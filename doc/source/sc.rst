Lexurgy SC
===========

Lexurgy SC simulates historical sound changes. It applies regular rules
to a list of input words from an older form of the language to produce
the same words in a newer form of the language.

Check out the `web app <https://www.lexurgy.com/sc>`_!

User Guide
-----------

.. toctree::
    :maxdepth: 2
    :caption: Contents:

    Tutorial <sc-tutorial>
    Cheat Sheet <sc-cheat-sheet>
    Command-Line Tool <sc-cli>

.. TODO Add "Language Specification <sc-dsl>"

Why Lexurgy SC?
----------------

Lexurgy's design philosophy sets it apart from other sound change
appliers:

- **Embrace revision**. Sound changes are hard to get right the first try,
  and it can take a lot of tinkering and experimentation to produce the results
  you want. It should be easy to make on-the-fly revisions to a project,
  even one you haven't touched in months. That means encouraging descriptive names,
  a logical and organized file structure, and syntax that
  allows for small adjustments to existing rules.
- **Make common things easy**. You shouldn't have to be a programming genius
  to write common kinds of sound change rules. Lots of languages have stress
  assignment, assimilation, and vowel harmony, so the available syntax
  should naturally lend itself to writing such rules.

Why not just use Rosenfelder's SCA?
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Rosenfelder's `SCA <http://zompist.com/sca2.html>`_ is a great tool,
but it's pretty limited in power.
Certain kinds of rules, like stress-sensitive changes and assimilation,
require convoluted sequences of rules, if they're possible at all.
Lexurgy lets you do everything the "SCA way" if you want, but the
more powerful tools are always there when you need them.

Also, don't underestimate the value of descriptive names. Yes, SCA's
one-character names are very fast to type, but they cost more in
the long run from every time you want to make changes and have to
remember what L and Q stood for.

Why not just use Phonix?
~~~~~~~~~~~~~~~~~~~~~~~~~

`Phonix <https://gitlab.com/jaspax/phonix/blob/master/README.md>`_
is what I used for sound changes before I started working on
Lexurgy. Its distinctive feature paradigm is very powerful, and
Lexurgy owes a great debt to it.

However, Phonix's limitation is that it forces *everything* into
the distinctive feature paradigm. The *only* way to make a rule
apply to more than one sound (without writing a separate rule
for each sound) is to give those sounds, and only
those sounds, a feature in common. This can lead to very long
feature matrices and fragile rules that break when you make changes.

Lexurgy avoids this by providing alternative lists and sound
classes, which are ways to group sounds together independent
of their features. That way, you can use features for the heavy
lifting, like managing stress systems and assimiliation,
while sticking with the simpler alternative lists and sound
classes for easier rules.
