// Generated from /Users/gthill/projects/lexurgy/core/src/antlr/sc/Lsc.g4 by ANTLR 4.13.2
package com.meamoria.lexurgy.sc.java;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class LscParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		COMMENT=1, LIST_SEP=2, CLASS_SEP=3, CHANGE=4, CONDITION=5, EXCLUSION=6, 
		ANCHOR=7, NEWLINE=8, WHITESPACE=9, O_PAREN=10, C_PAREN=11, NULL=12, MATRIX_START=13, 
		MATRIX_END=14, LIST_START=15, CLASS_START=16, LIST_END=17, AT_LEAST_ONE=18, 
		OPTIONAL=19, HYPHEN=20, RULE_START=21, DOUBLE_COLON=22, QMARK_COLON=23, 
		INEXACT=24, NEGATION=25, SYLLABLE_BOUNDARY=26, WORD_BOUNDARY=27, BETWEEN_WORDS=28, 
		CLASSREF=29, INTERSECTION=30, INTERSECTION_NOT=31, TRANSFORMING=32, ELEMENT_DECL=33, 
		CLASS_DECL=34, FEATURE_DECL=35, SYLLABLE_FEATURE=36, DIACRITIC_DECL=37, 
		DIA_BEFORE=38, DIA_FIRST=39, DIA_FLOATING=40, SYMBOL_DECL=41, SYLLABLE_DECL=42, 
		EXPLICIT_SYLLABLES=43, CLEAR_SYLLABLES=44, ANY_SYLLABLE=45, DEROMANIZER=46, 
		ROMANIZER=47, ALL_MATCHING=48, FIRST_MATCHING=49, LITERAL=50, LTR=51, 
		RTL=52, PROPAGATE=53, CLEANUP=54, BLOCK=55, UNCHANGED=56, OFF=57, NUMBER=58, 
		NAME=59, STR1=60, STR=61;
	public static final int
		RULE_lscFile = 0, RULE_statement = 1, RULE_elementDecl = 2, RULE_classDecl = 3, 
		RULE_classElement = 4, RULE_featureDecl = 5, RULE_featureModifier = 6, 
		RULE_plusFeature = 7, RULE_nullAlias = 8, RULE_diacriticDecl = 9, RULE_diacriticModifier = 10, 
		RULE_symbolDecl = 11, RULE_symbolName = 12, RULE_syllableDecl = 13, RULE_syllableExpression = 14, 
		RULE_syllablePattern = 15, RULE_structuredPattern = 16, RULE_reluctantOnset = 17, 
		RULE_deromanizer = 18, RULE_romanizer = 19, RULE_interRomanizer = 20, 
		RULE_changeRule = 21, RULE_filter = 22, RULE_block = 23, RULE_blockElement = 24, 
		RULE_blockType = 25, RULE_changeRuleModifier = 26, RULE_keywordModifier = 27, 
		RULE_expressionList = 28, RULE_ruleName = 29, RULE_expression = 30, RULE_keywordExpression = 31, 
		RULE_blockRef = 32, RULE_standardExpression = 33, RULE_from = 34, RULE_to = 35, 
		RULE_ruleElement = 36, RULE_unconditionalRuleElement = 37, RULE_bounded = 38, 
		RULE_group = 39, RULE_list = 40, RULE_sequence = 41, RULE_freeElement = 42, 
		RULE_compoundEnvironment = 43, RULE_condition = 44, RULE_exclusion = 45, 
		RULE_environmentList = 46, RULE_environment = 47, RULE_environmentBefore = 48, 
		RULE_environmentAfter = 49, RULE_interfix = 50, RULE_interfixType = 51, 
		RULE_interfixElement = 52, RULE_negated = 53, RULE_postfix = 54, RULE_capture = 55, 
		RULE_repeater = 56, RULE_simple = 57, RULE_anySyllable = 58, RULE_elementRef = 59, 
		RULE_captureRef = 60, RULE_fancyMatrix = 61, RULE_fancyValue = 62, RULE_positiveValue = 63, 
		RULE_absentFeature = 64, RULE_featureVariable = 65, RULE_empty = 66, RULE_sylBoundary = 67, 
		RULE_boundary = 68, RULE_betweenWords = 69, RULE_repeaterType = 70, RULE_repeatRange = 71, 
		RULE_lowerBound = 72, RULE_upperBound = 73, RULE_matrix = 74, RULE_matrixValue = 75, 
		RULE_plusFeatureValue = 76, RULE_featureValue = 77, RULE_text = 78, RULE_name = 79;
	private static String[] makeRuleNames() {
		return new String[] {
			"lscFile", "statement", "elementDecl", "classDecl", "classElement", "featureDecl", 
			"featureModifier", "plusFeature", "nullAlias", "diacriticDecl", "diacriticModifier", 
			"symbolDecl", "symbolName", "syllableDecl", "syllableExpression", "syllablePattern", 
			"structuredPattern", "reluctantOnset", "deromanizer", "romanizer", "interRomanizer", 
			"changeRule", "filter", "block", "blockElement", "blockType", "changeRuleModifier", 
			"keywordModifier", "expressionList", "ruleName", "expression", "keywordExpression", 
			"blockRef", "standardExpression", "from", "to", "ruleElement", "unconditionalRuleElement", 
			"bounded", "group", "list", "sequence", "freeElement", "compoundEnvironment", 
			"condition", "exclusion", "environmentList", "environment", "environmentBefore", 
			"environmentAfter", "interfix", "interfixType", "interfixElement", "negated", 
			"postfix", "capture", "repeater", "simple", "anySyllable", "elementRef", 
			"captureRef", "fancyMatrix", "fancyValue", "positiveValue", "absentFeature", 
			"featureVariable", "empty", "sylBoundary", "boundary", "betweenWords", 
			"repeaterType", "repeatRange", "lowerBound", "upperBound", "matrix", 
			"matrixValue", "plusFeatureValue", "featureValue", "text", "name"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, null, null, "'_'", null, null, null, null, 
			"'*'", null, null, null, null, null, "'+'", "'?'", "'-'", "':'", null, 
			null, "'~'", "'!'", "'.'", "'$'", "'$$'", "'@'", "'&'", "'&!'", "'>'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "COMMENT", "LIST_SEP", "CLASS_SEP", "CHANGE", "CONDITION", "EXCLUSION", 
			"ANCHOR", "NEWLINE", "WHITESPACE", "O_PAREN", "C_PAREN", "NULL", "MATRIX_START", 
			"MATRIX_END", "LIST_START", "CLASS_START", "LIST_END", "AT_LEAST_ONE", 
			"OPTIONAL", "HYPHEN", "RULE_START", "DOUBLE_COLON", "QMARK_COLON", "INEXACT", 
			"NEGATION", "SYLLABLE_BOUNDARY", "WORD_BOUNDARY", "BETWEEN_WORDS", "CLASSREF", 
			"INTERSECTION", "INTERSECTION_NOT", "TRANSFORMING", "ELEMENT_DECL", "CLASS_DECL", 
			"FEATURE_DECL", "SYLLABLE_FEATURE", "DIACRITIC_DECL", "DIA_BEFORE", "DIA_FIRST", 
			"DIA_FLOATING", "SYMBOL_DECL", "SYLLABLE_DECL", "EXPLICIT_SYLLABLES", 
			"CLEAR_SYLLABLES", "ANY_SYLLABLE", "DEROMANIZER", "ROMANIZER", "ALL_MATCHING", 
			"FIRST_MATCHING", "LITERAL", "LTR", "RTL", "PROPAGATE", "CLEANUP", "BLOCK", 
			"UNCHANGED", "OFF", "NUMBER", "NAME", "STR1", "STR"
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
			setState(167);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				{
				setState(160);
				match(WHITESPACE);
				}
				break;
			case 2:
				{
				setState(164);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(161);
						match(NEWLINE);
						}
						} 
					}
					setState(166);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
				}
				}
				break;
			}
			setState(170);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4323453641877926912L) != 0)) {
				{
				setState(169);
				statement();
				}
			}

			setState(180);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(173); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(172);
						match(NEWLINE);
						}
						}
						setState(175); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==NEWLINE );
					setState(177);
					statement();
					}
					} 
				}
				setState(182);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			}
			setState(190);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case WHITESPACE:
				{
				setState(183);
				match(WHITESPACE);
				}
				break;
			case EOF:
			case NEWLINE:
				{
				setState(187);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NEWLINE) {
					{
					{
					setState(184);
					match(NEWLINE);
					}
					}
					setState(189);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(192);
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
			setState(205);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(194);
				featureDecl();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(195);
				diacriticDecl();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(196);
				symbolDecl();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(197);
				classDecl();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(198);
				elementDecl();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(199);
				syllableDecl();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(200);
				deromanizer();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(201);
				interRomanizer();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(202);
				romanizer();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(203);
				changeRule();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(204);
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
			setState(207);
			match(ELEMENT_DECL);
			setState(208);
			match(WHITESPACE);
			setState(209);
			name();
			setState(210);
			match(WHITESPACE);
			setState(211);
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
		public TerminalNode NEWLINE() { return getToken(LscParser.NEWLINE, 0); }
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
			setState(213);
			match(CLASS_DECL);
			setState(214);
			match(WHITESPACE);
			setState(215);
			name();
			setState(216);
			match(WHITESPACE);
			setState(217);
			_la = _input.LA(1);
			if ( !(_la==LIST_START || _la==CLASS_START) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(218);
			classElement();
			setState(223);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(219);
					_la = _input.LA(1);
					if ( !(_la==LIST_SEP || _la==CLASS_SEP) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(220);
					classElement();
					}
					} 
				}
				setState(225);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			}
			setState(227);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CLASS_SEP || _la==NEWLINE) {
				{
				setState(226);
				_la = _input.LA(1);
				if ( !(_la==CLASS_SEP || _la==NEWLINE) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
			}

			setState(229);
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
			setState(233);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CLASSREF:
				enterOuterAlt(_localctx, 1);
				{
				setState(231);
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
				setState(232);
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
			setState(235);
			match(FEATURE_DECL);
			setState(236);
			match(WHITESPACE);
			setState(270);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				{
				{
				setState(237);
				plusFeature();
				setState(242);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==LIST_SEP) {
					{
					{
					setState(238);
					match(LIST_SEP);
					setState(239);
					plusFeature();
					}
					}
					setState(244);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				break;
			case 2:
				{
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

				setState(250);
				name();
				setState(252);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==WHITESPACE) {
					{
					setState(251);
					match(WHITESPACE);
					}
				}

				setState(254);
				match(O_PAREN);
				setState(258);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NULL) {
					{
					setState(255);
					nullAlias();
					setState(256);
					match(LIST_SEP);
					}
				}

				setState(260);
				featureValue();
				setState(265);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==LIST_SEP) {
					{
					{
					setState(261);
					match(LIST_SEP);
					setState(262);
					featureValue();
					}
					}
					setState(267);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(268);
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
			setState(272);
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
			setState(277);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SYLLABLE_FEATURE) {
				{
				setState(274);
				featureModifier();
				setState(275);
				match(WHITESPACE);
				}
			}

			setState(280);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==AT_LEAST_ONE) {
				{
				setState(279);
				match(AT_LEAST_ONE);
				}
			}

			setState(282);
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
			setState(284);
			match(NULL);
			setState(285);
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
			setState(287);
			match(DIACRITIC_DECL);
			setState(288);
			match(WHITESPACE);
			setState(289);
			text();
			setState(290);
			match(WHITESPACE);
			setState(296);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1924145348608L) != 0)) {
				{
				{
				setState(291);
				diacriticModifier();
				setState(292);
				match(WHITESPACE);
				}
				}
				setState(298);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(299);
			matrix();
			setState(304);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(300);
					match(WHITESPACE);
					setState(301);
					diacriticModifier();
					}
					} 
				}
				setState(306);
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
			setState(307);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 1924145348608L) != 0)) ) {
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
			setState(309);
			match(SYMBOL_DECL);
			setState(310);
			match(WHITESPACE);
			setState(311);
			symbolName();
			setState(321);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				{
				setState(316);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==LIST_SEP) {
					{
					{
					setState(312);
					match(LIST_SEP);
					setState(313);
					symbolName();
					}
					}
					setState(318);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				{
				setState(319);
				match(WHITESPACE);
				setState(320);
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
			setState(323);
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
		public List<SyllableExpressionContext> syllableExpression() {
			return getRuleContexts(SyllableExpressionContext.class);
		}
		public SyllableExpressionContext syllableExpression(int i) {
			return getRuleContext(SyllableExpressionContext.class,i);
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
			setState(325);
			match(SYLLABLE_DECL);
			setState(326);
			match(RULE_START);
			setState(343);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
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
				setState(339); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(334); 
						_errHandler.sync(this);
						_la = _input.LA(1);
						do {
							{
							{
							setState(333);
							match(NEWLINE);
							}
							}
							setState(336); 
							_errHandler.sync(this);
							_la = _input.LA(1);
						} while ( _la==NEWLINE );
						setState(338);
						syllableExpression();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(341); 
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
	public static class SyllableExpressionContext extends ParserRuleContext {
		public SyllablePatternContext syllablePattern() {
			return getRuleContext(SyllablePatternContext.class,0);
		}
		public TerminalNode CHANGE() { return getToken(LscParser.CHANGE, 0); }
		public MatrixContext matrix() {
			return getRuleContext(MatrixContext.class,0);
		}
		public CompoundEnvironmentContext compoundEnvironment() {
			return getRuleContext(CompoundEnvironmentContext.class,0);
		}
		public SyllableExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_syllableExpression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LscVisitor ) return ((LscVisitor<? extends T>)visitor).visitSyllableExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SyllableExpressionContext syllableExpression() throws RecognitionException {
		SyllableExpressionContext _localctx = new SyllableExpressionContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_syllableExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(345);
			syllablePattern();
			setState(348);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CHANGE) {
				{
				setState(346);
				match(CHANGE);
				setState(347);
				matrix();
				}
			}

			setState(351);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CONDITION || _la==EXCLUSION) {
				{
				setState(350);
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
	public static class SyllablePatternContext extends ParserRuleContext {
		public StructuredPatternContext structuredPattern() {
			return getRuleContext(StructuredPatternContext.class,0);
		}
		public RuleElementContext ruleElement() {
			return getRuleContext(RuleElementContext.class,0);
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
		enterRule(_localctx, 30, RULE_syllablePattern);
		try {
			setState(355);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(353);
				structuredPattern();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(354);
				ruleElement();
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
	public static class StructuredPatternContext extends ParserRuleContext {
		public List<UnconditionalRuleElementContext> unconditionalRuleElement() {
			return getRuleContexts(UnconditionalRuleElementContext.class);
		}
		public UnconditionalRuleElementContext unconditionalRuleElement(int i) {
			return getRuleContext(UnconditionalRuleElementContext.class,i);
		}
		public List<TerminalNode> DOUBLE_COLON() { return getTokens(LscParser.DOUBLE_COLON); }
		public TerminalNode DOUBLE_COLON(int i) {
			return getToken(LscParser.DOUBLE_COLON, i);
		}
		public ReluctantOnsetContext reluctantOnset() {
			return getRuleContext(ReluctantOnsetContext.class,0);
		}
		public TerminalNode QMARK_COLON() { return getToken(LscParser.QMARK_COLON, 0); }
		public StructuredPatternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structuredPattern; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LscVisitor ) return ((LscVisitor<? extends T>)visitor).visitStructuredPattern(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StructuredPatternContext structuredPattern() throws RecognitionException {
		StructuredPatternContext _localctx = new StructuredPatternContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_structuredPattern);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(360);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
			case 1:
				{
				setState(357);
				reluctantOnset();
				setState(358);
				match(QMARK_COLON);
				}
				break;
			}
			setState(362);
			unconditionalRuleElement();
			setState(363);
			match(DOUBLE_COLON);
			setState(364);
			unconditionalRuleElement();
			setState(367);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DOUBLE_COLON) {
				{
				setState(365);
				match(DOUBLE_COLON);
				setState(366);
				unconditionalRuleElement();
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
	public static class ReluctantOnsetContext extends ParserRuleContext {
		public UnconditionalRuleElementContext unconditionalRuleElement() {
			return getRuleContext(UnconditionalRuleElementContext.class,0);
		}
		public ReluctantOnsetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_reluctantOnset; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LscVisitor ) return ((LscVisitor<? extends T>)visitor).visitReluctantOnset(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReluctantOnsetContext reluctantOnset() throws RecognitionException {
		ReluctantOnsetContext _localctx = new ReluctantOnsetContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_reluctantOnset);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(369);
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
		enterRule(_localctx, 36, RULE_deromanizer);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(371);
			match(DEROMANIZER);
			setState(374);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WHITESPACE) {
				{
				setState(372);
				match(WHITESPACE);
				setState(373);
				match(LITERAL);
				}
			}

			setState(376);
			match(RULE_START);
			setState(378); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(377);
				match(NEWLINE);
				}
				}
				setState(380); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NEWLINE );
			setState(382);
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
		enterRule(_localctx, 38, RULE_romanizer);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(384);
			match(ROMANIZER);
			setState(387);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WHITESPACE) {
				{
				setState(385);
				match(WHITESPACE);
				setState(386);
				match(LITERAL);
				}
			}

			setState(389);
			match(RULE_START);
			setState(391); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(390);
				match(NEWLINE);
				}
				}
				setState(393); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NEWLINE );
			setState(395);
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
		enterRule(_localctx, 40, RULE_interRomanizer);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(397);
			match(ROMANIZER);
			setState(398);
			match(HYPHEN);
			setState(399);
			ruleName();
			setState(402);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WHITESPACE) {
				{
				setState(400);
				match(WHITESPACE);
				setState(401);
				match(LITERAL);
				}
			}

			setState(404);
			match(RULE_START);
			setState(406); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(405);
				match(NEWLINE);
				}
				}
				setState(408); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NEWLINE );
			setState(410);
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
		enterRule(_localctx, 42, RULE_changeRule);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(412);
			ruleName();
			setState(417);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WHITESPACE) {
				{
				{
				setState(413);
				match(WHITESPACE);
				setState(414);
				changeRuleModifier();
				}
				}
				setState(419);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(421);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==RULE_START) {
				{
				setState(420);
				match(RULE_START);
				}
			}

			setState(424); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(423);
				match(NEWLINE);
				}
				}
				setState(426); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NEWLINE );
			setState(428);
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
		enterRule(_localctx, 44, RULE_filter);
		try {
			setState(432);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CLASSREF:
				enterOuterAlt(_localctx, 1);
				{
				setState(430);
				elementRef();
				}
				break;
			case MATRIX_START:
				enterOuterAlt(_localctx, 2);
				{
				setState(431);
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
		enterRule(_localctx, 46, RULE_block);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(434);
			blockElement();
			setState(454);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,45,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(436); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(435);
						match(NEWLINE);
						}
						}
						setState(438); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==NEWLINE );
					setState(440);
					blockType();
					setState(441);
					match(RULE_START);
					setState(448);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case WHITESPACE:
						{
						setState(442);
						match(WHITESPACE);
						}
						break;
					case NEWLINE:
						{
						setState(444); 
						_errHandler.sync(this);
						_la = _input.LA(1);
						do {
							{
							{
							setState(443);
							match(NEWLINE);
							}
							}
							setState(446); 
							_errHandler.sync(this);
							_la = _input.LA(1);
						} while ( _la==NEWLINE );
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(450);
					blockElement();
					}
					} 
				}
				setState(456);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,45,_ctx);
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
		enterRule(_localctx, 48, RULE_blockElement);
		int _la;
		try {
			setState(474);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,48,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(457);
				expressionList();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(458);
				match(O_PAREN);
				setState(462);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NEWLINE) {
					{
					{
					setState(459);
					match(NEWLINE);
					}
					}
					setState(464);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(465);
				block();
				setState(469);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NEWLINE) {
					{
					{
					setState(466);
					match(NEWLINE);
					}
					}
					setState(471);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(472);
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
		enterRule(_localctx, 50, RULE_blockType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(476);
			_la = _input.LA(1);
			if ( !(_la==ALL_MATCHING || _la==FIRST_MATCHING) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(481);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WHITESPACE) {
				{
				{
				setState(477);
				match(WHITESPACE);
				setState(478);
				changeRuleModifier();
				}
				}
				setState(483);
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
		enterRule(_localctx, 52, RULE_changeRuleModifier);
		try {
			setState(486);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case MATRIX_START:
			case CLASSREF:
				enterOuterAlt(_localctx, 1);
				{
				setState(484);
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
				setState(485);
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
		enterRule(_localctx, 54, RULE_keywordModifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(488);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 646266546527666176L) != 0)) ) {
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
		enterRule(_localctx, 56, RULE_expressionList);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(490);
			expression();
			setState(499);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,52,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(492); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(491);
						match(NEWLINE);
						}
						}
						setState(494); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==NEWLINE );
					setState(496);
					expression();
					}
					} 
				}
				setState(501);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,52,_ctx);
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
		enterRule(_localctx, 58, RULE_ruleName);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(502);
			name();
			setState(510);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==HYPHEN) {
				{
				{
				setState(503);
				match(HYPHEN);
				setState(506);
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
					setState(504);
					name();
					}
					break;
				case NUMBER:
					{
					setState(505);
					match(NUMBER);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				}
				setState(512);
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
		enterRule(_localctx, 60, RULE_expression);
		try {
			setState(516);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,55,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(513);
				keywordExpression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(514);
				blockRef();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(515);
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
		enterRule(_localctx, 62, RULE_keywordExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(518);
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
		enterRule(_localctx, 64, RULE_blockRef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(520);
			match(RULE_START);
			setState(521);
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
		enterRule(_localctx, 66, RULE_standardExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(523);
			from();
			setState(524);
			match(CHANGE);
			setState(525);
			to();
			setState(527);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CONDITION || _la==EXCLUSION) {
				{
				setState(526);
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
		enterRule(_localctx, 68, RULE_from);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(529);
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
		enterRule(_localctx, 70, RULE_to);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(531);
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
		enterRule(_localctx, 72, RULE_ruleElement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(533);
			unconditionalRuleElement();
			setState(535);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,57,_ctx) ) {
			case 1:
				{
				setState(534);
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
		enterRule(_localctx, 74, RULE_unconditionalRuleElement);
		try {
			setState(543);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,58,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(537);
				bounded();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(538);
				interfix();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(539);
				negated();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(540);
				postfix();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(541);
				simple();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(542);
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
		enterRule(_localctx, 76, RULE_bounded);
		try {
			setState(547);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case O_PAREN:
				enterOuterAlt(_localctx, 1);
				{
				setState(545);
				group();
				}
				break;
			case LIST_START:
				enterOuterAlt(_localctx, 2);
				{
				setState(546);
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
		enterRule(_localctx, 78, RULE_group);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(549);
			match(O_PAREN);
			setState(550);
			ruleElement();
			setState(551);
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
		enterRule(_localctx, 80, RULE_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(553);
			match(LIST_START);
			setState(554);
			ruleElement();
			setState(559);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LIST_SEP) {
				{
				{
				setState(555);
				match(LIST_SEP);
				setState(556);
				ruleElement();
				}
				}
				setState(561);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(562);
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
		enterRule(_localctx, 82, RULE_sequence);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(564);
			freeElement();
			setState(567); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(565);
					match(WHITESPACE);
					setState(566);
					freeElement();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(569); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,61,_ctx);
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
		enterRule(_localctx, 84, RULE_freeElement);
		try {
			setState(576);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,62,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(571);
				bounded();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(572);
				interfix();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(573);
				negated();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(574);
				postfix();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(575);
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
		enterRule(_localctx, 86, RULE_compoundEnvironment);
		try {
			setState(583);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,63,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(578);
				condition();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(579);
				exclusion();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				{
				setState(580);
				condition();
				setState(581);
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
		enterRule(_localctx, 88, RULE_condition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(585);
			match(CONDITION);
			setState(588);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,64,_ctx) ) {
			case 1:
				{
				setState(586);
				environment();
				}
				break;
			case 2:
				{
				setState(587);
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
		enterRule(_localctx, 90, RULE_exclusion);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(590);
			match(EXCLUSION);
			setState(593);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,65,_ctx) ) {
			case 1:
				{
				setState(591);
				environment();
				}
				break;
			case 2:
				{
				setState(592);
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
		enterRule(_localctx, 92, RULE_environmentList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(595);
			match(LIST_START);
			setState(596);
			environment();
			setState(601);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LIST_SEP) {
				{
				{
				setState(597);
				match(LIST_SEP);
				setState(598);
				environment();
				}
				}
				setState(603);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(604);
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
		enterRule(_localctx, 94, RULE_environment);
		int _la;
		try {
			setState(619);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,70,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(609);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4323453641877926912L) != 0)) {
					{
					setState(606);
					environmentBefore();
					setState(607);
					match(WHITESPACE);
					}
				}

				setState(611);
				match(ANCHOR);
				setState(614);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,68,_ctx) ) {
				case 1:
					{
					setState(612);
					match(WHITESPACE);
					setState(613);
					environmentAfter();
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(617);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4323453641877926912L) != 0)) {
					{
					setState(616);
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
		enterRule(_localctx, 96, RULE_environmentBefore);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(621);
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
		enterRule(_localctx, 98, RULE_environmentAfter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(623);
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
		enterRule(_localctx, 100, RULE_interfix);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(625);
			interfixElement();
			setState(629); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(626);
				interfixType();
				setState(627);
				interfixElement();
				}
				}
				setState(631); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 7516192768L) != 0) );
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 102, RULE_interfixType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(633);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 7516192768L) != 0)) ) {
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
		enterRule(_localctx, 104, RULE_interfixElement);
		try {
			setState(639);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,72,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(635);
				bounded();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(636);
				negated();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(637);
				postfix();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(638);
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
		enterRule(_localctx, 106, RULE_negated);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(641);
			match(NEGATION);
			setState(644);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case O_PAREN:
			case LIST_START:
				{
				setState(642);
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
				setState(643);
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
		enterRule(_localctx, 108, RULE_postfix);
		try {
			setState(648);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,74,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(646);
				capture();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(647);
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
		enterRule(_localctx, 110, RULE_capture);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(653);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case O_PAREN:
			case LIST_START:
				{
				setState(650);
				bounded();
				}
				break;
			case NEGATION:
				{
				setState(651);
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
				setState(652);
				simple();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(655);
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
		enterRule(_localctx, 112, RULE_repeater);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(659);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case O_PAREN:
			case LIST_START:
				{
				setState(657);
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
				setState(658);
				simple();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(661);
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
		enterRule(_localctx, 114, RULE_simple);
		try {
			setState(672);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,77,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(663);
				anySyllable();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(664);
				elementRef();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(665);
				captureRef();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(666);
				fancyMatrix();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(667);
				empty();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(668);
				sylBoundary();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(669);
				boundary();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(670);
				betweenWords();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(671);
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
		enterRule(_localctx, 116, RULE_anySyllable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(674);
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
		enterRule(_localctx, 118, RULE_elementRef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(676);
			match(CLASSREF);
			setState(677);
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
		enterRule(_localctx, 120, RULE_captureRef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(680);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==INEXACT) {
				{
				setState(679);
				match(INEXACT);
				}
			}

			setState(682);
			match(WORD_BOUNDARY);
			setState(684);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SYLLABLE_BOUNDARY) {
				{
				setState(683);
				match(SYLLABLE_BOUNDARY);
				}
			}

			setState(686);
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
		enterRule(_localctx, 122, RULE_fancyMatrix);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(688);
			match(MATRIX_START);
			setState(690);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 864653942797373440L) != 0)) {
				{
				setState(689);
				fancyValue();
				}
			}

			setState(696);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WHITESPACE) {
				{
				{
				setState(692);
				match(WHITESPACE);
				setState(693);
				fancyValue();
				}
				}
				setState(698);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(699);
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
		public PositiveValueContext positiveValue() {
			return getRuleContext(PositiveValueContext.class,0);
		}
		public TerminalNode NEGATION() { return getToken(LscParser.NEGATION, 0); }
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
		enterRule(_localctx, 124, RULE_fancyValue);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(702);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NEGATION) {
				{
				setState(701);
				match(NEGATION);
				}
			}

			setState(704);
			positiveValue();
			}
		}
		catch (RecognitionException re) {
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
	public static class PositiveValueContext extends ParserRuleContext {
		public MatrixValueContext matrixValue() {
			return getRuleContext(MatrixValueContext.class,0);
		}
		public AbsentFeatureContext absentFeature() {
			return getRuleContext(AbsentFeatureContext.class,0);
		}
		public FeatureVariableContext featureVariable() {
			return getRuleContext(FeatureVariableContext.class,0);
		}
		public PositiveValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_positiveValue; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LscVisitor ) return ((LscVisitor<? extends T>)visitor).visitPositiveValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PositiveValueContext positiveValue() throws RecognitionException {
		PositiveValueContext _localctx = new PositiveValueContext(_ctx, getState());
		enterRule(_localctx, 126, RULE_positiveValue);
		try {
			setState(709);
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
				setState(706);
				matrixValue();
				}
				break;
			case NULL:
				enterOuterAlt(_localctx, 2);
				{
				setState(707);
				absentFeature();
				}
				break;
			case WORD_BOUNDARY:
				enterOuterAlt(_localctx, 3);
				{
				setState(708);
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
		enterRule(_localctx, 128, RULE_absentFeature);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(711);
			match(NULL);
			setState(712);
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
		enterRule(_localctx, 130, RULE_featureVariable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(714);
			match(WORD_BOUNDARY);
			setState(715);
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
		enterRule(_localctx, 132, RULE_empty);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(717);
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
		enterRule(_localctx, 134, RULE_sylBoundary);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(719);
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
		enterRule(_localctx, 136, RULE_boundary);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(721);
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
		enterRule(_localctx, 138, RULE_betweenWords);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(723);
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
		enterRule(_localctx, 140, RULE_repeaterType);
		try {
			setState(729);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,84,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(725);
				repeatRange();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(726);
				match(AT_LEAST_ONE);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(727);
				match(NULL);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(728);
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
		enterRule(_localctx, 142, RULE_repeatRange);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(731);
			match(NULL);
			setState(742);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUMBER:
				{
				setState(732);
				match(NUMBER);
				}
				break;
			case O_PAREN:
				{
				{
				setState(733);
				match(O_PAREN);
				setState(735);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NUMBER) {
					{
					setState(734);
					lowerBound();
					}
				}

				setState(737);
				match(HYPHEN);
				setState(739);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NUMBER) {
					{
					setState(738);
					upperBound();
					}
				}

				setState(741);
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
		enterRule(_localctx, 144, RULE_lowerBound);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(744);
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
		enterRule(_localctx, 146, RULE_upperBound);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(746);
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
		enterRule(_localctx, 148, RULE_matrix);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(748);
			match(MATRIX_START);
			setState(750);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 864653942629597184L) != 0)) {
				{
				setState(749);
				matrixValue();
				}
			}

			setState(756);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WHITESPACE) {
				{
				{
				setState(752);
				match(WHITESPACE);
				setState(753);
				matrixValue();
				}
				}
				setState(758);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(759);
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
		enterRule(_localctx, 150, RULE_matrixValue);
		try {
			setState(763);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case AT_LEAST_ONE:
			case HYPHEN:
				enterOuterAlt(_localctx, 1);
				{
				setState(761);
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
				setState(762);
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
		enterRule(_localctx, 152, RULE_plusFeatureValue);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(765);
			_la = _input.LA(1);
			if ( !(_la==AT_LEAST_ONE || _la==HYPHEN) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(766);
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
		enterRule(_localctx, 154, RULE_featureValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(768);
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
		enterRule(_localctx, 156, RULE_text);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(773);
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
				setState(770);
				name();
				}
				break;
			case STR1:
				{
				setState(771);
				match(STR1);
				}
				break;
			case STR:
				{
				setState(772);
				match(STR);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(776);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NEGATION) {
				{
				setState(775);
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
		enterRule(_localctx, 158, RULE_name);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(778);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 864653942628286464L) != 0)) ) {
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
		"\u0004\u0001=\u030d\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
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
		"K\u0007K\u0002L\u0007L\u0002M\u0007M\u0002N\u0007N\u0002O\u0007O\u0001"+
		"\u0000\u0001\u0000\u0005\u0000\u00a3\b\u0000\n\u0000\f\u0000\u00a6\t\u0000"+
		"\u0003\u0000\u00a8\b\u0000\u0001\u0000\u0003\u0000\u00ab\b\u0000\u0001"+
		"\u0000\u0004\u0000\u00ae\b\u0000\u000b\u0000\f\u0000\u00af\u0001\u0000"+
		"\u0005\u0000\u00b3\b\u0000\n\u0000\f\u0000\u00b6\t\u0000\u0001\u0000\u0001"+
		"\u0000\u0005\u0000\u00ba\b\u0000\n\u0000\f\u0000\u00bd\t\u0000\u0003\u0000"+
		"\u00bf\b\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0003\u0001\u00ce\b\u0001\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0005\u0003\u00de\b\u0003\n\u0003\f\u0003\u00e1\t\u0003\u0001\u0003\u0003"+
		"\u0003\u00e4\b\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0003"+
		"\u0004\u00ea\b\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0005\u0005\u00f1\b\u0005\n\u0005\f\u0005\u00f4\t\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0003\u0005\u00f9\b\u0005\u0001\u0005\u0001\u0005"+
		"\u0003\u0005\u00fd\b\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0003\u0005\u0103\b\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0005\u0005"+
		"\u0108\b\u0005\n\u0005\f\u0005\u010b\t\u0005\u0001\u0005\u0001\u0005\u0003"+
		"\u0005\u010f\b\u0005\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0003\u0007\u0116\b\u0007\u0001\u0007\u0003\u0007\u0119\b\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0005\t\u0127\b\t\n\t\f\t\u012a\t\t"+
		"\u0001\t\u0001\t\u0001\t\u0005\t\u012f\b\t\n\t\f\t\u0132\t\t\u0001\n\u0001"+
		"\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0005\u000b"+
		"\u013b\b\u000b\n\u000b\f\u000b\u013e\t\u000b\u0001\u000b\u0001\u000b\u0003"+
		"\u000b\u0142\b\u000b\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0004\r\u0149"+
		"\b\r\u000b\r\f\r\u014a\u0001\r\u0001\r\u0004\r\u014f\b\r\u000b\r\f\r\u0150"+
		"\u0001\r\u0004\r\u0154\b\r\u000b\r\f\r\u0155\u0003\r\u0158\b\r\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0003\u000e\u015d\b\u000e\u0001\u000e\u0003\u000e"+
		"\u0160\b\u000e\u0001\u000f\u0001\u000f\u0003\u000f\u0164\b\u000f\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0003\u0010\u0169\b\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0003\u0010\u0170\b\u0010\u0001"+
		"\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0003\u0012\u0177"+
		"\b\u0012\u0001\u0012\u0001\u0012\u0004\u0012\u017b\b\u0012\u000b\u0012"+
		"\f\u0012\u017c\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0003\u0013\u0184\b\u0013\u0001\u0013\u0001\u0013\u0004\u0013\u0188\b"+
		"\u0013\u000b\u0013\f\u0013\u0189\u0001\u0013\u0001\u0013\u0001\u0014\u0001"+
		"\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0003\u0014\u0193\b\u0014\u0001"+
		"\u0014\u0001\u0014\u0004\u0014\u0197\b\u0014\u000b\u0014\f\u0014\u0198"+
		"\u0001\u0014\u0001\u0014\u0001\u0015\u0001\u0015\u0001\u0015\u0005\u0015"+
		"\u01a0\b\u0015\n\u0015\f\u0015\u01a3\t\u0015\u0001\u0015\u0003\u0015\u01a6"+
		"\b\u0015\u0001\u0015\u0004\u0015\u01a9\b\u0015\u000b\u0015\f\u0015\u01aa"+
		"\u0001\u0015\u0001\u0015\u0001\u0016\u0001\u0016\u0003\u0016\u01b1\b\u0016"+
		"\u0001\u0017\u0001\u0017\u0004\u0017\u01b5\b\u0017\u000b\u0017\f\u0017"+
		"\u01b6\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0004\u0017\u01bd"+
		"\b\u0017\u000b\u0017\f\u0017\u01be\u0003\u0017\u01c1\b\u0017\u0001\u0017"+
		"\u0001\u0017\u0005\u0017\u01c5\b\u0017\n\u0017\f\u0017\u01c8\t\u0017\u0001"+
		"\u0018\u0001\u0018\u0001\u0018\u0005\u0018\u01cd\b\u0018\n\u0018\f\u0018"+
		"\u01d0\t\u0018\u0001\u0018\u0001\u0018\u0005\u0018\u01d4\b\u0018\n\u0018"+
		"\f\u0018\u01d7\t\u0018\u0001\u0018\u0001\u0018\u0003\u0018\u01db\b\u0018"+
		"\u0001\u0019\u0001\u0019\u0001\u0019\u0005\u0019\u01e0\b\u0019\n\u0019"+
		"\f\u0019\u01e3\t\u0019\u0001\u001a\u0001\u001a\u0003\u001a\u01e7\b\u001a"+
		"\u0001\u001b\u0001\u001b\u0001\u001c\u0001\u001c\u0004\u001c\u01ed\b\u001c"+
		"\u000b\u001c\f\u001c\u01ee\u0001\u001c\u0005\u001c\u01f2\b\u001c\n\u001c"+
		"\f\u001c\u01f5\t\u001c\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d"+
		"\u0003\u001d\u01fb\b\u001d\u0005\u001d\u01fd\b\u001d\n\u001d\f\u001d\u0200"+
		"\t\u001d\u0001\u001e\u0001\u001e\u0001\u001e\u0003\u001e\u0205\b\u001e"+
		"\u0001\u001f\u0001\u001f\u0001 \u0001 \u0001 \u0001!\u0001!\u0001!\u0001"+
		"!\u0003!\u0210\b!\u0001\"\u0001\"\u0001#\u0001#\u0001$\u0001$\u0003$\u0218"+
		"\b$\u0001%\u0001%\u0001%\u0001%\u0001%\u0001%\u0003%\u0220\b%\u0001&\u0001"+
		"&\u0003&\u0224\b&\u0001\'\u0001\'\u0001\'\u0001\'\u0001(\u0001(\u0001"+
		"(\u0001(\u0005(\u022e\b(\n(\f(\u0231\t(\u0001(\u0001(\u0001)\u0001)\u0001"+
		")\u0004)\u0238\b)\u000b)\f)\u0239\u0001*\u0001*\u0001*\u0001*\u0001*\u0003"+
		"*\u0241\b*\u0001+\u0001+\u0001+\u0001+\u0001+\u0003+\u0248\b+\u0001,\u0001"+
		",\u0001,\u0003,\u024d\b,\u0001-\u0001-\u0001-\u0003-\u0252\b-\u0001.\u0001"+
		".\u0001.\u0001.\u0005.\u0258\b.\n.\f.\u025b\t.\u0001.\u0001.\u0001/\u0001"+
		"/\u0001/\u0003/\u0262\b/\u0001/\u0001/\u0001/\u0003/\u0267\b/\u0001/\u0003"+
		"/\u026a\b/\u0003/\u026c\b/\u00010\u00010\u00011\u00011\u00012\u00012\u0001"+
		"2\u00012\u00042\u0276\b2\u000b2\f2\u0277\u00013\u00013\u00014\u00014\u0001"+
		"4\u00014\u00034\u0280\b4\u00015\u00015\u00015\u00035\u0285\b5\u00016\u0001"+
		"6\u00036\u0289\b6\u00017\u00017\u00017\u00037\u028e\b7\u00017\u00017\u0001"+
		"8\u00018\u00038\u0294\b8\u00018\u00018\u00019\u00019\u00019\u00019\u0001"+
		"9\u00019\u00019\u00019\u00019\u00039\u02a1\b9\u0001:\u0001:\u0001;\u0001"+
		";\u0001;\u0001<\u0003<\u02a9\b<\u0001<\u0001<\u0003<\u02ad\b<\u0001<\u0001"+
		"<\u0001=\u0001=\u0003=\u02b3\b=\u0001=\u0001=\u0005=\u02b7\b=\n=\f=\u02ba"+
		"\t=\u0001=\u0001=\u0001>\u0003>\u02bf\b>\u0001>\u0001>\u0001?\u0001?\u0001"+
		"?\u0003?\u02c6\b?\u0001@\u0001@\u0001@\u0001A\u0001A\u0001A\u0001B\u0001"+
		"B\u0001C\u0001C\u0001D\u0001D\u0001E\u0001E\u0001F\u0001F\u0001F\u0001"+
		"F\u0003F\u02da\bF\u0001G\u0001G\u0001G\u0001G\u0003G\u02e0\bG\u0001G\u0001"+
		"G\u0003G\u02e4\bG\u0001G\u0003G\u02e7\bG\u0001H\u0001H\u0001I\u0001I\u0001"+
		"J\u0001J\u0003J\u02ef\bJ\u0001J\u0001J\u0005J\u02f3\bJ\nJ\fJ\u02f6\tJ"+
		"\u0001J\u0001J\u0001K\u0001K\u0003K\u02fc\bK\u0001L\u0001L\u0001L\u0001"+
		"M\u0001M\u0001N\u0001N\u0001N\u0003N\u0306\bN\u0001N\u0003N\u0309\bN\u0001"+
		"O\u0001O\u0001O\u0000\u0000P\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010"+
		"\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,.02468:<>@BDFHJLNPR"+
		"TVXZ\\^`bdfhjlnprtvxz|~\u0080\u0082\u0084\u0086\u0088\u008a\u008c\u008e"+
		"\u0090\u0092\u0094\u0096\u0098\u009a\u009c\u009e\u0000\u000b\u0001\u0000"+
		"\u000f\u0010\u0001\u0000\u0002\u0003\u0002\u0000\u0003\u0003\b\b\u0001"+
		"\u0000&(\u0001\u0000+,\u0001\u000001\u0002\u000037;;\u0001\u000089\u0001"+
		"\u0000\u001e \u0002\u0000\u0012\u0012\u0014\u0014\u0005\u0000!#%%),.9"+
		";;\u0339\u0000\u00a7\u0001\u0000\u0000\u0000\u0002\u00cd\u0001\u0000\u0000"+
		"\u0000\u0004\u00cf\u0001\u0000\u0000\u0000\u0006\u00d5\u0001\u0000\u0000"+
		"\u0000\b\u00e9\u0001\u0000\u0000\u0000\n\u00eb\u0001\u0000\u0000\u0000"+
		"\f\u0110\u0001\u0000\u0000\u0000\u000e\u0115\u0001\u0000\u0000\u0000\u0010"+
		"\u011c\u0001\u0000\u0000\u0000\u0012\u011f\u0001\u0000\u0000\u0000\u0014"+
		"\u0133\u0001\u0000\u0000\u0000\u0016\u0135\u0001\u0000\u0000\u0000\u0018"+
		"\u0143\u0001\u0000\u0000\u0000\u001a\u0145\u0001\u0000\u0000\u0000\u001c"+
		"\u0159\u0001\u0000\u0000\u0000\u001e\u0163\u0001\u0000\u0000\u0000 \u0168"+
		"\u0001\u0000\u0000\u0000\"\u0171\u0001\u0000\u0000\u0000$\u0173\u0001"+
		"\u0000\u0000\u0000&\u0180\u0001\u0000\u0000\u0000(\u018d\u0001\u0000\u0000"+
		"\u0000*\u019c\u0001\u0000\u0000\u0000,\u01b0\u0001\u0000\u0000\u0000."+
		"\u01b2\u0001\u0000\u0000\u00000\u01da\u0001\u0000\u0000\u00002\u01dc\u0001"+
		"\u0000\u0000\u00004\u01e6\u0001\u0000\u0000\u00006\u01e8\u0001\u0000\u0000"+
		"\u00008\u01ea\u0001\u0000\u0000\u0000:\u01f6\u0001\u0000\u0000\u0000<"+
		"\u0204\u0001\u0000\u0000\u0000>\u0206\u0001\u0000\u0000\u0000@\u0208\u0001"+
		"\u0000\u0000\u0000B\u020b\u0001\u0000\u0000\u0000D\u0211\u0001\u0000\u0000"+
		"\u0000F\u0213\u0001\u0000\u0000\u0000H\u0215\u0001\u0000\u0000\u0000J"+
		"\u021f\u0001\u0000\u0000\u0000L\u0223\u0001\u0000\u0000\u0000N\u0225\u0001"+
		"\u0000\u0000\u0000P\u0229\u0001\u0000\u0000\u0000R\u0234\u0001\u0000\u0000"+
		"\u0000T\u0240\u0001\u0000\u0000\u0000V\u0247\u0001\u0000\u0000\u0000X"+
		"\u0249\u0001\u0000\u0000\u0000Z\u024e\u0001\u0000\u0000\u0000\\\u0253"+
		"\u0001\u0000\u0000\u0000^\u026b\u0001\u0000\u0000\u0000`\u026d\u0001\u0000"+
		"\u0000\u0000b\u026f\u0001\u0000\u0000\u0000d\u0271\u0001\u0000\u0000\u0000"+
		"f\u0279\u0001\u0000\u0000\u0000h\u027f\u0001\u0000\u0000\u0000j\u0281"+
		"\u0001\u0000\u0000\u0000l\u0288\u0001\u0000\u0000\u0000n\u028d\u0001\u0000"+
		"\u0000\u0000p\u0293\u0001\u0000\u0000\u0000r\u02a0\u0001\u0000\u0000\u0000"+
		"t\u02a2\u0001\u0000\u0000\u0000v\u02a4\u0001\u0000\u0000\u0000x\u02a8"+
		"\u0001\u0000\u0000\u0000z\u02b0\u0001\u0000\u0000\u0000|\u02be\u0001\u0000"+
		"\u0000\u0000~\u02c5\u0001\u0000\u0000\u0000\u0080\u02c7\u0001\u0000\u0000"+
		"\u0000\u0082\u02ca\u0001\u0000\u0000\u0000\u0084\u02cd\u0001\u0000\u0000"+
		"\u0000\u0086\u02cf\u0001\u0000\u0000\u0000\u0088\u02d1\u0001\u0000\u0000"+
		"\u0000\u008a\u02d3\u0001\u0000\u0000\u0000\u008c\u02d9\u0001\u0000\u0000"+
		"\u0000\u008e\u02db\u0001\u0000\u0000\u0000\u0090\u02e8\u0001\u0000\u0000"+
		"\u0000\u0092\u02ea\u0001\u0000\u0000\u0000\u0094\u02ec\u0001\u0000\u0000"+
		"\u0000\u0096\u02fb\u0001\u0000\u0000\u0000\u0098\u02fd\u0001\u0000\u0000"+
		"\u0000\u009a\u0300\u0001\u0000\u0000\u0000\u009c\u0305\u0001\u0000\u0000"+
		"\u0000\u009e\u030a\u0001\u0000\u0000\u0000\u00a0\u00a8\u0005\t\u0000\u0000"+
		"\u00a1\u00a3\u0005\b\u0000\u0000\u00a2\u00a1\u0001\u0000\u0000\u0000\u00a3"+
		"\u00a6\u0001\u0000\u0000\u0000\u00a4\u00a2\u0001\u0000\u0000\u0000\u00a4"+
		"\u00a5\u0001\u0000\u0000\u0000\u00a5\u00a8\u0001\u0000\u0000\u0000\u00a6"+
		"\u00a4\u0001\u0000\u0000\u0000\u00a7\u00a0\u0001\u0000\u0000\u0000\u00a7"+
		"\u00a4\u0001\u0000\u0000\u0000\u00a8\u00aa\u0001\u0000\u0000\u0000\u00a9"+
		"\u00ab\u0003\u0002\u0001\u0000\u00aa\u00a9\u0001\u0000\u0000\u0000\u00aa"+
		"\u00ab\u0001\u0000\u0000\u0000\u00ab\u00b4\u0001\u0000\u0000\u0000\u00ac"+
		"\u00ae\u0005\b\u0000\u0000\u00ad\u00ac\u0001\u0000\u0000\u0000\u00ae\u00af"+
		"\u0001\u0000\u0000\u0000\u00af\u00ad\u0001\u0000\u0000\u0000\u00af\u00b0"+
		"\u0001\u0000\u0000\u0000\u00b0\u00b1\u0001\u0000\u0000\u0000\u00b1\u00b3"+
		"\u0003\u0002\u0001\u0000\u00b2\u00ad\u0001\u0000\u0000\u0000\u00b3\u00b6"+
		"\u0001\u0000\u0000\u0000\u00b4\u00b2\u0001\u0000\u0000\u0000\u00b4\u00b5"+
		"\u0001\u0000\u0000\u0000\u00b5\u00be\u0001\u0000\u0000\u0000\u00b6\u00b4"+
		"\u0001\u0000\u0000\u0000\u00b7\u00bf\u0005\t\u0000\u0000\u00b8\u00ba\u0005"+
		"\b\u0000\u0000\u00b9\u00b8\u0001\u0000\u0000\u0000\u00ba\u00bd\u0001\u0000"+
		"\u0000\u0000\u00bb\u00b9\u0001\u0000\u0000\u0000\u00bb\u00bc\u0001\u0000"+
		"\u0000\u0000\u00bc\u00bf\u0001\u0000\u0000\u0000\u00bd\u00bb\u0001\u0000"+
		"\u0000\u0000\u00be\u00b7\u0001\u0000\u0000\u0000\u00be\u00bb\u0001\u0000"+
		"\u0000\u0000\u00bf\u00c0\u0001\u0000\u0000\u0000\u00c0\u00c1\u0005\u0000"+
		"\u0000\u0001\u00c1\u0001\u0001\u0000\u0000\u0000\u00c2\u00ce\u0003\n\u0005"+
		"\u0000\u00c3\u00ce\u0003\u0012\t\u0000\u00c4\u00ce\u0003\u0016\u000b\u0000"+
		"\u00c5\u00ce\u0003\u0006\u0003\u0000\u00c6\u00ce\u0003\u0004\u0002\u0000"+
		"\u00c7\u00ce\u0003\u001a\r\u0000\u00c8\u00ce\u0003$\u0012\u0000\u00c9"+
		"\u00ce\u0003(\u0014\u0000\u00ca\u00ce\u0003&\u0013\u0000\u00cb\u00ce\u0003"+
		"*\u0015\u0000\u00cc\u00ce\u0003B!\u0000\u00cd\u00c2\u0001\u0000\u0000"+
		"\u0000\u00cd\u00c3\u0001\u0000\u0000\u0000\u00cd\u00c4\u0001\u0000\u0000"+
		"\u0000\u00cd\u00c5\u0001\u0000\u0000\u0000\u00cd\u00c6\u0001\u0000\u0000"+
		"\u0000\u00cd\u00c7\u0001\u0000\u0000\u0000\u00cd\u00c8\u0001\u0000\u0000"+
		"\u0000\u00cd\u00c9\u0001\u0000\u0000\u0000\u00cd\u00ca\u0001\u0000\u0000"+
		"\u0000\u00cd\u00cb\u0001\u0000\u0000\u0000\u00cd\u00cc\u0001\u0000\u0000"+
		"\u0000\u00ce\u0003\u0001\u0000\u0000\u0000\u00cf\u00d0\u0005!\u0000\u0000"+
		"\u00d0\u00d1\u0005\t\u0000\u0000\u00d1\u00d2\u0003\u009eO\u0000\u00d2"+
		"\u00d3\u0005\t\u0000\u0000\u00d3\u00d4\u0003H$\u0000\u00d4\u0005\u0001"+
		"\u0000\u0000\u0000\u00d5\u00d6\u0005\"\u0000\u0000\u00d6\u00d7\u0005\t"+
		"\u0000\u0000\u00d7\u00d8\u0003\u009eO\u0000\u00d8\u00d9\u0005\t\u0000"+
		"\u0000\u00d9\u00da\u0007\u0000\u0000\u0000\u00da\u00df\u0003\b\u0004\u0000"+
		"\u00db\u00dc\u0007\u0001\u0000\u0000\u00dc\u00de\u0003\b\u0004\u0000\u00dd"+
		"\u00db\u0001\u0000\u0000\u0000\u00de\u00e1\u0001\u0000\u0000\u0000\u00df"+
		"\u00dd\u0001\u0000\u0000\u0000\u00df\u00e0\u0001\u0000\u0000\u0000\u00e0"+
		"\u00e3\u0001\u0000\u0000\u0000\u00e1\u00df\u0001\u0000\u0000\u0000\u00e2"+
		"\u00e4\u0007\u0002\u0000\u0000\u00e3\u00e2\u0001\u0000\u0000\u0000\u00e3"+
		"\u00e4\u0001\u0000\u0000\u0000\u00e4\u00e5\u0001\u0000\u0000\u0000\u00e5"+
		"\u00e6\u0005\u0011\u0000\u0000\u00e6\u0007\u0001\u0000\u0000\u0000\u00e7"+
		"\u00ea\u0003v;\u0000\u00e8\u00ea\u0003\u009cN\u0000\u00e9\u00e7\u0001"+
		"\u0000\u0000\u0000\u00e9\u00e8\u0001\u0000\u0000\u0000\u00ea\t\u0001\u0000"+
		"\u0000\u0000\u00eb\u00ec\u0005#\u0000\u0000\u00ec\u010e\u0005\t\u0000"+
		"\u0000\u00ed\u00f2\u0003\u000e\u0007\u0000\u00ee\u00ef\u0005\u0002\u0000"+
		"\u0000\u00ef\u00f1\u0003\u000e\u0007\u0000\u00f0\u00ee\u0001\u0000\u0000"+
		"\u0000\u00f1\u00f4\u0001\u0000\u0000\u0000\u00f2\u00f0\u0001\u0000\u0000"+
		"\u0000\u00f2\u00f3\u0001\u0000\u0000\u0000\u00f3\u010f\u0001\u0000\u0000"+
		"\u0000\u00f4\u00f2\u0001\u0000\u0000\u0000\u00f5\u00f6\u0003\f\u0006\u0000"+
		"\u00f6\u00f7\u0005\t\u0000\u0000\u00f7\u00f9\u0001\u0000\u0000\u0000\u00f8"+
		"\u00f5\u0001\u0000\u0000\u0000\u00f8\u00f9\u0001\u0000\u0000\u0000\u00f9"+
		"\u00fa\u0001\u0000\u0000\u0000\u00fa\u00fc\u0003\u009eO\u0000\u00fb\u00fd"+
		"\u0005\t\u0000\u0000\u00fc\u00fb\u0001\u0000\u0000\u0000\u00fc\u00fd\u0001"+
		"\u0000\u0000\u0000\u00fd\u00fe\u0001\u0000\u0000\u0000\u00fe\u0102\u0005"+
		"\n\u0000\u0000\u00ff\u0100\u0003\u0010\b\u0000\u0100\u0101\u0005\u0002"+
		"\u0000\u0000\u0101\u0103\u0001\u0000\u0000\u0000\u0102\u00ff\u0001\u0000"+
		"\u0000\u0000\u0102\u0103\u0001\u0000\u0000\u0000\u0103\u0104\u0001\u0000"+
		"\u0000\u0000\u0104\u0109\u0003\u009aM\u0000\u0105\u0106\u0005\u0002\u0000"+
		"\u0000\u0106\u0108\u0003\u009aM\u0000\u0107\u0105\u0001\u0000\u0000\u0000"+
		"\u0108\u010b\u0001\u0000\u0000\u0000\u0109\u0107\u0001\u0000\u0000\u0000"+
		"\u0109\u010a\u0001\u0000\u0000\u0000\u010a\u010c\u0001\u0000\u0000\u0000"+
		"\u010b\u0109\u0001\u0000\u0000\u0000\u010c\u010d\u0005\u000b\u0000\u0000"+
		"\u010d\u010f\u0001\u0000\u0000\u0000\u010e\u00ed\u0001\u0000\u0000\u0000"+
		"\u010e\u00f8\u0001\u0000\u0000\u0000\u010f\u000b\u0001\u0000\u0000\u0000"+
		"\u0110\u0111\u0005$\u0000\u0000\u0111\r\u0001\u0000\u0000\u0000\u0112"+
		"\u0113\u0003\f\u0006\u0000\u0113\u0114\u0005\t\u0000\u0000\u0114\u0116"+
		"\u0001\u0000\u0000\u0000\u0115\u0112\u0001\u0000\u0000\u0000\u0115\u0116"+
		"\u0001\u0000\u0000\u0000\u0116\u0118\u0001\u0000\u0000\u0000\u0117\u0119"+
		"\u0005\u0012\u0000\u0000\u0118\u0117\u0001\u0000\u0000\u0000\u0118\u0119"+
		"\u0001\u0000\u0000\u0000\u0119\u011a\u0001\u0000\u0000\u0000\u011a\u011b"+
		"\u0003\u009eO\u0000\u011b\u000f\u0001\u0000\u0000\u0000\u011c\u011d\u0005"+
		"\f\u0000\u0000\u011d\u011e\u0003\u009aM\u0000\u011e\u0011\u0001\u0000"+
		"\u0000\u0000\u011f\u0120\u0005%\u0000\u0000\u0120\u0121\u0005\t\u0000"+
		"\u0000\u0121\u0122\u0003\u009cN\u0000\u0122\u0128\u0005\t\u0000\u0000"+
		"\u0123\u0124\u0003\u0014\n\u0000\u0124\u0125\u0005\t\u0000\u0000\u0125"+
		"\u0127\u0001\u0000\u0000\u0000\u0126\u0123\u0001\u0000\u0000\u0000\u0127"+
		"\u012a\u0001\u0000\u0000\u0000\u0128\u0126\u0001\u0000\u0000\u0000\u0128"+
		"\u0129\u0001\u0000\u0000\u0000\u0129\u012b\u0001\u0000\u0000\u0000\u012a"+
		"\u0128\u0001\u0000\u0000\u0000\u012b\u0130\u0003\u0094J\u0000\u012c\u012d"+
		"\u0005\t\u0000\u0000\u012d\u012f\u0003\u0014\n\u0000\u012e\u012c\u0001"+
		"\u0000\u0000\u0000\u012f\u0132\u0001\u0000\u0000\u0000\u0130\u012e\u0001"+
		"\u0000\u0000\u0000\u0130\u0131\u0001\u0000\u0000\u0000\u0131\u0013\u0001"+
		"\u0000\u0000\u0000\u0132\u0130\u0001\u0000\u0000\u0000\u0133\u0134\u0007"+
		"\u0003\u0000\u0000\u0134\u0015\u0001\u0000\u0000\u0000\u0135\u0136\u0005"+
		")\u0000\u0000\u0136\u0137\u0005\t\u0000\u0000\u0137\u0141\u0003\u0018"+
		"\f\u0000\u0138\u0139\u0005\u0002\u0000\u0000\u0139\u013b\u0003\u0018\f"+
		"\u0000\u013a\u0138\u0001\u0000\u0000\u0000\u013b\u013e\u0001\u0000\u0000"+
		"\u0000\u013c\u013a\u0001\u0000\u0000\u0000\u013c\u013d\u0001\u0000\u0000"+
		"\u0000\u013d\u0142\u0001\u0000\u0000\u0000\u013e\u013c\u0001\u0000\u0000"+
		"\u0000\u013f\u0140\u0005\t\u0000\u0000\u0140\u0142\u0003\u0094J\u0000"+
		"\u0141\u013c\u0001\u0000\u0000\u0000\u0141\u013f\u0001\u0000\u0000\u0000"+
		"\u0142\u0017\u0001\u0000\u0000\u0000\u0143\u0144\u0003\u009cN\u0000\u0144"+
		"\u0019\u0001\u0000\u0000\u0000\u0145\u0146\u0005*\u0000\u0000\u0146\u0157"+
		"\u0005\u0015\u0000\u0000\u0147\u0149\u0005\b\u0000\u0000\u0148\u0147\u0001"+
		"\u0000\u0000\u0000\u0149\u014a\u0001\u0000\u0000\u0000\u014a\u0148\u0001"+
		"\u0000\u0000\u0000\u014a\u014b\u0001\u0000\u0000\u0000\u014b\u014c\u0001"+
		"\u0000\u0000\u0000\u014c\u0158\u0007\u0004\u0000\u0000\u014d\u014f\u0005"+
		"\b\u0000\u0000\u014e\u014d\u0001\u0000\u0000\u0000\u014f\u0150\u0001\u0000"+
		"\u0000\u0000\u0150\u014e\u0001\u0000\u0000\u0000\u0150\u0151\u0001\u0000"+
		"\u0000\u0000\u0151\u0152\u0001\u0000\u0000\u0000\u0152\u0154\u0003\u001c"+
		"\u000e\u0000\u0153\u014e\u0001\u0000\u0000\u0000\u0154\u0155\u0001\u0000"+
		"\u0000\u0000\u0155\u0153\u0001\u0000\u0000\u0000\u0155\u0156\u0001\u0000"+
		"\u0000\u0000\u0156\u0158\u0001\u0000\u0000\u0000\u0157\u0148\u0001\u0000"+
		"\u0000\u0000\u0157\u0153\u0001\u0000\u0000\u0000\u0158\u001b\u0001\u0000"+
		"\u0000\u0000\u0159\u015c\u0003\u001e\u000f\u0000\u015a\u015b\u0005\u0004"+
		"\u0000\u0000\u015b\u015d\u0003\u0094J\u0000\u015c\u015a\u0001\u0000\u0000"+
		"\u0000\u015c\u015d\u0001\u0000\u0000\u0000\u015d\u015f\u0001\u0000\u0000"+
		"\u0000\u015e\u0160\u0003V+\u0000\u015f\u015e\u0001\u0000\u0000\u0000\u015f"+
		"\u0160\u0001\u0000\u0000\u0000\u0160\u001d\u0001\u0000\u0000\u0000\u0161"+
		"\u0164\u0003 \u0010\u0000\u0162\u0164\u0003H$\u0000\u0163\u0161\u0001"+
		"\u0000\u0000\u0000\u0163\u0162\u0001\u0000\u0000\u0000\u0164\u001f\u0001"+
		"\u0000\u0000\u0000\u0165\u0166\u0003\"\u0011\u0000\u0166\u0167\u0005\u0017"+
		"\u0000\u0000\u0167\u0169\u0001\u0000\u0000\u0000\u0168\u0165\u0001\u0000"+
		"\u0000\u0000\u0168\u0169\u0001\u0000\u0000\u0000\u0169\u016a\u0001\u0000"+
		"\u0000\u0000\u016a\u016b\u0003J%\u0000\u016b\u016c\u0005\u0016\u0000\u0000"+
		"\u016c\u016f\u0003J%\u0000\u016d\u016e\u0005\u0016\u0000\u0000\u016e\u0170"+
		"\u0003J%\u0000\u016f\u016d\u0001\u0000\u0000\u0000\u016f\u0170\u0001\u0000"+
		"\u0000\u0000\u0170!\u0001\u0000\u0000\u0000\u0171\u0172\u0003J%\u0000"+
		"\u0172#\u0001\u0000\u0000\u0000\u0173\u0176\u0005.\u0000\u0000\u0174\u0175"+
		"\u0005\t\u0000\u0000\u0175\u0177\u00052\u0000\u0000\u0176\u0174\u0001"+
		"\u0000\u0000\u0000\u0176\u0177\u0001\u0000\u0000\u0000\u0177\u0178\u0001"+
		"\u0000\u0000\u0000\u0178\u017a\u0005\u0015\u0000\u0000\u0179\u017b\u0005"+
		"\b\u0000\u0000\u017a\u0179\u0001\u0000\u0000\u0000\u017b\u017c\u0001\u0000"+
		"\u0000\u0000\u017c\u017a\u0001\u0000\u0000\u0000\u017c\u017d\u0001\u0000"+
		"\u0000\u0000\u017d\u017e\u0001\u0000\u0000\u0000\u017e\u017f\u0003.\u0017"+
		"\u0000\u017f%\u0001\u0000\u0000\u0000\u0180\u0183\u0005/\u0000\u0000\u0181"+
		"\u0182\u0005\t\u0000\u0000\u0182\u0184\u00052\u0000\u0000\u0183\u0181"+
		"\u0001\u0000\u0000\u0000\u0183\u0184\u0001\u0000\u0000\u0000\u0184\u0185"+
		"\u0001\u0000\u0000\u0000\u0185\u0187\u0005\u0015\u0000\u0000\u0186\u0188"+
		"\u0005\b\u0000\u0000\u0187\u0186\u0001\u0000\u0000\u0000\u0188\u0189\u0001"+
		"\u0000\u0000\u0000\u0189\u0187\u0001\u0000\u0000\u0000\u0189\u018a\u0001"+
		"\u0000\u0000\u0000\u018a\u018b\u0001\u0000\u0000\u0000\u018b\u018c\u0003"+
		".\u0017\u0000\u018c\'\u0001\u0000\u0000\u0000\u018d\u018e\u0005/\u0000"+
		"\u0000\u018e\u018f\u0005\u0014\u0000\u0000\u018f\u0192\u0003:\u001d\u0000"+
		"\u0190\u0191\u0005\t\u0000\u0000\u0191\u0193\u00052\u0000\u0000\u0192"+
		"\u0190\u0001\u0000\u0000\u0000\u0192\u0193\u0001\u0000\u0000\u0000\u0193"+
		"\u0194\u0001\u0000\u0000\u0000\u0194\u0196\u0005\u0015\u0000\u0000\u0195"+
		"\u0197\u0005\b\u0000\u0000\u0196\u0195\u0001\u0000\u0000\u0000\u0197\u0198"+
		"\u0001\u0000\u0000\u0000\u0198\u0196\u0001\u0000\u0000\u0000\u0198\u0199"+
		"\u0001\u0000\u0000\u0000\u0199\u019a\u0001\u0000\u0000\u0000\u019a\u019b"+
		"\u0003.\u0017\u0000\u019b)\u0001\u0000\u0000\u0000\u019c\u01a1\u0003:"+
		"\u001d\u0000\u019d\u019e\u0005\t\u0000\u0000\u019e\u01a0\u00034\u001a"+
		"\u0000\u019f\u019d\u0001\u0000\u0000\u0000\u01a0\u01a3\u0001\u0000\u0000"+
		"\u0000\u01a1\u019f\u0001\u0000\u0000\u0000\u01a1\u01a2\u0001\u0000\u0000"+
		"\u0000\u01a2\u01a5\u0001\u0000\u0000\u0000\u01a3\u01a1\u0001\u0000\u0000"+
		"\u0000\u01a4\u01a6\u0005\u0015\u0000\u0000\u01a5\u01a4\u0001\u0000\u0000"+
		"\u0000\u01a5\u01a6\u0001\u0000\u0000\u0000\u01a6\u01a8\u0001\u0000\u0000"+
		"\u0000\u01a7\u01a9\u0005\b\u0000\u0000\u01a8\u01a7\u0001\u0000\u0000\u0000"+
		"\u01a9\u01aa\u0001\u0000\u0000\u0000\u01aa\u01a8\u0001\u0000\u0000\u0000"+
		"\u01aa\u01ab\u0001\u0000\u0000\u0000\u01ab\u01ac\u0001\u0000\u0000\u0000"+
		"\u01ac\u01ad\u0003.\u0017\u0000\u01ad+\u0001\u0000\u0000\u0000\u01ae\u01b1"+
		"\u0003v;\u0000\u01af\u01b1\u0003z=\u0000\u01b0\u01ae\u0001\u0000\u0000"+
		"\u0000\u01b0\u01af\u0001\u0000\u0000\u0000\u01b1-\u0001\u0000\u0000\u0000"+
		"\u01b2\u01c6\u00030\u0018\u0000\u01b3\u01b5\u0005\b\u0000\u0000\u01b4"+
		"\u01b3\u0001\u0000\u0000\u0000\u01b5\u01b6\u0001\u0000\u0000\u0000\u01b6"+
		"\u01b4\u0001\u0000\u0000\u0000\u01b6\u01b7\u0001\u0000\u0000\u0000\u01b7"+
		"\u01b8\u0001\u0000\u0000\u0000\u01b8\u01b9\u00032\u0019\u0000\u01b9\u01c0"+
		"\u0005\u0015\u0000\u0000\u01ba\u01c1\u0005\t\u0000\u0000\u01bb\u01bd\u0005"+
		"\b\u0000\u0000\u01bc\u01bb\u0001\u0000\u0000\u0000\u01bd\u01be\u0001\u0000"+
		"\u0000\u0000\u01be\u01bc\u0001\u0000\u0000\u0000\u01be\u01bf\u0001\u0000"+
		"\u0000\u0000\u01bf\u01c1\u0001\u0000\u0000\u0000\u01c0\u01ba\u0001\u0000"+
		"\u0000\u0000\u01c0\u01bc\u0001\u0000\u0000\u0000\u01c1\u01c2\u0001\u0000"+
		"\u0000\u0000\u01c2\u01c3\u00030\u0018\u0000\u01c3\u01c5\u0001\u0000\u0000"+
		"\u0000\u01c4\u01b4\u0001\u0000\u0000\u0000\u01c5\u01c8\u0001\u0000\u0000"+
		"\u0000\u01c6\u01c4\u0001\u0000\u0000\u0000\u01c6\u01c7\u0001\u0000\u0000"+
		"\u0000\u01c7/\u0001\u0000\u0000\u0000\u01c8\u01c6\u0001\u0000\u0000\u0000"+
		"\u01c9\u01db\u00038\u001c\u0000\u01ca\u01ce\u0005\n\u0000\u0000\u01cb"+
		"\u01cd\u0005\b\u0000\u0000\u01cc\u01cb\u0001\u0000\u0000\u0000\u01cd\u01d0"+
		"\u0001\u0000\u0000\u0000\u01ce\u01cc\u0001\u0000\u0000\u0000\u01ce\u01cf"+
		"\u0001\u0000\u0000\u0000\u01cf\u01d1\u0001\u0000\u0000\u0000\u01d0\u01ce"+
		"\u0001\u0000\u0000\u0000\u01d1\u01d5\u0003.\u0017\u0000\u01d2\u01d4\u0005"+
		"\b\u0000\u0000\u01d3\u01d2\u0001\u0000\u0000\u0000\u01d4\u01d7\u0001\u0000"+
		"\u0000\u0000\u01d5\u01d3\u0001\u0000\u0000\u0000\u01d5\u01d6\u0001\u0000"+
		"\u0000\u0000\u01d6\u01d8\u0001\u0000\u0000\u0000\u01d7\u01d5\u0001\u0000"+
		"\u0000\u0000\u01d8\u01d9\u0005\u000b\u0000\u0000\u01d9\u01db\u0001\u0000"+
		"\u0000\u0000\u01da\u01c9\u0001\u0000\u0000\u0000\u01da\u01ca\u0001\u0000"+
		"\u0000\u0000\u01db1\u0001\u0000\u0000\u0000\u01dc\u01e1\u0007\u0005\u0000"+
		"\u0000\u01dd\u01de\u0005\t\u0000\u0000\u01de\u01e0\u00034\u001a\u0000"+
		"\u01df\u01dd\u0001\u0000\u0000\u0000\u01e0\u01e3\u0001\u0000\u0000\u0000"+
		"\u01e1\u01df\u0001\u0000\u0000\u0000\u01e1\u01e2\u0001\u0000\u0000\u0000"+
		"\u01e23\u0001\u0000\u0000\u0000\u01e3\u01e1\u0001\u0000\u0000\u0000\u01e4"+
		"\u01e7\u0003,\u0016\u0000\u01e5\u01e7\u00036\u001b\u0000\u01e6\u01e4\u0001"+
		"\u0000\u0000\u0000\u01e6\u01e5\u0001\u0000\u0000\u0000\u01e75\u0001\u0000"+
		"\u0000\u0000\u01e8\u01e9\u0007\u0006\u0000\u0000\u01e97\u0001\u0000\u0000"+
		"\u0000\u01ea\u01f3\u0003<\u001e\u0000\u01eb\u01ed\u0005\b\u0000\u0000"+
		"\u01ec\u01eb\u0001\u0000\u0000\u0000\u01ed\u01ee\u0001\u0000\u0000\u0000"+
		"\u01ee\u01ec\u0001\u0000\u0000\u0000\u01ee\u01ef\u0001\u0000\u0000\u0000"+
		"\u01ef\u01f0\u0001\u0000\u0000\u0000\u01f0\u01f2\u0003<\u001e\u0000\u01f1"+
		"\u01ec\u0001\u0000\u0000\u0000\u01f2\u01f5\u0001\u0000\u0000\u0000\u01f3"+
		"\u01f1\u0001\u0000\u0000\u0000\u01f3\u01f4\u0001\u0000\u0000\u0000\u01f4"+
		"9\u0001\u0000\u0000\u0000\u01f5\u01f3\u0001\u0000\u0000\u0000\u01f6\u01fe"+
		"\u0003\u009eO\u0000\u01f7\u01fa\u0005\u0014\u0000\u0000\u01f8\u01fb\u0003"+
		"\u009eO\u0000\u01f9\u01fb\u0005:\u0000\u0000\u01fa\u01f8\u0001\u0000\u0000"+
		"\u0000\u01fa\u01f9\u0001\u0000\u0000\u0000\u01fb\u01fd\u0001\u0000\u0000"+
		"\u0000\u01fc\u01f7\u0001\u0000\u0000\u0000\u01fd\u0200\u0001\u0000\u0000"+
		"\u0000\u01fe\u01fc\u0001\u0000\u0000\u0000\u01fe\u01ff\u0001\u0000\u0000"+
		"\u0000\u01ff;\u0001\u0000\u0000\u0000\u0200\u01fe\u0001\u0000\u0000\u0000"+
		"\u0201\u0205\u0003>\u001f\u0000\u0202\u0205\u0003@ \u0000\u0203\u0205"+
		"\u0003B!\u0000\u0204\u0201\u0001\u0000\u0000\u0000\u0204\u0202\u0001\u0000"+
		"\u0000\u0000\u0204\u0203\u0001\u0000\u0000\u0000\u0205=\u0001\u0000\u0000"+
		"\u0000\u0206\u0207\u0007\u0007\u0000\u0000\u0207?\u0001\u0000\u0000\u0000"+
		"\u0208\u0209\u0005\u0015\u0000\u0000\u0209\u020a\u0003:\u001d\u0000\u020a"+
		"A\u0001\u0000\u0000\u0000\u020b\u020c\u0003D\"\u0000\u020c\u020d\u0005"+
		"\u0004\u0000\u0000\u020d\u020f\u0003F#\u0000\u020e\u0210\u0003V+\u0000"+
		"\u020f\u020e\u0001\u0000\u0000\u0000\u020f\u0210\u0001\u0000\u0000\u0000"+
		"\u0210C\u0001\u0000\u0000\u0000\u0211\u0212\u0003H$\u0000\u0212E\u0001"+
		"\u0000\u0000\u0000\u0213\u0214\u0003J%\u0000\u0214G\u0001\u0000\u0000"+
		"\u0000\u0215\u0217\u0003J%\u0000\u0216\u0218\u0003V+\u0000\u0217\u0216"+
		"\u0001\u0000\u0000\u0000\u0217\u0218\u0001\u0000\u0000\u0000\u0218I\u0001"+
		"\u0000\u0000\u0000\u0219\u0220\u0003L&\u0000\u021a\u0220\u0003d2\u0000"+
		"\u021b\u0220\u0003j5\u0000\u021c\u0220\u0003l6\u0000\u021d\u0220\u0003"+
		"r9\u0000\u021e\u0220\u0003R)\u0000\u021f\u0219\u0001\u0000\u0000\u0000"+
		"\u021f\u021a\u0001\u0000\u0000\u0000\u021f\u021b\u0001\u0000\u0000\u0000"+
		"\u021f\u021c\u0001\u0000\u0000\u0000\u021f\u021d\u0001\u0000\u0000\u0000"+
		"\u021f\u021e\u0001\u0000\u0000\u0000\u0220K\u0001\u0000\u0000\u0000\u0221"+
		"\u0224\u0003N\'\u0000\u0222\u0224\u0003P(\u0000\u0223\u0221\u0001\u0000"+
		"\u0000\u0000\u0223\u0222\u0001\u0000\u0000\u0000\u0224M\u0001\u0000\u0000"+
		"\u0000\u0225\u0226\u0005\n\u0000\u0000\u0226\u0227\u0003H$\u0000\u0227"+
		"\u0228\u0005\u000b\u0000\u0000\u0228O\u0001\u0000\u0000\u0000\u0229\u022a"+
		"\u0005\u000f\u0000\u0000\u022a\u022f\u0003H$\u0000\u022b\u022c\u0005\u0002"+
		"\u0000\u0000\u022c\u022e\u0003H$\u0000\u022d\u022b\u0001\u0000\u0000\u0000"+
		"\u022e\u0231\u0001\u0000\u0000\u0000\u022f\u022d\u0001\u0000\u0000\u0000"+
		"\u022f\u0230\u0001\u0000\u0000\u0000\u0230\u0232\u0001\u0000\u0000\u0000"+
		"\u0231\u022f\u0001\u0000\u0000\u0000\u0232\u0233\u0005\u0011\u0000\u0000"+
		"\u0233Q\u0001\u0000\u0000\u0000\u0234\u0237\u0003T*\u0000\u0235\u0236"+
		"\u0005\t\u0000\u0000\u0236\u0238\u0003T*\u0000\u0237\u0235\u0001\u0000"+
		"\u0000\u0000\u0238\u0239\u0001\u0000\u0000\u0000\u0239\u0237\u0001\u0000"+
		"\u0000\u0000\u0239\u023a\u0001\u0000\u0000\u0000\u023aS\u0001\u0000\u0000"+
		"\u0000\u023b\u0241\u0003L&\u0000\u023c\u0241\u0003d2\u0000\u023d\u0241"+
		"\u0003j5\u0000\u023e\u0241\u0003l6\u0000\u023f\u0241\u0003r9\u0000\u0240"+
		"\u023b\u0001\u0000\u0000\u0000\u0240\u023c\u0001\u0000\u0000\u0000\u0240"+
		"\u023d\u0001\u0000\u0000\u0000\u0240\u023e\u0001\u0000\u0000\u0000\u0240"+
		"\u023f\u0001\u0000\u0000\u0000\u0241U\u0001\u0000\u0000\u0000\u0242\u0248"+
		"\u0003X,\u0000\u0243\u0248\u0003Z-\u0000\u0244\u0245\u0003X,\u0000\u0245"+
		"\u0246\u0003Z-\u0000\u0246\u0248\u0001\u0000\u0000\u0000\u0247\u0242\u0001"+
		"\u0000\u0000\u0000\u0247\u0243\u0001\u0000\u0000\u0000\u0247\u0244\u0001"+
		"\u0000\u0000\u0000\u0248W\u0001\u0000\u0000\u0000\u0249\u024c\u0005\u0005"+
		"\u0000\u0000\u024a\u024d\u0003^/\u0000\u024b\u024d\u0003\\.\u0000\u024c"+
		"\u024a\u0001\u0000\u0000\u0000\u024c\u024b\u0001\u0000\u0000\u0000\u024d"+
		"Y\u0001\u0000\u0000\u0000\u024e\u0251\u0005\u0006\u0000\u0000\u024f\u0252"+
		"\u0003^/\u0000\u0250\u0252\u0003\\.\u0000\u0251\u024f\u0001\u0000\u0000"+
		"\u0000\u0251\u0250\u0001\u0000\u0000\u0000\u0252[\u0001\u0000\u0000\u0000"+
		"\u0253\u0254\u0005\u000f\u0000\u0000\u0254\u0259\u0003^/\u0000\u0255\u0256"+
		"\u0005\u0002\u0000\u0000\u0256\u0258\u0003^/\u0000\u0257\u0255\u0001\u0000"+
		"\u0000\u0000\u0258\u025b\u0001\u0000\u0000\u0000\u0259\u0257\u0001\u0000"+
		"\u0000\u0000\u0259\u025a\u0001\u0000\u0000\u0000\u025a\u025c\u0001\u0000"+
		"\u0000\u0000\u025b\u0259\u0001\u0000\u0000\u0000\u025c\u025d\u0005\u0011"+
		"\u0000\u0000\u025d]\u0001\u0000\u0000\u0000\u025e\u025f\u0003`0\u0000"+
		"\u025f\u0260\u0005\t\u0000\u0000\u0260\u0262\u0001\u0000\u0000\u0000\u0261"+
		"\u025e\u0001\u0000\u0000\u0000\u0261\u0262\u0001\u0000\u0000\u0000\u0262"+
		"\u0263\u0001\u0000\u0000\u0000\u0263\u0266\u0005\u0007\u0000\u0000\u0264"+
		"\u0265\u0005\t\u0000\u0000\u0265\u0267\u0003b1\u0000\u0266\u0264\u0001"+
		"\u0000\u0000\u0000\u0266\u0267\u0001\u0000\u0000\u0000\u0267\u026c\u0001"+
		"\u0000\u0000\u0000\u0268\u026a\u0003`0\u0000\u0269\u0268\u0001\u0000\u0000"+
		"\u0000\u0269\u026a\u0001\u0000\u0000\u0000\u026a\u026c\u0001\u0000\u0000"+
		"\u0000\u026b\u0261\u0001\u0000\u0000\u0000\u026b\u0269\u0001\u0000\u0000"+
		"\u0000\u026c_\u0001\u0000\u0000\u0000\u026d\u026e\u0003J%\u0000\u026e"+
		"a\u0001\u0000\u0000\u0000\u026f\u0270\u0003J%\u0000\u0270c\u0001\u0000"+
		"\u0000\u0000\u0271\u0275\u0003h4\u0000\u0272\u0273\u0003f3\u0000\u0273"+
		"\u0274\u0003h4\u0000\u0274\u0276\u0001\u0000\u0000\u0000\u0275\u0272\u0001"+
		"\u0000\u0000\u0000\u0276\u0277\u0001\u0000\u0000\u0000\u0277\u0275\u0001"+
		"\u0000\u0000\u0000\u0277\u0278\u0001\u0000\u0000\u0000\u0278e\u0001\u0000"+
		"\u0000\u0000\u0279\u027a\u0007\b\u0000\u0000\u027ag\u0001\u0000\u0000"+
		"\u0000\u027b\u0280\u0003L&\u0000\u027c\u0280\u0003j5\u0000\u027d\u0280"+
		"\u0003l6\u0000\u027e\u0280\u0003r9\u0000\u027f\u027b\u0001\u0000\u0000"+
		"\u0000\u027f\u027c\u0001\u0000\u0000\u0000\u027f\u027d\u0001\u0000\u0000"+
		"\u0000\u027f\u027e\u0001\u0000\u0000\u0000\u0280i\u0001\u0000\u0000\u0000"+
		"\u0281\u0284\u0005\u0019\u0000\u0000\u0282\u0285\u0003L&\u0000\u0283\u0285"+
		"\u0003r9\u0000\u0284\u0282\u0001\u0000\u0000\u0000\u0284\u0283\u0001\u0000"+
		"\u0000\u0000\u0285k\u0001\u0000\u0000\u0000\u0286\u0289\u0003n7\u0000"+
		"\u0287\u0289\u0003p8\u0000\u0288\u0286\u0001\u0000\u0000\u0000\u0288\u0287"+
		"\u0001\u0000\u0000\u0000\u0289m\u0001\u0000\u0000\u0000\u028a\u028e\u0003"+
		"L&\u0000\u028b\u028e\u0003j5\u0000\u028c\u028e\u0003r9\u0000\u028d\u028a"+
		"\u0001\u0000\u0000\u0000\u028d\u028b\u0001\u0000\u0000\u0000\u028d\u028c"+
		"\u0001\u0000\u0000\u0000\u028e\u028f\u0001\u0000\u0000\u0000\u028f\u0290"+
		"\u0003x<\u0000\u0290o\u0001\u0000\u0000\u0000\u0291\u0294\u0003L&\u0000"+
		"\u0292\u0294\u0003r9\u0000\u0293\u0291\u0001\u0000\u0000\u0000\u0293\u0292"+
		"\u0001\u0000\u0000\u0000\u0294\u0295\u0001\u0000\u0000\u0000\u0295\u0296"+
		"\u0003\u008cF\u0000\u0296q\u0001\u0000\u0000\u0000\u0297\u02a1\u0003t"+
		":\u0000\u0298\u02a1\u0003v;\u0000\u0299\u02a1\u0003x<\u0000\u029a\u02a1"+
		"\u0003z=\u0000\u029b\u02a1\u0003\u0084B\u0000\u029c\u02a1\u0003\u0086"+
		"C\u0000\u029d\u02a1\u0003\u0088D\u0000\u029e\u02a1\u0003\u008aE\u0000"+
		"\u029f\u02a1\u0003\u009cN\u0000\u02a0\u0297\u0001\u0000\u0000\u0000\u02a0"+
		"\u0298\u0001\u0000\u0000\u0000\u02a0\u0299\u0001\u0000\u0000\u0000\u02a0"+
		"\u029a\u0001\u0000\u0000\u0000\u02a0\u029b\u0001\u0000\u0000\u0000\u02a0"+
		"\u029c\u0001\u0000\u0000\u0000\u02a0\u029d\u0001\u0000\u0000\u0000\u02a0"+
		"\u029e\u0001\u0000\u0000\u0000\u02a0\u029f\u0001\u0000\u0000\u0000\u02a1"+
		"s\u0001\u0000\u0000\u0000\u02a2\u02a3\u0005-\u0000\u0000\u02a3u\u0001"+
		"\u0000\u0000\u0000\u02a4\u02a5\u0005\u001d\u0000\u0000\u02a5\u02a6\u0003"+
		"\u009eO\u0000\u02a6w\u0001\u0000\u0000\u0000\u02a7\u02a9\u0005\u0018\u0000"+
		"\u0000\u02a8\u02a7\u0001\u0000\u0000\u0000\u02a8\u02a9\u0001\u0000\u0000"+
		"\u0000\u02a9\u02aa\u0001\u0000\u0000\u0000\u02aa\u02ac\u0005\u001b\u0000"+
		"\u0000\u02ab\u02ad\u0005\u001a\u0000\u0000\u02ac\u02ab\u0001\u0000\u0000"+
		"\u0000\u02ac\u02ad\u0001\u0000\u0000\u0000\u02ad\u02ae\u0001\u0000\u0000"+
		"\u0000\u02ae\u02af\u0005:\u0000\u0000\u02afy\u0001\u0000\u0000\u0000\u02b0"+
		"\u02b2\u0005\r\u0000\u0000\u02b1\u02b3\u0003|>\u0000\u02b2\u02b1\u0001"+
		"\u0000\u0000\u0000\u02b2\u02b3\u0001\u0000\u0000\u0000\u02b3\u02b8\u0001"+
		"\u0000\u0000\u0000\u02b4\u02b5\u0005\t\u0000\u0000\u02b5\u02b7\u0003|"+
		">\u0000\u02b6\u02b4\u0001\u0000\u0000\u0000\u02b7\u02ba\u0001\u0000\u0000"+
		"\u0000\u02b8\u02b6\u0001\u0000\u0000\u0000\u02b8\u02b9\u0001\u0000\u0000"+
		"\u0000\u02b9\u02bb\u0001\u0000\u0000\u0000\u02ba\u02b8\u0001\u0000\u0000"+
		"\u0000\u02bb\u02bc\u0005\u000e\u0000\u0000\u02bc{\u0001\u0000\u0000\u0000"+
		"\u02bd\u02bf\u0005\u0019\u0000\u0000\u02be\u02bd\u0001\u0000\u0000\u0000"+
		"\u02be\u02bf\u0001\u0000\u0000\u0000\u02bf\u02c0\u0001\u0000\u0000\u0000"+
		"\u02c0\u02c1\u0003~?\u0000\u02c1}\u0001\u0000\u0000\u0000\u02c2\u02c6"+
		"\u0003\u0096K\u0000\u02c3\u02c6\u0003\u0080@\u0000\u02c4\u02c6\u0003\u0082"+
		"A\u0000\u02c5\u02c2\u0001\u0000\u0000\u0000\u02c5\u02c3\u0001\u0000\u0000"+
		"\u0000\u02c5\u02c4\u0001\u0000\u0000\u0000\u02c6\u007f\u0001\u0000\u0000"+
		"\u0000\u02c7\u02c8\u0005\f\u0000\u0000\u02c8\u02c9\u0003\u009eO\u0000"+
		"\u02c9\u0081\u0001\u0000\u0000\u0000\u02ca\u02cb\u0005\u001b\u0000\u0000"+
		"\u02cb\u02cc\u0003\u009eO\u0000\u02cc\u0083\u0001\u0000\u0000\u0000\u02cd"+
		"\u02ce\u0005\f\u0000\u0000\u02ce\u0085\u0001\u0000\u0000\u0000\u02cf\u02d0"+
		"\u0005\u001a\u0000\u0000\u02d0\u0087\u0001\u0000\u0000\u0000\u02d1\u02d2"+
		"\u0005\u001b\u0000\u0000\u02d2\u0089\u0001\u0000\u0000\u0000\u02d3\u02d4"+
		"\u0005\u001c\u0000\u0000\u02d4\u008b\u0001\u0000\u0000\u0000\u02d5\u02da"+
		"\u0003\u008eG\u0000\u02d6\u02da\u0005\u0012\u0000\u0000\u02d7\u02da\u0005"+
		"\f\u0000\u0000\u02d8\u02da\u0005\u0013\u0000\u0000\u02d9\u02d5\u0001\u0000"+
		"\u0000\u0000\u02d9\u02d6\u0001\u0000\u0000\u0000\u02d9\u02d7\u0001\u0000"+
		"\u0000\u0000\u02d9\u02d8\u0001\u0000\u0000\u0000\u02da\u008d\u0001\u0000"+
		"\u0000\u0000\u02db\u02e6\u0005\f\u0000\u0000\u02dc\u02e7\u0005:\u0000"+
		"\u0000\u02dd\u02df\u0005\n\u0000\u0000\u02de\u02e0\u0003\u0090H\u0000"+
		"\u02df\u02de\u0001\u0000\u0000\u0000\u02df\u02e0\u0001\u0000\u0000\u0000"+
		"\u02e0\u02e1\u0001\u0000\u0000\u0000\u02e1\u02e3\u0005\u0014\u0000\u0000"+
		"\u02e2\u02e4\u0003\u0092I\u0000\u02e3\u02e2\u0001\u0000\u0000\u0000\u02e3"+
		"\u02e4\u0001\u0000\u0000\u0000\u02e4\u02e5\u0001\u0000\u0000\u0000\u02e5"+
		"\u02e7\u0005\u000b\u0000\u0000\u02e6\u02dc\u0001\u0000\u0000\u0000\u02e6"+
		"\u02dd\u0001\u0000\u0000\u0000\u02e7\u008f\u0001\u0000\u0000\u0000\u02e8"+
		"\u02e9\u0005:\u0000\u0000\u02e9\u0091\u0001\u0000\u0000\u0000\u02ea\u02eb"+
		"\u0005:\u0000\u0000\u02eb\u0093\u0001\u0000\u0000\u0000\u02ec\u02ee\u0005"+
		"\r\u0000\u0000\u02ed\u02ef\u0003\u0096K\u0000\u02ee\u02ed\u0001\u0000"+
		"\u0000\u0000\u02ee\u02ef\u0001\u0000\u0000\u0000\u02ef\u02f4\u0001\u0000"+
		"\u0000\u0000\u02f0\u02f1\u0005\t\u0000\u0000\u02f1\u02f3\u0003\u0096K"+
		"\u0000\u02f2\u02f0\u0001\u0000\u0000\u0000\u02f3\u02f6\u0001\u0000\u0000"+
		"\u0000\u02f4\u02f2\u0001\u0000\u0000\u0000\u02f4\u02f5\u0001\u0000\u0000"+
		"\u0000\u02f5\u02f7\u0001\u0000\u0000\u0000\u02f6\u02f4\u0001\u0000\u0000"+
		"\u0000\u02f7\u02f8\u0005\u000e\u0000\u0000\u02f8\u0095\u0001\u0000\u0000"+
		"\u0000\u02f9\u02fc\u0003\u0098L\u0000\u02fa\u02fc\u0003\u009aM\u0000\u02fb"+
		"\u02f9\u0001\u0000\u0000\u0000\u02fb\u02fa\u0001\u0000\u0000\u0000\u02fc"+
		"\u0097\u0001\u0000\u0000\u0000\u02fd\u02fe\u0007\t\u0000\u0000\u02fe\u02ff"+
		"\u0003\u009eO\u0000\u02ff\u0099\u0001\u0000\u0000\u0000\u0300\u0301\u0003"+
		"\u009eO\u0000\u0301\u009b\u0001\u0000\u0000\u0000\u0302\u0306\u0003\u009e"+
		"O\u0000\u0303\u0306\u0005<\u0000\u0000\u0304\u0306\u0005=\u0000\u0000"+
		"\u0305\u0302\u0001\u0000\u0000\u0000\u0305\u0303\u0001\u0000\u0000\u0000"+
		"\u0305\u0304\u0001\u0000\u0000\u0000\u0306\u0308\u0001\u0000\u0000\u0000"+
		"\u0307\u0309\u0005\u0019\u0000\u0000\u0308\u0307\u0001\u0000\u0000\u0000"+
		"\u0308\u0309\u0001\u0000\u0000\u0000\u0309\u009d\u0001\u0000\u0000\u0000"+
		"\u030a\u030b\u0007\n\u0000\u0000\u030b\u009f\u0001\u0000\u0000\u0000]"+
		"\u00a4\u00a7\u00aa\u00af\u00b4\u00bb\u00be\u00cd\u00df\u00e3\u00e9\u00f2"+
		"\u00f8\u00fc\u0102\u0109\u010e\u0115\u0118\u0128\u0130\u013c\u0141\u014a"+
		"\u0150\u0155\u0157\u015c\u015f\u0163\u0168\u016f\u0176\u017c\u0183\u0189"+
		"\u0192\u0198\u01a1\u01a5\u01aa\u01b0\u01b6\u01be\u01c0\u01c6\u01ce\u01d5"+
		"\u01da\u01e1\u01e6\u01ee\u01f3\u01fa\u01fe\u0204\u020f\u0217\u021f\u0223"+
		"\u022f\u0239\u0240\u0247\u024c\u0251\u0259\u0261\u0266\u0269\u026b\u0277"+
		"\u027f\u0284\u0288\u028d\u0293\u02a0\u02a8\u02ac\u02b2\u02b8\u02be\u02c5"+
		"\u02d9\u02df\u02e3\u02e6\u02ee\u02f4\u02fb\u0305\u0308";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}