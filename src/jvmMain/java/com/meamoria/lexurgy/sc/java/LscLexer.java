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
		T__0=1, COMMENT=2, SEP=3, CHANGE=4, CONDITION=5, EXCLUSION=6, ANCHOR=7, 
		NEWLINE=8, WHITESPACE=9, O_PAREN=10, C_PAREN=11, NULL=12, MATRIX_START=13, 
		MATRIX_END=14, LIST_START=15, LIST_END=16, AT_LEAST_ONE=17, OPTIONAL=18, 
		HYPHEN=19, RULE_START=20, NEGATION=21, WORD_BOUNDARY=22, BETWEEN_WORDS=23, 
		CLASSREF=24, INTERSECTION=25, CLASS_DECL=26, FEATURE_DECL=27, DIACRITIC=28, 
		DIA_BEFORE=29, DIA_FLOATING=30, SYMBOL=31, SYLLABLE_DECL=32, DEROMANIZER=33, 
		ROMANIZER=34, ALL_MATCHING=35, FIRST_MATCHING=36, PROPAGATE=37, LITERAL=38, 
		UNCHANGED=39, NUMBER=40, NAME=41, STR1=42, STR=43;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "COMMENT", "SEP", "CHANGE", "CONDITION", "EXCLUSION", "ANCHOR", 
			"NEWLINE", "WHITESPACE", "O_PAREN", "C_PAREN", "NULL", "MATRIX_START", 
			"MATRIX_END", "LIST_START", "LIST_END", "AT_LEAST_ONE", "OPTIONAL", "HYPHEN", 
			"RULE_START", "NEGATION", "WORD_BOUNDARY", "BETWEEN_WORDS", "CLASSREF", 
			"INTERSECTION", "CLASS_DECL", "FEATURE_DECL", "DIACRITIC", "DIA_BEFORE", 
			"DIA_FLOATING", "SYMBOL", "SYLLABLE_DECL", "DEROMANIZER", "ROMANIZER", 
			"ALL_MATCHING", "FIRST_MATCHING", "PROPAGATE", "LITERAL", "UNCHANGED", 
			"NUMBER", "NAME", "STR1", "STR", "CHAR", "DIGIT", "ANY", "COMMENT_START"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'default'", null, null, null, null, null, "'_'", null, null, "'('", 
			"')'", "'*'", "'['", "']'", "'{'", "'}'", "'+'", "'?'", "'-'", "':'", 
			"'!'", "'$'", "'$$'", "'@'", "'&'", null, null, null, null, null, null, 
			"'Syllables'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, "COMMENT", "SEP", "CHANGE", "CONDITION", "EXCLUSION", "ANCHOR", 
			"NEWLINE", "WHITESPACE", "O_PAREN", "C_PAREN", "NULL", "MATRIX_START", 
			"MATRIX_END", "LIST_START", "LIST_END", "AT_LEAST_ONE", "OPTIONAL", "HYPHEN", 
			"RULE_START", "NEGATION", "WORD_BOUNDARY", "BETWEEN_WORDS", "CLASSREF", 
			"INTERSECTION", "CLASS_DECL", "FEATURE_DECL", "DIACRITIC", "DIA_BEFORE", 
			"DIA_FLOATING", "SYMBOL", "SYLLABLE_DECL", "DEROMANIZER", "ROMANIZER", 
			"ALL_MATCHING", "FIRST_MATCHING", "PROPAGATE", "LITERAL", "UNCHANGED", 
			"NUMBER", "NAME", "STR1", "STR"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2-\u01c9\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\5"+
		"\3k\n\3\3\3\3\3\7\3o\n\3\f\3\16\3r\13\3\3\3\3\3\3\4\3\4\5\4x\n\4\3\5\5"+
		"\5{\n\5\3\5\3\5\3\5\3\5\5\5\u0081\n\5\3\6\5\6\u0084\n\6\3\6\3\6\5\6\u0088"+
		"\n\6\3\7\5\7\u008b\n\7\3\7\3\7\3\7\3\7\5\7\u0091\n\7\3\b\3\b\3\t\5\t\u0096"+
		"\n\t\3\t\3\t\3\t\5\t\u009b\n\t\3\t\5\t\u009e\n\t\3\n\6\n\u00a1\n\n\r\n"+
		"\16\n\u00a2\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3"+
		"\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3"+
		"\30\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3"+
		"\33\3\33\3\33\5\33\u00d0\n\33\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34"+
		"\3\34\3\34\3\34\3\34\3\34\3\34\5\34\u00e0\n\34\3\35\3\35\3\35\3\35\3\35"+
		"\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\5\35"+
		"\u00f4\n\35\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36"+
		"\3\36\3\36\3\36\3\36\5\36\u0106\n\36\3\37\3\37\3\37\3\37\3\37\3\37\3\37"+
		"\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\5\37"+
		"\u011c\n\37\3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \5 \u012a\n \3!\3!\3!\3"+
		"!\3!\3!\3!\3!\3!\3!\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3"+
		"\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\5\"\u014c\n\"\3#\3#\3#\3#\3#\3"+
		"#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\5#\u0160\n#\3$\3$\3$\3$\3$\3$\3"+
		"$\3$\5$\u016a\n$\3%\3%\3%\3%\3%\3%\3%\3%\5%\u0174\n%\3&\3&\3&\3&\3&\3"+
		"&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\5&\u0188\n&\3\'\3\'\3\'\3\'\3\'"+
		"\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\5\'\u0198\n\'\3(\3(\3(\3(\3(\3(\3"+
		"(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\5(\u01ac\n(\3)\6)\u01af\n)\r)\16)\u01b0"+
		"\3*\6*\u01b4\n*\r*\16*\u01b5\3+\3+\3,\6,\u01bb\n,\r,\16,\u01bc\3-\3-\3"+
		".\3.\3/\3/\3/\5/\u01c6\n/\3\60\3\60\2\2\61\3\3\5\4\7\5\t\6\13\7\r\b\17"+
		"\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+"+
		"\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+"+
		"U,W-Y\2[\2]\2_\2\3\2\7\4\2\f\f\17\17\f\2\13\17\"\"\u0087\u0087\u00a2\u00a2"+
		"\u1682\u1682\u2002\u200c\u202a\u202b\u2031\u2031\u2061\u2061\u3002\u3002"+
		"\5\2\62;C\\c|\3\2\62;\17\2\f\f\17\17\"#%&((*/\61\61<<?B]_aa}}\177\177"+
		"\2\u01e2\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2"+
		"\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27"+
		"\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2"+
		"\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2"+
		"\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2"+
		"\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2"+
		"\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S"+
		"\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\3a\3\2\2\2\5j\3\2\2\2\7u\3\2\2\2\tz\3\2"+
		"\2\2\13\u0083\3\2\2\2\r\u008a\3\2\2\2\17\u0092\3\2\2\2\21\u0095\3\2\2"+
		"\2\23\u00a0\3\2\2\2\25\u00a4\3\2\2\2\27\u00a6\3\2\2\2\31\u00a8\3\2\2\2"+
		"\33\u00aa\3\2\2\2\35\u00ac\3\2\2\2\37\u00ae\3\2\2\2!\u00b0\3\2\2\2#\u00b2"+
		"\3\2\2\2%\u00b4\3\2\2\2\'\u00b6\3\2\2\2)\u00b8\3\2\2\2+\u00ba\3\2\2\2"+
		"-\u00bc\3\2\2\2/\u00be\3\2\2\2\61\u00c1\3\2\2\2\63\u00c3\3\2\2\2\65\u00cf"+
		"\3\2\2\2\67\u00df\3\2\2\29\u00f3\3\2\2\2;\u0105\3\2\2\2=\u011b\3\2\2\2"+
		"?\u0129\3\2\2\2A\u012b\3\2\2\2C\u014b\3\2\2\2E\u015f\3\2\2\2G\u0169\3"+
		"\2\2\2I\u0173\3\2\2\2K\u0187\3\2\2\2M\u0197\3\2\2\2O\u01ab\3\2\2\2Q\u01ae"+
		"\3\2\2\2S\u01b3\3\2\2\2U\u01b7\3\2\2\2W\u01ba\3\2\2\2Y\u01be\3\2\2\2["+
		"\u01c0\3\2\2\2]\u01c5\3\2\2\2_\u01c7\3\2\2\2ab\7f\2\2bc\7g\2\2cd\7h\2"+
		"\2de\7c\2\2ef\7w\2\2fg\7n\2\2gh\7v\2\2h\4\3\2\2\2ik\5\23\n\2ji\3\2\2\2"+
		"jk\3\2\2\2kl\3\2\2\2lp\5_\60\2mo\n\2\2\2nm\3\2\2\2or\3\2\2\2pn\3\2\2\2"+
		"pq\3\2\2\2qs\3\2\2\2rp\3\2\2\2st\b\3\2\2t\6\3\2\2\2uw\7.\2\2vx\5\23\n"+
		"\2wv\3\2\2\2wx\3\2\2\2x\b\3\2\2\2y{\5\23\n\2zy\3\2\2\2z{\3\2\2\2{|\3\2"+
		"\2\2|}\7?\2\2}~\7@\2\2~\u0080\3\2\2\2\177\u0081\5\23\n\2\u0080\177\3\2"+
		"\2\2\u0080\u0081\3\2\2\2\u0081\n\3\2\2\2\u0082\u0084\5\23\n\2\u0083\u0082"+
		"\3\2\2\2\u0083\u0084\3\2\2\2\u0084\u0085\3\2\2\2\u0085\u0087\7\61\2\2"+
		"\u0086\u0088\5\23\n\2\u0087\u0086\3\2\2\2\u0087\u0088\3\2\2\2\u0088\f"+
		"\3\2\2\2\u0089\u008b\5\23\n\2\u008a\u0089\3\2\2\2\u008a\u008b\3\2\2\2"+
		"\u008b\u008c\3\2\2\2\u008c\u008d\7\61\2\2\u008d\u008e\7\61\2\2\u008e\u0090"+
		"\3\2\2\2\u008f\u0091\5\23\n\2\u0090\u008f\3\2\2\2\u0090\u0091\3\2\2\2"+
		"\u0091\16\3\2\2\2\u0092\u0093\7a\2\2\u0093\20\3\2\2\2\u0094\u0096\5\23"+
		"\n\2\u0095\u0094\3\2\2\2\u0095\u0096\3\2\2\2\u0096\u009a\3\2\2\2\u0097"+
		"\u0098\7\17\2\2\u0098\u009b\7\f\2\2\u0099\u009b\7\f\2\2\u009a\u0097\3"+
		"\2\2\2\u009a\u0099\3\2\2\2\u009b\u009d\3\2\2\2\u009c\u009e\5\23\n\2\u009d"+
		"\u009c\3\2\2\2\u009d\u009e\3\2\2\2\u009e\22\3\2\2\2\u009f\u00a1\t\3\2"+
		"\2\u00a0\u009f\3\2\2\2\u00a1\u00a2\3\2\2\2\u00a2\u00a0\3\2\2\2\u00a2\u00a3"+
		"\3\2\2\2\u00a3\24\3\2\2\2\u00a4\u00a5\7*\2\2\u00a5\26\3\2\2\2\u00a6\u00a7"+
		"\7+\2\2\u00a7\30\3\2\2\2\u00a8\u00a9\7,\2\2\u00a9\32\3\2\2\2\u00aa\u00ab"+
		"\7]\2\2\u00ab\34\3\2\2\2\u00ac\u00ad\7_\2\2\u00ad\36\3\2\2\2\u00ae\u00af"+
		"\7}\2\2\u00af \3\2\2\2\u00b0\u00b1\7\177\2\2\u00b1\"\3\2\2\2\u00b2\u00b3"+
		"\7-\2\2\u00b3$\3\2\2\2\u00b4\u00b5\7A\2\2\u00b5&\3\2\2\2\u00b6\u00b7\7"+
		"/\2\2\u00b7(\3\2\2\2\u00b8\u00b9\7<\2\2\u00b9*\3\2\2\2\u00ba\u00bb\7#"+
		"\2\2\u00bb,\3\2\2\2\u00bc\u00bd\7&\2\2\u00bd.\3\2\2\2\u00be\u00bf\7&\2"+
		"\2\u00bf\u00c0\7&\2\2\u00c0\60\3\2\2\2\u00c1\u00c2\7B\2\2\u00c2\62\3\2"+
		"\2\2\u00c3\u00c4\7(\2\2\u00c4\64\3\2\2\2\u00c5\u00c6\7E\2\2\u00c6\u00c7"+
		"\7n\2\2\u00c7\u00c8\7c\2\2\u00c8\u00c9\7u\2\2\u00c9\u00d0\7u\2\2\u00ca"+
		"\u00cb\7e\2\2\u00cb\u00cc\7n\2\2\u00cc\u00cd\7c\2\2\u00cd\u00ce\7u\2\2"+
		"\u00ce\u00d0\7u\2\2\u00cf\u00c5\3\2\2\2\u00cf\u00ca\3\2\2\2\u00d0\66\3"+
		"\2\2\2\u00d1\u00d2\7H\2\2\u00d2\u00d3\7g\2\2\u00d3\u00d4\7c\2\2\u00d4"+
		"\u00d5\7v\2\2\u00d5\u00d6\7w\2\2\u00d6\u00d7\7t\2\2\u00d7\u00e0\7g\2\2"+
		"\u00d8\u00d9\7h\2\2\u00d9\u00da\7g\2\2\u00da\u00db\7c\2\2\u00db\u00dc"+
		"\7v\2\2\u00dc\u00dd\7w\2\2\u00dd\u00de\7t\2\2\u00de\u00e0\7g\2\2\u00df"+
		"\u00d1\3\2\2\2\u00df\u00d8\3\2\2\2\u00e08\3\2\2\2\u00e1\u00e2\7F\2\2\u00e2"+
		"\u00e3\7k\2\2\u00e3\u00e4\7c\2\2\u00e4\u00e5\7e\2\2\u00e5\u00e6\7t\2\2"+
		"\u00e6\u00e7\7k\2\2\u00e7\u00e8\7v\2\2\u00e8\u00e9\7k\2\2\u00e9\u00f4"+
		"\7e\2\2\u00ea\u00eb\7f\2\2\u00eb\u00ec\7k\2\2\u00ec\u00ed\7c\2\2\u00ed"+
		"\u00ee\7e\2\2\u00ee\u00ef\7t\2\2\u00ef\u00f0\7k\2\2\u00f0\u00f1\7v\2\2"+
		"\u00f1\u00f2\7k\2\2\u00f2\u00f4\7e\2\2\u00f3\u00e1\3\2\2\2\u00f3\u00ea"+
		"\3\2\2\2\u00f4:\3\2\2\2\u00f5\u00f6\7*\2\2\u00f6\u00f7\7D\2\2\u00f7\u00f8"+
		"\7g\2\2\u00f8\u00f9\7h\2\2\u00f9\u00fa\7q\2\2\u00fa\u00fb\7t\2\2\u00fb"+
		"\u00fc\7g\2\2\u00fc\u0106\7+\2\2\u00fd\u00fe\7*\2\2\u00fe\u00ff\7d\2\2"+
		"\u00ff\u0100\7g\2\2\u0100\u0101\7h\2\2\u0101\u0102\7q\2\2\u0102\u0103"+
		"\7t\2\2\u0103\u0104\7g\2\2\u0104\u0106\7+\2\2\u0105\u00f5\3\2\2\2\u0105"+
		"\u00fd\3\2\2\2\u0106<\3\2\2\2\u0107\u0108\7*\2\2\u0108\u0109\7H\2\2\u0109"+
		"\u010a\7n\2\2\u010a\u010b\7q\2\2\u010b\u010c\7c\2\2\u010c\u010d\7v\2\2"+
		"\u010d\u010e\7k\2\2\u010e\u010f\7p\2\2\u010f\u0110\7i\2\2\u0110\u011c"+
		"\7+\2\2\u0111\u0112\7*\2\2\u0112\u0113\7h\2\2\u0113\u0114\7n\2\2\u0114"+
		"\u0115\7q\2\2\u0115\u0116\7c\2\2\u0116\u0117\7v\2\2\u0117\u0118\7k\2\2"+
		"\u0118\u0119\7p\2\2\u0119\u011a\7i\2\2\u011a\u011c\7+\2\2\u011b\u0107"+
		"\3\2\2\2\u011b\u0111\3\2\2\2\u011c>\3\2\2\2\u011d\u011e\7U\2\2\u011e\u011f"+
		"\7{\2\2\u011f\u0120\7o\2\2\u0120\u0121\7d\2\2\u0121\u0122\7q\2\2\u0122"+
		"\u012a\7n\2\2\u0123\u0124\7u\2\2\u0124\u0125\7{\2\2\u0125\u0126\7o\2\2"+
		"\u0126\u0127\7d\2\2\u0127\u0128\7q\2\2\u0128\u012a\7n\2\2\u0129\u011d"+
		"\3\2\2\2\u0129\u0123\3\2\2\2\u012a@\3\2\2\2\u012b\u012c\7U\2\2\u012c\u012d"+
		"\7{\2\2\u012d\u012e\7n\2\2\u012e\u012f\7n\2\2\u012f\u0130\7c\2\2\u0130"+
		"\u0131\7d\2\2\u0131\u0132\7n\2\2\u0132\u0133\7g\2\2\u0133\u0134\7u\2\2"+
		"\u0134B\3\2\2\2\u0135\u0136\7F\2\2\u0136\u0137\7g\2\2\u0137\u0138\7t\2"+
		"\2\u0138\u0139\7q\2\2\u0139\u013a\7o\2\2\u013a\u013b\7c\2\2\u013b\u013c"+
		"\7p\2\2\u013c\u013d\7k\2\2\u013d\u013e\7|\2\2\u013e\u013f\7g\2\2\u013f"+
		"\u014c\7t\2\2\u0140\u0141\7f\2\2\u0141\u0142\7g\2\2\u0142\u0143\7t\2\2"+
		"\u0143\u0144\7q\2\2\u0144\u0145\7o\2\2\u0145\u0146\7c\2\2\u0146\u0147"+
		"\7p\2\2\u0147\u0148\7k\2\2\u0148\u0149\7|\2\2\u0149\u014a\7g\2\2\u014a"+
		"\u014c\7t\2\2\u014b\u0135\3\2\2\2\u014b\u0140\3\2\2\2\u014cD\3\2\2\2\u014d"+
		"\u014e\7T\2\2\u014e\u014f\7q\2\2\u014f\u0150\7o\2\2\u0150\u0151\7c\2\2"+
		"\u0151\u0152\7p\2\2\u0152\u0153\7k\2\2\u0153\u0154\7|\2\2\u0154\u0155"+
		"\7g\2\2\u0155\u0160\7t\2\2\u0156\u0157\7t\2\2\u0157\u0158\7q\2\2\u0158"+
		"\u0159\7o\2\2\u0159\u015a\7c\2\2\u015a\u015b\7p\2\2\u015b\u015c\7k\2\2"+
		"\u015c\u015d\7|\2\2\u015d\u015e\7g\2\2\u015e\u0160\7t\2\2\u015f\u014d"+
		"\3\2\2\2\u015f\u0156\3\2\2\2\u0160F\3\2\2\2\u0161\u0162\7V\2\2\u0162\u0163"+
		"\7j\2\2\u0163\u0164\7g\2\2\u0164\u016a\7p\2\2\u0165\u0166\7v\2\2\u0166"+
		"\u0167\7j\2\2\u0167\u0168\7g\2\2\u0168\u016a\7p\2\2\u0169\u0161\3\2\2"+
		"\2\u0169\u0165\3\2\2\2\u016aH\3\2\2\2\u016b\u016c\7G\2\2\u016c\u016d\7"+
		"n\2\2\u016d\u016e\7u\2\2\u016e\u0174\7g\2\2\u016f\u0170\7g\2\2\u0170\u0171"+
		"\7n\2\2\u0171\u0172\7u\2\2\u0172\u0174\7g\2\2\u0173\u016b\3\2\2\2\u0173"+
		"\u016f\3\2\2\2\u0174J\3\2\2\2\u0175\u0176\7R\2\2\u0176\u0177\7t\2\2\u0177"+
		"\u0178\7q\2\2\u0178\u0179\7r\2\2\u0179\u017a\7c\2\2\u017a\u017b\7i\2\2"+
		"\u017b\u017c\7c\2\2\u017c\u017d\7v\2\2\u017d\u0188\7g\2\2\u017e\u017f"+
		"\7r\2\2\u017f\u0180\7t\2\2\u0180\u0181\7q\2\2\u0181\u0182\7r\2\2\u0182"+
		"\u0183\7c\2\2\u0183\u0184\7i\2\2\u0184\u0185\7c\2\2\u0185\u0186\7v\2\2"+
		"\u0186\u0188\7g\2\2\u0187\u0175\3\2\2\2\u0187\u017e\3\2\2\2\u0188L\3\2"+
		"\2\2\u0189\u018a\7N\2\2\u018a\u018b\7k\2\2\u018b\u018c\7v\2\2\u018c\u018d"+
		"\7g\2\2\u018d\u018e\7t\2\2\u018e\u018f\7c\2\2\u018f\u0198\7n\2\2\u0190"+
		"\u0191\7n\2\2\u0191\u0192\7k\2\2\u0192\u0193\7v\2\2\u0193\u0194\7g\2\2"+
		"\u0194\u0195\7t\2\2\u0195\u0196\7c\2\2\u0196\u0198\7n\2\2\u0197\u0189"+
		"\3\2\2\2\u0197\u0190\3\2\2\2\u0198N\3\2\2\2\u0199\u019a\7W\2\2\u019a\u019b"+
		"\7p\2\2\u019b\u019c\7e\2\2\u019c\u019d\7j\2\2\u019d\u019e\7c\2\2\u019e"+
		"\u019f\7p\2\2\u019f\u01a0\7i\2\2\u01a0\u01a1\7g\2\2\u01a1\u01ac\7f\2\2"+
		"\u01a2\u01a3\7w\2\2\u01a3\u01a4\7p\2\2\u01a4\u01a5\7e\2\2\u01a5\u01a6"+
		"\7j\2\2\u01a6\u01a7\7c\2\2\u01a7\u01a8\7p\2\2\u01a8\u01a9\7i\2\2\u01a9"+
		"\u01aa\7g\2\2\u01aa\u01ac\7f\2\2\u01ab\u0199\3\2\2\2\u01ab\u01a2\3\2\2"+
		"\2\u01acP\3\2\2\2\u01ad\u01af\5[.\2\u01ae\u01ad\3\2\2\2\u01af\u01b0\3"+
		"\2\2\2\u01b0\u01ae\3\2\2\2\u01b0\u01b1\3\2\2\2\u01b1R\3\2\2\2\u01b2\u01b4"+
		"\5Y-\2\u01b3\u01b2\3\2\2\2\u01b4\u01b5\3\2\2\2\u01b5\u01b3\3\2\2\2\u01b5"+
		"\u01b6\3\2\2\2\u01b6T\3\2\2\2\u01b7\u01b8\5]/\2\u01b8V\3\2\2\2\u01b9\u01bb"+
		"\5]/\2\u01ba\u01b9\3\2\2\2\u01bb\u01bc\3\2\2\2\u01bc\u01ba\3\2\2\2\u01bc"+
		"\u01bd\3\2\2\2\u01bdX\3\2\2\2\u01be\u01bf\t\4\2\2\u01bfZ\3\2\2\2\u01c0"+
		"\u01c1\t\5\2\2\u01c1\\\3\2\2\2\u01c2\u01c3\7^\2\2\u01c3\u01c6\13\2\2\2"+
		"\u01c4\u01c6\n\6\2\2\u01c5\u01c2\3\2\2\2\u01c5\u01c4\3\2\2\2\u01c6^\3"+
		"\2\2\2\u01c7\u01c8\7%\2\2\u01c8`\3\2\2\2!\2jpwz\u0080\u0083\u0087\u008a"+
		"\u0090\u0095\u009a\u009d\u00a2\u00cf\u00df\u00f3\u0105\u011b\u0129\u014b"+
		"\u015f\u0169\u0173\u0187\u0197\u01ab\u01b0\u01b5\u01bc\u01c5\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}