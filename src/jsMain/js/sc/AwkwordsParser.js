// Generated from Awkwords.g4 by ANTLR 4.7.2
// jshint ignore: start
var antlr4 = require('antlr4/index');
var AwkwordsVisitor = require('./AwkwordsVisitor').AwkwordsVisitor;

var grammarFileName = "Awkwords.g4";


var serializedATN = ["\u0003\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964",
    "\u0003\u0012\u00a0\u0004\u0002\t\u0002\u0004\u0003\t\u0003\u0004\u0004",
    "\t\u0004\u0004\u0005\t\u0005\u0004\u0006\t\u0006\u0004\u0007\t\u0007",
    "\u0004\b\t\b\u0004\t\t\t\u0004\n\t\n\u0004\u000b\t\u000b\u0004\f\t\f",
    "\u0004\r\t\r\u0004\u000e\t\u000e\u0004\u000f\t\u000f\u0004\u0010\t\u0010",
    "\u0004\u0011\t\u0011\u0004\u0012\t\u0012\u0003\u0002\u0007\u0002&\n",
    "\u0002\f\u0002\u000e\u0002)\u000b\u0002\u0003\u0002\u0007\u0002,\n\u0002",
    "\f\u0002\u000e\u0002/\u000b\u0002\u0003\u0002\u0007\u00022\n\u0002\f",
    "\u0002\u000e\u00025\u000b\u0002\u0003\u0002\u0003\u0002\u0003\u0002",
    "\u0007\u0002:\n\u0002\f\u0002\u000e\u0002=\u000b\u0002\u0003\u0002\u0003",
    "\u0002\u0005\u0002A\n\u0002\u0003\u0002\u0005\u0002D\n\u0002\u0003\u0002",
    "\u0003\u0002\u0003\u0003\u0003\u0003\u0003\u0003\u0003\u0004\u0003\u0004",
    "\u0003\u0004\u0003\u0004\u0003\u0004\u0003\u0005\u0003\u0005\u0003\u0005",
    "\u0003\u0005\u0003\u0005\u0003\u0005\u0003\u0005\u0003\u0005\u0005\u0005",
    "X\n\u0005\u0003\u0006\u0003\u0006\u0003\u0006\u0006\u0006]\n\u0006\r",
    "\u0006\u000e\u0006^\u0003\u0007\u0003\u0007\u0003\u0007\u0005\u0007",
    "d\n\u0007\u0003\b\u0003\b\u0003\b\u0003\b\u0003\b\u0003\b\u0003\b\u0005",
    "\bm\n\b\u0003\t\u0003\t\u0003\t\u0006\tr\n\t\r\t\u000e\ts\u0003\n\u0006",
    "\nw\n\n\r\n\u000e\nx\u0003\u000b\u0003\u000b\u0003\u000b\u0003\u000b",
    "\u0003\f\u0003\f\u0003\f\u0003\f\u0003\f\u0003\f\u0006\f\u0085\n\f\r",
    "\f\u000e\f\u0086\u0003\r\u0003\r\u0003\r\u0003\r\u0003\u000e\u0003\u000e",
    "\u0006\u000e\u008f\n\u000e\r\u000e\u000e\u000e\u0090\u0003\u000e\u0003",
    "\u000e\u0003\u000f\u0003\u000f\u0003\u0010\u0003\u0010\u0003\u0011\u0003",
    "\u0011\u0003\u0012\u0006\u0012\u009c\n\u0012\r\u0012\u000e\u0012\u009d",
    "\u0003\u0012\u0002\u0002\u0013\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012",
    "\u0014\u0016\u0018\u001a\u001c\u001e \"\u0002\u0004\u0004\u0002\u0004",
    "\f\u000e\u000e\u0005\u0002\u0004\u0004\u000e\u000e\u0011\u0011\u0002",
    "\u00ad\u0002-\u0003\u0002\u0002\u0002\u0004G\u0003\u0002\u0002\u0002",
    "\u0006J\u0003\u0002\u0002\u0002\bW\u0003\u0002\u0002\u0002\nY\u0003",
    "\u0002\u0002\u0002\f`\u0003\u0002\u0002\u0002\u000el\u0003\u0002\u0002",
    "\u0002\u0010n\u0003\u0002\u0002\u0002\u0012v\u0003\u0002\u0002\u0002",
    "\u0014z\u0003\u0002\u0002\u0002\u0016\u0084\u0003\u0002\u0002\u0002",
    "\u0018\u0088\u0003\u0002\u0002\u0002\u001a\u008c\u0003\u0002\u0002\u0002",
    "\u001c\u0094\u0003\u0002\u0002\u0002\u001e\u0096\u0003\u0002\u0002\u0002",
    " \u0098\u0003\u0002\u0002\u0002\"\u009b\u0003\u0002\u0002\u0002$&\u0007",
    "\u0012\u0002\u0002%$\u0003\u0002\u0002\u0002&)\u0003\u0002\u0002\u0002",
    "\'%\u0003\u0002\u0002\u0002\'(\u0003\u0002\u0002\u0002(*\u0003\u0002",
    "\u0002\u0002)\'\u0003\u0002\u0002\u0002*,\u0005\u0006\u0004\u0002+\'",
    "\u0003\u0002\u0002\u0002,/\u0003\u0002\u0002\u0002-+\u0003\u0002\u0002",
    "\u0002-.\u0003\u0002\u0002\u0002.3\u0003\u0002\u0002\u0002/-\u0003\u0002",
    "\u0002\u000202\u0007\u0012\u0002\u000210\u0003\u0002\u0002\u000225\u0003",
    "\u0002\u0002\u000231\u0003\u0002\u0002\u000234\u0003\u0002\u0002\u0002",
    "46\u0003\u0002\u0002\u000253\u0003\u0002\u0002\u000267\u0007\u000f\u0002",
    "\u00027;\u0005\b\u0005\u00028:\u0007\u0012\u0002\u000298\u0003\u0002",
    "\u0002\u0002:=\u0003\u0002\u0002\u0002;9\u0003\u0002\u0002\u0002;<\u0003",
    "\u0002\u0002\u0002<@\u0003\u0002\u0002\u0002=;\u0003\u0002\u0002\u0002",
    ">?\u0007\u0012\u0002\u0002?A\u0005\u0004\u0003\u0002@>\u0003\u0002\u0002",
    "\u0002@A\u0003\u0002\u0002\u0002AC\u0003\u0002\u0002\u0002BD\u0007\u0012",
    "\u0002\u0002CB\u0003\u0002\u0002\u0002CD\u0003\u0002\u0002\u0002DE\u0003",
    "\u0002\u0002\u0002EF\u0007\u0002\u0002\u0003F\u0003\u0003\u0002\u0002",
    "\u0002GH\u0007\u0010\u0002\u0002HI\u0005\"\u0012\u0002I\u0005\u0003",
    "\u0002\u0002\u0002JK\u0007\u0005\u0002\u0002KL\u0007\u000e\u0002\u0002",
    "LM\u0005\b\u0005\u0002MN\u0007\u0012\u0002\u0002N\u0007\u0003\u0002",
    "\u0002\u0002OX\u0005\u0010\t\u0002PX\u0005\u0018\r\u0002QX\u0005\u001a",
    "\u000e\u0002RX\u0005\u0014\u000b\u0002SX\u0005\u001c\u000f\u0002TX\u0005",
    " \u0011\u0002UX\u0005\n\u0006\u0002VX\u0005\u0016\f\u0002WO\u0003\u0002",
    "\u0002\u0002WP\u0003\u0002\u0002\u0002WQ\u0003\u0002\u0002\u0002WR\u0003",
    "\u0002\u0002\u0002WS\u0003\u0002\u0002\u0002WT\u0003\u0002\u0002\u0002",
    "WU\u0003\u0002\u0002\u0002WV\u0003\u0002\u0002\u0002X\t\u0003\u0002",
    "\u0002\u0002Y\\\u0005\f\u0007\u0002Z[\u0007\u0006\u0002\u0002[]\u0005",
    "\f\u0007\u0002\\Z\u0003\u0002\u0002\u0002]^\u0003\u0002\u0002\u0002",
    "^\\\u0003\u0002\u0002\u0002^_\u0003\u0002\u0002\u0002_\u000b\u0003\u0002",
    "\u0002\u0002`c\u0005\u000e\b\u0002ab\u0007\u000b\u0002\u0002bd\u0005",
    "\"\u0012\u0002ca\u0003\u0002\u0002\u0002cd\u0003\u0002\u0002\u0002d",
    "\r\u0003\u0002\u0002\u0002em\u0005\u0010\t\u0002fm\u0005\u0018\r\u0002",
    "gm\u0005\u001a\u000e\u0002hm\u0005\u0014\u000b\u0002im\u0005\u001c\u000f",
    "\u0002jm\u0005 \u0011\u0002km\u0005\u0016\f\u0002le\u0003\u0002\u0002",
    "\u0002lf\u0003\u0002\u0002\u0002lg\u0003\u0002\u0002\u0002lh\u0003\u0002",
    "\u0002\u0002li\u0003\u0002\u0002\u0002lj\u0003\u0002\u0002\u0002lk\u0003",
    "\u0002\u0002\u0002m\u000f\u0003\u0002\u0002\u0002nq\u0005\u0018\r\u0002",
    "op\u0007\f\u0002\u0002pr\u0005\u0012\n\u0002qo\u0003\u0002\u0002\u0002",
    "rs\u0003\u0002\u0002\u0002sq\u0003\u0002\u0002\u0002st\u0003\u0002\u0002",
    "\u0002t\u0011\u0003\u0002\u0002\u0002uw\u0005 \u0011\u0002vu\u0003\u0002",
    "\u0002\u0002wx\u0003\u0002\u0002\u0002xv\u0003\u0002\u0002\u0002xy\u0003",
    "\u0002\u0002\u0002y\u0013\u0003\u0002\u0002\u0002z{\u0007\u0007\u0002",
    "\u0002{|\u0005\b\u0005\u0002|}\u0007\b\u0002\u0002}\u0015\u0003\u0002",
    "\u0002\u0002~\u0085\u0005\u0010\t\u0002\u007f\u0085\u0005\u0018\r\u0002",
    "\u0080\u0085\u0005\u001a\u000e\u0002\u0081\u0085\u0005\u0014\u000b\u0002",
    "\u0082\u0085\u0005\u001c\u000f\u0002\u0083\u0085\u0005 \u0011\u0002",
    "\u0084~\u0003\u0002\u0002\u0002\u0084\u007f\u0003\u0002\u0002\u0002",
    "\u0084\u0080\u0003\u0002\u0002\u0002\u0084\u0081\u0003\u0002\u0002\u0002",
    "\u0084\u0082\u0003\u0002\u0002\u0002\u0084\u0083\u0003\u0002\u0002\u0002",
    "\u0085\u0086\u0003\u0002\u0002\u0002\u0086\u0084\u0003\u0002\u0002\u0002",
    "\u0086\u0087\u0003\u0002\u0002\u0002\u0087\u0017\u0003\u0002\u0002\u0002",
    "\u0088\u0089\u0007\t\u0002\u0002\u0089\u008a\u0005\b\u0005\u0002\u008a",
    "\u008b\u0007\n\u0002\u0002\u008b\u0019\u0003\u0002\u0002\u0002\u008c",
    "\u008e\u0007\r\u0002\u0002\u008d\u008f\u0005\u001e\u0010\u0002\u008e",
    "\u008d\u0003\u0002\u0002\u0002\u008f\u0090\u0003\u0002\u0002\u0002\u0090",
    "\u008e\u0003\u0002\u0002\u0002\u0090\u0091\u0003\u0002\u0002\u0002\u0091",
    "\u0092\u0003\u0002\u0002\u0002\u0092\u0093\u0007\r\u0002\u0002\u0093",
    "\u001b\u0003\u0002\u0002\u0002\u0094\u0095\u0007\u0005\u0002\u0002\u0095",
    "\u001d\u0003\u0002\u0002\u0002\u0096\u0097\t\u0002\u0002\u0002\u0097",
    "\u001f\u0003\u0002\u0002\u0002\u0098\u0099\t\u0003\u0002\u0002\u0099",
    "!\u0003\u0002\u0002\u0002\u009a\u009c\u0007\u0011\u0002\u0002\u009b",
    "\u009a\u0003\u0002\u0002\u0002\u009c\u009d\u0003\u0002\u0002\u0002\u009d",
    "\u009b\u0003\u0002\u0002\u0002\u009d\u009e\u0003\u0002\u0002\u0002\u009e",
    "#\u0003\u0002\u0002\u0002\u0012\'-3;@CW^clsx\u0084\u0086\u0090\u009d"].join("");


var atn = new antlr4.atn.ATNDeserializer().deserialize(serializedATN);

var decisionsToDFA = atn.decisionToState.map( function(ds, index) { return new antlr4.dfa.DFA(ds, index); });

var sharedContextCache = new antlr4.PredictionContextCache();

var literalNames = [ null, null, null, null, "'/'", "'('", "')'", "'['", 
                     "']'", "'*'", "'^'", "'\"'", "':'", "'r:'", "'n:'" ];

var symbolicNames = [ null, "COMMENT", "ATOM", "SUBREF", "ALTSEP", "OPSTART", 
                      "OPEND", "GROUPSTART", "GROUPEND", "WEIGHT", "FILTERSEP", 
                      "ESCAPE", "SUBPATSTART", "TEMPLATESTART", "NUMWORDSSTART", 
                      "DIGIT", "NEWLINE" ];

var ruleNames =  [ "awkfile", "numwords", "subpattern", "pattern", "alternative", 
                   "weightedchoice", "altchoice", "filtered", "filterstring", 
                   "optional", "sequence", "group", "escape", "subref", 
                   "anychar", "atom", "number" ];

function AwkwordsParser (input) {
	antlr4.Parser.call(this, input);
    this._interp = new antlr4.atn.ParserATNSimulator(this, atn, decisionsToDFA, sharedContextCache);
    this.ruleNames = ruleNames;
    this.literalNames = literalNames;
    this.symbolicNames = symbolicNames;
    return this;
}

AwkwordsParser.prototype = Object.create(antlr4.Parser.prototype);
AwkwordsParser.prototype.constructor = AwkwordsParser;

Object.defineProperty(AwkwordsParser.prototype, "atn", {
	get : function() {
		return atn;
	}
});

AwkwordsParser.EOF = antlr4.Token.EOF;
AwkwordsParser.COMMENT = 1;
AwkwordsParser.ATOM = 2;
AwkwordsParser.SUBREF = 3;
AwkwordsParser.ALTSEP = 4;
AwkwordsParser.OPSTART = 5;
AwkwordsParser.OPEND = 6;
AwkwordsParser.GROUPSTART = 7;
AwkwordsParser.GROUPEND = 8;
AwkwordsParser.WEIGHT = 9;
AwkwordsParser.FILTERSEP = 10;
AwkwordsParser.ESCAPE = 11;
AwkwordsParser.SUBPATSTART = 12;
AwkwordsParser.TEMPLATESTART = 13;
AwkwordsParser.NUMWORDSSTART = 14;
AwkwordsParser.DIGIT = 15;
AwkwordsParser.NEWLINE = 16;

AwkwordsParser.RULE_awkfile = 0;
AwkwordsParser.RULE_numwords = 1;
AwkwordsParser.RULE_subpattern = 2;
AwkwordsParser.RULE_pattern = 3;
AwkwordsParser.RULE_alternative = 4;
AwkwordsParser.RULE_weightedchoice = 5;
AwkwordsParser.RULE_altchoice = 6;
AwkwordsParser.RULE_filtered = 7;
AwkwordsParser.RULE_filterstring = 8;
AwkwordsParser.RULE_optional = 9;
AwkwordsParser.RULE_sequence = 10;
AwkwordsParser.RULE_group = 11;
AwkwordsParser.RULE_escape = 12;
AwkwordsParser.RULE_subref = 13;
AwkwordsParser.RULE_anychar = 14;
AwkwordsParser.RULE_atom = 15;
AwkwordsParser.RULE_number = 16;


function AwkfileContext(parser, parent, invokingState) {
	if(parent===undefined) {
	    parent = null;
	}
	if(invokingState===undefined || invokingState===null) {
		invokingState = -1;
	}
	antlr4.ParserRuleContext.call(this, parent, invokingState);
    this.parser = parser;
    this.ruleIndex = AwkwordsParser.RULE_awkfile;
    return this;
}

AwkfileContext.prototype = Object.create(antlr4.ParserRuleContext.prototype);
AwkfileContext.prototype.constructor = AwkfileContext;

AwkfileContext.prototype.TEMPLATESTART = function() {
    return this.getToken(AwkwordsParser.TEMPLATESTART, 0);
};

AwkfileContext.prototype.pattern = function() {
    return this.getTypedRuleContext(PatternContext,0);
};

AwkfileContext.prototype.EOF = function() {
    return this.getToken(AwkwordsParser.EOF, 0);
};

AwkfileContext.prototype.subpattern = function(i) {
    if(i===undefined) {
        i = null;
    }
    if(i===null) {
        return this.getTypedRuleContexts(SubpatternContext);
    } else {
        return this.getTypedRuleContext(SubpatternContext,i);
    }
};

AwkfileContext.prototype.NEWLINE = function(i) {
	if(i===undefined) {
		i = null;
	}
    if(i===null) {
        return this.getTokens(AwkwordsParser.NEWLINE);
    } else {
        return this.getToken(AwkwordsParser.NEWLINE, i);
    }
};


AwkfileContext.prototype.numwords = function() {
    return this.getTypedRuleContext(NumwordsContext,0);
};

AwkfileContext.prototype.accept = function(visitor) {
    if ( visitor instanceof AwkwordsVisitor ) {
        return visitor.visitAwkfile(this);
    } else {
        return visitor.visitChildren(this);
    }
};




AwkwordsParser.AwkfileContext = AwkfileContext;

AwkwordsParser.prototype.awkfile = function() {

    var localctx = new AwkfileContext(this, this._ctx, this.state);
    this.enterRule(localctx, 0, AwkwordsParser.RULE_awkfile);
    var _la = 0; // Token type
    try {
        this.enterOuterAlt(localctx, 1);
        this.state = 43;
        this._errHandler.sync(this);
        var _alt = this._interp.adaptivePredict(this._input,1,this._ctx)
        while(_alt!=2 && _alt!=antlr4.atn.ATN.INVALID_ALT_NUMBER) {
            if(_alt===1) {
                this.state = 37;
                this._errHandler.sync(this);
                _la = this._input.LA(1);
                while(_la===AwkwordsParser.NEWLINE) {
                    this.state = 34;
                    this.match(AwkwordsParser.NEWLINE);
                    this.state = 39;
                    this._errHandler.sync(this);
                    _la = this._input.LA(1);
                }
                this.state = 40;
                this.subpattern(); 
            }
            this.state = 45;
            this._errHandler.sync(this);
            _alt = this._interp.adaptivePredict(this._input,1,this._ctx);
        }

        this.state = 49;
        this._errHandler.sync(this);
        _la = this._input.LA(1);
        while(_la===AwkwordsParser.NEWLINE) {
            this.state = 46;
            this.match(AwkwordsParser.NEWLINE);
            this.state = 51;
            this._errHandler.sync(this);
            _la = this._input.LA(1);
        }
        this.state = 52;
        this.match(AwkwordsParser.TEMPLATESTART);
        this.state = 53;
        this.pattern();
        this.state = 57;
        this._errHandler.sync(this);
        var _alt = this._interp.adaptivePredict(this._input,3,this._ctx)
        while(_alt!=2 && _alt!=antlr4.atn.ATN.INVALID_ALT_NUMBER) {
            if(_alt===1) {
                this.state = 54;
                this.match(AwkwordsParser.NEWLINE); 
            }
            this.state = 59;
            this._errHandler.sync(this);
            _alt = this._interp.adaptivePredict(this._input,3,this._ctx);
        }

        this.state = 62;
        this._errHandler.sync(this);
        var la_ = this._interp.adaptivePredict(this._input,4,this._ctx);
        if(la_===1) {
            this.state = 60;
            this.match(AwkwordsParser.NEWLINE);
            this.state = 61;
            this.numwords();

        }
        this.state = 65;
        this._errHandler.sync(this);
        _la = this._input.LA(1);
        if(_la===AwkwordsParser.NEWLINE) {
            this.state = 64;
            this.match(AwkwordsParser.NEWLINE);
        }

        this.state = 67;
        this.match(AwkwordsParser.EOF);
    } catch (re) {
    	if(re instanceof antlr4.error.RecognitionException) {
	        localctx.exception = re;
	        this._errHandler.reportError(this, re);
	        this._errHandler.recover(this, re);
	    } else {
	    	throw re;
	    }
    } finally {
        this.exitRule();
    }
    return localctx;
};


function NumwordsContext(parser, parent, invokingState) {
	if(parent===undefined) {
	    parent = null;
	}
	if(invokingState===undefined || invokingState===null) {
		invokingState = -1;
	}
	antlr4.ParserRuleContext.call(this, parent, invokingState);
    this.parser = parser;
    this.ruleIndex = AwkwordsParser.RULE_numwords;
    return this;
}

NumwordsContext.prototype = Object.create(antlr4.ParserRuleContext.prototype);
NumwordsContext.prototype.constructor = NumwordsContext;

NumwordsContext.prototype.NUMWORDSSTART = function() {
    return this.getToken(AwkwordsParser.NUMWORDSSTART, 0);
};

NumwordsContext.prototype.number = function() {
    return this.getTypedRuleContext(NumberContext,0);
};

NumwordsContext.prototype.accept = function(visitor) {
    if ( visitor instanceof AwkwordsVisitor ) {
        return visitor.visitNumwords(this);
    } else {
        return visitor.visitChildren(this);
    }
};




AwkwordsParser.NumwordsContext = NumwordsContext;

AwkwordsParser.prototype.numwords = function() {

    var localctx = new NumwordsContext(this, this._ctx, this.state);
    this.enterRule(localctx, 2, AwkwordsParser.RULE_numwords);
    try {
        this.enterOuterAlt(localctx, 1);
        this.state = 69;
        this.match(AwkwordsParser.NUMWORDSSTART);
        this.state = 70;
        this.number();
    } catch (re) {
    	if(re instanceof antlr4.error.RecognitionException) {
	        localctx.exception = re;
	        this._errHandler.reportError(this, re);
	        this._errHandler.recover(this, re);
	    } else {
	    	throw re;
	    }
    } finally {
        this.exitRule();
    }
    return localctx;
};


function SubpatternContext(parser, parent, invokingState) {
	if(parent===undefined) {
	    parent = null;
	}
	if(invokingState===undefined || invokingState===null) {
		invokingState = -1;
	}
	antlr4.ParserRuleContext.call(this, parent, invokingState);
    this.parser = parser;
    this.ruleIndex = AwkwordsParser.RULE_subpattern;
    return this;
}

SubpatternContext.prototype = Object.create(antlr4.ParserRuleContext.prototype);
SubpatternContext.prototype.constructor = SubpatternContext;

SubpatternContext.prototype.SUBREF = function() {
    return this.getToken(AwkwordsParser.SUBREF, 0);
};

SubpatternContext.prototype.SUBPATSTART = function() {
    return this.getToken(AwkwordsParser.SUBPATSTART, 0);
};

SubpatternContext.prototype.pattern = function() {
    return this.getTypedRuleContext(PatternContext,0);
};

SubpatternContext.prototype.NEWLINE = function() {
    return this.getToken(AwkwordsParser.NEWLINE, 0);
};

SubpatternContext.prototype.accept = function(visitor) {
    if ( visitor instanceof AwkwordsVisitor ) {
        return visitor.visitSubpattern(this);
    } else {
        return visitor.visitChildren(this);
    }
};




AwkwordsParser.SubpatternContext = SubpatternContext;

AwkwordsParser.prototype.subpattern = function() {

    var localctx = new SubpatternContext(this, this._ctx, this.state);
    this.enterRule(localctx, 4, AwkwordsParser.RULE_subpattern);
    try {
        this.enterOuterAlt(localctx, 1);
        this.state = 72;
        this.match(AwkwordsParser.SUBREF);
        this.state = 73;
        this.match(AwkwordsParser.SUBPATSTART);
        this.state = 74;
        this.pattern();
        this.state = 75;
        this.match(AwkwordsParser.NEWLINE);
    } catch (re) {
    	if(re instanceof antlr4.error.RecognitionException) {
	        localctx.exception = re;
	        this._errHandler.reportError(this, re);
	        this._errHandler.recover(this, re);
	    } else {
	    	throw re;
	    }
    } finally {
        this.exitRule();
    }
    return localctx;
};


function PatternContext(parser, parent, invokingState) {
	if(parent===undefined) {
	    parent = null;
	}
	if(invokingState===undefined || invokingState===null) {
		invokingState = -1;
	}
	antlr4.ParserRuleContext.call(this, parent, invokingState);
    this.parser = parser;
    this.ruleIndex = AwkwordsParser.RULE_pattern;
    return this;
}

PatternContext.prototype = Object.create(antlr4.ParserRuleContext.prototype);
PatternContext.prototype.constructor = PatternContext;

PatternContext.prototype.filtered = function() {
    return this.getTypedRuleContext(FilteredContext,0);
};

PatternContext.prototype.group = function() {
    return this.getTypedRuleContext(GroupContext,0);
};

PatternContext.prototype.escape = function() {
    return this.getTypedRuleContext(EscapeContext,0);
};

PatternContext.prototype.optional = function() {
    return this.getTypedRuleContext(OptionalContext,0);
};

PatternContext.prototype.subref = function() {
    return this.getTypedRuleContext(SubrefContext,0);
};

PatternContext.prototype.atom = function() {
    return this.getTypedRuleContext(AtomContext,0);
};

PatternContext.prototype.alternative = function() {
    return this.getTypedRuleContext(AlternativeContext,0);
};

PatternContext.prototype.sequence = function() {
    return this.getTypedRuleContext(SequenceContext,0);
};

PatternContext.prototype.accept = function(visitor) {
    if ( visitor instanceof AwkwordsVisitor ) {
        return visitor.visitPattern(this);
    } else {
        return visitor.visitChildren(this);
    }
};




AwkwordsParser.PatternContext = PatternContext;

AwkwordsParser.prototype.pattern = function() {

    var localctx = new PatternContext(this, this._ctx, this.state);
    this.enterRule(localctx, 6, AwkwordsParser.RULE_pattern);
    try {
        this.state = 85;
        this._errHandler.sync(this);
        var la_ = this._interp.adaptivePredict(this._input,6,this._ctx);
        switch(la_) {
        case 1:
            this.enterOuterAlt(localctx, 1);
            this.state = 77;
            this.filtered();
            break;

        case 2:
            this.enterOuterAlt(localctx, 2);
            this.state = 78;
            this.group();
            break;

        case 3:
            this.enterOuterAlt(localctx, 3);
            this.state = 79;
            this.escape();
            break;

        case 4:
            this.enterOuterAlt(localctx, 4);
            this.state = 80;
            this.optional();
            break;

        case 5:
            this.enterOuterAlt(localctx, 5);
            this.state = 81;
            this.subref();
            break;

        case 6:
            this.enterOuterAlt(localctx, 6);
            this.state = 82;
            this.atom();
            break;

        case 7:
            this.enterOuterAlt(localctx, 7);
            this.state = 83;
            this.alternative();
            break;

        case 8:
            this.enterOuterAlt(localctx, 8);
            this.state = 84;
            this.sequence();
            break;

        }
    } catch (re) {
    	if(re instanceof antlr4.error.RecognitionException) {
	        localctx.exception = re;
	        this._errHandler.reportError(this, re);
	        this._errHandler.recover(this, re);
	    } else {
	    	throw re;
	    }
    } finally {
        this.exitRule();
    }
    return localctx;
};


function AlternativeContext(parser, parent, invokingState) {
	if(parent===undefined) {
	    parent = null;
	}
	if(invokingState===undefined || invokingState===null) {
		invokingState = -1;
	}
	antlr4.ParserRuleContext.call(this, parent, invokingState);
    this.parser = parser;
    this.ruleIndex = AwkwordsParser.RULE_alternative;
    return this;
}

AlternativeContext.prototype = Object.create(antlr4.ParserRuleContext.prototype);
AlternativeContext.prototype.constructor = AlternativeContext;

AlternativeContext.prototype.weightedchoice = function(i) {
    if(i===undefined) {
        i = null;
    }
    if(i===null) {
        return this.getTypedRuleContexts(WeightedchoiceContext);
    } else {
        return this.getTypedRuleContext(WeightedchoiceContext,i);
    }
};

AlternativeContext.prototype.ALTSEP = function(i) {
	if(i===undefined) {
		i = null;
	}
    if(i===null) {
        return this.getTokens(AwkwordsParser.ALTSEP);
    } else {
        return this.getToken(AwkwordsParser.ALTSEP, i);
    }
};


AlternativeContext.prototype.accept = function(visitor) {
    if ( visitor instanceof AwkwordsVisitor ) {
        return visitor.visitAlternative(this);
    } else {
        return visitor.visitChildren(this);
    }
};




AwkwordsParser.AlternativeContext = AlternativeContext;

AwkwordsParser.prototype.alternative = function() {

    var localctx = new AlternativeContext(this, this._ctx, this.state);
    this.enterRule(localctx, 8, AwkwordsParser.RULE_alternative);
    var _la = 0; // Token type
    try {
        this.enterOuterAlt(localctx, 1);
        this.state = 87;
        this.weightedchoice();
        this.state = 90; 
        this._errHandler.sync(this);
        _la = this._input.LA(1);
        do {
            this.state = 88;
            this.match(AwkwordsParser.ALTSEP);
            this.state = 89;
            this.weightedchoice();
            this.state = 92; 
            this._errHandler.sync(this);
            _la = this._input.LA(1);
        } while(_la===AwkwordsParser.ALTSEP);
    } catch (re) {
    	if(re instanceof antlr4.error.RecognitionException) {
	        localctx.exception = re;
	        this._errHandler.reportError(this, re);
	        this._errHandler.recover(this, re);
	    } else {
	    	throw re;
	    }
    } finally {
        this.exitRule();
    }
    return localctx;
};


function WeightedchoiceContext(parser, parent, invokingState) {
	if(parent===undefined) {
	    parent = null;
	}
	if(invokingState===undefined || invokingState===null) {
		invokingState = -1;
	}
	antlr4.ParserRuleContext.call(this, parent, invokingState);
    this.parser = parser;
    this.ruleIndex = AwkwordsParser.RULE_weightedchoice;
    return this;
}

WeightedchoiceContext.prototype = Object.create(antlr4.ParserRuleContext.prototype);
WeightedchoiceContext.prototype.constructor = WeightedchoiceContext;

WeightedchoiceContext.prototype.altchoice = function() {
    return this.getTypedRuleContext(AltchoiceContext,0);
};

WeightedchoiceContext.prototype.WEIGHT = function() {
    return this.getToken(AwkwordsParser.WEIGHT, 0);
};

WeightedchoiceContext.prototype.number = function() {
    return this.getTypedRuleContext(NumberContext,0);
};

WeightedchoiceContext.prototype.accept = function(visitor) {
    if ( visitor instanceof AwkwordsVisitor ) {
        return visitor.visitWeightedchoice(this);
    } else {
        return visitor.visitChildren(this);
    }
};




AwkwordsParser.WeightedchoiceContext = WeightedchoiceContext;

AwkwordsParser.prototype.weightedchoice = function() {

    var localctx = new WeightedchoiceContext(this, this._ctx, this.state);
    this.enterRule(localctx, 10, AwkwordsParser.RULE_weightedchoice);
    var _la = 0; // Token type
    try {
        this.enterOuterAlt(localctx, 1);
        this.state = 94;
        this.altchoice();
        this.state = 97;
        this._errHandler.sync(this);
        _la = this._input.LA(1);
        if(_la===AwkwordsParser.WEIGHT) {
            this.state = 95;
            this.match(AwkwordsParser.WEIGHT);
            this.state = 96;
            this.number();
        }

    } catch (re) {
    	if(re instanceof antlr4.error.RecognitionException) {
	        localctx.exception = re;
	        this._errHandler.reportError(this, re);
	        this._errHandler.recover(this, re);
	    } else {
	    	throw re;
	    }
    } finally {
        this.exitRule();
    }
    return localctx;
};


function AltchoiceContext(parser, parent, invokingState) {
	if(parent===undefined) {
	    parent = null;
	}
	if(invokingState===undefined || invokingState===null) {
		invokingState = -1;
	}
	antlr4.ParserRuleContext.call(this, parent, invokingState);
    this.parser = parser;
    this.ruleIndex = AwkwordsParser.RULE_altchoice;
    return this;
}

AltchoiceContext.prototype = Object.create(antlr4.ParserRuleContext.prototype);
AltchoiceContext.prototype.constructor = AltchoiceContext;

AltchoiceContext.prototype.filtered = function() {
    return this.getTypedRuleContext(FilteredContext,0);
};

AltchoiceContext.prototype.group = function() {
    return this.getTypedRuleContext(GroupContext,0);
};

AltchoiceContext.prototype.escape = function() {
    return this.getTypedRuleContext(EscapeContext,0);
};

AltchoiceContext.prototype.optional = function() {
    return this.getTypedRuleContext(OptionalContext,0);
};

AltchoiceContext.prototype.subref = function() {
    return this.getTypedRuleContext(SubrefContext,0);
};

AltchoiceContext.prototype.atom = function() {
    return this.getTypedRuleContext(AtomContext,0);
};

AltchoiceContext.prototype.sequence = function() {
    return this.getTypedRuleContext(SequenceContext,0);
};

AltchoiceContext.prototype.accept = function(visitor) {
    if ( visitor instanceof AwkwordsVisitor ) {
        return visitor.visitAltchoice(this);
    } else {
        return visitor.visitChildren(this);
    }
};




AwkwordsParser.AltchoiceContext = AltchoiceContext;

AwkwordsParser.prototype.altchoice = function() {

    var localctx = new AltchoiceContext(this, this._ctx, this.state);
    this.enterRule(localctx, 12, AwkwordsParser.RULE_altchoice);
    try {
        this.state = 106;
        this._errHandler.sync(this);
        var la_ = this._interp.adaptivePredict(this._input,9,this._ctx);
        switch(la_) {
        case 1:
            this.enterOuterAlt(localctx, 1);
            this.state = 99;
            this.filtered();
            break;

        case 2:
            this.enterOuterAlt(localctx, 2);
            this.state = 100;
            this.group();
            break;

        case 3:
            this.enterOuterAlt(localctx, 3);
            this.state = 101;
            this.escape();
            break;

        case 4:
            this.enterOuterAlt(localctx, 4);
            this.state = 102;
            this.optional();
            break;

        case 5:
            this.enterOuterAlt(localctx, 5);
            this.state = 103;
            this.subref();
            break;

        case 6:
            this.enterOuterAlt(localctx, 6);
            this.state = 104;
            this.atom();
            break;

        case 7:
            this.enterOuterAlt(localctx, 7);
            this.state = 105;
            this.sequence();
            break;

        }
    } catch (re) {
    	if(re instanceof antlr4.error.RecognitionException) {
	        localctx.exception = re;
	        this._errHandler.reportError(this, re);
	        this._errHandler.recover(this, re);
	    } else {
	    	throw re;
	    }
    } finally {
        this.exitRule();
    }
    return localctx;
};


function FilteredContext(parser, parent, invokingState) {
	if(parent===undefined) {
	    parent = null;
	}
	if(invokingState===undefined || invokingState===null) {
		invokingState = -1;
	}
	antlr4.ParserRuleContext.call(this, parent, invokingState);
    this.parser = parser;
    this.ruleIndex = AwkwordsParser.RULE_filtered;
    return this;
}

FilteredContext.prototype = Object.create(antlr4.ParserRuleContext.prototype);
FilteredContext.prototype.constructor = FilteredContext;

FilteredContext.prototype.group = function() {
    return this.getTypedRuleContext(GroupContext,0);
};

FilteredContext.prototype.FILTERSEP = function(i) {
	if(i===undefined) {
		i = null;
	}
    if(i===null) {
        return this.getTokens(AwkwordsParser.FILTERSEP);
    } else {
        return this.getToken(AwkwordsParser.FILTERSEP, i);
    }
};


FilteredContext.prototype.filterstring = function(i) {
    if(i===undefined) {
        i = null;
    }
    if(i===null) {
        return this.getTypedRuleContexts(FilterstringContext);
    } else {
        return this.getTypedRuleContext(FilterstringContext,i);
    }
};

FilteredContext.prototype.accept = function(visitor) {
    if ( visitor instanceof AwkwordsVisitor ) {
        return visitor.visitFiltered(this);
    } else {
        return visitor.visitChildren(this);
    }
};




AwkwordsParser.FilteredContext = FilteredContext;

AwkwordsParser.prototype.filtered = function() {

    var localctx = new FilteredContext(this, this._ctx, this.state);
    this.enterRule(localctx, 14, AwkwordsParser.RULE_filtered);
    var _la = 0; // Token type
    try {
        this.enterOuterAlt(localctx, 1);
        this.state = 108;
        this.group();
        this.state = 111; 
        this._errHandler.sync(this);
        _la = this._input.LA(1);
        do {
            this.state = 109;
            this.match(AwkwordsParser.FILTERSEP);
            this.state = 110;
            this.filterstring();
            this.state = 113; 
            this._errHandler.sync(this);
            _la = this._input.LA(1);
        } while(_la===AwkwordsParser.FILTERSEP);
    } catch (re) {
    	if(re instanceof antlr4.error.RecognitionException) {
	        localctx.exception = re;
	        this._errHandler.reportError(this, re);
	        this._errHandler.recover(this, re);
	    } else {
	    	throw re;
	    }
    } finally {
        this.exitRule();
    }
    return localctx;
};


function FilterstringContext(parser, parent, invokingState) {
	if(parent===undefined) {
	    parent = null;
	}
	if(invokingState===undefined || invokingState===null) {
		invokingState = -1;
	}
	antlr4.ParserRuleContext.call(this, parent, invokingState);
    this.parser = parser;
    this.ruleIndex = AwkwordsParser.RULE_filterstring;
    return this;
}

FilterstringContext.prototype = Object.create(antlr4.ParserRuleContext.prototype);
FilterstringContext.prototype.constructor = FilterstringContext;

FilterstringContext.prototype.atom = function(i) {
    if(i===undefined) {
        i = null;
    }
    if(i===null) {
        return this.getTypedRuleContexts(AtomContext);
    } else {
        return this.getTypedRuleContext(AtomContext,i);
    }
};

FilterstringContext.prototype.accept = function(visitor) {
    if ( visitor instanceof AwkwordsVisitor ) {
        return visitor.visitFilterstring(this);
    } else {
        return visitor.visitChildren(this);
    }
};




AwkwordsParser.FilterstringContext = FilterstringContext;

AwkwordsParser.prototype.filterstring = function() {

    var localctx = new FilterstringContext(this, this._ctx, this.state);
    this.enterRule(localctx, 16, AwkwordsParser.RULE_filterstring);
    try {
        this.enterOuterAlt(localctx, 1);
        this.state = 116; 
        this._errHandler.sync(this);
        var _alt = 1;
        do {
        	switch (_alt) {
        	case 1:
        		this.state = 115;
        		this.atom();
        		break;
        	default:
        		throw new antlr4.error.NoViableAltException(this);
        	}
        	this.state = 118; 
        	this._errHandler.sync(this);
        	_alt = this._interp.adaptivePredict(this._input,11, this._ctx);
        } while ( _alt!=2 && _alt!=antlr4.atn.ATN.INVALID_ALT_NUMBER );
    } catch (re) {
    	if(re instanceof antlr4.error.RecognitionException) {
	        localctx.exception = re;
	        this._errHandler.reportError(this, re);
	        this._errHandler.recover(this, re);
	    } else {
	    	throw re;
	    }
    } finally {
        this.exitRule();
    }
    return localctx;
};


function OptionalContext(parser, parent, invokingState) {
	if(parent===undefined) {
	    parent = null;
	}
	if(invokingState===undefined || invokingState===null) {
		invokingState = -1;
	}
	antlr4.ParserRuleContext.call(this, parent, invokingState);
    this.parser = parser;
    this.ruleIndex = AwkwordsParser.RULE_optional;
    return this;
}

OptionalContext.prototype = Object.create(antlr4.ParserRuleContext.prototype);
OptionalContext.prototype.constructor = OptionalContext;

OptionalContext.prototype.OPSTART = function() {
    return this.getToken(AwkwordsParser.OPSTART, 0);
};

OptionalContext.prototype.pattern = function() {
    return this.getTypedRuleContext(PatternContext,0);
};

OptionalContext.prototype.OPEND = function() {
    return this.getToken(AwkwordsParser.OPEND, 0);
};

OptionalContext.prototype.accept = function(visitor) {
    if ( visitor instanceof AwkwordsVisitor ) {
        return visitor.visitOptional(this);
    } else {
        return visitor.visitChildren(this);
    }
};




AwkwordsParser.OptionalContext = OptionalContext;

AwkwordsParser.prototype.optional = function() {

    var localctx = new OptionalContext(this, this._ctx, this.state);
    this.enterRule(localctx, 18, AwkwordsParser.RULE_optional);
    try {
        this.enterOuterAlt(localctx, 1);
        this.state = 120;
        this.match(AwkwordsParser.OPSTART);
        this.state = 121;
        this.pattern();
        this.state = 122;
        this.match(AwkwordsParser.OPEND);
    } catch (re) {
    	if(re instanceof antlr4.error.RecognitionException) {
	        localctx.exception = re;
	        this._errHandler.reportError(this, re);
	        this._errHandler.recover(this, re);
	    } else {
	    	throw re;
	    }
    } finally {
        this.exitRule();
    }
    return localctx;
};


function SequenceContext(parser, parent, invokingState) {
	if(parent===undefined) {
	    parent = null;
	}
	if(invokingState===undefined || invokingState===null) {
		invokingState = -1;
	}
	antlr4.ParserRuleContext.call(this, parent, invokingState);
    this.parser = parser;
    this.ruleIndex = AwkwordsParser.RULE_sequence;
    return this;
}

SequenceContext.prototype = Object.create(antlr4.ParserRuleContext.prototype);
SequenceContext.prototype.constructor = SequenceContext;

SequenceContext.prototype.filtered = function(i) {
    if(i===undefined) {
        i = null;
    }
    if(i===null) {
        return this.getTypedRuleContexts(FilteredContext);
    } else {
        return this.getTypedRuleContext(FilteredContext,i);
    }
};

SequenceContext.prototype.group = function(i) {
    if(i===undefined) {
        i = null;
    }
    if(i===null) {
        return this.getTypedRuleContexts(GroupContext);
    } else {
        return this.getTypedRuleContext(GroupContext,i);
    }
};

SequenceContext.prototype.escape = function(i) {
    if(i===undefined) {
        i = null;
    }
    if(i===null) {
        return this.getTypedRuleContexts(EscapeContext);
    } else {
        return this.getTypedRuleContext(EscapeContext,i);
    }
};

SequenceContext.prototype.optional = function(i) {
    if(i===undefined) {
        i = null;
    }
    if(i===null) {
        return this.getTypedRuleContexts(OptionalContext);
    } else {
        return this.getTypedRuleContext(OptionalContext,i);
    }
};

SequenceContext.prototype.subref = function(i) {
    if(i===undefined) {
        i = null;
    }
    if(i===null) {
        return this.getTypedRuleContexts(SubrefContext);
    } else {
        return this.getTypedRuleContext(SubrefContext,i);
    }
};

SequenceContext.prototype.atom = function(i) {
    if(i===undefined) {
        i = null;
    }
    if(i===null) {
        return this.getTypedRuleContexts(AtomContext);
    } else {
        return this.getTypedRuleContext(AtomContext,i);
    }
};

SequenceContext.prototype.accept = function(visitor) {
    if ( visitor instanceof AwkwordsVisitor ) {
        return visitor.visitSequence(this);
    } else {
        return visitor.visitChildren(this);
    }
};




AwkwordsParser.SequenceContext = SequenceContext;

AwkwordsParser.prototype.sequence = function() {

    var localctx = new SequenceContext(this, this._ctx, this.state);
    this.enterRule(localctx, 20, AwkwordsParser.RULE_sequence);
    var _la = 0; // Token type
    try {
        this.enterOuterAlt(localctx, 1);
        this.state = 130; 
        this._errHandler.sync(this);
        _la = this._input.LA(1);
        do {
            this.state = 130;
            this._errHandler.sync(this);
            var la_ = this._interp.adaptivePredict(this._input,12,this._ctx);
            switch(la_) {
            case 1:
                this.state = 124;
                this.filtered();
                break;

            case 2:
                this.state = 125;
                this.group();
                break;

            case 3:
                this.state = 126;
                this.escape();
                break;

            case 4:
                this.state = 127;
                this.optional();
                break;

            case 5:
                this.state = 128;
                this.subref();
                break;

            case 6:
                this.state = 129;
                this.atom();
                break;

            }
            this.state = 132; 
            this._errHandler.sync(this);
            _la = this._input.LA(1);
        } while((((_la) & ~0x1f) == 0 && ((1 << _la) & ((1 << AwkwordsParser.ATOM) | (1 << AwkwordsParser.SUBREF) | (1 << AwkwordsParser.OPSTART) | (1 << AwkwordsParser.GROUPSTART) | (1 << AwkwordsParser.ESCAPE) | (1 << AwkwordsParser.SUBPATSTART) | (1 << AwkwordsParser.DIGIT))) !== 0));
    } catch (re) {
    	if(re instanceof antlr4.error.RecognitionException) {
	        localctx.exception = re;
	        this._errHandler.reportError(this, re);
	        this._errHandler.recover(this, re);
	    } else {
	    	throw re;
	    }
    } finally {
        this.exitRule();
    }
    return localctx;
};


function GroupContext(parser, parent, invokingState) {
	if(parent===undefined) {
	    parent = null;
	}
	if(invokingState===undefined || invokingState===null) {
		invokingState = -1;
	}
	antlr4.ParserRuleContext.call(this, parent, invokingState);
    this.parser = parser;
    this.ruleIndex = AwkwordsParser.RULE_group;
    return this;
}

GroupContext.prototype = Object.create(antlr4.ParserRuleContext.prototype);
GroupContext.prototype.constructor = GroupContext;

GroupContext.prototype.GROUPSTART = function() {
    return this.getToken(AwkwordsParser.GROUPSTART, 0);
};

GroupContext.prototype.pattern = function() {
    return this.getTypedRuleContext(PatternContext,0);
};

GroupContext.prototype.GROUPEND = function() {
    return this.getToken(AwkwordsParser.GROUPEND, 0);
};

GroupContext.prototype.accept = function(visitor) {
    if ( visitor instanceof AwkwordsVisitor ) {
        return visitor.visitGroup(this);
    } else {
        return visitor.visitChildren(this);
    }
};




AwkwordsParser.GroupContext = GroupContext;

AwkwordsParser.prototype.group = function() {

    var localctx = new GroupContext(this, this._ctx, this.state);
    this.enterRule(localctx, 22, AwkwordsParser.RULE_group);
    try {
        this.enterOuterAlt(localctx, 1);
        this.state = 134;
        this.match(AwkwordsParser.GROUPSTART);
        this.state = 135;
        this.pattern();
        this.state = 136;
        this.match(AwkwordsParser.GROUPEND);
    } catch (re) {
    	if(re instanceof antlr4.error.RecognitionException) {
	        localctx.exception = re;
	        this._errHandler.reportError(this, re);
	        this._errHandler.recover(this, re);
	    } else {
	    	throw re;
	    }
    } finally {
        this.exitRule();
    }
    return localctx;
};


function EscapeContext(parser, parent, invokingState) {
	if(parent===undefined) {
	    parent = null;
	}
	if(invokingState===undefined || invokingState===null) {
		invokingState = -1;
	}
	antlr4.ParserRuleContext.call(this, parent, invokingState);
    this.parser = parser;
    this.ruleIndex = AwkwordsParser.RULE_escape;
    return this;
}

EscapeContext.prototype = Object.create(antlr4.ParserRuleContext.prototype);
EscapeContext.prototype.constructor = EscapeContext;

EscapeContext.prototype.ESCAPE = function(i) {
	if(i===undefined) {
		i = null;
	}
    if(i===null) {
        return this.getTokens(AwkwordsParser.ESCAPE);
    } else {
        return this.getToken(AwkwordsParser.ESCAPE, i);
    }
};


EscapeContext.prototype.anychar = function(i) {
    if(i===undefined) {
        i = null;
    }
    if(i===null) {
        return this.getTypedRuleContexts(AnycharContext);
    } else {
        return this.getTypedRuleContext(AnycharContext,i);
    }
};

EscapeContext.prototype.accept = function(visitor) {
    if ( visitor instanceof AwkwordsVisitor ) {
        return visitor.visitEscape(this);
    } else {
        return visitor.visitChildren(this);
    }
};




AwkwordsParser.EscapeContext = EscapeContext;

AwkwordsParser.prototype.escape = function() {

    var localctx = new EscapeContext(this, this._ctx, this.state);
    this.enterRule(localctx, 24, AwkwordsParser.RULE_escape);
    var _la = 0; // Token type
    try {
        this.enterOuterAlt(localctx, 1);
        this.state = 138;
        this.match(AwkwordsParser.ESCAPE);
        this.state = 140; 
        this._errHandler.sync(this);
        _la = this._input.LA(1);
        do {
            this.state = 139;
            this.anychar();
            this.state = 142; 
            this._errHandler.sync(this);
            _la = this._input.LA(1);
        } while((((_la) & ~0x1f) == 0 && ((1 << _la) & ((1 << AwkwordsParser.ATOM) | (1 << AwkwordsParser.SUBREF) | (1 << AwkwordsParser.ALTSEP) | (1 << AwkwordsParser.OPSTART) | (1 << AwkwordsParser.OPEND) | (1 << AwkwordsParser.GROUPSTART) | (1 << AwkwordsParser.GROUPEND) | (1 << AwkwordsParser.WEIGHT) | (1 << AwkwordsParser.FILTERSEP) | (1 << AwkwordsParser.SUBPATSTART))) !== 0));
        this.state = 144;
        this.match(AwkwordsParser.ESCAPE);
    } catch (re) {
    	if(re instanceof antlr4.error.RecognitionException) {
	        localctx.exception = re;
	        this._errHandler.reportError(this, re);
	        this._errHandler.recover(this, re);
	    } else {
	    	throw re;
	    }
    } finally {
        this.exitRule();
    }
    return localctx;
};


function SubrefContext(parser, parent, invokingState) {
	if(parent===undefined) {
	    parent = null;
	}
	if(invokingState===undefined || invokingState===null) {
		invokingState = -1;
	}
	antlr4.ParserRuleContext.call(this, parent, invokingState);
    this.parser = parser;
    this.ruleIndex = AwkwordsParser.RULE_subref;
    return this;
}

SubrefContext.prototype = Object.create(antlr4.ParserRuleContext.prototype);
SubrefContext.prototype.constructor = SubrefContext;

SubrefContext.prototype.SUBREF = function() {
    return this.getToken(AwkwordsParser.SUBREF, 0);
};

SubrefContext.prototype.accept = function(visitor) {
    if ( visitor instanceof AwkwordsVisitor ) {
        return visitor.visitSubref(this);
    } else {
        return visitor.visitChildren(this);
    }
};




AwkwordsParser.SubrefContext = SubrefContext;

AwkwordsParser.prototype.subref = function() {

    var localctx = new SubrefContext(this, this._ctx, this.state);
    this.enterRule(localctx, 26, AwkwordsParser.RULE_subref);
    try {
        this.enterOuterAlt(localctx, 1);
        this.state = 146;
        this.match(AwkwordsParser.SUBREF);
    } catch (re) {
    	if(re instanceof antlr4.error.RecognitionException) {
	        localctx.exception = re;
	        this._errHandler.reportError(this, re);
	        this._errHandler.recover(this, re);
	    } else {
	    	throw re;
	    }
    } finally {
        this.exitRule();
    }
    return localctx;
};


function AnycharContext(parser, parent, invokingState) {
	if(parent===undefined) {
	    parent = null;
	}
	if(invokingState===undefined || invokingState===null) {
		invokingState = -1;
	}
	antlr4.ParserRuleContext.call(this, parent, invokingState);
    this.parser = parser;
    this.ruleIndex = AwkwordsParser.RULE_anychar;
    return this;
}

AnycharContext.prototype = Object.create(antlr4.ParserRuleContext.prototype);
AnycharContext.prototype.constructor = AnycharContext;

AnycharContext.prototype.ATOM = function() {
    return this.getToken(AwkwordsParser.ATOM, 0);
};

AnycharContext.prototype.SUBREF = function() {
    return this.getToken(AwkwordsParser.SUBREF, 0);
};

AnycharContext.prototype.ALTSEP = function() {
    return this.getToken(AwkwordsParser.ALTSEP, 0);
};

AnycharContext.prototype.OPSTART = function() {
    return this.getToken(AwkwordsParser.OPSTART, 0);
};

AnycharContext.prototype.OPEND = function() {
    return this.getToken(AwkwordsParser.OPEND, 0);
};

AnycharContext.prototype.GROUPSTART = function() {
    return this.getToken(AwkwordsParser.GROUPSTART, 0);
};

AnycharContext.prototype.GROUPEND = function() {
    return this.getToken(AwkwordsParser.GROUPEND, 0);
};

AnycharContext.prototype.WEIGHT = function() {
    return this.getToken(AwkwordsParser.WEIGHT, 0);
};

AnycharContext.prototype.FILTERSEP = function() {
    return this.getToken(AwkwordsParser.FILTERSEP, 0);
};

AnycharContext.prototype.SUBPATSTART = function() {
    return this.getToken(AwkwordsParser.SUBPATSTART, 0);
};

AnycharContext.prototype.accept = function(visitor) {
    if ( visitor instanceof AwkwordsVisitor ) {
        return visitor.visitAnychar(this);
    } else {
        return visitor.visitChildren(this);
    }
};




AwkwordsParser.AnycharContext = AnycharContext;

AwkwordsParser.prototype.anychar = function() {

    var localctx = new AnycharContext(this, this._ctx, this.state);
    this.enterRule(localctx, 28, AwkwordsParser.RULE_anychar);
    var _la = 0; // Token type
    try {
        this.enterOuterAlt(localctx, 1);
        this.state = 148;
        _la = this._input.LA(1);
        if(!((((_la) & ~0x1f) == 0 && ((1 << _la) & ((1 << AwkwordsParser.ATOM) | (1 << AwkwordsParser.SUBREF) | (1 << AwkwordsParser.ALTSEP) | (1 << AwkwordsParser.OPSTART) | (1 << AwkwordsParser.OPEND) | (1 << AwkwordsParser.GROUPSTART) | (1 << AwkwordsParser.GROUPEND) | (1 << AwkwordsParser.WEIGHT) | (1 << AwkwordsParser.FILTERSEP) | (1 << AwkwordsParser.SUBPATSTART))) !== 0))) {
        this._errHandler.recoverInline(this);
        }
        else {
        	this._errHandler.reportMatch(this);
            this.consume();
        }
    } catch (re) {
    	if(re instanceof antlr4.error.RecognitionException) {
	        localctx.exception = re;
	        this._errHandler.reportError(this, re);
	        this._errHandler.recover(this, re);
	    } else {
	    	throw re;
	    }
    } finally {
        this.exitRule();
    }
    return localctx;
};


function AtomContext(parser, parent, invokingState) {
	if(parent===undefined) {
	    parent = null;
	}
	if(invokingState===undefined || invokingState===null) {
		invokingState = -1;
	}
	antlr4.ParserRuleContext.call(this, parent, invokingState);
    this.parser = parser;
    this.ruleIndex = AwkwordsParser.RULE_atom;
    return this;
}

AtomContext.prototype = Object.create(antlr4.ParserRuleContext.prototype);
AtomContext.prototype.constructor = AtomContext;

AtomContext.prototype.ATOM = function() {
    return this.getToken(AwkwordsParser.ATOM, 0);
};

AtomContext.prototype.SUBPATSTART = function() {
    return this.getToken(AwkwordsParser.SUBPATSTART, 0);
};

AtomContext.prototype.DIGIT = function() {
    return this.getToken(AwkwordsParser.DIGIT, 0);
};

AtomContext.prototype.accept = function(visitor) {
    if ( visitor instanceof AwkwordsVisitor ) {
        return visitor.visitAtom(this);
    } else {
        return visitor.visitChildren(this);
    }
};




AwkwordsParser.AtomContext = AtomContext;

AwkwordsParser.prototype.atom = function() {

    var localctx = new AtomContext(this, this._ctx, this.state);
    this.enterRule(localctx, 30, AwkwordsParser.RULE_atom);
    var _la = 0; // Token type
    try {
        this.enterOuterAlt(localctx, 1);
        this.state = 150;
        _la = this._input.LA(1);
        if(!((((_la) & ~0x1f) == 0 && ((1 << _la) & ((1 << AwkwordsParser.ATOM) | (1 << AwkwordsParser.SUBPATSTART) | (1 << AwkwordsParser.DIGIT))) !== 0))) {
        this._errHandler.recoverInline(this);
        }
        else {
        	this._errHandler.reportMatch(this);
            this.consume();
        }
    } catch (re) {
    	if(re instanceof antlr4.error.RecognitionException) {
	        localctx.exception = re;
	        this._errHandler.reportError(this, re);
	        this._errHandler.recover(this, re);
	    } else {
	    	throw re;
	    }
    } finally {
        this.exitRule();
    }
    return localctx;
};


function NumberContext(parser, parent, invokingState) {
	if(parent===undefined) {
	    parent = null;
	}
	if(invokingState===undefined || invokingState===null) {
		invokingState = -1;
	}
	antlr4.ParserRuleContext.call(this, parent, invokingState);
    this.parser = parser;
    this.ruleIndex = AwkwordsParser.RULE_number;
    return this;
}

NumberContext.prototype = Object.create(antlr4.ParserRuleContext.prototype);
NumberContext.prototype.constructor = NumberContext;

NumberContext.prototype.DIGIT = function(i) {
	if(i===undefined) {
		i = null;
	}
    if(i===null) {
        return this.getTokens(AwkwordsParser.DIGIT);
    } else {
        return this.getToken(AwkwordsParser.DIGIT, i);
    }
};


NumberContext.prototype.accept = function(visitor) {
    if ( visitor instanceof AwkwordsVisitor ) {
        return visitor.visitNumber(this);
    } else {
        return visitor.visitChildren(this);
    }
};




AwkwordsParser.NumberContext = NumberContext;

AwkwordsParser.prototype.number = function() {

    var localctx = new NumberContext(this, this._ctx, this.state);
    this.enterRule(localctx, 32, AwkwordsParser.RULE_number);
    var _la = 0; // Token type
    try {
        this.enterOuterAlt(localctx, 1);
        this.state = 153; 
        this._errHandler.sync(this);
        _la = this._input.LA(1);
        do {
            this.state = 152;
            this.match(AwkwordsParser.DIGIT);
            this.state = 155; 
            this._errHandler.sync(this);
            _la = this._input.LA(1);
        } while(_la===AwkwordsParser.DIGIT);
    } catch (re) {
    	if(re instanceof antlr4.error.RecognitionException) {
	        localctx.exception = re;
	        this._errHandler.reportError(this, re);
	        this._errHandler.recover(this, re);
	    } else {
	    	throw re;
	    }
    } finally {
        this.exitRule();
    }
    return localctx;
};


exports.AwkwordsParser = AwkwordsParser;
