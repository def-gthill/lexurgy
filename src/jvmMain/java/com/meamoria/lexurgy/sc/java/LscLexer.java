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
		SYMBOL=30, SYLLABLE_DECL=31, EXPLICIT_SYLLABLES=32, ANY_SYLLABLE=33, DEROMANIZER=34, 
		ROMANIZER=35, ALL_MATCHING=36, FIRST_MATCHING=37, PROPAGATE=38, LITERAL=39, 
		UNCHANGED=40, NUMBER=41, NAME=42, STR1=43, STR=44;
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
			"SYMBOL", "SYLLABLE_DECL", "EXPLICIT_SYLLABLES", "ANY_SYLLABLE", "DEROMANIZER", 
			"ROMANIZER", "ALL_MATCHING", "FIRST_MATCHING", "PROPAGATE", "LITERAL", 
			"UNCHANGED", "NUMBER", "NAME", "STR1", "STR", "CHAR", "DIGIT", "ANY", 
			"COMMENT_START"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2.\u01d8\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\3\2\5\2e\n\2\3\2\3\2\7\2i\n"+
		"\2\f\2\16\2l\13\2\3\2\3\2\3\3\3\3\5\3r\n\3\3\4\5\4u\n\4\3\4\3\4\3\4\3"+
		"\4\5\4{\n\4\3\5\5\5~\n\5\3\5\3\5\5\5\u0082\n\5\3\6\5\6\u0085\n\6\3\6\3"+
		"\6\3\6\3\6\5\6\u008b\n\6\3\7\3\7\3\b\5\b\u0090\n\b\3\b\3\b\3\b\5\b\u0095"+
		"\n\b\3\b\5\b\u0098\n\b\3\t\6\t\u009b\n\t\r\t\16\t\u009c\3\n\3\n\3\13\3"+
		"\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22"+
		"\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\27\3\30\3\30\3\31"+
		"\3\31\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\5\32\u00ca\n\32"+
		"\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33"+
		"\5\33\u00da\n\33\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34"+
		"\3\34\3\34\3\34\3\34\3\34\3\34\3\34\5\34\u00ee\n\34\3\35\3\35\3\35\3\35"+
		"\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\5\35\u0100"+
		"\n\35\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36"+
		"\3\36\3\36\3\36\3\36\3\36\3\36\3\36\5\36\u0116\n\36\3\37\3\37\3\37\3\37"+
		"\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\5\37\u0124\n\37\3 \3 \3 \3 \3"+
		" \3 \3 \3 \3 \3 \3!\3!\3!\3!\3!\3!\3!\3!\3!\3\"\3\"\3\"\3\"\3\"\3\"\3"+
		"\"\3\"\3\"\3\"\5\"\u0143\n\"\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3"+
		"#\3#\3#\3#\3#\3#\3#\3#\3#\5#\u015b\n#\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3"+
		"$\3$\3$\3$\3$\3$\3$\3$\5$\u016f\n$\3%\3%\3%\3%\3%\3%\3%\3%\5%\u0179\n"+
		"%\3&\3&\3&\3&\3&\3&\3&\3&\5&\u0183\n&\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'"+
		"\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\5\'\u0197\n\'\3(\3(\3(\3(\3("+
		"\3(\3(\3(\3(\3(\3(\3(\3(\3(\5(\u01a7\n(\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)"+
		"\3)\3)\3)\3)\3)\3)\3)\3)\5)\u01bb\n)\3*\6*\u01be\n*\r*\16*\u01bf\3+\6"+
		"+\u01c3\n+\r+\16+\u01c4\3,\3,\3-\6-\u01ca\n-\r-\16-\u01cb\3.\3.\3/\3/"+
		"\3\60\3\60\3\60\5\60\u01d5\n\60\3\61\3\61\2\2\62\3\3\5\4\7\5\t\6\13\7"+
		"\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25"+
		")\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O"+
		")Q*S+U,W-Y.[\2]\2_\2a\2\3\2\7\4\2\f\f\17\17\f\2\13\17\"\"\u0087\u0087"+
		"\u00a2\u00a2\u1682\u1682\u2002\u200c\u202a\u202b\u2031\u2031\u2061\u2061"+
		"\u3002\u3002\5\2\62;C\\c|\3\2\62;\17\2\f\f\17\17\"#%&((*/\61\61<<?B]_"+
		"aa}}\177\177\2\u01f2\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2"+
		"\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3"+
		"\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2"+
		"\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2"+
		"\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2"+
		"\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2"+
		"\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q"+
		"\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\3d\3\2\2\2\5o\3\2"+
		"\2\2\7t\3\2\2\2\t}\3\2\2\2\13\u0084\3\2\2\2\r\u008c\3\2\2\2\17\u008f\3"+
		"\2\2\2\21\u009a\3\2\2\2\23\u009e\3\2\2\2\25\u00a0\3\2\2\2\27\u00a2\3\2"+
		"\2\2\31\u00a4\3\2\2\2\33\u00a6\3\2\2\2\35\u00a8\3\2\2\2\37\u00aa\3\2\2"+
		"\2!\u00ac\3\2\2\2#\u00ae\3\2\2\2%\u00b0\3\2\2\2\'\u00b2\3\2\2\2)\u00b4"+
		"\3\2\2\2+\u00b6\3\2\2\2-\u00b8\3\2\2\2/\u00bb\3\2\2\2\61\u00bd\3\2\2\2"+
		"\63\u00c9\3\2\2\2\65\u00d9\3\2\2\2\67\u00ed\3\2\2\29\u00ff\3\2\2\2;\u0115"+
		"\3\2\2\2=\u0123\3\2\2\2?\u0125\3\2\2\2A\u012f\3\2\2\2C\u0142\3\2\2\2E"+
		"\u015a\3\2\2\2G\u016e\3\2\2\2I\u0178\3\2\2\2K\u0182\3\2\2\2M\u0196\3\2"+
		"\2\2O\u01a6\3\2\2\2Q\u01ba\3\2\2\2S\u01bd\3\2\2\2U\u01c2\3\2\2\2W\u01c6"+
		"\3\2\2\2Y\u01c9\3\2\2\2[\u01cd\3\2\2\2]\u01cf\3\2\2\2_\u01d4\3\2\2\2a"+
		"\u01d6\3\2\2\2ce\5\21\t\2dc\3\2\2\2de\3\2\2\2ef\3\2\2\2fj\5a\61\2gi\n"+
		"\2\2\2hg\3\2\2\2il\3\2\2\2jh\3\2\2\2jk\3\2\2\2km\3\2\2\2lj\3\2\2\2mn\b"+
		"\2\2\2n\4\3\2\2\2oq\7.\2\2pr\5\21\t\2qp\3\2\2\2qr\3\2\2\2r\6\3\2\2\2s"+
		"u\5\21\t\2ts\3\2\2\2tu\3\2\2\2uv\3\2\2\2vw\7?\2\2wx\7@\2\2xz\3\2\2\2y"+
		"{\5\21\t\2zy\3\2\2\2z{\3\2\2\2{\b\3\2\2\2|~\5\21\t\2}|\3\2\2\2}~\3\2\2"+
		"\2~\177\3\2\2\2\177\u0081\7\61\2\2\u0080\u0082\5\21\t\2\u0081\u0080\3"+
		"\2\2\2\u0081\u0082\3\2\2\2\u0082\n\3\2\2\2\u0083\u0085\5\21\t\2\u0084"+
		"\u0083\3\2\2\2\u0084\u0085\3\2\2\2\u0085\u0086\3\2\2\2\u0086\u0087\7\61"+
		"\2\2\u0087\u0088\7\61\2\2\u0088\u008a\3\2\2\2\u0089\u008b\5\21\t\2\u008a"+
		"\u0089\3\2\2\2\u008a\u008b\3\2\2\2\u008b\f\3\2\2\2\u008c\u008d\7a\2\2"+
		"\u008d\16\3\2\2\2\u008e\u0090\5\21\t\2\u008f\u008e\3\2\2\2\u008f\u0090"+
		"\3\2\2\2\u0090\u0094\3\2\2\2\u0091\u0092\7\17\2\2\u0092\u0095\7\f\2\2"+
		"\u0093\u0095\7\f\2\2\u0094\u0091\3\2\2\2\u0094\u0093\3\2\2\2\u0095\u0097"+
		"\3\2\2\2\u0096\u0098\5\21\t\2\u0097\u0096\3\2\2\2\u0097\u0098\3\2\2\2"+
		"\u0098\20\3\2\2\2\u0099\u009b\t\3\2\2\u009a\u0099\3\2\2\2\u009b\u009c"+
		"\3\2\2\2\u009c\u009a\3\2\2\2\u009c\u009d\3\2\2\2\u009d\22\3\2\2\2\u009e"+
		"\u009f\7*\2\2\u009f\24\3\2\2\2\u00a0\u00a1\7+\2\2\u00a1\26\3\2\2\2\u00a2"+
		"\u00a3\7,\2\2\u00a3\30\3\2\2\2\u00a4\u00a5\7]\2\2\u00a5\32\3\2\2\2\u00a6"+
		"\u00a7\7_\2\2\u00a7\34\3\2\2\2\u00a8\u00a9\7}\2\2\u00a9\36\3\2\2\2\u00aa"+
		"\u00ab\7\177\2\2\u00ab \3\2\2\2\u00ac\u00ad\7-\2\2\u00ad\"\3\2\2\2\u00ae"+
		"\u00af\7A\2\2\u00af$\3\2\2\2\u00b0\u00b1\7/\2\2\u00b1&\3\2\2\2\u00b2\u00b3"+
		"\7<\2\2\u00b3(\3\2\2\2\u00b4\u00b5\7#\2\2\u00b5*\3\2\2\2\u00b6\u00b7\7"+
		"&\2\2\u00b7,\3\2\2\2\u00b8\u00b9\7&\2\2\u00b9\u00ba\7&\2\2\u00ba.\3\2"+
		"\2\2\u00bb\u00bc\7B\2\2\u00bc\60\3\2\2\2\u00bd\u00be\7(\2\2\u00be\62\3"+
		"\2\2\2\u00bf\u00c0\7E\2\2\u00c0\u00c1\7n\2\2\u00c1\u00c2\7c\2\2\u00c2"+
		"\u00c3\7u\2\2\u00c3\u00ca\7u\2\2\u00c4\u00c5\7e\2\2\u00c5\u00c6\7n\2\2"+
		"\u00c6\u00c7\7c\2\2\u00c7\u00c8\7u\2\2\u00c8\u00ca\7u\2\2\u00c9\u00bf"+
		"\3\2\2\2\u00c9\u00c4\3\2\2\2\u00ca\64\3\2\2\2\u00cb\u00cc\7H\2\2\u00cc"+
		"\u00cd\7g\2\2\u00cd\u00ce\7c\2\2\u00ce\u00cf\7v\2\2\u00cf\u00d0\7w\2\2"+
		"\u00d0\u00d1\7t\2\2\u00d1\u00da\7g\2\2\u00d2\u00d3\7h\2\2\u00d3\u00d4"+
		"\7g\2\2\u00d4\u00d5\7c\2\2\u00d5\u00d6\7v\2\2\u00d6\u00d7\7w\2\2\u00d7"+
		"\u00d8\7t\2\2\u00d8\u00da\7g\2\2\u00d9\u00cb\3\2\2\2\u00d9\u00d2\3\2\2"+
		"\2\u00da\66\3\2\2\2\u00db\u00dc\7F\2\2\u00dc\u00dd\7k\2\2\u00dd\u00de"+
		"\7c\2\2\u00de\u00df\7e\2\2\u00df\u00e0\7t\2\2\u00e0\u00e1\7k\2\2\u00e1"+
		"\u00e2\7v\2\2\u00e2\u00e3\7k\2\2\u00e3\u00ee\7e\2\2\u00e4\u00e5\7f\2\2"+
		"\u00e5\u00e6\7k\2\2\u00e6\u00e7\7c\2\2\u00e7\u00e8\7e\2\2\u00e8\u00e9"+
		"\7t\2\2\u00e9\u00ea\7k\2\2\u00ea\u00eb\7v\2\2\u00eb\u00ec\7k\2\2\u00ec"+
		"\u00ee\7e\2\2\u00ed\u00db\3\2\2\2\u00ed\u00e4\3\2\2\2\u00ee8\3\2\2\2\u00ef"+
		"\u00f0\7*\2\2\u00f0\u00f1\7D\2\2\u00f1\u00f2\7g\2\2\u00f2\u00f3\7h\2\2"+
		"\u00f3\u00f4\7q\2\2\u00f4\u00f5\7t\2\2\u00f5\u00f6\7g\2\2\u00f6\u0100"+
		"\7+\2\2\u00f7\u00f8\7*\2\2\u00f8\u00f9\7d\2\2\u00f9\u00fa\7g\2\2\u00fa"+
		"\u00fb\7h\2\2\u00fb\u00fc\7q\2\2\u00fc\u00fd\7t\2\2\u00fd\u00fe\7g\2\2"+
		"\u00fe\u0100\7+\2\2\u00ff\u00ef\3\2\2\2\u00ff\u00f7\3\2\2\2\u0100:\3\2"+
		"\2\2\u0101\u0102\7*\2\2\u0102\u0103\7H\2\2\u0103\u0104\7n\2\2\u0104\u0105"+
		"\7q\2\2\u0105\u0106\7c\2\2\u0106\u0107\7v\2\2\u0107\u0108\7k\2\2\u0108"+
		"\u0109\7p\2\2\u0109\u010a\7i\2\2\u010a\u0116\7+\2\2\u010b\u010c\7*\2\2"+
		"\u010c\u010d\7h\2\2\u010d\u010e\7n\2\2\u010e\u010f\7q\2\2\u010f\u0110"+
		"\7c\2\2\u0110\u0111\7v\2\2\u0111\u0112\7k\2\2\u0112\u0113\7p\2\2\u0113"+
		"\u0114\7i\2\2\u0114\u0116\7+\2\2\u0115\u0101\3\2\2\2\u0115\u010b\3\2\2"+
		"\2\u0116<\3\2\2\2\u0117\u0118\7U\2\2\u0118\u0119\7{\2\2\u0119\u011a\7"+
		"o\2\2\u011a\u011b\7d\2\2\u011b\u011c\7q\2\2\u011c\u0124\7n\2\2\u011d\u011e"+
		"\7u\2\2\u011e\u011f\7{\2\2\u011f\u0120\7o\2\2\u0120\u0121\7d\2\2\u0121"+
		"\u0122\7q\2\2\u0122\u0124\7n\2\2\u0123\u0117\3\2\2\2\u0123\u011d\3\2\2"+
		"\2\u0124>\3\2\2\2\u0125\u0126\7U\2\2\u0126\u0127\7{\2\2\u0127\u0128\7"+
		"n\2\2\u0128\u0129\7n\2\2\u0129\u012a\7c\2\2\u012a\u012b\7d\2\2\u012b\u012c"+
		"\7n\2\2\u012c\u012d\7g\2\2\u012d\u012e\7u\2\2\u012e@\3\2\2\2\u012f\u0130"+
		"\7g\2\2\u0130\u0131\7z\2\2\u0131\u0132\7r\2\2\u0132\u0133\7n\2\2\u0133"+
		"\u0134\7k\2\2\u0134\u0135\7e\2\2\u0135\u0136\7k\2\2\u0136\u0137\7v\2\2"+
		"\u0137B\3\2\2\2\u0138\u0139\7>\2\2\u0139\u013a\7U\2\2\u013a\u013b\7{\2"+
		"\2\u013b\u013c\7n\2\2\u013c\u0143\7@\2\2\u013d\u013e\7>\2\2\u013e\u013f"+
		"\7u\2\2\u013f\u0140\7{\2\2\u0140\u0141\7n\2\2\u0141\u0143\7@\2\2\u0142"+
		"\u0138\3\2\2\2\u0142\u013d\3\2\2\2\u0143D\3\2\2\2\u0144\u0145\7F\2\2\u0145"+
		"\u0146\7g\2\2\u0146\u0147\7t\2\2\u0147\u0148\7q\2\2\u0148\u0149\7o\2\2"+
		"\u0149\u014a\7c\2\2\u014a\u014b\7p\2\2\u014b\u014c\7k\2\2\u014c\u014d"+
		"\7|\2\2\u014d\u014e\7g\2\2\u014e\u015b\7t\2\2\u014f\u0150\7f\2\2\u0150"+
		"\u0151\7g\2\2\u0151\u0152\7t\2\2\u0152\u0153\7q\2\2\u0153\u0154\7o\2\2"+
		"\u0154\u0155\7c\2\2\u0155\u0156\7p\2\2\u0156\u0157\7k\2\2\u0157\u0158"+
		"\7|\2\2\u0158\u0159\7g\2\2\u0159\u015b\7t\2\2\u015a\u0144\3\2\2\2\u015a"+
		"\u014f\3\2\2\2\u015bF\3\2\2\2\u015c\u015d\7T\2\2\u015d\u015e\7q\2\2\u015e"+
		"\u015f\7o\2\2\u015f\u0160\7c\2\2\u0160\u0161\7p\2\2\u0161\u0162\7k\2\2"+
		"\u0162\u0163\7|\2\2\u0163\u0164\7g\2\2\u0164\u016f\7t\2\2\u0165\u0166"+
		"\7t\2\2\u0166\u0167\7q\2\2\u0167\u0168\7o\2\2\u0168\u0169\7c\2\2\u0169"+
		"\u016a\7p\2\2\u016a\u016b\7k\2\2\u016b\u016c\7|\2\2\u016c\u016d\7g\2\2"+
		"\u016d\u016f\7t\2\2\u016e\u015c\3\2\2\2\u016e\u0165\3\2\2\2\u016fH\3\2"+
		"\2\2\u0170\u0171\7V\2\2\u0171\u0172\7j\2\2\u0172\u0173\7g\2\2\u0173\u0179"+
		"\7p\2\2\u0174\u0175\7v\2\2\u0175\u0176\7j\2\2\u0176\u0177\7g\2\2\u0177"+
		"\u0179\7p\2\2\u0178\u0170\3\2\2\2\u0178\u0174\3\2\2\2\u0179J\3\2\2\2\u017a"+
		"\u017b\7G\2\2\u017b\u017c\7n\2\2\u017c\u017d\7u\2\2\u017d\u0183\7g\2\2"+
		"\u017e\u017f\7g\2\2\u017f\u0180\7n\2\2\u0180\u0181\7u\2\2\u0181\u0183"+
		"\7g\2\2\u0182\u017a\3\2\2\2\u0182\u017e\3\2\2\2\u0183L\3\2\2\2\u0184\u0185"+
		"\7R\2\2\u0185\u0186\7t\2\2\u0186\u0187\7q\2\2\u0187\u0188\7r\2\2\u0188"+
		"\u0189\7c\2\2\u0189\u018a\7i\2\2\u018a\u018b\7c\2\2\u018b\u018c\7v\2\2"+
		"\u018c\u0197\7g\2\2\u018d\u018e\7r\2\2\u018e\u018f\7t\2\2\u018f\u0190"+
		"\7q\2\2\u0190\u0191\7r\2\2\u0191\u0192\7c\2\2\u0192\u0193\7i\2\2\u0193"+
		"\u0194\7c\2\2\u0194\u0195\7v\2\2\u0195\u0197\7g\2\2\u0196\u0184\3\2\2"+
		"\2\u0196\u018d\3\2\2\2\u0197N\3\2\2\2\u0198\u0199\7N\2\2\u0199\u019a\7"+
		"k\2\2\u019a\u019b\7v\2\2\u019b\u019c\7g\2\2\u019c\u019d\7t\2\2\u019d\u019e"+
		"\7c\2\2\u019e\u01a7\7n\2\2\u019f\u01a0\7n\2\2\u01a0\u01a1\7k\2\2\u01a1"+
		"\u01a2\7v\2\2\u01a2\u01a3\7g\2\2\u01a3\u01a4\7t\2\2\u01a4\u01a5\7c\2\2"+
		"\u01a5\u01a7\7n\2\2\u01a6\u0198\3\2\2\2\u01a6\u019f\3\2\2\2\u01a7P\3\2"+
		"\2\2\u01a8\u01a9\7W\2\2\u01a9\u01aa\7p\2\2\u01aa\u01ab\7e\2\2\u01ab\u01ac"+
		"\7j\2\2\u01ac\u01ad\7c\2\2\u01ad\u01ae\7p\2\2\u01ae\u01af\7i\2\2\u01af"+
		"\u01b0\7g\2\2\u01b0\u01bb\7f\2\2\u01b1\u01b2\7w\2\2\u01b2\u01b3\7p\2\2"+
		"\u01b3\u01b4\7e\2\2\u01b4\u01b5\7j\2\2\u01b5\u01b6\7c\2\2\u01b6\u01b7"+
		"\7p\2\2\u01b7\u01b8\7i\2\2\u01b8\u01b9\7g\2\2\u01b9\u01bb\7f\2\2\u01ba"+
		"\u01a8\3\2\2\2\u01ba\u01b1\3\2\2\2\u01bbR\3\2\2\2\u01bc\u01be\5]/\2\u01bd"+
		"\u01bc\3\2\2\2\u01be\u01bf\3\2\2\2\u01bf\u01bd\3\2\2\2\u01bf\u01c0\3\2"+
		"\2\2\u01c0T\3\2\2\2\u01c1\u01c3\5[.\2\u01c2\u01c1\3\2\2\2\u01c3\u01c4"+
		"\3\2\2\2\u01c4\u01c2\3\2\2\2\u01c4\u01c5\3\2\2\2\u01c5V\3\2\2\2\u01c6"+
		"\u01c7\5_\60\2\u01c7X\3\2\2\2\u01c8\u01ca\5_\60\2\u01c9\u01c8\3\2\2\2"+
		"\u01ca\u01cb\3\2\2\2\u01cb\u01c9\3\2\2\2\u01cb\u01cc\3\2\2\2\u01ccZ\3"+
		"\2\2\2\u01cd\u01ce\t\4\2\2\u01ce\\\3\2\2\2\u01cf\u01d0\t\5\2\2\u01d0^"+
		"\3\2\2\2\u01d1\u01d2\7^\2\2\u01d2\u01d5\13\2\2\2\u01d3\u01d5\n\6\2\2\u01d4"+
		"\u01d1\3\2\2\2\u01d4\u01d3\3\2\2\2\u01d5`\3\2\2\2\u01d6\u01d7\7%\2\2\u01d7"+
		"b\3\2\2\2\"\2djqtz}\u0081\u0084\u008a\u008f\u0094\u0097\u009c\u00c9\u00d9"+
		"\u00ed\u00ff\u0115\u0123\u0142\u015a\u016e\u0178\u0182\u0196\u01a6\u01ba"+
		"\u01bf\u01c4\u01cb\u01d4\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}