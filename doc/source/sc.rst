
Lexurgy SC
===========

Run SC using the command line::

    lexurgy sc changes words

The ``changes`` file needs to use the Lexurgy SC format; by convention these have a
.lsc extension.

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
into the single new sound.

::

    glottal-stop:
        {p, t, k} => ʔ / {a, e, i, o, u} _ {a, e, i, o, u}

If both are alternative lists, they must be the same length, and each sound in the old list will change into the corresponding sound in the new list.

::

    intervocalic-lenition:
        {p, t, k} => {b, d, g} / {a, e, i, o, u} _ {a, e, i, o, u}

This will turn [p] into [b], [t] into [d], and [k] into [g].

It's invalid to have a single sound turn into an alternative list.

Word boundaries
***************

You can specify that a rule only applies at the beginning or end of a word by marking the word boundary with a $::

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

Similarly, you can add epenthetic sounds by putting an asterisk before the change arrow and specifying the environment where the sound should appear::

    spanish-e:
        * => e / _ s {p, t, k}

Exclusions
**********

Sometimes it's easier to say when a change *doesn't* occur than when it does. You can specify exceptions to a rule using a double slash::

    <insert example here>

Simultaneous rules
~~~~~~~~~~~~~~~~~~



Sound classes
~~~~~~~~~~~~~

You can define premade lists of sounds at the top of the file.

::

    Class vowel {a, e, i, o, u}
    Class unvcdstop {p, t, k}
    Class vcdstop {b, d, g}

When you use these in rules, they act just like alternative lists. So you can implement intervocalic lenition like this::

    @unvcdstop => @vcdstop / @vowel _ @vowel

Lexurgy automatically expands this rule into

::

    {p, t, k} => {b, d, g} / {a, e, i, o, u} _ {a, e, i, o, u}

But if you use the same lists often, having short names for them saves a lot of typing and makes your intentions clearer.

Lexurgy's sound classes should be familiar to users of Rosenfelder's SCA. But unlike in Rosenfelder's SCA, the sounds in a sound class can be multiple characters long, and work the way you would expect.

Feature matrices
~~~~~~~~~~~~~~~~

Another, more flexible way of generalizing rules is to define each sound as a matrix of features. This is inspired by distinctive feature theory (via Bangs's Phonix), but the syntax is designed for practical conlanging rather than theoretical soundness. In addition, not every sound needs to be defined with features, so you can freely mix feature matrices with sound classes and plain text in your rules.

Feature variables
*****************

Absent features and null aliases
********************************

Negated features
****************

Diacritics
**********

Multiple-segment rules and empty segments
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Optional and repeated segments
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Gemination and metathesis
~~~~~~~~~~~~~~~~~~~~~~~~~

Rule filters
~~~~~~~~~~~~

Propagation
~~~~~~~~~~~

Romanization
~~~~~~~~~~~~

It's a good idea to do all the sound changes in phonetic notation (e.g. IPA). But you probably do most of the work for your languages in their romanization systems. You can define romanization rules at the beginning and end of any sound change applier, but Lexurgy SC supports specific notation for it so your intention is clear. Just define a special rule at the beginning with the name "Deromanizer" and another rule at the end with the name "Romanizer". Like any rule, the expressions within the romanization rules are applied simultaneously, and earlier rules take precedence over later ones.

Some features, like matrices, aren't allowed in the input to the deromanizer or the output of the romanizer, since they operate on sounds, not letters.