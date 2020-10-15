
Lexurgy SC
===========

.. only:: not public

    Run SC using the command line::

        lexurgy sc changes words

    The ``changes`` file needs to use the Lexurgy SC format; by convention these have a
    .lsc extension.

    The ``words`` argument should be a text file with each old-language word on a separate line.
    By convention, this file should have a .wli extension.

    The Lexurgy SC file format
    ---------------------------

Basics
~~~~~~

In general, a rule looks like this::

    <rule-name>:
        <old-sounds> => <new-sounds> / <environment>

For example, to change [k] to [ʃ] before [a] (as happened in French), use this rule::

    k-before-a:
        k => ʃ / _ a

The underscore in the environment takes the place of the sounds that are changing.
So ``_ a`` means "before [a]", ``a _`` means "after [a]", and ``a _ a`` means "between two a's".

Any of these positions can contain multiple characters::

    palatalization:
        k => tʃ / _ i
    spanish-ch:
        lt => tʃ

Rule names must use only lowercase letters and hyphens.

Any line that starts with # is a comment, and Lexurgy will ignore it::

    # These rules palatalize k to s in three steps.
    palatalization-1:
        k => tʃ / _ i
    palatalization-2:
        # This is unconditional!
        tʃ => ʃ
    palatalization-3:
        ʃ => s

Alternative lists
*****************

Often, several sounds are affected by a change, or trigger it. You could write a bunch
of separate rules listing each possibility, but to make this faster and easier,
Lexurgy provides *alternative lists*.

For example, it's common to have a change happen only between vowels.
In a language with the classic five-vowel system, that would be 25 combinations,
which would be very tedious to write out in full. Instead of listing them out,
you use alternative lists, like this::

    rhotacization:
        s => r / {a, e, i, o, u} _ {a, e, i, o, u}

You can also use alternative lists in the old sound and new sound parts of the rule.
If only the old sound is an alternative list, all of the sounds in it will change
into the single new sound::

    glottal-stop:
        {p, t, k} => ʔ / {a, e, i, o, u} _ {a, e, i, o, u}

If both are alternative lists, they must be the same length, and each sound in the old list
will change into the corresponding sound in the new list::

    intervocalic-lenition:
        {p, t, k} => {b, d, g} / {a, e, i, o, u} _ {a, e, i, o, u}

This will turn [p] into [b], [t] into [d], and [k] into [g].

It's invalid to have a single sound turn into an alternative list, or to
have a list of one length turn into a list of a different length.

Alternative environments
************************

The alternative list mechanism can be used not just for sounds, but for entire environments.

.. TODO examples

Word boundaries
***************

You can specify that a rule only applies at the beginning or end of a word by marking the
word boundary with a $::

    aspirate-initial-stop:
        {p, t, k} => {pʰ, tʰ, kʰ} / $ _
    final-vowel-to-schwa:
        {a, e, i, o, u} => ə / _ $

The first applies only at the beginning of a word, the second at the end of a word.

Empty sounds
************

If you want to delete a sound entirely, put an asterisk in place of the new sound::

    drop-final-vowel:
        {a, e, i, o, u} => * / _ $

Similarly, you can add epenthetic sounds by putting an asterisk before the change arrow
and specifying the environment where the sound should appear::

    spanish-e:
        * => e / _ s {p, t, k}

Exclusions
**********

Sometimes it's easier to say when a change *doesn't* occur than when it does. You can
specify exceptions to a rule using a double slash::

    i-before-e-except-after-c:
        * => i / _ e // c _



Compound Rules
~~~~~~~~~~~~~~

You can put several rules under one rule name. This helps keep the file organized, grouping
related changes together.

Simultaneous Subrules
*********************

By default, compound rules are executed simultaneously.
This is useful for "chain shifts". For example::

    chain-shift:
        {pʰ, tʰ, kʰ} => {p, t, k}
        {p, t, k} => {b, d, g}
        {b, d, g} => {v, ð, ɣ}

If these were separate rules, then a proto-language ``pʰ`` would pass through each
rule in turn, becoming first ``p``, then ``b``, then ``v``. But since they're
written as subrules, the second subrule can't apply to the output of the first,
so the result is a ``p``.

.. TODO examples

Sequential Subrules
*******************

If you put ``Then:`` between two subrules, then Lexurgy will apply them sequentially instead of
simultaneously, as if they were separate rules.

.. TODO examples

Sound classes
~~~~~~~~~~~~~

You can define premade lists of sounds at the top of the file::

    Class vowel {a, e, i, o, u}
    Class unvcdstop {p, t, k}
    Class vcdstop {b, d, g}

When you use these in rules, they act just like alternative lists. So you can implement
intervocalic lenition like this::

    @unvcdstop => @vcdstop / @vowel _ @vowel

Lexurgy automatically expands this rule into::

    {p, t, k} => {b, d, g} / {a, e, i, o, u} _ {a, e, i, o, u}

But if you use the same lists often, having short names for them saves
a lot of typing and makes your intentions clearer.

You can use the names of previously defined classes in your
class definitions::

    Class stop {p, t, k}
    Class fricative {f, s}
    Class obstruent {@stop, @fricative}

Now the ``obstruent`` class expands to ``{p, t, k, f, s}``. You can
use this to build up larger and larger classes of sounds
without repeating yourself.

Lexurgy's sound classes should be familiar to users of Rosenfelder's SCA,
but they're more powerful in Lexurgy --- they can have descriptive
names, the symbols in them can be more than one character long, and
you can define them in terms of other classes.

Feature matrices
~~~~~~~~~~~~~~~~

Another, more flexible way of generalizing rules is to define each sound as a
matrix of features. This is inspired by distinctive feature theory (via Bangs's Phonix),
but the syntax is designed for practical conlanging rather than theoretical soundness.
In addition, not every sound needs to be defined with features, so you can freely
mix feature matrices with sound classes and plain text in your rules.

Feature variables
*****************

Absent features and null aliases
********************************

Negated features
****************

Diacritics
**********

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

Floating Diacritics
*******************

Multiple-segment rules and empty segments
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Optional and repeated segments
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

.. caution::
    Optional and repeated segments are *greedy*; they match as much as they
    can in the input word, even if doing so makes the rule fail. For
    example, suppose we have this file::

        Class glide {w, j}
        Class consonant {p, t, k, f, s, m, n, l, @glide}
        Class vowel {a, e, i, o, u, ø, y}

        umlaut:
            {a, e, o, u} => {e, i, ø, y} / _ @consonant* j

    This rule is intended to apply umlaut to a vowel in the syllable before
    a /j/ onglide; the ``@consonant*`` is supposed to mean that the
    rule still applies even if there are consonants in between.
    Unfortunately, the rule does nothing at all, no matter what word you give it.

    This happens because /j/ is also included in the ``consonant`` class. Suppose
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

Gemination and metathesis
~~~~~~~~~~~~~~~~~~~~~~~~~

Rule filters
~~~~~~~~~~~~

Propagation
~~~~~~~~~~~

Romanization
~~~~~~~~~~~~

It's a good idea to do all the sound changes in phonetic notation (e.g. IPA).
But you probably do most of the work for your languages in their romanization systems.
You can define romanization rules at the beginning and end of any sound change applier,
but Lexurgy SC supports specific notation for it so your intention is clear.
Just define a special rule at the beginning with the name "Deromanizer"
and another rule at the end with the name "Romanizer". Like any rule, the expressions
within the romanization rules are applied simultaneously, and earlier rules
take precedence over later ones.

Some features, like matrices, aren't allowed in the input to the deromanizer
or the output of the romanizer, since they operate on sounds, not letters.

.. _sc-intermediate-romanizers:

Intermediate romanizers
***********************

If you want to preserve the history of a language at several stages, you can
use intermediate romanizers.

.. TODO more

You need to specify the :option:`-m` command-line argument in order for
intermediate romanizers to activate.

.. only:: not public

    Command-line arguments
    ----------------------

    Lexurgy offers a variety of command-line arguments to customize its behaviour.

    .. option:: -a <rule>, --start-at <rule>

        If this is specified, Lexurgy will ignore every rule before the specified rule
        (including the deromanizer). This is useful if you want to introduce loanwords
        or affixes partway through the language's history.

    .. option:: -b <rule>, --stop-before <rule>

        If this is specified, Lexurgy will ignore the specified rule and every rule
        after it. This is useful if you want to evolve some forms partway, then
        modify them and resume (using :option:`-a`).

    .. option:: -m, --intermediates

        This activates :ref:`intermediate romanizers <sc-intermediate-romanizers>`.
