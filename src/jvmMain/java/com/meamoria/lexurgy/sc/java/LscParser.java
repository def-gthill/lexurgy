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
		CLASSREF=25, INTERSECTION=26, TRANSFORMING=27, CLASS_DECL=28, FEATURE_DECL=29, 
		SYLLABLE_FEATURE=30, DIACRITIC=31, DIA_BEFORE=32, DIA_FIRST=33, DIA_FLOATING=34, 
		SYMBOL=35, SYLLABLE_DECL=36, EXPLICIT_SYLLABLES=37, CLEAR_SYLLABLES=38, 
		ANY_SYLLABLE=39, DEROMANIZER=40, ROMANIZER=41, ALL_MATCHING=42, FIRST_MATCHING=43, 
		PROPAGATE=44, LTR=45, RTL=46, LITERAL=47, UNCHANGED=48, NUMBER=49, NAME=50, 
		STR1=51, STR=52;
	public static final int
		RULE_lscFile = 0, RULE_statement = 1, RULE_classDecl = 2, RULE_classElement = 3, 
		RULE_featureDecl = 4, RULE_featureModifier = 5, RULE_plusFeature = 6, 
		RULE_nullAlias = 7, RULE_diacriticDecl = 8, RULE_diacriticModifier = 9, 
		RULE_symbolDecl = 10, RULE_symbolName = 11, RULE_syllableDecl = 12, RULE_syllablePattern = 13, 
		RULE_deromanizer = 14, RULE_romanizer = 15, RULE_interRomanizer = 16, 
		RULE_changeRule = 17, RULE_filter = 18, RULE_block = 19, RULE_blockElement = 20, 
		RULE_blockType = 21, RULE_changeRuleModifier = 22, RULE_matchMode = 23, 
		RULE_expressionList = 24, RULE_ruleName = 25, RULE_expression = 26, RULE_from = 27, 
		RULE_to = 28, RULE_ruleElement = 29, RULE_bounded = 30, RULE_group = 31, 
		RULE_list = 32, RULE_lookaround = 33, RULE_sequence = 34, RULE_freeElement = 35, 
		RULE_compoundEnvironment = 36, RULE_condition = 37, RULE_exclusion = 38, 
		RULE_environmentList = 39, RULE_environment = 40, RULE_environmentBefore = 41, 
		RULE_environmentAfter = 42, RULE_interfix = 43, RULE_interfixType = 44, 
		RULE_interfixElement = 45, RULE_negated = 46, RULE_postfix = 47, RULE_capture = 48, 
		RULE_repeater = 49, RULE_simple = 50, RULE_anySyllable = 51, RULE_classRef = 52, 
		RULE_captureRef = 53, RULE_fancyMatrix = 54, RULE_fancyValue = 55, RULE_negatedValue = 56, 
		RULE_absentFeature = 57, RULE_featureVariable = 58, RULE_empty = 59, RULE_sylBoundary = 60, 
		RULE_boundary = 61, RULE_betweenWords = 62, RULE_repeaterType = 63, RULE_matrix = 64, 
		RULE_matrixValue = 65, RULE_plusFeatureValue = 66, RULE_featureValue = 67, 
		RULE_name = 68, RULE_text = 69;
	private static String[] makeRuleNames() {
		return new String[] {
			"lscFile", "statement", "classDecl", "classElement", "featureDecl", "featureModifier", 
			"plusFeature", "nullAlias", "diacriticDecl", "diacriticModifier", "symbolDecl", 
			"symbolName", "syllableDecl", "syllablePattern", "deromanizer", "romanizer", 
			"interRomanizer", "changeRule", "filter", "block", "blockElement", "blockType", 
			"changeRuleModifier", "matchMode", "expressionList", "ruleName", "expression", 
			"from", "to", "ruleElement", "bounded", "group", "list", "lookaround", 
			"sequence", "freeElement", "compoundEnvironment", "condition", "exclusion", 
			"environmentList", "environment", "environmentBefore", "environmentAfter", 
			"interfix", "interfixType", "interfixElement", "negated", "postfix", 
			"capture", "repeater", "simple", "anySyllable", "classRef", "captureRef", 
			"fancyMatrix", "fancyValue", "negatedValue", "absentFeature", "featureVariable", 
			"empty", "sylBoundary", "boundary", "betweenWords", "repeaterType", "matrix", 
			"matrixValue", "plusFeatureValue", "featureValue", "name", "text"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, null, "'_'", null, null, "'('", "')'", 
			"'*'", "'['", "']'", "'{'", "'}'", "'+'", "'?'", "'-'", "':'", "'~'", 
			"'!'", "'.'", "'$'", "'$$'", "'@'", "'&'", "'>'", null, null, null, null, 
			null, null, null, null, "'Syllables'", "'explicit'", "'clear'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "COMMENT", "SEP", "CHANGE", "CONDITION", "EXCLUSION", "ANCHOR", 
			"NEWLINE", "WHITESPACE", "O_PAREN", "C_PAREN", "NULL", "MATRIX_START", 
			"MATRIX_END", "LIST_START", "LIST_END", "AT_LEAST_ONE", "OPTIONAL", "HYPHEN", 
			"RULE_START", "INEXACT", "NEGATION", "SYLLABLE_BOUNDARY", "WORD_BOUNDARY", 
			"BETWEEN_WORDS", "CLASSREF", "INTERSECTION", "TRANSFORMING", "CLASS_DECL", 
			"FEATURE_DECL", "SYLLABLE_FEATURE", "DIACRITIC", "DIA_BEFORE", "DIA_FIRST", 
			"DIA_FLOATING", "SYMBOL", "SYLLABLE_DECL", "EXPLICIT_SYLLABLES", "CLEAR_SYLLABLES", 
			"ANY_SYLLABLE", "DEROMANIZER", "ROMANIZER", "ALL_MATCHING", "FIRST_MATCHING", 
			"PROPAGATE", "LTR", "RTL", "LITERAL", "UNCHANGED", "NUMBER", "NAME", 
			"STR1", "STR"
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
			setState(168);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case WHITESPACE:
				enterOuterAlt(_localctx, 1);
				{
				setState(140);
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
				setState(144);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(141);
						match(NEWLINE);
						}
						} 
					}
					setState(146);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
				}
				setState(148);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CLASS_DECL) | (1L << FEATURE_DECL) | (1L << DIACRITIC) | (1L << SYMBOL) | (1L << SYLLABLE_DECL) | (1L << DEROMANIZER) | (1L << ROMANIZER) | (1L << NAME))) != 0)) {
					{
					setState(147);
					statement();
					}
				}

				setState(158);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(151); 
						_errHandler.sync(this);
						_la = _input.LA(1);
						do {
							{
							{
							setState(150);
							match(NEWLINE);
							}
							}
							setState(153); 
							_errHandler.sync(this);
							_la = _input.LA(1);
						} while ( _la==NEWLINE );
						setState(155);
						statement();
						}
						} 
					}
					setState(160);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
				}
				setState(164);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NEWLINE) {
					{
					{
					setState(161);
					match(NEWLINE);
					}
					}
					setState(166);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(167);
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
			setState(179);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(170);
				featureDecl();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(171);
				diacriticDecl();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(172);
				symbolDecl();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(173);
				classDecl();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(174);
				syllableDecl();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(175);
				deromanizer();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(176);
				changeRule();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(177);
				interRomanizer();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(178);
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
			setState(181);
			match(CLASS_DECL);
			setState(182);
			match(WHITESPACE);
			setState(183);
			name();
			setState(184);
			match(WHITESPACE);
			setState(185);
			match(LIST_START);
			setState(186);
			classElement();
			setState(191);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SEP) {
				{
				{
				setState(187);
				match(SEP);
				setState(188);
				classElement();
				}
				}
				setState(193);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(194);
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
			setState(198);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CLASSREF:
				enterOuterAlt(_localctx, 1);
				{
				setState(196);
				classRef();
				}
				break;
			case NAME:
			case STR1:
			case STR:
				enterOuterAlt(_localctx, 2);
				{
				setState(197);
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
			setState(200);
			match(FEATURE_DECL);
			setState(201);
			match(WHITESPACE);
			setState(235);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				{
				{
				setState(202);
				plusFeature();
				setState(207);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==SEP) {
					{
					{
					setState(203);
					match(SEP);
					setState(204);
					plusFeature();
					}
					}
					setState(209);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				break;
			case 2:
				{
				{
				setState(213);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SYLLABLE_FEATURE) {
					{
					setState(210);
					featureModifier();
					setState(211);
					match(WHITESPACE);
					}
				}

				setState(215);
				name();
				setState(217);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==WHITESPACE) {
					{
					setState(216);
					match(WHITESPACE);
					}
				}

				setState(219);
				match(O_PAREN);
				setState(223);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NULL) {
					{
					setState(220);
					nullAlias();
					setState(221);
					match(SEP);
					}
				}

				setState(225);
				featureValue();
				setState(230);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==SEP) {
					{
					{
					setState(226);
					match(SEP);
					setState(227);
					featureValue();
					}
					}
					setState(232);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(233);
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
			setState(237);
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

			setState(245);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==AT_LEAST_ONE) {
				{
				setState(244);
				match(AT_LEAST_ONE);
				}
			}

			setState(247);
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
			setState(249);
			match(NULL);
			setState(250);
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
			setState(252);
			match(DIACRITIC);
			setState(253);
			match(WHITESPACE);
			setState(254);
			text();
			setState(255);
			match(WHITESPACE);
			setState(261);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DIA_BEFORE) | (1L << DIA_FIRST) | (1L << DIA_FLOATING))) != 0)) {
				{
				{
				setState(256);
				diacriticModifier();
				setState(257);
				match(WHITESPACE);
				}
				}
				setState(263);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(264);
			matrix();
			setState(269);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WHITESPACE) {
				{
				{
				setState(265);
				match(WHITESPACE);
				setState(266);
				diacriticModifier();
				}
				}
				setState(271);
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
			setState(272);
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
			setState(274);
			match(SYMBOL);
			setState(275);
			match(WHITESPACE);
			setState(276);
			symbolName();
			setState(286);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case EOF:
			case SEP:
			case NEWLINE:
				{
				setState(281);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==SEP) {
					{
					{
					setState(277);
					match(SEP);
					setState(278);
					symbolName();
					}
					}
					setState(283);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case WHITESPACE:
				{
				setState(284);
				match(WHITESPACE);
				setState(285);
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
			setState(288);
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
			setState(290);
			match(SYLLABLE_DECL);
			setState(291);
			match(RULE_START);
			setState(308);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				{
				setState(293); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(292);
					match(NEWLINE);
					}
					}
					setState(295); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NEWLINE );
				setState(297);
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
				setState(304); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
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
						syllablePattern();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(306); 
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
		public RuleElementContext ruleElement() {
			return getRuleContext(RuleElementContext.class,0);
		}
		public CompoundEnvironmentContext compoundEnvironment() {
			return getRuleContext(CompoundEnvironmentContext.class,0);
		}
		public TerminalNode CHANGE() { return getToken(LscParser.CHANGE, 0); }
		public MatrixContext matrix() {
			return getRuleContext(MatrixContext.class,0);
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
			setState(310);
			ruleElement();
			setState(313);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CHANGE) {
				{
				setState(311);
				match(CHANGE);
				setState(312);
				matrix();
				}
			}

			setState(315);
			compoundEnvironment();
			}
		}
		catch (RecognitionException re) {
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
			setState(317);
			match(DEROMANIZER);
			setState(320);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WHITESPACE) {
				{
				setState(318);
				match(WHITESPACE);
				setState(319);
				match(LITERAL);
				}
			}

			setState(322);
			match(RULE_START);
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
			setState(330);
			match(ROMANIZER);
			setState(333);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WHITESPACE) {
				{
				setState(331);
				match(WHITESPACE);
				setState(332);
				match(LITERAL);
				}
			}

			setState(335);
			match(RULE_START);
			setState(337); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(336);
				match(NEWLINE);
				}
				}
				setState(339); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NEWLINE );
			setState(341);
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
			setState(343);
			match(ROMANIZER);
			setState(344);
			match(HYPHEN);
			setState(345);
			ruleName();
			setState(348);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WHITESPACE) {
				{
				setState(346);
				match(WHITESPACE);
				setState(347);
				match(LITERAL);
				}
			}

			setState(350);
			match(RULE_START);
			setState(352); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(351);
				match(NEWLINE);
				}
				}
				setState(354); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NEWLINE );
			setState(356);
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
			setState(358);
			ruleName();
			setState(363);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WHITESPACE) {
				{
				{
				setState(359);
				match(WHITESPACE);
				setState(360);
				changeRuleModifier();
				}
				}
				setState(365);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(367);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==RULE_START) {
				{
				setState(366);
				match(RULE_START);
				}
			}

			setState(370); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(369);
				match(NEWLINE);
				}
				}
				setState(372); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NEWLINE );
			setState(374);
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
			setState(378);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CLASSREF:
				enterOuterAlt(_localctx, 1);
				{
				setState(376);
				classRef();
				}
				break;
			case MATRIX_START:
				enterOuterAlt(_localctx, 2);
				{
				setState(377);
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
			setState(380);
			blockElement();
			setState(400);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,39,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
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
					blockType();
					setState(387);
					match(RULE_START);
					setState(394);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case WHITESPACE:
						{
						setState(388);
						match(WHITESPACE);
						}
						break;
					case NEWLINE:
						{
						setState(390); 
						_errHandler.sync(this);
						_la = _input.LA(1);
						do {
							{
							{
							setState(389);
							match(NEWLINE);
							}
							}
							setState(392); 
							_errHandler.sync(this);
							_la = _input.LA(1);
						} while ( _la==NEWLINE );
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(396);
					blockElement();
					}
					} 
				}
				setState(402);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,39,_ctx);
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
			setState(420);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,42,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(403);
				expressionList();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(404);
				match(O_PAREN);
				setState(408);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NEWLINE) {
					{
					{
					setState(405);
					match(NEWLINE);
					}
					}
					setState(410);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(411);
				block();
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
			setState(422);
			_la = _input.LA(1);
			if ( !(_la==ALL_MATCHING || _la==FIRST_MATCHING) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(427);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WHITESPACE) {
				{
				{
				setState(423);
				match(WHITESPACE);
				setState(424);
				changeRuleModifier();
				}
				}
				setState(429);
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
			setState(433);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case MATRIX_START:
			case CLASSREF:
				enterOuterAlt(_localctx, 1);
				{
				setState(430);
				filter();
				}
				break;
			case LTR:
			case RTL:
				enterOuterAlt(_localctx, 2);
				{
				setState(431);
				matchMode();
				}
				break;
			case PROPAGATE:
				enterOuterAlt(_localctx, 3);
				{
				setState(432);
				match(PROPAGATE);
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
			setState(435);
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
			setState(437);
			expression();
			setState(446);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,46,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(439); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(438);
						match(NEWLINE);
						}
						}
						setState(441); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==NEWLINE );
					setState(443);
					expression();
					}
					} 
				}
				setState(448);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,46,_ctx);
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
			setState(449);
			match(NAME);
			setState(454);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==HYPHEN) {
				{
				{
				setState(450);
				match(HYPHEN);
				setState(451);
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
				setState(456);
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
		try {
			setState(463);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case UNCHANGED:
				enterOuterAlt(_localctx, 1);
				{
				setState(457);
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
				setState(458);
				from();
				setState(459);
				match(CHANGE);
				setState(460);
				to();
				setState(461);
				compoundEnvironment();
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
			setState(465);
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
		enterRule(_localctx, 56, RULE_to);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(467);
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
		try {
			setState(475);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,49,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(469);
				bounded();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(470);
				interfix();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(471);
				negated();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(472);
				postfix();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(473);
				simple();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(474);
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
		public LookaroundContext lookaround() {
			return getRuleContext(LookaroundContext.class,0);
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
		enterRule(_localctx, 60, RULE_bounded);
		try {
			setState(480);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,50,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(477);
				group();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(478);
				list();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(479);
				lookaround();
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
		enterRule(_localctx, 62, RULE_group);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(482);
			match(O_PAREN);
			setState(483);
			ruleElement();
			setState(484);
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
		enterRule(_localctx, 64, RULE_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(486);
			match(LIST_START);
			setState(487);
			ruleElement();
			setState(492);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SEP) {
				{
				{
				setState(488);
				match(SEP);
				setState(489);
				ruleElement();
				}
				}
				setState(494);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(495);
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

	public static class LookaroundContext extends ParserRuleContext {
		public TerminalNode O_PAREN() { return getToken(LscParser.O_PAREN, 0); }
		public RuleElementContext ruleElement() {
			return getRuleContext(RuleElementContext.class,0);
		}
		public CompoundEnvironmentContext compoundEnvironment() {
			return getRuleContext(CompoundEnvironmentContext.class,0);
		}
		public TerminalNode C_PAREN() { return getToken(LscParser.C_PAREN, 0); }
		public LookaroundContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lookaround; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LscVisitor ) return ((LscVisitor<? extends T>)visitor).visitLookaround(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LookaroundContext lookaround() throws RecognitionException {
		LookaroundContext _localctx = new LookaroundContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_lookaround);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(497);
			match(O_PAREN);
			setState(498);
			ruleElement();
			setState(499);
			compoundEnvironment();
			setState(500);
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
			setState(502);
			freeElement();
			setState(505); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(503);
					match(WHITESPACE);
					setState(504);
					freeElement();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(507); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,52,_ctx);
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
			setState(514);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,53,_ctx) ) {
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
			}
		}
		catch (RecognitionException re) {
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
		public TerminalNode CONDITION() { return getToken(LscParser.CONDITION, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public TerminalNode EXCLUSION() { return getToken(LscParser.EXCLUSION, 0); }
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
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(518);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CONDITION) {
				{
				setState(516);
				match(CONDITION);
				setState(517);
				condition();
				}
			}

			setState(522);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EXCLUSION) {
				{
				setState(520);
				match(EXCLUSION);
				setState(521);
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
		enterRule(_localctx, 74, RULE_condition);
		try {
			setState(526);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,56,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(524);
				environment();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(525);
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
		enterRule(_localctx, 76, RULE_exclusion);
		try {
			setState(530);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,57,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(528);
				environment();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(529);
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
			setState(532);
			match(LIST_START);
			setState(533);
			environment();
			setState(538);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SEP) {
				{
				{
				setState(534);
				match(SEP);
				setState(535);
				environment();
				}
				}
				setState(540);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(541);
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
			setState(556);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,62,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(546);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << O_PAREN) | (1L << NULL) | (1L << MATRIX_START) | (1L << LIST_START) | (1L << INEXACT) | (1L << NEGATION) | (1L << SYLLABLE_BOUNDARY) | (1L << WORD_BOUNDARY) | (1L << BETWEEN_WORDS) | (1L << CLASSREF) | (1L << ANY_SYLLABLE) | (1L << NAME) | (1L << STR1) | (1L << STR))) != 0)) {
					{
					setState(543);
					environmentBefore();
					setState(544);
					match(WHITESPACE);
					}
				}

				setState(548);
				match(ANCHOR);
				setState(551);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==WHITESPACE) {
					{
					setState(549);
					match(WHITESPACE);
					setState(550);
					environmentAfter();
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(554);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << O_PAREN) | (1L << NULL) | (1L << MATRIX_START) | (1L << LIST_START) | (1L << INEXACT) | (1L << NEGATION) | (1L << SYLLABLE_BOUNDARY) | (1L << WORD_BOUNDARY) | (1L << BETWEEN_WORDS) | (1L << CLASSREF) | (1L << ANY_SYLLABLE) | (1L << NAME) | (1L << STR1) | (1L << STR))) != 0)) {
					{
					setState(553);
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
		enterRule(_localctx, 82, RULE_environmentBefore);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(558);
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
		enterRule(_localctx, 84, RULE_environmentAfter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(560);
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
			setState(562);
			interfixElement();
			setState(566); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(563);
				interfixType();
				setState(564);
				interfixElement();
				}
				}
				setState(568); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==INTERSECTION || _la==TRANSFORMING );
			}
		}
		catch (RecognitionException re) {
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
			setState(570);
			_la = _input.LA(1);
			if ( !(_la==INTERSECTION || _la==TRANSFORMING) ) {
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
			setState(576);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,64,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(572);
				bounded();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(573);
				negated();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(574);
				postfix();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
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
			setState(578);
			match(NEGATION);
			setState(579);
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
			setState(583);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,65,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(581);
				capture();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(582);
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
			setState(588);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case O_PAREN:
			case LIST_START:
				{
				setState(585);
				bounded();
				}
				break;
			case NEGATION:
				{
				setState(586);
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
				setState(587);
				simple();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(590);
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
			setState(594);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case O_PAREN:
			case LIST_START:
				{
				setState(592);
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
				setState(593);
				simple();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(596);
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
			setState(607);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,68,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(598);
				anySyllable();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(599);
				classRef();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(600);
				captureRef();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(601);
				fancyMatrix();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(602);
				empty();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(603);
				sylBoundary();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(604);
				boundary();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(605);
				betweenWords();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(606);
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
			setState(609);
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
			setState(611);
			match(CLASSREF);
			setState(612);
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
			setState(615);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==INEXACT) {
				{
				setState(614);
				match(INEXACT);
				}
			}

			setState(617);
			match(WORD_BOUNDARY);
			setState(618);
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
			setState(620);
			match(MATRIX_START);
			setState(622);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NULL) | (1L << AT_LEAST_ONE) | (1L << HYPHEN) | (1L << NEGATION) | (1L << WORD_BOUNDARY) | (1L << NAME))) != 0)) {
				{
				setState(621);
				fancyValue();
				}
			}

			setState(628);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WHITESPACE) {
				{
				{
				setState(624);
				match(WHITESPACE);
				setState(625);
				fancyValue();
				}
				}
				setState(630);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(631);
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
			setState(637);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case AT_LEAST_ONE:
			case HYPHEN:
			case NAME:
				enterOuterAlt(_localctx, 1);
				{
				setState(633);
				matrixValue();
				}
				break;
			case NEGATION:
				enterOuterAlt(_localctx, 2);
				{
				setState(634);
				negatedValue();
				}
				break;
			case NULL:
				enterOuterAlt(_localctx, 3);
				{
				setState(635);
				absentFeature();
				}
				break;
			case WORD_BOUNDARY:
				enterOuterAlt(_localctx, 4);
				{
				setState(636);
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
			setState(639);
			match(NEGATION);
			setState(640);
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
			setState(642);
			match(NULL);
			setState(643);
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
			setState(645);
			match(WORD_BOUNDARY);
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
			setState(648);
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
			setState(650);
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
			setState(652);
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
			setState(654);
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
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(656);
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
		enterRule(_localctx, 128, RULE_matrix);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(658);
			match(MATRIX_START);
			setState(660);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AT_LEAST_ONE) | (1L << HYPHEN) | (1L << NAME))) != 0)) {
				{
				setState(659);
				matrixValue();
				}
			}

			setState(666);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WHITESPACE) {
				{
				{
				setState(662);
				match(WHITESPACE);
				setState(663);
				matrixValue();
				}
				}
				setState(668);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(669);
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
		enterRule(_localctx, 130, RULE_matrixValue);
		try {
			setState(673);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case AT_LEAST_ONE:
			case HYPHEN:
				enterOuterAlt(_localctx, 1);
				{
				setState(671);
				plusFeatureValue();
				}
				break;
			case NAME:
				enterOuterAlt(_localctx, 2);
				{
				setState(672);
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
		enterRule(_localctx, 132, RULE_plusFeatureValue);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(675);
			_la = _input.LA(1);
			if ( !(_la==AT_LEAST_ONE || _la==HYPHEN) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(676);
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
		enterRule(_localctx, 134, RULE_featureValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
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
		enterRule(_localctx, 136, RULE_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(680);
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
		enterRule(_localctx, 138, RULE_text);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(682);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NAME) | (1L << STR1) | (1L << STR))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(684);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NEGATION) {
				{
				setState(683);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\66\u02b1\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\3\2\3\2\7"+
		"\2\u0091\n\2\f\2\16\2\u0094\13\2\3\2\5\2\u0097\n\2\3\2\6\2\u009a\n\2\r"+
		"\2\16\2\u009b\3\2\7\2\u009f\n\2\f\2\16\2\u00a2\13\2\3\2\7\2\u00a5\n\2"+
		"\f\2\16\2\u00a8\13\2\3\2\5\2\u00ab\n\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\5\3\u00b6\n\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\7\4\u00c0\n\4\f\4\16"+
		"\4\u00c3\13\4\3\4\3\4\3\5\3\5\5\5\u00c9\n\5\3\6\3\6\3\6\3\6\3\6\7\6\u00d0"+
		"\n\6\f\6\16\6\u00d3\13\6\3\6\3\6\3\6\5\6\u00d8\n\6\3\6\3\6\5\6\u00dc\n"+
		"\6\3\6\3\6\3\6\3\6\5\6\u00e2\n\6\3\6\3\6\3\6\7\6\u00e7\n\6\f\6\16\6\u00ea"+
		"\13\6\3\6\3\6\5\6\u00ee\n\6\3\7\3\7\3\b\3\b\3\b\5\b\u00f5\n\b\3\b\5\b"+
		"\u00f8\n\b\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\7\n\u0106\n"+
		"\n\f\n\16\n\u0109\13\n\3\n\3\n\3\n\7\n\u010e\n\n\f\n\16\n\u0111\13\n\3"+
		"\13\3\13\3\f\3\f\3\f\3\f\3\f\7\f\u011a\n\f\f\f\16\f\u011d\13\f\3\f\3\f"+
		"\5\f\u0121\n\f\3\r\3\r\3\16\3\16\3\16\6\16\u0128\n\16\r\16\16\16\u0129"+
		"\3\16\3\16\6\16\u012e\n\16\r\16\16\16\u012f\3\16\6\16\u0133\n\16\r\16"+
		"\16\16\u0134\5\16\u0137\n\16\3\17\3\17\3\17\5\17\u013c\n\17\3\17\3\17"+
		"\3\20\3\20\3\20\5\20\u0143\n\20\3\20\3\20\6\20\u0147\n\20\r\20\16\20\u0148"+
		"\3\20\3\20\3\21\3\21\3\21\5\21\u0150\n\21\3\21\3\21\6\21\u0154\n\21\r"+
		"\21\16\21\u0155\3\21\3\21\3\22\3\22\3\22\3\22\3\22\5\22\u015f\n\22\3\22"+
		"\3\22\6\22\u0163\n\22\r\22\16\22\u0164\3\22\3\22\3\23\3\23\3\23\7\23\u016c"+
		"\n\23\f\23\16\23\u016f\13\23\3\23\5\23\u0172\n\23\3\23\6\23\u0175\n\23"+
		"\r\23\16\23\u0176\3\23\3\23\3\24\3\24\5\24\u017d\n\24\3\25\3\25\6\25\u0181"+
		"\n\25\r\25\16\25\u0182\3\25\3\25\3\25\3\25\6\25\u0189\n\25\r\25\16\25"+
		"\u018a\5\25\u018d\n\25\3\25\3\25\7\25\u0191\n\25\f\25\16\25\u0194\13\25"+
		"\3\26\3\26\3\26\7\26\u0199\n\26\f\26\16\26\u019c\13\26\3\26\3\26\7\26"+
		"\u01a0\n\26\f\26\16\26\u01a3\13\26\3\26\3\26\5\26\u01a7\n\26\3\27\3\27"+
		"\3\27\7\27\u01ac\n\27\f\27\16\27\u01af\13\27\3\30\3\30\3\30\5\30\u01b4"+
		"\n\30\3\31\3\31\3\32\3\32\6\32\u01ba\n\32\r\32\16\32\u01bb\3\32\7\32\u01bf"+
		"\n\32\f\32\16\32\u01c2\13\32\3\33\3\33\3\33\7\33\u01c7\n\33\f\33\16\33"+
		"\u01ca\13\33\3\34\3\34\3\34\3\34\3\34\3\34\5\34\u01d2\n\34\3\35\3\35\3"+
		"\36\3\36\3\37\3\37\3\37\3\37\3\37\3\37\5\37\u01de\n\37\3 \3 \3 \5 \u01e3"+
		"\n \3!\3!\3!\3!\3\"\3\"\3\"\3\"\7\"\u01ed\n\"\f\"\16\"\u01f0\13\"\3\""+
		"\3\"\3#\3#\3#\3#\3#\3$\3$\3$\6$\u01fc\n$\r$\16$\u01fd\3%\3%\3%\3%\3%\5"+
		"%\u0205\n%\3&\3&\5&\u0209\n&\3&\3&\5&\u020d\n&\3\'\3\'\5\'\u0211\n\'\3"+
		"(\3(\5(\u0215\n(\3)\3)\3)\3)\7)\u021b\n)\f)\16)\u021e\13)\3)\3)\3*\3*"+
		"\3*\5*\u0225\n*\3*\3*\3*\5*\u022a\n*\3*\5*\u022d\n*\5*\u022f\n*\3+\3+"+
		"\3,\3,\3-\3-\3-\3-\6-\u0239\n-\r-\16-\u023a\3.\3.\3/\3/\3/\3/\5/\u0243"+
		"\n/\3\60\3\60\3\60\3\61\3\61\5\61\u024a\n\61\3\62\3\62\3\62\5\62\u024f"+
		"\n\62\3\62\3\62\3\63\3\63\5\63\u0255\n\63\3\63\3\63\3\64\3\64\3\64\3\64"+
		"\3\64\3\64\3\64\3\64\3\64\5\64\u0262\n\64\3\65\3\65\3\66\3\66\3\66\3\67"+
		"\5\67\u026a\n\67\3\67\3\67\3\67\38\38\58\u0271\n8\38\38\78\u0275\n8\f"+
		"8\168\u0278\138\38\38\39\39\39\39\59\u0280\n9\3:\3:\3:\3;\3;\3;\3<\3<"+
		"\3<\3=\3=\3>\3>\3?\3?\3@\3@\3A\3A\3B\3B\5B\u0297\nB\3B\3B\7B\u029b\nB"+
		"\fB\16B\u029e\13B\3B\3B\3C\3C\5C\u02a4\nC\3D\3D\3D\3E\3E\3F\3F\3G\3G\5"+
		"G\u02af\nG\3G\2\2H\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60"+
		"\62\64\668:<>@BDFHJLNPRTVXZ\\^`bdfhjlnprtvxz|~\u0080\u0082\u0084\u0086"+
		"\u0088\u008a\u008c\2\13\3\2\"$\3\2\'(\3\2,-\3\2/\60\3\2\63\64\3\2\34\35"+
		"\4\2\r\r\22\23\4\2\22\22\24\24\3\2\64\66\2\u02d3\2\u00aa\3\2\2\2\4\u00b5"+
		"\3\2\2\2\6\u00b7\3\2\2\2\b\u00c8\3\2\2\2\n\u00ca\3\2\2\2\f\u00ef\3\2\2"+
		"\2\16\u00f4\3\2\2\2\20\u00fb\3\2\2\2\22\u00fe\3\2\2\2\24\u0112\3\2\2\2"+
		"\26\u0114\3\2\2\2\30\u0122\3\2\2\2\32\u0124\3\2\2\2\34\u0138\3\2\2\2\36"+
		"\u013f\3\2\2\2 \u014c\3\2\2\2\"\u0159\3\2\2\2$\u0168\3\2\2\2&\u017c\3"+
		"\2\2\2(\u017e\3\2\2\2*\u01a6\3\2\2\2,\u01a8\3\2\2\2.\u01b3\3\2\2\2\60"+
		"\u01b5\3\2\2\2\62\u01b7\3\2\2\2\64\u01c3\3\2\2\2\66\u01d1\3\2\2\28\u01d3"+
		"\3\2\2\2:\u01d5\3\2\2\2<\u01dd\3\2\2\2>\u01e2\3\2\2\2@\u01e4\3\2\2\2B"+
		"\u01e8\3\2\2\2D\u01f3\3\2\2\2F\u01f8\3\2\2\2H\u0204\3\2\2\2J\u0208\3\2"+
		"\2\2L\u0210\3\2\2\2N\u0214\3\2\2\2P\u0216\3\2\2\2R\u022e\3\2\2\2T\u0230"+
		"\3\2\2\2V\u0232\3\2\2\2X\u0234\3\2\2\2Z\u023c\3\2\2\2\\\u0242\3\2\2\2"+
		"^\u0244\3\2\2\2`\u0249\3\2\2\2b\u024e\3\2\2\2d\u0254\3\2\2\2f\u0261\3"+
		"\2\2\2h\u0263\3\2\2\2j\u0265\3\2\2\2l\u0269\3\2\2\2n\u026e\3\2\2\2p\u027f"+
		"\3\2\2\2r\u0281\3\2\2\2t\u0284\3\2\2\2v\u0287\3\2\2\2x\u028a\3\2\2\2z"+
		"\u028c\3\2\2\2|\u028e\3\2\2\2~\u0290\3\2\2\2\u0080\u0292\3\2\2\2\u0082"+
		"\u0294\3\2\2\2\u0084\u02a3\3\2\2\2\u0086\u02a5\3\2\2\2\u0088\u02a8\3\2"+
		"\2\2\u008a\u02aa\3\2\2\2\u008c\u02ac\3\2\2\2\u008e\u00ab\7\n\2\2\u008f"+
		"\u0091\7\t\2\2\u0090\u008f\3\2\2\2\u0091\u0094\3\2\2\2\u0092\u0090\3\2"+
		"\2\2\u0092\u0093\3\2\2\2\u0093\u0096\3\2\2\2\u0094\u0092\3\2\2\2\u0095"+
		"\u0097\5\4\3\2\u0096\u0095\3\2\2\2\u0096\u0097\3\2\2\2\u0097\u00a0\3\2"+
		"\2\2\u0098\u009a\7\t\2\2\u0099\u0098\3\2\2\2\u009a\u009b\3\2\2\2\u009b"+
		"\u0099\3\2\2\2\u009b\u009c\3\2\2\2\u009c\u009d\3\2\2\2\u009d\u009f\5\4"+
		"\3\2\u009e\u0099\3\2\2\2\u009f\u00a2\3\2\2\2\u00a0\u009e\3\2\2\2\u00a0"+
		"\u00a1\3\2\2\2\u00a1\u00a6\3\2\2\2\u00a2\u00a0\3\2\2\2\u00a3\u00a5\7\t"+
		"\2\2\u00a4\u00a3\3\2\2\2\u00a5\u00a8\3\2\2\2\u00a6\u00a4\3\2\2\2\u00a6"+
		"\u00a7\3\2\2\2\u00a7\u00a9\3\2\2\2\u00a8\u00a6\3\2\2\2\u00a9\u00ab\7\2"+
		"\2\3\u00aa\u008e\3\2\2\2\u00aa\u0092\3\2\2\2\u00ab\3\3\2\2\2\u00ac\u00b6"+
		"\5\n\6\2\u00ad\u00b6\5\22\n\2\u00ae\u00b6\5\26\f\2\u00af\u00b6\5\6\4\2"+
		"\u00b0\u00b6\5\32\16\2\u00b1\u00b6\5\36\20\2\u00b2\u00b6\5$\23\2\u00b3"+
		"\u00b6\5\"\22\2\u00b4\u00b6\5 \21\2\u00b5\u00ac\3\2\2\2\u00b5\u00ad\3"+
		"\2\2\2\u00b5\u00ae\3\2\2\2\u00b5\u00af\3\2\2\2\u00b5\u00b0\3\2\2\2\u00b5"+
		"\u00b1\3\2\2\2\u00b5\u00b2\3\2\2\2\u00b5\u00b3\3\2\2\2\u00b5\u00b4\3\2"+
		"\2\2\u00b6\5\3\2\2\2\u00b7\u00b8\7\36\2\2\u00b8\u00b9\7\n\2\2\u00b9\u00ba"+
		"\5\u008aF\2\u00ba\u00bb\7\n\2\2\u00bb\u00bc\7\20\2\2\u00bc\u00c1\5\b\5"+
		"\2\u00bd\u00be\7\4\2\2\u00be\u00c0\5\b\5\2\u00bf\u00bd\3\2\2\2\u00c0\u00c3"+
		"\3\2\2\2\u00c1\u00bf\3\2\2\2\u00c1\u00c2\3\2\2\2\u00c2\u00c4\3\2\2\2\u00c3"+
		"\u00c1\3\2\2\2\u00c4\u00c5\7\21\2\2\u00c5\7\3\2\2\2\u00c6\u00c9\5j\66"+
		"\2\u00c7\u00c9\5\u008cG\2\u00c8\u00c6\3\2\2\2\u00c8\u00c7\3\2\2\2\u00c9"+
		"\t\3\2\2\2\u00ca\u00cb\7\37\2\2\u00cb\u00ed\7\n\2\2\u00cc\u00d1\5\16\b"+
		"\2\u00cd\u00ce\7\4\2\2\u00ce\u00d0\5\16\b\2\u00cf\u00cd\3\2\2\2\u00d0"+
		"\u00d3\3\2\2\2\u00d1\u00cf\3\2\2\2\u00d1\u00d2\3\2\2\2\u00d2\u00ee\3\2"+
		"\2\2\u00d3\u00d1\3\2\2\2\u00d4\u00d5\5\f\7\2\u00d5\u00d6\7\n\2\2\u00d6"+
		"\u00d8\3\2\2\2\u00d7\u00d4\3\2\2\2\u00d7\u00d8\3\2\2\2\u00d8\u00d9\3\2"+
		"\2\2\u00d9\u00db\5\u008aF\2\u00da\u00dc\7\n\2\2\u00db\u00da\3\2\2\2\u00db"+
		"\u00dc\3\2\2\2\u00dc\u00dd\3\2\2\2\u00dd\u00e1\7\13\2\2\u00de\u00df\5"+
		"\20\t\2\u00df\u00e0\7\4\2\2\u00e0\u00e2\3\2\2\2\u00e1\u00de\3\2\2\2\u00e1"+
		"\u00e2\3\2\2\2\u00e2\u00e3\3\2\2\2\u00e3\u00e8\5\u0088E\2\u00e4\u00e5"+
		"\7\4\2\2\u00e5\u00e7\5\u0088E\2\u00e6\u00e4\3\2\2\2\u00e7\u00ea\3\2\2"+
		"\2\u00e8\u00e6\3\2\2\2\u00e8\u00e9\3\2\2\2\u00e9\u00eb\3\2\2\2\u00ea\u00e8"+
		"\3\2\2\2\u00eb\u00ec\7\f\2\2\u00ec\u00ee\3\2\2\2\u00ed\u00cc\3\2\2\2\u00ed"+
		"\u00d7\3\2\2\2\u00ee\13\3\2\2\2\u00ef\u00f0\7 \2\2\u00f0\r\3\2\2\2\u00f1"+
		"\u00f2\5\f\7\2\u00f2\u00f3\7\n\2\2\u00f3\u00f5\3\2\2\2\u00f4\u00f1\3\2"+
		"\2\2\u00f4\u00f5\3\2\2\2\u00f5\u00f7\3\2\2\2\u00f6\u00f8\7\22\2\2\u00f7"+
		"\u00f6\3\2\2\2\u00f7\u00f8\3\2\2\2\u00f8\u00f9\3\2\2\2\u00f9\u00fa\5\u008a"+
		"F\2\u00fa\17\3\2\2\2\u00fb\u00fc\7\r\2\2\u00fc\u00fd\5\u0088E\2\u00fd"+
		"\21\3\2\2\2\u00fe\u00ff\7!\2\2\u00ff\u0100\7\n\2\2\u0100\u0101\5\u008c"+
		"G\2\u0101\u0107\7\n\2\2\u0102\u0103\5\24\13\2\u0103\u0104\7\n\2\2\u0104"+
		"\u0106\3\2\2\2\u0105\u0102\3\2\2\2\u0106\u0109\3\2\2\2\u0107\u0105\3\2"+
		"\2\2\u0107\u0108\3\2\2\2\u0108\u010a\3\2\2\2\u0109\u0107\3\2\2\2\u010a"+
		"\u010f\5\u0082B\2\u010b\u010c\7\n\2\2\u010c\u010e\5\24\13\2\u010d\u010b"+
		"\3\2\2\2\u010e\u0111\3\2\2\2\u010f\u010d\3\2\2\2\u010f\u0110\3\2\2\2\u0110"+
		"\23\3\2\2\2\u0111\u010f\3\2\2\2\u0112\u0113\t\2\2\2\u0113\25\3\2\2\2\u0114"+
		"\u0115\7%\2\2\u0115\u0116\7\n\2\2\u0116\u0120\5\30\r\2\u0117\u0118\7\4"+
		"\2\2\u0118\u011a\5\30\r\2\u0119\u0117\3\2\2\2\u011a\u011d\3\2\2\2\u011b"+
		"\u0119\3\2\2\2\u011b\u011c\3\2\2\2\u011c\u0121\3\2\2\2\u011d\u011b\3\2"+
		"\2\2\u011e\u011f\7\n\2\2\u011f\u0121\5\u0082B\2\u0120\u011b\3\2\2\2\u0120"+
		"\u011e\3\2\2\2\u0121\27\3\2\2\2\u0122\u0123\5\u008cG\2\u0123\31\3\2\2"+
		"\2\u0124\u0125\7&\2\2\u0125\u0136\7\25\2\2\u0126\u0128\7\t\2\2\u0127\u0126"+
		"\3\2\2\2\u0128\u0129\3\2\2\2\u0129\u0127\3\2\2\2\u0129\u012a\3\2\2\2\u012a"+
		"\u012b\3\2\2\2\u012b\u0137\t\3\2\2\u012c\u012e\7\t\2\2\u012d\u012c\3\2"+
		"\2\2\u012e\u012f\3\2\2\2\u012f\u012d\3\2\2\2\u012f\u0130\3\2\2\2\u0130"+
		"\u0131\3\2\2\2\u0131\u0133\5\34\17\2\u0132\u012d\3\2\2\2\u0133\u0134\3"+
		"\2\2\2\u0134\u0132\3\2\2\2\u0134\u0135\3\2\2\2\u0135\u0137\3\2\2\2\u0136"+
		"\u0127\3\2\2\2\u0136\u0132\3\2\2\2\u0137\33\3\2\2\2\u0138\u013b\5<\37"+
		"\2\u0139\u013a\7\5\2\2\u013a\u013c\5\u0082B\2\u013b\u0139\3\2\2\2\u013b"+
		"\u013c\3\2\2\2\u013c\u013d\3\2\2\2\u013d\u013e\5J&\2\u013e\35\3\2\2\2"+
		"\u013f\u0142\7*\2\2\u0140\u0141\7\n\2\2\u0141\u0143\7\61\2\2\u0142\u0140"+
		"\3\2\2\2\u0142\u0143\3\2\2\2\u0143\u0144\3\2\2\2\u0144\u0146\7\25\2\2"+
		"\u0145\u0147\7\t\2\2\u0146\u0145\3\2\2\2\u0147\u0148\3\2\2\2\u0148\u0146"+
		"\3\2\2\2\u0148\u0149\3\2\2\2\u0149\u014a\3\2\2\2\u014a\u014b\5(\25\2\u014b"+
		"\37\3\2\2\2\u014c\u014f\7+\2\2\u014d\u014e\7\n\2\2\u014e\u0150\7\61\2"+
		"\2\u014f\u014d\3\2\2\2\u014f\u0150\3\2\2\2\u0150\u0151\3\2\2\2\u0151\u0153"+
		"\7\25\2\2\u0152\u0154\7\t\2\2\u0153\u0152\3\2\2\2\u0154\u0155\3\2\2\2"+
		"\u0155\u0153\3\2\2\2\u0155\u0156\3\2\2\2\u0156\u0157\3\2\2\2\u0157\u0158"+
		"\5(\25\2\u0158!\3\2\2\2\u0159\u015a\7+\2\2\u015a\u015b\7\24\2\2\u015b"+
		"\u015e\5\64\33\2\u015c\u015d\7\n\2\2\u015d\u015f\7\61\2\2\u015e\u015c"+
		"\3\2\2\2\u015e\u015f\3\2\2\2\u015f\u0160\3\2\2\2\u0160\u0162\7\25\2\2"+
		"\u0161\u0163\7\t\2\2\u0162\u0161\3\2\2\2\u0163\u0164\3\2\2\2\u0164\u0162"+
		"\3\2\2\2\u0164\u0165\3\2\2\2\u0165\u0166\3\2\2\2\u0166\u0167\5(\25\2\u0167"+
		"#\3\2\2\2\u0168\u016d\5\64\33\2\u0169\u016a\7\n\2\2\u016a\u016c\5.\30"+
		"\2\u016b\u0169\3\2\2\2\u016c\u016f\3\2\2\2\u016d\u016b\3\2\2\2\u016d\u016e"+
		"\3\2\2\2\u016e\u0171\3\2\2\2\u016f\u016d\3\2\2\2\u0170\u0172\7\25\2\2"+
		"\u0171\u0170\3\2\2\2\u0171\u0172\3\2\2\2\u0172\u0174\3\2\2\2\u0173\u0175"+
		"\7\t\2\2\u0174\u0173\3\2\2\2\u0175\u0176\3\2\2\2\u0176\u0174\3\2\2\2\u0176"+
		"\u0177\3\2\2\2\u0177\u0178\3\2\2\2\u0178\u0179\5(\25\2\u0179%\3\2\2\2"+
		"\u017a\u017d\5j\66\2\u017b\u017d\5n8\2\u017c\u017a\3\2\2\2\u017c\u017b"+
		"\3\2\2\2\u017d\'\3\2\2\2\u017e\u0192\5*\26\2\u017f\u0181\7\t\2\2\u0180"+
		"\u017f\3\2\2\2\u0181\u0182\3\2\2\2\u0182\u0180\3\2\2\2\u0182\u0183\3\2"+
		"\2\2\u0183\u0184\3\2\2\2\u0184\u0185\5,\27\2\u0185\u018c\7\25\2\2\u0186"+
		"\u018d\7\n\2\2\u0187\u0189\7\t\2\2\u0188\u0187\3\2\2\2\u0189\u018a\3\2"+
		"\2\2\u018a\u0188\3\2\2\2\u018a\u018b\3\2\2\2\u018b\u018d\3\2\2\2\u018c"+
		"\u0186\3\2\2\2\u018c\u0188\3\2\2\2\u018d\u018e\3\2\2\2\u018e\u018f\5*"+
		"\26\2\u018f\u0191\3\2\2\2\u0190\u0180\3\2\2\2\u0191\u0194\3\2\2\2\u0192"+
		"\u0190\3\2\2\2\u0192\u0193\3\2\2\2\u0193)\3\2\2\2\u0194\u0192\3\2\2\2"+
		"\u0195\u01a7\5\62\32\2\u0196\u019a\7\13\2\2\u0197\u0199\7\t\2\2\u0198"+
		"\u0197\3\2\2\2\u0199\u019c\3\2\2\2\u019a\u0198\3\2\2\2\u019a\u019b\3\2"+
		"\2\2\u019b\u019d\3\2\2\2\u019c\u019a\3\2\2\2\u019d\u01a1\5(\25\2\u019e"+
		"\u01a0\7\t\2\2\u019f\u019e\3\2\2\2\u01a0\u01a3\3\2\2\2\u01a1\u019f\3\2"+
		"\2\2\u01a1\u01a2\3\2\2\2\u01a2\u01a4\3\2\2\2\u01a3\u01a1\3\2\2\2\u01a4"+
		"\u01a5\7\f\2\2\u01a5\u01a7\3\2\2\2\u01a6\u0195\3\2\2\2\u01a6\u0196\3\2"+
		"\2\2\u01a7+\3\2\2\2\u01a8\u01ad\t\4\2\2\u01a9\u01aa\7\n\2\2\u01aa\u01ac"+
		"\5.\30\2\u01ab\u01a9\3\2\2\2\u01ac\u01af\3\2\2\2\u01ad\u01ab\3\2\2\2\u01ad"+
		"\u01ae\3\2\2\2\u01ae-\3\2\2\2\u01af\u01ad\3\2\2\2\u01b0\u01b4\5&\24\2"+
		"\u01b1\u01b4\5\60\31\2\u01b2\u01b4\7.\2\2\u01b3\u01b0\3\2\2\2\u01b3\u01b1"+
		"\3\2\2\2\u01b3\u01b2\3\2\2\2\u01b4/\3\2\2\2\u01b5\u01b6\t\5\2\2\u01b6"+
		"\61\3\2\2\2\u01b7\u01c0\5\66\34\2\u01b8\u01ba\7\t\2\2\u01b9\u01b8\3\2"+
		"\2\2\u01ba\u01bb\3\2\2\2\u01bb\u01b9\3\2\2\2\u01bb\u01bc\3\2\2\2\u01bc"+
		"\u01bd\3\2\2\2\u01bd\u01bf\5\66\34\2\u01be\u01b9\3\2\2\2\u01bf\u01c2\3"+
		"\2\2\2\u01c0\u01be\3\2\2\2\u01c0\u01c1\3\2\2\2\u01c1\63\3\2\2\2\u01c2"+
		"\u01c0\3\2\2\2\u01c3\u01c8\7\64\2\2\u01c4\u01c5\7\24\2\2\u01c5\u01c7\t"+
		"\6\2\2\u01c6\u01c4\3\2\2\2\u01c7\u01ca\3\2\2\2\u01c8\u01c6\3\2\2\2\u01c8"+
		"\u01c9\3\2\2\2\u01c9\65\3\2\2\2\u01ca\u01c8\3\2\2\2\u01cb\u01d2\7\62\2"+
		"\2\u01cc\u01cd\58\35\2\u01cd\u01ce\7\5\2\2\u01ce\u01cf\5:\36\2\u01cf\u01d0"+
		"\5J&\2\u01d0\u01d2\3\2\2\2\u01d1\u01cb\3\2\2\2\u01d1\u01cc\3\2\2\2\u01d2"+
		"\67\3\2\2\2\u01d3\u01d4\5<\37\2\u01d49\3\2\2\2\u01d5\u01d6\5<\37\2\u01d6"+
		";\3\2\2\2\u01d7\u01de\5> \2\u01d8\u01de\5X-\2\u01d9\u01de\5^\60\2\u01da"+
		"\u01de\5`\61\2\u01db\u01de\5f\64\2\u01dc\u01de\5F$\2\u01dd\u01d7\3\2\2"+
		"\2\u01dd\u01d8\3\2\2\2\u01dd\u01d9\3\2\2\2\u01dd\u01da\3\2\2\2\u01dd\u01db"+
		"\3\2\2\2\u01dd\u01dc\3\2\2\2\u01de=\3\2\2\2\u01df\u01e3\5@!\2\u01e0\u01e3"+
		"\5B\"\2\u01e1\u01e3\5D#\2\u01e2\u01df\3\2\2\2\u01e2\u01e0\3\2\2\2\u01e2"+
		"\u01e1\3\2\2\2\u01e3?\3\2\2\2\u01e4\u01e5\7\13\2\2\u01e5\u01e6\5<\37\2"+
		"\u01e6\u01e7\7\f\2\2\u01e7A\3\2\2\2\u01e8\u01e9\7\20\2\2\u01e9\u01ee\5"+
		"<\37\2\u01ea\u01eb\7\4\2\2\u01eb\u01ed\5<\37\2\u01ec\u01ea\3\2\2\2\u01ed"+
		"\u01f0\3\2\2\2\u01ee\u01ec\3\2\2\2\u01ee\u01ef\3\2\2\2\u01ef\u01f1\3\2"+
		"\2\2\u01f0\u01ee\3\2\2\2\u01f1\u01f2\7\21\2\2\u01f2C\3\2\2\2\u01f3\u01f4"+
		"\7\13\2\2\u01f4\u01f5\5<\37\2\u01f5\u01f6\5J&\2\u01f6\u01f7\7\f\2\2\u01f7"+
		"E\3\2\2\2\u01f8\u01fb\5H%\2\u01f9\u01fa\7\n\2\2\u01fa\u01fc\5H%\2\u01fb"+
		"\u01f9\3\2\2\2\u01fc\u01fd\3\2\2\2\u01fd\u01fb\3\2\2\2\u01fd\u01fe\3\2"+
		"\2\2\u01feG\3\2\2\2\u01ff\u0205\5> \2\u0200\u0205\5X-\2\u0201\u0205\5"+
		"^\60\2\u0202\u0205\5`\61\2\u0203\u0205\5f\64\2\u0204\u01ff\3\2\2\2\u0204"+
		"\u0200\3\2\2\2\u0204\u0201\3\2\2\2\u0204\u0202\3\2\2\2\u0204\u0203\3\2"+
		"\2\2\u0205I\3\2\2\2\u0206\u0207\7\6\2\2\u0207\u0209\5L\'\2\u0208\u0206"+
		"\3\2\2\2\u0208\u0209\3\2\2\2\u0209\u020c\3\2\2\2\u020a\u020b\7\7\2\2\u020b"+
		"\u020d\5N(\2\u020c\u020a\3\2\2\2\u020c\u020d\3\2\2\2\u020dK\3\2\2\2\u020e"+
		"\u0211\5R*\2\u020f\u0211\5P)\2\u0210\u020e\3\2\2\2\u0210\u020f\3\2\2\2"+
		"\u0211M\3\2\2\2\u0212\u0215\5R*\2\u0213\u0215\5P)\2\u0214\u0212\3\2\2"+
		"\2\u0214\u0213\3\2\2\2\u0215O\3\2\2\2\u0216\u0217\7\20\2\2\u0217\u021c"+
		"\5R*\2\u0218\u0219\7\4\2\2\u0219\u021b\5R*\2\u021a\u0218\3\2\2\2\u021b"+
		"\u021e\3\2\2\2\u021c\u021a\3\2\2\2\u021c\u021d\3\2\2\2\u021d\u021f\3\2"+
		"\2\2\u021e\u021c\3\2\2\2\u021f\u0220\7\21\2\2\u0220Q\3\2\2\2\u0221\u0222"+
		"\5T+\2\u0222\u0223\7\n\2\2\u0223\u0225\3\2\2\2\u0224\u0221\3\2\2\2\u0224"+
		"\u0225\3\2\2\2\u0225\u0226\3\2\2\2\u0226\u0229\7\b\2\2\u0227\u0228\7\n"+
		"\2\2\u0228\u022a\5V,\2\u0229\u0227\3\2\2\2\u0229\u022a\3\2\2\2\u022a\u022f"+
		"\3\2\2\2\u022b\u022d\5T+\2\u022c\u022b\3\2\2\2\u022c\u022d\3\2\2\2\u022d"+
		"\u022f\3\2\2\2\u022e\u0224\3\2\2\2\u022e\u022c\3\2\2\2\u022fS\3\2\2\2"+
		"\u0230\u0231\5<\37\2\u0231U\3\2\2\2\u0232\u0233\5<\37\2\u0233W\3\2\2\2"+
		"\u0234\u0238\5\\/\2\u0235\u0236\5Z.\2\u0236\u0237\5\\/\2\u0237\u0239\3"+
		"\2\2\2\u0238\u0235\3\2\2\2\u0239\u023a\3\2\2\2\u023a\u0238\3\2\2\2\u023a"+
		"\u023b\3\2\2\2\u023bY\3\2\2\2\u023c\u023d\t\7\2\2\u023d[\3\2\2\2\u023e"+
		"\u0243\5> \2\u023f\u0243\5^\60\2\u0240\u0243\5`\61\2\u0241\u0243\5f\64"+
		"\2\u0242\u023e\3\2\2\2\u0242\u023f\3\2\2\2\u0242\u0240\3\2\2\2\u0242\u0241"+
		"\3\2\2\2\u0243]\3\2\2\2\u0244\u0245\7\27\2\2\u0245\u0246\5f\64\2\u0246"+
		"_\3\2\2\2\u0247\u024a\5b\62\2\u0248\u024a\5d\63\2\u0249\u0247\3\2\2\2"+
		"\u0249\u0248\3\2\2\2\u024aa\3\2\2\2\u024b\u024f\5> \2\u024c\u024f\5^\60"+
		"\2\u024d\u024f\5f\64\2\u024e\u024b\3\2\2\2\u024e\u024c\3\2\2\2\u024e\u024d"+
		"\3\2\2\2\u024f\u0250\3\2\2\2\u0250\u0251\5l\67\2\u0251c\3\2\2\2\u0252"+
		"\u0255\5> \2\u0253\u0255\5f\64\2\u0254\u0252\3\2\2\2\u0254\u0253\3\2\2"+
		"\2\u0255\u0256\3\2\2\2\u0256\u0257\5\u0080A\2\u0257e\3\2\2\2\u0258\u0262"+
		"\5h\65\2\u0259\u0262\5j\66\2\u025a\u0262\5l\67\2\u025b\u0262\5n8\2\u025c"+
		"\u0262\5x=\2\u025d\u0262\5z>\2\u025e\u0262\5|?\2\u025f\u0262\5~@\2\u0260"+
		"\u0262\5\u008cG\2\u0261\u0258\3\2\2\2\u0261\u0259\3\2\2\2\u0261\u025a"+
		"\3\2\2\2\u0261\u025b\3\2\2\2\u0261\u025c\3\2\2\2\u0261\u025d\3\2\2\2\u0261"+
		"\u025e\3\2\2\2\u0261\u025f\3\2\2\2\u0261\u0260\3\2\2\2\u0262g\3\2\2\2"+
		"\u0263\u0264\7)\2\2\u0264i\3\2\2\2\u0265\u0266\7\33\2\2\u0266\u0267\5"+
		"\u008aF\2\u0267k\3\2\2\2\u0268\u026a\7\26\2\2\u0269\u0268\3\2\2\2\u0269"+
		"\u026a\3\2\2\2\u026a\u026b\3\2\2\2\u026b\u026c\7\31\2\2\u026c\u026d\7"+
		"\63\2\2\u026dm\3\2\2\2\u026e\u0270\7\16\2\2\u026f\u0271\5p9\2\u0270\u026f"+
		"\3\2\2\2\u0270\u0271\3\2\2\2\u0271\u0276\3\2\2\2\u0272\u0273\7\n\2\2\u0273"+
		"\u0275\5p9\2\u0274\u0272\3\2\2\2\u0275\u0278\3\2\2\2\u0276\u0274\3\2\2"+
		"\2\u0276\u0277\3\2\2\2\u0277\u0279\3\2\2\2\u0278\u0276\3\2\2\2\u0279\u027a"+
		"\7\17\2\2\u027ao\3\2\2\2\u027b\u0280\5\u0084C\2\u027c\u0280\5r:\2\u027d"+
		"\u0280\5t;\2\u027e\u0280\5v<\2\u027f\u027b\3\2\2\2\u027f\u027c\3\2\2\2"+
		"\u027f\u027d\3\2\2\2\u027f\u027e\3\2\2\2\u0280q\3\2\2\2\u0281\u0282\7"+
		"\27\2\2\u0282\u0283\5\u0084C\2\u0283s\3\2\2\2\u0284\u0285\7\r\2\2\u0285"+
		"\u0286\5\u008aF\2\u0286u\3\2\2\2\u0287\u0288\7\31\2\2\u0288\u0289\5\u008a"+
		"F\2\u0289w\3\2\2\2\u028a\u028b\7\r\2\2\u028by\3\2\2\2\u028c\u028d\7\30"+
		"\2\2\u028d{\3\2\2\2\u028e\u028f\7\31\2\2\u028f}\3\2\2\2\u0290\u0291\7"+
		"\32\2\2\u0291\177\3\2\2\2\u0292\u0293\t\b\2\2\u0293\u0081\3\2\2\2\u0294"+
		"\u0296\7\16\2\2\u0295\u0297\5\u0084C\2\u0296\u0295\3\2\2\2\u0296\u0297"+
		"\3\2\2\2\u0297\u029c\3\2\2\2\u0298\u0299\7\n\2\2\u0299\u029b\5\u0084C"+
		"\2\u029a\u0298\3\2\2\2\u029b\u029e\3\2\2\2\u029c\u029a\3\2\2\2\u029c\u029d"+
		"\3\2\2\2\u029d\u029f\3\2\2\2\u029e\u029c\3\2\2\2\u029f\u02a0\7\17\2\2"+
		"\u02a0\u0083\3\2\2\2\u02a1\u02a4\5\u0086D\2\u02a2\u02a4\5\u0088E\2\u02a3"+
		"\u02a1\3\2\2\2\u02a3\u02a2\3\2\2\2\u02a4\u0085\3\2\2\2\u02a5\u02a6\t\t"+
		"\2\2\u02a6\u02a7\5\u008aF\2\u02a7\u0087\3\2\2\2\u02a8\u02a9\5\u008aF\2"+
		"\u02a9\u0089\3\2\2\2\u02aa\u02ab\7\64\2\2\u02ab\u008b\3\2\2\2\u02ac\u02ae"+
		"\t\n\2\2\u02ad\u02af\7\27\2\2\u02ae\u02ad\3\2\2\2\u02ae\u02af\3\2\2\2"+
		"\u02af\u008d\3\2\2\2O\u0092\u0096\u009b\u00a0\u00a6\u00aa\u00b5\u00c1"+
		"\u00c8\u00d1\u00d7\u00db\u00e1\u00e8\u00ed\u00f4\u00f7\u0107\u010f\u011b"+
		"\u0120\u0129\u012f\u0134\u0136\u013b\u0142\u0148\u014f\u0155\u015e\u0164"+
		"\u016d\u0171\u0176\u017c\u0182\u018a\u018c\u0192\u019a\u01a1\u01a6\u01ad"+
		"\u01b3\u01bb\u01c0\u01c8\u01d1\u01dd\u01e2\u01ee\u01fd\u0204\u0208\u020c"+
		"\u0210\u0214\u021c\u0224\u0229\u022c\u022e\u023a\u0242\u0249\u024e\u0254"+
		"\u0261\u0269\u0270\u0276\u027f\u0296\u029c\u02a3\u02ae";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}