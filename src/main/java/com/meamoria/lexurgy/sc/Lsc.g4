grammar Lsc;

lscfile:
    (featuredecl NEWLINE+)* (diacritic NEWLINE+)* (symbol NEWLINE+)* (classdecl NEWLINE+)* (deromanizer NEWLINE+)?
    changerule? ((NEWLINE+ (changerule | interromanizer))* NEWLINE+ changerule)?
    (NEWLINE+ romanizer)?
    NEWLINE* EOF;

classdecl: CLASSDECL WHITESPACE value WHITESPACE LISTSTART classelement (SEP classelement)* LISTEND;
classelement: classref | text;
featuredecl: FEATUREDECL WHITESPACE feature OPAREN (nullalias SEP)? value (SEP value)* CPAREN (CHANGE matrix)?;
nullalias: NULL value;
diacritic: DIACRITIC WHITESPACE STR1 WHITESPACE (DIABEFORE WHITESPACE)? (DIAFLOATING WHITESPACE)? matrix;
symbol: SYMBOL WHITESPACE symbolname ((SEP symbolname)* | WHITESPACE matrix);
symbolname: text;

deromanizer: DEROMANIZER RULESTART NEWLINE subrules;
romanizer: ROMANIZER RULESTART NEWLINE subrules;
interromanizer: ROMANIZER HYPHEN rulename RULESTART NEWLINE subrules;

changerule: rulename (WHITESPACE filter)? (WHITESPACE PROPAGATE)? RULESTART NEWLINE subrules;
filter: classref | matrix;
subrules: subrule (NEWLINE SUBRULE RULESTART (WHITESPACE | NEWLINE) subrule)*;
subrule: ruleexpression (NEWLINE ruleexpression)*;
rulename: VALUE (HYPHEN VALUE)*;
ruleexpression: rulefrom CHANGE ruleto (CONDITION condition)? (EXCLUSION exclusion)?;
condition: ruleenviron | environlist;
exclusion: ruleenviron | environlist;
rulefrom: ruleelement;
ruleto: ruleelement;
environlist: LISTSTART ruleenviron (SEP ruleenviron)* LISTEND;
ruleenviron: (boundarybefore WHITESPACE)? (rulebefore WHITESPACE)? ANCHOR (WHITESPACE ruleafter)? (WHITESPACE boundaryafter)?;
boundarybefore: WORDBOUNDARY;
boundaryafter: WORDBOUNDARY;
rulebefore: ruleelement;
ruleafter: ruleelement;
ruleelement: rulecapture | rulerepeater | rulegroup | rulelist | simpleelement | rulesequence;
rulesequence: sequenceelement (WHITESPACE sequenceelement)+;
sequenceelement: rulecapture | rulerepeater | rulegroup | rulelist | simpleelement;
rulecapture: (rulegroup | rulelist | negelement | classref | fancymatrix) captureref;
rulerepeater: (rulegroup | rulelist | simpleelement) repeatertype;
rulegroup: OPAREN ruleelement CPAREN;
rulelist: LISTSTART ruleelement (SEP ruleelement)* LISTEND;
simpleelement: negelement | classref | captureref | fancymatrix | empty | text;
negelement: NEGATION classref;
classref: CLASSREF value;
captureref: WORDBOUNDARY NUMBER;
fancymatrix: MATSTART fancyvalue? (WHITESPACE fancyvalue)* MATEND;
fancyvalue: value | negvalue | absentfeature | featurevariable;
negvalue: NEGATION value;
absentfeature: NULL feature;
featurevariable: WORDBOUNDARY feature;
empty: NULL;
repeatertype: ATLEASTONE | NULL | OPTIONAL;

matrix: MATSTART value? (WHITESPACE value)* MATEND;
feature: FEATURE;
value: VALUE;
text: (FEATURE | VALUE | STR1 | STR) NEGATION?;

COMMENT: (WHITESPACE? COMMENTSTART ~[\n\r]* NEWLINE*) -> skip;
SEP: ',' WHITESPACE?;
CHANGE: WHITESPACE? '=>' WHITESPACE?;
CONDITION: WHITESPACE? '/' WHITESPACE?;
EXCLUSION: WHITESPACE? '//' WHITESPACE?;
ANCHOR: '_';
NEWLINE: WHITESPACE? ('\r\n' | '\n') WHITESPACE?;
WHITESPACE: ' '+;
OPAREN: '(';
CPAREN: ')';
NULL: '*';
MATSTART: '[';
MATEND: ']';
LISTSTART: '{';
LISTEND: '}';
ATLEASTONE: '+';
OPTIONAL: '?';
HYPHEN: '-';
RULESTART: ':';
NEGATION: '!';
WORDBOUNDARY: '$';
CLASSREF: '@';
CLASSDECL: 'Class';
FEATUREDECL: 'Feature';
DIACRITIC: 'Diacritic';
DIABEFORE: '(before)';
DIAFLOATING: '(floating)';
SYMBOL: 'Symbol';
DEROMANIZER: 'Deromanizer';
ROMANIZER: 'Romanizer';
SUBRULE: 'Then';
PROPAGATE: 'propagate';
FEATURE: UPPER CHAR*;
VALUE: LOWER CHAR*;
NUMBER: DIGIT+;
STR1: ANY;
STR: ANY+;

fragment UPPER: [A-Z];
fragment LOWER: [a-z];
fragment CHAR: [A-Za-z0-9];
fragment DIGIT: [0-9];
fragment ANY: ~[ ,=>()*[\]{}+?/\-_:!$@#\n\r];
fragment COMMENTSTART: '#';