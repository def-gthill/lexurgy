// Generated from Lgn.g4 by ANTLR 4.7.2
// jshint ignore: start
var antlr4 = require('antlr4/index');
var LgnVisitor = require('./LgnVisitor').LgnVisitor;

var grammarFileName = "Lgn.g4";


var serializedATN = ["\u0003\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964",
    "\u0003\u000ea\u0004\u0002\t\u0002\u0004\u0003\t\u0003\u0004\u0004\t",
    "\u0004\u0004\u0005\t\u0005\u0004\u0006\t\u0006\u0004\u0007\t\u0007\u0004",
    "\b\t\b\u0004\t\t\t\u0004\n\t\n\u0004\u000b\t\u000b\u0004\f\t\f\u0004",
    "\r\t\r\u0003\u0002\u0003\u0002\u0003\u0002\u0003\u0002\u0003\u0002\u0003",
    "\u0002\u0003\u0002\u0003\u0002\u0007\u0002#\n\u0002\f\u0002\u000e\u0002",
    "&\u000b\u0002\u0003\u0002\u0003\u0002\u0003\u0003\u0003\u0003\u0005",
    "\u0003,\n\u0003\u0003\u0004\u0003\u0004\u0003\u0004\u0003\u0004\u0003",
    "\u0004\u0003\u0004\u0003\u0004\u0003\u0005\u0003\u0005\u0005\u00057",
    "\n\u0005\u0003\u0006\u0003\u0006\u0003\u0006\u0006\u0006<\n\u0006\r",
    "\u0006\u000e\u0006=\u0003\u0007\u0003\u0007\u0003\u0007\u0005\u0007",
    "C\n\u0007\u0003\b\u0003\b\u0005\bG\n\b\u0003\b\u0003\b\u0003\t\u0003",
    "\t\u0003\t\u0003\t\u0007\tO\n\t\f\t\u000e\tR\u000b\t\u0003\t\u0003\t",
    "\u0003\n\u0003\n\u0005\nX\n\n\u0003\u000b\u0003\u000b\u0003\u000b\u0003",
    "\f\u0003\f\u0003\r\u0003\r\u0003\r\u0002\u0002\u000e\u0002\u0004\u0006",
    "\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u0002\u0003\u0003\u0002\r",
    "\u000e\u0002]\u0002\u001a\u0003\u0002\u0002\u0002\u0004+\u0003\u0002",
    "\u0002\u0002\u0006-\u0003\u0002\u0002\u0002\b6\u0003\u0002\u0002\u0002",
    "\n8\u0003\u0002\u0002\u0002\fB\u0003\u0002\u0002\u0002\u000eF\u0003",
    "\u0002\u0002\u0002\u0010J\u0003\u0002\u0002\u0002\u0012W\u0003\u0002",
    "\u0002\u0002\u0014Y\u0003\u0002\u0002\u0002\u0016\\\u0003\u0002\u0002",
    "\u0002\u0018^\u0003\u0002\u0002\u0002\u001a\u001b\u0007\u000b\u0002",
    "\u0002\u001b\u001c\u0007\u0004\u0002\u0002\u001c\u001d\u0005\u0016\f",
    "\u0002\u001d\u001e\u0007\u0004\u0002\u0002\u001e\u001f\u0007\u0006\u0002",
    "\u0002\u001f$\u0005\u0004\u0003\u0002 !\u0007\u0003\u0002\u0002!#\u0005",
    "\u0004\u0003\u0002\" \u0003\u0002\u0002\u0002#&\u0003\u0002\u0002\u0002",
    "$\"\u0003\u0002\u0002\u0002$%\u0003\u0002\u0002\u0002%\'\u0003\u0002",
    "\u0002\u0002&$\u0003\u0002\u0002\u0002\'(\u0007\u0007\u0002\u0002(\u0003",
    "\u0003\u0002\u0002\u0002),\u0005\u0014\u000b\u0002*,\u0005\u0018\r\u0002",
    "+)\u0003\u0002\u0002\u0002+*\u0003\u0002\u0002\u0002,\u0005\u0003\u0002",
    "\u0002\u0002-.\u0007\f\u0002\u0002./\u0007\u0004\u0002\u0002/0\u0005",
    "\u0016\f\u000201\u0007\n\u0002\u000212\u0007\u0005\u0002\u000223\u0005",
    "\b\u0005\u00023\u0007\u0003\u0002\u0002\u000247\u0005\u0012\n\u0002",
    "57\u0005\n\u0006\u000264\u0003\u0002\u0002\u000265\u0003\u0002\u0002",
    "\u00027\t\u0003\u0002\u0002\u00028;\u0005\f\u0007\u00029:\u0007\u0004",
    "\u0002\u0002:<\u0005\f\u0007\u0002;9\u0003\u0002\u0002\u0002<=\u0003",
    "\u0002\u0002\u0002=;\u0003\u0002\u0002\u0002=>\u0003\u0002\u0002\u0002",
    ">\u000b\u0003\u0002\u0002\u0002?C\u0005\u000e\b\u0002@C\u0005\u0010",
    "\t\u0002AC\u0005\u0012\n\u0002B?\u0003\u0002\u0002\u0002B@\u0003\u0002",
    "\u0002\u0002BA\u0003\u0002\u0002\u0002C\r\u0003\u0002\u0002\u0002DG",
    "\u0005\u0010\t\u0002EG\u0005\u0012\n\u0002FD\u0003\u0002\u0002\u0002",
    "FE\u0003\u0002\u0002\u0002GH\u0003\u0002\u0002\u0002HI\u0007\b\u0002",
    "\u0002I\u000f\u0003\u0002\u0002\u0002JK\u0007\u0006\u0002\u0002KP\u0005",
    "\b\u0005\u0002LM\u0007\u0003\u0002\u0002MO\u0005\b\u0005\u0002NL\u0003",
    "\u0002\u0002\u0002OR\u0003\u0002\u0002\u0002PN\u0003\u0002\u0002\u0002",
    "PQ\u0003\u0002\u0002\u0002QS\u0003\u0002\u0002\u0002RP\u0003\u0002\u0002",
    "\u0002ST\u0007\u0007\u0002\u0002T\u0011\u0003\u0002\u0002\u0002UX\u0005",
    "\u0014\u000b\u0002VX\u0005\u0018\r\u0002WU\u0003\u0002\u0002\u0002W",
    "V\u0003\u0002\u0002\u0002X\u0013\u0003\u0002\u0002\u0002YZ\u0007\t\u0002",
    "\u0002Z[\u0005\u0016\f\u0002[\u0015\u0003\u0002\u0002\u0002\\]\u0007",
    "\r\u0002\u0002]\u0017\u0003\u0002\u0002\u0002^_\t\u0002\u0002\u0002",
    "_\u0019\u0003\u0002\u0002\u0002\n$+6=BFPW"].join("");


var atn = new antlr4.atn.ATNDeserializer().deserialize(serializedATN);

var decisionsToDFA = atn.decisionToState.map( function(ds, index) { return new antlr4.dfa.DFA(ds, index); });

var sharedContextCache = new antlr4.PredictionContextCache();

var literalNames = [ null, null, null, null, "'{'", "'}'", "'?'", "'@'", 
                     "':'", "'Class'", "'Pattern'" ];

var symbolicNames = [ null, "SEP", "WHITESPACE", "NEWLINE", "LISTSTART", 
                      "LISTEND", "OPTIONAL", "CLASSREF", "BLOCKSTART", "CLASSDECL", 
                      "PATTERNDECL", "NAME", "STR" ];

var ruleNames =  [ "classdecl", "classelement", "patterndecl", "pattern", 
                   "sequence", "sequenceelement", "optional", "list", "simple", 
                   "classref", "name", "text" ];

function LgnParser (input) {
	antlr4.Parser.call(this, input);
    this._interp = new antlr4.atn.ParserATNSimulator(this, atn, decisionsToDFA, sharedContextCache);
    this.ruleNames = ruleNames;
    this.literalNames = literalNames;
    this.symbolicNames = symbolicNames;
    return this;
}

LgnParser.prototype = Object.create(antlr4.Parser.prototype);
LgnParser.prototype.constructor = LgnParser;

Object.defineProperty(LgnParser.prototype, "atn", {
	get : function() {
		return atn;
	}
});

LgnParser.EOF = antlr4.Token.EOF;
LgnParser.SEP = 1;
LgnParser.WHITESPACE = 2;
LgnParser.NEWLINE = 3;
LgnParser.LISTSTART = 4;
LgnParser.LISTEND = 5;
LgnParser.OPTIONAL = 6;
LgnParser.CLASSREF = 7;
LgnParser.BLOCKSTART = 8;
LgnParser.CLASSDECL = 9;
LgnParser.PATTERNDECL = 10;
LgnParser.NAME = 11;
LgnParser.STR = 12;

LgnParser.RULE_classdecl = 0;
LgnParser.RULE_classelement = 1;
LgnParser.RULE_patterndecl = 2;
LgnParser.RULE_pattern = 3;
LgnParser.RULE_sequence = 4;
LgnParser.RULE_sequenceelement = 5;
LgnParser.RULE_optional = 6;
LgnParser.RULE_list = 7;
LgnParser.RULE_simple = 8;
LgnParser.RULE_classref = 9;
LgnParser.RULE_name = 10;
LgnParser.RULE_text = 11;


function ClassdeclContext(parser, parent, invokingState) {
	if(parent===undefined) {
	    parent = null;
	}
	if(invokingState===undefined || invokingState===null) {
		invokingState = -1;
	}
	antlr4.ParserRuleContext.call(this, parent, invokingState);
    this.parser = parser;
    this.ruleIndex = LgnParser.RULE_classdecl;
    return this;
}

ClassdeclContext.prototype = Object.create(antlr4.ParserRuleContext.prototype);
ClassdeclContext.prototype.constructor = ClassdeclContext;

ClassdeclContext.prototype.CLASSDECL = function() {
    return this.getToken(LgnParser.CLASSDECL, 0);
};

ClassdeclContext.prototype.WHITESPACE = function(i) {
	if(i===undefined) {
		i = null;
	}
    if(i===null) {
        return this.getTokens(LgnParser.WHITESPACE);
    } else {
        return this.getToken(LgnParser.WHITESPACE, i);
    }
};


ClassdeclContext.prototype.name = function() {
    return this.getTypedRuleContext(NameContext,0);
};

ClassdeclContext.prototype.LISTSTART = function() {
    return this.getToken(LgnParser.LISTSTART, 0);
};

ClassdeclContext.prototype.classelement = function(i) {
    if(i===undefined) {
        i = null;
    }
    if(i===null) {
        return this.getTypedRuleContexts(ClasselementContext);
    } else {
        return this.getTypedRuleContext(ClasselementContext,i);
    }
};

ClassdeclContext.prototype.LISTEND = function() {
    return this.getToken(LgnParser.LISTEND, 0);
};

ClassdeclContext.prototype.SEP = function(i) {
	if(i===undefined) {
		i = null;
	}
    if(i===null) {
        return this.getTokens(LgnParser.SEP);
    } else {
        return this.getToken(LgnParser.SEP, i);
    }
};


ClassdeclContext.prototype.accept = function(visitor) {
    if ( visitor instanceof LgnVisitor ) {
        return visitor.visitClassdecl(this);
    } else {
        return visitor.visitChildren(this);
    }
};




LgnParser.ClassdeclContext = ClassdeclContext;

LgnParser.prototype.classdecl = function() {

    var localctx = new ClassdeclContext(this, this._ctx, this.state);
    this.enterRule(localctx, 0, LgnParser.RULE_classdecl);
    var _la = 0; // Token type
    try {
        this.enterOuterAlt(localctx, 1);
        this.state = 24;
        this.match(LgnParser.CLASSDECL);
        this.state = 25;
        this.match(LgnParser.WHITESPACE);
        this.state = 26;
        this.name();
        this.state = 27;
        this.match(LgnParser.WHITESPACE);
        this.state = 28;
        this.match(LgnParser.LISTSTART);
        this.state = 29;
        this.classelement();
        this.state = 34;
        this._errHandler.sync(this);
        _la = this._input.LA(1);
        while(_la===LgnParser.SEP) {
            this.state = 30;
            this.match(LgnParser.SEP);
            this.state = 31;
            this.classelement();
            this.state = 36;
            this._errHandler.sync(this);
            _la = this._input.LA(1);
        }
        this.state = 37;
        this.match(LgnParser.LISTEND);
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


function ClasselementContext(parser, parent, invokingState) {
	if(parent===undefined) {
	    parent = null;
	}
	if(invokingState===undefined || invokingState===null) {
		invokingState = -1;
	}
	antlr4.ParserRuleContext.call(this, parent, invokingState);
    this.parser = parser;
    this.ruleIndex = LgnParser.RULE_classelement;
    return this;
}

ClasselementContext.prototype = Object.create(antlr4.ParserRuleContext.prototype);
ClasselementContext.prototype.constructor = ClasselementContext;

ClasselementContext.prototype.classref = function() {
    return this.getTypedRuleContext(ClassrefContext,0);
};

ClasselementContext.prototype.text = function() {
    return this.getTypedRuleContext(TextContext,0);
};

ClasselementContext.prototype.accept = function(visitor) {
    if ( visitor instanceof LgnVisitor ) {
        return visitor.visitClasselement(this);
    } else {
        return visitor.visitChildren(this);
    }
};




LgnParser.ClasselementContext = ClasselementContext;

LgnParser.prototype.classelement = function() {

    var localctx = new ClasselementContext(this, this._ctx, this.state);
    this.enterRule(localctx, 2, LgnParser.RULE_classelement);
    try {
        this.state = 41;
        this._errHandler.sync(this);
        switch(this._input.LA(1)) {
        case LgnParser.CLASSREF:
            this.enterOuterAlt(localctx, 1);
            this.state = 39;
            this.classref();
            break;
        case LgnParser.NAME:
        case LgnParser.STR:
            this.enterOuterAlt(localctx, 2);
            this.state = 40;
            this.text();
            break;
        default:
            throw new antlr4.error.NoViableAltException(this);
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


function PatterndeclContext(parser, parent, invokingState) {
	if(parent===undefined) {
	    parent = null;
	}
	if(invokingState===undefined || invokingState===null) {
		invokingState = -1;
	}
	antlr4.ParserRuleContext.call(this, parent, invokingState);
    this.parser = parser;
    this.ruleIndex = LgnParser.RULE_patterndecl;
    return this;
}

PatterndeclContext.prototype = Object.create(antlr4.ParserRuleContext.prototype);
PatterndeclContext.prototype.constructor = PatterndeclContext;

PatterndeclContext.prototype.PATTERNDECL = function() {
    return this.getToken(LgnParser.PATTERNDECL, 0);
};

PatterndeclContext.prototype.WHITESPACE = function() {
    return this.getToken(LgnParser.WHITESPACE, 0);
};

PatterndeclContext.prototype.name = function() {
    return this.getTypedRuleContext(NameContext,0);
};

PatterndeclContext.prototype.BLOCKSTART = function() {
    return this.getToken(LgnParser.BLOCKSTART, 0);
};

PatterndeclContext.prototype.NEWLINE = function() {
    return this.getToken(LgnParser.NEWLINE, 0);
};

PatterndeclContext.prototype.pattern = function() {
    return this.getTypedRuleContext(PatternContext,0);
};

PatterndeclContext.prototype.accept = function(visitor) {
    if ( visitor instanceof LgnVisitor ) {
        return visitor.visitPatterndecl(this);
    } else {
        return visitor.visitChildren(this);
    }
};




LgnParser.PatterndeclContext = PatterndeclContext;

LgnParser.prototype.patterndecl = function() {

    var localctx = new PatterndeclContext(this, this._ctx, this.state);
    this.enterRule(localctx, 4, LgnParser.RULE_patterndecl);
    try {
        this.enterOuterAlt(localctx, 1);
        this.state = 43;
        this.match(LgnParser.PATTERNDECL);
        this.state = 44;
        this.match(LgnParser.WHITESPACE);
        this.state = 45;
        this.name();
        this.state = 46;
        this.match(LgnParser.BLOCKSTART);
        this.state = 47;
        this.match(LgnParser.NEWLINE);
        this.state = 48;
        this.pattern();
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
    this.ruleIndex = LgnParser.RULE_pattern;
    return this;
}

PatternContext.prototype = Object.create(antlr4.ParserRuleContext.prototype);
PatternContext.prototype.constructor = PatternContext;

PatternContext.prototype.simple = function() {
    return this.getTypedRuleContext(SimpleContext,0);
};

PatternContext.prototype.sequence = function() {
    return this.getTypedRuleContext(SequenceContext,0);
};

PatternContext.prototype.accept = function(visitor) {
    if ( visitor instanceof LgnVisitor ) {
        return visitor.visitPattern(this);
    } else {
        return visitor.visitChildren(this);
    }
};




LgnParser.PatternContext = PatternContext;

LgnParser.prototype.pattern = function() {

    var localctx = new PatternContext(this, this._ctx, this.state);
    this.enterRule(localctx, 6, LgnParser.RULE_pattern);
    try {
        this.state = 52;
        this._errHandler.sync(this);
        var la_ = this._interp.adaptivePredict(this._input,2,this._ctx);
        switch(la_) {
        case 1:
            this.enterOuterAlt(localctx, 1);
            this.state = 50;
            this.simple();
            break;

        case 2:
            this.enterOuterAlt(localctx, 2);
            this.state = 51;
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


function SequenceContext(parser, parent, invokingState) {
	if(parent===undefined) {
	    parent = null;
	}
	if(invokingState===undefined || invokingState===null) {
		invokingState = -1;
	}
	antlr4.ParserRuleContext.call(this, parent, invokingState);
    this.parser = parser;
    this.ruleIndex = LgnParser.RULE_sequence;
    return this;
}

SequenceContext.prototype = Object.create(antlr4.ParserRuleContext.prototype);
SequenceContext.prototype.constructor = SequenceContext;

SequenceContext.prototype.sequenceelement = function(i) {
    if(i===undefined) {
        i = null;
    }
    if(i===null) {
        return this.getTypedRuleContexts(SequenceelementContext);
    } else {
        return this.getTypedRuleContext(SequenceelementContext,i);
    }
};

SequenceContext.prototype.WHITESPACE = function(i) {
	if(i===undefined) {
		i = null;
	}
    if(i===null) {
        return this.getTokens(LgnParser.WHITESPACE);
    } else {
        return this.getToken(LgnParser.WHITESPACE, i);
    }
};


SequenceContext.prototype.accept = function(visitor) {
    if ( visitor instanceof LgnVisitor ) {
        return visitor.visitSequence(this);
    } else {
        return visitor.visitChildren(this);
    }
};




LgnParser.SequenceContext = SequenceContext;

LgnParser.prototype.sequence = function() {

    var localctx = new SequenceContext(this, this._ctx, this.state);
    this.enterRule(localctx, 8, LgnParser.RULE_sequence);
    var _la = 0; // Token type
    try {
        this.enterOuterAlt(localctx, 1);
        this.state = 54;
        this.sequenceelement();
        this.state = 57; 
        this._errHandler.sync(this);
        _la = this._input.LA(1);
        do {
            this.state = 55;
            this.match(LgnParser.WHITESPACE);
            this.state = 56;
            this.sequenceelement();
            this.state = 59; 
            this._errHandler.sync(this);
            _la = this._input.LA(1);
        } while(_la===LgnParser.WHITESPACE);
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


function SequenceelementContext(parser, parent, invokingState) {
	if(parent===undefined) {
	    parent = null;
	}
	if(invokingState===undefined || invokingState===null) {
		invokingState = -1;
	}
	antlr4.ParserRuleContext.call(this, parent, invokingState);
    this.parser = parser;
    this.ruleIndex = LgnParser.RULE_sequenceelement;
    return this;
}

SequenceelementContext.prototype = Object.create(antlr4.ParserRuleContext.prototype);
SequenceelementContext.prototype.constructor = SequenceelementContext;

SequenceelementContext.prototype.optional = function() {
    return this.getTypedRuleContext(OptionalContext,0);
};

SequenceelementContext.prototype.list = function() {
    return this.getTypedRuleContext(ListContext,0);
};

SequenceelementContext.prototype.simple = function() {
    return this.getTypedRuleContext(SimpleContext,0);
};

SequenceelementContext.prototype.accept = function(visitor) {
    if ( visitor instanceof LgnVisitor ) {
        return visitor.visitSequenceelement(this);
    } else {
        return visitor.visitChildren(this);
    }
};




LgnParser.SequenceelementContext = SequenceelementContext;

LgnParser.prototype.sequenceelement = function() {

    var localctx = new SequenceelementContext(this, this._ctx, this.state);
    this.enterRule(localctx, 10, LgnParser.RULE_sequenceelement);
    try {
        this.state = 64;
        this._errHandler.sync(this);
        var la_ = this._interp.adaptivePredict(this._input,4,this._ctx);
        switch(la_) {
        case 1:
            this.enterOuterAlt(localctx, 1);
            this.state = 61;
            this.optional();
            break;

        case 2:
            this.enterOuterAlt(localctx, 2);
            this.state = 62;
            this.list();
            break;

        case 3:
            this.enterOuterAlt(localctx, 3);
            this.state = 63;
            this.simple();
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


function OptionalContext(parser, parent, invokingState) {
	if(parent===undefined) {
	    parent = null;
	}
	if(invokingState===undefined || invokingState===null) {
		invokingState = -1;
	}
	antlr4.ParserRuleContext.call(this, parent, invokingState);
    this.parser = parser;
    this.ruleIndex = LgnParser.RULE_optional;
    return this;
}

OptionalContext.prototype = Object.create(antlr4.ParserRuleContext.prototype);
OptionalContext.prototype.constructor = OptionalContext;

OptionalContext.prototype.OPTIONAL = function() {
    return this.getToken(LgnParser.OPTIONAL, 0);
};

OptionalContext.prototype.list = function() {
    return this.getTypedRuleContext(ListContext,0);
};

OptionalContext.prototype.simple = function() {
    return this.getTypedRuleContext(SimpleContext,0);
};

OptionalContext.prototype.accept = function(visitor) {
    if ( visitor instanceof LgnVisitor ) {
        return visitor.visitOptional(this);
    } else {
        return visitor.visitChildren(this);
    }
};




LgnParser.OptionalContext = OptionalContext;

LgnParser.prototype.optional = function() {

    var localctx = new OptionalContext(this, this._ctx, this.state);
    this.enterRule(localctx, 12, LgnParser.RULE_optional);
    try {
        this.enterOuterAlt(localctx, 1);
        this.state = 68;
        this._errHandler.sync(this);
        switch(this._input.LA(1)) {
        case LgnParser.LISTSTART:
            this.state = 66;
            this.list();
            break;
        case LgnParser.CLASSREF:
        case LgnParser.NAME:
        case LgnParser.STR:
            this.state = 67;
            this.simple();
            break;
        default:
            throw new antlr4.error.NoViableAltException(this);
        }
        this.state = 70;
        this.match(LgnParser.OPTIONAL);
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


function ListContext(parser, parent, invokingState) {
	if(parent===undefined) {
	    parent = null;
	}
	if(invokingState===undefined || invokingState===null) {
		invokingState = -1;
	}
	antlr4.ParserRuleContext.call(this, parent, invokingState);
    this.parser = parser;
    this.ruleIndex = LgnParser.RULE_list;
    return this;
}

ListContext.prototype = Object.create(antlr4.ParserRuleContext.prototype);
ListContext.prototype.constructor = ListContext;

ListContext.prototype.LISTSTART = function() {
    return this.getToken(LgnParser.LISTSTART, 0);
};

ListContext.prototype.pattern = function(i) {
    if(i===undefined) {
        i = null;
    }
    if(i===null) {
        return this.getTypedRuleContexts(PatternContext);
    } else {
        return this.getTypedRuleContext(PatternContext,i);
    }
};

ListContext.prototype.LISTEND = function() {
    return this.getToken(LgnParser.LISTEND, 0);
};

ListContext.prototype.SEP = function(i) {
	if(i===undefined) {
		i = null;
	}
    if(i===null) {
        return this.getTokens(LgnParser.SEP);
    } else {
        return this.getToken(LgnParser.SEP, i);
    }
};


ListContext.prototype.accept = function(visitor) {
    if ( visitor instanceof LgnVisitor ) {
        return visitor.visitList(this);
    } else {
        return visitor.visitChildren(this);
    }
};




LgnParser.ListContext = ListContext;

LgnParser.prototype.list = function() {

    var localctx = new ListContext(this, this._ctx, this.state);
    this.enterRule(localctx, 14, LgnParser.RULE_list);
    var _la = 0; // Token type
    try {
        this.enterOuterAlt(localctx, 1);
        this.state = 72;
        this.match(LgnParser.LISTSTART);
        this.state = 73;
        this.pattern();
        this.state = 78;
        this._errHandler.sync(this);
        _la = this._input.LA(1);
        while(_la===LgnParser.SEP) {
            this.state = 74;
            this.match(LgnParser.SEP);
            this.state = 75;
            this.pattern();
            this.state = 80;
            this._errHandler.sync(this);
            _la = this._input.LA(1);
        }
        this.state = 81;
        this.match(LgnParser.LISTEND);
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


function SimpleContext(parser, parent, invokingState) {
	if(parent===undefined) {
	    parent = null;
	}
	if(invokingState===undefined || invokingState===null) {
		invokingState = -1;
	}
	antlr4.ParserRuleContext.call(this, parent, invokingState);
    this.parser = parser;
    this.ruleIndex = LgnParser.RULE_simple;
    return this;
}

SimpleContext.prototype = Object.create(antlr4.ParserRuleContext.prototype);
SimpleContext.prototype.constructor = SimpleContext;

SimpleContext.prototype.classref = function() {
    return this.getTypedRuleContext(ClassrefContext,0);
};

SimpleContext.prototype.text = function() {
    return this.getTypedRuleContext(TextContext,0);
};

SimpleContext.prototype.accept = function(visitor) {
    if ( visitor instanceof LgnVisitor ) {
        return visitor.visitSimple(this);
    } else {
        return visitor.visitChildren(this);
    }
};




LgnParser.SimpleContext = SimpleContext;

LgnParser.prototype.simple = function() {

    var localctx = new SimpleContext(this, this._ctx, this.state);
    this.enterRule(localctx, 16, LgnParser.RULE_simple);
    try {
        this.state = 85;
        this._errHandler.sync(this);
        switch(this._input.LA(1)) {
        case LgnParser.CLASSREF:
            this.enterOuterAlt(localctx, 1);
            this.state = 83;
            this.classref();
            break;
        case LgnParser.NAME:
        case LgnParser.STR:
            this.enterOuterAlt(localctx, 2);
            this.state = 84;
            this.text();
            break;
        default:
            throw new antlr4.error.NoViableAltException(this);
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


function ClassrefContext(parser, parent, invokingState) {
	if(parent===undefined) {
	    parent = null;
	}
	if(invokingState===undefined || invokingState===null) {
		invokingState = -1;
	}
	antlr4.ParserRuleContext.call(this, parent, invokingState);
    this.parser = parser;
    this.ruleIndex = LgnParser.RULE_classref;
    return this;
}

ClassrefContext.prototype = Object.create(antlr4.ParserRuleContext.prototype);
ClassrefContext.prototype.constructor = ClassrefContext;

ClassrefContext.prototype.CLASSREF = function() {
    return this.getToken(LgnParser.CLASSREF, 0);
};

ClassrefContext.prototype.name = function() {
    return this.getTypedRuleContext(NameContext,0);
};

ClassrefContext.prototype.accept = function(visitor) {
    if ( visitor instanceof LgnVisitor ) {
        return visitor.visitClassref(this);
    } else {
        return visitor.visitChildren(this);
    }
};




LgnParser.ClassrefContext = ClassrefContext;

LgnParser.prototype.classref = function() {

    var localctx = new ClassrefContext(this, this._ctx, this.state);
    this.enterRule(localctx, 18, LgnParser.RULE_classref);
    try {
        this.enterOuterAlt(localctx, 1);
        this.state = 87;
        this.match(LgnParser.CLASSREF);
        this.state = 88;
        this.name();
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


function NameContext(parser, parent, invokingState) {
	if(parent===undefined) {
	    parent = null;
	}
	if(invokingState===undefined || invokingState===null) {
		invokingState = -1;
	}
	antlr4.ParserRuleContext.call(this, parent, invokingState);
    this.parser = parser;
    this.ruleIndex = LgnParser.RULE_name;
    return this;
}

NameContext.prototype = Object.create(antlr4.ParserRuleContext.prototype);
NameContext.prototype.constructor = NameContext;

NameContext.prototype.NAME = function() {
    return this.getToken(LgnParser.NAME, 0);
};

NameContext.prototype.accept = function(visitor) {
    if ( visitor instanceof LgnVisitor ) {
        return visitor.visitName(this);
    } else {
        return visitor.visitChildren(this);
    }
};




LgnParser.NameContext = NameContext;

LgnParser.prototype.name = function() {

    var localctx = new NameContext(this, this._ctx, this.state);
    this.enterRule(localctx, 20, LgnParser.RULE_name);
    try {
        this.enterOuterAlt(localctx, 1);
        this.state = 90;
        this.match(LgnParser.NAME);
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


function TextContext(parser, parent, invokingState) {
	if(parent===undefined) {
	    parent = null;
	}
	if(invokingState===undefined || invokingState===null) {
		invokingState = -1;
	}
	antlr4.ParserRuleContext.call(this, parent, invokingState);
    this.parser = parser;
    this.ruleIndex = LgnParser.RULE_text;
    return this;
}

TextContext.prototype = Object.create(antlr4.ParserRuleContext.prototype);
TextContext.prototype.constructor = TextContext;

TextContext.prototype.NAME = function() {
    return this.getToken(LgnParser.NAME, 0);
};

TextContext.prototype.STR = function() {
    return this.getToken(LgnParser.STR, 0);
};

TextContext.prototype.accept = function(visitor) {
    if ( visitor instanceof LgnVisitor ) {
        return visitor.visitText(this);
    } else {
        return visitor.visitChildren(this);
    }
};




LgnParser.TextContext = TextContext;

LgnParser.prototype.text = function() {

    var localctx = new TextContext(this, this._ctx, this.state);
    this.enterRule(localctx, 22, LgnParser.RULE_text);
    var _la = 0; // Token type
    try {
        this.enterOuterAlt(localctx, 1);
        this.state = 92;
        _la = this._input.LA(1);
        if(!(_la===LgnParser.NAME || _la===LgnParser.STR)) {
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


exports.LgnParser = LgnParser;
