Lexurgy SC
===========

Lexurgy SC simulates historical sound changes. It applies regular rules
to a list of input words from an older form of the language to produce
the same words in a newer form of the language.

Why Lexurgy SC?
----------------

Conlangers rarely get things exactly right the first try, and sound
changers are especially prone to revision. Lexurgy embraces this truth.
It's designed around two main goals:

    - Rules are short, easy to read, and can have descriptive names.
      When you want to revise the sound changes, you shouldn't be lost
      in your own change file.
    - You might need complex feature and class definitions at the
      beginning of the file, but these should need to change much
      less often than the rules themselves.

Why not just use Rosenfelder's SCA?
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Rosenfelder's SCA is a great tool, but it's pretty limited in power.
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

Phonix is what I used for sound changes before I started working on
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

.. toctree::
    :maxdepth: 2
    :caption: Contents:

    sc-dsl
    sc-cli
