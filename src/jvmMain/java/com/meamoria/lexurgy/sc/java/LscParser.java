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
		ROMANIZER=30, SUBRULE=31, PROPAGATE=32, LITERAL=33, UNCHANGED=34, FEATURE=35, 
		VALUE=36, NUMBER=37, STR1=38, STR=39;
	public static final int
		RULE_lscFile = 0, RULE_statement = 1, RULE_classDecl = 2, RULE_classElement = 3, 
		RULE_featureDecl = 4, RULE_nullAlias = 5, RULE_diacriticDecl = 6, RULE_symbolDecl = 7, 
		RULE_symbolName = 8, RULE_deromanizer = 9, RULE_romanizer = 10, RULE_interRomanizer = 11, 
		RULE_changeRule = 12, RULE_filter = 13, RULE_subrules = 14, RULE_subrule = 15, 
		RULE_ruleName = 16, RULE_expression = 17, RULE_condition = 18, RULE_exclusion = 19, 
		RULE_from = 20, RULE_to = 21, RULE_environmentList = 22, RULE_environment = 23, 
		RULE_environmentBefore = 24, RULE_environmentAfter = 25, RULE_ruleElement = 26, 
		RULE_sequence = 27, RULE_sequenceElement = 28, RULE_capture = 29, RULE_repeater = 30, 
		RULE_group = 31, RULE_list = 32, RULE_simple = 33, RULE_negated = 34, 
		RULE_classRef = 35, RULE_captureRef = 36, RULE_fancyMatrix = 37, RULE_fancyValue = 38, 
		RULE_negatedValue = 39, RULE_absentFeature = 40, RULE_featureVariable = 41, 
		RULE_empty = 42, RULE_boundary = 43, RULE_repeaterType = 44, RULE_matrix = 45, 
		RULE_feature = 46, RULE_value = 47, RULE_text = 48;
	private static String[] makeRuleNames() {
		return new String[] {
			"lscFile", "statement", "classDecl", "classElement", "featureDecl", "nullAlias", 
			"diacriticDecl", "symbolDecl", "symbolName", "deromanizer", "romanizer", 
			"interRomanizer", "changeRule", "filter", "subrules", "subrule", "ruleName", 
			"expression", "condition", "exclusion", "from", "to", "environmentList", 
			"environment", "environmentBefore", "environmentAfter", "ruleElement", 
			"sequence", "sequenceElement", "capture", "repeater", "group", "list", 
			"simple", "negated", "classRef", "captureRef", "fancyMatrix", "fancyValue", 
			"negatedValue", "absentFeature", "featureVariable", "empty", "boundary", 
			"repeaterType", "matrix", "feature", "value", "text"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, null, "'_'", null, null, "'('", "')'", 
			"'*'", "'['", "']'", "'{'", "'}'", "'+'", "'?'", "'-'", "':'", "'!'", 
			"'$'", "'@'"
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
			"DEROMANIZER", "ROMANIZER", "SUBRULE", "PROPAGATE", "LITERAL", "UNCHANGED", 
			"FEATURE", "VALUE", "NUMBER", "STR1", "STR"
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
			setState(126);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case WHITESPACE:
				enterOuterAlt(_localctx, 1);
				{
				setState(98);
				match(WHITESPACE);
				}
				break;
			case EOF:
			case NEWLINE:
			case CLASS_DECL:
			case FEATURE_DECL:
			case DIACRITIC:
			case SYMBOL:
			case DEROMANIZER:
			case ROMANIZER:
			case VALUE:
				enterOuterAlt(_localctx, 2);
				{
				setState(102);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(99);
						match(NEWLINE);
						}
						} 
					}
					setState(104);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
				}
				setState(106);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CLASS_DECL) | (1L << FEATURE_DECL) | (1L << DIACRITIC) | (1L << SYMBOL) | (1L << DEROMANIZER) | (1L << ROMANIZER) | (1L << VALUE))) != 0)) {
					{
					setState(105);
					statement();
					}
				}

				setState(116);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(109); 
						_errHandler.sync(this);
						_la = _input.LA(1);
						do {
							{
							{
							setState(108);
							match(NEWLINE);
							}
							}
							setState(111); 
							_errHandler.sync(this);
							_la = _input.LA(1);
						} while ( _la==NEWLINE );
						setState(113);
						statement();
						}
						} 
					}
					setState(118);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
				}
				setState(122);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NEWLINE) {
					{
					{
					setState(119);
					match(NEWLINE);
					}
					}
					setState(124);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(125);
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
			setState(136);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(128);
				featureDecl();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(129);
				diacriticDecl();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(130);
				symbolDecl();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(131);
				classDecl();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(132);
				deromanizer();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(133);
				changeRule();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(134);
				interRomanizer();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(135);
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
		enterRule(_localctx, 4, RULE_classDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(138);
			match(CLASS_DECL);
			setState(139);
			match(WHITESPACE);
			setState(140);
			value();
			setState(141);
			match(WHITESPACE);
			setState(142);
			match(LIST_START);
			setState(143);
			classElement();
			setState(148);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SEP) {
				{
				{
				setState(144);
				match(SEP);
				setState(145);
				classElement();
				}
				}
				setState(150);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(151);
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
			setState(155);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CLASSREF:
				enterOuterAlt(_localctx, 1);
				{
				setState(153);
				classRef();
				}
				break;
			case FEATURE:
			case VALUE:
			case STR1:
			case STR:
				enterOuterAlt(_localctx, 2);
				{
				setState(154);
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
		enterRule(_localctx, 8, RULE_featureDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(157);
			match(FEATURE_DECL);
			setState(158);
			match(WHITESPACE);
			setState(159);
			feature();
			setState(161);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WHITESPACE) {
				{
				setState(160);
				match(WHITESPACE);
				}
			}

			setState(163);
			match(O_PAREN);
			setState(167);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NULL) {
				{
				setState(164);
				nullAlias();
				setState(165);
				match(SEP);
				}
			}

			setState(169);
			value();
			setState(174);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SEP) {
				{
				{
				setState(170);
				match(SEP);
				setState(171);
				value();
				}
				}
				setState(176);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(177);
			match(C_PAREN);
			setState(180);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CHANGE) {
				{
				setState(178);
				match(CHANGE);
				setState(179);
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
		enterRule(_localctx, 10, RULE_nullAlias);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(182);
			match(NULL);
			setState(183);
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
		enterRule(_localctx, 12, RULE_diacriticDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(185);
			match(DIACRITIC);
			setState(186);
			match(WHITESPACE);
			setState(187);
			match(STR1);
			setState(188);
			match(WHITESPACE);
			setState(191);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DIA_BEFORE) {
				{
				setState(189);
				match(DIA_BEFORE);
				setState(190);
				match(WHITESPACE);
				}
			}

			setState(195);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DIA_FLOATING) {
				{
				setState(193);
				match(DIA_FLOATING);
				setState(194);
				match(WHITESPACE);
				}
			}

			setState(197);
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
		enterRule(_localctx, 14, RULE_symbolDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(199);
			match(SYMBOL);
			setState(200);
			match(WHITESPACE);
			setState(201);
			symbolName();
			setState(211);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case EOF:
			case SEP:
			case NEWLINE:
				{
				setState(206);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==SEP) {
					{
					{
					setState(202);
					match(SEP);
					setState(203);
					symbolName();
					}
					}
					setState(208);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case WHITESPACE:
				{
				setState(209);
				match(WHITESPACE);
				setState(210);
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
		enterRule(_localctx, 16, RULE_symbolName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(213);
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
		public SubrulesContext subrules() {
			return getRuleContext(SubrulesContext.class,0);
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
		enterRule(_localctx, 18, RULE_deromanizer);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(215);
			match(DEROMANIZER);
			setState(218);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WHITESPACE) {
				{
				setState(216);
				match(WHITESPACE);
				setState(217);
				match(LITERAL);
				}
			}

			setState(220);
			match(RULE_START);
			setState(222); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(221);
				match(NEWLINE);
				}
				}
				setState(224); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NEWLINE );
			setState(226);
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
		public SubrulesContext subrules() {
			return getRuleContext(SubrulesContext.class,0);
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
		enterRule(_localctx, 20, RULE_romanizer);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(228);
			match(ROMANIZER);
			setState(231);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WHITESPACE) {
				{
				setState(229);
				match(WHITESPACE);
				setState(230);
				match(LITERAL);
				}
			}

			setState(233);
			match(RULE_START);
			setState(235); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(234);
				match(NEWLINE);
				}
				}
				setState(237); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NEWLINE );
			setState(239);
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
		public SubrulesContext subrules() {
			return getRuleContext(SubrulesContext.class,0);
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
		enterRule(_localctx, 22, RULE_interRomanizer);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(241);
			match(ROMANIZER);
			setState(242);
			match(HYPHEN);
			setState(243);
			ruleName();
			setState(246);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WHITESPACE) {
				{
				setState(244);
				match(WHITESPACE);
				setState(245);
				match(LITERAL);
				}
			}

			setState(248);
			match(RULE_START);
			setState(250); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(249);
				match(NEWLINE);
				}
				}
				setState(252); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NEWLINE );
			setState(254);
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
		enterRule(_localctx, 24, RULE_changeRule);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(256);
			ruleName();
			setState(259);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				{
				setState(257);
				match(WHITESPACE);
				setState(258);
				filter();
				}
				break;
			}
			setState(263);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WHITESPACE) {
				{
				setState(261);
				match(WHITESPACE);
				setState(262);
				match(PROPAGATE);
				}
			}

			setState(265);
			match(RULE_START);
			setState(267); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(266);
				match(NEWLINE);
				}
				}
				setState(269); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NEWLINE );
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
		enterRule(_localctx, 26, RULE_filter);
		try {
			setState(275);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CLASSREF:
				enterOuterAlt(_localctx, 1);
				{
				setState(273);
				classRef();
				}
				break;
			case MATRIX_START:
				enterOuterAlt(_localctx, 2);
				{
				setState(274);
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
		public List<TerminalNode> NEWLINE() { return getTokens(LscParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(LscParser.NEWLINE, i);
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
		enterRule(_localctx, 28, RULE_subrules);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(277);
			subrule();
			setState(296);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,30,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
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
					match(SUBRULE);
					setState(284);
					match(RULE_START);
					setState(291);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case WHITESPACE:
						{
						setState(285);
						match(WHITESPACE);
						}
						break;
					case NEWLINE:
						{
						setState(287); 
						_errHandler.sync(this);
						_la = _input.LA(1);
						do {
							{
							{
							setState(286);
							match(NEWLINE);
							}
							}
							setState(289); 
							_errHandler.sync(this);
							_la = _input.LA(1);
						} while ( _la==NEWLINE );
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(293);
					subrule();
					}
					} 
				}
				setState(298);
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
		enterRule(_localctx, 30, RULE_subrule);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(299);
			expression();
			setState(308);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(301); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(300);
						match(NEWLINE);
						}
						}
						setState(303); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==NEWLINE );
					setState(305);
					expression();
					}
					} 
				}
				setState(310);
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
		enterRule(_localctx, 32, RULE_ruleName);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(311);
			match(VALUE);
			setState(316);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==HYPHEN) {
				{
				{
				setState(312);
				match(HYPHEN);
				setState(313);
				match(VALUE);
				}
				}
				setState(318);
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
		enterRule(_localctx, 34, RULE_expression);
		int _la;
		try {
			setState(331);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case UNCHANGED:
				enterOuterAlt(_localctx, 1);
				{
				setState(319);
				match(UNCHANGED);
				}
				break;
			case O_PAREN:
			case NULL:
			case MATRIX_START:
			case LIST_START:
			case NEGATION:
			case WORD_BOUNDARY:
			case CLASSREF:
			case FEATURE:
			case VALUE:
			case STR1:
			case STR:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(320);
				from();
				setState(321);
				match(CHANGE);
				setState(322);
				to();
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
		enterRule(_localctx, 36, RULE_condition);
		try {
			setState(335);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,37,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(333);
				environment();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(334);
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
		enterRule(_localctx, 38, RULE_exclusion);
		try {
			setState(339);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,38,_ctx) ) {
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
		enterRule(_localctx, 40, RULE_from);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(341);
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
		enterRule(_localctx, 42, RULE_to);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(343);
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
		enterRule(_localctx, 44, RULE_environmentList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(345);
			match(LIST_START);
			setState(346);
			environment();
			setState(351);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SEP) {
				{
				{
				setState(347);
				match(SEP);
				setState(348);
				environment();
				}
				}
				setState(353);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(354);
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
		enterRule(_localctx, 46, RULE_environment);
		int _la;
		try {
			setState(369);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,43,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(359);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << O_PAREN) | (1L << NULL) | (1L << MATRIX_START) | (1L << LIST_START) | (1L << NEGATION) | (1L << WORD_BOUNDARY) | (1L << CLASSREF) | (1L << FEATURE) | (1L << VALUE) | (1L << STR1) | (1L << STR))) != 0)) {
					{
					setState(356);
					environmentBefore();
					setState(357);
					match(WHITESPACE);
					}
				}

				setState(361);
				match(ANCHOR);
				setState(364);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==WHITESPACE) {
					{
					setState(362);
					match(WHITESPACE);
					setState(363);
					environmentAfter();
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(367);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << O_PAREN) | (1L << NULL) | (1L << MATRIX_START) | (1L << LIST_START) | (1L << NEGATION) | (1L << WORD_BOUNDARY) | (1L << CLASSREF) | (1L << FEATURE) | (1L << VALUE) | (1L << STR1) | (1L << STR))) != 0)) {
					{
					setState(366);
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
		enterRule(_localctx, 48, RULE_environmentBefore);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(371);
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
		enterRule(_localctx, 50, RULE_environmentAfter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(373);
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
		enterRule(_localctx, 52, RULE_ruleElement);
		try {
			setState(381);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,44,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(375);
				capture();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(376);
				repeater();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(377);
				group();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(378);
				list();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(379);
				simple();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(380);
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
		enterRule(_localctx, 54, RULE_sequence);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(383);
			sequenceElement();
			setState(386); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(384);
					match(WHITESPACE);
					setState(385);
					sequenceElement();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(388); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,45,_ctx);
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
		enterRule(_localctx, 56, RULE_sequenceElement);
		try {
			setState(395);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,46,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(390);
				capture();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(391);
				repeater();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(392);
				group();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(393);
				list();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(394);
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
		enterRule(_localctx, 58, RULE_capture);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(402);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case O_PAREN:
				{
				setState(397);
				group();
				}
				break;
			case LIST_START:
				{
				setState(398);
				list();
				}
				break;
			case NEGATION:
				{
				setState(399);
				negated();
				}
				break;
			case CLASSREF:
				{
				setState(400);
				classRef();
				}
				break;
			case MATRIX_START:
				{
				setState(401);
				fancyMatrix();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(404);
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
		enterRule(_localctx, 60, RULE_repeater);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(409);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case O_PAREN:
				{
				setState(406);
				group();
				}
				break;
			case LIST_START:
				{
				setState(407);
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
				setState(408);
				simple();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(411);
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
		enterRule(_localctx, 62, RULE_group);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(413);
			match(O_PAREN);
			setState(414);
			ruleElement();
			setState(415);
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
			setState(417);
			match(LIST_START);
			setState(418);
			ruleElement();
			setState(423);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SEP) {
				{
				{
				setState(419);
				match(SEP);
				setState(420);
				ruleElement();
				}
				}
				setState(425);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(426);
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
		public BoundaryContext boundary() {
			return getRuleContext(BoundaryContext.class,0);
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
		enterRule(_localctx, 66, RULE_simple);
		try {
			setState(435);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,50,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(428);
				negated();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(429);
				classRef();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(430);
				captureRef();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(431);
				fancyMatrix();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(432);
				empty();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(433);
				boundary();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(434);
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
		enterRule(_localctx, 68, RULE_negated);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(437);
			match(NEGATION);
			setState(438);
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
		enterRule(_localctx, 70, RULE_classRef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(440);
			match(CLASSREF);
			setState(441);
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
		enterRule(_localctx, 72, RULE_captureRef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(443);
			match(WORD_BOUNDARY);
			setState(444);
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
		enterRule(_localctx, 74, RULE_fancyMatrix);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(446);
			match(MATRIX_START);
			setState(448);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NULL) | (1L << NEGATION) | (1L << WORD_BOUNDARY) | (1L << VALUE))) != 0)) {
				{
				setState(447);
				fancyValue();
				}
			}

			setState(454);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WHITESPACE) {
				{
				{
				setState(450);
				match(WHITESPACE);
				setState(451);
				fancyValue();
				}
				}
				setState(456);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(457);
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
		enterRule(_localctx, 76, RULE_fancyValue);
		try {
			setState(463);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VALUE:
				enterOuterAlt(_localctx, 1);
				{
				setState(459);
				value();
				}
				break;
			case NEGATION:
				enterOuterAlt(_localctx, 2);
				{
				setState(460);
				negatedValue();
				}
				break;
			case NULL:
				enterOuterAlt(_localctx, 3);
				{
				setState(461);
				absentFeature();
				}
				break;
			case WORD_BOUNDARY:
				enterOuterAlt(_localctx, 4);
				{
				setState(462);
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
		enterRule(_localctx, 78, RULE_negatedValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(465);
			match(NEGATION);
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
		enterRule(_localctx, 80, RULE_absentFeature);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(468);
			match(NULL);
			setState(469);
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
		enterRule(_localctx, 82, RULE_featureVariable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(471);
			match(WORD_BOUNDARY);
			setState(472);
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
			setState(474);
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
		enterRule(_localctx, 86, RULE_boundary);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(476);
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
			setState(478);
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
			setState(480);
			match(MATRIX_START);
			setState(482);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==VALUE) {
				{
				setState(481);
				value();
				}
			}

			setState(488);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WHITESPACE) {
				{
				{
				setState(484);
				match(WHITESPACE);
				setState(485);
				value();
				}
				}
				setState(490);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(491);
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
			setState(493);
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
			setState(495);
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
			setState(497);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << FEATURE) | (1L << VALUE) | (1L << STR1) | (1L << STR))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(499);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NEGATION) {
				{
				setState(498);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3)\u01f8\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\3\2\3\2\7\2g\n\2"+
		"\f\2\16\2j\13\2\3\2\5\2m\n\2\3\2\6\2p\n\2\r\2\16\2q\3\2\7\2u\n\2\f\2\16"+
		"\2x\13\2\3\2\7\2{\n\2\f\2\16\2~\13\2\3\2\5\2\u0081\n\2\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\5\3\u008b\n\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\7\4\u0095"+
		"\n\4\f\4\16\4\u0098\13\4\3\4\3\4\3\5\3\5\5\5\u009e\n\5\3\6\3\6\3\6\3\6"+
		"\5\6\u00a4\n\6\3\6\3\6\3\6\3\6\5\6\u00aa\n\6\3\6\3\6\3\6\7\6\u00af\n\6"+
		"\f\6\16\6\u00b2\13\6\3\6\3\6\3\6\5\6\u00b7\n\6\3\7\3\7\3\7\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\5\b\u00c2\n\b\3\b\3\b\5\b\u00c6\n\b\3\b\3\b\3\t\3\t\3\t\3"+
		"\t\3\t\7\t\u00cf\n\t\f\t\16\t\u00d2\13\t\3\t\3\t\5\t\u00d6\n\t\3\n\3\n"+
		"\3\13\3\13\3\13\5\13\u00dd\n\13\3\13\3\13\6\13\u00e1\n\13\r\13\16\13\u00e2"+
		"\3\13\3\13\3\f\3\f\3\f\5\f\u00ea\n\f\3\f\3\f\6\f\u00ee\n\f\r\f\16\f\u00ef"+
		"\3\f\3\f\3\r\3\r\3\r\3\r\3\r\5\r\u00f9\n\r\3\r\3\r\6\r\u00fd\n\r\r\r\16"+
		"\r\u00fe\3\r\3\r\3\16\3\16\3\16\5\16\u0106\n\16\3\16\3\16\5\16\u010a\n"+
		"\16\3\16\3\16\6\16\u010e\n\16\r\16\16\16\u010f\3\16\3\16\3\17\3\17\5\17"+
		"\u0116\n\17\3\20\3\20\6\20\u011a\n\20\r\20\16\20\u011b\3\20\3\20\3\20"+
		"\3\20\6\20\u0122\n\20\r\20\16\20\u0123\5\20\u0126\n\20\3\20\7\20\u0129"+
		"\n\20\f\20\16\20\u012c\13\20\3\21\3\21\6\21\u0130\n\21\r\21\16\21\u0131"+
		"\3\21\7\21\u0135\n\21\f\21\16\21\u0138\13\21\3\22\3\22\3\22\7\22\u013d"+
		"\n\22\f\22\16\22\u0140\13\22\3\23\3\23\3\23\3\23\3\23\3\23\5\23\u0148"+
		"\n\23\3\23\3\23\5\23\u014c\n\23\5\23\u014e\n\23\3\24\3\24\5\24\u0152\n"+
		"\24\3\25\3\25\5\25\u0156\n\25\3\26\3\26\3\27\3\27\3\30\3\30\3\30\3\30"+
		"\7\30\u0160\n\30\f\30\16\30\u0163\13\30\3\30\3\30\3\31\3\31\3\31\5\31"+
		"\u016a\n\31\3\31\3\31\3\31\5\31\u016f\n\31\3\31\5\31\u0172\n\31\5\31\u0174"+
		"\n\31\3\32\3\32\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\34\5\34\u0180\n\34"+
		"\3\35\3\35\3\35\6\35\u0185\n\35\r\35\16\35\u0186\3\36\3\36\3\36\3\36\3"+
		"\36\5\36\u018e\n\36\3\37\3\37\3\37\3\37\3\37\5\37\u0195\n\37\3\37\3\37"+
		"\3 \3 \3 \5 \u019c\n \3 \3 \3!\3!\3!\3!\3\"\3\"\3\"\3\"\7\"\u01a8\n\""+
		"\f\"\16\"\u01ab\13\"\3\"\3\"\3#\3#\3#\3#\3#\3#\3#\5#\u01b6\n#\3$\3$\3"+
		"$\3%\3%\3%\3&\3&\3&\3\'\3\'\5\'\u01c3\n\'\3\'\3\'\7\'\u01c7\n\'\f\'\16"+
		"\'\u01ca\13\'\3\'\3\'\3(\3(\3(\3(\5(\u01d2\n(\3)\3)\3)\3*\3*\3*\3+\3+"+
		"\3+\3,\3,\3-\3-\3.\3.\3/\3/\5/\u01e5\n/\3/\3/\7/\u01e9\n/\f/\16/\u01ec"+
		"\13/\3/\3/\3\60\3\60\3\61\3\61\3\62\3\62\5\62\u01f6\n\62\3\62\2\2\63\2"+
		"\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJL"+
		"NPRTVXZ\\^`b\2\4\4\2\r\r\22\23\4\2%&()\2\u0217\2\u0080\3\2\2\2\4\u008a"+
		"\3\2\2\2\6\u008c\3\2\2\2\b\u009d\3\2\2\2\n\u009f\3\2\2\2\f\u00b8\3\2\2"+
		"\2\16\u00bb\3\2\2\2\20\u00c9\3\2\2\2\22\u00d7\3\2\2\2\24\u00d9\3\2\2\2"+
		"\26\u00e6\3\2\2\2\30\u00f3\3\2\2\2\32\u0102\3\2\2\2\34\u0115\3\2\2\2\36"+
		"\u0117\3\2\2\2 \u012d\3\2\2\2\"\u0139\3\2\2\2$\u014d\3\2\2\2&\u0151\3"+
		"\2\2\2(\u0155\3\2\2\2*\u0157\3\2\2\2,\u0159\3\2\2\2.\u015b\3\2\2\2\60"+
		"\u0173\3\2\2\2\62\u0175\3\2\2\2\64\u0177\3\2\2\2\66\u017f\3\2\2\28\u0181"+
		"\3\2\2\2:\u018d\3\2\2\2<\u0194\3\2\2\2>\u019b\3\2\2\2@\u019f\3\2\2\2B"+
		"\u01a3\3\2\2\2D\u01b5\3\2\2\2F\u01b7\3\2\2\2H\u01ba\3\2\2\2J\u01bd\3\2"+
		"\2\2L\u01c0\3\2\2\2N\u01d1\3\2\2\2P\u01d3\3\2\2\2R\u01d6\3\2\2\2T\u01d9"+
		"\3\2\2\2V\u01dc\3\2\2\2X\u01de\3\2\2\2Z\u01e0\3\2\2\2\\\u01e2\3\2\2\2"+
		"^\u01ef\3\2\2\2`\u01f1\3\2\2\2b\u01f3\3\2\2\2d\u0081\7\n\2\2eg\7\t\2\2"+
		"fe\3\2\2\2gj\3\2\2\2hf\3\2\2\2hi\3\2\2\2il\3\2\2\2jh\3\2\2\2km\5\4\3\2"+
		"lk\3\2\2\2lm\3\2\2\2mv\3\2\2\2np\7\t\2\2on\3\2\2\2pq\3\2\2\2qo\3\2\2\2"+
		"qr\3\2\2\2rs\3\2\2\2su\5\4\3\2to\3\2\2\2ux\3\2\2\2vt\3\2\2\2vw\3\2\2\2"+
		"w|\3\2\2\2xv\3\2\2\2y{\7\t\2\2zy\3\2\2\2{~\3\2\2\2|z\3\2\2\2|}\3\2\2\2"+
		"}\177\3\2\2\2~|\3\2\2\2\177\u0081\7\2\2\3\u0080d\3\2\2\2\u0080h\3\2\2"+
		"\2\u0081\3\3\2\2\2\u0082\u008b\5\n\6\2\u0083\u008b\5\16\b\2\u0084\u008b"+
		"\5\20\t\2\u0085\u008b\5\6\4\2\u0086\u008b\5\24\13\2\u0087\u008b\5\32\16"+
		"\2\u0088\u008b\5\30\r\2\u0089\u008b\5\26\f\2\u008a\u0082\3\2\2\2\u008a"+
		"\u0083\3\2\2\2\u008a\u0084\3\2\2\2\u008a\u0085\3\2\2\2\u008a\u0086\3\2"+
		"\2\2\u008a\u0087\3\2\2\2\u008a\u0088\3\2\2\2\u008a\u0089\3\2\2\2\u008b"+
		"\5\3\2\2\2\u008c\u008d\7\31\2\2\u008d\u008e\7\n\2\2\u008e\u008f\5`\61"+
		"\2\u008f\u0090\7\n\2\2\u0090\u0091\7\20\2\2\u0091\u0096\5\b\5\2\u0092"+
		"\u0093\7\4\2\2\u0093\u0095\5\b\5\2\u0094\u0092\3\2\2\2\u0095\u0098\3\2"+
		"\2\2\u0096\u0094\3\2\2\2\u0096\u0097\3\2\2\2\u0097\u0099\3\2\2\2\u0098"+
		"\u0096\3\2\2\2\u0099\u009a\7\21\2\2\u009a\7\3\2\2\2\u009b\u009e\5H%\2"+
		"\u009c\u009e\5b\62\2\u009d\u009b\3\2\2\2\u009d\u009c\3\2\2\2\u009e\t\3"+
		"\2\2\2\u009f\u00a0\7\32\2\2\u00a0\u00a1\7\n\2\2\u00a1\u00a3\5^\60\2\u00a2"+
		"\u00a4\7\n\2\2\u00a3\u00a2\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4\u00a5\3\2"+
		"\2\2\u00a5\u00a9\7\13\2\2\u00a6\u00a7\5\f\7\2\u00a7\u00a8\7\4\2\2\u00a8"+
		"\u00aa\3\2\2\2\u00a9\u00a6\3\2\2\2\u00a9\u00aa\3\2\2\2\u00aa\u00ab\3\2"+
		"\2\2\u00ab\u00b0\5`\61\2\u00ac\u00ad\7\4\2\2\u00ad\u00af\5`\61\2\u00ae"+
		"\u00ac\3\2\2\2\u00af\u00b2\3\2\2\2\u00b0\u00ae\3\2\2\2\u00b0\u00b1\3\2"+
		"\2\2\u00b1\u00b3\3\2\2\2\u00b2\u00b0\3\2\2\2\u00b3\u00b6\7\f\2\2\u00b4"+
		"\u00b5\7\5\2\2\u00b5\u00b7\5\\/\2\u00b6\u00b4\3\2\2\2\u00b6\u00b7\3\2"+
		"\2\2\u00b7\13\3\2\2\2\u00b8\u00b9\7\r\2\2\u00b9\u00ba\5`\61\2\u00ba\r"+
		"\3\2\2\2\u00bb\u00bc\7\33\2\2\u00bc\u00bd\7\n\2\2\u00bd\u00be\7(\2\2\u00be"+
		"\u00c1\7\n\2\2\u00bf\u00c0\7\34\2\2\u00c0\u00c2\7\n\2\2\u00c1\u00bf\3"+
		"\2\2\2\u00c1\u00c2\3\2\2\2\u00c2\u00c5\3\2\2\2\u00c3\u00c4\7\35\2\2\u00c4"+
		"\u00c6\7\n\2\2\u00c5\u00c3\3\2\2\2\u00c5\u00c6\3\2\2\2\u00c6\u00c7\3\2"+
		"\2\2\u00c7\u00c8\5\\/\2\u00c8\17\3\2\2\2\u00c9\u00ca\7\36\2\2\u00ca\u00cb"+
		"\7\n\2\2\u00cb\u00d5\5\22\n\2\u00cc\u00cd\7\4\2\2\u00cd\u00cf\5\22\n\2"+
		"\u00ce\u00cc\3\2\2\2\u00cf\u00d2\3\2\2\2\u00d0\u00ce\3\2\2\2\u00d0\u00d1"+
		"\3\2\2\2\u00d1\u00d6\3\2\2\2\u00d2\u00d0\3\2\2\2\u00d3\u00d4\7\n\2\2\u00d4"+
		"\u00d6\5\\/\2\u00d5\u00d0\3\2\2\2\u00d5\u00d3\3\2\2\2\u00d6\21\3\2\2\2"+
		"\u00d7\u00d8\5b\62\2\u00d8\23\3\2\2\2\u00d9\u00dc\7\37\2\2\u00da\u00db"+
		"\7\n\2\2\u00db\u00dd\7#\2\2\u00dc\u00da\3\2\2\2\u00dc\u00dd\3\2\2\2\u00dd"+
		"\u00de\3\2\2\2\u00de\u00e0\7\25\2\2\u00df\u00e1\7\t\2\2\u00e0\u00df\3"+
		"\2\2\2\u00e1\u00e2\3\2\2\2\u00e2\u00e0\3\2\2\2\u00e2\u00e3\3\2\2\2\u00e3"+
		"\u00e4\3\2\2\2\u00e4\u00e5\5\36\20\2\u00e5\25\3\2\2\2\u00e6\u00e9\7 \2"+
		"\2\u00e7\u00e8\7\n\2\2\u00e8\u00ea\7#\2\2\u00e9\u00e7\3\2\2\2\u00e9\u00ea"+
		"\3\2\2\2\u00ea\u00eb\3\2\2\2\u00eb\u00ed\7\25\2\2\u00ec\u00ee\7\t\2\2"+
		"\u00ed\u00ec\3\2\2\2\u00ee\u00ef\3\2\2\2\u00ef\u00ed\3\2\2\2\u00ef\u00f0"+
		"\3\2\2\2\u00f0\u00f1\3\2\2\2\u00f1\u00f2\5\36\20\2\u00f2\27\3\2\2\2\u00f3"+
		"\u00f4\7 \2\2\u00f4\u00f5\7\24\2\2\u00f5\u00f8\5\"\22\2\u00f6\u00f7\7"+
		"\n\2\2\u00f7\u00f9\7#\2\2\u00f8\u00f6\3\2\2\2\u00f8\u00f9\3\2\2\2\u00f9"+
		"\u00fa\3\2\2\2\u00fa\u00fc\7\25\2\2\u00fb\u00fd\7\t\2\2\u00fc\u00fb\3"+
		"\2\2\2\u00fd\u00fe\3\2\2\2\u00fe\u00fc\3\2\2\2\u00fe\u00ff\3\2\2\2\u00ff"+
		"\u0100\3\2\2\2\u0100\u0101\5\36\20\2\u0101\31\3\2\2\2\u0102\u0105\5\""+
		"\22\2\u0103\u0104\7\n\2\2\u0104\u0106\5\34\17\2\u0105\u0103\3\2\2\2\u0105"+
		"\u0106\3\2\2\2\u0106\u0109\3\2\2\2\u0107\u0108\7\n\2\2\u0108\u010a\7\""+
		"\2\2\u0109\u0107\3\2\2\2\u0109\u010a\3\2\2\2\u010a\u010b\3\2\2\2\u010b"+
		"\u010d\7\25\2\2\u010c\u010e\7\t\2\2\u010d\u010c\3\2\2\2\u010e\u010f\3"+
		"\2\2\2\u010f\u010d\3\2\2\2\u010f\u0110\3\2\2\2\u0110\u0111\3\2\2\2\u0111"+
		"\u0112\5\36\20\2\u0112\33\3\2\2\2\u0113\u0116\5H%\2\u0114\u0116\5\\/\2"+
		"\u0115\u0113\3\2\2\2\u0115\u0114\3\2\2\2\u0116\35\3\2\2\2\u0117\u012a"+
		"\5 \21\2\u0118\u011a\7\t\2\2\u0119\u0118\3\2\2\2\u011a\u011b\3\2\2\2\u011b"+
		"\u0119\3\2\2\2\u011b\u011c\3\2\2\2\u011c\u011d\3\2\2\2\u011d\u011e\7!"+
		"\2\2\u011e\u0125\7\25\2\2\u011f\u0126\7\n\2\2\u0120\u0122\7\t\2\2\u0121"+
		"\u0120\3\2\2\2\u0122\u0123\3\2\2\2\u0123\u0121\3\2\2\2\u0123\u0124\3\2"+
		"\2\2\u0124\u0126\3\2\2\2\u0125\u011f\3\2\2\2\u0125\u0121\3\2\2\2\u0126"+
		"\u0127\3\2\2\2\u0127\u0129\5 \21\2\u0128\u0119\3\2\2\2\u0129\u012c\3\2"+
		"\2\2\u012a\u0128\3\2\2\2\u012a\u012b\3\2\2\2\u012b\37\3\2\2\2\u012c\u012a"+
		"\3\2\2\2\u012d\u0136\5$\23\2\u012e\u0130\7\t\2\2\u012f\u012e\3\2\2\2\u0130"+
		"\u0131\3\2\2\2\u0131\u012f\3\2\2\2\u0131\u0132\3\2\2\2\u0132\u0133\3\2"+
		"\2\2\u0133\u0135\5$\23\2\u0134\u012f\3\2\2\2\u0135\u0138\3\2\2\2\u0136"+
		"\u0134\3\2\2\2\u0136\u0137\3\2\2\2\u0137!\3\2\2\2\u0138\u0136\3\2\2\2"+
		"\u0139\u013e\7&\2\2\u013a\u013b\7\24\2\2\u013b\u013d\7&\2\2\u013c\u013a"+
		"\3\2\2\2\u013d\u0140\3\2\2\2\u013e\u013c\3\2\2\2\u013e\u013f\3\2\2\2\u013f"+
		"#\3\2\2\2\u0140\u013e\3\2\2\2\u0141\u014e\7$\2\2\u0142\u0143\5*\26\2\u0143"+
		"\u0144\7\5\2\2\u0144\u0147\5,\27\2\u0145\u0146\7\6\2\2\u0146\u0148\5&"+
		"\24\2\u0147\u0145\3\2\2\2\u0147\u0148\3\2\2\2\u0148\u014b\3\2\2\2\u0149"+
		"\u014a\7\7\2\2\u014a\u014c\5(\25\2\u014b\u0149\3\2\2\2\u014b\u014c\3\2"+
		"\2\2\u014c\u014e\3\2\2\2\u014d\u0141\3\2\2\2\u014d\u0142\3\2\2\2\u014e"+
		"%\3\2\2\2\u014f\u0152\5\60\31\2\u0150\u0152\5.\30\2\u0151\u014f\3\2\2"+
		"\2\u0151\u0150\3\2\2\2\u0152\'\3\2\2\2\u0153\u0156\5\60\31\2\u0154\u0156"+
		"\5.\30\2\u0155\u0153\3\2\2\2\u0155\u0154\3\2\2\2\u0156)\3\2\2\2\u0157"+
		"\u0158\5\66\34\2\u0158+\3\2\2\2\u0159\u015a\5\66\34\2\u015a-\3\2\2\2\u015b"+
		"\u015c\7\20\2\2\u015c\u0161\5\60\31\2\u015d\u015e\7\4\2\2\u015e\u0160"+
		"\5\60\31\2\u015f\u015d\3\2\2\2\u0160\u0163\3\2\2\2\u0161\u015f\3\2\2\2"+
		"\u0161\u0162\3\2\2\2\u0162\u0164\3\2\2\2\u0163\u0161\3\2\2\2\u0164\u0165"+
		"\7\21\2\2\u0165/\3\2\2\2\u0166\u0167\5\62\32\2\u0167\u0168\7\n\2\2\u0168"+
		"\u016a\3\2\2\2\u0169\u0166\3\2\2\2\u0169\u016a\3\2\2\2\u016a\u016b\3\2"+
		"\2\2\u016b\u016e\7\b\2\2\u016c\u016d\7\n\2\2\u016d\u016f\5\64\33\2\u016e"+
		"\u016c\3\2\2\2\u016e\u016f\3\2\2\2\u016f\u0174\3\2\2\2\u0170\u0172\5\62"+
		"\32\2\u0171\u0170\3\2\2\2\u0171\u0172\3\2\2\2\u0172\u0174\3\2\2\2\u0173"+
		"\u0169\3\2\2\2\u0173\u0171\3\2\2\2\u0174\61\3\2\2\2\u0175\u0176\5\66\34"+
		"\2\u0176\63\3\2\2\2\u0177\u0178\5\66\34\2\u0178\65\3\2\2\2\u0179\u0180"+
		"\5<\37\2\u017a\u0180\5> \2\u017b\u0180\5@!\2\u017c\u0180\5B\"\2\u017d"+
		"\u0180\5D#\2\u017e\u0180\58\35\2\u017f\u0179\3\2\2\2\u017f\u017a\3\2\2"+
		"\2\u017f\u017b\3\2\2\2\u017f\u017c\3\2\2\2\u017f\u017d\3\2\2\2\u017f\u017e"+
		"\3\2\2\2\u0180\67\3\2\2\2\u0181\u0184\5:\36\2\u0182\u0183\7\n\2\2\u0183"+
		"\u0185\5:\36\2\u0184\u0182\3\2\2\2\u0185\u0186\3\2\2\2\u0186\u0184\3\2"+
		"\2\2\u0186\u0187\3\2\2\2\u01879\3\2\2\2\u0188\u018e\5<\37\2\u0189\u018e"+
		"\5> \2\u018a\u018e\5@!\2\u018b\u018e\5B\"\2\u018c\u018e\5D#\2\u018d\u0188"+
		"\3\2\2\2\u018d\u0189\3\2\2\2\u018d\u018a\3\2\2\2\u018d\u018b\3\2\2\2\u018d"+
		"\u018c\3\2\2\2\u018e;\3\2\2\2\u018f\u0195\5@!\2\u0190\u0195\5B\"\2\u0191"+
		"\u0195\5F$\2\u0192\u0195\5H%\2\u0193\u0195\5L\'\2\u0194\u018f\3\2\2\2"+
		"\u0194\u0190\3\2\2\2\u0194\u0191\3\2\2\2\u0194\u0192\3\2\2\2\u0194\u0193"+
		"\3\2\2\2\u0195\u0196\3\2\2\2\u0196\u0197\5J&\2\u0197=\3\2\2\2\u0198\u019c"+
		"\5@!\2\u0199\u019c\5B\"\2\u019a\u019c\5D#\2\u019b\u0198\3\2\2\2\u019b"+
		"\u0199\3\2\2\2\u019b\u019a\3\2\2\2\u019c\u019d\3\2\2\2\u019d\u019e\5Z"+
		".\2\u019e?\3\2\2\2\u019f\u01a0\7\13\2\2\u01a0\u01a1\5\66\34\2\u01a1\u01a2"+
		"\7\f\2\2\u01a2A\3\2\2\2\u01a3\u01a4\7\20\2\2\u01a4\u01a9\5\66\34\2\u01a5"+
		"\u01a6\7\4\2\2\u01a6\u01a8\5\66\34\2\u01a7\u01a5\3\2\2\2\u01a8\u01ab\3"+
		"\2\2\2\u01a9\u01a7\3\2\2\2\u01a9\u01aa\3\2\2\2\u01aa\u01ac\3\2\2\2\u01ab"+
		"\u01a9\3\2\2\2\u01ac\u01ad\7\21\2\2\u01adC\3\2\2\2\u01ae\u01b6\5F$\2\u01af"+
		"\u01b6\5H%\2\u01b0\u01b6\5J&\2\u01b1\u01b6\5L\'\2\u01b2\u01b6\5V,\2\u01b3"+
		"\u01b6\5X-\2\u01b4\u01b6\5b\62\2\u01b5\u01ae\3\2\2\2\u01b5\u01af\3\2\2"+
		"\2\u01b5\u01b0\3\2\2\2\u01b5\u01b1\3\2\2\2\u01b5\u01b2\3\2\2\2\u01b5\u01b3"+
		"\3\2\2\2\u01b5\u01b4\3\2\2\2\u01b6E\3\2\2\2\u01b7\u01b8\7\26\2\2\u01b8"+
		"\u01b9\5H%\2\u01b9G\3\2\2\2\u01ba\u01bb\7\30\2\2\u01bb\u01bc\5`\61\2\u01bc"+
		"I\3\2\2\2\u01bd\u01be\7\27\2\2\u01be\u01bf\7\'\2\2\u01bfK\3\2\2\2\u01c0"+
		"\u01c2\7\16\2\2\u01c1\u01c3\5N(\2\u01c2\u01c1\3\2\2\2\u01c2\u01c3\3\2"+
		"\2\2\u01c3\u01c8\3\2\2\2\u01c4\u01c5\7\n\2\2\u01c5\u01c7\5N(\2\u01c6\u01c4"+
		"\3\2\2\2\u01c7\u01ca\3\2\2\2\u01c8\u01c6\3\2\2\2\u01c8\u01c9\3\2\2\2\u01c9"+
		"\u01cb\3\2\2\2\u01ca\u01c8\3\2\2\2\u01cb\u01cc\7\17\2\2\u01ccM\3\2\2\2"+
		"\u01cd\u01d2\5`\61\2\u01ce\u01d2\5P)\2\u01cf\u01d2\5R*\2\u01d0\u01d2\5"+
		"T+\2\u01d1\u01cd\3\2\2\2\u01d1\u01ce\3\2\2\2\u01d1\u01cf\3\2\2\2\u01d1"+
		"\u01d0\3\2\2\2\u01d2O\3\2\2\2\u01d3\u01d4\7\26\2\2\u01d4\u01d5\5`\61\2"+
		"\u01d5Q\3\2\2\2\u01d6\u01d7\7\r\2\2\u01d7\u01d8\5^\60\2\u01d8S\3\2\2\2"+
		"\u01d9\u01da\7\27\2\2\u01da\u01db\5^\60\2\u01dbU\3\2\2\2\u01dc\u01dd\7"+
		"\r\2\2\u01ddW\3\2\2\2\u01de\u01df\7\27\2\2\u01dfY\3\2\2\2\u01e0\u01e1"+
		"\t\2\2\2\u01e1[\3\2\2\2\u01e2\u01e4\7\16\2\2\u01e3\u01e5\5`\61\2\u01e4"+
		"\u01e3\3\2\2\2\u01e4\u01e5\3\2\2\2\u01e5\u01ea\3\2\2\2\u01e6\u01e7\7\n"+
		"\2\2\u01e7\u01e9\5`\61\2\u01e8\u01e6\3\2\2\2\u01e9\u01ec\3\2\2\2\u01ea"+
		"\u01e8\3\2\2\2\u01ea\u01eb\3\2\2\2\u01eb\u01ed\3\2\2\2\u01ec\u01ea\3\2"+
		"\2\2\u01ed\u01ee\7\17\2\2\u01ee]\3\2\2\2\u01ef\u01f0\7%\2\2\u01f0_\3\2"+
		"\2\2\u01f1\u01f2\7&\2\2\u01f2a\3\2\2\2\u01f3\u01f5\t\3\2\2\u01f4\u01f6"+
		"\7\26\2\2\u01f5\u01f4\3\2\2\2\u01f5\u01f6\3\2\2\2\u01f6c\3\2\2\2;hlqv"+
		"|\u0080\u008a\u0096\u009d\u00a3\u00a9\u00b0\u00b6\u00c1\u00c5\u00d0\u00d5"+
		"\u00dc\u00e2\u00e9\u00ef\u00f8\u00fe\u0105\u0109\u010f\u0115\u011b\u0123"+
		"\u0125\u012a\u0131\u0136\u013e\u0147\u014b\u014d\u0151\u0155\u0161\u0169"+
		"\u016e\u0171\u0173\u017f\u0186\u018d\u0194\u019b\u01a9\u01b5\u01c2\u01c8"+
		"\u01d1\u01e4\u01ea\u01f5";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}