Writing Sound Changes With Lexurgy SC
=====================================

This page is a tour through the features of Lexurgy SC.
For all the gory details, see :doc:`sc-dsl`.

As you read, be sure to try out each example in the
`Lexurgy SC web app <https://www.meamoria.com/lexurgy/app/sc>`_.

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

Comments
~~~~~~~~~

Any line that starts with # is a comment, and Lexurgy will ignore it.
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

    @unvcdstop => @vcdstop / @vowel _ @vowel

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

If you want to delete a sound entirely, put an asterisk in the output side::

    drop-final-vowel:
        {a, e, i, o, u} => * / _ $

Similarly, you can add epenthetic sounds by putting an asterisk on the input side
and specifying the environment where the sound should appear::

    spanish-e:
        * => e / _ s {p, t, k}

When using asterisks on the input side, be sure to specify a condition!
Not using a condition causes the sound to be inserted *everywhere*, turning
e.g. *scola* into *eseceoeleae* --- probably not what you want!

Exceptions
~~~~~~~~~~

Sometimes it's easier to say when a change *doesn't* occur than when it does. You can
specify exceptions to a rule using a double slash::

    final-vowel-loss:
        e => * / _ $ // {p, t, k} _

This rule drops a final [e], *except* after a voiceless stop.

Basican
~~~~~~~~

What you've seen so far is enough to understand the *Basican* example
in the web app. Load this example and watch it in action!

You can do a lot with just the basic structures, but they barely
scratch the surface of what Lexurgy offers.

Intermediate Structures
------------------------

Romanization
~~~~~~~~~~~~~

It's a good idea to do all the sound changes in phonetic notation (e.g. IPA).
But you probably do most of the work for your languages in their romanization systems.
You can define romanization rules at the beginning and end of any sound change applier,
but Lexurgy supports specific notation for it so your intention is clear.

Just define a special rule at the beginning with the name "Deromanizer"
and another rule at the end with the name "Romanizer". Like any rule, romanizers
and deromanizers can have both sequential subrules (separated by ``Then:``) and
simultaneous subrules.

Deromanizers and romanizers work just like ordinary rules, except that they don't support
filters or propagation.

.. TODO examples

.. _sc-intermediate-romanizers:

Intermediate romanizers
~~~~~~~~~~~~~~~~~~~~~~~

If you want to preserve the history of a language at several stages, you can
use intermediate romanizers. In intermediate romanizer is declared the same
way as the final romanizer, except they can go anywhere within the rule
portion of the file, and they must have a name like "Romanizer-middle" or
"Romanizer-post-classical" rather than just "Romanizer". An intermediate
romanizer will only see the changes declared before it, not those declared
after it (which haven't happened yet).

.. TODO examples

If the intermediate "romanizer" should just dump the phonetic form of each word,
you can use the special rule "unchanged"::

    Romanizer-phonetic:
        unchanged

    Romanizer:
        {tʃ, ʃ} => {ch, sh}

This will make Lexurgy produce both the phonetic form and the romanized form
of the final words.

For the command-line tool, you need to specify the :option:`-m` command-line argument
in order for intermediate romanizers to activate.

Multiple-Segment Rules
~~~~~~~~~~~~~~~~~~~~~~~

.. TODO different example without the more advanced features

A rule can affect a sequence of consecutive sounds at the same time. For example, this rule
applies nasal assimilation and voicing of the following sound at the same time::

    nasal-assimilation-and-voicing:
        [nasal] [cons $Place] => [$Place] [voiced]

The number of segments must be the same on each side of the ``=>``. If a change
adds or deletes sounds, fill in the missing spaces with the empty sound ``*``.
This is useful when dealing with :ref:`gemination <sc-gemination>`.

Simultaneous Expressions
~~~~~~~~~~~~~~~~~~~~~~~~~

.. TODO rewrite

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

Earlier subrules block later ones from changing the same part of the word.
This can be useful for making rules that do one thing in most cases,
and another thing in some exceptional case::

    k-shift:
        k => s / _ {e, i}
        k => h / $ _

Even though the two subrules execute simultaneously, the first rule
blocks the second from changing ``k`` to ``h`` before ``e`` and ``i``
(by changing it to ``s`` instead).

Compound Rules
~~~~~~~~~~~~~~~

.. TODO rewrite

If you put ``Then:`` between two subrules, then Lexurgy will apply them sequentially instead of
simultaneously, as if they were separate rules. For example, the palatalization rule from
:ref:`above <sc-three-stage-palatalization>` could be rewritten as::

    palatalization:
        k => tʃ / _ i
        Then: tʃ => ʃ
        Then: ʃ => s

This makes it clear that the three stages are really part of the same sound change.

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

Now, we can write a rule like this::

    final-vowel-raising:
        [-low -high] => [+high] / _ $

This rule says that any mid vowel (non-low, non-high) at
the end of a word becomes *the corresponding* high vowel:
[e] becomes [i], and [o] becomes [u]. The matrix ``[+high]``
on the output side of the rule means that the ``high``
feature, and *only* the ``high`` feature, will be changed
to ``+high``, while all other features (like the ``front``
and ``back`` features) are left unchanged.

Absent Features
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

Univalent Features
*******************

You can also define *univalent features*, which only
have *two* values: present and absent.

The following defines two univalent features::

    Feature +nasalized
    Feature +stress

This is just like defining binary features, except
for the plus sign before the feature name.

As with binary features, a sound that has the
``stress`` feature would have ``+stress`` in its
feature matrix. The *absence* of the ``stress``
feature can be written *either* ``-stress`` or
``*stress``; both mean the same thing. Any sound that
isn't explicitly declared to be ``+stress`` is
automatically ``*stress``.

Univalent features are convenient for suprasegmentals
like stress, because it would be annoying to have
to declare every single vowel to be ``[-stress]``.

Multivalued Features
*********************

Lexurgy differs from tools like
`Phonix <https://gitlab.com/jaspax/phonix/blob/master/README.md>`_
(and from distinctive feature theory) by allowing
features with any number of values. For example,
you can recreate the IPA consonant chart like this::

    Feature place(labial, alveolar, velar, glottal)
    Feature manner(stop, fricative, nasal, approximant)

    Symbol p [unvoiced labial stop]
    Symbol b [voiced labial stop]
    Symbol t [unvoiced alveolar stop]
    ...
    Symbol l [alveolar approximant]

Just like binary and univalent features, multivalued features always
have an *absent* value. In this example, we didn't specify a voicing for ``l``,
so it automatically has the absent value ``*voicing``.

Now you can write rules like this::

    intervocalic-lenition:
        [stop] => [voiced] / @vowel _ @vowel
        [voiced stop] => [fricative] / @vowel _ @vowel
        [unvoiced fricative] => h / @vowel _ @vowel

Feature Variables
******************

Languages often undergo *assimilation*, where one sound becomes more like a nearby sound.
Lexurgy helps in writing assimilation rules by allowing *feature variables*, which copy
a feature value from one sound to another.

For example, if you indicate the place of articulation of all your consonants with a
``place`` feature, the common *nasal assimilation* rule
can be written like this::

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

You can give the absent value of any multivalued feature a name. This declaration
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

.. _sc-diacritics:

Diacritics
~~~~~~~~~~

The IPA indicates some features explicitly using diacritics: [ʰ]
indicates aspiration, [ː] makes a vowel long, and [ ̥ ] makes a sound voiceless.

You can declare these in Lexurgy like this::

    Diacritic ʰ [aspirated]
    Diacritic ː [long]
    Diacritic ̥  [unvoiced]

If these diacritics appear in the old-language words or in rules, Lexurgy will
consider them to add the specified feature value to the previous sound, replacing
the existing value of that feature. For example, if
[p] is ``[unvoiced bilabial stop]``, then [pʰ] is ``[aspirated unvoiced bilabial stop]``;
if [n] is ``[voiced alveolar nasal]``, then [n̥] is ``[unvoiced alveolar nasal]``.

Diacritics also work when translating matrices back into symbols: if a rule produces
``[unvoiced alveolar nasal]``, and there's no symbol explicitly defined with that matrix,
Lexurgy will search through possible combinations of symbols and diacritics to find
one that fits the matrix, namely [n̥].

If you add ``(before)`` to a diacritic declaration (before or after the
matrix), it will go before the base symbol. For example, if you define
``Diacritic ⁿ (before) [prenasalized]`` (or ``Diacritic ⁿ [prenasalized] (before)``),
then the prenasalized version of [d] will show up as ``ⁿd`` rather than ``dⁿ``.

Diacritics can even be applied to symbols that aren't declared with feature
matrices, in which case you can change the diacritics using matrix rules but
not the base symbol. For example, suppose you define a vowel length feature
with ``Feature Length(*short, long)`` and a long diacritic
with ``Diacritic ː [long]``, but no other features or symbols. Then
this rule will still turn the sequence [ar] into [aː]::

    a-before-r:
        a r => [long] *

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

    Diacritic ˈ (floating) [stressed]
    Diacritic ́  (floating) [hightone]

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

.. TODO Work in the word "intersection".

If you want to limit a rule to segments that have several different properties,
you can join the properties with ``&``. This is useful when mixing sound classes
with features::

    unstressed-final-vowel-loss:
        @vowel&[unstressed] => * / _ $ // {p, t, k} _

If an :ref:`alternative list <sc-alternative-lists>` is the *first* element
joined by ``&``, then it can match up with an alternative list of the same length
on the new side of the rule. For example::

    unstressed-vowel-centralizing:
        {e, i, o, u}&[unstressed] => {ə, ɨ, ə, ɨ}

Optional and Repeated Segments
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

You can mark part of the environment *optional* by putting a question mark after it::

    stress-closed-last-syllable:
        [vowel] => [stressed] / _ [glide]? [consonant] $

This rule will stress the vowel in a final closed syllable, even if there's an
offglide like [j] or [w] after the vowel.

If the language has a more complex syllable structure though, this won't be enough;
it won't match a word like [krajsk]. To deal with that case, you can use a *repeated*
segment::

    stress-closed-last-syllable:
        [vowel] => [stressed] / _ [glide]? [consonant]+ $

The ``+`` indicates that we want *at least one* consonant at the end of the word.

If the repeated segment is also optional (i.e. the rule should accept zero or more
copies of the segment), you can use ``*`` instead of ``+``. For example, this
rule will stress the vowel in the last syllable regardless of whether there are
any consonants at the end::

    stress-last-syllable:
        [vowel] => [stressed] / _ [glide]? [consonant]* $

Advanced Structures
--------------------

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

    @stop @stop$1 => $1 $1

This rule applies metathesis to stop-fricative sequences::

    @fricative$1 @stop$2 => $2 $1

This rule uses a capture variable in the environment to *recognize* a geminate::

    * => e / _ [cons]$1 $1

This rule uses a bare capture variable on the old side of the rule to remove gemination
(*degemination*)::

    [cons]$1 $1 => $1 *

Negation
~~~~~~~~~

You can negate some types of rule elements --- match only segments that *don't* fit
the element --- by preceding the element with ``!``, as with matrix features.

Currently you can do this with literal text (``!r`` matches anything but the sound [r]),
classes (``!@vowel`` matches anything not in the ``vowel`` class), and capture references
(``!$1`` matches anything except what was captured in the ``$1`` variable).

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

    stress-first-syllable:
        [vowel] => [stressed] / $ [cons]* _

But any consonants before the vowel are actually irrelevant to this rule, so the
``[cons]*`` in the environment is a distraction. Instead, you can write it like this::

    stress-first-syllable [vowel]:
        [] => [stressed] / $ _

Note that we can use ``[]`` on the old side instead of ``[vowel]`` because anything
that passes the filter will already be a vowel, so we don't need to test for vowelhood
again.

Similarly, a short-distance vowel harmony rule could be written like this::

    vowel-harmony [vowel]:
        [!central] => [$Frontness] / [!central $Frontness] _

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
        [!central] => [$Frontness] / [!central $Frontness] _

Note that it's impossible to tell in general whether a propagating rule will ever
terminate. So Lexurgy is conservative and stops with an error message if a
rule runs a hundred times without settling on a result.

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

.. warning::

    The ``$$`` feature is experimental. This simple rule works,
    but anything more complicated, like trying to put conditions
    on affixation or writing *sandhi* rules, likely won't work
    correctly. Future versions of Lexurgy will have better support
    for this!
