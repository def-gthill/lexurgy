grammar Lsc;

lscFile:
    (featureDecl NEWLINE+)* (diacriticDecl NEWLINE+)* (symbolDecl NEWLINE+)* (classDecl NEWLINE+)* (deromanizer NEWLINE+)?
    changeRule? ((NEWLINE+ (changeRule | interRomanizer))* NEWLINE+ changeRule)?
    (NEWLINE+ romanizer)?
    NEWLINE* EOF;

classDecl: CLASS_DECL WHITESPACE value WHITESPACE LIST_START classElement (SEP classElement)* LIST_END;
classElement: classRef | text;
featureDecl: FEATURE_DECL WHITESPACE feature O_PAREN (nullAlias SEP)? value (SEP value)* C_PAREN (CHANGE matrix)?;
nullAlias: NULL value;
diacriticDecl: DIACRITIC WHITESPACE STR1 WHITESPACE (DIA_BEFORE WHITESPACE)? (DIA_FLOATING WHITESPACE)? matrix;
symbolDecl: SYMBOL WHITESPACE symbolName ((SEP symbolName)* | WHITESPACE matrix);
symbolName: text;

deromanizer: DEROMANIZER RULE_START NEWLINE subrules;
romanizer: ROMANIZER RULE_START NEWLINE subrules;
interRomanizer: ROMANIZER HYPHEN ruleName RULE_START NEWLINE subrules;

changeRule: ruleName (WHITESPACE filter)? (WHITESPACE PROPAGATE)? RULE_START NEWLINE subrules;
filter: classRef | matrix;
subrules: subrule (NEWLINE SUBRULE RULE_START (WHITESPACE | NEWLINE) subrule)*;
subrule: expression (NEWLINE expression)*;
ruleName: VALUE (HYPHEN VALUE)*;

expression: from CHANGE to (CONDITION condition)? (EXCLUSION exclusion)?;
condition: environment | environmentList;
exclusion: environment | environmentList;
from: ruleElement;
to: ruleElement;
environmentList: LIST_START environment (SEP environment)* LIST_END;
environment: (boundaryBefore WHITESPACE)? (environmentBefore WHITESPACE)? ANCHOR (WHITESPACE environmentAfter)? (WHITESPACE boundaryAfter)?;
boundaryBefore: WORD_BOUNDARY;
boundaryAfter: WORD_BOUNDARY;
environmentBefore: ruleElement;
environmentAfter: ruleElement;

ruleElement: capture | repeater | group | list | simple | sequence;
sequence: sequenceElement (WHITESPACE sequenceElement)+;
sequenceElement: capture | repeater | group | list | simple;
capture: (group | list | negated | classRef | fancyMatrix) captureRef;
repeater: (group | list | simple) repeaterType;
group: O_PAREN ruleElement C_PAREN;
list: LIST_START ruleElement (SEP ruleElement)* LIST_END;
simple: negated | classRef | captureRef | fancyMatrix | empty | text;
negated: NEGATION classRef;
classRef: CLASSREF value;
captureRef: WORD_BOUNDARY NUMBER;

fancyMatrix: MATRIX_START fancyValue? (WHITESPACE fancyValue)* MATRIX_END;
fancyValue: value | negatedValue | absentFeature | featureVariable;
negatedValue: NEGATION value;
absentFeature: NULL feature;
featureVariable: WORD_BOUNDARY feature;

empty: NULL;
repeaterType: AT_LEAST_ONE | NULL | OPTIONAL;
matrix: MATRIX_START value? (WHITESPACE value)* MATRIX_END;
feature: FEATURE;
value: VALUE;
text: (FEATURE | VALUE | STR1 | STR) NEGATION?;

COMMENT: (WHITESPACE? COMMENT_START ~[\n\r]* NEWLINE*) -> skip;
SEP: ',' WHITESPACE?;
CHANGE: WHITESPACE? '=>' WHITESPACE?;
CONDITION: WHITESPACE? '/' WHITESPACE?;
EXCLUSION: WHITESPACE? '//' WHITESPACE?;
ANCHOR: '_';
NEWLINE: WHITESPACE? ('\r\n' | '\n') WHITESPACE?;
WHITESPACE: ' '+;
O_PAREN: '(';
C_PAREN: ')';
NULL: '*';
MATRIX_START: '[';
MATRIX_END: ']';
LIST_START: '{';
LIST_END: '}';
AT_LEAST_ONE: '+';
OPTIONAL: '?';
HYPHEN: '-';
RULE_START: ':';
NEGATION: '!';
WORD_BOUNDARY: '$';
CLASSREF: '@';
CLASS_DECL: 'Class';
FEATURE_DECL: 'Feature';
DIACRITIC: 'Diacritic';
DIA_BEFORE: '(before)';
DIA_FLOATING: '(floating)';
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
fragment COMMENT_START: '#';