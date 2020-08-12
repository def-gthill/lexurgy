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
		DIABEFORE=26, DIAFLOATING=27, SYMBOL=28, DEROMANIZER=29, ROMANIZER=30, 
		SUBRULE=31, PROPAGATE=32, FEATURE=33, VALUE=34, NUMBER=35, STR1=36, STR=37;
	public static final int
		RULE_lscfile = 0, RULE_classdecl = 1, RULE_featuredecl = 2, RULE_nullalias = 3, 
		RULE_diacritic = 4, RULE_symbol = 5, RULE_symbolname = 6, RULE_deromanizer = 7, 
		RULE_romanizer = 8, RULE_interromanizer = 9, RULE_changerule = 10, RULE_subrule = 11, 
		RULE_rulename = 12, RULE_ruleexpression = 13, RULE_condition = 14, RULE_exclusion = 15, 
		RULE_rulefrom = 16, RULE_ruleto = 17, RULE_environlist = 18, RULE_ruleenviron = 19, 
		RULE_boundarybefore = 20, RULE_boundaryafter = 21, RULE_rulebefore = 22, 
		RULE_ruleafter = 23, RULE_ruleelement = 24, RULE_rulesequence = 25, RULE_sequenceelement = 26, 
		RULE_rulecapture = 27, RULE_rulerepeater = 28, RULE_rulegroup = 29, RULE_rulelist = 30, 
		RULE_simpleelement = 31, RULE_classref = 32, RULE_captureref = 33, RULE_fancymatrix = 34, 
		RULE_fancyvalue = 35, RULE_negvalue = 36, RULE_absentfeature = 37, RULE_featurevariable = 38, 
		RULE_empty = 39, RULE_repeatertype = 40, RULE_matrix = 41, RULE_feature = 42, 
		RULE_value = 43, RULE_text = 44;
	private static String[] makeRuleNames() {
		return new String[] {
			"lscfile", "classdecl", "featuredecl", "nullalias", "diacritic", "symbol", 
			"symbolname", "deromanizer", "romanizer", "interromanizer", "changerule", 
			"subrule", "rulename", "ruleexpression", "condition", "exclusion", "rulefrom", 
			"ruleto", "environlist", "ruleenviron", "boundarybefore", "boundaryafter", 
			"rulebefore", "ruleafter", "ruleelement", "rulesequence", "sequenceelement", 
			"rulecapture", "rulerepeater", "rulegroup", "rulelist", "simpleelement", 
			"classref", "captureref", "fancymatrix", "fancyvalue", "negvalue", "absentfeature", 
			"featurevariable", "empty", "repeatertype", "matrix", "feature", "value", 
			"text"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, null, "'_'", null, null, "'('", "')'", 
			"'*'", "'['", "']'", "'{'", "'}'", "'+'", "'?'", "'-'", "':'", "'!'", 
			"'$'", "'@'", "'Class'", "'Feature'", "'Diacritic'", "'(before)'", "'(floating)'", 
			"'Symbol'", "'Deromanizer'", "'Romanizer'", "'Then'", "'propagate'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "COMMENT", "SEP", "CHANGE", "CONDITION", "EXCLUSION", "ANCHOR", 
			"NEWLINE", "WHITESPACE", "OPAREN", "CPAREN", "NULL", "MATSTART", "MATEND", 
			"LISTSTART", "LISTEND", "ATLEASTONE", "OPTIONAL", "HYPHEN", "RULESTART", 
			"NEGATION", "WORDBOUNDARY", "CLASSREF", "CLASSDECL", "FEATUREDECL", "DIACRITIC", 
			"DIABEFORE", "DIAFLOATING", "SYMBOL", "DEROMANIZER", "ROMANIZER", "SUBRULE", 
			"PROPAGATE", "FEATURE", "VALUE", "NUMBER", "STR1", "STR"
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
		public TerminalNode EOF() { return getToken(LscParser.EOF, 0); }
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
		public List<ChangeruleContext> changerule() {
			return getRuleContexts(ChangeruleContext.class);
		}
		public ChangeruleContext changerule(int i) {
			return getRuleContext(ChangeruleContext.class,i);
		}
		public RomanizerContext romanizer() {
			return getRuleContext(RomanizerContext.class,0);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(LscParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(LscParser.NEWLINE, i);
		}
		public List<InterromanizerContext> interromanizer() {
			return getRuleContexts(InterromanizerContext.class);
		}
		public InterromanizerContext interromanizer(int i) {
			return getRuleContext(InterromanizerContext.class,i);
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
			setState(98);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==FEATUREDECL) {
				{
				{
				setState(90);
				featuredecl();
				setState(92); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(91);
						match(NEWLINE);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(94); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				}
				setState(100);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(109);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DIACRITIC) {
				{
				{
				setState(101);
				diacritic();
				setState(103); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(102);
						match(NEWLINE);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(105); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				}
				setState(111);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(120);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SYMBOL) {
				{
				{
				setState(112);
				symbol();
				setState(114); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(113);
						match(NEWLINE);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(116); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				}
				setState(122);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(131);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CLASSDECL) {
				{
				{
				setState(123);
				classdecl();
				setState(125); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(124);
						match(NEWLINE);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(127); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				}
				setState(133);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(140);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DEROMANIZER) {
				{
				setState(134);
				deromanizer();
				setState(136); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(135);
						match(NEWLINE);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(138); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
			}

			setState(143);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==VALUE) {
				{
				setState(142);
				changerule();
				}
			}

			setState(165);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				{
				setState(156);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(146); 
						_errHandler.sync(this);
						_la = _input.LA(1);
						do {
							{
							{
							setState(145);
							match(NEWLINE);
							}
							}
							setState(148); 
							_errHandler.sync(this);
							_la = _input.LA(1);
						} while ( _la==NEWLINE );
						setState(152);
						_errHandler.sync(this);
						switch (_input.LA(1)) {
						case VALUE:
							{
							setState(150);
							changerule();
							}
							break;
						case ROMANIZER:
							{
							setState(151);
							interromanizer();
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						}
						} 
					}
					setState(158);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
				}
				setState(160); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(159);
					match(NEWLINE);
					}
					}
					setState(162); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NEWLINE );
				setState(164);
				changerule();
				}
				break;
			}
			setState(173);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				{
				setState(168); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(167);
					match(NEWLINE);
					}
					}
					setState(170); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NEWLINE );
				setState(172);
				romanizer();
				}
				break;
			}
			setState(176);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NEWLINE) {
				{
				setState(175);
				match(NEWLINE);
				}
			}

			setState(178);
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
			setState(180);
			match(CLASSDECL);
			setState(181);
			match(WHITESPACE);
			setState(182);
			value();
			setState(183);
			match(WHITESPACE);
			setState(184);
			match(LISTSTART);
			setState(185);
			text();
			setState(190);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SEP) {
				{
				{
				setState(186);
				match(SEP);
				setState(187);
				text();
				}
				}
				setState(192);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(193);
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
			setState(195);
			match(FEATUREDECL);
			setState(196);
			match(WHITESPACE);
			setState(197);
			feature();
			setState(198);
			match(OPAREN);
			setState(202);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NULL) {
				{
				setState(199);
				nullalias();
				setState(200);
				match(SEP);
				}
			}

			setState(204);
			value();
			setState(209);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SEP) {
				{
				{
				setState(205);
				match(SEP);
				setState(206);
				value();
				}
				}
				setState(211);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(212);
			match(CPAREN);
			setState(215);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CHANGE) {
				{
				setState(213);
				match(CHANGE);
				setState(214);
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
			setState(217);
			match(NULL);
			setState(218);
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
		public TerminalNode DIAFLOATING() { return getToken(LscParser.DIAFLOATING, 0); }
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
			setState(220);
			match(DIACRITIC);
			setState(221);
			match(WHITESPACE);
			setState(222);
			match(STR1);
			setState(223);
			match(WHITESPACE);
			setState(226);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DIABEFORE) {
				{
				setState(224);
				match(DIABEFORE);
				setState(225);
				match(WHITESPACE);
				}
			}

			setState(230);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DIAFLOATING) {
				{
				setState(228);
				match(DIAFLOATING);
				setState(229);
				match(WHITESPACE);
				}
			}

			setState(232);
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
			setState(234);
			match(SYMBOL);
			setState(235);
			match(WHITESPACE);
			setState(236);
			symbolname();
			setState(246);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SEP:
			case NEWLINE:
				{
				setState(241);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==SEP) {
					{
					{
					setState(237);
					match(SEP);
					setState(238);
					symbolname();
					}
					}
					setState(243);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case WHITESPACE:
				{
				setState(244);
				match(WHITESPACE);
				setState(245);
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
			setState(248);
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
			setState(250);
			match(DEROMANIZER);
			setState(251);
			match(RULESTART);
			setState(258); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(253); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(252);
						match(NEWLINE);
						}
						}
						setState(255); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==NEWLINE );
					setState(257);
					ruleexpression();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(260); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
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
			setState(262);
			match(ROMANIZER);
			setState(263);
			match(RULESTART);
			setState(270); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(265); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(264);
						match(NEWLINE);
						}
						}
						setState(267); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==NEWLINE );
					setState(269);
					ruleexpression();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(272); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,30,_ctx);
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

	public static class InterromanizerContext extends ParserRuleContext {
		public TerminalNode ROMANIZER() { return getToken(LscParser.ROMANIZER, 0); }
		public TerminalNode HYPHEN() { return getToken(LscParser.HYPHEN, 0); }
		public RulenameContext rulename() {
			return getRuleContext(RulenameContext.class,0);
		}
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
		public InterromanizerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_interromanizer; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LscVisitor ) return ((LscVisitor<? extends T>)visitor).visitInterromanizer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InterromanizerContext interromanizer() throws RecognitionException {
		InterromanizerContext _localctx = new InterromanizerContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_interromanizer);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(274);
			match(ROMANIZER);
			setState(275);
			match(HYPHEN);
			setState(276);
			rulename();
			setState(277);
			match(RULESTART);
			setState(284); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(279); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(278);
						match(NEWLINE);
						}
						}
						setState(281); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==NEWLINE );
					setState(283);
					ruleexpression();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(286); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
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
		enterRule(_localctx, 20, RULE_changerule);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(288);
			rulename();
			setState(291);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
			case 1:
				{
				setState(289);
				match(WHITESPACE);
				setState(290);
				matrix();
				}
				break;
			}
			setState(295);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WHITESPACE) {
				{
				setState(293);
				match(WHITESPACE);
				setState(294);
				match(PROPAGATE);
				}
			}

			setState(297);
			match(RULESTART);
			setState(298);
			match(NEWLINE);
			setState(299);
			subrule();
			setState(307);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(300);
					match(NEWLINE);
					setState(301);
					match(SUBRULE);
					setState(302);
					match(RULESTART);
					setState(303);
					_la = _input.LA(1);
					if ( !(_la==NEWLINE || _la==WHITESPACE) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(304);
					subrule();
					}
					} 
				}
				setState(309);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
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
		enterRule(_localctx, 22, RULE_subrule);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(310);
			ruleexpression();
			setState(315);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,36,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(311);
					match(NEWLINE);
					setState(312);
					ruleexpression();
					}
					} 
				}
				setState(317);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,36,_ctx);
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
		enterRule(_localctx, 24, RULE_rulename);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(318);
			match(VALUE);
			setState(323);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==HYPHEN) {
				{
				{
				setState(319);
				match(HYPHEN);
				setState(320);
				match(VALUE);
				}
				}
				setState(325);
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
		enterRule(_localctx, 26, RULE_ruleexpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(326);
			rulefrom();
			setState(327);
			match(CHANGE);
			setState(328);
			ruleto();
			setState(331);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CONDITION) {
				{
				setState(329);
				match(CONDITION);
				setState(330);
				condition();
				}
			}

			setState(335);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EXCLUSION) {
				{
				setState(333);
				match(EXCLUSION);
				setState(334);
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
		enterRule(_localctx, 28, RULE_condition);
		try {
			setState(339);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,40,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(337);
				ruleenviron();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(338);
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
		enterRule(_localctx, 30, RULE_exclusion);
		try {
			setState(343);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,41,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(341);
				ruleenviron();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(342);
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
		enterRule(_localctx, 32, RULE_rulefrom);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(345);
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
		enterRule(_localctx, 34, RULE_ruleto);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(347);
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
		enterRule(_localctx, 36, RULE_environlist);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(349);
			match(LISTSTART);
			setState(350);
			ruleenviron();
			setState(355);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SEP) {
				{
				{
				setState(351);
				match(SEP);
				setState(352);
				ruleenviron();
				}
				}
				setState(357);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(358);
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
		enterRule(_localctx, 38, RULE_ruleenviron);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(363);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,43,_ctx) ) {
			case 1:
				{
				setState(360);
				boundarybefore();
				setState(361);
				match(WHITESPACE);
				}
				break;
			}
			setState(368);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OPAREN) | (1L << NULL) | (1L << MATSTART) | (1L << LISTSTART) | (1L << WORDBOUNDARY) | (1L << CLASSREF) | (1L << FEATURE) | (1L << VALUE) | (1L << STR1) | (1L << STR))) != 0)) {
				{
				setState(365);
				rulebefore();
				setState(366);
				match(WHITESPACE);
				}
			}

			setState(370);
			match(ANCHOR);
			setState(373);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,45,_ctx) ) {
			case 1:
				{
				setState(371);
				match(WHITESPACE);
				setState(372);
				ruleafter();
				}
				break;
			}
			setState(377);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WHITESPACE) {
				{
				setState(375);
				match(WHITESPACE);
				setState(376);
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
		enterRule(_localctx, 40, RULE_boundarybefore);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(379);
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
		enterRule(_localctx, 42, RULE_boundaryafter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(381);
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
		enterRule(_localctx, 44, RULE_rulebefore);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(383);
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
		enterRule(_localctx, 46, RULE_ruleafter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(385);
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
		enterRule(_localctx, 48, RULE_ruleelement);
		try {
			setState(393);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,47,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(387);
				rulecapture();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(388);
				rulerepeater();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(389);
				rulegroup();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(390);
				rulelist();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(391);
				simpleelement();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(392);
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
		enterRule(_localctx, 50, RULE_rulesequence);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(395);
			sequenceelement();
			setState(398); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(396);
					match(WHITESPACE);
					setState(397);
					sequenceelement();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(400); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,48,_ctx);
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
		enterRule(_localctx, 52, RULE_sequenceelement);
		try {
			setState(407);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,49,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(402);
				rulecapture();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(403);
				rulerepeater();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(404);
				rulegroup();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(405);
				rulelist();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(406);
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
		enterRule(_localctx, 54, RULE_rulecapture);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(413);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OPAREN:
				{
				setState(409);
				rulegroup();
				}
				break;
			case LISTSTART:
				{
				setState(410);
				rulelist();
				}
				break;
			case CLASSREF:
				{
				setState(411);
				classref();
				}
				break;
			case MATSTART:
				{
				setState(412);
				fancymatrix();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(415);
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
		enterRule(_localctx, 56, RULE_rulerepeater);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(420);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OPAREN:
				{
				setState(417);
				rulegroup();
				}
				break;
			case LISTSTART:
				{
				setState(418);
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
				setState(419);
				simpleelement();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(422);
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
		enterRule(_localctx, 58, RULE_rulegroup);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(424);
			match(OPAREN);
			setState(425);
			ruleelement();
			setState(426);
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
		enterRule(_localctx, 60, RULE_rulelist);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(428);
			match(LISTSTART);
			setState(429);
			ruleelement();
			setState(434);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SEP) {
				{
				{
				setState(430);
				match(SEP);
				setState(431);
				ruleelement();
				}
				}
				setState(436);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(437);
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
		enterRule(_localctx, 62, RULE_simpleelement);
		try {
			setState(444);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CLASSREF:
				enterOuterAlt(_localctx, 1);
				{
				setState(439);
				classref();
				}
				break;
			case WORDBOUNDARY:
				enterOuterAlt(_localctx, 2);
				{
				setState(440);
				captureref();
				}
				break;
			case MATSTART:
				enterOuterAlt(_localctx, 3);
				{
				setState(441);
				fancymatrix();
				}
				break;
			case NULL:
				enterOuterAlt(_localctx, 4);
				{
				setState(442);
				empty();
				}
				break;
			case FEATURE:
			case VALUE:
			case STR1:
			case STR:
				enterOuterAlt(_localctx, 5);
				{
				setState(443);
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
		enterRule(_localctx, 64, RULE_classref);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(446);
			match(CLASSREF);
			setState(447);
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
		enterRule(_localctx, 66, RULE_captureref);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(449);
			match(WORDBOUNDARY);
			setState(450);
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
		enterRule(_localctx, 68, RULE_fancymatrix);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(452);
			match(MATSTART);
			setState(454);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NULL) | (1L << NEGATION) | (1L << WORDBOUNDARY) | (1L << VALUE))) != 0)) {
				{
				setState(453);
				fancyvalue();
				}
			}

			setState(460);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WHITESPACE) {
				{
				{
				setState(456);
				match(WHITESPACE);
				setState(457);
				fancyvalue();
				}
				}
				setState(462);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(463);
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
		enterRule(_localctx, 70, RULE_fancyvalue);
		try {
			setState(469);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VALUE:
				enterOuterAlt(_localctx, 1);
				{
				setState(465);
				value();
				}
				break;
			case NEGATION:
				enterOuterAlt(_localctx, 2);
				{
				setState(466);
				negvalue();
				}
				break;
			case NULL:
				enterOuterAlt(_localctx, 3);
				{
				setState(467);
				absentfeature();
				}
				break;
			case WORDBOUNDARY:
				enterOuterAlt(_localctx, 4);
				{
				setState(468);
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
		enterRule(_localctx, 72, RULE_negvalue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(471);
			match(NEGATION);
			setState(472);
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
		enterRule(_localctx, 74, RULE_absentfeature);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(474);
			match(NULL);
			setState(475);
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
		enterRule(_localctx, 76, RULE_featurevariable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(477);
			match(WORDBOUNDARY);
			setState(478);
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
		enterRule(_localctx, 78, RULE_empty);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(480);
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
		enterRule(_localctx, 80, RULE_repeatertype);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(482);
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
		enterRule(_localctx, 82, RULE_matrix);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(484);
			match(MATSTART);
			setState(486);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==VALUE) {
				{
				setState(485);
				value();
				}
			}

			setState(492);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WHITESPACE) {
				{
				{
				setState(488);
				match(WHITESPACE);
				setState(489);
				value();
				}
				}
				setState(494);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(495);
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
		enterRule(_localctx, 84, RULE_feature);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(497);
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
		enterRule(_localctx, 86, RULE_value);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(499);
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
		enterRule(_localctx, 88, RULE_text);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(501);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\'\u01fa\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\3\2\3\2\6\2_\n\2\r\2\16\2`\7\2c\n\2\f\2\16\2f\13\2\3"+
		"\2\3\2\6\2j\n\2\r\2\16\2k\7\2n\n\2\f\2\16\2q\13\2\3\2\3\2\6\2u\n\2\r\2"+
		"\16\2v\7\2y\n\2\f\2\16\2|\13\2\3\2\3\2\6\2\u0080\n\2\r\2\16\2\u0081\7"+
		"\2\u0084\n\2\f\2\16\2\u0087\13\2\3\2\3\2\6\2\u008b\n\2\r\2\16\2\u008c"+
		"\5\2\u008f\n\2\3\2\5\2\u0092\n\2\3\2\6\2\u0095\n\2\r\2\16\2\u0096\3\2"+
		"\3\2\5\2\u009b\n\2\7\2\u009d\n\2\f\2\16\2\u00a0\13\2\3\2\6\2\u00a3\n\2"+
		"\r\2\16\2\u00a4\3\2\5\2\u00a8\n\2\3\2\6\2\u00ab\n\2\r\2\16\2\u00ac\3\2"+
		"\5\2\u00b0\n\2\3\2\5\2\u00b3\n\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\7\3\u00bf\n\3\f\3\16\3\u00c2\13\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\5\4\u00cd\n\4\3\4\3\4\3\4\7\4\u00d2\n\4\f\4\16\4\u00d5\13\4\3\4\3\4"+
		"\3\4\5\4\u00da\n\4\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\5\6\u00e5\n\6\3"+
		"\6\3\6\5\6\u00e9\n\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\7\7\u00f2\n\7\f\7\16"+
		"\7\u00f5\13\7\3\7\3\7\5\7\u00f9\n\7\3\b\3\b\3\t\3\t\3\t\6\t\u0100\n\t"+
		"\r\t\16\t\u0101\3\t\6\t\u0105\n\t\r\t\16\t\u0106\3\n\3\n\3\n\6\n\u010c"+
		"\n\n\r\n\16\n\u010d\3\n\6\n\u0111\n\n\r\n\16\n\u0112\3\13\3\13\3\13\3"+
		"\13\3\13\6\13\u011a\n\13\r\13\16\13\u011b\3\13\6\13\u011f\n\13\r\13\16"+
		"\13\u0120\3\f\3\f\3\f\5\f\u0126\n\f\3\f\3\f\5\f\u012a\n\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\7\f\u0134\n\f\f\f\16\f\u0137\13\f\3\r\3\r\3\r\7\r"+
		"\u013c\n\r\f\r\16\r\u013f\13\r\3\16\3\16\3\16\7\16\u0144\n\16\f\16\16"+
		"\16\u0147\13\16\3\17\3\17\3\17\3\17\3\17\5\17\u014e\n\17\3\17\3\17\5\17"+
		"\u0152\n\17\3\20\3\20\5\20\u0156\n\20\3\21\3\21\5\21\u015a\n\21\3\22\3"+
		"\22\3\23\3\23\3\24\3\24\3\24\3\24\7\24\u0164\n\24\f\24\16\24\u0167\13"+
		"\24\3\24\3\24\3\25\3\25\3\25\5\25\u016e\n\25\3\25\3\25\3\25\5\25\u0173"+
		"\n\25\3\25\3\25\3\25\5\25\u0178\n\25\3\25\3\25\5\25\u017c\n\25\3\26\3"+
		"\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\32\5\32\u018c"+
		"\n\32\3\33\3\33\3\33\6\33\u0191\n\33\r\33\16\33\u0192\3\34\3\34\3\34\3"+
		"\34\3\34\5\34\u019a\n\34\3\35\3\35\3\35\3\35\5\35\u01a0\n\35\3\35\3\35"+
		"\3\36\3\36\3\36\5\36\u01a7\n\36\3\36\3\36\3\37\3\37\3\37\3\37\3 \3 \3"+
		" \3 \7 \u01b3\n \f \16 \u01b6\13 \3 \3 \3!\3!\3!\3!\3!\5!\u01bf\n!\3\""+
		"\3\"\3\"\3#\3#\3#\3$\3$\5$\u01c9\n$\3$\3$\7$\u01cd\n$\f$\16$\u01d0\13"+
		"$\3$\3$\3%\3%\3%\3%\5%\u01d8\n%\3&\3&\3&\3\'\3\'\3\'\3(\3(\3(\3)\3)\3"+
		"*\3*\3+\3+\5+\u01e9\n+\3+\3+\7+\u01ed\n+\f+\16+\u01f0\13+\3+\3+\3,\3,"+
		"\3-\3-\3.\3.\3.\2\2/\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60"+
		"\62\64\668:<>@BDFHJLNPRTVXZ\2\5\3\2\t\n\4\2\r\r\22\23\4\2#$&\'\2\u0216"+
		"\2d\3\2\2\2\4\u00b6\3\2\2\2\6\u00c5\3\2\2\2\b\u00db\3\2\2\2\n\u00de\3"+
		"\2\2\2\f\u00ec\3\2\2\2\16\u00fa\3\2\2\2\20\u00fc\3\2\2\2\22\u0108\3\2"+
		"\2\2\24\u0114\3\2\2\2\26\u0122\3\2\2\2\30\u0138\3\2\2\2\32\u0140\3\2\2"+
		"\2\34\u0148\3\2\2\2\36\u0155\3\2\2\2 \u0159\3\2\2\2\"\u015b\3\2\2\2$\u015d"+
		"\3\2\2\2&\u015f\3\2\2\2(\u016d\3\2\2\2*\u017d\3\2\2\2,\u017f\3\2\2\2."+
		"\u0181\3\2\2\2\60\u0183\3\2\2\2\62\u018b\3\2\2\2\64\u018d\3\2\2\2\66\u0199"+
		"\3\2\2\28\u019f\3\2\2\2:\u01a6\3\2\2\2<\u01aa\3\2\2\2>\u01ae\3\2\2\2@"+
		"\u01be\3\2\2\2B\u01c0\3\2\2\2D\u01c3\3\2\2\2F\u01c6\3\2\2\2H\u01d7\3\2"+
		"\2\2J\u01d9\3\2\2\2L\u01dc\3\2\2\2N\u01df\3\2\2\2P\u01e2\3\2\2\2R\u01e4"+
		"\3\2\2\2T\u01e6\3\2\2\2V\u01f3\3\2\2\2X\u01f5\3\2\2\2Z\u01f7\3\2\2\2\\"+
		"^\5\6\4\2]_\7\t\2\2^]\3\2\2\2_`\3\2\2\2`^\3\2\2\2`a\3\2\2\2ac\3\2\2\2"+
		"b\\\3\2\2\2cf\3\2\2\2db\3\2\2\2de\3\2\2\2eo\3\2\2\2fd\3\2\2\2gi\5\n\6"+
		"\2hj\7\t\2\2ih\3\2\2\2jk\3\2\2\2ki\3\2\2\2kl\3\2\2\2ln\3\2\2\2mg\3\2\2"+
		"\2nq\3\2\2\2om\3\2\2\2op\3\2\2\2pz\3\2\2\2qo\3\2\2\2rt\5\f\7\2su\7\t\2"+
		"\2ts\3\2\2\2uv\3\2\2\2vt\3\2\2\2vw\3\2\2\2wy\3\2\2\2xr\3\2\2\2y|\3\2\2"+
		"\2zx\3\2\2\2z{\3\2\2\2{\u0085\3\2\2\2|z\3\2\2\2}\177\5\4\3\2~\u0080\7"+
		"\t\2\2\177~\3\2\2\2\u0080\u0081\3\2\2\2\u0081\177\3\2\2\2\u0081\u0082"+
		"\3\2\2\2\u0082\u0084\3\2\2\2\u0083}\3\2\2\2\u0084\u0087\3\2\2\2\u0085"+
		"\u0083\3\2\2\2\u0085\u0086\3\2\2\2\u0086\u008e\3\2\2\2\u0087\u0085\3\2"+
		"\2\2\u0088\u008a\5\20\t\2\u0089\u008b\7\t\2\2\u008a\u0089\3\2\2\2\u008b"+
		"\u008c\3\2\2\2\u008c\u008a\3\2\2\2\u008c\u008d\3\2\2\2\u008d\u008f\3\2"+
		"\2\2\u008e\u0088\3\2\2\2\u008e\u008f\3\2\2\2\u008f\u0091\3\2\2\2\u0090"+
		"\u0092\5\26\f\2\u0091\u0090\3\2\2\2\u0091\u0092\3\2\2\2\u0092\u00a7\3"+
		"\2\2\2\u0093\u0095\7\t\2\2\u0094\u0093\3\2\2\2\u0095\u0096\3\2\2\2\u0096"+
		"\u0094\3\2\2\2\u0096\u0097\3\2\2\2\u0097\u009a\3\2\2\2\u0098\u009b\5\26"+
		"\f\2\u0099\u009b\5\24\13\2\u009a\u0098\3\2\2\2\u009a\u0099\3\2\2\2\u009b"+
		"\u009d\3\2\2\2\u009c\u0094\3\2\2\2\u009d\u00a0\3\2\2\2\u009e\u009c\3\2"+
		"\2\2\u009e\u009f\3\2\2\2\u009f\u00a2\3\2\2\2\u00a0\u009e\3\2\2\2\u00a1"+
		"\u00a3\7\t\2\2\u00a2\u00a1\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4\u00a2\3\2"+
		"\2\2\u00a4\u00a5\3\2\2\2\u00a5\u00a6\3\2\2\2\u00a6\u00a8\5\26\f\2\u00a7"+
		"\u009e\3\2\2\2\u00a7\u00a8\3\2\2\2\u00a8\u00af\3\2\2\2\u00a9\u00ab\7\t"+
		"\2\2\u00aa\u00a9\3\2\2\2\u00ab\u00ac\3\2\2\2\u00ac\u00aa\3\2\2\2\u00ac"+
		"\u00ad\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ae\u00b0\5\22\n\2\u00af\u00aa\3"+
		"\2\2\2\u00af\u00b0\3\2\2\2\u00b0\u00b2\3\2\2\2\u00b1\u00b3\7\t\2\2\u00b2"+
		"\u00b1\3\2\2\2\u00b2\u00b3\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4\u00b5\7\2"+
		"\2\3\u00b5\3\3\2\2\2\u00b6\u00b7\7\31\2\2\u00b7\u00b8\7\n\2\2\u00b8\u00b9"+
		"\5X-\2\u00b9\u00ba\7\n\2\2\u00ba\u00bb\7\20\2\2\u00bb\u00c0\5Z.\2\u00bc"+
		"\u00bd\7\4\2\2\u00bd\u00bf\5Z.\2\u00be\u00bc\3\2\2\2\u00bf\u00c2\3\2\2"+
		"\2\u00c0\u00be\3\2\2\2\u00c0\u00c1\3\2\2\2\u00c1\u00c3\3\2\2\2\u00c2\u00c0"+
		"\3\2\2\2\u00c3\u00c4\7\21\2\2\u00c4\5\3\2\2\2\u00c5\u00c6\7\32\2\2\u00c6"+
		"\u00c7\7\n\2\2\u00c7\u00c8\5V,\2\u00c8\u00cc\7\13\2\2\u00c9\u00ca\5\b"+
		"\5\2\u00ca\u00cb\7\4\2\2\u00cb\u00cd\3\2\2\2\u00cc\u00c9\3\2\2\2\u00cc"+
		"\u00cd\3\2\2\2\u00cd\u00ce\3\2\2\2\u00ce\u00d3\5X-\2\u00cf\u00d0\7\4\2"+
		"\2\u00d0\u00d2\5X-\2\u00d1\u00cf\3\2\2\2\u00d2\u00d5\3\2\2\2\u00d3\u00d1"+
		"\3\2\2\2\u00d3\u00d4\3\2\2\2\u00d4\u00d6\3\2\2\2\u00d5\u00d3\3\2\2\2\u00d6"+
		"\u00d9\7\f\2\2\u00d7\u00d8\7\5\2\2\u00d8\u00da\5T+\2\u00d9\u00d7\3\2\2"+
		"\2\u00d9\u00da\3\2\2\2\u00da\7\3\2\2\2\u00db\u00dc\7\r\2\2\u00dc\u00dd"+
		"\5X-\2\u00dd\t\3\2\2\2\u00de\u00df\7\33\2\2\u00df\u00e0\7\n\2\2\u00e0"+
		"\u00e1\7&\2\2\u00e1\u00e4\7\n\2\2\u00e2\u00e3\7\34\2\2\u00e3\u00e5\7\n"+
		"\2\2\u00e4\u00e2\3\2\2\2\u00e4\u00e5\3\2\2\2\u00e5\u00e8\3\2\2\2\u00e6"+
		"\u00e7\7\35\2\2\u00e7\u00e9\7\n\2\2\u00e8\u00e6\3\2\2\2\u00e8\u00e9\3"+
		"\2\2\2\u00e9\u00ea\3\2\2\2\u00ea\u00eb\5T+\2\u00eb\13\3\2\2\2\u00ec\u00ed"+
		"\7\36\2\2\u00ed\u00ee\7\n\2\2\u00ee\u00f8\5\16\b\2\u00ef\u00f0\7\4\2\2"+
		"\u00f0\u00f2\5\16\b\2\u00f1\u00ef\3\2\2\2\u00f2\u00f5\3\2\2\2\u00f3\u00f1"+
		"\3\2\2\2\u00f3\u00f4\3\2\2\2\u00f4\u00f9\3\2\2\2\u00f5\u00f3\3\2\2\2\u00f6"+
		"\u00f7\7\n\2\2\u00f7\u00f9\5T+\2\u00f8\u00f3\3\2\2\2\u00f8\u00f6\3\2\2"+
		"\2\u00f9\r\3\2\2\2\u00fa\u00fb\5Z.\2\u00fb\17\3\2\2\2\u00fc\u00fd\7\37"+
		"\2\2\u00fd\u0104\7\25\2\2\u00fe\u0100\7\t\2\2\u00ff\u00fe\3\2\2\2\u0100"+
		"\u0101\3\2\2\2\u0101\u00ff\3\2\2\2\u0101\u0102\3\2\2\2\u0102\u0103\3\2"+
		"\2\2\u0103\u0105\5\34\17\2\u0104\u00ff\3\2\2\2\u0105\u0106\3\2\2\2\u0106"+
		"\u0104\3\2\2\2\u0106\u0107\3\2\2\2\u0107\21\3\2\2\2\u0108\u0109\7 \2\2"+
		"\u0109\u0110\7\25\2\2\u010a\u010c\7\t\2\2\u010b\u010a\3\2\2\2\u010c\u010d"+
		"\3\2\2\2\u010d\u010b\3\2\2\2\u010d\u010e\3\2\2\2\u010e\u010f\3\2\2\2\u010f"+
		"\u0111\5\34\17\2\u0110\u010b\3\2\2\2\u0111\u0112\3\2\2\2\u0112\u0110\3"+
		"\2\2\2\u0112\u0113\3\2\2\2\u0113\23\3\2\2\2\u0114\u0115\7 \2\2\u0115\u0116"+
		"\7\24\2\2\u0116\u0117\5\32\16\2\u0117\u011e\7\25\2\2\u0118\u011a\7\t\2"+
		"\2\u0119\u0118\3\2\2\2\u011a\u011b\3\2\2\2\u011b\u0119\3\2\2\2\u011b\u011c"+
		"\3\2\2\2\u011c\u011d\3\2\2\2\u011d\u011f\5\34\17\2\u011e\u0119\3\2\2\2"+
		"\u011f\u0120\3\2\2\2\u0120\u011e\3\2\2\2\u0120\u0121\3\2\2\2\u0121\25"+
		"\3\2\2\2\u0122\u0125\5\32\16\2\u0123\u0124\7\n\2\2\u0124\u0126\5T+\2\u0125"+
		"\u0123\3\2\2\2\u0125\u0126\3\2\2\2\u0126\u0129\3\2\2\2\u0127\u0128\7\n"+
		"\2\2\u0128\u012a\7\"\2\2\u0129\u0127\3\2\2\2\u0129\u012a\3\2\2\2\u012a"+
		"\u012b\3\2\2\2\u012b\u012c\7\25\2\2\u012c\u012d\7\t\2\2\u012d\u0135\5"+
		"\30\r\2\u012e\u012f\7\t\2\2\u012f\u0130\7!\2\2\u0130\u0131\7\25\2\2\u0131"+
		"\u0132\t\2\2\2\u0132\u0134\5\30\r\2\u0133\u012e\3\2\2\2\u0134\u0137\3"+
		"\2\2\2\u0135\u0133\3\2\2\2\u0135\u0136\3\2\2\2\u0136\27\3\2\2\2\u0137"+
		"\u0135\3\2\2\2\u0138\u013d\5\34\17\2\u0139\u013a\7\t\2\2\u013a\u013c\5"+
		"\34\17\2\u013b\u0139\3\2\2\2\u013c\u013f\3\2\2\2\u013d\u013b\3\2\2\2\u013d"+
		"\u013e\3\2\2\2\u013e\31\3\2\2\2\u013f\u013d\3\2\2\2\u0140\u0145\7$\2\2"+
		"\u0141\u0142\7\24\2\2\u0142\u0144\7$\2\2\u0143\u0141\3\2\2\2\u0144\u0147"+
		"\3\2\2\2\u0145\u0143\3\2\2\2\u0145\u0146\3\2\2\2\u0146\33\3\2\2\2\u0147"+
		"\u0145\3\2\2\2\u0148\u0149\5\"\22\2\u0149\u014a\7\5\2\2\u014a\u014d\5"+
		"$\23\2\u014b\u014c\7\6\2\2\u014c\u014e\5\36\20\2\u014d\u014b\3\2\2\2\u014d"+
		"\u014e\3\2\2\2\u014e\u0151\3\2\2\2\u014f\u0150\7\7\2\2\u0150\u0152\5 "+
		"\21\2\u0151\u014f\3\2\2\2\u0151\u0152\3\2\2\2\u0152\35\3\2\2\2\u0153\u0156"+
		"\5(\25\2\u0154\u0156\5&\24\2\u0155\u0153\3\2\2\2\u0155\u0154\3\2\2\2\u0156"+
		"\37\3\2\2\2\u0157\u015a\5(\25\2\u0158\u015a\5&\24\2\u0159\u0157\3\2\2"+
		"\2\u0159\u0158\3\2\2\2\u015a!\3\2\2\2\u015b\u015c\5\62\32\2\u015c#\3\2"+
		"\2\2\u015d\u015e\5\62\32\2\u015e%\3\2\2\2\u015f\u0160\7\20\2\2\u0160\u0165"+
		"\5(\25\2\u0161\u0162\7\4\2\2\u0162\u0164\5(\25\2\u0163\u0161\3\2\2\2\u0164"+
		"\u0167\3\2\2\2\u0165\u0163\3\2\2\2\u0165\u0166\3\2\2\2\u0166\u0168\3\2"+
		"\2\2\u0167\u0165\3\2\2\2\u0168\u0169\7\21\2\2\u0169\'\3\2\2\2\u016a\u016b"+
		"\5*\26\2\u016b\u016c\7\n\2\2\u016c\u016e\3\2\2\2\u016d\u016a\3\2\2\2\u016d"+
		"\u016e\3\2\2\2\u016e\u0172\3\2\2\2\u016f\u0170\5.\30\2\u0170\u0171\7\n"+
		"\2\2\u0171\u0173\3\2\2\2\u0172\u016f\3\2\2\2\u0172\u0173\3\2\2\2\u0173"+
		"\u0174\3\2\2\2\u0174\u0177\7\b\2\2\u0175\u0176\7\n\2\2\u0176\u0178\5\60"+
		"\31\2\u0177\u0175\3\2\2\2\u0177\u0178\3\2\2\2\u0178\u017b\3\2\2\2\u0179"+
		"\u017a\7\n\2\2\u017a\u017c\5,\27\2\u017b\u0179\3\2\2\2\u017b\u017c\3\2"+
		"\2\2\u017c)\3\2\2\2\u017d\u017e\7\27\2\2\u017e+\3\2\2\2\u017f\u0180\7"+
		"\27\2\2\u0180-\3\2\2\2\u0181\u0182\5\62\32\2\u0182/\3\2\2\2\u0183\u0184"+
		"\5\62\32\2\u0184\61\3\2\2\2\u0185\u018c\58\35\2\u0186\u018c\5:\36\2\u0187"+
		"\u018c\5<\37\2\u0188\u018c\5> \2\u0189\u018c\5@!\2\u018a\u018c\5\64\33"+
		"\2\u018b\u0185\3\2\2\2\u018b\u0186\3\2\2\2\u018b\u0187\3\2\2\2\u018b\u0188"+
		"\3\2\2\2\u018b\u0189\3\2\2\2\u018b\u018a\3\2\2\2\u018c\63\3\2\2\2\u018d"+
		"\u0190\5\66\34\2\u018e\u018f\7\n\2\2\u018f\u0191\5\66\34\2\u0190\u018e"+
		"\3\2\2\2\u0191\u0192\3\2\2\2\u0192\u0190\3\2\2\2\u0192\u0193\3\2\2\2\u0193"+
		"\65\3\2\2\2\u0194\u019a\58\35\2\u0195\u019a\5:\36\2\u0196\u019a\5<\37"+
		"\2\u0197\u019a\5> \2\u0198\u019a\5@!\2\u0199\u0194\3\2\2\2\u0199\u0195"+
		"\3\2\2\2\u0199\u0196\3\2\2\2\u0199\u0197\3\2\2\2\u0199\u0198\3\2\2\2\u019a"+
		"\67\3\2\2\2\u019b\u01a0\5<\37\2\u019c\u01a0\5> \2\u019d\u01a0\5B\"\2\u019e"+
		"\u01a0\5F$\2\u019f\u019b\3\2\2\2\u019f\u019c\3\2\2\2\u019f\u019d\3\2\2"+
		"\2\u019f\u019e\3\2\2\2\u01a0\u01a1\3\2\2\2\u01a1\u01a2\5D#\2\u01a29\3"+
		"\2\2\2\u01a3\u01a7\5<\37\2\u01a4\u01a7\5> \2\u01a5\u01a7\5@!\2\u01a6\u01a3"+
		"\3\2\2\2\u01a6\u01a4\3\2\2\2\u01a6\u01a5\3\2\2\2\u01a7\u01a8\3\2\2\2\u01a8"+
		"\u01a9\5R*\2\u01a9;\3\2\2\2\u01aa\u01ab\7\13\2\2\u01ab\u01ac\5\62\32\2"+
		"\u01ac\u01ad\7\f\2\2\u01ad=\3\2\2\2\u01ae\u01af\7\20\2\2\u01af\u01b4\5"+
		"\62\32\2\u01b0\u01b1\7\4\2\2\u01b1\u01b3\5\62\32\2\u01b2\u01b0\3\2\2\2"+
		"\u01b3\u01b6\3\2\2\2\u01b4\u01b2\3\2\2\2\u01b4\u01b5\3\2\2\2\u01b5\u01b7"+
		"\3\2\2\2\u01b6\u01b4\3\2\2\2\u01b7\u01b8\7\21\2\2\u01b8?\3\2\2\2\u01b9"+
		"\u01bf\5B\"\2\u01ba\u01bf\5D#\2\u01bb\u01bf\5F$\2\u01bc\u01bf\5P)\2\u01bd"+
		"\u01bf\5Z.\2\u01be\u01b9\3\2\2\2\u01be\u01ba\3\2\2\2\u01be\u01bb\3\2\2"+
		"\2\u01be\u01bc\3\2\2\2\u01be\u01bd\3\2\2\2\u01bfA\3\2\2\2\u01c0\u01c1"+
		"\7\30\2\2\u01c1\u01c2\5X-\2\u01c2C\3\2\2\2\u01c3\u01c4\7\27\2\2\u01c4"+
		"\u01c5\7%\2\2\u01c5E\3\2\2\2\u01c6\u01c8\7\16\2\2\u01c7\u01c9\5H%\2\u01c8"+
		"\u01c7\3\2\2\2\u01c8\u01c9\3\2\2\2\u01c9\u01ce\3\2\2\2\u01ca\u01cb\7\n"+
		"\2\2\u01cb\u01cd\5H%\2\u01cc\u01ca\3\2\2\2\u01cd\u01d0\3\2\2\2\u01ce\u01cc"+
		"\3\2\2\2\u01ce\u01cf\3\2\2\2\u01cf\u01d1\3\2\2\2\u01d0\u01ce\3\2\2\2\u01d1"+
		"\u01d2\7\17\2\2\u01d2G\3\2\2\2\u01d3\u01d8\5X-\2\u01d4\u01d8\5J&\2\u01d5"+
		"\u01d8\5L\'\2\u01d6\u01d8\5N(\2\u01d7\u01d3\3\2\2\2\u01d7\u01d4\3\2\2"+
		"\2\u01d7\u01d5\3\2\2\2\u01d7\u01d6\3\2\2\2\u01d8I\3\2\2\2\u01d9\u01da"+
		"\7\26\2\2\u01da\u01db\5X-\2\u01dbK\3\2\2\2\u01dc\u01dd\7\r\2\2\u01dd\u01de"+
		"\5V,\2\u01deM\3\2\2\2\u01df\u01e0\7\27\2\2\u01e0\u01e1\5V,\2\u01e1O\3"+
		"\2\2\2\u01e2\u01e3\7\r\2\2\u01e3Q\3\2\2\2\u01e4\u01e5\t\3\2\2\u01e5S\3"+
		"\2\2\2\u01e6\u01e8\7\16\2\2\u01e7\u01e9\5X-\2\u01e8\u01e7\3\2\2\2\u01e8"+
		"\u01e9\3\2\2\2\u01e9\u01ee\3\2\2\2\u01ea\u01eb\7\n\2\2\u01eb\u01ed\5X"+
		"-\2\u01ec\u01ea\3\2\2\2\u01ed\u01f0\3\2\2\2\u01ee\u01ec\3\2\2\2\u01ee"+
		"\u01ef\3\2\2\2\u01ef\u01f1\3\2\2\2\u01f0\u01ee\3\2\2\2\u01f1\u01f2\7\17"+
		"\2\2\u01f2U\3\2\2\2\u01f3\u01f4\7#\2\2\u01f4W\3\2\2\2\u01f5\u01f6\7$\2"+
		"\2\u01f6Y\3\2\2\2\u01f7\u01f8\t\4\2\2\u01f8[\3\2\2\2=`dkovz\u0081\u0085"+
		"\u008c\u008e\u0091\u0096\u009a\u009e\u00a4\u00a7\u00ac\u00af\u00b2\u00c0"+
		"\u00cc\u00d3\u00d9\u00e4\u00e8\u00f3\u00f8\u0101\u0106\u010d\u0112\u011b"+
		"\u0120\u0125\u0129\u0135\u013d\u0145\u014d\u0151\u0155\u0159\u0165\u016d"+
		"\u0172\u0177\u017b\u018b\u0192\u0199\u019f\u01a6\u01b4\u01be\u01c8\u01ce"+
		"\u01d7\u01e8\u01ee";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}