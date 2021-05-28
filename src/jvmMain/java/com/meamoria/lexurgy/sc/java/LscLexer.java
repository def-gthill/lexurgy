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
		CLASS_DECL=25, FEATURE_DECL=26, DIACRITIC=27, DIA_BEFORE=28, DIA_FLOATING=29, 
		SYMBOL=30, DEROMANIZER=31, ROMANIZER=32, ALL_MATCHING=33, FIRST_MATCHING=34, 
		PROPAGATE=35, LITERAL=36, UNCHANGED=37, NUMBER=38, NAME=39, STR1=40, STR=41;
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
			"CLASS_DECL", "FEATURE_DECL", "DIACRITIC", "DIA_BEFORE", "DIA_FLOATING", 
			"SYMBOL", "DEROMANIZER", "ROMANIZER", "ALL_MATCHING", "FIRST_MATCHING", 
			"PROPAGATE", "LITERAL", "UNCHANGED", "NUMBER", "NAME", "STR1", "STR", 
			"CHAR", "DIGIT", "ANY", "COMMENT_START"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, null, "'_'", null, null, "'('", "')'", 
			"'*'", "'['", "']'", "'{'", "'}'", "'+'", "'?'", "'-'", "':'", "'!'", 
			"'$'", "'$$'", "'@'", "'&'"
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
			"DIA_FLOATING", "SYMBOL", "DEROMANIZER", "ROMANIZER", "ALL_MATCHING", 
			"FIRST_MATCHING", "PROPAGATE", "LITERAL", "UNCHANGED", "NUMBER", "NAME", 
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2+\u01b3\b\1\4\2\t"+
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
		"\3\26\3\26\3\27\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\32\3\32\3\32"+
		"\3\32\3\32\3\32\3\32\3\32\5\32\u00c4\n\32\3\33\3\33\3\33\3\33\3\33\3\33"+
		"\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\5\33\u00d4\n\33\3\34\3\34\3\34"+
		"\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34"+
		"\3\34\5\34\u00e8\n\34\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35"+
		"\3\35\3\35\3\35\3\35\3\35\3\35\5\35\u00fa\n\35\3\36\3\36\3\36\3\36\3\36"+
		"\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36"+
		"\3\36\5\36\u0110\n\36\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37"+
		"\3\37\3\37\5\37\u011e\n\37\3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3"+
		" \3 \3 \3 \3 \3 \3 \3 \5 \u0136\n \3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3"+
		"!\3!\3!\3!\3!\3!\3!\5!\u014a\n!\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\5\"\u0154"+
		"\n\"\3#\3#\3#\3#\3#\3#\3#\3#\5#\u015e\n#\3$\3$\3$\3$\3$\3$\3$\3$\3$\3"+
		"$\3$\3$\3$\3$\3$\3$\3$\3$\5$\u0172\n$\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3"+
		"%\3%\3%\3%\5%\u0182\n%\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3"+
		"&\3&\3&\5&\u0196\n&\3\'\6\'\u0199\n\'\r\'\16\'\u019a\3(\6(\u019e\n(\r"+
		"(\16(\u019f\3)\3)\3*\6*\u01a5\n*\r*\16*\u01a6\3+\3+\3,\3,\3-\3-\3-\5-"+
		"\u01b0\n-\3.\3.\2\2/\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27"+
		"\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33"+
		"\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U\2W\2Y\2[\2\3\2\7\4\2\f"+
		"\f\17\17\f\2\13\17\"\"\u0087\u0087\u00a2\u00a2\u1682\u1682\u2002\u200c"+
		"\u202a\u202b\u2031\u2031\u2061\u2061\u3002\u3002\5\2\62;C\\c|\3\2\62;"+
		"\17\2\f\f\17\17\"#%&((*/\61\61<<?B]_aa}}\177\177\2\u01cc\2\3\3\2\2\2\2"+
		"\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2"+
		"\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2"+
		"\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2"+
		"\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2"+
		"\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2"+
		"\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2"+
		"K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\3^\3\2\2\2\5i\3"+
		"\2\2\2\7n\3\2\2\2\tw\3\2\2\2\13~\3\2\2\2\r\u0086\3\2\2\2\17\u0089\3\2"+
		"\2\2\21\u0094\3\2\2\2\23\u0098\3\2\2\2\25\u009a\3\2\2\2\27\u009c\3\2\2"+
		"\2\31\u009e\3\2\2\2\33\u00a0\3\2\2\2\35\u00a2\3\2\2\2\37\u00a4\3\2\2\2"+
		"!\u00a6\3\2\2\2#\u00a8\3\2\2\2%\u00aa\3\2\2\2\'\u00ac\3\2\2\2)\u00ae\3"+
		"\2\2\2+\u00b0\3\2\2\2-\u00b2\3\2\2\2/\u00b5\3\2\2\2\61\u00b7\3\2\2\2\63"+
		"\u00c3\3\2\2\2\65\u00d3\3\2\2\2\67\u00e7\3\2\2\29\u00f9\3\2\2\2;\u010f"+
		"\3\2\2\2=\u011d\3\2\2\2?\u0135\3\2\2\2A\u0149\3\2\2\2C\u0153\3\2\2\2E"+
		"\u015d\3\2\2\2G\u0171\3\2\2\2I\u0181\3\2\2\2K\u0195\3\2\2\2M\u0198\3\2"+
		"\2\2O\u019d\3\2\2\2Q\u01a1\3\2\2\2S\u01a4\3\2\2\2U\u01a8\3\2\2\2W\u01aa"+
		"\3\2\2\2Y\u01af\3\2\2\2[\u01b1\3\2\2\2]_\5\21\t\2^]\3\2\2\2^_\3\2\2\2"+
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
		"\3\2\2\2\u00b0\u00b1\7&\2\2\u00b1,\3\2\2\2\u00b2\u00b3\7&\2\2\u00b3\u00b4"+
		"\7&\2\2\u00b4.\3\2\2\2\u00b5\u00b6\7B\2\2\u00b6\60\3\2\2\2\u00b7\u00b8"+
		"\7(\2\2\u00b8\62\3\2\2\2\u00b9\u00ba\7E\2\2\u00ba\u00bb\7n\2\2\u00bb\u00bc"+
		"\7c\2\2\u00bc\u00bd\7u\2\2\u00bd\u00c4\7u\2\2\u00be\u00bf\7e\2\2\u00bf"+
		"\u00c0\7n\2\2\u00c0\u00c1\7c\2\2\u00c1\u00c2\7u\2\2\u00c2\u00c4\7u\2\2"+
		"\u00c3\u00b9\3\2\2\2\u00c3\u00be\3\2\2\2\u00c4\64\3\2\2\2\u00c5\u00c6"+
		"\7H\2\2\u00c6\u00c7\7g\2\2\u00c7\u00c8\7c\2\2\u00c8\u00c9\7v\2\2\u00c9"+
		"\u00ca\7w\2\2\u00ca\u00cb\7t\2\2\u00cb\u00d4\7g\2\2\u00cc\u00cd\7h\2\2"+
		"\u00cd\u00ce\7g\2\2\u00ce\u00cf\7c\2\2\u00cf\u00d0\7v\2\2\u00d0\u00d1"+
		"\7w\2\2\u00d1\u00d2\7t\2\2\u00d2\u00d4\7g\2\2\u00d3\u00c5\3\2\2\2\u00d3"+
		"\u00cc\3\2\2\2\u00d4\66\3\2\2\2\u00d5\u00d6\7F\2\2\u00d6\u00d7\7k\2\2"+
		"\u00d7\u00d8\7c\2\2\u00d8\u00d9\7e\2\2\u00d9\u00da\7t\2\2\u00da\u00db"+
		"\7k\2\2\u00db\u00dc\7v\2\2\u00dc\u00dd\7k\2\2\u00dd\u00e8\7e\2\2\u00de"+
		"\u00df\7f\2\2\u00df\u00e0\7k\2\2\u00e0\u00e1\7c\2\2\u00e1\u00e2\7e\2\2"+
		"\u00e2\u00e3\7t\2\2\u00e3\u00e4\7k\2\2\u00e4\u00e5\7v\2\2\u00e5\u00e6"+
		"\7k\2\2\u00e6\u00e8\7e\2\2\u00e7\u00d5\3\2\2\2\u00e7\u00de\3\2\2\2\u00e8"+
		"8\3\2\2\2\u00e9\u00ea\7*\2\2\u00ea\u00eb\7D\2\2\u00eb\u00ec\7g\2\2\u00ec"+
		"\u00ed\7h\2\2\u00ed\u00ee\7q\2\2\u00ee\u00ef\7t\2\2\u00ef\u00f0\7g\2\2"+
		"\u00f0\u00fa\7+\2\2\u00f1\u00f2\7*\2\2\u00f2\u00f3\7d\2\2\u00f3\u00f4"+
		"\7g\2\2\u00f4\u00f5\7h\2\2\u00f5\u00f6\7q\2\2\u00f6\u00f7\7t\2\2\u00f7"+
		"\u00f8\7g\2\2\u00f8\u00fa\7+\2\2\u00f9\u00e9\3\2\2\2\u00f9\u00f1\3\2\2"+
		"\2\u00fa:\3\2\2\2\u00fb\u00fc\7*\2\2\u00fc\u00fd\7H\2\2\u00fd\u00fe\7"+
		"n\2\2\u00fe\u00ff\7q\2\2\u00ff\u0100\7c\2\2\u0100\u0101\7v\2\2\u0101\u0102"+
		"\7k\2\2\u0102\u0103\7p\2\2\u0103\u0104\7i\2\2\u0104\u0110\7+\2\2\u0105"+
		"\u0106\7*\2\2\u0106\u0107\7h\2\2\u0107\u0108\7n\2\2\u0108\u0109\7q\2\2"+
		"\u0109\u010a\7c\2\2\u010a\u010b\7v\2\2\u010b\u010c\7k\2\2\u010c\u010d"+
		"\7p\2\2\u010d\u010e\7i\2\2\u010e\u0110\7+\2\2\u010f\u00fb\3\2\2\2\u010f"+
		"\u0105\3\2\2\2\u0110<\3\2\2\2\u0111\u0112\7U\2\2\u0112\u0113\7{\2\2\u0113"+
		"\u0114\7o\2\2\u0114\u0115\7d\2\2\u0115\u0116\7q\2\2\u0116\u011e\7n\2\2"+
		"\u0117\u0118\7u\2\2\u0118\u0119\7{\2\2\u0119\u011a\7o\2\2\u011a\u011b"+
		"\7d\2\2\u011b\u011c\7q\2\2\u011c\u011e\7n\2\2\u011d\u0111\3\2\2\2\u011d"+
		"\u0117\3\2\2\2\u011e>\3\2\2\2\u011f\u0120\7F\2\2\u0120\u0121\7g\2\2\u0121"+
		"\u0122\7t\2\2\u0122\u0123\7q\2\2\u0123\u0124\7o\2\2\u0124\u0125\7c\2\2"+
		"\u0125\u0126\7p\2\2\u0126\u0127\7k\2\2\u0127\u0128\7|\2\2\u0128\u0129"+
		"\7g\2\2\u0129\u0136\7t\2\2\u012a\u012b\7f\2\2\u012b\u012c\7g\2\2\u012c"+
		"\u012d\7t\2\2\u012d\u012e\7q\2\2\u012e\u012f\7o\2\2\u012f\u0130\7c\2\2"+
		"\u0130\u0131\7p\2\2\u0131\u0132\7k\2\2\u0132\u0133\7|\2\2\u0133\u0134"+
		"\7g\2\2\u0134\u0136\7t\2\2\u0135\u011f\3\2\2\2\u0135\u012a\3\2\2\2\u0136"+
		"@\3\2\2\2\u0137\u0138\7T\2\2\u0138\u0139\7q\2\2\u0139\u013a\7o\2\2\u013a"+
		"\u013b\7c\2\2\u013b\u013c\7p\2\2\u013c\u013d\7k\2\2\u013d\u013e\7|\2\2"+
		"\u013e\u013f\7g\2\2\u013f\u014a\7t\2\2\u0140\u0141\7t\2\2\u0141\u0142"+
		"\7q\2\2\u0142\u0143\7o\2\2\u0143\u0144\7c\2\2\u0144\u0145\7p\2\2\u0145"+
		"\u0146\7k\2\2\u0146\u0147\7|\2\2\u0147\u0148\7g\2\2\u0148\u014a\7t\2\2"+
		"\u0149\u0137\3\2\2\2\u0149\u0140\3\2\2\2\u014aB\3\2\2\2\u014b\u014c\7"+
		"V\2\2\u014c\u014d\7j\2\2\u014d\u014e\7g\2\2\u014e\u0154\7p\2\2\u014f\u0150"+
		"\7v\2\2\u0150\u0151\7j\2\2\u0151\u0152\7g\2\2\u0152\u0154\7p\2\2\u0153"+
		"\u014b\3\2\2\2\u0153\u014f\3\2\2\2\u0154D\3\2\2\2\u0155\u0156\7G\2\2\u0156"+
		"\u0157\7n\2\2\u0157\u0158\7u\2\2\u0158\u015e\7g\2\2\u0159\u015a\7g\2\2"+
		"\u015a\u015b\7n\2\2\u015b\u015c\7u\2\2\u015c\u015e\7g\2\2\u015d\u0155"+
		"\3\2\2\2\u015d\u0159\3\2\2\2\u015eF\3\2\2\2\u015f\u0160\7R\2\2\u0160\u0161"+
		"\7t\2\2\u0161\u0162\7q\2\2\u0162\u0163\7r\2\2\u0163\u0164\7c\2\2\u0164"+
		"\u0165\7i\2\2\u0165\u0166\7c\2\2\u0166\u0167\7v\2\2\u0167\u0172\7g\2\2"+
		"\u0168\u0169\7r\2\2\u0169\u016a\7t\2\2\u016a\u016b\7q\2\2\u016b\u016c"+
		"\7r\2\2\u016c\u016d\7c\2\2\u016d\u016e\7i\2\2\u016e\u016f\7c\2\2\u016f"+
		"\u0170\7v\2\2\u0170\u0172\7g\2\2\u0171\u015f\3\2\2\2\u0171\u0168\3\2\2"+
		"\2\u0172H\3\2\2\2\u0173\u0174\7N\2\2\u0174\u0175\7k\2\2\u0175\u0176\7"+
		"v\2\2\u0176\u0177\7g\2\2\u0177\u0178\7t\2\2\u0178\u0179\7c\2\2\u0179\u0182"+
		"\7n\2\2\u017a\u017b\7n\2\2\u017b\u017c\7k\2\2\u017c\u017d\7v\2\2\u017d"+
		"\u017e\7g\2\2\u017e\u017f\7t\2\2\u017f\u0180\7c\2\2\u0180\u0182\7n\2\2"+
		"\u0181\u0173\3\2\2\2\u0181\u017a\3\2\2\2\u0182J\3\2\2\2\u0183\u0184\7"+
		"W\2\2\u0184\u0185\7p\2\2\u0185\u0186\7e\2\2\u0186\u0187\7j\2\2\u0187\u0188"+
		"\7c\2\2\u0188\u0189\7p\2\2\u0189\u018a\7i\2\2\u018a\u018b\7g\2\2\u018b"+
		"\u0196\7f\2\2\u018c\u018d\7w\2\2\u018d\u018e\7p\2\2\u018e\u018f\7e\2\2"+
		"\u018f\u0190\7j\2\2\u0190\u0191\7c\2\2\u0191\u0192\7p\2\2\u0192\u0193"+
		"\7i\2\2\u0193\u0194\7g\2\2\u0194\u0196\7f\2\2\u0195\u0183\3\2\2\2\u0195"+
		"\u018c\3\2\2\2\u0196L\3\2\2\2\u0197\u0199\5W,\2\u0198\u0197\3\2\2\2\u0199"+
		"\u019a\3\2\2\2\u019a\u0198\3\2\2\2\u019a\u019b\3\2\2\2\u019bN\3\2\2\2"+
		"\u019c\u019e\5U+\2\u019d\u019c\3\2\2\2\u019e\u019f\3\2\2\2\u019f\u019d"+
		"\3\2\2\2\u019f\u01a0\3\2\2\2\u01a0P\3\2\2\2\u01a1\u01a2\5Y-\2\u01a2R\3"+
		"\2\2\2\u01a3\u01a5\5Y-\2\u01a4\u01a3\3\2\2\2\u01a5\u01a6\3\2\2\2\u01a6"+
		"\u01a4\3\2\2\2\u01a6\u01a7\3\2\2\2\u01a7T\3\2\2\2\u01a8\u01a9\t\4\2\2"+
		"\u01a9V\3\2\2\2\u01aa\u01ab\t\5\2\2\u01abX\3\2\2\2\u01ac\u01ad\7^\2\2"+
		"\u01ad\u01b0\13\2\2\2\u01ae\u01b0\n\6\2\2\u01af\u01ac\3\2\2\2\u01af\u01ae"+
		"\3\2\2\2\u01b0Z\3\2\2\2\u01b1\u01b2\7%\2\2\u01b2\\\3\2\2\2!\2^dkntw{~"+
		"\u0084\u0089\u008e\u0091\u0096\u00c3\u00d3\u00e7\u00f9\u010f\u011d\u0135"+
		"\u0149\u0153\u015d\u0171\u0181\u0195\u019a\u019f\u01a6\u01af\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}