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
		ROMANIZER=30, SUBRULE=31, PROPAGATE=32, LITERAL=33, UNCHANGED=34, FEATURE=35, 
		VALUE=36, NUMBER=37, STR1=38, STR=39;
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
			"SUBRULE", "PROPAGATE", "LITERAL", "UNCHANGED", "FEATURE", "VALUE", "NUMBER", 
			"STR1", "STR", "UPPER", "LOWER", "CHAR", "DIGIT", "ANY", "COMMENT_START"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2)\u01b1\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\3\2\5\2_\n\2\3\2\3\2\7\2c\n\2\f\2\16\2f\13\2\3\2\3\2"+
		"\3\3\3\3\5\3l\n\3\3\4\5\4o\n\4\3\4\3\4\3\4\3\4\5\4u\n\4\3\5\5\5x\n\5\3"+
		"\5\3\5\5\5|\n\5\3\6\5\6\177\n\6\3\6\3\6\3\6\3\6\5\6\u0085\n\6\3\7\3\7"+
		"\3\b\5\b\u008a\n\b\3\b\3\b\3\b\5\b\u008f\n\b\3\b\5\b\u0092\n\b\3\t\6\t"+
		"\u0095\n\t\r\t\16\t\u0096\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16"+
		"\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25"+
		"\3\26\3\26\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\5\30\u00bf\n\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31"+
		"\3\31\3\31\3\31\5\31\u00cf\n\31\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32"+
		"\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\5\32\u00e3\n\32\3\33"+
		"\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33"+
		"\3\33\5\33\u00f5\n\33\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34"+
		"\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\5\34\u010b\n\34\3\35"+
		"\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\5\35\u0119\n\35"+
		"\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36"+
		"\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\5\36\u0131\n\36\3\37\3\37\3\37"+
		"\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37"+
		"\3\37\5\37\u0145\n\37\3 \3 \3 \3 \3 \3 \3 \3 \5 \u014f\n \3!\3!\3!\3!"+
		"\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\5!\u0163\n!\3\"\3\"\3\"\3\""+
		"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\5\"\u0173\n\"\3#\3#\3#\3#\3#"+
		"\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\5#\u0187\n#\3$\3$\7$\u018b\n$"+
		"\f$\16$\u018e\13$\3%\3%\7%\u0192\n%\f%\16%\u0195\13%\3&\6&\u0198\n&\r"+
		"&\16&\u0199\3\'\3\'\3(\6(\u019f\n(\r(\16(\u01a0\3)\3)\3*\3*\3+\3+\3,\3"+
		",\3-\3-\3-\5-\u01ae\n-\3.\3.\2\2/\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23"+
		"\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31"+
		"\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q\2S\2U\2W\2Y\2"+
		"[\2\3\2\t\4\2\f\f\17\17\f\2\13\17\"\"\u0087\u0087\u00a2\u00a2\u1682\u1682"+
		"\u2002\u200c\u202a\u202b\u2031\u2031\u2061\u2061\u3002\u3002\3\2C\\\3"+
		"\2c|\5\2\62;C\\c|\3\2\62;\16\2\f\f\17\17\"#%&*/\61\61<<?B]_aa}}\177\177"+
		"\2\u01c8\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2"+
		"\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27"+
		"\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2"+
		"\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2"+
		"\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2"+
		"\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2"+
		"\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\3^\3\2\2\2\5i"+
		"\3\2\2\2\7n\3\2\2\2\tw\3\2\2\2\13~\3\2\2\2\r\u0086\3\2\2\2\17\u0089\3"+
		"\2\2\2\21\u0094\3\2\2\2\23\u0098\3\2\2\2\25\u009a\3\2\2\2\27\u009c\3\2"+
		"\2\2\31\u009e\3\2\2\2\33\u00a0\3\2\2\2\35\u00a2\3\2\2\2\37\u00a4\3\2\2"+
		"\2!\u00a6\3\2\2\2#\u00a8\3\2\2\2%\u00aa\3\2\2\2\'\u00ac\3\2\2\2)\u00ae"+
		"\3\2\2\2+\u00b0\3\2\2\2-\u00b2\3\2\2\2/\u00be\3\2\2\2\61\u00ce\3\2\2\2"+
		"\63\u00e2\3\2\2\2\65\u00f4\3\2\2\2\67\u010a\3\2\2\29\u0118\3\2\2\2;\u0130"+
		"\3\2\2\2=\u0144\3\2\2\2?\u014e\3\2\2\2A\u0162\3\2\2\2C\u0172\3\2\2\2E"+
		"\u0186\3\2\2\2G\u0188\3\2\2\2I\u018f\3\2\2\2K\u0197\3\2\2\2M\u019b\3\2"+
		"\2\2O\u019e\3\2\2\2Q\u01a2\3\2\2\2S\u01a4\3\2\2\2U\u01a6\3\2\2\2W\u01a8"+
		"\3\2\2\2Y\u01ad\3\2\2\2[\u01af\3\2\2\2]_\5\21\t\2^]\3\2\2\2^_\3\2\2\2"+
		"_`\3\2\2\2`d\5[.\2ac\n\2\2\2ba\3\2\2\2cf\3\2\2\2db\3\2\2\2de\3\2\2\2e"+
		"g\3\2\2\2fd\3\2\2\2gh\b\2\2\2h\4\3\2\2\2ik\7.\2\2jl\5\21\t\2kj\3\2\2\2"+
		"kl\3\2\2\2l\6\3\2\2\2mo\5\21\t\2nm\3\2\2\2no\3\2\2\2op\3\2\2\2pq\7?\2"+
		"\2qr\7@\2\2rt\3\2\2\2su\5\21\t\2ts\3\2\2\2tu\3\2\2\2u\b\3\2\2\2vx\5\21"+
		"\t\2wv\3\2\2\2wx\3\2\2\2xy\3\2\2\2y{\7\61\2\2z|\5\21\t\2{z\3\2\2\2{|\3"+
		"\2\2\2|\n\3\2\2\2}\177\5\21\t\2~}\3\2\2\2~\177\3\2\2\2\177\u0080\3\2\2"+
		"\2\u0080\u0081\7\61\2\2\u0081\u0082\7\61\2\2\u0082\u0084\3\2\2\2\u0083"+
		"\u0085\5\21\t\2\u0084\u0083\3\2\2\2\u0084\u0085\3\2\2\2\u0085\f\3\2\2"+
		"\2\u0086\u0087\7a\2\2\u0087\16\3\2\2\2\u0088\u008a\5\21\t\2\u0089\u0088"+
		"\3\2\2\2\u0089\u008a\3\2\2\2\u008a\u008e\3\2\2\2\u008b\u008c\7\17\2\2"+
		"\u008c\u008f\7\f\2\2\u008d\u008f\7\f\2\2\u008e\u008b\3\2\2\2\u008e\u008d"+
		"\3\2\2\2\u008f\u0091\3\2\2\2\u0090\u0092\5\21\t\2\u0091\u0090\3\2\2\2"+
		"\u0091\u0092\3\2\2\2\u0092\20\3\2\2\2\u0093\u0095\t\3\2\2\u0094\u0093"+
		"\3\2\2\2\u0095\u0096\3\2\2\2\u0096\u0094\3\2\2\2\u0096\u0097\3\2\2\2\u0097"+
		"\22\3\2\2\2\u0098\u0099\7*\2\2\u0099\24\3\2\2\2\u009a\u009b\7+\2\2\u009b"+
		"\26\3\2\2\2\u009c\u009d\7,\2\2\u009d\30\3\2\2\2\u009e\u009f\7]\2\2\u009f"+
		"\32\3\2\2\2\u00a0\u00a1\7_\2\2\u00a1\34\3\2\2\2\u00a2\u00a3\7}\2\2\u00a3"+
		"\36\3\2\2\2\u00a4\u00a5\7\177\2\2\u00a5 \3\2\2\2\u00a6\u00a7\7-\2\2\u00a7"+
		"\"\3\2\2\2\u00a8\u00a9\7A\2\2\u00a9$\3\2\2\2\u00aa\u00ab\7/\2\2\u00ab"+
		"&\3\2\2\2\u00ac\u00ad\7<\2\2\u00ad(\3\2\2\2\u00ae\u00af\7#\2\2\u00af*"+
		"\3\2\2\2\u00b0\u00b1\7&\2\2\u00b1,\3\2\2\2\u00b2\u00b3\7B\2\2\u00b3.\3"+
		"\2\2\2\u00b4\u00b5\7E\2\2\u00b5\u00b6\7n\2\2\u00b6\u00b7\7c\2\2\u00b7"+
		"\u00b8\7u\2\2\u00b8\u00bf\7u\2\2\u00b9\u00ba\7e\2\2\u00ba\u00bb\7n\2\2"+
		"\u00bb\u00bc\7c\2\2\u00bc\u00bd\7u\2\2\u00bd\u00bf\7u\2\2\u00be\u00b4"+
		"\3\2\2\2\u00be\u00b9\3\2\2\2\u00bf\60\3\2\2\2\u00c0\u00c1\7H\2\2\u00c1"+
		"\u00c2\7g\2\2\u00c2\u00c3\7c\2\2\u00c3\u00c4\7v\2\2\u00c4\u00c5\7w\2\2"+
		"\u00c5\u00c6\7t\2\2\u00c6\u00cf\7g\2\2\u00c7\u00c8\7h\2\2\u00c8\u00c9"+
		"\7g\2\2\u00c9\u00ca\7c\2\2\u00ca\u00cb\7v\2\2\u00cb\u00cc\7w\2\2\u00cc"+
		"\u00cd\7t\2\2\u00cd\u00cf\7g\2\2\u00ce\u00c0\3\2\2\2\u00ce\u00c7\3\2\2"+
		"\2\u00cf\62\3\2\2\2\u00d0\u00d1\7F\2\2\u00d1\u00d2\7k\2\2\u00d2\u00d3"+
		"\7c\2\2\u00d3\u00d4\7e\2\2\u00d4\u00d5\7t\2\2\u00d5\u00d6\7k\2\2\u00d6"+
		"\u00d7\7v\2\2\u00d7\u00d8\7k\2\2\u00d8\u00e3\7e\2\2\u00d9\u00da\7f\2\2"+
		"\u00da\u00db\7k\2\2\u00db\u00dc\7c\2\2\u00dc\u00dd\7e\2\2\u00dd\u00de"+
		"\7t\2\2\u00de\u00df\7k\2\2\u00df\u00e0\7v\2\2\u00e0\u00e1\7k\2\2\u00e1"+
		"\u00e3\7e\2\2\u00e2\u00d0\3\2\2\2\u00e2\u00d9\3\2\2\2\u00e3\64\3\2\2\2"+
		"\u00e4\u00e5\7*\2\2\u00e5\u00e6\7D\2\2\u00e6\u00e7\7g\2\2\u00e7\u00e8"+
		"\7h\2\2\u00e8\u00e9\7q\2\2\u00e9\u00ea\7t\2\2\u00ea\u00eb\7g\2\2\u00eb"+
		"\u00f5\7+\2\2\u00ec\u00ed\7*\2\2\u00ed\u00ee\7d\2\2\u00ee\u00ef\7g\2\2"+
		"\u00ef\u00f0\7h\2\2\u00f0\u00f1\7q\2\2\u00f1\u00f2\7t\2\2\u00f2\u00f3"+
		"\7g\2\2\u00f3\u00f5\7+\2\2\u00f4\u00e4\3\2\2\2\u00f4\u00ec\3\2\2\2\u00f5"+
		"\66\3\2\2\2\u00f6\u00f7\7*\2\2\u00f7\u00f8\7H\2\2\u00f8\u00f9\7n\2\2\u00f9"+
		"\u00fa\7q\2\2\u00fa\u00fb\7c\2\2\u00fb\u00fc\7v\2\2\u00fc\u00fd\7k\2\2"+
		"\u00fd\u00fe\7p\2\2\u00fe\u00ff\7i\2\2\u00ff\u010b\7+\2\2\u0100\u0101"+
		"\7*\2\2\u0101\u0102\7h\2\2\u0102\u0103\7n\2\2\u0103\u0104\7q\2\2\u0104"+
		"\u0105\7c\2\2\u0105\u0106\7v\2\2\u0106\u0107\7k\2\2\u0107\u0108\7p\2\2"+
		"\u0108\u0109\7i\2\2\u0109\u010b\7+\2\2\u010a\u00f6\3\2\2\2\u010a\u0100"+
		"\3\2\2\2\u010b8\3\2\2\2\u010c\u010d\7U\2\2\u010d\u010e\7{\2\2\u010e\u010f"+
		"\7o\2\2\u010f\u0110\7d\2\2\u0110\u0111\7q\2\2\u0111\u0119\7n\2\2\u0112"+
		"\u0113\7u\2\2\u0113\u0114\7{\2\2\u0114\u0115\7o\2\2\u0115\u0116\7d\2\2"+
		"\u0116\u0117\7q\2\2\u0117\u0119\7n\2\2\u0118\u010c\3\2\2\2\u0118\u0112"+
		"\3\2\2\2\u0119:\3\2\2\2\u011a\u011b\7F\2\2\u011b\u011c\7g\2\2\u011c\u011d"+
		"\7t\2\2\u011d\u011e\7q\2\2\u011e\u011f\7o\2\2\u011f\u0120\7c\2\2\u0120"+
		"\u0121\7p\2\2\u0121\u0122\7k\2\2\u0122\u0123\7|\2\2\u0123\u0124\7g\2\2"+
		"\u0124\u0131\7t\2\2\u0125\u0126\7f\2\2\u0126\u0127\7g\2\2\u0127\u0128"+
		"\7t\2\2\u0128\u0129\7q\2\2\u0129\u012a\7o\2\2\u012a\u012b\7c\2\2\u012b"+
		"\u012c\7p\2\2\u012c\u012d\7k\2\2\u012d\u012e\7|\2\2\u012e\u012f\7g\2\2"+
		"\u012f\u0131\7t\2\2\u0130\u011a\3\2\2\2\u0130\u0125\3\2\2\2\u0131<\3\2"+
		"\2\2\u0132\u0133\7T\2\2\u0133\u0134\7q\2\2\u0134\u0135\7o\2\2\u0135\u0136"+
		"\7c\2\2\u0136\u0137\7p\2\2\u0137\u0138\7k\2\2\u0138\u0139\7|\2\2\u0139"+
		"\u013a\7g\2\2\u013a\u0145\7t\2\2\u013b\u013c\7t\2\2\u013c\u013d\7q\2\2"+
		"\u013d\u013e\7o\2\2\u013e\u013f\7c\2\2\u013f\u0140\7p\2\2\u0140\u0141"+
		"\7k\2\2\u0141\u0142\7|\2\2\u0142\u0143\7g\2\2\u0143\u0145\7t\2\2\u0144"+
		"\u0132\3\2\2\2\u0144\u013b\3\2\2\2\u0145>\3\2\2\2\u0146\u0147\7V\2\2\u0147"+
		"\u0148\7j\2\2\u0148\u0149\7g\2\2\u0149\u014f\7p\2\2\u014a\u014b\7v\2\2"+
		"\u014b\u014c\7j\2\2\u014c\u014d\7g\2\2\u014d\u014f\7p\2\2\u014e\u0146"+
		"\3\2\2\2\u014e\u014a\3\2\2\2\u014f@\3\2\2\2\u0150\u0151\7R\2\2\u0151\u0152"+
		"\7t\2\2\u0152\u0153\7q\2\2\u0153\u0154\7r\2\2\u0154\u0155\7c\2\2\u0155"+
		"\u0156\7i\2\2\u0156\u0157\7c\2\2\u0157\u0158\7v\2\2\u0158\u0163\7g\2\2"+
		"\u0159\u015a\7r\2\2\u015a\u015b\7t\2\2\u015b\u015c\7q\2\2\u015c\u015d"+
		"\7r\2\2\u015d\u015e\7c\2\2\u015e\u015f\7i\2\2\u015f\u0160\7c\2\2\u0160"+
		"\u0161\7v\2\2\u0161\u0163\7g\2\2\u0162\u0150\3\2\2\2\u0162\u0159\3\2\2"+
		"\2\u0163B\3\2\2\2\u0164\u0165\7N\2\2\u0165\u0166\7k\2\2\u0166\u0167\7"+
		"v\2\2\u0167\u0168\7g\2\2\u0168\u0169\7t\2\2\u0169\u016a\7c\2\2\u016a\u0173"+
		"\7n\2\2\u016b\u016c\7n\2\2\u016c\u016d\7k\2\2\u016d\u016e\7v\2\2\u016e"+
		"\u016f\7g\2\2\u016f\u0170\7t\2\2\u0170\u0171\7c\2\2\u0171\u0173\7n\2\2"+
		"\u0172\u0164\3\2\2\2\u0172\u016b\3\2\2\2\u0173D\3\2\2\2\u0174\u0175\7"+
		"W\2\2\u0175\u0176\7p\2\2\u0176\u0177\7e\2\2\u0177\u0178\7j\2\2\u0178\u0179"+
		"\7c\2\2\u0179\u017a\7p\2\2\u017a\u017b\7i\2\2\u017b\u017c\7g\2\2\u017c"+
		"\u0187\7f\2\2\u017d\u017e\7w\2\2\u017e\u017f\7p\2\2\u017f\u0180\7e\2\2"+
		"\u0180\u0181\7j\2\2\u0181\u0182\7c\2\2\u0182\u0183\7p\2\2\u0183\u0184"+
		"\7i\2\2\u0184\u0185\7g\2\2\u0185\u0187\7f\2\2\u0186\u0174\3\2\2\2\u0186"+
		"\u017d\3\2\2\2\u0187F\3\2\2\2\u0188\u018c\5Q)\2\u0189\u018b\5U+\2\u018a"+
		"\u0189\3\2\2\2\u018b\u018e\3\2\2\2\u018c\u018a\3\2\2\2\u018c\u018d\3\2"+
		"\2\2\u018dH\3\2\2\2\u018e\u018c\3\2\2\2\u018f\u0193\5S*\2\u0190\u0192"+
		"\5U+\2\u0191\u0190\3\2\2\2\u0192\u0195\3\2\2\2\u0193\u0191\3\2\2\2\u0193"+
		"\u0194\3\2\2\2\u0194J\3\2\2\2\u0195\u0193\3\2\2\2\u0196\u0198\5W,\2\u0197"+
		"\u0196\3\2\2\2\u0198\u0199\3\2\2\2\u0199\u0197\3\2\2\2\u0199\u019a\3\2"+
		"\2\2\u019aL\3\2\2\2\u019b\u019c\5Y-\2\u019cN\3\2\2\2\u019d\u019f\5Y-\2"+
		"\u019e\u019d\3\2\2\2\u019f\u01a0\3\2\2\2\u01a0\u019e\3\2\2\2\u01a0\u01a1"+
		"\3\2\2\2\u01a1P\3\2\2\2\u01a2\u01a3\t\4\2\2\u01a3R\3\2\2\2\u01a4\u01a5"+
		"\t\5\2\2\u01a5T\3\2\2\2\u01a6\u01a7\t\6\2\2\u01a7V\3\2\2\2\u01a8\u01a9"+
		"\t\7\2\2\u01a9X\3\2\2\2\u01aa\u01ab\7^\2\2\u01ab\u01ae\13\2\2\2\u01ac"+
		"\u01ae\n\b\2\2\u01ad\u01aa\3\2\2\2\u01ad\u01ac\3\2\2\2\u01aeZ\3\2\2\2"+
		"\u01af\u01b0\7%\2\2\u01b0\\\3\2\2\2!\2^dkntw{~\u0084\u0089\u008e\u0091"+
		"\u0096\u00be\u00ce\u00e2\u00f4\u010a\u0118\u0130\u0144\u014e\u0162\u0172"+
		"\u0186\u018c\u0193\u0199\u01a0\u01ad\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}