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
			null, null, null, null, null, null, null, "'_'", null, null, "'('", "')'", 
			"'*'", "'['", "']'", "'{'", null, "'}'", "'+'", "'?'", "'-'", "':'", 
			"'~'", "'!'", "'.'", "'$'", "'$$'", "'@'", "'&'", "'&!'", "'>'"
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

	public static class LscFileContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(LscParser.EOF, 0); }
		public TerminalNode WHITESPACE() { return getToken(LscParser.WHITESPACE, 0); }
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
			switch (_input.LA(1)) {
			case WHITESPACE:
				{
				setState(154);
				match(WHITESPACE);
				}
				break;
			case EOF:
			case NEWLINE:
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
			default:
				throw new NoViableAltException(this);
			}
			setState(164);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ELEMENT_DECL) | (1L << CLASS_DECL) | (1L << FEATURE_DECL) | (1L << DIACRITIC_DECL) | (1L << SYMBOL_DECL) | (1L << SYLLABLE_DECL) | (1L << EXPLICIT_SYLLABLES) | (1L << CLEAR_SYLLABLES) | (1L << DEROMANIZER) | (1L << ROMANIZER) | (1L << ALL_MATCHING) | (1L << FIRST_MATCHING) | (1L << LITERAL) | (1L << LTR) | (1L << RTL) | (1L << PROPAGATE) | (1L << CLEANUP) | (1L << BLOCK) | (1L << UNCHANGED) | (1L << OFF) | (1L << NAME))) != 0)) {
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
			setState(180);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE) {
				{
				{
				setState(177);
				match(NEWLINE);
				}
				}
				setState(182);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(183);
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
			setState(195);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(185);
				featureDecl();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(186);
				diacriticDecl();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(187);
				symbolDecl();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(188);
				classDecl();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(189);
				elementDecl();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(190);
				syllableDecl();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(191);
				deromanizer();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(192);
				interRomanizer();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(193);
				romanizer();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(194);
				changeRule();
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
			setState(197);
			match(ELEMENT_DECL);
			setState(198);
			match(WHITESPACE);
			setState(199);
			name();
			setState(200);
			match(WHITESPACE);
			setState(201);
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
			setState(203);
			match(CLASS_DECL);
			setState(204);
			match(WHITESPACE);
			setState(205);
			name();
			setState(206);
			match(WHITESPACE);
			setState(207);
			_la = _input.LA(1);
			if ( !(_la==LIST_START || _la==CLASS_START) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(208);
			classElement();
			setState(213);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(209);
					_la = _input.LA(1);
					if ( !(_la==LIST_SEP || _la==CLASS_SEP) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(210);
					classElement();
					}
					} 
				}
				setState(215);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			}
			setState(217);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CLASS_SEP) {
				{
				setState(216);
				match(CLASS_SEP);
				}
			}

			setState(219);
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
			setState(223);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CLASSREF:
				enterOuterAlt(_localctx, 1);
				{
				setState(221);
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
				setState(222);
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
			setState(225);
			match(FEATURE_DECL);
			setState(226);
			match(WHITESPACE);
			setState(260);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				{
				{
				setState(227);
				plusFeature();
				setState(232);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==LIST_SEP) {
					{
					{
					setState(228);
					match(LIST_SEP);
					setState(229);
					plusFeature();
					}
					}
					setState(234);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				break;
			case 2:
				{
				{
				setState(238);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SYLLABLE_FEATURE) {
					{
					setState(235);
					featureModifier();
					setState(236);
					match(WHITESPACE);
					}
				}

				setState(240);
				name();
				setState(242);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==WHITESPACE) {
					{
					setState(241);
					match(WHITESPACE);
					}
				}

				setState(244);
				match(O_PAREN);
				setState(248);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NULL) {
					{
					setState(245);
					nullAlias();
					setState(246);
					match(LIST_SEP);
					}
				}

				setState(250);
				featureValue();
				setState(255);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==LIST_SEP) {
					{
					{
					setState(251);
					match(LIST_SEP);
					setState(252);
					featureValue();
					}
					}
					setState(257);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(258);
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
		enterRule(_localctx, 12, RULE_featureModifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(262);
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
		enterRule(_localctx, 14, RULE_plusFeature);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(267);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SYLLABLE_FEATURE) {
				{
				setState(264);
				featureModifier();
				setState(265);
				match(WHITESPACE);
				}
			}

			setState(270);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==AT_LEAST_ONE) {
				{
				setState(269);
				match(AT_LEAST_ONE);
				}
			}

			setState(272);
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
		enterRule(_localctx, 16, RULE_nullAlias);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(274);
			match(NULL);
			setState(275);
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
			enterOuterAlt(_localctx, 1);
			{
			setState(277);
			match(DIACRITIC_DECL);
			setState(278);
			match(WHITESPACE);
			setState(279);
			text();
			setState(280);
			match(WHITESPACE);
			setState(286);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DIA_BEFORE) | (1L << DIA_FIRST) | (1L << DIA_FLOATING))) != 0)) {
				{
				{
				setState(281);
				diacriticModifier();
				setState(282);
				match(WHITESPACE);
				}
				}
				setState(288);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(289);
			matrix();
			setState(294);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WHITESPACE) {
				{
				{
				setState(290);
				match(WHITESPACE);
				setState(291);
				diacriticModifier();
				}
				}
				setState(296);
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
		enterRule(_localctx, 20, RULE_diacriticModifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(297);
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
			setState(299);
			match(SYMBOL_DECL);
			setState(300);
			match(WHITESPACE);
			setState(301);
			symbolName();
			setState(311);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case EOF:
			case LIST_SEP:
			case NEWLINE:
				{
				setState(306);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==LIST_SEP) {
					{
					{
					setState(302);
					match(LIST_SEP);
					setState(303);
					symbolName();
					}
					}
					setState(308);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case WHITESPACE:
				{
				setState(309);
				match(WHITESPACE);
				setState(310);
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
		enterRule(_localctx, 24, RULE_symbolName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(313);
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
		enterRule(_localctx, 26, RULE_syllableDecl);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(315);
			match(SYLLABLE_DECL);
			setState(316);
			match(RULE_START);
			setState(333);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
			case 1:
				{
				setState(318); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(317);
					match(NEWLINE);
					}
					}
					setState(320); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NEWLINE );
				setState(322);
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
				setState(329); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(324); 
						_errHandler.sync(this);
						_la = _input.LA(1);
						do {
							{
							{
							setState(323);
							match(NEWLINE);
							}
							}
							setState(326); 
							_errHandler.sync(this);
							_la = _input.LA(1);
						} while ( _la==NEWLINE );
						setState(328);
						syllablePattern();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(331); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
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
		enterRule(_localctx, 28, RULE_syllablePattern);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(335);
			unconditionalRuleElement();
			setState(338);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CHANGE) {
				{
				setState(336);
				match(CHANGE);
				setState(337);
				matrix();
				}
			}

			setState(341);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CONDITION || _la==EXCLUSION) {
				{
				setState(340);
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
		enterRule(_localctx, 30, RULE_deromanizer);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(343);
			match(DEROMANIZER);
			setState(346);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WHITESPACE) {
				{
				setState(344);
				match(WHITESPACE);
				setState(345);
				match(LITERAL);
				}
			}

			setState(348);
			match(RULE_START);
			setState(350); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(349);
				match(NEWLINE);
				}
				}
				setState(352); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NEWLINE );
			setState(354);
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
		enterRule(_localctx, 32, RULE_romanizer);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(356);
			match(ROMANIZER);
			setState(359);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WHITESPACE) {
				{
				setState(357);
				match(WHITESPACE);
				setState(358);
				match(LITERAL);
				}
			}

			setState(361);
			match(RULE_START);
			setState(363); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(362);
				match(NEWLINE);
				}
				}
				setState(365); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NEWLINE );
			setState(367);
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
		enterRule(_localctx, 34, RULE_interRomanizer);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(369);
			match(ROMANIZER);
			setState(370);
			match(HYPHEN);
			setState(371);
			ruleName();
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
			setState(384);
			ruleName();
			setState(389);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WHITESPACE) {
				{
				{
				setState(385);
				match(WHITESPACE);
				setState(386);
				changeRuleModifier();
				}
				}
				setState(391);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(393);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==RULE_START) {
				{
				setState(392);
				match(RULE_START);
				}
			}

			setState(396); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(395);
				match(NEWLINE);
				}
				}
				setState(398); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NEWLINE );
			setState(400);
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
			setState(404);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CLASSREF:
				enterOuterAlt(_localctx, 1);
				{
				setState(402);
				elementRef();
				}
				break;
			case MATRIX_START:
				enterOuterAlt(_localctx, 2);
				{
				setState(403);
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
		enterRule(_localctx, 40, RULE_block);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(406);
			blockElement();
			setState(426);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,41,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(408); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(407);
						match(NEWLINE);
						}
						}
						setState(410); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==NEWLINE );
					setState(412);
					blockType();
					setState(413);
					match(RULE_START);
					setState(420);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case WHITESPACE:
						{
						setState(414);
						match(WHITESPACE);
						}
						break;
					case NEWLINE:
						{
						setState(416); 
						_errHandler.sync(this);
						_la = _input.LA(1);
						do {
							{
							{
							setState(415);
							match(NEWLINE);
							}
							}
							setState(418); 
							_errHandler.sync(this);
							_la = _input.LA(1);
						} while ( _la==NEWLINE );
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(422);
					blockElement();
					}
					} 
				}
				setState(428);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,41,_ctx);
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
		enterRule(_localctx, 42, RULE_blockElement);
		int _la;
		try {
			setState(446);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,44,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(429);
				expressionList();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(430);
				match(O_PAREN);
				setState(434);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NEWLINE) {
					{
					{
					setState(431);
					match(NEWLINE);
					}
					}
					setState(436);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(437);
				block();
				setState(441);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NEWLINE) {
					{
					{
					setState(438);
					match(NEWLINE);
					}
					}
					setState(443);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(444);
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
		enterRule(_localctx, 44, RULE_blockType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(448);
			_la = _input.LA(1);
			if ( !(_la==ALL_MATCHING || _la==FIRST_MATCHING) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(453);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WHITESPACE) {
				{
				{
				setState(449);
				match(WHITESPACE);
				setState(450);
				changeRuleModifier();
				}
				}
				setState(455);
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
			setState(458);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case MATRIX_START:
			case CLASSREF:
				enterOuterAlt(_localctx, 1);
				{
				setState(456);
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
				setState(457);
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
			setState(460);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LTR) | (1L << RTL) | (1L << PROPAGATE) | (1L << CLEANUP) | (1L << BLOCK) | (1L << NAME))) != 0)) ) {
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
		enterRule(_localctx, 50, RULE_expressionList);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(462);
			expression();
			setState(471);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,48,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(464); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(463);
						match(NEWLINE);
						}
						}
						setState(466); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==NEWLINE );
					setState(468);
					expression();
					}
					} 
				}
				setState(473);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,48,_ctx);
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
			setState(474);
			name();
			setState(482);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==HYPHEN) {
				{
				{
				setState(475);
				match(HYPHEN);
				setState(478);
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
					setState(476);
					name();
					}
					break;
				case NUMBER:
					{
					setState(477);
					match(NUMBER);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				}
				setState(484);
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
			setState(488);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,51,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(485);
				keywordExpression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(486);
				blockRef();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(487);
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
			setState(490);
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
			setState(492);
			match(RULE_START);
			setState(493);
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
			setState(495);
			from();
			setState(496);
			match(CHANGE);
			setState(497);
			to();
			setState(499);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CONDITION || _la==EXCLUSION) {
				{
				setState(498);
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
			setState(501);
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
		enterRule(_localctx, 64, RULE_to);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(503);
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
		enterRule(_localctx, 66, RULE_ruleElement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(505);
			unconditionalRuleElement();
			setState(507);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CONDITION || _la==EXCLUSION) {
				{
				setState(506);
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
		enterRule(_localctx, 68, RULE_unconditionalRuleElement);
		try {
			setState(515);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,54,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(509);
				bounded();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(510);
				interfix();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(511);
				negated();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(512);
				postfix();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(513);
				simple();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(514);
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
		enterRule(_localctx, 70, RULE_bounded);
		try {
			setState(519);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case O_PAREN:
				enterOuterAlt(_localctx, 1);
				{
				setState(517);
				group();
				}
				break;
			case LIST_START:
				enterOuterAlt(_localctx, 2);
				{
				setState(518);
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
		enterRule(_localctx, 72, RULE_group);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(521);
			match(O_PAREN);
			setState(522);
			ruleElement();
			setState(523);
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
			setState(525);
			match(LIST_START);
			setState(526);
			ruleElement();
			setState(531);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LIST_SEP) {
				{
				{
				setState(527);
				match(LIST_SEP);
				setState(528);
				ruleElement();
				}
				}
				setState(533);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(534);
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
		enterRule(_localctx, 76, RULE_sequence);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(536);
			freeElement();
			setState(539); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(537);
					match(WHITESPACE);
					setState(538);
					freeElement();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(541); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,57,_ctx);
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
		enterRule(_localctx, 78, RULE_freeElement);
		try {
			setState(548);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,58,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(543);
				bounded();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(544);
				interfix();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(545);
				negated();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(546);
				postfix();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(547);
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
		enterRule(_localctx, 80, RULE_compoundEnvironment);
		try {
			setState(555);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,59,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(550);
				condition();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(551);
				exclusion();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				{
				setState(552);
				condition();
				setState(553);
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
		enterRule(_localctx, 82, RULE_condition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(557);
			match(CONDITION);
			setState(560);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,60,_ctx) ) {
			case 1:
				{
				setState(558);
				environment();
				}
				break;
			case 2:
				{
				setState(559);
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
		enterRule(_localctx, 84, RULE_exclusion);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(562);
			match(EXCLUSION);
			setState(565);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,61,_ctx) ) {
			case 1:
				{
				setState(563);
				environment();
				}
				break;
			case 2:
				{
				setState(564);
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
			setState(567);
			match(LIST_START);
			setState(568);
			environment();
			setState(573);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LIST_SEP) {
				{
				{
				setState(569);
				match(LIST_SEP);
				setState(570);
				environment();
				}
				}
				setState(575);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(576);
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
		enterRule(_localctx, 88, RULE_environment);
		int _la;
		try {
			setState(591);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,66,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(581);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << O_PAREN) | (1L << NULL) | (1L << MATRIX_START) | (1L << LIST_START) | (1L << INEXACT) | (1L << NEGATION) | (1L << SYLLABLE_BOUNDARY) | (1L << WORD_BOUNDARY) | (1L << BETWEEN_WORDS) | (1L << CLASSREF) | (1L << ELEMENT_DECL) | (1L << CLASS_DECL) | (1L << FEATURE_DECL) | (1L << DIACRITIC_DECL) | (1L << SYMBOL_DECL) | (1L << SYLLABLE_DECL) | (1L << EXPLICIT_SYLLABLES) | (1L << CLEAR_SYLLABLES) | (1L << ANY_SYLLABLE) | (1L << DEROMANIZER) | (1L << ROMANIZER) | (1L << ALL_MATCHING) | (1L << FIRST_MATCHING) | (1L << LITERAL) | (1L << LTR) | (1L << RTL) | (1L << PROPAGATE) | (1L << CLEANUP) | (1L << BLOCK) | (1L << UNCHANGED) | (1L << OFF) | (1L << NAME) | (1L << STR1) | (1L << STR))) != 0)) {
					{
					setState(578);
					environmentBefore();
					setState(579);
					match(WHITESPACE);
					}
				}

				setState(583);
				match(ANCHOR);
				setState(586);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==WHITESPACE) {
					{
					setState(584);
					match(WHITESPACE);
					setState(585);
					environmentAfter();
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(589);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << O_PAREN) | (1L << NULL) | (1L << MATRIX_START) | (1L << LIST_START) | (1L << INEXACT) | (1L << NEGATION) | (1L << SYLLABLE_BOUNDARY) | (1L << WORD_BOUNDARY) | (1L << BETWEEN_WORDS) | (1L << CLASSREF) | (1L << ELEMENT_DECL) | (1L << CLASS_DECL) | (1L << FEATURE_DECL) | (1L << DIACRITIC_DECL) | (1L << SYMBOL_DECL) | (1L << SYLLABLE_DECL) | (1L << EXPLICIT_SYLLABLES) | (1L << CLEAR_SYLLABLES) | (1L << ANY_SYLLABLE) | (1L << DEROMANIZER) | (1L << ROMANIZER) | (1L << ALL_MATCHING) | (1L << FIRST_MATCHING) | (1L << LITERAL) | (1L << LTR) | (1L << RTL) | (1L << PROPAGATE) | (1L << CLEANUP) | (1L << BLOCK) | (1L << UNCHANGED) | (1L << OFF) | (1L << NAME) | (1L << STR1) | (1L << STR))) != 0)) {
					{
					setState(588);
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
		enterRule(_localctx, 90, RULE_environmentBefore);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(593);
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
		enterRule(_localctx, 92, RULE_environmentAfter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(595);
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
		enterRule(_localctx, 94, RULE_interfix);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(597);
			interfixElement();
			setState(601); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(598);
				interfixType();
				setState(599);
				interfixElement();
				}
				}
				setState(603); 
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
		enterRule(_localctx, 96, RULE_interfixType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(605);
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
		enterRule(_localctx, 98, RULE_interfixElement);
		try {
			setState(611);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,68,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(607);
				bounded();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(608);
				negated();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(609);
				postfix();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(610);
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
		enterRule(_localctx, 100, RULE_negated);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(613);
			match(NEGATION);
			setState(614);
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
		enterRule(_localctx, 102, RULE_postfix);
		try {
			setState(618);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,69,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(616);
				capture();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(617);
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
		enterRule(_localctx, 104, RULE_capture);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(623);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case O_PAREN:
			case LIST_START:
				{
				setState(620);
				bounded();
				}
				break;
			case NEGATION:
				{
				setState(621);
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
				setState(622);
				simple();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(625);
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
		enterRule(_localctx, 106, RULE_repeater);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(629);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case O_PAREN:
			case LIST_START:
				{
				setState(627);
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
				setState(628);
				simple();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(631);
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
			setState(642);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,72,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(633);
				anySyllable();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(634);
				elementRef();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(635);
				captureRef();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(636);
				fancyMatrix();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(637);
				empty();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(638);
				sylBoundary();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(639);
				boundary();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(640);
				betweenWords();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(641);
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
		enterRule(_localctx, 110, RULE_anySyllable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(644);
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
			setState(646);
			match(CLASSREF);
			setState(647);
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
		enterRule(_localctx, 114, RULE_captureRef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(650);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==INEXACT) {
				{
				setState(649);
				match(INEXACT);
				}
			}

			setState(652);
			match(WORD_BOUNDARY);
			setState(653);
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
		enterRule(_localctx, 116, RULE_fancyMatrix);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(655);
			match(MATRIX_START);
			setState(657);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NULL) | (1L << AT_LEAST_ONE) | (1L << HYPHEN) | (1L << NEGATION) | (1L << WORD_BOUNDARY) | (1L << ELEMENT_DECL) | (1L << CLASS_DECL) | (1L << FEATURE_DECL) | (1L << DIACRITIC_DECL) | (1L << SYMBOL_DECL) | (1L << SYLLABLE_DECL) | (1L << EXPLICIT_SYLLABLES) | (1L << CLEAR_SYLLABLES) | (1L << DEROMANIZER) | (1L << ROMANIZER) | (1L << ALL_MATCHING) | (1L << FIRST_MATCHING) | (1L << LITERAL) | (1L << LTR) | (1L << RTL) | (1L << PROPAGATE) | (1L << CLEANUP) | (1L << BLOCK) | (1L << UNCHANGED) | (1L << OFF) | (1L << NAME))) != 0)) {
				{
				setState(656);
				fancyValue();
				}
			}

			setState(663);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WHITESPACE) {
				{
				{
				setState(659);
				match(WHITESPACE);
				setState(660);
				fancyValue();
				}
				}
				setState(665);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(666);
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
		enterRule(_localctx, 118, RULE_fancyValue);
		try {
			setState(672);
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
				setState(668);
				matrixValue();
				}
				break;
			case NEGATION:
				enterOuterAlt(_localctx, 2);
				{
				setState(669);
				negatedValue();
				}
				break;
			case NULL:
				enterOuterAlt(_localctx, 3);
				{
				setState(670);
				absentFeature();
				}
				break;
			case WORD_BOUNDARY:
				enterOuterAlt(_localctx, 4);
				{
				setState(671);
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
		enterRule(_localctx, 120, RULE_negatedValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(674);
			match(NEGATION);
			setState(675);
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
		enterRule(_localctx, 122, RULE_absentFeature);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(677);
			match(NULL);
			setState(678);
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
		enterRule(_localctx, 124, RULE_featureVariable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(680);
			match(WORD_BOUNDARY);
			setState(681);
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
		enterRule(_localctx, 126, RULE_empty);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(683);
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
		enterRule(_localctx, 128, RULE_sylBoundary);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(685);
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
		enterRule(_localctx, 130, RULE_boundary);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(687);
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
		enterRule(_localctx, 132, RULE_betweenWords);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(689);
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
		enterRule(_localctx, 134, RULE_repeaterType);
		try {
			setState(695);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,77,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(691);
				repeatRange();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(692);
				match(AT_LEAST_ONE);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(693);
				match(NULL);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(694);
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
		enterRule(_localctx, 136, RULE_repeatRange);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(697);
			match(NULL);
			setState(708);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUMBER:
				{
				setState(698);
				match(NUMBER);
				}
				break;
			case O_PAREN:
				{
				{
				setState(699);
				match(O_PAREN);
				setState(701);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NUMBER) {
					{
					setState(700);
					lowerBound();
					}
				}

				setState(703);
				match(HYPHEN);
				setState(705);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NUMBER) {
					{
					setState(704);
					upperBound();
					}
				}

				setState(707);
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
		enterRule(_localctx, 138, RULE_lowerBound);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(710);
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
		enterRule(_localctx, 140, RULE_upperBound);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(712);
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
		enterRule(_localctx, 142, RULE_matrix);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(714);
			match(MATRIX_START);
			setState(716);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AT_LEAST_ONE) | (1L << HYPHEN) | (1L << ELEMENT_DECL) | (1L << CLASS_DECL) | (1L << FEATURE_DECL) | (1L << DIACRITIC_DECL) | (1L << SYMBOL_DECL) | (1L << SYLLABLE_DECL) | (1L << EXPLICIT_SYLLABLES) | (1L << CLEAR_SYLLABLES) | (1L << DEROMANIZER) | (1L << ROMANIZER) | (1L << ALL_MATCHING) | (1L << FIRST_MATCHING) | (1L << LITERAL) | (1L << LTR) | (1L << RTL) | (1L << PROPAGATE) | (1L << CLEANUP) | (1L << BLOCK) | (1L << UNCHANGED) | (1L << OFF) | (1L << NAME))) != 0)) {
				{
				setState(715);
				matrixValue();
				}
			}

			setState(722);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WHITESPACE) {
				{
				{
				setState(718);
				match(WHITESPACE);
				setState(719);
				matrixValue();
				}
				}
				setState(724);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(725);
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
		enterRule(_localctx, 144, RULE_matrixValue);
		try {
			setState(729);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case AT_LEAST_ONE:
			case HYPHEN:
				enterOuterAlt(_localctx, 1);
				{
				setState(727);
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
				setState(728);
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
		enterRule(_localctx, 146, RULE_plusFeatureValue);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(731);
			_la = _input.LA(1);
			if ( !(_la==AT_LEAST_ONE || _la==HYPHEN) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(732);
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
		enterRule(_localctx, 148, RULE_featureValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(734);
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
			setState(739);
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
				setState(736);
				name();
				}
				break;
			case STR1:
				{
				setState(737);
				match(STR1);
				}
				break;
			case STR:
				{
				setState(738);
				match(STR);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(742);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NEGATION) {
				{
				setState(741);
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
			setState(744);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ELEMENT_DECL) | (1L << CLASS_DECL) | (1L << FEATURE_DECL) | (1L << DIACRITIC_DECL) | (1L << SYMBOL_DECL) | (1L << SYLLABLE_DECL) | (1L << EXPLICIT_SYLLABLES) | (1L << CLEAR_SYLLABLES) | (1L << DEROMANIZER) | (1L << ROMANIZER) | (1L << ALL_MATCHING) | (1L << FIRST_MATCHING) | (1L << LITERAL) | (1L << LTR) | (1L << RTL) | (1L << PROPAGATE) | (1L << CLEANUP) | (1L << BLOCK) | (1L << UNCHANGED) | (1L << OFF) | (1L << NAME))) != 0)) ) {
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3=\u02ed\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\3\2\3\2\7\2\u009f\n\2\f\2\16\2\u00a2"+
		"\13\2\5\2\u00a4\n\2\3\2\5\2\u00a7\n\2\3\2\6\2\u00aa\n\2\r\2\16\2\u00ab"+
		"\3\2\7\2\u00af\n\2\f\2\16\2\u00b2\13\2\3\2\7\2\u00b5\n\2\f\2\16\2\u00b8"+
		"\13\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3\u00c6\n\3\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\7\5\u00d6\n\5\f"+
		"\5\16\5\u00d9\13\5\3\5\5\5\u00dc\n\5\3\5\3\5\3\6\3\6\5\6\u00e2\n\6\3\7"+
		"\3\7\3\7\3\7\3\7\7\7\u00e9\n\7\f\7\16\7\u00ec\13\7\3\7\3\7\3\7\5\7\u00f1"+
		"\n\7\3\7\3\7\5\7\u00f5\n\7\3\7\3\7\3\7\3\7\5\7\u00fb\n\7\3\7\3\7\3\7\7"+
		"\7\u0100\n\7\f\7\16\7\u0103\13\7\3\7\3\7\5\7\u0107\n\7\3\b\3\b\3\t\3\t"+
		"\3\t\5\t\u010e\n\t\3\t\5\t\u0111\n\t\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\7\13\u011f\n\13\f\13\16\13\u0122\13\13\3\13\3\13"+
		"\3\13\7\13\u0127\n\13\f\13\16\13\u012a\13\13\3\f\3\f\3\r\3\r\3\r\3\r\3"+
		"\r\7\r\u0133\n\r\f\r\16\r\u0136\13\r\3\r\3\r\5\r\u013a\n\r\3\16\3\16\3"+
		"\17\3\17\3\17\6\17\u0141\n\17\r\17\16\17\u0142\3\17\3\17\6\17\u0147\n"+
		"\17\r\17\16\17\u0148\3\17\6\17\u014c\n\17\r\17\16\17\u014d\5\17\u0150"+
		"\n\17\3\20\3\20\3\20\5\20\u0155\n\20\3\20\5\20\u0158\n\20\3\21\3\21\3"+
		"\21\5\21\u015d\n\21\3\21\3\21\6\21\u0161\n\21\r\21\16\21\u0162\3\21\3"+
		"\21\3\22\3\22\3\22\5\22\u016a\n\22\3\22\3\22\6\22\u016e\n\22\r\22\16\22"+
		"\u016f\3\22\3\22\3\23\3\23\3\23\3\23\3\23\5\23\u0179\n\23\3\23\3\23\6"+
		"\23\u017d\n\23\r\23\16\23\u017e\3\23\3\23\3\24\3\24\3\24\7\24\u0186\n"+
		"\24\f\24\16\24\u0189\13\24\3\24\5\24\u018c\n\24\3\24\6\24\u018f\n\24\r"+
		"\24\16\24\u0190\3\24\3\24\3\25\3\25\5\25\u0197\n\25\3\26\3\26\6\26\u019b"+
		"\n\26\r\26\16\26\u019c\3\26\3\26\3\26\3\26\6\26\u01a3\n\26\r\26\16\26"+
		"\u01a4\5\26\u01a7\n\26\3\26\3\26\7\26\u01ab\n\26\f\26\16\26\u01ae\13\26"+
		"\3\27\3\27\3\27\7\27\u01b3\n\27\f\27\16\27\u01b6\13\27\3\27\3\27\7\27"+
		"\u01ba\n\27\f\27\16\27\u01bd\13\27\3\27\3\27\5\27\u01c1\n\27\3\30\3\30"+
		"\3\30\7\30\u01c6\n\30\f\30\16\30\u01c9\13\30\3\31\3\31\5\31\u01cd\n\31"+
		"\3\32\3\32\3\33\3\33\6\33\u01d3\n\33\r\33\16\33\u01d4\3\33\7\33\u01d8"+
		"\n\33\f\33\16\33\u01db\13\33\3\34\3\34\3\34\3\34\5\34\u01e1\n\34\7\34"+
		"\u01e3\n\34\f\34\16\34\u01e6\13\34\3\35\3\35\3\35\5\35\u01eb\n\35\3\36"+
		"\3\36\3\37\3\37\3\37\3 \3 \3 \3 \5 \u01f6\n \3!\3!\3\"\3\"\3#\3#\5#\u01fe"+
		"\n#\3$\3$\3$\3$\3$\3$\5$\u0206\n$\3%\3%\5%\u020a\n%\3&\3&\3&\3&\3\'\3"+
		"\'\3\'\3\'\7\'\u0214\n\'\f\'\16\'\u0217\13\'\3\'\3\'\3(\3(\3(\6(\u021e"+
		"\n(\r(\16(\u021f\3)\3)\3)\3)\3)\5)\u0227\n)\3*\3*\3*\3*\3*\5*\u022e\n"+
		"*\3+\3+\3+\5+\u0233\n+\3,\3,\3,\5,\u0238\n,\3-\3-\3-\3-\7-\u023e\n-\f"+
		"-\16-\u0241\13-\3-\3-\3.\3.\3.\5.\u0248\n.\3.\3.\3.\5.\u024d\n.\3.\5."+
		"\u0250\n.\5.\u0252\n.\3/\3/\3\60\3\60\3\61\3\61\3\61\3\61\6\61\u025c\n"+
		"\61\r\61\16\61\u025d\3\62\3\62\3\63\3\63\3\63\3\63\5\63\u0266\n\63\3\64"+
		"\3\64\3\64\3\65\3\65\5\65\u026d\n\65\3\66\3\66\3\66\5\66\u0272\n\66\3"+
		"\66\3\66\3\67\3\67\5\67\u0278\n\67\3\67\3\67\38\38\38\38\38\38\38\38\3"+
		"8\58\u0285\n8\39\39\3:\3:\3:\3;\5;\u028d\n;\3;\3;\3;\3<\3<\5<\u0294\n"+
		"<\3<\3<\7<\u0298\n<\f<\16<\u029b\13<\3<\3<\3=\3=\3=\3=\5=\u02a3\n=\3>"+
		"\3>\3>\3?\3?\3?\3@\3@\3@\3A\3A\3B\3B\3C\3C\3D\3D\3E\3E\3E\3E\5E\u02ba"+
		"\nE\3F\3F\3F\3F\5F\u02c0\nF\3F\3F\5F\u02c4\nF\3F\5F\u02c7\nF\3G\3G\3H"+
		"\3H\3I\3I\5I\u02cf\nI\3I\3I\7I\u02d3\nI\fI\16I\u02d6\13I\3I\3I\3J\3J\5"+
		"J\u02dc\nJ\3K\3K\3K\3L\3L\3M\3M\3M\5M\u02e6\nM\3M\5M\u02e9\nM\3N\3N\3"+
		"N\2\2O\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<"+
		">@BDFHJLNPRTVXZ\\^`bdfhjlnprtvxz|~\u0080\u0082\u0084\u0086\u0088\u008a"+
		"\u008c\u008e\u0090\u0092\u0094\u0096\u0098\u009a\2\f\3\2\21\22\3\2\4\5"+
		"\3\2&(\3\2+,\3\2\60\61\4\2\63\67;;\3\289\3\2\36 \4\2\24\24\26\26\7\2!"+
		"#%%),.9;;\2\u0315\2\u00a3\3\2\2\2\4\u00c5\3\2\2\2\6\u00c7\3\2\2\2\b\u00cd"+
		"\3\2\2\2\n\u00e1\3\2\2\2\f\u00e3\3\2\2\2\16\u0108\3\2\2\2\20\u010d\3\2"+
		"\2\2\22\u0114\3\2\2\2\24\u0117\3\2\2\2\26\u012b\3\2\2\2\30\u012d\3\2\2"+
		"\2\32\u013b\3\2\2\2\34\u013d\3\2\2\2\36\u0151\3\2\2\2 \u0159\3\2\2\2\""+
		"\u0166\3\2\2\2$\u0173\3\2\2\2&\u0182\3\2\2\2(\u0196\3\2\2\2*\u0198\3\2"+
		"\2\2,\u01c0\3\2\2\2.\u01c2\3\2\2\2\60\u01cc\3\2\2\2\62\u01ce\3\2\2\2\64"+
		"\u01d0\3\2\2\2\66\u01dc\3\2\2\28\u01ea\3\2\2\2:\u01ec\3\2\2\2<\u01ee\3"+
		"\2\2\2>\u01f1\3\2\2\2@\u01f7\3\2\2\2B\u01f9\3\2\2\2D\u01fb\3\2\2\2F\u0205"+
		"\3\2\2\2H\u0209\3\2\2\2J\u020b\3\2\2\2L\u020f\3\2\2\2N\u021a\3\2\2\2P"+
		"\u0226\3\2\2\2R\u022d\3\2\2\2T\u022f\3\2\2\2V\u0234\3\2\2\2X\u0239\3\2"+
		"\2\2Z\u0251\3\2\2\2\\\u0253\3\2\2\2^\u0255\3\2\2\2`\u0257\3\2\2\2b\u025f"+
		"\3\2\2\2d\u0265\3\2\2\2f\u0267\3\2\2\2h\u026c\3\2\2\2j\u0271\3\2\2\2l"+
		"\u0277\3\2\2\2n\u0284\3\2\2\2p\u0286\3\2\2\2r\u0288\3\2\2\2t\u028c\3\2"+
		"\2\2v\u0291\3\2\2\2x\u02a2\3\2\2\2z\u02a4\3\2\2\2|\u02a7\3\2\2\2~\u02aa"+
		"\3\2\2\2\u0080\u02ad\3\2\2\2\u0082\u02af\3\2\2\2\u0084\u02b1\3\2\2\2\u0086"+
		"\u02b3\3\2\2\2\u0088\u02b9\3\2\2\2\u008a\u02bb\3\2\2\2\u008c\u02c8\3\2"+
		"\2\2\u008e\u02ca\3\2\2\2\u0090\u02cc\3\2\2\2\u0092\u02db\3\2\2\2\u0094"+
		"\u02dd\3\2\2\2\u0096\u02e0\3\2\2\2\u0098\u02e5\3\2\2\2\u009a\u02ea\3\2"+
		"\2\2\u009c\u00a4\7\13\2\2\u009d\u009f\7\n\2\2\u009e\u009d\3\2\2\2\u009f"+
		"\u00a2\3\2\2\2\u00a0\u009e\3\2\2\2\u00a0\u00a1\3\2\2\2\u00a1\u00a4\3\2"+
		"\2\2\u00a2\u00a0\3\2\2\2\u00a3\u009c\3\2\2\2\u00a3\u00a0\3\2\2\2\u00a4"+
		"\u00a6\3\2\2\2\u00a5\u00a7\5\4\3\2\u00a6\u00a5\3\2\2\2\u00a6\u00a7\3\2"+
		"\2\2\u00a7\u00b0\3\2\2\2\u00a8\u00aa\7\n\2\2\u00a9\u00a8\3\2\2\2\u00aa"+
		"\u00ab\3\2\2\2\u00ab\u00a9\3\2\2\2\u00ab\u00ac\3\2\2\2\u00ac\u00ad\3\2"+
		"\2\2\u00ad\u00af\5\4\3\2\u00ae\u00a9\3\2\2\2\u00af\u00b2\3\2\2\2\u00b0"+
		"\u00ae\3\2\2\2\u00b0\u00b1\3\2\2\2\u00b1\u00b6\3\2\2\2\u00b2\u00b0\3\2"+
		"\2\2\u00b3\u00b5\7\n\2\2\u00b4\u00b3\3\2\2\2\u00b5\u00b8\3\2\2\2\u00b6"+
		"\u00b4\3\2\2\2\u00b6\u00b7\3\2\2\2\u00b7\u00b9\3\2\2\2\u00b8\u00b6\3\2"+
		"\2\2\u00b9\u00ba\7\2\2\3\u00ba\3\3\2\2\2\u00bb\u00c6\5\f\7\2\u00bc\u00c6"+
		"\5\24\13\2\u00bd\u00c6\5\30\r\2\u00be\u00c6\5\b\5\2\u00bf\u00c6\5\6\4"+
		"\2\u00c0\u00c6\5\34\17\2\u00c1\u00c6\5 \21\2\u00c2\u00c6\5$\23\2\u00c3"+
		"\u00c6\5\"\22\2\u00c4\u00c6\5&\24\2\u00c5\u00bb\3\2\2\2\u00c5\u00bc\3"+
		"\2\2\2\u00c5\u00bd\3\2\2\2\u00c5\u00be\3\2\2\2\u00c5\u00bf\3\2\2\2\u00c5"+
		"\u00c0\3\2\2\2\u00c5\u00c1\3\2\2\2\u00c5\u00c2\3\2\2\2\u00c5\u00c3\3\2"+
		"\2\2\u00c5\u00c4\3\2\2\2\u00c6\5\3\2\2\2\u00c7\u00c8\7!\2\2\u00c8\u00c9"+
		"\7\13\2\2\u00c9\u00ca\5\u009aN\2\u00ca\u00cb\7\13\2\2\u00cb\u00cc\5D#"+
		"\2\u00cc\7\3\2\2\2\u00cd\u00ce\7\"\2\2\u00ce\u00cf\7\13\2\2\u00cf\u00d0"+
		"\5\u009aN\2\u00d0\u00d1\7\13\2\2\u00d1\u00d2\t\2\2\2\u00d2\u00d7\5\n\6"+
		"\2\u00d3\u00d4\t\3\2\2\u00d4\u00d6\5\n\6\2\u00d5\u00d3\3\2\2\2\u00d6\u00d9"+
		"\3\2\2\2\u00d7\u00d5\3\2\2\2\u00d7\u00d8\3\2\2\2\u00d8\u00db\3\2\2\2\u00d9"+
		"\u00d7\3\2\2\2\u00da\u00dc\7\5\2\2\u00db\u00da\3\2\2\2\u00db\u00dc\3\2"+
		"\2\2\u00dc\u00dd\3\2\2\2\u00dd\u00de\7\23\2\2\u00de\t\3\2\2\2\u00df\u00e2"+
		"\5r:\2\u00e0\u00e2\5\u0098M\2\u00e1\u00df\3\2\2\2\u00e1\u00e0\3\2\2\2"+
		"\u00e2\13\3\2\2\2\u00e3\u00e4\7#\2\2\u00e4\u0106\7\13\2\2\u00e5\u00ea"+
		"\5\20\t\2\u00e6\u00e7\7\4\2\2\u00e7\u00e9\5\20\t\2\u00e8\u00e6\3\2\2\2"+
		"\u00e9\u00ec\3\2\2\2\u00ea\u00e8\3\2\2\2\u00ea\u00eb\3\2\2\2\u00eb\u0107"+
		"\3\2\2\2\u00ec\u00ea\3\2\2\2\u00ed\u00ee\5\16\b\2\u00ee\u00ef\7\13\2\2"+
		"\u00ef\u00f1\3\2\2\2\u00f0\u00ed\3\2\2\2\u00f0\u00f1\3\2\2\2\u00f1\u00f2"+
		"\3\2\2\2\u00f2\u00f4\5\u009aN\2\u00f3\u00f5\7\13\2\2\u00f4\u00f3\3\2\2"+
		"\2\u00f4\u00f5\3\2\2\2\u00f5\u00f6\3\2\2\2\u00f6\u00fa\7\f\2\2\u00f7\u00f8"+
		"\5\22\n\2\u00f8\u00f9\7\4\2\2\u00f9\u00fb\3\2\2\2\u00fa\u00f7\3\2\2\2"+
		"\u00fa\u00fb\3\2\2\2\u00fb\u00fc\3\2\2\2\u00fc\u0101\5\u0096L\2\u00fd"+
		"\u00fe\7\4\2\2\u00fe\u0100\5\u0096L\2\u00ff\u00fd\3\2\2\2\u0100\u0103"+
		"\3\2\2\2\u0101\u00ff\3\2\2\2\u0101\u0102\3\2\2\2\u0102\u0104\3\2\2\2\u0103"+
		"\u0101\3\2\2\2\u0104\u0105\7\r\2\2\u0105\u0107\3\2\2\2\u0106\u00e5\3\2"+
		"\2\2\u0106\u00f0\3\2\2\2\u0107\r\3\2\2\2\u0108\u0109\7$\2\2\u0109\17\3"+
		"\2\2\2\u010a\u010b\5\16\b\2\u010b\u010c\7\13\2\2\u010c\u010e\3\2\2\2\u010d"+
		"\u010a\3\2\2\2\u010d\u010e\3\2\2\2\u010e\u0110\3\2\2\2\u010f\u0111\7\24"+
		"\2\2\u0110\u010f\3\2\2\2\u0110\u0111\3\2\2\2\u0111\u0112\3\2\2\2\u0112"+
		"\u0113\5\u009aN\2\u0113\21\3\2\2\2\u0114\u0115\7\16\2\2\u0115\u0116\5"+
		"\u0096L\2\u0116\23\3\2\2\2\u0117\u0118\7%\2\2\u0118\u0119\7\13\2\2\u0119"+
		"\u011a\5\u0098M\2\u011a\u0120\7\13\2\2\u011b\u011c\5\26\f\2\u011c\u011d"+
		"\7\13\2\2\u011d\u011f\3\2\2\2\u011e\u011b\3\2\2\2\u011f\u0122\3\2\2\2"+
		"\u0120\u011e\3\2\2\2\u0120\u0121\3\2\2\2\u0121\u0123\3\2\2\2\u0122\u0120"+
		"\3\2\2\2\u0123\u0128\5\u0090I\2\u0124\u0125\7\13\2\2\u0125\u0127\5\26"+
		"\f\2\u0126\u0124\3\2\2\2\u0127\u012a\3\2\2\2\u0128\u0126\3\2\2\2\u0128"+
		"\u0129\3\2\2\2\u0129\25\3\2\2\2\u012a\u0128\3\2\2\2\u012b\u012c\t\4\2"+
		"\2\u012c\27\3\2\2\2\u012d\u012e\7)\2\2\u012e\u012f\7\13\2\2\u012f\u0139"+
		"\5\32\16\2\u0130\u0131\7\4\2\2\u0131\u0133\5\32\16\2\u0132\u0130\3\2\2"+
		"\2\u0133\u0136\3\2\2\2\u0134\u0132\3\2\2\2\u0134\u0135\3\2\2\2\u0135\u013a"+
		"\3\2\2\2\u0136\u0134\3\2\2\2\u0137\u0138\7\13\2\2\u0138\u013a\5\u0090"+
		"I\2\u0139\u0134\3\2\2\2\u0139\u0137\3\2\2\2\u013a\31\3\2\2\2\u013b\u013c"+
		"\5\u0098M\2\u013c\33\3\2\2\2\u013d\u013e\7*\2\2\u013e\u014f\7\27\2\2\u013f"+
		"\u0141\7\n\2\2\u0140\u013f\3\2\2\2\u0141\u0142\3\2\2\2\u0142\u0140\3\2"+
		"\2\2\u0142\u0143\3\2\2\2\u0143\u0144\3\2\2\2\u0144\u0150\t\5\2\2\u0145"+
		"\u0147\7\n\2\2\u0146\u0145\3\2\2\2\u0147\u0148\3\2\2\2\u0148\u0146\3\2"+
		"\2\2\u0148\u0149\3\2\2\2\u0149\u014a\3\2\2\2\u014a\u014c\5\36\20\2\u014b"+
		"\u0146\3\2\2\2\u014c\u014d\3\2\2\2\u014d\u014b\3\2\2\2\u014d\u014e\3\2"+
		"\2\2\u014e\u0150\3\2\2\2\u014f\u0140\3\2\2\2\u014f\u014b\3\2\2\2\u0150"+
		"\35\3\2\2\2\u0151\u0154\5F$\2\u0152\u0153\7\6\2\2\u0153\u0155\5\u0090"+
		"I\2\u0154\u0152\3\2\2\2\u0154\u0155\3\2\2\2\u0155\u0157\3\2\2\2\u0156"+
		"\u0158\5R*\2\u0157\u0156\3\2\2\2\u0157\u0158\3\2\2\2\u0158\37\3\2\2\2"+
		"\u0159\u015c\7.\2\2\u015a\u015b\7\13\2\2\u015b\u015d\7\62\2\2\u015c\u015a"+
		"\3\2\2\2\u015c\u015d\3\2\2\2\u015d\u015e\3\2\2\2\u015e\u0160\7\27\2\2"+
		"\u015f\u0161\7\n\2\2\u0160\u015f\3\2\2\2\u0161\u0162\3\2\2\2\u0162\u0160"+
		"\3\2\2\2\u0162\u0163\3\2\2\2\u0163\u0164\3\2\2\2\u0164\u0165\5*\26\2\u0165"+
		"!\3\2\2\2\u0166\u0169\7/\2\2\u0167\u0168\7\13\2\2\u0168\u016a\7\62\2\2"+
		"\u0169\u0167\3\2\2\2\u0169\u016a\3\2\2\2\u016a\u016b\3\2\2\2\u016b\u016d"+
		"\7\27\2\2\u016c\u016e\7\n\2\2\u016d\u016c\3\2\2\2\u016e\u016f\3\2\2\2"+
		"\u016f\u016d\3\2\2\2\u016f\u0170\3\2\2\2\u0170\u0171\3\2\2\2\u0171\u0172"+
		"\5*\26\2\u0172#\3\2\2\2\u0173\u0174\7/\2\2\u0174\u0175\7\26\2\2\u0175"+
		"\u0178\5\66\34\2\u0176\u0177\7\13\2\2\u0177\u0179\7\62\2\2\u0178\u0176"+
		"\3\2\2\2\u0178\u0179\3\2\2\2\u0179\u017a\3\2\2\2\u017a\u017c\7\27\2\2"+
		"\u017b\u017d\7\n\2\2\u017c\u017b\3\2\2\2\u017d\u017e\3\2\2\2\u017e\u017c"+
		"\3\2\2\2\u017e\u017f\3\2\2\2\u017f\u0180\3\2\2\2\u0180\u0181\5*\26\2\u0181"+
		"%\3\2\2\2\u0182\u0187\5\66\34\2\u0183\u0184\7\13\2\2\u0184\u0186\5\60"+
		"\31\2\u0185\u0183\3\2\2\2\u0186\u0189\3\2\2\2\u0187\u0185\3\2\2\2\u0187"+
		"\u0188\3\2\2\2\u0188\u018b\3\2\2\2\u0189\u0187\3\2\2\2\u018a\u018c\7\27"+
		"\2\2\u018b\u018a\3\2\2\2\u018b\u018c\3\2\2\2\u018c\u018e\3\2\2\2\u018d"+
		"\u018f\7\n\2\2\u018e\u018d\3\2\2\2\u018f\u0190\3\2\2\2\u0190\u018e\3\2"+
		"\2\2\u0190\u0191\3\2\2\2\u0191\u0192\3\2\2\2\u0192\u0193\5*\26\2\u0193"+
		"\'\3\2\2\2\u0194\u0197\5r:\2\u0195\u0197\5v<\2\u0196\u0194\3\2\2\2\u0196"+
		"\u0195\3\2\2\2\u0197)\3\2\2\2\u0198\u01ac\5,\27\2\u0199\u019b\7\n\2\2"+
		"\u019a\u0199\3\2\2\2\u019b\u019c\3\2\2\2\u019c\u019a\3\2\2\2\u019c\u019d"+
		"\3\2\2\2\u019d\u019e\3\2\2\2\u019e\u019f\5.\30\2\u019f\u01a6\7\27\2\2"+
		"\u01a0\u01a7\7\13\2\2\u01a1\u01a3\7\n\2\2\u01a2\u01a1\3\2\2\2\u01a3\u01a4"+
		"\3\2\2\2\u01a4\u01a2\3\2\2\2\u01a4\u01a5\3\2\2\2\u01a5\u01a7\3\2\2\2\u01a6"+
		"\u01a0\3\2\2\2\u01a6\u01a2\3\2\2\2\u01a7\u01a8\3\2\2\2\u01a8\u01a9\5,"+
		"\27\2\u01a9\u01ab\3\2\2\2\u01aa\u019a\3\2\2\2\u01ab\u01ae\3\2\2\2\u01ac"+
		"\u01aa\3\2\2\2\u01ac\u01ad\3\2\2\2\u01ad+\3\2\2\2\u01ae\u01ac\3\2\2\2"+
		"\u01af\u01c1\5\64\33\2\u01b0\u01b4\7\f\2\2\u01b1\u01b3\7\n\2\2\u01b2\u01b1"+
		"\3\2\2\2\u01b3\u01b6\3\2\2\2\u01b4\u01b2\3\2\2\2\u01b4\u01b5\3\2\2\2\u01b5"+
		"\u01b7\3\2\2\2\u01b6\u01b4\3\2\2\2\u01b7\u01bb\5*\26\2\u01b8\u01ba\7\n"+
		"\2\2\u01b9\u01b8\3\2\2\2\u01ba\u01bd\3\2\2\2\u01bb\u01b9\3\2\2\2\u01bb"+
		"\u01bc\3\2\2\2\u01bc\u01be\3\2\2\2\u01bd\u01bb\3\2\2\2\u01be\u01bf\7\r"+
		"\2\2\u01bf\u01c1\3\2\2\2\u01c0\u01af\3\2\2\2\u01c0\u01b0\3\2\2\2\u01c1"+
		"-\3\2\2\2\u01c2\u01c7\t\6\2\2\u01c3\u01c4\7\13\2\2\u01c4\u01c6\5\60\31"+
		"\2\u01c5\u01c3\3\2\2\2\u01c6\u01c9\3\2\2\2\u01c7\u01c5\3\2\2\2\u01c7\u01c8"+
		"\3\2\2\2\u01c8/\3\2\2\2\u01c9\u01c7\3\2\2\2\u01ca\u01cd\5(\25\2\u01cb"+
		"\u01cd\5\62\32\2\u01cc\u01ca\3\2\2\2\u01cc\u01cb\3\2\2\2\u01cd\61\3\2"+
		"\2\2\u01ce\u01cf\t\7\2\2\u01cf\63\3\2\2\2\u01d0\u01d9\58\35\2\u01d1\u01d3"+
		"\7\n\2\2\u01d2\u01d1\3\2\2\2\u01d3\u01d4\3\2\2\2\u01d4\u01d2\3\2\2\2\u01d4"+
		"\u01d5\3\2\2\2\u01d5\u01d6\3\2\2\2\u01d6\u01d8\58\35\2\u01d7\u01d2\3\2"+
		"\2\2\u01d8\u01db\3\2\2\2\u01d9\u01d7\3\2\2\2\u01d9\u01da\3\2\2\2\u01da"+
		"\65\3\2\2\2\u01db\u01d9\3\2\2\2\u01dc\u01e4\5\u009aN\2\u01dd\u01e0\7\26"+
		"\2\2\u01de\u01e1\5\u009aN\2\u01df\u01e1\7:\2\2\u01e0\u01de\3\2\2\2\u01e0"+
		"\u01df\3\2\2\2\u01e1\u01e3\3\2\2\2\u01e2\u01dd\3\2\2\2\u01e3\u01e6\3\2"+
		"\2\2\u01e4\u01e2\3\2\2\2\u01e4\u01e5\3\2\2\2\u01e5\67\3\2\2\2\u01e6\u01e4"+
		"\3\2\2\2\u01e7\u01eb\5:\36\2\u01e8\u01eb\5<\37\2\u01e9\u01eb\5> \2\u01ea"+
		"\u01e7\3\2\2\2\u01ea\u01e8\3\2\2\2\u01ea\u01e9\3\2\2\2\u01eb9\3\2\2\2"+
		"\u01ec\u01ed\t\b\2\2\u01ed;\3\2\2\2\u01ee\u01ef\7\27\2\2\u01ef\u01f0\5"+
		"\66\34\2\u01f0=\3\2\2\2\u01f1\u01f2\5@!\2\u01f2\u01f3\7\6\2\2\u01f3\u01f5"+
		"\5B\"\2\u01f4\u01f6\5R*\2\u01f5\u01f4\3\2\2\2\u01f5\u01f6\3\2\2\2\u01f6"+
		"?\3\2\2\2\u01f7\u01f8\5D#\2\u01f8A\3\2\2\2\u01f9\u01fa\5F$\2\u01faC\3"+
		"\2\2\2\u01fb\u01fd\5F$\2\u01fc\u01fe\5R*\2\u01fd\u01fc\3\2\2\2\u01fd\u01fe"+
		"\3\2\2\2\u01feE\3\2\2\2\u01ff\u0206\5H%\2\u0200\u0206\5`\61\2\u0201\u0206"+
		"\5f\64\2\u0202\u0206\5h\65\2\u0203\u0206\5n8\2\u0204\u0206\5N(\2\u0205"+
		"\u01ff\3\2\2\2\u0205\u0200\3\2\2\2\u0205\u0201\3\2\2\2\u0205\u0202\3\2"+
		"\2\2\u0205\u0203\3\2\2\2\u0205\u0204\3\2\2\2\u0206G\3\2\2\2\u0207\u020a"+
		"\5J&\2\u0208\u020a\5L\'\2\u0209\u0207\3\2\2\2\u0209\u0208\3\2\2\2\u020a"+
		"I\3\2\2\2\u020b\u020c\7\f\2\2\u020c\u020d\5D#\2\u020d\u020e\7\r\2\2\u020e"+
		"K\3\2\2\2\u020f\u0210\7\21\2\2\u0210\u0215\5D#\2\u0211\u0212\7\4\2\2\u0212"+
		"\u0214\5D#\2\u0213\u0211\3\2\2\2\u0214\u0217\3\2\2\2\u0215\u0213\3\2\2"+
		"\2\u0215\u0216\3\2\2\2\u0216\u0218\3\2\2\2\u0217\u0215\3\2\2\2\u0218\u0219"+
		"\7\23\2\2\u0219M\3\2\2\2\u021a\u021d\5P)\2\u021b\u021c\7\13\2\2\u021c"+
		"\u021e\5P)\2\u021d\u021b\3\2\2\2\u021e\u021f\3\2\2\2\u021f\u021d\3\2\2"+
		"\2\u021f\u0220\3\2\2\2\u0220O\3\2\2\2\u0221\u0227\5H%\2\u0222\u0227\5"+
		"`\61\2\u0223\u0227\5f\64\2\u0224\u0227\5h\65\2\u0225\u0227\5n8\2\u0226"+
		"\u0221\3\2\2\2\u0226\u0222\3\2\2\2\u0226\u0223\3\2\2\2\u0226\u0224\3\2"+
		"\2\2\u0226\u0225\3\2\2\2\u0227Q\3\2\2\2\u0228\u022e\5T+\2\u0229\u022e"+
		"\5V,\2\u022a\u022b\5T+\2\u022b\u022c\5V,\2\u022c\u022e\3\2\2\2\u022d\u0228"+
		"\3\2\2\2\u022d\u0229\3\2\2\2\u022d\u022a\3\2\2\2\u022eS\3\2\2\2\u022f"+
		"\u0232\7\7\2\2\u0230\u0233\5Z.\2\u0231\u0233\5X-\2\u0232\u0230\3\2\2\2"+
		"\u0232\u0231\3\2\2\2\u0233U\3\2\2\2\u0234\u0237\7\b\2\2\u0235\u0238\5"+
		"Z.\2\u0236\u0238\5X-\2\u0237\u0235\3\2\2\2\u0237\u0236\3\2\2\2\u0238W"+
		"\3\2\2\2\u0239\u023a\7\21\2\2\u023a\u023f\5Z.\2\u023b\u023c\7\4\2\2\u023c"+
		"\u023e\5Z.\2\u023d\u023b\3\2\2\2\u023e\u0241\3\2\2\2\u023f\u023d\3\2\2"+
		"\2\u023f\u0240\3\2\2\2\u0240\u0242\3\2\2\2\u0241\u023f\3\2\2\2\u0242\u0243"+
		"\7\23\2\2\u0243Y\3\2\2\2\u0244\u0245\5\\/\2\u0245\u0246\7\13\2\2\u0246"+
		"\u0248\3\2\2\2\u0247\u0244\3\2\2\2\u0247\u0248\3\2\2\2\u0248\u0249\3\2"+
		"\2\2\u0249\u024c\7\t\2\2\u024a\u024b\7\13\2\2\u024b\u024d\5^\60\2\u024c"+
		"\u024a\3\2\2\2\u024c\u024d\3\2\2\2\u024d\u0252\3\2\2\2\u024e\u0250\5\\"+
		"/\2\u024f\u024e\3\2\2\2\u024f\u0250\3\2\2\2\u0250\u0252\3\2\2\2\u0251"+
		"\u0247\3\2\2\2\u0251\u024f\3\2\2\2\u0252[\3\2\2\2\u0253\u0254\5F$\2\u0254"+
		"]\3\2\2\2\u0255\u0256\5F$\2\u0256_\3\2\2\2\u0257\u025b\5d\63\2\u0258\u0259"+
		"\5b\62\2\u0259\u025a\5d\63\2\u025a\u025c\3\2\2\2\u025b\u0258\3\2\2\2\u025c"+
		"\u025d\3\2\2\2\u025d\u025b\3\2\2\2\u025d\u025e\3\2\2\2\u025ea\3\2\2\2"+
		"\u025f\u0260\t\t\2\2\u0260c\3\2\2\2\u0261\u0266\5H%\2\u0262\u0266\5f\64"+
		"\2\u0263\u0266\5h\65\2\u0264\u0266\5n8\2\u0265\u0261\3\2\2\2\u0265\u0262"+
		"\3\2\2\2\u0265\u0263\3\2\2\2\u0265\u0264\3\2\2\2\u0266e\3\2\2\2\u0267"+
		"\u0268\7\31\2\2\u0268\u0269\5n8\2\u0269g\3\2\2\2\u026a\u026d\5j\66\2\u026b"+
		"\u026d\5l\67\2\u026c\u026a\3\2\2\2\u026c\u026b\3\2\2\2\u026di\3\2\2\2"+
		"\u026e\u0272\5H%\2\u026f\u0272\5f\64\2\u0270\u0272\5n8\2\u0271\u026e\3"+
		"\2\2\2\u0271\u026f\3\2\2\2\u0271\u0270\3\2\2\2\u0272\u0273\3\2\2\2\u0273"+
		"\u0274\5t;\2\u0274k\3\2\2\2\u0275\u0278\5H%\2\u0276\u0278\5n8\2\u0277"+
		"\u0275\3\2\2\2\u0277\u0276\3\2\2\2\u0278\u0279\3\2\2\2\u0279\u027a\5\u0088"+
		"E\2\u027am\3\2\2\2\u027b\u0285\5p9\2\u027c\u0285\5r:\2\u027d\u0285\5t"+
		";\2\u027e\u0285\5v<\2\u027f\u0285\5\u0080A\2\u0280\u0285\5\u0082B\2\u0281"+
		"\u0285\5\u0084C\2\u0282\u0285\5\u0086D\2\u0283\u0285\5\u0098M\2\u0284"+
		"\u027b\3\2\2\2\u0284\u027c\3\2\2\2\u0284\u027d\3\2\2\2\u0284\u027e\3\2"+
		"\2\2\u0284\u027f\3\2\2\2\u0284\u0280\3\2\2\2\u0284\u0281\3\2\2\2\u0284"+
		"\u0282\3\2\2\2\u0284\u0283\3\2\2\2\u0285o\3\2\2\2\u0286\u0287\7-\2\2\u0287"+
		"q\3\2\2\2\u0288\u0289\7\35\2\2\u0289\u028a\5\u009aN\2\u028as\3\2\2\2\u028b"+
		"\u028d\7\30\2\2\u028c\u028b\3\2\2\2\u028c\u028d\3\2\2\2\u028d\u028e\3"+
		"\2\2\2\u028e\u028f\7\33\2\2\u028f\u0290\7:\2\2\u0290u\3\2\2\2\u0291\u0293"+
		"\7\17\2\2\u0292\u0294\5x=\2\u0293\u0292\3\2\2\2\u0293\u0294\3\2\2\2\u0294"+
		"\u0299\3\2\2\2\u0295\u0296\7\13\2\2\u0296\u0298\5x=\2\u0297\u0295\3\2"+
		"\2\2\u0298\u029b\3\2\2\2\u0299\u0297\3\2\2\2\u0299\u029a\3\2\2\2\u029a"+
		"\u029c\3\2\2\2\u029b\u0299\3\2\2\2\u029c\u029d\7\20\2\2\u029dw\3\2\2\2"+
		"\u029e\u02a3\5\u0092J\2\u029f\u02a3\5z>\2\u02a0\u02a3\5|?\2\u02a1\u02a3"+
		"\5~@\2\u02a2\u029e\3\2\2\2\u02a2\u029f\3\2\2\2\u02a2\u02a0\3\2\2\2\u02a2"+
		"\u02a1\3\2\2\2\u02a3y\3\2\2\2\u02a4\u02a5\7\31\2\2\u02a5\u02a6\5\u0092"+
		"J\2\u02a6{\3\2\2\2\u02a7\u02a8\7\16\2\2\u02a8\u02a9\5\u009aN\2\u02a9}"+
		"\3\2\2\2\u02aa\u02ab\7\33\2\2\u02ab\u02ac\5\u009aN\2\u02ac\177\3\2\2\2"+
		"\u02ad\u02ae\7\16\2\2\u02ae\u0081\3\2\2\2\u02af\u02b0\7\32\2\2\u02b0\u0083"+
		"\3\2\2\2\u02b1\u02b2\7\33\2\2\u02b2\u0085\3\2\2\2\u02b3\u02b4\7\34\2\2"+
		"\u02b4\u0087\3\2\2\2\u02b5\u02ba\5\u008aF\2\u02b6\u02ba\7\24\2\2\u02b7"+
		"\u02ba\7\16\2\2\u02b8\u02ba\7\25\2\2\u02b9\u02b5\3\2\2\2\u02b9\u02b6\3"+
		"\2\2\2\u02b9\u02b7\3\2\2\2\u02b9\u02b8\3\2\2\2\u02ba\u0089\3\2\2\2\u02bb"+
		"\u02c6\7\16\2\2\u02bc\u02c7\7:\2\2\u02bd\u02bf\7\f\2\2\u02be\u02c0\5\u008c"+
		"G\2\u02bf\u02be\3\2\2\2\u02bf\u02c0\3\2\2\2\u02c0\u02c1\3\2\2\2\u02c1"+
		"\u02c3\7\26\2\2\u02c2\u02c4\5\u008eH\2\u02c3\u02c2\3\2\2\2\u02c3\u02c4"+
		"\3\2\2\2\u02c4\u02c5\3\2\2\2\u02c5\u02c7\7\r\2\2\u02c6\u02bc\3\2\2\2\u02c6"+
		"\u02bd\3\2\2\2\u02c7\u008b\3\2\2\2\u02c8\u02c9\7:\2\2\u02c9\u008d\3\2"+
		"\2\2\u02ca\u02cb\7:\2\2\u02cb\u008f\3\2\2\2\u02cc\u02ce\7\17\2\2\u02cd"+
		"\u02cf\5\u0092J\2\u02ce\u02cd\3\2\2\2\u02ce\u02cf\3\2\2\2\u02cf\u02d4"+
		"\3\2\2\2\u02d0\u02d1\7\13\2\2\u02d1\u02d3\5\u0092J\2\u02d2\u02d0\3\2\2"+
		"\2\u02d3\u02d6\3\2\2\2\u02d4\u02d2\3\2\2\2\u02d4\u02d5\3\2\2\2\u02d5\u02d7"+
		"\3\2\2\2\u02d6\u02d4\3\2\2\2\u02d7\u02d8\7\20\2\2\u02d8\u0091\3\2\2\2"+
		"\u02d9\u02dc\5\u0094K\2\u02da\u02dc\5\u0096L\2\u02db\u02d9\3\2\2\2\u02db"+
		"\u02da\3\2\2\2\u02dc\u0093\3\2\2\2\u02dd\u02de\t\n\2\2\u02de\u02df\5\u009a"+
		"N\2\u02df\u0095\3\2\2\2\u02e0\u02e1\5\u009aN\2\u02e1\u0097\3\2\2\2\u02e2"+
		"\u02e6\5\u009aN\2\u02e3\u02e6\7<\2\2\u02e4\u02e6\7=\2\2\u02e5\u02e2\3"+
		"\2\2\2\u02e5\u02e3\3\2\2\2\u02e5\u02e4\3\2\2\2\u02e6\u02e8\3\2\2\2\u02e7"+
		"\u02e9\7\31\2\2\u02e8\u02e7\3\2\2\2\u02e8\u02e9\3\2\2\2\u02e9\u0099\3"+
		"\2\2\2\u02ea\u02eb\t\13\2\2\u02eb\u009b\3\2\2\2X\u00a0\u00a3\u00a6\u00ab"+
		"\u00b0\u00b6\u00c5\u00d7\u00db\u00e1\u00ea\u00f0\u00f4\u00fa\u0101\u0106"+
		"\u010d\u0110\u0120\u0128\u0134\u0139\u0142\u0148\u014d\u014f\u0154\u0157"+
		"\u015c\u0162\u0169\u016f\u0178\u017e\u0187\u018b\u0190\u0196\u019c\u01a4"+
		"\u01a6\u01ac\u01b4\u01bb\u01c0\u01c7\u01cc\u01d4\u01d9\u01e0\u01e4\u01ea"+
		"\u01f5\u01fd\u0205\u0209\u0215\u021f\u0226\u022d\u0232\u0237\u023f\u0247"+
		"\u024c\u024f\u0251\u025d\u0265\u026c\u0271\u0277\u0284\u028c\u0293\u0299"+
		"\u02a2\u02b9\u02bf\u02c3\u02c6\u02ce\u02d4\u02db\u02e5\u02e8";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}