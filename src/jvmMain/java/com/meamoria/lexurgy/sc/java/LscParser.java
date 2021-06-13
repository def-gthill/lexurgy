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
		SYMBOL=30, SYLLABLE_DECL=31, EXPLICIT_SYLLABLES=32, DEROMANIZER=33, ROMANIZER=34, 
		ALL_MATCHING=35, FIRST_MATCHING=36, PROPAGATE=37, LITERAL=38, UNCHANGED=39, 
		NUMBER=40, NAME=41, STR1=42, STR=43;
	public static final int
		RULE_lscFile = 0, RULE_statement = 1, RULE_classDecl = 2, RULE_classElement = 3, 
		RULE_featureDecl = 4, RULE_plusFeature = 5, RULE_nullAlias = 6, RULE_diacriticDecl = 7, 
		RULE_diacriticModifier = 8, RULE_symbolDecl = 9, RULE_symbolName = 10, 
		RULE_syllableDecl = 11, RULE_syllablePattern = 12, RULE_syllableElement = 13, 
		RULE_deromanizer = 14, RULE_romanizer = 15, RULE_interRomanizer = 16, 
		RULE_changeRule = 17, RULE_changeRuleModifier = 18, RULE_filter = 19, 
		RULE_block = 20, RULE_blockElement = 21, RULE_blockType = 22, RULE_expressionList = 23, 
		RULE_ruleName = 24, RULE_expression = 25, RULE_condition = 26, RULE_exclusion = 27, 
		RULE_from = 28, RULE_to = 29, RULE_environmentList = 30, RULE_environment = 31, 
		RULE_environmentBefore = 32, RULE_environmentAfter = 33, RULE_ruleElement = 34, 
		RULE_sequence = 35, RULE_sequenceElement = 36, RULE_capture = 37, RULE_repeater = 38, 
		RULE_group = 39, RULE_list = 40, RULE_intersection = 41, RULE_intersectionElement = 42, 
		RULE_simple = 43, RULE_negated = 44, RULE_classRef = 45, RULE_captureRef = 46, 
		RULE_fancyMatrix = 47, RULE_fancyValue = 48, RULE_negatedValue = 49, RULE_absentFeature = 50, 
		RULE_featureVariable = 51, RULE_empty = 52, RULE_boundary = 53, RULE_betweenWords = 54, 
		RULE_repeaterType = 55, RULE_matrix = 56, RULE_matrixValue = 57, RULE_plusFeatureValue = 58, 
		RULE_featureValue = 59, RULE_name = 60, RULE_text = 61;
	private static String[] makeRuleNames() {
		return new String[] {
			"lscFile", "statement", "classDecl", "classElement", "featureDecl", "plusFeature", 
			"nullAlias", "diacriticDecl", "diacriticModifier", "symbolDecl", "symbolName", 
			"syllableDecl", "syllablePattern", "syllableElement", "deromanizer", 
			"romanizer", "interRomanizer", "changeRule", "changeRuleModifier", "filter", 
			"block", "blockElement", "blockType", "expressionList", "ruleName", "expression", 
			"condition", "exclusion", "from", "to", "environmentList", "environment", 
			"environmentBefore", "environmentAfter", "ruleElement", "sequence", "sequenceElement", 
			"capture", "repeater", "group", "list", "intersection", "intersectionElement", 
			"simple", "negated", "classRef", "captureRef", "fancyMatrix", "fancyValue", 
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
			"DIA_FLOATING", "SYMBOL", "SYLLABLE_DECL", "EXPLICIT_SYLLABLES", "DEROMANIZER", 
			"ROMANIZER", "ALL_MATCHING", "FIRST_MATCHING", "PROPAGATE", "LITERAL", 
			"UNCHANGED", "NUMBER", "NAME", "STR1", "STR"
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
			setState(152);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case WHITESPACE:
				enterOuterAlt(_localctx, 1);
				{
				setState(124);
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
				setState(128);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(125);
						match(NEWLINE);
						}
						} 
					}
					setState(130);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
				}
				setState(132);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CLASS_DECL) | (1L << FEATURE_DECL) | (1L << DIACRITIC) | (1L << SYMBOL) | (1L << SYLLABLE_DECL) | (1L << DEROMANIZER) | (1L << ROMANIZER) | (1L << NAME))) != 0)) {
					{
					setState(131);
					statement();
					}
				}

				setState(142);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(135); 
						_errHandler.sync(this);
						_la = _input.LA(1);
						do {
							{
							{
							setState(134);
							match(NEWLINE);
							}
							}
							setState(137); 
							_errHandler.sync(this);
							_la = _input.LA(1);
						} while ( _la==NEWLINE );
						setState(139);
						statement();
						}
						} 
					}
					setState(144);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
				}
				setState(148);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NEWLINE) {
					{
					{
					setState(145);
					match(NEWLINE);
					}
					}
					setState(150);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(151);
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
			setState(163);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(154);
				featureDecl();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(155);
				diacriticDecl();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(156);
				symbolDecl();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(157);
				classDecl();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(158);
				syllableDecl();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(159);
				deromanizer();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(160);
				changeRule();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(161);
				interRomanizer();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(162);
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
			setState(165);
			match(CLASS_DECL);
			setState(166);
			match(WHITESPACE);
			setState(167);
			name();
			setState(168);
			match(WHITESPACE);
			setState(169);
			match(LIST_START);
			setState(170);
			classElement();
			setState(175);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SEP) {
				{
				{
				setState(171);
				match(SEP);
				setState(172);
				classElement();
				}
				}
				setState(177);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(178);
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
			setState(182);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CLASSREF:
				enterOuterAlt(_localctx, 1);
				{
				setState(180);
				classRef();
				}
				break;
			case NAME:
			case STR1:
			case STR:
				enterOuterAlt(_localctx, 2);
				{
				setState(181);
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
			setState(184);
			match(FEATURE_DECL);
			setState(185);
			match(WHITESPACE);
			setState(214);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				{
				{
				setState(186);
				plusFeature();
				setState(191);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==SEP) {
					{
					{
					setState(187);
					match(SEP);
					setState(188);
					plusFeature();
					}
					}
					setState(193);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				break;
			case 2:
				{
				{
				setState(194);
				name();
				setState(196);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==WHITESPACE) {
					{
					setState(195);
					match(WHITESPACE);
					}
				}

				setState(198);
				match(O_PAREN);
				setState(202);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NULL) {
					{
					setState(199);
					nullAlias();
					setState(200);
					match(SEP);
					}
				}

				setState(204);
				featureValue();
				setState(209);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==SEP) {
					{
					{
					setState(205);
					match(SEP);
					setState(206);
					featureValue();
					}
					}
					setState(211);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(212);
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
			setState(217);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==AT_LEAST_ONE) {
				{
				setState(216);
				match(AT_LEAST_ONE);
				}
			}

			setState(219);
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
			setState(221);
			match(NULL);
			setState(222);
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
			setState(224);
			match(DIACRITIC);
			setState(225);
			match(WHITESPACE);
			setState(226);
			text();
			setState(227);
			match(WHITESPACE);
			setState(233);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DIA_BEFORE || _la==DIA_FLOATING) {
				{
				{
				setState(228);
				diacriticModifier();
				setState(229);
				match(WHITESPACE);
				}
				}
				setState(235);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(236);
			matrix();
			setState(241);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WHITESPACE) {
				{
				{
				setState(237);
				match(WHITESPACE);
				setState(238);
				diacriticModifier();
				}
				}
				setState(243);
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
			setState(244);
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
			setState(246);
			match(SYMBOL);
			setState(247);
			match(WHITESPACE);
			setState(248);
			symbolName();
			setState(258);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case EOF:
			case SEP:
			case NEWLINE:
				{
				setState(253);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==SEP) {
					{
					{
					setState(249);
					match(SEP);
					setState(250);
					symbolName();
					}
					}
					setState(255);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case WHITESPACE:
				{
				setState(256);
				match(WHITESPACE);
				setState(257);
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
			setState(260);
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
			setState(262);
			match(SYLLABLE_DECL);
			setState(263);
			match(RULE_START);
			setState(280);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				{
				setState(265); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(264);
					match(NEWLINE);
					}
					}
					setState(267); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NEWLINE );
				setState(269);
				match(EXPLICIT_SYLLABLES);
				}
				break;
			case 2:
				{
				setState(276); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(271); 
						_errHandler.sync(this);
						_la = _input.LA(1);
						do {
							{
							{
							setState(270);
							match(NEWLINE);
							}
							}
							setState(273); 
							_errHandler.sync(this);
							_la = _input.LA(1);
						} while ( _la==NEWLINE );
						setState(275);
						syllablePattern();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(278); 
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
		public List<SyllableElementContext> syllableElement() {
			return getRuleContexts(SyllableElementContext.class);
		}
		public SyllableElementContext syllableElement(int i) {
			return getRuleContext(SyllableElementContext.class,i);
		}
		public List<TerminalNode> WHITESPACE() { return getTokens(LscParser.WHITESPACE); }
		public TerminalNode WHITESPACE(int i) {
			return getToken(LscParser.WHITESPACE, i);
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
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(282);
			syllableElement();
			setState(287);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WHITESPACE) {
				{
				{
				setState(283);
				match(WHITESPACE);
				setState(284);
				syllableElement();
				}
				}
				setState(289);
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

	public static class SyllableElementContext extends ParserRuleContext {
		public ClassRefContext classRef() {
			return getRuleContext(ClassRefContext.class,0);
		}
		public SyllableElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_syllableElement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LscVisitor ) return ((LscVisitor<? extends T>)visitor).visitSyllableElement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SyllableElementContext syllableElement() throws RecognitionException {
		SyllableElementContext _localctx = new SyllableElementContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_syllableElement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(290);
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
			setState(292);
			match(DEROMANIZER);
			setState(295);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WHITESPACE) {
				{
				setState(293);
				match(WHITESPACE);
				setState(294);
				match(LITERAL);
				}
			}

			setState(297);
			match(RULE_START);
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
			setState(305);
			match(ROMANIZER);
			setState(308);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WHITESPACE) {
				{
				setState(306);
				match(WHITESPACE);
				setState(307);
				match(LITERAL);
				}
			}

			setState(310);
			match(RULE_START);
			setState(312); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(311);
				match(NEWLINE);
				}
				}
				setState(314); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NEWLINE );
			setState(316);
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
			setState(318);
			match(ROMANIZER);
			setState(319);
			match(HYPHEN);
			setState(320);
			ruleName();
			setState(323);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WHITESPACE) {
				{
				setState(321);
				match(WHITESPACE);
				setState(322);
				match(LITERAL);
				}
			}

			setState(325);
			match(RULE_START);
			setState(327); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(326);
				match(NEWLINE);
				}
				}
				setState(329); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NEWLINE );
			setState(331);
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
			setState(333);
			ruleName();
			setState(338);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WHITESPACE) {
				{
				{
				setState(334);
				match(WHITESPACE);
				setState(335);
				changeRuleModifier();
				}
				}
				setState(340);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(342);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==RULE_START) {
				{
				setState(341);
				match(RULE_START);
				}
			}

			setState(345); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(344);
				match(NEWLINE);
				}
				}
				setState(347); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NEWLINE );
			setState(349);
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
		enterRule(_localctx, 36, RULE_changeRuleModifier);
		try {
			setState(353);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case MATRIX_START:
			case CLASSREF:
				enterOuterAlt(_localctx, 1);
				{
				setState(351);
				filter();
				}
				break;
			case PROPAGATE:
				enterOuterAlt(_localctx, 2);
				{
				setState(352);
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
		enterRule(_localctx, 38, RULE_filter);
		try {
			setState(357);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CLASSREF:
				enterOuterAlt(_localctx, 1);
				{
				setState(355);
				classRef();
				}
				break;
			case MATRIX_START:
				enterOuterAlt(_localctx, 2);
				{
				setState(356);
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
			setState(359);
			blockElement();
			setState(379);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,38,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(361); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(360);
						match(NEWLINE);
						}
						}
						setState(363); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==NEWLINE );
					setState(365);
					blockType();
					setState(366);
					match(RULE_START);
					setState(373);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case WHITESPACE:
						{
						setState(367);
						match(WHITESPACE);
						}
						break;
					case NEWLINE:
						{
						setState(369); 
						_errHandler.sync(this);
						_la = _input.LA(1);
						do {
							{
							{
							setState(368);
							match(NEWLINE);
							}
							}
							setState(371); 
							_errHandler.sync(this);
							_la = _input.LA(1);
						} while ( _la==NEWLINE );
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(375);
					blockElement();
					}
					} 
				}
				setState(381);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,38,_ctx);
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
			setState(399);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,41,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(382);
				expressionList();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(383);
				match(O_PAREN);
				setState(387);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NEWLINE) {
					{
					{
					setState(384);
					match(NEWLINE);
					}
					}
					setState(389);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(390);
				block();
				setState(394);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NEWLINE) {
					{
					{
					setState(391);
					match(NEWLINE);
					}
					}
					setState(396);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(397);
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
		enterRule(_localctx, 44, RULE_blockType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(401);
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
		enterRule(_localctx, 46, RULE_expressionList);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(403);
			expression();
			setState(412);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,43,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(405); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(404);
						match(NEWLINE);
						}
						}
						setState(407); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==NEWLINE );
					setState(409);
					expression();
					}
					} 
				}
				setState(414);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,43,_ctx);
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
		enterRule(_localctx, 48, RULE_ruleName);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(415);
			match(NAME);
			setState(420);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==HYPHEN) {
				{
				{
				setState(416);
				match(HYPHEN);
				setState(417);
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
				setState(422);
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
		enterRule(_localctx, 50, RULE_expression);
		int _la;
		try {
			setState(435);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case UNCHANGED:
				enterOuterAlt(_localctx, 1);
				{
				setState(423);
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
			case NAME:
			case STR1:
			case STR:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(424);
				from();
				setState(425);
				match(CHANGE);
				setState(426);
				to();
				setState(429);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==CONDITION) {
					{
					setState(427);
					match(CONDITION);
					setState(428);
					condition();
					}
				}

				setState(433);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==EXCLUSION) {
					{
					setState(431);
					match(EXCLUSION);
					setState(432);
					exclusion();
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
		enterRule(_localctx, 52, RULE_condition);
		try {
			setState(439);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,48,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(437);
				environment();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(438);
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
		enterRule(_localctx, 54, RULE_exclusion);
		try {
			setState(443);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,49,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(441);
				environment();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(442);
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
		enterRule(_localctx, 56, RULE_from);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(445);
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
		enterRule(_localctx, 58, RULE_to);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(447);
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
		enterRule(_localctx, 60, RULE_environmentList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(449);
			match(LIST_START);
			setState(450);
			environment();
			setState(455);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SEP) {
				{
				{
				setState(451);
				match(SEP);
				setState(452);
				environment();
				}
				}
				setState(457);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(458);
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
		enterRule(_localctx, 62, RULE_environment);
		int _la;
		try {
			setState(473);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,54,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(463);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << O_PAREN) | (1L << NULL) | (1L << MATRIX_START) | (1L << LIST_START) | (1L << NEGATION) | (1L << WORD_BOUNDARY) | (1L << BETWEEN_WORDS) | (1L << CLASSREF) | (1L << NAME) | (1L << STR1) | (1L << STR))) != 0)) {
					{
					setState(460);
					environmentBefore();
					setState(461);
					match(WHITESPACE);
					}
				}

				setState(465);
				match(ANCHOR);
				setState(468);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==WHITESPACE) {
					{
					setState(466);
					match(WHITESPACE);
					setState(467);
					environmentAfter();
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(471);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << O_PAREN) | (1L << NULL) | (1L << MATRIX_START) | (1L << LIST_START) | (1L << NEGATION) | (1L << WORD_BOUNDARY) | (1L << BETWEEN_WORDS) | (1L << CLASSREF) | (1L << NAME) | (1L << STR1) | (1L << STR))) != 0)) {
					{
					setState(470);
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
		enterRule(_localctx, 64, RULE_environmentBefore);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(475);
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
		enterRule(_localctx, 66, RULE_environmentAfter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(477);
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
		public IntersectionContext intersection() {
			return getRuleContext(IntersectionContext.class,0);
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
		enterRule(_localctx, 68, RULE_ruleElement);
		try {
			setState(486);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,55,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(479);
				capture();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(480);
				repeater();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(481);
				group();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(482);
				list();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(483);
				intersection();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(484);
				simple();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(485);
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
		enterRule(_localctx, 70, RULE_sequence);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(488);
			sequenceElement();
			setState(491); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(489);
					match(WHITESPACE);
					setState(490);
					sequenceElement();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(493); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,56,_ctx);
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
		public IntersectionContext intersection() {
			return getRuleContext(IntersectionContext.class,0);
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
		enterRule(_localctx, 72, RULE_sequenceElement);
		try {
			setState(501);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,57,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(495);
				capture();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(496);
				repeater();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(497);
				group();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(498);
				list();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(499);
				intersection();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(500);
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
		enterRule(_localctx, 74, RULE_capture);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(508);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case O_PAREN:
				{
				setState(503);
				group();
				}
				break;
			case LIST_START:
				{
				setState(504);
				list();
				}
				break;
			case NEGATION:
				{
				setState(505);
				negated();
				}
				break;
			case CLASSREF:
				{
				setState(506);
				classRef();
				}
				break;
			case MATRIX_START:
				{
				setState(507);
				fancyMatrix();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(510);
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
		enterRule(_localctx, 76, RULE_repeater);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(515);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case O_PAREN:
				{
				setState(512);
				group();
				}
				break;
			case LIST_START:
				{
				setState(513);
				list();
				}
				break;
			case NULL:
			case MATRIX_START:
			case NEGATION:
			case WORD_BOUNDARY:
			case BETWEEN_WORDS:
			case CLASSREF:
			case NAME:
			case STR1:
			case STR:
				{
				setState(514);
				simple();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(517);
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
		enterRule(_localctx, 78, RULE_group);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(519);
			match(O_PAREN);
			setState(520);
			ruleElement();
			setState(521);
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
		enterRule(_localctx, 80, RULE_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(523);
			match(LIST_START);
			setState(524);
			ruleElement();
			setState(529);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SEP) {
				{
				{
				setState(525);
				match(SEP);
				setState(526);
				ruleElement();
				}
				}
				setState(531);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(532);
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

	public static class IntersectionContext extends ParserRuleContext {
		public List<IntersectionElementContext> intersectionElement() {
			return getRuleContexts(IntersectionElementContext.class);
		}
		public IntersectionElementContext intersectionElement(int i) {
			return getRuleContext(IntersectionElementContext.class,i);
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
			setState(534);
			intersectionElement();
			setState(537); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(535);
				match(INTERSECTION);
				setState(536);
				intersectionElement();
				}
				}
				setState(539); 
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

	public static class IntersectionElementContext extends ParserRuleContext {
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
		public IntersectionElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_intersectionElement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LscVisitor ) return ((LscVisitor<? extends T>)visitor).visitIntersectionElement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IntersectionElementContext intersectionElement() throws RecognitionException {
		IntersectionElementContext _localctx = new IntersectionElementContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_intersectionElement);
		try {
			setState(546);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,62,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(541);
				capture();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(542);
				repeater();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(543);
				group();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(544);
				list();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(545);
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
		enterRule(_localctx, 86, RULE_simple);
		try {
			setState(556);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,63,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(548);
				negated();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(549);
				classRef();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(550);
				captureRef();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(551);
				fancyMatrix();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(552);
				empty();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(553);
				boundary();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(554);
				betweenWords();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(555);
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

	public static class NegatedContext extends ParserRuleContext {
		public TerminalNode NEGATION() { return getToken(LscParser.NEGATION, 0); }
		public ClassRefContext classRef() {
			return getRuleContext(ClassRefContext.class,0);
		}
		public CaptureRefContext captureRef() {
			return getRuleContext(CaptureRefContext.class,0);
		}
		public TextContext text() {
			return getRuleContext(TextContext.class,0);
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
		enterRule(_localctx, 88, RULE_negated);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(558);
			match(NEGATION);
			setState(562);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CLASSREF:
				{
				setState(559);
				classRef();
				}
				break;
			case WORD_BOUNDARY:
				{
				setState(560);
				captureRef();
				}
				break;
			case NAME:
			case STR1:
			case STR:
				{
				setState(561);
				text();
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
		enterRule(_localctx, 90, RULE_classRef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(564);
			match(CLASSREF);
			setState(565);
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
		enterRule(_localctx, 92, RULE_captureRef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(567);
			match(WORD_BOUNDARY);
			setState(568);
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
		enterRule(_localctx, 94, RULE_fancyMatrix);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(570);
			match(MATRIX_START);
			setState(572);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NULL) | (1L << AT_LEAST_ONE) | (1L << HYPHEN) | (1L << NEGATION) | (1L << WORD_BOUNDARY) | (1L << NAME))) != 0)) {
				{
				setState(571);
				fancyValue();
				}
			}

			setState(578);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WHITESPACE) {
				{
				{
				setState(574);
				match(WHITESPACE);
				setState(575);
				fancyValue();
				}
				}
				setState(580);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(581);
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
		enterRule(_localctx, 96, RULE_fancyValue);
		try {
			setState(588);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case AT_LEAST_ONE:
			case HYPHEN:
				enterOuterAlt(_localctx, 1);
				{
				setState(583);
				plusFeatureValue();
				}
				break;
			case NAME:
				enterOuterAlt(_localctx, 2);
				{
				setState(584);
				featureValue();
				}
				break;
			case NEGATION:
				enterOuterAlt(_localctx, 3);
				{
				setState(585);
				negatedValue();
				}
				break;
			case NULL:
				enterOuterAlt(_localctx, 4);
				{
				setState(586);
				absentFeature();
				}
				break;
			case WORD_BOUNDARY:
				enterOuterAlt(_localctx, 5);
				{
				setState(587);
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
		enterRule(_localctx, 98, RULE_negatedValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(590);
			match(NEGATION);
			setState(591);
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
		enterRule(_localctx, 100, RULE_absentFeature);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(593);
			match(NULL);
			setState(594);
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
		enterRule(_localctx, 102, RULE_featureVariable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(596);
			match(WORD_BOUNDARY);
			setState(597);
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
		enterRule(_localctx, 104, RULE_empty);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(599);
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
		enterRule(_localctx, 106, RULE_boundary);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(601);
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
		enterRule(_localctx, 108, RULE_betweenWords);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(603);
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
		enterRule(_localctx, 110, RULE_repeaterType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(605);
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
		enterRule(_localctx, 112, RULE_matrix);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(607);
			match(MATRIX_START);
			setState(609);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AT_LEAST_ONE) | (1L << HYPHEN) | (1L << NAME))) != 0)) {
				{
				setState(608);
				matrixValue();
				}
			}

			setState(615);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WHITESPACE) {
				{
				{
				setState(611);
				match(WHITESPACE);
				setState(612);
				matrixValue();
				}
				}
				setState(617);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(618);
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
		enterRule(_localctx, 114, RULE_matrixValue);
		try {
			setState(622);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case AT_LEAST_ONE:
			case HYPHEN:
				enterOuterAlt(_localctx, 1);
				{
				setState(620);
				plusFeatureValue();
				}
				break;
			case NAME:
				enterOuterAlt(_localctx, 2);
				{
				setState(621);
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
		enterRule(_localctx, 116, RULE_plusFeatureValue);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(624);
			_la = _input.LA(1);
			if ( !(_la==AT_LEAST_ONE || _la==HYPHEN) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(625);
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
		enterRule(_localctx, 118, RULE_featureValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(627);
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
		enterRule(_localctx, 120, RULE_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(629);
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
		enterRule(_localctx, 122, RULE_text);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(631);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NAME) | (1L << STR1) | (1L << STR))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(633);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NEGATION) {
				{
				setState(632);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3-\u027e\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\3\2\3\2\7\2\u0081\n\2\f\2\16\2\u0084\13\2\3\2\5\2\u0087\n"+
		"\2\3\2\6\2\u008a\n\2\r\2\16\2\u008b\3\2\7\2\u008f\n\2\f\2\16\2\u0092\13"+
		"\2\3\2\7\2\u0095\n\2\f\2\16\2\u0098\13\2\3\2\5\2\u009b\n\2\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\5\3\u00a6\n\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\7\4\u00b0\n\4\f\4\16\4\u00b3\13\4\3\4\3\4\3\5\3\5\5\5\u00b9\n\5\3\6\3"+
		"\6\3\6\3\6\3\6\7\6\u00c0\n\6\f\6\16\6\u00c3\13\6\3\6\3\6\5\6\u00c7\n\6"+
		"\3\6\3\6\3\6\3\6\5\6\u00cd\n\6\3\6\3\6\3\6\7\6\u00d2\n\6\f\6\16\6\u00d5"+
		"\13\6\3\6\3\6\5\6\u00d9\n\6\3\7\5\7\u00dc\n\7\3\7\3\7\3\b\3\b\3\b\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\7\t\u00ea\n\t\f\t\16\t\u00ed\13\t\3\t\3\t\3\t"+
		"\7\t\u00f2\n\t\f\t\16\t\u00f5\13\t\3\n\3\n\3\13\3\13\3\13\3\13\3\13\7"+
		"\13\u00fe\n\13\f\13\16\13\u0101\13\13\3\13\3\13\5\13\u0105\n\13\3\f\3"+
		"\f\3\r\3\r\3\r\6\r\u010c\n\r\r\r\16\r\u010d\3\r\3\r\6\r\u0112\n\r\r\r"+
		"\16\r\u0113\3\r\6\r\u0117\n\r\r\r\16\r\u0118\5\r\u011b\n\r\3\16\3\16\3"+
		"\16\7\16\u0120\n\16\f\16\16\16\u0123\13\16\3\17\3\17\3\20\3\20\3\20\5"+
		"\20\u012a\n\20\3\20\3\20\6\20\u012e\n\20\r\20\16\20\u012f\3\20\3\20\3"+
		"\21\3\21\3\21\5\21\u0137\n\21\3\21\3\21\6\21\u013b\n\21\r\21\16\21\u013c"+
		"\3\21\3\21\3\22\3\22\3\22\3\22\3\22\5\22\u0146\n\22\3\22\3\22\6\22\u014a"+
		"\n\22\r\22\16\22\u014b\3\22\3\22\3\23\3\23\3\23\7\23\u0153\n\23\f\23\16"+
		"\23\u0156\13\23\3\23\5\23\u0159\n\23\3\23\6\23\u015c\n\23\r\23\16\23\u015d"+
		"\3\23\3\23\3\24\3\24\5\24\u0164\n\24\3\25\3\25\5\25\u0168\n\25\3\26\3"+
		"\26\6\26\u016c\n\26\r\26\16\26\u016d\3\26\3\26\3\26\3\26\6\26\u0174\n"+
		"\26\r\26\16\26\u0175\5\26\u0178\n\26\3\26\3\26\7\26\u017c\n\26\f\26\16"+
		"\26\u017f\13\26\3\27\3\27\3\27\7\27\u0184\n\27\f\27\16\27\u0187\13\27"+
		"\3\27\3\27\7\27\u018b\n\27\f\27\16\27\u018e\13\27\3\27\3\27\5\27\u0192"+
		"\n\27\3\30\3\30\3\31\3\31\6\31\u0198\n\31\r\31\16\31\u0199\3\31\7\31\u019d"+
		"\n\31\f\31\16\31\u01a0\13\31\3\32\3\32\3\32\7\32\u01a5\n\32\f\32\16\32"+
		"\u01a8\13\32\3\33\3\33\3\33\3\33\3\33\3\33\5\33\u01b0\n\33\3\33\3\33\5"+
		"\33\u01b4\n\33\5\33\u01b6\n\33\3\34\3\34\5\34\u01ba\n\34\3\35\3\35\5\35"+
		"\u01be\n\35\3\36\3\36\3\37\3\37\3 \3 \3 \3 \7 \u01c8\n \f \16 \u01cb\13"+
		" \3 \3 \3!\3!\3!\5!\u01d2\n!\3!\3!\3!\5!\u01d7\n!\3!\5!\u01da\n!\5!\u01dc"+
		"\n!\3\"\3\"\3#\3#\3$\3$\3$\3$\3$\3$\3$\5$\u01e9\n$\3%\3%\3%\6%\u01ee\n"+
		"%\r%\16%\u01ef\3&\3&\3&\3&\3&\3&\5&\u01f8\n&\3\'\3\'\3\'\3\'\3\'\5\'\u01ff"+
		"\n\'\3\'\3\'\3(\3(\3(\5(\u0206\n(\3(\3(\3)\3)\3)\3)\3*\3*\3*\3*\7*\u0212"+
		"\n*\f*\16*\u0215\13*\3*\3*\3+\3+\3+\6+\u021c\n+\r+\16+\u021d\3,\3,\3,"+
		"\3,\3,\5,\u0225\n,\3-\3-\3-\3-\3-\3-\3-\3-\5-\u022f\n-\3.\3.\3.\3.\5."+
		"\u0235\n.\3/\3/\3/\3\60\3\60\3\60\3\61\3\61\5\61\u023f\n\61\3\61\3\61"+
		"\7\61\u0243\n\61\f\61\16\61\u0246\13\61\3\61\3\61\3\62\3\62\3\62\3\62"+
		"\3\62\5\62\u024f\n\62\3\63\3\63\3\63\3\64\3\64\3\64\3\65\3\65\3\65\3\66"+
		"\3\66\3\67\3\67\38\38\39\39\3:\3:\5:\u0264\n:\3:\3:\7:\u0268\n:\f:\16"+
		":\u026b\13:\3:\3:\3;\3;\5;\u0271\n;\3<\3<\3<\3=\3=\3>\3>\3?\3?\5?\u027c"+
		"\n?\3?\2\2@\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\66"+
		"8:<>@BDFHJLNPRTVXZ\\^`bdfhjlnprtvxz|\2\b\3\2\36\37\3\2%&\3\2*+\4\2\r\r"+
		"\22\23\4\2\22\22\24\24\3\2+-\2\u02a8\2\u009a\3\2\2\2\4\u00a5\3\2\2\2\6"+
		"\u00a7\3\2\2\2\b\u00b8\3\2\2\2\n\u00ba\3\2\2\2\f\u00db\3\2\2\2\16\u00df"+
		"\3\2\2\2\20\u00e2\3\2\2\2\22\u00f6\3\2\2\2\24\u00f8\3\2\2\2\26\u0106\3"+
		"\2\2\2\30\u0108\3\2\2\2\32\u011c\3\2\2\2\34\u0124\3\2\2\2\36\u0126\3\2"+
		"\2\2 \u0133\3\2\2\2\"\u0140\3\2\2\2$\u014f\3\2\2\2&\u0163\3\2\2\2(\u0167"+
		"\3\2\2\2*\u0169\3\2\2\2,\u0191\3\2\2\2.\u0193\3\2\2\2\60\u0195\3\2\2\2"+
		"\62\u01a1\3\2\2\2\64\u01b5\3\2\2\2\66\u01b9\3\2\2\28\u01bd\3\2\2\2:\u01bf"+
		"\3\2\2\2<\u01c1\3\2\2\2>\u01c3\3\2\2\2@\u01db\3\2\2\2B\u01dd\3\2\2\2D"+
		"\u01df\3\2\2\2F\u01e8\3\2\2\2H\u01ea\3\2\2\2J\u01f7\3\2\2\2L\u01fe\3\2"+
		"\2\2N\u0205\3\2\2\2P\u0209\3\2\2\2R\u020d\3\2\2\2T\u0218\3\2\2\2V\u0224"+
		"\3\2\2\2X\u022e\3\2\2\2Z\u0230\3\2\2\2\\\u0236\3\2\2\2^\u0239\3\2\2\2"+
		"`\u023c\3\2\2\2b\u024e\3\2\2\2d\u0250\3\2\2\2f\u0253\3\2\2\2h\u0256\3"+
		"\2\2\2j\u0259\3\2\2\2l\u025b\3\2\2\2n\u025d\3\2\2\2p\u025f\3\2\2\2r\u0261"+
		"\3\2\2\2t\u0270\3\2\2\2v\u0272\3\2\2\2x\u0275\3\2\2\2z\u0277\3\2\2\2|"+
		"\u0279\3\2\2\2~\u009b\7\n\2\2\177\u0081\7\t\2\2\u0080\177\3\2\2\2\u0081"+
		"\u0084\3\2\2\2\u0082\u0080\3\2\2\2\u0082\u0083\3\2\2\2\u0083\u0086\3\2"+
		"\2\2\u0084\u0082\3\2\2\2\u0085\u0087\5\4\3\2\u0086\u0085\3\2\2\2\u0086"+
		"\u0087\3\2\2\2\u0087\u0090\3\2\2\2\u0088\u008a\7\t\2\2\u0089\u0088\3\2"+
		"\2\2\u008a\u008b\3\2\2\2\u008b\u0089\3\2\2\2\u008b\u008c\3\2\2\2\u008c"+
		"\u008d\3\2\2\2\u008d\u008f\5\4\3\2\u008e\u0089\3\2\2\2\u008f\u0092\3\2"+
		"\2\2\u0090\u008e\3\2\2\2\u0090\u0091\3\2\2\2\u0091\u0096\3\2\2\2\u0092"+
		"\u0090\3\2\2\2\u0093\u0095\7\t\2\2\u0094\u0093\3\2\2\2\u0095\u0098\3\2"+
		"\2\2\u0096\u0094\3\2\2\2\u0096\u0097\3\2\2\2\u0097\u0099\3\2\2\2\u0098"+
		"\u0096\3\2\2\2\u0099\u009b\7\2\2\3\u009a~\3\2\2\2\u009a\u0082\3\2\2\2"+
		"\u009b\3\3\2\2\2\u009c\u00a6\5\n\6\2\u009d\u00a6\5\20\t\2\u009e\u00a6"+
		"\5\24\13\2\u009f\u00a6\5\6\4\2\u00a0\u00a6\5\30\r\2\u00a1\u00a6\5\36\20"+
		"\2\u00a2\u00a6\5$\23\2\u00a3\u00a6\5\"\22\2\u00a4\u00a6\5 \21\2\u00a5"+
		"\u009c\3\2\2\2\u00a5\u009d\3\2\2\2\u00a5\u009e\3\2\2\2\u00a5\u009f\3\2"+
		"\2\2\u00a5\u00a0\3\2\2\2\u00a5\u00a1\3\2\2\2\u00a5\u00a2\3\2\2\2\u00a5"+
		"\u00a3\3\2\2\2\u00a5\u00a4\3\2\2\2\u00a6\5\3\2\2\2\u00a7\u00a8\7\33\2"+
		"\2\u00a8\u00a9\7\n\2\2\u00a9\u00aa\5z>\2\u00aa\u00ab\7\n\2\2\u00ab\u00ac"+
		"\7\20\2\2\u00ac\u00b1\5\b\5\2\u00ad\u00ae\7\4\2\2\u00ae\u00b0\5\b\5\2"+
		"\u00af\u00ad\3\2\2\2\u00b0\u00b3\3\2\2\2\u00b1\u00af\3\2\2\2\u00b1\u00b2"+
		"\3\2\2\2\u00b2\u00b4\3\2\2\2\u00b3\u00b1\3\2\2\2\u00b4\u00b5\7\21\2\2"+
		"\u00b5\7\3\2\2\2\u00b6\u00b9\5\\/\2\u00b7\u00b9\5|?\2\u00b8\u00b6\3\2"+
		"\2\2\u00b8\u00b7\3\2\2\2\u00b9\t\3\2\2\2\u00ba\u00bb\7\34\2\2\u00bb\u00d8"+
		"\7\n\2\2\u00bc\u00c1\5\f\7\2\u00bd\u00be\7\4\2\2\u00be\u00c0\5\f\7\2\u00bf"+
		"\u00bd\3\2\2\2\u00c0\u00c3\3\2\2\2\u00c1\u00bf\3\2\2\2\u00c1\u00c2\3\2"+
		"\2\2\u00c2\u00d9\3\2\2\2\u00c3\u00c1\3\2\2\2\u00c4\u00c6\5z>\2\u00c5\u00c7"+
		"\7\n\2\2\u00c6\u00c5\3\2\2\2\u00c6\u00c7\3\2\2\2\u00c7\u00c8\3\2\2\2\u00c8"+
		"\u00cc\7\13\2\2\u00c9\u00ca\5\16\b\2\u00ca\u00cb\7\4\2\2\u00cb\u00cd\3"+
		"\2\2\2\u00cc\u00c9\3\2\2\2\u00cc\u00cd\3\2\2\2\u00cd\u00ce\3\2\2\2\u00ce"+
		"\u00d3\5x=\2\u00cf\u00d0\7\4\2\2\u00d0\u00d2\5x=\2\u00d1\u00cf\3\2\2\2"+
		"\u00d2\u00d5\3\2\2\2\u00d3\u00d1\3\2\2\2\u00d3\u00d4\3\2\2\2\u00d4\u00d6"+
		"\3\2\2\2\u00d5\u00d3\3\2\2\2\u00d6\u00d7\7\f\2\2\u00d7\u00d9\3\2\2\2\u00d8"+
		"\u00bc\3\2\2\2\u00d8\u00c4\3\2\2\2\u00d9\13\3\2\2\2\u00da\u00dc\7\22\2"+
		"\2\u00db\u00da\3\2\2\2\u00db\u00dc\3\2\2\2\u00dc\u00dd\3\2\2\2\u00dd\u00de"+
		"\5z>\2\u00de\r\3\2\2\2\u00df\u00e0\7\r\2\2\u00e0\u00e1\5x=\2\u00e1\17"+
		"\3\2\2\2\u00e2\u00e3\7\35\2\2\u00e3\u00e4\7\n\2\2\u00e4\u00e5\5|?\2\u00e5"+
		"\u00eb\7\n\2\2\u00e6\u00e7\5\22\n\2\u00e7\u00e8\7\n\2\2\u00e8\u00ea\3"+
		"\2\2\2\u00e9\u00e6\3\2\2\2\u00ea\u00ed\3\2\2\2\u00eb\u00e9\3\2\2\2\u00eb"+
		"\u00ec\3\2\2\2\u00ec\u00ee\3\2\2\2\u00ed\u00eb\3\2\2\2\u00ee\u00f3\5r"+
		":\2\u00ef\u00f0\7\n\2\2\u00f0\u00f2\5\22\n\2\u00f1\u00ef\3\2\2\2\u00f2"+
		"\u00f5\3\2\2\2\u00f3\u00f1\3\2\2\2\u00f3\u00f4\3\2\2\2\u00f4\21\3\2\2"+
		"\2\u00f5\u00f3\3\2\2\2\u00f6\u00f7\t\2\2\2\u00f7\23\3\2\2\2\u00f8\u00f9"+
		"\7 \2\2\u00f9\u00fa\7\n\2\2\u00fa\u0104\5\26\f\2\u00fb\u00fc\7\4\2\2\u00fc"+
		"\u00fe\5\26\f\2\u00fd\u00fb\3\2\2\2\u00fe\u0101\3\2\2\2\u00ff\u00fd\3"+
		"\2\2\2\u00ff\u0100\3\2\2\2\u0100\u0105\3\2\2\2\u0101\u00ff\3\2\2\2\u0102"+
		"\u0103\7\n\2\2\u0103\u0105\5r:\2\u0104\u00ff\3\2\2\2\u0104\u0102\3\2\2"+
		"\2\u0105\25\3\2\2\2\u0106\u0107\5|?\2\u0107\27\3\2\2\2\u0108\u0109\7!"+
		"\2\2\u0109\u011a\7\25\2\2\u010a\u010c\7\t\2\2\u010b\u010a\3\2\2\2\u010c"+
		"\u010d\3\2\2\2\u010d\u010b\3\2\2\2\u010d\u010e\3\2\2\2\u010e\u010f\3\2"+
		"\2\2\u010f\u011b\7\"\2\2\u0110\u0112\7\t\2\2\u0111\u0110\3\2\2\2\u0112"+
		"\u0113\3\2\2\2\u0113\u0111\3\2\2\2\u0113\u0114\3\2\2\2\u0114\u0115\3\2"+
		"\2\2\u0115\u0117\5\32\16\2\u0116\u0111\3\2\2\2\u0117\u0118\3\2\2\2\u0118"+
		"\u0116\3\2\2\2\u0118\u0119\3\2\2\2\u0119\u011b\3\2\2\2\u011a\u010b\3\2"+
		"\2\2\u011a\u0116\3\2\2\2\u011b\31\3\2\2\2\u011c\u0121\5\34\17\2\u011d"+
		"\u011e\7\n\2\2\u011e\u0120\5\34\17\2\u011f\u011d\3\2\2\2\u0120\u0123\3"+
		"\2\2\2\u0121\u011f\3\2\2\2\u0121\u0122\3\2\2\2\u0122\33\3\2\2\2\u0123"+
		"\u0121\3\2\2\2\u0124\u0125\5\\/\2\u0125\35\3\2\2\2\u0126\u0129\7#\2\2"+
		"\u0127\u0128\7\n\2\2\u0128\u012a\7(\2\2\u0129\u0127\3\2\2\2\u0129\u012a"+
		"\3\2\2\2\u012a\u012b\3\2\2\2\u012b\u012d\7\25\2\2\u012c\u012e\7\t\2\2"+
		"\u012d\u012c\3\2\2\2\u012e\u012f\3\2\2\2\u012f\u012d\3\2\2\2\u012f\u0130"+
		"\3\2\2\2\u0130\u0131\3\2\2\2\u0131\u0132\5*\26\2\u0132\37\3\2\2\2\u0133"+
		"\u0136\7$\2\2\u0134\u0135\7\n\2\2\u0135\u0137\7(\2\2\u0136\u0134\3\2\2"+
		"\2\u0136\u0137\3\2\2\2\u0137\u0138\3\2\2\2\u0138\u013a\7\25\2\2\u0139"+
		"\u013b\7\t\2\2\u013a\u0139\3\2\2\2\u013b\u013c\3\2\2\2\u013c\u013a\3\2"+
		"\2\2\u013c\u013d\3\2\2\2\u013d\u013e\3\2\2\2\u013e\u013f\5*\26\2\u013f"+
		"!\3\2\2\2\u0140\u0141\7$\2\2\u0141\u0142\7\24\2\2\u0142\u0145\5\62\32"+
		"\2\u0143\u0144\7\n\2\2\u0144\u0146\7(\2\2\u0145\u0143\3\2\2\2\u0145\u0146"+
		"\3\2\2\2\u0146\u0147\3\2\2\2\u0147\u0149\7\25\2\2\u0148\u014a\7\t\2\2"+
		"\u0149\u0148\3\2\2\2\u014a\u014b\3\2\2\2\u014b\u0149\3\2\2\2\u014b\u014c"+
		"\3\2\2\2\u014c\u014d\3\2\2\2\u014d\u014e\5*\26\2\u014e#\3\2\2\2\u014f"+
		"\u0154\5\62\32\2\u0150\u0151\7\n\2\2\u0151\u0153\5&\24\2\u0152\u0150\3"+
		"\2\2\2\u0153\u0156\3\2\2\2\u0154\u0152\3\2\2\2\u0154\u0155\3\2\2\2\u0155"+
		"\u0158\3\2\2\2\u0156\u0154\3\2\2\2\u0157\u0159\7\25\2\2\u0158\u0157\3"+
		"\2\2\2\u0158\u0159\3\2\2\2\u0159\u015b\3\2\2\2\u015a\u015c\7\t\2\2\u015b"+
		"\u015a\3\2\2\2\u015c\u015d\3\2\2\2\u015d\u015b\3\2\2\2\u015d\u015e\3\2"+
		"\2\2\u015e\u015f\3\2\2\2\u015f\u0160\5*\26\2\u0160%\3\2\2\2\u0161\u0164"+
		"\5(\25\2\u0162\u0164\7\'\2\2\u0163\u0161\3\2\2\2\u0163\u0162\3\2\2\2\u0164"+
		"\'\3\2\2\2\u0165\u0168\5\\/\2\u0166\u0168\5`\61\2\u0167\u0165\3\2\2\2"+
		"\u0167\u0166\3\2\2\2\u0168)\3\2\2\2\u0169\u017d\5,\27\2\u016a\u016c\7"+
		"\t\2\2\u016b\u016a\3\2\2\2\u016c\u016d\3\2\2\2\u016d\u016b\3\2\2\2\u016d"+
		"\u016e\3\2\2\2\u016e\u016f\3\2\2\2\u016f\u0170\5.\30\2\u0170\u0177\7\25"+
		"\2\2\u0171\u0178\7\n\2\2\u0172\u0174\7\t\2\2\u0173\u0172\3\2\2\2\u0174"+
		"\u0175\3\2\2\2\u0175\u0173\3\2\2\2\u0175\u0176\3\2\2\2\u0176\u0178\3\2"+
		"\2\2\u0177\u0171\3\2\2\2\u0177\u0173\3\2\2\2\u0178\u0179\3\2\2\2\u0179"+
		"\u017a\5,\27\2\u017a\u017c\3\2\2\2\u017b\u016b\3\2\2\2\u017c\u017f\3\2"+
		"\2\2\u017d\u017b\3\2\2\2\u017d\u017e\3\2\2\2\u017e+\3\2\2\2\u017f\u017d"+
		"\3\2\2\2\u0180\u0192\5\60\31\2\u0181\u0185\7\13\2\2\u0182\u0184\7\t\2"+
		"\2\u0183\u0182\3\2\2\2\u0184\u0187\3\2\2\2\u0185\u0183\3\2\2\2\u0185\u0186"+
		"\3\2\2\2\u0186\u0188\3\2\2\2\u0187\u0185\3\2\2\2\u0188\u018c\5*\26\2\u0189"+
		"\u018b\7\t\2\2\u018a\u0189\3\2\2\2\u018b\u018e\3\2\2\2\u018c\u018a\3\2"+
		"\2\2\u018c\u018d\3\2\2\2\u018d\u018f\3\2\2\2\u018e\u018c\3\2\2\2\u018f"+
		"\u0190\7\f\2\2\u0190\u0192\3\2\2\2\u0191\u0180\3\2\2\2\u0191\u0181\3\2"+
		"\2\2\u0192-\3\2\2\2\u0193\u0194\t\3\2\2\u0194/\3\2\2\2\u0195\u019e\5\64"+
		"\33\2\u0196\u0198\7\t\2\2\u0197\u0196\3\2\2\2\u0198\u0199\3\2\2\2\u0199"+
		"\u0197\3\2\2\2\u0199\u019a\3\2\2\2\u019a\u019b\3\2\2\2\u019b\u019d\5\64"+
		"\33\2\u019c\u0197\3\2\2\2\u019d\u01a0\3\2\2\2\u019e\u019c\3\2\2\2\u019e"+
		"\u019f\3\2\2\2\u019f\61\3\2\2\2\u01a0\u019e\3\2\2\2\u01a1\u01a6\7+\2\2"+
		"\u01a2\u01a3\7\24\2\2\u01a3\u01a5\t\4\2\2\u01a4\u01a2\3\2\2\2\u01a5\u01a8"+
		"\3\2\2\2\u01a6\u01a4\3\2\2\2\u01a6\u01a7\3\2\2\2\u01a7\63\3\2\2\2\u01a8"+
		"\u01a6\3\2\2\2\u01a9\u01b6\7)\2\2\u01aa\u01ab\5:\36\2\u01ab\u01ac\7\5"+
		"\2\2\u01ac\u01af\5<\37\2\u01ad\u01ae\7\6\2\2\u01ae\u01b0\5\66\34\2\u01af"+
		"\u01ad\3\2\2\2\u01af\u01b0\3\2\2\2\u01b0\u01b3\3\2\2\2\u01b1\u01b2\7\7"+
		"\2\2\u01b2\u01b4\58\35\2\u01b3\u01b1\3\2\2\2\u01b3\u01b4\3\2\2\2\u01b4"+
		"\u01b6\3\2\2\2\u01b5\u01a9\3\2\2\2\u01b5\u01aa\3\2\2\2\u01b6\65\3\2\2"+
		"\2\u01b7\u01ba\5@!\2\u01b8\u01ba\5> \2\u01b9\u01b7\3\2\2\2\u01b9\u01b8"+
		"\3\2\2\2\u01ba\67\3\2\2\2\u01bb\u01be\5@!\2\u01bc\u01be\5> \2\u01bd\u01bb"+
		"\3\2\2\2\u01bd\u01bc\3\2\2\2\u01be9\3\2\2\2\u01bf\u01c0\5F$\2\u01c0;\3"+
		"\2\2\2\u01c1\u01c2\5F$\2\u01c2=\3\2\2\2\u01c3\u01c4\7\20\2\2\u01c4\u01c9"+
		"\5@!\2\u01c5\u01c6\7\4\2\2\u01c6\u01c8\5@!\2\u01c7\u01c5\3\2\2\2\u01c8"+
		"\u01cb\3\2\2\2\u01c9\u01c7\3\2\2\2\u01c9\u01ca\3\2\2\2\u01ca\u01cc\3\2"+
		"\2\2\u01cb\u01c9\3\2\2\2\u01cc\u01cd\7\21\2\2\u01cd?\3\2\2\2\u01ce\u01cf"+
		"\5B\"\2\u01cf\u01d0\7\n\2\2\u01d0\u01d2\3\2\2\2\u01d1\u01ce\3\2\2\2\u01d1"+
		"\u01d2\3\2\2\2\u01d2\u01d3\3\2\2\2\u01d3\u01d6\7\b\2\2\u01d4\u01d5\7\n"+
		"\2\2\u01d5\u01d7\5D#\2\u01d6\u01d4\3\2\2\2\u01d6\u01d7\3\2\2\2\u01d7\u01dc"+
		"\3\2\2\2\u01d8\u01da\5B\"\2\u01d9\u01d8\3\2\2\2\u01d9\u01da\3\2\2\2\u01da"+
		"\u01dc\3\2\2\2\u01db\u01d1\3\2\2\2\u01db\u01d9\3\2\2\2\u01dcA\3\2\2\2"+
		"\u01dd\u01de\5F$\2\u01deC\3\2\2\2\u01df\u01e0\5F$\2\u01e0E\3\2\2\2\u01e1"+
		"\u01e9\5L\'\2\u01e2\u01e9\5N(\2\u01e3\u01e9\5P)\2\u01e4\u01e9\5R*\2\u01e5"+
		"\u01e9\5T+\2\u01e6\u01e9\5X-\2\u01e7\u01e9\5H%\2\u01e8\u01e1\3\2\2\2\u01e8"+
		"\u01e2\3\2\2\2\u01e8\u01e3\3\2\2\2\u01e8\u01e4\3\2\2\2\u01e8\u01e5\3\2"+
		"\2\2\u01e8\u01e6\3\2\2\2\u01e8\u01e7\3\2\2\2\u01e9G\3\2\2\2\u01ea\u01ed"+
		"\5J&\2\u01eb\u01ec\7\n\2\2\u01ec\u01ee\5J&\2\u01ed\u01eb\3\2\2\2\u01ee"+
		"\u01ef\3\2\2\2\u01ef\u01ed\3\2\2\2\u01ef\u01f0\3\2\2\2\u01f0I\3\2\2\2"+
		"\u01f1\u01f8\5L\'\2\u01f2\u01f8\5N(\2\u01f3\u01f8\5P)\2\u01f4\u01f8\5"+
		"R*\2\u01f5\u01f8\5T+\2\u01f6\u01f8\5X-\2\u01f7\u01f1\3\2\2\2\u01f7\u01f2"+
		"\3\2\2\2\u01f7\u01f3\3\2\2\2\u01f7\u01f4\3\2\2\2\u01f7\u01f5\3\2\2\2\u01f7"+
		"\u01f6\3\2\2\2\u01f8K\3\2\2\2\u01f9\u01ff\5P)\2\u01fa\u01ff\5R*\2\u01fb"+
		"\u01ff\5Z.\2\u01fc\u01ff\5\\/\2\u01fd\u01ff\5`\61\2\u01fe\u01f9\3\2\2"+
		"\2\u01fe\u01fa\3\2\2\2\u01fe\u01fb\3\2\2\2\u01fe\u01fc\3\2\2\2\u01fe\u01fd"+
		"\3\2\2\2\u01ff\u0200\3\2\2\2\u0200\u0201\5^\60\2\u0201M\3\2\2\2\u0202"+
		"\u0206\5P)\2\u0203\u0206\5R*\2\u0204\u0206\5X-\2\u0205\u0202\3\2\2\2\u0205"+
		"\u0203\3\2\2\2\u0205\u0204\3\2\2\2\u0206\u0207\3\2\2\2\u0207\u0208\5p"+
		"9\2\u0208O\3\2\2\2\u0209\u020a\7\13\2\2\u020a\u020b\5F$\2\u020b\u020c"+
		"\7\f\2\2\u020cQ\3\2\2\2\u020d\u020e\7\20\2\2\u020e\u0213\5F$\2\u020f\u0210"+
		"\7\4\2\2\u0210\u0212\5F$\2\u0211\u020f\3\2\2\2\u0212\u0215\3\2\2\2\u0213"+
		"\u0211\3\2\2\2\u0213\u0214\3\2\2\2\u0214\u0216\3\2\2\2\u0215\u0213\3\2"+
		"\2\2\u0216\u0217\7\21\2\2\u0217S\3\2\2\2\u0218\u021b\5V,\2\u0219\u021a"+
		"\7\32\2\2\u021a\u021c\5V,\2\u021b\u0219\3\2\2\2\u021c\u021d\3\2\2\2\u021d"+
		"\u021b\3\2\2\2\u021d\u021e\3\2\2\2\u021eU\3\2\2\2\u021f\u0225\5L\'\2\u0220"+
		"\u0225\5N(\2\u0221\u0225\5P)\2\u0222\u0225\5R*\2\u0223\u0225\5X-\2\u0224"+
		"\u021f\3\2\2\2\u0224\u0220\3\2\2\2\u0224\u0221\3\2\2\2\u0224\u0222\3\2"+
		"\2\2\u0224\u0223\3\2\2\2\u0225W\3\2\2\2\u0226\u022f\5Z.\2\u0227\u022f"+
		"\5\\/\2\u0228\u022f\5^\60\2\u0229\u022f\5`\61\2\u022a\u022f\5j\66\2\u022b"+
		"\u022f\5l\67\2\u022c\u022f\5n8\2\u022d\u022f\5|?\2\u022e\u0226\3\2\2\2"+
		"\u022e\u0227\3\2\2\2\u022e\u0228\3\2\2\2\u022e\u0229\3\2\2\2\u022e\u022a"+
		"\3\2\2\2\u022e\u022b\3\2\2\2\u022e\u022c\3\2\2\2\u022e\u022d\3\2\2\2\u022f"+
		"Y\3\2\2\2\u0230\u0234\7\26\2\2\u0231\u0235\5\\/\2\u0232\u0235\5^\60\2"+
		"\u0233\u0235\5|?\2\u0234\u0231\3\2\2\2\u0234\u0232\3\2\2\2\u0234\u0233"+
		"\3\2\2\2\u0235[\3\2\2\2\u0236\u0237\7\31\2\2\u0237\u0238\5z>\2\u0238]"+
		"\3\2\2\2\u0239\u023a\7\27\2\2\u023a\u023b\7*\2\2\u023b_\3\2\2\2\u023c"+
		"\u023e\7\16\2\2\u023d\u023f\5b\62\2\u023e\u023d\3\2\2\2\u023e\u023f\3"+
		"\2\2\2\u023f\u0244\3\2\2\2\u0240\u0241\7\n\2\2\u0241\u0243\5b\62\2\u0242"+
		"\u0240\3\2\2\2\u0243\u0246\3\2\2\2\u0244\u0242\3\2\2\2\u0244\u0245\3\2"+
		"\2\2\u0245\u0247\3\2\2\2\u0246\u0244\3\2\2\2\u0247\u0248\7\17\2\2\u0248"+
		"a\3\2\2\2\u0249\u024f\5v<\2\u024a\u024f\5x=\2\u024b\u024f\5d\63\2\u024c"+
		"\u024f\5f\64\2\u024d\u024f\5h\65\2\u024e\u0249\3\2\2\2\u024e\u024a\3\2"+
		"\2\2\u024e\u024b\3\2\2\2\u024e\u024c\3\2\2\2\u024e\u024d\3\2\2\2\u024f"+
		"c\3\2\2\2\u0250\u0251\7\26\2\2\u0251\u0252\5z>\2\u0252e\3\2\2\2\u0253"+
		"\u0254\7\r\2\2\u0254\u0255\5z>\2\u0255g\3\2\2\2\u0256\u0257\7\27\2\2\u0257"+
		"\u0258\5z>\2\u0258i\3\2\2\2\u0259\u025a\7\r\2\2\u025ak\3\2\2\2\u025b\u025c"+
		"\7\27\2\2\u025cm\3\2\2\2\u025d\u025e\7\30\2\2\u025eo\3\2\2\2\u025f\u0260"+
		"\t\5\2\2\u0260q\3\2\2\2\u0261\u0263\7\16\2\2\u0262\u0264\5t;\2\u0263\u0262"+
		"\3\2\2\2\u0263\u0264\3\2\2\2\u0264\u0269\3\2\2\2\u0265\u0266\7\n\2\2\u0266"+
		"\u0268\5t;\2\u0267\u0265\3\2\2\2\u0268\u026b\3\2\2\2\u0269\u0267\3\2\2"+
		"\2\u0269\u026a\3\2\2\2\u026a\u026c\3\2\2\2\u026b\u0269\3\2\2\2\u026c\u026d"+
		"\7\17\2\2\u026ds\3\2\2\2\u026e\u0271\5v<\2\u026f\u0271\5x=\2\u0270\u026e"+
		"\3\2\2\2\u0270\u026f\3\2\2\2\u0271u\3\2\2\2\u0272\u0273\t\6\2\2\u0273"+
		"\u0274\5z>\2\u0274w\3\2\2\2\u0275\u0276\5z>\2\u0276y\3\2\2\2\u0277\u0278"+
		"\7+\2\2\u0278{\3\2\2\2\u0279\u027b\t\7\2\2\u027a\u027c\7\26\2\2\u027b"+
		"\u027a\3\2\2\2\u027b\u027c\3\2\2\2\u027c}\3\2\2\2J\u0082\u0086\u008b\u0090"+
		"\u0096\u009a\u00a5\u00b1\u00b8\u00c1\u00c6\u00cc\u00d3\u00d8\u00db\u00eb"+
		"\u00f3\u00ff\u0104\u010d\u0113\u0118\u011a\u0121\u0129\u012f\u0136\u013c"+
		"\u0145\u014b\u0154\u0158\u015d\u0163\u0167\u016d\u0175\u0177\u017d\u0185"+
		"\u018c\u0191\u0199\u019e\u01a6\u01af\u01b3\u01b5\u01b9\u01bd\u01c9\u01d1"+
		"\u01d6\u01d9\u01db\u01e8\u01ef\u01f7\u01fe\u0205\u0213\u021d\u0224\u022e"+
		"\u0234\u023e\u0244\u024e\u0263\u0269\u0270\u027b";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}