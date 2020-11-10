// Generated from Lsc.g4 by ANTLR 4.7.2
package com.meamoria.lexurgy.sc.java;
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
		WHITESPACE=8, O_PAREN=9, C_PAREN=10, NULL=11, MATRIX_START=12, MATRIX_END=13, 
		LIST_START=14, LIST_END=15, AT_LEAST_ONE=16, OPTIONAL=17, HYPHEN=18, RULE_START=19, 
		NEGATION=20, WORD_BOUNDARY=21, CLASSREF=22, CLASS_DECL=23, FEATURE_DECL=24, 
		DIACRITIC=25, DIA_BEFORE=26, DIA_FLOATING=27, SYMBOL=28, DEROMANIZER=29, 
		ROMANIZER=30, SUBRULE=31, PROPAGATE=32, FEATURE=33, VALUE=34, NUMBER=35, 
		STR1=36, STR=37;
	public static final int
		RULE_lscFile = 0, RULE_classDecl = 1, RULE_classElement = 2, RULE_featureDecl = 3, 
		RULE_nullAlias = 4, RULE_diacriticDecl = 5, RULE_symbolDecl = 6, RULE_symbolName = 7, 
		RULE_deromanizer = 8, RULE_romanizer = 9, RULE_interRomanizer = 10, RULE_changeRule = 11, 
		RULE_filter = 12, RULE_subrules = 13, RULE_subrule = 14, RULE_ruleName = 15, 
		RULE_expression = 16, RULE_condition = 17, RULE_exclusion = 18, RULE_from = 19, 
		RULE_to = 20, RULE_environmentList = 21, RULE_environment = 22, RULE_boundaryBefore = 23, 
		RULE_boundaryAfter = 24, RULE_environmentBefore = 25, RULE_environmentAfter = 26, 
		RULE_ruleElement = 27, RULE_sequence = 28, RULE_sequenceElement = 29, 
		RULE_capture = 30, RULE_repeater = 31, RULE_group = 32, RULE_list = 33, 
		RULE_simple = 34, RULE_negated = 35, RULE_classRef = 36, RULE_captureRef = 37, 
		RULE_fancyMatrix = 38, RULE_fancyValue = 39, RULE_negatedValue = 40, RULE_absentFeature = 41, 
		RULE_featureVariable = 42, RULE_empty = 43, RULE_repeaterType = 44, RULE_matrix = 45, 
		RULE_feature = 46, RULE_value = 47, RULE_text = 48;
	private static String[] makeRuleNames() {
		return new String[] {
			"lscFile", "classDecl", "classElement", "featureDecl", "nullAlias", "diacriticDecl", 
			"symbolDecl", "symbolName", "deromanizer", "romanizer", "interRomanizer", 
			"changeRule", "filter", "subrules", "subrule", "ruleName", "expression", 
			"condition", "exclusion", "from", "to", "environmentList", "environment", 
			"boundaryBefore", "boundaryAfter", "environmentBefore", "environmentAfter", 
			"ruleElement", "sequence", "sequenceElement", "capture", "repeater", 
			"group", "list", "simple", "negated", "classRef", "captureRef", "fancyMatrix", 
			"fancyValue", "negatedValue", "absentFeature", "featureVariable", "empty", 
			"repeaterType", "matrix", "feature", "value", "text"
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
			"NEWLINE", "WHITESPACE", "O_PAREN", "C_PAREN", "NULL", "MATRIX_START", 
			"MATRIX_END", "LIST_START", "LIST_END", "AT_LEAST_ONE", "OPTIONAL", "HYPHEN", 
			"RULE_START", "NEGATION", "WORD_BOUNDARY", "CLASSREF", "CLASS_DECL", 
			"FEATURE_DECL", "DIACRITIC", "DIA_BEFORE", "DIA_FLOATING", "SYMBOL", 
			"DEROMANIZER", "ROMANIZER", "SUBRULE", "PROPAGATE", "FEATURE", "VALUE", 
			"NUMBER", "STR1", "STR"
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

	public static class LscFileContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(LscParser.EOF, 0); }
		public List<FeatureDeclContext> featureDecl() {
			return getRuleContexts(FeatureDeclContext.class);
		}
		public FeatureDeclContext featureDecl(int i) {
			return getRuleContext(FeatureDeclContext.class,i);
		}
		public List<DiacriticDeclContext> diacriticDecl() {
			return getRuleContexts(DiacriticDeclContext.class);
		}
		public DiacriticDeclContext diacriticDecl(int i) {
			return getRuleContext(DiacriticDeclContext.class,i);
		}
		public List<SymbolDeclContext> symbolDecl() {
			return getRuleContexts(SymbolDeclContext.class);
		}
		public SymbolDeclContext symbolDecl(int i) {
			return getRuleContext(SymbolDeclContext.class,i);
		}
		public List<ClassDeclContext> classDecl() {
			return getRuleContexts(ClassDeclContext.class);
		}
		public ClassDeclContext classDecl(int i) {
			return getRuleContext(ClassDeclContext.class,i);
		}
		public DeromanizerContext deromanizer() {
			return getRuleContext(DeromanizerContext.class,0);
		}
		public List<ChangeRuleContext> changeRule() {
			return getRuleContexts(ChangeRuleContext.class);
		}
		public ChangeRuleContext changeRule(int i) {
			return getRuleContext(ChangeRuleContext.class,i);
		}
		public RomanizerContext romanizer() {
			return getRuleContext(RomanizerContext.class,0);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(LscParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(LscParser.NEWLINE, i);
		}
		public List<InterRomanizerContext> interRomanizer() {
			return getRuleContexts(InterRomanizerContext.class);
		}
		public InterRomanizerContext interRomanizer(int i) {
			return getRuleContext(InterRomanizerContext.class,i);
		}
		public LscFileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lscFile; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LscVisitor ) return ((LscVisitor<? extends T>)visitor).visitLscFile(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LscFileContext lscFile() throws RecognitionException {
		LscFileContext _localctx = new LscFileContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_lscFile);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(106);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==FEATURE_DECL) {
				{
				{
				setState(98);
				featureDecl();
				setState(100); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(99);
						match(NEWLINE);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(102); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				}
				setState(108);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(117);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DIACRITIC) {
				{
				{
				setState(109);
				diacriticDecl();
				setState(111); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(110);
						match(NEWLINE);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(113); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				}
				setState(119);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(128);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SYMBOL) {
				{
				{
				setState(120);
				symbolDecl();
				setState(122); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(121);
						match(NEWLINE);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(124); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				}
				setState(130);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(139);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CLASS_DECL) {
				{
				{
				setState(131);
				classDecl();
				setState(133); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(132);
						match(NEWLINE);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(135); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				}
				setState(141);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(148);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DEROMANIZER) {
				{
				setState(142);
				deromanizer();
				setState(144); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(143);
						match(NEWLINE);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(146); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
			}

			setState(151);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==VALUE) {
				{
				setState(150);
				changeRule();
				}
			}

			setState(173);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				{
				setState(164);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(154); 
						_errHandler.sync(this);
						_la = _input.LA(1);
						do {
							{
							{
							setState(153);
							match(NEWLINE);
							}
							}
							setState(156); 
							_errHandler.sync(this);
							_la = _input.LA(1);
						} while ( _la==NEWLINE );
						setState(160);
						_errHandler.sync(this);
						switch (_input.LA(1)) {
						case VALUE:
							{
							setState(158);
							changeRule();
							}
							break;
						case ROMANIZER:
							{
							setState(159);
							interRomanizer();
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						}
						} 
					}
					setState(166);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
				}
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
				changeRule();
				}
				break;
			}
			setState(181);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				{
				setState(176); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(175);
					match(NEWLINE);
					}
					}
					setState(178); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NEWLINE );
				setState(180);
				romanizer();
				}
				break;
			}
			setState(186);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE) {
				{
				{
				setState(183);
				match(NEWLINE);
				}
				}
				setState(188);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(189);
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

	public static class ClassDeclContext extends ParserRuleContext {
		public TerminalNode CLASS_DECL() { return getToken(LscParser.CLASS_DECL, 0); }
		public List<TerminalNode> WHITESPACE() { return getTokens(LscParser.WHITESPACE); }
		public TerminalNode WHITESPACE(int i) {
			return getToken(LscParser.WHITESPACE, i);
		}
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public TerminalNode LIST_START() { return getToken(LscParser.LIST_START, 0); }
		public List<ClassElementContext> classElement() {
			return getRuleContexts(ClassElementContext.class);
		}
		public ClassElementContext classElement(int i) {
			return getRuleContext(ClassElementContext.class,i);
		}
		public TerminalNode LIST_END() { return getToken(LscParser.LIST_END, 0); }
		public List<TerminalNode> SEP() { return getTokens(LscParser.SEP); }
		public TerminalNode SEP(int i) {
			return getToken(LscParser.SEP, i);
		}
		public ClassDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classDecl; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LscVisitor ) return ((LscVisitor<? extends T>)visitor).visitClassDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassDeclContext classDecl() throws RecognitionException {
		ClassDeclContext _localctx = new ClassDeclContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_classDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(191);
			match(CLASS_DECL);
			setState(192);
			match(WHITESPACE);
			setState(193);
			value();
			setState(194);
			match(WHITESPACE);
			setState(195);
			match(LIST_START);
			setState(196);
			classElement();
			setState(201);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SEP) {
				{
				{
				setState(197);
				match(SEP);
				setState(198);
				classElement();
				}
				}
				setState(203);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(204);
			match(LIST_END);
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

	public static class ClassElementContext extends ParserRuleContext {
		public ClassRefContext classRef() {
			return getRuleContext(ClassRefContext.class,0);
		}
		public TextContext text() {
			return getRuleContext(TextContext.class,0);
		}
		public ClassElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classElement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LscVisitor ) return ((LscVisitor<? extends T>)visitor).visitClassElement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassElementContext classElement() throws RecognitionException {
		ClassElementContext _localctx = new ClassElementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_classElement);
		try {
			setState(208);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CLASSREF:
				enterOuterAlt(_localctx, 1);
				{
				setState(206);
				classRef();
				}
				break;
			case FEATURE:
			case VALUE:
			case STR1:
			case STR:
				enterOuterAlt(_localctx, 2);
				{
				setState(207);
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

	public static class FeatureDeclContext extends ParserRuleContext {
		public TerminalNode FEATURE_DECL() { return getToken(LscParser.FEATURE_DECL, 0); }
		public TerminalNode WHITESPACE() { return getToken(LscParser.WHITESPACE, 0); }
		public FeatureContext feature() {
			return getRuleContext(FeatureContext.class,0);
		}
		public TerminalNode O_PAREN() { return getToken(LscParser.O_PAREN, 0); }
		public List<ValueContext> value() {
			return getRuleContexts(ValueContext.class);
		}
		public ValueContext value(int i) {
			return getRuleContext(ValueContext.class,i);
		}
		public TerminalNode C_PAREN() { return getToken(LscParser.C_PAREN, 0); }
		public NullAliasContext nullAlias() {
			return getRuleContext(NullAliasContext.class,0);
		}
		public List<TerminalNode> SEP() { return getTokens(LscParser.SEP); }
		public TerminalNode SEP(int i) {
			return getToken(LscParser.SEP, i);
		}
		public TerminalNode CHANGE() { return getToken(LscParser.CHANGE, 0); }
		public MatrixContext matrix() {
			return getRuleContext(MatrixContext.class,0);
		}
		public FeatureDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_featureDecl; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LscVisitor ) return ((LscVisitor<? extends T>)visitor).visitFeatureDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FeatureDeclContext featureDecl() throws RecognitionException {
		FeatureDeclContext _localctx = new FeatureDeclContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_featureDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(210);
			match(FEATURE_DECL);
			setState(211);
			match(WHITESPACE);
			setState(212);
			feature();
			setState(213);
			match(O_PAREN);
			setState(217);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NULL) {
				{
				setState(214);
				nullAlias();
				setState(215);
				match(SEP);
				}
			}

			setState(219);
			value();
			setState(224);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SEP) {
				{
				{
				setState(220);
				match(SEP);
				setState(221);
				value();
				}
				}
				setState(226);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(227);
			match(C_PAREN);
			setState(230);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CHANGE) {
				{
				setState(228);
				match(CHANGE);
				setState(229);
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

	public static class NullAliasContext extends ParserRuleContext {
		public TerminalNode NULL() { return getToken(LscParser.NULL, 0); }
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public NullAliasContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nullAlias; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LscVisitor ) return ((LscVisitor<? extends T>)visitor).visitNullAlias(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NullAliasContext nullAlias() throws RecognitionException {
		NullAliasContext _localctx = new NullAliasContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_nullAlias);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(232);
			match(NULL);
			setState(233);
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

	public static class DiacriticDeclContext extends ParserRuleContext {
		public TerminalNode DIACRITIC() { return getToken(LscParser.DIACRITIC, 0); }
		public List<TerminalNode> WHITESPACE() { return getTokens(LscParser.WHITESPACE); }
		public TerminalNode WHITESPACE(int i) {
			return getToken(LscParser.WHITESPACE, i);
		}
		public TerminalNode STR1() { return getToken(LscParser.STR1, 0); }
		public MatrixContext matrix() {
			return getRuleContext(MatrixContext.class,0);
		}
		public TerminalNode DIA_BEFORE() { return getToken(LscParser.DIA_BEFORE, 0); }
		public TerminalNode DIA_FLOATING() { return getToken(LscParser.DIA_FLOATING, 0); }
		public DiacriticDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_diacriticDecl; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LscVisitor ) return ((LscVisitor<? extends T>)visitor).visitDiacriticDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DiacriticDeclContext diacriticDecl() throws RecognitionException {
		DiacriticDeclContext _localctx = new DiacriticDeclContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_diacriticDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(235);
			match(DIACRITIC);
			setState(236);
			match(WHITESPACE);
			setState(237);
			match(STR1);
			setState(238);
			match(WHITESPACE);
			setState(241);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DIA_BEFORE) {
				{
				setState(239);
				match(DIA_BEFORE);
				setState(240);
				match(WHITESPACE);
				}
			}

			setState(245);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DIA_FLOATING) {
				{
				setState(243);
				match(DIA_FLOATING);
				setState(244);
				match(WHITESPACE);
				}
			}

			setState(247);
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

	public static class SymbolDeclContext extends ParserRuleContext {
		public TerminalNode SYMBOL() { return getToken(LscParser.SYMBOL, 0); }
		public List<TerminalNode> WHITESPACE() { return getTokens(LscParser.WHITESPACE); }
		public TerminalNode WHITESPACE(int i) {
			return getToken(LscParser.WHITESPACE, i);
		}
		public List<SymbolNameContext> symbolName() {
			return getRuleContexts(SymbolNameContext.class);
		}
		public SymbolNameContext symbolName(int i) {
			return getRuleContext(SymbolNameContext.class,i);
		}
		public MatrixContext matrix() {
			return getRuleContext(MatrixContext.class,0);
		}
		public List<TerminalNode> SEP() { return getTokens(LscParser.SEP); }
		public TerminalNode SEP(int i) {
			return getToken(LscParser.SEP, i);
		}
		public SymbolDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_symbolDecl; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LscVisitor ) return ((LscVisitor<? extends T>)visitor).visitSymbolDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SymbolDeclContext symbolDecl() throws RecognitionException {
		SymbolDeclContext _localctx = new SymbolDeclContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_symbolDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(249);
			match(SYMBOL);
			setState(250);
			match(WHITESPACE);
			setState(251);
			symbolName();
			setState(261);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SEP:
			case NEWLINE:
				{
				setState(256);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==SEP) {
					{
					{
					setState(252);
					match(SEP);
					setState(253);
					symbolName();
					}
					}
					setState(258);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case WHITESPACE:
				{
				setState(259);
				match(WHITESPACE);
				setState(260);
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

	public static class SymbolNameContext extends ParserRuleContext {
		public TextContext text() {
			return getRuleContext(TextContext.class,0);
		}
		public SymbolNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_symbolName; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LscVisitor ) return ((LscVisitor<? extends T>)visitor).visitSymbolName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SymbolNameContext symbolName() throws RecognitionException {
		SymbolNameContext _localctx = new SymbolNameContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_symbolName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(263);
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
		public TerminalNode RULE_START() { return getToken(LscParser.RULE_START, 0); }
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
			setState(265);
			match(DEROMANIZER);
			setState(266);
			match(RULE_START);
			setState(267);
			match(NEWLINE);
			setState(268);
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
		public TerminalNode RULE_START() { return getToken(LscParser.RULE_START, 0); }
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
			setState(270);
			match(ROMANIZER);
			setState(271);
			match(RULE_START);
			setState(272);
			match(NEWLINE);
			setState(273);
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

	public static class InterRomanizerContext extends ParserRuleContext {
		public TerminalNode ROMANIZER() { return getToken(LscParser.ROMANIZER, 0); }
		public TerminalNode HYPHEN() { return getToken(LscParser.HYPHEN, 0); }
		public RuleNameContext ruleName() {
			return getRuleContext(RuleNameContext.class,0);
		}
		public TerminalNode RULE_START() { return getToken(LscParser.RULE_START, 0); }
		public TerminalNode NEWLINE() { return getToken(LscParser.NEWLINE, 0); }
		public SubrulesContext subrules() {
			return getRuleContext(SubrulesContext.class,0);
		}
		public InterRomanizerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_interRomanizer; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LscVisitor ) return ((LscVisitor<? extends T>)visitor).visitInterRomanizer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InterRomanizerContext interRomanizer() throws RecognitionException {
		InterRomanizerContext _localctx = new InterRomanizerContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_interRomanizer);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(275);
			match(ROMANIZER);
			setState(276);
			match(HYPHEN);
			setState(277);
			ruleName();
			setState(278);
			match(RULE_START);
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

	public static class ChangeRuleContext extends ParserRuleContext {
		public RuleNameContext ruleName() {
			return getRuleContext(RuleNameContext.class,0);
		}
		public TerminalNode RULE_START() { return getToken(LscParser.RULE_START, 0); }
		public TerminalNode NEWLINE() { return getToken(LscParser.NEWLINE, 0); }
		public SubrulesContext subrules() {
			return getRuleContext(SubrulesContext.class,0);
		}
		public List<TerminalNode> WHITESPACE() { return getTokens(LscParser.WHITESPACE); }
		public TerminalNode WHITESPACE(int i) {
			return getToken(LscParser.WHITESPACE, i);
		}
		public FilterContext filter() {
			return getRuleContext(FilterContext.class,0);
		}
		public TerminalNode PROPAGATE() { return getToken(LscParser.PROPAGATE, 0); }
		public ChangeRuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_changeRule; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LscVisitor ) return ((LscVisitor<? extends T>)visitor).visitChangeRule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ChangeRuleContext changeRule() throws RecognitionException {
		ChangeRuleContext _localctx = new ChangeRuleContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_changeRule);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(282);
			ruleName();
			setState(285);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
			case 1:
				{
				setState(283);
				match(WHITESPACE);
				setState(284);
				filter();
				}
				break;
			}
			setState(289);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WHITESPACE) {
				{
				setState(287);
				match(WHITESPACE);
				setState(288);
				match(PROPAGATE);
				}
			}

			setState(291);
			match(RULE_START);
			setState(292);
			match(NEWLINE);
			setState(293);
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

	public static class FilterContext extends ParserRuleContext {
		public ClassRefContext classRef() {
			return getRuleContext(ClassRefContext.class,0);
		}
		public MatrixContext matrix() {
			return getRuleContext(MatrixContext.class,0);
		}
		public FilterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_filter; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LscVisitor ) return ((LscVisitor<? extends T>)visitor).visitFilter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FilterContext filter() throws RecognitionException {
		FilterContext _localctx = new FilterContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_filter);
		try {
			setState(297);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CLASSREF:
				enterOuterAlt(_localctx, 1);
				{
				setState(295);
				classRef();
				}
				break;
			case MATRIX_START:
				enterOuterAlt(_localctx, 2);
				{
				setState(296);
				matrix();
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
		public List<TerminalNode> RULE_START() { return getTokens(LscParser.RULE_START); }
		public TerminalNode RULE_START(int i) {
			return getToken(LscParser.RULE_START, i);
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
		enterRule(_localctx, 26, RULE_subrules);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(299);
			subrule();
			setState(307);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(300);
					match(NEWLINE);
					setState(301);
					match(SUBRULE);
					setState(302);
					match(RULE_START);
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

	public static class SubruleContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
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
		enterRule(_localctx, 28, RULE_subrule);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(310);
			expression();
			setState(315);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(311);
					match(NEWLINE);
					setState(312);
					expression();
					}
					} 
				}
				setState(317);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
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

	public static class RuleNameContext extends ParserRuleContext {
		public List<TerminalNode> VALUE() { return getTokens(LscParser.VALUE); }
		public TerminalNode VALUE(int i) {
			return getToken(LscParser.VALUE, i);
		}
		public List<TerminalNode> HYPHEN() { return getTokens(LscParser.HYPHEN); }
		public TerminalNode HYPHEN(int i) {
			return getToken(LscParser.HYPHEN, i);
		}
		public RuleNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ruleName; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LscVisitor ) return ((LscVisitor<? extends T>)visitor).visitRuleName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RuleNameContext ruleName() throws RecognitionException {
		RuleNameContext _localctx = new RuleNameContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_ruleName);
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

	public static class ExpressionContext extends ParserRuleContext {
		public FromContext from() {
			return getRuleContext(FromContext.class,0);
		}
		public TerminalNode CHANGE() { return getToken(LscParser.CHANGE, 0); }
		public ToContext to() {
			return getRuleContext(ToContext.class,0);
		}
		public TerminalNode CONDITION() { return getToken(LscParser.CONDITION, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public TerminalNode EXCLUSION() { return getToken(LscParser.EXCLUSION, 0); }
		public ExclusionContext exclusion() {
			return getRuleContext(ExclusionContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LscVisitor ) return ((LscVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(326);
			from();
			setState(327);
			match(CHANGE);
			setState(328);
			to();
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
		public EnvironmentContext environment() {
			return getRuleContext(EnvironmentContext.class,0);
		}
		public EnvironmentListContext environmentList() {
			return getRuleContext(EnvironmentListContext.class,0);
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
		enterRule(_localctx, 34, RULE_condition);
		try {
			setState(339);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,36,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(337);
				environment();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(338);
				environmentList();
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
		public EnvironmentContext environment() {
			return getRuleContext(EnvironmentContext.class,0);
		}
		public EnvironmentListContext environmentList() {
			return getRuleContext(EnvironmentListContext.class,0);
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
		enterRule(_localctx, 36, RULE_exclusion);
		try {
			setState(343);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,37,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(341);
				environment();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(342);
				environmentList();
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

	public static class FromContext extends ParserRuleContext {
		public RuleElementContext ruleElement() {
			return getRuleContext(RuleElementContext.class,0);
		}
		public FromContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_from; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LscVisitor ) return ((LscVisitor<? extends T>)visitor).visitFrom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FromContext from() throws RecognitionException {
		FromContext _localctx = new FromContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_from);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(345);
			ruleElement();
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

	public static class ToContext extends ParserRuleContext {
		public RuleElementContext ruleElement() {
			return getRuleContext(RuleElementContext.class,0);
		}
		public ToContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_to; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LscVisitor ) return ((LscVisitor<? extends T>)visitor).visitTo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ToContext to() throws RecognitionException {
		ToContext _localctx = new ToContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_to);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(347);
			ruleElement();
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

	public static class EnvironmentListContext extends ParserRuleContext {
		public TerminalNode LIST_START() { return getToken(LscParser.LIST_START, 0); }
		public List<EnvironmentContext> environment() {
			return getRuleContexts(EnvironmentContext.class);
		}
		public EnvironmentContext environment(int i) {
			return getRuleContext(EnvironmentContext.class,i);
		}
		public TerminalNode LIST_END() { return getToken(LscParser.LIST_END, 0); }
		public List<TerminalNode> SEP() { return getTokens(LscParser.SEP); }
		public TerminalNode SEP(int i) {
			return getToken(LscParser.SEP, i);
		}
		public EnvironmentListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_environmentList; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LscVisitor ) return ((LscVisitor<? extends T>)visitor).visitEnvironmentList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EnvironmentListContext environmentList() throws RecognitionException {
		EnvironmentListContext _localctx = new EnvironmentListContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_environmentList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(349);
			match(LIST_START);
			setState(350);
			environment();
			setState(355);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SEP) {
				{
				{
				setState(351);
				match(SEP);
				setState(352);
				environment();
				}
				}
				setState(357);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(358);
			match(LIST_END);
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

	public static class EnvironmentContext extends ParserRuleContext {
		public TerminalNode ANCHOR() { return getToken(LscParser.ANCHOR, 0); }
		public BoundaryBeforeContext boundaryBefore() {
			return getRuleContext(BoundaryBeforeContext.class,0);
		}
		public List<TerminalNode> WHITESPACE() { return getTokens(LscParser.WHITESPACE); }
		public TerminalNode WHITESPACE(int i) {
			return getToken(LscParser.WHITESPACE, i);
		}
		public EnvironmentBeforeContext environmentBefore() {
			return getRuleContext(EnvironmentBeforeContext.class,0);
		}
		public EnvironmentAfterContext environmentAfter() {
			return getRuleContext(EnvironmentAfterContext.class,0);
		}
		public BoundaryAfterContext boundaryAfter() {
			return getRuleContext(BoundaryAfterContext.class,0);
		}
		public EnvironmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_environment; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LscVisitor ) return ((LscVisitor<? extends T>)visitor).visitEnvironment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EnvironmentContext environment() throws RecognitionException {
		EnvironmentContext _localctx = new EnvironmentContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_environment);
		int _la;
		try {
			setState(391);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,46,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(363);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,39,_ctx) ) {
				case 1:
					{
					setState(360);
					boundaryBefore();
					setState(361);
					match(WHITESPACE);
					}
					break;
				}
				setState(368);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << O_PAREN) | (1L << NULL) | (1L << MATRIX_START) | (1L << LIST_START) | (1L << NEGATION) | (1L << WORD_BOUNDARY) | (1L << CLASSREF) | (1L << FEATURE) | (1L << VALUE) | (1L << STR1) | (1L << STR))) != 0)) {
					{
					setState(365);
					environmentBefore();
					setState(366);
					match(WHITESPACE);
					}
				}

				setState(370);
				match(ANCHOR);
				setState(373);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,41,_ctx) ) {
				case 1:
					{
					setState(371);
					match(WHITESPACE);
					setState(372);
					environmentAfter();
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
					boundaryAfter();
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(382);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,43,_ctx) ) {
				case 1:
					{
					setState(379);
					boundaryBefore();
					setState(380);
					match(WHITESPACE);
					}
					break;
				}
				setState(385);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << O_PAREN) | (1L << NULL) | (1L << MATRIX_START) | (1L << LIST_START) | (1L << NEGATION) | (1L << WORD_BOUNDARY) | (1L << CLASSREF) | (1L << FEATURE) | (1L << VALUE) | (1L << STR1) | (1L << STR))) != 0)) {
					{
					setState(384);
					environmentBefore();
					}
				}

				setState(389);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==WHITESPACE) {
					{
					setState(387);
					match(WHITESPACE);
					setState(388);
					boundaryAfter();
					}
				}

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

	public static class BoundaryBeforeContext extends ParserRuleContext {
		public TerminalNode WORD_BOUNDARY() { return getToken(LscParser.WORD_BOUNDARY, 0); }
		public BoundaryBeforeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boundaryBefore; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LscVisitor ) return ((LscVisitor<? extends T>)visitor).visitBoundaryBefore(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BoundaryBeforeContext boundaryBefore() throws RecognitionException {
		BoundaryBeforeContext _localctx = new BoundaryBeforeContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_boundaryBefore);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(393);
			match(WORD_BOUNDARY);
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

	public static class BoundaryAfterContext extends ParserRuleContext {
		public TerminalNode WORD_BOUNDARY() { return getToken(LscParser.WORD_BOUNDARY, 0); }
		public BoundaryAfterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boundaryAfter; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LscVisitor ) return ((LscVisitor<? extends T>)visitor).visitBoundaryAfter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BoundaryAfterContext boundaryAfter() throws RecognitionException {
		BoundaryAfterContext _localctx = new BoundaryAfterContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_boundaryAfter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(395);
			match(WORD_BOUNDARY);
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

	public static class EnvironmentBeforeContext extends ParserRuleContext {
		public RuleElementContext ruleElement() {
			return getRuleContext(RuleElementContext.class,0);
		}
		public EnvironmentBeforeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_environmentBefore; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LscVisitor ) return ((LscVisitor<? extends T>)visitor).visitEnvironmentBefore(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EnvironmentBeforeContext environmentBefore() throws RecognitionException {
		EnvironmentBeforeContext _localctx = new EnvironmentBeforeContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_environmentBefore);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(397);
			ruleElement();
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

	public static class EnvironmentAfterContext extends ParserRuleContext {
		public RuleElementContext ruleElement() {
			return getRuleContext(RuleElementContext.class,0);
		}
		public EnvironmentAfterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_environmentAfter; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LscVisitor ) return ((LscVisitor<? extends T>)visitor).visitEnvironmentAfter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EnvironmentAfterContext environmentAfter() throws RecognitionException {
		EnvironmentAfterContext _localctx = new EnvironmentAfterContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_environmentAfter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(399);
			ruleElement();
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

	public static class RuleElementContext extends ParserRuleContext {
		public CaptureContext capture() {
			return getRuleContext(CaptureContext.class,0);
		}
		public RepeaterContext repeater() {
			return getRuleContext(RepeaterContext.class,0);
		}
		public GroupContext group() {
			return getRuleContext(GroupContext.class,0);
		}
		public ListContext list() {
			return getRuleContext(ListContext.class,0);
		}
		public SimpleContext simple() {
			return getRuleContext(SimpleContext.class,0);
		}
		public SequenceContext sequence() {
			return getRuleContext(SequenceContext.class,0);
		}
		public RuleElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ruleElement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LscVisitor ) return ((LscVisitor<? extends T>)visitor).visitRuleElement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RuleElementContext ruleElement() throws RecognitionException {
		RuleElementContext _localctx = new RuleElementContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_ruleElement);
		try {
			setState(407);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,47,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(401);
				capture();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(402);
				repeater();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(403);
				group();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(404);
				list();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(405);
				simple();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(406);
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

	public static class SequenceContext extends ParserRuleContext {
		public List<SequenceElementContext> sequenceElement() {
			return getRuleContexts(SequenceElementContext.class);
		}
		public SequenceElementContext sequenceElement(int i) {
			return getRuleContext(SequenceElementContext.class,i);
		}
		public List<TerminalNode> WHITESPACE() { return getTokens(LscParser.WHITESPACE); }
		public TerminalNode WHITESPACE(int i) {
			return getToken(LscParser.WHITESPACE, i);
		}
		public SequenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sequence; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LscVisitor ) return ((LscVisitor<? extends T>)visitor).visitSequence(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SequenceContext sequence() throws RecognitionException {
		SequenceContext _localctx = new SequenceContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_sequence);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(409);
			sequenceElement();
			setState(412); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(410);
					match(WHITESPACE);
					setState(411);
					sequenceElement();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(414); 
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

	public static class SequenceElementContext extends ParserRuleContext {
		public CaptureContext capture() {
			return getRuleContext(CaptureContext.class,0);
		}
		public RepeaterContext repeater() {
			return getRuleContext(RepeaterContext.class,0);
		}
		public GroupContext group() {
			return getRuleContext(GroupContext.class,0);
		}
		public ListContext list() {
			return getRuleContext(ListContext.class,0);
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
			if ( visitor instanceof LscVisitor ) return ((LscVisitor<? extends T>)visitor).visitSequenceElement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SequenceElementContext sequenceElement() throws RecognitionException {
		SequenceElementContext _localctx = new SequenceElementContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_sequenceElement);
		try {
			setState(421);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,49,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(416);
				capture();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(417);
				repeater();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(418);
				group();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(419);
				list();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(420);
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

	public static class CaptureContext extends ParserRuleContext {
		public CaptureRefContext captureRef() {
			return getRuleContext(CaptureRefContext.class,0);
		}
		public GroupContext group() {
			return getRuleContext(GroupContext.class,0);
		}
		public ListContext list() {
			return getRuleContext(ListContext.class,0);
		}
		public NegatedContext negated() {
			return getRuleContext(NegatedContext.class,0);
		}
		public ClassRefContext classRef() {
			return getRuleContext(ClassRefContext.class,0);
		}
		public FancyMatrixContext fancyMatrix() {
			return getRuleContext(FancyMatrixContext.class,0);
		}
		public CaptureContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_capture; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LscVisitor ) return ((LscVisitor<? extends T>)visitor).visitCapture(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CaptureContext capture() throws RecognitionException {
		CaptureContext _localctx = new CaptureContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_capture);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(428);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case O_PAREN:
				{
				setState(423);
				group();
				}
				break;
			case LIST_START:
				{
				setState(424);
				list();
				}
				break;
			case NEGATION:
				{
				setState(425);
				negated();
				}
				break;
			case CLASSREF:
				{
				setState(426);
				classRef();
				}
				break;
			case MATRIX_START:
				{
				setState(427);
				fancyMatrix();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(430);
			captureRef();
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
		public ListContext list() {
			return getRuleContext(ListContext.class,0);
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
			if ( visitor instanceof LscVisitor ) return ((LscVisitor<? extends T>)visitor).visitRepeater(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RepeaterContext repeater() throws RecognitionException {
		RepeaterContext _localctx = new RepeaterContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_repeater);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(435);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case O_PAREN:
				{
				setState(432);
				group();
				}
				break;
			case LIST_START:
				{
				setState(433);
				list();
				}
				break;
			case NULL:
			case MATRIX_START:
			case NEGATION:
			case WORD_BOUNDARY:
			case CLASSREF:
			case FEATURE:
			case VALUE:
			case STR1:
			case STR:
				{
				setState(434);
				simple();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(437);
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

	public static class GroupContext extends ParserRuleContext {
		public TerminalNode O_PAREN() { return getToken(LscParser.O_PAREN, 0); }
		public RuleElementContext ruleElement() {
			return getRuleContext(RuleElementContext.class,0);
		}
		public TerminalNode C_PAREN() { return getToken(LscParser.C_PAREN, 0); }
		public GroupContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_group; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LscVisitor ) return ((LscVisitor<? extends T>)visitor).visitGroup(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GroupContext group() throws RecognitionException {
		GroupContext _localctx = new GroupContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_group);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(439);
			match(O_PAREN);
			setState(440);
			ruleElement();
			setState(441);
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

	public static class ListContext extends ParserRuleContext {
		public TerminalNode LIST_START() { return getToken(LscParser.LIST_START, 0); }
		public List<RuleElementContext> ruleElement() {
			return getRuleContexts(RuleElementContext.class);
		}
		public RuleElementContext ruleElement(int i) {
			return getRuleContext(RuleElementContext.class,i);
		}
		public TerminalNode LIST_END() { return getToken(LscParser.LIST_END, 0); }
		public List<TerminalNode> SEP() { return getTokens(LscParser.SEP); }
		public TerminalNode SEP(int i) {
			return getToken(LscParser.SEP, i);
		}
		public ListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_list; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LscVisitor ) return ((LscVisitor<? extends T>)visitor).visitList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ListContext list() throws RecognitionException {
		ListContext _localctx = new ListContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(443);
			match(LIST_START);
			setState(444);
			ruleElement();
			setState(449);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SEP) {
				{
				{
				setState(445);
				match(SEP);
				setState(446);
				ruleElement();
				}
				}
				setState(451);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(452);
			match(LIST_END);
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
		public NegatedContext negated() {
			return getRuleContext(NegatedContext.class,0);
		}
		public ClassRefContext classRef() {
			return getRuleContext(ClassRefContext.class,0);
		}
		public CaptureRefContext captureRef() {
			return getRuleContext(CaptureRefContext.class,0);
		}
		public FancyMatrixContext fancyMatrix() {
			return getRuleContext(FancyMatrixContext.class,0);
		}
		public EmptyContext empty() {
			return getRuleContext(EmptyContext.class,0);
		}
		public TextContext text() {
			return getRuleContext(TextContext.class,0);
		}
		public SimpleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simple; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LscVisitor ) return ((LscVisitor<? extends T>)visitor).visitSimple(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SimpleContext simple() throws RecognitionException {
		SimpleContext _localctx = new SimpleContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_simple);
		try {
			setState(460);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NEGATION:
				enterOuterAlt(_localctx, 1);
				{
				setState(454);
				negated();
				}
				break;
			case CLASSREF:
				enterOuterAlt(_localctx, 2);
				{
				setState(455);
				classRef();
				}
				break;
			case WORD_BOUNDARY:
				enterOuterAlt(_localctx, 3);
				{
				setState(456);
				captureRef();
				}
				break;
			case MATRIX_START:
				enterOuterAlt(_localctx, 4);
				{
				setState(457);
				fancyMatrix();
				}
				break;
			case NULL:
				enterOuterAlt(_localctx, 5);
				{
				setState(458);
				empty();
				}
				break;
			case FEATURE:
			case VALUE:
			case STR1:
			case STR:
				enterOuterAlt(_localctx, 6);
				{
				setState(459);
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

	public static class NegatedContext extends ParserRuleContext {
		public TerminalNode NEGATION() { return getToken(LscParser.NEGATION, 0); }
		public ClassRefContext classRef() {
			return getRuleContext(ClassRefContext.class,0);
		}
		public NegatedContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_negated; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LscVisitor ) return ((LscVisitor<? extends T>)visitor).visitNegated(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NegatedContext negated() throws RecognitionException {
		NegatedContext _localctx = new NegatedContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_negated);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(462);
			match(NEGATION);
			setState(463);
			classRef();
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

	public static class ClassRefContext extends ParserRuleContext {
		public TerminalNode CLASSREF() { return getToken(LscParser.CLASSREF, 0); }
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public ClassRefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classRef; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LscVisitor ) return ((LscVisitor<? extends T>)visitor).visitClassRef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassRefContext classRef() throws RecognitionException {
		ClassRefContext _localctx = new ClassRefContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_classRef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(465);
			match(CLASSREF);
			setState(466);
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

	public static class CaptureRefContext extends ParserRuleContext {
		public TerminalNode WORD_BOUNDARY() { return getToken(LscParser.WORD_BOUNDARY, 0); }
		public TerminalNode NUMBER() { return getToken(LscParser.NUMBER, 0); }
		public CaptureRefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_captureRef; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LscVisitor ) return ((LscVisitor<? extends T>)visitor).visitCaptureRef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CaptureRefContext captureRef() throws RecognitionException {
		CaptureRefContext _localctx = new CaptureRefContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_captureRef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(468);
			match(WORD_BOUNDARY);
			setState(469);
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

	public static class FancyMatrixContext extends ParserRuleContext {
		public TerminalNode MATRIX_START() { return getToken(LscParser.MATRIX_START, 0); }
		public TerminalNode MATRIX_END() { return getToken(LscParser.MATRIX_END, 0); }
		public List<FancyValueContext> fancyValue() {
			return getRuleContexts(FancyValueContext.class);
		}
		public FancyValueContext fancyValue(int i) {
			return getRuleContext(FancyValueContext.class,i);
		}
		public List<TerminalNode> WHITESPACE() { return getTokens(LscParser.WHITESPACE); }
		public TerminalNode WHITESPACE(int i) {
			return getToken(LscParser.WHITESPACE, i);
		}
		public FancyMatrixContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fancyMatrix; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LscVisitor ) return ((LscVisitor<? extends T>)visitor).visitFancyMatrix(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FancyMatrixContext fancyMatrix() throws RecognitionException {
		FancyMatrixContext _localctx = new FancyMatrixContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_fancyMatrix);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(471);
			match(MATRIX_START);
			setState(473);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NULL) | (1L << NEGATION) | (1L << WORD_BOUNDARY) | (1L << VALUE))) != 0)) {
				{
				setState(472);
				fancyValue();
				}
			}

			setState(479);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WHITESPACE) {
				{
				{
				setState(475);
				match(WHITESPACE);
				setState(476);
				fancyValue();
				}
				}
				setState(481);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(482);
			match(MATRIX_END);
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

	public static class FancyValueContext extends ParserRuleContext {
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public NegatedValueContext negatedValue() {
			return getRuleContext(NegatedValueContext.class,0);
		}
		public AbsentFeatureContext absentFeature() {
			return getRuleContext(AbsentFeatureContext.class,0);
		}
		public FeatureVariableContext featureVariable() {
			return getRuleContext(FeatureVariableContext.class,0);
		}
		public FancyValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fancyValue; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LscVisitor ) return ((LscVisitor<? extends T>)visitor).visitFancyValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FancyValueContext fancyValue() throws RecognitionException {
		FancyValueContext _localctx = new FancyValueContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_fancyValue);
		try {
			setState(488);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VALUE:
				enterOuterAlt(_localctx, 1);
				{
				setState(484);
				value();
				}
				break;
			case NEGATION:
				enterOuterAlt(_localctx, 2);
				{
				setState(485);
				negatedValue();
				}
				break;
			case NULL:
				enterOuterAlt(_localctx, 3);
				{
				setState(486);
				absentFeature();
				}
				break;
			case WORD_BOUNDARY:
				enterOuterAlt(_localctx, 4);
				{
				setState(487);
				featureVariable();
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

	public static class NegatedValueContext extends ParserRuleContext {
		public TerminalNode NEGATION() { return getToken(LscParser.NEGATION, 0); }
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public NegatedValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_negatedValue; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LscVisitor ) return ((LscVisitor<? extends T>)visitor).visitNegatedValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NegatedValueContext negatedValue() throws RecognitionException {
		NegatedValueContext _localctx = new NegatedValueContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_negatedValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(490);
			match(NEGATION);
			setState(491);
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

	public static class AbsentFeatureContext extends ParserRuleContext {
		public TerminalNode NULL() { return getToken(LscParser.NULL, 0); }
		public FeatureContext feature() {
			return getRuleContext(FeatureContext.class,0);
		}
		public AbsentFeatureContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_absentFeature; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LscVisitor ) return ((LscVisitor<? extends T>)visitor).visitAbsentFeature(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AbsentFeatureContext absentFeature() throws RecognitionException {
		AbsentFeatureContext _localctx = new AbsentFeatureContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_absentFeature);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(493);
			match(NULL);
			setState(494);
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

	public static class FeatureVariableContext extends ParserRuleContext {
		public TerminalNode WORD_BOUNDARY() { return getToken(LscParser.WORD_BOUNDARY, 0); }
		public FeatureContext feature() {
			return getRuleContext(FeatureContext.class,0);
		}
		public FeatureVariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_featureVariable; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LscVisitor ) return ((LscVisitor<? extends T>)visitor).visitFeatureVariable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FeatureVariableContext featureVariable() throws RecognitionException {
		FeatureVariableContext _localctx = new FeatureVariableContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_featureVariable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(496);
			match(WORD_BOUNDARY);
			setState(497);
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
		enterRule(_localctx, 86, RULE_empty);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(499);
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

	public static class RepeaterTypeContext extends ParserRuleContext {
		public TerminalNode AT_LEAST_ONE() { return getToken(LscParser.AT_LEAST_ONE, 0); }
		public TerminalNode NULL() { return getToken(LscParser.NULL, 0); }
		public TerminalNode OPTIONAL() { return getToken(LscParser.OPTIONAL, 0); }
		public RepeaterTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_repeaterType; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LscVisitor ) return ((LscVisitor<? extends T>)visitor).visitRepeaterType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RepeaterTypeContext repeaterType() throws RecognitionException {
		RepeaterTypeContext _localctx = new RepeaterTypeContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_repeaterType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(501);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NULL) | (1L << AT_LEAST_ONE) | (1L << OPTIONAL))) != 0)) ) {
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
		public TerminalNode MATRIX_START() { return getToken(LscParser.MATRIX_START, 0); }
		public TerminalNode MATRIX_END() { return getToken(LscParser.MATRIX_END, 0); }
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
		enterRule(_localctx, 90, RULE_matrix);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(503);
			match(MATRIX_START);
			setState(505);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==VALUE) {
				{
				setState(504);
				value();
				}
			}

			setState(511);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WHITESPACE) {
				{
				{
				setState(507);
				match(WHITESPACE);
				setState(508);
				value();
				}
				}
				setState(513);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(514);
			match(MATRIX_END);
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
		enterRule(_localctx, 92, RULE_feature);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(516);
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
		enterRule(_localctx, 94, RULE_value);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(518);
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
		enterRule(_localctx, 96, RULE_text);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(520);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << FEATURE) | (1L << VALUE) | (1L << STR1) | (1L << STR))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(522);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NEGATION) {
				{
				setState(521);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\'\u020f\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\3\2\3\2\6\2g\n\2"+
		"\r\2\16\2h\7\2k\n\2\f\2\16\2n\13\2\3\2\3\2\6\2r\n\2\r\2\16\2s\7\2v\n\2"+
		"\f\2\16\2y\13\2\3\2\3\2\6\2}\n\2\r\2\16\2~\7\2\u0081\n\2\f\2\16\2\u0084"+
		"\13\2\3\2\3\2\6\2\u0088\n\2\r\2\16\2\u0089\7\2\u008c\n\2\f\2\16\2\u008f"+
		"\13\2\3\2\3\2\6\2\u0093\n\2\r\2\16\2\u0094\5\2\u0097\n\2\3\2\5\2\u009a"+
		"\n\2\3\2\6\2\u009d\n\2\r\2\16\2\u009e\3\2\3\2\5\2\u00a3\n\2\7\2\u00a5"+
		"\n\2\f\2\16\2\u00a8\13\2\3\2\6\2\u00ab\n\2\r\2\16\2\u00ac\3\2\5\2\u00b0"+
		"\n\2\3\2\6\2\u00b3\n\2\r\2\16\2\u00b4\3\2\5\2\u00b8\n\2\3\2\7\2\u00bb"+
		"\n\2\f\2\16\2\u00be\13\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\7\3\u00ca"+
		"\n\3\f\3\16\3\u00cd\13\3\3\3\3\3\3\4\3\4\5\4\u00d3\n\4\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\5\5\u00dc\n\5\3\5\3\5\3\5\7\5\u00e1\n\5\f\5\16\5\u00e4\13"+
		"\5\3\5\3\5\3\5\5\5\u00e9\n\5\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\5\7\u00f4"+
		"\n\7\3\7\3\7\5\7\u00f8\n\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\7\b\u0101\n\b\f"+
		"\b\16\b\u0104\13\b\3\b\3\b\5\b\u0108\n\b\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3"+
		"\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\5\r\u0120"+
		"\n\r\3\r\3\r\5\r\u0124\n\r\3\r\3\r\3\r\3\r\3\16\3\16\5\16\u012c\n\16\3"+
		"\17\3\17\3\17\3\17\3\17\3\17\7\17\u0134\n\17\f\17\16\17\u0137\13\17\3"+
		"\20\3\20\3\20\7\20\u013c\n\20\f\20\16\20\u013f\13\20\3\21\3\21\3\21\7"+
		"\21\u0144\n\21\f\21\16\21\u0147\13\21\3\22\3\22\3\22\3\22\3\22\5\22\u014e"+
		"\n\22\3\22\3\22\5\22\u0152\n\22\3\23\3\23\5\23\u0156\n\23\3\24\3\24\5"+
		"\24\u015a\n\24\3\25\3\25\3\26\3\26\3\27\3\27\3\27\3\27\7\27\u0164\n\27"+
		"\f\27\16\27\u0167\13\27\3\27\3\27\3\30\3\30\3\30\5\30\u016e\n\30\3\30"+
		"\3\30\3\30\5\30\u0173\n\30\3\30\3\30\3\30\5\30\u0178\n\30\3\30\3\30\5"+
		"\30\u017c\n\30\3\30\3\30\3\30\5\30\u0181\n\30\3\30\5\30\u0184\n\30\3\30"+
		"\3\30\5\30\u0188\n\30\5\30\u018a\n\30\3\31\3\31\3\32\3\32\3\33\3\33\3"+
		"\34\3\34\3\35\3\35\3\35\3\35\3\35\3\35\5\35\u019a\n\35\3\36\3\36\3\36"+
		"\6\36\u019f\n\36\r\36\16\36\u01a0\3\37\3\37\3\37\3\37\3\37\5\37\u01a8"+
		"\n\37\3 \3 \3 \3 \3 \5 \u01af\n \3 \3 \3!\3!\3!\5!\u01b6\n!\3!\3!\3\""+
		"\3\"\3\"\3\"\3#\3#\3#\3#\7#\u01c2\n#\f#\16#\u01c5\13#\3#\3#\3$\3$\3$\3"+
		"$\3$\3$\5$\u01cf\n$\3%\3%\3%\3&\3&\3&\3\'\3\'\3\'\3(\3(\5(\u01dc\n(\3"+
		"(\3(\7(\u01e0\n(\f(\16(\u01e3\13(\3(\3(\3)\3)\3)\3)\5)\u01eb\n)\3*\3*"+
		"\3*\3+\3+\3+\3,\3,\3,\3-\3-\3.\3.\3/\3/\5/\u01fc\n/\3/\3/\7/\u0200\n/"+
		"\f/\16/\u0203\13/\3/\3/\3\60\3\60\3\61\3\61\3\62\3\62\5\62\u020d\n\62"+
		"\3\62\2\2\63\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64"+
		"\668:<>@BDFHJLNPRTVXZ\\^`b\2\5\3\2\t\n\4\2\r\r\22\23\4\2#$&\'\2\u022a"+
		"\2l\3\2\2\2\4\u00c1\3\2\2\2\6\u00d2\3\2\2\2\b\u00d4\3\2\2\2\n\u00ea\3"+
		"\2\2\2\f\u00ed\3\2\2\2\16\u00fb\3\2\2\2\20\u0109\3\2\2\2\22\u010b\3\2"+
		"\2\2\24\u0110\3\2\2\2\26\u0115\3\2\2\2\30\u011c\3\2\2\2\32\u012b\3\2\2"+
		"\2\34\u012d\3\2\2\2\36\u0138\3\2\2\2 \u0140\3\2\2\2\"\u0148\3\2\2\2$\u0155"+
		"\3\2\2\2&\u0159\3\2\2\2(\u015b\3\2\2\2*\u015d\3\2\2\2,\u015f\3\2\2\2."+
		"\u0189\3\2\2\2\60\u018b\3\2\2\2\62\u018d\3\2\2\2\64\u018f\3\2\2\2\66\u0191"+
		"\3\2\2\28\u0199\3\2\2\2:\u019b\3\2\2\2<\u01a7\3\2\2\2>\u01ae\3\2\2\2@"+
		"\u01b5\3\2\2\2B\u01b9\3\2\2\2D\u01bd\3\2\2\2F\u01ce\3\2\2\2H\u01d0\3\2"+
		"\2\2J\u01d3\3\2\2\2L\u01d6\3\2\2\2N\u01d9\3\2\2\2P\u01ea\3\2\2\2R\u01ec"+
		"\3\2\2\2T\u01ef\3\2\2\2V\u01f2\3\2\2\2X\u01f5\3\2\2\2Z\u01f7\3\2\2\2\\"+
		"\u01f9\3\2\2\2^\u0206\3\2\2\2`\u0208\3\2\2\2b\u020a\3\2\2\2df\5\b\5\2"+
		"eg\7\t\2\2fe\3\2\2\2gh\3\2\2\2hf\3\2\2\2hi\3\2\2\2ik\3\2\2\2jd\3\2\2\2"+
		"kn\3\2\2\2lj\3\2\2\2lm\3\2\2\2mw\3\2\2\2nl\3\2\2\2oq\5\f\7\2pr\7\t\2\2"+
		"qp\3\2\2\2rs\3\2\2\2sq\3\2\2\2st\3\2\2\2tv\3\2\2\2uo\3\2\2\2vy\3\2\2\2"+
		"wu\3\2\2\2wx\3\2\2\2x\u0082\3\2\2\2yw\3\2\2\2z|\5\16\b\2{}\7\t\2\2|{\3"+
		"\2\2\2}~\3\2\2\2~|\3\2\2\2~\177\3\2\2\2\177\u0081\3\2\2\2\u0080z\3\2\2"+
		"\2\u0081\u0084\3\2\2\2\u0082\u0080\3\2\2\2\u0082\u0083\3\2\2\2\u0083\u008d"+
		"\3\2\2\2\u0084\u0082\3\2\2\2\u0085\u0087\5\4\3\2\u0086\u0088\7\t\2\2\u0087"+
		"\u0086\3\2\2\2\u0088\u0089\3\2\2\2\u0089\u0087\3\2\2\2\u0089\u008a\3\2"+
		"\2\2\u008a\u008c\3\2\2\2\u008b\u0085\3\2\2\2\u008c\u008f\3\2\2\2\u008d"+
		"\u008b\3\2\2\2\u008d\u008e\3\2\2\2\u008e\u0096\3\2\2\2\u008f\u008d\3\2"+
		"\2\2\u0090\u0092\5\22\n\2\u0091\u0093\7\t\2\2\u0092\u0091\3\2\2\2\u0093"+
		"\u0094\3\2\2\2\u0094\u0092\3\2\2\2\u0094\u0095\3\2\2\2\u0095\u0097\3\2"+
		"\2\2\u0096\u0090\3\2\2\2\u0096\u0097\3\2\2\2\u0097\u0099\3\2\2\2\u0098"+
		"\u009a\5\30\r\2\u0099\u0098\3\2\2\2\u0099\u009a\3\2\2\2\u009a\u00af\3"+
		"\2\2\2\u009b\u009d\7\t\2\2\u009c\u009b\3\2\2\2\u009d\u009e\3\2\2\2\u009e"+
		"\u009c\3\2\2\2\u009e\u009f\3\2\2\2\u009f\u00a2\3\2\2\2\u00a0\u00a3\5\30"+
		"\r\2\u00a1\u00a3\5\26\f\2\u00a2\u00a0\3\2\2\2\u00a2\u00a1\3\2\2\2\u00a3"+
		"\u00a5\3\2\2\2\u00a4\u009c\3\2\2\2\u00a5\u00a8\3\2\2\2\u00a6\u00a4\3\2"+
		"\2\2\u00a6\u00a7\3\2\2\2\u00a7\u00aa\3\2\2\2\u00a8\u00a6\3\2\2\2\u00a9"+
		"\u00ab\7\t\2\2\u00aa\u00a9\3\2\2\2\u00ab\u00ac\3\2\2\2\u00ac\u00aa\3\2"+
		"\2\2\u00ac\u00ad\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ae\u00b0\5\30\r\2\u00af"+
		"\u00a6\3\2\2\2\u00af\u00b0\3\2\2\2\u00b0\u00b7\3\2\2\2\u00b1\u00b3\7\t"+
		"\2\2\u00b2\u00b1\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4\u00b2\3\2\2\2\u00b4"+
		"\u00b5\3\2\2\2\u00b5\u00b6\3\2\2\2\u00b6\u00b8\5\24\13\2\u00b7\u00b2\3"+
		"\2\2\2\u00b7\u00b8\3\2\2\2\u00b8\u00bc\3\2\2\2\u00b9\u00bb\7\t\2\2\u00ba"+
		"\u00b9\3\2\2\2\u00bb\u00be\3\2\2\2\u00bc\u00ba\3\2\2\2\u00bc\u00bd\3\2"+
		"\2\2\u00bd\u00bf\3\2\2\2\u00be\u00bc\3\2\2\2\u00bf\u00c0\7\2\2\3\u00c0"+
		"\3\3\2\2\2\u00c1\u00c2\7\31\2\2\u00c2\u00c3\7\n\2\2\u00c3\u00c4\5`\61"+
		"\2\u00c4\u00c5\7\n\2\2\u00c5\u00c6\7\20\2\2\u00c6\u00cb\5\6\4\2\u00c7"+
		"\u00c8\7\4\2\2\u00c8\u00ca\5\6\4\2\u00c9\u00c7\3\2\2\2\u00ca\u00cd\3\2"+
		"\2\2\u00cb\u00c9\3\2\2\2\u00cb\u00cc\3\2\2\2\u00cc\u00ce\3\2\2\2\u00cd"+
		"\u00cb\3\2\2\2\u00ce\u00cf\7\21\2\2\u00cf\5\3\2\2\2\u00d0\u00d3\5J&\2"+
		"\u00d1\u00d3\5b\62\2\u00d2\u00d0\3\2\2\2\u00d2\u00d1\3\2\2\2\u00d3\7\3"+
		"\2\2\2\u00d4\u00d5\7\32\2\2\u00d5\u00d6\7\n\2\2\u00d6\u00d7\5^\60\2\u00d7"+
		"\u00db\7\13\2\2\u00d8\u00d9\5\n\6\2\u00d9\u00da\7\4\2\2\u00da\u00dc\3"+
		"\2\2\2\u00db\u00d8\3\2\2\2\u00db\u00dc\3\2\2\2\u00dc\u00dd\3\2\2\2\u00dd"+
		"\u00e2\5`\61\2\u00de\u00df\7\4\2\2\u00df\u00e1\5`\61\2\u00e0\u00de\3\2"+
		"\2\2\u00e1\u00e4\3\2\2\2\u00e2\u00e0\3\2\2\2\u00e2\u00e3\3\2\2\2\u00e3"+
		"\u00e5\3\2\2\2\u00e4\u00e2\3\2\2\2\u00e5\u00e8\7\f\2\2\u00e6\u00e7\7\5"+
		"\2\2\u00e7\u00e9\5\\/\2\u00e8\u00e6\3\2\2\2\u00e8\u00e9\3\2\2\2\u00e9"+
		"\t\3\2\2\2\u00ea\u00eb\7\r\2\2\u00eb\u00ec\5`\61\2\u00ec\13\3\2\2\2\u00ed"+
		"\u00ee\7\33\2\2\u00ee\u00ef\7\n\2\2\u00ef\u00f0\7&\2\2\u00f0\u00f3\7\n"+
		"\2\2\u00f1\u00f2\7\34\2\2\u00f2\u00f4\7\n\2\2\u00f3\u00f1\3\2\2\2\u00f3"+
		"\u00f4\3\2\2\2\u00f4\u00f7\3\2\2\2\u00f5\u00f6\7\35\2\2\u00f6\u00f8\7"+
		"\n\2\2\u00f7\u00f5\3\2\2\2\u00f7\u00f8\3\2\2\2\u00f8\u00f9\3\2\2\2\u00f9"+
		"\u00fa\5\\/\2\u00fa\r\3\2\2\2\u00fb\u00fc\7\36\2\2\u00fc\u00fd\7\n\2\2"+
		"\u00fd\u0107\5\20\t\2\u00fe\u00ff\7\4\2\2\u00ff\u0101\5\20\t\2\u0100\u00fe"+
		"\3\2\2\2\u0101\u0104\3\2\2\2\u0102\u0100\3\2\2\2\u0102\u0103\3\2\2\2\u0103"+
		"\u0108\3\2\2\2\u0104\u0102\3\2\2\2\u0105\u0106\7\n\2\2\u0106\u0108\5\\"+
		"/\2\u0107\u0102\3\2\2\2\u0107\u0105\3\2\2\2\u0108\17\3\2\2\2\u0109\u010a"+
		"\5b\62\2\u010a\21\3\2\2\2\u010b\u010c\7\37\2\2\u010c\u010d\7\25\2\2\u010d"+
		"\u010e\7\t\2\2\u010e\u010f\5\34\17\2\u010f\23\3\2\2\2\u0110\u0111\7 \2"+
		"\2\u0111\u0112\7\25\2\2\u0112\u0113\7\t\2\2\u0113\u0114\5\34\17\2\u0114"+
		"\25\3\2\2\2\u0115\u0116\7 \2\2\u0116\u0117\7\24\2\2\u0117\u0118\5 \21"+
		"\2\u0118\u0119\7\25\2\2\u0119\u011a\7\t\2\2\u011a\u011b\5\34\17\2\u011b"+
		"\27\3\2\2\2\u011c\u011f\5 \21\2\u011d\u011e\7\n\2\2\u011e\u0120\5\32\16"+
		"\2\u011f\u011d\3\2\2\2\u011f\u0120\3\2\2\2\u0120\u0123\3\2\2\2\u0121\u0122"+
		"\7\n\2\2\u0122\u0124\7\"\2\2\u0123\u0121\3\2\2\2\u0123\u0124\3\2\2\2\u0124"+
		"\u0125\3\2\2\2\u0125\u0126\7\25\2\2\u0126\u0127\7\t\2\2\u0127\u0128\5"+
		"\34\17\2\u0128\31\3\2\2\2\u0129\u012c\5J&\2\u012a\u012c\5\\/\2\u012b\u0129"+
		"\3\2\2\2\u012b\u012a\3\2\2\2\u012c\33\3\2\2\2\u012d\u0135\5\36\20\2\u012e"+
		"\u012f\7\t\2\2\u012f\u0130\7!\2\2\u0130\u0131\7\25\2\2\u0131\u0132\t\2"+
		"\2\2\u0132\u0134\5\36\20\2\u0133\u012e\3\2\2\2\u0134\u0137\3\2\2\2\u0135"+
		"\u0133\3\2\2\2\u0135\u0136\3\2\2\2\u0136\35\3\2\2\2\u0137\u0135\3\2\2"+
		"\2\u0138\u013d\5\"\22\2\u0139\u013a\7\t\2\2\u013a\u013c\5\"\22\2\u013b"+
		"\u0139\3\2\2\2\u013c\u013f\3\2\2\2\u013d\u013b\3\2\2\2\u013d\u013e\3\2"+
		"\2\2\u013e\37\3\2\2\2\u013f\u013d\3\2\2\2\u0140\u0145\7$\2\2\u0141\u0142"+
		"\7\24\2\2\u0142\u0144\7$\2\2\u0143\u0141\3\2\2\2\u0144\u0147\3\2\2\2\u0145"+
		"\u0143\3\2\2\2\u0145\u0146\3\2\2\2\u0146!\3\2\2\2\u0147\u0145\3\2\2\2"+
		"\u0148\u0149\5(\25\2\u0149\u014a\7\5\2\2\u014a\u014d\5*\26\2\u014b\u014c"+
		"\7\6\2\2\u014c\u014e\5$\23\2\u014d\u014b\3\2\2\2\u014d\u014e\3\2\2\2\u014e"+
		"\u0151\3\2\2\2\u014f\u0150\7\7\2\2\u0150\u0152\5&\24\2\u0151\u014f\3\2"+
		"\2\2\u0151\u0152\3\2\2\2\u0152#\3\2\2\2\u0153\u0156\5.\30\2\u0154\u0156"+
		"\5,\27\2\u0155\u0153\3\2\2\2\u0155\u0154\3\2\2\2\u0156%\3\2\2\2\u0157"+
		"\u015a\5.\30\2\u0158\u015a\5,\27\2\u0159\u0157\3\2\2\2\u0159\u0158\3\2"+
		"\2\2\u015a\'\3\2\2\2\u015b\u015c\58\35\2\u015c)\3\2\2\2\u015d\u015e\5"+
		"8\35\2\u015e+\3\2\2\2\u015f\u0160\7\20\2\2\u0160\u0165\5.\30\2\u0161\u0162"+
		"\7\4\2\2\u0162\u0164\5.\30\2\u0163\u0161\3\2\2\2\u0164\u0167\3\2\2\2\u0165"+
		"\u0163\3\2\2\2\u0165\u0166\3\2\2\2\u0166\u0168\3\2\2\2\u0167\u0165\3\2"+
		"\2\2\u0168\u0169\7\21\2\2\u0169-\3\2\2\2\u016a\u016b\5\60\31\2\u016b\u016c"+
		"\7\n\2\2\u016c\u016e\3\2\2\2\u016d\u016a\3\2\2\2\u016d\u016e\3\2\2\2\u016e"+
		"\u0172\3\2\2\2\u016f\u0170\5\64\33\2\u0170\u0171\7\n\2\2\u0171\u0173\3"+
		"\2\2\2\u0172\u016f\3\2\2\2\u0172\u0173\3\2\2\2\u0173\u0174\3\2\2\2\u0174"+
		"\u0177\7\b\2\2\u0175\u0176\7\n\2\2\u0176\u0178\5\66\34\2\u0177\u0175\3"+
		"\2\2\2\u0177\u0178\3\2\2\2\u0178\u017b\3\2\2\2\u0179\u017a\7\n\2\2\u017a"+
		"\u017c\5\62\32\2\u017b\u0179\3\2\2\2\u017b\u017c\3\2\2\2\u017c\u018a\3"+
		"\2\2\2\u017d\u017e\5\60\31\2\u017e\u017f\7\n\2\2\u017f\u0181\3\2\2\2\u0180"+
		"\u017d\3\2\2\2\u0180\u0181\3\2\2\2\u0181\u0183\3\2\2\2\u0182\u0184\5\64"+
		"\33\2\u0183\u0182\3\2\2\2\u0183\u0184\3\2\2\2\u0184\u0187\3\2\2\2\u0185"+
		"\u0186\7\n\2\2\u0186\u0188\5\62\32\2\u0187\u0185\3\2\2\2\u0187\u0188\3"+
		"\2\2\2\u0188\u018a\3\2\2\2\u0189\u016d\3\2\2\2\u0189\u0180\3\2\2\2\u018a"+
		"/\3\2\2\2\u018b\u018c\7\27\2\2\u018c\61\3\2\2\2\u018d\u018e\7\27\2\2\u018e"+
		"\63\3\2\2\2\u018f\u0190\58\35\2\u0190\65\3\2\2\2\u0191\u0192\58\35\2\u0192"+
		"\67\3\2\2\2\u0193\u019a\5> \2\u0194\u019a\5@!\2\u0195\u019a\5B\"\2\u0196"+
		"\u019a\5D#\2\u0197\u019a\5F$\2\u0198\u019a\5:\36\2\u0199\u0193\3\2\2\2"+
		"\u0199\u0194\3\2\2\2\u0199\u0195\3\2\2\2\u0199\u0196\3\2\2\2\u0199\u0197"+
		"\3\2\2\2\u0199\u0198\3\2\2\2\u019a9\3\2\2\2\u019b\u019e\5<\37\2\u019c"+
		"\u019d\7\n\2\2\u019d\u019f\5<\37\2\u019e\u019c\3\2\2\2\u019f\u01a0\3\2"+
		"\2\2\u01a0\u019e\3\2\2\2\u01a0\u01a1\3\2\2\2\u01a1;\3\2\2\2\u01a2\u01a8"+
		"\5> \2\u01a3\u01a8\5@!\2\u01a4\u01a8\5B\"\2\u01a5\u01a8\5D#\2\u01a6\u01a8"+
		"\5F$\2\u01a7\u01a2\3\2\2\2\u01a7\u01a3\3\2\2\2\u01a7\u01a4\3\2\2\2\u01a7"+
		"\u01a5\3\2\2\2\u01a7\u01a6\3\2\2\2\u01a8=\3\2\2\2\u01a9\u01af\5B\"\2\u01aa"+
		"\u01af\5D#\2\u01ab\u01af\5H%\2\u01ac\u01af\5J&\2\u01ad\u01af\5N(\2\u01ae"+
		"\u01a9\3\2\2\2\u01ae\u01aa\3\2\2\2\u01ae\u01ab\3\2\2\2\u01ae\u01ac\3\2"+
		"\2\2\u01ae\u01ad\3\2\2\2\u01af\u01b0\3\2\2\2\u01b0\u01b1\5L\'\2\u01b1"+
		"?\3\2\2\2\u01b2\u01b6\5B\"\2\u01b3\u01b6\5D#\2\u01b4\u01b6\5F$\2\u01b5"+
		"\u01b2\3\2\2\2\u01b5\u01b3\3\2\2\2\u01b5\u01b4\3\2\2\2\u01b6\u01b7\3\2"+
		"\2\2\u01b7\u01b8\5Z.\2\u01b8A\3\2\2\2\u01b9\u01ba\7\13\2\2\u01ba\u01bb"+
		"\58\35\2\u01bb\u01bc\7\f\2\2\u01bcC\3\2\2\2\u01bd\u01be\7\20\2\2\u01be"+
		"\u01c3\58\35\2\u01bf\u01c0\7\4\2\2\u01c0\u01c2\58\35\2\u01c1\u01bf\3\2"+
		"\2\2\u01c2\u01c5\3\2\2\2\u01c3\u01c1\3\2\2\2\u01c3\u01c4\3\2\2\2\u01c4"+
		"\u01c6\3\2\2\2\u01c5\u01c3\3\2\2\2\u01c6\u01c7\7\21\2\2\u01c7E\3\2\2\2"+
		"\u01c8\u01cf\5H%\2\u01c9\u01cf\5J&\2\u01ca\u01cf\5L\'\2\u01cb\u01cf\5"+
		"N(\2\u01cc\u01cf\5X-\2\u01cd\u01cf\5b\62\2\u01ce\u01c8\3\2\2\2\u01ce\u01c9"+
		"\3\2\2\2\u01ce\u01ca\3\2\2\2\u01ce\u01cb\3\2\2\2\u01ce\u01cc\3\2\2\2\u01ce"+
		"\u01cd\3\2\2\2\u01cfG\3\2\2\2\u01d0\u01d1\7\26\2\2\u01d1\u01d2\5J&\2\u01d2"+
		"I\3\2\2\2\u01d3\u01d4\7\30\2\2\u01d4\u01d5\5`\61\2\u01d5K\3\2\2\2\u01d6"+
		"\u01d7\7\27\2\2\u01d7\u01d8\7%\2\2\u01d8M\3\2\2\2\u01d9\u01db\7\16\2\2"+
		"\u01da\u01dc\5P)\2\u01db\u01da\3\2\2\2\u01db\u01dc\3\2\2\2\u01dc\u01e1"+
		"\3\2\2\2\u01dd\u01de\7\n\2\2\u01de\u01e0\5P)\2\u01df\u01dd\3\2\2\2\u01e0"+
		"\u01e3\3\2\2\2\u01e1\u01df\3\2\2\2\u01e1\u01e2\3\2\2\2\u01e2\u01e4\3\2"+
		"\2\2\u01e3\u01e1\3\2\2\2\u01e4\u01e5\7\17\2\2\u01e5O\3\2\2\2\u01e6\u01eb"+
		"\5`\61\2\u01e7\u01eb\5R*\2\u01e8\u01eb\5T+\2\u01e9\u01eb\5V,\2\u01ea\u01e6"+
		"\3\2\2\2\u01ea\u01e7\3\2\2\2\u01ea\u01e8\3\2\2\2\u01ea\u01e9\3\2\2\2\u01eb"+
		"Q\3\2\2\2\u01ec\u01ed\7\26\2\2\u01ed\u01ee\5`\61\2\u01eeS\3\2\2\2\u01ef"+
		"\u01f0\7\r\2\2\u01f0\u01f1\5^\60\2\u01f1U\3\2\2\2\u01f2\u01f3\7\27\2\2"+
		"\u01f3\u01f4\5^\60\2\u01f4W\3\2\2\2\u01f5\u01f6\7\r\2\2\u01f6Y\3\2\2\2"+
		"\u01f7\u01f8\t\3\2\2\u01f8[\3\2\2\2\u01f9\u01fb\7\16\2\2\u01fa\u01fc\5"+
		"`\61\2\u01fb\u01fa\3\2\2\2\u01fb\u01fc\3\2\2\2\u01fc\u0201\3\2\2\2\u01fd"+
		"\u01fe\7\n\2\2\u01fe\u0200\5`\61\2\u01ff\u01fd\3\2\2\2\u0200\u0203\3\2"+
		"\2\2\u0201\u01ff\3\2\2\2\u0201\u0202\3\2\2\2\u0202\u0204\3\2\2\2\u0203"+
		"\u0201\3\2\2\2\u0204\u0205\7\17\2\2\u0205]\3\2\2\2\u0206\u0207\7#\2\2"+
		"\u0207_\3\2\2\2\u0208\u0209\7$\2\2\u0209a\3\2\2\2\u020a\u020c\t\4\2\2"+
		"\u020b\u020d\7\26\2\2\u020c\u020b\3\2\2\2\u020c\u020d\3\2\2\2\u020dc\3"+
		"\2\2\2>hlsw~\u0082\u0089\u008d\u0094\u0096\u0099\u009e\u00a2\u00a6\u00ac"+
		"\u00af\u00b4\u00b7\u00bc\u00cb\u00d2\u00db\u00e2\u00e8\u00f3\u00f7\u0102"+
		"\u0107\u011f\u0123\u012b\u0135\u013d\u0145\u014d\u0151\u0155\u0159\u0165"+
		"\u016d\u0172\u0177\u017b\u0180\u0183\u0187\u0189\u0199\u01a0\u01a7\u01ae"+
		"\u01b5\u01c3\u01ce\u01db\u01e1\u01ea\u01fb\u0201\u020c";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}