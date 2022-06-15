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
		CLASSREF=25, INTERSECTION=26, INTERSECTION_NOT=27, TRANSFORMING=28, CLASS_DECL=29, 
		FEATURE_DECL=30, SYLLABLE_FEATURE=31, DIACRITIC=32, DIA_BEFORE=33, DIA_FIRST=34, 
		DIA_FLOATING=35, SYMBOL=36, SYLLABLE_DECL=37, EXPLICIT_SYLLABLES=38, CLEAR_SYLLABLES=39, 
		ANY_SYLLABLE=40, DEROMANIZER=41, ROMANIZER=42, ALL_MATCHING=43, FIRST_MATCHING=44, 
		LITERAL=45, UNCHANGED=46, NUMBER=47, NAME=48, STR1=49, STR=50;
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
			"CLASSREF", "INTERSECTION", "INTERSECTION_NOT", "TRANSFORMING", "CLASS_DECL", 
			"FEATURE_DECL", "SYLLABLE_FEATURE", "DIACRITIC", "DIA_BEFORE", "DIA_FIRST", 
			"DIA_FLOATING", "SYMBOL", "SYLLABLE_DECL", "EXPLICIT_SYLLABLES", "CLEAR_SYLLABLES", 
			"ANY_SYLLABLE", "DEROMANIZER", "ROMANIZER", "ALL_MATCHING", "FIRST_MATCHING", 
			"LITERAL", "UNCHANGED", "NUMBER", "NAME", "STR1", "STR", "CHAR", "DIGIT", 
			"ANY", "COMMENT_START"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, null, "'_'", null, null, "'('", "')'", 
			"'*'", "'['", "']'", "'{'", "'}'", "'+'", "'?'", "'-'", "':'", "'~'", 
			"'!'", "'.'", "'$'", "'$$'", "'@'", "'&'", "'&!'", "'>'", null, null, 
			null, null, null, null, null, null, "'Syllables'", "'explicit'", "'clear'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "COMMENT", "SEP", "CHANGE", "CONDITION", "EXCLUSION", "ANCHOR", 
			"NEWLINE", "WHITESPACE", "O_PAREN", "C_PAREN", "NULL", "MATRIX_START", 
			"MATRIX_END", "LIST_START", "LIST_END", "AT_LEAST_ONE", "OPTIONAL", "HYPHEN", 
			"RULE_START", "INEXACT", "NEGATION", "SYLLABLE_BOUNDARY", "WORD_BOUNDARY", 
			"BETWEEN_WORDS", "CLASSREF", "INTERSECTION", "INTERSECTION_NOT", "TRANSFORMING", 
			"CLASS_DECL", "FEATURE_DECL", "SYLLABLE_FEATURE", "DIACRITIC", "DIA_BEFORE", 
			"DIA_FIRST", "DIA_FLOATING", "SYMBOL", "SYLLABLE_DECL", "EXPLICIT_SYLLABLES", 
			"CLEAR_SYLLABLES", "ANY_SYLLABLE", "DEROMANIZER", "ROMANIZER", "ALL_MATCHING", 
			"FIRST_MATCHING", "LITERAL", "UNCHANGED", "NUMBER", "NAME", "STR1", "STR"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\64\u0205\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64"+
		"\t\64\4\65\t\65\4\66\t\66\4\67\t\67\3\2\5\2q\n\2\3\2\3\2\7\2u\n\2\f\2"+
		"\16\2x\13\2\3\2\3\2\3\3\3\3\5\3~\n\3\3\4\5\4\u0081\n\4\3\4\3\4\3\4\3\4"+
		"\5\4\u0087\n\4\3\5\5\5\u008a\n\5\3\5\3\5\5\5\u008e\n\5\3\6\5\6\u0091\n"+
		"\6\3\6\3\6\3\6\3\6\5\6\u0097\n\6\3\7\3\7\3\b\5\b\u009c\n\b\3\b\3\b\3\b"+
		"\5\b\u00a1\n\b\3\b\5\b\u00a4\n\b\3\t\6\t\u00a7\n\t\r\t\16\t\u00a8\3\n"+
		"\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21"+
		"\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30"+
		"\3\31\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\34\3\35\3\35\3\36\3\36"+
		"\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\5\36\u00df\n\36\3\37\3\37\3\37"+
		"\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\5\37\u00ef\n\37"+
		"\3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \5 \u0105"+
		"\n \3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\5!\u0119\n!"+
		"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\5\"\u012b"+
		"\n\"\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\5#\u013b\n#\3$\3$\3$\3"+
		"$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\5$\u0151\n$\3%\3%\3"+
		"%\3%\3%\3%\3%\3%\3%\3%\3%\3%\5%\u015f\n%\3&\3&\3&\3&\3&\3&\3&\3&\3&\3"+
		"&\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3(\3(\3(\3(\3(\3(\3)\3)\3)\3)\3"+
		")\3)\3)\3)\3)\3)\5)\u0184\n)\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3"+
		"*\3*\3*\3*\3*\3*\3*\3*\3*\5*\u019c\n*\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3"+
		"+\3+\3+\3+\3+\3+\3+\3+\5+\u01b0\n+\3,\3,\3,\3,\3,\3,\3,\3,\5,\u01ba\n"+
		",\3-\3-\3-\3-\3-\3-\3-\3-\5-\u01c4\n-\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3"+
		".\3.\3.\3.\5.\u01d4\n.\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3"+
		"/\3/\3/\5/\u01e8\n/\3\60\6\60\u01eb\n\60\r\60\16\60\u01ec\3\61\6\61\u01f0"+
		"\n\61\r\61\16\61\u01f1\3\62\3\62\3\63\6\63\u01f7\n\63\r\63\16\63\u01f8"+
		"\3\64\3\64\3\65\3\65\3\66\3\66\3\66\5\66\u0202\n\66\3\67\3\67\2\28\3\3"+
		"\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21"+
		"!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!"+
		"A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62c\63e\64g\2i\2k\2m\2\3\2\7\4"+
		"\2\f\f\17\17\f\2\13\17\"\"\u0087\u0087\u00a2\u00a2\u1682\u1682\u2002\u200c"+
		"\u202a\u202b\u2031\u2031\u2061\u2061\u3002\u3002\5\2\62;C\\c|\3\2\62;"+
		"\16\2\f\f\17\17\"#%&((*\61<<?B]_aa}}\177\u0080\2\u0220\2\3\3\2\2\2\2\5"+
		"\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2"+
		"\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33"+
		"\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2"+
		"\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2"+
		"\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2"+
		"\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K"+
		"\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2"+
		"\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2"+
		"\2e\3\2\2\2\3p\3\2\2\2\5{\3\2\2\2\7\u0080\3\2\2\2\t\u0089\3\2\2\2\13\u0090"+
		"\3\2\2\2\r\u0098\3\2\2\2\17\u009b\3\2\2\2\21\u00a6\3\2\2\2\23\u00aa\3"+
		"\2\2\2\25\u00ac\3\2\2\2\27\u00ae\3\2\2\2\31\u00b0\3\2\2\2\33\u00b2\3\2"+
		"\2\2\35\u00b4\3\2\2\2\37\u00b6\3\2\2\2!\u00b8\3\2\2\2#\u00ba\3\2\2\2%"+
		"\u00bc\3\2\2\2\'\u00be\3\2\2\2)\u00c0\3\2\2\2+\u00c2\3\2\2\2-\u00c4\3"+
		"\2\2\2/\u00c6\3\2\2\2\61\u00c8\3\2\2\2\63\u00cb\3\2\2\2\65\u00cd\3\2\2"+
		"\2\67\u00cf\3\2\2\29\u00d2\3\2\2\2;\u00de\3\2\2\2=\u00ee\3\2\2\2?\u0104"+
		"\3\2\2\2A\u0118\3\2\2\2C\u012a\3\2\2\2E\u013a\3\2\2\2G\u0150\3\2\2\2I"+
		"\u015e\3\2\2\2K\u0160\3\2\2\2M\u016a\3\2\2\2O\u0173\3\2\2\2Q\u0183\3\2"+
		"\2\2S\u019b\3\2\2\2U\u01af\3\2\2\2W\u01b9\3\2\2\2Y\u01c3\3\2\2\2[\u01d3"+
		"\3\2\2\2]\u01e7\3\2\2\2_\u01ea\3\2\2\2a\u01ef\3\2\2\2c\u01f3\3\2\2\2e"+
		"\u01f6\3\2\2\2g\u01fa\3\2\2\2i\u01fc\3\2\2\2k\u0201\3\2\2\2m\u0203\3\2"+
		"\2\2oq\5\21\t\2po\3\2\2\2pq\3\2\2\2qr\3\2\2\2rv\5m\67\2su\n\2\2\2ts\3"+
		"\2\2\2ux\3\2\2\2vt\3\2\2\2vw\3\2\2\2wy\3\2\2\2xv\3\2\2\2yz\b\2\2\2z\4"+
		"\3\2\2\2{}\7.\2\2|~\5\21\t\2}|\3\2\2\2}~\3\2\2\2~\6\3\2\2\2\177\u0081"+
		"\5\21\t\2\u0080\177\3\2\2\2\u0080\u0081\3\2\2\2\u0081\u0082\3\2\2\2\u0082"+
		"\u0083\7?\2\2\u0083\u0084\7@\2\2\u0084\u0086\3\2\2\2\u0085\u0087\5\21"+
		"\t\2\u0086\u0085\3\2\2\2\u0086\u0087\3\2\2\2\u0087\b\3\2\2\2\u0088\u008a"+
		"\5\21\t\2\u0089\u0088\3\2\2\2\u0089\u008a\3\2\2\2\u008a\u008b\3\2\2\2"+
		"\u008b\u008d\7\61\2\2\u008c\u008e\5\21\t\2\u008d\u008c\3\2\2\2\u008d\u008e"+
		"\3\2\2\2\u008e\n\3\2\2\2\u008f\u0091\5\21\t\2\u0090\u008f\3\2\2\2\u0090"+
		"\u0091\3\2\2\2\u0091\u0092\3\2\2\2\u0092\u0093\7\61\2\2\u0093\u0094\7"+
		"\61\2\2\u0094\u0096\3\2\2\2\u0095\u0097\5\21\t\2\u0096\u0095\3\2\2\2\u0096"+
		"\u0097\3\2\2\2\u0097\f\3\2\2\2\u0098\u0099\7a\2\2\u0099\16\3\2\2\2\u009a"+
		"\u009c\5\21\t\2\u009b\u009a\3\2\2\2\u009b\u009c\3\2\2\2\u009c\u00a0\3"+
		"\2\2\2\u009d\u009e\7\17\2\2\u009e\u00a1\7\f\2\2\u009f\u00a1\7\f\2\2\u00a0"+
		"\u009d\3\2\2\2\u00a0\u009f\3\2\2\2\u00a1\u00a3\3\2\2\2\u00a2\u00a4\5\21"+
		"\t\2\u00a3\u00a2\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4\20\3\2\2\2\u00a5\u00a7"+
		"\t\3\2\2\u00a6\u00a5\3\2\2\2\u00a7\u00a8\3\2\2\2\u00a8\u00a6\3\2\2\2\u00a8"+
		"\u00a9\3\2\2\2\u00a9\22\3\2\2\2\u00aa\u00ab\7*\2\2\u00ab\24\3\2\2\2\u00ac"+
		"\u00ad\7+\2\2\u00ad\26\3\2\2\2\u00ae\u00af\7,\2\2\u00af\30\3\2\2\2\u00b0"+
		"\u00b1\7]\2\2\u00b1\32\3\2\2\2\u00b2\u00b3\7_\2\2\u00b3\34\3\2\2\2\u00b4"+
		"\u00b5\7}\2\2\u00b5\36\3\2\2\2\u00b6\u00b7\7\177\2\2\u00b7 \3\2\2\2\u00b8"+
		"\u00b9\7-\2\2\u00b9\"\3\2\2\2\u00ba\u00bb\7A\2\2\u00bb$\3\2\2\2\u00bc"+
		"\u00bd\7/\2\2\u00bd&\3\2\2\2\u00be\u00bf\7<\2\2\u00bf(\3\2\2\2\u00c0\u00c1"+
		"\7\u0080\2\2\u00c1*\3\2\2\2\u00c2\u00c3\7#\2\2\u00c3,\3\2\2\2\u00c4\u00c5"+
		"\7\60\2\2\u00c5.\3\2\2\2\u00c6\u00c7\7&\2\2\u00c7\60\3\2\2\2\u00c8\u00c9"+
		"\7&\2\2\u00c9\u00ca\7&\2\2\u00ca\62\3\2\2\2\u00cb\u00cc\7B\2\2\u00cc\64"+
		"\3\2\2\2\u00cd\u00ce\7(\2\2\u00ce\66\3\2\2\2\u00cf\u00d0\7(\2\2\u00d0"+
		"\u00d1\7#\2\2\u00d18\3\2\2\2\u00d2\u00d3\7@\2\2\u00d3:\3\2\2\2\u00d4\u00d5"+
		"\7E\2\2\u00d5\u00d6\7n\2\2\u00d6\u00d7\7c\2\2\u00d7\u00d8\7u\2\2\u00d8"+
		"\u00df\7u\2\2\u00d9\u00da\7e\2\2\u00da\u00db\7n\2\2\u00db\u00dc\7c\2\2"+
		"\u00dc\u00dd\7u\2\2\u00dd\u00df\7u\2\2\u00de\u00d4\3\2\2\2\u00de\u00d9"+
		"\3\2\2\2\u00df<\3\2\2\2\u00e0\u00e1\7H\2\2\u00e1\u00e2\7g\2\2\u00e2\u00e3"+
		"\7c\2\2\u00e3\u00e4\7v\2\2\u00e4\u00e5\7w\2\2\u00e5\u00e6\7t\2\2\u00e6"+
		"\u00ef\7g\2\2\u00e7\u00e8\7h\2\2\u00e8\u00e9\7g\2\2\u00e9\u00ea\7c\2\2"+
		"\u00ea\u00eb\7v\2\2\u00eb\u00ec\7w\2\2\u00ec\u00ed\7t\2\2\u00ed\u00ef"+
		"\7g\2\2\u00ee\u00e0\3\2\2\2\u00ee\u00e7\3\2\2\2\u00ef>\3\2\2\2\u00f0\u00f1"+
		"\7*\2\2\u00f1\u00f2\7U\2\2\u00f2\u00f3\7{\2\2\u00f3\u00f4\7n\2\2\u00f4"+
		"\u00f5\7n\2\2\u00f5\u00f6\7c\2\2\u00f6\u00f7\7d\2\2\u00f7\u00f8\7n\2\2"+
		"\u00f8\u00f9\7g\2\2\u00f9\u0105\7+\2\2\u00fa\u00fb\7*\2\2\u00fb\u00fc"+
		"\7u\2\2\u00fc\u00fd\7{\2\2\u00fd\u00fe\7n\2\2\u00fe\u00ff\7n\2\2\u00ff"+
		"\u0100\7c\2\2\u0100\u0101\7d\2\2\u0101\u0102\7n\2\2\u0102\u0103\7g\2\2"+
		"\u0103\u0105\7+\2\2\u0104\u00f0\3\2\2\2\u0104\u00fa\3\2\2\2\u0105@\3\2"+
		"\2\2\u0106\u0107\7F\2\2\u0107\u0108\7k\2\2\u0108\u0109\7c\2\2\u0109\u010a"+
		"\7e\2\2\u010a\u010b\7t\2\2\u010b\u010c\7k\2\2\u010c\u010d\7v\2\2\u010d"+
		"\u010e\7k\2\2\u010e\u0119\7e\2\2\u010f\u0110\7f\2\2\u0110\u0111\7k\2\2"+
		"\u0111\u0112\7c\2\2\u0112\u0113\7e\2\2\u0113\u0114\7t\2\2\u0114\u0115"+
		"\7k\2\2\u0115\u0116\7v\2\2\u0116\u0117\7k\2\2\u0117\u0119\7e\2\2\u0118"+
		"\u0106\3\2\2\2\u0118\u010f\3\2\2\2\u0119B\3\2\2\2\u011a\u011b\7*\2\2\u011b"+
		"\u011c\7D\2\2\u011c\u011d\7g\2\2\u011d\u011e\7h\2\2\u011e\u011f\7q\2\2"+
		"\u011f\u0120\7t\2\2\u0120\u0121\7g\2\2\u0121\u012b\7+\2\2\u0122\u0123"+
		"\7*\2\2\u0123\u0124\7d\2\2\u0124\u0125\7g\2\2\u0125\u0126\7h\2\2\u0126"+
		"\u0127\7q\2\2\u0127\u0128\7t\2\2\u0128\u0129\7g\2\2\u0129\u012b\7+\2\2"+
		"\u012a\u011a\3\2\2\2\u012a\u0122\3\2\2\2\u012bD\3\2\2\2\u012c\u012d\7"+
		"*\2\2\u012d\u012e\7H\2\2\u012e\u012f\7k\2\2\u012f\u0130\7t\2\2\u0130\u0131"+
		"\7u\2\2\u0131\u0132\7v\2\2\u0132\u013b\7+\2\2\u0133\u0134\7*\2\2\u0134"+
		"\u0135\7h\2\2\u0135\u0136\7k\2\2\u0136\u0137\7t\2\2\u0137\u0138\7u\2\2"+
		"\u0138\u0139\7v\2\2\u0139\u013b\7+\2\2\u013a\u012c\3\2\2\2\u013a\u0133"+
		"\3\2\2\2\u013bF\3\2\2\2\u013c\u013d\7*\2\2\u013d\u013e\7H\2\2\u013e\u013f"+
		"\7n\2\2\u013f\u0140\7q\2\2\u0140\u0141\7c\2\2\u0141\u0142\7v\2\2\u0142"+
		"\u0143\7k\2\2\u0143\u0144\7p\2\2\u0144\u0145\7i\2\2\u0145\u0151\7+\2\2"+
		"\u0146\u0147\7*\2\2\u0147\u0148\7h\2\2\u0148\u0149\7n\2\2\u0149\u014a"+
		"\7q\2\2\u014a\u014b\7c\2\2\u014b\u014c\7v\2\2\u014c\u014d\7k\2\2\u014d"+
		"\u014e\7p\2\2\u014e\u014f\7i\2\2\u014f\u0151\7+\2\2\u0150\u013c\3\2\2"+
		"\2\u0150\u0146\3\2\2\2\u0151H\3\2\2\2\u0152\u0153\7U\2\2\u0153\u0154\7"+
		"{\2\2\u0154\u0155\7o\2\2\u0155\u0156\7d\2\2\u0156\u0157\7q\2\2\u0157\u015f"+
		"\7n\2\2\u0158\u0159\7u\2\2\u0159\u015a\7{\2\2\u015a\u015b\7o\2\2\u015b"+
		"\u015c\7d\2\2\u015c\u015d\7q\2\2\u015d\u015f\7n\2\2\u015e\u0152\3\2\2"+
		"\2\u015e\u0158\3\2\2\2\u015fJ\3\2\2\2\u0160\u0161\7U\2\2\u0161\u0162\7"+
		"{\2\2\u0162\u0163\7n\2\2\u0163\u0164\7n\2\2\u0164\u0165\7c\2\2\u0165\u0166"+
		"\7d\2\2\u0166\u0167\7n\2\2\u0167\u0168\7g\2\2\u0168\u0169\7u\2\2\u0169"+
		"L\3\2\2\2\u016a\u016b\7g\2\2\u016b\u016c\7z\2\2\u016c\u016d\7r\2\2\u016d"+
		"\u016e\7n\2\2\u016e\u016f\7k\2\2\u016f\u0170\7e\2\2\u0170\u0171\7k\2\2"+
		"\u0171\u0172\7v\2\2\u0172N\3\2\2\2\u0173\u0174\7e\2\2\u0174\u0175\7n\2"+
		"\2\u0175\u0176\7g\2\2\u0176\u0177\7c\2\2\u0177\u0178\7t\2\2\u0178P\3\2"+
		"\2\2\u0179\u017a\7>\2\2\u017a\u017b\7U\2\2\u017b\u017c\7{\2\2\u017c\u017d"+
		"\7n\2\2\u017d\u0184\7@\2\2\u017e\u017f\7>\2\2\u017f\u0180\7u\2\2\u0180"+
		"\u0181\7{\2\2\u0181\u0182\7n\2\2\u0182\u0184\7@\2\2\u0183\u0179\3\2\2"+
		"\2\u0183\u017e\3\2\2\2\u0184R\3\2\2\2\u0185\u0186\7F\2\2\u0186\u0187\7"+
		"g\2\2\u0187\u0188\7t\2\2\u0188\u0189\7q\2\2\u0189\u018a\7o\2\2\u018a\u018b"+
		"\7c\2\2\u018b\u018c\7p\2\2\u018c\u018d\7k\2\2\u018d\u018e\7|\2\2\u018e"+
		"\u018f\7g\2\2\u018f\u019c\7t\2\2\u0190\u0191\7f\2\2\u0191\u0192\7g\2\2"+
		"\u0192\u0193\7t\2\2\u0193\u0194\7q\2\2\u0194\u0195\7o\2\2\u0195\u0196"+
		"\7c\2\2\u0196\u0197\7p\2\2\u0197\u0198\7k\2\2\u0198\u0199\7|\2\2\u0199"+
		"\u019a\7g\2\2\u019a\u019c\7t\2\2\u019b\u0185\3\2\2\2\u019b\u0190\3\2\2"+
		"\2\u019cT\3\2\2\2\u019d\u019e\7T\2\2\u019e\u019f\7q\2\2\u019f\u01a0\7"+
		"o\2\2\u01a0\u01a1\7c\2\2\u01a1\u01a2\7p\2\2\u01a2\u01a3\7k\2\2\u01a3\u01a4"+
		"\7|\2\2\u01a4\u01a5\7g\2\2\u01a5\u01b0\7t\2\2\u01a6\u01a7\7t\2\2\u01a7"+
		"\u01a8\7q\2\2\u01a8\u01a9\7o\2\2\u01a9\u01aa\7c\2\2\u01aa\u01ab\7p\2\2"+
		"\u01ab\u01ac\7k\2\2\u01ac\u01ad\7|\2\2\u01ad\u01ae\7g\2\2\u01ae\u01b0"+
		"\7t\2\2\u01af\u019d\3\2\2\2\u01af\u01a6\3\2\2\2\u01b0V\3\2\2\2\u01b1\u01b2"+
		"\7V\2\2\u01b2\u01b3\7j\2\2\u01b3\u01b4\7g\2\2\u01b4\u01ba\7p\2\2\u01b5"+
		"\u01b6\7v\2\2\u01b6\u01b7\7j\2\2\u01b7\u01b8\7g\2\2\u01b8\u01ba\7p\2\2"+
		"\u01b9\u01b1\3\2\2\2\u01b9\u01b5\3\2\2\2\u01baX\3\2\2\2\u01bb\u01bc\7"+
		"G\2\2\u01bc\u01bd\7n\2\2\u01bd\u01be\7u\2\2\u01be\u01c4\7g\2\2\u01bf\u01c0"+
		"\7g\2\2\u01c0\u01c1\7n\2\2\u01c1\u01c2\7u\2\2\u01c2\u01c4\7g\2\2\u01c3"+
		"\u01bb\3\2\2\2\u01c3\u01bf\3\2\2\2\u01c4Z\3\2\2\2\u01c5\u01c6\7N\2\2\u01c6"+
		"\u01c7\7k\2\2\u01c7\u01c8\7v\2\2\u01c8\u01c9\7g\2\2\u01c9\u01ca\7t\2\2"+
		"\u01ca\u01cb\7c\2\2\u01cb\u01d4\7n\2\2\u01cc\u01cd\7n\2\2\u01cd\u01ce"+
		"\7k\2\2\u01ce\u01cf\7v\2\2\u01cf\u01d0\7g\2\2\u01d0\u01d1\7t\2\2\u01d1"+
		"\u01d2\7c\2\2\u01d2\u01d4\7n\2\2\u01d3\u01c5\3\2\2\2\u01d3\u01cc\3\2\2"+
		"\2\u01d4\\\3\2\2\2\u01d5\u01d6\7W\2\2\u01d6\u01d7\7p\2\2\u01d7\u01d8\7"+
		"e\2\2\u01d8\u01d9\7j\2\2\u01d9\u01da\7c\2\2\u01da\u01db\7p\2\2\u01db\u01dc"+
		"\7i\2\2\u01dc\u01dd\7g\2\2\u01dd\u01e8\7f\2\2\u01de\u01df\7w\2\2\u01df"+
		"\u01e0\7p\2\2\u01e0\u01e1\7e\2\2\u01e1\u01e2\7j\2\2\u01e2\u01e3\7c\2\2"+
		"\u01e3\u01e4\7p\2\2\u01e4\u01e5\7i\2\2\u01e5\u01e6\7g\2\2\u01e6\u01e8"+
		"\7f\2\2\u01e7\u01d5\3\2\2\2\u01e7\u01de\3\2\2\2\u01e8^\3\2\2\2\u01e9\u01eb"+
		"\5i\65\2\u01ea\u01e9\3\2\2\2\u01eb\u01ec\3\2\2\2\u01ec\u01ea\3\2\2\2\u01ec"+
		"\u01ed\3\2\2\2\u01ed`\3\2\2\2\u01ee\u01f0\5g\64\2\u01ef\u01ee\3\2\2\2"+
		"\u01f0\u01f1\3\2\2\2\u01f1\u01ef\3\2\2\2\u01f1\u01f2\3\2\2\2\u01f2b\3"+
		"\2\2\2\u01f3\u01f4\5k\66\2\u01f4d\3\2\2\2\u01f5\u01f7\5k\66\2\u01f6\u01f5"+
		"\3\2\2\2\u01f7\u01f8\3\2\2\2\u01f8\u01f6\3\2\2\2\u01f8\u01f9\3\2\2\2\u01f9"+
		"f\3\2\2\2\u01fa\u01fb\t\4\2\2\u01fbh\3\2\2\2\u01fc\u01fd\t\5\2\2\u01fd"+
		"j\3\2\2\2\u01fe\u01ff\7^\2\2\u01ff\u0202\13\2\2\2\u0200\u0202\n\6\2\2"+
		"\u0201\u01fe\3\2\2\2\u0201\u0200\3\2\2\2\u0202l\3\2\2\2\u0203\u0204\7"+
		"%\2\2\u0204n\3\2\2\2#\2pv}\u0080\u0086\u0089\u008d\u0090\u0096\u009b\u00a0"+
		"\u00a3\u00a8\u00de\u00ee\u0104\u0118\u012a\u013a\u0150\u015e\u0183\u019b"+
		"\u01af\u01b9\u01c3\u01d3\u01e7\u01ec\u01f1\u01f8\u0201\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}