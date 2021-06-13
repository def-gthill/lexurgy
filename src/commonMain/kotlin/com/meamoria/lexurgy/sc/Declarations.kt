package com.meamoria.lexurgy.sc

import com.meamoria.lexurgy.*

class Declarations(
    val features: List<Feature>,
    val diacritics: List<Diacritic>,
    val symbols: List<Symbol>,
    val classes: List<SegmentClass>,
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
            { listOf(it.matrix.removeExplicitDefaults()) },
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

    private val classNameToClass = classes.associateBy { it.name }

    private fun checkUndefinedFeatures(matrices: List<Matrix>) {
        for (value in matrices.flatMap { it.valueList }) {
            (value as? SimpleValue)?.name?.toSimpleValue()
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

    private val phoneticParser = PhoneticParser(
        symbols.map { it.name },
        diacritics.filter { it.before }.map { it.name },
        diacritics.filterNot { it.before }.map { it.name },
        syllableSeparator = ".",
    )

    private val normalizedPhoneticParser = PhoneticParser(
        normalizedSymbols.map { it.name },
        normalizedDiacritics.filter { it.before }.map { it.name },
        normalizedDiacritics.filterNot { it.before }.map { it.name },
        syllableSeparator = ".",
    )

    fun withSyllabifier(syllabifier: Syllabifier?): Declarations =
        copy(syllabifier = syllabifier)

    fun copy(
        features: List<Feature>? = null,
        diacritics: List<Diacritic>? = null,
        symbols: List<Symbol>? = null,
        classes: List<SegmentClass>? = null,
        syllabifier: Syllabifier? = null,
    ): Declarations = Declarations(
        features ?: this.features,
        diacritics ?: this.diacritics,
        symbols ?: this.symbols,
        classes ?: this.classes,
        syllabifier ?: this.syllabifier,
    )

    fun parsePhonetic(text: String): Word =
        phoneticParser.parse(text).normalize()

    fun parsePhonetic(word: Word): Word = parsePhonetic(word.string)

    fun syllabify(word: Word): Word =
        syllabifier?.syllabify(word) ?: word

    fun String.toFeature(): Feature =
        featureNameToFeatureMap[this] ?: throw LscUndefinedName("feature", this)

    fun String.toSimpleValue(): SimpleValue =
        valueNameToSimpleValue[this] ?: throw LscUndefinedName("feature value", this)

    fun String.toClass(): SegmentClass =
        classNameToClass[this] ?: throw LscUndefinedName("sound class", this)

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
        return (searchDiacritics(
            thisSymbol.toMatrix(),
            listOf(patternSymbol),
            availableDiacritics = floatingDiacritics
        ) == this.toComplexSymbol()).also { phoneticSegmentMatchCache[this to pattern] = it }
    }

    /**
     * Tries to match the specified matrix to this phonetic symbol.
     * Returns true if the matrix matched, false otherwise. Binds variables.
     */
    fun Segment.matches(matrix: Matrix, bindings: Bindings): Boolean {
        val complexSymbolMatrix = (toMatrix())
        for (value in matrix.valueList) {
            if (!value.matches(complexSymbolMatrix, bindings)) return false
        }
        return true
    }

    private fun MatrixValue.isDefault(): Boolean = this in defaults

    private fun MatrixValue.isAbsent(): Boolean = this in absents

    fun Segment.withFloatingDiacriticsFrom(
        other: Segment, excluding: Segment? = null
    ): Segment {
        if (floatingDiacritics.isEmpty()) return this
        val excludingDiacritics = excluding?.toComplexSymbol()?.diacritics ?: listOf()
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
        return result.toPhoneticSegment()
    }

    fun Segment.toComplexSymbol(): ComplexSymbol {
        phoneticSegmentToComplexSymbolCache[this]?.let { return it }

        val (core, before, after) = normalizedPhoneticParser.breakDiacritics(string)
        val coreSymbol = symbolNameToSymbol[core] ?: Symbol(core, null)
        val diacritics = (before + after).map { diacriticNameToDiacritic.getValue(it) }
        return complexSymbol(coreSymbol, diacritics).also {
            phoneticSegmentToComplexSymbolCache[this] = it
        }
    }

    fun Segment.toMatrix(): Matrix = toComplexSymbol().toMatrix()

    fun Symbol.toPhoneticSegment(): Segment = Segment(name)

    val Symbol.matrix: Matrix
        get() = declaredMatrix ?: Matrix(listOf(UndeclaredSymbolValue(name)))

    /**
     * Creates a ``ComplexSymbol`` with the specified core and diacritics. This
     * is a member of ``Declarations`` (and the ``ComplexSymbol`` constructor is
     * marked ``internal``) because it enforces declaration order on the diacritics.
     */
    fun complexSymbol(coreSymbol: Symbol, diacritics: Iterable<Diacritic> = emptyList()): ComplexSymbol =
        ComplexSymbol(coreSymbol, normalizedDiacritics.filter { it in diacritics })

    fun ComplexSymbol.withDiacritic(diacritic: Diacritic): ComplexSymbol =
        complexSymbol(symbol, diacritics + diacritic)

    fun ComplexSymbol.toMatrix(): Matrix {
        var result = symbol.matrix
        for (diacritic in diacritics) result = result.update(diacritic.matrix)
        return result
    }

    fun ComplexSymbol.toPhoneticSegment(): Segment = Segment(string)

    val Matrix.fullValueList: List<MatrixValue>
        get() {
            val explicitFeatures = valueList.mapNotNull { valueToFeature[it] }.toSet()
            val implicitDefaults = features.filter { it !in explicitFeatures }.map { it.default }
            return (valueList + implicitDefaults)
        }

    val Matrix.fullValueSet: Set<MatrixValue>
        get() {
            matrixFullValueSetCache[this]?.let { return it }
            return fullValueList.toSet().also { matrixFullValueSetCache[this] = it }
        }

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

        val result = matrixToSimpleSymbol[matrix]?.toPhoneticSegment()
            ?: searchDiacritics(matrix)?.toPhoneticSegment()
            ?: throw LscInvalidMatrix(matrix)

        return result.also { matrixToSymbolCache[this] = it }
    }

    private fun Matrix.removeExplicitDefaults(): Matrix = Matrix(valueList.filterNot { it.isDefault() || it.isAbsent() })

    private fun searchDiacritics(
        matrix: Matrix,
        candidates: List<ComplexSymbol> = emptyList(),
        bestDistance: Int? = null,
        availableDiacritics: List<Diacritic> = normalizedDiacritics
    ): ComplexSymbol? {
        if (availableDiacritics.isEmpty()) return null
        if (matrix.hasUndeclaredSymbol() && candidates.isEmpty()) {
            return searchDiacritics(
                matrix,
                listOf(complexSymbol(matrix.undeclaredSymbol())),
                bestDistance,
                availableDiacritics)
        }
        val sortedCandidates = candidates.ifEmpty { symbolsAsComplexSymbols }.sortedBy { it.distanceTo(matrix) }
        sortedCandidates.first().takeIf { it.distanceTo(matrix) == 0 }?.let { return it }

        for (candidate in sortedCandidates) {
            val candidateDistance = candidate.distanceTo(matrix)
            if (bestDistance != null && candidateDistance >= bestDistance) return null
            val withDiacritics = availableDiacritics.map { candidate.withDiacritic(it) }
            searchDiacritics(matrix, withDiacritics, candidateDistance, availableDiacritics)?.let { return it }
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

    fun UndeclaredSymbolValue.toUndeclaredSymbol(): Symbol = name.toUndeclaredSymbol()

    private fun SimpleValue.toFeature(): Feature =
        valueToFeature[this] ?: throw LscUndefinedName("feature value", name)

    fun MatrixValue.matches(matrix: Matrix, bindings: Bindings): Boolean =
        matches(this@Declarations, matrix, bindings)

    companion object {
        val empty: Declarations = Declarations(emptyList(), emptyList(), emptyList(), emptyList())
    }
}

expect class Cache<K, V>() : MutableMap<K, V>

data class SegmentClass(val name: String, val sounds: List<String>)

class Feature(val name: String, val values: List<SimpleValue>, explicitDefault: SimpleValue? = null) {
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
data class ComplexSymbol internal constructor(val symbol: Symbol, val diacritics: List<Diacritic>) {

    // Most ComplexSymbol instances never have toString called (they're intermediate results).
    // Most of the rest have it called only once, when the ComplexSymbol needs to be converted
    // into something else, usually a PhoneticSegment.
    // So compute only as needed.
    val string
        get() = (diacritics.filter { it.before }.map { it.name } +
                listOf(symbol.name) +
                diacritics.filterNot { it.before }.map { it.name }
                ).joinToString("")

    override fun toString(): String = string
}

data class Diacritic(val name: String, val matrix: Matrix, val before: Boolean, val floating: Boolean) {
    fun normalize() = Diacritic(name.normalizeDecompose(), matrix, before, floating)
}

class LscUndefinedName(val nameType: String, val undefinedName: String) :
    LscUserError("The $nameType \"$undefinedName\" is not defined")

class LscDuplicateName(val nameType: String, val duplicateName: String) :
    LscUserError("The $nameType \"$duplicateName\" is defined more than once")

class LscDuplicateMatrices(
    matrix: Matrix, declarationType: String, newDeclaration: String, existingDeclaration: String
) : LscUserError(
    "The $declarationType $existingDeclaration and $newDeclaration both have " +
            "the matrix $matrix; add features to make them distinct."
)
