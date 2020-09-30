// Generated from Lgn.g4 by ANTLR 4.7.2
package com.meamoria.lexurgy.gen;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class LgnParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		SEP=1, WHITESPACE=2, LISTSTART=3, LISTEND=4, OPTIONAL=5, CLASSREF=6, CLASSDECL=7, 
		NAME=8, STR=9;
	public static final int
		RULE_classdecl = 0, RULE_classelement = 1, RULE_pattern = 2, RULE_sequence = 3, 
		RULE_sequenceelement = 4, RULE_optional = 5, RULE_classref = 6, RULE_name = 7, 
		RULE_text = 8;
	private static String[] makeRuleNames() {
		return new String[] {
			"classdecl", "classelement", "pattern", "sequence", "sequenceelement", 
			"optional", "classref", "name", "text"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, "'{'", "'}'", "'?'", "'@'", "'Class'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "SEP", "WHITESPACE", "LISTSTART", "LISTEND", "OPTIONAL", "CLASSREF", 
			"CLASSDECL", "NAME", "STR"
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
	public String getGrammarFileName() { return "Lgn.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public LgnParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ClassdeclContext extends ParserRuleContext {
		public TerminalNode CLASSDECL() { return getToken(LgnParser.CLASSDECL, 0); }
		public List<TerminalNode> WHITESPACE() { return getTokens(LgnParser.WHITESPACE); }
		public TerminalNode WHITESPACE(int i) {
			return getToken(LgnParser.WHITESPACE, i);
		}
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public TerminalNode LISTSTART() { return getToken(LgnParser.LISTSTART, 0); }
		public List<ClasselementContext> classelement() {
			return getRuleContexts(ClasselementContext.class);
		}
		public ClasselementContext classelement(int i) {
			return getRuleContext(ClasselementContext.class,i);
		}
		public TerminalNode LISTEND() { return getToken(LgnParser.LISTEND, 0); }
		public List<TerminalNode> SEP() { return getTokens(LgnParser.SEP); }
		public TerminalNode SEP(int i) {
			return getToken(LgnParser.SEP, i);
		}
		public ClassdeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classdecl; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LgnVisitor ) return ((LgnVisitor<? extends T>)visitor).visitClassdecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassdeclContext classdecl() throws RecognitionException {
		ClassdeclContext _localctx = new ClassdeclContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_classdecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(18);
			match(CLASSDECL);
			setState(19);
			match(WHITESPACE);
			setState(20);
			name();
			setState(21);
			match(WHITESPACE);
			setState(22);
			match(LISTSTART);
			setState(23);
			classelement();
			setState(28);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SEP) {
				{
				{
				setState(24);
				match(SEP);
				setState(25);
				classelement();
				}
				}
				setState(30);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(31);
			match(LISTEND);
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

	public static class ClasselementContext extends ParserRuleContext {
		public OptionalContext optional() {
			return getRuleContext(OptionalContext.class,0);
		}
		public ClassrefContext classref() {
			return getRuleContext(ClassrefContext.class,0);
		}
		public TextContext text() {
			return getRuleContext(TextContext.class,0);
		}
		public ClasselementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classelement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LgnVisitor ) return ((LgnVisitor<? extends T>)visitor).visitClasselement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClasselementContext classelement() throws RecognitionException {
		ClasselementContext _localctx = new ClasselementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_classelement);
		try {
			setState(36);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(33);
				optional();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(34);
				classref();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(35);
				text();
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

	public static class PatternContext extends ParserRuleContext {
		public SequenceContext sequence() {
			return getRuleContext(SequenceContext.class,0);
		}
		public PatternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pattern; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LgnVisitor ) return ((LgnVisitor<? extends T>)visitor).visitPattern(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PatternContext pattern() throws RecognitionException {
		PatternContext _localctx = new PatternContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_pattern);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(38);
			sequence();
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
		public List<SequenceelementContext> sequenceelement() {
			return getRuleContexts(SequenceelementContext.class);
		}
		public SequenceelementContext sequenceelement(int i) {
			return getRuleContext(SequenceelementContext.class,i);
		}
		public List<TerminalNode> WHITESPACE() { return getTokens(LgnParser.WHITESPACE); }
		public TerminalNode WHITESPACE(int i) {
			return getToken(LgnParser.WHITESPACE, i);
		}
		public SequenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sequence; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LgnVisitor ) return ((LgnVisitor<? extends T>)visitor).visitSequence(this);
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
			setState(40);
			sequenceelement();
			setState(43); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(41);
				match(WHITESPACE);
				setState(42);
				sequenceelement();
				}
				}
				setState(45); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==WHITESPACE );
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

	public static class SequenceelementContext extends ParserRuleContext {
		public ClassrefContext classref() {
			return getRuleContext(ClassrefContext.class,0);
		}
		public TextContext text() {
			return getRuleContext(TextContext.class,0);
		}
		public SequenceelementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sequenceelement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LgnVisitor ) return ((LgnVisitor<? extends T>)visitor).visitSequenceelement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SequenceelementContext sequenceelement() throws RecognitionException {
		SequenceelementContext _localctx = new SequenceelementContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_sequenceelement);
		try {
			setState(49);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CLASSREF:
				enterOuterAlt(_localctx, 1);
				{
				setState(47);
				classref();
				}
				break;
			case NAME:
			case STR:
				enterOuterAlt(_localctx, 2);
				{
				setState(48);
				text();
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

	public static class OptionalContext extends ParserRuleContext {
		public TerminalNode OPTIONAL() { return getToken(LgnParser.OPTIONAL, 0); }
		public ClassrefContext classref() {
			return getRuleContext(ClassrefContext.class,0);
		}
		public TextContext text() {
			return getRuleContext(TextContext.class,0);
		}
		public OptionalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_optional; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LgnVisitor ) return ((LgnVisitor<? extends T>)visitor).visitOptional(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OptionalContext optional() throws RecognitionException {
		OptionalContext _localctx = new OptionalContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_optional);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(53);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CLASSREF:
				{
				setState(51);
				classref();
				}
				break;
			case NAME:
			case STR:
				{
				setState(52);
				text();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(55);
			match(OPTIONAL);
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

	public static class ClassrefContext extends ParserRuleContext {
		public TerminalNode CLASSREF() { return getToken(LgnParser.CLASSREF, 0); }
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public ClassrefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classref; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LgnVisitor ) return ((LgnVisitor<? extends T>)visitor).visitClassref(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassrefContext classref() throws RecognitionException {
		ClassrefContext _localctx = new ClassrefContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_classref);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(57);
			match(CLASSREF);
			setState(58);
			name();
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

	public static class NameContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(LgnParser.NAME, 0); }
		public NameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_name; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LgnVisitor ) return ((LgnVisitor<? extends T>)visitor).visitName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NameContext name() throws RecognitionException {
		NameContext _localctx = new NameContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(60);
			match(NAME);
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

	public static class TextContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(LgnParser.NAME, 0); }
		public TerminalNode STR() { return getToken(LgnParser.STR, 0); }
		public TextContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_text; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LgnVisitor ) return ((LgnVisitor<? extends T>)visitor).visitText(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TextContext text() throws RecognitionException {
		TextContext _localctx = new TextContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_text);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(62);
			_la = _input.LA(1);
			if ( !(_la==NAME || _la==STR) ) {
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\13C\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\7\2\35\n\2\f\2\16\2 \13\2\3\2\3\2\3\3\3\3\3\3\5\3"+
		"\'\n\3\3\4\3\4\3\5\3\5\3\5\6\5.\n\5\r\5\16\5/\3\6\3\6\5\6\64\n\6\3\7\3"+
		"\7\5\78\n\7\3\7\3\7\3\b\3\b\3\b\3\t\3\t\3\n\3\n\3\n\2\2\13\2\4\6\b\n\f"+
		"\16\20\22\2\3\3\2\n\13\2?\2\24\3\2\2\2\4&\3\2\2\2\6(\3\2\2\2\b*\3\2\2"+
		"\2\n\63\3\2\2\2\f\67\3\2\2\2\16;\3\2\2\2\20>\3\2\2\2\22@\3\2\2\2\24\25"+
		"\7\t\2\2\25\26\7\4\2\2\26\27\5\20\t\2\27\30\7\4\2\2\30\31\7\5\2\2\31\36"+
		"\5\4\3\2\32\33\7\3\2\2\33\35\5\4\3\2\34\32\3\2\2\2\35 \3\2\2\2\36\34\3"+
		"\2\2\2\36\37\3\2\2\2\37!\3\2\2\2 \36\3\2\2\2!\"\7\6\2\2\"\3\3\2\2\2#\'"+
		"\5\f\7\2$\'\5\16\b\2%\'\5\22\n\2&#\3\2\2\2&$\3\2\2\2&%\3\2\2\2\'\5\3\2"+
		"\2\2()\5\b\5\2)\7\3\2\2\2*-\5\n\6\2+,\7\4\2\2,.\5\n\6\2-+\3\2\2\2./\3"+
		"\2\2\2/-\3\2\2\2/\60\3\2\2\2\60\t\3\2\2\2\61\64\5\16\b\2\62\64\5\22\n"+
		"\2\63\61\3\2\2\2\63\62\3\2\2\2\64\13\3\2\2\2\658\5\16\b\2\668\5\22\n\2"+
		"\67\65\3\2\2\2\67\66\3\2\2\289\3\2\2\29:\7\7\2\2:\r\3\2\2\2;<\7\b\2\2"+
		"<=\5\20\t\2=\17\3\2\2\2>?\7\n\2\2?\21\3\2\2\2@A\t\2\2\2A\23\3\2\2\2\7"+
		"\36&/\63\67";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}