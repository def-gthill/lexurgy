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
		NEGATION=20, WORD_BOUNDARY=21, BETWEEN_WORDS=22, CLASSREF=23, INTERSECTION=24, 
		CLASS_DECL=25, FEATURE_DECL=26, SYLLABLE_FEATURE=27, DIACRITIC=28, DIA_BEFORE=29, 
		DIA_FLOATING=30, SYMBOL=31, SYLLABLE_DECL=32, EXPLICIT_SYLLABLES=33, ANY_SYLLABLE=34, 
		DEROMANIZER=35, ROMANIZER=36, ALL_MATCHING=37, FIRST_MATCHING=38, PROPAGATE=39, 
		LITERAL=40, UNCHANGED=41, NUMBER=42, NAME=43, STR1=44, STR=45;
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
			"NEGATION", "WORD_BOUNDARY", "BETWEEN_WORDS", "CLASSREF", "INTERSECTION", 
			"CLASS_DECL", "FEATURE_DECL", "SYLLABLE_FEATURE", "DIACRITIC", "DIA_BEFORE", 
			"DIA_FLOATING", "SYMBOL", "SYLLABLE_DECL", "EXPLICIT_SYLLABLES", "ANY_SYLLABLE", 
			"DEROMANIZER", "ROMANIZER", "ALL_MATCHING", "FIRST_MATCHING", "PROPAGATE", 
			"LITERAL", "UNCHANGED", "NUMBER", "NAME", "STR1", "STR", "CHAR", "DIGIT", 
			"ANY", "COMMENT_START"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, null, "'_'", null, null, "'('", "')'", 
			"'*'", "'['", "']'", "'{'", "'}'", "'+'", "'?'", "'-'", "':'", "'!'", 
			"'$'", "'$$'", "'@'", "'&'", null, null, null, null, null, null, null, 
			"'Syllables'", "'explicit'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "COMMENT", "SEP", "CHANGE", "CONDITION", "EXCLUSION", "ANCHOR", 
			"NEWLINE", "WHITESPACE", "O_PAREN", "C_PAREN", "NULL", "MATRIX_START", 
			"MATRIX_END", "LIST_START", "LIST_END", "AT_LEAST_ONE", "OPTIONAL", "HYPHEN", 
			"RULE_START", "NEGATION", "WORD_BOUNDARY", "BETWEEN_WORDS", "CLASSREF", 
			"INTERSECTION", "CLASS_DECL", "FEATURE_DECL", "SYLLABLE_FEATURE", "DIACRITIC", 
			"DIA_BEFORE", "DIA_FLOATING", "SYMBOL", "SYLLABLE_DECL", "EXPLICIT_SYLLABLES", 
			"ANY_SYLLABLE", "DEROMANIZER", "ROMANIZER", "ALL_MATCHING", "FIRST_MATCHING", 
			"PROPAGATE", "LITERAL", "UNCHANGED", "NUMBER", "NAME", "STR1", "STR"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2/\u01f0\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\3\2\5\2g\n\2\3\2"+
		"\3\2\7\2k\n\2\f\2\16\2n\13\2\3\2\3\2\3\3\3\3\5\3t\n\3\3\4\5\4w\n\4\3\4"+
		"\3\4\3\4\3\4\5\4}\n\4\3\5\5\5\u0080\n\5\3\5\3\5\5\5\u0084\n\5\3\6\5\6"+
		"\u0087\n\6\3\6\3\6\3\6\3\6\5\6\u008d\n\6\3\7\3\7\3\b\5\b\u0092\n\b\3\b"+
		"\3\b\3\b\5\b\u0097\n\b\3\b\5\b\u009a\n\b\3\t\6\t\u009d\n\t\r\t\16\t\u009e"+
		"\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21"+
		"\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\27"+
		"\3\30\3\30\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32"+
		"\5\32\u00cc\n\32\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33"+
		"\3\33\3\33\3\33\5\33\u00dc\n\33\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34"+
		"\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\5\34\u00f2"+
		"\n\34\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35"+
		"\3\35\3\35\3\35\3\35\3\35\5\35\u0106\n\35\3\36\3\36\3\36\3\36\3\36\3\36"+
		"\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\5\36\u0118\n\36\3\37"+
		"\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37"+
		"\3\37\3\37\3\37\3\37\3\37\5\37\u012e\n\37\3 \3 \3 \3 \3 \3 \3 \3 \3 \3"+
		" \3 \3 \5 \u013c\n \3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3\"\3\"\3\"\3\"\3\""+
		"\3\"\3\"\3\"\3\"\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\5#\u015b\n#\3$\3$\3$\3"+
		"$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\5$\u0173\n$\3"+
		"%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\5%\u0187\n%\3&\3"+
		"&\3&\3&\3&\3&\3&\3&\5&\u0191\n&\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\5\'\u019b"+
		"\n\'\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\5(\u01af\n"+
		"(\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\5)\u01bf\n)\3*\3*\3*\3*\3"+
		"*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\5*\u01d3\n*\3+\6+\u01d6\n+\r"+
		"+\16+\u01d7\3,\6,\u01db\n,\r,\16,\u01dc\3-\3-\3.\6.\u01e2\n.\r.\16.\u01e3"+
		"\3/\3/\3\60\3\60\3\61\3\61\3\61\5\61\u01ed\n\61\3\62\3\62\2\2\63\3\3\5"+
		"\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21"+
		"!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!"+
		"A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\2_\2a\2c\2\3\2\7\4\2\f\f\17\17\f\2\13"+
		"\17\"\"\u0087\u0087\u00a2\u00a2\u1682\u1682\u2002\u200c\u202a\u202b\u2031"+
		"\u2031\u2061\u2061\u3002\u3002\5\2\62;C\\c|\3\2\62;\17\2\f\f\17\17\"#"+
		"%&((*/\61\61<<?B]_aa}}\177\177\2\u020b\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2"+
		"\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2"+
		"\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3"+
		"\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3"+
		"\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65"+
		"\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3"+
		"\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2"+
		"\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2"+
		"[\3\2\2\2\3f\3\2\2\2\5q\3\2\2\2\7v\3\2\2\2\t\177\3\2\2\2\13\u0086\3\2"+
		"\2\2\r\u008e\3\2\2\2\17\u0091\3\2\2\2\21\u009c\3\2\2\2\23\u00a0\3\2\2"+
		"\2\25\u00a2\3\2\2\2\27\u00a4\3\2\2\2\31\u00a6\3\2\2\2\33\u00a8\3\2\2\2"+
		"\35\u00aa\3\2\2\2\37\u00ac\3\2\2\2!\u00ae\3\2\2\2#\u00b0\3\2\2\2%\u00b2"+
		"\3\2\2\2\'\u00b4\3\2\2\2)\u00b6\3\2\2\2+\u00b8\3\2\2\2-\u00ba\3\2\2\2"+
		"/\u00bd\3\2\2\2\61\u00bf\3\2\2\2\63\u00cb\3\2\2\2\65\u00db\3\2\2\2\67"+
		"\u00f1\3\2\2\29\u0105\3\2\2\2;\u0117\3\2\2\2=\u012d\3\2\2\2?\u013b\3\2"+
		"\2\2A\u013d\3\2\2\2C\u0147\3\2\2\2E\u015a\3\2\2\2G\u0172\3\2\2\2I\u0186"+
		"\3\2\2\2K\u0190\3\2\2\2M\u019a\3\2\2\2O\u01ae\3\2\2\2Q\u01be\3\2\2\2S"+
		"\u01d2\3\2\2\2U\u01d5\3\2\2\2W\u01da\3\2\2\2Y\u01de\3\2\2\2[\u01e1\3\2"+
		"\2\2]\u01e5\3\2\2\2_\u01e7\3\2\2\2a\u01ec\3\2\2\2c\u01ee\3\2\2\2eg\5\21"+
		"\t\2fe\3\2\2\2fg\3\2\2\2gh\3\2\2\2hl\5c\62\2ik\n\2\2\2ji\3\2\2\2kn\3\2"+
		"\2\2lj\3\2\2\2lm\3\2\2\2mo\3\2\2\2nl\3\2\2\2op\b\2\2\2p\4\3\2\2\2qs\7"+
		".\2\2rt\5\21\t\2sr\3\2\2\2st\3\2\2\2t\6\3\2\2\2uw\5\21\t\2vu\3\2\2\2v"+
		"w\3\2\2\2wx\3\2\2\2xy\7?\2\2yz\7@\2\2z|\3\2\2\2{}\5\21\t\2|{\3\2\2\2|"+
		"}\3\2\2\2}\b\3\2\2\2~\u0080\5\21\t\2\177~\3\2\2\2\177\u0080\3\2\2\2\u0080"+
		"\u0081\3\2\2\2\u0081\u0083\7\61\2\2\u0082\u0084\5\21\t\2\u0083\u0082\3"+
		"\2\2\2\u0083\u0084\3\2\2\2\u0084\n\3\2\2\2\u0085\u0087\5\21\t\2\u0086"+
		"\u0085\3\2\2\2\u0086\u0087\3\2\2\2\u0087\u0088\3\2\2\2\u0088\u0089\7\61"+
		"\2\2\u0089\u008a\7\61\2\2\u008a\u008c\3\2\2\2\u008b\u008d\5\21\t\2\u008c"+
		"\u008b\3\2\2\2\u008c\u008d\3\2\2\2\u008d\f\3\2\2\2\u008e\u008f\7a\2\2"+
		"\u008f\16\3\2\2\2\u0090\u0092\5\21\t\2\u0091\u0090\3\2\2\2\u0091\u0092"+
		"\3\2\2\2\u0092\u0096\3\2\2\2\u0093\u0094\7\17\2\2\u0094\u0097\7\f\2\2"+
		"\u0095\u0097\7\f\2\2\u0096\u0093\3\2\2\2\u0096\u0095\3\2\2\2\u0097\u0099"+
		"\3\2\2\2\u0098\u009a\5\21\t\2\u0099\u0098\3\2\2\2\u0099\u009a\3\2\2\2"+
		"\u009a\20\3\2\2\2\u009b\u009d\t\3\2\2\u009c\u009b\3\2\2\2\u009d\u009e"+
		"\3\2\2\2\u009e\u009c\3\2\2\2\u009e\u009f\3\2\2\2\u009f\22\3\2\2\2\u00a0"+
		"\u00a1\7*\2\2\u00a1\24\3\2\2\2\u00a2\u00a3\7+\2\2\u00a3\26\3\2\2\2\u00a4"+
		"\u00a5\7,\2\2\u00a5\30\3\2\2\2\u00a6\u00a7\7]\2\2\u00a7\32\3\2\2\2\u00a8"+
		"\u00a9\7_\2\2\u00a9\34\3\2\2\2\u00aa\u00ab\7}\2\2\u00ab\36\3\2\2\2\u00ac"+
		"\u00ad\7\177\2\2\u00ad \3\2\2\2\u00ae\u00af\7-\2\2\u00af\"\3\2\2\2\u00b0"+
		"\u00b1\7A\2\2\u00b1$\3\2\2\2\u00b2\u00b3\7/\2\2\u00b3&\3\2\2\2\u00b4\u00b5"+
		"\7<\2\2\u00b5(\3\2\2\2\u00b6\u00b7\7#\2\2\u00b7*\3\2\2\2\u00b8\u00b9\7"+
		"&\2\2\u00b9,\3\2\2\2\u00ba\u00bb\7&\2\2\u00bb\u00bc\7&\2\2\u00bc.\3\2"+
		"\2\2\u00bd\u00be\7B\2\2\u00be\60\3\2\2\2\u00bf\u00c0\7(\2\2\u00c0\62\3"+
		"\2\2\2\u00c1\u00c2\7E\2\2\u00c2\u00c3\7n\2\2\u00c3\u00c4\7c\2\2\u00c4"+
		"\u00c5\7u\2\2\u00c5\u00cc\7u\2\2\u00c6\u00c7\7e\2\2\u00c7\u00c8\7n\2\2"+
		"\u00c8\u00c9\7c\2\2\u00c9\u00ca\7u\2\2\u00ca\u00cc\7u\2\2\u00cb\u00c1"+
		"\3\2\2\2\u00cb\u00c6\3\2\2\2\u00cc\64\3\2\2\2\u00cd\u00ce\7H\2\2\u00ce"+
		"\u00cf\7g\2\2\u00cf\u00d0\7c\2\2\u00d0\u00d1\7v\2\2\u00d1\u00d2\7w\2\2"+
		"\u00d2\u00d3\7t\2\2\u00d3\u00dc\7g\2\2\u00d4\u00d5\7h\2\2\u00d5\u00d6"+
		"\7g\2\2\u00d6\u00d7\7c\2\2\u00d7\u00d8\7v\2\2\u00d8\u00d9\7w\2\2\u00d9"+
		"\u00da\7t\2\2\u00da\u00dc\7g\2\2\u00db\u00cd\3\2\2\2\u00db\u00d4\3\2\2"+
		"\2\u00dc\66\3\2\2\2\u00dd\u00de\7*\2\2\u00de\u00df\7U\2\2\u00df\u00e0"+
		"\7{\2\2\u00e0\u00e1\7n\2\2\u00e1\u00e2\7n\2\2\u00e2\u00e3\7c\2\2\u00e3"+
		"\u00e4\7d\2\2\u00e4\u00e5\7n\2\2\u00e5\u00e6\7g\2\2\u00e6\u00f2\7+\2\2"+
		"\u00e7\u00e8\7*\2\2\u00e8\u00e9\7u\2\2\u00e9\u00ea\7{\2\2\u00ea\u00eb"+
		"\7n\2\2\u00eb\u00ec\7n\2\2\u00ec\u00ed\7c\2\2\u00ed\u00ee\7d\2\2\u00ee"+
		"\u00ef\7n\2\2\u00ef\u00f0\7g\2\2\u00f0\u00f2\7+\2\2\u00f1\u00dd\3\2\2"+
		"\2\u00f1\u00e7\3\2\2\2\u00f28\3\2\2\2\u00f3\u00f4\7F\2\2\u00f4\u00f5\7"+
		"k\2\2\u00f5\u00f6\7c\2\2\u00f6\u00f7\7e\2\2\u00f7\u00f8\7t\2\2\u00f8\u00f9"+
		"\7k\2\2\u00f9\u00fa\7v\2\2\u00fa\u00fb\7k\2\2\u00fb\u0106\7e\2\2\u00fc"+
		"\u00fd\7f\2\2\u00fd\u00fe\7k\2\2\u00fe\u00ff\7c\2\2\u00ff\u0100\7e\2\2"+
		"\u0100\u0101\7t\2\2\u0101\u0102\7k\2\2\u0102\u0103\7v\2\2\u0103\u0104"+
		"\7k\2\2\u0104\u0106\7e\2\2\u0105\u00f3\3\2\2\2\u0105\u00fc\3\2\2\2\u0106"+
		":\3\2\2\2\u0107\u0108\7*\2\2\u0108\u0109\7D\2\2\u0109\u010a\7g\2\2\u010a"+
		"\u010b\7h\2\2\u010b\u010c\7q\2\2\u010c\u010d\7t\2\2\u010d\u010e\7g\2\2"+
		"\u010e\u0118\7+\2\2\u010f\u0110\7*\2\2\u0110\u0111\7d\2\2\u0111\u0112"+
		"\7g\2\2\u0112\u0113\7h\2\2\u0113\u0114\7q\2\2\u0114\u0115\7t\2\2\u0115"+
		"\u0116\7g\2\2\u0116\u0118\7+\2\2\u0117\u0107\3\2\2\2\u0117\u010f\3\2\2"+
		"\2\u0118<\3\2\2\2\u0119\u011a\7*\2\2\u011a\u011b\7H\2\2\u011b\u011c\7"+
		"n\2\2\u011c\u011d\7q\2\2\u011d\u011e\7c\2\2\u011e\u011f\7v\2\2\u011f\u0120"+
		"\7k\2\2\u0120\u0121\7p\2\2\u0121\u0122\7i\2\2\u0122\u012e\7+\2\2\u0123"+
		"\u0124\7*\2\2\u0124\u0125\7h\2\2\u0125\u0126\7n\2\2\u0126\u0127\7q\2\2"+
		"\u0127\u0128\7c\2\2\u0128\u0129\7v\2\2\u0129\u012a\7k\2\2\u012a\u012b"+
		"\7p\2\2\u012b\u012c\7i\2\2\u012c\u012e\7+\2\2\u012d\u0119\3\2\2\2\u012d"+
		"\u0123\3\2\2\2\u012e>\3\2\2\2\u012f\u0130\7U\2\2\u0130\u0131\7{\2\2\u0131"+
		"\u0132\7o\2\2\u0132\u0133\7d\2\2\u0133\u0134\7q\2\2\u0134\u013c\7n\2\2"+
		"\u0135\u0136\7u\2\2\u0136\u0137\7{\2\2\u0137\u0138\7o\2\2\u0138\u0139"+
		"\7d\2\2\u0139\u013a\7q\2\2\u013a\u013c\7n\2\2\u013b\u012f\3\2\2\2\u013b"+
		"\u0135\3\2\2\2\u013c@\3\2\2\2\u013d\u013e\7U\2\2\u013e\u013f\7{\2\2\u013f"+
		"\u0140\7n\2\2\u0140\u0141\7n\2\2\u0141\u0142\7c\2\2\u0142\u0143\7d\2\2"+
		"\u0143\u0144\7n\2\2\u0144\u0145\7g\2\2\u0145\u0146\7u\2\2\u0146B\3\2\2"+
		"\2\u0147\u0148\7g\2\2\u0148\u0149\7z\2\2\u0149\u014a\7r\2\2\u014a\u014b"+
		"\7n\2\2\u014b\u014c\7k\2\2\u014c\u014d\7e\2\2\u014d\u014e\7k\2\2\u014e"+
		"\u014f\7v\2\2\u014fD\3\2\2\2\u0150\u0151\7>\2\2\u0151\u0152\7U\2\2\u0152"+
		"\u0153\7{\2\2\u0153\u0154\7n\2\2\u0154\u015b\7@\2\2\u0155\u0156\7>\2\2"+
		"\u0156\u0157\7u\2\2\u0157\u0158\7{\2\2\u0158\u0159\7n\2\2\u0159\u015b"+
		"\7@\2\2\u015a\u0150\3\2\2\2\u015a\u0155\3\2\2\2\u015bF\3\2\2\2\u015c\u015d"+
		"\7F\2\2\u015d\u015e\7g\2\2\u015e\u015f\7t\2\2\u015f\u0160\7q\2\2\u0160"+
		"\u0161\7o\2\2\u0161\u0162\7c\2\2\u0162\u0163\7p\2\2\u0163\u0164\7k\2\2"+
		"\u0164\u0165\7|\2\2\u0165\u0166\7g\2\2\u0166\u0173\7t\2\2\u0167\u0168"+
		"\7f\2\2\u0168\u0169\7g\2\2\u0169\u016a\7t\2\2\u016a\u016b\7q\2\2\u016b"+
		"\u016c\7o\2\2\u016c\u016d\7c\2\2\u016d\u016e\7p\2\2\u016e\u016f\7k\2\2"+
		"\u016f\u0170\7|\2\2\u0170\u0171\7g\2\2\u0171\u0173\7t\2\2\u0172\u015c"+
		"\3\2\2\2\u0172\u0167\3\2\2\2\u0173H\3\2\2\2\u0174\u0175\7T\2\2\u0175\u0176"+
		"\7q\2\2\u0176\u0177\7o\2\2\u0177\u0178\7c\2\2\u0178\u0179\7p\2\2\u0179"+
		"\u017a\7k\2\2\u017a\u017b\7|\2\2\u017b\u017c\7g\2\2\u017c\u0187\7t\2\2"+
		"\u017d\u017e\7t\2\2\u017e\u017f\7q\2\2\u017f\u0180\7o\2\2\u0180\u0181"+
		"\7c\2\2\u0181\u0182\7p\2\2\u0182\u0183\7k\2\2\u0183\u0184\7|\2\2\u0184"+
		"\u0185\7g\2\2\u0185\u0187\7t\2\2\u0186\u0174\3\2\2\2\u0186\u017d\3\2\2"+
		"\2\u0187J\3\2\2\2\u0188\u0189\7V\2\2\u0189\u018a\7j\2\2\u018a\u018b\7"+
		"g\2\2\u018b\u0191\7p\2\2\u018c\u018d\7v\2\2\u018d\u018e\7j\2\2\u018e\u018f"+
		"\7g\2\2\u018f\u0191\7p\2\2\u0190\u0188\3\2\2\2\u0190\u018c\3\2\2\2\u0191"+
		"L\3\2\2\2\u0192\u0193\7G\2\2\u0193\u0194\7n\2\2\u0194\u0195\7u\2\2\u0195"+
		"\u019b\7g\2\2\u0196\u0197\7g\2\2\u0197\u0198\7n\2\2\u0198\u0199\7u\2\2"+
		"\u0199\u019b\7g\2\2\u019a\u0192\3\2\2\2\u019a\u0196\3\2\2\2\u019bN\3\2"+
		"\2\2\u019c\u019d\7R\2\2\u019d\u019e\7t\2\2\u019e\u019f\7q\2\2\u019f\u01a0"+
		"\7r\2\2\u01a0\u01a1\7c\2\2\u01a1\u01a2\7i\2\2\u01a2\u01a3\7c\2\2\u01a3"+
		"\u01a4\7v\2\2\u01a4\u01af\7g\2\2\u01a5\u01a6\7r\2\2\u01a6\u01a7\7t\2\2"+
		"\u01a7\u01a8\7q\2\2\u01a8\u01a9\7r\2\2\u01a9\u01aa\7c\2\2\u01aa\u01ab"+
		"\7i\2\2\u01ab\u01ac\7c\2\2\u01ac\u01ad\7v\2\2\u01ad\u01af\7g\2\2\u01ae"+
		"\u019c\3\2\2\2\u01ae\u01a5\3\2\2\2\u01afP\3\2\2\2\u01b0\u01b1\7N\2\2\u01b1"+
		"\u01b2\7k\2\2\u01b2\u01b3\7v\2\2\u01b3\u01b4\7g\2\2\u01b4\u01b5\7t\2\2"+
		"\u01b5\u01b6\7c\2\2\u01b6\u01bf\7n\2\2\u01b7\u01b8\7n\2\2\u01b8\u01b9"+
		"\7k\2\2\u01b9\u01ba\7v\2\2\u01ba\u01bb\7g\2\2\u01bb\u01bc\7t\2\2\u01bc"+
		"\u01bd\7c\2\2\u01bd\u01bf\7n\2\2\u01be\u01b0\3\2\2\2\u01be\u01b7\3\2\2"+
		"\2\u01bfR\3\2\2\2\u01c0\u01c1\7W\2\2\u01c1\u01c2\7p\2\2\u01c2\u01c3\7"+
		"e\2\2\u01c3\u01c4\7j\2\2\u01c4\u01c5\7c\2\2\u01c5\u01c6\7p\2\2\u01c6\u01c7"+
		"\7i\2\2\u01c7\u01c8\7g\2\2\u01c8\u01d3\7f\2\2\u01c9\u01ca\7w\2\2\u01ca"+
		"\u01cb\7p\2\2\u01cb\u01cc\7e\2\2\u01cc\u01cd\7j\2\2\u01cd\u01ce\7c\2\2"+
		"\u01ce\u01cf\7p\2\2\u01cf\u01d0\7i\2\2\u01d0\u01d1\7g\2\2\u01d1\u01d3"+
		"\7f\2\2\u01d2\u01c0\3\2\2\2\u01d2\u01c9\3\2\2\2\u01d3T\3\2\2\2\u01d4\u01d6"+
		"\5_\60\2\u01d5\u01d4\3\2\2\2\u01d6\u01d7\3\2\2\2\u01d7\u01d5\3\2\2\2\u01d7"+
		"\u01d8\3\2\2\2\u01d8V\3\2\2\2\u01d9\u01db\5]/\2\u01da\u01d9\3\2\2\2\u01db"+
		"\u01dc\3\2\2\2\u01dc\u01da\3\2\2\2\u01dc\u01dd\3\2\2\2\u01ddX\3\2\2\2"+
		"\u01de\u01df\5a\61\2\u01dfZ\3\2\2\2\u01e0\u01e2\5a\61\2\u01e1\u01e0\3"+
		"\2\2\2\u01e2\u01e3\3\2\2\2\u01e3\u01e1\3\2\2\2\u01e3\u01e4\3\2\2\2\u01e4"+
		"\\\3\2\2\2\u01e5\u01e6\t\4\2\2\u01e6^\3\2\2\2\u01e7\u01e8\t\5\2\2\u01e8"+
		"`\3\2\2\2\u01e9\u01ea\7^\2\2\u01ea\u01ed\13\2\2\2\u01eb\u01ed\n\6\2\2"+
		"\u01ec\u01e9\3\2\2\2\u01ec\u01eb\3\2\2\2\u01edb\3\2\2\2\u01ee\u01ef\7"+
		"%\2\2\u01efd\3\2\2\2#\2flsv|\177\u0083\u0086\u008c\u0091\u0096\u0099\u009e"+
		"\u00cb\u00db\u00f1\u0105\u0117\u012d\u013b\u015a\u0172\u0186\u0190\u019a"+
		"\u01ae\u01be\u01d2\u01d7\u01dc\u01e3\u01ec\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}