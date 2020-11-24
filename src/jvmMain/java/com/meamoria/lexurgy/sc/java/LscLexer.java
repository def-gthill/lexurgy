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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\'\u0186\b\1\4\2\t"+
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
		"\3\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\5\30\u00bb\n\30"+
		"\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31"+
		"\5\31\u00cb\n\31\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32"+
		"\3\32\3\32\3\32\3\32\3\32\3\32\3\32\5\32\u00df\n\32\3\33\3\33\3\33\3\33"+
		"\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\5\33\u00f1"+
		"\n\33\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34"+
		"\3\34\3\34\3\34\3\34\3\34\3\34\3\34\5\34\u0107\n\34\3\35\3\35\3\35\3\35"+
		"\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\5\35\u0115\n\35\3\36\3\36\3\36"+
		"\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36"+
		"\3\36\3\36\3\36\3\36\3\36\5\36\u012d\n\36\3\37\3\37\3\37\3\37\3\37\3\37"+
		"\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\5\37\u0141"+
		"\n\37\3 \3 \3 \3 \3 \3 \3 \3 \5 \u014b\n \3!\3!\3!\3!\3!\3!\3!\3!\3!\3"+
		"!\3!\3!\3!\3!\3!\3!\3!\3!\5!\u015f\n!\3\"\3\"\7\"\u0163\n\"\f\"\16\"\u0166"+
		"\13\"\3#\3#\7#\u016a\n#\f#\16#\u016d\13#\3$\6$\u0170\n$\r$\16$\u0171\3"+
		"%\3%\3&\6&\u0177\n&\r&\16&\u0178\3\'\3\'\3(\3(\3)\3)\3*\3*\3+\3+\3,\3"+
		",\2\2-\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17"+
		"\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\35"+
		"9\36;\37= ?!A\"C#E$G%I&K\'M\2O\2Q\2S\2U\2W\2\3\2\b\4\2\f\f\17\17\3\2C"+
		"\\\3\2c|\5\2\62;C\\c|\3\2\62;\17\2\f\f\17\17\"#%&*/\61\61<<?B]]__aa}}"+
		"\177\177\2\u019a\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13"+
		"\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2"+
		"\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2"+
		"!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3"+
		"\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2"+
		"\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E"+
		"\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\3Z\3\2\2\2\5e\3\2\2\2\7j\3\2"+
		"\2\2\ts\3\2\2\2\13z\3\2\2\2\r\u0082\3\2\2\2\17\u0085\3\2\2\2\21\u0090"+
		"\3\2\2\2\23\u0094\3\2\2\2\25\u0096\3\2\2\2\27\u0098\3\2\2\2\31\u009a\3"+
		"\2\2\2\33\u009c\3\2\2\2\35\u009e\3\2\2\2\37\u00a0\3\2\2\2!\u00a2\3\2\2"+
		"\2#\u00a4\3\2\2\2%\u00a6\3\2\2\2\'\u00a8\3\2\2\2)\u00aa\3\2\2\2+\u00ac"+
		"\3\2\2\2-\u00ae\3\2\2\2/\u00ba\3\2\2\2\61\u00ca\3\2\2\2\63\u00de\3\2\2"+
		"\2\65\u00f0\3\2\2\2\67\u0106\3\2\2\29\u0114\3\2\2\2;\u012c\3\2\2\2=\u0140"+
		"\3\2\2\2?\u014a\3\2\2\2A\u015e\3\2\2\2C\u0160\3\2\2\2E\u0167\3\2\2\2G"+
		"\u016f\3\2\2\2I\u0173\3\2\2\2K\u0176\3\2\2\2M\u017a\3\2\2\2O\u017c\3\2"+
		"\2\2Q\u017e\3\2\2\2S\u0180\3\2\2\2U\u0182\3\2\2\2W\u0184\3\2\2\2Y[\5\21"+
		"\t\2ZY\3\2\2\2Z[\3\2\2\2[\\\3\2\2\2\\`\5W,\2]_\n\2\2\2^]\3\2\2\2_b\3\2"+
		"\2\2`^\3\2\2\2`a\3\2\2\2ac\3\2\2\2b`\3\2\2\2cd\b\2\2\2d\4\3\2\2\2eg\7"+
		".\2\2fh\5\21\t\2gf\3\2\2\2gh\3\2\2\2h\6\3\2\2\2ik\5\21\t\2ji\3\2\2\2j"+
		"k\3\2\2\2kl\3\2\2\2lm\7?\2\2mn\7@\2\2np\3\2\2\2oq\5\21\t\2po\3\2\2\2p"+
		"q\3\2\2\2q\b\3\2\2\2rt\5\21\t\2sr\3\2\2\2st\3\2\2\2tu\3\2\2\2uw\7\61\2"+
		"\2vx\5\21\t\2wv\3\2\2\2wx\3\2\2\2x\n\3\2\2\2y{\5\21\t\2zy\3\2\2\2z{\3"+
		"\2\2\2{|\3\2\2\2|}\7\61\2\2}~\7\61\2\2~\u0080\3\2\2\2\177\u0081\5\21\t"+
		"\2\u0080\177\3\2\2\2\u0080\u0081\3\2\2\2\u0081\f\3\2\2\2\u0082\u0083\7"+
		"a\2\2\u0083\16\3\2\2\2\u0084\u0086\5\21\t\2\u0085\u0084\3\2\2\2\u0085"+
		"\u0086\3\2\2\2\u0086\u008a\3\2\2\2\u0087\u0088\7\17\2\2\u0088\u008b\7"+
		"\f\2\2\u0089\u008b\7\f\2\2\u008a\u0087\3\2\2\2\u008a\u0089\3\2\2\2\u008b"+
		"\u008d\3\2\2\2\u008c\u008e\5\21\t\2\u008d\u008c\3\2\2\2\u008d\u008e\3"+
		"\2\2\2\u008e\20\3\2\2\2\u008f\u0091\7\"\2\2\u0090\u008f\3\2\2\2\u0091"+
		"\u0092\3\2\2\2\u0092\u0090\3\2\2\2\u0092\u0093\3\2\2\2\u0093\22\3\2\2"+
		"\2\u0094\u0095\7*\2\2\u0095\24\3\2\2\2\u0096\u0097\7+\2\2\u0097\26\3\2"+
		"\2\2\u0098\u0099\7,\2\2\u0099\30\3\2\2\2\u009a\u009b\7]\2\2\u009b\32\3"+
		"\2\2\2\u009c\u009d\7_\2\2\u009d\34\3\2\2\2\u009e\u009f\7}\2\2\u009f\36"+
		"\3\2\2\2\u00a0\u00a1\7\177\2\2\u00a1 \3\2\2\2\u00a2\u00a3\7-\2\2\u00a3"+
		"\"\3\2\2\2\u00a4\u00a5\7A\2\2\u00a5$\3\2\2\2\u00a6\u00a7\7/\2\2\u00a7"+
		"&\3\2\2\2\u00a8\u00a9\7<\2\2\u00a9(\3\2\2\2\u00aa\u00ab\7#\2\2\u00ab*"+
		"\3\2\2\2\u00ac\u00ad\7&\2\2\u00ad,\3\2\2\2\u00ae\u00af\7B\2\2\u00af.\3"+
		"\2\2\2\u00b0\u00b1\7E\2\2\u00b1\u00b2\7n\2\2\u00b2\u00b3\7c\2\2\u00b3"+
		"\u00b4\7u\2\2\u00b4\u00bb\7u\2\2\u00b5\u00b6\7e\2\2\u00b6\u00b7\7n\2\2"+
		"\u00b7\u00b8\7c\2\2\u00b8\u00b9\7u\2\2\u00b9\u00bb\7u\2\2\u00ba\u00b0"+
		"\3\2\2\2\u00ba\u00b5\3\2\2\2\u00bb\60\3\2\2\2\u00bc\u00bd\7H\2\2\u00bd"+
		"\u00be\7g\2\2\u00be\u00bf\7c\2\2\u00bf\u00c0\7v\2\2\u00c0\u00c1\7w\2\2"+
		"\u00c1\u00c2\7t\2\2\u00c2\u00cb\7g\2\2\u00c3\u00c4\7h\2\2\u00c4\u00c5"+
		"\7g\2\2\u00c5\u00c6\7c\2\2\u00c6\u00c7\7v\2\2\u00c7\u00c8\7w\2\2\u00c8"+
		"\u00c9\7t\2\2\u00c9\u00cb\7g\2\2\u00ca\u00bc\3\2\2\2\u00ca\u00c3\3\2\2"+
		"\2\u00cb\62\3\2\2\2\u00cc\u00cd\7F\2\2\u00cd\u00ce\7k\2\2\u00ce\u00cf"+
		"\7c\2\2\u00cf\u00d0\7e\2\2\u00d0\u00d1\7t\2\2\u00d1\u00d2\7k\2\2\u00d2"+
		"\u00d3\7v\2\2\u00d3\u00d4\7k\2\2\u00d4\u00df\7e\2\2\u00d5\u00d6\7f\2\2"+
		"\u00d6\u00d7\7k\2\2\u00d7\u00d8\7c\2\2\u00d8\u00d9\7e\2\2\u00d9\u00da"+
		"\7t\2\2\u00da\u00db\7k\2\2\u00db\u00dc\7v\2\2\u00dc\u00dd\7k\2\2\u00dd"+
		"\u00df\7e\2\2\u00de\u00cc\3\2\2\2\u00de\u00d5\3\2\2\2\u00df\64\3\2\2\2"+
		"\u00e0\u00e1\7*\2\2\u00e1\u00e2\7D\2\2\u00e2\u00e3\7g\2\2\u00e3\u00e4"+
		"\7h\2\2\u00e4\u00e5\7q\2\2\u00e5\u00e6\7t\2\2\u00e6\u00e7\7g\2\2\u00e7"+
		"\u00f1\7+\2\2\u00e8\u00e9\7*\2\2\u00e9\u00ea\7d\2\2\u00ea\u00eb\7g\2\2"+
		"\u00eb\u00ec\7h\2\2\u00ec\u00ed\7q\2\2\u00ed\u00ee\7t\2\2\u00ee\u00ef"+
		"\7g\2\2\u00ef\u00f1\7+\2\2\u00f0\u00e0\3\2\2\2\u00f0\u00e8\3\2\2\2\u00f1"+
		"\66\3\2\2\2\u00f2\u00f3\7*\2\2\u00f3\u00f4\7H\2\2\u00f4\u00f5\7n\2\2\u00f5"+
		"\u00f6\7q\2\2\u00f6\u00f7\7c\2\2\u00f7\u00f8\7v\2\2\u00f8\u00f9\7k\2\2"+
		"\u00f9\u00fa\7p\2\2\u00fa\u00fb\7i\2\2\u00fb\u0107\7+\2\2\u00fc\u00fd"+
		"\7*\2\2\u00fd\u00fe\7h\2\2\u00fe\u00ff\7n\2\2\u00ff\u0100\7q\2\2\u0100"+
		"\u0101\7c\2\2\u0101\u0102\7v\2\2\u0102\u0103\7k\2\2\u0103\u0104\7p\2\2"+
		"\u0104\u0105\7i\2\2\u0105\u0107\7+\2\2\u0106\u00f2\3\2\2\2\u0106\u00fc"+
		"\3\2\2\2\u01078\3\2\2\2\u0108\u0109\7U\2\2\u0109\u010a\7{\2\2\u010a\u010b"+
		"\7o\2\2\u010b\u010c\7d\2\2\u010c\u010d\7q\2\2\u010d\u0115\7n\2\2\u010e"+
		"\u010f\7u\2\2\u010f\u0110\7{\2\2\u0110\u0111\7o\2\2\u0111\u0112\7d\2\2"+
		"\u0112\u0113\7q\2\2\u0113\u0115\7n\2\2\u0114\u0108\3\2\2\2\u0114\u010e"+
		"\3\2\2\2\u0115:\3\2\2\2\u0116\u0117\7F\2\2\u0117\u0118\7g\2\2\u0118\u0119"+
		"\7t\2\2\u0119\u011a\7q\2\2\u011a\u011b\7o\2\2\u011b\u011c\7c\2\2\u011c"+
		"\u011d\7p\2\2\u011d\u011e\7k\2\2\u011e\u011f\7|\2\2\u011f\u0120\7g\2\2"+
		"\u0120\u012d\7t\2\2\u0121\u0122\7f\2\2\u0122\u0123\7g\2\2\u0123\u0124"+
		"\7t\2\2\u0124\u0125\7q\2\2\u0125\u0126\7o\2\2\u0126\u0127\7c\2\2\u0127"+
		"\u0128\7p\2\2\u0128\u0129\7k\2\2\u0129\u012a\7|\2\2\u012a\u012b\7g\2\2"+
		"\u012b\u012d\7t\2\2\u012c\u0116\3\2\2\2\u012c\u0121\3\2\2\2\u012d<\3\2"+
		"\2\2\u012e\u012f\7T\2\2\u012f\u0130\7q\2\2\u0130\u0131\7o\2\2\u0131\u0132"+
		"\7c\2\2\u0132\u0133\7p\2\2\u0133\u0134\7k\2\2\u0134\u0135\7|\2\2\u0135"+
		"\u0136\7g\2\2\u0136\u0141\7t\2\2\u0137\u0138\7t\2\2\u0138\u0139\7q\2\2"+
		"\u0139\u013a\7o\2\2\u013a\u013b\7c\2\2\u013b\u013c\7p\2\2\u013c\u013d"+
		"\7k\2\2\u013d\u013e\7|\2\2\u013e\u013f\7g\2\2\u013f\u0141\7t\2\2\u0140"+
		"\u012e\3\2\2\2\u0140\u0137\3\2\2\2\u0141>\3\2\2\2\u0142\u0143\7V\2\2\u0143"+
		"\u0144\7j\2\2\u0144\u0145\7g\2\2\u0145\u014b\7p\2\2\u0146\u0147\7v\2\2"+
		"\u0147\u0148\7j\2\2\u0148\u0149\7g\2\2\u0149\u014b\7p\2\2\u014a\u0142"+
		"\3\2\2\2\u014a\u0146\3\2\2\2\u014b@\3\2\2\2\u014c\u014d\7R\2\2\u014d\u014e"+
		"\7t\2\2\u014e\u014f\7q\2\2\u014f\u0150\7r\2\2\u0150\u0151\7c\2\2\u0151"+
		"\u0152\7i\2\2\u0152\u0153\7c\2\2\u0153\u0154\7v\2\2\u0154\u015f\7g\2\2"+
		"\u0155\u0156\7r\2\2\u0156\u0157\7t\2\2\u0157\u0158\7q\2\2\u0158\u0159"+
		"\7r\2\2\u0159\u015a\7c\2\2\u015a\u015b\7i\2\2\u015b\u015c\7c\2\2\u015c"+
		"\u015d\7v\2\2\u015d\u015f\7g\2\2\u015e\u014c\3\2\2\2\u015e\u0155\3\2\2"+
		"\2\u015fB\3\2\2\2\u0160\u0164\5M\'\2\u0161\u0163\5Q)\2\u0162\u0161\3\2"+
		"\2\2\u0163\u0166\3\2\2\2\u0164\u0162\3\2\2\2\u0164\u0165\3\2\2\2\u0165"+
		"D\3\2\2\2\u0166\u0164\3\2\2\2\u0167\u016b\5O(\2\u0168\u016a\5Q)\2\u0169"+
		"\u0168\3\2\2\2\u016a\u016d\3\2\2\2\u016b\u0169\3\2\2\2\u016b\u016c\3\2"+
		"\2\2\u016cF\3\2\2\2\u016d\u016b\3\2\2\2\u016e\u0170\5S*\2\u016f\u016e"+
		"\3\2\2\2\u0170\u0171\3\2\2\2\u0171\u016f\3\2\2\2\u0171\u0172\3\2\2\2\u0172"+
		"H\3\2\2\2\u0173\u0174\5U+\2\u0174J\3\2\2\2\u0175\u0177\5U+\2\u0176\u0175"+
		"\3\2\2\2\u0177\u0178\3\2\2\2\u0178\u0176\3\2\2\2\u0178\u0179\3\2\2\2\u0179"+
		"L\3\2\2\2\u017a\u017b\t\3\2\2\u017bN\3\2\2\2\u017c\u017d\t\4\2\2\u017d"+
		"P\3\2\2\2\u017e\u017f\t\5\2\2\u017fR\3\2\2\2\u0180\u0181\t\6\2\2\u0181"+
		"T\3\2\2\2\u0182\u0183\n\7\2\2\u0183V\3\2\2\2\u0184\u0185\7%\2\2\u0185"+
		"X\3\2\2\2\36\2Z`gjpswz\u0080\u0085\u008a\u008d\u0092\u00ba\u00ca\u00de"+
		"\u00f0\u0106\u0114\u012c\u0140\u014a\u015e\u0164\u016b\u0171\u0178\3\b"+
		"\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}