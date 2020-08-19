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
		RULE_lscfile = 0, RULE_classdecl = 1, RULE_classelement = 2, RULE_featuredecl = 3, 
		RULE_nullalias = 4, RULE_diacritic = 5, RULE_symbol = 6, RULE_symbolname = 7, 
		RULE_deromanizer = 8, RULE_romanizer = 9, RULE_interromanizer = 10, RULE_changerule = 11, 
		RULE_subrules = 12, RULE_subrule = 13, RULE_rulename = 14, RULE_ruleexpression = 15, 
		RULE_condition = 16, RULE_exclusion = 17, RULE_rulefrom = 18, RULE_ruleto = 19, 
		RULE_environlist = 20, RULE_ruleenviron = 21, RULE_boundarybefore = 22, 
		RULE_boundaryafter = 23, RULE_rulebefore = 24, RULE_ruleafter = 25, RULE_ruleelement = 26, 
		RULE_rulesequence = 27, RULE_sequenceelement = 28, RULE_rulecapture = 29, 
		RULE_rulerepeater = 30, RULE_rulegroup = 31, RULE_rulelist = 32, RULE_simpleelement = 33, 
		RULE_negelement = 34, RULE_classref = 35, RULE_captureref = 36, RULE_fancymatrix = 37, 
		RULE_fancyvalue = 38, RULE_negvalue = 39, RULE_absentfeature = 40, RULE_featurevariable = 41, 
		RULE_empty = 42, RULE_repeatertype = 43, RULE_matrix = 44, RULE_feature = 45, 
		RULE_value = 46, RULE_text = 47;
	private static String[] makeRuleNames() {
		return new String[] {
			"lscfile", "classdecl", "classelement", "featuredecl", "nullalias", "diacritic", 
			"symbol", "symbolname", "deromanizer", "romanizer", "interromanizer", 
			"changerule", "subrules", "subrule", "rulename", "ruleexpression", "condition", 
			"exclusion", "rulefrom", "ruleto", "environlist", "ruleenviron", "boundarybefore", 
			"boundaryafter", "rulebefore", "ruleafter", "ruleelement", "rulesequence", 
			"sequenceelement", "rulecapture", "rulerepeater", "rulegroup", "rulelist", 
			"simpleelement", "negelement", "classref", "captureref", "fancymatrix", 
			"fancyvalue", "negvalue", "absentfeature", "featurevariable", "empty", 
			"repeatertype", "matrix", "feature", "value", "text"
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
			setState(104);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==FEATUREDECL) {
				{
				{
				setState(96);
				featuredecl();
				setState(98); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(97);
						match(NEWLINE);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(100); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				}
				setState(106);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(115);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DIACRITIC) {
				{
				{
				setState(107);
				diacritic();
				setState(109); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(108);
						match(NEWLINE);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(111); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				}
				setState(117);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(126);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SYMBOL) {
				{
				{
				setState(118);
				symbol();
				setState(120); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(119);
						match(NEWLINE);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(122); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				}
				setState(128);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(137);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CLASSDECL) {
				{
				{
				setState(129);
				classdecl();
				setState(131); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(130);
						match(NEWLINE);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(133); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				}
				setState(139);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(146);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DEROMANIZER) {
				{
				setState(140);
				deromanizer();
				setState(142); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(141);
						match(NEWLINE);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(144); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
			}

			setState(149);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==VALUE) {
				{
				setState(148);
				changerule();
				}
			}

			setState(171);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				{
				setState(162);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(152); 
						_errHandler.sync(this);
						_la = _input.LA(1);
						do {
							{
							{
							setState(151);
							match(NEWLINE);
							}
							}
							setState(154); 
							_errHandler.sync(this);
							_la = _input.LA(1);
						} while ( _la==NEWLINE );
						setState(158);
						_errHandler.sync(this);
						switch (_input.LA(1)) {
						case VALUE:
							{
							setState(156);
							changerule();
							}
							break;
						case ROMANIZER:
							{
							setState(157);
							interromanizer();
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						}
						} 
					}
					setState(164);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
				}
				setState(166); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(165);
					match(NEWLINE);
					}
					}
					setState(168); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NEWLINE );
				setState(170);
				changerule();
				}
				break;
			}
			setState(179);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				{
				setState(174); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(173);
					match(NEWLINE);
					}
					}
					setState(176); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NEWLINE );
				setState(178);
				romanizer();
				}
				break;
			}
			setState(184);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE) {
				{
				{
				setState(181);
				match(NEWLINE);
				}
				}
				setState(186);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(187);
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
		public List<ClasselementContext> classelement() {
			return getRuleContexts(ClasselementContext.class);
		}
		public ClasselementContext classelement(int i) {
			return getRuleContext(ClasselementContext.class,i);
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
			setState(189);
			match(CLASSDECL);
			setState(190);
			match(WHITESPACE);
			setState(191);
			value();
			setState(192);
			match(WHITESPACE);
			setState(193);
			match(LISTSTART);
			setState(194);
			classelement();
			setState(199);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SEP) {
				{
				{
				setState(195);
				match(SEP);
				setState(196);
				classelement();
				}
				}
				setState(201);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(202);
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
			if ( visitor instanceof LscVisitor ) return ((LscVisitor<? extends T>)visitor).visitClasselement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClasselementContext classelement() throws RecognitionException {
		ClasselementContext _localctx = new ClasselementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_classelement);
		try {
			setState(206);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CLASSREF:
				enterOuterAlt(_localctx, 1);
				{
				setState(204);
				classref();
				}
				break;
			case FEATURE:
			case VALUE:
			case STR1:
			case STR:
				enterOuterAlt(_localctx, 2);
				{
				setState(205);
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
		enterRule(_localctx, 6, RULE_featuredecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(208);
			match(FEATUREDECL);
			setState(209);
			match(WHITESPACE);
			setState(210);
			feature();
			setState(211);
			match(OPAREN);
			setState(215);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NULL) {
				{
				setState(212);
				nullalias();
				setState(213);
				match(SEP);
				}
			}

			setState(217);
			value();
			setState(222);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SEP) {
				{
				{
				setState(218);
				match(SEP);
				setState(219);
				value();
				}
				}
				setState(224);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(225);
			match(CPAREN);
			setState(228);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CHANGE) {
				{
				setState(226);
				match(CHANGE);
				setState(227);
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
		enterRule(_localctx, 8, RULE_nullalias);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(230);
			match(NULL);
			setState(231);
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
		enterRule(_localctx, 10, RULE_diacritic);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(233);
			match(DIACRITIC);
			setState(234);
			match(WHITESPACE);
			setState(235);
			match(STR1);
			setState(236);
			match(WHITESPACE);
			setState(239);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DIABEFORE) {
				{
				setState(237);
				match(DIABEFORE);
				setState(238);
				match(WHITESPACE);
				}
			}

			setState(243);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DIAFLOATING) {
				{
				setState(241);
				match(DIAFLOATING);
				setState(242);
				match(WHITESPACE);
				}
			}

			setState(245);
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
		enterRule(_localctx, 12, RULE_symbol);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(247);
			match(SYMBOL);
			setState(248);
			match(WHITESPACE);
			setState(249);
			symbolname();
			setState(259);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SEP:
			case NEWLINE:
				{
				setState(254);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==SEP) {
					{
					{
					setState(250);
					match(SEP);
					setState(251);
					symbolname();
					}
					}
					setState(256);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case WHITESPACE:
				{
				setState(257);
				match(WHITESPACE);
				setState(258);
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
		enterRule(_localctx, 14, RULE_symbolname);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(261);
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
		enterRule(_localctx, 16, RULE_deromanizer);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(263);
			match(DEROMANIZER);
			setState(264);
			match(RULESTART);
			setState(265);
			match(NEWLINE);
			setState(266);
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
		enterRule(_localctx, 18, RULE_romanizer);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(268);
			match(ROMANIZER);
			setState(269);
			match(RULESTART);
			setState(270);
			match(NEWLINE);
			setState(271);
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
		enterRule(_localctx, 20, RULE_interromanizer);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(273);
			match(ROMANIZER);
			setState(274);
			match(HYPHEN);
			setState(275);
			rulename();
			setState(276);
			match(RULESTART);
			setState(277);
			match(NEWLINE);
			setState(278);
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
		enterRule(_localctx, 22, RULE_changerule);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(280);
			rulename();
			setState(283);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
			case 1:
				{
				setState(281);
				match(WHITESPACE);
				setState(282);
				matrix();
				}
				break;
			}
			setState(287);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WHITESPACE) {
				{
				setState(285);
				match(WHITESPACE);
				setState(286);
				match(PROPAGATE);
				}
			}

			setState(289);
			match(RULESTART);
			setState(290);
			match(NEWLINE);
			setState(291);
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
		enterRule(_localctx, 24, RULE_subrules);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(293);
			subrule();
			setState(301);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,30,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(294);
					match(NEWLINE);
					setState(295);
					match(SUBRULE);
					setState(296);
					match(RULESTART);
					setState(297);
					_la = _input.LA(1);
					if ( !(_la==NEWLINE || _la==WHITESPACE) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(298);
					subrule();
					}
					} 
				}
				setState(303);
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
		enterRule(_localctx, 26, RULE_subrule);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(304);
			ruleexpression();
			setState(309);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(305);
					match(NEWLINE);
					setState(306);
					ruleexpression();
					}
					} 
				}
				setState(311);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
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
		enterRule(_localctx, 28, RULE_rulename);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(312);
			match(VALUE);
			setState(317);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==HYPHEN) {
				{
				{
				setState(313);
				match(HYPHEN);
				setState(314);
				match(VALUE);
				}
				}
				setState(319);
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
		enterRule(_localctx, 30, RULE_ruleexpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(320);
			rulefrom();
			setState(321);
			match(CHANGE);
			setState(322);
			ruleto();
			setState(325);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CONDITION) {
				{
				setState(323);
				match(CONDITION);
				setState(324);
				condition();
				}
			}

			setState(329);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EXCLUSION) {
				{
				setState(327);
				match(EXCLUSION);
				setState(328);
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
		enterRule(_localctx, 32, RULE_condition);
		try {
			setState(333);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(331);
				ruleenviron();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(332);
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
		enterRule(_localctx, 34, RULE_exclusion);
		try {
			setState(337);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,36,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(335);
				ruleenviron();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(336);
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
		enterRule(_localctx, 36, RULE_rulefrom);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(339);
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
		enterRule(_localctx, 38, RULE_ruleto);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(341);
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
		enterRule(_localctx, 40, RULE_environlist);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(343);
			match(LISTSTART);
			setState(344);
			ruleenviron();
			setState(349);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SEP) {
				{
				{
				setState(345);
				match(SEP);
				setState(346);
				ruleenviron();
				}
				}
				setState(351);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(352);
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
		enterRule(_localctx, 42, RULE_ruleenviron);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(357);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,38,_ctx) ) {
			case 1:
				{
				setState(354);
				boundarybefore();
				setState(355);
				match(WHITESPACE);
				}
				break;
			}
			setState(362);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OPAREN) | (1L << NULL) | (1L << MATSTART) | (1L << LISTSTART) | (1L << NEGATION) | (1L << WORDBOUNDARY) | (1L << CLASSREF) | (1L << FEATURE) | (1L << VALUE) | (1L << STR1) | (1L << STR))) != 0)) {
				{
				setState(359);
				rulebefore();
				setState(360);
				match(WHITESPACE);
				}
			}

			setState(364);
			match(ANCHOR);
			setState(367);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,40,_ctx) ) {
			case 1:
				{
				setState(365);
				match(WHITESPACE);
				setState(366);
				ruleafter();
				}
				break;
			}
			setState(371);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WHITESPACE) {
				{
				setState(369);
				match(WHITESPACE);
				setState(370);
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
		enterRule(_localctx, 44, RULE_boundarybefore);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(373);
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
		enterRule(_localctx, 46, RULE_boundaryafter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(375);
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
		enterRule(_localctx, 48, RULE_rulebefore);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(377);
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
		enterRule(_localctx, 50, RULE_ruleafter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(379);
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
		enterRule(_localctx, 52, RULE_ruleelement);
		try {
			setState(387);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,42,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(381);
				rulecapture();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(382);
				rulerepeater();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(383);
				rulegroup();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(384);
				rulelist();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(385);
				simpleelement();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(386);
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
		enterRule(_localctx, 54, RULE_rulesequence);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(389);
			sequenceelement();
			setState(392); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(390);
					match(WHITESPACE);
					setState(391);
					sequenceelement();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(394); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,43,_ctx);
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
		enterRule(_localctx, 56, RULE_sequenceelement);
		try {
			setState(401);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,44,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(396);
				rulecapture();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(397);
				rulerepeater();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(398);
				rulegroup();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(399);
				rulelist();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(400);
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
		public NegelementContext negelement() {
			return getRuleContext(NegelementContext.class,0);
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
		enterRule(_localctx, 58, RULE_rulecapture);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(408);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OPAREN:
				{
				setState(403);
				rulegroup();
				}
				break;
			case LISTSTART:
				{
				setState(404);
				rulelist();
				}
				break;
			case NEGATION:
				{
				setState(405);
				negelement();
				}
				break;
			case CLASSREF:
				{
				setState(406);
				classref();
				}
				break;
			case MATSTART:
				{
				setState(407);
				fancymatrix();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(410);
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
		enterRule(_localctx, 60, RULE_rulerepeater);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(415);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OPAREN:
				{
				setState(412);
				rulegroup();
				}
				break;
			case LISTSTART:
				{
				setState(413);
				rulelist();
				}
				break;
			case NULL:
			case MATSTART:
			case NEGATION:
			case WORDBOUNDARY:
			case CLASSREF:
			case FEATURE:
			case VALUE:
			case STR1:
			case STR:
				{
				setState(414);
				simpleelement();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(417);
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
		enterRule(_localctx, 62, RULE_rulegroup);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(419);
			match(OPAREN);
			setState(420);
			ruleelement();
			setState(421);
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
		enterRule(_localctx, 64, RULE_rulelist);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(423);
			match(LISTSTART);
			setState(424);
			ruleelement();
			setState(429);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SEP) {
				{
				{
				setState(425);
				match(SEP);
				setState(426);
				ruleelement();
				}
				}
				setState(431);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(432);
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
		public NegelementContext negelement() {
			return getRuleContext(NegelementContext.class,0);
		}
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
		enterRule(_localctx, 66, RULE_simpleelement);
		try {
			setState(440);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NEGATION:
				enterOuterAlt(_localctx, 1);
				{
				setState(434);
				negelement();
				}
				break;
			case CLASSREF:
				enterOuterAlt(_localctx, 2);
				{
				setState(435);
				classref();
				}
				break;
			case WORDBOUNDARY:
				enterOuterAlt(_localctx, 3);
				{
				setState(436);
				captureref();
				}
				break;
			case MATSTART:
				enterOuterAlt(_localctx, 4);
				{
				setState(437);
				fancymatrix();
				}
				break;
			case NULL:
				enterOuterAlt(_localctx, 5);
				{
				setState(438);
				empty();
				}
				break;
			case FEATURE:
			case VALUE:
			case STR1:
			case STR:
				enterOuterAlt(_localctx, 6);
				{
				setState(439);
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

	public static class NegelementContext extends ParserRuleContext {
		public TerminalNode NEGATION() { return getToken(LscParser.NEGATION, 0); }
		public ClassrefContext classref() {
			return getRuleContext(ClassrefContext.class,0);
		}
		public NegelementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_negelement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LscVisitor ) return ((LscVisitor<? extends T>)visitor).visitNegelement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NegelementContext negelement() throws RecognitionException {
		NegelementContext _localctx = new NegelementContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_negelement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(442);
			match(NEGATION);
			setState(443);
			classref();
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
		enterRule(_localctx, 70, RULE_classref);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(445);
			match(CLASSREF);
			setState(446);
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
		enterRule(_localctx, 72, RULE_captureref);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(448);
			match(WORDBOUNDARY);
			setState(449);
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
		enterRule(_localctx, 74, RULE_fancymatrix);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(451);
			match(MATSTART);
			setState(453);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NULL) | (1L << NEGATION) | (1L << WORDBOUNDARY) | (1L << VALUE))) != 0)) {
				{
				setState(452);
				fancyvalue();
				}
			}

			setState(459);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WHITESPACE) {
				{
				{
				setState(455);
				match(WHITESPACE);
				setState(456);
				fancyvalue();
				}
				}
				setState(461);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(462);
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
		enterRule(_localctx, 76, RULE_fancyvalue);
		try {
			setState(468);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VALUE:
				enterOuterAlt(_localctx, 1);
				{
				setState(464);
				value();
				}
				break;
			case NEGATION:
				enterOuterAlt(_localctx, 2);
				{
				setState(465);
				negvalue();
				}
				break;
			case NULL:
				enterOuterAlt(_localctx, 3);
				{
				setState(466);
				absentfeature();
				}
				break;
			case WORDBOUNDARY:
				enterOuterAlt(_localctx, 4);
				{
				setState(467);
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
		enterRule(_localctx, 78, RULE_negvalue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(470);
			match(NEGATION);
			setState(471);
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
		enterRule(_localctx, 80, RULE_absentfeature);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(473);
			match(NULL);
			setState(474);
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
		enterRule(_localctx, 82, RULE_featurevariable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(476);
			match(WORDBOUNDARY);
			setState(477);
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
		enterRule(_localctx, 84, RULE_empty);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(479);
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
		enterRule(_localctx, 86, RULE_repeatertype);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(481);
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
		enterRule(_localctx, 88, RULE_matrix);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(483);
			match(MATSTART);
			setState(485);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==VALUE) {
				{
				setState(484);
				value();
				}
			}

			setState(491);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WHITESPACE) {
				{
				{
				setState(487);
				match(WHITESPACE);
				setState(488);
				value();
				}
				}
				setState(493);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(494);
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
		enterRule(_localctx, 90, RULE_feature);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(496);
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
		enterRule(_localctx, 92, RULE_value);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(498);
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
		public TerminalNode NEGATION() { return getToken(LscParser.NEGATION, 0); }
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
		enterRule(_localctx, 94, RULE_text);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(500);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << FEATURE) | (1L << VALUE) | (1L << STR1) | (1L << STR))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(502);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NEGATION) {
				{
				setState(501);
				match(NEGATION);
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\'\u01fb\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\3\2\3\2\6\2e\n\2\r\2\16\2f"+
		"\7\2i\n\2\f\2\16\2l\13\2\3\2\3\2\6\2p\n\2\r\2\16\2q\7\2t\n\2\f\2\16\2"+
		"w\13\2\3\2\3\2\6\2{\n\2\r\2\16\2|\7\2\177\n\2\f\2\16\2\u0082\13\2\3\2"+
		"\3\2\6\2\u0086\n\2\r\2\16\2\u0087\7\2\u008a\n\2\f\2\16\2\u008d\13\2\3"+
		"\2\3\2\6\2\u0091\n\2\r\2\16\2\u0092\5\2\u0095\n\2\3\2\5\2\u0098\n\2\3"+
		"\2\6\2\u009b\n\2\r\2\16\2\u009c\3\2\3\2\5\2\u00a1\n\2\7\2\u00a3\n\2\f"+
		"\2\16\2\u00a6\13\2\3\2\6\2\u00a9\n\2\r\2\16\2\u00aa\3\2\5\2\u00ae\n\2"+
		"\3\2\6\2\u00b1\n\2\r\2\16\2\u00b2\3\2\5\2\u00b6\n\2\3\2\7\2\u00b9\n\2"+
		"\f\2\16\2\u00bc\13\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\7\3\u00c8"+
		"\n\3\f\3\16\3\u00cb\13\3\3\3\3\3\3\4\3\4\5\4\u00d1\n\4\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\5\5\u00da\n\5\3\5\3\5\3\5\7\5\u00df\n\5\f\5\16\5\u00e2\13"+
		"\5\3\5\3\5\3\5\5\5\u00e7\n\5\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\5\7\u00f2"+
		"\n\7\3\7\3\7\5\7\u00f6\n\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\7\b\u00ff\n\b\f"+
		"\b\16\b\u0102\13\b\3\b\3\b\5\b\u0106\n\b\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3"+
		"\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\5\r\u011e"+
		"\n\r\3\r\3\r\5\r\u0122\n\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3"+
		"\16\7\16\u012e\n\16\f\16\16\16\u0131\13\16\3\17\3\17\3\17\7\17\u0136\n"+
		"\17\f\17\16\17\u0139\13\17\3\20\3\20\3\20\7\20\u013e\n\20\f\20\16\20\u0141"+
		"\13\20\3\21\3\21\3\21\3\21\3\21\5\21\u0148\n\21\3\21\3\21\5\21\u014c\n"+
		"\21\3\22\3\22\5\22\u0150\n\22\3\23\3\23\5\23\u0154\n\23\3\24\3\24\3\25"+
		"\3\25\3\26\3\26\3\26\3\26\7\26\u015e\n\26\f\26\16\26\u0161\13\26\3\26"+
		"\3\26\3\27\3\27\3\27\5\27\u0168\n\27\3\27\3\27\3\27\5\27\u016d\n\27\3"+
		"\27\3\27\3\27\5\27\u0172\n\27\3\27\3\27\5\27\u0176\n\27\3\30\3\30\3\31"+
		"\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\34\5\34\u0186\n\34"+
		"\3\35\3\35\3\35\6\35\u018b\n\35\r\35\16\35\u018c\3\36\3\36\3\36\3\36\3"+
		"\36\5\36\u0194\n\36\3\37\3\37\3\37\3\37\3\37\5\37\u019b\n\37\3\37\3\37"+
		"\3 \3 \3 \5 \u01a2\n \3 \3 \3!\3!\3!\3!\3\"\3\"\3\"\3\"\7\"\u01ae\n\""+
		"\f\"\16\"\u01b1\13\"\3\"\3\"\3#\3#\3#\3#\3#\3#\5#\u01bb\n#\3$\3$\3$\3"+
		"%\3%\3%\3&\3&\3&\3\'\3\'\5\'\u01c8\n\'\3\'\3\'\7\'\u01cc\n\'\f\'\16\'"+
		"\u01cf\13\'\3\'\3\'\3(\3(\3(\3(\5(\u01d7\n(\3)\3)\3)\3*\3*\3*\3+\3+\3"+
		"+\3,\3,\3-\3-\3.\3.\5.\u01e8\n.\3.\3.\7.\u01ec\n.\f.\16.\u01ef\13.\3."+
		"\3.\3/\3/\3\60\3\60\3\61\3\61\5\61\u01f9\n\61\3\61\2\2\62\2\4\6\b\n\f"+
		"\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNPRTVXZ\\^"+
		"`\2\5\3\2\t\n\4\2\r\r\22\23\4\2#$&\'\2\u0212\2j\3\2\2\2\4\u00bf\3\2\2"+
		"\2\6\u00d0\3\2\2\2\b\u00d2\3\2\2\2\n\u00e8\3\2\2\2\f\u00eb\3\2\2\2\16"+
		"\u00f9\3\2\2\2\20\u0107\3\2\2\2\22\u0109\3\2\2\2\24\u010e\3\2\2\2\26\u0113"+
		"\3\2\2\2\30\u011a\3\2\2\2\32\u0127\3\2\2\2\34\u0132\3\2\2\2\36\u013a\3"+
		"\2\2\2 \u0142\3\2\2\2\"\u014f\3\2\2\2$\u0153\3\2\2\2&\u0155\3\2\2\2(\u0157"+
		"\3\2\2\2*\u0159\3\2\2\2,\u0167\3\2\2\2.\u0177\3\2\2\2\60\u0179\3\2\2\2"+
		"\62\u017b\3\2\2\2\64\u017d\3\2\2\2\66\u0185\3\2\2\28\u0187\3\2\2\2:\u0193"+
		"\3\2\2\2<\u019a\3\2\2\2>\u01a1\3\2\2\2@\u01a5\3\2\2\2B\u01a9\3\2\2\2D"+
		"\u01ba\3\2\2\2F\u01bc\3\2\2\2H\u01bf\3\2\2\2J\u01c2\3\2\2\2L\u01c5\3\2"+
		"\2\2N\u01d6\3\2\2\2P\u01d8\3\2\2\2R\u01db\3\2\2\2T\u01de\3\2\2\2V\u01e1"+
		"\3\2\2\2X\u01e3\3\2\2\2Z\u01e5\3\2\2\2\\\u01f2\3\2\2\2^\u01f4\3\2\2\2"+
		"`\u01f6\3\2\2\2bd\5\b\5\2ce\7\t\2\2dc\3\2\2\2ef\3\2\2\2fd\3\2\2\2fg\3"+
		"\2\2\2gi\3\2\2\2hb\3\2\2\2il\3\2\2\2jh\3\2\2\2jk\3\2\2\2ku\3\2\2\2lj\3"+
		"\2\2\2mo\5\f\7\2np\7\t\2\2on\3\2\2\2pq\3\2\2\2qo\3\2\2\2qr\3\2\2\2rt\3"+
		"\2\2\2sm\3\2\2\2tw\3\2\2\2us\3\2\2\2uv\3\2\2\2v\u0080\3\2\2\2wu\3\2\2"+
		"\2xz\5\16\b\2y{\7\t\2\2zy\3\2\2\2{|\3\2\2\2|z\3\2\2\2|}\3\2\2\2}\177\3"+
		"\2\2\2~x\3\2\2\2\177\u0082\3\2\2\2\u0080~\3\2\2\2\u0080\u0081\3\2\2\2"+
		"\u0081\u008b\3\2\2\2\u0082\u0080\3\2\2\2\u0083\u0085\5\4\3\2\u0084\u0086"+
		"\7\t\2\2\u0085\u0084\3\2\2\2\u0086\u0087\3\2\2\2\u0087\u0085\3\2\2\2\u0087"+
		"\u0088\3\2\2\2\u0088\u008a\3\2\2\2\u0089\u0083\3\2\2\2\u008a\u008d\3\2"+
		"\2\2\u008b\u0089\3\2\2\2\u008b\u008c\3\2\2\2\u008c\u0094\3\2\2\2\u008d"+
		"\u008b\3\2\2\2\u008e\u0090\5\22\n\2\u008f\u0091\7\t\2\2\u0090\u008f\3"+
		"\2\2\2\u0091\u0092\3\2\2\2\u0092\u0090\3\2\2\2\u0092\u0093\3\2\2\2\u0093"+
		"\u0095\3\2\2\2\u0094\u008e\3\2\2\2\u0094\u0095\3\2\2\2\u0095\u0097\3\2"+
		"\2\2\u0096\u0098\5\30\r\2\u0097\u0096\3\2\2\2\u0097\u0098\3\2\2\2\u0098"+
		"\u00ad\3\2\2\2\u0099\u009b\7\t\2\2\u009a\u0099\3\2\2\2\u009b\u009c\3\2"+
		"\2\2\u009c\u009a\3\2\2\2\u009c\u009d\3\2\2\2\u009d\u00a0\3\2\2\2\u009e"+
		"\u00a1\5\30\r\2\u009f\u00a1\5\26\f\2\u00a0\u009e\3\2\2\2\u00a0\u009f\3"+
		"\2\2\2\u00a1\u00a3\3\2\2\2\u00a2\u009a\3\2\2\2\u00a3\u00a6\3\2\2\2\u00a4"+
		"\u00a2\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5\u00a8\3\2\2\2\u00a6\u00a4\3\2"+
		"\2\2\u00a7\u00a9\7\t\2\2\u00a8\u00a7\3\2\2\2\u00a9\u00aa\3\2\2\2\u00aa"+
		"\u00a8\3\2\2\2\u00aa\u00ab\3\2\2\2\u00ab\u00ac\3\2\2\2\u00ac\u00ae\5\30"+
		"\r\2\u00ad\u00a4\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ae\u00b5\3\2\2\2\u00af"+
		"\u00b1\7\t\2\2\u00b0\u00af\3\2\2\2\u00b1\u00b2\3\2\2\2\u00b2\u00b0\3\2"+
		"\2\2\u00b2\u00b3\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4\u00b6\5\24\13\2\u00b5"+
		"\u00b0\3\2\2\2\u00b5\u00b6\3\2\2\2\u00b6\u00ba\3\2\2\2\u00b7\u00b9\7\t"+
		"\2\2\u00b8\u00b7\3\2\2\2\u00b9\u00bc\3\2\2\2\u00ba\u00b8\3\2\2\2\u00ba"+
		"\u00bb\3\2\2\2\u00bb\u00bd\3\2\2\2\u00bc\u00ba\3\2\2\2\u00bd\u00be\7\2"+
		"\2\3\u00be\3\3\2\2\2\u00bf\u00c0\7\31\2\2\u00c0\u00c1\7\n\2\2\u00c1\u00c2"+
		"\5^\60\2\u00c2\u00c3\7\n\2\2\u00c3\u00c4\7\20\2\2\u00c4\u00c9\5\6\4\2"+
		"\u00c5\u00c6\7\4\2\2\u00c6\u00c8\5\6\4\2\u00c7\u00c5\3\2\2\2\u00c8\u00cb"+
		"\3\2\2\2\u00c9\u00c7\3\2\2\2\u00c9\u00ca\3\2\2\2\u00ca\u00cc\3\2\2\2\u00cb"+
		"\u00c9\3\2\2\2\u00cc\u00cd\7\21\2\2\u00cd\5\3\2\2\2\u00ce\u00d1\5H%\2"+
		"\u00cf\u00d1\5`\61\2\u00d0\u00ce\3\2\2\2\u00d0\u00cf\3\2\2\2\u00d1\7\3"+
		"\2\2\2\u00d2\u00d3\7\32\2\2\u00d3\u00d4\7\n\2\2\u00d4\u00d5\5\\/\2\u00d5"+
		"\u00d9\7\13\2\2\u00d6\u00d7\5\n\6\2\u00d7\u00d8\7\4\2\2\u00d8\u00da\3"+
		"\2\2\2\u00d9\u00d6\3\2\2\2\u00d9\u00da\3\2\2\2\u00da\u00db\3\2\2\2\u00db"+
		"\u00e0\5^\60\2\u00dc\u00dd\7\4\2\2\u00dd\u00df\5^\60\2\u00de\u00dc\3\2"+
		"\2\2\u00df\u00e2\3\2\2\2\u00e0\u00de\3\2\2\2\u00e0\u00e1\3\2\2\2\u00e1"+
		"\u00e3\3\2\2\2\u00e2\u00e0\3\2\2\2\u00e3\u00e6\7\f\2\2\u00e4\u00e5\7\5"+
		"\2\2\u00e5\u00e7\5Z.\2\u00e6\u00e4\3\2\2\2\u00e6\u00e7\3\2\2\2\u00e7\t"+
		"\3\2\2\2\u00e8\u00e9\7\r\2\2\u00e9\u00ea\5^\60\2\u00ea\13\3\2\2\2\u00eb"+
		"\u00ec\7\33\2\2\u00ec\u00ed\7\n\2\2\u00ed\u00ee\7&\2\2\u00ee\u00f1\7\n"+
		"\2\2\u00ef\u00f0\7\34\2\2\u00f0\u00f2\7\n\2\2\u00f1\u00ef\3\2\2\2\u00f1"+
		"\u00f2\3\2\2\2\u00f2\u00f5\3\2\2\2\u00f3\u00f4\7\35\2\2\u00f4\u00f6\7"+
		"\n\2\2\u00f5\u00f3\3\2\2\2\u00f5\u00f6\3\2\2\2\u00f6\u00f7\3\2\2\2\u00f7"+
		"\u00f8\5Z.\2\u00f8\r\3\2\2\2\u00f9\u00fa\7\36\2\2\u00fa\u00fb\7\n\2\2"+
		"\u00fb\u0105\5\20\t\2\u00fc\u00fd\7\4\2\2\u00fd\u00ff\5\20\t\2\u00fe\u00fc"+
		"\3\2\2\2\u00ff\u0102\3\2\2\2\u0100\u00fe\3\2\2\2\u0100\u0101\3\2\2\2\u0101"+
		"\u0106\3\2\2\2\u0102\u0100\3\2\2\2\u0103\u0104\7\n\2\2\u0104\u0106\5Z"+
		".\2\u0105\u0100\3\2\2\2\u0105\u0103\3\2\2\2\u0106\17\3\2\2\2\u0107\u0108"+
		"\5`\61\2\u0108\21\3\2\2\2\u0109\u010a\7\37\2\2\u010a\u010b\7\25\2\2\u010b"+
		"\u010c\7\t\2\2\u010c\u010d\5\32\16\2\u010d\23\3\2\2\2\u010e\u010f\7 \2"+
		"\2\u010f\u0110\7\25\2\2\u0110\u0111\7\t\2\2\u0111\u0112\5\32\16\2\u0112"+
		"\25\3\2\2\2\u0113\u0114\7 \2\2\u0114\u0115\7\24\2\2\u0115\u0116\5\36\20"+
		"\2\u0116\u0117\7\25\2\2\u0117\u0118\7\t\2\2\u0118\u0119\5\32\16\2\u0119"+
		"\27\3\2\2\2\u011a\u011d\5\36\20\2\u011b\u011c\7\n\2\2\u011c\u011e\5Z."+
		"\2\u011d\u011b\3\2\2\2\u011d\u011e\3\2\2\2\u011e\u0121\3\2\2\2\u011f\u0120"+
		"\7\n\2\2\u0120\u0122\7\"\2\2\u0121\u011f\3\2\2\2\u0121\u0122\3\2\2\2\u0122"+
		"\u0123\3\2\2\2\u0123\u0124\7\25\2\2\u0124\u0125\7\t\2\2\u0125\u0126\5"+
		"\32\16\2\u0126\31\3\2\2\2\u0127\u012f\5\34\17\2\u0128\u0129\7\t\2\2\u0129"+
		"\u012a\7!\2\2\u012a\u012b\7\25\2\2\u012b\u012c\t\2\2\2\u012c\u012e\5\34"+
		"\17\2\u012d\u0128\3\2\2\2\u012e\u0131\3\2\2\2\u012f\u012d\3\2\2\2\u012f"+
		"\u0130\3\2\2\2\u0130\33\3\2\2\2\u0131\u012f\3\2\2\2\u0132\u0137\5 \21"+
		"\2\u0133\u0134\7\t\2\2\u0134\u0136\5 \21\2\u0135\u0133\3\2\2\2\u0136\u0139"+
		"\3\2\2\2\u0137\u0135\3\2\2\2\u0137\u0138\3\2\2\2\u0138\35\3\2\2\2\u0139"+
		"\u0137\3\2\2\2\u013a\u013f\7$\2\2\u013b\u013c\7\24\2\2\u013c\u013e\7$"+
		"\2\2\u013d\u013b\3\2\2\2\u013e\u0141\3\2\2\2\u013f\u013d\3\2\2\2\u013f"+
		"\u0140\3\2\2\2\u0140\37\3\2\2\2\u0141\u013f\3\2\2\2\u0142\u0143\5&\24"+
		"\2\u0143\u0144\7\5\2\2\u0144\u0147\5(\25\2\u0145\u0146\7\6\2\2\u0146\u0148"+
		"\5\"\22\2\u0147\u0145\3\2\2\2\u0147\u0148\3\2\2\2\u0148\u014b\3\2\2\2"+
		"\u0149\u014a\7\7\2\2\u014a\u014c\5$\23\2\u014b\u0149\3\2\2\2\u014b\u014c"+
		"\3\2\2\2\u014c!\3\2\2\2\u014d\u0150\5,\27\2\u014e\u0150\5*\26\2\u014f"+
		"\u014d\3\2\2\2\u014f\u014e\3\2\2\2\u0150#\3\2\2\2\u0151\u0154\5,\27\2"+
		"\u0152\u0154\5*\26\2\u0153\u0151\3\2\2\2\u0153\u0152\3\2\2\2\u0154%\3"+
		"\2\2\2\u0155\u0156\5\66\34\2\u0156\'\3\2\2\2\u0157\u0158\5\66\34\2\u0158"+
		")\3\2\2\2\u0159\u015a\7\20\2\2\u015a\u015f\5,\27\2\u015b\u015c\7\4\2\2"+
		"\u015c\u015e\5,\27\2\u015d\u015b\3\2\2\2\u015e\u0161\3\2\2\2\u015f\u015d"+
		"\3\2\2\2\u015f\u0160\3\2\2\2\u0160\u0162\3\2\2\2\u0161\u015f\3\2\2\2\u0162"+
		"\u0163\7\21\2\2\u0163+\3\2\2\2\u0164\u0165\5.\30\2\u0165\u0166\7\n\2\2"+
		"\u0166\u0168\3\2\2\2\u0167\u0164\3\2\2\2\u0167\u0168\3\2\2\2\u0168\u016c"+
		"\3\2\2\2\u0169\u016a\5\62\32\2\u016a\u016b\7\n\2\2\u016b\u016d\3\2\2\2"+
		"\u016c\u0169\3\2\2\2\u016c\u016d\3\2\2\2\u016d\u016e\3\2\2\2\u016e\u0171"+
		"\7\b\2\2\u016f\u0170\7\n\2\2\u0170\u0172\5\64\33\2\u0171\u016f\3\2\2\2"+
		"\u0171\u0172\3\2\2\2\u0172\u0175\3\2\2\2\u0173\u0174\7\n\2\2\u0174\u0176"+
		"\5\60\31\2\u0175\u0173\3\2\2\2\u0175\u0176\3\2\2\2\u0176-\3\2\2\2\u0177"+
		"\u0178\7\27\2\2\u0178/\3\2\2\2\u0179\u017a\7\27\2\2\u017a\61\3\2\2\2\u017b"+
		"\u017c\5\66\34\2\u017c\63\3\2\2\2\u017d\u017e\5\66\34\2\u017e\65\3\2\2"+
		"\2\u017f\u0186\5<\37\2\u0180\u0186\5> \2\u0181\u0186\5@!\2\u0182\u0186"+
		"\5B\"\2\u0183\u0186\5D#\2\u0184\u0186\58\35\2\u0185\u017f\3\2\2\2\u0185"+
		"\u0180\3\2\2\2\u0185\u0181\3\2\2\2\u0185\u0182\3\2\2\2\u0185\u0183\3\2"+
		"\2\2\u0185\u0184\3\2\2\2\u0186\67\3\2\2\2\u0187\u018a\5:\36\2\u0188\u0189"+
		"\7\n\2\2\u0189\u018b\5:\36\2\u018a\u0188\3\2\2\2\u018b\u018c\3\2\2\2\u018c"+
		"\u018a\3\2\2\2\u018c\u018d\3\2\2\2\u018d9\3\2\2\2\u018e\u0194\5<\37\2"+
		"\u018f\u0194\5> \2\u0190\u0194\5@!\2\u0191\u0194\5B\"\2\u0192\u0194\5"+
		"D#\2\u0193\u018e\3\2\2\2\u0193\u018f\3\2\2\2\u0193\u0190\3\2\2\2\u0193"+
		"\u0191\3\2\2\2\u0193\u0192\3\2\2\2\u0194;\3\2\2\2\u0195\u019b\5@!\2\u0196"+
		"\u019b\5B\"\2\u0197\u019b\5F$\2\u0198\u019b\5H%\2\u0199\u019b\5L\'\2\u019a"+
		"\u0195\3\2\2\2\u019a\u0196\3\2\2\2\u019a\u0197\3\2\2\2\u019a\u0198\3\2"+
		"\2\2\u019a\u0199\3\2\2\2\u019b\u019c\3\2\2\2\u019c\u019d\5J&\2\u019d="+
		"\3\2\2\2\u019e\u01a2\5@!\2\u019f\u01a2\5B\"\2\u01a0\u01a2\5D#\2\u01a1"+
		"\u019e\3\2\2\2\u01a1\u019f\3\2\2\2\u01a1\u01a0\3\2\2\2\u01a2\u01a3\3\2"+
		"\2\2\u01a3\u01a4\5X-\2\u01a4?\3\2\2\2\u01a5\u01a6\7\13\2\2\u01a6\u01a7"+
		"\5\66\34\2\u01a7\u01a8\7\f\2\2\u01a8A\3\2\2\2\u01a9\u01aa\7\20\2\2\u01aa"+
		"\u01af\5\66\34\2\u01ab\u01ac\7\4\2\2\u01ac\u01ae\5\66\34\2\u01ad\u01ab"+
		"\3\2\2\2\u01ae\u01b1\3\2\2\2\u01af\u01ad\3\2\2\2\u01af\u01b0\3\2\2\2\u01b0"+
		"\u01b2\3\2\2\2\u01b1\u01af\3\2\2\2\u01b2\u01b3\7\21\2\2\u01b3C\3\2\2\2"+
		"\u01b4\u01bb\5F$\2\u01b5\u01bb\5H%\2\u01b6\u01bb\5J&\2\u01b7\u01bb\5L"+
		"\'\2\u01b8\u01bb\5V,\2\u01b9\u01bb\5`\61\2\u01ba\u01b4\3\2\2\2\u01ba\u01b5"+
		"\3\2\2\2\u01ba\u01b6\3\2\2\2\u01ba\u01b7\3\2\2\2\u01ba\u01b8\3\2\2\2\u01ba"+
		"\u01b9\3\2\2\2\u01bbE\3\2\2\2\u01bc\u01bd\7\26\2\2\u01bd\u01be\5H%\2\u01be"+
		"G\3\2\2\2\u01bf\u01c0\7\30\2\2\u01c0\u01c1\5^\60\2\u01c1I\3\2\2\2\u01c2"+
		"\u01c3\7\27\2\2\u01c3\u01c4\7%\2\2\u01c4K\3\2\2\2\u01c5\u01c7\7\16\2\2"+
		"\u01c6\u01c8\5N(\2\u01c7\u01c6\3\2\2\2\u01c7\u01c8\3\2\2\2\u01c8\u01cd"+
		"\3\2\2\2\u01c9\u01ca\7\n\2\2\u01ca\u01cc\5N(\2\u01cb\u01c9\3\2\2\2\u01cc"+
		"\u01cf\3\2\2\2\u01cd\u01cb\3\2\2\2\u01cd\u01ce\3\2\2\2\u01ce\u01d0\3\2"+
		"\2\2\u01cf\u01cd\3\2\2\2\u01d0\u01d1\7\17\2\2\u01d1M\3\2\2\2\u01d2\u01d7"+
		"\5^\60\2\u01d3\u01d7\5P)\2\u01d4\u01d7\5R*\2\u01d5\u01d7\5T+\2\u01d6\u01d2"+
		"\3\2\2\2\u01d6\u01d3\3\2\2\2\u01d6\u01d4\3\2\2\2\u01d6\u01d5\3\2\2\2\u01d7"+
		"O\3\2\2\2\u01d8\u01d9\7\26\2\2\u01d9\u01da\5^\60\2\u01daQ\3\2\2\2\u01db"+
		"\u01dc\7\r\2\2\u01dc\u01dd\5\\/\2\u01ddS\3\2\2\2\u01de\u01df\7\27\2\2"+
		"\u01df\u01e0\5\\/\2\u01e0U\3\2\2\2\u01e1\u01e2\7\r\2\2\u01e2W\3\2\2\2"+
		"\u01e3\u01e4\t\3\2\2\u01e4Y\3\2\2\2\u01e5\u01e7\7\16\2\2\u01e6\u01e8\5"+
		"^\60\2\u01e7\u01e6\3\2\2\2\u01e7\u01e8\3\2\2\2\u01e8\u01ed\3\2\2\2\u01e9"+
		"\u01ea\7\n\2\2\u01ea\u01ec\5^\60\2\u01eb\u01e9\3\2\2\2\u01ec\u01ef\3\2"+
		"\2\2\u01ed\u01eb\3\2\2\2\u01ed\u01ee\3\2\2\2\u01ee\u01f0\3\2\2\2\u01ef"+
		"\u01ed\3\2\2\2\u01f0\u01f1\7\17\2\2\u01f1[\3\2\2\2\u01f2\u01f3\7#\2\2"+
		"\u01f3]\3\2\2\2\u01f4\u01f5\7$\2\2\u01f5_\3\2\2\2\u01f6\u01f8\t\4\2\2"+
		"\u01f7\u01f9\7\26\2\2\u01f8\u01f7\3\2\2\2\u01f8\u01f9\3\2\2\2\u01f9a\3"+
		"\2\2\29fjqu|\u0080\u0087\u008b\u0092\u0094\u0097\u009c\u00a0\u00a4\u00aa"+
		"\u00ad\u00b2\u00b5\u00ba\u00c9\u00d0\u00d9\u00e0\u00e6\u00f1\u00f5\u0100"+
		"\u0105\u011d\u0121\u012f\u0137\u013f\u0147\u014b\u014f\u0153\u015f\u0167"+
		"\u016c\u0171\u0175\u0185\u018c\u0193\u019a\u01a1\u01af\u01ba\u01c7\u01cd"+
		"\u01d6\u01e7\u01ed\u01f8";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}