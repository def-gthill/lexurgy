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
		RULE_romanizer = 8, RULE_interromanizer = 9, RULE_changerule = 10, RULE_subrules = 11, 
		RULE_subrule = 12, RULE_rulename = 13, RULE_ruleexpression = 14, RULE_condition = 15, 
		RULE_exclusion = 16, RULE_rulefrom = 17, RULE_ruleto = 18, RULE_environlist = 19, 
		RULE_ruleenviron = 20, RULE_boundarybefore = 21, RULE_boundaryafter = 22, 
		RULE_rulebefore = 23, RULE_ruleafter = 24, RULE_ruleelement = 25, RULE_rulesequence = 26, 
		RULE_sequenceelement = 27, RULE_rulecapture = 28, RULE_rulerepeater = 29, 
		RULE_rulegroup = 30, RULE_rulelist = 31, RULE_simpleelement = 32, RULE_classref = 33, 
		RULE_captureref = 34, RULE_fancymatrix = 35, RULE_fancyvalue = 36, RULE_negvalue = 37, 
		RULE_absentfeature = 38, RULE_featurevariable = 39, RULE_empty = 40, RULE_repeatertype = 41, 
		RULE_matrix = 42, RULE_feature = 43, RULE_value = 44, RULE_text = 45;
	private static String[] makeRuleNames() {
		return new String[] {
			"lscfile", "classdecl", "featuredecl", "nullalias", "diacritic", "symbol", 
			"symbolname", "deromanizer", "romanizer", "interromanizer", "changerule", 
			"subrules", "subrule", "rulename", "ruleexpression", "condition", "exclusion", 
			"rulefrom", "ruleto", "environlist", "ruleenviron", "boundarybefore", 
			"boundaryafter", "rulebefore", "ruleafter", "ruleelement", "rulesequence", 
			"sequenceelement", "rulecapture", "rulerepeater", "rulegroup", "rulelist", 
			"simpleelement", "classref", "captureref", "fancymatrix", "fancyvalue", 
			"negvalue", "absentfeature", "featurevariable", "empty", "repeatertype", 
			"matrix", "feature", "value", "text"
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
			setState(100);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==FEATUREDECL) {
				{
				{
				setState(92);
				featuredecl();
				setState(94); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(93);
						match(NEWLINE);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(96); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				}
				setState(102);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(111);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DIACRITIC) {
				{
				{
				setState(103);
				diacritic();
				setState(105); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(104);
						match(NEWLINE);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(107); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				}
				setState(113);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(122);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SYMBOL) {
				{
				{
				setState(114);
				symbol();
				setState(116); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(115);
						match(NEWLINE);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(118); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				}
				setState(124);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(133);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CLASSDECL) {
				{
				{
				setState(125);
				classdecl();
				setState(127); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(126);
						match(NEWLINE);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(129); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				}
				setState(135);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(142);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DEROMANIZER) {
				{
				setState(136);
				deromanizer();
				setState(138); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(137);
						match(NEWLINE);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(140); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
			}

			setState(145);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==VALUE) {
				{
				setState(144);
				changerule();
				}
			}

			setState(167);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				{
				setState(158);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(148); 
						_errHandler.sync(this);
						_la = _input.LA(1);
						do {
							{
							{
							setState(147);
							match(NEWLINE);
							}
							}
							setState(150); 
							_errHandler.sync(this);
							_la = _input.LA(1);
						} while ( _la==NEWLINE );
						setState(154);
						_errHandler.sync(this);
						switch (_input.LA(1)) {
						case VALUE:
							{
							setState(152);
							changerule();
							}
							break;
						case ROMANIZER:
							{
							setState(153);
							interromanizer();
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						}
						} 
					}
					setState(160);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
				}
				setState(162); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(161);
					match(NEWLINE);
					}
					}
					setState(164); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NEWLINE );
				setState(166);
				changerule();
				}
				break;
			}
			setState(175);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				{
				setState(170); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(169);
					match(NEWLINE);
					}
					}
					setState(172); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NEWLINE );
				setState(174);
				romanizer();
				}
				break;
			}
			setState(178);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NEWLINE) {
				{
				setState(177);
				match(NEWLINE);
				}
			}

			setState(180);
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
			setState(182);
			match(CLASSDECL);
			setState(183);
			match(WHITESPACE);
			setState(184);
			value();
			setState(185);
			match(WHITESPACE);
			setState(186);
			match(LISTSTART);
			setState(187);
			text();
			setState(192);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SEP) {
				{
				{
				setState(188);
				match(SEP);
				setState(189);
				text();
				}
				}
				setState(194);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(195);
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
			setState(197);
			match(FEATUREDECL);
			setState(198);
			match(WHITESPACE);
			setState(199);
			feature();
			setState(200);
			match(OPAREN);
			setState(204);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NULL) {
				{
				setState(201);
				nullalias();
				setState(202);
				match(SEP);
				}
			}

			setState(206);
			value();
			setState(211);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SEP) {
				{
				{
				setState(207);
				match(SEP);
				setState(208);
				value();
				}
				}
				setState(213);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(214);
			match(CPAREN);
			setState(217);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CHANGE) {
				{
				setState(215);
				match(CHANGE);
				setState(216);
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
			setState(219);
			match(NULL);
			setState(220);
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
			setState(222);
			match(DIACRITIC);
			setState(223);
			match(WHITESPACE);
			setState(224);
			match(STR1);
			setState(225);
			match(WHITESPACE);
			setState(228);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DIABEFORE) {
				{
				setState(226);
				match(DIABEFORE);
				setState(227);
				match(WHITESPACE);
				}
			}

			setState(232);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DIAFLOATING) {
				{
				setState(230);
				match(DIAFLOATING);
				setState(231);
				match(WHITESPACE);
				}
			}

			setState(234);
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
			setState(236);
			match(SYMBOL);
			setState(237);
			match(WHITESPACE);
			setState(238);
			symbolname();
			setState(248);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SEP:
			case NEWLINE:
				{
				setState(243);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==SEP) {
					{
					{
					setState(239);
					match(SEP);
					setState(240);
					symbolname();
					}
					}
					setState(245);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case WHITESPACE:
				{
				setState(246);
				match(WHITESPACE);
				setState(247);
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
			setState(250);
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
		public TerminalNode NEWLINE() { return getToken(LscParser.NEWLINE, 0); }
		public SubrulesContext subrules() {
			return getRuleContext(SubrulesContext.class,0);
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
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(252);
			match(DEROMANIZER);
			setState(253);
			match(RULESTART);
			setState(254);
			match(NEWLINE);
			setState(255);
			subrules();
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
		public TerminalNode NEWLINE() { return getToken(LscParser.NEWLINE, 0); }
		public SubrulesContext subrules() {
			return getRuleContext(SubrulesContext.class,0);
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
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(257);
			match(ROMANIZER);
			setState(258);
			match(RULESTART);
			setState(259);
			match(NEWLINE);
			setState(260);
			subrules();
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
		public TerminalNode NEWLINE() { return getToken(LscParser.NEWLINE, 0); }
		public SubrulesContext subrules() {
			return getRuleContext(SubrulesContext.class,0);
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
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(262);
			match(ROMANIZER);
			setState(263);
			match(HYPHEN);
			setState(264);
			rulename();
			setState(265);
			match(RULESTART);
			setState(266);
			match(NEWLINE);
			setState(267);
			subrules();
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
		public TerminalNode RULESTART() { return getToken(LscParser.RULESTART, 0); }
		public TerminalNode NEWLINE() { return getToken(LscParser.NEWLINE, 0); }
		public SubrulesContext subrules() {
			return getRuleContext(SubrulesContext.class,0);
		}
		public List<TerminalNode> WHITESPACE() { return getTokens(LscParser.WHITESPACE); }
		public TerminalNode WHITESPACE(int i) {
			return getToken(LscParser.WHITESPACE, i);
		}
		public MatrixContext matrix() {
			return getRuleContext(MatrixContext.class,0);
		}
		public TerminalNode PROPAGATE() { return getToken(LscParser.PROPAGATE, 0); }
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
			enterOuterAlt(_localctx, 1);
			{
			setState(269);
			rulename();
			setState(272);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				{
				setState(270);
				match(WHITESPACE);
				setState(271);
				matrix();
				}
				break;
			}
			setState(276);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WHITESPACE) {
				{
				setState(274);
				match(WHITESPACE);
				setState(275);
				match(PROPAGATE);
				}
			}

			setState(278);
			match(RULESTART);
			setState(279);
			match(NEWLINE);
			setState(280);
			subrules();
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

	public static class SubrulesContext extends ParserRuleContext {
		public List<SubruleContext> subrule() {
			return getRuleContexts(SubruleContext.class);
		}
		public SubruleContext subrule(int i) {
			return getRuleContext(SubruleContext.class,i);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(LscParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(LscParser.NEWLINE, i);
		}
		public List<TerminalNode> SUBRULE() { return getTokens(LscParser.SUBRULE); }
		public TerminalNode SUBRULE(int i) {
			return getToken(LscParser.SUBRULE, i);
		}
		public List<TerminalNode> RULESTART() { return getTokens(LscParser.RULESTART); }
		public TerminalNode RULESTART(int i) {
			return getToken(LscParser.RULESTART, i);
		}
		public List<TerminalNode> WHITESPACE() { return getTokens(LscParser.WHITESPACE); }
		public TerminalNode WHITESPACE(int i) {
			return getToken(LscParser.WHITESPACE, i);
		}
		public SubrulesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subrules; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LscVisitor ) return ((LscVisitor<? extends T>)visitor).visitSubrules(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SubrulesContext subrules() throws RecognitionException {
		SubrulesContext _localctx = new SubrulesContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_subrules);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(282);
			subrule();
			setState(290);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(283);
					match(NEWLINE);
					setState(284);
					match(SUBRULE);
					setState(285);
					match(RULESTART);
					setState(286);
					_la = _input.LA(1);
					if ( !(_la==NEWLINE || _la==WHITESPACE) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(287);
					subrule();
					}
					} 
				}
				setState(292);
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
		enterRule(_localctx, 24, RULE_subrule);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(293);
			ruleexpression();
			setState(298);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,30,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(294);
					match(NEWLINE);
					setState(295);
					ruleexpression();
					}
					} 
				}
				setState(300);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,30,_ctx);
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
		enterRule(_localctx, 26, RULE_rulename);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(301);
			match(VALUE);
			setState(306);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==HYPHEN) {
				{
				{
				setState(302);
				match(HYPHEN);
				setState(303);
				match(VALUE);
				}
				}
				setState(308);
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
		enterRule(_localctx, 28, RULE_ruleexpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(309);
			rulefrom();
			setState(310);
			match(CHANGE);
			setState(311);
			ruleto();
			setState(314);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CONDITION) {
				{
				setState(312);
				match(CONDITION);
				setState(313);
				condition();
				}
			}

			setState(318);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EXCLUSION) {
				{
				setState(316);
				match(EXCLUSION);
				setState(317);
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
		enterRule(_localctx, 30, RULE_condition);
		try {
			setState(322);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(320);
				ruleenviron();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(321);
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
		enterRule(_localctx, 32, RULE_exclusion);
		try {
			setState(326);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(324);
				ruleenviron();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(325);
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
		enterRule(_localctx, 34, RULE_rulefrom);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(328);
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
		enterRule(_localctx, 36, RULE_ruleto);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(330);
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
		enterRule(_localctx, 38, RULE_environlist);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(332);
			match(LISTSTART);
			setState(333);
			ruleenviron();
			setState(338);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SEP) {
				{
				{
				setState(334);
				match(SEP);
				setState(335);
				ruleenviron();
				}
				}
				setState(340);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(341);
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
		enterRule(_localctx, 40, RULE_ruleenviron);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(346);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,37,_ctx) ) {
			case 1:
				{
				setState(343);
				boundarybefore();
				setState(344);
				match(WHITESPACE);
				}
				break;
			}
			setState(351);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OPAREN) | (1L << NULL) | (1L << MATSTART) | (1L << LISTSTART) | (1L << WORDBOUNDARY) | (1L << CLASSREF) | (1L << FEATURE) | (1L << VALUE) | (1L << STR1) | (1L << STR))) != 0)) {
				{
				setState(348);
				rulebefore();
				setState(349);
				match(WHITESPACE);
				}
			}

			setState(353);
			match(ANCHOR);
			setState(356);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,39,_ctx) ) {
			case 1:
				{
				setState(354);
				match(WHITESPACE);
				setState(355);
				ruleafter();
				}
				break;
			}
			setState(360);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WHITESPACE) {
				{
				setState(358);
				match(WHITESPACE);
				setState(359);
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
		enterRule(_localctx, 42, RULE_boundarybefore);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(362);
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
		enterRule(_localctx, 44, RULE_boundaryafter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(364);
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
		enterRule(_localctx, 46, RULE_rulebefore);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(366);
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
		enterRule(_localctx, 48, RULE_ruleafter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(368);
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
		enterRule(_localctx, 50, RULE_ruleelement);
		try {
			setState(376);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,41,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(370);
				rulecapture();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(371);
				rulerepeater();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(372);
				rulegroup();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(373);
				rulelist();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(374);
				simpleelement();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(375);
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
		enterRule(_localctx, 52, RULE_rulesequence);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(378);
			sequenceelement();
			setState(381); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(379);
					match(WHITESPACE);
					setState(380);
					sequenceelement();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(383); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,42,_ctx);
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
		enterRule(_localctx, 54, RULE_sequenceelement);
		try {
			setState(390);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,43,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(385);
				rulecapture();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(386);
				rulerepeater();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(387);
				rulegroup();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(388);
				rulelist();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(389);
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
		enterRule(_localctx, 56, RULE_rulecapture);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(396);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OPAREN:
				{
				setState(392);
				rulegroup();
				}
				break;
			case LISTSTART:
				{
				setState(393);
				rulelist();
				}
				break;
			case CLASSREF:
				{
				setState(394);
				classref();
				}
				break;
			case MATSTART:
				{
				setState(395);
				fancymatrix();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(398);
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
		enterRule(_localctx, 58, RULE_rulerepeater);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(403);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OPAREN:
				{
				setState(400);
				rulegroup();
				}
				break;
			case LISTSTART:
				{
				setState(401);
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
				setState(402);
				simpleelement();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(405);
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
		enterRule(_localctx, 60, RULE_rulegroup);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(407);
			match(OPAREN);
			setState(408);
			ruleelement();
			setState(409);
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
		enterRule(_localctx, 62, RULE_rulelist);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(411);
			match(LISTSTART);
			setState(412);
			ruleelement();
			setState(417);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SEP) {
				{
				{
				setState(413);
				match(SEP);
				setState(414);
				ruleelement();
				}
				}
				setState(419);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(420);
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
		enterRule(_localctx, 64, RULE_simpleelement);
		try {
			setState(427);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CLASSREF:
				enterOuterAlt(_localctx, 1);
				{
				setState(422);
				classref();
				}
				break;
			case WORDBOUNDARY:
				enterOuterAlt(_localctx, 2);
				{
				setState(423);
				captureref();
				}
				break;
			case MATSTART:
				enterOuterAlt(_localctx, 3);
				{
				setState(424);
				fancymatrix();
				}
				break;
			case NULL:
				enterOuterAlt(_localctx, 4);
				{
				setState(425);
				empty();
				}
				break;
			case FEATURE:
			case VALUE:
			case STR1:
			case STR:
				enterOuterAlt(_localctx, 5);
				{
				setState(426);
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
		enterRule(_localctx, 66, RULE_classref);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(429);
			match(CLASSREF);
			setState(430);
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
		enterRule(_localctx, 68, RULE_captureref);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(432);
			match(WORDBOUNDARY);
			setState(433);
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
		enterRule(_localctx, 70, RULE_fancymatrix);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(435);
			match(MATSTART);
			setState(437);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NULL) | (1L << NEGATION) | (1L << WORDBOUNDARY) | (1L << VALUE))) != 0)) {
				{
				setState(436);
				fancyvalue();
				}
			}

			setState(443);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WHITESPACE) {
				{
				{
				setState(439);
				match(WHITESPACE);
				setState(440);
				fancyvalue();
				}
				}
				setState(445);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(446);
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
		enterRule(_localctx, 72, RULE_fancyvalue);
		try {
			setState(452);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VALUE:
				enterOuterAlt(_localctx, 1);
				{
				setState(448);
				value();
				}
				break;
			case NEGATION:
				enterOuterAlt(_localctx, 2);
				{
				setState(449);
				negvalue();
				}
				break;
			case NULL:
				enterOuterAlt(_localctx, 3);
				{
				setState(450);
				absentfeature();
				}
				break;
			case WORDBOUNDARY:
				enterOuterAlt(_localctx, 4);
				{
				setState(451);
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
		enterRule(_localctx, 74, RULE_negvalue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(454);
			match(NEGATION);
			setState(455);
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
		enterRule(_localctx, 76, RULE_absentfeature);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(457);
			match(NULL);
			setState(458);
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
		enterRule(_localctx, 78, RULE_featurevariable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(460);
			match(WORDBOUNDARY);
			setState(461);
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
		enterRule(_localctx, 80, RULE_empty);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(463);
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
		enterRule(_localctx, 82, RULE_repeatertype);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(465);
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
		enterRule(_localctx, 84, RULE_matrix);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(467);
			match(MATSTART);
			setState(469);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==VALUE) {
				{
				setState(468);
				value();
				}
			}

			setState(475);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WHITESPACE) {
				{
				{
				setState(471);
				match(WHITESPACE);
				setState(472);
				value();
				}
				}
				setState(477);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(478);
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
		enterRule(_localctx, 86, RULE_feature);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(480);
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
		enterRule(_localctx, 88, RULE_value);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(482);
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
		enterRule(_localctx, 90, RULE_text);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(484);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\'\u01e9\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\3\2\3\2\6\2a\n\2\r\2\16\2b\7\2e\n\2\f\2\16\2h\13"+
		"\2\3\2\3\2\6\2l\n\2\r\2\16\2m\7\2p\n\2\f\2\16\2s\13\2\3\2\3\2\6\2w\n\2"+
		"\r\2\16\2x\7\2{\n\2\f\2\16\2~\13\2\3\2\3\2\6\2\u0082\n\2\r\2\16\2\u0083"+
		"\7\2\u0086\n\2\f\2\16\2\u0089\13\2\3\2\3\2\6\2\u008d\n\2\r\2\16\2\u008e"+
		"\5\2\u0091\n\2\3\2\5\2\u0094\n\2\3\2\6\2\u0097\n\2\r\2\16\2\u0098\3\2"+
		"\3\2\5\2\u009d\n\2\7\2\u009f\n\2\f\2\16\2\u00a2\13\2\3\2\6\2\u00a5\n\2"+
		"\r\2\16\2\u00a6\3\2\5\2\u00aa\n\2\3\2\6\2\u00ad\n\2\r\2\16\2\u00ae\3\2"+
		"\5\2\u00b2\n\2\3\2\5\2\u00b5\n\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\7\3\u00c1\n\3\f\3\16\3\u00c4\13\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\5\4\u00cf\n\4\3\4\3\4\3\4\7\4\u00d4\n\4\f\4\16\4\u00d7\13\4\3\4\3\4"+
		"\3\4\5\4\u00dc\n\4\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\5\6\u00e7\n\6\3"+
		"\6\3\6\5\6\u00eb\n\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\7\7\u00f4\n\7\f\7\16"+
		"\7\u00f7\13\7\3\7\3\7\5\7\u00fb\n\7\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\n\3"+
		"\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\5\f\u0113"+
		"\n\f\3\f\3\f\5\f\u0117\n\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\7\r"+
		"\u0123\n\r\f\r\16\r\u0126\13\r\3\16\3\16\3\16\7\16\u012b\n\16\f\16\16"+
		"\16\u012e\13\16\3\17\3\17\3\17\7\17\u0133\n\17\f\17\16\17\u0136\13\17"+
		"\3\20\3\20\3\20\3\20\3\20\5\20\u013d\n\20\3\20\3\20\5\20\u0141\n\20\3"+
		"\21\3\21\5\21\u0145\n\21\3\22\3\22\5\22\u0149\n\22\3\23\3\23\3\24\3\24"+
		"\3\25\3\25\3\25\3\25\7\25\u0153\n\25\f\25\16\25\u0156\13\25\3\25\3\25"+
		"\3\26\3\26\3\26\5\26\u015d\n\26\3\26\3\26\3\26\5\26\u0162\n\26\3\26\3"+
		"\26\3\26\5\26\u0167\n\26\3\26\3\26\5\26\u016b\n\26\3\27\3\27\3\30\3\30"+
		"\3\31\3\31\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\33\5\33\u017b\n\33\3\34"+
		"\3\34\3\34\6\34\u0180\n\34\r\34\16\34\u0181\3\35\3\35\3\35\3\35\3\35\5"+
		"\35\u0189\n\35\3\36\3\36\3\36\3\36\5\36\u018f\n\36\3\36\3\36\3\37\3\37"+
		"\3\37\5\37\u0196\n\37\3\37\3\37\3 \3 \3 \3 \3!\3!\3!\3!\7!\u01a2\n!\f"+
		"!\16!\u01a5\13!\3!\3!\3\"\3\"\3\"\3\"\3\"\5\"\u01ae\n\"\3#\3#\3#\3$\3"+
		"$\3$\3%\3%\5%\u01b8\n%\3%\3%\7%\u01bc\n%\f%\16%\u01bf\13%\3%\3%\3&\3&"+
		"\3&\3&\5&\u01c7\n&\3\'\3\'\3\'\3(\3(\3(\3)\3)\3)\3*\3*\3+\3+\3,\3,\5,"+
		"\u01d8\n,\3,\3,\7,\u01dc\n,\f,\16,\u01df\13,\3,\3,\3-\3-\3.\3.\3/\3/\3"+
		"/\2\2\60\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668"+
		":<>@BDFHJLNPRTVXZ\\\2\5\3\2\t\n\4\2\r\r\22\23\4\2#$&\'\2\u01fe\2f\3\2"+
		"\2\2\4\u00b8\3\2\2\2\6\u00c7\3\2\2\2\b\u00dd\3\2\2\2\n\u00e0\3\2\2\2\f"+
		"\u00ee\3\2\2\2\16\u00fc\3\2\2\2\20\u00fe\3\2\2\2\22\u0103\3\2\2\2\24\u0108"+
		"\3\2\2\2\26\u010f\3\2\2\2\30\u011c\3\2\2\2\32\u0127\3\2\2\2\34\u012f\3"+
		"\2\2\2\36\u0137\3\2\2\2 \u0144\3\2\2\2\"\u0148\3\2\2\2$\u014a\3\2\2\2"+
		"&\u014c\3\2\2\2(\u014e\3\2\2\2*\u015c\3\2\2\2,\u016c\3\2\2\2.\u016e\3"+
		"\2\2\2\60\u0170\3\2\2\2\62\u0172\3\2\2\2\64\u017a\3\2\2\2\66\u017c\3\2"+
		"\2\28\u0188\3\2\2\2:\u018e\3\2\2\2<\u0195\3\2\2\2>\u0199\3\2\2\2@\u019d"+
		"\3\2\2\2B\u01ad\3\2\2\2D\u01af\3\2\2\2F\u01b2\3\2\2\2H\u01b5\3\2\2\2J"+
		"\u01c6\3\2\2\2L\u01c8\3\2\2\2N\u01cb\3\2\2\2P\u01ce\3\2\2\2R\u01d1\3\2"+
		"\2\2T\u01d3\3\2\2\2V\u01d5\3\2\2\2X\u01e2\3\2\2\2Z\u01e4\3\2\2\2\\\u01e6"+
		"\3\2\2\2^`\5\6\4\2_a\7\t\2\2`_\3\2\2\2ab\3\2\2\2b`\3\2\2\2bc\3\2\2\2c"+
		"e\3\2\2\2d^\3\2\2\2eh\3\2\2\2fd\3\2\2\2fg\3\2\2\2gq\3\2\2\2hf\3\2\2\2"+
		"ik\5\n\6\2jl\7\t\2\2kj\3\2\2\2lm\3\2\2\2mk\3\2\2\2mn\3\2\2\2np\3\2\2\2"+
		"oi\3\2\2\2ps\3\2\2\2qo\3\2\2\2qr\3\2\2\2r|\3\2\2\2sq\3\2\2\2tv\5\f\7\2"+
		"uw\7\t\2\2vu\3\2\2\2wx\3\2\2\2xv\3\2\2\2xy\3\2\2\2y{\3\2\2\2zt\3\2\2\2"+
		"{~\3\2\2\2|z\3\2\2\2|}\3\2\2\2}\u0087\3\2\2\2~|\3\2\2\2\177\u0081\5\4"+
		"\3\2\u0080\u0082\7\t\2\2\u0081\u0080\3\2\2\2\u0082\u0083\3\2\2\2\u0083"+
		"\u0081\3\2\2\2\u0083\u0084\3\2\2\2\u0084\u0086\3\2\2\2\u0085\177\3\2\2"+
		"\2\u0086\u0089\3\2\2\2\u0087\u0085\3\2\2\2\u0087\u0088\3\2\2\2\u0088\u0090"+
		"\3\2\2\2\u0089\u0087\3\2\2\2\u008a\u008c\5\20\t\2\u008b\u008d\7\t\2\2"+
		"\u008c\u008b\3\2\2\2\u008d\u008e\3\2\2\2\u008e\u008c\3\2\2\2\u008e\u008f"+
		"\3\2\2\2\u008f\u0091\3\2\2\2\u0090\u008a\3\2\2\2\u0090\u0091\3\2\2\2\u0091"+
		"\u0093\3\2\2\2\u0092\u0094\5\26\f\2\u0093\u0092\3\2\2\2\u0093\u0094\3"+
		"\2\2\2\u0094\u00a9\3\2\2\2\u0095\u0097\7\t\2\2\u0096\u0095\3\2\2\2\u0097"+
		"\u0098\3\2\2\2\u0098\u0096\3\2\2\2\u0098\u0099\3\2\2\2\u0099\u009c\3\2"+
		"\2\2\u009a\u009d\5\26\f\2\u009b\u009d\5\24\13\2\u009c\u009a\3\2\2\2\u009c"+
		"\u009b\3\2\2\2\u009d\u009f\3\2\2\2\u009e\u0096\3\2\2\2\u009f\u00a2\3\2"+
		"\2\2\u00a0\u009e\3\2\2\2\u00a0\u00a1\3\2\2\2\u00a1\u00a4\3\2\2\2\u00a2"+
		"\u00a0\3\2\2\2\u00a3\u00a5\7\t\2\2\u00a4\u00a3\3\2\2\2\u00a5\u00a6\3\2"+
		"\2\2\u00a6\u00a4\3\2\2\2\u00a6\u00a7\3\2\2\2\u00a7\u00a8\3\2\2\2\u00a8"+
		"\u00aa\5\26\f\2\u00a9\u00a0\3\2\2\2\u00a9\u00aa\3\2\2\2\u00aa\u00b1\3"+
		"\2\2\2\u00ab\u00ad\7\t\2\2\u00ac\u00ab\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ae"+
		"\u00ac\3\2\2\2\u00ae\u00af\3\2\2\2\u00af\u00b0\3\2\2\2\u00b0\u00b2\5\22"+
		"\n\2\u00b1\u00ac\3\2\2\2\u00b1\u00b2\3\2\2\2\u00b2\u00b4\3\2\2\2\u00b3"+
		"\u00b5\7\t\2\2\u00b4\u00b3\3\2\2\2\u00b4\u00b5\3\2\2\2\u00b5\u00b6\3\2"+
		"\2\2\u00b6\u00b7\7\2\2\3\u00b7\3\3\2\2\2\u00b8\u00b9\7\31\2\2\u00b9\u00ba"+
		"\7\n\2\2\u00ba\u00bb\5Z.\2\u00bb\u00bc\7\n\2\2\u00bc\u00bd\7\20\2\2\u00bd"+
		"\u00c2\5\\/\2\u00be\u00bf\7\4\2\2\u00bf\u00c1\5\\/\2\u00c0\u00be\3\2\2"+
		"\2\u00c1\u00c4\3\2\2\2\u00c2\u00c0\3\2\2\2\u00c2\u00c3\3\2\2\2\u00c3\u00c5"+
		"\3\2\2\2\u00c4\u00c2\3\2\2\2\u00c5\u00c6\7\21\2\2\u00c6\5\3\2\2\2\u00c7"+
		"\u00c8\7\32\2\2\u00c8\u00c9\7\n\2\2\u00c9\u00ca\5X-\2\u00ca\u00ce\7\13"+
		"\2\2\u00cb\u00cc\5\b\5\2\u00cc\u00cd\7\4\2\2\u00cd\u00cf\3\2\2\2\u00ce"+
		"\u00cb\3\2\2\2\u00ce\u00cf\3\2\2\2\u00cf\u00d0\3\2\2\2\u00d0\u00d5\5Z"+
		".\2\u00d1\u00d2\7\4\2\2\u00d2\u00d4\5Z.\2\u00d3\u00d1\3\2\2\2\u00d4\u00d7"+
		"\3\2\2\2\u00d5\u00d3\3\2\2\2\u00d5\u00d6\3\2\2\2\u00d6\u00d8\3\2\2\2\u00d7"+
		"\u00d5\3\2\2\2\u00d8\u00db\7\f\2\2\u00d9\u00da\7\5\2\2\u00da\u00dc\5V"+
		",\2\u00db\u00d9\3\2\2\2\u00db\u00dc\3\2\2\2\u00dc\7\3\2\2\2\u00dd\u00de"+
		"\7\r\2\2\u00de\u00df\5Z.\2\u00df\t\3\2\2\2\u00e0\u00e1\7\33\2\2\u00e1"+
		"\u00e2\7\n\2\2\u00e2\u00e3\7&\2\2\u00e3\u00e6\7\n\2\2\u00e4\u00e5\7\34"+
		"\2\2\u00e5\u00e7\7\n\2\2\u00e6\u00e4\3\2\2\2\u00e6\u00e7\3\2\2\2\u00e7"+
		"\u00ea\3\2\2\2\u00e8\u00e9\7\35\2\2\u00e9\u00eb\7\n\2\2\u00ea\u00e8\3"+
		"\2\2\2\u00ea\u00eb\3\2\2\2\u00eb\u00ec\3\2\2\2\u00ec\u00ed\5V,\2\u00ed"+
		"\13\3\2\2\2\u00ee\u00ef\7\36\2\2\u00ef\u00f0\7\n\2\2\u00f0\u00fa\5\16"+
		"\b\2\u00f1\u00f2\7\4\2\2\u00f2\u00f4\5\16\b\2\u00f3\u00f1\3\2\2\2\u00f4"+
		"\u00f7\3\2\2\2\u00f5\u00f3\3\2\2\2\u00f5\u00f6\3\2\2\2\u00f6\u00fb\3\2"+
		"\2\2\u00f7\u00f5\3\2\2\2\u00f8\u00f9\7\n\2\2\u00f9\u00fb\5V,\2\u00fa\u00f5"+
		"\3\2\2\2\u00fa\u00f8\3\2\2\2\u00fb\r\3\2\2\2\u00fc\u00fd\5\\/\2\u00fd"+
		"\17\3\2\2\2\u00fe\u00ff\7\37\2\2\u00ff\u0100\7\25\2\2\u0100\u0101\7\t"+
		"\2\2\u0101\u0102\5\30\r\2\u0102\21\3\2\2\2\u0103\u0104\7 \2\2\u0104\u0105"+
		"\7\25\2\2\u0105\u0106\7\t\2\2\u0106\u0107\5\30\r\2\u0107\23\3\2\2\2\u0108"+
		"\u0109\7 \2\2\u0109\u010a\7\24\2\2\u010a\u010b\5\34\17\2\u010b\u010c\7"+
		"\25\2\2\u010c\u010d\7\t\2\2\u010d\u010e\5\30\r\2\u010e\25\3\2\2\2\u010f"+
		"\u0112\5\34\17\2\u0110\u0111\7\n\2\2\u0111\u0113\5V,\2\u0112\u0110\3\2"+
		"\2\2\u0112\u0113\3\2\2\2\u0113\u0116\3\2\2\2\u0114\u0115\7\n\2\2\u0115"+
		"\u0117\7\"\2\2\u0116\u0114\3\2\2\2\u0116\u0117\3\2\2\2\u0117\u0118\3\2"+
		"\2\2\u0118\u0119\7\25\2\2\u0119\u011a\7\t\2\2\u011a\u011b\5\30\r\2\u011b"+
		"\27\3\2\2\2\u011c\u0124\5\32\16\2\u011d\u011e\7\t\2\2\u011e\u011f\7!\2"+
		"\2\u011f\u0120\7\25\2\2\u0120\u0121\t\2\2\2\u0121\u0123\5\32\16\2\u0122"+
		"\u011d\3\2\2\2\u0123\u0126\3\2\2\2\u0124\u0122\3\2\2\2\u0124\u0125\3\2"+
		"\2\2\u0125\31\3\2\2\2\u0126\u0124\3\2\2\2\u0127\u012c\5\36\20\2\u0128"+
		"\u0129\7\t\2\2\u0129\u012b\5\36\20\2\u012a\u0128\3\2\2\2\u012b\u012e\3"+
		"\2\2\2\u012c\u012a\3\2\2\2\u012c\u012d\3\2\2\2\u012d\33\3\2\2\2\u012e"+
		"\u012c\3\2\2\2\u012f\u0134\7$\2\2\u0130\u0131\7\24\2\2\u0131\u0133\7$"+
		"\2\2\u0132\u0130\3\2\2\2\u0133\u0136\3\2\2\2\u0134\u0132\3\2\2\2\u0134"+
		"\u0135\3\2\2\2\u0135\35\3\2\2\2\u0136\u0134\3\2\2\2\u0137\u0138\5$\23"+
		"\2\u0138\u0139\7\5\2\2\u0139\u013c\5&\24\2\u013a\u013b\7\6\2\2\u013b\u013d"+
		"\5 \21\2\u013c\u013a\3\2\2\2\u013c\u013d\3\2\2\2\u013d\u0140\3\2\2\2\u013e"+
		"\u013f\7\7\2\2\u013f\u0141\5\"\22\2\u0140\u013e\3\2\2\2\u0140\u0141\3"+
		"\2\2\2\u0141\37\3\2\2\2\u0142\u0145\5*\26\2\u0143\u0145\5(\25\2\u0144"+
		"\u0142\3\2\2\2\u0144\u0143\3\2\2\2\u0145!\3\2\2\2\u0146\u0149\5*\26\2"+
		"\u0147\u0149\5(\25\2\u0148\u0146\3\2\2\2\u0148\u0147\3\2\2\2\u0149#\3"+
		"\2\2\2\u014a\u014b\5\64\33\2\u014b%\3\2\2\2\u014c\u014d\5\64\33\2\u014d"+
		"\'\3\2\2\2\u014e\u014f\7\20\2\2\u014f\u0154\5*\26\2\u0150\u0151\7\4\2"+
		"\2\u0151\u0153\5*\26\2\u0152\u0150\3\2\2\2\u0153\u0156\3\2\2\2\u0154\u0152"+
		"\3\2\2\2\u0154\u0155\3\2\2\2\u0155\u0157\3\2\2\2\u0156\u0154\3\2\2\2\u0157"+
		"\u0158\7\21\2\2\u0158)\3\2\2\2\u0159\u015a\5,\27\2\u015a\u015b\7\n\2\2"+
		"\u015b\u015d\3\2\2\2\u015c\u0159\3\2\2\2\u015c\u015d\3\2\2\2\u015d\u0161"+
		"\3\2\2\2\u015e\u015f\5\60\31\2\u015f\u0160\7\n\2\2\u0160\u0162\3\2\2\2"+
		"\u0161\u015e\3\2\2\2\u0161\u0162\3\2\2\2\u0162\u0163\3\2\2\2\u0163\u0166"+
		"\7\b\2\2\u0164\u0165\7\n\2\2\u0165\u0167\5\62\32\2\u0166\u0164\3\2\2\2"+
		"\u0166\u0167\3\2\2\2\u0167\u016a\3\2\2\2\u0168\u0169\7\n\2\2\u0169\u016b"+
		"\5.\30\2\u016a\u0168\3\2\2\2\u016a\u016b\3\2\2\2\u016b+\3\2\2\2\u016c"+
		"\u016d\7\27\2\2\u016d-\3\2\2\2\u016e\u016f\7\27\2\2\u016f/\3\2\2\2\u0170"+
		"\u0171\5\64\33\2\u0171\61\3\2\2\2\u0172\u0173\5\64\33\2\u0173\63\3\2\2"+
		"\2\u0174\u017b\5:\36\2\u0175\u017b\5<\37\2\u0176\u017b\5> \2\u0177\u017b"+
		"\5@!\2\u0178\u017b\5B\"\2\u0179\u017b\5\66\34\2\u017a\u0174\3\2\2\2\u017a"+
		"\u0175\3\2\2\2\u017a\u0176\3\2\2\2\u017a\u0177\3\2\2\2\u017a\u0178\3\2"+
		"\2\2\u017a\u0179\3\2\2\2\u017b\65\3\2\2\2\u017c\u017f\58\35\2\u017d\u017e"+
		"\7\n\2\2\u017e\u0180\58\35\2\u017f\u017d\3\2\2\2\u0180\u0181\3\2\2\2\u0181"+
		"\u017f\3\2\2\2\u0181\u0182\3\2\2\2\u0182\67\3\2\2\2\u0183\u0189\5:\36"+
		"\2\u0184\u0189\5<\37\2\u0185\u0189\5> \2\u0186\u0189\5@!\2\u0187\u0189"+
		"\5B\"\2\u0188\u0183\3\2\2\2\u0188\u0184\3\2\2\2\u0188\u0185\3\2\2\2\u0188"+
		"\u0186\3\2\2\2\u0188\u0187\3\2\2\2\u01899\3\2\2\2\u018a\u018f\5> \2\u018b"+
		"\u018f\5@!\2\u018c\u018f\5D#\2\u018d\u018f\5H%\2\u018e\u018a\3\2\2\2\u018e"+
		"\u018b\3\2\2\2\u018e\u018c\3\2\2\2\u018e\u018d\3\2\2\2\u018f\u0190\3\2"+
		"\2\2\u0190\u0191\5F$\2\u0191;\3\2\2\2\u0192\u0196\5> \2\u0193\u0196\5"+
		"@!\2\u0194\u0196\5B\"\2\u0195\u0192\3\2\2\2\u0195\u0193\3\2\2\2\u0195"+
		"\u0194\3\2\2\2\u0196\u0197\3\2\2\2\u0197\u0198\5T+\2\u0198=\3\2\2\2\u0199"+
		"\u019a\7\13\2\2\u019a\u019b\5\64\33\2\u019b\u019c\7\f\2\2\u019c?\3\2\2"+
		"\2\u019d\u019e\7\20\2\2\u019e\u01a3\5\64\33\2\u019f\u01a0\7\4\2\2\u01a0"+
		"\u01a2\5\64\33\2\u01a1\u019f\3\2\2\2\u01a2\u01a5\3\2\2\2\u01a3\u01a1\3"+
		"\2\2\2\u01a3\u01a4\3\2\2\2\u01a4\u01a6\3\2\2\2\u01a5\u01a3\3\2\2\2\u01a6"+
		"\u01a7\7\21\2\2\u01a7A\3\2\2\2\u01a8\u01ae\5D#\2\u01a9\u01ae\5F$\2\u01aa"+
		"\u01ae\5H%\2\u01ab\u01ae\5R*\2\u01ac\u01ae\5\\/\2\u01ad\u01a8\3\2\2\2"+
		"\u01ad\u01a9\3\2\2\2\u01ad\u01aa\3\2\2\2\u01ad\u01ab\3\2\2\2\u01ad\u01ac"+
		"\3\2\2\2\u01aeC\3\2\2\2\u01af\u01b0\7\30\2\2\u01b0\u01b1\5Z.\2\u01b1E"+
		"\3\2\2\2\u01b2\u01b3\7\27\2\2\u01b3\u01b4\7%\2\2\u01b4G\3\2\2\2\u01b5"+
		"\u01b7\7\16\2\2\u01b6\u01b8\5J&\2\u01b7\u01b6\3\2\2\2\u01b7\u01b8\3\2"+
		"\2\2\u01b8\u01bd\3\2\2\2\u01b9\u01ba\7\n\2\2\u01ba\u01bc\5J&\2\u01bb\u01b9"+
		"\3\2\2\2\u01bc\u01bf\3\2\2\2\u01bd\u01bb\3\2\2\2\u01bd\u01be\3\2\2\2\u01be"+
		"\u01c0\3\2\2\2\u01bf\u01bd\3\2\2\2\u01c0\u01c1\7\17\2\2\u01c1I\3\2\2\2"+
		"\u01c2\u01c7\5Z.\2\u01c3\u01c7\5L\'\2\u01c4\u01c7\5N(\2\u01c5\u01c7\5"+
		"P)\2\u01c6\u01c2\3\2\2\2\u01c6\u01c3\3\2\2\2\u01c6\u01c4\3\2\2\2\u01c6"+
		"\u01c5\3\2\2\2\u01c7K\3\2\2\2\u01c8\u01c9\7\26\2\2\u01c9\u01ca\5Z.\2\u01ca"+
		"M\3\2\2\2\u01cb\u01cc\7\r\2\2\u01cc\u01cd\5X-\2\u01cdO\3\2\2\2\u01ce\u01cf"+
		"\7\27\2\2\u01cf\u01d0\5X-\2\u01d0Q\3\2\2\2\u01d1\u01d2\7\r\2\2\u01d2S"+
		"\3\2\2\2\u01d3\u01d4\t\3\2\2\u01d4U\3\2\2\2\u01d5\u01d7\7\16\2\2\u01d6"+
		"\u01d8\5Z.\2\u01d7\u01d6\3\2\2\2\u01d7\u01d8\3\2\2\2\u01d8\u01dd\3\2\2"+
		"\2\u01d9\u01da\7\n\2\2\u01da\u01dc\5Z.\2\u01db\u01d9\3\2\2\2\u01dc\u01df"+
		"\3\2\2\2\u01dd\u01db\3\2\2\2\u01dd\u01de\3\2\2\2\u01de\u01e0\3\2\2\2\u01df"+
		"\u01dd\3\2\2\2\u01e0\u01e1\7\17\2\2\u01e1W\3\2\2\2\u01e2\u01e3\7#\2\2"+
		"\u01e3Y\3\2\2\2\u01e4\u01e5\7$\2\2\u01e5[\3\2\2\2\u01e6\u01e7\t\4\2\2"+
		"\u01e7]\3\2\2\2\67bfmqx|\u0083\u0087\u008e\u0090\u0093\u0098\u009c\u00a0"+
		"\u00a6\u00a9\u00ae\u00b1\u00b4\u00c2\u00ce\u00d5\u00db\u00e6\u00ea\u00f5"+
		"\u00fa\u0112\u0116\u0124\u012c\u0134\u013c\u0140\u0144\u0148\u0154\u015c"+
		"\u0161\u0166\u016a\u017a\u0181\u0188\u018e\u0195\u01a3\u01ad\u01b7\u01bd"+
		"\u01c6\u01d7\u01dd";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}