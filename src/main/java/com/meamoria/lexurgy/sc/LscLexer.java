// Generated from Lsc.g4 by ANTLR 4.7.2
package com.meamoria.lexurgy.sc;
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
		WHITESPACE=8, OPAREN=9, CPAREN=10, NULL=11, MATSTART=12, MATEND=13, LISTSTART=14, 
		LISTEND=15, ATLEASTONE=16, OPTIONAL=17, HYPHEN=18, RULESTART=19, NEGATION=20, 
		WORDBOUNDARY=21, CLASSREF=22, CLASSDECL=23, FEATUREDECL=24, DIACRITIC=25, 
		DIABEFORE=26, SYMBOL=27, DEROMANIZER=28, ROMANIZER=29, SUBRULE=30, PROPAGATE=31, 
		FEATURE=32, VALUE=33, NUMBER=34, STR1=35, STR=36;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"COMMENT", "SEP", "CHANGE", "CONDITION", "EXCLUSION", "ANCHOR", "NEWLINE", 
			"WHITESPACE", "OPAREN", "CPAREN", "NULL", "MATSTART", "MATEND", "LISTSTART", 
			"LISTEND", "ATLEASTONE", "OPTIONAL", "HYPHEN", "RULESTART", "NEGATION", 
			"WORDBOUNDARY", "CLASSREF", "CLASSDECL", "FEATUREDECL", "DIACRITIC", 
			"DIABEFORE", "SYMBOL", "DEROMANIZER", "ROMANIZER", "SUBRULE", "PROPAGATE", 
			"FEATURE", "VALUE", "NUMBER", "STR1", "STR", "UPPER", "LOWER", "CHAR", 
			"DIGIT", "ANY", "COMMENTSTART"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, null, "'_'", null, null, "'('", "')'", 
			"'*'", "'['", "']'", "'{'", "'}'", "'+'", "'?'", "'-'", "':'", "'!'", 
			"'$'", "'@'", "'Class'", "'Feature'", "'Diacritic'", "'(before)'", "'Symbol'", 
			"'Deromanizer'", "'Romanizer'", "'Then'", "'propagate'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "COMMENT", "SEP", "CHANGE", "CONDITION", "EXCLUSION", "ANCHOR", 
			"NEWLINE", "WHITESPACE", "OPAREN", "CPAREN", "NULL", "MATSTART", "MATEND", 
			"LISTSTART", "LISTEND", "ATLEASTONE", "OPTIONAL", "HYPHEN", "RULESTART", 
			"NEGATION", "WORDBOUNDARY", "CLASSREF", "CLASSDECL", "FEATUREDECL", "DIACRITIC", 
			"DIABEFORE", "SYMBOL", "DEROMANIZER", "ROMANIZER", "SUBRULE", "PROPAGATE", 
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2&\u0121\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\3"+
		"\2\5\2Y\n\2\3\2\3\2\7\2]\n\2\f\2\16\2`\13\2\3\2\3\2\3\3\3\3\5\3f\n\3\3"+
		"\4\5\4i\n\4\3\4\3\4\3\4\3\4\5\4o\n\4\3\5\5\5r\n\5\3\5\3\5\5\5v\n\5\3\6"+
		"\5\6y\n\6\3\6\3\6\3\6\3\6\5\6\177\n\6\3\7\3\7\3\b\5\b\u0084\n\b\3\b\3"+
		"\b\3\b\5\b\u0089\n\b\3\b\5\b\u008c\n\b\3\t\6\t\u008f\n\t\r\t\16\t\u0090"+
		"\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21"+
		"\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30"+
		"\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\32"+
		"\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33"+
		"\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\35\3\35\3\35"+
		"\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36"+
		"\3\36\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3\37\3 \3 \3 \3 \3 \3 \3"+
		" \3 \3 \3 \3!\3!\7!\u00fe\n!\f!\16!\u0101\13!\3\"\3\"\7\"\u0105\n\"\f"+
		"\"\16\"\u0108\13\"\3#\6#\u010b\n#\r#\16#\u010c\3$\3$\3%\6%\u0112\n%\r"+
		"%\16%\u0113\3&\3&\3\'\3\'\3(\3(\3)\3)\3*\3*\3+\3+\2\2,\3\3\5\4\7\5\t\6"+
		"\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24"+
		"\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K"+
		"\2M\2O\2Q\2S\2U\2\3\2\b\4\2\f\f\17\17\3\2C\\\3\2c|\5\2\62;C\\c|\3\2\62"+
		";\17\2\f\f\17\17\"#%&*/\61\61<<?B]]__aa}}\177\177\2\u012b\2\3\3\2\2\2"+
		"\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2"+
		"\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2"+
		"\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2"+
		"\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2"+
		"\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2"+
		"\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2"+
		"\3X\3\2\2\2\5c\3\2\2\2\7h\3\2\2\2\tq\3\2\2\2\13x\3\2\2\2\r\u0080\3\2\2"+
		"\2\17\u0083\3\2\2\2\21\u008e\3\2\2\2\23\u0092\3\2\2\2\25\u0094\3\2\2\2"+
		"\27\u0096\3\2\2\2\31\u0098\3\2\2\2\33\u009a\3\2\2\2\35\u009c\3\2\2\2\37"+
		"\u009e\3\2\2\2!\u00a0\3\2\2\2#\u00a2\3\2\2\2%\u00a4\3\2\2\2\'\u00a6\3"+
		"\2\2\2)\u00a8\3\2\2\2+\u00aa\3\2\2\2-\u00ac\3\2\2\2/\u00ae\3\2\2\2\61"+
		"\u00b4\3\2\2\2\63\u00bc\3\2\2\2\65\u00c6\3\2\2\2\67\u00cf\3\2\2\29\u00d6"+
		"\3\2\2\2;\u00e2\3\2\2\2=\u00ec\3\2\2\2?\u00f1\3\2\2\2A\u00fb\3\2\2\2C"+
		"\u0102\3\2\2\2E\u010a\3\2\2\2G\u010e\3\2\2\2I\u0111\3\2\2\2K\u0115\3\2"+
		"\2\2M\u0117\3\2\2\2O\u0119\3\2\2\2Q\u011b\3\2\2\2S\u011d\3\2\2\2U\u011f"+
		"\3\2\2\2WY\5\21\t\2XW\3\2\2\2XY\3\2\2\2YZ\3\2\2\2Z^\5U+\2[]\n\2\2\2\\"+
		"[\3\2\2\2]`\3\2\2\2^\\\3\2\2\2^_\3\2\2\2_a\3\2\2\2`^\3\2\2\2ab\b\2\2\2"+
		"b\4\3\2\2\2ce\7.\2\2df\5\21\t\2ed\3\2\2\2ef\3\2\2\2f\6\3\2\2\2gi\5\21"+
		"\t\2hg\3\2\2\2hi\3\2\2\2ij\3\2\2\2jk\7?\2\2kl\7@\2\2ln\3\2\2\2mo\5\21"+
		"\t\2nm\3\2\2\2no\3\2\2\2o\b\3\2\2\2pr\5\21\t\2qp\3\2\2\2qr\3\2\2\2rs\3"+
		"\2\2\2su\7\61\2\2tv\5\21\t\2ut\3\2\2\2uv\3\2\2\2v\n\3\2\2\2wy\5\21\t\2"+
		"xw\3\2\2\2xy\3\2\2\2yz\3\2\2\2z{\7\61\2\2{|\7\61\2\2|~\3\2\2\2}\177\5"+
		"\21\t\2~}\3\2\2\2~\177\3\2\2\2\177\f\3\2\2\2\u0080\u0081\7a\2\2\u0081"+
		"\16\3\2\2\2\u0082\u0084\5\21\t\2\u0083\u0082\3\2\2\2\u0083\u0084\3\2\2"+
		"\2\u0084\u0088\3\2\2\2\u0085\u0086\7\17\2\2\u0086\u0089\7\f\2\2\u0087"+
		"\u0089\7\f\2\2\u0088\u0085\3\2\2\2\u0088\u0087\3\2\2\2\u0089\u008b\3\2"+
		"\2\2\u008a\u008c\5\21\t\2\u008b\u008a\3\2\2\2\u008b\u008c\3\2\2\2\u008c"+
		"\20\3\2\2\2\u008d\u008f\7\"\2\2\u008e\u008d\3\2\2\2\u008f\u0090\3\2\2"+
		"\2\u0090\u008e\3\2\2\2\u0090\u0091\3\2\2\2\u0091\22\3\2\2\2\u0092\u0093"+
		"\7*\2\2\u0093\24\3\2\2\2\u0094\u0095\7+\2\2\u0095\26\3\2\2\2\u0096\u0097"+
		"\7,\2\2\u0097\30\3\2\2\2\u0098\u0099\7]\2\2\u0099\32\3\2\2\2\u009a\u009b"+
		"\7_\2\2\u009b\34\3\2\2\2\u009c\u009d\7}\2\2\u009d\36\3\2\2\2\u009e\u009f"+
		"\7\177\2\2\u009f \3\2\2\2\u00a0\u00a1\7-\2\2\u00a1\"\3\2\2\2\u00a2\u00a3"+
		"\7A\2\2\u00a3$\3\2\2\2\u00a4\u00a5\7/\2\2\u00a5&\3\2\2\2\u00a6\u00a7\7"+
		"<\2\2\u00a7(\3\2\2\2\u00a8\u00a9\7#\2\2\u00a9*\3\2\2\2\u00aa\u00ab\7&"+
		"\2\2\u00ab,\3\2\2\2\u00ac\u00ad\7B\2\2\u00ad.\3\2\2\2\u00ae\u00af\7E\2"+
		"\2\u00af\u00b0\7n\2\2\u00b0\u00b1\7c\2\2\u00b1\u00b2\7u\2\2\u00b2\u00b3"+
		"\7u\2\2\u00b3\60\3\2\2\2\u00b4\u00b5\7H\2\2\u00b5\u00b6\7g\2\2\u00b6\u00b7"+
		"\7c\2\2\u00b7\u00b8\7v\2\2\u00b8\u00b9\7w\2\2\u00b9\u00ba\7t\2\2\u00ba"+
		"\u00bb\7g\2\2\u00bb\62\3\2\2\2\u00bc\u00bd\7F\2\2\u00bd\u00be\7k\2\2\u00be"+
		"\u00bf\7c\2\2\u00bf\u00c0\7e\2\2\u00c0\u00c1\7t\2\2\u00c1\u00c2\7k\2\2"+
		"\u00c2\u00c3\7v\2\2\u00c3\u00c4\7k\2\2\u00c4\u00c5\7e\2\2\u00c5\64\3\2"+
		"\2\2\u00c6\u00c7\7*\2\2\u00c7\u00c8\7d\2\2\u00c8\u00c9\7g\2\2\u00c9\u00ca"+
		"\7h\2\2\u00ca\u00cb\7q\2\2\u00cb\u00cc\7t\2\2\u00cc\u00cd\7g\2\2\u00cd"+
		"\u00ce\7+\2\2\u00ce\66\3\2\2\2\u00cf\u00d0\7U\2\2\u00d0\u00d1\7{\2\2\u00d1"+
		"\u00d2\7o\2\2\u00d2\u00d3\7d\2\2\u00d3\u00d4\7q\2\2\u00d4\u00d5\7n\2\2"+
		"\u00d58\3\2\2\2\u00d6\u00d7\7F\2\2\u00d7\u00d8\7g\2\2\u00d8\u00d9\7t\2"+
		"\2\u00d9\u00da\7q\2\2\u00da\u00db\7o\2\2\u00db\u00dc\7c\2\2\u00dc\u00dd"+
		"\7p\2\2\u00dd\u00de\7k\2\2\u00de\u00df\7|\2\2\u00df\u00e0\7g\2\2\u00e0"+
		"\u00e1\7t\2\2\u00e1:\3\2\2\2\u00e2\u00e3\7T\2\2\u00e3\u00e4\7q\2\2\u00e4"+
		"\u00e5\7o\2\2\u00e5\u00e6\7c\2\2\u00e6\u00e7\7p\2\2\u00e7\u00e8\7k\2\2"+
		"\u00e8\u00e9\7|\2\2\u00e9\u00ea\7g\2\2\u00ea\u00eb\7t\2\2\u00eb<\3\2\2"+
		"\2\u00ec\u00ed\7V\2\2\u00ed\u00ee\7j\2\2\u00ee\u00ef\7g\2\2\u00ef\u00f0"+
		"\7p\2\2\u00f0>\3\2\2\2\u00f1\u00f2\7r\2\2\u00f2\u00f3\7t\2\2\u00f3\u00f4"+
		"\7q\2\2\u00f4\u00f5\7r\2\2\u00f5\u00f6\7c\2\2\u00f6\u00f7\7i\2\2\u00f7"+
		"\u00f8\7c\2\2\u00f8\u00f9\7v\2\2\u00f9\u00fa\7g\2\2\u00fa@\3\2\2\2\u00fb"+
		"\u00ff\5K&\2\u00fc\u00fe\5O(\2\u00fd\u00fc\3\2\2\2\u00fe\u0101\3\2\2\2"+
		"\u00ff\u00fd\3\2\2\2\u00ff\u0100\3\2\2\2\u0100B\3\2\2\2\u0101\u00ff\3"+
		"\2\2\2\u0102\u0106\5M\'\2\u0103\u0105\5O(\2\u0104\u0103\3\2\2\2\u0105"+
		"\u0108\3\2\2\2\u0106\u0104\3\2\2\2\u0106\u0107\3\2\2\2\u0107D\3\2\2\2"+
		"\u0108\u0106\3\2\2\2\u0109\u010b\5Q)\2\u010a\u0109\3\2\2\2\u010b\u010c"+
		"\3\2\2\2\u010c\u010a\3\2\2\2\u010c\u010d\3\2\2\2\u010dF\3\2\2\2\u010e"+
		"\u010f\5S*\2\u010fH\3\2\2\2\u0110\u0112\5S*\2\u0111\u0110\3\2\2\2\u0112"+
		"\u0113\3\2\2\2\u0113\u0111\3\2\2\2\u0113\u0114\3\2\2\2\u0114J\3\2\2\2"+
		"\u0115\u0116\t\3\2\2\u0116L\3\2\2\2\u0117\u0118\t\4\2\2\u0118N\3\2\2\2"+
		"\u0119\u011a\t\5\2\2\u011aP\3\2\2\2\u011b\u011c\t\6\2\2\u011cR\3\2\2\2"+
		"\u011d\u011e\n\7\2\2\u011eT\3\2\2\2\u011f\u0120\7%\2\2\u0120V\3\2\2\2"+
		"\24\2X^ehnqux~\u0083\u0088\u008b\u0090\u00ff\u0106\u010c\u0113\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}