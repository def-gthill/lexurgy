grammar Lsc;

lscFile: (WHITESPACE | NEWLINE*) statement? (NEWLINE+ statement)* (WHITESPACE | NEWLINE*) EOF;
statement:
    featureDecl | diacriticDecl | symbolDecl | classDecl | elementDecl | syllableDecl |
    deromanizer | interRomanizer | romanizer | changeRule | standardExpression;

elementDecl: ELEMENT_DECL WHITESPACE name WHITESPACE ruleElement;
classDecl: CLASS_DECL WHITESPACE name WHITESPACE (CLASS_START | LIST_START) classElement ((CLASS_SEP | LIST_SEP) classElement)* CLASS_SEP? LIST_END;
classElement: elementRef | text;
featureDecl:
    FEATURE_DECL WHITESPACE (
        (plusFeature (LIST_SEP plusFeature)*) |
        ((featureModifier WHITESPACE)? name WHITESPACE? O_PAREN (nullAlias LIST_SEP)? featureValue (LIST_SEP featureValue)* C_PAREN)
    );
featureModifier: SYLLABLE_FEATURE;
plusFeature: (featureModifier WHITESPACE)? AT_LEAST_ONE? name;
nullAlias: NULL featureValue;
diacriticDecl:
    DIACRITIC_DECL WHITESPACE text WHITESPACE
    (diacriticModifier WHITESPACE)* matrix (WHITESPACE diacriticModifier)*;
diacriticModifier: DIA_BEFORE | DIA_FIRST | DIA_FLOATING;
symbolDecl: SYMBOL_DECL WHITESPACE symbolName ((LIST_SEP symbolName)* | WHITESPACE matrix);
symbolName: text;

syllableDecl:
    SYLLABLE_DECL RULE_START (NEWLINE+ (EXPLICIT_SYLLABLES | CLEAR_SYLLABLES) | (NEWLINE+ syllableExpression)+);
syllableExpression: syllablePattern (CHANGE matrix)? compoundEnvironment?;
syllablePattern: structuredPattern | ruleElement;
structuredPattern:
    (reluctantOnset QMARK_COLON)?
    unconditionalRuleElement DOUBLE_COLON
    unconditionalRuleElement (DOUBLE_COLON unconditionalRuleElement)?;
reluctantOnset: unconditionalRuleElement;

deromanizer: DEROMANIZER (WHITESPACE LITERAL)? RULE_START NEWLINE+ block;
romanizer: ROMANIZER (WHITESPACE LITERAL)? RULE_START NEWLINE+ block;
interRomanizer: ROMANIZER HYPHEN ruleName (WHITESPACE LITERAL)? RULE_START NEWLINE+ block;

changeRule: ruleName (WHITESPACE changeRuleModifier)* RULE_START? NEWLINE+ block;
filter: elementRef | fancyMatrix;
block: blockElement (NEWLINE+ blockType RULE_START (WHITESPACE | NEWLINE+) blockElement)*;
blockElement: expressionList | O_PAREN NEWLINE* block NEWLINE* C_PAREN;
blockType: (ALL_MATCHING | FIRST_MATCHING) (WHITESPACE changeRuleModifier)*;
changeRuleModifier: filter | keywordModifier;
keywordModifier: LTR | RTL | PROPAGATE | BLOCK | CLEANUP | NAME;
expressionList: expression (NEWLINE+ expression)*;
ruleName: name (HYPHEN (name | NUMBER))*;

expression: keywordExpression | blockRef | standardExpression;
keywordExpression: UNCHANGED | OFF;
blockRef: RULE_START ruleName;
standardExpression: from CHANGE to compoundEnvironment?;
from: ruleElement;
to: unconditionalRuleElement;

ruleElement: unconditionalRuleElement compoundEnvironment?;
unconditionalRuleElement: bounded | interfix | negated | postfix | simple | sequence;

// "Bounded" elements have a clear start and end symbol
bounded: group | list;
group: O_PAREN ruleElement C_PAREN;
list: LIST_START ruleElement (LIST_SEP ruleElement)* LIST_END;

// "Free" elements have sub-elements floating free amid whitespace
sequence: freeElement (WHITESPACE freeElement)+;
freeElement: bounded | interfix | negated | postfix | simple;

compoundEnvironment: condition | exclusion | (condition exclusion);
condition: CONDITION (environment | environmentList);
exclusion: EXCLUSION (environment | environmentList);
environmentList: LIST_START environment (LIST_SEP environment)* LIST_END;
environment:
    (environmentBefore WHITESPACE)? ANCHOR (WHITESPACE environmentAfter)?
    | environmentBefore?;
environmentBefore: unconditionalRuleElement;
environmentAfter: unconditionalRuleElement;

// "Interfix" elements use a delimiter but no whitespace or boundary marker
interfix: interfixElement (interfixType interfixElement)+;
interfixType: INTERSECTION | INTERSECTION_NOT | TRANSFORMING;
interfixElement: bounded | negated | postfix | simple;

// "Prefix" elements use a prefix operator
negated: NEGATION (bounded | simple);

// "Postfix" elements use a postfix operator
postfix: capture | repeater;
capture: (bounded | negated | simple) captureRef;
repeater: (bounded | simple) repeaterType;

// "Simple" elements can't have other elements inside them
simple: anySyllable | elementRef | captureRef | fancyMatrix | empty | sylBoundary | boundary | betweenWords | text;
anySyllable: ANY_SYLLABLE;
elementRef: CLASSREF name;
captureRef: INEXACT? WORD_BOUNDARY SYLLABLE_BOUNDARY? NUMBER;

fancyMatrix: MATRIX_START fancyValue? (WHITESPACE fancyValue)* MATRIX_END;
fancyValue: matrixValue | negatedValue | absentFeature | featureVariable;
negatedValue: NEGATION matrixValue;
absentFeature: NULL name;
featureVariable: WORD_BOUNDARY name;

empty: NULL;
sylBoundary: SYLLABLE_BOUNDARY;
boundary: WORD_BOUNDARY;
betweenWords: BETWEEN_WORDS;
repeaterType: repeatRange | AT_LEAST_ONE | NULL | OPTIONAL;
repeatRange: NULL (NUMBER | (O_PAREN lowerBound? HYPHEN upperBound? C_PAREN));
lowerBound: NUMBER;
upperBound: NUMBER;
matrix: MATRIX_START matrixValue? (WHITESPACE matrixValue)* MATRIX_END;
matrixValue: plusFeatureValue | featureValue;
plusFeatureValue: (AT_LEAST_ONE | HYPHEN) name;
featureValue: name;
text: (name | STR1 | STR) NEGATION?;
name:
    NAME |
    ELEMENT_DECL | CLASS_DECL | FEATURE_DECL | DIACRITIC_DECL | SYMBOL_DECL |
    SYLLABLE_DECL | CLEAR_SYLLABLES | EXPLICIT_SYLLABLES |
    DEROMANIZER | ROMANIZER | LITERAL |
    ALL_MATCHING | FIRST_MATCHING |
    LTR | RTL | PROPAGATE | BLOCK | CLEANUP |
    OFF | UNCHANGED;

COMMENT: (WHITESPACE? COMMENT_START ~[\n\r]*) -> skip;
LIST_SEP: ',' WHITESPACE?;
CLASS_SEP: ',' (WHITESPACE | NEWLINE)?;
CHANGE: WHITESPACE? '=>' (WHITESPACE | NEWLINE)?;
CONDITION: WHITESPACE? '/' (WHITESPACE | NEWLINE)?;
EXCLUSION: WHITESPACE? '//' (WHITESPACE | NEWLINE)?;
ANCHOR: '_';
NEWLINE: WHITESPACE? ('\r\n' | '\n') WHITESPACE?;
WHITESPACE: ~[\P{White_Space}\r\n]+;
O_PAREN: '(' WHITESPACE?;
C_PAREN:  WHITESPACE? ')';
NULL: '*';
MATRIX_START: '[' WHITESPACE?;
MATRIX_END:  WHITESPACE? ']';
LIST_START: '{' WHITESPACE?;
CLASS_START: '{' NEWLINE?;
LIST_END:  WHITESPACE? '}';
AT_LEAST_ONE: '+';
OPTIONAL: '?';
HYPHEN: '-';
RULE_START: ':';
DOUBLE_COLON: WHITESPACE? '::' WHITESPACE?;
QMARK_COLON: WHITESPACE? '?:' WHITESPACE?;
INEXACT: '~';
NEGATION: '!';
SYLLABLE_BOUNDARY: '.';
WORD_BOUNDARY: '$';
BETWEEN_WORDS: '$$';
CLASSREF: '@';
INTERSECTION: '&';
INTERSECTION_NOT: '&!';
TRANSFORMING: '>';
ELEMENT_DECL: 'Element' | 'element';
CLASS_DECL: 'Class' | 'class';
FEATURE_DECL: 'Feature' | 'feature';
SYLLABLE_FEATURE: '(Syllable)' | '(syllable)';
DIACRITIC_DECL: 'Diacritic' | 'diacritic';
DIA_BEFORE: '(Before)' | '(before)';
DIA_FIRST: '(First)' | '(first)';
DIA_FLOATING: '(Floating)' | '(floating)';
SYMBOL_DECL: 'Symbol' | 'symbol';
SYLLABLE_DECL: 'Syllables' | 'syllables';
EXPLICIT_SYLLABLES: 'Explicit' | 'explicit';
CLEAR_SYLLABLES: 'Clear' | 'clear';
ANY_SYLLABLE: '<Syl>' | '<syl>';
DEROMANIZER: 'Deromanizer' | 'deromanizer';
ROMANIZER: 'Romanizer' | 'romanizer';
ALL_MATCHING: 'Then' | 'then';
FIRST_MATCHING: 'Else' | 'else';
LITERAL: 'Literal' | 'literal';
LTR: 'LTR' | 'Ltr' | 'ltr';
RTL: 'RTL' | 'Rtl' | 'rtl';
PROPAGATE: 'Propagate' | 'propagate';
CLEANUP: 'Cleanup' | 'cleanup';
BLOCK: 'Defer' | 'defer';
UNCHANGED: 'Unchanged' | 'unchanged';
OFF: 'Off' | 'off';
NUMBER: DIGIT+;
NAME: CHAR+;
STR1: ANY;
STR: ANY+;

fragment CHAR: [A-Za-z0-9];
fragment DIGIT: [0-9];
fragment ANY: ('\\' .) | ~[ \\,.=>()*[\]{}+?/\-_:!~$@#&\n\r];
fragment COMMENT_START: '#';
