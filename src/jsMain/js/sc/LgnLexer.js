// Generated from Lgn.g4 by ANTLR 4.7.2
// jshint ignore: start
var antlr4 = require('antlr4/index');



var serializedATN = ["\u0003\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964",
    "\u0002\u000e_\b\u0001\u0004\u0002\t\u0002\u0004\u0003\t\u0003\u0004",
    "\u0004\t\u0004\u0004\u0005\t\u0005\u0004\u0006\t\u0006\u0004\u0007\t",
    "\u0007\u0004\b\t\b\u0004\t\t\t\u0004\n\t\n\u0004\u000b\t\u000b\u0004",
    "\f\t\f\u0004\r\t\r\u0004\u000e\t\u000e\u0004\u000f\t\u000f\u0004\u0010",
    "\t\u0010\u0003\u0002\u0003\u0002\u0005\u0002$\n\u0002\u0003\u0003\u0006",
    "\u0003\'\n\u0003\r\u0003\u000e\u0003(\u0003\u0004\u0005\u0004,\n\u0004",
    "\u0003\u0004\u0003\u0004\u0003\u0004\u0005\u00041\n\u0004\u0003\u0004",
    "\u0005\u00044\n\u0004\u0003\u0005\u0003\u0005\u0003\u0006\u0003\u0006",
    "\u0003\u0007\u0003\u0007\u0003\b\u0003\b\u0003\t\u0003\t\u0003\n\u0003",
    "\n\u0003\n\u0003\n\u0003\n\u0003\n\u0003\u000b\u0003\u000b\u0003\u000b",
    "\u0003\u000b\u0003\u000b\u0003\u000b\u0003\u000b\u0003\u000b\u0003\f",
    "\u0003\f\u0007\fP\n\f\f\f\u000e\fS\u000b\f\u0003\r\u0006\rV\n\r\r\r",
    "\u000e\rW\u0003\u000e\u0003\u000e\u0003\u000f\u0003\u000f\u0003\u0010",
    "\u0003\u0010\u0002\u0002\u0011\u0003\u0003\u0005\u0004\u0007\u0005\t",
    "\u0006\u000b\u0007\r\b\u000f\t\u0011\n\u0013\u000b\u0015\f\u0017\r\u0019",
    "\u000e\u001b\u0002\u001d\u0002\u001f\u0002\u0003\u0002\u0005\u0003\u0002",
    "c|\u0005\u00022;C\\c|\u000f\u0002\f\f\u000f\u000f\"#%&*/11<<?B]]__a",
    "a}}\u007f\u007f\u0002b\u0002\u0003\u0003\u0002\u0002\u0002\u0002\u0005",
    "\u0003\u0002\u0002\u0002\u0002\u0007\u0003\u0002\u0002\u0002\u0002\t",
    "\u0003\u0002\u0002\u0002\u0002\u000b\u0003\u0002\u0002\u0002\u0002\r",
    "\u0003\u0002\u0002\u0002\u0002\u000f\u0003\u0002\u0002\u0002\u0002\u0011",
    "\u0003\u0002\u0002\u0002\u0002\u0013\u0003\u0002\u0002\u0002\u0002\u0015",
    "\u0003\u0002\u0002\u0002\u0002\u0017\u0003\u0002\u0002\u0002\u0002\u0019",
    "\u0003\u0002\u0002\u0002\u0003!\u0003\u0002\u0002\u0002\u0005&\u0003",
    "\u0002\u0002\u0002\u0007+\u0003\u0002\u0002\u0002\t5\u0003\u0002\u0002",
    "\u0002\u000b7\u0003\u0002\u0002\u0002\r9\u0003\u0002\u0002\u0002\u000f",
    ";\u0003\u0002\u0002\u0002\u0011=\u0003\u0002\u0002\u0002\u0013?\u0003",
    "\u0002\u0002\u0002\u0015E\u0003\u0002\u0002\u0002\u0017M\u0003\u0002",
    "\u0002\u0002\u0019U\u0003\u0002\u0002\u0002\u001bY\u0003\u0002\u0002",
    "\u0002\u001d[\u0003\u0002\u0002\u0002\u001f]\u0003\u0002\u0002\u0002",
    "!#\u0007.\u0002\u0002\"$\u0005\u0005\u0003\u0002#\"\u0003\u0002\u0002",
    "\u0002#$\u0003\u0002\u0002\u0002$\u0004\u0003\u0002\u0002\u0002%\'\u0007",
    "\"\u0002\u0002&%\u0003\u0002\u0002\u0002\'(\u0003\u0002\u0002\u0002",
    "(&\u0003\u0002\u0002\u0002()\u0003\u0002\u0002\u0002)\u0006\u0003\u0002",
    "\u0002\u0002*,\u0005\u0005\u0003\u0002+*\u0003\u0002\u0002\u0002+,\u0003",
    "\u0002\u0002\u0002,0\u0003\u0002\u0002\u0002-.\u0007\u000f\u0002\u0002",
    ".1\u0007\f\u0002\u0002/1\u0007\f\u0002\u00020-\u0003\u0002\u0002\u0002",
    "0/\u0003\u0002\u0002\u000213\u0003\u0002\u0002\u000224\u0005\u0005\u0003",
    "\u000232\u0003\u0002\u0002\u000234\u0003\u0002\u0002\u00024\b\u0003",
    "\u0002\u0002\u000256\u0007}\u0002\u00026\n\u0003\u0002\u0002\u00027",
    "8\u0007\u007f\u0002\u00028\f\u0003\u0002\u0002\u00029:\u0007A\u0002",
    "\u0002:\u000e\u0003\u0002\u0002\u0002;<\u0007B\u0002\u0002<\u0010\u0003",
    "\u0002\u0002\u0002=>\u0007<\u0002\u0002>\u0012\u0003\u0002\u0002\u0002",
    "?@\u0007E\u0002\u0002@A\u0007n\u0002\u0002AB\u0007c\u0002\u0002BC\u0007",
    "u\u0002\u0002CD\u0007u\u0002\u0002D\u0014\u0003\u0002\u0002\u0002EF",
    "\u0007R\u0002\u0002FG\u0007c\u0002\u0002GH\u0007v\u0002\u0002HI\u0007",
    "v\u0002\u0002IJ\u0007g\u0002\u0002JK\u0007t\u0002\u0002KL\u0007p\u0002",
    "\u0002L\u0016\u0003\u0002\u0002\u0002MQ\u0005\u001b\u000e\u0002NP\u0005",
    "\u001d\u000f\u0002ON\u0003\u0002\u0002\u0002PS\u0003\u0002\u0002\u0002",
    "QO\u0003\u0002\u0002\u0002QR\u0003\u0002\u0002\u0002R\u0018\u0003\u0002",
    "\u0002\u0002SQ\u0003\u0002\u0002\u0002TV\u0005\u001f\u0010\u0002UT\u0003",
    "\u0002\u0002\u0002VW\u0003\u0002\u0002\u0002WU\u0003\u0002\u0002\u0002",
    "WX\u0003\u0002\u0002\u0002X\u001a\u0003\u0002\u0002\u0002YZ\t\u0002",
    "\u0002\u0002Z\u001c\u0003\u0002\u0002\u0002[\\\t\u0003\u0002\u0002\\",
    "\u001e\u0003\u0002\u0002\u0002]^\n\u0004\u0002\u0002^ \u0003\u0002\u0002",
    "\u0002\n\u0002#(+03QW\u0002"].join("");


var atn = new antlr4.atn.ATNDeserializer().deserialize(serializedATN);

var decisionsToDFA = atn.decisionToState.map( function(ds, index) { return new antlr4.dfa.DFA(ds, index); });

function LgnLexer(input) {
	antlr4.Lexer.call(this, input);
    this._interp = new antlr4.atn.LexerATNSimulator(this, atn, decisionsToDFA, new antlr4.PredictionContextCache());
    return this;
}

LgnLexer.prototype = Object.create(antlr4.Lexer.prototype);
LgnLexer.prototype.constructor = LgnLexer;

Object.defineProperty(LgnLexer.prototype, "atn", {
        get : function() {
                return atn;
        }
});

LgnLexer.EOF = antlr4.Token.EOF;
LgnLexer.SEP = 1;
LgnLexer.WHITESPACE = 2;
LgnLexer.NEWLINE = 3;
LgnLexer.LISTSTART = 4;
LgnLexer.LISTEND = 5;
LgnLexer.OPTIONAL = 6;
LgnLexer.CLASSREF = 7;
LgnLexer.BLOCKSTART = 8;
LgnLexer.CLASSDECL = 9;
LgnLexer.PATTERNDECL = 10;
LgnLexer.NAME = 11;
LgnLexer.STR = 12;

LgnLexer.prototype.channelNames = [ "DEFAULT_TOKEN_CHANNEL", "HIDDEN" ];

LgnLexer.prototype.modeNames = [ "DEFAULT_MODE" ];

LgnLexer.prototype.literalNames = [ null, null, null, null, "'{'", "'}'", 
                                    "'?'", "'@'", "':'", "'Class'", "'Pattern'" ];

LgnLexer.prototype.symbolicNames = [ null, "SEP", "WHITESPACE", "NEWLINE", 
                                     "LISTSTART", "LISTEND", "OPTIONAL", 
                                     "CLASSREF", "BLOCKSTART", "CLASSDECL", 
                                     "PATTERNDECL", "NAME", "STR" ];

LgnLexer.prototype.ruleNames = [ "SEP", "WHITESPACE", "NEWLINE", "LISTSTART", 
                                 "LISTEND", "OPTIONAL", "CLASSREF", "BLOCKSTART", 
                                 "CLASSDECL", "PATTERNDECL", "NAME", "STR", 
                                 "LOWER", "CHAR", "ANY" ];

LgnLexer.prototype.grammarFileName = "Lgn.g4";



exports.LgnLexer = LgnLexer;

