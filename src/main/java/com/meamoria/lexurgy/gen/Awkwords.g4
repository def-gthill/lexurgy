grammar Awkwords;

awkfile: (NEWLINE* subpattern)* NEWLINE* TEMPLATESTART pattern NEWLINE* (NEWLINE numwords)? NEWLINE? EOF;
numwords: NUMWORDSSTART number;
subpattern: SUBREF SUBPATSTART pattern NEWLINE;
pattern: filtered | group | escape | optional | subref | atom | alternative | sequence;

alternative: weightedchoice (ALTSEP weightedchoice)+;
weightedchoice: altchoice (WEIGHT number)?;
altchoice: filtered | group | escape | optional | subref | atom | sequence;

filtered: group (FILTERSEP filterstring)+;
filterstring: atom+;

optional: OPSTART pattern OPEND;
sequence: (filtered | group | escape | optional | subref | atom)+;
group: GROUPSTART pattern GROUPEND;
escape: ESCAPE anychar+ ESCAPE;

subref: SUBREF;
anychar: ATOM | SUBREF | ALTSEP | OPSTART | OPEND | GROUPSTART | GROUPEND | WEIGHT | FILTERSEP | SUBPATSTART;
// : and numbers are valid inside patterns - they only have special meanings in particular spots
atom: ATOM | SUBPATSTART | DIGIT;
number: DIGIT+;

COMMENT: (COMMENTSTART ~[\n\r]*) -> skip;
ATOM: ~[A-Z0-9/()[\]*^":\n\r];
SUBREF: [A-Z];
ALTSEP: '/';
OPSTART: '(';
OPEND: ')';
GROUPSTART: '[';
GROUPEND: ']';
WEIGHT: '*';
FILTERSEP: '^';
ESCAPE: '"';
SUBPATSTART: ':';
TEMPLATESTART: 'r:';
NUMWORDSSTART: 'n:';
DIGIT: [0-9];
NEWLINE: '\r\n' | '\n';

fragment COMMENTSTART: '#';


