// Generated from Lsc.g4 by ANTLR 4.7.2
package com.meamoria.lexurgy.sc;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class LscParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		COMMENT=1, SEP=2, CHANGE=3, CONDITION=4, EXCLUSION=5, ANCHOR=6, NEWLINE=7, 
		WHITESPACE=8, OPAREN=9, CPAREN=10, NULL=11, MATSTART=12, MATEND=13, LISTSTART=14, 
		LISTEND=15, ATLEASTONE=16, OPTIONAL=17, HYPHEN=18, RULESTART=19, NEGATION=20, 
		WORDBOUNDARY=21, CLASSREF=22, CLASSDECL=23, FEATUREDECL=24, DIACRITIC=25, 
		DIABEFORE=26, SYMBOL=27, DEROMANIZER=28, ROMANIZER=29, SUBRULE=30, PROPAGATE=31, 
		FEATURE=32, VALUE=33, NUMBER=34, STR1=35, STR=36;
	public static final int
		RULE_lscfile = 0, RULE_classdecl = 1, RULE_featuredecl = 2, RULE_nullalias = 3, 
		RULE_diacritic = 4, RULE_symbol = 5, RULE_symbolname = 6, RULE_deromanizer = 7, 
		RULE_romanizer = 8, RULE_changerule = 9, RULE_subrule = 10, RULE_rulename = 11, 
		RULE_ruleexpression = 12, RULE_condition = 13, RULE_exclusion = 14, RULE_rulefrom = 15, 
		RULE_ruleto = 16, RULE_environlist = 17, RULE_ruleenviron = 18, RULE_boundarybefore = 19, 
		RULE_boundaryafter = 20, RULE_rulebefore = 21, RULE_ruleafter = 22, RULE_ruleelement = 23, 
		RULE_rulesequence = 24, RULE_sequenceelement = 25, RULE_rulecapture = 26, 
		RULE_rulerepeater = 27, RULE_rulegroup = 28, RULE_rulelist = 29, RULE_simpleelement = 30, 
		RULE_classref = 31, RULE_captureref = 32, RULE_fancymatrix = 33, RULE_fancyvalue = 34, 
		RULE_negvalue = 35, RULE_absentfeature = 36, RULE_featurevariable = 37, 
		RULE_empty = 38, RULE_repeatertype = 39, RULE_matrix = 40, RULE_feature = 41, 
		RULE_value = 42, RULE_text = 43;
	private static String[] makeRuleNames() {
		return new String[] {
			"lscfile", "classdecl", "featuredecl", "nullalias", "diacritic", "symbol", 
			"symbolname", "deromanizer", "romanizer", "changerule", "subrule", "rulename", 
			"ruleexpression", "condition", "exclusion", "rulefrom", "ruleto", "environlist", 
			"ruleenviron", "boundarybefore", "boundaryafter", "rulebefore", "ruleafter", 
			"ruleelement", "rulesequence", "sequenceelement", "rulecapture", "rulerepeater", 
			"rulegroup", "rulelist", "simpleelement", "classref", "captureref", "fancymatrix", 
			"fancyvalue", "negvalue", "absentfeature", "featurevariable", "empty", 
			"repeatertype", "matrix", "feature", "value", "text"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, null, "'_'", null, null, "'('", "')'", 
			"'*'", "'['", "']'", "'{'", "'}'", "'+'", "'?'", "'-'", "':'", "'!'", 
			"'$'", "'@'", "'Class'", "'Feature'", "'Diacritic'", "'(before)'", "'Symbol'", 
			"'Deromanizer'", "'Romanizer'", "'Then'", "'propagate'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "COMMENT", "SEP", "CHANGE", "CONDITION", "EXCLUSION", "ANCHOR", 
			"NEWLINE", "WHITESPACE", "OPAREN", "CPAREN", "NULL", "MATSTART", "MATEND", 
			"LISTSTART", "LISTEND", "ATLEASTONE", "OPTIONAL", "HYPHEN", "RULESTART", 
			"NEGATION", "WORDBOUNDARY", "CLASSREF", "CLASSDECL", "FEATUREDECL", "DIACRITIC", 
			"DIABEFORE", "SYMBOL", "DEROMANIZER", "ROMANIZER", "SUBRULE", "PROPAGATE", 
			"FEATURE", "VALUE", "NUMBER", "STR1", "STR"
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
	public String getGrammarFileName() { return "Lsc.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public LscParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class LscfileContext extends ParserRuleContext {
		public List<ChangeruleContext> changerule() {
			return getRuleContexts(ChangeruleContext.class);
		}
		public ChangeruleContext changerule(int i) {
			return getRuleContext(ChangeruleContext.class,i);
		}
		public List<FeaturedeclContext> featuredecl() {
			return getRuleContexts(FeaturedeclContext.class);
		}
		public FeaturedeclContext featuredecl(int i) {
			return getRuleContext(FeaturedeclContext.class,i);
		}
		public List<DiacriticContext> diacritic() {
			return getRuleContexts(DiacriticContext.class);
		}
		public DiacriticContext diacritic(int i) {
			return getRuleContext(DiacriticContext.class,i);
		}
		public List<SymbolContext> symbol() {
			return getRuleContexts(SymbolContext.class);
		}
		public SymbolContext symbol(int i) {
			return getRuleContext(SymbolContext.class,i);
		}
		public List<ClassdeclContext> classdecl() {
			return getRuleContexts(ClassdeclContext.class);
		}
		public ClassdeclContext classdecl(int i) {
			return getRuleContext(ClassdeclContext.class,i);
		}
		public DeromanizerContext deromanizer() {
			return getRuleContext(DeromanizerContext.class,0);
		}
		public RomanizerContext romanizer() {
			return getRuleContext(RomanizerContext.class,0);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(LscParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(LscParser.NEWLINE, i);
		}
		public LscfileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lscfile; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LscVisitor ) return ((LscVisitor<? extends T>)visitor).visitLscfile(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LscfileContext lscfile() throws RecognitionException {
		LscfileContext _localctx = new LscfileContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_lscfile);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(96);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==FEATUREDECL) {
				{
				{
				setState(88);
				featuredecl();
				setState(90); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(89);
					match(NEWLINE);
					}
					}
					setState(92); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NEWLINE );
				}
				}
				setState(98);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(107);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DIACRITIC) {
				{
				{
				setState(99);
				diacritic();
				setState(101); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(100);
					match(NEWLINE);
					}
					}
					setState(103); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NEWLINE );
				}
				}
				setState(109);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(118);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SYMBOL) {
				{
				{
				setState(110);
				symbol();
				setState(112); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(111);
					match(NEWLINE);
					}
					}
					setState(114); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NEWLINE );
				}
				}
				setState(120);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(129);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CLASSDECL) {
				{
				{
				setState(121);
				classdecl();
				setState(123); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(122);
					match(NEWLINE);
					}
					}
					setState(125); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NEWLINE );
				}
				}
				setState(131);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(138);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DEROMANIZER) {
				{
				setState(132);
				deromanizer();
				setState(134); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(133);
					match(NEWLINE);
					}
					}
					setState(136); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NEWLINE );
				}
			}

			setState(140);
			changerule();
			setState(149);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(142); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(141);
						match(NEWLINE);
						}
						}
						setState(144); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==NEWLINE );
					setState(146);
					changerule();
					}
					} 
				}
				setState(151);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			}
			setState(158);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				{
				setState(153); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(152);
					match(NEWLINE);
					}
					}
					setState(155); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NEWLINE );
				setState(157);
				romanizer();
				}
				break;
			}
			setState(161);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NEWLINE) {
				{
				setState(160);
				match(NEWLINE);
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

	public static class ClassdeclContext extends ParserRuleContext {
		public TerminalNode CLASSDECL() { return getToken(LscParser.CLASSDECL, 0); }
		public List<TerminalNode> WHITESPACE() { return getTokens(LscParser.WHITESPACE); }
		public TerminalNode WHITESPACE(int i) {
			return getToken(LscParser.WHITESPACE, i);
		}
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public TerminalNode LISTSTART() { return getToken(LscParser.LISTSTART, 0); }
		public List<TextContext> text() {
			return getRuleContexts(TextContext.class);
		}
		public TextContext text(int i) {
			return getRuleContext(TextContext.class,i);
		}
		public TerminalNode LISTEND() { return getToken(LscParser.LISTEND, 0); }
		public List<TerminalNode> SEP() { return getTokens(LscParser.SEP); }
		public TerminalNode SEP(int i) {
			return getToken(LscParser.SEP, i);
		}
		public ClassdeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classdecl; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LscVisitor ) return ((LscVisitor<? extends T>)visitor).visitClassdecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassdeclContext classdecl() throws RecognitionException {
		ClassdeclContext _localctx = new ClassdeclContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_classdecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(163);
			match(CLASSDECL);
			setState(164);
			match(WHITESPACE);
			setState(165);
			value();
			setState(166);
			match(WHITESPACE);
			setState(167);
			match(LISTSTART);
			setState(168);
			text();
			setState(173);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SEP) {
				{
				{
				setState(169);
				match(SEP);
				setState(170);
				text();
				}
				}
				setState(175);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(176);
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

	public static class FeaturedeclContext extends ParserRuleContext {
		public TerminalNode FEATUREDECL() { return getToken(LscParser.FEATUREDECL, 0); }
		public TerminalNode WHITESPACE() { return getToken(LscParser.WHITESPACE, 0); }
		public FeatureContext feature() {
			return getRuleContext(FeatureContext.class,0);
		}
		public TerminalNode OPAREN() { return getToken(LscParser.OPAREN, 0); }
		public List<ValueContext> value() {
			return getRuleContexts(ValueContext.class);
		}
		public ValueContext value(int i) {
			return getRuleContext(ValueContext.class,i);
		}
		public TerminalNode CPAREN() { return getToken(LscParser.CPAREN, 0); }
		public NullaliasContext nullalias() {
			return getRuleContext(NullaliasContext.class,0);
		}
		public List<TerminalNode> SEP() { return getTokens(LscParser.SEP); }
		public TerminalNode SEP(int i) {
			return getToken(LscParser.SEP, i);
		}
		public TerminalNode CHANGE() { return getToken(LscParser.CHANGE, 0); }
		public MatrixContext matrix() {
			return getRuleContext(MatrixContext.class,0);
		}
		public FeaturedeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_featuredecl; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LscVisitor ) return ((LscVisitor<? extends T>)visitor).visitFeaturedecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FeaturedeclContext featuredecl() throws RecognitionException {
		FeaturedeclContext _localctx = new FeaturedeclContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_featuredecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(178);
			match(FEATUREDECL);
			setState(179);
			match(WHITESPACE);
			setState(180);
			feature();
			setState(181);
			match(OPAREN);
			setState(185);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NULL) {
				{
				setState(182);
				nullalias();
				setState(183);
				match(SEP);
				}
			}

			setState(187);
			value();
			setState(192);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SEP) {
				{
				{
				setState(188);
				match(SEP);
				setState(189);
				value();
				}
				}
				setState(194);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(195);
			match(CPAREN);
			setState(198);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CHANGE) {
				{
				setState(196);
				match(CHANGE);
				setState(197);
				matrix();
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

	public static class NullaliasContext extends ParserRuleContext {
		public TerminalNode NULL() { return getToken(LscParser.NULL, 0); }
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public NullaliasContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nullalias; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LscVisitor ) return ((LscVisitor<? extends T>)visitor).visitNullalias(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NullaliasContext nullalias() throws RecognitionException {
		NullaliasContext _localctx = new NullaliasContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_nullalias);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(200);
			match(NULL);
			setState(201);
			value();
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

	public static class DiacriticContext extends ParserRuleContext {
		public TerminalNode DIACRITIC() { return getToken(LscParser.DIACRITIC, 0); }
		public List<TerminalNode> WHITESPACE() { return getTokens(LscParser.WHITESPACE); }
		public TerminalNode WHITESPACE(int i) {
			return getToken(LscParser.WHITESPACE, i);
		}
		public TerminalNode STR1() { return getToken(LscParser.STR1, 0); }
		public MatrixContext matrix() {
			return getRuleContext(MatrixContext.class,0);
		}
		public TerminalNode DIABEFORE() { return getToken(LscParser.DIABEFORE, 0); }
		public DiacriticContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_diacritic; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LscVisitor ) return ((LscVisitor<? extends T>)visitor).visitDiacritic(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DiacriticContext diacritic() throws RecognitionException {
		DiacriticContext _localctx = new DiacriticContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_diacritic);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(203);
			match(DIACRITIC);
			setState(204);
			match(WHITESPACE);
			setState(205);
			match(STR1);
			setState(206);
			match(WHITESPACE);
			setState(209);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DIABEFORE) {
				{
				setState(207);
				match(DIABEFORE);
				setState(208);
				match(WHITESPACE);
				}
			}

			setState(211);
			matrix();
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

	public static class SymbolContext extends ParserRuleContext {
		public TerminalNode SYMBOL() { return getToken(LscParser.SYMBOL, 0); }
		public List<TerminalNode> WHITESPACE() { return getTokens(LscParser.WHITESPACE); }
		public TerminalNode WHITESPACE(int i) {
			return getToken(LscParser.WHITESPACE, i);
		}
		public List<SymbolnameContext> symbolname() {
			return getRuleContexts(SymbolnameContext.class);
		}
		public SymbolnameContext symbolname(int i) {
			return getRuleContext(SymbolnameContext.class,i);
		}
		public MatrixContext matrix() {
			return getRuleContext(MatrixContext.class,0);
		}
		public List<TerminalNode> SEP() { return getTokens(LscParser.SEP); }
		public TerminalNode SEP(int i) {
			return getToken(LscParser.SEP, i);
		}
		public SymbolContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_symbol; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LscVisitor ) return ((LscVisitor<? extends T>)visitor).visitSymbol(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SymbolContext symbol() throws RecognitionException {
		SymbolContext _localctx = new SymbolContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_symbol);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(213);
			match(SYMBOL);
			setState(214);
			match(WHITESPACE);
			setState(215);
			symbolname();
			setState(225);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SEP:
			case NEWLINE:
				{
				setState(220);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==SEP) {
					{
					{
					setState(216);
					match(SEP);
					setState(217);
					symbolname();
					}
					}
					setState(222);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case WHITESPACE:
				{
				setState(223);
				match(WHITESPACE);
				setState(224);
				matrix();
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class SymbolnameContext extends ParserRuleContext {
		public TextContext text() {
			return getRuleContext(TextContext.class,0);
		}
		public SymbolnameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_symbolname; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LscVisitor ) return ((LscVisitor<? extends T>)visitor).visitSymbolname(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SymbolnameContext symbolname() throws RecognitionException {
		SymbolnameContext _localctx = new SymbolnameContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_symbolname);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(227);
			text();
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

	public static class DeromanizerContext extends ParserRuleContext {
		public TerminalNode DEROMANIZER() { return getToken(LscParser.DEROMANIZER, 0); }
		public TerminalNode RULESTART() { return getToken(LscParser.RULESTART, 0); }
		public List<RuleexpressionContext> ruleexpression() {
			return getRuleContexts(RuleexpressionContext.class);
		}
		public RuleexpressionContext ruleexpression(int i) {
			return getRuleContext(RuleexpressionContext.class,i);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(LscParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(LscParser.NEWLINE, i);
		}
		public DeromanizerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_deromanizer; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LscVisitor ) return ((LscVisitor<? extends T>)visitor).visitDeromanizer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeromanizerContext deromanizer() throws RecognitionException {
		DeromanizerContext _localctx = new DeromanizerContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_deromanizer);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(229);
			match(DEROMANIZER);
			setState(230);
			match(RULESTART);
			setState(237); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(232); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(231);
						match(NEWLINE);
						}
						}
						setState(234); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==NEWLINE );
					setState(236);
					ruleexpression();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(239); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
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

	public static class RomanizerContext extends ParserRuleContext {
		public TerminalNode ROMANIZER() { return getToken(LscParser.ROMANIZER, 0); }
		public TerminalNode RULESTART() { return getToken(LscParser.RULESTART, 0); }
		public List<RuleexpressionContext> ruleexpression() {
			return getRuleContexts(RuleexpressionContext.class);
		}
		public RuleexpressionContext ruleexpression(int i) {
			return getRuleContext(RuleexpressionContext.class,i);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(LscParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(LscParser.NEWLINE, i);
		}
		public RomanizerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_romanizer; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LscVisitor ) return ((LscVisitor<? extends T>)visitor).visitRomanizer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RomanizerContext romanizer() throws RecognitionException {
		RomanizerContext _localctx = new RomanizerContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_romanizer);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(241);
			match(ROMANIZER);
			setState(242);
			match(RULESTART);
			setState(249); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(244); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(243);
						match(NEWLINE);
						}
						}
						setState(246); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==NEWLINE );
					setState(248);
					ruleexpression();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(251); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
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

	public static class ChangeruleContext extends ParserRuleContext {
		public RulenameContext rulename() {
			return getRuleContext(RulenameContext.class,0);
		}
		public List<TerminalNode> RULESTART() { return getTokens(LscParser.RULESTART); }
		public TerminalNode RULESTART(int i) {
			return getToken(LscParser.RULESTART, i);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(LscParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(LscParser.NEWLINE, i);
		}
		public List<SubruleContext> subrule() {
			return getRuleContexts(SubruleContext.class);
		}
		public SubruleContext subrule(int i) {
			return getRuleContext(SubruleContext.class,i);
		}
		public List<TerminalNode> WHITESPACE() { return getTokens(LscParser.WHITESPACE); }
		public TerminalNode WHITESPACE(int i) {
			return getToken(LscParser.WHITESPACE, i);
		}
		public MatrixContext matrix() {
			return getRuleContext(MatrixContext.class,0);
		}
		public TerminalNode PROPAGATE() { return getToken(LscParser.PROPAGATE, 0); }
		public List<TerminalNode> SUBRULE() { return getTokens(LscParser.SUBRULE); }
		public TerminalNode SUBRULE(int i) {
			return getToken(LscParser.SUBRULE, i);
		}
		public ChangeruleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_changerule; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LscVisitor ) return ((LscVisitor<? extends T>)visitor).visitChangerule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ChangeruleContext changerule() throws RecognitionException {
		ChangeruleContext _localctx = new ChangeruleContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_changerule);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(253);
			rulename();
			setState(256);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				{
				setState(254);
				match(WHITESPACE);
				setState(255);
				matrix();
				}
				break;
			}
			setState(260);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WHITESPACE) {
				{
				setState(258);
				match(WHITESPACE);
				setState(259);
				match(PROPAGATE);
				}
			}

			setState(262);
			match(RULESTART);
			setState(263);
			match(NEWLINE);
			setState(264);
			subrule();
			setState(272);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(265);
					match(NEWLINE);
					setState(266);
					match(SUBRULE);
					setState(267);
					match(RULESTART);
					setState(268);
					_la = _input.LA(1);
					if ( !(_la==NEWLINE || _la==WHITESPACE) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(269);
					subrule();
					}
					} 
				}
				setState(274);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
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

	public static class SubruleContext extends ParserRuleContext {
		public List<RuleexpressionContext> ruleexpression() {
			return getRuleContexts(RuleexpressionContext.class);
		}
		public RuleexpressionContext ruleexpression(int i) {
			return getRuleContext(RuleexpressionContext.class,i);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(LscParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(LscParser.NEWLINE, i);
		}
		public SubruleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subrule; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LscVisitor ) return ((LscVisitor<? extends T>)visitor).visitSubrule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SubruleContext subrule() throws RecognitionException {
		SubruleContext _localctx = new SubruleContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_subrule);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(275);
			ruleexpression();
			setState(280);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(276);
					match(NEWLINE);
					setState(277);
					ruleexpression();
					}
					} 
				}
				setState(282);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
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

	public static class RulenameContext extends ParserRuleContext {
		public List<TerminalNode> VALUE() { return getTokens(LscParser.VALUE); }
		public TerminalNode VALUE(int i) {
			return getToken(LscParser.VALUE, i);
		}
		public List<TerminalNode> HYPHEN() { return getTokens(LscParser.HYPHEN); }
		public TerminalNode HYPHEN(int i) {
			return getToken(LscParser.HYPHEN, i);
		}
		public RulenameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rulename; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LscVisitor ) return ((LscVisitor<? extends T>)visitor).visitRulename(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RulenameContext rulename() throws RecognitionException {
		RulenameContext _localctx = new RulenameContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_rulename);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(283);
			match(VALUE);
			setState(288);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==HYPHEN) {
				{
				{
				setState(284);
				match(HYPHEN);
				setState(285);
				match(VALUE);
				}
				}
				setState(290);
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

	public static class RuleexpressionContext extends ParserRuleContext {
		public RulefromContext rulefrom() {
			return getRuleContext(RulefromContext.class,0);
		}
		public TerminalNode CHANGE() { return getToken(LscParser.CHANGE, 0); }
		public RuletoContext ruleto() {
			return getRuleContext(RuletoContext.class,0);
		}
		public TerminalNode CONDITION() { return getToken(LscParser.CONDITION, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public TerminalNode EXCLUSION() { return getToken(LscParser.EXCLUSION, 0); }
		public ExclusionContext exclusion() {
			return getRuleContext(ExclusionContext.class,0);
		}
		public RuleexpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ruleexpression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LscVisitor ) return ((LscVisitor<? extends T>)visitor).visitRuleexpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RuleexpressionContext ruleexpression() throws RecognitionException {
		RuleexpressionContext _localctx = new RuleexpressionContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_ruleexpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(291);
			rulefrom();
			setState(292);
			match(CHANGE);
			setState(293);
			ruleto();
			setState(296);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CONDITION) {
				{
				setState(294);
				match(CONDITION);
				setState(295);
				condition();
				}
			}

			setState(300);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EXCLUSION) {
				{
				setState(298);
				match(EXCLUSION);
				setState(299);
				exclusion();
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

	public static class ConditionContext extends ParserRuleContext {
		public RuleenvironContext ruleenviron() {
			return getRuleContext(RuleenvironContext.class,0);
		}
		public EnvironlistContext environlist() {
			return getRuleContext(EnvironlistContext.class,0);
		}
		public ConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LscVisitor ) return ((LscVisitor<? extends T>)visitor).visitCondition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionContext condition() throws RecognitionException {
		ConditionContext _localctx = new ConditionContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_condition);
		try {
			setState(304);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(302);
				ruleenviron();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(303);
				environlist();
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

	public static class ExclusionContext extends ParserRuleContext {
		public RuleenvironContext ruleenviron() {
			return getRuleContext(RuleenvironContext.class,0);
		}
		public EnvironlistContext environlist() {
			return getRuleContext(EnvironlistContext.class,0);
		}
		public ExclusionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exclusion; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LscVisitor ) return ((LscVisitor<? extends T>)visitor).visitExclusion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExclusionContext exclusion() throws RecognitionException {
		ExclusionContext _localctx = new ExclusionContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_exclusion);
		try {
			setState(308);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(306);
				ruleenviron();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(307);
				environlist();
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

	public static class RulefromContext extends ParserRuleContext {
		public RuleelementContext ruleelement() {
			return getRuleContext(RuleelementContext.class,0);
		}
		public RulefromContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rulefrom; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LscVisitor ) return ((LscVisitor<? extends T>)visitor).visitRulefrom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RulefromContext rulefrom() throws RecognitionException {
		RulefromContext _localctx = new RulefromContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_rulefrom);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(310);
			ruleelement();
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

	public static class RuletoContext extends ParserRuleContext {
		public RuleelementContext ruleelement() {
			return getRuleContext(RuleelementContext.class,0);
		}
		public RuletoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ruleto; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LscVisitor ) return ((LscVisitor<? extends T>)visitor).visitRuleto(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RuletoContext ruleto() throws RecognitionException {
		RuletoContext _localctx = new RuletoContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_ruleto);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(312);
			ruleelement();
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

	public static class EnvironlistContext extends ParserRuleContext {
		public TerminalNode LISTSTART() { return getToken(LscParser.LISTSTART, 0); }
		public List<RuleenvironContext> ruleenviron() {
			return getRuleContexts(RuleenvironContext.class);
		}
		public RuleenvironContext ruleenviron(int i) {
			return getRuleContext(RuleenvironContext.class,i);
		}
		public TerminalNode LISTEND() { return getToken(LscParser.LISTEND, 0); }
		public List<TerminalNode> SEP() { return getTokens(LscParser.SEP); }
		public TerminalNode SEP(int i) {
			return getToken(LscParser.SEP, i);
		}
		public EnvironlistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_environlist; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LscVisitor ) return ((LscVisitor<? extends T>)visitor).visitEnvironlist(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EnvironlistContext environlist() throws RecognitionException {
		EnvironlistContext _localctx = new EnvironlistContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_environlist);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(314);
			match(LISTSTART);
			setState(315);
			ruleenviron();
			setState(320);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SEP) {
				{
				{
				setState(316);
				match(SEP);
				setState(317);
				ruleenviron();
				}
				}
				setState(322);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(323);
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

	public static class RuleenvironContext extends ParserRuleContext {
		public TerminalNode ANCHOR() { return getToken(LscParser.ANCHOR, 0); }
		public BoundarybeforeContext boundarybefore() {
			return getRuleContext(BoundarybeforeContext.class,0);
		}
		public List<TerminalNode> WHITESPACE() { return getTokens(LscParser.WHITESPACE); }
		public TerminalNode WHITESPACE(int i) {
			return getToken(LscParser.WHITESPACE, i);
		}
		public RulebeforeContext rulebefore() {
			return getRuleContext(RulebeforeContext.class,0);
		}
		public RuleafterContext ruleafter() {
			return getRuleContext(RuleafterContext.class,0);
		}
		public BoundaryafterContext boundaryafter() {
			return getRuleContext(BoundaryafterContext.class,0);
		}
		public RuleenvironContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ruleenviron; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LscVisitor ) return ((LscVisitor<? extends T>)visitor).visitRuleenviron(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RuleenvironContext ruleenviron() throws RecognitionException {
		RuleenvironContext _localctx = new RuleenvironContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_ruleenviron);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(328);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,36,_ctx) ) {
			case 1:
				{
				setState(325);
				boundarybefore();
				setState(326);
				match(WHITESPACE);
				}
				break;
			}
			setState(333);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OPAREN) | (1L << NULL) | (1L << MATSTART) | (1L << LISTSTART) | (1L << WORDBOUNDARY) | (1L << CLASSREF) | (1L << FEATURE) | (1L << VALUE) | (1L << STR1) | (1L << STR))) != 0)) {
				{
				setState(330);
				rulebefore();
				setState(331);
				match(WHITESPACE);
				}
			}

			setState(335);
			match(ANCHOR);
			setState(338);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,38,_ctx) ) {
			case 1:
				{
				setState(336);
				match(WHITESPACE);
				setState(337);
				ruleafter();
				}
				break;
			}
			setState(342);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WHITESPACE) {
				{
				setState(340);
				match(WHITESPACE);
				setState(341);
				boundaryafter();
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

	public static class BoundarybeforeContext extends ParserRuleContext {
		public TerminalNode WORDBOUNDARY() { return getToken(LscParser.WORDBOUNDARY, 0); }
		public BoundarybeforeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boundarybefore; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LscVisitor ) return ((LscVisitor<? extends T>)visitor).visitBoundarybefore(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BoundarybeforeContext boundarybefore() throws RecognitionException {
		BoundarybeforeContext _localctx = new BoundarybeforeContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_boundarybefore);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(344);
			match(WORDBOUNDARY);
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

	public static class BoundaryafterContext extends ParserRuleContext {
		public TerminalNode WORDBOUNDARY() { return getToken(LscParser.WORDBOUNDARY, 0); }
		public BoundaryafterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boundaryafter; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LscVisitor ) return ((LscVisitor<? extends T>)visitor).visitBoundaryafter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BoundaryafterContext boundaryafter() throws RecognitionException {
		BoundaryafterContext _localctx = new BoundaryafterContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_boundaryafter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(346);
			match(WORDBOUNDARY);
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

	public static class RulebeforeContext extends ParserRuleContext {
		public RuleelementContext ruleelement() {
			return getRuleContext(RuleelementContext.class,0);
		}
		public RulebeforeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rulebefore; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LscVisitor ) return ((LscVisitor<? extends T>)visitor).visitRulebefore(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RulebeforeContext rulebefore() throws RecognitionException {
		RulebeforeContext _localctx = new RulebeforeContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_rulebefore);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(348);
			ruleelement();
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

	public static class RuleafterContext extends ParserRuleContext {
		public RuleelementContext ruleelement() {
			return getRuleContext(RuleelementContext.class,0);
		}
		public RuleafterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ruleafter; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LscVisitor ) return ((LscVisitor<? extends T>)visitor).visitRuleafter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RuleafterContext ruleafter() throws RecognitionException {
		RuleafterContext _localctx = new RuleafterContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_ruleafter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(350);
			ruleelement();
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

	public static class RuleelementContext extends ParserRuleContext {
		public RulecaptureContext rulecapture() {
			return getRuleContext(RulecaptureContext.class,0);
		}
		public RulerepeaterContext rulerepeater() {
			return getRuleContext(RulerepeaterContext.class,0);
		}
		public RulegroupContext rulegroup() {
			return getRuleContext(RulegroupContext.class,0);
		}
		public RulelistContext rulelist() {
			return getRuleContext(RulelistContext.class,0);
		}
		public SimpleelementContext simpleelement() {
			return getRuleContext(SimpleelementContext.class,0);
		}
		public RulesequenceContext rulesequence() {
			return getRuleContext(RulesequenceContext.class,0);
		}
		public RuleelementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ruleelement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LscVisitor ) return ((LscVisitor<? extends T>)visitor).visitRuleelement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RuleelementContext ruleelement() throws RecognitionException {
		RuleelementContext _localctx = new RuleelementContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_ruleelement);
		try {
			setState(358);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,40,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(352);
				rulecapture();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(353);
				rulerepeater();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(354);
				rulegroup();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(355);
				rulelist();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(356);
				simpleelement();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(357);
				rulesequence();
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

	public static class RulesequenceContext extends ParserRuleContext {
		public List<SequenceelementContext> sequenceelement() {
			return getRuleContexts(SequenceelementContext.class);
		}
		public SequenceelementContext sequenceelement(int i) {
			return getRuleContext(SequenceelementContext.class,i);
		}
		public List<TerminalNode> WHITESPACE() { return getTokens(LscParser.WHITESPACE); }
		public TerminalNode WHITESPACE(int i) {
			return getToken(LscParser.WHITESPACE, i);
		}
		public RulesequenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rulesequence; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LscVisitor ) return ((LscVisitor<? extends T>)visitor).visitRulesequence(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RulesequenceContext rulesequence() throws RecognitionException {
		RulesequenceContext _localctx = new RulesequenceContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_rulesequence);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(360);
			sequenceelement();
			setState(363); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(361);
					match(WHITESPACE);
					setState(362);
					sequenceelement();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(365); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,41,_ctx);
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

	public static class SequenceelementContext extends ParserRuleContext {
		public RulecaptureContext rulecapture() {
			return getRuleContext(RulecaptureContext.class,0);
		}
		public RulerepeaterContext rulerepeater() {
			return getRuleContext(RulerepeaterContext.class,0);
		}
		public RulegroupContext rulegroup() {
			return getRuleContext(RulegroupContext.class,0);
		}
		public RulelistContext rulelist() {
			return getRuleContext(RulelistContext.class,0);
		}
		public SimpleelementContext simpleelement() {
			return getRuleContext(SimpleelementContext.class,0);
		}
		public SequenceelementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sequenceelement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LscVisitor ) return ((LscVisitor<? extends T>)visitor).visitSequenceelement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SequenceelementContext sequenceelement() throws RecognitionException {
		SequenceelementContext _localctx = new SequenceelementContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_sequenceelement);
		try {
			setState(372);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,42,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(367);
				rulecapture();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(368);
				rulerepeater();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(369);
				rulegroup();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(370);
				rulelist();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(371);
				simpleelement();
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

	public static class RulecaptureContext extends ParserRuleContext {
		public CapturerefContext captureref() {
			return getRuleContext(CapturerefContext.class,0);
		}
		public RulegroupContext rulegroup() {
			return getRuleContext(RulegroupContext.class,0);
		}
		public RulelistContext rulelist() {
			return getRuleContext(RulelistContext.class,0);
		}
		public ClassrefContext classref() {
			return getRuleContext(ClassrefContext.class,0);
		}
		public FancymatrixContext fancymatrix() {
			return getRuleContext(FancymatrixContext.class,0);
		}
		public RulecaptureContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rulecapture; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LscVisitor ) return ((LscVisitor<? extends T>)visitor).visitRulecapture(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RulecaptureContext rulecapture() throws RecognitionException {
		RulecaptureContext _localctx = new RulecaptureContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_rulecapture);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(378);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OPAREN:
				{
				setState(374);
				rulegroup();
				}
				break;
			case LISTSTART:
				{
				setState(375);
				rulelist();
				}
				break;
			case CLASSREF:
				{
				setState(376);
				classref();
				}
				break;
			case MATSTART:
				{
				setState(377);
				fancymatrix();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(380);
			captureref();
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

	public static class RulerepeaterContext extends ParserRuleContext {
		public RepeatertypeContext repeatertype() {
			return getRuleContext(RepeatertypeContext.class,0);
		}
		public RulegroupContext rulegroup() {
			return getRuleContext(RulegroupContext.class,0);
		}
		public RulelistContext rulelist() {
			return getRuleContext(RulelistContext.class,0);
		}
		public SimpleelementContext simpleelement() {
			return getRuleContext(SimpleelementContext.class,0);
		}
		public RulerepeaterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rulerepeater; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LscVisitor ) return ((LscVisitor<? extends T>)visitor).visitRulerepeater(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RulerepeaterContext rulerepeater() throws RecognitionException {
		RulerepeaterContext _localctx = new RulerepeaterContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_rulerepeater);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(385);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OPAREN:
				{
				setState(382);
				rulegroup();
				}
				break;
			case LISTSTART:
				{
				setState(383);
				rulelist();
				}
				break;
			case NULL:
			case MATSTART:
			case WORDBOUNDARY:
			case CLASSREF:
			case FEATURE:
			case VALUE:
			case STR1:
			case STR:
				{
				setState(384);
				simpleelement();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(387);
			repeatertype();
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

	public static class RulegroupContext extends ParserRuleContext {
		public TerminalNode OPAREN() { return getToken(LscParser.OPAREN, 0); }
		public RuleelementContext ruleelement() {
			return getRuleContext(RuleelementContext.class,0);
		}
		public TerminalNode CPAREN() { return getToken(LscParser.CPAREN, 0); }
		public RulegroupContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rulegroup; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LscVisitor ) return ((LscVisitor<? extends T>)visitor).visitRulegroup(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RulegroupContext rulegroup() throws RecognitionException {
		RulegroupContext _localctx = new RulegroupContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_rulegroup);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(389);
			match(OPAREN);
			setState(390);
			ruleelement();
			setState(391);
			match(CPAREN);
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

	public static class RulelistContext extends ParserRuleContext {
		public TerminalNode LISTSTART() { return getToken(LscParser.LISTSTART, 0); }
		public List<RuleelementContext> ruleelement() {
			return getRuleContexts(RuleelementContext.class);
		}
		public RuleelementContext ruleelement(int i) {
			return getRuleContext(RuleelementContext.class,i);
		}
		public TerminalNode LISTEND() { return getToken(LscParser.LISTEND, 0); }
		public List<TerminalNode> SEP() { return getTokens(LscParser.SEP); }
		public TerminalNode SEP(int i) {
			return getToken(LscParser.SEP, i);
		}
		public RulelistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rulelist; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LscVisitor ) return ((LscVisitor<? extends T>)visitor).visitRulelist(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RulelistContext rulelist() throws RecognitionException {
		RulelistContext _localctx = new RulelistContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_rulelist);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(393);
			match(LISTSTART);
			setState(394);
			ruleelement();
			setState(399);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SEP) {
				{
				{
				setState(395);
				match(SEP);
				setState(396);
				ruleelement();
				}
				}
				setState(401);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(402);
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

	public static class SimpleelementContext extends ParserRuleContext {
		public ClassrefContext classref() {
			return getRuleContext(ClassrefContext.class,0);
		}
		public CapturerefContext captureref() {
			return getRuleContext(CapturerefContext.class,0);
		}
		public FancymatrixContext fancymatrix() {
			return getRuleContext(FancymatrixContext.class,0);
		}
		public EmptyContext empty() {
			return getRuleContext(EmptyContext.class,0);
		}
		public TextContext text() {
			return getRuleContext(TextContext.class,0);
		}
		public SimpleelementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simpleelement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LscVisitor ) return ((LscVisitor<? extends T>)visitor).visitSimpleelement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SimpleelementContext simpleelement() throws RecognitionException {
		SimpleelementContext _localctx = new SimpleelementContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_simpleelement);
		try {
			setState(409);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CLASSREF:
				enterOuterAlt(_localctx, 1);
				{
				setState(404);
				classref();
				}
				break;
			case WORDBOUNDARY:
				enterOuterAlt(_localctx, 2);
				{
				setState(405);
				captureref();
				}
				break;
			case MATSTART:
				enterOuterAlt(_localctx, 3);
				{
				setState(406);
				fancymatrix();
				}
				break;
			case NULL:
				enterOuterAlt(_localctx, 4);
				{
				setState(407);
				empty();
				}
				break;
			case FEATURE:
			case VALUE:
			case STR1:
			case STR:
				enterOuterAlt(_localctx, 5);
				{
				setState(408);
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

	public static class ClassrefContext extends ParserRuleContext {
		public TerminalNode CLASSREF() { return getToken(LscParser.CLASSREF, 0); }
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public ClassrefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classref; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LscVisitor ) return ((LscVisitor<? extends T>)visitor).visitClassref(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassrefContext classref() throws RecognitionException {
		ClassrefContext _localctx = new ClassrefContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_classref);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(411);
			match(CLASSREF);
			setState(412);
			value();
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

	public static class CapturerefContext extends ParserRuleContext {
		public TerminalNode WORDBOUNDARY() { return getToken(LscParser.WORDBOUNDARY, 0); }
		public TerminalNode NUMBER() { return getToken(LscParser.NUMBER, 0); }
		public CapturerefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_captureref; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LscVisitor ) return ((LscVisitor<? extends T>)visitor).visitCaptureref(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CapturerefContext captureref() throws RecognitionException {
		CapturerefContext _localctx = new CapturerefContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_captureref);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(414);
			match(WORDBOUNDARY);
			setState(415);
			match(NUMBER);
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

	public static class FancymatrixContext extends ParserRuleContext {
		public TerminalNode MATSTART() { return getToken(LscParser.MATSTART, 0); }
		public TerminalNode MATEND() { return getToken(LscParser.MATEND, 0); }
		public List<FancyvalueContext> fancyvalue() {
			return getRuleContexts(FancyvalueContext.class);
		}
		public FancyvalueContext fancyvalue(int i) {
			return getRuleContext(FancyvalueContext.class,i);
		}
		public List<TerminalNode> WHITESPACE() { return getTokens(LscParser.WHITESPACE); }
		public TerminalNode WHITESPACE(int i) {
			return getToken(LscParser.WHITESPACE, i);
		}
		public FancymatrixContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fancymatrix; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LscVisitor ) return ((LscVisitor<? extends T>)visitor).visitFancymatrix(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FancymatrixContext fancymatrix() throws RecognitionException {
		FancymatrixContext _localctx = new FancymatrixContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_fancymatrix);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(417);
			match(MATSTART);
			setState(419);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NULL) | (1L << NEGATION) | (1L << WORDBOUNDARY) | (1L << VALUE))) != 0)) {
				{
				setState(418);
				fancyvalue();
				}
			}

			setState(425);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WHITESPACE) {
				{
				{
				setState(421);
				match(WHITESPACE);
				setState(422);
				fancyvalue();
				}
				}
				setState(427);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(428);
			match(MATEND);
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

	public static class FancyvalueContext extends ParserRuleContext {
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public NegvalueContext negvalue() {
			return getRuleContext(NegvalueContext.class,0);
		}
		public AbsentfeatureContext absentfeature() {
			return getRuleContext(AbsentfeatureContext.class,0);
		}
		public FeaturevariableContext featurevariable() {
			return getRuleContext(FeaturevariableContext.class,0);
		}
		public FancyvalueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fancyvalue; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LscVisitor ) return ((LscVisitor<? extends T>)visitor).visitFancyvalue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FancyvalueContext fancyvalue() throws RecognitionException {
		FancyvalueContext _localctx = new FancyvalueContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_fancyvalue);
		try {
			setState(434);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VALUE:
				enterOuterAlt(_localctx, 1);
				{
				setState(430);
				value();
				}
				break;
			case NEGATION:
				enterOuterAlt(_localctx, 2);
				{
				setState(431);
				negvalue();
				}
				break;
			case NULL:
				enterOuterAlt(_localctx, 3);
				{
				setState(432);
				absentfeature();
				}
				break;
			case WORDBOUNDARY:
				enterOuterAlt(_localctx, 4);
				{
				setState(433);
				featurevariable();
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

	public static class NegvalueContext extends ParserRuleContext {
		public TerminalNode NEGATION() { return getToken(LscParser.NEGATION, 0); }
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public NegvalueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_negvalue; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LscVisitor ) return ((LscVisitor<? extends T>)visitor).visitNegvalue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NegvalueContext negvalue() throws RecognitionException {
		NegvalueContext _localctx = new NegvalueContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_negvalue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(436);
			match(NEGATION);
			setState(437);
			value();
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

	public static class AbsentfeatureContext extends ParserRuleContext {
		public TerminalNode NULL() { return getToken(LscParser.NULL, 0); }
		public FeatureContext feature() {
			return getRuleContext(FeatureContext.class,0);
		}
		public AbsentfeatureContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_absentfeature; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LscVisitor ) return ((LscVisitor<? extends T>)visitor).visitAbsentfeature(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AbsentfeatureContext absentfeature() throws RecognitionException {
		AbsentfeatureContext _localctx = new AbsentfeatureContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_absentfeature);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(439);
			match(NULL);
			setState(440);
			feature();
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

	public static class FeaturevariableContext extends ParserRuleContext {
		public TerminalNode WORDBOUNDARY() { return getToken(LscParser.WORDBOUNDARY, 0); }
		public FeatureContext feature() {
			return getRuleContext(FeatureContext.class,0);
		}
		public FeaturevariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_featurevariable; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LscVisitor ) return ((LscVisitor<? extends T>)visitor).visitFeaturevariable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FeaturevariableContext featurevariable() throws RecognitionException {
		FeaturevariableContext _localctx = new FeaturevariableContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_featurevariable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(442);
			match(WORDBOUNDARY);
			setState(443);
			feature();
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

	public static class EmptyContext extends ParserRuleContext {
		public TerminalNode NULL() { return getToken(LscParser.NULL, 0); }
		public EmptyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_empty; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LscVisitor ) return ((LscVisitor<? extends T>)visitor).visitEmpty(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EmptyContext empty() throws RecognitionException {
		EmptyContext _localctx = new EmptyContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_empty);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(445);
			match(NULL);
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

	public static class RepeatertypeContext extends ParserRuleContext {
		public TerminalNode ATLEASTONE() { return getToken(LscParser.ATLEASTONE, 0); }
		public TerminalNode NULL() { return getToken(LscParser.NULL, 0); }
		public TerminalNode OPTIONAL() { return getToken(LscParser.OPTIONAL, 0); }
		public RepeatertypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_repeatertype; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LscVisitor ) return ((LscVisitor<? extends T>)visitor).visitRepeatertype(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RepeatertypeContext repeatertype() throws RecognitionException {
		RepeatertypeContext _localctx = new RepeatertypeContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_repeatertype);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(447);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NULL) | (1L << ATLEASTONE) | (1L << OPTIONAL))) != 0)) ) {
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

	public static class MatrixContext extends ParserRuleContext {
		public TerminalNode MATSTART() { return getToken(LscParser.MATSTART, 0); }
		public TerminalNode MATEND() { return getToken(LscParser.MATEND, 0); }
		public List<ValueContext> value() {
			return getRuleContexts(ValueContext.class);
		}
		public ValueContext value(int i) {
			return getRuleContext(ValueContext.class,i);
		}
		public List<TerminalNode> WHITESPACE() { return getTokens(LscParser.WHITESPACE); }
		public TerminalNode WHITESPACE(int i) {
			return getToken(LscParser.WHITESPACE, i);
		}
		public MatrixContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_matrix; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LscVisitor ) return ((LscVisitor<? extends T>)visitor).visitMatrix(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MatrixContext matrix() throws RecognitionException {
		MatrixContext _localctx = new MatrixContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_matrix);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(449);
			match(MATSTART);
			setState(451);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==VALUE) {
				{
				setState(450);
				value();
				}
			}

			setState(457);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WHITESPACE) {
				{
				{
				setState(453);
				match(WHITESPACE);
				setState(454);
				value();
				}
				}
				setState(459);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(460);
			match(MATEND);
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

	public static class FeatureContext extends ParserRuleContext {
		public TerminalNode FEATURE() { return getToken(LscParser.FEATURE, 0); }
		public FeatureContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_feature; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LscVisitor ) return ((LscVisitor<? extends T>)visitor).visitFeature(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FeatureContext feature() throws RecognitionException {
		FeatureContext _localctx = new FeatureContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_feature);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(462);
			match(FEATURE);
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

	public static class ValueContext extends ParserRuleContext {
		public TerminalNode VALUE() { return getToken(LscParser.VALUE, 0); }
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LscVisitor ) return ((LscVisitor<? extends T>)visitor).visitValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_value);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(464);
			match(VALUE);
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
		public TerminalNode FEATURE() { return getToken(LscParser.FEATURE, 0); }
		public TerminalNode VALUE() { return getToken(LscParser.VALUE, 0); }
		public TerminalNode STR1() { return getToken(LscParser.STR1, 0); }
		public TerminalNode STR() { return getToken(LscParser.STR, 0); }
		public TextContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_text; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LscVisitor ) return ((LscVisitor<? extends T>)visitor).visitText(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TextContext text() throws RecognitionException {
		TextContext _localctx = new TextContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_text);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(466);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << FEATURE) | (1L << VALUE) | (1L << STR1) | (1L << STR))) != 0)) ) {
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3&\u01d7\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\3\2\3\2\6\2]\n\2\r\2\16\2^\7\2a\n\2\f\2\16\2d\13\2\3\2\3\2"+
		"\6\2h\n\2\r\2\16\2i\7\2l\n\2\f\2\16\2o\13\2\3\2\3\2\6\2s\n\2\r\2\16\2"+
		"t\7\2w\n\2\f\2\16\2z\13\2\3\2\3\2\6\2~\n\2\r\2\16\2\177\7\2\u0082\n\2"+
		"\f\2\16\2\u0085\13\2\3\2\3\2\6\2\u0089\n\2\r\2\16\2\u008a\5\2\u008d\n"+
		"\2\3\2\3\2\6\2\u0091\n\2\r\2\16\2\u0092\3\2\7\2\u0096\n\2\f\2\16\2\u0099"+
		"\13\2\3\2\6\2\u009c\n\2\r\2\16\2\u009d\3\2\5\2\u00a1\n\2\3\2\5\2\u00a4"+
		"\n\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\7\3\u00ae\n\3\f\3\16\3\u00b1\13\3"+
		"\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4\u00bc\n\4\3\4\3\4\3\4\7\4\u00c1"+
		"\n\4\f\4\16\4\u00c4\13\4\3\4\3\4\3\4\5\4\u00c9\n\4\3\5\3\5\3\5\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\5\6\u00d4\n\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\7\7\u00dd\n"+
		"\7\f\7\16\7\u00e0\13\7\3\7\3\7\5\7\u00e4\n\7\3\b\3\b\3\t\3\t\3\t\6\t\u00eb"+
		"\n\t\r\t\16\t\u00ec\3\t\6\t\u00f0\n\t\r\t\16\t\u00f1\3\n\3\n\3\n\6\n\u00f7"+
		"\n\n\r\n\16\n\u00f8\3\n\6\n\u00fc\n\n\r\n\16\n\u00fd\3\13\3\13\3\13\5"+
		"\13\u0103\n\13\3\13\3\13\5\13\u0107\n\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\7\13\u0111\n\13\f\13\16\13\u0114\13\13\3\f\3\f\3\f\7\f\u0119"+
		"\n\f\f\f\16\f\u011c\13\f\3\r\3\r\3\r\7\r\u0121\n\r\f\r\16\r\u0124\13\r"+
		"\3\16\3\16\3\16\3\16\3\16\5\16\u012b\n\16\3\16\3\16\5\16\u012f\n\16\3"+
		"\17\3\17\5\17\u0133\n\17\3\20\3\20\5\20\u0137\n\20\3\21\3\21\3\22\3\22"+
		"\3\23\3\23\3\23\3\23\7\23\u0141\n\23\f\23\16\23\u0144\13\23\3\23\3\23"+
		"\3\24\3\24\3\24\5\24\u014b\n\24\3\24\3\24\3\24\5\24\u0150\n\24\3\24\3"+
		"\24\3\24\5\24\u0155\n\24\3\24\3\24\5\24\u0159\n\24\3\25\3\25\3\26\3\26"+
		"\3\27\3\27\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\31\5\31\u0169\n\31\3\32"+
		"\3\32\3\32\6\32\u016e\n\32\r\32\16\32\u016f\3\33\3\33\3\33\3\33\3\33\5"+
		"\33\u0177\n\33\3\34\3\34\3\34\3\34\5\34\u017d\n\34\3\34\3\34\3\35\3\35"+
		"\3\35\5\35\u0184\n\35\3\35\3\35\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37"+
		"\7\37\u0190\n\37\f\37\16\37\u0193\13\37\3\37\3\37\3 \3 \3 \3 \3 \5 \u019c"+
		"\n \3!\3!\3!\3\"\3\"\3\"\3#\3#\5#\u01a6\n#\3#\3#\7#\u01aa\n#\f#\16#\u01ad"+
		"\13#\3#\3#\3$\3$\3$\3$\5$\u01b5\n$\3%\3%\3%\3&\3&\3&\3\'\3\'\3\'\3(\3"+
		"(\3)\3)\3*\3*\5*\u01c6\n*\3*\3*\7*\u01ca\n*\f*\16*\u01cd\13*\3*\3*\3+"+
		"\3+\3,\3,\3-\3-\3-\2\2.\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*"+
		",.\60\62\64\668:<>@BDFHJLNPRTVX\2\5\3\2\t\n\4\2\r\r\22\23\4\2\"#%&\2\u01ed"+
		"\2b\3\2\2\2\4\u00a5\3\2\2\2\6\u00b4\3\2\2\2\b\u00ca\3\2\2\2\n\u00cd\3"+
		"\2\2\2\f\u00d7\3\2\2\2\16\u00e5\3\2\2\2\20\u00e7\3\2\2\2\22\u00f3\3\2"+
		"\2\2\24\u00ff\3\2\2\2\26\u0115\3\2\2\2\30\u011d\3\2\2\2\32\u0125\3\2\2"+
		"\2\34\u0132\3\2\2\2\36\u0136\3\2\2\2 \u0138\3\2\2\2\"\u013a\3\2\2\2$\u013c"+
		"\3\2\2\2&\u014a\3\2\2\2(\u015a\3\2\2\2*\u015c\3\2\2\2,\u015e\3\2\2\2."+
		"\u0160\3\2\2\2\60\u0168\3\2\2\2\62\u016a\3\2\2\2\64\u0176\3\2\2\2\66\u017c"+
		"\3\2\2\28\u0183\3\2\2\2:\u0187\3\2\2\2<\u018b\3\2\2\2>\u019b\3\2\2\2@"+
		"\u019d\3\2\2\2B\u01a0\3\2\2\2D\u01a3\3\2\2\2F\u01b4\3\2\2\2H\u01b6\3\2"+
		"\2\2J\u01b9\3\2\2\2L\u01bc\3\2\2\2N\u01bf\3\2\2\2P\u01c1\3\2\2\2R\u01c3"+
		"\3\2\2\2T\u01d0\3\2\2\2V\u01d2\3\2\2\2X\u01d4\3\2\2\2Z\\\5\6\4\2[]\7\t"+
		"\2\2\\[\3\2\2\2]^\3\2\2\2^\\\3\2\2\2^_\3\2\2\2_a\3\2\2\2`Z\3\2\2\2ad\3"+
		"\2\2\2b`\3\2\2\2bc\3\2\2\2cm\3\2\2\2db\3\2\2\2eg\5\n\6\2fh\7\t\2\2gf\3"+
		"\2\2\2hi\3\2\2\2ig\3\2\2\2ij\3\2\2\2jl\3\2\2\2ke\3\2\2\2lo\3\2\2\2mk\3"+
		"\2\2\2mn\3\2\2\2nx\3\2\2\2om\3\2\2\2pr\5\f\7\2qs\7\t\2\2rq\3\2\2\2st\3"+
		"\2\2\2tr\3\2\2\2tu\3\2\2\2uw\3\2\2\2vp\3\2\2\2wz\3\2\2\2xv\3\2\2\2xy\3"+
		"\2\2\2y\u0083\3\2\2\2zx\3\2\2\2{}\5\4\3\2|~\7\t\2\2}|\3\2\2\2~\177\3\2"+
		"\2\2\177}\3\2\2\2\177\u0080\3\2\2\2\u0080\u0082\3\2\2\2\u0081{\3\2\2\2"+
		"\u0082\u0085\3\2\2\2\u0083\u0081\3\2\2\2\u0083\u0084\3\2\2\2\u0084\u008c"+
		"\3\2\2\2\u0085\u0083\3\2\2\2\u0086\u0088\5\20\t\2\u0087\u0089\7\t\2\2"+
		"\u0088\u0087\3\2\2\2\u0089\u008a\3\2\2\2\u008a\u0088\3\2\2\2\u008a\u008b"+
		"\3\2\2\2\u008b\u008d\3\2\2\2\u008c\u0086\3\2\2\2\u008c\u008d\3\2\2\2\u008d"+
		"\u008e\3\2\2\2\u008e\u0097\5\24\13\2\u008f\u0091\7\t\2\2\u0090\u008f\3"+
		"\2\2\2\u0091\u0092\3\2\2\2\u0092\u0090\3\2\2\2\u0092\u0093\3\2\2\2\u0093"+
		"\u0094\3\2\2\2\u0094\u0096\5\24\13\2\u0095\u0090\3\2\2\2\u0096\u0099\3"+
		"\2\2\2\u0097\u0095\3\2\2\2\u0097\u0098\3\2\2\2\u0098\u00a0\3\2\2\2\u0099"+
		"\u0097\3\2\2\2\u009a\u009c\7\t\2\2\u009b\u009a\3\2\2\2\u009c\u009d\3\2"+
		"\2\2\u009d\u009b\3\2\2\2\u009d\u009e\3\2\2\2\u009e\u009f\3\2\2\2\u009f"+
		"\u00a1\5\22\n\2\u00a0\u009b\3\2\2\2\u00a0\u00a1\3\2\2\2\u00a1\u00a3\3"+
		"\2\2\2\u00a2\u00a4\7\t\2\2\u00a3\u00a2\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4"+
		"\3\3\2\2\2\u00a5\u00a6\7\31\2\2\u00a6\u00a7\7\n\2\2\u00a7\u00a8\5V,\2"+
		"\u00a8\u00a9\7\n\2\2\u00a9\u00aa\7\20\2\2\u00aa\u00af\5X-\2\u00ab\u00ac"+
		"\7\4\2\2\u00ac\u00ae\5X-\2\u00ad\u00ab\3\2\2\2\u00ae\u00b1\3\2\2\2\u00af"+
		"\u00ad\3\2\2\2\u00af\u00b0\3\2\2\2\u00b0\u00b2\3\2\2\2\u00b1\u00af\3\2"+
		"\2\2\u00b2\u00b3\7\21\2\2\u00b3\5\3\2\2\2\u00b4\u00b5\7\32\2\2\u00b5\u00b6"+
		"\7\n\2\2\u00b6\u00b7\5T+\2\u00b7\u00bb\7\13\2\2\u00b8\u00b9\5\b\5\2\u00b9"+
		"\u00ba\7\4\2\2\u00ba\u00bc\3\2\2\2\u00bb\u00b8\3\2\2\2\u00bb\u00bc\3\2"+
		"\2\2\u00bc\u00bd\3\2\2\2\u00bd\u00c2\5V,\2\u00be\u00bf\7\4\2\2\u00bf\u00c1"+
		"\5V,\2\u00c0\u00be\3\2\2\2\u00c1\u00c4\3\2\2\2\u00c2\u00c0\3\2\2\2\u00c2"+
		"\u00c3\3\2\2\2\u00c3\u00c5\3\2\2\2\u00c4\u00c2\3\2\2\2\u00c5\u00c8\7\f"+
		"\2\2\u00c6\u00c7\7\5\2\2\u00c7\u00c9\5R*\2\u00c8\u00c6\3\2\2\2\u00c8\u00c9"+
		"\3\2\2\2\u00c9\7\3\2\2\2\u00ca\u00cb\7\r\2\2\u00cb\u00cc\5V,\2\u00cc\t"+
		"\3\2\2\2\u00cd\u00ce\7\33\2\2\u00ce\u00cf\7\n\2\2\u00cf\u00d0\7%\2\2\u00d0"+
		"\u00d3\7\n\2\2\u00d1\u00d2\7\34\2\2\u00d2\u00d4\7\n\2\2\u00d3\u00d1\3"+
		"\2\2\2\u00d3\u00d4\3\2\2\2\u00d4\u00d5\3\2\2\2\u00d5\u00d6\5R*\2\u00d6"+
		"\13\3\2\2\2\u00d7\u00d8\7\35\2\2\u00d8\u00d9\7\n\2\2\u00d9\u00e3\5\16"+
		"\b\2\u00da\u00db\7\4\2\2\u00db\u00dd\5\16\b\2\u00dc\u00da\3\2\2\2\u00dd"+
		"\u00e0\3\2\2\2\u00de\u00dc\3\2\2\2\u00de\u00df\3\2\2\2\u00df\u00e4\3\2"+
		"\2\2\u00e0\u00de\3\2\2\2\u00e1\u00e2\7\n\2\2\u00e2\u00e4\5R*\2\u00e3\u00de"+
		"\3\2\2\2\u00e3\u00e1\3\2\2\2\u00e4\r\3\2\2\2\u00e5\u00e6\5X-\2\u00e6\17"+
		"\3\2\2\2\u00e7\u00e8\7\36\2\2\u00e8\u00ef\7\25\2\2\u00e9\u00eb\7\t\2\2"+
		"\u00ea\u00e9\3\2\2\2\u00eb\u00ec\3\2\2\2\u00ec\u00ea\3\2\2\2\u00ec\u00ed"+
		"\3\2\2\2\u00ed\u00ee\3\2\2\2\u00ee\u00f0\5\32\16\2\u00ef\u00ea\3\2\2\2"+
		"\u00f0\u00f1\3\2\2\2\u00f1\u00ef\3\2\2\2\u00f1\u00f2\3\2\2\2\u00f2\21"+
		"\3\2\2\2\u00f3\u00f4\7\37\2\2\u00f4\u00fb\7\25\2\2\u00f5\u00f7\7\t\2\2"+
		"\u00f6\u00f5\3\2\2\2\u00f7\u00f8\3\2\2\2\u00f8\u00f6\3\2\2\2\u00f8\u00f9"+
		"\3\2\2\2\u00f9\u00fa\3\2\2\2\u00fa\u00fc\5\32\16\2\u00fb\u00f6\3\2\2\2"+
		"\u00fc\u00fd\3\2\2\2\u00fd\u00fb\3\2\2\2\u00fd\u00fe\3\2\2\2\u00fe\23"+
		"\3\2\2\2\u00ff\u0102\5\30\r\2\u0100\u0101\7\n\2\2\u0101\u0103\5R*\2\u0102"+
		"\u0100\3\2\2\2\u0102\u0103\3\2\2\2\u0103\u0106\3\2\2\2\u0104\u0105\7\n"+
		"\2\2\u0105\u0107\7!\2\2\u0106\u0104\3\2\2\2\u0106\u0107\3\2\2\2\u0107"+
		"\u0108\3\2\2\2\u0108\u0109\7\25\2\2\u0109\u010a\7\t\2\2\u010a\u0112\5"+
		"\26\f\2\u010b\u010c\7\t\2\2\u010c\u010d\7 \2\2\u010d\u010e\7\25\2\2\u010e"+
		"\u010f\t\2\2\2\u010f\u0111\5\26\f\2\u0110\u010b\3\2\2\2\u0111\u0114\3"+
		"\2\2\2\u0112\u0110\3\2\2\2\u0112\u0113\3\2\2\2\u0113\25\3\2\2\2\u0114"+
		"\u0112\3\2\2\2\u0115\u011a\5\32\16\2\u0116\u0117\7\t\2\2\u0117\u0119\5"+
		"\32\16\2\u0118\u0116\3\2\2\2\u0119\u011c\3\2\2\2\u011a\u0118\3\2\2\2\u011a"+
		"\u011b\3\2\2\2\u011b\27\3\2\2\2\u011c\u011a\3\2\2\2\u011d\u0122\7#\2\2"+
		"\u011e\u011f\7\24\2\2\u011f\u0121\7#\2\2\u0120\u011e\3\2\2\2\u0121\u0124"+
		"\3\2\2\2\u0122\u0120\3\2\2\2\u0122\u0123\3\2\2\2\u0123\31\3\2\2\2\u0124"+
		"\u0122\3\2\2\2\u0125\u0126\5 \21\2\u0126\u0127\7\5\2\2\u0127\u012a\5\""+
		"\22\2\u0128\u0129\7\6\2\2\u0129\u012b\5\34\17\2\u012a\u0128\3\2\2\2\u012a"+
		"\u012b\3\2\2\2\u012b\u012e\3\2\2\2\u012c\u012d\7\7\2\2\u012d\u012f\5\36"+
		"\20\2\u012e\u012c\3\2\2\2\u012e\u012f\3\2\2\2\u012f\33\3\2\2\2\u0130\u0133"+
		"\5&\24\2\u0131\u0133\5$\23\2\u0132\u0130\3\2\2\2\u0132\u0131\3\2\2\2\u0133"+
		"\35\3\2\2\2\u0134\u0137\5&\24\2\u0135\u0137\5$\23\2\u0136\u0134\3\2\2"+
		"\2\u0136\u0135\3\2\2\2\u0137\37\3\2\2\2\u0138\u0139\5\60\31\2\u0139!\3"+
		"\2\2\2\u013a\u013b\5\60\31\2\u013b#\3\2\2\2\u013c\u013d\7\20\2\2\u013d"+
		"\u0142\5&\24\2\u013e\u013f\7\4\2\2\u013f\u0141\5&\24\2\u0140\u013e\3\2"+
		"\2\2\u0141\u0144\3\2\2\2\u0142\u0140\3\2\2\2\u0142\u0143\3\2\2\2\u0143"+
		"\u0145\3\2\2\2\u0144\u0142\3\2\2\2\u0145\u0146\7\21\2\2\u0146%\3\2\2\2"+
		"\u0147\u0148\5(\25\2\u0148\u0149\7\n\2\2\u0149\u014b\3\2\2\2\u014a\u0147"+
		"\3\2\2\2\u014a\u014b\3\2\2\2\u014b\u014f\3\2\2\2\u014c\u014d\5,\27\2\u014d"+
		"\u014e\7\n\2\2\u014e\u0150\3\2\2\2\u014f\u014c\3\2\2\2\u014f\u0150\3\2"+
		"\2\2\u0150\u0151\3\2\2\2\u0151\u0154\7\b\2\2\u0152\u0153\7\n\2\2\u0153"+
		"\u0155\5.\30\2\u0154\u0152\3\2\2\2\u0154\u0155\3\2\2\2\u0155\u0158\3\2"+
		"\2\2\u0156\u0157\7\n\2\2\u0157\u0159\5*\26\2\u0158\u0156\3\2\2\2\u0158"+
		"\u0159\3\2\2\2\u0159\'\3\2\2\2\u015a\u015b\7\27\2\2\u015b)\3\2\2\2\u015c"+
		"\u015d\7\27\2\2\u015d+\3\2\2\2\u015e\u015f\5\60\31\2\u015f-\3\2\2\2\u0160"+
		"\u0161\5\60\31\2\u0161/\3\2\2\2\u0162\u0169\5\66\34\2\u0163\u0169\58\35"+
		"\2\u0164\u0169\5:\36\2\u0165\u0169\5<\37\2\u0166\u0169\5> \2\u0167\u0169"+
		"\5\62\32\2\u0168\u0162\3\2\2\2\u0168\u0163\3\2\2\2\u0168\u0164\3\2\2\2"+
		"\u0168\u0165\3\2\2\2\u0168\u0166\3\2\2\2\u0168\u0167\3\2\2\2\u0169\61"+
		"\3\2\2\2\u016a\u016d\5\64\33\2\u016b\u016c\7\n\2\2\u016c\u016e\5\64\33"+
		"\2\u016d\u016b\3\2\2\2\u016e\u016f\3\2\2\2\u016f\u016d\3\2\2\2\u016f\u0170"+
		"\3\2\2\2\u0170\63\3\2\2\2\u0171\u0177\5\66\34\2\u0172\u0177\58\35\2\u0173"+
		"\u0177\5:\36\2\u0174\u0177\5<\37\2\u0175\u0177\5> \2\u0176\u0171\3\2\2"+
		"\2\u0176\u0172\3\2\2\2\u0176\u0173\3\2\2\2\u0176\u0174\3\2\2\2\u0176\u0175"+
		"\3\2\2\2\u0177\65\3\2\2\2\u0178\u017d\5:\36\2\u0179\u017d\5<\37\2\u017a"+
		"\u017d\5@!\2\u017b\u017d\5D#\2\u017c\u0178\3\2\2\2\u017c\u0179\3\2\2\2"+
		"\u017c\u017a\3\2\2\2\u017c\u017b\3\2\2\2\u017d\u017e\3\2\2\2\u017e\u017f"+
		"\5B\"\2\u017f\67\3\2\2\2\u0180\u0184\5:\36\2\u0181\u0184\5<\37\2\u0182"+
		"\u0184\5> \2\u0183\u0180\3\2\2\2\u0183\u0181\3\2\2\2\u0183\u0182\3\2\2"+
		"\2\u0184\u0185\3\2\2\2\u0185\u0186\5P)\2\u01869\3\2\2\2\u0187\u0188\7"+
		"\13\2\2\u0188\u0189\5\60\31\2\u0189\u018a\7\f\2\2\u018a;\3\2\2\2\u018b"+
		"\u018c\7\20\2\2\u018c\u0191\5\60\31\2\u018d\u018e\7\4\2\2\u018e\u0190"+
		"\5\60\31\2\u018f\u018d\3\2\2\2\u0190\u0193\3\2\2\2\u0191\u018f\3\2\2\2"+
		"\u0191\u0192\3\2\2\2\u0192\u0194\3\2\2\2\u0193\u0191\3\2\2\2\u0194\u0195"+
		"\7\21\2\2\u0195=\3\2\2\2\u0196\u019c\5@!\2\u0197\u019c\5B\"\2\u0198\u019c"+
		"\5D#\2\u0199\u019c\5N(\2\u019a\u019c\5X-\2\u019b\u0196\3\2\2\2\u019b\u0197"+
		"\3\2\2\2\u019b\u0198\3\2\2\2\u019b\u0199\3\2\2\2\u019b\u019a\3\2\2\2\u019c"+
		"?\3\2\2\2\u019d\u019e\7\30\2\2\u019e\u019f\5V,\2\u019fA\3\2\2\2\u01a0"+
		"\u01a1\7\27\2\2\u01a1\u01a2\7$\2\2\u01a2C\3\2\2\2\u01a3\u01a5\7\16\2\2"+
		"\u01a4\u01a6\5F$\2\u01a5\u01a4\3\2\2\2\u01a5\u01a6\3\2\2\2\u01a6\u01ab"+
		"\3\2\2\2\u01a7\u01a8\7\n\2\2\u01a8\u01aa\5F$\2\u01a9\u01a7\3\2\2\2\u01aa"+
		"\u01ad\3\2\2\2\u01ab\u01a9\3\2\2\2\u01ab\u01ac\3\2\2\2\u01ac\u01ae\3\2"+
		"\2\2\u01ad\u01ab\3\2\2\2\u01ae\u01af\7\17\2\2\u01afE\3\2\2\2\u01b0\u01b5"+
		"\5V,\2\u01b1\u01b5\5H%\2\u01b2\u01b5\5J&\2\u01b3\u01b5\5L\'\2\u01b4\u01b0"+
		"\3\2\2\2\u01b4\u01b1\3\2\2\2\u01b4\u01b2\3\2\2\2\u01b4\u01b3\3\2\2\2\u01b5"+
		"G\3\2\2\2\u01b6\u01b7\7\26\2\2\u01b7\u01b8\5V,\2\u01b8I\3\2\2\2\u01b9"+
		"\u01ba\7\r\2\2\u01ba\u01bb\5T+\2\u01bbK\3\2\2\2\u01bc\u01bd\7\27\2\2\u01bd"+
		"\u01be\5T+\2\u01beM\3\2\2\2\u01bf\u01c0\7\r\2\2\u01c0O\3\2\2\2\u01c1\u01c2"+
		"\t\3\2\2\u01c2Q\3\2\2\2\u01c3\u01c5\7\16\2\2\u01c4\u01c6\5V,\2\u01c5\u01c4"+
		"\3\2\2\2\u01c5\u01c6\3\2\2\2\u01c6\u01cb\3\2\2\2\u01c7\u01c8\7\n\2\2\u01c8"+
		"\u01ca\5V,\2\u01c9\u01c7\3\2\2\2\u01ca\u01cd\3\2\2\2\u01cb\u01c9\3\2\2"+
		"\2\u01cb\u01cc\3\2\2\2\u01cc\u01ce\3\2\2\2\u01cd\u01cb\3\2\2\2\u01ce\u01cf"+
		"\7\17\2\2\u01cfS\3\2\2\2\u01d0\u01d1\7\"\2\2\u01d1U\3\2\2\2\u01d2\u01d3"+
		"\7#\2\2\u01d3W\3\2\2\2\u01d4\u01d5\t\4\2\2\u01d5Y\3\2\2\2\66^bimtx\177"+
		"\u0083\u008a\u008c\u0092\u0097\u009d\u00a0\u00a3\u00af\u00bb\u00c2\u00c8"+
		"\u00d3\u00de\u00e3\u00ec\u00f1\u00f8\u00fd\u0102\u0106\u0112\u011a\u0122"+
		"\u012a\u012e\u0132\u0136\u0142\u014a\u014f\u0154\u0158\u0168\u016f\u0176"+
		"\u017c\u0183\u0191\u019b\u01a5\u01ab\u01b4\u01c5\u01cb";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}