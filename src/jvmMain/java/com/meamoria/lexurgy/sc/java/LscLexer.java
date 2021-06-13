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
		SYMBOL=30, SYLLABLE_DECL=31, EXPLICIT_SYLLABLES=32, DEROMANIZER=33, ROMANIZER=34, 
		ALL_MATCHING=35, FIRST_MATCHING=36, PROPAGATE=37, LITERAL=38, UNCHANGED=39, 
		NUMBER=40, NAME=41, STR1=42, STR=43;
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
			"SYMBOL", "SYLLABLE_DECL", "EXPLICIT_SYLLABLES", "DEROMANIZER", "ROMANIZER", 
			"ALL_MATCHING", "FIRST_MATCHING", "PROPAGATE", "LITERAL", "UNCHANGED", 
			"NUMBER", "NAME", "STR1", "STR", "CHAR", "DIGIT", "ANY", "COMMENT_START"
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
			"DIA_FLOATING", "SYMBOL", "SYLLABLE_DECL", "EXPLICIT_SYLLABLES", "DEROMANIZER", 
			"ROMANIZER", "ALL_MATCHING", "FIRST_MATCHING", "PROPAGATE", "LITERAL", 
			"UNCHANGED", "NUMBER", "NAME", "STR1", "STR"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2-\u01ca\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\3\2\5\2c\n\2\3\2\3\2\7\2g\n\2\f\2\16"+
		"\2j\13\2\3\2\3\2\3\3\3\3\5\3p\n\3\3\4\5\4s\n\4\3\4\3\4\3\4\3\4\5\4y\n"+
		"\4\3\5\5\5|\n\5\3\5\3\5\5\5\u0080\n\5\3\6\5\6\u0083\n\6\3\6\3\6\3\6\3"+
		"\6\5\6\u0089\n\6\3\7\3\7\3\b\5\b\u008e\n\b\3\b\3\b\3\b\5\b\u0093\n\b\3"+
		"\b\5\b\u0096\n\b\3\t\6\t\u0099\n\t\r\t\16\t\u009a\3\n\3\n\3\13\3\13\3"+
		"\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23"+
		"\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\27\3\30\3\30\3\31\3\31"+
		"\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\5\32\u00c8\n\32\3\33"+
		"\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\5\33"+
		"\u00d8\n\33\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34"+
		"\3\34\3\34\3\34\3\34\3\34\3\34\5\34\u00ec\n\34\3\35\3\35\3\35\3\35\3\35"+
		"\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\5\35\u00fe\n\35"+
		"\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36"+
		"\3\36\3\36\3\36\3\36\3\36\3\36\5\36\u0114\n\36\3\37\3\37\3\37\3\37\3\37"+
		"\3\37\3\37\3\37\3\37\3\37\3\37\3\37\5\37\u0122\n\37\3 \3 \3 \3 \3 \3 "+
		"\3 \3 \3 \3 \3!\3!\3!\3!\3!\3!\3!\3!\3!\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3"+
		"\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\5\"\u014d\n"+
		"\"\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\5#\u0161\n#\3"+
		"$\3$\3$\3$\3$\3$\3$\3$\5$\u016b\n$\3%\3%\3%\3%\3%\3%\3%\3%\5%\u0175\n"+
		"%\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\5&\u0189\n&\3"+
		"\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\5\'\u0199\n\'\3"+
		"(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\5(\u01ad\n(\3)\6"+
		")\u01b0\n)\r)\16)\u01b1\3*\6*\u01b5\n*\r*\16*\u01b6\3+\3+\3,\6,\u01bc"+
		"\n,\r,\16,\u01bd\3-\3-\3.\3.\3/\3/\3/\5/\u01c7\n/\3\60\3\60\2\2\61\3\3"+
		"\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21"+
		"!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!"+
		"A\"C#E$G%I&K\'M(O)Q*S+U,W-Y\2[\2]\2_\2\3\2\7\4\2\f\f\17\17\f\2\13\17\""+
		"\"\u0087\u0087\u00a2\u00a2\u1682\u1682\u2002\u200c\u202a\u202b\u2031\u2031"+
		"\u2061\u2061\u3002\u3002\5\2\62;C\\c|\3\2\62;\17\2\f\f\17\17\"#%&((*/"+
		"\61\61<<?B]_aa}}\177\177\2\u01e3\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2"+
		"\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2"+
		"\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2"+
		"\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2"+
		"\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2"+
		"\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2"+
		"\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O"+
		"\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\3b\3\2\2\2\5m\3\2"+
		"\2\2\7r\3\2\2\2\t{\3\2\2\2\13\u0082\3\2\2\2\r\u008a\3\2\2\2\17\u008d\3"+
		"\2\2\2\21\u0098\3\2\2\2\23\u009c\3\2\2\2\25\u009e\3\2\2\2\27\u00a0\3\2"+
		"\2\2\31\u00a2\3\2\2\2\33\u00a4\3\2\2\2\35\u00a6\3\2\2\2\37\u00a8\3\2\2"+
		"\2!\u00aa\3\2\2\2#\u00ac\3\2\2\2%\u00ae\3\2\2\2\'\u00b0\3\2\2\2)\u00b2"+
		"\3\2\2\2+\u00b4\3\2\2\2-\u00b6\3\2\2\2/\u00b9\3\2\2\2\61\u00bb\3\2\2\2"+
		"\63\u00c7\3\2\2\2\65\u00d7\3\2\2\2\67\u00eb\3\2\2\29\u00fd\3\2\2\2;\u0113"+
		"\3\2\2\2=\u0121\3\2\2\2?\u0123\3\2\2\2A\u012d\3\2\2\2C\u014c\3\2\2\2E"+
		"\u0160\3\2\2\2G\u016a\3\2\2\2I\u0174\3\2\2\2K\u0188\3\2\2\2M\u0198\3\2"+
		"\2\2O\u01ac\3\2\2\2Q\u01af\3\2\2\2S\u01b4\3\2\2\2U\u01b8\3\2\2\2W\u01bb"+
		"\3\2\2\2Y\u01bf\3\2\2\2[\u01c1\3\2\2\2]\u01c6\3\2\2\2_\u01c8\3\2\2\2a"+
		"c\5\21\t\2ba\3\2\2\2bc\3\2\2\2cd\3\2\2\2dh\5_\60\2eg\n\2\2\2fe\3\2\2\2"+
		"gj\3\2\2\2hf\3\2\2\2hi\3\2\2\2ik\3\2\2\2jh\3\2\2\2kl\b\2\2\2l\4\3\2\2"+
		"\2mo\7.\2\2np\5\21\t\2on\3\2\2\2op\3\2\2\2p\6\3\2\2\2qs\5\21\t\2rq\3\2"+
		"\2\2rs\3\2\2\2st\3\2\2\2tu\7?\2\2uv\7@\2\2vx\3\2\2\2wy\5\21\t\2xw\3\2"+
		"\2\2xy\3\2\2\2y\b\3\2\2\2z|\5\21\t\2{z\3\2\2\2{|\3\2\2\2|}\3\2\2\2}\177"+
		"\7\61\2\2~\u0080\5\21\t\2\177~\3\2\2\2\177\u0080\3\2\2\2\u0080\n\3\2\2"+
		"\2\u0081\u0083\5\21\t\2\u0082\u0081\3\2\2\2\u0082\u0083\3\2\2\2\u0083"+
		"\u0084\3\2\2\2\u0084\u0085\7\61\2\2\u0085\u0086\7\61\2\2\u0086\u0088\3"+
		"\2\2\2\u0087\u0089\5\21\t\2\u0088\u0087\3\2\2\2\u0088\u0089\3\2\2\2\u0089"+
		"\f\3\2\2\2\u008a\u008b\7a\2\2\u008b\16\3\2\2\2\u008c\u008e\5\21\t\2\u008d"+
		"\u008c\3\2\2\2\u008d\u008e\3\2\2\2\u008e\u0092\3\2\2\2\u008f\u0090\7\17"+
		"\2\2\u0090\u0093\7\f\2\2\u0091\u0093\7\f\2\2\u0092\u008f\3\2\2\2\u0092"+
		"\u0091\3\2\2\2\u0093\u0095\3\2\2\2\u0094\u0096\5\21\t\2\u0095\u0094\3"+
		"\2\2\2\u0095\u0096\3\2\2\2\u0096\20\3\2\2\2\u0097\u0099\t\3\2\2\u0098"+
		"\u0097\3\2\2\2\u0099\u009a\3\2\2\2\u009a\u0098\3\2\2\2\u009a\u009b\3\2"+
		"\2\2\u009b\22\3\2\2\2\u009c\u009d\7*\2\2\u009d\24\3\2\2\2\u009e\u009f"+
		"\7+\2\2\u009f\26\3\2\2\2\u00a0\u00a1\7,\2\2\u00a1\30\3\2\2\2\u00a2\u00a3"+
		"\7]\2\2\u00a3\32\3\2\2\2\u00a4\u00a5\7_\2\2\u00a5\34\3\2\2\2\u00a6\u00a7"+
		"\7}\2\2\u00a7\36\3\2\2\2\u00a8\u00a9\7\177\2\2\u00a9 \3\2\2\2\u00aa\u00ab"+
		"\7-\2\2\u00ab\"\3\2\2\2\u00ac\u00ad\7A\2\2\u00ad$\3\2\2\2\u00ae\u00af"+
		"\7/\2\2\u00af&\3\2\2\2\u00b0\u00b1\7<\2\2\u00b1(\3\2\2\2\u00b2\u00b3\7"+
		"#\2\2\u00b3*\3\2\2\2\u00b4\u00b5\7&\2\2\u00b5,\3\2\2\2\u00b6\u00b7\7&"+
		"\2\2\u00b7\u00b8\7&\2\2\u00b8.\3\2\2\2\u00b9\u00ba\7B\2\2\u00ba\60\3\2"+
		"\2\2\u00bb\u00bc\7(\2\2\u00bc\62\3\2\2\2\u00bd\u00be\7E\2\2\u00be\u00bf"+
		"\7n\2\2\u00bf\u00c0\7c\2\2\u00c0\u00c1\7u\2\2\u00c1\u00c8\7u\2\2\u00c2"+
		"\u00c3\7e\2\2\u00c3\u00c4\7n\2\2\u00c4\u00c5\7c\2\2\u00c5\u00c6\7u\2\2"+
		"\u00c6\u00c8\7u\2\2\u00c7\u00bd\3\2\2\2\u00c7\u00c2\3\2\2\2\u00c8\64\3"+
		"\2\2\2\u00c9\u00ca\7H\2\2\u00ca\u00cb\7g\2\2\u00cb\u00cc\7c\2\2\u00cc"+
		"\u00cd\7v\2\2\u00cd\u00ce\7w\2\2\u00ce\u00cf\7t\2\2\u00cf\u00d8\7g\2\2"+
		"\u00d0\u00d1\7h\2\2\u00d1\u00d2\7g\2\2\u00d2\u00d3\7c\2\2\u00d3\u00d4"+
		"\7v\2\2\u00d4\u00d5\7w\2\2\u00d5\u00d6\7t\2\2\u00d6\u00d8\7g\2\2\u00d7"+
		"\u00c9\3\2\2\2\u00d7\u00d0\3\2\2\2\u00d8\66\3\2\2\2\u00d9\u00da\7F\2\2"+
		"\u00da\u00db\7k\2\2\u00db\u00dc\7c\2\2\u00dc\u00dd\7e\2\2\u00dd\u00de"+
		"\7t\2\2\u00de\u00df\7k\2\2\u00df\u00e0\7v\2\2\u00e0\u00e1\7k\2\2\u00e1"+
		"\u00ec\7e\2\2\u00e2\u00e3\7f\2\2\u00e3\u00e4\7k\2\2\u00e4\u00e5\7c\2\2"+
		"\u00e5\u00e6\7e\2\2\u00e6\u00e7\7t\2\2\u00e7\u00e8\7k\2\2\u00e8\u00e9"+
		"\7v\2\2\u00e9\u00ea\7k\2\2\u00ea\u00ec\7e\2\2\u00eb\u00d9\3\2\2\2\u00eb"+
		"\u00e2\3\2\2\2\u00ec8\3\2\2\2\u00ed\u00ee\7*\2\2\u00ee\u00ef\7D\2\2\u00ef"+
		"\u00f0\7g\2\2\u00f0\u00f1\7h\2\2\u00f1\u00f2\7q\2\2\u00f2\u00f3\7t\2\2"+
		"\u00f3\u00f4\7g\2\2\u00f4\u00fe\7+\2\2\u00f5\u00f6\7*\2\2\u00f6\u00f7"+
		"\7d\2\2\u00f7\u00f8\7g\2\2\u00f8\u00f9\7h\2\2\u00f9\u00fa\7q\2\2\u00fa"+
		"\u00fb\7t\2\2\u00fb\u00fc\7g\2\2\u00fc\u00fe\7+\2\2\u00fd\u00ed\3\2\2"+
		"\2\u00fd\u00f5\3\2\2\2\u00fe:\3\2\2\2\u00ff\u0100\7*\2\2\u0100\u0101\7"+
		"H\2\2\u0101\u0102\7n\2\2\u0102\u0103\7q\2\2\u0103\u0104\7c\2\2\u0104\u0105"+
		"\7v\2\2\u0105\u0106\7k\2\2\u0106\u0107\7p\2\2\u0107\u0108\7i\2\2\u0108"+
		"\u0114\7+\2\2\u0109\u010a\7*\2\2\u010a\u010b\7h\2\2\u010b\u010c\7n\2\2"+
		"\u010c\u010d\7q\2\2\u010d\u010e\7c\2\2\u010e\u010f\7v\2\2\u010f\u0110"+
		"\7k\2\2\u0110\u0111\7p\2\2\u0111\u0112\7i\2\2\u0112\u0114\7+\2\2\u0113"+
		"\u00ff\3\2\2\2\u0113\u0109\3\2\2\2\u0114<\3\2\2\2\u0115\u0116\7U\2\2\u0116"+
		"\u0117\7{\2\2\u0117\u0118\7o\2\2\u0118\u0119\7d\2\2\u0119\u011a\7q\2\2"+
		"\u011a\u0122\7n\2\2\u011b\u011c\7u\2\2\u011c\u011d\7{\2\2\u011d\u011e"+
		"\7o\2\2\u011e\u011f\7d\2\2\u011f\u0120\7q\2\2\u0120\u0122\7n\2\2\u0121"+
		"\u0115\3\2\2\2\u0121\u011b\3\2\2\2\u0122>\3\2\2\2\u0123\u0124\7U\2\2\u0124"+
		"\u0125\7{\2\2\u0125\u0126\7n\2\2\u0126\u0127\7n\2\2\u0127\u0128\7c\2\2"+
		"\u0128\u0129\7d\2\2\u0129\u012a\7n\2\2\u012a\u012b\7g\2\2\u012b\u012c"+
		"\7u\2\2\u012c@\3\2\2\2\u012d\u012e\7g\2\2\u012e\u012f\7z\2\2\u012f\u0130"+
		"\7r\2\2\u0130\u0131\7n\2\2\u0131\u0132\7k\2\2\u0132\u0133\7e\2\2\u0133"+
		"\u0134\7k\2\2\u0134\u0135\7v\2\2\u0135B\3\2\2\2\u0136\u0137\7F\2\2\u0137"+
		"\u0138\7g\2\2\u0138\u0139\7t\2\2\u0139\u013a\7q\2\2\u013a\u013b\7o\2\2"+
		"\u013b\u013c\7c\2\2\u013c\u013d\7p\2\2\u013d\u013e\7k\2\2\u013e\u013f"+
		"\7|\2\2\u013f\u0140\7g\2\2\u0140\u014d\7t\2\2\u0141\u0142\7f\2\2\u0142"+
		"\u0143\7g\2\2\u0143\u0144\7t\2\2\u0144\u0145\7q\2\2\u0145\u0146\7o\2\2"+
		"\u0146\u0147\7c\2\2\u0147\u0148\7p\2\2\u0148\u0149\7k\2\2\u0149\u014a"+
		"\7|\2\2\u014a\u014b\7g\2\2\u014b\u014d\7t\2\2\u014c\u0136\3\2\2\2\u014c"+
		"\u0141\3\2\2\2\u014dD\3\2\2\2\u014e\u014f\7T\2\2\u014f\u0150\7q\2\2\u0150"+
		"\u0151\7o\2\2\u0151\u0152\7c\2\2\u0152\u0153\7p\2\2\u0153\u0154\7k\2\2"+
		"\u0154\u0155\7|\2\2\u0155\u0156\7g\2\2\u0156\u0161\7t\2\2\u0157\u0158"+
		"\7t\2\2\u0158\u0159\7q\2\2\u0159\u015a\7o\2\2\u015a\u015b\7c\2\2\u015b"+
		"\u015c\7p\2\2\u015c\u015d\7k\2\2\u015d\u015e\7|\2\2\u015e\u015f\7g\2\2"+
		"\u015f\u0161\7t\2\2\u0160\u014e\3\2\2\2\u0160\u0157\3\2\2\2\u0161F\3\2"+
		"\2\2\u0162\u0163\7V\2\2\u0163\u0164\7j\2\2\u0164\u0165\7g\2\2\u0165\u016b"+
		"\7p\2\2\u0166\u0167\7v\2\2\u0167\u0168\7j\2\2\u0168\u0169\7g\2\2\u0169"+
		"\u016b\7p\2\2\u016a\u0162\3\2\2\2\u016a\u0166\3\2\2\2\u016bH\3\2\2\2\u016c"+
		"\u016d\7G\2\2\u016d\u016e\7n\2\2\u016e\u016f\7u\2\2\u016f\u0175\7g\2\2"+
		"\u0170\u0171\7g\2\2\u0171\u0172\7n\2\2\u0172\u0173\7u\2\2\u0173\u0175"+
		"\7g\2\2\u0174\u016c\3\2\2\2\u0174\u0170\3\2\2\2\u0175J\3\2\2\2\u0176\u0177"+
		"\7R\2\2\u0177\u0178\7t\2\2\u0178\u0179\7q\2\2\u0179\u017a\7r\2\2\u017a"+
		"\u017b\7c\2\2\u017b\u017c\7i\2\2\u017c\u017d\7c\2\2\u017d\u017e\7v\2\2"+
		"\u017e\u0189\7g\2\2\u017f\u0180\7r\2\2\u0180\u0181\7t\2\2\u0181\u0182"+
		"\7q\2\2\u0182\u0183\7r\2\2\u0183\u0184\7c\2\2\u0184\u0185\7i\2\2\u0185"+
		"\u0186\7c\2\2\u0186\u0187\7v\2\2\u0187\u0189\7g\2\2\u0188\u0176\3\2\2"+
		"\2\u0188\u017f\3\2\2\2\u0189L\3\2\2\2\u018a\u018b\7N\2\2\u018b\u018c\7"+
		"k\2\2\u018c\u018d\7v\2\2\u018d\u018e\7g\2\2\u018e\u018f\7t\2\2\u018f\u0190"+
		"\7c\2\2\u0190\u0199\7n\2\2\u0191\u0192\7n\2\2\u0192\u0193\7k\2\2\u0193"+
		"\u0194\7v\2\2\u0194\u0195\7g\2\2\u0195\u0196\7t\2\2\u0196\u0197\7c\2\2"+
		"\u0197\u0199\7n\2\2\u0198\u018a\3\2\2\2\u0198\u0191\3\2\2\2\u0199N\3\2"+
		"\2\2\u019a\u019b\7W\2\2\u019b\u019c\7p\2\2\u019c\u019d\7e\2\2\u019d\u019e"+
		"\7j\2\2\u019e\u019f\7c\2\2\u019f\u01a0\7p\2\2\u01a0\u01a1\7i\2\2\u01a1"+
		"\u01a2\7g\2\2\u01a2\u01ad\7f\2\2\u01a3\u01a4\7w\2\2\u01a4\u01a5\7p\2\2"+
		"\u01a5\u01a6\7e\2\2\u01a6\u01a7\7j\2\2\u01a7\u01a8\7c\2\2\u01a8\u01a9"+
		"\7p\2\2\u01a9\u01aa\7i\2\2\u01aa\u01ab\7g\2\2\u01ab\u01ad\7f\2\2\u01ac"+
		"\u019a\3\2\2\2\u01ac\u01a3\3\2\2\2\u01adP\3\2\2\2\u01ae\u01b0\5[.\2\u01af"+
		"\u01ae\3\2\2\2\u01b0\u01b1\3\2\2\2\u01b1\u01af\3\2\2\2\u01b1\u01b2\3\2"+
		"\2\2\u01b2R\3\2\2\2\u01b3\u01b5\5Y-\2\u01b4\u01b3\3\2\2\2\u01b5\u01b6"+
		"\3\2\2\2\u01b6\u01b4\3\2\2\2\u01b6\u01b7\3\2\2\2\u01b7T\3\2\2\2\u01b8"+
		"\u01b9\5]/\2\u01b9V\3\2\2\2\u01ba\u01bc\5]/\2\u01bb\u01ba\3\2\2\2\u01bc"+
		"\u01bd\3\2\2\2\u01bd\u01bb\3\2\2\2\u01bd\u01be\3\2\2\2\u01beX\3\2\2\2"+
		"\u01bf\u01c0\t\4\2\2\u01c0Z\3\2\2\2\u01c1\u01c2\t\5\2\2\u01c2\\\3\2\2"+
		"\2\u01c3\u01c4\7^\2\2\u01c4\u01c7\13\2\2\2\u01c5\u01c7\n\6\2\2\u01c6\u01c3"+
		"\3\2\2\2\u01c6\u01c5\3\2\2\2\u01c7^\3\2\2\2\u01c8\u01c9\7%\2\2\u01c9`"+
		"\3\2\2\2!\2bhorx{\177\u0082\u0088\u008d\u0092\u0095\u009a\u00c7\u00d7"+
		"\u00eb\u00fd\u0113\u0121\u014c\u0160\u016a\u0174\u0188\u0198\u01ac\u01b1"+
		"\u01b6\u01bd\u01c6\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}