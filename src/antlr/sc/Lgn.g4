grammar Lgn;

classdecl: CLASSDECL WHITESPACE name WHITESPACE LISTSTART classelement (SEP classelement)* LISTEND;
classelement: classref | text;

patterndecl: PATTERNDECL WHITESPACE name BLOCKSTART NEWLINE pattern;

pattern: simple | sequence;
sequence: sequenceelement (WHITESPACE sequenceelement)+;
sequenceelement: optional | list | simple;
optional: (list | simple) OPTIONAL;
list: LISTSTART pattern (SEP pattern)* LISTEND;

simple: classref | text;
classref: CLASSREF name;

name: NAME;
text: NAME | STR;

SEP: ',' WHITESPACE?;
WHITESPACE: ' '+;
NEWLINE: WHITESPACE? ('\r\n' | '\n') WHITESPACE?;
LISTSTART: '{';
LISTEND: '}';
OPTIONAL: '?';
CLASSREF: '@';
BLOCKSTART: ':';
CLASSDECL: 'Class';
PATTERNDECL: 'Pattern';

NAME: LOWER CHAR*;
STR: ANY+;

fragment LOWER: [a-z];
fragment CHAR: [A-Za-z0-9];
fragment ANY: ~[ ,=>()*[\]{}+?/\-_:!$@#\n\r];