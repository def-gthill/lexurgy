// Generated from Meta.g4 by ANTLR 4.7.2
package com.meamoria.lexurgy.meta.java;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MetaLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		COMMENT=1, COMMENT_START=2, NEWLINE=3, WHITESPACE=4, GRAMMAR=5, GRAMMAR_NAME=6, 
		RULE_NAME=7, TOKEN_NAME=8, START=9, END=10, ALT_SEP=11, O_PAREN=12, C_PAREN=13, 
		AT_LEAST_ONE=14, ANY_NUMBER=15, OPTIONAL=16, END_JUNK=17;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"COMMENT", "COMMENT_START", "NEWLINE", "WHITESPACE", "GRAMMAR", "GRAMMAR_NAME", 
			"RULE_NAME", "TOKEN_NAME", "START", "END", "ALT_SEP", "O_PAREN", "C_PAREN", 
			"AT_LEAST_ONE", "ANY_NUMBER", "OPTIONAL", "END_JUNK", "UPPER", "LOWER", 
			"UPPER_OR_LOWER", "UPPER_OR_UNDER", "ANY"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, "'//'", null, null, "'grammar'", null, null, null, null, 
			"';'", null, null, null, "'+'", "'*'", "'?'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "COMMENT", "COMMENT_START", "NEWLINE", "WHITESPACE", "GRAMMAR", 
			"GRAMMAR_NAME", "RULE_NAME", "TOKEN_NAME", "START", "END", "ALT_SEP", 
			"O_PAREN", "C_PAREN", "AT_LEAST_ONE", "ANY_NUMBER", "OPTIONAL", "END_JUNK"
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


	public MetaLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Meta.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\23\u00a8\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\3\2\5\2\61\n\2"+
		"\3\2\3\2\7\2\65\n\2\f\2\16\28\13\2\3\2\3\2\3\3\3\3\3\3\3\4\5\4@\n\4\3"+
		"\4\3\4\3\4\5\4E\n\4\3\4\5\4H\n\4\3\5\6\5K\n\5\r\5\16\5L\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\7\3\7\6\7Y\n\7\r\7\16\7Z\3\b\3\b\6\b_\n\b\r\b\16"+
		"\b`\3\t\3\t\6\te\n\t\r\t\16\tf\3\n\3\n\5\nk\n\n\3\n\5\nn\n\n\3\13\3\13"+
		"\3\f\5\fs\n\f\3\f\5\fv\n\f\3\f\3\f\5\fz\n\f\3\f\5\f}\n\f\3\r\3\r\5\r\u0081"+
		"\n\r\3\16\5\16\u0084\n\16\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22"+
		"\6\22\u008f\n\22\r\22\16\22\u0090\3\22\6\22\u0094\n\22\r\22\16\22\u0095"+
		"\3\22\3\22\7\22\u009a\n\22\f\22\16\22\u009d\13\22\3\23\3\23\3\24\3\24"+
		"\3\25\3\25\3\26\3\26\3\27\3\27\2\2\30\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21"+
		"\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\2\'\2)\2+\2-\2\3\2"+
		"\7\4\2\f\f\17\17\3\2C\\\3\2c|\5\2\62;C\\c|\5\2\62;C\\aa\2\u00b6\2\3\3"+
		"\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2"+
		"\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3"+
		"\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\3"+
		"\60\3\2\2\2\5;\3\2\2\2\7?\3\2\2\2\tJ\3\2\2\2\13N\3\2\2\2\rV\3\2\2\2\17"+
		"\\\3\2\2\2\21b\3\2\2\2\23h\3\2\2\2\25o\3\2\2\2\27r\3\2\2\2\31~\3\2\2\2"+
		"\33\u0083\3\2\2\2\35\u0087\3\2\2\2\37\u0089\3\2\2\2!\u008b\3\2\2\2#\u008e"+
		"\3\2\2\2%\u009e\3\2\2\2\'\u00a0\3\2\2\2)\u00a2\3\2\2\2+\u00a4\3\2\2\2"+
		"-\u00a6\3\2\2\2/\61\5\t\5\2\60/\3\2\2\2\60\61\3\2\2\2\61\62\3\2\2\2\62"+
		"\66\5\5\3\2\63\65\n\2\2\2\64\63\3\2\2\2\658\3\2\2\2\66\64\3\2\2\2\66\67"+
		"\3\2\2\2\679\3\2\2\28\66\3\2\2\29:\b\2\2\2:\4\3\2\2\2;<\7\61\2\2<=\7\61"+
		"\2\2=\6\3\2\2\2>@\5\t\5\2?>\3\2\2\2?@\3\2\2\2@D\3\2\2\2AB\7\17\2\2BE\7"+
		"\f\2\2CE\7\f\2\2DA\3\2\2\2DC\3\2\2\2EG\3\2\2\2FH\5\t\5\2GF\3\2\2\2GH\3"+
		"\2\2\2H\b\3\2\2\2IK\7\"\2\2JI\3\2\2\2KL\3\2\2\2LJ\3\2\2\2LM\3\2\2\2M\n"+
		"\3\2\2\2NO\7i\2\2OP\7t\2\2PQ\7c\2\2QR\7o\2\2RS\7o\2\2ST\7c\2\2TU\7t\2"+
		"\2U\f\3\2\2\2VX\5%\23\2WY\5\'\24\2XW\3\2\2\2YZ\3\2\2\2ZX\3\2\2\2Z[\3\2"+
		"\2\2[\16\3\2\2\2\\^\5\'\24\2]_\5)\25\2^]\3\2\2\2_`\3\2\2\2`^\3\2\2\2`"+
		"a\3\2\2\2a\20\3\2\2\2bd\5%\23\2ce\5+\26\2dc\3\2\2\2ef\3\2\2\2fd\3\2\2"+
		"\2fg\3\2\2\2g\22\3\2\2\2hj\7<\2\2ik\5\t\5\2ji\3\2\2\2jk\3\2\2\2km\3\2"+
		"\2\2ln\5\7\4\2ml\3\2\2\2mn\3\2\2\2n\24\3\2\2\2op\7=\2\2p\26\3\2\2\2qs"+
		"\5\t\5\2rq\3\2\2\2rs\3\2\2\2su\3\2\2\2tv\5\7\4\2ut\3\2\2\2uv\3\2\2\2v"+
		"w\3\2\2\2wy\7~\2\2xz\5\t\5\2yx\3\2\2\2yz\3\2\2\2z|\3\2\2\2{}\5\7\4\2|"+
		"{\3\2\2\2|}\3\2\2\2}\30\3\2\2\2~\u0080\7*\2\2\177\u0081\5\7\4\2\u0080"+
		"\177\3\2\2\2\u0080\u0081\3\2\2\2\u0081\32\3\2\2\2\u0082\u0084\5\7\4\2"+
		"\u0083\u0082\3\2\2\2\u0083\u0084\3\2\2\2\u0084\u0085\3\2\2\2\u0085\u0086"+
		"\7+\2\2\u0086\34\3\2\2\2\u0087\u0088\7-\2\2\u0088\36\3\2\2\2\u0089\u008a"+
		"\7,\2\2\u008a \3\2\2\2\u008b\u008c\7A\2\2\u008c\"\3\2\2\2\u008d\u008f"+
		"\5\7\4\2\u008e\u008d\3\2\2\2\u008f\u0090\3\2\2\2\u0090\u008e\3\2\2\2\u0090"+
		"\u0091\3\2\2\2\u0091\u0093\3\2\2\2\u0092\u0094\5%\23\2\u0093\u0092\3\2"+
		"\2\2\u0094\u0095\3\2\2\2\u0095\u0093\3\2\2\2\u0095\u0096\3\2\2\2\u0096"+
		"\u0097\3\2\2\2\u0097\u009b\5\23\n\2\u0098\u009a\5-\27\2\u0099\u0098\3"+
		"\2\2\2\u009a\u009d\3\2\2\2\u009b\u0099\3\2\2\2\u009b\u009c\3\2\2\2\u009c"+
		"$\3\2\2\2\u009d\u009b\3\2\2\2\u009e\u009f\t\3\2\2\u009f&\3\2\2\2\u00a0"+
		"\u00a1\t\4\2\2\u00a1(\3\2\2\2\u00a2\u00a3\t\5\2\2\u00a3*\3\2\2\2\u00a4"+
		"\u00a5\t\6\2\2\u00a5,\3\2\2\2\u00a6\u00a7\13\2\2\2\u00a7.\3\2\2\2\27\2"+
		"\60\66?DGLZ`fjmruy|\u0080\u0083\u0090\u0095\u009b\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}