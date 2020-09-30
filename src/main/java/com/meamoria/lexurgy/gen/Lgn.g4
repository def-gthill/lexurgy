grammar Lgn;

classdecl: CLASSDECL WHITESPACE name WHITESPACE LISTSTART classelement (SEP classelement)* LISTEND;
classelement: optional | classref | text;

pattern: sequence;
sequence: sequenceelement (WHITESPACE sequenceelement)+;
sequenceelement: classref | text;
optional: (classref | text) OPTIONAL;

classref: CLASSREF name;

name: NAME;
text: NAME | STR;

SEP: ',' WHITESPACE?;
WHITESPACE: ' '+;
LISTSTART: '{';
LISTEND: '}';
OPTIONAL: '?';
CLASSREF: '@';
CLASSDECL: 'Class';

NAME: LOWER CHAR*;
STR: ANY+;

fragment LOWER: [a-z];
fragment CHAR: [A-Za-z0-9];
fragment ANY: ~[ ,=>()*[\]{}+?/\-_:!$@#\n\r];