package com.meamoria.lexurgy.sc

import com.meamoria.lexurgy.*
import com.meamoria.lexurgy.word.*
import com.meamoria.lexurgy.word.modify
import java.util.concurrent.ConcurrentHashMap

class Declarations private constructor(
    val features: List<Feature>,
    val diacritics: List<Diacritic>,
    val symbols: List<Symbol>,
    val syllabifier: Syllabifier? = null,
) {
    // Features
    private val featureNameToFeatureMap = features.associateBy { it.name }
    private val defaults = defaults(features)
    private val absents = absents(features)
    private val valueToFeature = valueToFeature(features)
    private val allFeatureValues = features.flatMap { it.allValues }
    private val valueNameToSimpleValue = allFeatureValues.associate {
        it.name to normalizeAbsent(it)
    }

    // Diacritics
    private val normalizedDiacritics = diacritics.map { it.normalize() }
    private val diacriticNameToDiacritic = normalizedDiacritics.associateBy { it.name }
    private val floatingDiacritics = normalizedDiacritics.filter { it.floating }

    private val normalizedSymbols = symbols.map { it.normalize() }
    private val symbolsAsComplexSymbols = normalizedSymbols.map { complexSymbol(it) }
    private val symbolNameToSymbol = normalizedSymbols.associateBy { it.name }
    private val matrixToSimpleSymbol = normalizedSymbols.associateByNotNull {
        it.declaredMatrix?.removeExplicitDefaults()
    }

    // Symbols
    private val matrixFullValueSetCache = ConcurrentHashMap<Matrix, Set<MatrixValue>>()
    private val matrixSimpleValueCache = ConcurrentHashMap<Matrix, Set<SimpleValue>>()
    private val matrixToSymbolCache = ConcurrentHashMap<Matrix, Segment>()
    private val phoneticSegmentToComplexSymbolCache = ConcurrentHashMap<Segment, ComplexSymbol>()
    private val phoneticSegmentMatchCache = ConcurrentHashMap<Pair<Segment, Segment>, Boolean>()
    private val undeclaredSymbolCache = ConcurrentHashMap<String, Symbol>()

    private val diacriticsByLevel = diacritics.groupBy { diacritic ->
            val values = diacritic.matrix.explicitSimpleValues
            val level = values.first().wordLevel(this)
            val firstConflictingValue = values.firstOrNull { it.wordLevel(this) != level }
            if (firstConflictingValue != null) {
                throw LscInvalidFeatureLevel(
                    firstConflictingValue.name,
                    "a ${level.text}-level diacritic",
                    firstConflictingValue.wordLevel(this),
                    listOf(level),
                )
            }
            level
        }

    private val phoneticParser = PhoneticParser(
        (symbols + normalizedSymbols).map { it.name },
        diacriticsByLevel[WordLevel.SEGMENT]?.map { it.toModifier() } ?: emptyList(),
        syllableSeparator = syllabifier?.let { "." },
        syllableModifiers = diacriticsByLevel[WordLevel.SYLLABLE]?.map {
            it.toModifier()
        } ?: emptyList()
    )

    private fun normalizeAbsent(value: SimpleValue): SimpleValue =
        if (value in absents) valueToFeature.getValue(value).default else value

    fun withSyllabifier(syllabifier: Syllabifier?): Declarations =
        copy(syllabifier = syllabifier)

    fun copy(
        features: List<Feature>? = null,
        diacritics: List<Diacritic>? = null,
        symbols: List<Symbol>? = null,
        syllabifier: Syllabifier? = null,
    ): Declarations = create(
        features ?: this.features,
        diacritics ?: this.diacritics,
        symbols ?: this.symbols,
        syllabifier ?: this.syllabifier,
    )

    fun parsePhonetic(text: String): Word =
        phoneticParser.parse(text).normalize(phoneticParser).fixDiacriticOrder()

    fun parsePhonetic(word: Word): Word = parsePhonetic(word.string)

    private fun Word.fixDiacriticOrder(): Word {
        val fixed = StandardWord(segments.map { it.toMatrix().toSymbol() })
        return if (isSyllabified()) {
            fixed.withSyllabification(
                syllableBreaks, syllableModifiers
            )
        } else {
            fixed
        }
    }

    fun syllabify(word: Word): Word =
        syllabifier?.syllabify(word) ?: word.toSimple()

    fun syllabify(phrase: Phrase): Phrase =
        Phrase(phrase.map(::syllabify))

    fun String.toFeature(): Feature =
        featureNameToFeatureMap[this] ?: throw LscUndefinedName("feature", this)

    fun String.toSimpleValue(): SimpleValue =
        valueNameToSimpleValue[this] ?: throw LscUndefinedName("feature value", this)

    fun String.toUndeclaredSymbol(): Symbol =
        undeclaredSymbolCache.getOrPut(this) { Symbol(this, null) }

    /**
     * Checks if this segment is the same as the specified pattern plus
     * any number of floating diacritics.
     */
    fun Segment.matches(pattern: Segment): Boolean {
        phoneticSegmentMatchCache[this to pattern]?.let { return it }

        if (floatingDiacritics.isEmpty()) return this == pattern
        val thisSymbol = this.toComplexSymbol()
        if (!thisSymbol.diacritics.any { it.floating }) return this == pattern
        val patternSymbol = pattern.toComplexSymbol()
        val symbolWithDiacritics = addDiacriticsToMatch(
            thisSymbol.toMatrix(),
            startingCandidates = listOf(patternSymbol),
            availableDiacritics = floatingDiacritics
        )
        return (symbolWithDiacritics == this.toComplexSymbol()).also {
            phoneticSegmentMatchCache[this to pattern] = it
        }
    }

    /**
     * Tries to match the specified matrix to this phonetic symbol.
     * Returns true if the matrix matched, false otherwise. Binds variables.
     */
    fun Segment.matches(matrix: Matrix, bindings: Bindings): Bindings? =
        toMatrix().matches(matrix, bindings)

    fun Segment.withFloatingDiacriticsFrom(
        other: Segment, excluding: Segment? = null
    ): Segment {
        if (floatingDiacritics.isEmpty()) return this
        val excludingDiacritics = excluding?.toComplexSymbol()?.diacritics ?: emptyList()
        val otherSymbol = other.toComplexSymbol()
        val otherFloating = otherSymbol.diacritics.filter {
            it.floating && it !in excludingDiacritics
        }
        if (otherFloating.isEmpty()) return this
        val thisSymbol = this.toComplexSymbol()
        var result = thisSymbol
        for (diacritic in otherFloating) {
            if (diacritic !in result.diacritics) result = result.withDiacritic(diacritic)
        }
        return result.toSegment()
    }

    fun Segment.withoutFloatingDiacritics(): Segment {
        val symbol = toComplexSymbol()
        val result = complexSymbol(symbol.symbol, symbol.diacritics.filter { !it.floating })
        return result.toSegment()
    }

    fun Segment.toComplexSymbol(): ComplexSymbol {
        phoneticSegmentToComplexSymbolCache[this]?.let { return it }

        val coreSymbol = symbolNameToSymbol[core] ?: Symbol(core, null)
        val diacritics = modifiers.map { diacriticNameToDiacritic.getValue(it.string) }
        return complexSymbol(coreSymbol, diacritics).also {
            phoneticSegmentToComplexSymbolCache[this] = it
        }
    }

    fun Segment.toMatrix(): Matrix = toComplexSymbol().toMatrix()

    fun Symbol.toSegment(): Segment = Segment(name)

    /**
     * Creates a ``ComplexSymbol`` with the specified core and diacritics. This
     * is a member of ``Declarations`` (and the ``ComplexSymbol`` constructor is
     * marked ``internal``) because it enforces declaration order on the diacritics.
     */
    fun complexSymbol(coreSymbol: Symbol?, diacritics: Iterable<Diacritic> = emptyList()): ComplexSymbol =
        ComplexSymbol(coreSymbol, normalizedDiacritics.filter { it in diacritics })

    fun ComplexSymbol.withDiacritic(diacritic: Diacritic): ComplexSymbol =
        complexSymbol(symbol, diacritics + diacritic)

    fun ComplexSymbol.toMatrix(): Matrix {
        var result = symbol?.matrix ?: Matrix.EMPTY
        for (diacritic in diacritics) result = result.update(diacritic.matrix)
        return result
    }

    fun ComplexSymbol.toSegment(): Segment = Segment(
        symbol?.name ?: "",
        diacritics.map { it.toModifier() }
    )

    /**
     * A matrix containing the default values of all features
     * at the specified level
     */
    fun defaultMatrix(wordLevel: WordLevel): Matrix =
        Matrix(features.filter { it.level == wordLevel }.map { it.default })

    /**
     * Returns all of this matrix's values as a list, including feature variables etc.
     * and implicit defaults
     */
    val Matrix.fullValueList: List<MatrixValue>
        get() {
            val explicitFeatures = valueList.mapNotNull { valueToFeature[it] }.toSet()
            val implicitDefaults = features.filter { it !in explicitFeatures }.map { it.default }
            return (valueList + implicitDefaults)
        }

    /**
     * Returns all of this matrix's values as a set, including feature variables etc.
     * and implicit defaults
     */
    val Matrix.fullValueSet: Set<MatrixValue>
        get() {
            matrixFullValueSetCache[this]?.let { return it }
            return fullValueList.toSet().also { matrixFullValueSetCache[this] = it }
        }

    /**
     * Returns this matrix's feature values as a set, including implicit
     * defaults
     */
    val Matrix.simpleValues: Set<SimpleValue>
        get() {
            matrixSimpleValueCache[this]?.let { return it }

            return fullValueList.filterIsInstanceTo(mutableSetOf<SimpleValue>()).also {
                matrixSimpleValueCache[this] = it
            }
        }

    fun Matrix.toSymbol(): Segment {
        matrixToSymbolCache[this]?.let { return it }

        val matrix = removeExplicitDefaults()

        val result = matrixToSimpleSymbol[matrix]?.toSegment()
            ?: findSymbolWithDiacriticsMatching(matrix)?.toSegment()
            ?: throw LscInvalidMatrix(matrix)

        return result.also { matrixToSymbolCache[this] = it }
    }

    fun Matrix.toModifiers(): List<Modifier> =
        toDiacritics().map { it.toModifier() }

    fun Matrix.toDiacritics(): List<Diacritic> {
        val matrix = removeExplicitDefaults()
        if (matrix.valueList.isEmpty()) return emptyList()
        val matchingSymbol = addDiacriticsToMatch(matrix, startingCandidates = listOf(ComplexSymbol()))
        return matchingSymbol?.diacritics ?: throw LscInvalidMatrix(matrix)
    }

    /**
     * Throws an UndefinedName error if this matrix references
     * non-existent feature values.
     */
    fun Matrix.checkUndefinedFeatures() {
        checkUndefinedFeatures(this, features)
    }

    /**
     * Throws a RepeatedFeatures error if this matrix contains
     * multiple values from the same feature.
     */
    fun Matrix.checkRepeatedFeatures() {
        checkRepeatedFeatures(this, features)
    }

    private fun findSymbolWithDiacriticsMatching(matrix: Matrix): ComplexSymbol? {
        val startingCandidates = if (matrix.hasUndeclaredSymbol()) {
            listOf(complexSymbol(matrix.undeclaredSymbol()))
        } else {
            symbolsAsComplexSymbols
        }
        return addDiacriticsToMatch(matrix, startingCandidates = startingCandidates)
    }

    private fun addDiacriticsToMatch(
        matrix: Matrix,
        startingCandidates: List<ComplexSymbol>,
        availableDiacritics: List<Diacritic> = normalizedDiacritics,
    ): ComplexSymbol? {
        return recursivelyAddDiacriticsToMatch(
            matrix,
            startingCandidates = startingCandidates,
            availableDiacritics = availableDiacritics,
        )
    }

    private fun recursivelyAddDiacriticsToMatch(
        matrix: Matrix,
        startingCandidates: List<ComplexSymbol>,
        availableDiacritics: List<Diacritic> = normalizedDiacritics,
        bestDistance: Int? = null,
    ): ComplexSymbol? {
        if (startingCandidates.isEmpty()) return null
        val sortedCandidates = startingCandidates.sortedBy { it.distanceTo(matrix) }
        sortedCandidates.first().takeIf { it.distanceTo(matrix) == 0 }?.let { return it }
        if (availableDiacritics.isEmpty()) return null

        for (candidate in sortedCandidates) {
            val candidateDistance = candidate.distanceTo(matrix)
            if (bestDistance != null && candidateDistance >= bestDistance) return null
            val withDiacritics = availableDiacritics.map { candidate.withDiacritic(it) }
            recursivelyAddDiacriticsToMatch(
                matrix,
                withDiacritics,
                availableDiacritics,
                candidateDistance,
            )?.let { return it }
        }
        return null
    }

    private fun ComplexSymbol.distanceTo(matrix: Matrix): Int {
        val symbolMatrix = toMatrix()
        val difference = (matrix.simpleValues.filterNot { it in symbolMatrix.simpleValues } +
                symbolMatrix.simpleValues.filterNot { it in matrix.simpleValues }
                )
        return difference.size
    }

    private fun Matrix.removeExplicitDefaults(): Matrix =
        removeExplicitDefaults(features)

    /**
     * Compute a matrix with all the feature values in this matrix,
     * and all the feature values in `updateMatrix`. Feature values in `updateMatrix`
     * override values for the same feature in this matrix.
     */
    fun Matrix.update(updateMatrix: Matrix): Matrix {
        val oldMatrixFeatures = simpleValues.associateBy { it.toFeature() }
        val newMatrixValues = valueList.toMutableList()
        for (value in updateMatrix.valueList) {
            val updateFeature = (value as SimpleValue).toFeature()
            oldMatrixFeatures[updateFeature]?.let { newMatrixValues.remove(it) }
            if (value !in defaults)
                newMatrixValues += value
        }
        return Matrix(newMatrixValues)
    }

    /**
     * If this matrix represents an undeclared symbol, convert to a Symbol.
     */
    fun Matrix.undeclaredSymbol(): Symbol =
        valueList.filterIsInstance<UndeclaredSymbolValue>().single().toUndeclaredSymbol()

    /**
     * Splits apart the explicit values of this matrix that operate at each
     * level.
     */
    fun Matrix.splitByLevel(): Map<WordLevel, Matrix> =
        valueList.groupBy {
            it.wordLevel(this@Declarations)
        }.mapValues { (_, v) -> Matrix(v) }

    /**
     * Tests whether this matrix matches (i.e. has at least the values in)
     * the specificed matrix, given the specified bindings.
     * Returns an updated set of bindings if the matrix matches; returns
     * null if the matrix doesn't match.
     */
    fun Matrix.matches(matrix: Matrix, bindings: Bindings): Bindings? {
        var result = bindings
        for (value in matrix.valueList) {
            value.matches(this, bindings)?.let { result = result.combine(it) } ?: return null
        }
        return result
    }

    fun UndeclaredSymbolValue.toUndeclaredSymbol(): Symbol = name.toUndeclaredSymbol()

    fun SimpleValue.toFeature(): Feature =
        valueToFeature[this] ?: throw LscUndefinedName("feature value", name)

    fun MatrixValue.matches(matrix: Matrix, bindings: Bindings): Bindings? =
        matches(this@Declarations, matrix, bindings)

    fun Modifier.toDiacritic(): Diacritic =
        diacriticNameToDiacritic[string] ?: throw LscUndefinedName("diacritic", string)

    fun List<Modifier>.toMatrix(): Matrix =
        ComplexSymbol(null, map { it.toDiacritic() }).toMatrix()

    val Word.syllableMatrix: Matrix
        get() {
            var matrix = Matrix.EMPTY
            for (modifiers in syllableModifiers.values) {
                matrix = matrix.update(modifiers.toMatrix())
            }
            return matrix
        }

    /**
     * Updates the syllable modifiers on this phrase by adding and removing
     * syllable-level features according to the specified matrices.
     */
    fun Phrase.updateSyllableModifiers(changes: Map<PhraseIndex, Matrix>): Phrase =
        updateSyllableModifiers(changes) { existing, new ->
            existing.toMatrix().update(new).toModifiers()
        }

    companion object {
        val empty: Declarations = Declarations(emptyList(), emptyList(), emptyList())

        fun create(
            features: List<Feature>,
            diacritics: List<Diacritic>,
            symbols: List<Symbol>,
            syllabifier: Syllabifier? = null,
        ): Declarations {
            checkDuplicateFeatures(features)
            checkDuplicateFeatureValues(features)

            checkUndefinedFeaturesInDiacritics(diacritics, features)
            checkRepeatedFeaturesInDiacritics(diacritics, features)
            val normalizedDiacritics = diacritics.map { it.normalize() }
            checkDuplicateDiacritics(normalizedDiacritics)
            checkDiacriticsWithSameMatrix(normalizedDiacritics)

            checkUndefinedFeaturesInSymbols(symbols, features)
            checkRepeatedFeaturesInSymbols(symbols, features)
            val normalizedSymbols = symbols.map { it.normalize() }
            checkDuplicateSymbols(normalizedSymbols)
            checkSymbolsWithSameMatrix(normalizedSymbols, features)
            checkNonSegmentFeatures(symbols, features)

            return Declarations(
                features, diacritics, symbols, syllabifier
            )
        }

        private fun checkDuplicateFeatures(features: List<Feature>) {
            features.checkDuplicates(
                { listOf(it.name) },
                { name, _, _ -> throw LscDuplicateName("feature", name) }
            )
        }

        private fun checkDuplicateFeatureValues(features: List<Feature>) {
            features.checkDuplicates(
                { it.allValues },
                { value, _, _ -> throw LscDuplicateName("feature value", value.name) },
            )
        }

        private fun checkUndefinedFeaturesInDiacritics(
            diacritics: List<Diacritic>, features: List<Feature>
        ) {
            for (diacritic in diacritics) {
                checkUndefinedFeatures(diacritic.matrix, features)
            }
        }

        private fun checkRepeatedFeaturesInDiacritics(
            diacritics: List<Diacritic>, features: List<Feature>
        ) {
            for (diacritic in diacritics) {
                checkRepeatedFeatures(diacritic.matrix, features)
            }
        }

        private fun checkDuplicateDiacritics(diacritics: List<Diacritic>) {
            diacritics.checkDuplicates(
                { listOf(it.name) },
                { name, _, _ -> throw LscDuplicateName("diacritic", name) }
            )
        }

        private fun checkDiacriticsWithSameMatrix(diacritics: List<Diacritic>) {
            diacritics.checkDuplicates(
                { listOf(it.matrix) },
                { matrix, new, existing -> throw LscDuplicateMatrices(matrix, "diacritics", new.name, existing.name) },
            )
        }

        private fun checkUndefinedFeaturesInSymbols(
            symbols: List<Symbol>, features: List<Feature>
        ) {
            for (symbol in symbols) {
                checkUndefinedFeatures(symbol.matrix, features)
            }
        }

        private fun checkRepeatedFeaturesInSymbols(
            symbols: List<Symbol>, features: List<Feature>
        ) {
            for (symbol in symbols) {
                checkRepeatedFeatures(symbol.matrix, features)
            }
        }

        private fun checkDuplicateSymbols(symbols: List<Symbol>) {
            symbols.checkDuplicates(
                { listOf(it.name) },
                { name, _, _ -> throw LscDuplicateName("symbol", name) },
            )
        }

        private fun checkSymbolsWithSameMatrix(symbols: List<Symbol>, features: List<Feature>) {
            symbols.checkDuplicates(
                { listOfNotNull(it.declaredMatrix?.removeExplicitDefaults(features)) },
                { matrix, new, existing -> throw LscDuplicateMatrices(matrix, "symbols", new.name, existing.name) },
            )
        }

        private fun Matrix.removeExplicitDefaults(
            features: List<Feature>
        ): Matrix {
            val defaults = defaults(features)
            val absents = absents(features)
            return Matrix(valueList.filterNot { it in defaults || it in absents })
        }

        private fun checkNonSegmentFeatures(symbols: List<Symbol>, features: List<Feature>) {
            val matrices = symbols.map { it.matrix }
            val valueToFeature = features.associateByAll { it.allValues }

            for (value in matrices.flatMap { it.explicitSimpleValues }) {
                val level = valueToFeature.getValue(value).level
                if (level != WordLevel.SEGMENT) {
                    throw LscInvalidFeatureLevel(
                        value.name,
                        "a symbol",
                        level,
                        listOf(WordLevel.SEGMENT),
                    )
                }
            }
        }

        private fun checkUndefinedFeatures(matrix: Matrix, features: List<Feature>) {
            val valueNames = features.flatMap { it.allValues }.map { it.name }.toSet()
            for (value in matrix.explicitSimpleValues) {
                if (value.name !in valueNames) {
                    throw LscUndefinedName("feature value", value.name)
                }
            }
        }

        private fun checkRepeatedFeatures(matrix: Matrix, features: List<Feature>) {
            val valueToFeature = valueToFeature(features)
            matrix.explicitSimpleValues.checkDuplicates(
                { listOf(valueToFeature.getValue(it)) },
                { feature, new, existing -> throw RepeatedFeature(matrix, feature.name, listOf(existing.name, new.name))}
            )
        }

        // Checks if any elements of this iterable are mapped to equal
        // values by the selector.
        private fun <T, K> Iterable<T>.checkDuplicates(
            selector: (T) -> List<K>,
            onDuplicate: (K, T, T) -> Nothing,
        ) {
            val seenMappings = mutableMapOf<K, T>()
            for (element in this) {
                for (key in selector(element)) {
                    if (key in seenMappings) {
                        onDuplicate(key, element, seenMappings.getValue(key))
                    }
                    seenMappings[key] = element
                }
            }
        }

        private fun defaults(features: List<Feature>): List<SimpleValue> =
            features.map { it.default }

        private fun absents(features: List<Feature>): List<SimpleValue> =
            features.map { it.absent }

        private fun valueToFeature(features: List<Feature>): Map<SimpleValue, Feature> =
            features.associateByAll { it.allValues }
    }
}

class Feature(
    val name: String,
    val values: List<SimpleValue>,
    explicitDefault: SimpleValue? = null,
    val level: WordLevel = WordLevel.SEGMENT,
) {
    val absent: SimpleValue = SimpleValue.absent(name)
    val default: SimpleValue = explicitDefault ?: absent
    val allValues: List<SimpleValue> = listOf(absent) + listOfNotNull(explicitDefault) + values

    override fun toString(): String = values.joinToString(prefix = "$name(", postfix = ")")

    companion object {
        fun plusOnly(name: String, level: WordLevel = WordLevel.SEGMENT): Feature =
            Feature(
                name,
                listOf(SimpleValue("+$name")),
                explicitDefault = SimpleValue("-$name"),
                level = level,
            )

        fun plusMinus(name: String, level: WordLevel = WordLevel.SEGMENT): Feature =
            Feature(
                name,
                listOf(SimpleValue("+$name"), SimpleValue("-$name")),
                level = level,
            )
    }
}

data class Symbol(val name: String, val declaredMatrix: Matrix?) {
    override fun toString(): String = name + if (declaredMatrix == null) "" else " $declaredMatrix"

    fun normalize() = Symbol(name.normalizeDecompose(), declaredMatrix)

    val matrix: Matrix
        get() = declaredMatrix ?: Matrix(listOf(UndeclaredSymbolValue(name)))
}

/**
 * A symbol with diacritics.
 *
 * The constructor is marked ``internal`` because validation depends on the declarations.
 * Use the ``complexSymbol`` function in ``Declarations`` to create instances.
 */
data class ComplexSymbol internal constructor(
    val symbol: Symbol? = null,
    val diacritics: List<Diacritic> = emptyList(),
) {

    // Most ComplexSymbol instances never have toString called (they're intermediate results).
    // Most of the rest have it called only once, when the ComplexSymbol needs to be converted
    // into something else, usually a PhoneticSegment.
    // So compute only as needed.
    val string
        get() = (symbol?.name ?: "").modify(diacritics.map { it.toModifier() })

    override fun toString(): String = string
}

data class Diacritic(
    val name: String,
    val matrix: Matrix,
    val position: ModifierPosition,
    val floating: Boolean
) {
    fun normalize() = Diacritic(name.normalizeDecompose(), matrix, position, floating)

    fun toModifier(): Modifier =
        Modifier(name, position)
}

class LscUndefinedName(val nameType: String, val undefinedName: String, val usedBeforeDefined: Boolean = false) :
    LscUserError(
        "The $nameType \"$undefinedName\" is " +
                if (usedBeforeDefined) "used before it's defined" else "not defined"
    )

class LscDuplicateName(val nameType: String, val duplicateName: String) :
    LscUserError("The $nameType \"$duplicateName\" is defined more than once")

class LscInvalidFeatureLevel(
    val valueName: String,
    val context: String,
    val invalidLevel: WordLevel,
    val allowedLevels: List<WordLevel>,
) : LscUserError(
    "The ${invalidLevel.text}-level value $valueName can't be used in $context; " +
            "values must be at the level of ${allowedLevels.joinToString(" or ") { it.text }}"
)

class LscDuplicateMatrices(
    matrix: Matrix, declarationType: String, newDeclaration: String, existingDeclaration: String
) : LscUserError(
    "The $declarationType $existingDeclaration and $newDeclaration both have " +
            "the matrix $matrix; add features to make them distinct."
)

class RepeatedFeature(
    val matrix: Matrix,
    val feature: String,
    val values: List<String>,
) : LscUserError(
    "The matrix $matrix has multiple values of the feature " +
            "\"$feature\" (${values.joinToString { "\"$it\"" }}); remove all but one."
)
