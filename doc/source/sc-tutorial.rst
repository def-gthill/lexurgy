Writing Sound Changes With Lexurgy SC
=====================================

This page is a tour through the features of Lexurgy SC.
Start here if you're new to Lexurgy.

Once you're comfortable with the basics, the
:doc:`Cheat Sheet <sc-cheat-sheet>` is a handy reference.

.. For all the gory details, see the :doc:`Language Specification <sc-dsl>`.

As you read, be sure to try out each example in the
`Lexurgy SC web app <https://www.lexurgy.com/sc>`_.
Full example files can be found at
`Examples page <https://www.lexurgy.com/examples/sc>`_.

Basic Structures
-----------------

Writing Rules
~~~~~~~~~~~~~~

Enter the following into the "Sound Changes" box::

    k-before-a:
        k => ʃ / _ a

This rule changes the sound [k] to the sound [ʃ], but only immediately
before the sound [a]. If you put some example words (e.g. "koka" and "sisa")
in the "Input Words" box and click "Apply", you should see that "koka"
turns into "koʃa", while words that don't match the rule at all, like "sisa",
don't change.

All rules need to have the ``=>`` symbol to separate the *match side* of
the expression (``k`` in the example), which indicates what to change,
from the *result side* of the expression (``ʃ`` in the example),
which indicates what it should change into. The example also has
an *environment* (``_ a``), meaning "before the sound [a]"; the underscore
represents the location of the changing sounds.

If you want an *unconditional*
change --- one that doesn't depend on neighbouring sounds --- you can
leave out the environment. This is an unconditional sound change::

    caught-cot-merger:
        ɔ => ɑ

This change turns all [ɔ] sounds into [ɑ], wherever they appear in the word.

.. note::

    I've indented the examples on this page to make them easier to read,
    but Lexurgy doesn't actually care about indentation. Your rules will
    still work even if all the lines are left-justified.

Special Characters
~~~~~~~~~~~~~~~~~~~~

Lexurgy works in Unicode, so it can seamlessly handle IPA characters and
other special characters. You just need a way to enter them: either copy
them from a site like `this <https://www.ipachart.com/>`_, or install
an IPA keyboard layout like `this one <https://keyman.com/ipa/>`_.

While Lexurgy handles exotic characters with ease, it'll have trouble
if you try to write rules using characters like "+", "$", "!", and other characters
that mean something special to Lexurgy. If you need to use one of these
characters as a phonetic symbol (say you're making a click language and
want to use "!"), you have to put a backslash in front of it to tell
Lexurgy that you mean a literal [!]::

    click-loss:
        \! => t

.. _sc-symbols:

Using Digraphs
~~~~~~~~~~~~~~

If you want to use digraphs in your rules, you can declare *symbols*::

    Symbol ts, dz

Then rules that affect *t* or *s* will ignore them if they're part of a *ts*,
and similarly with *dz*.

.. _sc-alternative-lists:

Combining Similar Rules with Alternative Lists
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Often, several sounds are affected by a change, or trigger it. You could write a bunch
of separate rules listing each possibility, but to make this faster and easier,
Lexurgy provides *alternative lists*.

For example, it's common to have a change happen only between vowels.
In a language with the classic five-vowel system, that would be 25 combinations,
which would be very tedious to write out in full. Instead of listing them out,
you use alternative lists, like this::

    rhotacization:
        s => r / {a, e, i, o, u} _ {a, e, i, o, u}

You can also use alternative lists in the input and output parts of the rule.
If only the input is an alternative list, all of the sounds in it will change
into the single new sound::

    glottal-stop:
        {p, t, k} => ʔ / {a, e, i, o, u} _ {a, e, i, o, u}

If both are alternative lists, they must be the same length, and each sound in the old list
will change into the corresponding sound in the new list::

    intervocalic-lenition:
        {p, t, k} => {b, d, ɡ} / {a, e, i, o, u} _ {a, e, i, o, u}

This will turn [p] into [b], [t] into [d], and [k] into [ɡ].

It's invalid to have a single sound turn into an alternative list, or to
have a list of one length turn into a list of a different length.

The alternative list mechanism can also be used to specify multiple environments.
For example, this rule converts stops into fricatives both between vowels and before other
stops::

    frication:
        {p, t, k} => {f, θ, x} / {{a, e, i, o, u} _ {a, e, i, o, u}, _ {p, t, k}}

Note the two underscores, one in each environment. Alternative environments are the
*only* time you can have multiple underscores in the same expression!

.. _sc-classes:

Sound Classes
~~~~~~~~~~~~~~

If you find yourself using the same alternative lists over and over
again, you can give them convenient names using *sound classes*.
The above examples would be much less repetative if we defined these
classes::

    Class vowel {a, e, i, o, u}
    Class unvcdstop {p, t, k}
    Class vcdstop {b, d, ɡ}

Now we can write intervocalic lenition like this::

    intervocalic-lenition:
        @unvcdstop => @vcdstop / @vowel _ @vowel

You need to include the `@` sign to make it clear that you're talking
about the *class* called `vowel`, not the literal sounds /vowel/.

You can use the names of previously defined classes in your
class definitions::

    Class stop {p, t, k}
    Class fricative {f, s}
    Class obstruent {@stop, @fricative}

Now the ``obstruent`` class expands to ``{p, t, k, f, s}``. You can
use this to build up larger and larger classes of sounds
without repeating yourself.

Lexurgy's sound classes should be familiar to users of Rosenfelder's
`SCA <http://zompist.com/sca2.html>`_.

Word Boundaries
~~~~~~~~~~~~~~~

You can specify that a rule only applies at the beginning or end of a word by marking the
word boundary with a dollar sign::

    aspirate-initial-stop:
        {p, t, k} => {pʰ, tʰ, kʰ} / $ _
    final-vowel-to-schwa:
        {a, e, i, o, u} => ə / _ $

The first applies only at the beginning of a word, the second at the end of a word.

Deleting and Inserting Sounds
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

If you want to delete a sound entirely, put an asterisk in the result side::

    drop-final-vowel:
        {a, e, i, o, u} => * / _ $

Similarly, you can add epenthetic sounds by putting an asterisk on the match side
and specifying the environment where the sound should appear::

    spanish-e:
        * => e / _ s {p, t, k}

When using asterisks on the match side, be sure to specify a condition!
Not using a condition causes the sound to be inserted *everywhere*, turning
e.g. *scola* into *eseceoeleae* --- probably not what you want!

Exceptions
~~~~~~~~~~

Sometimes it's easier to say when a change *doesn't* occur than when it does. You can
specify exceptions to a rule using a double slash::

    final-vowel-loss:
        e => * / _ $ // {p, t, k} _

This rule drops a final [e], *except* after a voiceless stop.

Wildcards
~~~~~~~~~~

The symbol ``[]`` matches any single sound. It's often useful for
"skipping" a certain number of sounds. For example, the following
rule deletes schwas, but not in the last two sounds of a word::

    drop-schwas:
        ə => * / _ [] []

It works by requiring there to be two sounds (*any* two sounds)
after the schwa.

Comments
~~~~~~~~~

Any line that starts with ``#`` is a comment, and Lexurgy will ignore it.
Comments can help you remember why you wrote your sound changes a certain
way, especially if you had to use a complicated rule that's hard to
understand just by looking at it.

.. _sc-three-stage-palatalization:

You can put comments on their own, inside rules, or even at the ends
of lines::

    # These rules palatalize k to s before i in three steps.
    palatalization-1:
        k => tʃ / _ i
    palatalization-2:
        # This is step 2!
        tʃ => ʃ
    palatalization-3:
        ʃ => s # This is step 3!

Basican
~~~~~~~~

What you've seen so far is enough to understand the
`Basican example <https://www.lexurgy.com/examples/sc?changes=1&input=1>`_.

You can do a lot with just the basic structures, but they barely
scratch the surface of what Lexurgy offers.

Intermediate Structures
------------------------

Multiple-Segment Rules
~~~~~~~~~~~~~~~~~~~~~~~

A rule can affect a *sequence* of consecutive sounds at the same time.
For example, this rule implements *compensatory lengthening* when a
coda stop consonant is lost::

    Class consonant {p, t, k, s, m, n, l}
    coda-stop-drop-and-lengthen:
        {a, e, i, o, u} {p, t, k} => {aː, eː, iː, oː, uː} * / _ @consonant

Lexurgy lines up ``{a, e, i, o, u}`` with ``{aː, eː, iː, oː, uː}`` and
``{p, t, k}`` with ``*``, and applies both changes.

In most cases, the number of elements must be the same on each side of the ``=>``.
If a change adds or deletes some of the sounds, fill in the missing spaces
with asterisks.

Simultaneous Expressions
~~~~~~~~~~~~~~~~~~~~~~~~~

You can put multiple expressions in a single rule::

    Class nasal {m, n}
    post-nasal-lenition:
        {b, d, ɡ} => * / @nasal _
        {p, t, k, f, x} => {b, d, ɡ, h, h} / @nasal _

When a rule has several expressions, each expression
runs simultaneously, so later expressions don't see
the results of earlier expressions. This means we could
actually reverse the order of the expressions above
without changing the result::

    post-nasal-lenition:
        {p, t, k, f, x} => {b, d, ɡ, h, h} / @nasal _
        {b, d, ɡ} => * / @nasal _

Even though the first expression changes [p] into [b], this
isn't visible to the second expression, so the second expression
won't delete the resulting [b]'s.

The order of expressions only matters if two expressions try to change
the same part of the word; in these situations, the earliest expression
takes precedence.
This can be useful for making rules that do one thing in most cases,
and another thing in some exceptional case::

    k-shift:
        k => s / _ {e, i}
        k => h / $ _

The first expression
blocks the second from changing ``k`` to ``h`` before ``e`` and ``i``
(by changing it to ``s`` instead).

Compound Rules
~~~~~~~~~~~~~~~

You can combine two or more rules under one name by putting ``Then:``
between the expressions. For example, the palatalization rule from
:ref:`above <sc-three-stage-palatalization>` could be rewritten as::

    palatalization:
        k => tʃ / _ i
        Then: tʃ => ʃ
        Then: ʃ => s

If you put more than one expression between each ``Then:``, then those
expressions run simultaneously, just like in an ordinary rule.

Compound rules help keep the sound changes organized by grouping related
changes together under one name.

Romanization
~~~~~~~~~~~~~

It's a good idea to do all the sound changes in phonetic notation (e.g. IPA).
But you probably do most of the work for your languages in their romanization systems.
Lexurgy has conventions for converting between IPA and romanizations so
that you don't confuse romanization rules with actual sound changes.

If the input language has a romanization system, the first rule should
be called "deromanizer" and contain all of the rules for converting from
the input language's romanization to phonetic notation. If you make this
a compound rule (by separating expressions with ``Then:``), you can do
complex sequences of transformations within a single "deromanizer" rule.

Similarly, if the output language has a romanization system, the last
rule should be called "romanizer" and contain all of the rules for
converting from phonetic language to the output language's romanization.

.. _sc-intermediate-romanizers:

Intermediate Romanizers
~~~~~~~~~~~~~~~~~~~~~~~

If you want to preserve the history of the language at several stages, you can
use intermediate romanizers. Any rule whose name starts with "romanizer-" will
be treated as an intermediate romanizer.

Intermediate romanizers differ from ordinary rules in an important way: subsequent
rules don't see the changes they make. Instead, their results are included in the
output along with the final form of the word.
Let's revisit the three-stage palatalization
rule, but put in some intermediate romanizers::

    palatalization-1:
        k => tʃ / _ i
    romanizer-old-examplish:
        tʃ => ch
    palatalization-2:
        tʃ => ʃ
    romanizer-middle-examplish:
        ʃ => sh
    palatalization-3:
        ʃ => s

Suppose you pass the word "kinoki" to these sound changes. It
will go through the changes as follows:

- The rule ``palatalization-1`` executes, turning "kinoki" into "tʃinotʃi".
- The rule ``romanizer-old-examplish`` executes, turning "tʃinotʃi" into "chinochi".
- The rule ``palatalization-2`` executes, but it *still sees* "tʃinotʃi";
  it turns this into "ʃinoʃi".
- The rule ``romanizer-middle-examplish`` executes, turning "ʃinoʃi" into "shinoshi".
- The rule ``palatalization-3`` executes, but it *still sees* "ʃinoʃi"; it turns
  this into "sinosi".

The output of this sound changer would look something like this::

    kinoki => chinochi => shinoshi => sinosi

If the intermediate "romanizer" should just dump the phonetic forms,
you can use the special rule "unchanged"::

    romanizer-phonetic:
        unchanged

.. note::

    For the command-line tool, you need to specify the :option:`-m` command-line argument
    in order for intermediate romanizers to activate.

.. _sc-features:

Using Features
~~~~~~~~~~~~~~~

We saw above how using alternative lists and sound classes helps make
sound changes less repetitive and more compact. But Lexurgy provides
another way of doing this: *features*. Features take more effort to
set up, but they allow certain kinds of rules, like assimilation and
stress rules, to be written much more simply than would be possible
with sound classes.

Binary Features
****************

Let's look at an example of a simple vowel space defined using
*binary features*, as used in
`distinctive feature theory <http://www.sfu.ca/~mcrobbie/Ling221/Lecture%233%20.pdf>`_::

    Feature low, high
    Feature front, back
    Symbol a [+low -high -front -back]
    Symbol e [-low -high +front -back]
    Symbol i [-low +high +front -back]
    Symbol o [-low -high -front +back]
    Symbol u [-low +high -front +back]

This example defines four *features*: ``low``, ``high``, ``front``,
and ``back``, representing the position of the tongue
in the mouth when making that vowel. Each of these features has two *values*: ``low``
has the value ``+low`` for low vowels like [a], and the
value ``-low`` for non-low vowels. We then define
a *symbol* for each vowel we want to use, and give each
vowel a *feature matrix*, showing which feature values
that vowel has. Now, anytime Lexurgy encounters an [e]
in a word, it knows that that [e] is a front vowel, but
not a low, high, or back vowel.

With these definitions, we can write a rule like this::

    final-vowel-raising:
        [-low -high] => [+high] / _ $

This rule says that any mid vowel (non-low, non-high) at
the end of a word becomes *the corresponding* high vowel:
[e] becomes [i], and [o] becomes [u]. The matrix ``[+high]``
on the result side of the rule means that the ``high``
feature, and *only* the ``high`` feature, will be changed
to ``+high``, while all other features (like the ``front``
and ``back`` features) are left unchanged.

.. note::
    Each symbol must have a distinct matrix --- you can't define both
    [ɛ] and [e] as just ``[-low -high +front -back]``. You have to
    add some kind of distinguishing feature; an ``ATR``
    feature could be used to distinguish these two sounds.

Absent Values
****************

Binary features actually have a *third* value: *absent*,
written with a ``*`` before the feature name. (This
makes the name "binary" rather suspect... sorry, I didn't
invent the terminology!) So the
absence of the ``low`` feature is written ``*low`` and
the absence of the ``back`` feature is written ``*back``.
Any character that you haven't explicitly given a value
for the ``low`` feature automatically has ``*low``.
This would most likely be the case with any consonant
sounds, where the ``low`` feature is irrelevant.

You can use absent features in rules just like any other
feature value.

.. note::
    Any characters in an input word that don't match symbols are considered to
    lack all features, so they'll only match matrices consisting entirely
    of absent features, like ``[*low *front]``, or the empty matrix ``[]``.

Univalent Features
*******************

You can also define *univalent features*, which only
have *two* values: present and absent.

The following defines two univalent features::

    Feature +nasalized
    Feature +stress

With these definitions, the feature ``stress`` has the two values
``+stress`` and ``-stress``. Any sound that
isn't explicitly declared to be ``+stress`` is
automatically ``-stress``. There's no separate ``*stress``
value; ``-stress`` *is* the absent value.

Univalent features are convenient for suprasegmentals
like stress, because it would be annoying to have
to declare every single vowel to be ``[-stress]``.

Multivalent Features
*********************

Lexurgy differs from tools like
`Phonix <https://gitlab.com/jaspax/phonix/blob/master/README.md>`_
(and from distinctive feature theory) by allowing
features with any number of values. For example,
you can recreate the IPA consonant chart like this::

    Feature voicing(unvoiced, voiced)
    Feature place(labial, dental, alveolar, velar, glottal)
    Feature manner(stop, fricative, nasal, approximant)

    Symbol p [unvoiced labial stop]
    Symbol b [voiced labial stop]
    Symbol t [unvoiced dental stop]
    Symbol d [voiced dental stop]
    Symbol k [unvoiced velar stop]
    Symbol ɡ [voiced velar stop]
    Symbol f [unvoiced labial fricative]
    Symbol v [voiced labial fricative]
    Symbol ð [voiced dental fricative]
    Symbol s [unvoiced alveolar fricative]
    Symbol z [voiced alveolar fricative]
    Symbol x [unvoiced velar fricative]
    Symbol ɣ [voiced velar fricative]
    Symbol h [unvoiced glottal fricative]
    Symbol m [labial nasal]
    Symbol n [alveolar nasal]
    Symbol l [alveolar approximant]

This defines three features, ``voicing``, ``place`` and ``manner``, with
two, five, and four values respectively. With multivalent features, each value has a name;
rather than writing ``[+place]`` or ``[-manner]``, which wouldn't make
sense, you have to use the names, like ``[labial nasal]``.

With these definitions, you can write rules like this::

    Class vowel {a, e, i, o, u}
    intervocalic-lenition:
        [unvoiced stop] => [voiced] / @vowel _ @vowel
        [voiced stop] => [fricative] / @vowel _ @vowel
        [unvoiced fricative] => h / @vowel _ @vowel
        h => * / @vowel _ @vowel

Just like binary and univalent features, multivalent features always
have an *absent* value. In this example, we didn't specify a voicing for [m], [n], and [l],
so they automatically have the absent value ``*voicing``.

Feature Variables
******************

Languages often undergo *assimilation*, where one sound becomes more like a nearby sound.
Lexurgy helps in writing assimilation rules by allowing *feature variables*, which copy
a feature value from one sound to another.

For example, suppose you have these declarations::

    Feature type(*vowel, consonant)
    Feature place(labial, alveolar, velar, glottal)
    Feature manner(stop, fricative, nasal, approximant)

    Symbol p [labial stop consonant]
    Symbol t [alveolar stop consonant]
    Symbol k [velar stop consonant]
    Symbol s [alveolar fricative consonant]
    Symbol m [labial nasal consonant]
    Symbol n [alveolar nasal consonant]
    Symbol ŋ [velar nasal consonant]
    Symbol l [alveolar approximant consonant]

Then you can write the common *nasal assimilation* rule like this::

    nasal-assimilation:
        [nasal] => [$place] / _ [consonant $place]

The ``[consonant $place]`` matrix in the environment matches any consonant, but captures the
value of that consonant's ``place`` feature. This feature value is copied into the matching
``$place`` in the output matrix. So a nasal before a [p] would have the matrix [labial]
applied to it and become an [m], a nasal before a [d] would have the matrix [alveolar]
applied and become an [n], etc.

.. warning::
    Beware of matrices containing only feature variables, like ``[$place]`` or
    ``[$low $front]``, in the match or environment portion of a rule. Feature
    variables copy the *absent value too*, so these matrices will match
    *anything* and blithely copy absent values where they don't belong. For
    example, it's tempting to write the above nasal assimilation rule like this::

        [nasal] => [$place] / _ [$place]

    But this rule will apply to a word like "nato", copying the implicit ``*place``
    value from the [a] onto the [n] and resulting in a nasal with no place of
    articulation. If Lexurgy complains with an error message like
    "No combination of a symbol and diacritics has the matrix [nasal]",
    it's probably run into exactly this problem!

Giving the Absent Value a Name
*********************************

You can give the absent value of any multivalent feature a name. This declaration
allows ``unstressed`` to be used instead of ``*stress`` to indicate a lack
of both primary and secondary stress::

    Feature stress(*unstressed, primary, secondary)

Even though it has a name, ``unstressed`` still behaves like an absent value;
all sounds that don't have stress indicated explicitly are ``unstressed``.

Negated Features
*****************

A feature value in a matrix can be negated by prefixing it with ``!``. Then the matrix
will match any sound that *doesn't* have that value. For example, ``[stop !glottal]``
will match any stop *except* the glottal stop, while ``[vowel front !high]`` will match
non-high back vowels.

You can't use negated features on the result side of a rule; if you try to transform
a sound *to* ``[stop !glottal]``, Lexurgy doesn't know what you want
the place of articulation to be (is it ``alveolar``? ``velar``?), only what you want
it *not* to be.

.. _sc-diacritics:

Diacritics
~~~~~~~~~~

The IPA indicates some features explicitly using diacritics: [ʰ]
indicates aspiration, [ː] makes a vowel long, and [ ̥ ] makes a sound voiceless.

You can declare these in Lexurgy like this::

    Feature +aspirated, +long, voiced
    Diacritic ʰ [+aspirated]
    Diacritic ː [+long]
    Diacritic ̥  [-voiced]

If these diacritics appear in the input words or in rules, Lexurgy will
consider them to add the specified feature value to the modified sound, replacing
the existing value of that feature. For example, if
[p] is ``[-voiced bilabial stop]``, then [pʰ] is ``[+aspirated -voiced bilabial stop]``;
if [n] is ``[+voiced alveolar nasal]``, then [n̥] is ``[-voiced alveolar nasal]``.

Diacritics also work when translating matrices back into symbols: if a rule produces
``[-voiced alveolar nasal]``, and there's no symbol explicitly defined with that matrix,
Lexurgy will search through possible combinations of symbols and diacritics to find
one that fits the matrix, namely [n̥].

If you add ``(before)`` to a diacritic declaration (before or after the
matrix), it will go before the base symbol. For example, if you define
``Diacritic ⁿ (before) [+prenasalized]`` (or ``Diacritic ⁿ [+prenasalized] (before)``),
then the prenasalized version of [d] will show up as ``ⁿd`` rather than ``dⁿ``.

Similarly, if you add ``(first)`` to a diacritic declaration,
it will go *after the first character* of the symbol. This is
useful for applying diacritics to diphthongs: applying
``́`` to the symbol ``aj`` will produce the undesirable ``aj́``. Declaring
it ``(first)`` will produce ``áj`` instead. (On single-character symbols,
"first" diacritics act the same as "after" diacritics.)

Diacritics can even be applied to symbols that aren't declared with feature
matrices, in which case you can change the diacritics using matrix rules but
not the base symbol. For example,
this rule will turn the sequence [ar] into [aː], even without a symbol
definition for [a]::

    Feature +long
    Diacritic ː [+long]
    a-before-r:
        a r => [+long] *

But if you wanted to change the ``a`` into a different vowel using matrix
rules, you would have to declare it as a symbol with a feature matrix.

Floating Diacritics
********************

Some diacritics indicate suprasegmentals or other features that aren't integral to the
sound. While most languages would treat [p] and [pʰ] as entirely different
sounds (if they're distinguished at all), a feature like stress or tone is added on
top of a vowel sound without affecting its nature much. As a result, most sound changes
should ignore the feature.

You can indicate this by making the diacritic *floating*::

    Feature +hightone, +stress
    Diacritic ˈ (floating) [+stress]
    Diacritic ́  (floating) [+hightone]

Literal sounds *without* floating diacritics match sounds *with or without* floating diacritics, and
transmit any floating diacritics unaltered to the output. For example, suppose that we write this rule::

    mid-raising:
        {e, o} => {i, u}

This will turn ``kepo`` into ``kipu``, but also ``keˈpó`` into ``kiˈpú``.

On the other hand, literal sounds *with* the floating diacritic only match sounds *with*
the diacritic. Suppose we write this rule instead::

    mid-raising:
        {eˈ, oˈ} => {iˈ, uˈ}

This rule will leave ``kepo`` unaltered because the vowels aren't stressed, but will turn
``keˈpó`` into ``kiˈpó``.

If you really want a literal sound without floating diacritics to only accept exact matches,
put ``!`` after the sound::

    mid-raising:
        {e!, o!} => {i, u}

This will turn ``kepo`` into ``kipu``, but leave ``keˈpó`` unaltered.

Multiple Criteria
~~~~~~~~~~~~~~~~~~

You can force Lexurgy to match multiple criteria on the same segment using
an *intersection*, which is notated by joining the criteria with ``&``.
The most common use of this is when you're mixing sound classes with features,
and need to specify that a rule only applies when a sound both *has a feature*
and *is in a class*::

    Feature +stress
    Diacritic ˈ (floating) [+stress]
    Class vowel {a, e, i, o, u}
    unstressed-final-vowel-loss:
        @vowel&[-stress] => * / _ $ // {p, t, k} _

If an :ref:`alternative list <sc-alternative-lists>` is the *first* element
in an intersection, then it can match up with an alternative list of the same length
on the result side of the rule. For example::

    Feature +stress
    Diacritic ˈ (floating) [+stress]
    unstressed-vowel-centralizing:
        {e, i, o, u}&[-stress] => {ə, ɨ, ə, ɨ}

Optional and Repeated Segments
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

You can mark part of the environment *optional* by putting a question mark after it::

    Feature +stress
    Diacritic ˈ (floating) [+stress]
    Class vowel {a, e, i, o, u}
    Class consonant {p, t, k, s, m, n, l}
    Class glide {j, w}
    stress-closed-last-syllable:
        @vowel => [+stress] / _ @glide? @consonant $

This rule will stress the vowel in a final closed syllable, even if there's an
offglide like [j] or [w] after the vowel.

If the language has a more complex syllable structure though, this won't be enough;
it won't match a word like [krajsk]. To deal with that case, you can use a *repeated*
segment::

    stress-closed-last-syllable:
        @vowel => [+stress] / _ @glide? @consonant+ $

The ``+`` indicates that we want *at least one* consonant at the end of the word.

If the repeated segment is also optional (i.e. the rule should accept zero or more
copies of the segment), you can use ``*`` instead of ``+``. For example, this
rule will stress the vowel in the last syllable regardless of whether there are
any glides or consonants at the end::

    stress-last-syllable:
        @vowel => [+stress] / _ {@glide, @consonant}* $

You can get even more specific about the number of allowed repetitions by
using numbers after the `*`. This rule will stress the last syllable
only if there are *exactly two* coda consonants::

    stress-last-syllable-picky:
        @vowel => [+stress] / _ {@glide, @consonant}*2 $


And this rule will stress the last syllable if there are *between one and three*
coda consonants::

    stress-last-syllable-less-picky:
        @vowel => [+stress] / _ {@glide, @consonant}*(1-3) $

If an entire sequence of sounds is optional or repeated, put those sounds in
parentheses so it's clear that the repeater applies to all the sounds
together, not just the last one. For example, if you wanted to assign stress
to the last syllable if it's open *or* if there's *both* a glide and a consonant
in its coda, you could do this::

    stress-last-syllable-complicated:
        @vowel => [+stress] / _ (@glide @consonant)? $

.. warning::

    Overly complicated combinations of optionals and repeaters can
    force Lexurgy to try too many possibilities. Take this rule::

        silly:
            (x+ x+)+ => *

    If you apply this rule to a word with a long sequence of x's
    (say, ``soxxxxxxxxxxxxx``), then Lexurgy doesn't know how to
    divide up the x's between the repeaters: it could be
    ``[(xxx)(xx)][(xxxxx)(xxx)]``, or ``[(x)(xx)][(xxx)(xxxx)][(xxx)]``,
    or any number of other possible combinations. Instead of running
    for a long time and hanging the app, Lexurgy will give up and report
    a "too many possibilities" error.

Intermediatese
~~~~~~~~~~~~~~~

Now you should understand enough to be able to follow along with the
`Intermediatese example <https://www.lexurgy.com/examples/sc?changes=2&input=1>`_.

With that, it's time to get to the power features that really make Lexurgy
stand out.

Advanced Structures
--------------------

Reusable Elements
~~~~~~~~~~~~~~~~~~

If you find yourself repeating part of an expression across many rules,
consider declaring it as an ``Element``.

Element declarations are similar to `class declarations <sc-classes_>`_, but
they can contain *anything* that you could find in an expression::

    Element scluster (s @stop)
    Element longorhigh {[+long], [+hightone]}

Once declared, you can reference elements in rules (or other elements),
using ``@`` just like class references::

    Feature +long, +hightone, +stress
    Diacritic ː (floating) [+long]
    Diacritic ́  (floating) [+hightone]
    Diacritic ˈ (floating) (before) [+stress]

    Class stop {p, t, k}

    Element scluster s @stop
    Element longorhigh {[+long], [+hightone]}

    epenthetic-e:
        * => e / _ @scluster

    stress:
        @longorhigh => [+stress]

    decluster-s:
        @scluster => * @stop

.. note::

    Most sound classes could equally well be declared as
    elements; e.g. ``Element stop {p, t, k}`` does the same thing
    as ``Class stop {p, t, k}``. However, referencing a class in
    an element declaration is slightly different from referencing a
    class from another class: ``Class obstruent {@stop, s}`` expands to
    ``{p, t, k, s}``, but ``Element obstruent {@stop, s}`` expands to
    ``{{p, t, k}, s}``. This matters if you're trying to line
    up corresponding sounds!

Hierarchical Rules
~~~~~~~~~~~~~~~~~~~

Some kinds of sound changes are best expressed as a hierarchy of rules, where
only the first condition that matches matters. The classic example
of this is stress rules. For example, a language might have the following stress
rule: a word is stressed on the last long vowel if one exists; *otherwise*
on the last closed syllable if one exists; *otherwise* on the last syllable.
To do this with the structures seen so far, you'd have to write something like this::

    Feature +stress, +long
    Diacritic ˈ (floating) [+stress]
    Diacritic ː (floating) [+long]
    Class vowel {a, e, i, o, u}
    Class cons {p, t, k, s, m, n, l}
    assign-stress:
        [+long] => [+stress] / _ [-long]* $
        Then:
        @vowel => [+stress] / $ [-stress]* _ @cons (@cons? @vowel&[-stress])* $
        Then:
        @vowel => [+stress] / $ [-stress]* _ @cons* $

We have to awkwardly tell the second and third expressions not to apply
if there's already stress somewhere else in the word. Otherwise, a
word like ``teːpunsa`` will trigger all three expressions in different
syllables, leading to all three syllables being stressed. Not helpfulǃ

Fortunately, there's a better way. Just use ``Else:`` instead of ``Then:``::

    Feature +stress, +long
    Diacritic ˈ (floating) [+stress]
    Diacritic ː (floating) [+long]
    Class vowel {a, e, i, o, u}
    Class cons {p, t, k, s, m, n, l}
    assign-stress:
        [+long] => [+stress] / _ [-long]* $
        Else:
        @vowel => [+stress] / _ @cons (@cons? @vowel)* $
        Else:
        @vowel => [+stress] / _ @cons* $

Now we don't have to include the extra ``[-stress]`` conditions.
When this rule is applied to a word like ``teːpunsa``, then as
soon as the first expression matches the [eː], that one sound is
changed and then the whole rule exits, so nothing else gets stressed.
If the first vowel is short, though, then the first expression doesn't
match anything, so the second expression gets a chance to apply, putting
stress on the [u]. In general, subsequent ``Else:`` rules are
only applied if all the previous ones didn't match the word.

If you need to use ``Then:`` and ``Else:`` in the same rule, use
parentheses to indicate whether the ``Then:`` is inside the ``Else:``
or vice versa. Here's a variation on the above rule that restricts
stress to one of the last three syllables using a temporary diacritic::

    Feature +stress, +long, +lastThree
    Diacritic ˈ (floating) [+stress]
    Diacritic ː (floating) [+long]
    Diacritic ³ (floating) [+lastThree]
    Class vowel {a, e, i, o, u}
    Class cons {p, t, k, s, m, n, l}
    assign-stress:
        @vowel => [+lastThree] / _ @cons* @vowel? @cons* @vowel? @cons* $
        Then: (
            [+long +lastThree] => [+stress] / _ [-long]* $
            Else:
            [+lastThree] => [+stress] / _ @cons (@cons? @vowel)* $
            Else:
            [+lastThree] => [+stress] / _ @cons* $
        )
        Then:
            [+lastThree] => [-lastThree]

Here, the parentheses indicate that the ``[+lastThree]`` is added
before the entire ``Else:`` block, and removed after the entire
``Else:`` block.

.. _sc-gemination:

Gemination and Metathesis
~~~~~~~~~~~~~~~~~~~~~~~~~~

Sometimes it's useful to copy an entire sound from one place to another, rather than
just a feature. Common cases where copying sounds is useful include *gemination*
(duplication of a sound) and *metathesis* (switching of sounds).

To capture a sound, put a *capture variable* immediately after the pattern that matches it.
A capture variable looks like a dollar sign followed by a number: ``$1``, ``$2``, etc.
Once a sound has been captured, you can use the capture variable alone to produce or
recognize a copy of the sound.

This rule applies gemination in stop-stop clusters, turning the first stop into
a copy of the second::

    Class stop {p, t, k}
    gemination:
        @stop @stop$1 => $1 $1

This rule applies metathesis to stop-fricative sequences::

    Class stop {p, t, k}
    Class fricative {f, s}
    metathesis:
        @stop$1 @fricative$2 => $2 $1

This rule uses a capture variable in the environment to *recognize* a geminate::

    Class consonant {p, t, k, s, m, n, l}
    geminate-epenthesis:
        * => e / _ @consonant$1 $1

This rule uses a bare capture variable on the match side of the rule to remove gemination
(*degemination*)::

    Class consonant {p, t, k, s, m, n, l}
    degemination:
        @consonant$1 $1 => $1 *

.. warning::

    Unlike most other elements, captures are picky about floating diacritics
    by default. They only match sounds that are *exactly* the same as the
    sound that was originally captured. If you want a capture reference
    to ignore floating diacritics, put a ``~`` before it: ``~$1`` matches
    whatever was captured by ``$1`` plus or minus any floating diacritics.

Negation
~~~~~~~~~

You can negate some types of rule elements --- match only segments that *don't* fit
the element --- by preceding the element with ``!``, as with matrix features.

Currently you can do this with literal text (``!r`` matches anything but the sound [r]),
classes (``!@vowel`` matches anything not in the ``vowel`` class), and capture references
(``!$1`` matches anything except what was captured in the ``$1`` variable).

You can negate *any* element that immediately follows an ``&``. For example,
``([] [])&!(@consonant @vowel)`` matches any sequence of two sounds *other than*
a consonant followed by a vowel. You can't just say ``!(@consonant @vowel)`` with
no context: almost any sequence of sounds is "not a consonant followed by a vowel",
and it often isn't clear which such sequence should be matched. Having a positive match first
tells Lexurgy what it should look for first, before filtering out the cases
you don't want.

Nested Environments
~~~~~~~~~~~~~~~~~~~~

Environments can be nested inside other structures. For example,
the following is a compact way of writing the rule "voiced stops word finally,
and aspirated stops unconditionally, both become voiceless stops"::

    nested-environment:
        {{b, d, g} / _ $, {pʰ, tʰ, kʰ}} => {p, t, k}

.. _sc-filters:

Rule Filters
~~~~~~~~~~~~~

Some rules only care about certain kinds of sounds, ignoring any intervening sounds.
This is most common with rules affecting vowels, such as stress, vowel harmony, and
tone.

You can make such rules more concise by defining a *filter* on the rule. A rule with
a filter will treat sounds that don't match the filter as if they didn't exist.

For example, a rule that assigns stress to the vowel in the first symbol could be
written like this::

    Feature +stress
    Diacritic ˈ (floating) [+stress]
    Class vowel {a, e, i, o, u}
    Class consonant {p, t, k, s, m, n, l}
    stress-first-syllable:
        @vowel => [+stress] / $ @consonant* _

But any consonants before the vowel are actually irrelevant to this rule, so the
``@consonant*`` in the environment is a distraction. Instead, you can write it like this::

    stress-first-syllable @vowel:
        [] => [+stress] / $ _

Note that we can use ``[]`` on the match side instead of ``@vowel`` because anything
that passes the filter will already be a vowel, so we don't need to test for vowelhood
again.

Similarly, a short-distance vowel harmony rule could be written like this::

    Feature type(*consonant, vowel)
    Feature height(low, mid, high)
    Feature frontness(front, central, back)
    Feature rounded
    Symbol a [low central -rounded vowel]
    Symbol e [mid front -rounded vowel]
    Symbol i [high front -rounded vowel]
    Symbol ø [mid front +rounded vowel]
    Symbol y [high front +rounded vowel]
    Symbol ɤ [mid back -rounded vowel]
    Symbol ɯ [high back -rounded vowel]
    Symbol o [mid back +rounded vowel]
    Symbol u [high back +rounded vowel]
    vowel-harmony [vowel]:
        [!central] => [$frontness] / [!central $frontness] _

Propagation
~~~~~~~~~~~~

Notice the word "short-distance" in the description of the previous example.
As written, it would only apply vowel harmony one vowel at a time, turning
e.g. [sinotehu] into [sinøtɤhy], which isn't harmonious at all.

When faced with a change that acts over arbitrarily long distances, such as
vowel harmony and stress rules, you can use *propagating* rules. A propagating
rule is marked by ``propagate`` after the rule name (and after any filter).
Lexurgy will apply propagating rules *repeatedly* until the word stops changing.

Propagation is all that's needed to turn the vowel harmony rule into a long-distance
rule::

    vowel-harmony [vowel] propagate:
        [!central] => [$frontness] / [!central $frontness] _

You can also put ``propagate`` on a ``Then:`` block to propagate
only the statements in the block.

.. warning::

    It's impossible to tell in general whether a propagating rule will ever
    terminate. So Lexurgy is conservative and stops with an error message if a
    rule runs a hundred times without settling on a result.

Now you should be able to follow the
`Advancedish example <https://www.lexurgy.com/examples/sc?changes=3&input=1>`_.

Left-to-Right and Right-to-Left Rules
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Lexurgy also supports directional variants of propagation.
If you mark a rule as ``ltr``, then it will be applied *exactly once*
at each sound in the word, moving from left to right. Rules marked
as ``rtl`` are similar, but move from right to left.

Since the vowel harmony rule from the previous section propagates
exclusively from left to right, it could equally well have been
written as::

    vowel-harmony [vowel] ltr:
        [!central] => [$frontness] / [!central $frontness] _

Deferred Rules
~~~~~~~~~~~~~~~

If you find yourself applying the same sound changes at several
stages of your language's evolution, consider turning them into
``deferred`` rules. A deferred rule isn't applied where it's declared;
instead, you apply it later as part of other rules.

For example, suppose you have a nasal assimilation rule::

    Class nasal {m, n, ŋ}

    nasal-assimilation:
        @nasal => m / {p, b}
        @nasal => n / {t, d}
        @nasal => ŋ / {k, g}

Then you go on developing your language, and at some point you
have a vowel deletion rule::

    Class vowel {a, e, o, i, u}

    delete-pretonic-mid-vowels:
        {e, o} => * / @vowel []* _ ([]* @vowel)*2 []* $

But this reintroduces nasal-stop clusters at different places
of articulation: your word ``anepato`` becomes ``anpato``. You
don't like this, so you apply the nasal assimilation rule *again*.
Now you have these sound changes::

    Class nasal {m, n, ŋ}
    Class vowel {a, e, o, i, u}

    nasal-assimilation:
        @nasal => m / _ {p, b}
        @nasal => n / _ {t, d}
        @nasal => ŋ / _ {k, g}

    delete-pretonic-mid-vowels:
        {e, o} => * / @vowel []* _ ([]* @vowel)*2 []* $

    nasal-assimilation-again:
        @nasal => m / _ {p, b}
        @nasal => n / _ {t, d}
        @nasal => ŋ / _ {k, g}

That works, but it's annoying; this entire rule appears twice, cluttering
up your sound changes. It also means that if you later find a mistake
in this rule, you have to remember to fix the mistake in both places.

You can get rid of this repetition by declaring nasal assimilation as
a deferred rule::

    nasal-assimilation defer:
        @nasal => m / {p, b}
        @nasal => n / {t, d}
        @nasal => ŋ / {k, g}

Now you can apply this rule whenever you need it using the syntax
``:nasal-assimilation``::

    Class nasal {m, n, ŋ}
    Class vowel {a, e, o, i, u}

    nasal-assimilation defer:
        @nasal => m / _ {p, b}
        @nasal => n / _ {t, d}
        @nasal => ŋ / _ {k, g}

    initial-nasal-assimilation:
        :nasal-assimilation

    delete-pretonic-mid-vowels:
        {e, o} => * / @vowel []* _ ([]* @vowel)*2 []* $

    nasal-assimilation-again:
        :nasal-assimilation

This is an improvement, but it could be a trap in the future:
if you later reorder your rules, you might accidentally move
``delete-pretonic-mid-vowels`` somewhere else and forget to move
``nasal-assimilation-again`` along with it. Since these two rules
belong together (the second cleans up a mess made by the first),
why not combine them into one rule?

::

    delete-pretonic-mid-vowels:
        {e, o} => * / @vowel []* _ ([]* @vowel)*2 []* $
        Then:
        :nasal-assimilation

As this example illustrates, you can combine references to deferred
rules with ordinary expressions.

Deferred rules can contain all the structures normal rules can,
including ``Then:`` and ``Else:`` blocks, filters,
and modifiers like ``propagate``.

.. note::

    If a deferred rule contains a ``Then:`` or ``Else:``, any
    references to it *must* be separated from adjacent expressions
    by a ``Then:`` or ``Else:``.

Cleanup Rules
~~~~~~~~~~~~~~

Deferred rules can help reduce repetition if you need to apply
the same rule multiple times. But sometimes you don't need that
much precision; you want something like nasal assimilation to
apply after *every* rule, to clean up any illicit clusters.
You can do this by declaring ``nasal-assimilation`` to be a
``cleanup`` rule::

    Class nasal {m, n, ŋ}
    Class vowel {a, e, o, i, u}

    nasal-assimilation cleanup:
        @nasal => m / _ {p, b}
        @nasal => n / _ {t, d}
        @nasal => ŋ / _ {k, g}

    delete-pretonic-mid-vowels:
        {e, o} => * / @vowel []* _ ([]* @vowel)*2 []* $

Cleanup rules run once when declared, and then again after every
subsequent named rule.

If you want a cleanup rule to *stop* applying at some point, you
can turn it off using this syntax::

    nasal-assimilation:
        off

Interactions Between Words
~~~~~~~~~~~~~~~~~~~~~~~~~~~

If you write multiple words on a line in the input (separated
by spaces), each will be treated as a separate word. For example,
if your rules are::

    drop-final-t:
        t => * / _ $

and your words are::

    sit amet

Then the result will be ``si ame``; the space between the words
is treated as a word boundary. Similarly, rules that look for
a specific environment won't look across word boundaries.

Affixation
***********

When creating a language diachronically, you may want to
simulate how grammatical particles turn into affixes. This
means you need the words to be treated as separate *before*
the affixation, but as one word after.

You do this with a rule that destroys the space between words, which is
represented by ``$$``::

    glomination:
        $$ => *

This can be conditioned on sounds in the neighbouring words. The following
will only join words if the first word ends in a [t] or the second word
starts with an [s]::

    selective-glomination:
        $$ => * / t _
        $$ => * / _ s

Sandhi Rules
*************

You can also condition *across* word boundaries, creating *sandhi* rules.
For example, this rule implements initial consonant lenition, similar
to how it works in Irish::

    Class vowel {a, e, i, o, u}
    lenition:
        {p, t, k, b, d, ɡ} => {f, h, x, v, j, ɣ} / @vowel $$ _ @vowel

Syllables
~~~~~~~~~~

Lexurgy can understand words that are broken up into syllables, using
periods (``.``) to separate syllables. You can also specify syllabification
rules and have Lexurgy automatically break up words into syllables.
This capability is demonstrated by the
`Syllabian example <https://www.lexurgy.com/examples/sc?changes=4&input=2>`_.

Enabling Syllables
*******************

To enable syllable-based processing, you have to provide a ``Syllables:``
declaration. Take this sound change::

    Class vowel {a, e, i, o, u}
    intervocalic-voicing:
        {p, t, k} => {b, d, ɡ} / @vowel _ @vowel

This turns e.g. ``kipo`` into ``kibo``. But
if we put syllable breaks in (``ki.po``), the rule stops
working, because the [p] is no longer between two vowels:
it's between a ``.`` and a vowel. To fix this, add *explicit syllables*::

    Class vowel {a, e, i, o, u}
    Syllables:
        explicit
    intervocalic-voicing:
        {p, t, k} => {b, d, ɡ} / @vowel _ @vowel

Now Lexurgy will treat all ``.`` characters in the input as syllable
breaks. It sees the [p] in ``ki.po`` as directly following the
[i] and correctly produces ``ki.bo``.

If you want to get rid of syllable breaks once you're done with them,
*clear syllables*::

    Class vowel {a, e, i, o, u}
    Syllables:
        explicit
    intervocalic-voicing:
        {p, t, k} => {b, d, ɡ} / @vowel _ @vowel
    Syllables:
        clear

This turns ``ki.po`` into ``kibo``.

Matching Syllable Breaks
*************************

You can use the ``.`` character in rules to match syllable boundaries.
For example, it's common for a rule to affect only *coda* consonants.
This rule nasalizes vowels before a coda nasal::

    Feature +nasalized
    Diacritic ̃  (floating) [+nasalized]
    Class vowel {a, e, i, o, u}
    Class nasal {m, n}
    Syllables:
        explicit
    nasalization:
        @vowel => [+nasalized] / _ @nasal .

This turns ``ban.ta`` into ``bãn.ta`` and ``ton`` into ``tõn``, but
leaves ``ba.na.na`` unchanged. Note that the ``.`` character matches
word boundaries too, not just syllable breaks within a word.

Matching Entire Syllables
**************************

If you want to match an entire syllable, use ``<syl>`` in the rule.
For example, this rule converts words into tallies of their syllables::

    Syllables:
        explicit
    tally-syllables:
        <syl> => I
    Syllables:
        clear

This converts ``ki.po`` into ``II`` and ``ba.na.na`` into ``III``.

Syllabification Rules
***********************

The above assumes that you've manually put syllable breaks in the input.
But you can have Lexurgy do this for you by specifying what syllable shapes
are allowed, using the same syntax as any other rule. Here's
a syllable declaration for a language with strictly open syllables
and no clusters::

    Class consonant {p, t, k, s, m, n, l}
    Class vowel {a, e, i, o, u}
    Syllables:
        @consonant? @vowel

The pattern ``@consonant? @vowel`` describes the valid syllable
shapes: an optional consonant followed by a mandatory vowel.
This will automatically break up ``kamina`` as ``ka.mi.na``
and ``ekipoa`` as ``e.ki.po.a``. But if you try to pass in a
word like ``kantu`` that violates the syllable structure,
you'll get an error.

Here's a more complicated example that allows certain coda
consonants::

    Class consonant {p, t, k, s, m, n, l}
    Class vowel {a, e, i, o, u}
    Syllables:
        @consonant? @vowel {m, n, l}?

This will still automatically break up ``kamina`` as ``ka.mi.na``
and ``ekipoa`` as ``e.ki.po.a``, but it will also allow
words like ``kantu`` and ``pasel``, breaking them up as ``kan.tu``
and ``pa.sel``.

This example also illustrates that, when faced with multiple possible
ways of breaking a word into syllables, Lexurgy will always put the
syllable breaks *as early as possible*. Notice that ``kamina`` could equally well
be broken up as ``kam.in.a``, since ``kam``, ``in``, and ``a`` are
all valid syllables. But breaking it up as ``ka.mi.na`` puts the
syllable breaks earlier.

Resyllabification
******************

Syllabification rules are automatically reapplied after every
named sound change. Take the example with codas again,
but this time let's add a sound change::

    Class consonant {p, t, k, s, m, n, l}
    Class vowel {a, e, i, o, u}
    Syllables:
        @consonant? @vowel {m, n, l}?
    drop-stop-after-nasal:
        {p, t, k} => * / {m, n} _

A word like ``kantu`` gets syllabified into ``kan.tu``, and then the
sound change deletes the ``t``, leaving ``kan.u``. But after the rule
finishes, the syllabification rule applies again, resulting in ``ka.nu``.

Changing Syllabification Rules
*******************************

However, sometimes sound changes affect the syllable structure. Let's
add a vowel-deletion change to the language with strictly open syllables::

    Class consonant {p, t, k, s, m, n, l}
    Class vowel {a, e, i, o, u}
    Syllables:
        @consonant? @vowel
    syncope:
        @vowel => * / $ <syl> @consonant _ @consonant

This rule deletes the vowel in the second syllable if it's
between two consonants. But if you try to apply it to a word like
``kamina``, you'll get an error; the new word, ``kamna``, now
has an illegal coda consonant!

To solve this, add a new syllable declaration after the syncope
rule::

    Class consonant {p, t, k, s, m, n, l}
    Class vowel {a, e, i, o, u}
    Syllables:
        @consonant? @vowel
    syncope:
        @vowel => * / $ <syl> @consonant _ @consonant
    Syllables:
        @consonant? @vowel @consonant?

Now the words ``kamina`` and ``ekipoa`` correctly become
``kam.na`` and ``ek.po.a``, with the syllabification adjusted
to the new structure.

You can also stop resyllabification completely with special
syllable declarations. This stops automatic resyllabification
but leaves any existing syllable breaks where they are::

    Syllables:
        explicit

This removes all syllable breaks::

    Syllables:
        clear

Syllable-Level Features
*************************

You can declare :ref:`features <sc-features>` and
:ref:`diacritics <sc-diacritics>` that operate on entire
syllables. Here's an example::

    Feature (syllable) +stress
    Diacritic ˈ (before) [+stress]
    Syllables:
        explicit
    stress-shift:
        {ɛ, ɔ}&[+stress] => {e, o}

The line ``Feature (syllable) +stress`` declares the ``stress``
feature to be a syllable-level feature. This feature needs a diacritic
to mark it, provided by the line ``Diacritic ˈ (before) [+stress]``.
The ``(before)`` modifier means that the diacritic must go before the
beginning of the syllable, which is where the IPA puts it. (The default
location is after the end of the syllable.)

If you pass in words like ``ˈkɛ.tɔ`` and ``kɛ.ˈtɔ``, which differ
only by stress location, the above changes will turn them into
``ˈke.tɔ`` and ``kɛ.ˈto``.

You can assign a syllable-level feature to a syllable in a rule by
changing any sound in the syllable (or the entire syllable) to a matrix
containing the feature. This rule assigns stress on the first syllable
by assigning it to the first sound::

    Feature (syllable) +stress
    Diacritic ˈ (before) [+stress]
    Syllables:
        explicit
    stress-first:
        [] => [+stress] / $ _

You can replace the last line with ``<syl> => [+stress] / $ _``,
applying the rule to the entire first syllable, and the result is the same.
Use whichever strategy works best for your case.

Syllable-Level Features in Syllabification Rules
*************************************************

You can also assign syllable-level features directly in
the syllabification rules. The following uses the syllabifier
to distinguish "heavy" syllables (with a long vowel or coda)
from "light" syllables (all others)::

    Feature (syllable) +heavy, +long
    Diacritic ² [+heavy]
    Diacritic ː (floating) [+long]
    Class consonant {p, t, k, s, m, n, l}
    Class vowel {a, e, i, o, u}

    Syllables:
        @consonant? {@vowel&[+long], @vowel @consonant} => [+heavy]
        @consonant? @vowel

The first line finds syllables that end in a long vowel or a vowel
and a consonant, and applies the ``+heavy`` feature (notated with
a ``²``). The second line says that consonant-vowel syllables
are also allowed, but these aren't ``+heavy``.
This syllabification rule turns ``kamina`` into ``ka.mi.na`` (because all its
syllables are light), but ``kaːtantu`` into ``kaː².tan².tu`` (because the
first two syllables are heavy).

Syllable-level features allow complex stress rules to be written compactly.
The following implements the rule "stress the third-last syllable if
the last two syllables are light, otherwise stress the second-last syllable"::

    Feature (syllable) +heavy, (syllable) +stress, +long
    Diacritic ² [+heavy]
    Diacritic ˈ (before) [+stress]
    Diacritic ː (floating) [+long]
    Class consonant {p, t, k, s, m, n, l}
    Class vowel {a, e, i, o, u}

    Syllables:
        @consonant? {@vowel&[+long], @vowel @consonant} => [+heavy]
        @consonant? @vowel

    assign-stress:
        <syl> => [+stress] / _ <syl>&[-heavy] <syl>&[-heavy] $
        Else:
        <syl> => [+stress] / _ <syl> $

This turns ``kamina`` into ``ˈka.mi.na``, stressing the first
syllable, but ``kaːtantu`` into ``kaː².ˈtan².tu``, stressing the second
syllable.
