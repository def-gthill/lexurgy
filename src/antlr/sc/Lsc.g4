grammar Lsc;
// Pointless comment 1
lscFile: WHITESPACE | NEWLINE* statement? (NEWLINE+ statement)* NEWLINE* EOF;
statement:
    featureDecl | diacriticDecl | symbolDecl | classDecl | syllableDecl |
    deromanizer | changeRule | interRomanizer | romanizer;

classDecl: CLASS_DECL WHITESPACE name WHITESPACE LIST_START classElement (SEP classElement)* LIST_END;
classElement: classRef | text;
featureDecl:
    FEATURE_DECL WHITESPACE (
        (plusFeature (SEP plusFeature)*) |
        (name WHITESPACE? O_PAREN (nullAlias SEP)? featureValue (SEP featureValue)* C_PAREN)
    );
plusFeature: AT_LEAST_ONE? name;
nullAlias: NULL featureValue;
diacriticDecl:
    DIACRITIC WHITESPACE text WHITESPACE
    (diacriticModifier WHITESPACE)* matrix (WHITESPACE diacriticModifier)*;
diacriticModifier: DIA_BEFORE | DIA_FLOATING;
symbolDecl: SYMBOL WHITESPACE symbolName ((SEP symbolName)* | WHITESPACE matrix);
symbolName: text;

syllableDecl: SYLLABLE_DECL RULE_START (NEWLINE+ EXPLICIT_SYLLABLES | (NEWLINE+ syllablePattern)+);
syllablePattern: syllableElement (WHITESPACE syllableElement)*;
syllableElement: classRef;

deromanizer: DEROMANIZER (WHITESPACE LITERAL)? RULE_START NEWLINE+ block;
romanizer: ROMANIZER (WHITESPACE LITERAL)? RULE_START NEWLINE+ block;
interRomanizer: ROMANIZER HYPHEN ruleName (WHITESPACE LITERAL)? RULE_START NEWLINE+ block;

changeRule: ruleName (WHITESPACE changeRuleModifier)* RULE_START? NEWLINE+ block;
changeRuleModifier: filter | PROPAGATE;
filter: classRef | fancyMatrix;
block: blockElement (NEWLINE+ blockType RULE_START (WHITESPACE | NEWLINE+) blockElement)*;
blockElement: expressionList | O_PAREN NEWLINE* block NEWLINE* C_PAREN;
blockType: ALL_MATCHING | FIRST_MATCHING;
expressionList: expression (NEWLINE+ expression)*;
ruleName: NAME (HYPHEN (NAME | NUMBER))*;

expression: UNCHANGED | (from CHANGE to compoundEnvironment);
from: ruleElement;
to: ruleElement;

//ruleElement: capture | repeater | group | list | intersection | simple | sequence;
//sequence: sequenceElement (WHITESPACE sequenceElement)+;
//sequenceElement: capture | repeater | group | list | intersection | simple;
//capture: (group | list | negated | classRef | fancyMatrix) captureRef;
//repeater: (group | list | simple) repeaterType;
//group: O_PAREN ruleElement C_PAREN;
//list: LIST_START ruleElement (SEP ruleElement)* LIST_END;
//intersection: intersectionElement (INTERSECTION intersectionElement)+;
//intersectionElement: capture | repeater | group | list | simple;
//simple: negated | classRef | captureRef | fancyMatrix | empty | boundary | betweenWords | text;
//negated: NEGATION (classRef | captureRef | text);

ruleElement: group | list | intersection | negated | capture | repeater | simple | sequence | lookaround;

// "Bounded" elements have a clear start and end symbol
group: O_PAREN ruleElement C_PAREN;
list: LIST_START ruleElement (SEP ruleElement)* LIST_END;

// "Free" elements have sub-elements floating free amid whitespace
sequence: freeElement (WHITESPACE freeElement)+;
lookaround: O_PAREN freeElement compoundEnvironment C_PAREN;
freeElement: group | list | intersection | negated | capture | repeater | simple;

compoundEnvironment: (CONDITION condition)? (EXCLUSION exclusion)?;
condition: environment | environmentList;
exclusion: environment | environmentList;
environmentList: LIST_START environment (SEP environment)* LIST_END;
environment:
    (environmentBefore WHITESPACE)? ANCHOR (WHITESPACE environmentAfter)?
    | environmentBefore?;
environmentBefore: ruleElement;
environmentAfter: ruleElement;

// "Interfix" elements use a delimiter but no whitespace or boundary marker
intersection: interfixElement (INTERSECTION interfixElement)+;
interfixElement: group | list | negated | capture | repeater | simple;

// "Prefix" elements use a prefix operator
negated: NEGATION simple;

// "Postfix" elements use a postfix operator
capture: (group | list | negated | simple) captureRef;
repeater: (group | list | simple) repeaterType;

// "Simple" elements can't have other elements inside them
simple: classRef | captureRef | fancyMatrix | empty | boundary | betweenWords | text;
classRef: CLASSREF name;
captureRef: WORD_BOUNDARY NUMBER;

fancyMatrix: MATRIX_START fancyValue? (WHITESPACE fancyValue)* MATRIX_END;
fancyValue: plusFeatureValue | featureValue | negatedValue | absentFeature | featureVariable;
negatedValue: NEGATION name;
absentFeature: NULL name;
featureVariable: WORD_BOUNDARY name;

empty: NULL;
boundary: WORD_BOUNDARY;
betweenWords: BETWEEN_WORDS;
repeaterType: AT_LEAST_ONE | NULL | OPTIONAL;
matrix: MATRIX_START matrixValue? (WHITESPACE matrixValue)* MATRIX_END;
matrixValue: plusFeatureValue | featureValue;
plusFeatureValue: (AT_LEAST_ONE | HYPHEN) name;
featureValue: name;
name: NAME;
text: (NAME | STR1 | STR) NEGATION?;

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
BETWEEN_WORDS: '$$';
CLASSREF: '@';
INTERSECTION: '&';
CLASS_DECL: 'Class' | 'class';
FEATURE_DECL: 'Feature' | 'feature';
DIACRITIC: 'Diacritic' | 'diacritic';
DIA_BEFORE: '(Before)' | '(before)';
DIA_FLOATING: '(Floating)' | '(floating)';
SYMBOL: 'Symbol' | 'symbol';
SYLLABLE_DECL: 'Syllables';
EXPLICIT_SYLLABLES: 'explicit';
DEROMANIZER: 'Deromanizer' | 'deromanizer';
ROMANIZER: 'Romanizer' | 'romanizer';
ALL_MATCHING: 'Then' | 'then';
FIRST_MATCHING: 'Else' | 'else';
PROPAGATE: 'Propagate' | 'propagate';
LITERAL: 'Literal' | 'literal';
UNCHANGED: 'Unchanged' | 'unchanged';
NUMBER: DIGIT+;
NAME: CHAR+;
STR1: ANY;
STR: ANY+;

fragment CHAR: [A-Za-z0-9];
fragment DIGIT: [0-9];
fragment ANY: ('\\' .) | ~[ \\,=>()*[\]{}+?/\-_:!$@#&\n\r];
fragment COMMENT_START: '#';