grammar Lsc;

lscFile: WHITESPACE | NEWLINE* statement? (NEWLINE+ statement)* NEWLINE* EOF;
statement:
    featureDecl | diacriticDecl | symbolDecl | classDecl |
    deromanizer | changeRule | interRomanizer | romanizer;

classDecl: CLASS_DECL WHITESPACE value WHITESPACE LIST_START classElement (SEP classElement)* LIST_END;
classElement: classRef | text;
featureDecl:
    FEATURE_DECL WHITESPACE feature WHITESPACE?
    O_PAREN (nullAlias SEP)? value (SEP value)* C_PAREN (CHANGE matrix)?;
nullAlias: NULL value;
diacriticDecl:
    DIACRITIC WHITESPACE STR1 WHITESPACE
    (diacriticModifier WHITESPACE)* matrix (WHITESPACE diacriticModifier)*;
diacriticModifier: DIA_BEFORE | DIA_FLOATING;
symbolDecl: SYMBOL WHITESPACE symbolName ((SEP symbolName)* | WHITESPACE matrix);
symbolName: text;

deromanizer: DEROMANIZER (WHITESPACE LITERAL)? RULE_START NEWLINE+ subrules;
romanizer: ROMANIZER (WHITESPACE LITERAL)? RULE_START NEWLINE+ subrules;
interRomanizer: ROMANIZER HYPHEN ruleName (WHITESPACE LITERAL)? RULE_START NEWLINE+ subrules;

changeRule: ruleName (WHITESPACE filter)? (WHITESPACE PROPAGATE)? RULE_START NEWLINE+ subrules;
filter: classRef | matrix;
subrules: subrule (NEWLINE+ SUBRULE RULE_START (WHITESPACE | NEWLINE+) subrule)*;
subrule: expression (NEWLINE+ expression)*;
ruleName: VALUE (HYPHEN VALUE)*;

expression: UNCHANGED | (from CHANGE to (CONDITION condition)? (EXCLUSION exclusion)?);
condition: environment | environmentList;
exclusion: environment | environmentList;
from: ruleElement;
to: ruleElement;
environmentList: LIST_START environment (SEP environment)* LIST_END;
environment:
    (environmentBefore WHITESPACE)? ANCHOR (WHITESPACE environmentAfter)?
    | environmentBefore?;
environmentBefore: ruleElement;
environmentAfter: ruleElement;

ruleElement: capture | repeater | group | list | simple | sequence;
sequence: sequenceElement (WHITESPACE sequenceElement)+;
sequenceElement: capture | repeater | group | list | simple;
capture: (group | list | negated | classRef | fancyMatrix) captureRef;
repeater: (group | list | simple) repeaterType;
group: O_PAREN ruleElement C_PAREN;
list: LIST_START ruleElement (SEP ruleElement)* LIST_END;
simple: negated | classRef | captureRef | fancyMatrix | empty | boundary | text;
negated: NEGATION classRef;
classRef: CLASSREF value;
captureRef: WORD_BOUNDARY NUMBER;

fancyMatrix: MATRIX_START fancyValue? (WHITESPACE fancyValue)* MATRIX_END;
fancyValue: value | negatedValue | absentFeature | featureVariable;
negatedValue: NEGATION value;
absentFeature: NULL feature;
featureVariable: WORD_BOUNDARY feature;

empty: NULL;
boundary: WORD_BOUNDARY;
repeaterType: AT_LEAST_ONE | NULL | OPTIONAL;
matrix: MATRIX_START value? (WHITESPACE value)* MATRIX_END;
feature: FEATURE;
value: VALUE;
text: (FEATURE | VALUE | STR1 | STR) NEGATION?;

COMMENT: (WHITESPACE? COMMENT_START ~[\n\r]*) -> skip;
SEP: ',' WHITESPACE?;
CHANGE: WHITESPACE? '=>' WHITESPACE?;
CONDITION: WHITESPACE? '/' WHITESPACE?;
EXCLUSION: WHITESPACE? '//' WHITESPACE?;
ANCHOR: '_';
NEWLINE: WHITESPACE? ('\r\n' | '\n') WHITESPACE?;
WHITESPACE: [\p{White_Space}]+;
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
CLASS_DECL: 'Class' | 'class';
FEATURE_DECL: 'Feature' | 'feature';
DIACRITIC: 'Diacritic' | 'diacritic';
DIA_BEFORE: '(Before)' | '(before)';
DIA_FLOATING: '(Floating)' | '(floating)';
SYMBOL: 'Symbol' | 'symbol';
DEROMANIZER: 'Deromanizer' | 'deromanizer';
ROMANIZER: 'Romanizer' | 'romanizer';
SUBRULE: 'Then' | 'then';
PROPAGATE: 'Propagate' | 'propagate';
LITERAL: 'Literal' | 'literal';
UNCHANGED: 'Unchanged' | 'unchanged';
FEATURE: UPPER CHAR*;
VALUE: LOWER CHAR*;
NUMBER: DIGIT+;
STR1: ANY;
STR: ANY+;

fragment UPPER: [A-Z];
fragment LOWER: [a-z];
fragment CHAR: [A-Za-z0-9];
fragment DIGIT: [0-9];
fragment ANY: ('\\' .) | ~[ \\,=>()*[\]{}+?/\-_:!$@#\n\r];
fragment COMMENT_START: '#';