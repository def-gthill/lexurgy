The Lexurgy SC Rules Language
=============================

This is the full technical specification of the Lexurgy SC
rules language. For a gentler introduction, see :doc:`sc-tutorial`.

Overall Structure
------------------

Lexurgy sound changes consist of any number of *declarations*
followed by any number of *rules*.

Declarations define
concepts that can be used in the rest of the file:
:ref:`classes <sc-class-decl>`, .

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

A rule's expressions can be grouped into subrules by separating the subrules
with ``Then:``, either on its own line or sharing a line with the first
expression of the next group.

The expressons *within* a subrule (between

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



capture | repeater | group | list | intersection | sequence
negated | classRef | captureRef | fancyMatrix | boundary | betweenWords | text

.. note::

    Word boundaries have to be on the edge of the environment (either the beginning or
    the end), otherwise they could never match anything. For example, this is invalid::

        bad:
            a => o / o $ _

    Lexurgy will give you an error message if you write a rule like this.

    However, word boundaries in alternative lists are fine, as long as the word boundary
    is at the edge of that alternative::

        okay:
            a => o / {o, $} _






.. note::
    Any characters in an input word that don't match symbols are considered to
    lack all features, so they'll only match matrices consisting entirely
    of absent features, like ``[*Voicing *Nasality]``, or the empty matrix ``[]``.

.. caution::
    It's possible for a rule to create a matrix that has no matching symbol;
    for example, if all nasals in your language are voiced, the rule
    ``[nasal] => [unvoiced]`` will create matrices like ``[unvoiced alveolar nasal]``
    that you haven't defined a symbol for. In such cases, Lexurgy will stop
    and report an error, telling you what matrix it couldn't interpret and
    which rule produced the ill-formed matrix. Fix the problem either by
    defining a symbol to go with the matrix (or a :ref:`diacritic <sc-diacritics>`),
    or by rewriting the rule so it produces valid sounds.

    .. TODO Is this true?
        Rules that delete all features from a sound are always invalid, and will lead to errors.

Each symbol must have a distinct matrix --- you can't define both [p] and [b] as just ``[labial stop]``.


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
    .. TODO This isn't true anymore! Rewrite to point out exactly what
            stops a repeater from advancing.

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



