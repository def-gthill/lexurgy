The Lexurgy SC Rules Format
===========================

Basics
------

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

.. _sc-three-stage-palatalization:

Any line that starts with # is a comment, and Lexurgy will ignore it::

    # These rules palatalize k to s in three steps.
    palatalization-1:
        k => tʃ / _ i
    palatalization-2:
        # This is unconditional!
        tʃ => ʃ
    palatalization-3:
        ʃ => s

.. note::

    The following characters mean something special to Lexurgy::

        \ , = > ( ) [ ] { } * + ? / - _ : ! $ @ # &

    If you need to use one of these characters as part of a rule
    (e.g. you're working with a click language and want to use ``!``),
    you have to put a backslash (``\``) in front of it. For example::

        click-loss:
            \! => t

    This works anywhere you could use IPA: in rules, in symbol definitions,
    in class definitions, etc.

.. note::

    Indentation is insignificant; these examples are indented purely for readability.
    This works equally well::

        k-before-a:
        k => ʃ / _ a

    Lexurgy knows where one rule ends and another begins because the rule name must end
    with a colon and the rule expressions must contain an arrow ``=>``.

.. _sc-symbols:

Symbols
~~~~~~~~

If you want to use digraphs in your rules, you can declare *symbols*::

    Symbol ts, dz

Then rules that affect *t* or *s* will ignore them if they're part of a *ts*,
and similarly with *dz*.

.. _sc-alternative-lists:

Alternative Lists
~~~~~~~~~~~~~~~~~

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

Alternative Environments
~~~~~~~~~~~~~~~~~~~~~~~~

The alternative list mechanism can be used not just for sounds, but for entire environments.
For example, this rule converts stops into fricatives both between vowels and before other
stops::

    frication:
        {p, t, k} => {f, θ, x} / {{a, e, i, o, u} _ {a, e, i, o, u}, _ {p, t, k}}

Word Boundaries
~~~~~~~~~~~~~~~

You can specify that a rule only applies at the beginning or end of a word by marking the
word boundary with a $::

    aspirate-initial-stop:
        {p, t, k} => {pʰ, tʰ, kʰ} / $ _
    final-vowel-to-schwa:
        {a, e, i, o, u} => ə / _ $

The first applies only at the beginning of a word, the second at the end of a word.

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

Empty Sounds
~~~~~~~~~~~~

If you want to delete a sound entirely, put an asterisk in place of the new sound::

    drop-final-vowel:
        {a, e, i, o, u} => * / _ $

Similarly, you can add epenthetic sounds by putting an asterisk before the change arrow
and specifying the environment where the sound should appear::

    spanish-e:
        * => e / _ s {p, t, k}

.. _sc-exclusions:

Exclusions
~~~~~~~~~~

Sometimes it's easier to say when a change *doesn't* occur than when it does. You can
specify exceptions to a rule using a double slash::

    i-before-e-except-after-c:
        * => i / _ e // c _



Compound Rules
--------------

You can put several rules under one rule name. This helps keep the file organized, grouping
related changes together.

Simultaneous Subrules
~~~~~~~~~~~~~~~~~~~~~

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

Sequential Subrules
~~~~~~~~~~~~~~~~~~~

If you put ``Then:`` between two subrules, then Lexurgy will apply them sequentially instead of
simultaneously, as if they were separate rules. For example, the palatalization rule from
:ref:`above <sc-three-stage-palatalization>` could be rewritten as::

    palatalization:
        k => tʃ / _ i
        Then: tʃ => ʃ
        Then: ʃ => s

This makes it clear that the three stages are really part of the same sound change.

Sound Classes
-------------

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

Lexurgy's sound classes should be familiar to users of Rosenfelder's SCA.

Feature Matrices
----------------

Another, more flexible way of generalizing rules is to define each sound as a
matrix of feature values. This is inspired by distinctive feature theory (via Bangs's Phonix),
but the syntax is designed for practical conlanging rather than theoretical soundness.
In addition, not every sound needs to be defined with features, so you can freely
mix feature matrices with sound classes and plain text in your rules.

You can define features like this::

    Feature Voicing(unvoiced, voiced)
    Feature Nasality(nonnasal, nasal)

In this example, ``Voicing`` and ``Nasality`` are *features*, while
``unvoiced`` and ``voiced`` are the *values* that the ``Voicing`` feature
can take.

In terms of distinctive feature theory, the ``voiced`` value is +voiced, the ``unvoiced``
value is -voiced, and an absence of the ``Voicing`` feature (written ``*Voicing``) is
\*voiced.

But features can have any number of values. It might be more convenient to
just recreate the IPA chart::

    Feature Place(labial, alveolar, velar, glottal)
    Feature Manner(stop, fricative, nasal, approximant)

Feature names must start with an uppercase letter, while feature values
must be all lowercase.

Once you've defined features, you can define :ref:`symbols <sc-symbols>`
in terms of *matrices* of features::

    Symbol p [unvoiced labial stop]
    Symbol b [voiced labial stop]
    Symbol t [unvoiced alveolar stop]
    ...
    Symbol l [alveolar approximant]

Each symbol must have a distinct matrix --- you can't define both [p] and [b] as just ``[labial stop]``.
Note that we didn't specify a voicing for ``l``, so it automatically has the value
``*Voicing``, i.e. it lacks the voicing feature entirely.

Usually it's best to use IPA for symbols, but you can define whatever symbols
you like if it suits your language.

Now you can use feature values in your rules::

    intervocalic-lenition:
        [stop] => [voiced] / @vowel _ @vowel
        [voiced stop] => [fricative] / @vowel _ @vowel
        [unvoiced fricative] => h / @vowel _ @vowel

The matrices to the left match any symbol with that feature, even if it has other
features too; so ``[stop]`` matches the ``[unvoiced labial stop]`` of a [p],
the ``[voiced alveolar stop]`` of a [d], etc. If you only want to accept
symbols that lack a given feature, you have to explicitly specify the absent
feature; e.g. ``[alveolar *Voicing]`` only matches alveolar sounds that lack
the voicing feature.

The matrices to the right indicate how the feature matrix should be modified.
Features not mentioned in the matrix are left unchanged. For example,
the second rule turns [d] ``[voiced alveolar stop]`` into [ð]
``[voiced alveolar fricative]``, changing the ``Manner`` feature from
``[stop]`` to ``[fricative]`` while leaving ``[voiced alveolar]`` unchanged.
If you want to delete a feature, you have to specify the absent feature
explicitly (e.g. ``[*Voicing]`` to delete ``voiced`` or ``unvoiced``
from the matrix).

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


Feature Variables
~~~~~~~~~~~~~~~~~

Languages often undergo *assimilation*, where one sound becomes more like a nearby sound.
Lexurgy helps in writing assimilation rules by allowing *feature variables*, which copy
a feature value from one sound to another.

For example, if you indicate the place of articulation of all your consonants with a
``Place`` feature, the common *nasal assimilation* rule
can be written like this::

    [nasal] => [$Place] / _ [cons $Place]

The ``[cons $Place]`` matrix in the environment matches any consonant, but captures the
value of that consonant's ``Place`` feature. This feature value is copied into the matching
``$Place`` in the output matrix. So a nasal before a [p] would have the matrix [labial]
applied to it and become an [m], a nasal before a [d] would have the matrix [alveolar]
applied and become an [n], etc.

Absent Features and Absent Aliases
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

As mentioned previously, every feature automatically has an extra value indicating that
the feature is *absent* from a sound, and every sound has the absent feature unless
you specify a value.

It can make rules clearer to give the absent feature an explicit name using an *absent alias*::

    Feature Stress(*unstressed, primary, secondary)

The value marked by an asterisk is the absent alias; now all sounds that don't have an
explicit stress will be ``unstressed``.

Negated Features
~~~~~~~~~~~~~~~~

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
~~~~~~~~~~~~~~~~~~~

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
------------------

If you want to limit a rule to segments that have several different properties,
you can join the properties with ``&``. This is useful, for example, if you want
something to happen to sounds that fall into a sound class *and* have a specific
feature::

    unstressed-final-vowel-loss:
        @vowel&[unstressed] => * / _ $ // {p, t, k} _

Note that this rule couldn't be written with a :ref:`filter <sc-filters>` of
``@vowel`` because the filter would also remove any /p/, /t/, or /k/, meaning
the exclusion wouldn't work.

If an :ref:`alternative list <sc-alternative-lists>` is the *first* element
joined by ``&``, then it can match up with an alternative list of the same length
on the new side of the rule. For example::

    unstressed-vowel-centralizing:
        {e, i, o, u}&[unstressed] => {ə, ɨ, ə, ɨ}

Multiple-Segment Rules
------------------------

A rule can affect a sequence of consecutive sounds at the same time. For example, this rule
applies nasal assimilation and voicing of the following sound at the same time::

    nasal-assimilation-and-voicing:
        [nasal] [cons $Place] => [$Place] [voiced]

The number of segments must be the same on each side of the ``=>``. If a change
adds or deletes sounds, fill in the missing spaces with the empty sound ``*``.
This is useful when dealing with :ref:`gemination <sc-gemination>`.

Optional and Repeated Segments
------------------------------

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

Optional and repeated segments can also be used in :ref:`exclusions <sc-exclusions>`.

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

.. _sc-gemination:

Gemination and Metathesis
-------------------------

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
---------

You can negate some types of rule elements --- match only segments that *don't* fit
the element --- by preceding the element with ``!``, as with matrix features.

Currently you can do this with literal text (``!r`` matches anything but the sound [r]),
classes (``!@vowel`` matches anything not in the ``vowel`` class), and capture references
(``!$1`` matches anything except what was captured in the ``$1`` variable).

.. _sc-filters:

Rule Filters
------------

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
-----------

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

Romanization
------------

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

Interactions Between Words
---------------------------

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
~~~~~~~~~~~

When creating a language diachronically, you may want to
simulate how grammatical particles turn into affixes. This
means you need the words to be treated as separate *before*
the affixation, but as one word after.

You do this with a rule that destroys the space between words, which is
represented by ``$$``::

    glomination:
        $$ => *
