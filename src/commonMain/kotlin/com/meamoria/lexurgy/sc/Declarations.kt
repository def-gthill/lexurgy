package com.meamoria.lexurgy.sc

import com.meamoria.lexurgy.*
import com.meamoria.lexurgy.word.*
import com.meamoria.lexurgy.word.modify

class Declarations(
    val features: List<Feature>,
    val diacritics: List<Diacritic>,
    val symbols: List<Symbol>,
    val syllabifier: Syllabifier? = null,
) {
    private val featureNameToFeatureMap = features.associateByCheckingDuplicates(
        { listOf(it.name) },
        { name, _, _ -> throw LscDuplicateName("feature", name) }
    )
    private val defaults = features.map { it.default }
    private val absents = features.map { it.absent }
    private val valueToFeature = features.associateByCheckingDuplicates(
        { it.allValues },
        { value, _, _ -> throw LscDuplicateName("feature value", value.name) },
    )
    private val valueNameToSimpleValue = features.flatMap { it.allValues }.associate {
        it.name to (if (it in absents) valueToFeature.getValue(it).default else it)
    }

    init {
        checkUndefinedFeatures(diacritics.map { it.matrix })
    }
    private val normalizedDiacritics = diacritics.map { it.normalize() }
    private val diacriticNameToDiacritic = normalizedDiacritics.associateByCheckingDuplicates(
        { listOf(it.name) },
        { name, _, _ -> throw LscDuplicateName("diacritic", name) }
    )
    private val floatingDiacritics = normalizedDiacritics.filter { it.floating }
    init {
        normalizedDiacritics.associateByCheckingDuplicates(
            { listOf(it.matrix) },
            { matrix, new, existing -> throw LscDuplicateMatrices(matrix, "diacritics", new.name, existing.name) },
        )
    }

    init {
        checkUndefinedFeatures(symbols.map { it.matrix })
    }
    private val normalizedSymbols = symbols.map { it.normalize() }
    private val symbolsAsComplexSymbols = normalizedSymbols.map { complexSymbol(it) }
    private val symbolNameToSymbol = normalizedSymbols.associateByCheckingDuplicates(
        { listOf(it.name) },
        { name, _, _ -> throw LscDuplicateName("symbol", name) },
    )
    private val matrixToSimpleSymbol = normalizedSymbols.associateByCheckingDuplicates(
        { listOfNotNull(it.declaredMatrix?.removeExplicitDefaults()) },
        { matrix, new, existing -> throw LscDuplicateMatrices(matrix, "symbols", new.name, existing.name) },
    )

    private val matrixFullValueSetCache = Cache<Matrix, Set<MatrixValue>>()
    private val matrixSimpleValueCache = Cache<Matrix, Set<SimpleValue>>()
    private val matrixToSymbolCache = Cache<Matrix, Segment>()
    private val phoneticSegmentToComplexSymbolCache = Cache<Segment, ComplexSymbol>()
    private val phoneticSegmentMatchCache = Cache<Pair<Segment, Segment>, Boolean>()
    private val undeclaredSymbolCache = Cache<String, Symbol>()

    private fun checkUndefinedFeatures(matrices: List<Matrix>) {
        for (value in matrices.flatMap { it.explicitSimpleValues }) {
            value.name.toSimpleValue()
        }
    }

    private fun checkNonSegmentFeatures(matrices: List<Matrix>) {
        for (value in matrices.flatMap { it.explicitSimpleValues }) {
            if (value.wordLevel(this) != WordLevel.SEGMENT) {
                throw LscInvalidFeatureLevel(
                    value.name,
                    "a symbol",
                    value.wordLevel(this),
                    listOf(WordLevel.SEGMENT),
                )
            }
        }
    }

    private fun <T, K> Iterable<T>.associateByCheckingDuplicates(
        keySelector: (T) -> List<K>,
        onDuplicate: (K, T, T) -> Nothing,
    ): Map<K, T> {
        val result = mutableMapOf<K, T>()
        for (element in this) {
            for (key in keySelector(element)) {
                if (key in result) {
                    onDuplicate(key, element, result.getValue(key))
                }
                result[key] = element
            }
        }
        return result
    }

    init {
        checkNonSegmentFeatures(symbols.map { it.matrix })
    }

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

    fun withSyllabifier(syllabifier: Syllabifier?): Declarations =
        copy(syllabifier = syllabifier)

    fun copy(
        features: List<Feature>? = null,
        diacritics: List<Diacritic>? = null,
        symbols: List<Symbol>? = null,
        syllabifier: Syllabifier? = null,
    ): Declarations = Declarations(
        features ?: this.features,
        diacritics ?: this.diacritics,
        symbols ?: this.symbols,
        syllabifier ?: this.syllabifier,
    )

    fun parsePhonetic(text: String, syllabify: Boolean = true): Word =
        phoneticParser.parse(text, syllabify).normalize(phoneticParser)

    fun parsePhonetic(word: Word): Word = parsePhonetic(word.string)

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

    private fun MatrixValue.isDefault(): Boolean = this in defaults

    private fun MatrixValue.isAbsent(): Boolean = this in absents

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

    val Symbol.matrix: Matrix
        get() = declaredMatrix ?: Matrix(listOf(UndeclaredSymbolValue(name)))

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
        Matrix(valueList.filterNot { it.isDefault() || it.isAbsent() })

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
            if (!value.isDefault())
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

    companion object {
        val empty: Declarations = Declarations(emptyList(), emptyList(), emptyList())
    }
}

expect class Cache<K, V>() : MutableMap<K, V>

data class SegmentClass(val name: String, val sounds: List<String>)

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
}

data class Symbol(val name: String, val declaredMatrix: Matrix?) {
    override fun toString(): String = name + if (declaredMatrix == null) "" else " $declaredMatrix"

    fun normalize() = Symbol(name.normalizeDecompose(), declaredMatrix)
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
