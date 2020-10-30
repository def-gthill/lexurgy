Lexurgy SC on the Command Line
===============================

Run SC using the command line::

    lexurgy sc changes words

The ``changes`` file needs to use the Lexurgy SC Rules format; by convention these have a
.lsc extension.

The ``words`` argument should be a text file with each old-language word on a separate line.
By convention, this file should have a .wli extension.

Lexurgy SC accepts the following command-line options:

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