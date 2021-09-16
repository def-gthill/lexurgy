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
		INEXACT=20, NEGATION=21, SYLLABLE_BOUNDARY=22, WORD_BOUNDARY=23, BETWEEN_WORDS=24, 
		CLASSREF=25, INTERSECTION=26, CLASS_DECL=27, FEATURE_DECL=28, SYLLABLE_FEATURE=29, 
		DIACRITIC=30, DIA_BEFORE=31, DIA_FIRST=32, DIA_FLOATING=33, SYMBOL=34, 
		SYLLABLE_DECL=35, EXPLICIT_SYLLABLES=36, CLEAR_SYLLABLES=37, ANY_SYLLABLE=38, 
		DEROMANIZER=39, ROMANIZER=40, ALL_MATCHING=41, FIRST_MATCHING=42, PROPAGATE=43, 
		LTR=44, RTL=45, LITERAL=46, UNCHANGED=47, NUMBER=48, NAME=49, STR1=50, 
		STR=51;
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
			"INEXACT", "NEGATION", "SYLLABLE_BOUNDARY", "WORD_BOUNDARY", "BETWEEN_WORDS", 
			"CLASSREF", "INTERSECTION", "CLASS_DECL", "FEATURE_DECL", "SYLLABLE_FEATURE", 
			"DIACRITIC", "DIA_BEFORE", "DIA_FIRST", "DIA_FLOATING", "SYMBOL", "SYLLABLE_DECL", 
			"EXPLICIT_SYLLABLES", "CLEAR_SYLLABLES", "ANY_SYLLABLE", "DEROMANIZER", 
			"ROMANIZER", "ALL_MATCHING", "FIRST_MATCHING", "PROPAGATE", "LTR", "RTL", 
			"LITERAL", "UNCHANGED", "NUMBER", "NAME", "STR1", "STR", "CHAR", "DIGIT", 
			"ANY", "COMMENT_START"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, null, "'_'", null, null, "'('", "')'", 
			"'*'", "'['", "']'", "'{'", "'}'", "'+'", "'?'", "'-'", "':'", "'~'", 
			"'!'", "'.'", "'$'", "'$$'", "'@'", "'&'", null, null, null, null, null, 
			null, null, null, "'Syllables'", "'explicit'", "'clear'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "COMMENT", "SEP", "CHANGE", "CONDITION", "EXCLUSION", "ANCHOR", 
			"NEWLINE", "WHITESPACE", "O_PAREN", "C_PAREN", "NULL", "MATRIX_START", 
			"MATRIX_END", "LIST_START", "LIST_END", "AT_LEAST_ONE", "OPTIONAL", "HYPHEN", 
			"RULE_START", "INEXACT", "NEGATION", "SYLLABLE_BOUNDARY", "WORD_BOUNDARY", 
			"BETWEEN_WORDS", "CLASSREF", "INTERSECTION", "CLASS_DECL", "FEATURE_DECL", 
			"SYLLABLE_FEATURE", "DIACRITIC", "DIA_BEFORE", "DIA_FIRST", "DIA_FLOATING", 
			"SYMBOL", "SYLLABLE_DECL", "EXPLICIT_SYLLABLES", "CLEAR_SYLLABLES", "ANY_SYLLABLE", 
			"DEROMANIZER", "ROMANIZER", "ALL_MATCHING", "FIRST_MATCHING", "PROPAGATE", 
			"LTR", "RTL", "LITERAL", "UNCHANGED", "NUMBER", "NAME", "STR1", "STR"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\65\u022c\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64"+
		"\t\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\3\2\5\2s\n\2\3\2\3\2\7\2w\n"+
		"\2\f\2\16\2z\13\2\3\2\3\2\3\3\3\3\5\3\u0080\n\3\3\4\5\4\u0083\n\4\3\4"+
		"\3\4\3\4\3\4\5\4\u0089\n\4\3\5\5\5\u008c\n\5\3\5\3\5\5\5\u0090\n\5\3\6"+
		"\5\6\u0093\n\6\3\6\3\6\3\6\3\6\5\6\u0099\n\6\3\7\3\7\3\b\5\b\u009e\n\b"+
		"\3\b\3\b\3\b\5\b\u00a3\n\b\3\b\5\b\u00a6\n\b\3\t\6\t\u00a9\n\t\r\t\16"+
		"\t\u00aa\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3"+
		"\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3"+
		"\27\3\30\3\30\3\31\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\34\3\34\3"+
		"\34\3\34\3\34\3\34\3\34\3\34\5\34\u00dc\n\34\3\35\3\35\3\35\3\35\3\35"+
		"\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\5\35\u00ec\n\35\3\36\3\36"+
		"\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36"+
		"\3\36\3\36\3\36\3\36\5\36\u0102\n\36\3\37\3\37\3\37\3\37\3\37\3\37\3\37"+
		"\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\5\37\u0116\n\37"+
		"\3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \5 \u0128\n \3!\3!\3!"+
		"\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\5!\u0138\n!\3\"\3\"\3\"\3\"\3\"\3\""+
		"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\5\"\u014e\n\""+
		"\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\5#\u015c\n#\3$\3$\3$\3$\3$\3$\3$"+
		"\3$\3$\3$\3%\3%\3%\3%\3%\3%\3%\3%\3%\3&\3&\3&\3&\3&\3&\3\'\3\'\3\'\3\'"+
		"\3\'\3\'\3\'\3\'\3\'\3\'\5\'\u0181\n\'\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3"+
		"(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\5(\u0199\n(\3)\3)\3)\3)\3)\3)\3)\3"+
		")\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\5)\u01ad\n)\3*\3*\3*\3*\3*\3*\3*\3*\5"+
		"*\u01b7\n*\3+\3+\3+\3+\3+\3+\3+\3+\5+\u01c1\n+\3,\3,\3,\3,\3,\3,\3,\3"+
		",\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,\5,\u01d5\n,\3-\3-\3-\3-\3-\3-\3-\3-\3"+
		"-\5-\u01e0\n-\3.\3.\3.\3.\3.\3.\3.\3.\3.\5.\u01eb\n.\3/\3/\3/\3/\3/\3"+
		"/\3/\3/\3/\3/\3/\3/\3/\3/\5/\u01fb\n/\3\60\3\60\3\60\3\60\3\60\3\60\3"+
		"\60\3\60\3\60\3\60\3\60\3\60\3\60\3\60\3\60\3\60\3\60\3\60\5\60\u020f"+
		"\n\60\3\61\6\61\u0212\n\61\r\61\16\61\u0213\3\62\6\62\u0217\n\62\r\62"+
		"\16\62\u0218\3\63\3\63\3\64\6\64\u021e\n\64\r\64\16\64\u021f\3\65\3\65"+
		"\3\66\3\66\3\67\3\67\3\67\5\67\u0229\n\67\38\38\2\29\3\3\5\4\7\5\t\6\13"+
		"\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'"+
		"\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'"+
		"M(O)Q*S+U,W-Y.[/]\60_\61a\62c\63e\64g\65i\2k\2m\2o\2\3\2\7\4\2\f\f\17"+
		"\17\f\2\13\17\"\"\u0087\u0087\u00a2\u00a2\u1682\u1682\u2002\u200c\u202a"+
		"\u202b\u2031\u2031\u2061\u2061\u3002\u3002\5\2\62;C\\c|\3\2\62;\16\2\f"+
		"\f\17\17\"#%&((*\61<<?B]_aa}}\177\u0080\2\u024c\2\3\3\2\2\2\2\5\3\2\2"+
		"\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21"+
		"\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2"+
		"\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3"+
		"\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3"+
		"\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3"+
		"\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2"+
		"\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2"+
		"Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3"+
		"\2\2\2\2g\3\2\2\2\3r\3\2\2\2\5}\3\2\2\2\7\u0082\3\2\2\2\t\u008b\3\2\2"+
		"\2\13\u0092\3\2\2\2\r\u009a\3\2\2\2\17\u009d\3\2\2\2\21\u00a8\3\2\2\2"+
		"\23\u00ac\3\2\2\2\25\u00ae\3\2\2\2\27\u00b0\3\2\2\2\31\u00b2\3\2\2\2\33"+
		"\u00b4\3\2\2\2\35\u00b6\3\2\2\2\37\u00b8\3\2\2\2!\u00ba\3\2\2\2#\u00bc"+
		"\3\2\2\2%\u00be\3\2\2\2\'\u00c0\3\2\2\2)\u00c2\3\2\2\2+\u00c4\3\2\2\2"+
		"-\u00c6\3\2\2\2/\u00c8\3\2\2\2\61\u00ca\3\2\2\2\63\u00cd\3\2\2\2\65\u00cf"+
		"\3\2\2\2\67\u00db\3\2\2\29\u00eb\3\2\2\2;\u0101\3\2\2\2=\u0115\3\2\2\2"+
		"?\u0127\3\2\2\2A\u0137\3\2\2\2C\u014d\3\2\2\2E\u015b\3\2\2\2G\u015d\3"+
		"\2\2\2I\u0167\3\2\2\2K\u0170\3\2\2\2M\u0180\3\2\2\2O\u0198\3\2\2\2Q\u01ac"+
		"\3\2\2\2S\u01b6\3\2\2\2U\u01c0\3\2\2\2W\u01d4\3\2\2\2Y\u01df\3\2\2\2["+
		"\u01ea\3\2\2\2]\u01fa\3\2\2\2_\u020e\3\2\2\2a\u0211\3\2\2\2c\u0216\3\2"+
		"\2\2e\u021a\3\2\2\2g\u021d\3\2\2\2i\u0221\3\2\2\2k\u0223\3\2\2\2m\u0228"+
		"\3\2\2\2o\u022a\3\2\2\2qs\5\21\t\2rq\3\2\2\2rs\3\2\2\2st\3\2\2\2tx\5o"+
		"8\2uw\n\2\2\2vu\3\2\2\2wz\3\2\2\2xv\3\2\2\2xy\3\2\2\2y{\3\2\2\2zx\3\2"+
		"\2\2{|\b\2\2\2|\4\3\2\2\2}\177\7.\2\2~\u0080\5\21\t\2\177~\3\2\2\2\177"+
		"\u0080\3\2\2\2\u0080\6\3\2\2\2\u0081\u0083\5\21\t\2\u0082\u0081\3\2\2"+
		"\2\u0082\u0083\3\2\2\2\u0083\u0084\3\2\2\2\u0084\u0085\7?\2\2\u0085\u0086"+
		"\7@\2\2\u0086\u0088\3\2\2\2\u0087\u0089\5\21\t\2\u0088\u0087\3\2\2\2\u0088"+
		"\u0089\3\2\2\2\u0089\b\3\2\2\2\u008a\u008c\5\21\t\2\u008b\u008a\3\2\2"+
		"\2\u008b\u008c\3\2\2\2\u008c\u008d\3\2\2\2\u008d\u008f\7\61\2\2\u008e"+
		"\u0090\5\21\t\2\u008f\u008e\3\2\2\2\u008f\u0090\3\2\2\2\u0090\n\3\2\2"+
		"\2\u0091\u0093\5\21\t\2\u0092\u0091\3\2\2\2\u0092\u0093\3\2\2\2\u0093"+
		"\u0094\3\2\2\2\u0094\u0095\7\61\2\2\u0095\u0096\7\61\2\2\u0096\u0098\3"+
		"\2\2\2\u0097\u0099\5\21\t\2\u0098\u0097\3\2\2\2\u0098\u0099\3\2\2\2\u0099"+
		"\f\3\2\2\2\u009a\u009b\7a\2\2\u009b\16\3\2\2\2\u009c\u009e\5\21\t\2\u009d"+
		"\u009c\3\2\2\2\u009d\u009e\3\2\2\2\u009e\u00a2\3\2\2\2\u009f\u00a0\7\17"+
		"\2\2\u00a0\u00a3\7\f\2\2\u00a1\u00a3\7\f\2\2\u00a2\u009f\3\2\2\2\u00a2"+
		"\u00a1\3\2\2\2\u00a3\u00a5\3\2\2\2\u00a4\u00a6\5\21\t\2\u00a5\u00a4\3"+
		"\2\2\2\u00a5\u00a6\3\2\2\2\u00a6\20\3\2\2\2\u00a7\u00a9\t\3\2\2\u00a8"+
		"\u00a7\3\2\2\2\u00a9\u00aa\3\2\2\2\u00aa\u00a8\3\2\2\2\u00aa\u00ab\3\2"+
		"\2\2\u00ab\22\3\2\2\2\u00ac\u00ad\7*\2\2\u00ad\24\3\2\2\2\u00ae\u00af"+
		"\7+\2\2\u00af\26\3\2\2\2\u00b0\u00b1\7,\2\2\u00b1\30\3\2\2\2\u00b2\u00b3"+
		"\7]\2\2\u00b3\32\3\2\2\2\u00b4\u00b5\7_\2\2\u00b5\34\3\2\2\2\u00b6\u00b7"+
		"\7}\2\2\u00b7\36\3\2\2\2\u00b8\u00b9\7\177\2\2\u00b9 \3\2\2\2\u00ba\u00bb"+
		"\7-\2\2\u00bb\"\3\2\2\2\u00bc\u00bd\7A\2\2\u00bd$\3\2\2\2\u00be\u00bf"+
		"\7/\2\2\u00bf&\3\2\2\2\u00c0\u00c1\7<\2\2\u00c1(\3\2\2\2\u00c2\u00c3\7"+
		"\u0080\2\2\u00c3*\3\2\2\2\u00c4\u00c5\7#\2\2\u00c5,\3\2\2\2\u00c6\u00c7"+
		"\7\60\2\2\u00c7.\3\2\2\2\u00c8\u00c9\7&\2\2\u00c9\60\3\2\2\2\u00ca\u00cb"+
		"\7&\2\2\u00cb\u00cc\7&\2\2\u00cc\62\3\2\2\2\u00cd\u00ce\7B\2\2\u00ce\64"+
		"\3\2\2\2\u00cf\u00d0\7(\2\2\u00d0\66\3\2\2\2\u00d1\u00d2\7E\2\2\u00d2"+
		"\u00d3\7n\2\2\u00d3\u00d4\7c\2\2\u00d4\u00d5\7u\2\2\u00d5\u00dc\7u\2\2"+
		"\u00d6\u00d7\7e\2\2\u00d7\u00d8\7n\2\2\u00d8\u00d9\7c\2\2\u00d9\u00da"+
		"\7u\2\2\u00da\u00dc\7u\2\2\u00db\u00d1\3\2\2\2\u00db\u00d6\3\2\2\2\u00dc"+
		"8\3\2\2\2\u00dd\u00de\7H\2\2\u00de\u00df\7g\2\2\u00df\u00e0\7c\2\2\u00e0"+
		"\u00e1\7v\2\2\u00e1\u00e2\7w\2\2\u00e2\u00e3\7t\2\2\u00e3\u00ec\7g\2\2"+
		"\u00e4\u00e5\7h\2\2\u00e5\u00e6\7g\2\2\u00e6\u00e7\7c\2\2\u00e7\u00e8"+
		"\7v\2\2\u00e8\u00e9\7w\2\2\u00e9\u00ea\7t\2\2\u00ea\u00ec\7g\2\2\u00eb"+
		"\u00dd\3\2\2\2\u00eb\u00e4\3\2\2\2\u00ec:\3\2\2\2\u00ed\u00ee\7*\2\2\u00ee"+
		"\u00ef\7U\2\2\u00ef\u00f0\7{\2\2\u00f0\u00f1\7n\2\2\u00f1\u00f2\7n\2\2"+
		"\u00f2\u00f3\7c\2\2\u00f3\u00f4\7d\2\2\u00f4\u00f5\7n\2\2\u00f5\u00f6"+
		"\7g\2\2\u00f6\u0102\7+\2\2\u00f7\u00f8\7*\2\2\u00f8\u00f9\7u\2\2\u00f9"+
		"\u00fa\7{\2\2\u00fa\u00fb\7n\2\2\u00fb\u00fc\7n\2\2\u00fc\u00fd\7c\2\2"+
		"\u00fd\u00fe\7d\2\2\u00fe\u00ff\7n\2\2\u00ff\u0100\7g\2\2\u0100\u0102"+
		"\7+\2\2\u0101\u00ed\3\2\2\2\u0101\u00f7\3\2\2\2\u0102<\3\2\2\2\u0103\u0104"+
		"\7F\2\2\u0104\u0105\7k\2\2\u0105\u0106\7c\2\2\u0106\u0107\7e\2\2\u0107"+
		"\u0108\7t\2\2\u0108\u0109\7k\2\2\u0109\u010a\7v\2\2\u010a\u010b\7k\2\2"+
		"\u010b\u0116\7e\2\2\u010c\u010d\7f\2\2\u010d\u010e\7k\2\2\u010e\u010f"+
		"\7c\2\2\u010f\u0110\7e\2\2\u0110\u0111\7t\2\2\u0111\u0112\7k\2\2\u0112"+
		"\u0113\7v\2\2\u0113\u0114\7k\2\2\u0114\u0116\7e\2\2\u0115\u0103\3\2\2"+
		"\2\u0115\u010c\3\2\2\2\u0116>\3\2\2\2\u0117\u0118\7*\2\2\u0118\u0119\7"+
		"D\2\2\u0119\u011a\7g\2\2\u011a\u011b\7h\2\2\u011b\u011c\7q\2\2\u011c\u011d"+
		"\7t\2\2\u011d\u011e\7g\2\2\u011e\u0128\7+\2\2\u011f\u0120\7*\2\2\u0120"+
		"\u0121\7d\2\2\u0121\u0122\7g\2\2\u0122\u0123\7h\2\2\u0123\u0124\7q\2\2"+
		"\u0124\u0125\7t\2\2\u0125\u0126\7g\2\2\u0126\u0128\7+\2\2\u0127\u0117"+
		"\3\2\2\2\u0127\u011f\3\2\2\2\u0128@\3\2\2\2\u0129\u012a\7*\2\2\u012a\u012b"+
		"\7H\2\2\u012b\u012c\7k\2\2\u012c\u012d\7t\2\2\u012d\u012e\7u\2\2\u012e"+
		"\u012f\7v\2\2\u012f\u0138\7+\2\2\u0130\u0131\7*\2\2\u0131\u0132\7h\2\2"+
		"\u0132\u0133\7k\2\2\u0133\u0134\7t\2\2\u0134\u0135\7u\2\2\u0135\u0136"+
		"\7v\2\2\u0136\u0138\7+\2\2\u0137\u0129\3\2\2\2\u0137\u0130\3\2\2\2\u0138"+
		"B\3\2\2\2\u0139\u013a\7*\2\2\u013a\u013b\7H\2\2\u013b\u013c\7n\2\2\u013c"+
		"\u013d\7q\2\2\u013d\u013e\7c\2\2\u013e\u013f\7v\2\2\u013f\u0140\7k\2\2"+
		"\u0140\u0141\7p\2\2\u0141\u0142\7i\2\2\u0142\u014e\7+\2\2\u0143\u0144"+
		"\7*\2\2\u0144\u0145\7h\2\2\u0145\u0146\7n\2\2\u0146\u0147\7q\2\2\u0147"+
		"\u0148\7c\2\2\u0148\u0149\7v\2\2\u0149\u014a\7k\2\2\u014a\u014b\7p\2\2"+
		"\u014b\u014c\7i\2\2\u014c\u014e\7+\2\2\u014d\u0139\3\2\2\2\u014d\u0143"+
		"\3\2\2\2\u014eD\3\2\2\2\u014f\u0150\7U\2\2\u0150\u0151\7{\2\2\u0151\u0152"+
		"\7o\2\2\u0152\u0153\7d\2\2\u0153\u0154\7q\2\2\u0154\u015c\7n\2\2\u0155"+
		"\u0156\7u\2\2\u0156\u0157\7{\2\2\u0157\u0158\7o\2\2\u0158\u0159\7d\2\2"+
		"\u0159\u015a\7q\2\2\u015a\u015c\7n\2\2\u015b\u014f\3\2\2\2\u015b\u0155"+
		"\3\2\2\2\u015cF\3\2\2\2\u015d\u015e\7U\2\2\u015e\u015f\7{\2\2\u015f\u0160"+
		"\7n\2\2\u0160\u0161\7n\2\2\u0161\u0162\7c\2\2\u0162\u0163\7d\2\2\u0163"+
		"\u0164\7n\2\2\u0164\u0165\7g\2\2\u0165\u0166\7u\2\2\u0166H\3\2\2\2\u0167"+
		"\u0168\7g\2\2\u0168\u0169\7z\2\2\u0169\u016a\7r\2\2\u016a\u016b\7n\2\2"+
		"\u016b\u016c\7k\2\2\u016c\u016d\7e\2\2\u016d\u016e\7k\2\2\u016e\u016f"+
		"\7v\2\2\u016fJ\3\2\2\2\u0170\u0171\7e\2\2\u0171\u0172\7n\2\2\u0172\u0173"+
		"\7g\2\2\u0173\u0174\7c\2\2\u0174\u0175\7t\2\2\u0175L\3\2\2\2\u0176\u0177"+
		"\7>\2\2\u0177\u0178\7U\2\2\u0178\u0179\7{\2\2\u0179\u017a\7n\2\2\u017a"+
		"\u0181\7@\2\2\u017b\u017c\7>\2\2\u017c\u017d\7u\2\2\u017d\u017e\7{\2\2"+
		"\u017e\u017f\7n\2\2\u017f\u0181\7@\2\2\u0180\u0176\3\2\2\2\u0180\u017b"+
		"\3\2\2\2\u0181N\3\2\2\2\u0182\u0183\7F\2\2\u0183\u0184\7g\2\2\u0184\u0185"+
		"\7t\2\2\u0185\u0186\7q\2\2\u0186\u0187\7o\2\2\u0187\u0188\7c\2\2\u0188"+
		"\u0189\7p\2\2\u0189\u018a\7k\2\2\u018a\u018b\7|\2\2\u018b\u018c\7g\2\2"+
		"\u018c\u0199\7t\2\2\u018d\u018e\7f\2\2\u018e\u018f\7g\2\2\u018f\u0190"+
		"\7t\2\2\u0190\u0191\7q\2\2\u0191\u0192\7o\2\2\u0192\u0193\7c\2\2\u0193"+
		"\u0194\7p\2\2\u0194\u0195\7k\2\2\u0195\u0196\7|\2\2\u0196\u0197\7g\2\2"+
		"\u0197\u0199\7t\2\2\u0198\u0182\3\2\2\2\u0198\u018d\3\2\2\2\u0199P\3\2"+
		"\2\2\u019a\u019b\7T\2\2\u019b\u019c\7q\2\2\u019c\u019d\7o\2\2\u019d\u019e"+
		"\7c\2\2\u019e\u019f\7p\2\2\u019f\u01a0\7k\2\2\u01a0\u01a1\7|\2\2\u01a1"+
		"\u01a2\7g\2\2\u01a2\u01ad\7t\2\2\u01a3\u01a4\7t\2\2\u01a4\u01a5\7q\2\2"+
		"\u01a5\u01a6\7o\2\2\u01a6\u01a7\7c\2\2\u01a7\u01a8\7p\2\2\u01a8\u01a9"+
		"\7k\2\2\u01a9\u01aa\7|\2\2\u01aa\u01ab\7g\2\2\u01ab\u01ad\7t\2\2\u01ac"+
		"\u019a\3\2\2\2\u01ac\u01a3\3\2\2\2\u01adR\3\2\2\2\u01ae\u01af\7V\2\2\u01af"+
		"\u01b0\7j\2\2\u01b0\u01b1\7g\2\2\u01b1\u01b7\7p\2\2\u01b2\u01b3\7v\2\2"+
		"\u01b3\u01b4\7j\2\2\u01b4\u01b5\7g\2\2\u01b5\u01b7\7p\2\2\u01b6\u01ae"+
		"\3\2\2\2\u01b6\u01b2\3\2\2\2\u01b7T\3\2\2\2\u01b8\u01b9\7G\2\2\u01b9\u01ba"+
		"\7n\2\2\u01ba\u01bb\7u\2\2\u01bb\u01c1\7g\2\2\u01bc\u01bd\7g\2\2\u01bd"+
		"\u01be\7n\2\2\u01be\u01bf\7u\2\2\u01bf\u01c1\7g\2\2\u01c0\u01b8\3\2\2"+
		"\2\u01c0\u01bc\3\2\2\2\u01c1V\3\2\2\2\u01c2\u01c3\7R\2\2\u01c3\u01c4\7"+
		"t\2\2\u01c4\u01c5\7q\2\2\u01c5\u01c6\7r\2\2\u01c6\u01c7\7c\2\2\u01c7\u01c8"+
		"\7i\2\2\u01c8\u01c9\7c\2\2\u01c9\u01ca\7v\2\2\u01ca\u01d5\7g\2\2\u01cb"+
		"\u01cc\7r\2\2\u01cc\u01cd\7t\2\2\u01cd\u01ce\7q\2\2\u01ce\u01cf\7r\2\2"+
		"\u01cf\u01d0\7c\2\2\u01d0\u01d1\7i\2\2\u01d1\u01d2\7c\2\2\u01d2\u01d3"+
		"\7v\2\2\u01d3\u01d5\7g\2\2\u01d4\u01c2\3\2\2\2\u01d4\u01cb\3\2\2\2\u01d5"+
		"X\3\2\2\2\u01d6\u01d7\7N\2\2\u01d7\u01d8\7V\2\2\u01d8\u01e0\7T\2\2\u01d9"+
		"\u01da\7N\2\2\u01da\u01db\7v\2\2\u01db\u01e0\7t\2\2\u01dc\u01dd\7n\2\2"+
		"\u01dd\u01de\7v\2\2\u01de\u01e0\7t\2\2\u01df\u01d6\3\2\2\2\u01df\u01d9"+
		"\3\2\2\2\u01df\u01dc\3\2\2\2\u01e0Z\3\2\2\2\u01e1\u01e2\7T\2\2\u01e2\u01e3"+
		"\7V\2\2\u01e3\u01eb\7N\2\2\u01e4\u01e5\7T\2\2\u01e5\u01e6\7v\2\2\u01e6"+
		"\u01eb\7n\2\2\u01e7\u01e8\7t\2\2\u01e8\u01e9\7v\2\2\u01e9\u01eb\7n\2\2"+
		"\u01ea\u01e1\3\2\2\2\u01ea\u01e4\3\2\2\2\u01ea\u01e7\3\2\2\2\u01eb\\\3"+
		"\2\2\2\u01ec\u01ed\7N\2\2\u01ed\u01ee\7k\2\2\u01ee\u01ef\7v\2\2\u01ef"+
		"\u01f0\7g\2\2\u01f0\u01f1\7t\2\2\u01f1\u01f2\7c\2\2\u01f2\u01fb\7n\2\2"+
		"\u01f3\u01f4\7n\2\2\u01f4\u01f5\7k\2\2\u01f5\u01f6\7v\2\2\u01f6\u01f7"+
		"\7g\2\2\u01f7\u01f8\7t\2\2\u01f8\u01f9\7c\2\2\u01f9\u01fb\7n\2\2\u01fa"+
		"\u01ec\3\2\2\2\u01fa\u01f3\3\2\2\2\u01fb^\3\2\2\2\u01fc\u01fd\7W\2\2\u01fd"+
		"\u01fe\7p\2\2\u01fe\u01ff\7e\2\2\u01ff\u0200\7j\2\2\u0200\u0201\7c\2\2"+
		"\u0201\u0202\7p\2\2\u0202\u0203\7i\2\2\u0203\u0204\7g\2\2\u0204\u020f"+
		"\7f\2\2\u0205\u0206\7w\2\2\u0206\u0207\7p\2\2\u0207\u0208\7e\2\2\u0208"+
		"\u0209\7j\2\2\u0209\u020a\7c\2\2\u020a\u020b\7p\2\2\u020b\u020c\7i\2\2"+
		"\u020c\u020d\7g\2\2\u020d\u020f\7f\2\2\u020e\u01fc\3\2\2\2\u020e\u0205"+
		"\3\2\2\2\u020f`\3\2\2\2\u0210\u0212\5k\66\2\u0211\u0210\3\2\2\2\u0212"+
		"\u0213\3\2\2\2\u0213\u0211\3\2\2\2\u0213\u0214\3\2\2\2\u0214b\3\2\2\2"+
		"\u0215\u0217\5i\65\2\u0216\u0215\3\2\2\2\u0217\u0218\3\2\2\2\u0218\u0216"+
		"\3\2\2\2\u0218\u0219\3\2\2\2\u0219d\3\2\2\2\u021a\u021b\5m\67\2\u021b"+
		"f\3\2\2\2\u021c\u021e\5m\67\2\u021d\u021c\3\2\2\2\u021e\u021f\3\2\2\2"+
		"\u021f\u021d\3\2\2\2\u021f\u0220\3\2\2\2\u0220h\3\2\2\2\u0221\u0222\t"+
		"\4\2\2\u0222j\3\2\2\2\u0223\u0224\t\5\2\2\u0224l\3\2\2\2\u0225\u0226\7"+
		"^\2\2\u0226\u0229\13\2\2\2\u0227\u0229\n\6\2\2\u0228\u0225\3\2\2\2\u0228"+
		"\u0227\3\2\2\2\u0229n\3\2\2\2\u022a\u022b\7%\2\2\u022bp\3\2\2\2&\2rx\177"+
		"\u0082\u0088\u008b\u008f\u0092\u0098\u009d\u00a2\u00a5\u00aa\u00db\u00eb"+
		"\u0101\u0115\u0127\u0137\u014d\u015b\u0180\u0198\u01ac\u01b6\u01c0\u01d4"+
		"\u01df\u01ea\u01fa\u020e\u0213\u0218\u021f\u0228\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}