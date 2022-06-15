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
		INEXACT=20, NEGATION=21, SYLLABLE_BOUNDARY=22, WORD_BOUNDARY=23, BETWEEN_WORDS=24, 
		CLASSREF=25, INTERSECTION=26, INTERSECTION_NOT=27, TRANSFORMING=28, CLASS_DECL=29, 
		FEATURE_DECL=30, SYLLABLE_FEATURE=31, DIACRITIC=32, DIA_BEFORE=33, DIA_FIRST=34, 
		DIA_FLOATING=35, SYMBOL=36, SYLLABLE_DECL=37, EXPLICIT_SYLLABLES=38, CLEAR_SYLLABLES=39, 
		ANY_SYLLABLE=40, DEROMANIZER=41, ROMANIZER=42, ALL_MATCHING=43, FIRST_MATCHING=44, 
		PROPAGATE=45, LTR=46, RTL=47, LITERAL=48, CLEANUP=49, UNCHANGED=50, NUMBER=51, 
		NAME=52, STR1=53, STR=54;
	public static final int
		RULE_lscFile = 0, RULE_statement = 1, RULE_classDecl = 2, RULE_classElement = 3, 
		RULE_featureDecl = 4, RULE_featureModifier = 5, RULE_plusFeature = 6, 
		RULE_nullAlias = 7, RULE_diacriticDecl = 8, RULE_diacriticModifier = 9, 
		RULE_symbolDecl = 10, RULE_symbolName = 11, RULE_syllableDecl = 12, RULE_syllablePattern = 13, 
		RULE_deromanizer = 14, RULE_romanizer = 15, RULE_interRomanizer = 16, 
		RULE_changeRule = 17, RULE_filter = 18, RULE_block = 19, RULE_blockElement = 20, 
		RULE_blockType = 21, RULE_changeRuleModifier = 22, RULE_matchMode = 23, 
		RULE_expressionList = 24, RULE_ruleName = 25, RULE_expression = 26, RULE_from = 27, 
		RULE_to = 28, RULE_ruleElement = 29, RULE_unconditionalRuleElement = 30, 
		RULE_bounded = 31, RULE_group = 32, RULE_list = 33, RULE_sequence = 34, 
		RULE_freeElement = 35, RULE_compoundEnvironment = 36, RULE_condition = 37, 
		RULE_exclusion = 38, RULE_environmentList = 39, RULE_environment = 40, 
		RULE_environmentBefore = 41, RULE_environmentAfter = 42, RULE_interfix = 43, 
		RULE_interfixType = 44, RULE_interfixElement = 45, RULE_negated = 46, 
		RULE_postfix = 47, RULE_capture = 48, RULE_repeater = 49, RULE_simple = 50, 
		RULE_anySyllable = 51, RULE_classRef = 52, RULE_captureRef = 53, RULE_fancyMatrix = 54, 
		RULE_fancyValue = 55, RULE_negatedValue = 56, RULE_absentFeature = 57, 
		RULE_featureVariable = 58, RULE_empty = 59, RULE_sylBoundary = 60, RULE_boundary = 61, 
		RULE_betweenWords = 62, RULE_repeaterType = 63, RULE_repeatRange = 64, 
		RULE_lowerBound = 65, RULE_upperBound = 66, RULE_matrix = 67, RULE_matrixValue = 68, 
		RULE_plusFeatureValue = 69, RULE_featureValue = 70, RULE_name = 71, RULE_text = 72;
	private static String[] makeRuleNames() {
		return new String[] {
			"lscFile", "statement", "classDecl", "classElement", "featureDecl", "featureModifier", 
			"plusFeature", "nullAlias", "diacriticDecl", "diacriticModifier", "symbolDecl", 
			"symbolName", "syllableDecl", "syllablePattern", "deromanizer", "romanizer", 
			"interRomanizer", "changeRule", "filter", "block", "blockElement", "blockType", 
			"changeRuleModifier", "matchMode", "expressionList", "ruleName", "expression", 
			"from", "to", "ruleElement", "unconditionalRuleElement", "bounded", "group", 
			"list", "sequence", "freeElement", "compoundEnvironment", "condition", 
			"exclusion", "environmentList", "environment", "environmentBefore", "environmentAfter", 
			"interfix", "interfixType", "interfixElement", "negated", "postfix", 
			"capture", "repeater", "simple", "anySyllable", "classRef", "captureRef", 
			"fancyMatrix", "fancyValue", "negatedValue", "absentFeature", "featureVariable", 
			"empty", "sylBoundary", "boundary", "betweenWords", "repeaterType", "repeatRange", 
			"lowerBound", "upperBound", "matrix", "matrixValue", "plusFeatureValue", 
			"featureValue", "name", "text"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, null, "'_'", null, null, "'('", "')'", 
			"'*'", "'['", "']'", "'{'", "'}'", "'+'", "'?'", "'-'", "':'", "'~'", 
			"'!'", "'.'", "'$'", "'$$'", "'@'", "'&'", "'&!'", "'>'", null, null, 
			null, null, null, null, null, null, "'Syllables'", "'explicit'", "'clear'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "COMMENT", "SEP", "CHANGE", "CONDITION", "EXCLUSION", "ANCHOR", 
			"NEWLINE", "WHITESPACE", "O_PAREN", "C_PAREN", "NULL", "MATRIX_START", 
			"MATRIX_END", "LIST_START", "LIST_END", "AT_LEAST_ONE", "OPTIONAL", "HYPHEN", 
			"RULE_START", "INEXACT", "NEGATION", "SYLLABLE_BOUNDARY", "WORD_BOUNDARY", 
			"BETWEEN_WORDS", "CLASSREF", "INTERSECTION", "INTERSECTION_NOT", "TRANSFORMING", 
			"CLASS_DECL", "FEATURE_DECL", "SYLLABLE_FEATURE", "DIACRITIC", "DIA_BEFORE", 
			"DIA_FIRST", "DIA_FLOATING", "SYMBOL", "SYLLABLE_DECL", "EXPLICIT_SYLLABLES", 
			"CLEAR_SYLLABLES", "ANY_SYLLABLE", "DEROMANIZER", "ROMANIZER", "ALL_MATCHING", 
			"FIRST_MATCHING", "PROPAGATE", "LTR", "RTL", "LITERAL", "CLEANUP", "UNCHANGED", 
			"NUMBER", "NAME", "STR1", "STR"
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
		public TerminalNode WHITESPACE() { return getToken(LscParser.WHITESPACE, 0); }
		public TerminalNode EOF() { return getToken(LscParser.EOF, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(LscParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(LscParser.NEWLINE, i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
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
			setState(174);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case WHITESPACE:
				enterOuterAlt(_localctx, 1);
				{
				setState(146);
				match(WHITESPACE);
				}
				break;
			case EOF:
			case NEWLINE:
			case CLASS_DECL:
			case FEATURE_DECL:
			case DIACRITIC:
			case SYMBOL:
			case SYLLABLE_DECL:
			case DEROMANIZER:
			case ROMANIZER:
			case NAME:
				enterOuterAlt(_localctx, 2);
				{
				setState(150);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(147);
						match(NEWLINE);
						}
						} 
					}
					setState(152);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
				}
				setState(154);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CLASS_DECL) | (1L << FEATURE_DECL) | (1L << DIACRITIC) | (1L << SYMBOL) | (1L << SYLLABLE_DECL) | (1L << DEROMANIZER) | (1L << ROMANIZER) | (1L << NAME))) != 0)) {
					{
					setState(153);
					statement();
					}
				}

				setState(164);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(157); 
						_errHandler.sync(this);
						_la = _input.LA(1);
						do {
							{
							{
							setState(156);
							match(NEWLINE);
							}
							}
							setState(159); 
							_errHandler.sync(this);
							_la = _input.LA(1);
						} while ( _la==NEWLINE );
						setState(161);
						statement();
						}
						} 
					}
					setState(166);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
				}
				setState(170);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NEWLINE) {
					{
					{
					setState(167);
					match(NEWLINE);
					}
					}
					setState(172);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(173);
				match(EOF);
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

	public static class StatementContext extends ParserRuleContext {
		public FeatureDeclContext featureDecl() {
			return getRuleContext(FeatureDeclContext.class,0);
		}
		public DiacriticDeclContext diacriticDecl() {
			return getRuleContext(DiacriticDeclContext.class,0);
		}
		public SymbolDeclContext symbolDecl() {
			return getRuleContext(SymbolDeclContext.class,0);
		}
		public ClassDeclContext classDecl() {
			return getRuleContext(ClassDeclContext.class,0);
		}
		public SyllableDeclContext syllableDecl() {
			return getRuleContext(SyllableDeclContext.class,0);
		}
		public DeromanizerContext deromanizer() {
			return getRuleContext(DeromanizerContext.class,0);
		}
		public ChangeRuleContext changeRule() {
			return getRuleContext(ChangeRuleContext.class,0);
		}
		public InterRomanizerContext interRomanizer() {
			return getRuleContext(InterRomanizerContext.class,0);
		}
		public RomanizerContext romanizer() {
			return getRuleContext(RomanizerContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LscVisitor ) return ((LscVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_statement);
		try {
			setState(185);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(176);
				featureDecl();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(177);
				diacriticDecl();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(178);
				symbolDecl();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(179);
				classDecl();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(180);
				syllableDecl();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(181);
				deromanizer();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(182);
				changeRule();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(183);
				interRomanizer();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(184);
				romanizer();
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

	public static class ClassDeclContext extends ParserRuleContext {
		public TerminalNode CLASS_DECL() { return getToken(LscParser.CLASS_DECL, 0); }
		public List<TerminalNode> WHITESPACE() { return getTokens(LscParser.WHITESPACE); }
		public TerminalNode WHITESPACE(int i) {
			return getToken(LscParser.WHITESPACE, i);
		}
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
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
		enterRule(_localctx, 4, RULE_classDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(187);
			match(CLASS_DECL);
			setState(188);
			match(WHITESPACE);
			setState(189);
			name();
			setState(190);
			match(WHITESPACE);
			setState(191);
			match(LIST_START);
			setState(192);
			classElement();
			setState(197);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SEP) {
				{
				{
				setState(193);
				match(SEP);
				setState(194);
				classElement();
				}
				}
				setState(199);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(200);
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
		enterRule(_localctx, 6, RULE_classElement);
		try {
			setState(204);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CLASSREF:
				enterOuterAlt(_localctx, 1);
				{
				setState(202);
				classRef();
				}
				break;
			case NAME:
			case STR1:
			case STR:
				enterOuterAlt(_localctx, 2);
				{
				setState(203);
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
		public List<TerminalNode> WHITESPACE() { return getTokens(LscParser.WHITESPACE); }
		public TerminalNode WHITESPACE(int i) {
			return getToken(LscParser.WHITESPACE, i);
		}
		public List<PlusFeatureContext> plusFeature() {
			return getRuleContexts(PlusFeatureContext.class);
		}
		public PlusFeatureContext plusFeature(int i) {
			return getRuleContext(PlusFeatureContext.class,i);
		}
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public TerminalNode O_PAREN() { return getToken(LscParser.O_PAREN, 0); }
		public List<FeatureValueContext> featureValue() {
			return getRuleContexts(FeatureValueContext.class);
		}
		public FeatureValueContext featureValue(int i) {
			return getRuleContext(FeatureValueContext.class,i);
		}
		public TerminalNode C_PAREN() { return getToken(LscParser.C_PAREN, 0); }
		public List<TerminalNode> SEP() { return getTokens(LscParser.SEP); }
		public TerminalNode SEP(int i) {
			return getToken(LscParser.SEP, i);
		}
		public FeatureModifierContext featureModifier() {
			return getRuleContext(FeatureModifierContext.class,0);
		}
		public NullAliasContext nullAlias() {
			return getRuleContext(NullAliasContext.class,0);
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
		enterRule(_localctx, 8, RULE_featureDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(206);
			match(FEATURE_DECL);
			setState(207);
			match(WHITESPACE);
			setState(241);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				{
				{
				setState(208);
				plusFeature();
				setState(213);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==SEP) {
					{
					{
					setState(209);
					match(SEP);
					setState(210);
					plusFeature();
					}
					}
					setState(215);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				break;
			case 2:
				{
				{
				setState(219);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SYLLABLE_FEATURE) {
					{
					setState(216);
					featureModifier();
					setState(217);
					match(WHITESPACE);
					}
				}

				setState(221);
				name();
				setState(223);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==WHITESPACE) {
					{
					setState(222);
					match(WHITESPACE);
					}
				}

				setState(225);
				match(O_PAREN);
				setState(229);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NULL) {
					{
					setState(226);
					nullAlias();
					setState(227);
					match(SEP);
					}
				}

				setState(231);
				featureValue();
				setState(236);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==SEP) {
					{
					{
					setState(232);
					match(SEP);
					setState(233);
					featureValue();
					}
					}
					setState(238);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(239);
				match(C_PAREN);
				}
				}
				break;
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

	public static class FeatureModifierContext extends ParserRuleContext {
		public TerminalNode SYLLABLE_FEATURE() { return getToken(LscParser.SYLLABLE_FEATURE, 0); }
		public FeatureModifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_featureModifier; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LscVisitor ) return ((LscVisitor<? extends T>)visitor).visitFeatureModifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FeatureModifierContext featureModifier() throws RecognitionException {
		FeatureModifierContext _localctx = new FeatureModifierContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_featureModifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(243);
			match(SYLLABLE_FEATURE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PlusFeatureContext extends ParserRuleContext {
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public FeatureModifierContext featureModifier() {
			return getRuleContext(FeatureModifierContext.class,0);
		}
		public TerminalNode WHITESPACE() { return getToken(LscParser.WHITESPACE, 0); }
		public TerminalNode AT_LEAST_ONE() { return getToken(LscParser.AT_LEAST_ONE, 0); }
		public PlusFeatureContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_plusFeature; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LscVisitor ) return ((LscVisitor<? extends T>)visitor).visitPlusFeature(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PlusFeatureContext plusFeature() throws RecognitionException {
		PlusFeatureContext _localctx = new PlusFeatureContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_plusFeature);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(248);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SYLLABLE_FEATURE) {
				{
				setState(245);
				featureModifier();
				setState(246);
				match(WHITESPACE);
				}
			}

			setState(251);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==AT_LEAST_ONE) {
				{
				setState(250);
				match(AT_LEAST_ONE);
				}
			}

			setState(253);
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

	public static class NullAliasContext extends ParserRuleContext {
		public TerminalNode NULL() { return getToken(LscParser.NULL, 0); }
		public FeatureValueContext featureValue() {
			return getRuleContext(FeatureValueContext.class,0);
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
		enterRule(_localctx, 14, RULE_nullAlias);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(255);
			match(NULL);
			setState(256);
			featureValue();
			}
		}
		catch (RecognitionException re) {
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
		public TextContext text() {
			return getRuleContext(TextContext.class,0);
		}
		public MatrixContext matrix() {
			return getRuleContext(MatrixContext.class,0);
		}
		public List<DiacriticModifierContext> diacriticModifier() {
			return getRuleContexts(DiacriticModifierContext.class);
		}
		public DiacriticModifierContext diacriticModifier(int i) {
			return getRuleContext(DiacriticModifierContext.class,i);
		}
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
		enterRule(_localctx, 16, RULE_diacriticDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(258);
			match(DIACRITIC);
			setState(259);
			match(WHITESPACE);
			setState(260);
			text();
			setState(261);
			match(WHITESPACE);
			setState(267);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DIA_BEFORE) | (1L << DIA_FIRST) | (1L << DIA_FLOATING))) != 0)) {
				{
				{
				setState(262);
				diacriticModifier();
				setState(263);
				match(WHITESPACE);
				}
				}
				setState(269);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(270);
			matrix();
			setState(275);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WHITESPACE) {
				{
				{
				setState(271);
				match(WHITESPACE);
				setState(272);
				diacriticModifier();
				}
				}
				setState(277);
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

	public static class DiacriticModifierContext extends ParserRuleContext {
		public TerminalNode DIA_BEFORE() { return getToken(LscParser.DIA_BEFORE, 0); }
		public TerminalNode DIA_FIRST() { return getToken(LscParser.DIA_FIRST, 0); }
		public TerminalNode DIA_FLOATING() { return getToken(LscParser.DIA_FLOATING, 0); }
		public DiacriticModifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_diacriticModifier; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LscVisitor ) return ((LscVisitor<? extends T>)visitor).visitDiacriticModifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DiacriticModifierContext diacriticModifier() throws RecognitionException {
		DiacriticModifierContext _localctx = new DiacriticModifierContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_diacriticModifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(278);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DIA_BEFORE) | (1L << DIA_FIRST) | (1L << DIA_FLOATING))) != 0)) ) {
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
		enterRule(_localctx, 20, RULE_symbolDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(280);
			match(SYMBOL);
			setState(281);
			match(WHITESPACE);
			setState(282);
			symbolName();
			setState(292);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case EOF:
			case SEP:
			case NEWLINE:
				{
				setState(287);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==SEP) {
					{
					{
					setState(283);
					match(SEP);
					setState(284);
					symbolName();
					}
					}
					setState(289);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case WHITESPACE:
				{
				setState(290);
				match(WHITESPACE);
				setState(291);
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
		enterRule(_localctx, 22, RULE_symbolName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(294);
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

	public static class SyllableDeclContext extends ParserRuleContext {
		public TerminalNode SYLLABLE_DECL() { return getToken(LscParser.SYLLABLE_DECL, 0); }
		public TerminalNode RULE_START() { return getToken(LscParser.RULE_START, 0); }
		public TerminalNode EXPLICIT_SYLLABLES() { return getToken(LscParser.EXPLICIT_SYLLABLES, 0); }
		public TerminalNode CLEAR_SYLLABLES() { return getToken(LscParser.CLEAR_SYLLABLES, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(LscParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(LscParser.NEWLINE, i);
		}
		public List<SyllablePatternContext> syllablePattern() {
			return getRuleContexts(SyllablePatternContext.class);
		}
		public SyllablePatternContext syllablePattern(int i) {
			return getRuleContext(SyllablePatternContext.class,i);
		}
		public SyllableDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_syllableDecl; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LscVisitor ) return ((LscVisitor<? extends T>)visitor).visitSyllableDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SyllableDeclContext syllableDecl() throws RecognitionException {
		SyllableDeclContext _localctx = new SyllableDeclContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_syllableDecl);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(296);
			match(SYLLABLE_DECL);
			setState(297);
			match(RULE_START);
			setState(314);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				{
				setState(299); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(298);
					match(NEWLINE);
					}
					}
					setState(301); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NEWLINE );
				setState(303);
				_la = _input.LA(1);
				if ( !(_la==EXPLICIT_SYLLABLES || _la==CLEAR_SYLLABLES) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case 2:
				{
				setState(310); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(305); 
						_errHandler.sync(this);
						_la = _input.LA(1);
						do {
							{
							{
							setState(304);
							match(NEWLINE);
							}
							}
							setState(307); 
							_errHandler.sync(this);
							_la = _input.LA(1);
						} while ( _la==NEWLINE );
						setState(309);
						syllablePattern();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(312); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
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

	public static class SyllablePatternContext extends ParserRuleContext {
		public UnconditionalRuleElementContext unconditionalRuleElement() {
			return getRuleContext(UnconditionalRuleElementContext.class,0);
		}
		public TerminalNode CHANGE() { return getToken(LscParser.CHANGE, 0); }
		public MatrixContext matrix() {
			return getRuleContext(MatrixContext.class,0);
		}
		public CompoundEnvironmentContext compoundEnvironment() {
			return getRuleContext(CompoundEnvironmentContext.class,0);
		}
		public SyllablePatternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_syllablePattern; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LscVisitor ) return ((LscVisitor<? extends T>)visitor).visitSyllablePattern(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SyllablePatternContext syllablePattern() throws RecognitionException {
		SyllablePatternContext _localctx = new SyllablePatternContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_syllablePattern);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(316);
			unconditionalRuleElement();
			setState(319);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CHANGE) {
				{
				setState(317);
				match(CHANGE);
				setState(318);
				matrix();
				}
			}

			setState(322);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CONDITION || _la==EXCLUSION) {
				{
				setState(321);
				compoundEnvironment();
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

	public static class DeromanizerContext extends ParserRuleContext {
		public TerminalNode DEROMANIZER() { return getToken(LscParser.DEROMANIZER, 0); }
		public TerminalNode RULE_START() { return getToken(LscParser.RULE_START, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode WHITESPACE() { return getToken(LscParser.WHITESPACE, 0); }
		public TerminalNode LITERAL() { return getToken(LscParser.LITERAL, 0); }
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
		enterRule(_localctx, 28, RULE_deromanizer);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(324);
			match(DEROMANIZER);
			setState(327);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WHITESPACE) {
				{
				setState(325);
				match(WHITESPACE);
				setState(326);
				match(LITERAL);
				}
			}

			setState(329);
			match(RULE_START);
			setState(331); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(330);
				match(NEWLINE);
				}
				}
				setState(333); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NEWLINE );
			setState(335);
			block();
			}
		}
		catch (RecognitionException re) {
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
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode WHITESPACE() { return getToken(LscParser.WHITESPACE, 0); }
		public TerminalNode LITERAL() { return getToken(LscParser.LITERAL, 0); }
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
		enterRule(_localctx, 30, RULE_romanizer);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(337);
			match(ROMANIZER);
			setState(340);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WHITESPACE) {
				{
				setState(338);
				match(WHITESPACE);
				setState(339);
				match(LITERAL);
				}
			}

			setState(342);
			match(RULE_START);
			setState(344); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(343);
				match(NEWLINE);
				}
				}
				setState(346); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NEWLINE );
			setState(348);
			block();
			}
		}
		catch (RecognitionException re) {
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
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode WHITESPACE() { return getToken(LscParser.WHITESPACE, 0); }
		public TerminalNode LITERAL() { return getToken(LscParser.LITERAL, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(LscParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(LscParser.NEWLINE, i);
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
		enterRule(_localctx, 32, RULE_interRomanizer);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(350);
			match(ROMANIZER);
			setState(351);
			match(HYPHEN);
			setState(352);
			ruleName();
			setState(355);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WHITESPACE) {
				{
				setState(353);
				match(WHITESPACE);
				setState(354);
				match(LITERAL);
				}
			}

			setState(357);
			match(RULE_START);
			setState(359); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(358);
				match(NEWLINE);
				}
				}
				setState(361); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NEWLINE );
			setState(363);
			block();
			}
		}
		catch (RecognitionException re) {
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
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public List<TerminalNode> WHITESPACE() { return getTokens(LscParser.WHITESPACE); }
		public TerminalNode WHITESPACE(int i) {
			return getToken(LscParser.WHITESPACE, i);
		}
		public List<ChangeRuleModifierContext> changeRuleModifier() {
			return getRuleContexts(ChangeRuleModifierContext.class);
		}
		public ChangeRuleModifierContext changeRuleModifier(int i) {
			return getRuleContext(ChangeRuleModifierContext.class,i);
		}
		public TerminalNode RULE_START() { return getToken(LscParser.RULE_START, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(LscParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(LscParser.NEWLINE, i);
		}
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
		enterRule(_localctx, 34, RULE_changeRule);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(365);
			ruleName();
			setState(370);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WHITESPACE) {
				{
				{
				setState(366);
				match(WHITESPACE);
				setState(367);
				changeRuleModifier();
				}
				}
				setState(372);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(374);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==RULE_START) {
				{
				setState(373);
				match(RULE_START);
				}
			}

			setState(377); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(376);
				match(NEWLINE);
				}
				}
				setState(379); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NEWLINE );
			setState(381);
			block();
			}
		}
		catch (RecognitionException re) {
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
		public FancyMatrixContext fancyMatrix() {
			return getRuleContext(FancyMatrixContext.class,0);
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
		enterRule(_localctx, 36, RULE_filter);
		try {
			setState(385);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CLASSREF:
				enterOuterAlt(_localctx, 1);
				{
				setState(383);
				classRef();
				}
				break;
			case MATRIX_START:
				enterOuterAlt(_localctx, 2);
				{
				setState(384);
				fancyMatrix();
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

	public static class BlockContext extends ParserRuleContext {
		public List<BlockElementContext> blockElement() {
			return getRuleContexts(BlockElementContext.class);
		}
		public BlockElementContext blockElement(int i) {
			return getRuleContext(BlockElementContext.class,i);
		}
		public List<BlockTypeContext> blockType() {
			return getRuleContexts(BlockTypeContext.class);
		}
		public BlockTypeContext blockType(int i) {
			return getRuleContext(BlockTypeContext.class,i);
		}
		public List<TerminalNode> RULE_START() { return getTokens(LscParser.RULE_START); }
		public TerminalNode RULE_START(int i) {
			return getToken(LscParser.RULE_START, i);
		}
		public List<TerminalNode> WHITESPACE() { return getTokens(LscParser.WHITESPACE); }
		public TerminalNode WHITESPACE(int i) {
			return getToken(LscParser.WHITESPACE, i);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(LscParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(LscParser.NEWLINE, i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LscVisitor ) return ((LscVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_block);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(387);
			blockElement();
			setState(407);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,40,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(389); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(388);
						match(NEWLINE);
						}
						}
						setState(391); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==NEWLINE );
					setState(393);
					blockType();
					setState(394);
					match(RULE_START);
					setState(401);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case WHITESPACE:
						{
						setState(395);
						match(WHITESPACE);
						}
						break;
					case NEWLINE:
						{
						setState(397); 
						_errHandler.sync(this);
						_la = _input.LA(1);
						do {
							{
							{
							setState(396);
							match(NEWLINE);
							}
							}
							setState(399); 
							_errHandler.sync(this);
							_la = _input.LA(1);
						} while ( _la==NEWLINE );
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(403);
					blockElement();
					}
					} 
				}
				setState(409);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,40,_ctx);
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

	public static class BlockElementContext extends ParserRuleContext {
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
		}
		public TerminalNode O_PAREN() { return getToken(LscParser.O_PAREN, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode C_PAREN() { return getToken(LscParser.C_PAREN, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(LscParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(LscParser.NEWLINE, i);
		}
		public BlockElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blockElement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LscVisitor ) return ((LscVisitor<? extends T>)visitor).visitBlockElement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockElementContext blockElement() throws RecognitionException {
		BlockElementContext _localctx = new BlockElementContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_blockElement);
		int _la;
		try {
			setState(427);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,43,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(410);
				expressionList();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(411);
				match(O_PAREN);
				setState(415);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NEWLINE) {
					{
					{
					setState(412);
					match(NEWLINE);
					}
					}
					setState(417);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(418);
				block();
				setState(422);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NEWLINE) {
					{
					{
					setState(419);
					match(NEWLINE);
					}
					}
					setState(424);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(425);
				match(C_PAREN);
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

	public static class BlockTypeContext extends ParserRuleContext {
		public TerminalNode ALL_MATCHING() { return getToken(LscParser.ALL_MATCHING, 0); }
		public TerminalNode FIRST_MATCHING() { return getToken(LscParser.FIRST_MATCHING, 0); }
		public List<TerminalNode> WHITESPACE() { return getTokens(LscParser.WHITESPACE); }
		public TerminalNode WHITESPACE(int i) {
			return getToken(LscParser.WHITESPACE, i);
		}
		public List<ChangeRuleModifierContext> changeRuleModifier() {
			return getRuleContexts(ChangeRuleModifierContext.class);
		}
		public ChangeRuleModifierContext changeRuleModifier(int i) {
			return getRuleContext(ChangeRuleModifierContext.class,i);
		}
		public BlockTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blockType; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LscVisitor ) return ((LscVisitor<? extends T>)visitor).visitBlockType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockTypeContext blockType() throws RecognitionException {
		BlockTypeContext _localctx = new BlockTypeContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_blockType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(429);
			_la = _input.LA(1);
			if ( !(_la==ALL_MATCHING || _la==FIRST_MATCHING) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(434);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WHITESPACE) {
				{
				{
				setState(430);
				match(WHITESPACE);
				setState(431);
				changeRuleModifier();
				}
				}
				setState(436);
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

	public static class ChangeRuleModifierContext extends ParserRuleContext {
		public FilterContext filter() {
			return getRuleContext(FilterContext.class,0);
		}
		public MatchModeContext matchMode() {
			return getRuleContext(MatchModeContext.class,0);
		}
		public TerminalNode PROPAGATE() { return getToken(LscParser.PROPAGATE, 0); }
		public TerminalNode CLEANUP() { return getToken(LscParser.CLEANUP, 0); }
		public ChangeRuleModifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_changeRuleModifier; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LscVisitor ) return ((LscVisitor<? extends T>)visitor).visitChangeRuleModifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ChangeRuleModifierContext changeRuleModifier() throws RecognitionException {
		ChangeRuleModifierContext _localctx = new ChangeRuleModifierContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_changeRuleModifier);
		try {
			setState(441);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case MATRIX_START:
			case CLASSREF:
				enterOuterAlt(_localctx, 1);
				{
				setState(437);
				filter();
				}
				break;
			case LTR:
			case RTL:
				enterOuterAlt(_localctx, 2);
				{
				setState(438);
				matchMode();
				}
				break;
			case PROPAGATE:
				enterOuterAlt(_localctx, 3);
				{
				setState(439);
				match(PROPAGATE);
				}
				break;
			case CLEANUP:
				enterOuterAlt(_localctx, 4);
				{
				setState(440);
				match(CLEANUP);
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

	public static class MatchModeContext extends ParserRuleContext {
		public TerminalNode LTR() { return getToken(LscParser.LTR, 0); }
		public TerminalNode RTL() { return getToken(LscParser.RTL, 0); }
		public MatchModeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_matchMode; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LscVisitor ) return ((LscVisitor<? extends T>)visitor).visitMatchMode(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MatchModeContext matchMode() throws RecognitionException {
		MatchModeContext _localctx = new MatchModeContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_matchMode);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(443);
			_la = _input.LA(1);
			if ( !(_la==LTR || _la==RTL) ) {
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

	public static class ExpressionListContext extends ParserRuleContext {
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
		public ExpressionListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionList; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LscVisitor ) return ((LscVisitor<? extends T>)visitor).visitExpressionList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionListContext expressionList() throws RecognitionException {
		ExpressionListContext _localctx = new ExpressionListContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_expressionList);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(445);
			expression();
			setState(454);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,47,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(447); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(446);
						match(NEWLINE);
						}
						}
						setState(449); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==NEWLINE );
					setState(451);
					expression();
					}
					} 
				}
				setState(456);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,47,_ctx);
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
		public List<TerminalNode> NAME() { return getTokens(LscParser.NAME); }
		public TerminalNode NAME(int i) {
			return getToken(LscParser.NAME, i);
		}
		public List<TerminalNode> HYPHEN() { return getTokens(LscParser.HYPHEN); }
		public TerminalNode HYPHEN(int i) {
			return getToken(LscParser.HYPHEN, i);
		}
		public List<TerminalNode> NUMBER() { return getTokens(LscParser.NUMBER); }
		public TerminalNode NUMBER(int i) {
			return getToken(LscParser.NUMBER, i);
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
		enterRule(_localctx, 50, RULE_ruleName);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(457);
			match(NAME);
			setState(462);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==HYPHEN) {
				{
				{
				setState(458);
				match(HYPHEN);
				setState(459);
				_la = _input.LA(1);
				if ( !(_la==NUMBER || _la==NAME) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				}
				setState(464);
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
		public TerminalNode UNCHANGED() { return getToken(LscParser.UNCHANGED, 0); }
		public FromContext from() {
			return getRuleContext(FromContext.class,0);
		}
		public TerminalNode CHANGE() { return getToken(LscParser.CHANGE, 0); }
		public ToContext to() {
			return getRuleContext(ToContext.class,0);
		}
		public CompoundEnvironmentContext compoundEnvironment() {
			return getRuleContext(CompoundEnvironmentContext.class,0);
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
		enterRule(_localctx, 52, RULE_expression);
		int _la;
		try {
			setState(472);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case UNCHANGED:
				enterOuterAlt(_localctx, 1);
				{
				setState(465);
				match(UNCHANGED);
				}
				break;
			case O_PAREN:
			case NULL:
			case MATRIX_START:
			case LIST_START:
			case INEXACT:
			case NEGATION:
			case SYLLABLE_BOUNDARY:
			case WORD_BOUNDARY:
			case BETWEEN_WORDS:
			case CLASSREF:
			case ANY_SYLLABLE:
			case NAME:
			case STR1:
			case STR:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(466);
				from();
				setState(467);
				match(CHANGE);
				setState(468);
				to();
				setState(470);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==CONDITION || _la==EXCLUSION) {
					{
					setState(469);
					compoundEnvironment();
					}
				}

				}
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
		enterRule(_localctx, 54, RULE_from);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(474);
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
		public UnconditionalRuleElementContext unconditionalRuleElement() {
			return getRuleContext(UnconditionalRuleElementContext.class,0);
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
		enterRule(_localctx, 56, RULE_to);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(476);
			unconditionalRuleElement();
			}
		}
		catch (RecognitionException re) {
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
		public UnconditionalRuleElementContext unconditionalRuleElement() {
			return getRuleContext(UnconditionalRuleElementContext.class,0);
		}
		public CompoundEnvironmentContext compoundEnvironment() {
			return getRuleContext(CompoundEnvironmentContext.class,0);
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
		enterRule(_localctx, 58, RULE_ruleElement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(478);
			unconditionalRuleElement();
			setState(480);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CONDITION || _la==EXCLUSION) {
				{
				setState(479);
				compoundEnvironment();
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

	public static class UnconditionalRuleElementContext extends ParserRuleContext {
		public BoundedContext bounded() {
			return getRuleContext(BoundedContext.class,0);
		}
		public InterfixContext interfix() {
			return getRuleContext(InterfixContext.class,0);
		}
		public NegatedContext negated() {
			return getRuleContext(NegatedContext.class,0);
		}
		public PostfixContext postfix() {
			return getRuleContext(PostfixContext.class,0);
		}
		public SimpleContext simple() {
			return getRuleContext(SimpleContext.class,0);
		}
		public SequenceContext sequence() {
			return getRuleContext(SequenceContext.class,0);
		}
		public UnconditionalRuleElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unconditionalRuleElement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LscVisitor ) return ((LscVisitor<? extends T>)visitor).visitUnconditionalRuleElement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnconditionalRuleElementContext unconditionalRuleElement() throws RecognitionException {
		UnconditionalRuleElementContext _localctx = new UnconditionalRuleElementContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_unconditionalRuleElement);
		try {
			setState(488);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,52,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(482);
				bounded();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(483);
				interfix();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(484);
				negated();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(485);
				postfix();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(486);
				simple();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(487);
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

	public static class BoundedContext extends ParserRuleContext {
		public GroupContext group() {
			return getRuleContext(GroupContext.class,0);
		}
		public ListContext list() {
			return getRuleContext(ListContext.class,0);
		}
		public BoundedContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bounded; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LscVisitor ) return ((LscVisitor<? extends T>)visitor).visitBounded(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BoundedContext bounded() throws RecognitionException {
		BoundedContext _localctx = new BoundedContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_bounded);
		try {
			setState(492);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case O_PAREN:
				enterOuterAlt(_localctx, 1);
				{
				setState(490);
				group();
				}
				break;
			case LIST_START:
				enterOuterAlt(_localctx, 2);
				{
				setState(491);
				list();
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
			setState(494);
			match(O_PAREN);
			setState(495);
			ruleElement();
			setState(496);
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
			setState(498);
			match(LIST_START);
			setState(499);
			ruleElement();
			setState(504);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SEP) {
				{
				{
				setState(500);
				match(SEP);
				setState(501);
				ruleElement();
				}
				}
				setState(506);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(507);
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

	public static class SequenceContext extends ParserRuleContext {
		public List<FreeElementContext> freeElement() {
			return getRuleContexts(FreeElementContext.class);
		}
		public FreeElementContext freeElement(int i) {
			return getRuleContext(FreeElementContext.class,i);
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
		enterRule(_localctx, 68, RULE_sequence);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(509);
			freeElement();
			setState(512); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(510);
					match(WHITESPACE);
					setState(511);
					freeElement();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(514); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,55,_ctx);
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

	public static class FreeElementContext extends ParserRuleContext {
		public BoundedContext bounded() {
			return getRuleContext(BoundedContext.class,0);
		}
		public InterfixContext interfix() {
			return getRuleContext(InterfixContext.class,0);
		}
		public NegatedContext negated() {
			return getRuleContext(NegatedContext.class,0);
		}
		public PostfixContext postfix() {
			return getRuleContext(PostfixContext.class,0);
		}
		public SimpleContext simple() {
			return getRuleContext(SimpleContext.class,0);
		}
		public FreeElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_freeElement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LscVisitor ) return ((LscVisitor<? extends T>)visitor).visitFreeElement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FreeElementContext freeElement() throws RecognitionException {
		FreeElementContext _localctx = new FreeElementContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_freeElement);
		try {
			setState(521);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,56,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(516);
				bounded();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(517);
				interfix();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(518);
				negated();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(519);
				postfix();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(520);
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

	public static class CompoundEnvironmentContext extends ParserRuleContext {
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public ExclusionContext exclusion() {
			return getRuleContext(ExclusionContext.class,0);
		}
		public CompoundEnvironmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compoundEnvironment; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LscVisitor ) return ((LscVisitor<? extends T>)visitor).visitCompoundEnvironment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CompoundEnvironmentContext compoundEnvironment() throws RecognitionException {
		CompoundEnvironmentContext _localctx = new CompoundEnvironmentContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_compoundEnvironment);
		try {
			setState(528);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,57,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(523);
				condition();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(524);
				exclusion();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				{
				setState(525);
				condition();
				setState(526);
				exclusion();
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

	public static class ConditionContext extends ParserRuleContext {
		public TerminalNode CONDITION() { return getToken(LscParser.CONDITION, 0); }
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
		enterRule(_localctx, 74, RULE_condition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(530);
			match(CONDITION);
			setState(533);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,58,_ctx) ) {
			case 1:
				{
				setState(531);
				environment();
				}
				break;
			case 2:
				{
				setState(532);
				environmentList();
				}
				break;
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

	public static class ExclusionContext extends ParserRuleContext {
		public TerminalNode EXCLUSION() { return getToken(LscParser.EXCLUSION, 0); }
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
		enterRule(_localctx, 76, RULE_exclusion);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(535);
			match(EXCLUSION);
			setState(538);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,59,_ctx) ) {
			case 1:
				{
				setState(536);
				environment();
				}
				break;
			case 2:
				{
				setState(537);
				environmentList();
				}
				break;
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
		enterRule(_localctx, 78, RULE_environmentList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(540);
			match(LIST_START);
			setState(541);
			environment();
			setState(546);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SEP) {
				{
				{
				setState(542);
				match(SEP);
				setState(543);
				environment();
				}
				}
				setState(548);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(549);
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
		public EnvironmentBeforeContext environmentBefore() {
			return getRuleContext(EnvironmentBeforeContext.class,0);
		}
		public List<TerminalNode> WHITESPACE() { return getTokens(LscParser.WHITESPACE); }
		public TerminalNode WHITESPACE(int i) {
			return getToken(LscParser.WHITESPACE, i);
		}
		public EnvironmentAfterContext environmentAfter() {
			return getRuleContext(EnvironmentAfterContext.class,0);
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
		enterRule(_localctx, 80, RULE_environment);
		int _la;
		try {
			setState(564);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,64,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(554);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << O_PAREN) | (1L << NULL) | (1L << MATRIX_START) | (1L << LIST_START) | (1L << INEXACT) | (1L << NEGATION) | (1L << SYLLABLE_BOUNDARY) | (1L << WORD_BOUNDARY) | (1L << BETWEEN_WORDS) | (1L << CLASSREF) | (1L << ANY_SYLLABLE) | (1L << NAME) | (1L << STR1) | (1L << STR))) != 0)) {
					{
					setState(551);
					environmentBefore();
					setState(552);
					match(WHITESPACE);
					}
				}

				setState(556);
				match(ANCHOR);
				setState(559);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==WHITESPACE) {
					{
					setState(557);
					match(WHITESPACE);
					setState(558);
					environmentAfter();
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(562);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << O_PAREN) | (1L << NULL) | (1L << MATRIX_START) | (1L << LIST_START) | (1L << INEXACT) | (1L << NEGATION) | (1L << SYLLABLE_BOUNDARY) | (1L << WORD_BOUNDARY) | (1L << BETWEEN_WORDS) | (1L << CLASSREF) | (1L << ANY_SYLLABLE) | (1L << NAME) | (1L << STR1) | (1L << STR))) != 0)) {
					{
					setState(561);
					environmentBefore();
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

	public static class EnvironmentBeforeContext extends ParserRuleContext {
		public UnconditionalRuleElementContext unconditionalRuleElement() {
			return getRuleContext(UnconditionalRuleElementContext.class,0);
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
		enterRule(_localctx, 82, RULE_environmentBefore);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(566);
			unconditionalRuleElement();
			}
		}
		catch (RecognitionException re) {
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
		public UnconditionalRuleElementContext unconditionalRuleElement() {
			return getRuleContext(UnconditionalRuleElementContext.class,0);
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
		enterRule(_localctx, 84, RULE_environmentAfter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(568);
			unconditionalRuleElement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InterfixContext extends ParserRuleContext {
		public List<InterfixElementContext> interfixElement() {
			return getRuleContexts(InterfixElementContext.class);
		}
		public InterfixElementContext interfixElement(int i) {
			return getRuleContext(InterfixElementContext.class,i);
		}
		public List<InterfixTypeContext> interfixType() {
			return getRuleContexts(InterfixTypeContext.class);
		}
		public InterfixTypeContext interfixType(int i) {
			return getRuleContext(InterfixTypeContext.class,i);
		}
		public InterfixContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_interfix; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LscVisitor ) return ((LscVisitor<? extends T>)visitor).visitInterfix(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InterfixContext interfix() throws RecognitionException {
		InterfixContext _localctx = new InterfixContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_interfix);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(570);
			interfixElement();
			setState(574); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(571);
				interfixType();
				setState(572);
				interfixElement();
				}
				}
				setState(576); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INTERSECTION) | (1L << INTERSECTION_NOT) | (1L << TRANSFORMING))) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InterfixTypeContext extends ParserRuleContext {
		public TerminalNode INTERSECTION() { return getToken(LscParser.INTERSECTION, 0); }
		public TerminalNode INTERSECTION_NOT() { return getToken(LscParser.INTERSECTION_NOT, 0); }
		public TerminalNode TRANSFORMING() { return getToken(LscParser.TRANSFORMING, 0); }
		public InterfixTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_interfixType; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LscVisitor ) return ((LscVisitor<? extends T>)visitor).visitInterfixType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InterfixTypeContext interfixType() throws RecognitionException {
		InterfixTypeContext _localctx = new InterfixTypeContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_interfixType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(578);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INTERSECTION) | (1L << INTERSECTION_NOT) | (1L << TRANSFORMING))) != 0)) ) {
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

	public static class InterfixElementContext extends ParserRuleContext {
		public BoundedContext bounded() {
			return getRuleContext(BoundedContext.class,0);
		}
		public NegatedContext negated() {
			return getRuleContext(NegatedContext.class,0);
		}
		public PostfixContext postfix() {
			return getRuleContext(PostfixContext.class,0);
		}
		public SimpleContext simple() {
			return getRuleContext(SimpleContext.class,0);
		}
		public InterfixElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_interfixElement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LscVisitor ) return ((LscVisitor<? extends T>)visitor).visitInterfixElement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InterfixElementContext interfixElement() throws RecognitionException {
		InterfixElementContext _localctx = new InterfixElementContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_interfixElement);
		try {
			setState(584);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,66,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(580);
				bounded();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(581);
				negated();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(582);
				postfix();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(583);
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

	public static class NegatedContext extends ParserRuleContext {
		public TerminalNode NEGATION() { return getToken(LscParser.NEGATION, 0); }
		public SimpleContext simple() {
			return getRuleContext(SimpleContext.class,0);
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
		enterRule(_localctx, 92, RULE_negated);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(586);
			match(NEGATION);
			setState(587);
			simple();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PostfixContext extends ParserRuleContext {
		public CaptureContext capture() {
			return getRuleContext(CaptureContext.class,0);
		}
		public RepeaterContext repeater() {
			return getRuleContext(RepeaterContext.class,0);
		}
		public PostfixContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_postfix; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LscVisitor ) return ((LscVisitor<? extends T>)visitor).visitPostfix(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PostfixContext postfix() throws RecognitionException {
		PostfixContext _localctx = new PostfixContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_postfix);
		try {
			setState(591);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,67,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(589);
				capture();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(590);
				repeater();
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
		public BoundedContext bounded() {
			return getRuleContext(BoundedContext.class,0);
		}
		public NegatedContext negated() {
			return getRuleContext(NegatedContext.class,0);
		}
		public SimpleContext simple() {
			return getRuleContext(SimpleContext.class,0);
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
		enterRule(_localctx, 96, RULE_capture);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(596);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case O_PAREN:
			case LIST_START:
				{
				setState(593);
				bounded();
				}
				break;
			case NEGATION:
				{
				setState(594);
				negated();
				}
				break;
			case NULL:
			case MATRIX_START:
			case INEXACT:
			case SYLLABLE_BOUNDARY:
			case WORD_BOUNDARY:
			case BETWEEN_WORDS:
			case CLASSREF:
			case ANY_SYLLABLE:
			case NAME:
			case STR1:
			case STR:
				{
				setState(595);
				simple();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(598);
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
		public BoundedContext bounded() {
			return getRuleContext(BoundedContext.class,0);
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
		enterRule(_localctx, 98, RULE_repeater);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(602);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case O_PAREN:
			case LIST_START:
				{
				setState(600);
				bounded();
				}
				break;
			case NULL:
			case MATRIX_START:
			case INEXACT:
			case SYLLABLE_BOUNDARY:
			case WORD_BOUNDARY:
			case BETWEEN_WORDS:
			case CLASSREF:
			case ANY_SYLLABLE:
			case NAME:
			case STR1:
			case STR:
				{
				setState(601);
				simple();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(604);
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

	public static class SimpleContext extends ParserRuleContext {
		public AnySyllableContext anySyllable() {
			return getRuleContext(AnySyllableContext.class,0);
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
		public SylBoundaryContext sylBoundary() {
			return getRuleContext(SylBoundaryContext.class,0);
		}
		public BoundaryContext boundary() {
			return getRuleContext(BoundaryContext.class,0);
		}
		public BetweenWordsContext betweenWords() {
			return getRuleContext(BetweenWordsContext.class,0);
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
		enterRule(_localctx, 100, RULE_simple);
		try {
			setState(615);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,70,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(606);
				anySyllable();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(607);
				classRef();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(608);
				captureRef();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(609);
				fancyMatrix();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(610);
				empty();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(611);
				sylBoundary();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(612);
				boundary();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(613);
				betweenWords();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(614);
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

	public static class AnySyllableContext extends ParserRuleContext {
		public TerminalNode ANY_SYLLABLE() { return getToken(LscParser.ANY_SYLLABLE, 0); }
		public AnySyllableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_anySyllable; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LscVisitor ) return ((LscVisitor<? extends T>)visitor).visitAnySyllable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AnySyllableContext anySyllable() throws RecognitionException {
		AnySyllableContext _localctx = new AnySyllableContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_anySyllable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(617);
			match(ANY_SYLLABLE);
			}
		}
		catch (RecognitionException re) {
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
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
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
		enterRule(_localctx, 104, RULE_classRef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(619);
			match(CLASSREF);
			setState(620);
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

	public static class CaptureRefContext extends ParserRuleContext {
		public TerminalNode WORD_BOUNDARY() { return getToken(LscParser.WORD_BOUNDARY, 0); }
		public TerminalNode NUMBER() { return getToken(LscParser.NUMBER, 0); }
		public TerminalNode INEXACT() { return getToken(LscParser.INEXACT, 0); }
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
		enterRule(_localctx, 106, RULE_captureRef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(623);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==INEXACT) {
				{
				setState(622);
				match(INEXACT);
				}
			}

			setState(625);
			match(WORD_BOUNDARY);
			setState(626);
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
		enterRule(_localctx, 108, RULE_fancyMatrix);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(628);
			match(MATRIX_START);
			setState(630);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NULL) | (1L << AT_LEAST_ONE) | (1L << HYPHEN) | (1L << NEGATION) | (1L << WORD_BOUNDARY) | (1L << NAME))) != 0)) {
				{
				setState(629);
				fancyValue();
				}
			}

			setState(636);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WHITESPACE) {
				{
				{
				setState(632);
				match(WHITESPACE);
				setState(633);
				fancyValue();
				}
				}
				setState(638);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(639);
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
		public MatrixValueContext matrixValue() {
			return getRuleContext(MatrixValueContext.class,0);
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
		enterRule(_localctx, 110, RULE_fancyValue);
		try {
			setState(645);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case AT_LEAST_ONE:
			case HYPHEN:
			case NAME:
				enterOuterAlt(_localctx, 1);
				{
				setState(641);
				matrixValue();
				}
				break;
			case NEGATION:
				enterOuterAlt(_localctx, 2);
				{
				setState(642);
				negatedValue();
				}
				break;
			case NULL:
				enterOuterAlt(_localctx, 3);
				{
				setState(643);
				absentFeature();
				}
				break;
			case WORD_BOUNDARY:
				enterOuterAlt(_localctx, 4);
				{
				setState(644);
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
		public MatrixValueContext matrixValue() {
			return getRuleContext(MatrixValueContext.class,0);
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
		enterRule(_localctx, 112, RULE_negatedValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(647);
			match(NEGATION);
			setState(648);
			matrixValue();
			}
		}
		catch (RecognitionException re) {
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
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
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
		enterRule(_localctx, 114, RULE_absentFeature);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(650);
			match(NULL);
			setState(651);
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

	public static class FeatureVariableContext extends ParserRuleContext {
		public TerminalNode WORD_BOUNDARY() { return getToken(LscParser.WORD_BOUNDARY, 0); }
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
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
		enterRule(_localctx, 116, RULE_featureVariable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(653);
			match(WORD_BOUNDARY);
			setState(654);
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
		enterRule(_localctx, 118, RULE_empty);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(656);
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

	public static class SylBoundaryContext extends ParserRuleContext {
		public TerminalNode SYLLABLE_BOUNDARY() { return getToken(LscParser.SYLLABLE_BOUNDARY, 0); }
		public SylBoundaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sylBoundary; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LscVisitor ) return ((LscVisitor<? extends T>)visitor).visitSylBoundary(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SylBoundaryContext sylBoundary() throws RecognitionException {
		SylBoundaryContext _localctx = new SylBoundaryContext(_ctx, getState());
		enterRule(_localctx, 120, RULE_sylBoundary);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(658);
			match(SYLLABLE_BOUNDARY);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BoundaryContext extends ParserRuleContext {
		public TerminalNode WORD_BOUNDARY() { return getToken(LscParser.WORD_BOUNDARY, 0); }
		public BoundaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boundary; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LscVisitor ) return ((LscVisitor<? extends T>)visitor).visitBoundary(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BoundaryContext boundary() throws RecognitionException {
		BoundaryContext _localctx = new BoundaryContext(_ctx, getState());
		enterRule(_localctx, 122, RULE_boundary);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(660);
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

	public static class BetweenWordsContext extends ParserRuleContext {
		public TerminalNode BETWEEN_WORDS() { return getToken(LscParser.BETWEEN_WORDS, 0); }
		public BetweenWordsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_betweenWords; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LscVisitor ) return ((LscVisitor<? extends T>)visitor).visitBetweenWords(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BetweenWordsContext betweenWords() throws RecognitionException {
		BetweenWordsContext _localctx = new BetweenWordsContext(_ctx, getState());
		enterRule(_localctx, 124, RULE_betweenWords);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(662);
			match(BETWEEN_WORDS);
			}
		}
		catch (RecognitionException re) {
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
		public RepeatRangeContext repeatRange() {
			return getRuleContext(RepeatRangeContext.class,0);
		}
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
		enterRule(_localctx, 126, RULE_repeaterType);
		try {
			setState(668);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,75,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(664);
				repeatRange();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(665);
				match(AT_LEAST_ONE);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(666);
				match(NULL);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(667);
				match(OPTIONAL);
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

	public static class RepeatRangeContext extends ParserRuleContext {
		public TerminalNode NULL() { return getToken(LscParser.NULL, 0); }
		public TerminalNode NUMBER() { return getToken(LscParser.NUMBER, 0); }
		public TerminalNode O_PAREN() { return getToken(LscParser.O_PAREN, 0); }
		public TerminalNode HYPHEN() { return getToken(LscParser.HYPHEN, 0); }
		public TerminalNode C_PAREN() { return getToken(LscParser.C_PAREN, 0); }
		public LowerBoundContext lowerBound() {
			return getRuleContext(LowerBoundContext.class,0);
		}
		public UpperBoundContext upperBound() {
			return getRuleContext(UpperBoundContext.class,0);
		}
		public RepeatRangeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_repeatRange; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LscVisitor ) return ((LscVisitor<? extends T>)visitor).visitRepeatRange(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RepeatRangeContext repeatRange() throws RecognitionException {
		RepeatRangeContext _localctx = new RepeatRangeContext(_ctx, getState());
		enterRule(_localctx, 128, RULE_repeatRange);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(670);
			match(NULL);
			setState(681);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUMBER:
				{
				setState(671);
				match(NUMBER);
				}
				break;
			case O_PAREN:
				{
				{
				setState(672);
				match(O_PAREN);
				setState(674);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NUMBER) {
					{
					setState(673);
					lowerBound();
					}
				}

				setState(676);
				match(HYPHEN);
				setState(678);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NUMBER) {
					{
					setState(677);
					upperBound();
					}
				}

				setState(680);
				match(C_PAREN);
				}
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

	public static class LowerBoundContext extends ParserRuleContext {
		public TerminalNode NUMBER() { return getToken(LscParser.NUMBER, 0); }
		public LowerBoundContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lowerBound; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LscVisitor ) return ((LscVisitor<? extends T>)visitor).visitLowerBound(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LowerBoundContext lowerBound() throws RecognitionException {
		LowerBoundContext _localctx = new LowerBoundContext(_ctx, getState());
		enterRule(_localctx, 130, RULE_lowerBound);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(683);
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

	public static class UpperBoundContext extends ParserRuleContext {
		public TerminalNode NUMBER() { return getToken(LscParser.NUMBER, 0); }
		public UpperBoundContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_upperBound; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LscVisitor ) return ((LscVisitor<? extends T>)visitor).visitUpperBound(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UpperBoundContext upperBound() throws RecognitionException {
		UpperBoundContext _localctx = new UpperBoundContext(_ctx, getState());
		enterRule(_localctx, 132, RULE_upperBound);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(685);
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

	public static class MatrixContext extends ParserRuleContext {
		public TerminalNode MATRIX_START() { return getToken(LscParser.MATRIX_START, 0); }
		public TerminalNode MATRIX_END() { return getToken(LscParser.MATRIX_END, 0); }
		public List<MatrixValueContext> matrixValue() {
			return getRuleContexts(MatrixValueContext.class);
		}
		public MatrixValueContext matrixValue(int i) {
			return getRuleContext(MatrixValueContext.class,i);
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
		enterRule(_localctx, 134, RULE_matrix);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(687);
			match(MATRIX_START);
			setState(689);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AT_LEAST_ONE) | (1L << HYPHEN) | (1L << NAME))) != 0)) {
				{
				setState(688);
				matrixValue();
				}
			}

			setState(695);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WHITESPACE) {
				{
				{
				setState(691);
				match(WHITESPACE);
				setState(692);
				matrixValue();
				}
				}
				setState(697);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(698);
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

	public static class MatrixValueContext extends ParserRuleContext {
		public PlusFeatureValueContext plusFeatureValue() {
			return getRuleContext(PlusFeatureValueContext.class,0);
		}
		public FeatureValueContext featureValue() {
			return getRuleContext(FeatureValueContext.class,0);
		}
		public MatrixValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_matrixValue; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LscVisitor ) return ((LscVisitor<? extends T>)visitor).visitMatrixValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MatrixValueContext matrixValue() throws RecognitionException {
		MatrixValueContext _localctx = new MatrixValueContext(_ctx, getState());
		enterRule(_localctx, 136, RULE_matrixValue);
		try {
			setState(702);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case AT_LEAST_ONE:
			case HYPHEN:
				enterOuterAlt(_localctx, 1);
				{
				setState(700);
				plusFeatureValue();
				}
				break;
			case NAME:
				enterOuterAlt(_localctx, 2);
				{
				setState(701);
				featureValue();
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

	public static class PlusFeatureValueContext extends ParserRuleContext {
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public TerminalNode AT_LEAST_ONE() { return getToken(LscParser.AT_LEAST_ONE, 0); }
		public TerminalNode HYPHEN() { return getToken(LscParser.HYPHEN, 0); }
		public PlusFeatureValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_plusFeatureValue; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LscVisitor ) return ((LscVisitor<? extends T>)visitor).visitPlusFeatureValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PlusFeatureValueContext plusFeatureValue() throws RecognitionException {
		PlusFeatureValueContext _localctx = new PlusFeatureValueContext(_ctx, getState());
		enterRule(_localctx, 138, RULE_plusFeatureValue);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(704);
			_la = _input.LA(1);
			if ( !(_la==AT_LEAST_ONE || _la==HYPHEN) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(705);
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

	public static class FeatureValueContext extends ParserRuleContext {
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public FeatureValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_featureValue; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LscVisitor ) return ((LscVisitor<? extends T>)visitor).visitFeatureValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FeatureValueContext featureValue() throws RecognitionException {
		FeatureValueContext _localctx = new FeatureValueContext(_ctx, getState());
		enterRule(_localctx, 140, RULE_featureValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(707);
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
		public TerminalNode NAME() { return getToken(LscParser.NAME, 0); }
		public NameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_name; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LscVisitor ) return ((LscVisitor<? extends T>)visitor).visitName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NameContext name() throws RecognitionException {
		NameContext _localctx = new NameContext(_ctx, getState());
		enterRule(_localctx, 142, RULE_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(709);
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
		public TerminalNode NAME() { return getToken(LscParser.NAME, 0); }
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
		enterRule(_localctx, 144, RULE_text);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(711);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NAME) | (1L << STR1) | (1L << STR))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(713);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NEGATION) {
				{
				setState(712);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\38\u02ce\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\3\2\3\2\7\2\u0097\n\2\f\2\16\2\u009a\13\2\3\2\5\2\u009d\n\2"+
		"\3\2\6\2\u00a0\n\2\r\2\16\2\u00a1\3\2\7\2\u00a5\n\2\f\2\16\2\u00a8\13"+
		"\2\3\2\7\2\u00ab\n\2\f\2\16\2\u00ae\13\2\3\2\5\2\u00b1\n\2\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\5\3\u00bc\n\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\7\4\u00c6\n\4\f\4\16\4\u00c9\13\4\3\4\3\4\3\5\3\5\5\5\u00cf\n\5\3\6\3"+
		"\6\3\6\3\6\3\6\7\6\u00d6\n\6\f\6\16\6\u00d9\13\6\3\6\3\6\3\6\5\6\u00de"+
		"\n\6\3\6\3\6\5\6\u00e2\n\6\3\6\3\6\3\6\3\6\5\6\u00e8\n\6\3\6\3\6\3\6\7"+
		"\6\u00ed\n\6\f\6\16\6\u00f0\13\6\3\6\3\6\5\6\u00f4\n\6\3\7\3\7\3\b\3\b"+
		"\3\b\5\b\u00fb\n\b\3\b\5\b\u00fe\n\b\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\7\n\u010c\n\n\f\n\16\n\u010f\13\n\3\n\3\n\3\n\7\n\u0114"+
		"\n\n\f\n\16\n\u0117\13\n\3\13\3\13\3\f\3\f\3\f\3\f\3\f\7\f\u0120\n\f\f"+
		"\f\16\f\u0123\13\f\3\f\3\f\5\f\u0127\n\f\3\r\3\r\3\16\3\16\3\16\6\16\u012e"+
		"\n\16\r\16\16\16\u012f\3\16\3\16\6\16\u0134\n\16\r\16\16\16\u0135\3\16"+
		"\6\16\u0139\n\16\r\16\16\16\u013a\5\16\u013d\n\16\3\17\3\17\3\17\5\17"+
		"\u0142\n\17\3\17\5\17\u0145\n\17\3\20\3\20\3\20\5\20\u014a\n\20\3\20\3"+
		"\20\6\20\u014e\n\20\r\20\16\20\u014f\3\20\3\20\3\21\3\21\3\21\5\21\u0157"+
		"\n\21\3\21\3\21\6\21\u015b\n\21\r\21\16\21\u015c\3\21\3\21\3\22\3\22\3"+
		"\22\3\22\3\22\5\22\u0166\n\22\3\22\3\22\6\22\u016a\n\22\r\22\16\22\u016b"+
		"\3\22\3\22\3\23\3\23\3\23\7\23\u0173\n\23\f\23\16\23\u0176\13\23\3\23"+
		"\5\23\u0179\n\23\3\23\6\23\u017c\n\23\r\23\16\23\u017d\3\23\3\23\3\24"+
		"\3\24\5\24\u0184\n\24\3\25\3\25\6\25\u0188\n\25\r\25\16\25\u0189\3\25"+
		"\3\25\3\25\3\25\6\25\u0190\n\25\r\25\16\25\u0191\5\25\u0194\n\25\3\25"+
		"\3\25\7\25\u0198\n\25\f\25\16\25\u019b\13\25\3\26\3\26\3\26\7\26\u01a0"+
		"\n\26\f\26\16\26\u01a3\13\26\3\26\3\26\7\26\u01a7\n\26\f\26\16\26\u01aa"+
		"\13\26\3\26\3\26\5\26\u01ae\n\26\3\27\3\27\3\27\7\27\u01b3\n\27\f\27\16"+
		"\27\u01b6\13\27\3\30\3\30\3\30\3\30\5\30\u01bc\n\30\3\31\3\31\3\32\3\32"+
		"\6\32\u01c2\n\32\r\32\16\32\u01c3\3\32\7\32\u01c7\n\32\f\32\16\32\u01ca"+
		"\13\32\3\33\3\33\3\33\7\33\u01cf\n\33\f\33\16\33\u01d2\13\33\3\34\3\34"+
		"\3\34\3\34\3\34\5\34\u01d9\n\34\5\34\u01db\n\34\3\35\3\35\3\36\3\36\3"+
		"\37\3\37\5\37\u01e3\n\37\3 \3 \3 \3 \3 \3 \5 \u01eb\n \3!\3!\5!\u01ef"+
		"\n!\3\"\3\"\3\"\3\"\3#\3#\3#\3#\7#\u01f9\n#\f#\16#\u01fc\13#\3#\3#\3$"+
		"\3$\3$\6$\u0203\n$\r$\16$\u0204\3%\3%\3%\3%\3%\5%\u020c\n%\3&\3&\3&\3"+
		"&\3&\5&\u0213\n&\3\'\3\'\3\'\5\'\u0218\n\'\3(\3(\3(\5(\u021d\n(\3)\3)"+
		"\3)\3)\7)\u0223\n)\f)\16)\u0226\13)\3)\3)\3*\3*\3*\5*\u022d\n*\3*\3*\3"+
		"*\5*\u0232\n*\3*\5*\u0235\n*\5*\u0237\n*\3+\3+\3,\3,\3-\3-\3-\3-\6-\u0241"+
		"\n-\r-\16-\u0242\3.\3.\3/\3/\3/\3/\5/\u024b\n/\3\60\3\60\3\60\3\61\3\61"+
		"\5\61\u0252\n\61\3\62\3\62\3\62\5\62\u0257\n\62\3\62\3\62\3\63\3\63\5"+
		"\63\u025d\n\63\3\63\3\63\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\64"+
		"\5\64\u026a\n\64\3\65\3\65\3\66\3\66\3\66\3\67\5\67\u0272\n\67\3\67\3"+
		"\67\3\67\38\38\58\u0279\n8\38\38\78\u027d\n8\f8\168\u0280\138\38\38\3"+
		"9\39\39\39\59\u0288\n9\3:\3:\3:\3;\3;\3;\3<\3<\3<\3=\3=\3>\3>\3?\3?\3"+
		"@\3@\3A\3A\3A\3A\5A\u029f\nA\3B\3B\3B\3B\5B\u02a5\nB\3B\3B\5B\u02a9\n"+
		"B\3B\5B\u02ac\nB\3C\3C\3D\3D\3E\3E\5E\u02b4\nE\3E\3E\7E\u02b8\nE\fE\16"+
		"E\u02bb\13E\3E\3E\3F\3F\5F\u02c1\nF\3G\3G\3G\3H\3H\3I\3I\3J\3J\5J\u02cc"+
		"\nJ\3J\2\2K\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\66"+
		"8:<>@BDFHJLNPRTVXZ\\^`bdfhjlnprtvxz|~\u0080\u0082\u0084\u0086\u0088\u008a"+
		"\u008c\u008e\u0090\u0092\2\n\3\2#%\3\2()\3\2-.\3\2\60\61\3\2\65\66\3\2"+
		"\34\36\4\2\22\22\24\24\3\2\668\2\u02f6\2\u00b0\3\2\2\2\4\u00bb\3\2\2\2"+
		"\6\u00bd\3\2\2\2\b\u00ce\3\2\2\2\n\u00d0\3\2\2\2\f\u00f5\3\2\2\2\16\u00fa"+
		"\3\2\2\2\20\u0101\3\2\2\2\22\u0104\3\2\2\2\24\u0118\3\2\2\2\26\u011a\3"+
		"\2\2\2\30\u0128\3\2\2\2\32\u012a\3\2\2\2\34\u013e\3\2\2\2\36\u0146\3\2"+
		"\2\2 \u0153\3\2\2\2\"\u0160\3\2\2\2$\u016f\3\2\2\2&\u0183\3\2\2\2(\u0185"+
		"\3\2\2\2*\u01ad\3\2\2\2,\u01af\3\2\2\2.\u01bb\3\2\2\2\60\u01bd\3\2\2\2"+
		"\62\u01bf\3\2\2\2\64\u01cb\3\2\2\2\66\u01da\3\2\2\28\u01dc\3\2\2\2:\u01de"+
		"\3\2\2\2<\u01e0\3\2\2\2>\u01ea\3\2\2\2@\u01ee\3\2\2\2B\u01f0\3\2\2\2D"+
		"\u01f4\3\2\2\2F\u01ff\3\2\2\2H\u020b\3\2\2\2J\u0212\3\2\2\2L\u0214\3\2"+
		"\2\2N\u0219\3\2\2\2P\u021e\3\2\2\2R\u0236\3\2\2\2T\u0238\3\2\2\2V\u023a"+
		"\3\2\2\2X\u023c\3\2\2\2Z\u0244\3\2\2\2\\\u024a\3\2\2\2^\u024c\3\2\2\2"+
		"`\u0251\3\2\2\2b\u0256\3\2\2\2d\u025c\3\2\2\2f\u0269\3\2\2\2h\u026b\3"+
		"\2\2\2j\u026d\3\2\2\2l\u0271\3\2\2\2n\u0276\3\2\2\2p\u0287\3\2\2\2r\u0289"+
		"\3\2\2\2t\u028c\3\2\2\2v\u028f\3\2\2\2x\u0292\3\2\2\2z\u0294\3\2\2\2|"+
		"\u0296\3\2\2\2~\u0298\3\2\2\2\u0080\u029e\3\2\2\2\u0082\u02a0\3\2\2\2"+
		"\u0084\u02ad\3\2\2\2\u0086\u02af\3\2\2\2\u0088\u02b1\3\2\2\2\u008a\u02c0"+
		"\3\2\2\2\u008c\u02c2\3\2\2\2\u008e\u02c5\3\2\2\2\u0090\u02c7\3\2\2\2\u0092"+
		"\u02c9\3\2\2\2\u0094\u00b1\7\n\2\2\u0095\u0097\7\t\2\2\u0096\u0095\3\2"+
		"\2\2\u0097\u009a\3\2\2\2\u0098\u0096\3\2\2\2\u0098\u0099\3\2\2\2\u0099"+
		"\u009c\3\2\2\2\u009a\u0098\3\2\2\2\u009b\u009d\5\4\3\2\u009c\u009b\3\2"+
		"\2\2\u009c\u009d\3\2\2\2\u009d\u00a6\3\2\2\2\u009e\u00a0\7\t\2\2\u009f"+
		"\u009e\3\2\2\2\u00a0\u00a1\3\2\2\2\u00a1\u009f\3\2\2\2\u00a1\u00a2\3\2"+
		"\2\2\u00a2\u00a3\3\2\2\2\u00a3\u00a5\5\4\3\2\u00a4\u009f\3\2\2\2\u00a5"+
		"\u00a8\3\2\2\2\u00a6\u00a4\3\2\2\2\u00a6\u00a7\3\2\2\2\u00a7\u00ac\3\2"+
		"\2\2\u00a8\u00a6\3\2\2\2\u00a9\u00ab\7\t\2\2\u00aa\u00a9\3\2\2\2\u00ab"+
		"\u00ae\3\2\2\2\u00ac\u00aa\3\2\2\2\u00ac\u00ad\3\2\2\2\u00ad\u00af\3\2"+
		"\2\2\u00ae\u00ac\3\2\2\2\u00af\u00b1\7\2\2\3\u00b0\u0094\3\2\2\2\u00b0"+
		"\u0098\3\2\2\2\u00b1\3\3\2\2\2\u00b2\u00bc\5\n\6\2\u00b3\u00bc\5\22\n"+
		"\2\u00b4\u00bc\5\26\f\2\u00b5\u00bc\5\6\4\2\u00b6\u00bc\5\32\16\2\u00b7"+
		"\u00bc\5\36\20\2\u00b8\u00bc\5$\23\2\u00b9\u00bc\5\"\22\2\u00ba\u00bc"+
		"\5 \21\2\u00bb\u00b2\3\2\2\2\u00bb\u00b3\3\2\2\2\u00bb\u00b4\3\2\2\2\u00bb"+
		"\u00b5\3\2\2\2\u00bb\u00b6\3\2\2\2\u00bb\u00b7\3\2\2\2\u00bb\u00b8\3\2"+
		"\2\2\u00bb\u00b9\3\2\2\2\u00bb\u00ba\3\2\2\2\u00bc\5\3\2\2\2\u00bd\u00be"+
		"\7\37\2\2\u00be\u00bf\7\n\2\2\u00bf\u00c0\5\u0090I\2\u00c0\u00c1\7\n\2"+
		"\2\u00c1\u00c2\7\20\2\2\u00c2\u00c7\5\b\5\2\u00c3\u00c4\7\4\2\2\u00c4"+
		"\u00c6\5\b\5\2\u00c5\u00c3\3\2\2\2\u00c6\u00c9\3\2\2\2\u00c7\u00c5\3\2"+
		"\2\2\u00c7\u00c8\3\2\2\2\u00c8\u00ca\3\2\2\2\u00c9\u00c7\3\2\2\2\u00ca"+
		"\u00cb\7\21\2\2\u00cb\7\3\2\2\2\u00cc\u00cf\5j\66\2\u00cd\u00cf\5\u0092"+
		"J\2\u00ce\u00cc\3\2\2\2\u00ce\u00cd\3\2\2\2\u00cf\t\3\2\2\2\u00d0\u00d1"+
		"\7 \2\2\u00d1\u00f3\7\n\2\2\u00d2\u00d7\5\16\b\2\u00d3\u00d4\7\4\2\2\u00d4"+
		"\u00d6\5\16\b\2\u00d5\u00d3\3\2\2\2\u00d6\u00d9\3\2\2\2\u00d7\u00d5\3"+
		"\2\2\2\u00d7\u00d8\3\2\2\2\u00d8\u00f4\3\2\2\2\u00d9\u00d7\3\2\2\2\u00da"+
		"\u00db\5\f\7\2\u00db\u00dc\7\n\2\2\u00dc\u00de\3\2\2\2\u00dd\u00da\3\2"+
		"\2\2\u00dd\u00de\3\2\2\2\u00de\u00df\3\2\2\2\u00df\u00e1\5\u0090I\2\u00e0"+
		"\u00e2\7\n\2\2\u00e1\u00e0\3\2\2\2\u00e1\u00e2\3\2\2\2\u00e2\u00e3\3\2"+
		"\2\2\u00e3\u00e7\7\13\2\2\u00e4\u00e5\5\20\t\2\u00e5\u00e6\7\4\2\2\u00e6"+
		"\u00e8\3\2\2\2\u00e7\u00e4\3\2\2\2\u00e7\u00e8\3\2\2\2\u00e8\u00e9\3\2"+
		"\2\2\u00e9\u00ee\5\u008eH\2\u00ea\u00eb\7\4\2\2\u00eb\u00ed\5\u008eH\2"+
		"\u00ec\u00ea\3\2\2\2\u00ed\u00f0\3\2\2\2\u00ee\u00ec\3\2\2\2\u00ee\u00ef"+
		"\3\2\2\2\u00ef\u00f1\3\2\2\2\u00f0\u00ee\3\2\2\2\u00f1\u00f2\7\f\2\2\u00f2"+
		"\u00f4\3\2\2\2\u00f3\u00d2\3\2\2\2\u00f3\u00dd\3\2\2\2\u00f4\13\3\2\2"+
		"\2\u00f5\u00f6\7!\2\2\u00f6\r\3\2\2\2\u00f7\u00f8\5\f\7\2\u00f8\u00f9"+
		"\7\n\2\2\u00f9\u00fb\3\2\2\2\u00fa\u00f7\3\2\2\2\u00fa\u00fb\3\2\2\2\u00fb"+
		"\u00fd\3\2\2\2\u00fc\u00fe\7\22\2\2\u00fd\u00fc\3\2\2\2\u00fd\u00fe\3"+
		"\2\2\2\u00fe\u00ff\3\2\2\2\u00ff\u0100\5\u0090I\2\u0100\17\3\2\2\2\u0101"+
		"\u0102\7\r\2\2\u0102\u0103\5\u008eH\2\u0103\21\3\2\2\2\u0104\u0105\7\""+
		"\2\2\u0105\u0106\7\n\2\2\u0106\u0107\5\u0092J\2\u0107\u010d\7\n\2\2\u0108"+
		"\u0109\5\24\13\2\u0109\u010a\7\n\2\2\u010a\u010c\3\2\2\2\u010b\u0108\3"+
		"\2\2\2\u010c\u010f\3\2\2\2\u010d\u010b\3\2\2\2\u010d\u010e\3\2\2\2\u010e"+
		"\u0110\3\2\2\2\u010f\u010d\3\2\2\2\u0110\u0115\5\u0088E\2\u0111\u0112"+
		"\7\n\2\2\u0112\u0114\5\24\13\2\u0113\u0111\3\2\2\2\u0114\u0117\3\2\2\2"+
		"\u0115\u0113\3\2\2\2\u0115\u0116\3\2\2\2\u0116\23\3\2\2\2\u0117\u0115"+
		"\3\2\2\2\u0118\u0119\t\2\2\2\u0119\25\3\2\2\2\u011a\u011b\7&\2\2\u011b"+
		"\u011c\7\n\2\2\u011c\u0126\5\30\r\2\u011d\u011e\7\4\2\2\u011e\u0120\5"+
		"\30\r\2\u011f\u011d\3\2\2\2\u0120\u0123\3\2\2\2\u0121\u011f\3\2\2\2\u0121"+
		"\u0122\3\2\2\2\u0122\u0127\3\2\2\2\u0123\u0121\3\2\2\2\u0124\u0125\7\n"+
		"\2\2\u0125\u0127\5\u0088E\2\u0126\u0121\3\2\2\2\u0126\u0124\3\2\2\2\u0127"+
		"\27\3\2\2\2\u0128\u0129\5\u0092J\2\u0129\31\3\2\2\2\u012a\u012b\7\'\2"+
		"\2\u012b\u013c\7\25\2\2\u012c\u012e\7\t\2\2\u012d\u012c\3\2\2\2\u012e"+
		"\u012f\3\2\2\2\u012f\u012d\3\2\2\2\u012f\u0130\3\2\2\2\u0130\u0131\3\2"+
		"\2\2\u0131\u013d\t\3\2\2\u0132\u0134\7\t\2\2\u0133\u0132\3\2\2\2\u0134"+
		"\u0135\3\2\2\2\u0135\u0133\3\2\2\2\u0135\u0136\3\2\2\2\u0136\u0137\3\2"+
		"\2\2\u0137\u0139\5\34\17\2\u0138\u0133\3\2\2\2\u0139\u013a\3\2\2\2\u013a"+
		"\u0138\3\2\2\2\u013a\u013b\3\2\2\2\u013b\u013d\3\2\2\2\u013c\u012d\3\2"+
		"\2\2\u013c\u0138\3\2\2\2\u013d\33\3\2\2\2\u013e\u0141\5> \2\u013f\u0140"+
		"\7\5\2\2\u0140\u0142\5\u0088E\2\u0141\u013f\3\2\2\2\u0141\u0142\3\2\2"+
		"\2\u0142\u0144\3\2\2\2\u0143\u0145\5J&\2\u0144\u0143\3\2\2\2\u0144\u0145"+
		"\3\2\2\2\u0145\35\3\2\2\2\u0146\u0149\7+\2\2\u0147\u0148\7\n\2\2\u0148"+
		"\u014a\7\62\2\2\u0149\u0147\3\2\2\2\u0149\u014a\3\2\2\2\u014a\u014b\3"+
		"\2\2\2\u014b\u014d\7\25\2\2\u014c\u014e\7\t\2\2\u014d\u014c\3\2\2\2\u014e"+
		"\u014f\3\2\2\2\u014f\u014d\3\2\2\2\u014f\u0150\3\2\2\2\u0150\u0151\3\2"+
		"\2\2\u0151\u0152\5(\25\2\u0152\37\3\2\2\2\u0153\u0156\7,\2\2\u0154\u0155"+
		"\7\n\2\2\u0155\u0157\7\62\2\2\u0156\u0154\3\2\2\2\u0156\u0157\3\2\2\2"+
		"\u0157\u0158\3\2\2\2\u0158\u015a\7\25\2\2\u0159\u015b\7\t\2\2\u015a\u0159"+
		"\3\2\2\2\u015b\u015c\3\2\2\2\u015c\u015a\3\2\2\2\u015c\u015d\3\2\2\2\u015d"+
		"\u015e\3\2\2\2\u015e\u015f\5(\25\2\u015f!\3\2\2\2\u0160\u0161\7,\2\2\u0161"+
		"\u0162\7\24\2\2\u0162\u0165\5\64\33\2\u0163\u0164\7\n\2\2\u0164\u0166"+
		"\7\62\2\2\u0165\u0163\3\2\2\2\u0165\u0166\3\2\2\2\u0166\u0167\3\2\2\2"+
		"\u0167\u0169\7\25\2\2\u0168\u016a\7\t\2\2\u0169\u0168\3\2\2\2\u016a\u016b"+
		"\3\2\2\2\u016b\u0169\3\2\2\2\u016b\u016c\3\2\2\2\u016c\u016d\3\2\2\2\u016d"+
		"\u016e\5(\25\2\u016e#\3\2\2\2\u016f\u0174\5\64\33\2\u0170\u0171\7\n\2"+
		"\2\u0171\u0173\5.\30\2\u0172\u0170\3\2\2\2\u0173\u0176\3\2\2\2\u0174\u0172"+
		"\3\2\2\2\u0174\u0175\3\2\2\2\u0175\u0178\3\2\2\2\u0176\u0174\3\2\2\2\u0177"+
		"\u0179\7\25\2\2\u0178\u0177\3\2\2\2\u0178\u0179\3\2\2\2\u0179\u017b\3"+
		"\2\2\2\u017a\u017c\7\t\2\2\u017b\u017a\3\2\2\2\u017c\u017d\3\2\2\2\u017d"+
		"\u017b\3\2\2\2\u017d\u017e\3\2\2\2\u017e\u017f\3\2\2\2\u017f\u0180\5("+
		"\25\2\u0180%\3\2\2\2\u0181\u0184\5j\66\2\u0182\u0184\5n8\2\u0183\u0181"+
		"\3\2\2\2\u0183\u0182\3\2\2\2\u0184\'\3\2\2\2\u0185\u0199\5*\26\2\u0186"+
		"\u0188\7\t\2\2\u0187\u0186\3\2\2\2\u0188\u0189\3\2\2\2\u0189\u0187\3\2"+
		"\2\2\u0189\u018a\3\2\2\2\u018a\u018b\3\2\2\2\u018b\u018c\5,\27\2\u018c"+
		"\u0193\7\25\2\2\u018d\u0194\7\n\2\2\u018e\u0190\7\t\2\2\u018f\u018e\3"+
		"\2\2\2\u0190\u0191\3\2\2\2\u0191\u018f\3\2\2\2\u0191\u0192\3\2\2\2\u0192"+
		"\u0194\3\2\2\2\u0193\u018d\3\2\2\2\u0193\u018f\3\2\2\2\u0194\u0195\3\2"+
		"\2\2\u0195\u0196\5*\26\2\u0196\u0198\3\2\2\2\u0197\u0187\3\2\2\2\u0198"+
		"\u019b\3\2\2\2\u0199\u0197\3\2\2\2\u0199\u019a\3\2\2\2\u019a)\3\2\2\2"+
		"\u019b\u0199\3\2\2\2\u019c\u01ae\5\62\32\2\u019d\u01a1\7\13\2\2\u019e"+
		"\u01a0\7\t\2\2\u019f\u019e\3\2\2\2\u01a0\u01a3\3\2\2\2\u01a1\u019f\3\2"+
		"\2\2\u01a1\u01a2\3\2\2\2\u01a2\u01a4\3\2\2\2\u01a3\u01a1\3\2\2\2\u01a4"+
		"\u01a8\5(\25\2\u01a5\u01a7\7\t\2\2\u01a6\u01a5\3\2\2\2\u01a7\u01aa\3\2"+
		"\2\2\u01a8\u01a6\3\2\2\2\u01a8\u01a9\3\2\2\2\u01a9\u01ab\3\2\2\2\u01aa"+
		"\u01a8\3\2\2\2\u01ab\u01ac\7\f\2\2\u01ac\u01ae\3\2\2\2\u01ad\u019c\3\2"+
		"\2\2\u01ad\u019d\3\2\2\2\u01ae+\3\2\2\2\u01af\u01b4\t\4\2\2\u01b0\u01b1"+
		"\7\n\2\2\u01b1\u01b3\5.\30\2\u01b2\u01b0\3\2\2\2\u01b3\u01b6\3\2\2\2\u01b4"+
		"\u01b2\3\2\2\2\u01b4\u01b5\3\2\2\2\u01b5-\3\2\2\2\u01b6\u01b4\3\2\2\2"+
		"\u01b7\u01bc\5&\24\2\u01b8\u01bc\5\60\31\2\u01b9\u01bc\7/\2\2\u01ba\u01bc"+
		"\7\63\2\2\u01bb\u01b7\3\2\2\2\u01bb\u01b8\3\2\2\2\u01bb\u01b9\3\2\2\2"+
		"\u01bb\u01ba\3\2\2\2\u01bc/\3\2\2\2\u01bd\u01be\t\5\2\2\u01be\61\3\2\2"+
		"\2\u01bf\u01c8\5\66\34\2\u01c0\u01c2\7\t\2\2\u01c1\u01c0\3\2\2\2\u01c2"+
		"\u01c3\3\2\2\2\u01c3\u01c1\3\2\2\2\u01c3\u01c4\3\2\2\2\u01c4\u01c5\3\2"+
		"\2\2\u01c5\u01c7\5\66\34\2\u01c6\u01c1\3\2\2\2\u01c7\u01ca\3\2\2\2\u01c8"+
		"\u01c6\3\2\2\2\u01c8\u01c9\3\2\2\2\u01c9\63\3\2\2\2\u01ca\u01c8\3\2\2"+
		"\2\u01cb\u01d0\7\66\2\2\u01cc\u01cd\7\24\2\2\u01cd\u01cf\t\6\2\2\u01ce"+
		"\u01cc\3\2\2\2\u01cf\u01d2\3\2\2\2\u01d0\u01ce\3\2\2\2\u01d0\u01d1\3\2"+
		"\2\2\u01d1\65\3\2\2\2\u01d2\u01d0\3\2\2\2\u01d3\u01db\7\64\2\2\u01d4\u01d5"+
		"\58\35\2\u01d5\u01d6\7\5\2\2\u01d6\u01d8\5:\36\2\u01d7\u01d9\5J&\2\u01d8"+
		"\u01d7\3\2\2\2\u01d8\u01d9\3\2\2\2\u01d9\u01db\3\2\2\2\u01da\u01d3\3\2"+
		"\2\2\u01da\u01d4\3\2\2\2\u01db\67\3\2\2\2\u01dc\u01dd\5<\37\2\u01dd9\3"+
		"\2\2\2\u01de\u01df\5> \2\u01df;\3\2\2\2\u01e0\u01e2\5> \2\u01e1\u01e3"+
		"\5J&\2\u01e2\u01e1\3\2\2\2\u01e2\u01e3\3\2\2\2\u01e3=\3\2\2\2\u01e4\u01eb"+
		"\5@!\2\u01e5\u01eb\5X-\2\u01e6\u01eb\5^\60\2\u01e7\u01eb\5`\61\2\u01e8"+
		"\u01eb\5f\64\2\u01e9\u01eb\5F$\2\u01ea\u01e4\3\2\2\2\u01ea\u01e5\3\2\2"+
		"\2\u01ea\u01e6\3\2\2\2\u01ea\u01e7\3\2\2\2\u01ea\u01e8\3\2\2\2\u01ea\u01e9"+
		"\3\2\2\2\u01eb?\3\2\2\2\u01ec\u01ef\5B\"\2\u01ed\u01ef\5D#\2\u01ee\u01ec"+
		"\3\2\2\2\u01ee\u01ed\3\2\2\2\u01efA\3\2\2\2\u01f0\u01f1\7\13\2\2\u01f1"+
		"\u01f2\5<\37\2\u01f2\u01f3\7\f\2\2\u01f3C\3\2\2\2\u01f4\u01f5\7\20\2\2"+
		"\u01f5\u01fa\5<\37\2\u01f6\u01f7\7\4\2\2\u01f7\u01f9\5<\37\2\u01f8\u01f6"+
		"\3\2\2\2\u01f9\u01fc\3\2\2\2\u01fa\u01f8\3\2\2\2\u01fa\u01fb\3\2\2\2\u01fb"+
		"\u01fd\3\2\2\2\u01fc\u01fa\3\2\2\2\u01fd\u01fe\7\21\2\2\u01feE\3\2\2\2"+
		"\u01ff\u0202\5H%\2\u0200\u0201\7\n\2\2\u0201\u0203\5H%\2\u0202\u0200\3"+
		"\2\2\2\u0203\u0204\3\2\2\2\u0204\u0202\3\2\2\2\u0204\u0205\3\2\2\2\u0205"+
		"G\3\2\2\2\u0206\u020c\5@!\2\u0207\u020c\5X-\2\u0208\u020c\5^\60\2\u0209"+
		"\u020c\5`\61\2\u020a\u020c\5f\64\2\u020b\u0206\3\2\2\2\u020b\u0207\3\2"+
		"\2\2\u020b\u0208\3\2\2\2\u020b\u0209\3\2\2\2\u020b\u020a\3\2\2\2\u020c"+
		"I\3\2\2\2\u020d\u0213\5L\'\2\u020e\u0213\5N(\2\u020f\u0210\5L\'\2\u0210"+
		"\u0211\5N(\2\u0211\u0213\3\2\2\2\u0212\u020d\3\2\2\2\u0212\u020e\3\2\2"+
		"\2\u0212\u020f\3\2\2\2\u0213K\3\2\2\2\u0214\u0217\7\6\2\2\u0215\u0218"+
		"\5R*\2\u0216\u0218\5P)\2\u0217\u0215\3\2\2\2\u0217\u0216\3\2\2\2\u0218"+
		"M\3\2\2\2\u0219\u021c\7\7\2\2\u021a\u021d\5R*\2\u021b\u021d\5P)\2\u021c"+
		"\u021a\3\2\2\2\u021c\u021b\3\2\2\2\u021dO\3\2\2\2\u021e\u021f\7\20\2\2"+
		"\u021f\u0224\5R*\2\u0220\u0221\7\4\2\2\u0221\u0223\5R*\2\u0222\u0220\3"+
		"\2\2\2\u0223\u0226\3\2\2\2\u0224\u0222\3\2\2\2\u0224\u0225\3\2\2\2\u0225"+
		"\u0227\3\2\2\2\u0226\u0224\3\2\2\2\u0227\u0228\7\21\2\2\u0228Q\3\2\2\2"+
		"\u0229\u022a\5T+\2\u022a\u022b\7\n\2\2\u022b\u022d\3\2\2\2\u022c\u0229"+
		"\3\2\2\2\u022c\u022d\3\2\2\2\u022d\u022e\3\2\2\2\u022e\u0231\7\b\2\2\u022f"+
		"\u0230\7\n\2\2\u0230\u0232\5V,\2\u0231\u022f\3\2\2\2\u0231\u0232\3\2\2"+
		"\2\u0232\u0237\3\2\2\2\u0233\u0235\5T+\2\u0234\u0233\3\2\2\2\u0234\u0235"+
		"\3\2\2\2\u0235\u0237\3\2\2\2\u0236\u022c\3\2\2\2\u0236\u0234\3\2\2\2\u0237"+
		"S\3\2\2\2\u0238\u0239\5> \2\u0239U\3\2\2\2\u023a\u023b\5> \2\u023bW\3"+
		"\2\2\2\u023c\u0240\5\\/\2\u023d\u023e\5Z.\2\u023e\u023f\5\\/\2\u023f\u0241"+
		"\3\2\2\2\u0240\u023d\3\2\2\2\u0241\u0242\3\2\2\2\u0242\u0240\3\2\2\2\u0242"+
		"\u0243\3\2\2\2\u0243Y\3\2\2\2\u0244\u0245\t\7\2\2\u0245[\3\2\2\2\u0246"+
		"\u024b\5@!\2\u0247\u024b\5^\60\2\u0248\u024b\5`\61\2\u0249\u024b\5f\64"+
		"\2\u024a\u0246\3\2\2\2\u024a\u0247\3\2\2\2\u024a\u0248\3\2\2\2\u024a\u0249"+
		"\3\2\2\2\u024b]\3\2\2\2\u024c\u024d\7\27\2\2\u024d\u024e\5f\64\2\u024e"+
		"_\3\2\2\2\u024f\u0252\5b\62\2\u0250\u0252\5d\63\2\u0251\u024f\3\2\2\2"+
		"\u0251\u0250\3\2\2\2\u0252a\3\2\2\2\u0253\u0257\5@!\2\u0254\u0257\5^\60"+
		"\2\u0255\u0257\5f\64\2\u0256\u0253\3\2\2\2\u0256\u0254\3\2\2\2\u0256\u0255"+
		"\3\2\2\2\u0257\u0258\3\2\2\2\u0258\u0259\5l\67\2\u0259c\3\2\2\2\u025a"+
		"\u025d\5@!\2\u025b\u025d\5f\64\2\u025c\u025a\3\2\2\2\u025c\u025b\3\2\2"+
		"\2\u025d\u025e\3\2\2\2\u025e\u025f\5\u0080A\2\u025fe\3\2\2\2\u0260\u026a"+
		"\5h\65\2\u0261\u026a\5j\66\2\u0262\u026a\5l\67\2\u0263\u026a\5n8\2\u0264"+
		"\u026a\5x=\2\u0265\u026a\5z>\2\u0266\u026a\5|?\2\u0267\u026a\5~@\2\u0268"+
		"\u026a\5\u0092J\2\u0269\u0260\3\2\2\2\u0269\u0261\3\2\2\2\u0269\u0262"+
		"\3\2\2\2\u0269\u0263\3\2\2\2\u0269\u0264\3\2\2\2\u0269\u0265\3\2\2\2\u0269"+
		"\u0266\3\2\2\2\u0269\u0267\3\2\2\2\u0269\u0268\3\2\2\2\u026ag\3\2\2\2"+
		"\u026b\u026c\7*\2\2\u026ci\3\2\2\2\u026d\u026e\7\33\2\2\u026e\u026f\5"+
		"\u0090I\2\u026fk\3\2\2\2\u0270\u0272\7\26\2\2\u0271\u0270\3\2\2\2\u0271"+
		"\u0272\3\2\2\2\u0272\u0273\3\2\2\2\u0273\u0274\7\31\2\2\u0274\u0275\7"+
		"\65\2\2\u0275m\3\2\2\2\u0276\u0278\7\16\2\2\u0277\u0279\5p9\2\u0278\u0277"+
		"\3\2\2\2\u0278\u0279\3\2\2\2\u0279\u027e\3\2\2\2\u027a\u027b\7\n\2\2\u027b"+
		"\u027d\5p9\2\u027c\u027a\3\2\2\2\u027d\u0280\3\2\2\2\u027e\u027c\3\2\2"+
		"\2\u027e\u027f\3\2\2\2\u027f\u0281\3\2\2\2\u0280\u027e\3\2\2\2\u0281\u0282"+
		"\7\17\2\2\u0282o\3\2\2\2\u0283\u0288\5\u008aF\2\u0284\u0288\5r:\2\u0285"+
		"\u0288\5t;\2\u0286\u0288\5v<\2\u0287\u0283\3\2\2\2\u0287\u0284\3\2\2\2"+
		"\u0287\u0285\3\2\2\2\u0287\u0286\3\2\2\2\u0288q\3\2\2\2\u0289\u028a\7"+
		"\27\2\2\u028a\u028b\5\u008aF\2\u028bs\3\2\2\2\u028c\u028d\7\r\2\2\u028d"+
		"\u028e\5\u0090I\2\u028eu\3\2\2\2\u028f\u0290\7\31\2\2\u0290\u0291\5\u0090"+
		"I\2\u0291w\3\2\2\2\u0292\u0293\7\r\2\2\u0293y\3\2\2\2\u0294\u0295\7\30"+
		"\2\2\u0295{\3\2\2\2\u0296\u0297\7\31\2\2\u0297}\3\2\2\2\u0298\u0299\7"+
		"\32\2\2\u0299\177\3\2\2\2\u029a\u029f\5\u0082B\2\u029b\u029f\7\22\2\2"+
		"\u029c\u029f\7\r\2\2\u029d\u029f\7\23\2\2\u029e\u029a\3\2\2\2\u029e\u029b"+
		"\3\2\2\2\u029e\u029c\3\2\2\2\u029e\u029d\3\2\2\2\u029f\u0081\3\2\2\2\u02a0"+
		"\u02ab\7\r\2\2\u02a1\u02ac\7\65\2\2\u02a2\u02a4\7\13\2\2\u02a3\u02a5\5"+
		"\u0084C\2\u02a4\u02a3\3\2\2\2\u02a4\u02a5\3\2\2\2\u02a5\u02a6\3\2\2\2"+
		"\u02a6\u02a8\7\24\2\2\u02a7\u02a9\5\u0086D\2\u02a8\u02a7\3\2\2\2\u02a8"+
		"\u02a9\3\2\2\2\u02a9\u02aa\3\2\2\2\u02aa\u02ac\7\f\2\2\u02ab\u02a1\3\2"+
		"\2\2\u02ab\u02a2\3\2\2\2\u02ac\u0083\3\2\2\2\u02ad\u02ae\7\65\2\2\u02ae"+
		"\u0085\3\2\2\2\u02af\u02b0\7\65\2\2\u02b0\u0087\3\2\2\2\u02b1\u02b3\7"+
		"\16\2\2\u02b2\u02b4\5\u008aF\2\u02b3\u02b2\3\2\2\2\u02b3\u02b4\3\2\2\2"+
		"\u02b4\u02b9\3\2\2\2\u02b5\u02b6\7\n\2\2\u02b6\u02b8\5\u008aF\2\u02b7"+
		"\u02b5\3\2\2\2\u02b8\u02bb\3\2\2\2\u02b9\u02b7\3\2\2\2\u02b9\u02ba\3\2"+
		"\2\2\u02ba\u02bc\3\2\2\2\u02bb\u02b9\3\2\2\2\u02bc\u02bd\7\17\2\2\u02bd"+
		"\u0089\3\2\2\2\u02be\u02c1\5\u008cG\2\u02bf\u02c1\5\u008eH\2\u02c0\u02be"+
		"\3\2\2\2\u02c0\u02bf\3\2\2\2\u02c1\u008b\3\2\2\2\u02c2\u02c3\t\b\2\2\u02c3"+
		"\u02c4\5\u0090I\2\u02c4\u008d\3\2\2\2\u02c5\u02c6\5\u0090I\2\u02c6\u008f"+
		"\3\2\2\2\u02c7\u02c8\7\66\2\2\u02c8\u0091\3\2\2\2\u02c9\u02cb\t\t\2\2"+
		"\u02ca\u02cc\7\27\2\2\u02cb\u02ca\3\2\2\2\u02cb\u02cc\3\2\2\2\u02cc\u0093"+
		"\3\2\2\2U\u0098\u009c\u00a1\u00a6\u00ac\u00b0\u00bb\u00c7\u00ce\u00d7"+
		"\u00dd\u00e1\u00e7\u00ee\u00f3\u00fa\u00fd\u010d\u0115\u0121\u0126\u012f"+
		"\u0135\u013a\u013c\u0141\u0144\u0149\u014f\u0156\u015c\u0165\u016b\u0174"+
		"\u0178\u017d\u0183\u0189\u0191\u0193\u0199\u01a1\u01a8\u01ad\u01b4\u01bb"+
		"\u01c3\u01c8\u01d0\u01d8\u01da\u01e2\u01ea\u01ee\u01fa\u0204\u020b\u0212"+
		"\u0217\u021c\u0224\u022c\u0231\u0234\u0236\u0242\u024a\u0251\u0256\u025c"+
		"\u0269\u0271\u0278\u027e\u0287\u029e\u02a4\u02a8\u02ab\u02b3\u02b9\u02c0"+
		"\u02cb";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}