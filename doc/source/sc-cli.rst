Lexurgy SC on the Command Line
===============================

Run SC using the command line::

    lexurgy sc changes words

The ``changes`` file needs to use the Lexurgy SC Rules format; by convention these have a
.lsc extension.

The ``words`` argument should be one or more text files, each containing
an old-language word per line.
By convention, these files should have a .wli extension.

Lexurgy SC accepts the following command-line options:

.. option:: -a <rule>, --start-at <rule>

    If this is specified, Lexurgy will ignore every rule before the specified rule
    (including the deromanizer). This is useful if you want to introduce loanwords
    or affixes partway through the language's history.

.. option:: -b <rule>, --stop-before <rule>

    If this is specified, Lexurgy will ignore the specified rule and every rule
    after it. This is useful if you want to evolve some forms partway, then
    modify them and resume (using :option:`-a`).

.. option:: -i <suffix>, --in-suffix <suffix>

    If this is specified, each input file name will have the specified suffix
    added. For example, ``lexurgy sc changes.lsc nouns.wli verbs.wli -i old``
    will actually look for the files ``nouns_old.wli`` and
    ``verbs_old.wli`` to read old-language words from.

.. option:: -o <suffix>, --out-suffix <suffix>

    By default, the new-language words are written to files with the same names
    as the input files, but with ``_ev`` attached to the file name (so
    the words in ``nouns.wli`` will have their new-language forms written to
    ``nouns_ev.wli``. But if ``-o`` is specified, the output files will have
    that suffix instead. For example, ``lexurgy sc changes.lsc nouns.wli verbs.wli -i newfangled``
    will produce output files ``nouns_newfangled.wli`` and ``verbs_newfangled.wli``.

.. option:: -t <word>, --trace-word <word>

    Indicates a word to trace through its changes. Each change applied to the word
    will be displayed in the terminal and also written to a file with the suffix
    ``_trace`` on it. Depending on your terminal font and encoding, IPA characters
    might not render correctly in the terminal, so check the ``_trace`` file if
    you think there's a problem with the terminal output.

    This option can be specified more than once to trace several words. For example,
    ``-t pika -t talimu -t atepino`` will show how the changes to apply to
    *pika*, *talimu*, and *atepino*.

.. option:: -m, --intermediates

    This activates :ref:`intermediate romanizers <sc-intermediate-romanizers>`, so
    that Lexurgy will produce a ``.wli`` file for each intermediate romanizer in
    addition to the main romanizer at the end of the .lsc file.

.. option:: -p, --phonetic

    This deactivates the main romanizer, so the output files will have the phonetic
    forms instead of the romanized forms. This is useful if you think there might
    be mistakes in your romanizer.

.. option:: -S, --no-compare-stages

    This turns off the ``<old-word> => <new-word>`` format in the ``.wlm`` file.

.. option:: -v, --compare-versions

    This makes Lexurgy compare its output files to the existing contents of those
    files before replacing them. The existing words are written to the ``.wlm``
    file after an ``XX``. For example, if the previous version of the .lsc
    file turned *kehati* into *kiade*, but you've now added a palatalization
    rule that turns *ki* into *ch*, then the ``.wlm`` file will show
    ``kehati => chade XX kiade``.

    This is useful if you're making tweaks to the sound changes for an established
    language and want to make sure that the tweaks don't have unintended consequences.

.. option:: -d, --developer

    This makes Lexurgy print a full stack trace when it encounters an error.
    Use this if you get a "Lexurgy couldn't apply the changes because of an unexpected error",
    which usually indicates a bug in Lexurgy. File a bug report
    `here <https://github.com/def-gthill/lexurgy/issues>`_ and attach the full output.
