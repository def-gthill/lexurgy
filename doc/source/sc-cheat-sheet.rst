Lexurgy SC Cheat Sheet
=======================

This is a quick reference for the syntax available in Lexurgy SC.
Each of these examples is runnable: you should be able to put the contents of the
Example column into the Sound Changes box and the input words from the Effect
column (to the left of the arrows) into the Input Words box, and get the results
shown in the Effect column.

For a gentler introduction, see the :doc:`Tutorial <sc-tutorial>`.

Basics
-------

+-----------------------+---------------------------+---------------------------------------+---------------------------+
| Structure             | Meaning                   | Example                               | Effect                    |
+=======================+===========================+=======================================+===========================+
| Comment               | Ignored by Lexurgy. Use   | ::                                    |                           |
|                       | them to remind yourself   |                                       |                           |
|                       | what a rule is for.       |   # This is ignored                   |                           |
+-----------------------+---------------------------+---------------------------------------+---------------------------+
| Simple change         | Change sounds to the left | ::                                    | ::                        |
|                       | of the arrow into sounds  |                                       |                           |
|                       | to the right of the       |   rule:                               |   bad    => bid           |
|                       | arrow.                    |     a => i                            |   banana => binini        |
+-----------------------+---------------------------+---------------------------------------+---------------------------+
| Condition             | Change sounds *only* when | ::                                    | ::                        |
|                       | certain other sounds are  |                                       |                           |
|                       | nearby.                   |   rule:                               |   bad       => bid        |
|                       |                           |     a => i / b _ d                    |   bananabad => bananabid  |
+-----------------------+---------------------------+---------------------------------------+---------------------------+
| Exception             | Change sounds *except*    | ::                                    | ::                        |
|                       | when certain other sounds |                                       |                           |
|                       | are nearby.               |   rule:                               |   bad       => bad        |
|                       |                           |     a => i // b _ d                   |   bananabad => bininibad  |
+-----------------------+---------------------------+---------------------------------------+---------------------------+
| Condition and         | You can use conditions    | ::                                    | ::                        |
| exception             | and exceptions together   |                                       |                           |
|                       | to create complex         |   rule:                               |   banana => binana        |
|                       | restrictions on changes.  |     a => i / b _ // _ d               |   badaba => badabi        |
+-----------------------+---------------------------+---------------------------------------+---------------------------+
| Word boundary (start) | Change sounds only at     | ::                                    | ::                        |
|                       | the beginning of a word.  |                                       |                           |
|                       |                           |   rule:                               |   abanana => ibanana      |
|                       |                           |     a => i / $ _                      |   abada   => ibada        |
+-----------------------+---------------------------+---------------------------------------+---------------------------+
| Word boundary (end)   | Change sounds only at     | ::                                    | ::                        |
|                       | the end of a word.        |                                       |                           |
|                       |                           |   rule:                               |   abanana => abanani      |
|                       |                           |     a => i / _ $                      |   abada   => abadi        |
+-----------------------+---------------------------+---------------------------------------+---------------------------+
| Insertion             | Add sounds between        | ::                                    | ::                        |
|                       | certain other sounds.     |                                       |                           |
|                       |                           |   rule:                               |   bdana  => bidana        |
|                       |                           |     * => i / b _ d                    |   ababda => ababida       |
+-----------------------+---------------------------+---------------------------------------+---------------------------+
| Deletion              | Delete sounds.            | ::                                    | ::                        |
|                       |                           |                                       |                           |
|                       |                           |   rule:                               |   banina => bnin          |
|                       |                           |     a => *                            |   badai  => bdi           |
+-----------------------+---------------------------+---------------------------------------+---------------------------+
| Alternatives          | Change each of the sounds | ::                                    | ::                        |
|                       | on the left into the      |                                       |                           |
|                       | sound on the right.       |   rule:                               |   banana => xanana        |
|                       |                           |     {b, d} => x                       |   abdab  => axxax         |
+-----------------------+---------------------------+---------------------------------------+---------------------------+
| Alternatives          | Change each of the sounds | ::                                    | ::                        |
| (corresponding)       | on the left into the      |                                       |                           |
|                       | *corresponding* sound     |   rule:                               |   banana => xanana        |
|                       | on the right.             |     {b, d} => {x, j}                  |   abdab  => axjax         |
+-----------------------+---------------------------+---------------------------------------+---------------------------+
| Alternative           | Apply the change when     | ::                                    | ::                        |
| environments          | nearby sounds match       |                                       |                           |
|                       | *any* of the conditions.  |   rule:                               |   banana => banina        |
|                       |                           |     a => i / {b _ d, n _ n}           |   badaba => bidaba        |
+-----------------------+---------------------------+---------------------------------------+---------------------------+
| Sound class           | Define a list of sounds   | ::                                    | ::                        |
|                       | that tend to behave       |                                       |                           |
|                       | similarly.                |   Class stop {b, d}                   |   banana => xanana        |
|                       |                           |   rule:                               |   abdab  => axxax         |
|                       |                           |     @stop => x                        |                           |
+-----------------------+---------------------------+---------------------------------------+---------------------------+
| Sound class           | Change one sound class    | ::                                    | ::                        |
| (corresponding)       | to another; each sound    |                                       |                           |
|                       | in the left class turns   |   Class stop {b, d}                   |   banana => vanana        |
|                       | into the corresponding    |   Class fricative {v, z}              |   abdab  => avzav         |
|                       | sound in the right class. |   rule:                               |                           |
|                       |                           |     @stop => @fricative               |                           |
+-----------------------+---------------------------+---------------------------------------+---------------------------+
| Wildcard              | Matches any single sound. | ::                                    | ::                        |
|                       |                           |                                       |                           |
|                       |                           |   rule:                               |   bad       => xxx        |
|                       |                           |     [] => x                           |   bananabad => xxxxxxxxx  |
+-----------------------+---------------------------+---------------------------------------+---------------------------+
| Digraph               | Define a multi-character  | ::                                    | ::                        |
|                       | symbol that should be     |                                       |                           |
|                       | treated as one sound.     |   Symbol ts, dz                       |   badadz => baladz        |
|                       |                           |   rule:                               |   tsatat => tsalal        |
|                       |                           |     {t, d} => l                       |                           |
+-----------------------+---------------------------+---------------------------------------+---------------------------+
| Escape                | Use a backslash to treat  | ::                                    | ::                        |
|                       | a character as a sound    |                                       |                           |
|                       | rather than part of the   |   rule:                               |   ba*a*a => ba@a@a        |
|                       | syntax.                   |     \* => \@                          |                           |
+-----------------------+---------------------------+---------------------------------------+---------------------------+

Combining Elements
-------------------

+-----------------------+---------------------------+---------------------------------------+---------------------------+
| Structure             | Meaning                   | Example                               | Effect                    |
+=======================+===========================+=======================================+===========================+
| Sequence              | Change several            | ::                                    | ::                        |
|                       | consecutive sounds at     |                                       |                           |
|                       | once.                     |   rule:                               |   banana => inana         |
|                       |                           |     {b, d} a => * i                   |   abdab  => abib          |
+-----------------------+---------------------------+---------------------------------------+---------------------------+
| Optional element      | The rule applies whether  | ::                                    | ::                        |
|                       | the optional element      |                                       |                           |
|                       | is present or not.        |   rule:                               |   banana => binana        |
|                       |                           |     a => i / b d? _                   |   abdab  => abdib         |
+-----------------------+---------------------------+---------------------------------------+---------------------------+
| Grouping              | Use parentheses to group  | ::                                    | ::                        |
|                       | elements together, so     |                                       |                           |
|                       | that other syntax applies |   rule:                               |   aab   => aib            |
|                       | to the group as a whole.  |     a => i / a (b d)? _               |   abab  => abab           |
|                       |                           |                                       |   abdab => abdib          |
+-----------------------+---------------------------+---------------------------------------+---------------------------+
| Repeated element      | Matches any number of     | ::                                    | ::                        |
| (any number)          | copies of the specified   |                                       |                           |
|                       | element.                  |   rule:                               |   ba       => va          |
|                       |                           |     b => v / _ (an)* a $              |   bana     => vana        |
|                       |                           |                                       |   banana   => vanana      |
|                       |                           |                                       |   bananana => vananana    |
+-----------------------+---------------------------+---------------------------------------+---------------------------+
| Repeated element      | Matches one or more       | ::                                    | ::                        |
| (one or more)         | copies of the specified   |                                       |                           |
|                       | element.                  |   rule:                               |   ba       => ba          |
|                       |                           |     b => v / _ (an)+ a $              |   bana     => vana        |
|                       |                           |                                       |   banana   => vanana      |
|                       |                           |                                       |   bananana => vananana    |
+-----------------------+---------------------------+---------------------------------------+---------------------------+
| Repeated element      | Matches a specific exact  | ::                                    | ::                        |
| (exact count)         | number of copies of the   |                                       |                           |
|                       | specified element.        |   rule:                               |   ba       => ba          |
|                       |                           |     b => v / _ (an)*2 a $             |   bana     => bana        |
|                       |                           |                                       |   banana   => vanana      |
|                       |                           |                                       |   bananana => bananana    |
+-----------------------+---------------------------+---------------------------------------+---------------------------+
| Repeated element      | Matches any number of     | ::                                    | ::                        |
| (range)               | copies of the             |                                       |                           |
|                       | specified element, within |   rule:                               |   ba       => ba          |
|                       | a given range.            |     b => v / _ (an)*(1-2) a $         |   bana     => vana        |
|                       |                           |                                       |   banana   => vanana      |
|                       |                           |                                       |   bananana => bananana    |
+-----------------------+---------------------------+---------------------------------------+---------------------------+
| Repeated element      | Matches any number of     | ::                                    | ::                        |
| (upper bound)         | copies of the             |                                       |                           |
|                       | specified element, up     |   rule:                               |   ba       => va          |
|                       | to the given limit.       |     b => v / _ (an)*(-2) a $          |   bana     => vana        |
|                       |                           |                                       |   banana   => vanana      |
|                       |                           |                                       |   bananana => bananana    |
+-----------------------+---------------------------+---------------------------------------+---------------------------+
| Repeated element      | Matches at least this     | ::                                    | ::                        |
| (lower bound)         | many copies of the        |                                       |                           |
|                       | specified element.        |   rule:                               |   ba       => ba          |
|                       |                           |     b => v / _ (an)*(2-) a $          |   bana     => bana        |
|                       |                           |                                       |   banana   => vanana      |
|                       |                           |                                       |   bananana => vananana    |
+-----------------------+---------------------------+---------------------------------------+---------------------------+
| Capture               | Remember the sounds that  | ::                                    | ::                        |
|                       | an element matched and    |                                       |                           |
|                       | refer to them later.      |   rule:                               |   abbanna => abanna       |
|                       |                           |     {b, d}$1 => * / _ $1              |   abdadda => abdada       |
+-----------------------+---------------------------+---------------------------------------+---------------------------+
| Negation              | Matches anything *but*    | ::                                    | ::                        |
|                       | the specified element.    |                                       |                           |
|                       |                           |   rule:                               |   banana => xaxaxa        |
|                       |                           |     !a => x                           |   abdab  => axxax         |
+-----------------------+---------------------------+---------------------------------------+---------------------------+
| Intersection          | Sounds must match both    | ::                                    | ::                        |
|                       | criteria at the same      |                                       |                           |
|                       | time.                     |   Class stop {t, d, k, g}             |   bataka => baraka        |
|                       |                           |   Class alveolar {t, d, s, z}         |   tasada => tasara        |
|                       |                           |   rule:                               |                           |
|                       |                           |     @stop&@alveolar => r / a _ a      |                           |
+-----------------------+---------------------------+---------------------------------------+---------------------------+
| Negated Intersection  | Sounds must match the     | ::                                    | ::                        |
|                       | first element but *not*   |                                       |                           |
|                       | the second element.       |   Class stop {t, d, k, g}             |   bataka => batara        |
|                       |                           |   Class alveolar {t, d, s, z}         |   tagasa => tarasa        |
|                       |                           |   rule:                               |                           |
|                       |                           |     @stop&!@alveolar => r / a _ a     |                           |
+-----------------------+---------------------------+---------------------------------------+---------------------------+
| Dummy rule            | Does nothing. Use this    | ::                                    | ::                        |
|                       | if you need a rule        |                                       |                           |
|                       | for other reasons but     |   rule:                               |   banana => banana        |
|                       | don't want it to change   |     unchanged                         |   abdab  => abdab         |
|                       | anything.                 |                                       |                           |
+-----------------------+---------------------------+---------------------------------------+---------------------------+
| Multiple words        | Spaces between words are  | ::                                    | ::                        |
|                       | treated as boundaries:    |                                       |                           |
|                       | ``$`` matches them, and   |   rule:                               |   ratatat  => rasasa      |
|                       | they break adjacency      |     t => * / _ $                      |   rat atat => ra asa      |
|                       |                           |     t => s / _ a                      |                           |
+-----------------------+---------------------------+---------------------------------------+---------------------------+
| Between words         | Matches the space between | ::                                    | ::                        |
|                       | words                     |                                       |                           |
|                       |                           |   rule:                               |   rat atat  => ratatat    |
|                       |                           |     $$ => * / _ a                     |   ran tanta => ran danta  |
|                       |                           |     t => d / n $$ _                   |                           |
+-----------------------+---------------------------+---------------------------------------+---------------------------+

Features
---------

The examples in this section all require the following declarations::

    Feature low, high, front, back
    Feature voicing(unvoiced, voiced)
    Feature place(labial, alveolar, velar)
    Feature manner(stop, fricative, nasal)
    Symbol a [+low -high -front -back]
    Symbol e [-low -high +front -back]
    Symbol i [-low +high +front -back]
    Symbol o [-low -high -front +back]
    Symbol u [-low +high -front +back]
    Symbol p [unvoiced labial stop]
    Symbol b [voiced labial stop]
    Symbol t [unvoiced alveolar stop]
    Symbol d [voiced alveolar stop]
    Symbol k [unvoiced velar stop]
    Symbol g [voiced velar stop]
    Symbol f [unvoiced labial fricative]
    Symbol v [voiced labial fricative]
    Symbol s [unvoiced alveolar fricative]
    Symbol z [voiced alveolar fricative]
    Symbol m [labial nasal]
    Symbol n [alveolar nasal]

Then put any additional declarations in the appropriate sections. Remember
that all the feature declarations must come first, then all the symbol and
diacritic declarations, then the rules.

+-----------------------+---------------------------+-----------------------------------------------+---------------------------+
| Structure             | Meaning                   | Example                                       | Effect                    |
+=======================+===========================+===============================================+===========================+
| Binary feature        | These features can either | ::                                            | ::                        |
|                       | be plus (``+``) or minus  |                                               |                           |
|                       | (``-``).                  |   rule:                                       |   benene => beneni        |
|                       |                           |     [-low -high] => [+high] / _ $             |   bonono => bononu        |
+-----------------------+---------------------------+-----------------------------------------------+---------------------------+
| Multivalent feature   | These features can have   | ::                                            | ::                        |
|                       | multiple values, each     |                                               |                           |
|                       | with a distinct name.     |   rule:                                       |   bememe => denene        |
|                       |                           |     [labial] => [alveolar]                    |   pofofo => tososo        |
|                       |                           |                                               |                           |
+-----------------------+---------------------------+-----------------------------------------------+---------------------------+
| Absent value          | If a feature isn't        | ::                                            | ::                        |
|                       | mentioned in a symbol     |                                               |                           |
|                       | declaration, it's         |   rule:                                       |   benene => binini        |
|                       | automatically absent      |     [*place] => i                             |   dofofo => dififi        |
|                       | (``*``).                  |                                               |                           |
+-----------------------+---------------------------+-----------------------------------------------+---------------------------+
| Univalent feature     | These features are minus  | ::                                            | ::                        |
|                       | by default.               |                                               |                           |
|                       |                           |   Feature +lateral                            |   benene => bexexe        |
|                       |                           |   Symbol l [alveolar +lateral]                |   dololo => xololo        |
|                       |                           |   rule:                                       |                           |
|                       |                           |     [alveolar -lateral] => x                  |                           |
+-----------------------+---------------------------+-----------------------------------------------+---------------------------+
| Feature variable      | Copy a feature value from | ::                                            | ::                        |
|                       | one sound to another.     |                                               |                           |
|                       |                           |   rule:                                       |   abtadka => aptatka      |
|                       |                           |     [stop] => [$voicing] / _ [stop $voicing]  |   akdak   => agdak        |
+-----------------------+---------------------------+-----------------------------------------------+---------------------------+
| Negated value         | Match only sounds that    | ::                                            | ::                        |
|                       | *don't* have a specific   |                                               |                           |
|                       | feature value.            |   rule:                                       |   benene => biiiii        |
|                       |                           |     [!labial] => i                            |   dofofo => iififi        |
+-----------------------+---------------------------+-----------------------------------------------+---------------------------+
| Diacritic             | Add features to a sound   | ::                                            | ::                        |
|                       | by putting a modifier     |                                               |                           |
|                       | character after it.       |   Feature +ejective                           |   appakka => ap'ak'a      |
|                       |                           |   Diacritic ' [+ejective]                     |   attakta => at'akta      |
|                       |                           |   rule:                                       |                           |
|                       |                           |     [unvoiced stop]$1 $1 => [+ejective] *     |                           |
+-----------------------+---------------------------+-----------------------------------------------+---------------------------+
| Diacritic (before)    | This diacritic is written | ::                                            | ::                        |
|                       | before the sound it       |                                               |                           |
|                       | modifies.                 |   Feature +ejective                           |   appakka => a'pa'ka      |
|                       |                           |   Diacritic ' (before) [+ejective]            |   attakta => a'takta      |
|                       |                           |   rule:                                       |                           |
|                       |                           |     [unvoiced stop]$1 $1 => [+ejective] *     |                           |
+-----------------------+---------------------------+-----------------------------------------------+---------------------------+
| Diacritic (first)     | This diacritic is written | ::                                            | ::                        |
|                       | after the first character |                                               |                           |
|                       | of the sound it modifies. |   Feature +hightone                           |   pataida => pa'ta'ida    |
|                       |                           |   Diacritic ' (first) [+hightone]             |   badaita => badaita'     |
|                       |                           |   Symbol ai [+low +high +front -back]         |                           |
|                       |                           |   rule:                                       |                           |
|                       |                           |     [+low] => [+hightone] / [unvoiced stop] _ |                           |
+-----------------------+---------------------------+-----------------------------------------------+---------------------------+
| Floating diacritic    | Sounds and classes        | ::                                            | ::                        |
|                       | without the diacritic     |                                               |                           |
|                       | match sounds with it.     |   Feature +hightone                           |   be'ne'ne' => bi'ni'ni'  |
|                       |                           |   Diacritic ' (floating) [+hightone]          |   bununu    => bonono     |
|                       |                           |   rule:                                       |                           |
|                       |                           |     {u, e} => {o, i}                          |                           |
+-----------------------+---------------------------+-----------------------------------------------+---------------------------+
| Exact match           | This sound must match     | ::                                            | ::                        |
|                       | exactly, including        |                                               |                           |
|                       | floating diacritics.      |   Feature +hightone                           |   be'ne'ne' => be'ne'ne'  |
|                       |                           |   Diacritic ' (floating) [+hightone]          |   bununu    => bonono     |
|                       |                           |   rule:                                       |                           |
|                       |                           |     {u!, e!} => {o, i}                        |                           |
+-----------------------+---------------------------+-----------------------------------------------+---------------------------+
| Inexact capture       | Match a captured sound,   | ::                                            | ::                        |
|                       | even if it has different  |                                               |                           |
|                       | floating diacritics       |   Feature +hightone                           |   be'eneu' => be'ineu'    |
|                       |                           |   Diacritic ' (floating) [+hightone]          |   buunu'e' => buonu'e'    |
|                       |                           |   rule:                                       |                           |
|                       |                           |     {u, e}$1 => {o, i} / ~$1 _                |                           |
+-----------------------+---------------------------+-----------------------------------------------+---------------------------+
| Named absent value    | Use the specified name    | ::                                            | ::                        |
|                       | to refer to the absent    |                                               |                           |
|                       | value instead of the      |   Feature tone(*lowtone, hightone)            |   bene'ne  => bine'ni     |
|                       | ``*`` syntax.             |   Diacritic ' [hightone]                      |   bo'nono' => bo'nuno'    |
|                       |                           |   rule:                                       |                           |
|                       |                           |     [-low -high lowtone] => [+high]           |                           |
+-----------------------+---------------------------+-----------------------------------------------+---------------------------+

Blocks
-------

+-----------------------+---------------------------+---------------------------------------+---------------------------+
| Structure             | Meaning                   | Example                               | Effect                    |
+=======================+===========================+=======================================+===========================+
| Simultaneous          | Apply several changes,    | ::                                    | ::                        |
| expression            | finding all possible      |                                       |                           |
|                       | application sites         |   rule:                               |   bad       => vid        |
|                       | simultaneously.           |     a => i / b _ d                    |   banana    => vanana     |
|                       |                           |     b => v / _ a                      |   bananabad => vananavid  |
+-----------------------+---------------------------+---------------------------------------+---------------------------+
| Simultaneous          | Earlier expressions       | ::                                    | ::                        |
| expression            | take precedence over      |                                       |                           |
| (precedence)          | later ones if they        |   rule:                               |   bad       => bid        |
|                       | conflict.                 |     a => i / b _ d                    |   banana    => bununu     |
|                       |                           |     a => u                            |   bananabad => bununubid  |
+-----------------------+---------------------------+---------------------------------------+---------------------------+
| Sequential block      | Apply several changes,    | ::                                    | ::                        |
|                       | one after the other.      |                                       |                           |
|                       |                           |   rule:                               |   bad       => bid        |
|                       |                           |     a => i / b _ d                    |   banana    => vanana     |
|                       |                           |     Then: b => v / _ a                |   bananabad => vananabid  |
+-----------------------+---------------------------+---------------------------------------+---------------------------+
| Hierarchical block    | Apply later expressions   | ::                                    | ::                        |
|                       | only if earlier ones      |                                       |                           |
|                       | fail to change anything.  |   rule:                               |   bad       => bid        |
|                       |                           |     a => i / b _ d                    |   banana    => vanana     |
|                       |                           |     Else: b => v / _ a                |   bananabad => bananabid  |
+-----------------------+---------------------------+---------------------------------------+---------------------------+
| Propagating rule      | Apply the rule repeatedly | ::                                    | ::                        |
|                       | until the word stops      |                                       |                           |
|                       | changing.                 |   rule propagate:                     |   aitaaita => etaeta      |
|                       |                           |     ai => e                           |   aiaaia   => aa          |
|                       |                           |     ea => a                           |   eaiteai  => eetee       |
+-----------------------+---------------------------+---------------------------------------+---------------------------+
| Left-to-right rule    | Apply the rule once       | ::                                    | ::                        |
|                       | starting at each          |                                       |                           |
|                       | character, from the       |   rule ltr:                           |   aitaaita => etaeta      |
|                       | beginning of the word to  |     ai => e                           |   aiaaia   => eaea        |
|                       | the end.                  |     ea => a                           |   eaiteai  => aitai       |
+-----------------------+---------------------------+---------------------------------------+---------------------------+
| Right-to-left rule    | Apply the rule once       | ::                                    | ::                        |
|                       | starting at each          |                                       |                           |
|                       | character, from the       |   rule rtl:                           |   aitaaita => etaeta      |
|                       | end of the word to        |     ai => e                           |   aiaaia   => eaea        |
|                       | the beginning.            |     ea => a                           |   eaiteai  => eetee       |
+-----------------------+---------------------------+---------------------------------------+---------------------------+
| Filter                | The rule pretends that    | ::                                    | ::                        |
|                       | only sounds that match    |                                       |                           |
|                       | the filter exist.         |   Class vowel {a, e, i}               |   aitati  => eiteti       |
|                       | Adjacency passes through  |   rule @vowel:                        |   annanni => annenni      |
|                       | non-matching sounds.      |     a => e / _ i                      |                           |
+-----------------------+---------------------------+---------------------------------------+---------------------------+
| Deromanizer           | Convert the romanization  | ::                                    | ::                        |
|                       | system into phonetic      |                                       |                           |
|                       | notation before applying  |   deromanizer:                        |   khakhi => xaxi          |
|                       | any rules.                |     kh => x                           |                           |
+-----------------------+---------------------------+---------------------------------------+---------------------------+
| Literal deromanizer   | Ignore all declarations   | ::                                    | ::                        |
|                       | until the first           |                                       |                           |
|                       | ``Then:``. Use this if    |   Feature +ejective                   |   'a'i   => hahi          |
|                       | the romanization system   |   Diacritic ' [+ejective]             |   kaki   => k'ak'i        |
|                       | conflicts with the        |   deromanizer literal:                |   k'ak'i => k'hak'hi      |
|                       | declarations.             |     ' => h                            |                           |
|                       |                           |   rule:                               |                           |
|                       |                           |     k => k'                           |                           |
+-----------------------+---------------------------+---------------------------------------+---------------------------+
| Romanizer             | Convert phonetic          | ::                                    | ::                        |
|                       | notation into the         |                                       |                           |
|                       | romanization system after |   romanizer:                          |   xaxi => khakhi          |
|                       | applying all the rules.   |     x => kh                           |                           |
+-----------------------+---------------------------+---------------------------------------+---------------------------+
| Literal romanizer     | Ignore all declarations   | ::                                    | ::                        |
|                       | after the last            |                                       |                           |
|                       | ``Then:``. Use this if    |   Feature +ejective                   |   hahi   => 'a'i          |
|                       | the romanization system   |   Diacritic ' [+ejective]             |   k'ak'i => kaki          |
|                       | conflicts with the        |   rule:                               |   khakhi => k'ak'i        |
|                       | declarations.             |     k' => k                           |                           |
|                       |                           |   romanizer literal:                  |                           |
|                       |                           |     h => '                            |                           |
+-----------------------+---------------------------+---------------------------------------+---------------------------+
| Intermediate          | Preserve an intermediate  | ::                                    | ::                        |
| romanizer             | stage of the language.    |                                       |                           |
|                       |                           |   rule-1:                             |   hahi => hihi => huhu    |
|                       |                           |     a => i                            |                           |
|                       |                           |   romanizer-a:                        |                           |
|                       |                           |     unchanged                         |                           |
|                       |                           |   rule-2:                             |                           |
|                       |                           |     i => u                            |                           |
+-----------------------+---------------------------+---------------------------------------+---------------------------+

Syllables
----------

+-----------------------+---------------------------+---------------------------------------+---------------------------+
| Structure             | Meaning                   | Example                               | Effect                    |
+=======================+===========================+=======================================+===========================+
| Explicit syllables    | Syllable breaks (``.``)   | ::                                    | ::                        |
|                       | don't break adjacency,    |                                       |                           |
|                       | but you have to include   |   Syllables:                          |   banana   => binina      |
|                       | them in the input words.  |     explicit                          |   ba.na.na => bi.ni.na    |
|                       |                           |   rule:                               |                           |
|                       |                           |     a => i / _ n                      |                           |
+-----------------------+---------------------------+---------------------------------------+---------------------------+
| Syllable boundary     | Matches syllable breaks   | ::                                    | ::                        |
|                       | and word boundaries.      |                                       |                           |
|                       |                           |   Syllables:                          |   banana   => banani      |
|                       |                           |     explicit                          |   ba.na.na => bi.ni.ni    |
|                       |                           |   rule:                               |   ban.ta   => ban.ti      |
|                       |                           |     a => i / _ .                      |                           |
+-----------------------+---------------------------+---------------------------------------+---------------------------+
| Syllable element      | Matches an entire         | ::                                    | ::                        |
|                       | syllable.                 |                                       |                           |
|                       |                           |   Syllables:                          |   banana   => x           |
|                       |                           |     explicit                          |   ba.na.na => x.x.x       |
|                       |                           |   rule:                               |                           |
|                       |                           |     <syl> => x                        |                           |
+-----------------------+---------------------------+---------------------------------------+---------------------------+
| Syllabification       | Automatically break words | ::                                    | ::                        |
|                       | into syllables matching   |                                       |                           |
|                       | specified patterns.       |   Syllables:                          |   banana => ba.na.na      |
|                       |                           |     {b, n} a                          |   banina => #Error!       |
+-----------------------+---------------------------+---------------------------------------+---------------------------+
| Resyllabification     | Words are automatically   | ::                                    | ::                        |
|                       | broken into syllables     |                                       |                           |
|                       | again at the end of each  |   Syllables:                          |   banana => ba.na.ba.na   |
|                       | named rule.               |     {b, n} a                          |                           |
|                       |                           |   rule:                               |                           |
|                       |                           |     a => aba / n _ n                  |                           |
+-----------------------+---------------------------+---------------------------------------+---------------------------+
| New syllabification   | Change syllabification    | ::                                    | ::                        |
|                       | patterns between rules.   |                                       |                           |
|                       |                           |   Syllables:                          |   banana => bi.ni.na      |
|                       |                           |     {b, n} a                          |                           |
|                       |                           |   rule:                               |                           |
|                       |                           |     a => i / _ n                      |                           |
|                       |                           |   Syllables:                          |                           |
|                       |                           |     {b, n} {a, i}                     |                           |
+-----------------------+---------------------------+---------------------------------------+---------------------------+
| Clearing syllables    | Throw away all syllable   | ::                                    | ::                        |
|                       | information for           |                                       |                           |
|                       | subsequent rules.         |   Syllables:                          |   ba.na.na => binina      |
|                       |                           |     explicit                          |                           |
|                       |                           |   rule:                               |                           |
|                       |                           |     a => i / _ n                      |                           |
|                       |                           |   Syllables:                          |                           |
|                       |                           |     clear                             |                           |
+-----------------------+---------------------------+---------------------------------------+---------------------------+
| Syllable-level        | These features attach     | ::                                    | ::                        |
| features              | to whole syllables rather |                                       |                           |
|                       | than sounds.              |   Feature (syllable) +stress          |   'ba.na.na => 'be.na.na  |
|                       |                           |   Diacritic ' (before) [+stress]      |   ba.'na.na => ba.'ne.na  |
|                       |                           |   Syllables:                          |                           |
|                       |                           |     explicit                          |                           |
|                       |                           |   rule:                               |                           |
|                       |                           |     a&[+stress] => e                  |                           |
+-----------------------+---------------------------+---------------------------------------+---------------------------+
| Syllabification       | Apply syllable-level      | ::                                    | ::                        |
| features              | features to syllables     |                                       |                           |
|                       | that match certain        |   Feature (syllable) +stress          |   banana => 'ba.na.na     |
|                       | patterns                  |   Diacritic ' (before) [+stress]      |   nabana => na.'ba.na     |
|                       |                           |   Syllables:                          |                           |
|                       |                           |     b a => [+stress]                  |                           |
|                       |                           |     n a                               |                           |
+-----------------------+---------------------------+---------------------------------------+---------------------------+
