The Lexurgy SC Rules Language Specification
=============================================

This is the full technical specification of the Lexurgy SC
rules language. For a gentler introduction, see :doc:`sc-tutorial`.

Overall Structure
------------------

Lexurgy sound changes consist of any number of *declarations*
followed by any number of *rules*.

Declarations define
concepts that can be used in the rest of the file:
:ref:`classes <sc-class-decl>`, :ref:`features <sc-feature-decl>`,
:ref:`symbols <sc-symbol-decl>`, and :ref:`diacritics <sc-diacritic-decl>`.

:ref:`Rules <sc-rules>` define how
*input words* change into *output words*. Each word
in the input lexicon is passed through all rules in
the order they're declared, transforming it one step
at a time into an output word.

Rules whose names start with "Romanizer-" or "romanizer-"
are called :ref:`intermediate romanizers <sc-inter-roman>`.
Intermediate romanizers break the linear sequence of rules;
their output may be sent to a file or text box, but subsequent
rules don't see their changes.

Syntactic Elements
-------------------

At the lowest level, Lexurgy sound changes are made up of the
following elements:

- *Literal text* is text that Lexurgy interprets literally as
  phonetic characters. It can contain any non-whitespace characters,
  but the characters ``\ , = > ( ) [ ] { } * + ? / - _ : ! $ @ # &``
  and the digits 0-9 have to be escaped with a preceding backslash.
  Literal text is used to define :ref:`symbols <sc-symbol-decl>` and
  :ref:`diacritics <sc-diacritic-decl>`, as elements of
  :ref:`classes <sc-class-decl>`, and as
- A *name* is

Declarations
------------

.. _sc-class-decl:

Class Declarations
~~~~~~~~~~~~~~~~~~

.. _sc-feature-decl:

Feature Declarations
~~~~~~~~~~~~~~~~~~~~~

.. _sc-symbol-decl:

Symbol Declarations
~~~~~~~~~~~~~~~~~~~~

.. _sc-diacritic-decl:

Diacritic Declarations
~~~~~~~~~~~~~~~~~~~~~~~

.. _sc-floating-diacritics:

.. note::
    Diacritics are added to a symbol in the order they're declared
    in the file. For example, suppose you declare::

        Diacritic ː [long]
        Diacritic ́  [hightone]

    Then a vowel that's both long and high-tone will have the high tone diacritic
    applied on top of the long symbol, which looks like ``aː́``. Probably not
    what you want! Switch the order of the diacritic declarations::

        Diacritic ́  [hightone]
        Diacritic ː [long]

    Now the long high-tone vowel will look the way it should: ``áː``.

.. _sc-rules:

Rules
------

A rule consists of a line giving the *rule name* followed by a colon,
and then one or more *expressions*, which may be grouped into *subrules*.

Rule names have to follow the same
restrictions as feature, value, and class names except that they
can also contain hyphens.

If a rule has multiple expressions, each expression is
executed *simultaneously*. This means that later expressions don't
see changes made by earlier expressions. If two expressions try
to change overlapping parts of the word, the first expression declared
takes precedence.

Subrules
~~~~~~~~~

A rule's expressions can be grouped into *subrules* by separating the subrules
with ``Then:``, either on its own line or sharing a line with the first
expression of the next subrule.

The expressons *within* a subrule (between ``Then:`` keywords) are
executed simultaneously.

Expressions
~~~~~~~~~~~~

An expression

.. _sc-inter-roman:

Intermediate Romanizers
~~~~~~~~~~~~~~~~~~~~~~~~

Rule Elements
~~~~~~~~~~~~~~

The match, result, and environment portions of rule expressions
are all made of *rule elements*. Rule elements can be broadly
divided into *container elements*, which have other rule elements
inside them, and *simple elements*, which don't.

Rule elements in the match and environment portions of a rule are
called *matchers* (since they match characters in words),
while those in the result portion are called *emitters* (since they
emit new or changed characters to put back into the word). All
elements can be used as matchers, but only some can be used as emitters.

Lexurgy keeps track of which sounds undergo which changes by lining
up the match and result sides of an expression into *transformations*.
A transformation consists of a matcher and an emitter. The matcher
finds a part of the word that needs to be changed, and the corresponding
emitter produces the new characters that should go there instead.

Empty Elements
***************

An empty element is written ``*``. It represents "no characters".

As a matcher, an empty element matches
*between* every pair of consecutive characters in a word, as well as the
start and end of the word. For example, if
given the word "bar", an empty matcher will find four matches: before the
[b], between the [b] and the [a], between the [a] and the [r], and after
the [r]. Any transformation from an empty matcher will *insert* characters
into the word.

As an emitter, an empty element produces no characters. Any
transformation to an empty emitter will *delete* whatever
characters were matched by the matcher.

Boundary Elements
******************

A boundary element is written ``$``. It represents the edge of
a word. Boundary elements can only be used in the environment
portion of a rule. They must also be on the *edge* of the
environment: a word boundary *before* the underscore must be
at the beginning of all containing :ref:``sequences <sc-sequence-elements>``,
and a word boundary *after* the underscore must be at the
end of all containing sequences.

As a matcher, a boundary element matches immediately *before*
the first character in a word, or immediately *after* the
last character in a word. If the input consists of multiple
words separated by spaces, the boundary element matches
the start and end of each word.

Between-Words Element
**********************

A between-words element is written ``$$``. It represents the
space between words.

As a matcher, a between-words element matches the space
between the words of a multiple-word input. Any transformation
from a between-words matcher will join adjacent words together.

Between-words elements can't currently be used as emitters.

Literal Element
****************

A literal element represents phonetic characters exactly
as they appear in words. Any element containing no special
characters is taken as a literal element. Examples of
literal elements are ``p``, ``ɛ``, ``kʷ``, and ``foo``.
A literal element can be marked *exact* by adding an exclamation
mark after it: ``p!``, ``kʷ!``, etc.

As a matcher, a literal element looks for its exact sequence
of segments in the word.
Any transformation from a literal
element will modify or replace those segments.

A literal matcher will also match that sequence augmented
with any number of :ref:`floating diacritics <sc-floating-diacritics>`,
unless the literal element is marked *exact*. So if ``x`` and ``y``
are both declared as floating diacritics, the literal matcher
``e`` will match ``e``, ``ex``, ``ey``, and ``exy``;
``ex`` will only match ``ex`` and ``exy``;
``exy`` will only match ``exy``; and ``e!`` will only match ``e``.

As an emitter, a literal element produces its exact sequence
of segments and inserts them into the word, replacing whatever
characters were matched by the matcher.

In a transformation between a literal matcher and a literal
emitter, any
are maintained. For example, in the transformation
``ɛ => e``, the segment ``ɛx`` will be transformed into ``ex``
if ``x`` is declared as a floating diacritic.

Class Reference Elements
*************************

A class reference element refers to a declared :ref:`class <sc-class-decl>`.
It's written as an at sign ``@`` followed by the name of the class.

Class reference elements are automatically replaced with
:ref:`alternative lists <sc-alternative-list-elements>` internally,
so they behave exactly like alternative lists.

Capture Reference Elements
***************************

A capture reference element refers to a :ref:`capture element <sc-captures>`
by number. It's written as a dollar sign ``$`` followed by the number
of the capture element being referenced. ``$1``, ``$3``, and ``$97`` are
examples of valid capture reference elements.

As a matcher, a capture reference element matches an exact copy
of whatever was matched by the corresponding capture element.

As an emitter, a capture reference element *produces* an exact
copy of whatever was matched by the corresponding capture element.

Matrix Elements
****************

A matrix element represents a combination of
:ref:`feature values <sc-feature-decl>`. Matrix elements
can contain the following kinds of values:

- Values of binary and univalent features, written with ``+`` or ``-``
  followed by the feature name.
- Values of multivalent features, written as the name of the feature value.
- The absent value of any feature, written with ``*`` followed by the feature
  name.
- The negation of any multivalent feature value, written with ``!``
  followed by the name of the feature value.
- A feature variable, written as ``$`` followed by the feature name.

As a matcher, a matrix element matches any single segment that
has all of the feature values in the element.

As an emitter, a matrix element adds its feature values to
all of the segments matched by the corresponding matcher, replacing
any other values of the same features. In the special case of
a transformation from an empty matcher to a matrix emitter,
the result will be the exact features in the matrix emitter.
The resulting matrix is then converted back to a symbol using the
:ref:`symbol <sc-symbol-decl>` and :ref:`diacritic <sc-diacritic-decl>`
declarations. If a symbol is defined with exactly the resulting matrix,
that symbol is used; otherwise, Lexurgy will try to add diacritics
to create a symbol with that matrix. If it fails to find any
combination of a symbol with diacritics, it generates an error.

It's an error to use a negated feature in a matrix emitter.

The first time a matrix with a feature variable matches something,
it stores the value that the feature variable has in the matched
segment. Subsequent uses of the feature variable are treated as
the stored value. If a matrix *emitter* tries to produce a segment
when any of its feature variables haven't stored a value, an
error is generated.

Negated Elements
*****************

A negated element is a container element that matches any
single segment that its sub-element *doesn't* match.
The sub-element can be a literal element, a class
reference element, or a capture element.

A negated element can't be used as an emitter.

.. _sc-sequence-elements:

Sequence Elements
******************

A sequence element is a container element that can contain
any number of sub-elements of any type.

As a matcher, a sequence element matches each of its
sub-elements in turn against the word. For the match
to succeed, all of its sub-elements must match contiguous
parts of the word, in the exact order specified by the sequence.

As an emitter, a sequence element gathers the results
from each of its sub-elements and concatenates them together.



.. _sc-alternative-list-elements:

Alternative List Elements
**************************

.. _sc-captures:

Capture Elements
*****************

Repeater Elements
******************

.. note::

    Lexurgy won't let you put optional and repeated segments on the edge of an
    environment. To see why, notice that these two rules would be exactly the same::

        stress-before-one-or-more-consonants:
            [vowel] => [stressed] / _ [cons]+
        stress-before-a-consonant:
            [vowel] => [stressed] / _ [cons]

    The second rule would match vowels before multiple consonants too, because
    rules never care about what's beyond their environment.

    Similarly, an optional (?) or optional repeater (*) on the edge of an
    environment would match anything, so it would just be noise.

.. caution::
    .. TODO This isn't true anymore! Rewrite to point out exactly what stops a repeater from advancing.

    Optional and repeated segments are *greedy*; they match as much as they
    can in the input word, even if doing so makes the rule fail. For
    example, suppose we have this file::

        Class glide {w, j}
        Class consonant {p, t, k, f, s, m, n, l, @glide}
        Class vowel {a, e, i, o, u, ø, y}

        umlaut:
            {a, e, o, u} => {e, i, ø, y} / _ @consonant* j

    This rule is intended to apply umlaut to a vowel in the syllable before
    a [j] onglide; the ``@consonant*`` is supposed to mean that the
    rule still applies even if there are consonants in between.
    Unfortunately, the rule does nothing at all, no matter what word you give it.

    This happens because [j] is also included in the ``consonant`` class. Suppose
    you feed the word ``altja`` to this rule, intending it to become ``eltja``.
    Lexurgy sees ``@consonant*`` and goes looking for consonants. It finds
    ``l``, then ``t``... but it keeps looking, finding ``j`` as well, since
    ``j`` is also a consonant. Then it runs out of consonants, tries
    to find the literal ``j`` from the rule, and fails, because it already
    consumed the ``j``.

    The way to work around this is to narrow
    the repeated element so that it doesn't overlap with the next element::

        umlaut:
            {a, e, o, u} => {e, i, ø, y} / _ {p, t, k, f, s, m, n, l, w}* j

    Now, the repeated element can't possibly consume the ``j``.

    For the part of the environment before the underscore, Lexurgy searches from
    *right to left*, so the logic above is reversed. Lexurgy does this because
    it results in more intuitive behaviour most of the time --- after all, sound changes
    are most likely to be conditioned on the nearest sounds.

Capture Elements
*****************

Intersection Elements
**********************
