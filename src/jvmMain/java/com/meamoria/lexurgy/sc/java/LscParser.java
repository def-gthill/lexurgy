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
		NEGATION=20, WORD_BOUNDARY=21, BETWEEN_WORDS=22, CLASSREF=23, INTERSECTION=24, 
		CLASS_DECL=25, FEATURE_DECL=26, DIACRITIC=27, DIA_BEFORE=28, DIA_FLOATING=29, 
		SYMBOL=30, SYLLABLE_DECL=31, EXPLICIT_SYLLABLES=32, ANY_SYLLABLE=33, DEROMANIZER=34, 
		ROMANIZER=35, ALL_MATCHING=36, FIRST_MATCHING=37, PROPAGATE=38, LITERAL=39, 
		UNCHANGED=40, NUMBER=41, NAME=42, STR1=43, STR=44;
	public static final int
		RULE_lscFile = 0, RULE_statement = 1, RULE_classDecl = 2, RULE_classElement = 3, 
		RULE_featureDecl = 4, RULE_plusFeature = 5, RULE_nullAlias = 6, RULE_diacriticDecl = 7, 
		RULE_diacriticModifier = 8, RULE_symbolDecl = 9, RULE_symbolName = 10, 
		RULE_syllableDecl = 11, RULE_syllablePattern = 12, RULE_deromanizer = 13, 
		RULE_romanizer = 14, RULE_interRomanizer = 15, RULE_changeRule = 16, RULE_changeRuleModifier = 17, 
		RULE_filter = 18, RULE_block = 19, RULE_blockElement = 20, RULE_blockType = 21, 
		RULE_expressionList = 22, RULE_ruleName = 23, RULE_expression = 24, RULE_from = 25, 
		RULE_to = 26, RULE_ruleElement = 27, RULE_bounded = 28, RULE_group = 29, 
		RULE_list = 30, RULE_sequence = 31, RULE_lookaround = 32, RULE_freeElement = 33, 
		RULE_compoundEnvironment = 34, RULE_condition = 35, RULE_exclusion = 36, 
		RULE_environmentList = 37, RULE_environment = 38, RULE_environmentBefore = 39, 
		RULE_environmentAfter = 40, RULE_intersection = 41, RULE_interfixElement = 42, 
		RULE_negated = 43, RULE_postfix = 44, RULE_capture = 45, RULE_repeater = 46, 
		RULE_simple = 47, RULE_anySyllable = 48, RULE_classRef = 49, RULE_captureRef = 50, 
		RULE_fancyMatrix = 51, RULE_fancyValue = 52, RULE_negatedValue = 53, RULE_absentFeature = 54, 
		RULE_featureVariable = 55, RULE_empty = 56, RULE_boundary = 57, RULE_betweenWords = 58, 
		RULE_repeaterType = 59, RULE_matrix = 60, RULE_matrixValue = 61, RULE_plusFeatureValue = 62, 
		RULE_featureValue = 63, RULE_name = 64, RULE_text = 65;
	private static String[] makeRuleNames() {
		return new String[] {
			"lscFile", "statement", "classDecl", "classElement", "featureDecl", "plusFeature", 
			"nullAlias", "diacriticDecl", "diacriticModifier", "symbolDecl", "symbolName", 
			"syllableDecl", "syllablePattern", "deromanizer", "romanizer", "interRomanizer", 
			"changeRule", "changeRuleModifier", "filter", "block", "blockElement", 
			"blockType", "expressionList", "ruleName", "expression", "from", "to", 
			"ruleElement", "bounded", "group", "list", "sequence", "lookaround", 
			"freeElement", "compoundEnvironment", "condition", "exclusion", "environmentList", 
			"environment", "environmentBefore", "environmentAfter", "intersection", 
			"interfixElement", "negated", "postfix", "capture", "repeater", "simple", 
			"anySyllable", "classRef", "captureRef", "fancyMatrix", "fancyValue", 
			"negatedValue", "absentFeature", "featureVariable", "empty", "boundary", 
			"betweenWords", "repeaterType", "matrix", "matrixValue", "plusFeatureValue", 
			"featureValue", "name", "text"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, null, "'_'", null, null, "'('", "')'", 
			"'*'", "'['", "']'", "'{'", "'}'", "'+'", "'?'", "'-'", "':'", "'!'", 
			"'$'", "'$$'", "'@'", "'&'", null, null, null, null, null, null, "'Syllables'", 
			"'explicit'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "COMMENT", "SEP", "CHANGE", "CONDITION", "EXCLUSION", "ANCHOR", 
			"NEWLINE", "WHITESPACE", "O_PAREN", "C_PAREN", "NULL", "MATRIX_START", 
			"MATRIX_END", "LIST_START", "LIST_END", "AT_LEAST_ONE", "OPTIONAL", "HYPHEN", 
			"RULE_START", "NEGATION", "WORD_BOUNDARY", "BETWEEN_WORDS", "CLASSREF", 
			"INTERSECTION", "CLASS_DECL", "FEATURE_DECL", "DIACRITIC", "DIA_BEFORE", 
			"DIA_FLOATING", "SYMBOL", "SYLLABLE_DECL", "EXPLICIT_SYLLABLES", "ANY_SYLLABLE", 
			"DEROMANIZER", "ROMANIZER", "ALL_MATCHING", "FIRST_MATCHING", "PROPAGATE", 
			"LITERAL", "UNCHANGED", "NUMBER", "NAME", "STR1", "STR"
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
			setState(160);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case WHITESPACE:
				enterOuterAlt(_localctx, 1);
				{
				setState(132);
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
				setState(136);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(133);
						match(NEWLINE);
						}
						} 
					}
					setState(138);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
				}
				setState(140);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CLASS_DECL) | (1L << FEATURE_DECL) | (1L << DIACRITIC) | (1L << SYMBOL) | (1L << SYLLABLE_DECL) | (1L << DEROMANIZER) | (1L << ROMANIZER) | (1L << NAME))) != 0)) {
					{
					setState(139);
					statement();
					}
				}

				setState(150);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(143); 
						_errHandler.sync(this);
						_la = _input.LA(1);
						do {
							{
							{
							setState(142);
							match(NEWLINE);
							}
							}
							setState(145); 
							_errHandler.sync(this);
							_la = _input.LA(1);
						} while ( _la==NEWLINE );
						setState(147);
						statement();
						}
						} 
					}
					setState(152);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
				}
				setState(156);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NEWLINE) {
					{
					{
					setState(153);
					match(NEWLINE);
					}
					}
					setState(158);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(159);
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
			setState(171);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(162);
				featureDecl();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(163);
				diacriticDecl();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(164);
				symbolDecl();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(165);
				classDecl();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(166);
				syllableDecl();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(167);
				deromanizer();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(168);
				changeRule();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(169);
				interRomanizer();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(170);
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
			setState(173);
			match(CLASS_DECL);
			setState(174);
			match(WHITESPACE);
			setState(175);
			name();
			setState(176);
			match(WHITESPACE);
			setState(177);
			match(LIST_START);
			setState(178);
			classElement();
			setState(183);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SEP) {
				{
				{
				setState(179);
				match(SEP);
				setState(180);
				classElement();
				}
				}
				setState(185);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(186);
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
			setState(190);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CLASSREF:
				enterOuterAlt(_localctx, 1);
				{
				setState(188);
				classRef();
				}
				break;
			case NAME:
			case STR1:
			case STR:
				enterOuterAlt(_localctx, 2);
				{
				setState(189);
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
			setState(192);
			match(FEATURE_DECL);
			setState(193);
			match(WHITESPACE);
			setState(222);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				{
				{
				setState(194);
				plusFeature();
				setState(199);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==SEP) {
					{
					{
					setState(195);
					match(SEP);
					setState(196);
					plusFeature();
					}
					}
					setState(201);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				break;
			case 2:
				{
				{
				setState(202);
				name();
				setState(204);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==WHITESPACE) {
					{
					setState(203);
					match(WHITESPACE);
					}
				}

				setState(206);
				match(O_PAREN);
				setState(210);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NULL) {
					{
					setState(207);
					nullAlias();
					setState(208);
					match(SEP);
					}
				}

				setState(212);
				featureValue();
				setState(217);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==SEP) {
					{
					{
					setState(213);
					match(SEP);
					setState(214);
					featureValue();
					}
					}
					setState(219);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(220);
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

	public static class PlusFeatureContext extends ParserRuleContext {
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
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
		enterRule(_localctx, 10, RULE_plusFeature);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(225);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==AT_LEAST_ONE) {
				{
				setState(224);
				match(AT_LEAST_ONE);
				}
			}

			setState(227);
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
		enterRule(_localctx, 12, RULE_nullAlias);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(229);
			match(NULL);
			setState(230);
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
		enterRule(_localctx, 14, RULE_diacriticDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(232);
			match(DIACRITIC);
			setState(233);
			match(WHITESPACE);
			setState(234);
			text();
			setState(235);
			match(WHITESPACE);
			setState(241);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DIA_BEFORE || _la==DIA_FLOATING) {
				{
				{
				setState(236);
				diacriticModifier();
				setState(237);
				match(WHITESPACE);
				}
				}
				setState(243);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(244);
			matrix();
			setState(249);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WHITESPACE) {
				{
				{
				setState(245);
				match(WHITESPACE);
				setState(246);
				diacriticModifier();
				}
				}
				setState(251);
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
		enterRule(_localctx, 16, RULE_diacriticModifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(252);
			_la = _input.LA(1);
			if ( !(_la==DIA_BEFORE || _la==DIA_FLOATING) ) {
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
		enterRule(_localctx, 18, RULE_symbolDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(254);
			match(SYMBOL);
			setState(255);
			match(WHITESPACE);
			setState(256);
			symbolName();
			setState(266);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case EOF:
			case SEP:
			case NEWLINE:
				{
				setState(261);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==SEP) {
					{
					{
					setState(257);
					match(SEP);
					setState(258);
					symbolName();
					}
					}
					setState(263);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case WHITESPACE:
				{
				setState(264);
				match(WHITESPACE);
				setState(265);
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
		enterRule(_localctx, 20, RULE_symbolName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(268);
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
		enterRule(_localctx, 22, RULE_syllableDecl);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(270);
			match(SYLLABLE_DECL);
			setState(271);
			match(RULE_START);
			setState(288);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				{
				setState(273); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(272);
					match(NEWLINE);
					}
					}
					setState(275); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NEWLINE );
				setState(277);
				match(EXPLICIT_SYLLABLES);
				}
				break;
			case 2:
				{
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
						syllablePattern();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(286); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
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
		enterRule(_localctx, 24, RULE_syllablePattern);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(290);
			ruleElement();
			setState(291);
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
		enterRule(_localctx, 26, RULE_deromanizer);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(293);
			match(DEROMANIZER);
			setState(296);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WHITESPACE) {
				{
				setState(294);
				match(WHITESPACE);
				setState(295);
				match(LITERAL);
				}
			}

			setState(298);
			match(RULE_START);
			setState(300); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(299);
				match(NEWLINE);
				}
				}
				setState(302); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NEWLINE );
			setState(304);
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
		enterRule(_localctx, 28, RULE_romanizer);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(306);
			match(ROMANIZER);
			setState(309);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WHITESPACE) {
				{
				setState(307);
				match(WHITESPACE);
				setState(308);
				match(LITERAL);
				}
			}

			setState(311);
			match(RULE_START);
			setState(313); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(312);
				match(NEWLINE);
				}
				}
				setState(315); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NEWLINE );
			setState(317);
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
		enterRule(_localctx, 30, RULE_interRomanizer);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(319);
			match(ROMANIZER);
			setState(320);
			match(HYPHEN);
			setState(321);
			ruleName();
			setState(324);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WHITESPACE) {
				{
				setState(322);
				match(WHITESPACE);
				setState(323);
				match(LITERAL);
				}
			}

			setState(326);
			match(RULE_START);
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
		enterRule(_localctx, 32, RULE_changeRule);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(334);
			ruleName();
			setState(339);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WHITESPACE) {
				{
				{
				setState(335);
				match(WHITESPACE);
				setState(336);
				changeRuleModifier();
				}
				}
				setState(341);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(343);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==RULE_START) {
				{
				setState(342);
				match(RULE_START);
				}
			}

			setState(346); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(345);
				match(NEWLINE);
				}
				}
				setState(348); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NEWLINE );
			setState(350);
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

	public static class ChangeRuleModifierContext extends ParserRuleContext {
		public FilterContext filter() {
			return getRuleContext(FilterContext.class,0);
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
		enterRule(_localctx, 34, RULE_changeRuleModifier);
		try {
			setState(354);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case MATRIX_START:
			case CLASSREF:
				enterOuterAlt(_localctx, 1);
				{
				setState(352);
				filter();
				}
				break;
			case PROPAGATE:
				enterOuterAlt(_localctx, 2);
				{
				setState(353);
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
			setState(358);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CLASSREF:
				enterOuterAlt(_localctx, 1);
				{
				setState(356);
				classRef();
				}
				break;
			case MATRIX_START:
				enterOuterAlt(_localctx, 2);
				{
				setState(357);
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
			setState(360);
			blockElement();
			setState(380);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,37,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
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
					blockType();
					setState(367);
					match(RULE_START);
					setState(374);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case WHITESPACE:
						{
						setState(368);
						match(WHITESPACE);
						}
						break;
					case NEWLINE:
						{
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
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(376);
					blockElement();
					}
					} 
				}
				setState(382);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,37,_ctx);
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
			setState(400);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,40,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(383);
				expressionList();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(384);
				match(O_PAREN);
				setState(388);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NEWLINE) {
					{
					{
					setState(385);
					match(NEWLINE);
					}
					}
					setState(390);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(391);
				block();
				setState(395);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NEWLINE) {
					{
					{
					setState(392);
					match(NEWLINE);
					}
					}
					setState(397);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(398);
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
			setState(402);
			_la = _input.LA(1);
			if ( !(_la==ALL_MATCHING || _la==FIRST_MATCHING) ) {
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
		enterRule(_localctx, 44, RULE_expressionList);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(404);
			expression();
			setState(413);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,42,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
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
					expression();
					}
					} 
				}
				setState(415);
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
		enterRule(_localctx, 46, RULE_ruleName);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(416);
			match(NAME);
			setState(421);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==HYPHEN) {
				{
				{
				setState(417);
				match(HYPHEN);
				setState(418);
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
				setState(423);
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
		enterRule(_localctx, 48, RULE_expression);
		try {
			setState(430);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case UNCHANGED:
				enterOuterAlt(_localctx, 1);
				{
				setState(424);
				match(UNCHANGED);
				}
				break;
			case O_PAREN:
			case NULL:
			case MATRIX_START:
			case LIST_START:
			case NEGATION:
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
				setState(425);
				from();
				setState(426);
				match(CHANGE);
				setState(427);
				to();
				setState(428);
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
		enterRule(_localctx, 50, RULE_from);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(432);
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
		enterRule(_localctx, 52, RULE_to);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(434);
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
		public IntersectionContext intersection() {
			return getRuleContext(IntersectionContext.class,0);
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
		public LookaroundContext lookaround() {
			return getRuleContext(LookaroundContext.class,0);
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
			setState(443);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,45,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(436);
				bounded();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(437);
				intersection();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(438);
				negated();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(439);
				postfix();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(440);
				simple();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(441);
				sequence();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(442);
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
		enterRule(_localctx, 56, RULE_bounded);
		try {
			setState(447);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case O_PAREN:
				enterOuterAlt(_localctx, 1);
				{
				setState(445);
				group();
				}
				break;
			case LIST_START:
				enterOuterAlt(_localctx, 2);
				{
				setState(446);
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
		enterRule(_localctx, 58, RULE_group);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(449);
			match(O_PAREN);
			setState(450);
			ruleElement();
			setState(451);
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
		enterRule(_localctx, 60, RULE_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(453);
			match(LIST_START);
			setState(454);
			ruleElement();
			setState(459);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SEP) {
				{
				{
				setState(455);
				match(SEP);
				setState(456);
				ruleElement();
				}
				}
				setState(461);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(462);
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
		enterRule(_localctx, 62, RULE_sequence);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(464);
			freeElement();
			setState(467); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(465);
					match(WHITESPACE);
					setState(466);
					freeElement();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(469); 
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

	public static class LookaroundContext extends ParserRuleContext {
		public TerminalNode O_PAREN() { return getToken(LscParser.O_PAREN, 0); }
		public FreeElementContext freeElement() {
			return getRuleContext(FreeElementContext.class,0);
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
		enterRule(_localctx, 64, RULE_lookaround);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(471);
			match(O_PAREN);
			setState(472);
			freeElement();
			setState(473);
			compoundEnvironment();
			setState(474);
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

	public static class FreeElementContext extends ParserRuleContext {
		public BoundedContext bounded() {
			return getRuleContext(BoundedContext.class,0);
		}
		public IntersectionContext intersection() {
			return getRuleContext(IntersectionContext.class,0);
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
		enterRule(_localctx, 66, RULE_freeElement);
		try {
			setState(481);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,49,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(476);
				bounded();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(477);
				intersection();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(478);
				negated();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(479);
				postfix();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(480);
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
		enterRule(_localctx, 68, RULE_compoundEnvironment);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(485);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CONDITION) {
				{
				setState(483);
				match(CONDITION);
				setState(484);
				condition();
				}
			}

			setState(489);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EXCLUSION) {
				{
				setState(487);
				match(EXCLUSION);
				setState(488);
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
		enterRule(_localctx, 70, RULE_condition);
		try {
			setState(493);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,52,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(491);
				environment();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(492);
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
		enterRule(_localctx, 72, RULE_exclusion);
		try {
			setState(497);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,53,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(495);
				environment();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(496);
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
		enterRule(_localctx, 74, RULE_environmentList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(499);
			match(LIST_START);
			setState(500);
			environment();
			setState(505);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SEP) {
				{
				{
				setState(501);
				match(SEP);
				setState(502);
				environment();
				}
				}
				setState(507);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(508);
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
		enterRule(_localctx, 76, RULE_environment);
		int _la;
		try {
			setState(523);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,58,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(513);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << O_PAREN) | (1L << NULL) | (1L << MATRIX_START) | (1L << LIST_START) | (1L << NEGATION) | (1L << WORD_BOUNDARY) | (1L << BETWEEN_WORDS) | (1L << CLASSREF) | (1L << ANY_SYLLABLE) | (1L << NAME) | (1L << STR1) | (1L << STR))) != 0)) {
					{
					setState(510);
					environmentBefore();
					setState(511);
					match(WHITESPACE);
					}
				}

				setState(515);
				match(ANCHOR);
				setState(518);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==WHITESPACE) {
					{
					setState(516);
					match(WHITESPACE);
					setState(517);
					environmentAfter();
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(521);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << O_PAREN) | (1L << NULL) | (1L << MATRIX_START) | (1L << LIST_START) | (1L << NEGATION) | (1L << WORD_BOUNDARY) | (1L << BETWEEN_WORDS) | (1L << CLASSREF) | (1L << ANY_SYLLABLE) | (1L << NAME) | (1L << STR1) | (1L << STR))) != 0)) {
					{
					setState(520);
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
		enterRule(_localctx, 78, RULE_environmentBefore);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(525);
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
		enterRule(_localctx, 80, RULE_environmentAfter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(527);
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

	public static class IntersectionContext extends ParserRuleContext {
		public List<InterfixElementContext> interfixElement() {
			return getRuleContexts(InterfixElementContext.class);
		}
		public InterfixElementContext interfixElement(int i) {
			return getRuleContext(InterfixElementContext.class,i);
		}
		public List<TerminalNode> INTERSECTION() { return getTokens(LscParser.INTERSECTION); }
		public TerminalNode INTERSECTION(int i) {
			return getToken(LscParser.INTERSECTION, i);
		}
		public IntersectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_intersection; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LscVisitor ) return ((LscVisitor<? extends T>)visitor).visitIntersection(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IntersectionContext intersection() throws RecognitionException {
		IntersectionContext _localctx = new IntersectionContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_intersection);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(529);
			interfixElement();
			setState(532); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(530);
				match(INTERSECTION);
				setState(531);
				interfixElement();
				}
				}
				setState(534); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==INTERSECTION );
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 84, RULE_interfixElement);
		try {
			setState(540);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,60,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(536);
				bounded();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(537);
				negated();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(538);
				postfix();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(539);
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
		enterRule(_localctx, 86, RULE_negated);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(542);
			match(NEGATION);
			setState(543);
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
		enterRule(_localctx, 88, RULE_postfix);
		try {
			setState(547);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,61,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(545);
				capture();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(546);
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
		enterRule(_localctx, 90, RULE_capture);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(552);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case O_PAREN:
			case LIST_START:
				{
				setState(549);
				bounded();
				}
				break;
			case NEGATION:
				{
				setState(550);
				negated();
				}
				break;
			case NULL:
			case MATRIX_START:
			case WORD_BOUNDARY:
			case BETWEEN_WORDS:
			case CLASSREF:
			case ANY_SYLLABLE:
			case NAME:
			case STR1:
			case STR:
				{
				setState(551);
				simple();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(554);
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
		enterRule(_localctx, 92, RULE_repeater);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(558);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case O_PAREN:
			case LIST_START:
				{
				setState(556);
				bounded();
				}
				break;
			case NULL:
			case MATRIX_START:
			case WORD_BOUNDARY:
			case BETWEEN_WORDS:
			case CLASSREF:
			case ANY_SYLLABLE:
			case NAME:
			case STR1:
			case STR:
				{
				setState(557);
				simple();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(560);
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
		enterRule(_localctx, 94, RULE_simple);
		try {
			setState(570);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,64,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(562);
				anySyllable();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(563);
				classRef();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(564);
				captureRef();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(565);
				fancyMatrix();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(566);
				empty();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(567);
				boundary();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(568);
				betweenWords();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(569);
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
		enterRule(_localctx, 96, RULE_anySyllable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(572);
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
		enterRule(_localctx, 98, RULE_classRef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(574);
			match(CLASSREF);
			setState(575);
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
		enterRule(_localctx, 100, RULE_captureRef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(577);
			match(WORD_BOUNDARY);
			setState(578);
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
		enterRule(_localctx, 102, RULE_fancyMatrix);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(580);
			match(MATRIX_START);
			setState(582);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NULL) | (1L << AT_LEAST_ONE) | (1L << HYPHEN) | (1L << NEGATION) | (1L << WORD_BOUNDARY) | (1L << NAME))) != 0)) {
				{
				setState(581);
				fancyValue();
				}
			}

			setState(588);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WHITESPACE) {
				{
				{
				setState(584);
				match(WHITESPACE);
				setState(585);
				fancyValue();
				}
				}
				setState(590);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(591);
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
		public PlusFeatureValueContext plusFeatureValue() {
			return getRuleContext(PlusFeatureValueContext.class,0);
		}
		public FeatureValueContext featureValue() {
			return getRuleContext(FeatureValueContext.class,0);
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
		enterRule(_localctx, 104, RULE_fancyValue);
		try {
			setState(598);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case AT_LEAST_ONE:
			case HYPHEN:
				enterOuterAlt(_localctx, 1);
				{
				setState(593);
				plusFeatureValue();
				}
				break;
			case NAME:
				enterOuterAlt(_localctx, 2);
				{
				setState(594);
				featureValue();
				}
				break;
			case NEGATION:
				enterOuterAlt(_localctx, 3);
				{
				setState(595);
				negatedValue();
				}
				break;
			case NULL:
				enterOuterAlt(_localctx, 4);
				{
				setState(596);
				absentFeature();
				}
				break;
			case WORD_BOUNDARY:
				enterOuterAlt(_localctx, 5);
				{
				setState(597);
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
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
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
		enterRule(_localctx, 106, RULE_negatedValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(600);
			match(NEGATION);
			setState(601);
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
		enterRule(_localctx, 108, RULE_absentFeature);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(603);
			match(NULL);
			setState(604);
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
		enterRule(_localctx, 110, RULE_featureVariable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(606);
			match(WORD_BOUNDARY);
			setState(607);
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
		enterRule(_localctx, 112, RULE_empty);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(609);
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
		enterRule(_localctx, 114, RULE_boundary);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(611);
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
		enterRule(_localctx, 116, RULE_betweenWords);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(613);
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
		enterRule(_localctx, 118, RULE_repeaterType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(615);
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
		enterRule(_localctx, 120, RULE_matrix);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(617);
			match(MATRIX_START);
			setState(619);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AT_LEAST_ONE) | (1L << HYPHEN) | (1L << NAME))) != 0)) {
				{
				setState(618);
				matrixValue();
				}
			}

			setState(625);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WHITESPACE) {
				{
				{
				setState(621);
				match(WHITESPACE);
				setState(622);
				matrixValue();
				}
				}
				setState(627);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(628);
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
		enterRule(_localctx, 122, RULE_matrixValue);
		try {
			setState(632);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case AT_LEAST_ONE:
			case HYPHEN:
				enterOuterAlt(_localctx, 1);
				{
				setState(630);
				plusFeatureValue();
				}
				break;
			case NAME:
				enterOuterAlt(_localctx, 2);
				{
				setState(631);
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
		enterRule(_localctx, 124, RULE_plusFeatureValue);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(634);
			_la = _input.LA(1);
			if ( !(_la==AT_LEAST_ONE || _la==HYPHEN) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(635);
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
		enterRule(_localctx, 126, RULE_featureValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(637);
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
		enterRule(_localctx, 128, RULE_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(639);
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
		enterRule(_localctx, 130, RULE_text);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(641);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NAME) | (1L << STR1) | (1L << STR))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(643);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NEGATION) {
				{
				setState(642);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3.\u0288\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\3\2\3\2\7\2\u0089\n\2\f\2\16\2\u008c"+
		"\13\2\3\2\5\2\u008f\n\2\3\2\6\2\u0092\n\2\r\2\16\2\u0093\3\2\7\2\u0097"+
		"\n\2\f\2\16\2\u009a\13\2\3\2\7\2\u009d\n\2\f\2\16\2\u00a0\13\2\3\2\5\2"+
		"\u00a3\n\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3\u00ae\n\3\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\7\4\u00b8\n\4\f\4\16\4\u00bb\13\4\3\4\3\4\3\5\3"+
		"\5\5\5\u00c1\n\5\3\6\3\6\3\6\3\6\3\6\7\6\u00c8\n\6\f\6\16\6\u00cb\13\6"+
		"\3\6\3\6\5\6\u00cf\n\6\3\6\3\6\3\6\3\6\5\6\u00d5\n\6\3\6\3\6\3\6\7\6\u00da"+
		"\n\6\f\6\16\6\u00dd\13\6\3\6\3\6\5\6\u00e1\n\6\3\7\5\7\u00e4\n\7\3\7\3"+
		"\7\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\7\t\u00f2\n\t\f\t\16\t\u00f5"+
		"\13\t\3\t\3\t\3\t\7\t\u00fa\n\t\f\t\16\t\u00fd\13\t\3\n\3\n\3\13\3\13"+
		"\3\13\3\13\3\13\7\13\u0106\n\13\f\13\16\13\u0109\13\13\3\13\3\13\5\13"+
		"\u010d\n\13\3\f\3\f\3\r\3\r\3\r\6\r\u0114\n\r\r\r\16\r\u0115\3\r\3\r\6"+
		"\r\u011a\n\r\r\r\16\r\u011b\3\r\6\r\u011f\n\r\r\r\16\r\u0120\5\r\u0123"+
		"\n\r\3\16\3\16\3\16\3\17\3\17\3\17\5\17\u012b\n\17\3\17\3\17\6\17\u012f"+
		"\n\17\r\17\16\17\u0130\3\17\3\17\3\20\3\20\3\20\5\20\u0138\n\20\3\20\3"+
		"\20\6\20\u013c\n\20\r\20\16\20\u013d\3\20\3\20\3\21\3\21\3\21\3\21\3\21"+
		"\5\21\u0147\n\21\3\21\3\21\6\21\u014b\n\21\r\21\16\21\u014c\3\21\3\21"+
		"\3\22\3\22\3\22\7\22\u0154\n\22\f\22\16\22\u0157\13\22\3\22\5\22\u015a"+
		"\n\22\3\22\6\22\u015d\n\22\r\22\16\22\u015e\3\22\3\22\3\23\3\23\5\23\u0165"+
		"\n\23\3\24\3\24\5\24\u0169\n\24\3\25\3\25\6\25\u016d\n\25\r\25\16\25\u016e"+
		"\3\25\3\25\3\25\3\25\6\25\u0175\n\25\r\25\16\25\u0176\5\25\u0179\n\25"+
		"\3\25\3\25\7\25\u017d\n\25\f\25\16\25\u0180\13\25\3\26\3\26\3\26\7\26"+
		"\u0185\n\26\f\26\16\26\u0188\13\26\3\26\3\26\7\26\u018c\n\26\f\26\16\26"+
		"\u018f\13\26\3\26\3\26\5\26\u0193\n\26\3\27\3\27\3\30\3\30\6\30\u0199"+
		"\n\30\r\30\16\30\u019a\3\30\7\30\u019e\n\30\f\30\16\30\u01a1\13\30\3\31"+
		"\3\31\3\31\7\31\u01a6\n\31\f\31\16\31\u01a9\13\31\3\32\3\32\3\32\3\32"+
		"\3\32\3\32\5\32\u01b1\n\32\3\33\3\33\3\34\3\34\3\35\3\35\3\35\3\35\3\35"+
		"\3\35\3\35\5\35\u01be\n\35\3\36\3\36\5\36\u01c2\n\36\3\37\3\37\3\37\3"+
		"\37\3 \3 \3 \3 \7 \u01cc\n \f \16 \u01cf\13 \3 \3 \3!\3!\3!\6!\u01d6\n"+
		"!\r!\16!\u01d7\3\"\3\"\3\"\3\"\3\"\3#\3#\3#\3#\3#\5#\u01e4\n#\3$\3$\5"+
		"$\u01e8\n$\3$\3$\5$\u01ec\n$\3%\3%\5%\u01f0\n%\3&\3&\5&\u01f4\n&\3\'\3"+
		"\'\3\'\3\'\7\'\u01fa\n\'\f\'\16\'\u01fd\13\'\3\'\3\'\3(\3(\3(\5(\u0204"+
		"\n(\3(\3(\3(\5(\u0209\n(\3(\5(\u020c\n(\5(\u020e\n(\3)\3)\3*\3*\3+\3+"+
		"\3+\6+\u0217\n+\r+\16+\u0218\3,\3,\3,\3,\5,\u021f\n,\3-\3-\3-\3.\3.\5"+
		".\u0226\n.\3/\3/\3/\5/\u022b\n/\3/\3/\3\60\3\60\5\60\u0231\n\60\3\60\3"+
		"\60\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\5\61\u023d\n\61\3\62\3\62"+
		"\3\63\3\63\3\63\3\64\3\64\3\64\3\65\3\65\5\65\u0249\n\65\3\65\3\65\7\65"+
		"\u024d\n\65\f\65\16\65\u0250\13\65\3\65\3\65\3\66\3\66\3\66\3\66\3\66"+
		"\5\66\u0259\n\66\3\67\3\67\3\67\38\38\38\39\39\39\3:\3:\3;\3;\3<\3<\3"+
		"=\3=\3>\3>\5>\u026e\n>\3>\3>\7>\u0272\n>\f>\16>\u0275\13>\3>\3>\3?\3?"+
		"\5?\u027b\n?\3@\3@\3@\3A\3A\3B\3B\3C\3C\5C\u0286\nC\3C\2\2D\2\4\6\b\n"+
		"\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNPRTVXZ\\"+
		"^`bdfhjlnprtvxz|~\u0080\u0082\u0084\2\b\3\2\36\37\3\2&\'\3\2+,\4\2\r\r"+
		"\22\23\4\2\22\22\24\24\3\2,.\2\u02a8\2\u00a2\3\2\2\2\4\u00ad\3\2\2\2\6"+
		"\u00af\3\2\2\2\b\u00c0\3\2\2\2\n\u00c2\3\2\2\2\f\u00e3\3\2\2\2\16\u00e7"+
		"\3\2\2\2\20\u00ea\3\2\2\2\22\u00fe\3\2\2\2\24\u0100\3\2\2\2\26\u010e\3"+
		"\2\2\2\30\u0110\3\2\2\2\32\u0124\3\2\2\2\34\u0127\3\2\2\2\36\u0134\3\2"+
		"\2\2 \u0141\3\2\2\2\"\u0150\3\2\2\2$\u0164\3\2\2\2&\u0168\3\2\2\2(\u016a"+
		"\3\2\2\2*\u0192\3\2\2\2,\u0194\3\2\2\2.\u0196\3\2\2\2\60\u01a2\3\2\2\2"+
		"\62\u01b0\3\2\2\2\64\u01b2\3\2\2\2\66\u01b4\3\2\2\28\u01bd\3\2\2\2:\u01c1"+
		"\3\2\2\2<\u01c3\3\2\2\2>\u01c7\3\2\2\2@\u01d2\3\2\2\2B\u01d9\3\2\2\2D"+
		"\u01e3\3\2\2\2F\u01e7\3\2\2\2H\u01ef\3\2\2\2J\u01f3\3\2\2\2L\u01f5\3\2"+
		"\2\2N\u020d\3\2\2\2P\u020f\3\2\2\2R\u0211\3\2\2\2T\u0213\3\2\2\2V\u021e"+
		"\3\2\2\2X\u0220\3\2\2\2Z\u0225\3\2\2\2\\\u022a\3\2\2\2^\u0230\3\2\2\2"+
		"`\u023c\3\2\2\2b\u023e\3\2\2\2d\u0240\3\2\2\2f\u0243\3\2\2\2h\u0246\3"+
		"\2\2\2j\u0258\3\2\2\2l\u025a\3\2\2\2n\u025d\3\2\2\2p\u0260\3\2\2\2r\u0263"+
		"\3\2\2\2t\u0265\3\2\2\2v\u0267\3\2\2\2x\u0269\3\2\2\2z\u026b\3\2\2\2|"+
		"\u027a\3\2\2\2~\u027c\3\2\2\2\u0080\u027f\3\2\2\2\u0082\u0281\3\2\2\2"+
		"\u0084\u0283\3\2\2\2\u0086\u00a3\7\n\2\2\u0087\u0089\7\t\2\2\u0088\u0087"+
		"\3\2\2\2\u0089\u008c\3\2\2\2\u008a\u0088\3\2\2\2\u008a\u008b\3\2\2\2\u008b"+
		"\u008e\3\2\2\2\u008c\u008a\3\2\2\2\u008d\u008f\5\4\3\2\u008e\u008d\3\2"+
		"\2\2\u008e\u008f\3\2\2\2\u008f\u0098\3\2\2\2\u0090\u0092\7\t\2\2\u0091"+
		"\u0090\3\2\2\2\u0092\u0093\3\2\2\2\u0093\u0091\3\2\2\2\u0093\u0094\3\2"+
		"\2\2\u0094\u0095\3\2\2\2\u0095\u0097\5\4\3\2\u0096\u0091\3\2\2\2\u0097"+
		"\u009a\3\2\2\2\u0098\u0096\3\2\2\2\u0098\u0099\3\2\2\2\u0099\u009e\3\2"+
		"\2\2\u009a\u0098\3\2\2\2\u009b\u009d\7\t\2\2\u009c\u009b\3\2\2\2\u009d"+
		"\u00a0\3\2\2\2\u009e\u009c\3\2\2\2\u009e\u009f\3\2\2\2\u009f\u00a1\3\2"+
		"\2\2\u00a0\u009e\3\2\2\2\u00a1\u00a3\7\2\2\3\u00a2\u0086\3\2\2\2\u00a2"+
		"\u008a\3\2\2\2\u00a3\3\3\2\2\2\u00a4\u00ae\5\n\6\2\u00a5\u00ae\5\20\t"+
		"\2\u00a6\u00ae\5\24\13\2\u00a7\u00ae\5\6\4\2\u00a8\u00ae\5\30\r\2\u00a9"+
		"\u00ae\5\34\17\2\u00aa\u00ae\5\"\22\2\u00ab\u00ae\5 \21\2\u00ac\u00ae"+
		"\5\36\20\2\u00ad\u00a4\3\2\2\2\u00ad\u00a5\3\2\2\2\u00ad\u00a6\3\2\2\2"+
		"\u00ad\u00a7\3\2\2\2\u00ad\u00a8\3\2\2\2\u00ad\u00a9\3\2\2\2\u00ad\u00aa"+
		"\3\2\2\2\u00ad\u00ab\3\2\2\2\u00ad\u00ac\3\2\2\2\u00ae\5\3\2\2\2\u00af"+
		"\u00b0\7\33\2\2\u00b0\u00b1\7\n\2\2\u00b1\u00b2\5\u0082B\2\u00b2\u00b3"+
		"\7\n\2\2\u00b3\u00b4\7\20\2\2\u00b4\u00b9\5\b\5\2\u00b5\u00b6\7\4\2\2"+
		"\u00b6\u00b8\5\b\5\2\u00b7\u00b5\3\2\2\2\u00b8\u00bb\3\2\2\2\u00b9\u00b7"+
		"\3\2\2\2\u00b9\u00ba\3\2\2\2\u00ba\u00bc\3\2\2\2\u00bb\u00b9\3\2\2\2\u00bc"+
		"\u00bd\7\21\2\2\u00bd\7\3\2\2\2\u00be\u00c1\5d\63\2\u00bf\u00c1\5\u0084"+
		"C\2\u00c0\u00be\3\2\2\2\u00c0\u00bf\3\2\2\2\u00c1\t\3\2\2\2\u00c2\u00c3"+
		"\7\34\2\2\u00c3\u00e0\7\n\2\2\u00c4\u00c9\5\f\7\2\u00c5\u00c6\7\4\2\2"+
		"\u00c6\u00c8\5\f\7\2\u00c7\u00c5\3\2\2\2\u00c8\u00cb\3\2\2\2\u00c9\u00c7"+
		"\3\2\2\2\u00c9\u00ca\3\2\2\2\u00ca\u00e1\3\2\2\2\u00cb\u00c9\3\2\2\2\u00cc"+
		"\u00ce\5\u0082B\2\u00cd\u00cf\7\n\2\2\u00ce\u00cd\3\2\2\2\u00ce\u00cf"+
		"\3\2\2\2\u00cf\u00d0\3\2\2\2\u00d0\u00d4\7\13\2\2\u00d1\u00d2\5\16\b\2"+
		"\u00d2\u00d3\7\4\2\2\u00d3\u00d5\3\2\2\2\u00d4\u00d1\3\2\2\2\u00d4\u00d5"+
		"\3\2\2\2\u00d5\u00d6\3\2\2\2\u00d6\u00db\5\u0080A\2\u00d7\u00d8\7\4\2"+
		"\2\u00d8\u00da\5\u0080A\2\u00d9\u00d7\3\2\2\2\u00da\u00dd\3\2\2\2\u00db"+
		"\u00d9\3\2\2\2\u00db\u00dc\3\2\2\2\u00dc\u00de\3\2\2\2\u00dd\u00db\3\2"+
		"\2\2\u00de\u00df\7\f\2\2\u00df\u00e1\3\2\2\2\u00e0\u00c4\3\2\2\2\u00e0"+
		"\u00cc\3\2\2\2\u00e1\13\3\2\2\2\u00e2\u00e4\7\22\2\2\u00e3\u00e2\3\2\2"+
		"\2\u00e3\u00e4\3\2\2\2\u00e4\u00e5\3\2\2\2\u00e5\u00e6\5\u0082B\2\u00e6"+
		"\r\3\2\2\2\u00e7\u00e8\7\r\2\2\u00e8\u00e9\5\u0080A\2\u00e9\17\3\2\2\2"+
		"\u00ea\u00eb\7\35\2\2\u00eb\u00ec\7\n\2\2\u00ec\u00ed\5\u0084C\2\u00ed"+
		"\u00f3\7\n\2\2\u00ee\u00ef\5\22\n\2\u00ef\u00f0\7\n\2\2\u00f0\u00f2\3"+
		"\2\2\2\u00f1\u00ee\3\2\2\2\u00f2\u00f5\3\2\2\2\u00f3\u00f1\3\2\2\2\u00f3"+
		"\u00f4\3\2\2\2\u00f4\u00f6\3\2\2\2\u00f5\u00f3\3\2\2\2\u00f6\u00fb\5z"+
		">\2\u00f7\u00f8\7\n\2\2\u00f8\u00fa\5\22\n\2\u00f9\u00f7\3\2\2\2\u00fa"+
		"\u00fd\3\2\2\2\u00fb\u00f9\3\2\2\2\u00fb\u00fc\3\2\2\2\u00fc\21\3\2\2"+
		"\2\u00fd\u00fb\3\2\2\2\u00fe\u00ff\t\2\2\2\u00ff\23\3\2\2\2\u0100\u0101"+
		"\7 \2\2\u0101\u0102\7\n\2\2\u0102\u010c\5\26\f\2\u0103\u0104\7\4\2\2\u0104"+
		"\u0106\5\26\f\2\u0105\u0103\3\2\2\2\u0106\u0109\3\2\2\2\u0107\u0105\3"+
		"\2\2\2\u0107\u0108\3\2\2\2\u0108\u010d\3\2\2\2\u0109\u0107\3\2\2\2\u010a"+
		"\u010b\7\n\2\2\u010b\u010d\5z>\2\u010c\u0107\3\2\2\2\u010c\u010a\3\2\2"+
		"\2\u010d\25\3\2\2\2\u010e\u010f\5\u0084C\2\u010f\27\3\2\2\2\u0110\u0111"+
		"\7!\2\2\u0111\u0122\7\25\2\2\u0112\u0114\7\t\2\2\u0113\u0112\3\2\2\2\u0114"+
		"\u0115\3\2\2\2\u0115\u0113\3\2\2\2\u0115\u0116\3\2\2\2\u0116\u0117\3\2"+
		"\2\2\u0117\u0123\7\"\2\2\u0118\u011a\7\t\2\2\u0119\u0118\3\2\2\2\u011a"+
		"\u011b\3\2\2\2\u011b\u0119\3\2\2\2\u011b\u011c\3\2\2\2\u011c\u011d\3\2"+
		"\2\2\u011d\u011f\5\32\16\2\u011e\u0119\3\2\2\2\u011f\u0120\3\2\2\2\u0120"+
		"\u011e\3\2\2\2\u0120\u0121\3\2\2\2\u0121\u0123\3\2\2\2\u0122\u0113\3\2"+
		"\2\2\u0122\u011e\3\2\2\2\u0123\31\3\2\2\2\u0124\u0125\58\35\2\u0125\u0126"+
		"\5F$\2\u0126\33\3\2\2\2\u0127\u012a\7$\2\2\u0128\u0129\7\n\2\2\u0129\u012b"+
		"\7)\2\2\u012a\u0128\3\2\2\2\u012a\u012b\3\2\2\2\u012b\u012c\3\2\2\2\u012c"+
		"\u012e\7\25\2\2\u012d\u012f\7\t\2\2\u012e\u012d\3\2\2\2\u012f\u0130\3"+
		"\2\2\2\u0130\u012e\3\2\2\2\u0130\u0131\3\2\2\2\u0131\u0132\3\2\2\2\u0132"+
		"\u0133\5(\25\2\u0133\35\3\2\2\2\u0134\u0137\7%\2\2\u0135\u0136\7\n\2\2"+
		"\u0136\u0138\7)\2\2\u0137\u0135\3\2\2\2\u0137\u0138\3\2\2\2\u0138\u0139"+
		"\3\2\2\2\u0139\u013b\7\25\2\2\u013a\u013c\7\t\2\2\u013b\u013a\3\2\2\2"+
		"\u013c\u013d\3\2\2\2\u013d\u013b\3\2\2\2\u013d\u013e\3\2\2\2\u013e\u013f"+
		"\3\2\2\2\u013f\u0140\5(\25\2\u0140\37\3\2\2\2\u0141\u0142\7%\2\2\u0142"+
		"\u0143\7\24\2\2\u0143\u0146\5\60\31\2\u0144\u0145\7\n\2\2\u0145\u0147"+
		"\7)\2\2\u0146\u0144\3\2\2\2\u0146\u0147\3\2\2\2\u0147\u0148\3\2\2\2\u0148"+
		"\u014a\7\25\2\2\u0149\u014b\7\t\2\2\u014a\u0149\3\2\2\2\u014b\u014c\3"+
		"\2\2\2\u014c\u014a\3\2\2\2\u014c\u014d\3\2\2\2\u014d\u014e\3\2\2\2\u014e"+
		"\u014f\5(\25\2\u014f!\3\2\2\2\u0150\u0155\5\60\31\2\u0151\u0152\7\n\2"+
		"\2\u0152\u0154\5$\23\2\u0153\u0151\3\2\2\2\u0154\u0157\3\2\2\2\u0155\u0153"+
		"\3\2\2\2\u0155\u0156\3\2\2\2\u0156\u0159\3\2\2\2\u0157\u0155\3\2\2\2\u0158"+
		"\u015a\7\25\2\2\u0159\u0158\3\2\2\2\u0159\u015a\3\2\2\2\u015a\u015c\3"+
		"\2\2\2\u015b\u015d\7\t\2\2\u015c\u015b\3\2\2\2\u015d\u015e\3\2\2\2\u015e"+
		"\u015c\3\2\2\2\u015e\u015f\3\2\2\2\u015f\u0160\3\2\2\2\u0160\u0161\5("+
		"\25\2\u0161#\3\2\2\2\u0162\u0165\5&\24\2\u0163\u0165\7(\2\2\u0164\u0162"+
		"\3\2\2\2\u0164\u0163\3\2\2\2\u0165%\3\2\2\2\u0166\u0169\5d\63\2\u0167"+
		"\u0169\5h\65\2\u0168\u0166\3\2\2\2\u0168\u0167\3\2\2\2\u0169\'\3\2\2\2"+
		"\u016a\u017e\5*\26\2\u016b\u016d\7\t\2\2\u016c\u016b\3\2\2\2\u016d\u016e"+
		"\3\2\2\2\u016e\u016c\3\2\2\2\u016e\u016f\3\2\2\2\u016f\u0170\3\2\2\2\u0170"+
		"\u0171\5,\27\2\u0171\u0178\7\25\2\2\u0172\u0179\7\n\2\2\u0173\u0175\7"+
		"\t\2\2\u0174\u0173\3\2\2\2\u0175\u0176\3\2\2\2\u0176\u0174\3\2\2\2\u0176"+
		"\u0177\3\2\2\2\u0177\u0179\3\2\2\2\u0178\u0172\3\2\2\2\u0178\u0174\3\2"+
		"\2\2\u0179\u017a\3\2\2\2\u017a\u017b\5*\26\2\u017b\u017d\3\2\2\2\u017c"+
		"\u016c\3\2\2\2\u017d\u0180\3\2\2\2\u017e\u017c\3\2\2\2\u017e\u017f\3\2"+
		"\2\2\u017f)\3\2\2\2\u0180\u017e\3\2\2\2\u0181\u0193\5.\30\2\u0182\u0186"+
		"\7\13\2\2\u0183\u0185\7\t\2\2\u0184\u0183\3\2\2\2\u0185\u0188\3\2\2\2"+
		"\u0186\u0184\3\2\2\2\u0186\u0187\3\2\2\2\u0187\u0189\3\2\2\2\u0188\u0186"+
		"\3\2\2\2\u0189\u018d\5(\25\2\u018a\u018c\7\t\2\2\u018b\u018a\3\2\2\2\u018c"+
		"\u018f\3\2\2\2\u018d\u018b\3\2\2\2\u018d\u018e\3\2\2\2\u018e\u0190\3\2"+
		"\2\2\u018f\u018d\3\2\2\2\u0190\u0191\7\f\2\2\u0191\u0193\3\2\2\2\u0192"+
		"\u0181\3\2\2\2\u0192\u0182\3\2\2\2\u0193+\3\2\2\2\u0194\u0195\t\3\2\2"+
		"\u0195-\3\2\2\2\u0196\u019f\5\62\32\2\u0197\u0199\7\t\2\2\u0198\u0197"+
		"\3\2\2\2\u0199\u019a\3\2\2\2\u019a\u0198\3\2\2\2\u019a\u019b\3\2\2\2\u019b"+
		"\u019c\3\2\2\2\u019c\u019e\5\62\32\2\u019d\u0198\3\2\2\2\u019e\u01a1\3"+
		"\2\2\2\u019f\u019d\3\2\2\2\u019f\u01a0\3\2\2\2\u01a0/\3\2\2\2\u01a1\u019f"+
		"\3\2\2\2\u01a2\u01a7\7,\2\2\u01a3\u01a4\7\24\2\2\u01a4\u01a6\t\4\2\2\u01a5"+
		"\u01a3\3\2\2\2\u01a6\u01a9\3\2\2\2\u01a7\u01a5\3\2\2\2\u01a7\u01a8\3\2"+
		"\2\2\u01a8\61\3\2\2\2\u01a9\u01a7\3\2\2\2\u01aa\u01b1\7*\2\2\u01ab\u01ac"+
		"\5\64\33\2\u01ac\u01ad\7\5\2\2\u01ad\u01ae\5\66\34\2\u01ae\u01af\5F$\2"+
		"\u01af\u01b1\3\2\2\2\u01b0\u01aa\3\2\2\2\u01b0\u01ab\3\2\2\2\u01b1\63"+
		"\3\2\2\2\u01b2\u01b3\58\35\2\u01b3\65\3\2\2\2\u01b4\u01b5\58\35\2\u01b5"+
		"\67\3\2\2\2\u01b6\u01be\5:\36\2\u01b7\u01be\5T+\2\u01b8\u01be\5X-\2\u01b9"+
		"\u01be\5Z.\2\u01ba\u01be\5`\61\2\u01bb\u01be\5@!\2\u01bc\u01be\5B\"\2"+
		"\u01bd\u01b6\3\2\2\2\u01bd\u01b7\3\2\2\2\u01bd\u01b8\3\2\2\2\u01bd\u01b9"+
		"\3\2\2\2\u01bd\u01ba\3\2\2\2\u01bd\u01bb\3\2\2\2\u01bd\u01bc\3\2\2\2\u01be"+
		"9\3\2\2\2\u01bf\u01c2\5<\37\2\u01c0\u01c2\5> \2\u01c1\u01bf\3\2\2\2\u01c1"+
		"\u01c0\3\2\2\2\u01c2;\3\2\2\2\u01c3\u01c4\7\13\2\2\u01c4\u01c5\58\35\2"+
		"\u01c5\u01c6\7\f\2\2\u01c6=\3\2\2\2\u01c7\u01c8\7\20\2\2\u01c8\u01cd\5"+
		"8\35\2\u01c9\u01ca\7\4\2\2\u01ca\u01cc\58\35\2\u01cb\u01c9\3\2\2\2\u01cc"+
		"\u01cf\3\2\2\2\u01cd\u01cb\3\2\2\2\u01cd\u01ce\3\2\2\2\u01ce\u01d0\3\2"+
		"\2\2\u01cf\u01cd\3\2\2\2\u01d0\u01d1\7\21\2\2\u01d1?\3\2\2\2\u01d2\u01d5"+
		"\5D#\2\u01d3\u01d4\7\n\2\2\u01d4\u01d6\5D#\2\u01d5\u01d3\3\2\2\2\u01d6"+
		"\u01d7\3\2\2\2\u01d7\u01d5\3\2\2\2\u01d7\u01d8\3\2\2\2\u01d8A\3\2\2\2"+
		"\u01d9\u01da\7\13\2\2\u01da\u01db\5D#\2\u01db\u01dc\5F$\2\u01dc\u01dd"+
		"\7\f\2\2\u01ddC\3\2\2\2\u01de\u01e4\5:\36\2\u01df\u01e4\5T+\2\u01e0\u01e4"+
		"\5X-\2\u01e1\u01e4\5Z.\2\u01e2\u01e4\5`\61\2\u01e3\u01de\3\2\2\2\u01e3"+
		"\u01df\3\2\2\2\u01e3\u01e0\3\2\2\2\u01e3\u01e1\3\2\2\2\u01e3\u01e2\3\2"+
		"\2\2\u01e4E\3\2\2\2\u01e5\u01e6\7\6\2\2\u01e6\u01e8\5H%\2\u01e7\u01e5"+
		"\3\2\2\2\u01e7\u01e8\3\2\2\2\u01e8\u01eb\3\2\2\2\u01e9\u01ea\7\7\2\2\u01ea"+
		"\u01ec\5J&\2\u01eb\u01e9\3\2\2\2\u01eb\u01ec\3\2\2\2\u01ecG\3\2\2\2\u01ed"+
		"\u01f0\5N(\2\u01ee\u01f0\5L\'\2\u01ef\u01ed\3\2\2\2\u01ef\u01ee\3\2\2"+
		"\2\u01f0I\3\2\2\2\u01f1\u01f4\5N(\2\u01f2\u01f4\5L\'\2\u01f3\u01f1\3\2"+
		"\2\2\u01f3\u01f2\3\2\2\2\u01f4K\3\2\2\2\u01f5\u01f6\7\20\2\2\u01f6\u01fb"+
		"\5N(\2\u01f7\u01f8\7\4\2\2\u01f8\u01fa\5N(\2\u01f9\u01f7\3\2\2\2\u01fa"+
		"\u01fd\3\2\2\2\u01fb\u01f9\3\2\2\2\u01fb\u01fc\3\2\2\2\u01fc\u01fe\3\2"+
		"\2\2\u01fd\u01fb\3\2\2\2\u01fe\u01ff\7\21\2\2\u01ffM\3\2\2\2\u0200\u0201"+
		"\5P)\2\u0201\u0202\7\n\2\2\u0202\u0204\3\2\2\2\u0203\u0200\3\2\2\2\u0203"+
		"\u0204\3\2\2\2\u0204\u0205\3\2\2\2\u0205\u0208\7\b\2\2\u0206\u0207\7\n"+
		"\2\2\u0207\u0209\5R*\2\u0208\u0206\3\2\2\2\u0208\u0209\3\2\2\2\u0209\u020e"+
		"\3\2\2\2\u020a\u020c\5P)\2\u020b\u020a\3\2\2\2\u020b\u020c\3\2\2\2\u020c"+
		"\u020e\3\2\2\2\u020d\u0203\3\2\2\2\u020d\u020b\3\2\2\2\u020eO\3\2\2\2"+
		"\u020f\u0210\58\35\2\u0210Q\3\2\2\2\u0211\u0212\58\35\2\u0212S\3\2\2\2"+
		"\u0213\u0216\5V,\2\u0214\u0215\7\32\2\2\u0215\u0217\5V,\2\u0216\u0214"+
		"\3\2\2\2\u0217\u0218\3\2\2\2\u0218\u0216\3\2\2\2\u0218\u0219\3\2\2\2\u0219"+
		"U\3\2\2\2\u021a\u021f\5:\36\2\u021b\u021f\5X-\2\u021c\u021f\5Z.\2\u021d"+
		"\u021f\5`\61\2\u021e\u021a\3\2\2\2\u021e\u021b\3\2\2\2\u021e\u021c\3\2"+
		"\2\2\u021e\u021d\3\2\2\2\u021fW\3\2\2\2\u0220\u0221\7\26\2\2\u0221\u0222"+
		"\5`\61\2\u0222Y\3\2\2\2\u0223\u0226\5\\/\2\u0224\u0226\5^\60\2\u0225\u0223"+
		"\3\2\2\2\u0225\u0224\3\2\2\2\u0226[\3\2\2\2\u0227\u022b\5:\36\2\u0228"+
		"\u022b\5X-\2\u0229\u022b\5`\61\2\u022a\u0227\3\2\2\2\u022a\u0228\3\2\2"+
		"\2\u022a\u0229\3\2\2\2\u022b\u022c\3\2\2\2\u022c\u022d\5f\64\2\u022d]"+
		"\3\2\2\2\u022e\u0231\5:\36\2\u022f\u0231\5`\61\2\u0230\u022e\3\2\2\2\u0230"+
		"\u022f\3\2\2\2\u0231\u0232\3\2\2\2\u0232\u0233\5x=\2\u0233_\3\2\2\2\u0234"+
		"\u023d\5b\62\2\u0235\u023d\5d\63\2\u0236\u023d\5f\64\2\u0237\u023d\5h"+
		"\65\2\u0238\u023d\5r:\2\u0239\u023d\5t;\2\u023a\u023d\5v<\2\u023b\u023d"+
		"\5\u0084C\2\u023c\u0234\3\2\2\2\u023c\u0235\3\2\2\2\u023c\u0236\3\2\2"+
		"\2\u023c\u0237\3\2\2\2\u023c\u0238\3\2\2\2\u023c\u0239\3\2\2\2\u023c\u023a"+
		"\3\2\2\2\u023c\u023b\3\2\2\2\u023da\3\2\2\2\u023e\u023f\7#\2\2\u023fc"+
		"\3\2\2\2\u0240\u0241\7\31\2\2\u0241\u0242\5\u0082B\2\u0242e\3\2\2\2\u0243"+
		"\u0244\7\27\2\2\u0244\u0245\7+\2\2\u0245g\3\2\2\2\u0246\u0248\7\16\2\2"+
		"\u0247\u0249\5j\66\2\u0248\u0247\3\2\2\2\u0248\u0249\3\2\2\2\u0249\u024e"+
		"\3\2\2\2\u024a\u024b\7\n\2\2\u024b\u024d\5j\66\2\u024c\u024a\3\2\2\2\u024d"+
		"\u0250\3\2\2\2\u024e\u024c\3\2\2\2\u024e\u024f\3\2\2\2\u024f\u0251\3\2"+
		"\2\2\u0250\u024e\3\2\2\2\u0251\u0252\7\17\2\2\u0252i\3\2\2\2\u0253\u0259"+
		"\5~@\2\u0254\u0259\5\u0080A\2\u0255\u0259\5l\67\2\u0256\u0259\5n8\2\u0257"+
		"\u0259\5p9\2\u0258\u0253\3\2\2\2\u0258\u0254\3\2\2\2\u0258\u0255\3\2\2"+
		"\2\u0258\u0256\3\2\2\2\u0258\u0257\3\2\2\2\u0259k\3\2\2\2\u025a\u025b"+
		"\7\26\2\2\u025b\u025c\5\u0082B\2\u025cm\3\2\2\2\u025d\u025e\7\r\2\2\u025e"+
		"\u025f\5\u0082B\2\u025fo\3\2\2\2\u0260\u0261\7\27\2\2\u0261\u0262\5\u0082"+
		"B\2\u0262q\3\2\2\2\u0263\u0264\7\r\2\2\u0264s\3\2\2\2\u0265\u0266\7\27"+
		"\2\2\u0266u\3\2\2\2\u0267\u0268\7\30\2\2\u0268w\3\2\2\2\u0269\u026a\t"+
		"\5\2\2\u026ay\3\2\2\2\u026b\u026d\7\16\2\2\u026c\u026e\5|?\2\u026d\u026c"+
		"\3\2\2\2\u026d\u026e\3\2\2\2\u026e\u0273\3\2\2\2\u026f\u0270\7\n\2\2\u0270"+
		"\u0272\5|?\2\u0271\u026f\3\2\2\2\u0272\u0275\3\2\2\2\u0273\u0271\3\2\2"+
		"\2\u0273\u0274\3\2\2\2\u0274\u0276\3\2\2\2\u0275\u0273\3\2\2\2\u0276\u0277"+
		"\7\17\2\2\u0277{\3\2\2\2\u0278\u027b\5~@\2\u0279\u027b\5\u0080A\2\u027a"+
		"\u0278\3\2\2\2\u027a\u0279\3\2\2\2\u027b}\3\2\2\2\u027c\u027d\t\6\2\2"+
		"\u027d\u027e\5\u0082B\2\u027e\177\3\2\2\2\u027f\u0280\5\u0082B\2\u0280"+
		"\u0081\3\2\2\2\u0281\u0282\7,\2\2\u0282\u0083\3\2\2\2\u0283\u0285\t\7"+
		"\2\2\u0284\u0286\7\26\2\2\u0285\u0284\3\2\2\2\u0285\u0286\3\2\2\2\u0286"+
		"\u0085\3\2\2\2J\u008a\u008e\u0093\u0098\u009e\u00a2\u00ad\u00b9\u00c0"+
		"\u00c9\u00ce\u00d4\u00db\u00e0\u00e3\u00f3\u00fb\u0107\u010c\u0115\u011b"+
		"\u0120\u0122\u012a\u0130\u0137\u013d\u0146\u014c\u0155\u0159\u015e\u0164"+
		"\u0168\u016e\u0176\u0178\u017e\u0186\u018d\u0192\u019a\u019f\u01a7\u01b0"+
		"\u01bd\u01c1\u01cd\u01d7\u01e3\u01e7\u01eb\u01ef\u01f3\u01fb\u0203\u0208"+
		"\u020b\u020d\u0218\u021e\u0225\u022a\u0230\u023c\u0248\u024e\u0258\u026d"+
		"\u0273\u027a\u0285";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}