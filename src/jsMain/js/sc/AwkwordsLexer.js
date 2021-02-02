// Generated from Awkwords.g4 by ANTLR 4.7.2
// jshint ignore: start
var antlr4 = require('antlr4/index');



var serializedATN = ["\u0003\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964",
    "\u0002\u0012S\b\u0001\u0004\u0002\t\u0002\u0004\u0003\t\u0003\u0004",
    "\u0004\t\u0004\u0004\u0005\t\u0005\u0004\u0006\t\u0006\u0004\u0007\t",
    "\u0007\u0004\b\t\b\u0004\t\t\t\u0004\n\t\n\u0004\u000b\t\u000b\u0004",
    "\f\t\f\u0004\r\t\r\u0004\u000e\t\u000e\u0004\u000f\t\u000f\u0004\u0010",
    "\t\u0010\u0004\u0011\t\u0011\u0004\u0012\t\u0012\u0003\u0002\u0003\u0002",
    "\u0007\u0002(\n\u0002\f\u0002\u000e\u0002+\u000b\u0002\u0003\u0002\u0003",
    "\u0002\u0003\u0003\u0003\u0003\u0003\u0004\u0003\u0004\u0003\u0005\u0003",
    "\u0005\u0003\u0006\u0003\u0006\u0003\u0007\u0003\u0007\u0003\b\u0003",
    "\b\u0003\t\u0003\t\u0003\n\u0003\n\u0003\u000b\u0003\u000b\u0003\f\u0003",
    "\f\u0003\r\u0003\r\u0003\u000e\u0003\u000e\u0003\u000e\u0003\u000f\u0003",
    "\u000f\u0003\u000f\u0003\u0010\u0003\u0010\u0003\u0011\u0003\u0011\u0003",
    "\u0011\u0005\u0011P\n\u0011\u0003\u0012\u0003\u0012\u0002\u0002\u0013",
    "\u0003\u0003\u0005\u0004\u0007\u0005\t\u0006\u000b\u0007\r\b\u000f\t",
    "\u0011\n\u0013\u000b\u0015\f\u0017\r\u0019\u000e\u001b\u000f\u001d\u0010",
    "\u001f\u0011!\u0012#\u0002\u0003\u0002\u0006\u0004\u0002\f\f\u000f\u000f",
    "\t\u0002\f\f\u000f\u000f$$*,1<C]_`\u0003\u0002C\\\u0003\u00022;\u0002",
    "S\u0002\u0003\u0003\u0002\u0002\u0002\u0002\u0005\u0003\u0002\u0002",
    "\u0002\u0002\u0007\u0003\u0002\u0002\u0002\u0002\t\u0003\u0002\u0002",
    "\u0002\u0002\u000b\u0003\u0002\u0002\u0002\u0002\r\u0003\u0002\u0002",
    "\u0002\u0002\u000f\u0003\u0002\u0002\u0002\u0002\u0011\u0003\u0002\u0002",
    "\u0002\u0002\u0013\u0003\u0002\u0002\u0002\u0002\u0015\u0003\u0002\u0002",
    "\u0002\u0002\u0017\u0003\u0002\u0002\u0002\u0002\u0019\u0003\u0002\u0002",
    "\u0002\u0002\u001b\u0003\u0002\u0002\u0002\u0002\u001d\u0003\u0002\u0002",
    "\u0002\u0002\u001f\u0003\u0002\u0002\u0002\u0002!\u0003\u0002\u0002",
    "\u0002\u0003%\u0003\u0002\u0002\u0002\u0005.\u0003\u0002\u0002\u0002",
    "\u00070\u0003\u0002\u0002\u0002\t2\u0003\u0002\u0002\u0002\u000b4\u0003",
    "\u0002\u0002\u0002\r6\u0003\u0002\u0002\u0002\u000f8\u0003\u0002\u0002",
    "\u0002\u0011:\u0003\u0002\u0002\u0002\u0013<\u0003\u0002\u0002\u0002",
    "\u0015>\u0003\u0002\u0002\u0002\u0017@\u0003\u0002\u0002\u0002\u0019",
    "B\u0003\u0002\u0002\u0002\u001bD\u0003\u0002\u0002\u0002\u001dG\u0003",
    "\u0002\u0002\u0002\u001fJ\u0003\u0002\u0002\u0002!O\u0003\u0002\u0002",
    "\u0002#Q\u0003\u0002\u0002\u0002%)\u0005#\u0012\u0002&(\n\u0002\u0002",
    "\u0002\'&\u0003\u0002\u0002\u0002(+\u0003\u0002\u0002\u0002)\'\u0003",
    "\u0002\u0002\u0002)*\u0003\u0002\u0002\u0002*,\u0003\u0002\u0002\u0002",
    "+)\u0003\u0002\u0002\u0002,-\b\u0002\u0002\u0002-\u0004\u0003\u0002",
    "\u0002\u0002./\n\u0003\u0002\u0002/\u0006\u0003\u0002\u0002\u000201",
    "\t\u0004\u0002\u00021\b\u0003\u0002\u0002\u000223\u00071\u0002\u0002",
    "3\n\u0003\u0002\u0002\u000245\u0007*\u0002\u00025\f\u0003\u0002\u0002",
    "\u000267\u0007+\u0002\u00027\u000e\u0003\u0002\u0002\u000289\u0007]",
    "\u0002\u00029\u0010\u0003\u0002\u0002\u0002:;\u0007_\u0002\u0002;\u0012",
    "\u0003\u0002\u0002\u0002<=\u0007,\u0002\u0002=\u0014\u0003\u0002\u0002",
    "\u0002>?\u0007`\u0002\u0002?\u0016\u0003\u0002\u0002\u0002@A\u0007$",
    "\u0002\u0002A\u0018\u0003\u0002\u0002\u0002BC\u0007<\u0002\u0002C\u001a",
    "\u0003\u0002\u0002\u0002DE\u0007t\u0002\u0002EF\u0007<\u0002\u0002F",
    "\u001c\u0003\u0002\u0002\u0002GH\u0007p\u0002\u0002HI\u0007<\u0002\u0002",
    "I\u001e\u0003\u0002\u0002\u0002JK\t\u0005\u0002\u0002K \u0003\u0002",
    "\u0002\u0002LM\u0007\u000f\u0002\u0002MP\u0007\f\u0002\u0002NP\u0007",
    "\f\u0002\u0002OL\u0003\u0002\u0002\u0002ON\u0003\u0002\u0002\u0002P",
    "\"\u0003\u0002\u0002\u0002QR\u0007%\u0002\u0002R$\u0003\u0002\u0002",
    "\u0002\u0005\u0002)O\u0003\b\u0002\u0002"].join("");


var atn = new antlr4.atn.ATNDeserializer().deserialize(serializedATN);

var decisionsToDFA = atn.decisionToState.map( function(ds, index) { return new antlr4.dfa.DFA(ds, index); });

function AwkwordsLexer(input) {
	antlr4.Lexer.call(this, input);
    this._interp = new antlr4.atn.LexerATNSimulator(this, atn, decisionsToDFA, new antlr4.PredictionContextCache());
    return this;
}

AwkwordsLexer.prototype = Object.create(antlr4.Lexer.prototype);
AwkwordsLexer.prototype.constructor = AwkwordsLexer;

Object.defineProperty(AwkwordsLexer.prototype, "atn", {
        get : function() {
                return atn;
        }
});

AwkwordsLexer.EOF = antlr4.Token.EOF;
AwkwordsLexer.COMMENT = 1;
AwkwordsLexer.ATOM = 2;
AwkwordsLexer.SUBREF = 3;
AwkwordsLexer.ALTSEP = 4;
AwkwordsLexer.OPSTART = 5;
AwkwordsLexer.OPEND = 6;
AwkwordsLexer.GROUPSTART = 7;
AwkwordsLexer.GROUPEND = 8;
AwkwordsLexer.WEIGHT = 9;
AwkwordsLexer.FILTERSEP = 10;
AwkwordsLexer.ESCAPE = 11;
AwkwordsLexer.SUBPATSTART = 12;
AwkwordsLexer.TEMPLATESTART = 13;
AwkwordsLexer.NUMWORDSSTART = 14;
AwkwordsLexer.DIGIT = 15;
AwkwordsLexer.NEWLINE = 16;

AwkwordsLexer.prototype.channelNames = [ "DEFAULT_TOKEN_CHANNEL", "HIDDEN" ];

AwkwordsLexer.prototype.modeNames = [ "DEFAULT_MODE" ];

AwkwordsLexer.prototype.literalNames = [ null, null, null, null, "'/'", 
                                         "'('", "')'", "'['", "']'", "'*'", 
                                         "'^'", "'\"'", "':'", "'r:'", "'n:'" ];

AwkwordsLexer.prototype.symbolicNames = [ null, "COMMENT", "ATOM", "SUBREF", 
                                          "ALTSEP", "OPSTART", "OPEND", 
                                          "GROUPSTART", "GROUPEND", "WEIGHT", 
                                          "FILTERSEP", "ESCAPE", "SUBPATSTART", 
                                          "TEMPLATESTART", "NUMWORDSSTART", 
                                          "DIGIT", "NEWLINE" ];

AwkwordsLexer.prototype.ruleNames = [ "COMMENT", "ATOM", "SUBREF", "ALTSEP", 
                                      "OPSTART", "OPEND", "GROUPSTART", 
                                      "GROUPEND", "WEIGHT", "FILTERSEP", 
                                      "ESCAPE", "SUBPATSTART", "TEMPLATESTART", 
                                      "NUMWORDSSTART", "DIGIT", "NEWLINE", 
                                      "COMMENTSTART" ];

AwkwordsLexer.prototype.grammarFileName = "Awkwords.g4";



exports.AwkwordsLexer = AwkwordsLexer;

