grammar Meta;

g4File: GRAMMAR WHITESPACE GRAMMAR_NAME END NEWLINE+ antlrRule (NEWLINE+ antlrRule)* END_JUNK EOF;
antlrRule: ruleName START expression END;
expression: group | repeater | simple | sequence | alts;
sequence: sequenceElement ((WHITESPACE | NEWLINE) sequenceElement)*;
sequenceElement: group | repeater | simple;
alts: altElement (ALT_SEP altElement)*;
altElement: group | repeater | simple | sequence;
group: O_PAREN expression C_PAREN;
repeater: (group | simple) repeaterType;
repeaterType: AT_LEAST_ONE | ANY_NUMBER | OPTIONAL;
simple: ruleName | tokenName;
ruleName: RULE_NAME;
tokenName: TOKEN_NAME;

COMMENT: (WHITESPACE? COMMENT_START ~[\n\r]*) -> skip;
COMMENT_START: '//';
NEWLINE: WHITESPACE? ('\r\n' | '\n') WHITESPACE?;
WHITESPACE: ' '+;
GRAMMAR: 'grammar';
GRAMMAR_NAME: UPPER LOWER+;
RULE_NAME: LOWER UPPER_OR_LOWER+;
TOKEN_NAME: UPPER UPPER_OR_UNDER+;
START: ':' WHITESPACE? NEWLINE?;
END: ';';
ALT_SEP: WHITESPACE? NEWLINE? '|' WHITESPACE? NEWLINE?;
O_PAREN: '(' NEWLINE?;
C_PAREN: NEWLINE? ')';
AT_LEAST_ONE: '+';
ANY_NUMBER: '*';
OPTIONAL: '?';
END_JUNK: NEWLINE+ UPPER+ START ANY*;

fragment UPPER: [A-Z];
fragment LOWER: [a-z];
fragment UPPER_OR_LOWER: [A-Za-z0-9];
fragment UPPER_OR_UNDER: [A-Z0-9_];
fragment ANY: .;