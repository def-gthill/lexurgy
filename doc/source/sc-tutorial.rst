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
You can put

    # These rules palatalize k to s in three steps.
    palatalization-1:
        k => tʃ / _ i
    palatalization-2:
        # This is step 2!
        tʃ => ʃ
    palatalization-3:
        ʃ => s # This is step 3!


Basican
~~~~~~~~

What you've seen so far is enough to understand the *Basican* example
in the web app. Load this example and watch it in action!

You can do a lot with just the basic structures, but they barely
scratch the surface of what Lexurgy offers.

Intermediate Features
----------------------


