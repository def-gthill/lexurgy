# Welcome to Lexurgy!
Lexurgy is a sound change applier. It allows the user to simulate historical changes in spoken languages by applying regular rules to a list of words.

It's available as a [command-line tool](https://github.com/def-gthill/lexurgy/releases/latest) and as a [web app](https://www.lexurgy.com/sc). The web interface is in [a separate repo](https://github.com/def-gthill/lexurgy-web).

The command-line tool requires Java 8 or higher to be installed on your computer. You can get Java [here](https://www.oracle.com/java/technologies/javase-jre8-downloads.html).

To install the command-line tool, download the ZIP or TAR from the releases page, unpack it, and add the ``bin`` folder to your PATH. You should now have a ``lexurgy`` command available in your terminal; test it by running ``lexurgy --help``, which should display basic usage instructions.

You can read the documentation [here](https://www.meamoria.com/lexurgy/html/index.html).

Lexurgy is written in [Kotlin](https://kotlinlang.org/), and the sound change file format is powered by the [ANTLR](https://github.com/antlr/antlr4) parser generator.
