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
			setState(182);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case WHITESPACE:
				enterOuterAlt(_localctx, 1);
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
				enterOuterAlt(_localctx, 2);
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
				setState(162);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ELEMENT_DECL) | (1L << CLASS_DECL) | (1L << FEATURE_DECL) | (1L << DIACRITIC_DECL) | (1L << SYMBOL_DECL) | (1L << SYLLABLE_DECL) | (1L << EXPLICIT_SYLLABLES) | (1L << CLEAR_SYLLABLES) | (1L << DEROMANIZER) | (1L << ROMANIZER) | (1L << ALL_MATCHING) | (1L << FIRST_MATCHING) | (1L << LITERAL) | (1L << LTR) | (1L << RTL) | (1L << PROPAGATE) | (1L << CLEANUP) | (1L << BLOCK) | (1L << UNCHANGED) | (1L << OFF) | (1L << NAME))) != 0)) {
					{
					setState(161);
					statement();
					}
				}

				setState(172);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(165); 
						_errHandler.sync(this);
						_la = _input.LA(1);
						do {
							{
							{
							setState(164);
							match(NEWLINE);
							}
							}
							setState(167); 
							_errHandler.sync(this);
							_la = _input.LA(1);
						} while ( _la==NEWLINE );
						setState(169);
						statement();
						}
						} 
					}
					setState(174);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
				}
				setState(178);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NEWLINE) {
					{
					{
					setState(175);
					match(NEWLINE);
					}
					}
					setState(180);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(181);
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
			setState(194);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(184);
				featureDecl();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(185);
				diacriticDecl();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(186);
				symbolDecl();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(187);
				classDecl();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(188);
				elementDecl();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(189);
				syllableDecl();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(190);
				deromanizer();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(191);
				interRomanizer();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(192);
				romanizer();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(193);
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
			setState(196);
			match(ELEMENT_DECL);
			setState(197);
			match(WHITESPACE);
			setState(198);
			name();
			setState(199);
			match(WHITESPACE);
			setState(200);
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
			setState(202);
			match(CLASS_DECL);
			setState(203);
			match(WHITESPACE);
			setState(204);
			name();
			setState(205);
			match(WHITESPACE);
			setState(206);
			_la = _input.LA(1);
			if ( !(_la==LIST_START || _la==CLASS_START) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(207);
			classElement();
			setState(212);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(208);
					_la = _input.LA(1);
					if ( !(_la==LIST_SEP || _la==CLASS_SEP) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(209);
					classElement();
					}
					} 
				}
				setState(214);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			}
			setState(216);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CLASS_SEP) {
				{
				setState(215);
				match(CLASS_SEP);
				}
			}

			setState(218);
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
			setState(222);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CLASSREF:
				enterOuterAlt(_localctx, 1);
				{
				setState(220);
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
				setState(221);
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
			setState(224);
			match(FEATURE_DECL);
			setState(225);
			match(WHITESPACE);
			setState(259);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				{
				{
				setState(226);
				plusFeature();
				setState(231);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==LIST_SEP) {
					{
					{
					setState(227);
					match(LIST_SEP);
					setState(228);
					plusFeature();
					}
					}
					setState(233);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				break;
			case 2:
				{
				{
				setState(237);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SYLLABLE_FEATURE) {
					{
					setState(234);
					featureModifier();
					setState(235);
					match(WHITESPACE);
					}
				}

				setState(239);
				name();
				setState(241);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==WHITESPACE) {
					{
					setState(240);
					match(WHITESPACE);
					}
				}

				setState(243);
				match(O_PAREN);
				setState(247);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NULL) {
					{
					setState(244);
					nullAlias();
					setState(245);
					match(LIST_SEP);
					}
				}

				setState(249);
				featureValue();
				setState(254);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==LIST_SEP) {
					{
					{
					setState(250);
					match(LIST_SEP);
					setState(251);
					featureValue();
					}
					}
					setState(256);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(257);
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
			setState(261);
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
			setState(266);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SYLLABLE_FEATURE) {
				{
				setState(263);
				featureModifier();
				setState(264);
				match(WHITESPACE);
				}
			}

			setState(269);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==AT_LEAST_ONE) {
				{
				setState(268);
				match(AT_LEAST_ONE);
				}
			}

			setState(271);
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
			setState(273);
			match(NULL);
			setState(274);
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
			setState(276);
			match(DIACRITIC_DECL);
			setState(277);
			match(WHITESPACE);
			setState(278);
			text();
			setState(279);
			match(WHITESPACE);
			setState(285);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DIA_BEFORE) | (1L << DIA_FIRST) | (1L << DIA_FLOATING))) != 0)) {
				{
				{
				setState(280);
				diacriticModifier();
				setState(281);
				match(WHITESPACE);
				}
				}
				setState(287);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(288);
			matrix();
			setState(293);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WHITESPACE) {
				{
				{
				setState(289);
				match(WHITESPACE);
				setState(290);
				diacriticModifier();
				}
				}
				setState(295);
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
			setState(296);
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
			setState(298);
			match(SYMBOL_DECL);
			setState(299);
			match(WHITESPACE);
			setState(300);
			symbolName();
			setState(310);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case EOF:
			case LIST_SEP:
			case NEWLINE:
				{
				setState(305);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==LIST_SEP) {
					{
					{
					setState(301);
					match(LIST_SEP);
					setState(302);
					symbolName();
					}
					}
					setState(307);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case WHITESPACE:
				{
				setState(308);
				match(WHITESPACE);
				setState(309);
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
			setState(312);
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
			setState(314);
			match(SYLLABLE_DECL);
			setState(315);
			match(RULE_START);
			setState(332);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
			case 1:
				{
				setState(317); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(316);
					match(NEWLINE);
					}
					}
					setState(319); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NEWLINE );
				setState(321);
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
				setState(328); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(323); 
						_errHandler.sync(this);
						_la = _input.LA(1);
						do {
							{
							{
							setState(322);
							match(NEWLINE);
							}
							}
							setState(325); 
							_errHandler.sync(this);
							_la = _input.LA(1);
						} while ( _la==NEWLINE );
						setState(327);
						syllablePattern();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(330); 
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
			setState(334);
			unconditionalRuleElement();
			setState(337);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CHANGE) {
				{
				setState(335);
				match(CHANGE);
				setState(336);
				matrix();
				}
			}

			setState(340);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CONDITION || _la==EXCLUSION) {
				{
				setState(339);
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
			setState(342);
			match(DEROMANIZER);
			setState(345);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WHITESPACE) {
				{
				setState(343);
				match(WHITESPACE);
				setState(344);
				match(LITERAL);
				}
			}

			setState(347);
			match(RULE_START);
			setState(349); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(348);
				match(NEWLINE);
				}
				}
				setState(351); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NEWLINE );
			setState(353);
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
			setState(355);
			match(ROMANIZER);
			setState(358);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WHITESPACE) {
				{
				setState(356);
				match(WHITESPACE);
				setState(357);
				match(LITERAL);
				}
			}

			setState(360);
			match(RULE_START);
			setState(362); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(361);
				match(NEWLINE);
				}
				}
				setState(364); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NEWLINE );
			setState(366);
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
			setState(368);
			match(ROMANIZER);
			setState(369);
			match(HYPHEN);
			setState(370);
			ruleName();
			setState(373);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WHITESPACE) {
				{
				setState(371);
				match(WHITESPACE);
				setState(372);
				match(LITERAL);
				}
			}

			setState(375);
			match(RULE_START);
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
			setState(383);
			ruleName();
			setState(388);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WHITESPACE) {
				{
				{
				setState(384);
				match(WHITESPACE);
				setState(385);
				changeRuleModifier();
				}
				}
				setState(390);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(392);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==RULE_START) {
				{
				setState(391);
				match(RULE_START);
				}
			}

			setState(395); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(394);
				match(NEWLINE);
				}
				}
				setState(397); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NEWLINE );
			setState(399);
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
			setState(403);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CLASSREF:
				enterOuterAlt(_localctx, 1);
				{
				setState(401);
				elementRef();
				}
				break;
			case MATRIX_START:
				enterOuterAlt(_localctx, 2);
				{
				setState(402);
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
			setState(405);
			blockElement();
			setState(425);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,41,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(407); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(406);
						match(NEWLINE);
						}
						}
						setState(409); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==NEWLINE );
					setState(411);
					blockType();
					setState(412);
					match(RULE_START);
					setState(419);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case WHITESPACE:
						{
						setState(413);
						match(WHITESPACE);
						}
						break;
					case NEWLINE:
						{
						setState(415); 
						_errHandler.sync(this);
						_la = _input.LA(1);
						do {
							{
							{
							setState(414);
							match(NEWLINE);
							}
							}
							setState(417); 
							_errHandler.sync(this);
							_la = _input.LA(1);
						} while ( _la==NEWLINE );
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(421);
					blockElement();
					}
					} 
				}
				setState(427);
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
			setState(445);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,44,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(428);
				expressionList();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(429);
				match(O_PAREN);
				setState(433);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NEWLINE) {
					{
					{
					setState(430);
					match(NEWLINE);
					}
					}
					setState(435);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(436);
				block();
				setState(440);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NEWLINE) {
					{
					{
					setState(437);
					match(NEWLINE);
					}
					}
					setState(442);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(443);
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
			setState(447);
			_la = _input.LA(1);
			if ( !(_la==ALL_MATCHING || _la==FIRST_MATCHING) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(452);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WHITESPACE) {
				{
				{
				setState(448);
				match(WHITESPACE);
				setState(449);
				changeRuleModifier();
				}
				}
				setState(454);
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
			setState(457);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case MATRIX_START:
			case CLASSREF:
				enterOuterAlt(_localctx, 1);
				{
				setState(455);
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
				setState(456);
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
			setState(459);
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
			setState(461);
			expression();
			setState(470);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,48,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(463); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(462);
						match(NEWLINE);
						}
						}
						setState(465); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==NEWLINE );
					setState(467);
					expression();
					}
					} 
				}
				setState(472);
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
			setState(473);
			name();
			setState(481);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==HYPHEN) {
				{
				{
				setState(474);
				match(HYPHEN);
				setState(477);
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
					setState(475);
					name();
					}
					break;
				case NUMBER:
					{
					setState(476);
					match(NUMBER);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
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
			setState(487);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,51,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(484);
				keywordExpression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(485);
				blockRef();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(486);
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
			setState(489);
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
			setState(491);
			match(RULE_START);
			setState(492);
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
			setState(494);
			from();
			setState(495);
			match(CHANGE);
			setState(496);
			to();
			setState(498);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CONDITION || _la==EXCLUSION) {
				{
				setState(497);
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
			setState(500);
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
			setState(502);
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
			setState(504);
			unconditionalRuleElement();
			setState(506);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CONDITION || _la==EXCLUSION) {
				{
				setState(505);
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
			setState(514);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,54,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(508);
				bounded();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(509);
				interfix();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(510);
				negated();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(511);
				postfix();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(512);
				simple();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(513);
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
			setState(518);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case O_PAREN:
				enterOuterAlt(_localctx, 1);
				{
				setState(516);
				group();
				}
				break;
			case LIST_START:
				enterOuterAlt(_localctx, 2);
				{
				setState(517);
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
			setState(520);
			match(O_PAREN);
			setState(521);
			ruleElement();
			setState(522);
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
			setState(524);
			match(LIST_START);
			setState(525);
			ruleElement();
			setState(530);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LIST_SEP) {
				{
				{
				setState(526);
				match(LIST_SEP);
				setState(527);
				ruleElement();
				}
				}
				setState(532);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(533);
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
			setState(535);
			freeElement();
			setState(538); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(536);
					match(WHITESPACE);
					setState(537);
					freeElement();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(540); 
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
			setState(547);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,58,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(542);
				bounded();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(543);
				interfix();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(544);
				negated();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(545);
				postfix();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(546);
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
			setState(554);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,59,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(549);
				condition();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(550);
				exclusion();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				{
				setState(551);
				condition();
				setState(552);
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
			setState(556);
			match(CONDITION);
			setState(559);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,60,_ctx) ) {
			case 1:
				{
				setState(557);
				environment();
				}
				break;
			case 2:
				{
				setState(558);
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
			setState(561);
			match(EXCLUSION);
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
			setState(566);
			match(LIST_START);
			setState(567);
			environment();
			setState(572);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LIST_SEP) {
				{
				{
				setState(568);
				match(LIST_SEP);
				setState(569);
				environment();
				}
				}
				setState(574);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(575);
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
			setState(590);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,66,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(580);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << O_PAREN) | (1L << NULL) | (1L << MATRIX_START) | (1L << LIST_START) | (1L << INEXACT) | (1L << NEGATION) | (1L << SYLLABLE_BOUNDARY) | (1L << WORD_BOUNDARY) | (1L << BETWEEN_WORDS) | (1L << CLASSREF) | (1L << ELEMENT_DECL) | (1L << CLASS_DECL) | (1L << FEATURE_DECL) | (1L << DIACRITIC_DECL) | (1L << SYMBOL_DECL) | (1L << SYLLABLE_DECL) | (1L << EXPLICIT_SYLLABLES) | (1L << CLEAR_SYLLABLES) | (1L << ANY_SYLLABLE) | (1L << DEROMANIZER) | (1L << ROMANIZER) | (1L << ALL_MATCHING) | (1L << FIRST_MATCHING) | (1L << LITERAL) | (1L << LTR) | (1L << RTL) | (1L << PROPAGATE) | (1L << CLEANUP) | (1L << BLOCK) | (1L << UNCHANGED) | (1L << OFF) | (1L << NAME) | (1L << STR1) | (1L << STR))) != 0)) {
					{
					setState(577);
					environmentBefore();
					setState(578);
					match(WHITESPACE);
					}
				}

				setState(582);
				match(ANCHOR);
				setState(585);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==WHITESPACE) {
					{
					setState(583);
					match(WHITESPACE);
					setState(584);
					environmentAfter();
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(588);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << O_PAREN) | (1L << NULL) | (1L << MATRIX_START) | (1L << LIST_START) | (1L << INEXACT) | (1L << NEGATION) | (1L << SYLLABLE_BOUNDARY) | (1L << WORD_BOUNDARY) | (1L << BETWEEN_WORDS) | (1L << CLASSREF) | (1L << ELEMENT_DECL) | (1L << CLASS_DECL) | (1L << FEATURE_DECL) | (1L << DIACRITIC_DECL) | (1L << SYMBOL_DECL) | (1L << SYLLABLE_DECL) | (1L << EXPLICIT_SYLLABLES) | (1L << CLEAR_SYLLABLES) | (1L << ANY_SYLLABLE) | (1L << DEROMANIZER) | (1L << ROMANIZER) | (1L << ALL_MATCHING) | (1L << FIRST_MATCHING) | (1L << LITERAL) | (1L << LTR) | (1L << RTL) | (1L << PROPAGATE) | (1L << CLEANUP) | (1L << BLOCK) | (1L << UNCHANGED) | (1L << OFF) | (1L << NAME) | (1L << STR1) | (1L << STR))) != 0)) {
					{
					setState(587);
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
			setState(592);
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
			setState(594);
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
			setState(596);
			interfixElement();
			setState(600); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(597);
				interfixType();
				setState(598);
				interfixElement();
				}
				}
				setState(602); 
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
			setState(604);
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
			setState(610);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,68,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(606);
				bounded();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(607);
				negated();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(608);
				postfix();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(609);
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
			setState(612);
			match(NEGATION);
			setState(613);
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
			setState(617);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,69,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(615);
				capture();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(616);
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
			setState(622);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case O_PAREN:
			case LIST_START:
				{
				setState(619);
				bounded();
				}
				break;
			case NEGATION:
				{
				setState(620);
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
				setState(621);
				simple();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(624);
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
			setState(628);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case O_PAREN:
			case LIST_START:
				{
				setState(626);
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
				setState(627);
				simple();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(630);
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
			setState(641);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,72,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(632);
				anySyllable();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(633);
				elementRef();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(634);
				captureRef();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(635);
				fancyMatrix();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(636);
				empty();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(637);
				sylBoundary();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(638);
				boundary();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(639);
				betweenWords();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(640);
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
			setState(643);
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
			setState(645);
			match(CLASSREF);
			setState(646);
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
			setState(649);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==INEXACT) {
				{
				setState(648);
				match(INEXACT);
				}
			}

			setState(651);
			match(WORD_BOUNDARY);
			setState(652);
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
			setState(654);
			match(MATRIX_START);
			setState(656);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NULL) | (1L << AT_LEAST_ONE) | (1L << HYPHEN) | (1L << NEGATION) | (1L << WORD_BOUNDARY) | (1L << ELEMENT_DECL) | (1L << CLASS_DECL) | (1L << FEATURE_DECL) | (1L << DIACRITIC_DECL) | (1L << SYMBOL_DECL) | (1L << SYLLABLE_DECL) | (1L << EXPLICIT_SYLLABLES) | (1L << CLEAR_SYLLABLES) | (1L << DEROMANIZER) | (1L << ROMANIZER) | (1L << ALL_MATCHING) | (1L << FIRST_MATCHING) | (1L << LITERAL) | (1L << LTR) | (1L << RTL) | (1L << PROPAGATE) | (1L << CLEANUP) | (1L << BLOCK) | (1L << UNCHANGED) | (1L << OFF) | (1L << NAME))) != 0)) {
				{
				setState(655);
				fancyValue();
				}
			}

			setState(662);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WHITESPACE) {
				{
				{
				setState(658);
				match(WHITESPACE);
				setState(659);
				fancyValue();
				}
				}
				setState(664);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(665);
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
			setState(671);
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
				setState(667);
				matrixValue();
				}
				break;
			case NEGATION:
				enterOuterAlt(_localctx, 2);
				{
				setState(668);
				negatedValue();
				}
				break;
			case NULL:
				enterOuterAlt(_localctx, 3);
				{
				setState(669);
				absentFeature();
				}
				break;
			case WORD_BOUNDARY:
				enterOuterAlt(_localctx, 4);
				{
				setState(670);
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
			setState(673);
			match(NEGATION);
			setState(674);
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
			setState(676);
			match(NULL);
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
			setState(679);
			match(WORD_BOUNDARY);
			setState(680);
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
			setState(682);
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
			setState(684);
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
			setState(686);
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
			setState(688);
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
			setState(694);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,77,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(690);
				repeatRange();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(691);
				match(AT_LEAST_ONE);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(692);
				match(NULL);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(693);
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
			setState(696);
			match(NULL);
			setState(707);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUMBER:
				{
				setState(697);
				match(NUMBER);
				}
				break;
			case O_PAREN:
				{
				{
				setState(698);
				match(O_PAREN);
				setState(700);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NUMBER) {
					{
					setState(699);
					lowerBound();
					}
				}

				setState(702);
				match(HYPHEN);
				setState(704);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NUMBER) {
					{
					setState(703);
					upperBound();
					}
				}

				setState(706);
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
			setState(709);
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
			setState(711);
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
			setState(713);
			match(MATRIX_START);
			setState(715);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AT_LEAST_ONE) | (1L << HYPHEN) | (1L << ELEMENT_DECL) | (1L << CLASS_DECL) | (1L << FEATURE_DECL) | (1L << DIACRITIC_DECL) | (1L << SYMBOL_DECL) | (1L << SYLLABLE_DECL) | (1L << EXPLICIT_SYLLABLES) | (1L << CLEAR_SYLLABLES) | (1L << DEROMANIZER) | (1L << ROMANIZER) | (1L << ALL_MATCHING) | (1L << FIRST_MATCHING) | (1L << LITERAL) | (1L << LTR) | (1L << RTL) | (1L << PROPAGATE) | (1L << CLEANUP) | (1L << BLOCK) | (1L << UNCHANGED) | (1L << OFF) | (1L << NAME))) != 0)) {
				{
				setState(714);
				matrixValue();
				}
			}

			setState(721);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WHITESPACE) {
				{
				{
				setState(717);
				match(WHITESPACE);
				setState(718);
				matrixValue();
				}
				}
				setState(723);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(724);
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
			setState(728);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case AT_LEAST_ONE:
			case HYPHEN:
				enterOuterAlt(_localctx, 1);
				{
				setState(726);
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
				setState(727);
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
			setState(730);
			_la = _input.LA(1);
			if ( !(_la==AT_LEAST_ONE || _la==HYPHEN) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(731);
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
			setState(733);
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
			setState(738);
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
				setState(735);
				name();
				}
				break;
			case STR1:
				{
				setState(736);
				match(STR1);
				}
				break;
			case STR:
				{
				setState(737);
				match(STR);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(741);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NEGATION) {
				{
				setState(740);
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
			setState(743);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3=\u02ec\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\3\2\3\2\7\2\u009f\n\2\f\2\16\2\u00a2"+
		"\13\2\3\2\5\2\u00a5\n\2\3\2\6\2\u00a8\n\2\r\2\16\2\u00a9\3\2\7\2\u00ad"+
		"\n\2\f\2\16\2\u00b0\13\2\3\2\7\2\u00b3\n\2\f\2\16\2\u00b6\13\2\3\2\5\2"+
		"\u00b9\n\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3\u00c5\n\3\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\7\5\u00d5\n\5\f\5\16"+
		"\5\u00d8\13\5\3\5\5\5\u00db\n\5\3\5\3\5\3\6\3\6\5\6\u00e1\n\6\3\7\3\7"+
		"\3\7\3\7\3\7\7\7\u00e8\n\7\f\7\16\7\u00eb\13\7\3\7\3\7\3\7\5\7\u00f0\n"+
		"\7\3\7\3\7\5\7\u00f4\n\7\3\7\3\7\3\7\3\7\5\7\u00fa\n\7\3\7\3\7\3\7\7\7"+
		"\u00ff\n\7\f\7\16\7\u0102\13\7\3\7\3\7\5\7\u0106\n\7\3\b\3\b\3\t\3\t\3"+
		"\t\5\t\u010d\n\t\3\t\5\t\u0110\n\t\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\7\13\u011e\n\13\f\13\16\13\u0121\13\13\3\13\3\13"+
		"\3\13\7\13\u0126\n\13\f\13\16\13\u0129\13\13\3\f\3\f\3\r\3\r\3\r\3\r\3"+
		"\r\7\r\u0132\n\r\f\r\16\r\u0135\13\r\3\r\3\r\5\r\u0139\n\r\3\16\3\16\3"+
		"\17\3\17\3\17\6\17\u0140\n\17\r\17\16\17\u0141\3\17\3\17\6\17\u0146\n"+
		"\17\r\17\16\17\u0147\3\17\6\17\u014b\n\17\r\17\16\17\u014c\5\17\u014f"+
		"\n\17\3\20\3\20\3\20\5\20\u0154\n\20\3\20\5\20\u0157\n\20\3\21\3\21\3"+
		"\21\5\21\u015c\n\21\3\21\3\21\6\21\u0160\n\21\r\21\16\21\u0161\3\21\3"+
		"\21\3\22\3\22\3\22\5\22\u0169\n\22\3\22\3\22\6\22\u016d\n\22\r\22\16\22"+
		"\u016e\3\22\3\22\3\23\3\23\3\23\3\23\3\23\5\23\u0178\n\23\3\23\3\23\6"+
		"\23\u017c\n\23\r\23\16\23\u017d\3\23\3\23\3\24\3\24\3\24\7\24\u0185\n"+
		"\24\f\24\16\24\u0188\13\24\3\24\5\24\u018b\n\24\3\24\6\24\u018e\n\24\r"+
		"\24\16\24\u018f\3\24\3\24\3\25\3\25\5\25\u0196\n\25\3\26\3\26\6\26\u019a"+
		"\n\26\r\26\16\26\u019b\3\26\3\26\3\26\3\26\6\26\u01a2\n\26\r\26\16\26"+
		"\u01a3\5\26\u01a6\n\26\3\26\3\26\7\26\u01aa\n\26\f\26\16\26\u01ad\13\26"+
		"\3\27\3\27\3\27\7\27\u01b2\n\27\f\27\16\27\u01b5\13\27\3\27\3\27\7\27"+
		"\u01b9\n\27\f\27\16\27\u01bc\13\27\3\27\3\27\5\27\u01c0\n\27\3\30\3\30"+
		"\3\30\7\30\u01c5\n\30\f\30\16\30\u01c8\13\30\3\31\3\31\5\31\u01cc\n\31"+
		"\3\32\3\32\3\33\3\33\6\33\u01d2\n\33\r\33\16\33\u01d3\3\33\7\33\u01d7"+
		"\n\33\f\33\16\33\u01da\13\33\3\34\3\34\3\34\3\34\5\34\u01e0\n\34\7\34"+
		"\u01e2\n\34\f\34\16\34\u01e5\13\34\3\35\3\35\3\35\5\35\u01ea\n\35\3\36"+
		"\3\36\3\37\3\37\3\37\3 \3 \3 \3 \5 \u01f5\n \3!\3!\3\"\3\"\3#\3#\5#\u01fd"+
		"\n#\3$\3$\3$\3$\3$\3$\5$\u0205\n$\3%\3%\5%\u0209\n%\3&\3&\3&\3&\3\'\3"+
		"\'\3\'\3\'\7\'\u0213\n\'\f\'\16\'\u0216\13\'\3\'\3\'\3(\3(\3(\6(\u021d"+
		"\n(\r(\16(\u021e\3)\3)\3)\3)\3)\5)\u0226\n)\3*\3*\3*\3*\3*\5*\u022d\n"+
		"*\3+\3+\3+\5+\u0232\n+\3,\3,\3,\5,\u0237\n,\3-\3-\3-\3-\7-\u023d\n-\f"+
		"-\16-\u0240\13-\3-\3-\3.\3.\3.\5.\u0247\n.\3.\3.\3.\5.\u024c\n.\3.\5."+
		"\u024f\n.\5.\u0251\n.\3/\3/\3\60\3\60\3\61\3\61\3\61\3\61\6\61\u025b\n"+
		"\61\r\61\16\61\u025c\3\62\3\62\3\63\3\63\3\63\3\63\5\63\u0265\n\63\3\64"+
		"\3\64\3\64\3\65\3\65\5\65\u026c\n\65\3\66\3\66\3\66\5\66\u0271\n\66\3"+
		"\66\3\66\3\67\3\67\5\67\u0277\n\67\3\67\3\67\38\38\38\38\38\38\38\38\3"+
		"8\58\u0284\n8\39\39\3:\3:\3:\3;\5;\u028c\n;\3;\3;\3;\3<\3<\5<\u0293\n"+
		"<\3<\3<\7<\u0297\n<\f<\16<\u029a\13<\3<\3<\3=\3=\3=\3=\5=\u02a2\n=\3>"+
		"\3>\3>\3?\3?\3?\3@\3@\3@\3A\3A\3B\3B\3C\3C\3D\3D\3E\3E\3E\3E\5E\u02b9"+
		"\nE\3F\3F\3F\3F\5F\u02bf\nF\3F\3F\5F\u02c3\nF\3F\5F\u02c6\nF\3G\3G\3H"+
		"\3H\3I\3I\5I\u02ce\nI\3I\3I\7I\u02d2\nI\fI\16I\u02d5\13I\3I\3I\3J\3J\5"+
		"J\u02db\nJ\3K\3K\3K\3L\3L\3M\3M\3M\5M\u02e5\nM\3M\5M\u02e8\nM\3N\3N\3"+
		"N\2\2O\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<"+
		">@BDFHJLNPRTVXZ\\^`bdfhjlnprtvxz|~\u0080\u0082\u0084\u0086\u0088\u008a"+
		"\u008c\u008e\u0090\u0092\u0094\u0096\u0098\u009a\2\f\3\2\21\22\3\2\4\5"+
		"\3\2&(\3\2+,\3\2\60\61\4\2\63\67;;\3\289\3\2\36 \4\2\24\24\26\26\7\2!"+
		"#%%),.9;;\2\u0314\2\u00b8\3\2\2\2\4\u00c4\3\2\2\2\6\u00c6\3\2\2\2\b\u00cc"+
		"\3\2\2\2\n\u00e0\3\2\2\2\f\u00e2\3\2\2\2\16\u0107\3\2\2\2\20\u010c\3\2"+
		"\2\2\22\u0113\3\2\2\2\24\u0116\3\2\2\2\26\u012a\3\2\2\2\30\u012c\3\2\2"+
		"\2\32\u013a\3\2\2\2\34\u013c\3\2\2\2\36\u0150\3\2\2\2 \u0158\3\2\2\2\""+
		"\u0165\3\2\2\2$\u0172\3\2\2\2&\u0181\3\2\2\2(\u0195\3\2\2\2*\u0197\3\2"+
		"\2\2,\u01bf\3\2\2\2.\u01c1\3\2\2\2\60\u01cb\3\2\2\2\62\u01cd\3\2\2\2\64"+
		"\u01cf\3\2\2\2\66\u01db\3\2\2\28\u01e9\3\2\2\2:\u01eb\3\2\2\2<\u01ed\3"+
		"\2\2\2>\u01f0\3\2\2\2@\u01f6\3\2\2\2B\u01f8\3\2\2\2D\u01fa\3\2\2\2F\u0204"+
		"\3\2\2\2H\u0208\3\2\2\2J\u020a\3\2\2\2L\u020e\3\2\2\2N\u0219\3\2\2\2P"+
		"\u0225\3\2\2\2R\u022c\3\2\2\2T\u022e\3\2\2\2V\u0233\3\2\2\2X\u0238\3\2"+
		"\2\2Z\u0250\3\2\2\2\\\u0252\3\2\2\2^\u0254\3\2\2\2`\u0256\3\2\2\2b\u025e"+
		"\3\2\2\2d\u0264\3\2\2\2f\u0266\3\2\2\2h\u026b\3\2\2\2j\u0270\3\2\2\2l"+
		"\u0276\3\2\2\2n\u0283\3\2\2\2p\u0285\3\2\2\2r\u0287\3\2\2\2t\u028b\3\2"+
		"\2\2v\u0290\3\2\2\2x\u02a1\3\2\2\2z\u02a3\3\2\2\2|\u02a6\3\2\2\2~\u02a9"+
		"\3\2\2\2\u0080\u02ac\3\2\2\2\u0082\u02ae\3\2\2\2\u0084\u02b0\3\2\2\2\u0086"+
		"\u02b2\3\2\2\2\u0088\u02b8\3\2\2\2\u008a\u02ba\3\2\2\2\u008c\u02c7\3\2"+
		"\2\2\u008e\u02c9\3\2\2\2\u0090\u02cb\3\2\2\2\u0092\u02da\3\2\2\2\u0094"+
		"\u02dc\3\2\2\2\u0096\u02df\3\2\2\2\u0098\u02e4\3\2\2\2\u009a\u02e9\3\2"+
		"\2\2\u009c\u00b9\7\13\2\2\u009d\u009f\7\n\2\2\u009e\u009d\3\2\2\2\u009f"+
		"\u00a2\3\2\2\2\u00a0\u009e\3\2\2\2\u00a0\u00a1\3\2\2\2\u00a1\u00a4\3\2"+
		"\2\2\u00a2\u00a0\3\2\2\2\u00a3\u00a5\5\4\3\2\u00a4\u00a3\3\2\2\2\u00a4"+
		"\u00a5\3\2\2\2\u00a5\u00ae\3\2\2\2\u00a6\u00a8\7\n\2\2\u00a7\u00a6\3\2"+
		"\2\2\u00a8\u00a9\3\2\2\2\u00a9\u00a7\3\2\2\2\u00a9\u00aa\3\2\2\2\u00aa"+
		"\u00ab\3\2\2\2\u00ab\u00ad\5\4\3\2\u00ac\u00a7\3\2\2\2\u00ad\u00b0\3\2"+
		"\2\2\u00ae\u00ac\3\2\2\2\u00ae\u00af\3\2\2\2\u00af\u00b4\3\2\2\2\u00b0"+
		"\u00ae\3\2\2\2\u00b1\u00b3\7\n\2\2\u00b2\u00b1\3\2\2\2\u00b3\u00b6\3\2"+
		"\2\2\u00b4\u00b2\3\2\2\2\u00b4\u00b5\3\2\2\2\u00b5\u00b7\3\2\2\2\u00b6"+
		"\u00b4\3\2\2\2\u00b7\u00b9\7\2\2\3\u00b8\u009c\3\2\2\2\u00b8\u00a0\3\2"+
		"\2\2\u00b9\3\3\2\2\2\u00ba\u00c5\5\f\7\2\u00bb\u00c5\5\24\13\2\u00bc\u00c5"+
		"\5\30\r\2\u00bd\u00c5\5\b\5\2\u00be\u00c5\5\6\4\2\u00bf\u00c5\5\34\17"+
		"\2\u00c0\u00c5\5 \21\2\u00c1\u00c5\5$\23\2\u00c2\u00c5\5\"\22\2\u00c3"+
		"\u00c5\5&\24\2\u00c4\u00ba\3\2\2\2\u00c4\u00bb\3\2\2\2\u00c4\u00bc\3\2"+
		"\2\2\u00c4\u00bd\3\2\2\2\u00c4\u00be\3\2\2\2\u00c4\u00bf\3\2\2\2\u00c4"+
		"\u00c0\3\2\2\2\u00c4\u00c1\3\2\2\2\u00c4\u00c2\3\2\2\2\u00c4\u00c3\3\2"+
		"\2\2\u00c5\5\3\2\2\2\u00c6\u00c7\7!\2\2\u00c7\u00c8\7\13\2\2\u00c8\u00c9"+
		"\5\u009aN\2\u00c9\u00ca\7\13\2\2\u00ca\u00cb\5D#\2\u00cb\7\3\2\2\2\u00cc"+
		"\u00cd\7\"\2\2\u00cd\u00ce\7\13\2\2\u00ce\u00cf\5\u009aN\2\u00cf\u00d0"+
		"\7\13\2\2\u00d0\u00d1\t\2\2\2\u00d1\u00d6\5\n\6\2\u00d2\u00d3\t\3\2\2"+
		"\u00d3\u00d5\5\n\6\2\u00d4\u00d2\3\2\2\2\u00d5\u00d8\3\2\2\2\u00d6\u00d4"+
		"\3\2\2\2\u00d6\u00d7\3\2\2\2\u00d7\u00da\3\2\2\2\u00d8\u00d6\3\2\2\2\u00d9"+
		"\u00db\7\5\2\2\u00da\u00d9\3\2\2\2\u00da\u00db\3\2\2\2\u00db\u00dc\3\2"+
		"\2\2\u00dc\u00dd\7\23\2\2\u00dd\t\3\2\2\2\u00de\u00e1\5r:\2\u00df\u00e1"+
		"\5\u0098M\2\u00e0\u00de\3\2\2\2\u00e0\u00df\3\2\2\2\u00e1\13\3\2\2\2\u00e2"+
		"\u00e3\7#\2\2\u00e3\u0105\7\13\2\2\u00e4\u00e9\5\20\t\2\u00e5\u00e6\7"+
		"\4\2\2\u00e6\u00e8\5\20\t\2\u00e7\u00e5\3\2\2\2\u00e8\u00eb\3\2\2\2\u00e9"+
		"\u00e7\3\2\2\2\u00e9\u00ea\3\2\2\2\u00ea\u0106\3\2\2\2\u00eb\u00e9\3\2"+
		"\2\2\u00ec\u00ed\5\16\b\2\u00ed\u00ee\7\13\2\2\u00ee\u00f0\3\2\2\2\u00ef"+
		"\u00ec\3\2\2\2\u00ef\u00f0\3\2\2\2\u00f0\u00f1\3\2\2\2\u00f1\u00f3\5\u009a"+
		"N\2\u00f2\u00f4\7\13\2\2\u00f3\u00f2\3\2\2\2\u00f3\u00f4\3\2\2\2\u00f4"+
		"\u00f5\3\2\2\2\u00f5\u00f9\7\f\2\2\u00f6\u00f7\5\22\n\2\u00f7\u00f8\7"+
		"\4\2\2\u00f8\u00fa\3\2\2\2\u00f9\u00f6\3\2\2\2\u00f9\u00fa\3\2\2\2\u00fa"+
		"\u00fb\3\2\2\2\u00fb\u0100\5\u0096L\2\u00fc\u00fd\7\4\2\2\u00fd\u00ff"+
		"\5\u0096L\2\u00fe\u00fc\3\2\2\2\u00ff\u0102\3\2\2\2\u0100\u00fe\3\2\2"+
		"\2\u0100\u0101\3\2\2\2\u0101\u0103\3\2\2\2\u0102\u0100\3\2\2\2\u0103\u0104"+
		"\7\r\2\2\u0104\u0106\3\2\2\2\u0105\u00e4\3\2\2\2\u0105\u00ef\3\2\2\2\u0106"+
		"\r\3\2\2\2\u0107\u0108\7$\2\2\u0108\17\3\2\2\2\u0109\u010a\5\16\b\2\u010a"+
		"\u010b\7\13\2\2\u010b\u010d\3\2\2\2\u010c\u0109\3\2\2\2\u010c\u010d\3"+
		"\2\2\2\u010d\u010f\3\2\2\2\u010e\u0110\7\24\2\2\u010f\u010e\3\2\2\2\u010f"+
		"\u0110\3\2\2\2\u0110\u0111\3\2\2\2\u0111\u0112\5\u009aN\2\u0112\21\3\2"+
		"\2\2\u0113\u0114\7\16\2\2\u0114\u0115\5\u0096L\2\u0115\23\3\2\2\2\u0116"+
		"\u0117\7%\2\2\u0117\u0118\7\13\2\2\u0118\u0119\5\u0098M\2\u0119\u011f"+
		"\7\13\2\2\u011a\u011b\5\26\f\2\u011b\u011c\7\13\2\2\u011c\u011e\3\2\2"+
		"\2\u011d\u011a\3\2\2\2\u011e\u0121\3\2\2\2\u011f\u011d\3\2\2\2\u011f\u0120"+
		"\3\2\2\2\u0120\u0122\3\2\2\2\u0121\u011f\3\2\2\2\u0122\u0127\5\u0090I"+
		"\2\u0123\u0124\7\13\2\2\u0124\u0126\5\26\f\2\u0125\u0123\3\2\2\2\u0126"+
		"\u0129\3\2\2\2\u0127\u0125\3\2\2\2\u0127\u0128\3\2\2\2\u0128\25\3\2\2"+
		"\2\u0129\u0127\3\2\2\2\u012a\u012b\t\4\2\2\u012b\27\3\2\2\2\u012c\u012d"+
		"\7)\2\2\u012d\u012e\7\13\2\2\u012e\u0138\5\32\16\2\u012f\u0130\7\4\2\2"+
		"\u0130\u0132\5\32\16\2\u0131\u012f\3\2\2\2\u0132\u0135\3\2\2\2\u0133\u0131"+
		"\3\2\2\2\u0133\u0134\3\2\2\2\u0134\u0139\3\2\2\2\u0135\u0133\3\2\2\2\u0136"+
		"\u0137\7\13\2\2\u0137\u0139\5\u0090I\2\u0138\u0133\3\2\2\2\u0138\u0136"+
		"\3\2\2\2\u0139\31\3\2\2\2\u013a\u013b\5\u0098M\2\u013b\33\3\2\2\2\u013c"+
		"\u013d\7*\2\2\u013d\u014e\7\27\2\2\u013e\u0140\7\n\2\2\u013f\u013e\3\2"+
		"\2\2\u0140\u0141\3\2\2\2\u0141\u013f\3\2\2\2\u0141\u0142\3\2\2\2\u0142"+
		"\u0143\3\2\2\2\u0143\u014f\t\5\2\2\u0144\u0146\7\n\2\2\u0145\u0144\3\2"+
		"\2\2\u0146\u0147\3\2\2\2\u0147\u0145\3\2\2\2\u0147\u0148\3\2\2\2\u0148"+
		"\u0149\3\2\2\2\u0149\u014b\5\36\20\2\u014a\u0145\3\2\2\2\u014b\u014c\3"+
		"\2\2\2\u014c\u014a\3\2\2\2\u014c\u014d\3\2\2\2\u014d\u014f\3\2\2\2\u014e"+
		"\u013f\3\2\2\2\u014e\u014a\3\2\2\2\u014f\35\3\2\2\2\u0150\u0153\5F$\2"+
		"\u0151\u0152\7\6\2\2\u0152\u0154\5\u0090I\2\u0153\u0151\3\2\2\2\u0153"+
		"\u0154\3\2\2\2\u0154\u0156\3\2\2\2\u0155\u0157\5R*\2\u0156\u0155\3\2\2"+
		"\2\u0156\u0157\3\2\2\2\u0157\37\3\2\2\2\u0158\u015b\7.\2\2\u0159\u015a"+
		"\7\13\2\2\u015a\u015c\7\62\2\2\u015b\u0159\3\2\2\2\u015b\u015c\3\2\2\2"+
		"\u015c\u015d\3\2\2\2\u015d\u015f\7\27\2\2\u015e\u0160\7\n\2\2\u015f\u015e"+
		"\3\2\2\2\u0160\u0161\3\2\2\2\u0161\u015f\3\2\2\2\u0161\u0162\3\2\2\2\u0162"+
		"\u0163\3\2\2\2\u0163\u0164\5*\26\2\u0164!\3\2\2\2\u0165\u0168\7/\2\2\u0166"+
		"\u0167\7\13\2\2\u0167\u0169\7\62\2\2\u0168\u0166\3\2\2\2\u0168\u0169\3"+
		"\2\2\2\u0169\u016a\3\2\2\2\u016a\u016c\7\27\2\2\u016b\u016d\7\n\2\2\u016c"+
		"\u016b\3\2\2\2\u016d\u016e\3\2\2\2\u016e\u016c\3\2\2\2\u016e\u016f\3\2"+
		"\2\2\u016f\u0170\3\2\2\2\u0170\u0171\5*\26\2\u0171#\3\2\2\2\u0172\u0173"+
		"\7/\2\2\u0173\u0174\7\26\2\2\u0174\u0177\5\66\34\2\u0175\u0176\7\13\2"+
		"\2\u0176\u0178\7\62\2\2\u0177\u0175\3\2\2\2\u0177\u0178\3\2\2\2\u0178"+
		"\u0179\3\2\2\2\u0179\u017b\7\27\2\2\u017a\u017c\7\n\2\2\u017b\u017a\3"+
		"\2\2\2\u017c\u017d\3\2\2\2\u017d\u017b\3\2\2\2\u017d\u017e\3\2\2\2\u017e"+
		"\u017f\3\2\2\2\u017f\u0180\5*\26\2\u0180%\3\2\2\2\u0181\u0186\5\66\34"+
		"\2\u0182\u0183\7\13\2\2\u0183\u0185\5\60\31\2\u0184\u0182\3\2\2\2\u0185"+
		"\u0188\3\2\2\2\u0186\u0184\3\2\2\2\u0186\u0187\3\2\2\2\u0187\u018a\3\2"+
		"\2\2\u0188\u0186\3\2\2\2\u0189\u018b\7\27\2\2\u018a\u0189\3\2\2\2\u018a"+
		"\u018b\3\2\2\2\u018b\u018d\3\2\2\2\u018c\u018e\7\n\2\2\u018d\u018c\3\2"+
		"\2\2\u018e\u018f\3\2\2\2\u018f\u018d\3\2\2\2\u018f\u0190\3\2\2\2\u0190"+
		"\u0191\3\2\2\2\u0191\u0192\5*\26\2\u0192\'\3\2\2\2\u0193\u0196\5r:\2\u0194"+
		"\u0196\5v<\2\u0195\u0193\3\2\2\2\u0195\u0194\3\2\2\2\u0196)\3\2\2\2\u0197"+
		"\u01ab\5,\27\2\u0198\u019a\7\n\2\2\u0199\u0198\3\2\2\2\u019a\u019b\3\2"+
		"\2\2\u019b\u0199\3\2\2\2\u019b\u019c\3\2\2\2\u019c\u019d\3\2\2\2\u019d"+
		"\u019e\5.\30\2\u019e\u01a5\7\27\2\2\u019f\u01a6\7\13\2\2\u01a0\u01a2\7"+
		"\n\2\2\u01a1\u01a0\3\2\2\2\u01a2\u01a3\3\2\2\2\u01a3\u01a1\3\2\2\2\u01a3"+
		"\u01a4\3\2\2\2\u01a4\u01a6\3\2\2\2\u01a5\u019f\3\2\2\2\u01a5\u01a1\3\2"+
		"\2\2\u01a6\u01a7\3\2\2\2\u01a7\u01a8\5,\27\2\u01a8\u01aa\3\2\2\2\u01a9"+
		"\u0199\3\2\2\2\u01aa\u01ad\3\2\2\2\u01ab\u01a9\3\2\2\2\u01ab\u01ac\3\2"+
		"\2\2\u01ac+\3\2\2\2\u01ad\u01ab\3\2\2\2\u01ae\u01c0\5\64\33\2\u01af\u01b3"+
		"\7\f\2\2\u01b0\u01b2\7\n\2\2\u01b1\u01b0\3\2\2\2\u01b2\u01b5\3\2\2\2\u01b3"+
		"\u01b1\3\2\2\2\u01b3\u01b4\3\2\2\2\u01b4\u01b6\3\2\2\2\u01b5\u01b3\3\2"+
		"\2\2\u01b6\u01ba\5*\26\2\u01b7\u01b9\7\n\2\2\u01b8\u01b7\3\2\2\2\u01b9"+
		"\u01bc\3\2\2\2\u01ba\u01b8\3\2\2\2\u01ba\u01bb\3\2\2\2\u01bb\u01bd\3\2"+
		"\2\2\u01bc\u01ba\3\2\2\2\u01bd\u01be\7\r\2\2\u01be\u01c0\3\2\2\2\u01bf"+
		"\u01ae\3\2\2\2\u01bf\u01af\3\2\2\2\u01c0-\3\2\2\2\u01c1\u01c6\t\6\2\2"+
		"\u01c2\u01c3\7\13\2\2\u01c3\u01c5\5\60\31\2\u01c4\u01c2\3\2\2\2\u01c5"+
		"\u01c8\3\2\2\2\u01c6\u01c4\3\2\2\2\u01c6\u01c7\3\2\2\2\u01c7/\3\2\2\2"+
		"\u01c8\u01c6\3\2\2\2\u01c9\u01cc\5(\25\2\u01ca\u01cc\5\62\32\2\u01cb\u01c9"+
		"\3\2\2\2\u01cb\u01ca\3\2\2\2\u01cc\61\3\2\2\2\u01cd\u01ce\t\7\2\2\u01ce"+
		"\63\3\2\2\2\u01cf\u01d8\58\35\2\u01d0\u01d2\7\n\2\2\u01d1\u01d0\3\2\2"+
		"\2\u01d2\u01d3\3\2\2\2\u01d3\u01d1\3\2\2\2\u01d3\u01d4\3\2\2\2\u01d4\u01d5"+
		"\3\2\2\2\u01d5\u01d7\58\35\2\u01d6\u01d1\3\2\2\2\u01d7\u01da\3\2\2\2\u01d8"+
		"\u01d6\3\2\2\2\u01d8\u01d9\3\2\2\2\u01d9\65\3\2\2\2\u01da\u01d8\3\2\2"+
		"\2\u01db\u01e3\5\u009aN\2\u01dc\u01df\7\26\2\2\u01dd\u01e0\5\u009aN\2"+
		"\u01de\u01e0\7:\2\2\u01df\u01dd\3\2\2\2\u01df\u01de\3\2\2\2\u01e0\u01e2"+
		"\3\2\2\2\u01e1\u01dc\3\2\2\2\u01e2\u01e5\3\2\2\2\u01e3\u01e1\3\2\2\2\u01e3"+
		"\u01e4\3\2\2\2\u01e4\67\3\2\2\2\u01e5\u01e3\3\2\2\2\u01e6\u01ea\5:\36"+
		"\2\u01e7\u01ea\5<\37\2\u01e8\u01ea\5> \2\u01e9\u01e6\3\2\2\2\u01e9\u01e7"+
		"\3\2\2\2\u01e9\u01e8\3\2\2\2\u01ea9\3\2\2\2\u01eb\u01ec\t\b\2\2\u01ec"+
		";\3\2\2\2\u01ed\u01ee\7\27\2\2\u01ee\u01ef\5\66\34\2\u01ef=\3\2\2\2\u01f0"+
		"\u01f1\5@!\2\u01f1\u01f2\7\6\2\2\u01f2\u01f4\5B\"\2\u01f3\u01f5\5R*\2"+
		"\u01f4\u01f3\3\2\2\2\u01f4\u01f5\3\2\2\2\u01f5?\3\2\2\2\u01f6\u01f7\5"+
		"D#\2\u01f7A\3\2\2\2\u01f8\u01f9\5F$\2\u01f9C\3\2\2\2\u01fa\u01fc\5F$\2"+
		"\u01fb\u01fd\5R*\2\u01fc\u01fb\3\2\2\2\u01fc\u01fd\3\2\2\2\u01fdE\3\2"+
		"\2\2\u01fe\u0205\5H%\2\u01ff\u0205\5`\61\2\u0200\u0205\5f\64\2\u0201\u0205"+
		"\5h\65\2\u0202\u0205\5n8\2\u0203\u0205\5N(\2\u0204\u01fe\3\2\2\2\u0204"+
		"\u01ff\3\2\2\2\u0204\u0200\3\2\2\2\u0204\u0201\3\2\2\2\u0204\u0202\3\2"+
		"\2\2\u0204\u0203\3\2\2\2\u0205G\3\2\2\2\u0206\u0209\5J&\2\u0207\u0209"+
		"\5L\'\2\u0208\u0206\3\2\2\2\u0208\u0207\3\2\2\2\u0209I\3\2\2\2\u020a\u020b"+
		"\7\f\2\2\u020b\u020c\5D#\2\u020c\u020d\7\r\2\2\u020dK\3\2\2\2\u020e\u020f"+
		"\7\21\2\2\u020f\u0214\5D#\2\u0210\u0211\7\4\2\2\u0211\u0213\5D#\2\u0212"+
		"\u0210\3\2\2\2\u0213\u0216\3\2\2\2\u0214\u0212\3\2\2\2\u0214\u0215\3\2"+
		"\2\2\u0215\u0217\3\2\2\2\u0216\u0214\3\2\2\2\u0217\u0218\7\23\2\2\u0218"+
		"M\3\2\2\2\u0219\u021c\5P)\2\u021a\u021b\7\13\2\2\u021b\u021d\5P)\2\u021c"+
		"\u021a\3\2\2\2\u021d\u021e\3\2\2\2\u021e\u021c\3\2\2\2\u021e\u021f\3\2"+
		"\2\2\u021fO\3\2\2\2\u0220\u0226\5H%\2\u0221\u0226\5`\61\2\u0222\u0226"+
		"\5f\64\2\u0223\u0226\5h\65\2\u0224\u0226\5n8\2\u0225\u0220\3\2\2\2\u0225"+
		"\u0221\3\2\2\2\u0225\u0222\3\2\2\2\u0225\u0223\3\2\2\2\u0225\u0224\3\2"+
		"\2\2\u0226Q\3\2\2\2\u0227\u022d\5T+\2\u0228\u022d\5V,\2\u0229\u022a\5"+
		"T+\2\u022a\u022b\5V,\2\u022b\u022d\3\2\2\2\u022c\u0227\3\2\2\2\u022c\u0228"+
		"\3\2\2\2\u022c\u0229\3\2\2\2\u022dS\3\2\2\2\u022e\u0231\7\7\2\2\u022f"+
		"\u0232\5Z.\2\u0230\u0232\5X-\2\u0231\u022f\3\2\2\2\u0231\u0230\3\2\2\2"+
		"\u0232U\3\2\2\2\u0233\u0236\7\b\2\2\u0234\u0237\5Z.\2\u0235\u0237\5X-"+
		"\2\u0236\u0234\3\2\2\2\u0236\u0235\3\2\2\2\u0237W\3\2\2\2\u0238\u0239"+
		"\7\21\2\2\u0239\u023e\5Z.\2\u023a\u023b\7\4\2\2\u023b\u023d\5Z.\2\u023c"+
		"\u023a\3\2\2\2\u023d\u0240\3\2\2\2\u023e\u023c\3\2\2\2\u023e\u023f\3\2"+
		"\2\2\u023f\u0241\3\2\2\2\u0240\u023e\3\2\2\2\u0241\u0242\7\23\2\2\u0242"+
		"Y\3\2\2\2\u0243\u0244\5\\/\2\u0244\u0245\7\13\2\2\u0245\u0247\3\2\2\2"+
		"\u0246\u0243\3\2\2\2\u0246\u0247\3\2\2\2\u0247\u0248\3\2\2\2\u0248\u024b"+
		"\7\t\2\2\u0249\u024a\7\13\2\2\u024a\u024c\5^\60\2\u024b\u0249\3\2\2\2"+
		"\u024b\u024c\3\2\2\2\u024c\u0251\3\2\2\2\u024d\u024f\5\\/\2\u024e\u024d"+
		"\3\2\2\2\u024e\u024f\3\2\2\2\u024f\u0251\3\2\2\2\u0250\u0246\3\2\2\2\u0250"+
		"\u024e\3\2\2\2\u0251[\3\2\2\2\u0252\u0253\5F$\2\u0253]\3\2\2\2\u0254\u0255"+
		"\5F$\2\u0255_\3\2\2\2\u0256\u025a\5d\63\2\u0257\u0258\5b\62\2\u0258\u0259"+
		"\5d\63\2\u0259\u025b\3\2\2\2\u025a\u0257\3\2\2\2\u025b\u025c\3\2\2\2\u025c"+
		"\u025a\3\2\2\2\u025c\u025d\3\2\2\2\u025da\3\2\2\2\u025e\u025f\t\t\2\2"+
		"\u025fc\3\2\2\2\u0260\u0265\5H%\2\u0261\u0265\5f\64\2\u0262\u0265\5h\65"+
		"\2\u0263\u0265\5n8\2\u0264\u0260\3\2\2\2\u0264\u0261\3\2\2\2\u0264\u0262"+
		"\3\2\2\2\u0264\u0263\3\2\2\2\u0265e\3\2\2\2\u0266\u0267\7\31\2\2\u0267"+
		"\u0268\5n8\2\u0268g\3\2\2\2\u0269\u026c\5j\66\2\u026a\u026c\5l\67\2\u026b"+
		"\u0269\3\2\2\2\u026b\u026a\3\2\2\2\u026ci\3\2\2\2\u026d\u0271\5H%\2\u026e"+
		"\u0271\5f\64\2\u026f\u0271\5n8\2\u0270\u026d\3\2\2\2\u0270\u026e\3\2\2"+
		"\2\u0270\u026f\3\2\2\2\u0271\u0272\3\2\2\2\u0272\u0273\5t;\2\u0273k\3"+
		"\2\2\2\u0274\u0277\5H%\2\u0275\u0277\5n8\2\u0276\u0274\3\2\2\2\u0276\u0275"+
		"\3\2\2\2\u0277\u0278\3\2\2\2\u0278\u0279\5\u0088E\2\u0279m\3\2\2\2\u027a"+
		"\u0284\5p9\2\u027b\u0284\5r:\2\u027c\u0284\5t;\2\u027d\u0284\5v<\2\u027e"+
		"\u0284\5\u0080A\2\u027f\u0284\5\u0082B\2\u0280\u0284\5\u0084C\2\u0281"+
		"\u0284\5\u0086D\2\u0282\u0284\5\u0098M\2\u0283\u027a\3\2\2\2\u0283\u027b"+
		"\3\2\2\2\u0283\u027c\3\2\2\2\u0283\u027d\3\2\2\2\u0283\u027e\3\2\2\2\u0283"+
		"\u027f\3\2\2\2\u0283\u0280\3\2\2\2\u0283\u0281\3\2\2\2\u0283\u0282\3\2"+
		"\2\2\u0284o\3\2\2\2\u0285\u0286\7-\2\2\u0286q\3\2\2\2\u0287\u0288\7\35"+
		"\2\2\u0288\u0289\5\u009aN\2\u0289s\3\2\2\2\u028a\u028c\7\30\2\2\u028b"+
		"\u028a\3\2\2\2\u028b\u028c\3\2\2\2\u028c\u028d\3\2\2\2\u028d\u028e\7\33"+
		"\2\2\u028e\u028f\7:\2\2\u028fu\3\2\2\2\u0290\u0292\7\17\2\2\u0291\u0293"+
		"\5x=\2\u0292\u0291\3\2\2\2\u0292\u0293\3\2\2\2\u0293\u0298\3\2\2\2\u0294"+
		"\u0295\7\13\2\2\u0295\u0297\5x=\2\u0296\u0294\3\2\2\2\u0297\u029a\3\2"+
		"\2\2\u0298\u0296\3\2\2\2\u0298\u0299\3\2\2\2\u0299\u029b\3\2\2\2\u029a"+
		"\u0298\3\2\2\2\u029b\u029c\7\20\2\2\u029cw\3\2\2\2\u029d\u02a2\5\u0092"+
		"J\2\u029e\u02a2\5z>\2\u029f\u02a2\5|?\2\u02a0\u02a2\5~@\2\u02a1\u029d"+
		"\3\2\2\2\u02a1\u029e\3\2\2\2\u02a1\u029f\3\2\2\2\u02a1\u02a0\3\2\2\2\u02a2"+
		"y\3\2\2\2\u02a3\u02a4\7\31\2\2\u02a4\u02a5\5\u0092J\2\u02a5{\3\2\2\2\u02a6"+
		"\u02a7\7\16\2\2\u02a7\u02a8\5\u009aN\2\u02a8}\3\2\2\2\u02a9\u02aa\7\33"+
		"\2\2\u02aa\u02ab\5\u009aN\2\u02ab\177\3\2\2\2\u02ac\u02ad\7\16\2\2\u02ad"+
		"\u0081\3\2\2\2\u02ae\u02af\7\32\2\2\u02af\u0083\3\2\2\2\u02b0\u02b1\7"+
		"\33\2\2\u02b1\u0085\3\2\2\2\u02b2\u02b3\7\34\2\2\u02b3\u0087\3\2\2\2\u02b4"+
		"\u02b9\5\u008aF\2\u02b5\u02b9\7\24\2\2\u02b6\u02b9\7\16\2\2\u02b7\u02b9"+
		"\7\25\2\2\u02b8\u02b4\3\2\2\2\u02b8\u02b5\3\2\2\2\u02b8\u02b6\3\2\2\2"+
		"\u02b8\u02b7\3\2\2\2\u02b9\u0089\3\2\2\2\u02ba\u02c5\7\16\2\2\u02bb\u02c6"+
		"\7:\2\2\u02bc\u02be\7\f\2\2\u02bd\u02bf\5\u008cG\2\u02be\u02bd\3\2\2\2"+
		"\u02be\u02bf\3\2\2\2\u02bf\u02c0\3\2\2\2\u02c0\u02c2\7\26\2\2\u02c1\u02c3"+
		"\5\u008eH\2\u02c2\u02c1\3\2\2\2\u02c2\u02c3\3\2\2\2\u02c3\u02c4\3\2\2"+
		"\2\u02c4\u02c6\7\r\2\2\u02c5\u02bb\3\2\2\2\u02c5\u02bc\3\2\2\2\u02c6\u008b"+
		"\3\2\2\2\u02c7\u02c8\7:\2\2\u02c8\u008d\3\2\2\2\u02c9\u02ca\7:\2\2\u02ca"+
		"\u008f\3\2\2\2\u02cb\u02cd\7\17\2\2\u02cc\u02ce\5\u0092J\2\u02cd\u02cc"+
		"\3\2\2\2\u02cd\u02ce\3\2\2\2\u02ce\u02d3\3\2\2\2\u02cf\u02d0\7\13\2\2"+
		"\u02d0\u02d2\5\u0092J\2\u02d1\u02cf\3\2\2\2\u02d2\u02d5\3\2\2\2\u02d3"+
		"\u02d1\3\2\2\2\u02d3\u02d4\3\2\2\2\u02d4\u02d6\3\2\2\2\u02d5\u02d3\3\2"+
		"\2\2\u02d6\u02d7\7\20\2\2\u02d7\u0091\3\2\2\2\u02d8\u02db\5\u0094K\2\u02d9"+
		"\u02db\5\u0096L\2\u02da\u02d8\3\2\2\2\u02da\u02d9\3\2\2\2\u02db\u0093"+
		"\3\2\2\2\u02dc\u02dd\t\n\2\2\u02dd\u02de\5\u009aN\2\u02de\u0095\3\2\2"+
		"\2\u02df\u02e0\5\u009aN\2\u02e0\u0097\3\2\2\2\u02e1\u02e5\5\u009aN\2\u02e2"+
		"\u02e5\7<\2\2\u02e3\u02e5\7=\2\2\u02e4\u02e1\3\2\2\2\u02e4\u02e2\3\2\2"+
		"\2\u02e4\u02e3\3\2\2\2\u02e5\u02e7\3\2\2\2\u02e6\u02e8\7\31\2\2\u02e7"+
		"\u02e6\3\2\2\2\u02e7\u02e8\3\2\2\2\u02e8\u0099\3\2\2\2\u02e9\u02ea\t\13"+
		"\2\2\u02ea\u009b\3\2\2\2X\u00a0\u00a4\u00a9\u00ae\u00b4\u00b8\u00c4\u00d6"+
		"\u00da\u00e0\u00e9\u00ef\u00f3\u00f9\u0100\u0105\u010c\u010f\u011f\u0127"+
		"\u0133\u0138\u0141\u0147\u014c\u014e\u0153\u0156\u015b\u0161\u0168\u016e"+
		"\u0177\u017d\u0186\u018a\u018f\u0195\u019b\u01a3\u01a5\u01ab\u01b3\u01ba"+
		"\u01bf\u01c6\u01cb\u01d3\u01d8\u01df\u01e3\u01e9\u01f4\u01fc\u0204\u0208"+
		"\u0214\u021e\u0225\u022c\u0231\u0236\u023e\u0246\u024b\u024e\u0250\u025c"+
		"\u0264\u026b\u0270\u0276\u0283\u028b\u0292\u0298\u02a1\u02b8\u02be\u02c2"+
		"\u02c5\u02cd\u02d3\u02da\u02e4\u02e7";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}