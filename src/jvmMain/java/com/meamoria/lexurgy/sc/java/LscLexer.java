// Generated from Lsc.g4 by ANTLR 4.7.2
package com.meamoria.lexurgy.sc.java;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class LscLexer extends Lexer {
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
		ROMANIZER=30, SUBRULE=31, PROPAGATE=32, FEATURE=33, VALUE=34, NUMBER=35, 
		STR1=36, STR=37;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"COMMENT", "SEP", "CHANGE", "CONDITION", "EXCLUSION", "ANCHOR", "NEWLINE", 
			"WHITESPACE", "O_PAREN", "C_PAREN", "NULL", "MATRIX_START", "MATRIX_END", 
			"LIST_START", "LIST_END", "AT_LEAST_ONE", "OPTIONAL", "HYPHEN", "RULE_START", 
			"NEGATION", "WORD_BOUNDARY", "CLASSREF", "CLASS_DECL", "FEATURE_DECL", 
			"DIACRITIC", "DIA_BEFORE", "DIA_FLOATING", "SYMBOL", "DEROMANIZER", "ROMANIZER", 
			"SUBRULE", "PROPAGATE", "FEATURE", "VALUE", "NUMBER", "STR1", "STR", 
			"UPPER", "LOWER", "CHAR", "DIGIT", "ANY", "COMMENT_START"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, null, "'_'", null, null, "'('", "')'", 
			"'*'", "'['", "']'", "'{'", "'}'", "'+'", "'?'", "'-'", "':'", "'!'", 
			"'$'", "'@'", "'Class'", "'Feature'", "'Diacritic'", "'(before)'", "'(floating)'", 
			"'Symbol'", "'Deromanizer'", "'Romanizer'", "'Then'", "'propagate'"
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
			"DEROMANIZER", "ROMANIZER", "SUBRULE", "PROPAGATE", "FEATURE", "VALUE", 
			"NUMBER", "STR1", "STR"
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


	public LscLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Lsc.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\'\u012e\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\3\2\5\2[\n\2\3\2\3\2\7\2_\n\2\f\2\16\2b\13\2\3\2\3\2\3\3\3\3\5\3"+
		"h\n\3\3\4\5\4k\n\4\3\4\3\4\3\4\3\4\5\4q\n\4\3\5\5\5t\n\5\3\5\3\5\5\5x"+
		"\n\5\3\6\5\6{\n\6\3\6\3\6\3\6\3\6\5\6\u0081\n\6\3\7\3\7\3\b\5\b\u0086"+
		"\n\b\3\b\3\b\3\b\5\b\u008b\n\b\3\b\5\b\u008e\n\b\3\t\6\t\u0091\n\t\r\t"+
		"\16\t\u0092\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20"+
		"\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27"+
		"\3\27\3\30\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31"+
		"\3\31\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33"+
		"\3\33\3\33\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34"+
		"\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36"+
		"\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3\37\3\37"+
		"\3\37\3\37\3\37\3\37\3 \3 \3 \3 \3 \3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3\""+
		"\3\"\7\"\u010b\n\"\f\"\16\"\u010e\13\"\3#\3#\7#\u0112\n#\f#\16#\u0115"+
		"\13#\3$\6$\u0118\n$\r$\16$\u0119\3%\3%\3&\6&\u011f\n&\r&\16&\u0120\3\'"+
		"\3\'\3(\3(\3)\3)\3*\3*\3+\3+\3,\3,\2\2-\3\3\5\4\7\5\t\6\13\7\r\b\17\t"+
		"\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27"+
		"-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M\2O\2Q\2S\2"+
		"U\2W\2\3\2\b\4\2\f\f\17\17\3\2C\\\3\2c|\5\2\62;C\\c|\3\2\62;\17\2\f\f"+
		"\17\17\"#%&*/\61\61<<?B]]__aa}}\177\177\2\u0138\2\3\3\2\2\2\2\5\3\2\2"+
		"\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21"+
		"\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2"+
		"\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3"+
		"\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3"+
		"\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3"+
		"\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2"+
		"\2\3Z\3\2\2\2\5e\3\2\2\2\7j\3\2\2\2\ts\3\2\2\2\13z\3\2\2\2\r\u0082\3\2"+
		"\2\2\17\u0085\3\2\2\2\21\u0090\3\2\2\2\23\u0094\3\2\2\2\25\u0096\3\2\2"+
		"\2\27\u0098\3\2\2\2\31\u009a\3\2\2\2\33\u009c\3\2\2\2\35\u009e\3\2\2\2"+
		"\37\u00a0\3\2\2\2!\u00a2\3\2\2\2#\u00a4\3\2\2\2%\u00a6\3\2\2\2\'\u00a8"+
		"\3\2\2\2)\u00aa\3\2\2\2+\u00ac\3\2\2\2-\u00ae\3\2\2\2/\u00b0\3\2\2\2\61"+
		"\u00b6\3\2\2\2\63\u00be\3\2\2\2\65\u00c8\3\2\2\2\67\u00d1\3\2\2\29\u00dc"+
		"\3\2\2\2;\u00e3\3\2\2\2=\u00ef\3\2\2\2?\u00f9\3\2\2\2A\u00fe\3\2\2\2C"+
		"\u0108\3\2\2\2E\u010f\3\2\2\2G\u0117\3\2\2\2I\u011b\3\2\2\2K\u011e\3\2"+
		"\2\2M\u0122\3\2\2\2O\u0124\3\2\2\2Q\u0126\3\2\2\2S\u0128\3\2\2\2U\u012a"+
		"\3\2\2\2W\u012c\3\2\2\2Y[\5\21\t\2ZY\3\2\2\2Z[\3\2\2\2[\\\3\2\2\2\\`\5"+
		"W,\2]_\n\2\2\2^]\3\2\2\2_b\3\2\2\2`^\3\2\2\2`a\3\2\2\2ac\3\2\2\2b`\3\2"+
		"\2\2cd\b\2\2\2d\4\3\2\2\2eg\7.\2\2fh\5\21\t\2gf\3\2\2\2gh\3\2\2\2h\6\3"+
		"\2\2\2ik\5\21\t\2ji\3\2\2\2jk\3\2\2\2kl\3\2\2\2lm\7?\2\2mn\7@\2\2np\3"+
		"\2\2\2oq\5\21\t\2po\3\2\2\2pq\3\2\2\2q\b\3\2\2\2rt\5\21\t\2sr\3\2\2\2"+
		"st\3\2\2\2tu\3\2\2\2uw\7\61\2\2vx\5\21\t\2wv\3\2\2\2wx\3\2\2\2x\n\3\2"+
		"\2\2y{\5\21\t\2zy\3\2\2\2z{\3\2\2\2{|\3\2\2\2|}\7\61\2\2}~\7\61\2\2~\u0080"+
		"\3\2\2\2\177\u0081\5\21\t\2\u0080\177\3\2\2\2\u0080\u0081\3\2\2\2\u0081"+
		"\f\3\2\2\2\u0082\u0083\7a\2\2\u0083\16\3\2\2\2\u0084\u0086\5\21\t\2\u0085"+
		"\u0084\3\2\2\2\u0085\u0086\3\2\2\2\u0086\u008a\3\2\2\2\u0087\u0088\7\17"+
		"\2\2\u0088\u008b\7\f\2\2\u0089\u008b\7\f\2\2\u008a\u0087\3\2\2\2\u008a"+
		"\u0089\3\2\2\2\u008b\u008d\3\2\2\2\u008c\u008e\5\21\t\2\u008d\u008c\3"+
		"\2\2\2\u008d\u008e\3\2\2\2\u008e\20\3\2\2\2\u008f\u0091\7\"\2\2\u0090"+
		"\u008f\3\2\2\2\u0091\u0092\3\2\2\2\u0092\u0090\3\2\2\2\u0092\u0093\3\2"+
		"\2\2\u0093\22\3\2\2\2\u0094\u0095\7*\2\2\u0095\24\3\2\2\2\u0096\u0097"+
		"\7+\2\2\u0097\26\3\2\2\2\u0098\u0099\7,\2\2\u0099\30\3\2\2\2\u009a\u009b"+
		"\7]\2\2\u009b\32\3\2\2\2\u009c\u009d\7_\2\2\u009d\34\3\2\2\2\u009e\u009f"+
		"\7}\2\2\u009f\36\3\2\2\2\u00a0\u00a1\7\177\2\2\u00a1 \3\2\2\2\u00a2\u00a3"+
		"\7-\2\2\u00a3\"\3\2\2\2\u00a4\u00a5\7A\2\2\u00a5$\3\2\2\2\u00a6\u00a7"+
		"\7/\2\2\u00a7&\3\2\2\2\u00a8\u00a9\7<\2\2\u00a9(\3\2\2\2\u00aa\u00ab\7"+
		"#\2\2\u00ab*\3\2\2\2\u00ac\u00ad\7&\2\2\u00ad,\3\2\2\2\u00ae\u00af\7B"+
		"\2\2\u00af.\3\2\2\2\u00b0\u00b1\7E\2\2\u00b1\u00b2\7n\2\2\u00b2\u00b3"+
		"\7c\2\2\u00b3\u00b4\7u\2\2\u00b4\u00b5\7u\2\2\u00b5\60\3\2\2\2\u00b6\u00b7"+
		"\7H\2\2\u00b7\u00b8\7g\2\2\u00b8\u00b9\7c\2\2\u00b9\u00ba\7v\2\2\u00ba"+
		"\u00bb\7w\2\2\u00bb\u00bc\7t\2\2\u00bc\u00bd\7g\2\2\u00bd\62\3\2\2\2\u00be"+
		"\u00bf\7F\2\2\u00bf\u00c0\7k\2\2\u00c0\u00c1\7c\2\2\u00c1\u00c2\7e\2\2"+
		"\u00c2\u00c3\7t\2\2\u00c3\u00c4\7k\2\2\u00c4\u00c5\7v\2\2\u00c5\u00c6"+
		"\7k\2\2\u00c6\u00c7\7e\2\2\u00c7\64\3\2\2\2\u00c8\u00c9\7*\2\2\u00c9\u00ca"+
		"\7d\2\2\u00ca\u00cb\7g\2\2\u00cb\u00cc\7h\2\2\u00cc\u00cd\7q\2\2\u00cd"+
		"\u00ce\7t\2\2\u00ce\u00cf\7g\2\2\u00cf\u00d0\7+\2\2\u00d0\66\3\2\2\2\u00d1"+
		"\u00d2\7*\2\2\u00d2\u00d3\7h\2\2\u00d3\u00d4\7n\2\2\u00d4\u00d5\7q\2\2"+
		"\u00d5\u00d6\7c\2\2\u00d6\u00d7\7v\2\2\u00d7\u00d8\7k\2\2\u00d8\u00d9"+
		"\7p\2\2\u00d9\u00da\7i\2\2\u00da\u00db\7+\2\2\u00db8\3\2\2\2\u00dc\u00dd"+
		"\7U\2\2\u00dd\u00de\7{\2\2\u00de\u00df\7o\2\2\u00df\u00e0\7d\2\2\u00e0"+
		"\u00e1\7q\2\2\u00e1\u00e2\7n\2\2\u00e2:\3\2\2\2\u00e3\u00e4\7F\2\2\u00e4"+
		"\u00e5\7g\2\2\u00e5\u00e6\7t\2\2\u00e6\u00e7\7q\2\2\u00e7\u00e8\7o\2\2"+
		"\u00e8\u00e9\7c\2\2\u00e9\u00ea\7p\2\2\u00ea\u00eb\7k\2\2\u00eb\u00ec"+
		"\7|\2\2\u00ec\u00ed\7g\2\2\u00ed\u00ee\7t\2\2\u00ee<\3\2\2\2\u00ef\u00f0"+
		"\7T\2\2\u00f0\u00f1\7q\2\2\u00f1\u00f2\7o\2\2\u00f2\u00f3\7c\2\2\u00f3"+
		"\u00f4\7p\2\2\u00f4\u00f5\7k\2\2\u00f5\u00f6\7|\2\2\u00f6\u00f7\7g\2\2"+
		"\u00f7\u00f8\7t\2\2\u00f8>\3\2\2\2\u00f9\u00fa\7V\2\2\u00fa\u00fb\7j\2"+
		"\2\u00fb\u00fc\7g\2\2\u00fc\u00fd\7p\2\2\u00fd@\3\2\2\2\u00fe\u00ff\7"+
		"r\2\2\u00ff\u0100\7t\2\2\u0100\u0101\7q\2\2\u0101\u0102\7r\2\2\u0102\u0103"+
		"\7c\2\2\u0103\u0104\7i\2\2\u0104\u0105\7c\2\2\u0105\u0106\7v\2\2\u0106"+
		"\u0107\7g\2\2\u0107B\3\2\2\2\u0108\u010c\5M\'\2\u0109\u010b\5Q)\2\u010a"+
		"\u0109\3\2\2\2\u010b\u010e\3\2\2\2\u010c\u010a\3\2\2\2\u010c\u010d\3\2"+
		"\2\2\u010dD\3\2\2\2\u010e\u010c\3\2\2\2\u010f\u0113\5O(\2\u0110\u0112"+
		"\5Q)\2\u0111\u0110\3\2\2\2\u0112\u0115\3\2\2\2\u0113\u0111\3\2\2\2\u0113"+
		"\u0114\3\2\2\2\u0114F\3\2\2\2\u0115\u0113\3\2\2\2\u0116\u0118\5S*\2\u0117"+
		"\u0116\3\2\2\2\u0118\u0119\3\2\2\2\u0119\u0117\3\2\2\2\u0119\u011a\3\2"+
		"\2\2\u011aH\3\2\2\2\u011b\u011c\5U+\2\u011cJ\3\2\2\2\u011d\u011f\5U+\2"+
		"\u011e\u011d\3\2\2\2\u011f\u0120\3\2\2\2\u0120\u011e\3\2\2\2\u0120\u0121"+
		"\3\2\2\2\u0121L\3\2\2\2\u0122\u0123\t\3\2\2\u0123N\3\2\2\2\u0124\u0125"+
		"\t\4\2\2\u0125P\3\2\2\2\u0126\u0127\t\5\2\2\u0127R\3\2\2\2\u0128\u0129"+
		"\t\6\2\2\u0129T\3\2\2\2\u012a\u012b\n\7\2\2\u012bV\3\2\2\2\u012c\u012d"+
		"\7%\2\2\u012dX\3\2\2\2\24\2Z`gjpswz\u0080\u0085\u008a\u008d\u0092\u010c"+
		"\u0113\u0119\u0120\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}