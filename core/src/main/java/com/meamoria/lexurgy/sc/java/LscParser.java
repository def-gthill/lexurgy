// Generated from /Users/gthill/projects/lexurgy/core/src/antlr/sc/Lsc.g4 by ANTLR 4.13.1
package com.meamoria.lexurgy.sc.java;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class LscParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		COMMENT=1, LIST_SEP=2, CLASS_SEP=3, CHANGE=4, CONDITION=5, EXCLUSION=6, 
		ANCHOR=7, NEWLINE=8, WHITESPACE=9, O_PAREN=10, C_PAREN=11, NULL=12, MATRIX_START=13, 
		MATRIX_END=14, LIST_START=15, CLASS_START=16, LIST_END=17, AT_LEAST_ONE=18, 
		OPTIONAL=19, HYPHEN=20, RULE_START=21, INEXACT=22, NEGATION=23, SYLLABLE_BOUNDARY=24, 
		WORD_BOUNDARY=25, BETWEEN_WORDS=26, CLASSREF=27, INTERSECTION=28, INTERSECTION_NOT=29, 
		TRANSFORMING=30, ELEMENT_DECL=31, CLASS_DECL=32, FEATURE_DECL=33, SYLLABLE_FEATURE=34, 
		DIACRITIC_DECL=35, DIA_BEFORE=36, DIA_FIRST=37, DIA_FLOATING=38, SYMBOL_DECL=39, 
		SYLLABLE_DECL=40, EXPLICIT_SYLLABLES=41, CLEAR_SYLLABLES=42, ANY_SYLLABLE=43, 
		DEROMANIZER=44, ROMANIZER=45, ALL_MATCHING=46, FIRST_MATCHING=47, LITERAL=48, 
		LTR=49, RTL=50, PROPAGATE=51, CLEANUP=52, BLOCK=53, UNCHANGED=54, OFF=55, 
		NUMBER=56, NAME=57, STR1=58, STR=59;
	public static final int
		RULE_lscFile = 0, RULE_statement = 1, RULE_elementDecl = 2, RULE_classDecl = 3, 
		RULE_classElement = 4, RULE_featureDecl = 5, RULE_featureModifier = 6, 
		RULE_plusFeature = 7, RULE_nullAlias = 8, RULE_diacriticDecl = 9, RULE_diacriticModifier = 10, 
		RULE_symbolDecl = 11, RULE_symbolName = 12, RULE_syllableDecl = 13, RULE_syllablePattern = 14, 
		RULE_deromanizer = 15, RULE_romanizer = 16, RULE_interRomanizer = 17, 
		RULE_changeRule = 18, RULE_filter = 19, RULE_block = 20, RULE_blockElement = 21, 
		RULE_blockType = 22, RULE_changeRuleModifier = 23, RULE_keywordModifier = 24, 
		RULE_expressionList = 25, RULE_ruleName = 26, RULE_expression = 27, RULE_keywordExpression = 28, 
		RULE_blockRef = 29, RULE_standardExpression = 30, RULE_from = 31, RULE_to = 32, 
		RULE_ruleElement = 33, RULE_unconditionalRuleElement = 34, RULE_bounded = 35, 
		RULE_group = 36, RULE_list = 37, RULE_sequence = 38, RULE_freeElement = 39, 
		RULE_compoundEnvironment = 40, RULE_condition = 41, RULE_exclusion = 42, 
		RULE_environmentList = 43, RULE_environment = 44, RULE_environmentBefore = 45, 
		RULE_environmentAfter = 46, RULE_interfix = 47, RULE_interfixType = 48, 
		RULE_interfixElement = 49, RULE_negated = 50, RULE_postfix = 51, RULE_capture = 52, 
		RULE_repeater = 53, RULE_simple = 54, RULE_anySyllable = 55, RULE_elementRef = 56, 
		RULE_captureRef = 57, RULE_fancyMatrix = 58, RULE_fancyValue = 59, RULE_negatedValue = 60, 
		RULE_absentFeature = 61, RULE_featureVariable = 62, RULE_empty = 63, RULE_sylBoundary = 64, 
		RULE_boundary = 65, RULE_betweenWords = 66, RULE_repeaterType = 67, RULE_repeatRange = 68, 
		RULE_lowerBound = 69, RULE_upperBound = 70, RULE_matrix = 71, RULE_matrixValue = 72, 
		RULE_plusFeatureValue = 73, RULE_featureValue = 74, RULE_text = 75, RULE_name = 76;
	private static String[] makeRuleNames() {
		return new String[] {
			"lscFile", "statement", "elementDecl", "classDecl", "classElement", "featureDecl", 
			"featureModifier", "plusFeature", "nullAlias", "diacriticDecl", "diacriticModifier", 
			"symbolDecl", "symbolName", "syllableDecl", "syllablePattern", "deromanizer", 
			"romanizer", "interRomanizer", "changeRule", "filter", "block", "blockElement", 
			"blockType", "changeRuleModifier", "keywordModifier", "expressionList", 
			"ruleName", "expression", "keywordExpression", "blockRef", "standardExpression", 
			"from", "to", "ruleElement", "unconditionalRuleElement", "bounded", "group", 
			"list", "sequence", "freeElement", "compoundEnvironment", "condition", 
			"exclusion", "environmentList", "environment", "environmentBefore", "environmentAfter", 
			"interfix", "interfixType", "interfixElement", "negated", "postfix", 
			"capture", "repeater", "simple", "anySyllable", "elementRef", "captureRef", 
			"fancyMatrix", "fancyValue", "negatedValue", "absentFeature", "featureVariable", 
			"empty", "sylBoundary", "boundary", "betweenWords", "repeaterType", "repeatRange", 
			"lowerBound", "upperBound", "matrix", "matrixValue", "plusFeatureValue", 
			"featureValue", "text", "name"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, null, null, "'_'", null, null, null, null, 
			"'*'", null, null, null, null, null, "'+'", "'?'", "'-'", "':'", "'~'", 
			"'!'", "'.'", "'$'", "'$$'", "'@'", "'&'", "'&!'", "'>'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "COMMENT", "LIST_SEP", "CLASS_SEP", "CHANGE", "CONDITION", "EXCLUSION", 
			"ANCHOR", "NEWLINE", "WHITESPACE", "O_PAREN", "C_PAREN", "NULL", "MATRIX_START", 
			"MATRIX_END", "LIST_START", "CLASS_START", "LIST_END", "AT_LEAST_ONE", 
			"OPTIONAL", "HYPHEN", "RULE_START", "INEXACT", "NEGATION", "SYLLABLE_BOUNDARY", 
			"WORD_BOUNDARY", "BETWEEN_WORDS", "CLASSREF", "INTERSECTION", "INTERSECTION_NOT", 
			"TRANSFORMING", "ELEMENT_DECL", "CLASS_DECL", "FEATURE_DECL", "SYLLABLE_FEATURE", 
			"DIACRITIC_DECL", "DIA_BEFORE", "DIA_FIRST", "DIA_FLOATING", "SYMBOL_DECL", 
			"SYLLABLE_DECL", "EXPLICIT_SYLLABLES", "CLEAR_SYLLABLES", "ANY_SYLLABLE", 
			"DEROMANIZER", "ROMANIZER", "ALL_MATCHING", "FIRST_MATCHING", "LITERAL", 
			"LTR", "RTL", "PROPAGATE", "CLEANUP", "BLOCK", "UNCHANGED", "OFF", "NUMBER", 
			"NAME", "STR1", "STR"
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

	@SuppressWarnings("CheckReturnValue")
	public static class LscFileContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(LscParser.EOF, 0); }
		public List<TerminalNode> WHITESPACE() { return getTokens(LscParser.WHITESPACE); }
		public TerminalNode WHITESPACE(int i) {
			return getToken(LscParser.WHITESPACE, i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(LscParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(LscParser.NEWLINE, i);
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
			setState(161);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				{
				setState(154);
				match(WHITESPACE);
				}
				break;
			case 2:
				{
				setState(158);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(155);
						match(NEWLINE);
						}
						} 
					}
					setState(160);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
				}
				}
				break;
			}
			setState(164);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1080863410469516288L) != 0)) {
				{
				setState(163);
				statement();
				}
			}

			setState(174);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(167); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(166);
						match(NEWLINE);
						}
						}
						setState(169); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==NEWLINE );
					setState(171);
					statement();
					}
					} 
				}
				setState(176);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			}
			setState(184);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case WHITESPACE:
				{
				setState(177);
				match(WHITESPACE);
				}
				break;
			case EOF:
			case NEWLINE:
				{
				setState(181);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NEWLINE) {
					{
					{
					setState(178);
					match(NEWLINE);
					}
					}
					setState(183);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(186);
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

	@SuppressWarnings("CheckReturnValue")
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
		public ElementDeclContext elementDecl() {
			return getRuleContext(ElementDeclContext.class,0);
		}
		public SyllableDeclContext syllableDecl() {
			return getRuleContext(SyllableDeclContext.class,0);
		}
		public DeromanizerContext deromanizer() {
			return getRuleContext(DeromanizerContext.class,0);
		}
		public InterRomanizerContext interRomanizer() {
			return getRuleContext(InterRomanizerContext.class,0);
		}
		public RomanizerContext romanizer() {
			return getRuleContext(RomanizerContext.class,0);
		}
		public ChangeRuleContext changeRule() {
			return getRuleContext(ChangeRuleContext.class,0);
		}
		public StandardExpressionContext standardExpression() {
			return getRuleContext(StandardExpressionContext.class,0);
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
			setState(199);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(188);
				featureDecl();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(189);
				diacriticDecl();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(190);
				symbolDecl();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(191);
				classDecl();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(192);
				elementDecl();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(193);
				syllableDecl();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(194);
				deromanizer();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(195);
				interRomanizer();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(196);
				romanizer();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(197);
				changeRule();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(198);
				standardExpression();
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

	@SuppressWarnings("CheckReturnValue")
	public static class ElementDeclContext extends ParserRuleContext {
		public TerminalNode ELEMENT_DECL() { return getToken(LscParser.ELEMENT_DECL, 0); }
		public List<TerminalNode> WHITESPACE() { return getTokens(LscParser.WHITESPACE); }
		public TerminalNode WHITESPACE(int i) {
			return getToken(LscParser.WHITESPACE, i);
		}
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public RuleElementContext ruleElement() {
			return getRuleContext(RuleElementContext.class,0);
		}
		public ElementDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elementDecl; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LscVisitor ) return ((LscVisitor<? extends T>)visitor).visitElementDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElementDeclContext elementDecl() throws RecognitionException {
		ElementDeclContext _localctx = new ElementDeclContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_elementDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(201);
			match(ELEMENT_DECL);
			setState(202);
			match(WHITESPACE);
			setState(203);
			name();
			setState(204);
			match(WHITESPACE);
			setState(205);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ClassDeclContext extends ParserRuleContext {
		public TerminalNode CLASS_DECL() { return getToken(LscParser.CLASS_DECL, 0); }
		public List<TerminalNode> WHITESPACE() { return getTokens(LscParser.WHITESPACE); }
		public TerminalNode WHITESPACE(int i) {
			return getToken(LscParser.WHITESPACE, i);
		}
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public List<ClassElementContext> classElement() {
			return getRuleContexts(ClassElementContext.class);
		}
		public ClassElementContext classElement(int i) {
			return getRuleContext(ClassElementContext.class,i);
		}
		public TerminalNode LIST_END() { return getToken(LscParser.LIST_END, 0); }
		public TerminalNode CLASS_START() { return getToken(LscParser.CLASS_START, 0); }
		public TerminalNode LIST_START() { return getToken(LscParser.LIST_START, 0); }
		public List<TerminalNode> CLASS_SEP() { return getTokens(LscParser.CLASS_SEP); }
		public TerminalNode CLASS_SEP(int i) {
			return getToken(LscParser.CLASS_SEP, i);
		}
		public List<TerminalNode> LIST_SEP() { return getTokens(LscParser.LIST_SEP); }
		public TerminalNode LIST_SEP(int i) {
			return getToken(LscParser.LIST_SEP, i);
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
		enterRule(_localctx, 6, RULE_classDecl);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(207);
			match(CLASS_DECL);
			setState(208);
			match(WHITESPACE);
			setState(209);
			name();
			setState(210);
			match(WHITESPACE);
			setState(211);
			_la = _input.LA(1);
			if ( !(_la==LIST_START || _la==CLASS_START) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(212);
			classElement();
			setState(217);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(213);
					_la = _input.LA(1);
					if ( !(_la==LIST_SEP || _la==CLASS_SEP) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(214);
					classElement();
					}
					} 
				}
				setState(219);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			}
			setState(221);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CLASS_SEP) {
				{
				setState(220);
				match(CLASS_SEP);
				}
			}

			setState(223);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ClassElementContext extends ParserRuleContext {
		public ElementRefContext elementRef() {
			return getRuleContext(ElementRefContext.class,0);
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
		enterRule(_localctx, 8, RULE_classElement);
		try {
			setState(227);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CLASSREF:
				enterOuterAlt(_localctx, 1);
				{
				setState(225);
				elementRef();
				}
				break;
			case ELEMENT_DECL:
			case CLASS_DECL:
			case FEATURE_DECL:
			case DIACRITIC_DECL:
			case SYMBOL_DECL:
			case SYLLABLE_DECL:
			case EXPLICIT_SYLLABLES:
			case CLEAR_SYLLABLES:
			case DEROMANIZER:
			case ROMANIZER:
			case ALL_MATCHING:
			case FIRST_MATCHING:
			case LITERAL:
			case LTR:
			case RTL:
			case PROPAGATE:
			case CLEANUP:
			case BLOCK:
			case UNCHANGED:
			case OFF:
			case NAME:
			case STR1:
			case STR:
				enterOuterAlt(_localctx, 2);
				{
				setState(226);
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

	@SuppressWarnings("CheckReturnValue")
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
		public List<TerminalNode> LIST_SEP() { return getTokens(LscParser.LIST_SEP); }
		public TerminalNode LIST_SEP(int i) {
			return getToken(LscParser.LIST_SEP, i);
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
		enterRule(_localctx, 10, RULE_featureDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(229);
			match(FEATURE_DECL);
			setState(230);
			match(WHITESPACE);
			setState(264);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				{
				{
				setState(231);
				plusFeature();
				setState(236);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==LIST_SEP) {
					{
					{
					setState(232);
					match(LIST_SEP);
					setState(233);
					plusFeature();
					}
					}
					setState(238);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				break;
			case 2:
				{
				{
				setState(242);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SYLLABLE_FEATURE) {
					{
					setState(239);
					featureModifier();
					setState(240);
					match(WHITESPACE);
					}
				}

				setState(244);
				name();
				setState(246);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==WHITESPACE) {
					{
					setState(245);
					match(WHITESPACE);
					}
				}

				setState(248);
				match(O_PAREN);
				setState(252);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NULL) {
					{
					setState(249);
					nullAlias();
					setState(250);
					match(LIST_SEP);
					}
				}

				setState(254);
				featureValue();
				setState(259);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==LIST_SEP) {
					{
					{
					setState(255);
					match(LIST_SEP);
					setState(256);
					featureValue();
					}
					}
					setState(261);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(262);
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

	@SuppressWarnings("CheckReturnValue")
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
		enterRule(_localctx, 12, RULE_featureModifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(266);
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

	@SuppressWarnings("CheckReturnValue")
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
		enterRule(_localctx, 14, RULE_plusFeature);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(271);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SYLLABLE_FEATURE) {
				{
				setState(268);
				featureModifier();
				setState(269);
				match(WHITESPACE);
				}
			}

			setState(274);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==AT_LEAST_ONE) {
				{
				setState(273);
				match(AT_LEAST_ONE);
				}
			}

			setState(276);
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

	@SuppressWarnings("CheckReturnValue")
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
		enterRule(_localctx, 16, RULE_nullAlias);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(278);
			match(NULL);
			setState(279);
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

	@SuppressWarnings("CheckReturnValue")
	public static class DiacriticDeclContext extends ParserRuleContext {
		public TerminalNode DIACRITIC_DECL() { return getToken(LscParser.DIACRITIC_DECL, 0); }
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
		enterRule(_localctx, 18, RULE_diacriticDecl);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(281);
			match(DIACRITIC_DECL);
			setState(282);
			match(WHITESPACE);
			setState(283);
			text();
			setState(284);
			match(WHITESPACE);
			setState(290);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 481036337152L) != 0)) {
				{
				{
				setState(285);
				diacriticModifier();
				setState(286);
				match(WHITESPACE);
				}
				}
				setState(292);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(293);
			matrix();
			setState(298);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(294);
					match(WHITESPACE);
					setState(295);
					diacriticModifier();
					}
					} 
				}
				setState(300);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
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

	@SuppressWarnings("CheckReturnValue")
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
		enterRule(_localctx, 20, RULE_diacriticModifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(301);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 481036337152L) != 0)) ) {
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

	@SuppressWarnings("CheckReturnValue")
	public static class SymbolDeclContext extends ParserRuleContext {
		public TerminalNode SYMBOL_DECL() { return getToken(LscParser.SYMBOL_DECL, 0); }
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
		public List<TerminalNode> LIST_SEP() { return getTokens(LscParser.LIST_SEP); }
		public TerminalNode LIST_SEP(int i) {
			return getToken(LscParser.LIST_SEP, i);
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
		enterRule(_localctx, 22, RULE_symbolDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(303);
			match(SYMBOL_DECL);
			setState(304);
			match(WHITESPACE);
			setState(305);
			symbolName();
			setState(315);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				{
				setState(310);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==LIST_SEP) {
					{
					{
					setState(306);
					match(LIST_SEP);
					setState(307);
					symbolName();
					}
					}
					setState(312);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				{
				setState(313);
				match(WHITESPACE);
				setState(314);
				matrix();
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

	@SuppressWarnings("CheckReturnValue")
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
		enterRule(_localctx, 24, RULE_symbolName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(317);
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

	@SuppressWarnings("CheckReturnValue")
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
		enterRule(_localctx, 26, RULE_syllableDecl);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(319);
			match(SYLLABLE_DECL);
			setState(320);
			match(RULE_START);
			setState(337);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				{
				setState(322); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(321);
					match(NEWLINE);
					}
					}
					setState(324); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NEWLINE );
				setState(326);
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
				setState(333); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(328); 
						_errHandler.sync(this);
						_la = _input.LA(1);
						do {
							{
							{
							setState(327);
							match(NEWLINE);
							}
							}
							setState(330); 
							_errHandler.sync(this);
							_la = _input.LA(1);
						} while ( _la==NEWLINE );
						setState(332);
						syllablePattern();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(335); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
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

	@SuppressWarnings("CheckReturnValue")
	public static class SyllablePatternContext extends ParserRuleContext {
		public RuleElementContext ruleElement() {
			return getRuleContext(RuleElementContext.class,0);
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
		enterRule(_localctx, 28, RULE_syllablePattern);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(339);
			ruleElement();
			setState(342);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CHANGE) {
				{
				setState(340);
				match(CHANGE);
				setState(341);
				matrix();
				}
			}

			setState(345);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CONDITION || _la==EXCLUSION) {
				{
				setState(344);
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

	@SuppressWarnings("CheckReturnValue")
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
		enterRule(_localctx, 30, RULE_deromanizer);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(347);
			match(DEROMANIZER);
			setState(350);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WHITESPACE) {
				{
				setState(348);
				match(WHITESPACE);
				setState(349);
				match(LITERAL);
				}
			}

			setState(352);
			match(RULE_START);
			setState(354); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(353);
				match(NEWLINE);
				}
				}
				setState(356); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NEWLINE );
			setState(358);
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

	@SuppressWarnings("CheckReturnValue")
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
		enterRule(_localctx, 32, RULE_romanizer);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(360);
			match(ROMANIZER);
			setState(363);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WHITESPACE) {
				{
				setState(361);
				match(WHITESPACE);
				setState(362);
				match(LITERAL);
				}
			}

			setState(365);
			match(RULE_START);
			setState(367); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(366);
				match(NEWLINE);
				}
				}
				setState(369); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NEWLINE );
			setState(371);
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

	@SuppressWarnings("CheckReturnValue")
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
		enterRule(_localctx, 34, RULE_interRomanizer);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(373);
			match(ROMANIZER);
			setState(374);
			match(HYPHEN);
			setState(375);
			ruleName();
			setState(378);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WHITESPACE) {
				{
				setState(376);
				match(WHITESPACE);
				setState(377);
				match(LITERAL);
				}
			}

			setState(380);
			match(RULE_START);
			setState(382); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(381);
				match(NEWLINE);
				}
				}
				setState(384); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NEWLINE );
			setState(386);
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

	@SuppressWarnings("CheckReturnValue")
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
		enterRule(_localctx, 36, RULE_changeRule);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(388);
			ruleName();
			setState(393);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WHITESPACE) {
				{
				{
				setState(389);
				match(WHITESPACE);
				setState(390);
				changeRuleModifier();
				}
				}
				setState(395);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(397);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==RULE_START) {
				{
				setState(396);
				match(RULE_START);
				}
			}

			setState(400); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(399);
				match(NEWLINE);
				}
				}
				setState(402); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NEWLINE );
			setState(404);
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

	@SuppressWarnings("CheckReturnValue")
	public static class FilterContext extends ParserRuleContext {
		public ElementRefContext elementRef() {
			return getRuleContext(ElementRefContext.class,0);
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
		enterRule(_localctx, 38, RULE_filter);
		try {
			setState(408);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CLASSREF:
				enterOuterAlt(_localctx, 1);
				{
				setState(406);
				elementRef();
				}
				break;
			case MATRIX_START:
				enterOuterAlt(_localctx, 2);
				{
				setState(407);
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

	@SuppressWarnings("CheckReturnValue")
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
		enterRule(_localctx, 40, RULE_block);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(410);
			blockElement();
			setState(430);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,42,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(412); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(411);
						match(NEWLINE);
						}
						}
						setState(414); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==NEWLINE );
					setState(416);
					blockType();
					setState(417);
					match(RULE_START);
					setState(424);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case WHITESPACE:
						{
						setState(418);
						match(WHITESPACE);
						}
						break;
					case NEWLINE:
						{
						setState(420); 
						_errHandler.sync(this);
						_la = _input.LA(1);
						do {
							{
							{
							setState(419);
							match(NEWLINE);
							}
							}
							setState(422); 
							_errHandler.sync(this);
							_la = _input.LA(1);
						} while ( _la==NEWLINE );
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(426);
					blockElement();
					}
					} 
				}
				setState(432);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,42,_ctx);
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

	@SuppressWarnings("CheckReturnValue")
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
		enterRule(_localctx, 42, RULE_blockElement);
		int _la;
		try {
			setState(450);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,45,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(433);
				expressionList();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(434);
				match(O_PAREN);
				setState(438);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NEWLINE) {
					{
					{
					setState(435);
					match(NEWLINE);
					}
					}
					setState(440);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(441);
				block();
				setState(445);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NEWLINE) {
					{
					{
					setState(442);
					match(NEWLINE);
					}
					}
					setState(447);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(448);
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

	@SuppressWarnings("CheckReturnValue")
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
		enterRule(_localctx, 44, RULE_blockType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(452);
			_la = _input.LA(1);
			if ( !(_la==ALL_MATCHING || _la==FIRST_MATCHING) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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
				changeRuleModifier();
				}
				}
				setState(459);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ChangeRuleModifierContext extends ParserRuleContext {
		public FilterContext filter() {
			return getRuleContext(FilterContext.class,0);
		}
		public KeywordModifierContext keywordModifier() {
			return getRuleContext(KeywordModifierContext.class,0);
		}
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
		enterRule(_localctx, 46, RULE_changeRuleModifier);
		try {
			setState(462);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case MATRIX_START:
			case CLASSREF:
				enterOuterAlt(_localctx, 1);
				{
				setState(460);
				filter();
				}
				break;
			case LTR:
			case RTL:
			case PROPAGATE:
			case CLEANUP:
			case BLOCK:
			case NAME:
				enterOuterAlt(_localctx, 2);
				{
				setState(461);
				keywordModifier();
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

	@SuppressWarnings("CheckReturnValue")
	public static class KeywordModifierContext extends ParserRuleContext {
		public TerminalNode LTR() { return getToken(LscParser.LTR, 0); }
		public TerminalNode RTL() { return getToken(LscParser.RTL, 0); }
		public TerminalNode PROPAGATE() { return getToken(LscParser.PROPAGATE, 0); }
		public TerminalNode BLOCK() { return getToken(LscParser.BLOCK, 0); }
		public TerminalNode CLEANUP() { return getToken(LscParser.CLEANUP, 0); }
		public TerminalNode NAME() { return getToken(LscParser.NAME, 0); }
		public KeywordModifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keywordModifier; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LscVisitor ) return ((LscVisitor<? extends T>)visitor).visitKeywordModifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final KeywordModifierContext keywordModifier() throws RecognitionException {
		KeywordModifierContext _localctx = new KeywordModifierContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_keywordModifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(464);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 161566636631916544L) != 0)) ) {
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

	@SuppressWarnings("CheckReturnValue")
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
		enterRule(_localctx, 50, RULE_expressionList);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(466);
			expression();
			setState(475);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,49,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(468); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(467);
						match(NEWLINE);
						}
						}
						setState(470); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==NEWLINE );
					setState(472);
					expression();
					}
					} 
				}
				setState(477);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,49,_ctx);
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

	@SuppressWarnings("CheckReturnValue")
	public static class RuleNameContext extends ParserRuleContext {
		public List<NameContext> name() {
			return getRuleContexts(NameContext.class);
		}
		public NameContext name(int i) {
			return getRuleContext(NameContext.class,i);
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
		enterRule(_localctx, 52, RULE_ruleName);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(478);
			name();
			setState(486);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==HYPHEN) {
				{
				{
				setState(479);
				match(HYPHEN);
				setState(482);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case ELEMENT_DECL:
				case CLASS_DECL:
				case FEATURE_DECL:
				case DIACRITIC_DECL:
				case SYMBOL_DECL:
				case SYLLABLE_DECL:
				case EXPLICIT_SYLLABLES:
				case CLEAR_SYLLABLES:
				case DEROMANIZER:
				case ROMANIZER:
				case ALL_MATCHING:
				case FIRST_MATCHING:
				case LITERAL:
				case LTR:
				case RTL:
				case PROPAGATE:
				case CLEANUP:
				case BLOCK:
				case UNCHANGED:
				case OFF:
				case NAME:
					{
					setState(480);
					name();
					}
					break;
				case NUMBER:
					{
					setState(481);
					match(NUMBER);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				}
				setState(488);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionContext extends ParserRuleContext {
		public KeywordExpressionContext keywordExpression() {
			return getRuleContext(KeywordExpressionContext.class,0);
		}
		public BlockRefContext blockRef() {
			return getRuleContext(BlockRefContext.class,0);
		}
		public StandardExpressionContext standardExpression() {
			return getRuleContext(StandardExpressionContext.class,0);
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
		enterRule(_localctx, 54, RULE_expression);
		try {
			setState(492);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,52,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(489);
				keywordExpression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(490);
				blockRef();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(491);
				standardExpression();
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

	@SuppressWarnings("CheckReturnValue")
	public static class KeywordExpressionContext extends ParserRuleContext {
		public TerminalNode UNCHANGED() { return getToken(LscParser.UNCHANGED, 0); }
		public TerminalNode OFF() { return getToken(LscParser.OFF, 0); }
		public KeywordExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keywordExpression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LscVisitor ) return ((LscVisitor<? extends T>)visitor).visitKeywordExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final KeywordExpressionContext keywordExpression() throws RecognitionException {
		KeywordExpressionContext _localctx = new KeywordExpressionContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_keywordExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(494);
			_la = _input.LA(1);
			if ( !(_la==UNCHANGED || _la==OFF) ) {
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

	@SuppressWarnings("CheckReturnValue")
	public static class BlockRefContext extends ParserRuleContext {
		public TerminalNode RULE_START() { return getToken(LscParser.RULE_START, 0); }
		public RuleNameContext ruleName() {
			return getRuleContext(RuleNameContext.class,0);
		}
		public BlockRefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blockRef; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LscVisitor ) return ((LscVisitor<? extends T>)visitor).visitBlockRef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockRefContext blockRef() throws RecognitionException {
		BlockRefContext _localctx = new BlockRefContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_blockRef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(496);
			match(RULE_START);
			setState(497);
			ruleName();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StandardExpressionContext extends ParserRuleContext {
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
		public StandardExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_standardExpression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LscVisitor ) return ((LscVisitor<? extends T>)visitor).visitStandardExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StandardExpressionContext standardExpression() throws RecognitionException {
		StandardExpressionContext _localctx = new StandardExpressionContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_standardExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(499);
			from();
			setState(500);
			match(CHANGE);
			setState(501);
			to();
			setState(503);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CONDITION || _la==EXCLUSION) {
				{
				setState(502);
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

	@SuppressWarnings("CheckReturnValue")
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
		enterRule(_localctx, 62, RULE_from);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(505);
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

	@SuppressWarnings("CheckReturnValue")
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
		enterRule(_localctx, 64, RULE_to);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(507);
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

	@SuppressWarnings("CheckReturnValue")
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
		enterRule(_localctx, 66, RULE_ruleElement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(509);
			unconditionalRuleElement();
			setState(511);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,54,_ctx) ) {
			case 1:
				{
				setState(510);
				compoundEnvironment();
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

	@SuppressWarnings("CheckReturnValue")
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
		enterRule(_localctx, 68, RULE_unconditionalRuleElement);
		try {
			setState(519);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,55,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(513);
				bounded();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(514);
				interfix();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(515);
				negated();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(516);
				postfix();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(517);
				simple();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(518);
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

	@SuppressWarnings("CheckReturnValue")
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
		enterRule(_localctx, 70, RULE_bounded);
		try {
			setState(523);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case O_PAREN:
				enterOuterAlt(_localctx, 1);
				{
				setState(521);
				group();
				}
				break;
			case LIST_START:
				enterOuterAlt(_localctx, 2);
				{
				setState(522);
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

	@SuppressWarnings("CheckReturnValue")
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
		enterRule(_localctx, 72, RULE_group);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(525);
			match(O_PAREN);
			setState(526);
			ruleElement();
			setState(527);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ListContext extends ParserRuleContext {
		public TerminalNode LIST_START() { return getToken(LscParser.LIST_START, 0); }
		public List<RuleElementContext> ruleElement() {
			return getRuleContexts(RuleElementContext.class);
		}
		public RuleElementContext ruleElement(int i) {
			return getRuleContext(RuleElementContext.class,i);
		}
		public TerminalNode LIST_END() { return getToken(LscParser.LIST_END, 0); }
		public List<TerminalNode> LIST_SEP() { return getTokens(LscParser.LIST_SEP); }
		public TerminalNode LIST_SEP(int i) {
			return getToken(LscParser.LIST_SEP, i);
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
		enterRule(_localctx, 74, RULE_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(529);
			match(LIST_START);
			setState(530);
			ruleElement();
			setState(535);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LIST_SEP) {
				{
				{
				setState(531);
				match(LIST_SEP);
				setState(532);
				ruleElement();
				}
				}
				setState(537);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(538);
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

	@SuppressWarnings("CheckReturnValue")
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
		enterRule(_localctx, 76, RULE_sequence);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(540);
			freeElement();
			setState(543); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(541);
					match(WHITESPACE);
					setState(542);
					freeElement();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(545); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,58,_ctx);
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

	@SuppressWarnings("CheckReturnValue")
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
		enterRule(_localctx, 78, RULE_freeElement);
		try {
			setState(552);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,59,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(547);
				bounded();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(548);
				interfix();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(549);
				negated();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(550);
				postfix();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(551);
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

	@SuppressWarnings("CheckReturnValue")
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
		enterRule(_localctx, 80, RULE_compoundEnvironment);
		try {
			setState(559);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,60,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(554);
				condition();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(555);
				exclusion();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				{
				setState(556);
				condition();
				setState(557);
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

	@SuppressWarnings("CheckReturnValue")
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
		enterRule(_localctx, 82, RULE_condition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(561);
			match(CONDITION);
			setState(564);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,61,_ctx) ) {
			case 1:
				{
				setState(562);
				environment();
				}
				break;
			case 2:
				{
				setState(563);
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

	@SuppressWarnings("CheckReturnValue")
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
		enterRule(_localctx, 84, RULE_exclusion);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(566);
			match(EXCLUSION);
			setState(569);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,62,_ctx) ) {
			case 1:
				{
				setState(567);
				environment();
				}
				break;
			case 2:
				{
				setState(568);
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

	@SuppressWarnings("CheckReturnValue")
	public static class EnvironmentListContext extends ParserRuleContext {
		public TerminalNode LIST_START() { return getToken(LscParser.LIST_START, 0); }
		public List<EnvironmentContext> environment() {
			return getRuleContexts(EnvironmentContext.class);
		}
		public EnvironmentContext environment(int i) {
			return getRuleContext(EnvironmentContext.class,i);
		}
		public TerminalNode LIST_END() { return getToken(LscParser.LIST_END, 0); }
		public List<TerminalNode> LIST_SEP() { return getTokens(LscParser.LIST_SEP); }
		public TerminalNode LIST_SEP(int i) {
			return getToken(LscParser.LIST_SEP, i);
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
		enterRule(_localctx, 86, RULE_environmentList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(571);
			match(LIST_START);
			setState(572);
			environment();
			setState(577);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LIST_SEP) {
				{
				{
				setState(573);
				match(LIST_SEP);
				setState(574);
				environment();
				}
				}
				setState(579);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(580);
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

	@SuppressWarnings("CheckReturnValue")
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
		enterRule(_localctx, 88, RULE_environment);
		int _la;
		try {
			setState(595);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,67,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(585);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1080863410469516288L) != 0)) {
					{
					setState(582);
					environmentBefore();
					setState(583);
					match(WHITESPACE);
					}
				}

				setState(587);
				match(ANCHOR);
				setState(590);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,65,_ctx) ) {
				case 1:
					{
					setState(588);
					match(WHITESPACE);
					setState(589);
					environmentAfter();
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(593);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1080863410469516288L) != 0)) {
					{
					setState(592);
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

	@SuppressWarnings("CheckReturnValue")
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
		enterRule(_localctx, 90, RULE_environmentBefore);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(597);
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

	@SuppressWarnings("CheckReturnValue")
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
		enterRule(_localctx, 92, RULE_environmentAfter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(599);
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

	@SuppressWarnings("CheckReturnValue")
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
		enterRule(_localctx, 94, RULE_interfix);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(601);
			interfixElement();
			setState(605); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(602);
				interfixType();
				setState(603);
				interfixElement();
				}
				}
				setState(607); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 1879048192L) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
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
		enterRule(_localctx, 96, RULE_interfixType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(609);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 1879048192L) != 0)) ) {
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

	@SuppressWarnings("CheckReturnValue")
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
		enterRule(_localctx, 98, RULE_interfixElement);
		try {
			setState(615);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,69,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(611);
				bounded();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(612);
				negated();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(613);
				postfix();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(614);
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

	@SuppressWarnings("CheckReturnValue")
	public static class NegatedContext extends ParserRuleContext {
		public TerminalNode NEGATION() { return getToken(LscParser.NEGATION, 0); }
		public BoundedContext bounded() {
			return getRuleContext(BoundedContext.class,0);
		}
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
		enterRule(_localctx, 100, RULE_negated);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(617);
			match(NEGATION);
			setState(620);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case O_PAREN:
			case LIST_START:
				{
				setState(618);
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
			case ELEMENT_DECL:
			case CLASS_DECL:
			case FEATURE_DECL:
			case DIACRITIC_DECL:
			case SYMBOL_DECL:
			case SYLLABLE_DECL:
			case EXPLICIT_SYLLABLES:
			case CLEAR_SYLLABLES:
			case ANY_SYLLABLE:
			case DEROMANIZER:
			case ROMANIZER:
			case ALL_MATCHING:
			case FIRST_MATCHING:
			case LITERAL:
			case LTR:
			case RTL:
			case PROPAGATE:
			case CLEANUP:
			case BLOCK:
			case UNCHANGED:
			case OFF:
			case NAME:
			case STR1:
			case STR:
				{
				setState(619);
				simple();
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

	@SuppressWarnings("CheckReturnValue")
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
		enterRule(_localctx, 102, RULE_postfix);
		try {
			setState(624);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,71,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(622);
				capture();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(623);
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

	@SuppressWarnings("CheckReturnValue")
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
		enterRule(_localctx, 104, RULE_capture);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(629);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case O_PAREN:
			case LIST_START:
				{
				setState(626);
				bounded();
				}
				break;
			case NEGATION:
				{
				setState(627);
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
			case ELEMENT_DECL:
			case CLASS_DECL:
			case FEATURE_DECL:
			case DIACRITIC_DECL:
			case SYMBOL_DECL:
			case SYLLABLE_DECL:
			case EXPLICIT_SYLLABLES:
			case CLEAR_SYLLABLES:
			case ANY_SYLLABLE:
			case DEROMANIZER:
			case ROMANIZER:
			case ALL_MATCHING:
			case FIRST_MATCHING:
			case LITERAL:
			case LTR:
			case RTL:
			case PROPAGATE:
			case CLEANUP:
			case BLOCK:
			case UNCHANGED:
			case OFF:
			case NAME:
			case STR1:
			case STR:
				{
				setState(628);
				simple();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(631);
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

	@SuppressWarnings("CheckReturnValue")
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
		enterRule(_localctx, 106, RULE_repeater);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(635);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case O_PAREN:
			case LIST_START:
				{
				setState(633);
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
			case ELEMENT_DECL:
			case CLASS_DECL:
			case FEATURE_DECL:
			case DIACRITIC_DECL:
			case SYMBOL_DECL:
			case SYLLABLE_DECL:
			case EXPLICIT_SYLLABLES:
			case CLEAR_SYLLABLES:
			case ANY_SYLLABLE:
			case DEROMANIZER:
			case ROMANIZER:
			case ALL_MATCHING:
			case FIRST_MATCHING:
			case LITERAL:
			case LTR:
			case RTL:
			case PROPAGATE:
			case CLEANUP:
			case BLOCK:
			case UNCHANGED:
			case OFF:
			case NAME:
			case STR1:
			case STR:
				{
				setState(634);
				simple();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(637);
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

	@SuppressWarnings("CheckReturnValue")
	public static class SimpleContext extends ParserRuleContext {
		public AnySyllableContext anySyllable() {
			return getRuleContext(AnySyllableContext.class,0);
		}
		public ElementRefContext elementRef() {
			return getRuleContext(ElementRefContext.class,0);
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
		enterRule(_localctx, 108, RULE_simple);
		try {
			setState(648);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,74,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(639);
				anySyllable();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(640);
				elementRef();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(641);
				captureRef();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(642);
				fancyMatrix();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(643);
				empty();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(644);
				sylBoundary();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(645);
				boundary();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(646);
				betweenWords();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(647);
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

	@SuppressWarnings("CheckReturnValue")
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
		enterRule(_localctx, 110, RULE_anySyllable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(650);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ElementRefContext extends ParserRuleContext {
		public TerminalNode CLASSREF() { return getToken(LscParser.CLASSREF, 0); }
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public ElementRefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elementRef; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LscVisitor ) return ((LscVisitor<? extends T>)visitor).visitElementRef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElementRefContext elementRef() throws RecognitionException {
		ElementRefContext _localctx = new ElementRefContext(_ctx, getState());
		enterRule(_localctx, 112, RULE_elementRef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(652);
			match(CLASSREF);
			setState(653);
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

	@SuppressWarnings("CheckReturnValue")
	public static class CaptureRefContext extends ParserRuleContext {
		public TerminalNode WORD_BOUNDARY() { return getToken(LscParser.WORD_BOUNDARY, 0); }
		public TerminalNode NUMBER() { return getToken(LscParser.NUMBER, 0); }
		public TerminalNode INEXACT() { return getToken(LscParser.INEXACT, 0); }
		public TerminalNode SYLLABLE_BOUNDARY() { return getToken(LscParser.SYLLABLE_BOUNDARY, 0); }
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
		enterRule(_localctx, 114, RULE_captureRef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(656);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==INEXACT) {
				{
				setState(655);
				match(INEXACT);
				}
			}

			setState(658);
			match(WORD_BOUNDARY);
			setState(660);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SYLLABLE_BOUNDARY) {
				{
				setState(659);
				match(SYLLABLE_BOUNDARY);
				}
			}

			setState(662);
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

	@SuppressWarnings("CheckReturnValue")
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
		enterRule(_localctx, 116, RULE_fancyMatrix);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(664);
			match(MATRIX_START);
			setState(666);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 216163485700329472L) != 0)) {
				{
				setState(665);
				fancyValue();
				}
			}

			setState(672);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WHITESPACE) {
				{
				{
				setState(668);
				match(WHITESPACE);
				setState(669);
				fancyValue();
				}
				}
				setState(674);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(675);
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

	@SuppressWarnings("CheckReturnValue")
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
		enterRule(_localctx, 118, RULE_fancyValue);
		try {
			setState(681);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case AT_LEAST_ONE:
			case HYPHEN:
			case ELEMENT_DECL:
			case CLASS_DECL:
			case FEATURE_DECL:
			case DIACRITIC_DECL:
			case SYMBOL_DECL:
			case SYLLABLE_DECL:
			case EXPLICIT_SYLLABLES:
			case CLEAR_SYLLABLES:
			case DEROMANIZER:
			case ROMANIZER:
			case ALL_MATCHING:
			case FIRST_MATCHING:
			case LITERAL:
			case LTR:
			case RTL:
			case PROPAGATE:
			case CLEANUP:
			case BLOCK:
			case UNCHANGED:
			case OFF:
			case NAME:
				enterOuterAlt(_localctx, 1);
				{
				setState(677);
				matrixValue();
				}
				break;
			case NEGATION:
				enterOuterAlt(_localctx, 2);
				{
				setState(678);
				negatedValue();
				}
				break;
			case NULL:
				enterOuterAlt(_localctx, 3);
				{
				setState(679);
				absentFeature();
				}
				break;
			case WORD_BOUNDARY:
				enterOuterAlt(_localctx, 4);
				{
				setState(680);
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

	@SuppressWarnings("CheckReturnValue")
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
		enterRule(_localctx, 120, RULE_negatedValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(683);
			match(NEGATION);
			setState(684);
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

	@SuppressWarnings("CheckReturnValue")
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
		enterRule(_localctx, 122, RULE_absentFeature);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(686);
			match(NULL);
			setState(687);
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

	@SuppressWarnings("CheckReturnValue")
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
		enterRule(_localctx, 124, RULE_featureVariable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(689);
			match(WORD_BOUNDARY);
			setState(690);
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

	@SuppressWarnings("CheckReturnValue")
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
		enterRule(_localctx, 126, RULE_empty);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(692);
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

	@SuppressWarnings("CheckReturnValue")
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
		enterRule(_localctx, 128, RULE_sylBoundary);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(694);
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

	@SuppressWarnings("CheckReturnValue")
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
		enterRule(_localctx, 130, RULE_boundary);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(696);
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

	@SuppressWarnings("CheckReturnValue")
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
		enterRule(_localctx, 132, RULE_betweenWords);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(698);
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

	@SuppressWarnings("CheckReturnValue")
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
		enterRule(_localctx, 134, RULE_repeaterType);
		try {
			setState(704);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,80,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(700);
				repeatRange();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(701);
				match(AT_LEAST_ONE);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(702);
				match(NULL);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(703);
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

	@SuppressWarnings("CheckReturnValue")
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
		enterRule(_localctx, 136, RULE_repeatRange);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(706);
			match(NULL);
			setState(717);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUMBER:
				{
				setState(707);
				match(NUMBER);
				}
				break;
			case O_PAREN:
				{
				{
				setState(708);
				match(O_PAREN);
				setState(710);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NUMBER) {
					{
					setState(709);
					lowerBound();
					}
				}

				setState(712);
				match(HYPHEN);
				setState(714);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NUMBER) {
					{
					setState(713);
					upperBound();
					}
				}

				setState(716);
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

	@SuppressWarnings("CheckReturnValue")
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
		enterRule(_localctx, 138, RULE_lowerBound);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(719);
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

	@SuppressWarnings("CheckReturnValue")
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
		enterRule(_localctx, 140, RULE_upperBound);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(721);
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

	@SuppressWarnings("CheckReturnValue")
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
		enterRule(_localctx, 142, RULE_matrix);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(723);
			match(MATRIX_START);
			setState(725);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 216163485658382336L) != 0)) {
				{
				setState(724);
				matrixValue();
				}
			}

			setState(731);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WHITESPACE) {
				{
				{
				setState(727);
				match(WHITESPACE);
				setState(728);
				matrixValue();
				}
				}
				setState(733);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(734);
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

	@SuppressWarnings("CheckReturnValue")
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
		enterRule(_localctx, 144, RULE_matrixValue);
		try {
			setState(738);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case AT_LEAST_ONE:
			case HYPHEN:
				enterOuterAlt(_localctx, 1);
				{
				setState(736);
				plusFeatureValue();
				}
				break;
			case ELEMENT_DECL:
			case CLASS_DECL:
			case FEATURE_DECL:
			case DIACRITIC_DECL:
			case SYMBOL_DECL:
			case SYLLABLE_DECL:
			case EXPLICIT_SYLLABLES:
			case CLEAR_SYLLABLES:
			case DEROMANIZER:
			case ROMANIZER:
			case ALL_MATCHING:
			case FIRST_MATCHING:
			case LITERAL:
			case LTR:
			case RTL:
			case PROPAGATE:
			case CLEANUP:
			case BLOCK:
			case UNCHANGED:
			case OFF:
			case NAME:
				enterOuterAlt(_localctx, 2);
				{
				setState(737);
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

	@SuppressWarnings("CheckReturnValue")
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
		enterRule(_localctx, 146, RULE_plusFeatureValue);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(740);
			_la = _input.LA(1);
			if ( !(_la==AT_LEAST_ONE || _la==HYPHEN) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(741);
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

	@SuppressWarnings("CheckReturnValue")
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
		enterRule(_localctx, 148, RULE_featureValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(743);
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

	@SuppressWarnings("CheckReturnValue")
	public static class TextContext extends ParserRuleContext {
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
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
		enterRule(_localctx, 150, RULE_text);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(748);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ELEMENT_DECL:
			case CLASS_DECL:
			case FEATURE_DECL:
			case DIACRITIC_DECL:
			case SYMBOL_DECL:
			case SYLLABLE_DECL:
			case EXPLICIT_SYLLABLES:
			case CLEAR_SYLLABLES:
			case DEROMANIZER:
			case ROMANIZER:
			case ALL_MATCHING:
			case FIRST_MATCHING:
			case LITERAL:
			case LTR:
			case RTL:
			case PROPAGATE:
			case CLEANUP:
			case BLOCK:
			case UNCHANGED:
			case OFF:
			case NAME:
				{
				setState(745);
				name();
				}
				break;
			case STR1:
				{
				setState(746);
				match(STR1);
				}
				break;
			case STR:
				{
				setState(747);
				match(STR);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(751);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NEGATION) {
				{
				setState(750);
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

	@SuppressWarnings("CheckReturnValue")
	public static class NameContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(LscParser.NAME, 0); }
		public TerminalNode ELEMENT_DECL() { return getToken(LscParser.ELEMENT_DECL, 0); }
		public TerminalNode CLASS_DECL() { return getToken(LscParser.CLASS_DECL, 0); }
		public TerminalNode FEATURE_DECL() { return getToken(LscParser.FEATURE_DECL, 0); }
		public TerminalNode DIACRITIC_DECL() { return getToken(LscParser.DIACRITIC_DECL, 0); }
		public TerminalNode SYMBOL_DECL() { return getToken(LscParser.SYMBOL_DECL, 0); }
		public TerminalNode SYLLABLE_DECL() { return getToken(LscParser.SYLLABLE_DECL, 0); }
		public TerminalNode CLEAR_SYLLABLES() { return getToken(LscParser.CLEAR_SYLLABLES, 0); }
		public TerminalNode EXPLICIT_SYLLABLES() { return getToken(LscParser.EXPLICIT_SYLLABLES, 0); }
		public TerminalNode DEROMANIZER() { return getToken(LscParser.DEROMANIZER, 0); }
		public TerminalNode ROMANIZER() { return getToken(LscParser.ROMANIZER, 0); }
		public TerminalNode LITERAL() { return getToken(LscParser.LITERAL, 0); }
		public TerminalNode ALL_MATCHING() { return getToken(LscParser.ALL_MATCHING, 0); }
		public TerminalNode FIRST_MATCHING() { return getToken(LscParser.FIRST_MATCHING, 0); }
		public TerminalNode LTR() { return getToken(LscParser.LTR, 0); }
		public TerminalNode RTL() { return getToken(LscParser.RTL, 0); }
		public TerminalNode PROPAGATE() { return getToken(LscParser.PROPAGATE, 0); }
		public TerminalNode BLOCK() { return getToken(LscParser.BLOCK, 0); }
		public TerminalNode CLEANUP() { return getToken(LscParser.CLEANUP, 0); }
		public TerminalNode OFF() { return getToken(LscParser.OFF, 0); }
		public TerminalNode UNCHANGED() { return getToken(LscParser.UNCHANGED, 0); }
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
		enterRule(_localctx, 152, RULE_name);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(753);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 216163485657071616L) != 0)) ) {
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
		"\u0004\u0001;\u02f4\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
		"\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007\u001e"+
		"\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007!\u0002\"\u0007\"\u0002"+
		"#\u0007#\u0002$\u0007$\u0002%\u0007%\u0002&\u0007&\u0002\'\u0007\'\u0002"+
		"(\u0007(\u0002)\u0007)\u0002*\u0007*\u0002+\u0007+\u0002,\u0007,\u0002"+
		"-\u0007-\u0002.\u0007.\u0002/\u0007/\u00020\u00070\u00021\u00071\u0002"+
		"2\u00072\u00023\u00073\u00024\u00074\u00025\u00075\u00026\u00076\u0002"+
		"7\u00077\u00028\u00078\u00029\u00079\u0002:\u0007:\u0002;\u0007;\u0002"+
		"<\u0007<\u0002=\u0007=\u0002>\u0007>\u0002?\u0007?\u0002@\u0007@\u0002"+
		"A\u0007A\u0002B\u0007B\u0002C\u0007C\u0002D\u0007D\u0002E\u0007E\u0002"+
		"F\u0007F\u0002G\u0007G\u0002H\u0007H\u0002I\u0007I\u0002J\u0007J\u0002"+
		"K\u0007K\u0002L\u0007L\u0001\u0000\u0001\u0000\u0005\u0000\u009d\b\u0000"+
		"\n\u0000\f\u0000\u00a0\t\u0000\u0003\u0000\u00a2\b\u0000\u0001\u0000\u0003"+
		"\u0000\u00a5\b\u0000\u0001\u0000\u0004\u0000\u00a8\b\u0000\u000b\u0000"+
		"\f\u0000\u00a9\u0001\u0000\u0005\u0000\u00ad\b\u0000\n\u0000\f\u0000\u00b0"+
		"\t\u0000\u0001\u0000\u0001\u0000\u0005\u0000\u00b4\b\u0000\n\u0000\f\u0000"+
		"\u00b7\t\u0000\u0003\u0000\u00b9\b\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001\u00c8"+
		"\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0005\u0003\u00d8\b\u0003\n\u0003\f\u0003"+
		"\u00db\t\u0003\u0001\u0003\u0003\u0003\u00de\b\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0004\u0001\u0004\u0003\u0004\u00e4\b\u0004\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0005\u0005\u00eb\b\u0005\n"+
		"\u0005\f\u0005\u00ee\t\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0003"+
		"\u0005\u00f3\b\u0005\u0001\u0005\u0001\u0005\u0003\u0005\u00f7\b\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005\u00fd\b\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0005\u0005\u0102\b\u0005\n\u0005"+
		"\f\u0005\u0105\t\u0005\u0001\u0005\u0001\u0005\u0003\u0005\u0109\b\u0005"+
		"\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007"+
		"\u0110\b\u0007\u0001\u0007\u0003\u0007\u0113\b\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t"+
		"\u0001\t\u0001\t\u0005\t\u0121\b\t\n\t\f\t\u0124\t\t\u0001\t\u0001\t\u0001"+
		"\t\u0005\t\u0129\b\t\n\t\f\t\u012c\t\t\u0001\n\u0001\n\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0005\u000b\u0135\b\u000b\n"+
		"\u000b\f\u000b\u0138\t\u000b\u0001\u000b\u0001\u000b\u0003\u000b\u013c"+
		"\b\u000b\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0004\r\u0143\b\r\u000b"+
		"\r\f\r\u0144\u0001\r\u0001\r\u0004\r\u0149\b\r\u000b\r\f\r\u014a\u0001"+
		"\r\u0004\r\u014e\b\r\u000b\r\f\r\u014f\u0003\r\u0152\b\r\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0003\u000e\u0157\b\u000e\u0001\u000e\u0003\u000e\u015a"+
		"\b\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0003\u000f\u015f\b\u000f"+
		"\u0001\u000f\u0001\u000f\u0004\u000f\u0163\b\u000f\u000b\u000f\f\u000f"+
		"\u0164\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0003"+
		"\u0010\u016c\b\u0010\u0001\u0010\u0001\u0010\u0004\u0010\u0170\b\u0010"+
		"\u000b\u0010\f\u0010\u0171\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0003\u0011\u017b\b\u0011\u0001\u0011"+
		"\u0001\u0011\u0004\u0011\u017f\b\u0011\u000b\u0011\f\u0011\u0180\u0001"+
		"\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0005\u0012\u0188"+
		"\b\u0012\n\u0012\f\u0012\u018b\t\u0012\u0001\u0012\u0003\u0012\u018e\b"+
		"\u0012\u0001\u0012\u0004\u0012\u0191\b\u0012\u000b\u0012\f\u0012\u0192"+
		"\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013\u0003\u0013\u0199\b\u0013"+
		"\u0001\u0014\u0001\u0014\u0004\u0014\u019d\b\u0014\u000b\u0014\f\u0014"+
		"\u019e\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0004\u0014\u01a5"+
		"\b\u0014\u000b\u0014\f\u0014\u01a6\u0003\u0014\u01a9\b\u0014\u0001\u0014"+
		"\u0001\u0014\u0005\u0014\u01ad\b\u0014\n\u0014\f\u0014\u01b0\t\u0014\u0001"+
		"\u0015\u0001\u0015\u0001\u0015\u0005\u0015\u01b5\b\u0015\n\u0015\f\u0015"+
		"\u01b8\t\u0015\u0001\u0015\u0001\u0015\u0005\u0015\u01bc\b\u0015\n\u0015"+
		"\f\u0015\u01bf\t\u0015\u0001\u0015\u0001\u0015\u0003\u0015\u01c3\b\u0015"+
		"\u0001\u0016\u0001\u0016\u0001\u0016\u0005\u0016\u01c8\b\u0016\n\u0016"+
		"\f\u0016\u01cb\t\u0016\u0001\u0017\u0001\u0017\u0003\u0017\u01cf\b\u0017"+
		"\u0001\u0018\u0001\u0018\u0001\u0019\u0001\u0019\u0004\u0019\u01d5\b\u0019"+
		"\u000b\u0019\f\u0019\u01d6\u0001\u0019\u0005\u0019\u01da\b\u0019\n\u0019"+
		"\f\u0019\u01dd\t\u0019\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a"+
		"\u0003\u001a\u01e3\b\u001a\u0005\u001a\u01e5\b\u001a\n\u001a\f\u001a\u01e8"+
		"\t\u001a\u0001\u001b\u0001\u001b\u0001\u001b\u0003\u001b\u01ed\b\u001b"+
		"\u0001\u001c\u0001\u001c\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001e"+
		"\u0001\u001e\u0001\u001e\u0001\u001e\u0003\u001e\u01f8\b\u001e\u0001\u001f"+
		"\u0001\u001f\u0001 \u0001 \u0001!\u0001!\u0003!\u0200\b!\u0001\"\u0001"+
		"\"\u0001\"\u0001\"\u0001\"\u0001\"\u0003\"\u0208\b\"\u0001#\u0001#\u0003"+
		"#\u020c\b#\u0001$\u0001$\u0001$\u0001$\u0001%\u0001%\u0001%\u0001%\u0005"+
		"%\u0216\b%\n%\f%\u0219\t%\u0001%\u0001%\u0001&\u0001&\u0001&\u0004&\u0220"+
		"\b&\u000b&\f&\u0221\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'\u0003\'\u0229"+
		"\b\'\u0001(\u0001(\u0001(\u0001(\u0001(\u0003(\u0230\b(\u0001)\u0001)"+
		"\u0001)\u0003)\u0235\b)\u0001*\u0001*\u0001*\u0003*\u023a\b*\u0001+\u0001"+
		"+\u0001+\u0001+\u0005+\u0240\b+\n+\f+\u0243\t+\u0001+\u0001+\u0001,\u0001"+
		",\u0001,\u0003,\u024a\b,\u0001,\u0001,\u0001,\u0003,\u024f\b,\u0001,\u0003"+
		",\u0252\b,\u0003,\u0254\b,\u0001-\u0001-\u0001.\u0001.\u0001/\u0001/\u0001"+
		"/\u0001/\u0004/\u025e\b/\u000b/\f/\u025f\u00010\u00010\u00011\u00011\u0001"+
		"1\u00011\u00031\u0268\b1\u00012\u00012\u00012\u00032\u026d\b2\u00013\u0001"+
		"3\u00033\u0271\b3\u00014\u00014\u00014\u00034\u0276\b4\u00014\u00014\u0001"+
		"5\u00015\u00035\u027c\b5\u00015\u00015\u00016\u00016\u00016\u00016\u0001"+
		"6\u00016\u00016\u00016\u00016\u00036\u0289\b6\u00017\u00017\u00018\u0001"+
		"8\u00018\u00019\u00039\u0291\b9\u00019\u00019\u00039\u0295\b9\u00019\u0001"+
		"9\u0001:\u0001:\u0003:\u029b\b:\u0001:\u0001:\u0005:\u029f\b:\n:\f:\u02a2"+
		"\t:\u0001:\u0001:\u0001;\u0001;\u0001;\u0001;\u0003;\u02aa\b;\u0001<\u0001"+
		"<\u0001<\u0001=\u0001=\u0001=\u0001>\u0001>\u0001>\u0001?\u0001?\u0001"+
		"@\u0001@\u0001A\u0001A\u0001B\u0001B\u0001C\u0001C\u0001C\u0001C\u0003"+
		"C\u02c1\bC\u0001D\u0001D\u0001D\u0001D\u0003D\u02c7\bD\u0001D\u0001D\u0003"+
		"D\u02cb\bD\u0001D\u0003D\u02ce\bD\u0001E\u0001E\u0001F\u0001F\u0001G\u0001"+
		"G\u0003G\u02d6\bG\u0001G\u0001G\u0005G\u02da\bG\nG\fG\u02dd\tG\u0001G"+
		"\u0001G\u0001H\u0001H\u0003H\u02e3\bH\u0001I\u0001I\u0001I\u0001J\u0001"+
		"J\u0001K\u0001K\u0001K\u0003K\u02ed\bK\u0001K\u0003K\u02f0\bK\u0001L\u0001"+
		"L\u0001L\u0000\u0000M\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012"+
		"\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,.02468:<>@BDFHJLNPRTVXZ\\"+
		"^`bdfhjlnprtvxz|~\u0080\u0082\u0084\u0086\u0088\u008a\u008c\u008e\u0090"+
		"\u0092\u0094\u0096\u0098\u0000\n\u0001\u0000\u000f\u0010\u0001\u0000\u0002"+
		"\u0003\u0001\u0000$&\u0001\u0000)*\u0001\u0000./\u0002\u00001599\u0001"+
		"\u000067\u0001\u0000\u001c\u001e\u0002\u0000\u0012\u0012\u0014\u0014\u0005"+
		"\u0000\u001f!##\'*,799\u0320\u0000\u00a1\u0001\u0000\u0000\u0000\u0002"+
		"\u00c7\u0001\u0000\u0000\u0000\u0004\u00c9\u0001\u0000\u0000\u0000\u0006"+
		"\u00cf\u0001\u0000\u0000\u0000\b\u00e3\u0001\u0000\u0000\u0000\n\u00e5"+
		"\u0001\u0000\u0000\u0000\f\u010a\u0001\u0000\u0000\u0000\u000e\u010f\u0001"+
		"\u0000\u0000\u0000\u0010\u0116\u0001\u0000\u0000\u0000\u0012\u0119\u0001"+
		"\u0000\u0000\u0000\u0014\u012d\u0001\u0000\u0000\u0000\u0016\u012f\u0001"+
		"\u0000\u0000\u0000\u0018\u013d\u0001\u0000\u0000\u0000\u001a\u013f\u0001"+
		"\u0000\u0000\u0000\u001c\u0153\u0001\u0000\u0000\u0000\u001e\u015b\u0001"+
		"\u0000\u0000\u0000 \u0168\u0001\u0000\u0000\u0000\"\u0175\u0001\u0000"+
		"\u0000\u0000$\u0184\u0001\u0000\u0000\u0000&\u0198\u0001\u0000\u0000\u0000"+
		"(\u019a\u0001\u0000\u0000\u0000*\u01c2\u0001\u0000\u0000\u0000,\u01c4"+
		"\u0001\u0000\u0000\u0000.\u01ce\u0001\u0000\u0000\u00000\u01d0\u0001\u0000"+
		"\u0000\u00002\u01d2\u0001\u0000\u0000\u00004\u01de\u0001\u0000\u0000\u0000"+
		"6\u01ec\u0001\u0000\u0000\u00008\u01ee\u0001\u0000\u0000\u0000:\u01f0"+
		"\u0001\u0000\u0000\u0000<\u01f3\u0001\u0000\u0000\u0000>\u01f9\u0001\u0000"+
		"\u0000\u0000@\u01fb\u0001\u0000\u0000\u0000B\u01fd\u0001\u0000\u0000\u0000"+
		"D\u0207\u0001\u0000\u0000\u0000F\u020b\u0001\u0000\u0000\u0000H\u020d"+
		"\u0001\u0000\u0000\u0000J\u0211\u0001\u0000\u0000\u0000L\u021c\u0001\u0000"+
		"\u0000\u0000N\u0228\u0001\u0000\u0000\u0000P\u022f\u0001\u0000\u0000\u0000"+
		"R\u0231\u0001\u0000\u0000\u0000T\u0236\u0001\u0000\u0000\u0000V\u023b"+
		"\u0001\u0000\u0000\u0000X\u0253\u0001\u0000\u0000\u0000Z\u0255\u0001\u0000"+
		"\u0000\u0000\\\u0257\u0001\u0000\u0000\u0000^\u0259\u0001\u0000\u0000"+
		"\u0000`\u0261\u0001\u0000\u0000\u0000b\u0267\u0001\u0000\u0000\u0000d"+
		"\u0269\u0001\u0000\u0000\u0000f\u0270\u0001\u0000\u0000\u0000h\u0275\u0001"+
		"\u0000\u0000\u0000j\u027b\u0001\u0000\u0000\u0000l\u0288\u0001\u0000\u0000"+
		"\u0000n\u028a\u0001\u0000\u0000\u0000p\u028c\u0001\u0000\u0000\u0000r"+
		"\u0290\u0001\u0000\u0000\u0000t\u0298\u0001\u0000\u0000\u0000v\u02a9\u0001"+
		"\u0000\u0000\u0000x\u02ab\u0001\u0000\u0000\u0000z\u02ae\u0001\u0000\u0000"+
		"\u0000|\u02b1\u0001\u0000\u0000\u0000~\u02b4\u0001\u0000\u0000\u0000\u0080"+
		"\u02b6\u0001\u0000\u0000\u0000\u0082\u02b8\u0001\u0000\u0000\u0000\u0084"+
		"\u02ba\u0001\u0000\u0000\u0000\u0086\u02c0\u0001\u0000\u0000\u0000\u0088"+
		"\u02c2\u0001\u0000\u0000\u0000\u008a\u02cf\u0001\u0000\u0000\u0000\u008c"+
		"\u02d1\u0001\u0000\u0000\u0000\u008e\u02d3\u0001\u0000\u0000\u0000\u0090"+
		"\u02e2\u0001\u0000\u0000\u0000\u0092\u02e4\u0001\u0000\u0000\u0000\u0094"+
		"\u02e7\u0001\u0000\u0000\u0000\u0096\u02ec\u0001\u0000\u0000\u0000\u0098"+
		"\u02f1\u0001\u0000\u0000\u0000\u009a\u00a2\u0005\t\u0000\u0000\u009b\u009d"+
		"\u0005\b\u0000\u0000\u009c\u009b\u0001\u0000\u0000\u0000\u009d\u00a0\u0001"+
		"\u0000\u0000\u0000\u009e\u009c\u0001\u0000\u0000\u0000\u009e\u009f\u0001"+
		"\u0000\u0000\u0000\u009f\u00a2\u0001\u0000\u0000\u0000\u00a0\u009e\u0001"+
		"\u0000\u0000\u0000\u00a1\u009a\u0001\u0000\u0000\u0000\u00a1\u009e\u0001"+
		"\u0000\u0000\u0000\u00a2\u00a4\u0001\u0000\u0000\u0000\u00a3\u00a5\u0003"+
		"\u0002\u0001\u0000\u00a4\u00a3\u0001\u0000\u0000\u0000\u00a4\u00a5\u0001"+
		"\u0000\u0000\u0000\u00a5\u00ae\u0001\u0000\u0000\u0000\u00a6\u00a8\u0005"+
		"\b\u0000\u0000\u00a7\u00a6\u0001\u0000\u0000\u0000\u00a8\u00a9\u0001\u0000"+
		"\u0000\u0000\u00a9\u00a7\u0001\u0000\u0000\u0000\u00a9\u00aa\u0001\u0000"+
		"\u0000\u0000\u00aa\u00ab\u0001\u0000\u0000\u0000\u00ab\u00ad\u0003\u0002"+
		"\u0001\u0000\u00ac\u00a7\u0001\u0000\u0000\u0000\u00ad\u00b0\u0001\u0000"+
		"\u0000\u0000\u00ae\u00ac\u0001\u0000\u0000\u0000\u00ae\u00af\u0001\u0000"+
		"\u0000\u0000\u00af\u00b8\u0001\u0000\u0000\u0000\u00b0\u00ae\u0001\u0000"+
		"\u0000\u0000\u00b1\u00b9\u0005\t\u0000\u0000\u00b2\u00b4\u0005\b\u0000"+
		"\u0000\u00b3\u00b2\u0001\u0000\u0000\u0000\u00b4\u00b7\u0001\u0000\u0000"+
		"\u0000\u00b5\u00b3\u0001\u0000\u0000\u0000\u00b5\u00b6\u0001\u0000\u0000"+
		"\u0000\u00b6\u00b9\u0001\u0000\u0000\u0000\u00b7\u00b5\u0001\u0000\u0000"+
		"\u0000\u00b8\u00b1\u0001\u0000\u0000\u0000\u00b8\u00b5\u0001\u0000\u0000"+
		"\u0000\u00b9\u00ba\u0001\u0000\u0000\u0000\u00ba\u00bb\u0005\u0000\u0000"+
		"\u0001\u00bb\u0001\u0001\u0000\u0000\u0000\u00bc\u00c8\u0003\n\u0005\u0000"+
		"\u00bd\u00c8\u0003\u0012\t\u0000\u00be\u00c8\u0003\u0016\u000b\u0000\u00bf"+
		"\u00c8\u0003\u0006\u0003\u0000\u00c0\u00c8\u0003\u0004\u0002\u0000\u00c1"+
		"\u00c8\u0003\u001a\r\u0000\u00c2\u00c8\u0003\u001e\u000f\u0000\u00c3\u00c8"+
		"\u0003\"\u0011\u0000\u00c4\u00c8\u0003 \u0010\u0000\u00c5\u00c8\u0003"+
		"$\u0012\u0000\u00c6\u00c8\u0003<\u001e\u0000\u00c7\u00bc\u0001\u0000\u0000"+
		"\u0000\u00c7\u00bd\u0001\u0000\u0000\u0000\u00c7\u00be\u0001\u0000\u0000"+
		"\u0000\u00c7\u00bf\u0001\u0000\u0000\u0000\u00c7\u00c0\u0001\u0000\u0000"+
		"\u0000\u00c7\u00c1\u0001\u0000\u0000\u0000\u00c7\u00c2\u0001\u0000\u0000"+
		"\u0000\u00c7\u00c3\u0001\u0000\u0000\u0000\u00c7\u00c4\u0001\u0000\u0000"+
		"\u0000\u00c7\u00c5\u0001\u0000\u0000\u0000\u00c7\u00c6\u0001\u0000\u0000"+
		"\u0000\u00c8\u0003\u0001\u0000\u0000\u0000\u00c9\u00ca\u0005\u001f\u0000"+
		"\u0000\u00ca\u00cb\u0005\t\u0000\u0000\u00cb\u00cc\u0003\u0098L\u0000"+
		"\u00cc\u00cd\u0005\t\u0000\u0000\u00cd\u00ce\u0003B!\u0000\u00ce\u0005"+
		"\u0001\u0000\u0000\u0000\u00cf\u00d0\u0005 \u0000\u0000\u00d0\u00d1\u0005"+
		"\t\u0000\u0000\u00d1\u00d2\u0003\u0098L\u0000\u00d2\u00d3\u0005\t\u0000"+
		"\u0000\u00d3\u00d4\u0007\u0000\u0000\u0000\u00d4\u00d9\u0003\b\u0004\u0000"+
		"\u00d5\u00d6\u0007\u0001\u0000\u0000\u00d6\u00d8\u0003\b\u0004\u0000\u00d7"+
		"\u00d5\u0001\u0000\u0000\u0000\u00d8\u00db\u0001\u0000\u0000\u0000\u00d9"+
		"\u00d7\u0001\u0000\u0000\u0000\u00d9\u00da\u0001\u0000\u0000\u0000\u00da"+
		"\u00dd\u0001\u0000\u0000\u0000\u00db\u00d9\u0001\u0000\u0000\u0000\u00dc"+
		"\u00de\u0005\u0003\u0000\u0000\u00dd\u00dc\u0001\u0000\u0000\u0000\u00dd"+
		"\u00de\u0001\u0000\u0000\u0000\u00de\u00df\u0001\u0000\u0000\u0000\u00df"+
		"\u00e0\u0005\u0011\u0000\u0000\u00e0\u0007\u0001\u0000\u0000\u0000\u00e1"+
		"\u00e4\u0003p8\u0000\u00e2\u00e4\u0003\u0096K\u0000\u00e3\u00e1\u0001"+
		"\u0000\u0000\u0000\u00e3\u00e2\u0001\u0000\u0000\u0000\u00e4\t\u0001\u0000"+
		"\u0000\u0000\u00e5\u00e6\u0005!\u0000\u0000\u00e6\u0108\u0005\t\u0000"+
		"\u0000\u00e7\u00ec\u0003\u000e\u0007\u0000\u00e8\u00e9\u0005\u0002\u0000"+
		"\u0000\u00e9\u00eb\u0003\u000e\u0007\u0000\u00ea\u00e8\u0001\u0000\u0000"+
		"\u0000\u00eb\u00ee\u0001\u0000\u0000\u0000\u00ec\u00ea\u0001\u0000\u0000"+
		"\u0000\u00ec\u00ed\u0001\u0000\u0000\u0000\u00ed\u0109\u0001\u0000\u0000"+
		"\u0000\u00ee\u00ec\u0001\u0000\u0000\u0000\u00ef\u00f0\u0003\f\u0006\u0000"+
		"\u00f0\u00f1\u0005\t\u0000\u0000\u00f1\u00f3\u0001\u0000\u0000\u0000\u00f2"+
		"\u00ef\u0001\u0000\u0000\u0000\u00f2\u00f3\u0001\u0000\u0000\u0000\u00f3"+
		"\u00f4\u0001\u0000\u0000\u0000\u00f4\u00f6\u0003\u0098L\u0000\u00f5\u00f7"+
		"\u0005\t\u0000\u0000\u00f6\u00f5\u0001\u0000\u0000\u0000\u00f6\u00f7\u0001"+
		"\u0000\u0000\u0000\u00f7\u00f8\u0001\u0000\u0000\u0000\u00f8\u00fc\u0005"+
		"\n\u0000\u0000\u00f9\u00fa\u0003\u0010\b\u0000\u00fa\u00fb\u0005\u0002"+
		"\u0000\u0000\u00fb\u00fd\u0001\u0000\u0000\u0000\u00fc\u00f9\u0001\u0000"+
		"\u0000\u0000\u00fc\u00fd\u0001\u0000\u0000\u0000\u00fd\u00fe\u0001\u0000"+
		"\u0000\u0000\u00fe\u0103\u0003\u0094J\u0000\u00ff\u0100\u0005\u0002\u0000"+
		"\u0000\u0100\u0102\u0003\u0094J\u0000\u0101\u00ff\u0001\u0000\u0000\u0000"+
		"\u0102\u0105\u0001\u0000\u0000\u0000\u0103\u0101\u0001\u0000\u0000\u0000"+
		"\u0103\u0104\u0001\u0000\u0000\u0000\u0104\u0106\u0001\u0000\u0000\u0000"+
		"\u0105\u0103\u0001\u0000\u0000\u0000\u0106\u0107\u0005\u000b\u0000\u0000"+
		"\u0107\u0109\u0001\u0000\u0000\u0000\u0108\u00e7\u0001\u0000\u0000\u0000"+
		"\u0108\u00f2\u0001\u0000\u0000\u0000\u0109\u000b\u0001\u0000\u0000\u0000"+
		"\u010a\u010b\u0005\"\u0000\u0000\u010b\r\u0001\u0000\u0000\u0000\u010c"+
		"\u010d\u0003\f\u0006\u0000\u010d\u010e\u0005\t\u0000\u0000\u010e\u0110"+
		"\u0001\u0000\u0000\u0000\u010f\u010c\u0001\u0000\u0000\u0000\u010f\u0110"+
		"\u0001\u0000\u0000\u0000\u0110\u0112\u0001\u0000\u0000\u0000\u0111\u0113"+
		"\u0005\u0012\u0000\u0000\u0112\u0111\u0001\u0000\u0000\u0000\u0112\u0113"+
		"\u0001\u0000\u0000\u0000\u0113\u0114\u0001\u0000\u0000\u0000\u0114\u0115"+
		"\u0003\u0098L\u0000\u0115\u000f\u0001\u0000\u0000\u0000\u0116\u0117\u0005"+
		"\f\u0000\u0000\u0117\u0118\u0003\u0094J\u0000\u0118\u0011\u0001\u0000"+
		"\u0000\u0000\u0119\u011a\u0005#\u0000\u0000\u011a\u011b\u0005\t\u0000"+
		"\u0000\u011b\u011c\u0003\u0096K\u0000\u011c\u0122\u0005\t\u0000\u0000"+
		"\u011d\u011e\u0003\u0014\n\u0000\u011e\u011f\u0005\t\u0000\u0000\u011f"+
		"\u0121\u0001\u0000\u0000\u0000\u0120\u011d\u0001\u0000\u0000\u0000\u0121"+
		"\u0124\u0001\u0000\u0000\u0000\u0122\u0120\u0001\u0000\u0000\u0000\u0122"+
		"\u0123\u0001\u0000\u0000\u0000\u0123\u0125\u0001\u0000\u0000\u0000\u0124"+
		"\u0122\u0001\u0000\u0000\u0000\u0125\u012a\u0003\u008eG\u0000\u0126\u0127"+
		"\u0005\t\u0000\u0000\u0127\u0129\u0003\u0014\n\u0000\u0128\u0126\u0001"+
		"\u0000\u0000\u0000\u0129\u012c\u0001\u0000\u0000\u0000\u012a\u0128\u0001"+
		"\u0000\u0000\u0000\u012a\u012b\u0001\u0000\u0000\u0000\u012b\u0013\u0001"+
		"\u0000\u0000\u0000\u012c\u012a\u0001\u0000\u0000\u0000\u012d\u012e\u0007"+
		"\u0002\u0000\u0000\u012e\u0015\u0001\u0000\u0000\u0000\u012f\u0130\u0005"+
		"\'\u0000\u0000\u0130\u0131\u0005\t\u0000\u0000\u0131\u013b\u0003\u0018"+
		"\f\u0000\u0132\u0133\u0005\u0002\u0000\u0000\u0133\u0135\u0003\u0018\f"+
		"\u0000\u0134\u0132\u0001\u0000\u0000\u0000\u0135\u0138\u0001\u0000\u0000"+
		"\u0000\u0136\u0134\u0001\u0000\u0000\u0000\u0136\u0137\u0001\u0000\u0000"+
		"\u0000\u0137\u013c\u0001\u0000\u0000\u0000\u0138\u0136\u0001\u0000\u0000"+
		"\u0000\u0139\u013a\u0005\t\u0000\u0000\u013a\u013c\u0003\u008eG\u0000"+
		"\u013b\u0136\u0001\u0000\u0000\u0000\u013b\u0139\u0001\u0000\u0000\u0000"+
		"\u013c\u0017\u0001\u0000\u0000\u0000\u013d\u013e\u0003\u0096K\u0000\u013e"+
		"\u0019\u0001\u0000\u0000\u0000\u013f\u0140\u0005(\u0000\u0000\u0140\u0151"+
		"\u0005\u0015\u0000\u0000\u0141\u0143\u0005\b\u0000\u0000\u0142\u0141\u0001"+
		"\u0000\u0000\u0000\u0143\u0144\u0001\u0000\u0000\u0000\u0144\u0142\u0001"+
		"\u0000\u0000\u0000\u0144\u0145\u0001\u0000\u0000\u0000\u0145\u0146\u0001"+
		"\u0000\u0000\u0000\u0146\u0152\u0007\u0003\u0000\u0000\u0147\u0149\u0005"+
		"\b\u0000\u0000\u0148\u0147\u0001\u0000\u0000\u0000\u0149\u014a\u0001\u0000"+
		"\u0000\u0000\u014a\u0148\u0001\u0000\u0000\u0000\u014a\u014b\u0001\u0000"+
		"\u0000\u0000\u014b\u014c\u0001\u0000\u0000\u0000\u014c\u014e\u0003\u001c"+
		"\u000e\u0000\u014d\u0148\u0001\u0000\u0000\u0000\u014e\u014f\u0001\u0000"+
		"\u0000\u0000\u014f\u014d\u0001\u0000\u0000\u0000\u014f\u0150\u0001\u0000"+
		"\u0000\u0000\u0150\u0152\u0001\u0000\u0000\u0000\u0151\u0142\u0001\u0000"+
		"\u0000\u0000\u0151\u014d\u0001\u0000\u0000\u0000\u0152\u001b\u0001\u0000"+
		"\u0000\u0000\u0153\u0156\u0003B!\u0000\u0154\u0155\u0005\u0004\u0000\u0000"+
		"\u0155\u0157\u0003\u008eG\u0000\u0156\u0154\u0001\u0000\u0000\u0000\u0156"+
		"\u0157\u0001\u0000\u0000\u0000\u0157\u0159\u0001\u0000\u0000\u0000\u0158"+
		"\u015a\u0003P(\u0000\u0159\u0158\u0001\u0000\u0000\u0000\u0159\u015a\u0001"+
		"\u0000\u0000\u0000\u015a\u001d\u0001\u0000\u0000\u0000\u015b\u015e\u0005"+
		",\u0000\u0000\u015c\u015d\u0005\t\u0000\u0000\u015d\u015f\u00050\u0000"+
		"\u0000\u015e\u015c\u0001\u0000\u0000\u0000\u015e\u015f\u0001\u0000\u0000"+
		"\u0000\u015f\u0160\u0001\u0000\u0000\u0000\u0160\u0162\u0005\u0015\u0000"+
		"\u0000\u0161\u0163\u0005\b\u0000\u0000\u0162\u0161\u0001\u0000\u0000\u0000"+
		"\u0163\u0164\u0001\u0000\u0000\u0000\u0164\u0162\u0001\u0000\u0000\u0000"+
		"\u0164\u0165\u0001\u0000\u0000\u0000\u0165\u0166\u0001\u0000\u0000\u0000"+
		"\u0166\u0167\u0003(\u0014\u0000\u0167\u001f\u0001\u0000\u0000\u0000\u0168"+
		"\u016b\u0005-\u0000\u0000\u0169\u016a\u0005\t\u0000\u0000\u016a\u016c"+
		"\u00050\u0000\u0000\u016b\u0169\u0001\u0000\u0000\u0000\u016b\u016c\u0001"+
		"\u0000\u0000\u0000\u016c\u016d\u0001\u0000\u0000\u0000\u016d\u016f\u0005"+
		"\u0015\u0000\u0000\u016e\u0170\u0005\b\u0000\u0000\u016f\u016e\u0001\u0000"+
		"\u0000\u0000\u0170\u0171\u0001\u0000\u0000\u0000\u0171\u016f\u0001\u0000"+
		"\u0000\u0000\u0171\u0172\u0001\u0000\u0000\u0000\u0172\u0173\u0001\u0000"+
		"\u0000\u0000\u0173\u0174\u0003(\u0014\u0000\u0174!\u0001\u0000\u0000\u0000"+
		"\u0175\u0176\u0005-\u0000\u0000\u0176\u0177\u0005\u0014\u0000\u0000\u0177"+
		"\u017a\u00034\u001a\u0000\u0178\u0179\u0005\t\u0000\u0000\u0179\u017b"+
		"\u00050\u0000\u0000\u017a\u0178\u0001\u0000\u0000\u0000\u017a\u017b\u0001"+
		"\u0000\u0000\u0000\u017b\u017c\u0001\u0000\u0000\u0000\u017c\u017e\u0005"+
		"\u0015\u0000\u0000\u017d\u017f\u0005\b\u0000\u0000\u017e\u017d\u0001\u0000"+
		"\u0000\u0000\u017f\u0180\u0001\u0000\u0000\u0000\u0180\u017e\u0001\u0000"+
		"\u0000\u0000\u0180\u0181\u0001\u0000\u0000\u0000\u0181\u0182\u0001\u0000"+
		"\u0000\u0000\u0182\u0183\u0003(\u0014\u0000\u0183#\u0001\u0000\u0000\u0000"+
		"\u0184\u0189\u00034\u001a\u0000\u0185\u0186\u0005\t\u0000\u0000\u0186"+
		"\u0188\u0003.\u0017\u0000\u0187\u0185\u0001\u0000\u0000\u0000\u0188\u018b"+
		"\u0001\u0000\u0000\u0000\u0189\u0187\u0001\u0000\u0000\u0000\u0189\u018a"+
		"\u0001\u0000\u0000\u0000\u018a\u018d\u0001\u0000\u0000\u0000\u018b\u0189"+
		"\u0001\u0000\u0000\u0000\u018c\u018e\u0005\u0015\u0000\u0000\u018d\u018c"+
		"\u0001\u0000\u0000\u0000\u018d\u018e\u0001\u0000\u0000\u0000\u018e\u0190"+
		"\u0001\u0000\u0000\u0000\u018f\u0191\u0005\b\u0000\u0000\u0190\u018f\u0001"+
		"\u0000\u0000\u0000\u0191\u0192\u0001\u0000\u0000\u0000\u0192\u0190\u0001"+
		"\u0000\u0000\u0000\u0192\u0193\u0001\u0000\u0000\u0000\u0193\u0194\u0001"+
		"\u0000\u0000\u0000\u0194\u0195\u0003(\u0014\u0000\u0195%\u0001\u0000\u0000"+
		"\u0000\u0196\u0199\u0003p8\u0000\u0197\u0199\u0003t:\u0000\u0198\u0196"+
		"\u0001\u0000\u0000\u0000\u0198\u0197\u0001\u0000\u0000\u0000\u0199\'\u0001"+
		"\u0000\u0000\u0000\u019a\u01ae\u0003*\u0015\u0000\u019b\u019d\u0005\b"+
		"\u0000\u0000\u019c\u019b\u0001\u0000\u0000\u0000\u019d\u019e\u0001\u0000"+
		"\u0000\u0000\u019e\u019c\u0001\u0000\u0000\u0000\u019e\u019f\u0001\u0000"+
		"\u0000\u0000\u019f\u01a0\u0001\u0000\u0000\u0000\u01a0\u01a1\u0003,\u0016"+
		"\u0000\u01a1\u01a8\u0005\u0015\u0000\u0000\u01a2\u01a9\u0005\t\u0000\u0000"+
		"\u01a3\u01a5\u0005\b\u0000\u0000\u01a4\u01a3\u0001\u0000\u0000\u0000\u01a5"+
		"\u01a6\u0001\u0000\u0000\u0000\u01a6\u01a4\u0001\u0000\u0000\u0000\u01a6"+
		"\u01a7\u0001\u0000\u0000\u0000\u01a7\u01a9\u0001\u0000\u0000\u0000\u01a8"+
		"\u01a2\u0001\u0000\u0000\u0000\u01a8\u01a4\u0001\u0000\u0000\u0000\u01a9"+
		"\u01aa\u0001\u0000\u0000\u0000\u01aa\u01ab\u0003*\u0015\u0000\u01ab\u01ad"+
		"\u0001\u0000\u0000\u0000\u01ac\u019c\u0001\u0000\u0000\u0000\u01ad\u01b0"+
		"\u0001\u0000\u0000\u0000\u01ae\u01ac\u0001\u0000\u0000\u0000\u01ae\u01af"+
		"\u0001\u0000\u0000\u0000\u01af)\u0001\u0000\u0000\u0000\u01b0\u01ae\u0001"+
		"\u0000\u0000\u0000\u01b1\u01c3\u00032\u0019\u0000\u01b2\u01b6\u0005\n"+
		"\u0000\u0000\u01b3\u01b5\u0005\b\u0000\u0000\u01b4\u01b3\u0001\u0000\u0000"+
		"\u0000\u01b5\u01b8\u0001\u0000\u0000\u0000\u01b6\u01b4\u0001\u0000\u0000"+
		"\u0000\u01b6\u01b7\u0001\u0000\u0000\u0000\u01b7\u01b9\u0001\u0000\u0000"+
		"\u0000\u01b8\u01b6\u0001\u0000\u0000\u0000\u01b9\u01bd\u0003(\u0014\u0000"+
		"\u01ba\u01bc\u0005\b\u0000\u0000\u01bb\u01ba\u0001\u0000\u0000\u0000\u01bc"+
		"\u01bf\u0001\u0000\u0000\u0000\u01bd\u01bb\u0001\u0000\u0000\u0000\u01bd"+
		"\u01be\u0001\u0000\u0000\u0000\u01be\u01c0\u0001\u0000\u0000\u0000\u01bf"+
		"\u01bd\u0001\u0000\u0000\u0000\u01c0\u01c1\u0005\u000b\u0000\u0000\u01c1"+
		"\u01c3\u0001\u0000\u0000\u0000\u01c2\u01b1\u0001\u0000\u0000\u0000\u01c2"+
		"\u01b2\u0001\u0000\u0000\u0000\u01c3+\u0001\u0000\u0000\u0000\u01c4\u01c9"+
		"\u0007\u0004\u0000\u0000\u01c5\u01c6\u0005\t\u0000\u0000\u01c6\u01c8\u0003"+
		".\u0017\u0000\u01c7\u01c5\u0001\u0000\u0000\u0000\u01c8\u01cb\u0001\u0000"+
		"\u0000\u0000\u01c9\u01c7\u0001\u0000\u0000\u0000\u01c9\u01ca\u0001\u0000"+
		"\u0000\u0000\u01ca-\u0001\u0000\u0000\u0000\u01cb\u01c9\u0001\u0000\u0000"+
		"\u0000\u01cc\u01cf\u0003&\u0013\u0000\u01cd\u01cf\u00030\u0018\u0000\u01ce"+
		"\u01cc\u0001\u0000\u0000\u0000\u01ce\u01cd\u0001\u0000\u0000\u0000\u01cf"+
		"/\u0001\u0000\u0000\u0000\u01d0\u01d1\u0007\u0005\u0000\u0000\u01d11\u0001"+
		"\u0000\u0000\u0000\u01d2\u01db\u00036\u001b\u0000\u01d3\u01d5\u0005\b"+
		"\u0000\u0000\u01d4\u01d3\u0001\u0000\u0000\u0000\u01d5\u01d6\u0001\u0000"+
		"\u0000\u0000\u01d6\u01d4\u0001\u0000\u0000\u0000\u01d6\u01d7\u0001\u0000"+
		"\u0000\u0000\u01d7\u01d8\u0001\u0000\u0000\u0000\u01d8\u01da\u00036\u001b"+
		"\u0000\u01d9\u01d4\u0001\u0000\u0000\u0000\u01da\u01dd\u0001\u0000\u0000"+
		"\u0000\u01db\u01d9\u0001\u0000\u0000\u0000\u01db\u01dc\u0001\u0000\u0000"+
		"\u0000\u01dc3\u0001\u0000\u0000\u0000\u01dd\u01db\u0001\u0000\u0000\u0000"+
		"\u01de\u01e6\u0003\u0098L\u0000\u01df\u01e2\u0005\u0014\u0000\u0000\u01e0"+
		"\u01e3\u0003\u0098L\u0000\u01e1\u01e3\u00058\u0000\u0000\u01e2\u01e0\u0001"+
		"\u0000\u0000\u0000\u01e2\u01e1\u0001\u0000\u0000\u0000\u01e3\u01e5\u0001"+
		"\u0000\u0000\u0000\u01e4\u01df\u0001\u0000\u0000\u0000\u01e5\u01e8\u0001"+
		"\u0000\u0000\u0000\u01e6\u01e4\u0001\u0000\u0000\u0000\u01e6\u01e7\u0001"+
		"\u0000\u0000\u0000\u01e75\u0001\u0000\u0000\u0000\u01e8\u01e6\u0001\u0000"+
		"\u0000\u0000\u01e9\u01ed\u00038\u001c\u0000\u01ea\u01ed\u0003:\u001d\u0000"+
		"\u01eb\u01ed\u0003<\u001e\u0000\u01ec\u01e9\u0001\u0000\u0000\u0000\u01ec"+
		"\u01ea\u0001\u0000\u0000\u0000\u01ec\u01eb\u0001\u0000\u0000\u0000\u01ed"+
		"7\u0001\u0000\u0000\u0000\u01ee\u01ef\u0007\u0006\u0000\u0000\u01ef9\u0001"+
		"\u0000\u0000\u0000\u01f0\u01f1\u0005\u0015\u0000\u0000\u01f1\u01f2\u0003"+
		"4\u001a\u0000\u01f2;\u0001\u0000\u0000\u0000\u01f3\u01f4\u0003>\u001f"+
		"\u0000\u01f4\u01f5\u0005\u0004\u0000\u0000\u01f5\u01f7\u0003@ \u0000\u01f6"+
		"\u01f8\u0003P(\u0000\u01f7\u01f6\u0001\u0000\u0000\u0000\u01f7\u01f8\u0001"+
		"\u0000\u0000\u0000\u01f8=\u0001\u0000\u0000\u0000\u01f9\u01fa\u0003B!"+
		"\u0000\u01fa?\u0001\u0000\u0000\u0000\u01fb\u01fc\u0003D\"\u0000\u01fc"+
		"A\u0001\u0000\u0000\u0000\u01fd\u01ff\u0003D\"\u0000\u01fe\u0200\u0003"+
		"P(\u0000\u01ff\u01fe\u0001\u0000\u0000\u0000\u01ff\u0200\u0001\u0000\u0000"+
		"\u0000\u0200C\u0001\u0000\u0000\u0000\u0201\u0208\u0003F#\u0000\u0202"+
		"\u0208\u0003^/\u0000\u0203\u0208\u0003d2\u0000\u0204\u0208\u0003f3\u0000"+
		"\u0205\u0208\u0003l6\u0000\u0206\u0208\u0003L&\u0000\u0207\u0201\u0001"+
		"\u0000\u0000\u0000\u0207\u0202\u0001\u0000\u0000\u0000\u0207\u0203\u0001"+
		"\u0000\u0000\u0000\u0207\u0204\u0001\u0000\u0000\u0000\u0207\u0205\u0001"+
		"\u0000\u0000\u0000\u0207\u0206\u0001\u0000\u0000\u0000\u0208E\u0001\u0000"+
		"\u0000\u0000\u0209\u020c\u0003H$\u0000\u020a\u020c\u0003J%\u0000\u020b"+
		"\u0209\u0001\u0000\u0000\u0000\u020b\u020a\u0001\u0000\u0000\u0000\u020c"+
		"G\u0001\u0000\u0000\u0000\u020d\u020e\u0005\n\u0000\u0000\u020e\u020f"+
		"\u0003B!\u0000\u020f\u0210\u0005\u000b\u0000\u0000\u0210I\u0001\u0000"+
		"\u0000\u0000\u0211\u0212\u0005\u000f\u0000\u0000\u0212\u0217\u0003B!\u0000"+
		"\u0213\u0214\u0005\u0002\u0000\u0000\u0214\u0216\u0003B!\u0000\u0215\u0213"+
		"\u0001\u0000\u0000\u0000\u0216\u0219\u0001\u0000\u0000\u0000\u0217\u0215"+
		"\u0001\u0000\u0000\u0000\u0217\u0218\u0001\u0000\u0000\u0000\u0218\u021a"+
		"\u0001\u0000\u0000\u0000\u0219\u0217\u0001\u0000\u0000\u0000\u021a\u021b"+
		"\u0005\u0011\u0000\u0000\u021bK\u0001\u0000\u0000\u0000\u021c\u021f\u0003"+
		"N\'\u0000\u021d\u021e\u0005\t\u0000\u0000\u021e\u0220\u0003N\'\u0000\u021f"+
		"\u021d\u0001\u0000\u0000\u0000\u0220\u0221\u0001\u0000\u0000\u0000\u0221"+
		"\u021f\u0001\u0000\u0000\u0000\u0221\u0222\u0001\u0000\u0000\u0000\u0222"+
		"M\u0001\u0000\u0000\u0000\u0223\u0229\u0003F#\u0000\u0224\u0229\u0003"+
		"^/\u0000\u0225\u0229\u0003d2\u0000\u0226\u0229\u0003f3\u0000\u0227\u0229"+
		"\u0003l6\u0000\u0228\u0223\u0001\u0000\u0000\u0000\u0228\u0224\u0001\u0000"+
		"\u0000\u0000\u0228\u0225\u0001\u0000\u0000\u0000\u0228\u0226\u0001\u0000"+
		"\u0000\u0000\u0228\u0227\u0001\u0000\u0000\u0000\u0229O\u0001\u0000\u0000"+
		"\u0000\u022a\u0230\u0003R)\u0000\u022b\u0230\u0003T*\u0000\u022c\u022d"+
		"\u0003R)\u0000\u022d\u022e\u0003T*\u0000\u022e\u0230\u0001\u0000\u0000"+
		"\u0000\u022f\u022a\u0001\u0000\u0000\u0000\u022f\u022b\u0001\u0000\u0000"+
		"\u0000\u022f\u022c\u0001\u0000\u0000\u0000\u0230Q\u0001\u0000\u0000\u0000"+
		"\u0231\u0234\u0005\u0005\u0000\u0000\u0232\u0235\u0003X,\u0000\u0233\u0235"+
		"\u0003V+\u0000\u0234\u0232\u0001\u0000\u0000\u0000\u0234\u0233\u0001\u0000"+
		"\u0000\u0000\u0235S\u0001\u0000\u0000\u0000\u0236\u0239\u0005\u0006\u0000"+
		"\u0000\u0237\u023a\u0003X,\u0000\u0238\u023a\u0003V+\u0000\u0239\u0237"+
		"\u0001\u0000\u0000\u0000\u0239\u0238\u0001\u0000\u0000\u0000\u023aU\u0001"+
		"\u0000\u0000\u0000\u023b\u023c\u0005\u000f\u0000\u0000\u023c\u0241\u0003"+
		"X,\u0000\u023d\u023e\u0005\u0002\u0000\u0000\u023e\u0240\u0003X,\u0000"+
		"\u023f\u023d\u0001\u0000\u0000\u0000\u0240\u0243\u0001\u0000\u0000\u0000"+
		"\u0241\u023f\u0001\u0000\u0000\u0000\u0241\u0242\u0001\u0000\u0000\u0000"+
		"\u0242\u0244\u0001\u0000\u0000\u0000\u0243\u0241\u0001\u0000\u0000\u0000"+
		"\u0244\u0245\u0005\u0011\u0000\u0000\u0245W\u0001\u0000\u0000\u0000\u0246"+
		"\u0247\u0003Z-\u0000\u0247\u0248\u0005\t\u0000\u0000\u0248\u024a\u0001"+
		"\u0000\u0000\u0000\u0249\u0246\u0001\u0000\u0000\u0000\u0249\u024a\u0001"+
		"\u0000\u0000\u0000\u024a\u024b\u0001\u0000\u0000\u0000\u024b\u024e\u0005"+
		"\u0007\u0000\u0000\u024c\u024d\u0005\t\u0000\u0000\u024d\u024f\u0003\\"+
		".\u0000\u024e\u024c\u0001\u0000\u0000\u0000\u024e\u024f\u0001\u0000\u0000"+
		"\u0000\u024f\u0254\u0001\u0000\u0000\u0000\u0250\u0252\u0003Z-\u0000\u0251"+
		"\u0250\u0001\u0000\u0000\u0000\u0251\u0252\u0001\u0000\u0000\u0000\u0252"+
		"\u0254\u0001\u0000\u0000\u0000\u0253\u0249\u0001\u0000\u0000\u0000\u0253"+
		"\u0251\u0001\u0000\u0000\u0000\u0254Y\u0001\u0000\u0000\u0000\u0255\u0256"+
		"\u0003D\"\u0000\u0256[\u0001\u0000\u0000\u0000\u0257\u0258\u0003D\"\u0000"+
		"\u0258]\u0001\u0000\u0000\u0000\u0259\u025d\u0003b1\u0000\u025a\u025b"+
		"\u0003`0\u0000\u025b\u025c\u0003b1\u0000\u025c\u025e\u0001\u0000\u0000"+
		"\u0000\u025d\u025a\u0001\u0000\u0000\u0000\u025e\u025f\u0001\u0000\u0000"+
		"\u0000\u025f\u025d\u0001\u0000\u0000\u0000\u025f\u0260\u0001\u0000\u0000"+
		"\u0000\u0260_\u0001\u0000\u0000\u0000\u0261\u0262\u0007\u0007\u0000\u0000"+
		"\u0262a\u0001\u0000\u0000\u0000\u0263\u0268\u0003F#\u0000\u0264\u0268"+
		"\u0003d2\u0000\u0265\u0268\u0003f3\u0000\u0266\u0268\u0003l6\u0000\u0267"+
		"\u0263\u0001\u0000\u0000\u0000\u0267\u0264\u0001\u0000\u0000\u0000\u0267"+
		"\u0265\u0001\u0000\u0000\u0000\u0267\u0266\u0001\u0000\u0000\u0000\u0268"+
		"c\u0001\u0000\u0000\u0000\u0269\u026c\u0005\u0017\u0000\u0000\u026a\u026d"+
		"\u0003F#\u0000\u026b\u026d\u0003l6\u0000\u026c\u026a\u0001\u0000\u0000"+
		"\u0000\u026c\u026b\u0001\u0000\u0000\u0000\u026de\u0001\u0000\u0000\u0000"+
		"\u026e\u0271\u0003h4\u0000\u026f\u0271\u0003j5\u0000\u0270\u026e\u0001"+
		"\u0000\u0000\u0000\u0270\u026f\u0001\u0000\u0000\u0000\u0271g\u0001\u0000"+
		"\u0000\u0000\u0272\u0276\u0003F#\u0000\u0273\u0276\u0003d2\u0000\u0274"+
		"\u0276\u0003l6\u0000\u0275\u0272\u0001\u0000\u0000\u0000\u0275\u0273\u0001"+
		"\u0000\u0000\u0000\u0275\u0274\u0001\u0000\u0000\u0000\u0276\u0277\u0001"+
		"\u0000\u0000\u0000\u0277\u0278\u0003r9\u0000\u0278i\u0001\u0000\u0000"+
		"\u0000\u0279\u027c\u0003F#\u0000\u027a\u027c\u0003l6\u0000\u027b\u0279"+
		"\u0001\u0000\u0000\u0000\u027b\u027a\u0001\u0000\u0000\u0000\u027c\u027d"+
		"\u0001\u0000\u0000\u0000\u027d\u027e\u0003\u0086C\u0000\u027ek\u0001\u0000"+
		"\u0000\u0000\u027f\u0289\u0003n7\u0000\u0280\u0289\u0003p8\u0000\u0281"+
		"\u0289\u0003r9\u0000\u0282\u0289\u0003t:\u0000\u0283\u0289\u0003~?\u0000"+
		"\u0284\u0289\u0003\u0080@\u0000\u0285\u0289\u0003\u0082A\u0000\u0286\u0289"+
		"\u0003\u0084B\u0000\u0287\u0289\u0003\u0096K\u0000\u0288\u027f\u0001\u0000"+
		"\u0000\u0000\u0288\u0280\u0001\u0000\u0000\u0000\u0288\u0281\u0001\u0000"+
		"\u0000\u0000\u0288\u0282\u0001\u0000\u0000\u0000\u0288\u0283\u0001\u0000"+
		"\u0000\u0000\u0288\u0284\u0001\u0000\u0000\u0000\u0288\u0285\u0001\u0000"+
		"\u0000\u0000\u0288\u0286\u0001\u0000\u0000\u0000\u0288\u0287\u0001\u0000"+
		"\u0000\u0000\u0289m\u0001\u0000\u0000\u0000\u028a\u028b\u0005+\u0000\u0000"+
		"\u028bo\u0001\u0000\u0000\u0000\u028c\u028d\u0005\u001b\u0000\u0000\u028d"+
		"\u028e\u0003\u0098L\u0000\u028eq\u0001\u0000\u0000\u0000\u028f\u0291\u0005"+
		"\u0016\u0000\u0000\u0290\u028f\u0001\u0000\u0000\u0000\u0290\u0291\u0001"+
		"\u0000\u0000\u0000\u0291\u0292\u0001\u0000\u0000\u0000\u0292\u0294\u0005"+
		"\u0019\u0000\u0000\u0293\u0295\u0005\u0018\u0000\u0000\u0294\u0293\u0001"+
		"\u0000\u0000\u0000\u0294\u0295\u0001\u0000\u0000\u0000\u0295\u0296\u0001"+
		"\u0000\u0000\u0000\u0296\u0297\u00058\u0000\u0000\u0297s\u0001\u0000\u0000"+
		"\u0000\u0298\u029a\u0005\r\u0000\u0000\u0299\u029b\u0003v;\u0000\u029a"+
		"\u0299\u0001\u0000\u0000\u0000\u029a\u029b\u0001\u0000\u0000\u0000\u029b"+
		"\u02a0\u0001\u0000\u0000\u0000\u029c\u029d\u0005\t\u0000\u0000\u029d\u029f"+
		"\u0003v;\u0000\u029e\u029c\u0001\u0000\u0000\u0000\u029f\u02a2\u0001\u0000"+
		"\u0000\u0000\u02a0\u029e\u0001\u0000\u0000\u0000\u02a0\u02a1\u0001\u0000"+
		"\u0000\u0000\u02a1\u02a3\u0001\u0000\u0000\u0000\u02a2\u02a0\u0001\u0000"+
		"\u0000\u0000\u02a3\u02a4\u0005\u000e\u0000\u0000\u02a4u\u0001\u0000\u0000"+
		"\u0000\u02a5\u02aa\u0003\u0090H\u0000\u02a6\u02aa\u0003x<\u0000\u02a7"+
		"\u02aa\u0003z=\u0000\u02a8\u02aa\u0003|>\u0000\u02a9\u02a5\u0001\u0000"+
		"\u0000\u0000\u02a9\u02a6\u0001\u0000\u0000\u0000\u02a9\u02a7\u0001\u0000"+
		"\u0000\u0000\u02a9\u02a8\u0001\u0000\u0000\u0000\u02aaw\u0001\u0000\u0000"+
		"\u0000\u02ab\u02ac\u0005\u0017\u0000\u0000\u02ac\u02ad\u0003\u0090H\u0000"+
		"\u02ady\u0001\u0000\u0000\u0000\u02ae\u02af\u0005\f\u0000\u0000\u02af"+
		"\u02b0\u0003\u0098L\u0000\u02b0{\u0001\u0000\u0000\u0000\u02b1\u02b2\u0005"+
		"\u0019\u0000\u0000\u02b2\u02b3\u0003\u0098L\u0000\u02b3}\u0001\u0000\u0000"+
		"\u0000\u02b4\u02b5\u0005\f\u0000\u0000\u02b5\u007f\u0001\u0000\u0000\u0000"+
		"\u02b6\u02b7\u0005\u0018\u0000\u0000\u02b7\u0081\u0001\u0000\u0000\u0000"+
		"\u02b8\u02b9\u0005\u0019\u0000\u0000\u02b9\u0083\u0001\u0000\u0000\u0000"+
		"\u02ba\u02bb\u0005\u001a\u0000\u0000\u02bb\u0085\u0001\u0000\u0000\u0000"+
		"\u02bc\u02c1\u0003\u0088D\u0000\u02bd\u02c1\u0005\u0012\u0000\u0000\u02be"+
		"\u02c1\u0005\f\u0000\u0000\u02bf\u02c1\u0005\u0013\u0000\u0000\u02c0\u02bc"+
		"\u0001\u0000\u0000\u0000\u02c0\u02bd\u0001\u0000\u0000\u0000\u02c0\u02be"+
		"\u0001\u0000\u0000\u0000\u02c0\u02bf\u0001\u0000\u0000\u0000\u02c1\u0087"+
		"\u0001\u0000\u0000\u0000\u02c2\u02cd\u0005\f\u0000\u0000\u02c3\u02ce\u0005"+
		"8\u0000\u0000\u02c4\u02c6\u0005\n\u0000\u0000\u02c5\u02c7\u0003\u008a"+
		"E\u0000\u02c6\u02c5\u0001\u0000\u0000\u0000\u02c6\u02c7\u0001\u0000\u0000"+
		"\u0000\u02c7\u02c8\u0001\u0000\u0000\u0000\u02c8\u02ca\u0005\u0014\u0000"+
		"\u0000\u02c9\u02cb\u0003\u008cF\u0000\u02ca\u02c9\u0001\u0000\u0000\u0000"+
		"\u02ca\u02cb\u0001\u0000\u0000\u0000\u02cb\u02cc\u0001\u0000\u0000\u0000"+
		"\u02cc\u02ce\u0005\u000b\u0000\u0000\u02cd\u02c3\u0001\u0000\u0000\u0000"+
		"\u02cd\u02c4\u0001\u0000\u0000\u0000\u02ce\u0089\u0001\u0000\u0000\u0000"+
		"\u02cf\u02d0\u00058\u0000\u0000\u02d0\u008b\u0001\u0000\u0000\u0000\u02d1"+
		"\u02d2\u00058\u0000\u0000\u02d2\u008d\u0001\u0000\u0000\u0000\u02d3\u02d5"+
		"\u0005\r\u0000\u0000\u02d4\u02d6\u0003\u0090H\u0000\u02d5\u02d4\u0001"+
		"\u0000\u0000\u0000\u02d5\u02d6\u0001\u0000\u0000\u0000\u02d6\u02db\u0001"+
		"\u0000\u0000\u0000\u02d7\u02d8\u0005\t\u0000\u0000\u02d8\u02da\u0003\u0090"+
		"H\u0000\u02d9\u02d7\u0001\u0000\u0000\u0000\u02da\u02dd\u0001\u0000\u0000"+
		"\u0000\u02db\u02d9\u0001\u0000\u0000\u0000\u02db\u02dc\u0001\u0000\u0000"+
		"\u0000\u02dc\u02de\u0001\u0000\u0000\u0000\u02dd\u02db\u0001\u0000\u0000"+
		"\u0000\u02de\u02df\u0005\u000e\u0000\u0000\u02df\u008f\u0001\u0000\u0000"+
		"\u0000\u02e0\u02e3\u0003\u0092I\u0000\u02e1\u02e3\u0003\u0094J\u0000\u02e2"+
		"\u02e0\u0001\u0000\u0000\u0000\u02e2\u02e1\u0001\u0000\u0000\u0000\u02e3"+
		"\u0091\u0001\u0000\u0000\u0000\u02e4\u02e5\u0007\b\u0000\u0000\u02e5\u02e6"+
		"\u0003\u0098L\u0000\u02e6\u0093\u0001\u0000\u0000\u0000\u02e7\u02e8\u0003"+
		"\u0098L\u0000\u02e8\u0095\u0001\u0000\u0000\u0000\u02e9\u02ed\u0003\u0098"+
		"L\u0000\u02ea\u02ed\u0005:\u0000\u0000\u02eb\u02ed\u0005;\u0000\u0000"+
		"\u02ec\u02e9\u0001\u0000\u0000\u0000\u02ec\u02ea\u0001\u0000\u0000\u0000"+
		"\u02ec\u02eb\u0001\u0000\u0000\u0000\u02ed\u02ef\u0001\u0000\u0000\u0000"+
		"\u02ee\u02f0\u0005\u0017\u0000\u0000\u02ef\u02ee\u0001\u0000\u0000\u0000"+
		"\u02ef\u02f0\u0001\u0000\u0000\u0000\u02f0\u0097\u0001\u0000\u0000\u0000"+
		"\u02f1\u02f2\u0007\t\u0000\u0000\u02f2\u0099\u0001\u0000\u0000\u0000Y"+
		"\u009e\u00a1\u00a4\u00a9\u00ae\u00b5\u00b8\u00c7\u00d9\u00dd\u00e3\u00ec"+
		"\u00f2\u00f6\u00fc\u0103\u0108\u010f\u0112\u0122\u012a\u0136\u013b\u0144"+
		"\u014a\u014f\u0151\u0156\u0159\u015e\u0164\u016b\u0171\u017a\u0180\u0189"+
		"\u018d\u0192\u0198\u019e\u01a6\u01a8\u01ae\u01b6\u01bd\u01c2\u01c9\u01ce"+
		"\u01d6\u01db\u01e2\u01e6\u01ec\u01f7\u01ff\u0207\u020b\u0217\u0221\u0228"+
		"\u022f\u0234\u0239\u0241\u0249\u024e\u0251\u0253\u025f\u0267\u026c\u0270"+
		"\u0275\u027b\u0288\u0290\u0294\u029a\u02a0\u02a9\u02c0\u02c6\u02ca\u02cd"+
		"\u02d5\u02db\u02e2\u02ec\u02ef";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}