// Generated from Meta.g4 by ANTLR 4.7.2
package com.meamoria.lexurgy.meta.java;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MetaParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		COMMENT=1, COMMENT_START=2, NEWLINE=3, WHITESPACE=4, GRAMMAR=5, GRAMMAR_NAME=6, 
		RULE_NAME=7, TOKEN_NAME=8, START=9, END=10, ALT_SEP=11, O_PAREN=12, C_PAREN=13, 
		AT_LEAST_ONE=14, ANY_NUMBER=15, OPTIONAL=16, END_JUNK=17;
	public static final int
		RULE_g4File = 0, RULE_antlrRule = 1, RULE_expression = 2, RULE_sequence = 3, 
		RULE_sequenceElement = 4, RULE_alts = 5, RULE_altElement = 6, RULE_group = 7, 
		RULE_repeater = 8, RULE_repeaterType = 9, RULE_simple = 10, RULE_ruleName = 11, 
		RULE_tokenName = 12;
	private static String[] makeRuleNames() {
		return new String[] {
			"g4File", "antlrRule", "expression", "sequence", "sequenceElement", "alts", 
			"altElement", "group", "repeater", "repeaterType", "simple", "ruleName", 
			"tokenName"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, "'//'", null, null, "'grammar'", null, null, null, null, 
			"';'", null, null, null, "'+'", "'*'", "'?'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "COMMENT", "COMMENT_START", "NEWLINE", "WHITESPACE", "GRAMMAR", 
			"GRAMMAR_NAME", "RULE_NAME", "TOKEN_NAME", "START", "END", "ALT_SEP", 
			"O_PAREN", "C_PAREN", "AT_LEAST_ONE", "ANY_NUMBER", "OPTIONAL", "END_JUNK"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Meta.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public MetaParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class G4FileContext extends ParserRuleContext {
		public TerminalNode GRAMMAR() { return getToken(MetaParser.GRAMMAR, 0); }
		public TerminalNode WHITESPACE() { return getToken(MetaParser.WHITESPACE, 0); }
		public TerminalNode GRAMMAR_NAME() { return getToken(MetaParser.GRAMMAR_NAME, 0); }
		public TerminalNode END() { return getToken(MetaParser.END, 0); }
		public List<AntlrRuleContext> antlrRule() {
			return getRuleContexts(AntlrRuleContext.class);
		}
		public AntlrRuleContext antlrRule(int i) {
			return getRuleContext(AntlrRuleContext.class,i);
		}
		public TerminalNode END_JUNK() { return getToken(MetaParser.END_JUNK, 0); }
		public TerminalNode EOF() { return getToken(MetaParser.EOF, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(MetaParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(MetaParser.NEWLINE, i);
		}
		public G4FileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_g4File; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MetaVisitor ) return ((MetaVisitor<? extends T>)visitor).visitG4File(this);
			else return visitor.visitChildren(this);
		}
	}

	public final G4FileContext g4File() throws RecognitionException {
		G4FileContext _localctx = new G4FileContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_g4File);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(26);
			match(GRAMMAR);
			setState(27);
			match(WHITESPACE);
			setState(28);
			match(GRAMMAR_NAME);
			setState(29);
			match(END);
			setState(31); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(30);
				match(NEWLINE);
				}
				}
				setState(33); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NEWLINE );
			setState(35);
			antlrRule();
			setState(44);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE) {
				{
				{
				setState(37); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(36);
					match(NEWLINE);
					}
					}
					setState(39); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NEWLINE );
				setState(41);
				antlrRule();
				}
				}
				setState(46);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(47);
			match(END_JUNK);
			setState(48);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AntlrRuleContext extends ParserRuleContext {
		public RuleNameContext ruleName() {
			return getRuleContext(RuleNameContext.class,0);
		}
		public TerminalNode START() { return getToken(MetaParser.START, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode END() { return getToken(MetaParser.END, 0); }
		public AntlrRuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_antlrRule; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MetaVisitor ) return ((MetaVisitor<? extends T>)visitor).visitAntlrRule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AntlrRuleContext antlrRule() throws RecognitionException {
		AntlrRuleContext _localctx = new AntlrRuleContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_antlrRule);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
			ruleName();
			setState(51);
			match(START);
			setState(52);
			expression();
			setState(53);
			match(END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public GroupContext group() {
			return getRuleContext(GroupContext.class,0);
		}
		public RepeaterContext repeater() {
			return getRuleContext(RepeaterContext.class,0);
		}
		public SimpleContext simple() {
			return getRuleContext(SimpleContext.class,0);
		}
		public SequenceContext sequence() {
			return getRuleContext(SequenceContext.class,0);
		}
		public AltsContext alts() {
			return getRuleContext(AltsContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MetaVisitor ) return ((MetaVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_expression);
		try {
			setState(60);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(55);
				group();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(56);
				repeater();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(57);
				simple();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(58);
				sequence();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(59);
				alts();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SequenceContext extends ParserRuleContext {
		public List<SequenceElementContext> sequenceElement() {
			return getRuleContexts(SequenceElementContext.class);
		}
		public SequenceElementContext sequenceElement(int i) {
			return getRuleContext(SequenceElementContext.class,i);
		}
		public List<TerminalNode> WHITESPACE() { return getTokens(MetaParser.WHITESPACE); }
		public TerminalNode WHITESPACE(int i) {
			return getToken(MetaParser.WHITESPACE, i);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(MetaParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(MetaParser.NEWLINE, i);
		}
		public SequenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sequence; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MetaVisitor ) return ((MetaVisitor<? extends T>)visitor).visitSequence(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SequenceContext sequence() throws RecognitionException {
		SequenceContext _localctx = new SequenceContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_sequence);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(62);
			sequenceElement();
			setState(67);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE || _la==WHITESPACE) {
				{
				{
				setState(63);
				_la = _input.LA(1);
				if ( !(_la==NEWLINE || _la==WHITESPACE) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(64);
				sequenceElement();
				}
				}
				setState(69);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SequenceElementContext extends ParserRuleContext {
		public GroupContext group() {
			return getRuleContext(GroupContext.class,0);
		}
		public RepeaterContext repeater() {
			return getRuleContext(RepeaterContext.class,0);
		}
		public SimpleContext simple() {
			return getRuleContext(SimpleContext.class,0);
		}
		public SequenceElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sequenceElement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MetaVisitor ) return ((MetaVisitor<? extends T>)visitor).visitSequenceElement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SequenceElementContext sequenceElement() throws RecognitionException {
		SequenceElementContext _localctx = new SequenceElementContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_sequenceElement);
		try {
			setState(73);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(70);
				group();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(71);
				repeater();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(72);
				simple();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AltsContext extends ParserRuleContext {
		public List<AltElementContext> altElement() {
			return getRuleContexts(AltElementContext.class);
		}
		public AltElementContext altElement(int i) {
			return getRuleContext(AltElementContext.class,i);
		}
		public List<TerminalNode> ALT_SEP() { return getTokens(MetaParser.ALT_SEP); }
		public TerminalNode ALT_SEP(int i) {
			return getToken(MetaParser.ALT_SEP, i);
		}
		public AltsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_alts; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MetaVisitor ) return ((MetaVisitor<? extends T>)visitor).visitAlts(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AltsContext alts() throws RecognitionException {
		AltsContext _localctx = new AltsContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_alts);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(75);
			altElement();
			setState(80);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ALT_SEP) {
				{
				{
				setState(76);
				match(ALT_SEP);
				setState(77);
				altElement();
				}
				}
				setState(82);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AltElementContext extends ParserRuleContext {
		public GroupContext group() {
			return getRuleContext(GroupContext.class,0);
		}
		public RepeaterContext repeater() {
			return getRuleContext(RepeaterContext.class,0);
		}
		public SimpleContext simple() {
			return getRuleContext(SimpleContext.class,0);
		}
		public SequenceContext sequence() {
			return getRuleContext(SequenceContext.class,0);
		}
		public AltElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_altElement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MetaVisitor ) return ((MetaVisitor<? extends T>)visitor).visitAltElement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AltElementContext altElement() throws RecognitionException {
		AltElementContext _localctx = new AltElementContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_altElement);
		try {
			setState(87);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(83);
				group();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(84);
				repeater();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(85);
				simple();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(86);
				sequence();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GroupContext extends ParserRuleContext {
		public TerminalNode O_PAREN() { return getToken(MetaParser.O_PAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode C_PAREN() { return getToken(MetaParser.C_PAREN, 0); }
		public GroupContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_group; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MetaVisitor ) return ((MetaVisitor<? extends T>)visitor).visitGroup(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GroupContext group() throws RecognitionException {
		GroupContext _localctx = new GroupContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_group);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(89);
			match(O_PAREN);
			setState(90);
			expression();
			setState(91);
			match(C_PAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RepeaterContext extends ParserRuleContext {
		public RepeaterTypeContext repeaterType() {
			return getRuleContext(RepeaterTypeContext.class,0);
		}
		public GroupContext group() {
			return getRuleContext(GroupContext.class,0);
		}
		public SimpleContext simple() {
			return getRuleContext(SimpleContext.class,0);
		}
		public RepeaterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_repeater; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MetaVisitor ) return ((MetaVisitor<? extends T>)visitor).visitRepeater(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RepeaterContext repeater() throws RecognitionException {
		RepeaterContext _localctx = new RepeaterContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_repeater);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(95);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case O_PAREN:
				{
				setState(93);
				group();
				}
				break;
			case RULE_NAME:
			case TOKEN_NAME:
				{
				setState(94);
				simple();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(97);
			repeaterType();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RepeaterTypeContext extends ParserRuleContext {
		public TerminalNode AT_LEAST_ONE() { return getToken(MetaParser.AT_LEAST_ONE, 0); }
		public TerminalNode ANY_NUMBER() { return getToken(MetaParser.ANY_NUMBER, 0); }
		public TerminalNode OPTIONAL() { return getToken(MetaParser.OPTIONAL, 0); }
		public RepeaterTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_repeaterType; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MetaVisitor ) return ((MetaVisitor<? extends T>)visitor).visitRepeaterType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RepeaterTypeContext repeaterType() throws RecognitionException {
		RepeaterTypeContext _localctx = new RepeaterTypeContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_repeaterType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(99);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AT_LEAST_ONE) | (1L << ANY_NUMBER) | (1L << OPTIONAL))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SimpleContext extends ParserRuleContext {
		public RuleNameContext ruleName() {
			return getRuleContext(RuleNameContext.class,0);
		}
		public TokenNameContext tokenName() {
			return getRuleContext(TokenNameContext.class,0);
		}
		public SimpleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simple; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MetaVisitor ) return ((MetaVisitor<? extends T>)visitor).visitSimple(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SimpleContext simple() throws RecognitionException {
		SimpleContext _localctx = new SimpleContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_simple);
		try {
			setState(103);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case RULE_NAME:
				enterOuterAlt(_localctx, 1);
				{
				setState(101);
				ruleName();
				}
				break;
			case TOKEN_NAME:
				enterOuterAlt(_localctx, 2);
				{
				setState(102);
				tokenName();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RuleNameContext extends ParserRuleContext {
		public TerminalNode RULE_NAME() { return getToken(MetaParser.RULE_NAME, 0); }
		public RuleNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ruleName; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MetaVisitor ) return ((MetaVisitor<? extends T>)visitor).visitRuleName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RuleNameContext ruleName() throws RecognitionException {
		RuleNameContext _localctx = new RuleNameContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_ruleName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(105);
			match(RULE_NAME);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TokenNameContext extends ParserRuleContext {
		public TerminalNode TOKEN_NAME() { return getToken(MetaParser.TOKEN_NAME, 0); }
		public TokenNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tokenName; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MetaVisitor ) return ((MetaVisitor<? extends T>)visitor).visitTokenName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TokenNameContext tokenName() throws RecognitionException {
		TokenNameContext _localctx = new TokenNameContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_tokenName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(107);
			match(TOKEN_NAME);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\23p\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\4"+
		"\f\t\f\4\r\t\r\4\16\t\16\3\2\3\2\3\2\3\2\3\2\6\2\"\n\2\r\2\16\2#\3\2\3"+
		"\2\6\2(\n\2\r\2\16\2)\3\2\7\2-\n\2\f\2\16\2\60\13\2\3\2\3\2\3\2\3\3\3"+
		"\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\5\4?\n\4\3\5\3\5\3\5\7\5D\n\5\f\5\16"+
		"\5G\13\5\3\6\3\6\3\6\5\6L\n\6\3\7\3\7\3\7\7\7Q\n\7\f\7\16\7T\13\7\3\b"+
		"\3\b\3\b\3\b\5\bZ\n\b\3\t\3\t\3\t\3\t\3\n\3\n\5\nb\n\n\3\n\3\n\3\13\3"+
		"\13\3\f\3\f\5\fj\n\f\3\r\3\r\3\16\3\16\3\16\2\2\17\2\4\6\b\n\f\16\20\22"+
		"\24\26\30\32\2\4\3\2\5\6\3\2\20\22\2r\2\34\3\2\2\2\4\64\3\2\2\2\6>\3\2"+
		"\2\2\b@\3\2\2\2\nK\3\2\2\2\fM\3\2\2\2\16Y\3\2\2\2\20[\3\2\2\2\22a\3\2"+
		"\2\2\24e\3\2\2\2\26i\3\2\2\2\30k\3\2\2\2\32m\3\2\2\2\34\35\7\7\2\2\35"+
		"\36\7\6\2\2\36\37\7\b\2\2\37!\7\f\2\2 \"\7\5\2\2! \3\2\2\2\"#\3\2\2\2"+
		"#!\3\2\2\2#$\3\2\2\2$%\3\2\2\2%.\5\4\3\2&(\7\5\2\2\'&\3\2\2\2()\3\2\2"+
		"\2)\'\3\2\2\2)*\3\2\2\2*+\3\2\2\2+-\5\4\3\2,\'\3\2\2\2-\60\3\2\2\2.,\3"+
		"\2\2\2./\3\2\2\2/\61\3\2\2\2\60.\3\2\2\2\61\62\7\23\2\2\62\63\7\2\2\3"+
		"\63\3\3\2\2\2\64\65\5\30\r\2\65\66\7\13\2\2\66\67\5\6\4\2\678\7\f\2\2"+
		"8\5\3\2\2\29?\5\20\t\2:?\5\22\n\2;?\5\26\f\2<?\5\b\5\2=?\5\f\7\2>9\3\2"+
		"\2\2>:\3\2\2\2>;\3\2\2\2><\3\2\2\2>=\3\2\2\2?\7\3\2\2\2@E\5\n\6\2AB\t"+
		"\2\2\2BD\5\n\6\2CA\3\2\2\2DG\3\2\2\2EC\3\2\2\2EF\3\2\2\2F\t\3\2\2\2GE"+
		"\3\2\2\2HL\5\20\t\2IL\5\22\n\2JL\5\26\f\2KH\3\2\2\2KI\3\2\2\2KJ\3\2\2"+
		"\2L\13\3\2\2\2MR\5\16\b\2NO\7\r\2\2OQ\5\16\b\2PN\3\2\2\2QT\3\2\2\2RP\3"+
		"\2\2\2RS\3\2\2\2S\r\3\2\2\2TR\3\2\2\2UZ\5\20\t\2VZ\5\22\n\2WZ\5\26\f\2"+
		"XZ\5\b\5\2YU\3\2\2\2YV\3\2\2\2YW\3\2\2\2YX\3\2\2\2Z\17\3\2\2\2[\\\7\16"+
		"\2\2\\]\5\6\4\2]^\7\17\2\2^\21\3\2\2\2_b\5\20\t\2`b\5\26\f\2a_\3\2\2\2"+
		"a`\3\2\2\2bc\3\2\2\2cd\5\24\13\2d\23\3\2\2\2ef\t\3\2\2f\25\3\2\2\2gj\5"+
		"\30\r\2hj\5\32\16\2ig\3\2\2\2ih\3\2\2\2j\27\3\2\2\2kl\7\t\2\2l\31\3\2"+
		"\2\2mn\7\n\2\2n\33\3\2\2\2\f#).>EKRYai";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}