// Generated from Awkwords.g4 by ANTLR 4.7.2
package com.meamoria.lexurgy.gen.java;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class AwkwordsParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		COMMENT=1, ATOM=2, SUBREF=3, ALTSEP=4, OPSTART=5, OPEND=6, GROUPSTART=7, 
		GROUPEND=8, WEIGHT=9, FILTERSEP=10, ESCAPE=11, SUBPATSTART=12, TEMPLATESTART=13, 
		NUMWORDSSTART=14, DIGIT=15, NEWLINE=16;
	public static final int
		RULE_awkfile = 0, RULE_numwords = 1, RULE_subpattern = 2, RULE_pattern = 3, 
		RULE_alternative = 4, RULE_weightedchoice = 5, RULE_altchoice = 6, RULE_filtered = 7, 
		RULE_filterstring = 8, RULE_optional = 9, RULE_sequence = 10, RULE_group = 11, 
		RULE_escape = 12, RULE_subref = 13, RULE_anychar = 14, RULE_atom = 15, 
		RULE_number = 16;
	private static String[] makeRuleNames() {
		return new String[] {
			"awkfile", "numwords", "subpattern", "pattern", "alternative", "weightedchoice", 
			"altchoice", "filtered", "filterstring", "optional", "sequence", "group", 
			"escape", "subref", "anychar", "atom", "number"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, "'/'", "'('", "')'", "'['", "']'", "'*'", "'^'", 
			"'\"'", "':'", "'r:'", "'n:'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "COMMENT", "ATOM", "SUBREF", "ALTSEP", "OPSTART", "OPEND", "GROUPSTART", 
			"GROUPEND", "WEIGHT", "FILTERSEP", "ESCAPE", "SUBPATSTART", "TEMPLATESTART", 
			"NUMWORDSSTART", "DIGIT", "NEWLINE"
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
	public String getGrammarFileName() { return "Awkwords.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public AwkwordsParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class AwkfileContext extends ParserRuleContext {
		public TerminalNode TEMPLATESTART() { return getToken(AwkwordsParser.TEMPLATESTART, 0); }
		public PatternContext pattern() {
			return getRuleContext(PatternContext.class,0);
		}
		public TerminalNode EOF() { return getToken(AwkwordsParser.EOF, 0); }
		public List<SubpatternContext> subpattern() {
			return getRuleContexts(SubpatternContext.class);
		}
		public SubpatternContext subpattern(int i) {
			return getRuleContext(SubpatternContext.class,i);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(AwkwordsParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(AwkwordsParser.NEWLINE, i);
		}
		public NumwordsContext numwords() {
			return getRuleContext(NumwordsContext.class,0);
		}
		public AwkfileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_awkfile; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AwkwordsVisitor ) return ((AwkwordsVisitor<? extends T>)visitor).visitAwkfile(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AwkfileContext awkfile() throws RecognitionException {
		AwkfileContext _localctx = new AwkfileContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_awkfile);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(43);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(37);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==NEWLINE) {
						{
						{
						setState(34);
						match(NEWLINE);
						}
						}
						setState(39);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(40);
					subpattern();
					}
					} 
				}
				setState(45);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			}
			setState(49);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE) {
				{
				{
				setState(46);
				match(NEWLINE);
				}
				}
				setState(51);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(52);
			match(TEMPLATESTART);
			setState(53);
			pattern();
			setState(57);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(54);
					match(NEWLINE);
					}
					} 
				}
				setState(59);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			}
			setState(62);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				{
				setState(60);
				match(NEWLINE);
				setState(61);
				numwords();
				}
				break;
			}
			setState(65);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NEWLINE) {
				{
				setState(64);
				match(NEWLINE);
				}
			}

			setState(67);
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

	public static class NumwordsContext extends ParserRuleContext {
		public TerminalNode NUMWORDSSTART() { return getToken(AwkwordsParser.NUMWORDSSTART, 0); }
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public NumwordsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numwords; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AwkwordsVisitor ) return ((AwkwordsVisitor<? extends T>)visitor).visitNumwords(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumwordsContext numwords() throws RecognitionException {
		NumwordsContext _localctx = new NumwordsContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_numwords);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(69);
			match(NUMWORDSSTART);
			setState(70);
			number();
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

	public static class SubpatternContext extends ParserRuleContext {
		public TerminalNode SUBREF() { return getToken(AwkwordsParser.SUBREF, 0); }
		public TerminalNode SUBPATSTART() { return getToken(AwkwordsParser.SUBPATSTART, 0); }
		public PatternContext pattern() {
			return getRuleContext(PatternContext.class,0);
		}
		public TerminalNode NEWLINE() { return getToken(AwkwordsParser.NEWLINE, 0); }
		public SubpatternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subpattern; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AwkwordsVisitor ) return ((AwkwordsVisitor<? extends T>)visitor).visitSubpattern(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SubpatternContext subpattern() throws RecognitionException {
		SubpatternContext _localctx = new SubpatternContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_subpattern);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(72);
			match(SUBREF);
			setState(73);
			match(SUBPATSTART);
			setState(74);
			pattern();
			setState(75);
			match(NEWLINE);
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
		public FilteredContext filtered() {
			return getRuleContext(FilteredContext.class,0);
		}
		public GroupContext group() {
			return getRuleContext(GroupContext.class,0);
		}
		public EscapeContext escape() {
			return getRuleContext(EscapeContext.class,0);
		}
		public OptionalContext optional() {
			return getRuleContext(OptionalContext.class,0);
		}
		public SubrefContext subref() {
			return getRuleContext(SubrefContext.class,0);
		}
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public AlternativeContext alternative() {
			return getRuleContext(AlternativeContext.class,0);
		}
		public SequenceContext sequence() {
			return getRuleContext(SequenceContext.class,0);
		}
		public PatternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pattern; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AwkwordsVisitor ) return ((AwkwordsVisitor<? extends T>)visitor).visitPattern(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PatternContext pattern() throws RecognitionException {
		PatternContext _localctx = new PatternContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_pattern);
		try {
			setState(85);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(77);
				filtered();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(78);
				group();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(79);
				escape();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(80);
				optional();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(81);
				subref();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(82);
				atom();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(83);
				alternative();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(84);
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

	public static class AlternativeContext extends ParserRuleContext {
		public List<WeightedchoiceContext> weightedchoice() {
			return getRuleContexts(WeightedchoiceContext.class);
		}
		public WeightedchoiceContext weightedchoice(int i) {
			return getRuleContext(WeightedchoiceContext.class,i);
		}
		public List<TerminalNode> ALTSEP() { return getTokens(AwkwordsParser.ALTSEP); }
		public TerminalNode ALTSEP(int i) {
			return getToken(AwkwordsParser.ALTSEP, i);
		}
		public AlternativeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_alternative; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AwkwordsVisitor ) return ((AwkwordsVisitor<? extends T>)visitor).visitAlternative(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AlternativeContext alternative() throws RecognitionException {
		AlternativeContext _localctx = new AlternativeContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_alternative);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(87);
			weightedchoice();
			setState(90); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(88);
				match(ALTSEP);
				setState(89);
				weightedchoice();
				}
				}
				setState(92); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==ALTSEP );
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

	public static class WeightedchoiceContext extends ParserRuleContext {
		public AltchoiceContext altchoice() {
			return getRuleContext(AltchoiceContext.class,0);
		}
		public TerminalNode WEIGHT() { return getToken(AwkwordsParser.WEIGHT, 0); }
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public WeightedchoiceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_weightedchoice; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AwkwordsVisitor ) return ((AwkwordsVisitor<? extends T>)visitor).visitWeightedchoice(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WeightedchoiceContext weightedchoice() throws RecognitionException {
		WeightedchoiceContext _localctx = new WeightedchoiceContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_weightedchoice);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(94);
			altchoice();
			setState(97);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WEIGHT) {
				{
				setState(95);
				match(WEIGHT);
				setState(96);
				number();
				}
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

	public static class AltchoiceContext extends ParserRuleContext {
		public FilteredContext filtered() {
			return getRuleContext(FilteredContext.class,0);
		}
		public GroupContext group() {
			return getRuleContext(GroupContext.class,0);
		}
		public EscapeContext escape() {
			return getRuleContext(EscapeContext.class,0);
		}
		public OptionalContext optional() {
			return getRuleContext(OptionalContext.class,0);
		}
		public SubrefContext subref() {
			return getRuleContext(SubrefContext.class,0);
		}
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public SequenceContext sequence() {
			return getRuleContext(SequenceContext.class,0);
		}
		public AltchoiceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_altchoice; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AwkwordsVisitor ) return ((AwkwordsVisitor<? extends T>)visitor).visitAltchoice(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AltchoiceContext altchoice() throws RecognitionException {
		AltchoiceContext _localctx = new AltchoiceContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_altchoice);
		try {
			setState(106);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(99);
				filtered();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(100);
				group();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(101);
				escape();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(102);
				optional();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(103);
				subref();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(104);
				atom();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(105);
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

	public static class FilteredContext extends ParserRuleContext {
		public GroupContext group() {
			return getRuleContext(GroupContext.class,0);
		}
		public List<TerminalNode> FILTERSEP() { return getTokens(AwkwordsParser.FILTERSEP); }
		public TerminalNode FILTERSEP(int i) {
			return getToken(AwkwordsParser.FILTERSEP, i);
		}
		public List<FilterstringContext> filterstring() {
			return getRuleContexts(FilterstringContext.class);
		}
		public FilterstringContext filterstring(int i) {
			return getRuleContext(FilterstringContext.class,i);
		}
		public FilteredContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_filtered; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AwkwordsVisitor ) return ((AwkwordsVisitor<? extends T>)visitor).visitFiltered(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FilteredContext filtered() throws RecognitionException {
		FilteredContext _localctx = new FilteredContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_filtered);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(108);
			group();
			setState(111); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(109);
				match(FILTERSEP);
				setState(110);
				filterstring();
				}
				}
				setState(113); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==FILTERSEP );
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

	public static class FilterstringContext extends ParserRuleContext {
		public List<AtomContext> atom() {
			return getRuleContexts(AtomContext.class);
		}
		public AtomContext atom(int i) {
			return getRuleContext(AtomContext.class,i);
		}
		public FilterstringContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_filterstring; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AwkwordsVisitor ) return ((AwkwordsVisitor<? extends T>)visitor).visitFilterstring(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FilterstringContext filterstring() throws RecognitionException {
		FilterstringContext _localctx = new FilterstringContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_filterstring);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(116); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(115);
					atom();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(118); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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
		public TerminalNode OPSTART() { return getToken(AwkwordsParser.OPSTART, 0); }
		public PatternContext pattern() {
			return getRuleContext(PatternContext.class,0);
		}
		public TerminalNode OPEND() { return getToken(AwkwordsParser.OPEND, 0); }
		public OptionalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_optional; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AwkwordsVisitor ) return ((AwkwordsVisitor<? extends T>)visitor).visitOptional(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OptionalContext optional() throws RecognitionException {
		OptionalContext _localctx = new OptionalContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_optional);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(120);
			match(OPSTART);
			setState(121);
			pattern();
			setState(122);
			match(OPEND);
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
		public List<FilteredContext> filtered() {
			return getRuleContexts(FilteredContext.class);
		}
		public FilteredContext filtered(int i) {
			return getRuleContext(FilteredContext.class,i);
		}
		public List<GroupContext> group() {
			return getRuleContexts(GroupContext.class);
		}
		public GroupContext group(int i) {
			return getRuleContext(GroupContext.class,i);
		}
		public List<EscapeContext> escape() {
			return getRuleContexts(EscapeContext.class);
		}
		public EscapeContext escape(int i) {
			return getRuleContext(EscapeContext.class,i);
		}
		public List<OptionalContext> optional() {
			return getRuleContexts(OptionalContext.class);
		}
		public OptionalContext optional(int i) {
			return getRuleContext(OptionalContext.class,i);
		}
		public List<SubrefContext> subref() {
			return getRuleContexts(SubrefContext.class);
		}
		public SubrefContext subref(int i) {
			return getRuleContext(SubrefContext.class,i);
		}
		public List<AtomContext> atom() {
			return getRuleContexts(AtomContext.class);
		}
		public AtomContext atom(int i) {
			return getRuleContext(AtomContext.class,i);
		}
		public SequenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sequence; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AwkwordsVisitor ) return ((AwkwordsVisitor<? extends T>)visitor).visitSequence(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SequenceContext sequence() throws RecognitionException {
		SequenceContext _localctx = new SequenceContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_sequence);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(130); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(130);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
				case 1:
					{
					setState(124);
					filtered();
					}
					break;
				case 2:
					{
					setState(125);
					group();
					}
					break;
				case 3:
					{
					setState(126);
					escape();
					}
					break;
				case 4:
					{
					setState(127);
					optional();
					}
					break;
				case 5:
					{
					setState(128);
					subref();
					}
					break;
				case 6:
					{
					setState(129);
					atom();
					}
					break;
				}
				}
				setState(132); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ATOM) | (1L << SUBREF) | (1L << OPSTART) | (1L << GROUPSTART) | (1L << ESCAPE) | (1L << SUBPATSTART) | (1L << DIGIT))) != 0) );
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
		public TerminalNode GROUPSTART() { return getToken(AwkwordsParser.GROUPSTART, 0); }
		public PatternContext pattern() {
			return getRuleContext(PatternContext.class,0);
		}
		public TerminalNode GROUPEND() { return getToken(AwkwordsParser.GROUPEND, 0); }
		public GroupContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_group; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AwkwordsVisitor ) return ((AwkwordsVisitor<? extends T>)visitor).visitGroup(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GroupContext group() throws RecognitionException {
		GroupContext _localctx = new GroupContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_group);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(134);
			match(GROUPSTART);
			setState(135);
			pattern();
			setState(136);
			match(GROUPEND);
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

	public static class EscapeContext extends ParserRuleContext {
		public List<TerminalNode> ESCAPE() { return getTokens(AwkwordsParser.ESCAPE); }
		public TerminalNode ESCAPE(int i) {
			return getToken(AwkwordsParser.ESCAPE, i);
		}
		public List<AnycharContext> anychar() {
			return getRuleContexts(AnycharContext.class);
		}
		public AnycharContext anychar(int i) {
			return getRuleContext(AnycharContext.class,i);
		}
		public EscapeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_escape; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AwkwordsVisitor ) return ((AwkwordsVisitor<? extends T>)visitor).visitEscape(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EscapeContext escape() throws RecognitionException {
		EscapeContext _localctx = new EscapeContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_escape);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(138);
			match(ESCAPE);
			setState(140); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(139);
				anychar();
				}
				}
				setState(142); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ATOM) | (1L << SUBREF) | (1L << ALTSEP) | (1L << OPSTART) | (1L << OPEND) | (1L << GROUPSTART) | (1L << GROUPEND) | (1L << WEIGHT) | (1L << FILTERSEP) | (1L << SUBPATSTART))) != 0) );
			setState(144);
			match(ESCAPE);
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

	public static class SubrefContext extends ParserRuleContext {
		public TerminalNode SUBREF() { return getToken(AwkwordsParser.SUBREF, 0); }
		public SubrefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subref; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AwkwordsVisitor ) return ((AwkwordsVisitor<? extends T>)visitor).visitSubref(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SubrefContext subref() throws RecognitionException {
		SubrefContext _localctx = new SubrefContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_subref);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(146);
			match(SUBREF);
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

	public static class AnycharContext extends ParserRuleContext {
		public TerminalNode ATOM() { return getToken(AwkwordsParser.ATOM, 0); }
		public TerminalNode SUBREF() { return getToken(AwkwordsParser.SUBREF, 0); }
		public TerminalNode ALTSEP() { return getToken(AwkwordsParser.ALTSEP, 0); }
		public TerminalNode OPSTART() { return getToken(AwkwordsParser.OPSTART, 0); }
		public TerminalNode OPEND() { return getToken(AwkwordsParser.OPEND, 0); }
		public TerminalNode GROUPSTART() { return getToken(AwkwordsParser.GROUPSTART, 0); }
		public TerminalNode GROUPEND() { return getToken(AwkwordsParser.GROUPEND, 0); }
		public TerminalNode WEIGHT() { return getToken(AwkwordsParser.WEIGHT, 0); }
		public TerminalNode FILTERSEP() { return getToken(AwkwordsParser.FILTERSEP, 0); }
		public TerminalNode SUBPATSTART() { return getToken(AwkwordsParser.SUBPATSTART, 0); }
		public AnycharContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_anychar; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AwkwordsVisitor ) return ((AwkwordsVisitor<? extends T>)visitor).visitAnychar(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AnycharContext anychar() throws RecognitionException {
		AnycharContext _localctx = new AnycharContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_anychar);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(148);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ATOM) | (1L << SUBREF) | (1L << ALTSEP) | (1L << OPSTART) | (1L << OPEND) | (1L << GROUPSTART) | (1L << GROUPEND) | (1L << WEIGHT) | (1L << FILTERSEP) | (1L << SUBPATSTART))) != 0)) ) {
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

	public static class AtomContext extends ParserRuleContext {
		public TerminalNode ATOM() { return getToken(AwkwordsParser.ATOM, 0); }
		public TerminalNode SUBPATSTART() { return getToken(AwkwordsParser.SUBPATSTART, 0); }
		public TerminalNode DIGIT() { return getToken(AwkwordsParser.DIGIT, 0); }
		public AtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atom; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AwkwordsVisitor ) return ((AwkwordsVisitor<? extends T>)visitor).visitAtom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtomContext atom() throws RecognitionException {
		AtomContext _localctx = new AtomContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_atom);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(150);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ATOM) | (1L << SUBPATSTART) | (1L << DIGIT))) != 0)) ) {
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

	public static class NumberContext extends ParserRuleContext {
		public List<TerminalNode> DIGIT() { return getTokens(AwkwordsParser.DIGIT); }
		public TerminalNode DIGIT(int i) {
			return getToken(AwkwordsParser.DIGIT, i);
		}
		public NumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_number; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AwkwordsVisitor ) return ((AwkwordsVisitor<? extends T>)visitor).visitNumber(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumberContext number() throws RecognitionException {
		NumberContext _localctx = new NumberContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_number);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(153); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(152);
				match(DIGIT);
				}
				}
				setState(155); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==DIGIT );
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\22\u00a0\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\3\2\7\2&\n\2\f\2\16\2)\13\2\3\2\7\2,\n\2\f\2\16\2/\13\2\3\2\7\2\62\n"+
		"\2\f\2\16\2\65\13\2\3\2\3\2\3\2\7\2:\n\2\f\2\16\2=\13\2\3\2\3\2\5\2A\n"+
		"\2\3\2\5\2D\n\2\3\2\3\2\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\5\5X\n\5\3\6\3\6\3\6\6\6]\n\6\r\6\16\6^\3\7\3\7\3\7"+
		"\5\7d\n\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\bm\n\b\3\t\3\t\3\t\6\tr\n\t\r"+
		"\t\16\ts\3\n\6\nw\n\n\r\n\16\nx\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\6\f\u0085\n\f\r\f\16\f\u0086\3\r\3\r\3\r\3\r\3\16\3\16\6\16\u008f"+
		"\n\16\r\16\16\16\u0090\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22\6"+
		"\22\u009c\n\22\r\22\16\22\u009d\3\22\2\2\23\2\4\6\b\n\f\16\20\22\24\26"+
		"\30\32\34\36 \"\2\4\4\2\4\f\16\16\5\2\4\4\16\16\21\21\2\u00ad\2-\3\2\2"+
		"\2\4G\3\2\2\2\6J\3\2\2\2\bW\3\2\2\2\nY\3\2\2\2\f`\3\2\2\2\16l\3\2\2\2"+
		"\20n\3\2\2\2\22v\3\2\2\2\24z\3\2\2\2\26\u0084\3\2\2\2\30\u0088\3\2\2\2"+
		"\32\u008c\3\2\2\2\34\u0094\3\2\2\2\36\u0096\3\2\2\2 \u0098\3\2\2\2\"\u009b"+
		"\3\2\2\2$&\7\22\2\2%$\3\2\2\2&)\3\2\2\2\'%\3\2\2\2\'(\3\2\2\2(*\3\2\2"+
		"\2)\'\3\2\2\2*,\5\6\4\2+\'\3\2\2\2,/\3\2\2\2-+\3\2\2\2-.\3\2\2\2.\63\3"+
		"\2\2\2/-\3\2\2\2\60\62\7\22\2\2\61\60\3\2\2\2\62\65\3\2\2\2\63\61\3\2"+
		"\2\2\63\64\3\2\2\2\64\66\3\2\2\2\65\63\3\2\2\2\66\67\7\17\2\2\67;\5\b"+
		"\5\28:\7\22\2\298\3\2\2\2:=\3\2\2\2;9\3\2\2\2;<\3\2\2\2<@\3\2\2\2=;\3"+
		"\2\2\2>?\7\22\2\2?A\5\4\3\2@>\3\2\2\2@A\3\2\2\2AC\3\2\2\2BD\7\22\2\2C"+
		"B\3\2\2\2CD\3\2\2\2DE\3\2\2\2EF\7\2\2\3F\3\3\2\2\2GH\7\20\2\2HI\5\"\22"+
		"\2I\5\3\2\2\2JK\7\5\2\2KL\7\16\2\2LM\5\b\5\2MN\7\22\2\2N\7\3\2\2\2OX\5"+
		"\20\t\2PX\5\30\r\2QX\5\32\16\2RX\5\24\13\2SX\5\34\17\2TX\5 \21\2UX\5\n"+
		"\6\2VX\5\26\f\2WO\3\2\2\2WP\3\2\2\2WQ\3\2\2\2WR\3\2\2\2WS\3\2\2\2WT\3"+
		"\2\2\2WU\3\2\2\2WV\3\2\2\2X\t\3\2\2\2Y\\\5\f\7\2Z[\7\6\2\2[]\5\f\7\2\\"+
		"Z\3\2\2\2]^\3\2\2\2^\\\3\2\2\2^_\3\2\2\2_\13\3\2\2\2`c\5\16\b\2ab\7\13"+
		"\2\2bd\5\"\22\2ca\3\2\2\2cd\3\2\2\2d\r\3\2\2\2em\5\20\t\2fm\5\30\r\2g"+
		"m\5\32\16\2hm\5\24\13\2im\5\34\17\2jm\5 \21\2km\5\26\f\2le\3\2\2\2lf\3"+
		"\2\2\2lg\3\2\2\2lh\3\2\2\2li\3\2\2\2lj\3\2\2\2lk\3\2\2\2m\17\3\2\2\2n"+
		"q\5\30\r\2op\7\f\2\2pr\5\22\n\2qo\3\2\2\2rs\3\2\2\2sq\3\2\2\2st\3\2\2"+
		"\2t\21\3\2\2\2uw\5 \21\2vu\3\2\2\2wx\3\2\2\2xv\3\2\2\2xy\3\2\2\2y\23\3"+
		"\2\2\2z{\7\7\2\2{|\5\b\5\2|}\7\b\2\2}\25\3\2\2\2~\u0085\5\20\t\2\177\u0085"+
		"\5\30\r\2\u0080\u0085\5\32\16\2\u0081\u0085\5\24\13\2\u0082\u0085\5\34"+
		"\17\2\u0083\u0085\5 \21\2\u0084~\3\2\2\2\u0084\177\3\2\2\2\u0084\u0080"+
		"\3\2\2\2\u0084\u0081\3\2\2\2\u0084\u0082\3\2\2\2\u0084\u0083\3\2\2\2\u0085"+
		"\u0086\3\2\2\2\u0086\u0084\3\2\2\2\u0086\u0087\3\2\2\2\u0087\27\3\2\2"+
		"\2\u0088\u0089\7\t\2\2\u0089\u008a\5\b\5\2\u008a\u008b\7\n\2\2\u008b\31"+
		"\3\2\2\2\u008c\u008e\7\r\2\2\u008d\u008f\5\36\20\2\u008e\u008d\3\2\2\2"+
		"\u008f\u0090\3\2\2\2\u0090\u008e\3\2\2\2\u0090\u0091\3\2\2\2\u0091\u0092"+
		"\3\2\2\2\u0092\u0093\7\r\2\2\u0093\33\3\2\2\2\u0094\u0095\7\5\2\2\u0095"+
		"\35\3\2\2\2\u0096\u0097\t\2\2\2\u0097\37\3\2\2\2\u0098\u0099\t\3\2\2\u0099"+
		"!\3\2\2\2\u009a\u009c\7\21\2\2\u009b\u009a\3\2\2\2\u009c\u009d\3\2\2\2"+
		"\u009d\u009b\3\2\2\2\u009d\u009e\3\2\2\2\u009e#\3\2\2\2\22\'-\63;@CW^"+
		"clsx\u0084\u0086\u0090\u009d";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}