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
		PROPAGATE=45, LTR=46, RTL=47, LITERAL=48, CLEANUP=49, UNCHANGED=50, NUMBER=51, 
		NAME=52, STR1=53, STR=54;
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
			"PROPAGATE", "LTR", "RTL", "LITERAL", "CLEANUP", "UNCHANGED", "NUMBER", 
			"NAME", "STR1", "STR", "CHAR", "DIGIT", "ANY", "COMMENT_START"
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
			"FIRST_MATCHING", "PROPAGATE", "LTR", "RTL", "LITERAL", "CLEANUP", "UNCHANGED", 
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\28\u0247\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\3\2\5\2y\n\2"+
		"\3\2\3\2\7\2}\n\2\f\2\16\2\u0080\13\2\3\2\3\2\3\3\3\3\5\3\u0086\n\3\3"+
		"\4\5\4\u0089\n\4\3\4\3\4\3\4\3\4\5\4\u008f\n\4\3\5\5\5\u0092\n\5\3\5\3"+
		"\5\5\5\u0096\n\5\3\6\5\6\u0099\n\6\3\6\3\6\3\6\3\6\5\6\u009f\n\6\3\7\3"+
		"\7\3\b\5\b\u00a4\n\b\3\b\3\b\3\b\5\b\u00a9\n\b\3\b\5\b\u00ac\n\b\3\t\6"+
		"\t\u00af\n\t\r\t\16\t\u00b0\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16"+
		"\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25"+
		"\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\31\3\32\3\32\3\33\3\33\3\34"+
		"\3\34\3\34\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36"+
		"\5\36\u00e7\n\36\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37"+
		"\3\37\3\37\3\37\5\37\u00f7\n\37\3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3"+
		" \3 \3 \3 \3 \3 \3 \3 \5 \u010d\n \3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3"+
		"!\3!\3!\3!\3!\3!\3!\5!\u0121\n!\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3"+
		"\"\3\"\3\"\3\"\3\"\3\"\3\"\5\"\u0133\n\"\3#\3#\3#\3#\3#\3#\3#\3#\3#\3"+
		"#\3#\3#\3#\3#\5#\u0143\n#\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3"+
		"$\3$\3$\3$\3$\3$\5$\u0159\n$\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\5%\u0167"+
		"\n%\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'"+
		"\3(\3(\3(\3(\3(\3(\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\5)\u018c\n)\3*\3*\3*"+
		"\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\5*\u01a4\n*"+
		"\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\5+\u01b8\n+\3,"+
		"\3,\3,\3,\3,\3,\3,\3,\5,\u01c2\n,\3-\3-\3-\3-\3-\3-\3-\3-\5-\u01cc\n-"+
		"\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\5.\u01e0\n.\3/"+
		"\3/\3/\3/\3/\3/\3/\3/\3/\5/\u01eb\n/\3\60\3\60\3\60\3\60\3\60\3\60\3\60"+
		"\3\60\3\60\5\60\u01f6\n\60\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61"+
		"\3\61\3\61\3\61\3\61\3\61\5\61\u0206\n\61\3\62\3\62\3\62\3\62\3\62\3\62"+
		"\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\5\62\u0216\n\62\3\63\3\63\3\63"+
		"\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63"+
		"\3\63\5\63\u022a\n\63\3\64\6\64\u022d\n\64\r\64\16\64\u022e\3\65\6\65"+
		"\u0232\n\65\r\65\16\65\u0233\3\66\3\66\3\67\6\67\u0239\n\67\r\67\16\67"+
		"\u023a\38\38\39\39\3:\3:\3:\5:\u0244\n:\3;\3;\2\2<\3\3\5\4\7\5\t\6\13"+
		"\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'"+
		"\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'"+
		"M(O)Q*S+U,W-Y.[/]\60_\61a\62c\63e\64g\65i\66k\67m8o\2q\2s\2u\2\3\2\7\4"+
		"\2\f\f\17\17\f\2\13\17\"\"\u0087\u0087\u00a2\u00a2\u1682\u1682\u2002\u200c"+
		"\u202a\u202b\u2031\u2031\u2061\u2061\u3002\u3002\5\2\62;C\\c|\3\2\62;"+
		"\16\2\f\f\17\17\"#%&((*\61<<?B]_aa}}\177\u0080\2\u0268\2\3\3\2\2\2\2\5"+
		"\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2"+
		"\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33"+
		"\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2"+
		"\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2"+
		"\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2"+
		"\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K"+
		"\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2"+
		"\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2"+
		"\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\3x\3\2\2\2\5\u0083"+
		"\3\2\2\2\7\u0088\3\2\2\2\t\u0091\3\2\2\2\13\u0098\3\2\2\2\r\u00a0\3\2"+
		"\2\2\17\u00a3\3\2\2\2\21\u00ae\3\2\2\2\23\u00b2\3\2\2\2\25\u00b4\3\2\2"+
		"\2\27\u00b6\3\2\2\2\31\u00b8\3\2\2\2\33\u00ba\3\2\2\2\35\u00bc\3\2\2\2"+
		"\37\u00be\3\2\2\2!\u00c0\3\2\2\2#\u00c2\3\2\2\2%\u00c4\3\2\2\2\'\u00c6"+
		"\3\2\2\2)\u00c8\3\2\2\2+\u00ca\3\2\2\2-\u00cc\3\2\2\2/\u00ce\3\2\2\2\61"+
		"\u00d0\3\2\2\2\63\u00d3\3\2\2\2\65\u00d5\3\2\2\2\67\u00d7\3\2\2\29\u00da"+
		"\3\2\2\2;\u00e6\3\2\2\2=\u00f6\3\2\2\2?\u010c\3\2\2\2A\u0120\3\2\2\2C"+
		"\u0132\3\2\2\2E\u0142\3\2\2\2G\u0158\3\2\2\2I\u0166\3\2\2\2K\u0168\3\2"+
		"\2\2M\u0172\3\2\2\2O\u017b\3\2\2\2Q\u018b\3\2\2\2S\u01a3\3\2\2\2U\u01b7"+
		"\3\2\2\2W\u01c1\3\2\2\2Y\u01cb\3\2\2\2[\u01df\3\2\2\2]\u01ea\3\2\2\2_"+
		"\u01f5\3\2\2\2a\u0205\3\2\2\2c\u0215\3\2\2\2e\u0229\3\2\2\2g\u022c\3\2"+
		"\2\2i\u0231\3\2\2\2k\u0235\3\2\2\2m\u0238\3\2\2\2o\u023c\3\2\2\2q\u023e"+
		"\3\2\2\2s\u0243\3\2\2\2u\u0245\3\2\2\2wy\5\21\t\2xw\3\2\2\2xy\3\2\2\2"+
		"yz\3\2\2\2z~\5u;\2{}\n\2\2\2|{\3\2\2\2}\u0080\3\2\2\2~|\3\2\2\2~\177\3"+
		"\2\2\2\177\u0081\3\2\2\2\u0080~\3\2\2\2\u0081\u0082\b\2\2\2\u0082\4\3"+
		"\2\2\2\u0083\u0085\7.\2\2\u0084\u0086\5\21\t\2\u0085\u0084\3\2\2\2\u0085"+
		"\u0086\3\2\2\2\u0086\6\3\2\2\2\u0087\u0089\5\21\t\2\u0088\u0087\3\2\2"+
		"\2\u0088\u0089\3\2\2\2\u0089\u008a\3\2\2\2\u008a\u008b\7?\2\2\u008b\u008c"+
		"\7@\2\2\u008c\u008e\3\2\2\2\u008d\u008f\5\21\t\2\u008e\u008d\3\2\2\2\u008e"+
		"\u008f\3\2\2\2\u008f\b\3\2\2\2\u0090\u0092\5\21\t\2\u0091\u0090\3\2\2"+
		"\2\u0091\u0092\3\2\2\2\u0092\u0093\3\2\2\2\u0093\u0095\7\61\2\2\u0094"+
		"\u0096\5\21\t\2\u0095\u0094\3\2\2\2\u0095\u0096\3\2\2\2\u0096\n\3\2\2"+
		"\2\u0097\u0099\5\21\t\2\u0098\u0097\3\2\2\2\u0098\u0099\3\2\2\2\u0099"+
		"\u009a\3\2\2\2\u009a\u009b\7\61\2\2\u009b\u009c\7\61\2\2\u009c\u009e\3"+
		"\2\2\2\u009d\u009f\5\21\t\2\u009e\u009d\3\2\2\2\u009e\u009f\3\2\2\2\u009f"+
		"\f\3\2\2\2\u00a0\u00a1\7a\2\2\u00a1\16\3\2\2\2\u00a2\u00a4\5\21\t\2\u00a3"+
		"\u00a2\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4\u00a8\3\2\2\2\u00a5\u00a6\7\17"+
		"\2\2\u00a6\u00a9\7\f\2\2\u00a7\u00a9\7\f\2\2\u00a8\u00a5\3\2\2\2\u00a8"+
		"\u00a7\3\2\2\2\u00a9\u00ab\3\2\2\2\u00aa\u00ac\5\21\t\2\u00ab\u00aa\3"+
		"\2\2\2\u00ab\u00ac\3\2\2\2\u00ac\20\3\2\2\2\u00ad\u00af\t\3\2\2\u00ae"+
		"\u00ad\3\2\2\2\u00af\u00b0\3\2\2\2\u00b0\u00ae\3\2\2\2\u00b0\u00b1\3\2"+
		"\2\2\u00b1\22\3\2\2\2\u00b2\u00b3\7*\2\2\u00b3\24\3\2\2\2\u00b4\u00b5"+
		"\7+\2\2\u00b5\26\3\2\2\2\u00b6\u00b7\7,\2\2\u00b7\30\3\2\2\2\u00b8\u00b9"+
		"\7]\2\2\u00b9\32\3\2\2\2\u00ba\u00bb\7_\2\2\u00bb\34\3\2\2\2\u00bc\u00bd"+
		"\7}\2\2\u00bd\36\3\2\2\2\u00be\u00bf\7\177\2\2\u00bf \3\2\2\2\u00c0\u00c1"+
		"\7-\2\2\u00c1\"\3\2\2\2\u00c2\u00c3\7A\2\2\u00c3$\3\2\2\2\u00c4\u00c5"+
		"\7/\2\2\u00c5&\3\2\2\2\u00c6\u00c7\7<\2\2\u00c7(\3\2\2\2\u00c8\u00c9\7"+
		"\u0080\2\2\u00c9*\3\2\2\2\u00ca\u00cb\7#\2\2\u00cb,\3\2\2\2\u00cc\u00cd"+
		"\7\60\2\2\u00cd.\3\2\2\2\u00ce\u00cf\7&\2\2\u00cf\60\3\2\2\2\u00d0\u00d1"+
		"\7&\2\2\u00d1\u00d2\7&\2\2\u00d2\62\3\2\2\2\u00d3\u00d4\7B\2\2\u00d4\64"+
		"\3\2\2\2\u00d5\u00d6\7(\2\2\u00d6\66\3\2\2\2\u00d7\u00d8\7(\2\2\u00d8"+
		"\u00d9\7#\2\2\u00d98\3\2\2\2\u00da\u00db\7@\2\2\u00db:\3\2\2\2\u00dc\u00dd"+
		"\7E\2\2\u00dd\u00de\7n\2\2\u00de\u00df\7c\2\2\u00df\u00e0\7u\2\2\u00e0"+
		"\u00e7\7u\2\2\u00e1\u00e2\7e\2\2\u00e2\u00e3\7n\2\2\u00e3\u00e4\7c\2\2"+
		"\u00e4\u00e5\7u\2\2\u00e5\u00e7\7u\2\2\u00e6\u00dc\3\2\2\2\u00e6\u00e1"+
		"\3\2\2\2\u00e7<\3\2\2\2\u00e8\u00e9\7H\2\2\u00e9\u00ea\7g\2\2\u00ea\u00eb"+
		"\7c\2\2\u00eb\u00ec\7v\2\2\u00ec\u00ed\7w\2\2\u00ed\u00ee\7t\2\2\u00ee"+
		"\u00f7\7g\2\2\u00ef\u00f0\7h\2\2\u00f0\u00f1\7g\2\2\u00f1\u00f2\7c\2\2"+
		"\u00f2\u00f3\7v\2\2\u00f3\u00f4\7w\2\2\u00f4\u00f5\7t\2\2\u00f5\u00f7"+
		"\7g\2\2\u00f6\u00e8\3\2\2\2\u00f6\u00ef\3\2\2\2\u00f7>\3\2\2\2\u00f8\u00f9"+
		"\7*\2\2\u00f9\u00fa\7U\2\2\u00fa\u00fb\7{\2\2\u00fb\u00fc\7n\2\2\u00fc"+
		"\u00fd\7n\2\2\u00fd\u00fe\7c\2\2\u00fe\u00ff\7d\2\2\u00ff\u0100\7n\2\2"+
		"\u0100\u0101\7g\2\2\u0101\u010d\7+\2\2\u0102\u0103\7*\2\2\u0103\u0104"+
		"\7u\2\2\u0104\u0105\7{\2\2\u0105\u0106\7n\2\2\u0106\u0107\7n\2\2\u0107"+
		"\u0108\7c\2\2\u0108\u0109\7d\2\2\u0109\u010a\7n\2\2\u010a\u010b\7g\2\2"+
		"\u010b\u010d\7+\2\2\u010c\u00f8\3\2\2\2\u010c\u0102\3\2\2\2\u010d@\3\2"+
		"\2\2\u010e\u010f\7F\2\2\u010f\u0110\7k\2\2\u0110\u0111\7c\2\2\u0111\u0112"+
		"\7e\2\2\u0112\u0113\7t\2\2\u0113\u0114\7k\2\2\u0114\u0115\7v\2\2\u0115"+
		"\u0116\7k\2\2\u0116\u0121\7e\2\2\u0117\u0118\7f\2\2\u0118\u0119\7k\2\2"+
		"\u0119\u011a\7c\2\2\u011a\u011b\7e\2\2\u011b\u011c\7t\2\2\u011c\u011d"+
		"\7k\2\2\u011d\u011e\7v\2\2\u011e\u011f\7k\2\2\u011f\u0121\7e\2\2\u0120"+
		"\u010e\3\2\2\2\u0120\u0117\3\2\2\2\u0121B\3\2\2\2\u0122\u0123\7*\2\2\u0123"+
		"\u0124\7D\2\2\u0124\u0125\7g\2\2\u0125\u0126\7h\2\2\u0126\u0127\7q\2\2"+
		"\u0127\u0128\7t\2\2\u0128\u0129\7g\2\2\u0129\u0133\7+\2\2\u012a\u012b"+
		"\7*\2\2\u012b\u012c\7d\2\2\u012c\u012d\7g\2\2\u012d\u012e\7h\2\2\u012e"+
		"\u012f\7q\2\2\u012f\u0130\7t\2\2\u0130\u0131\7g\2\2\u0131\u0133\7+\2\2"+
		"\u0132\u0122\3\2\2\2\u0132\u012a\3\2\2\2\u0133D\3\2\2\2\u0134\u0135\7"+
		"*\2\2\u0135\u0136\7H\2\2\u0136\u0137\7k\2\2\u0137\u0138\7t\2\2\u0138\u0139"+
		"\7u\2\2\u0139\u013a\7v\2\2\u013a\u0143\7+\2\2\u013b\u013c\7*\2\2\u013c"+
		"\u013d\7h\2\2\u013d\u013e\7k\2\2\u013e\u013f\7t\2\2\u013f\u0140\7u\2\2"+
		"\u0140\u0141\7v\2\2\u0141\u0143\7+\2\2\u0142\u0134\3\2\2\2\u0142\u013b"+
		"\3\2\2\2\u0143F\3\2\2\2\u0144\u0145\7*\2\2\u0145\u0146\7H\2\2\u0146\u0147"+
		"\7n\2\2\u0147\u0148\7q\2\2\u0148\u0149\7c\2\2\u0149\u014a\7v\2\2\u014a"+
		"\u014b\7k\2\2\u014b\u014c\7p\2\2\u014c\u014d\7i\2\2\u014d\u0159\7+\2\2"+
		"\u014e\u014f\7*\2\2\u014f\u0150\7h\2\2\u0150\u0151\7n\2\2\u0151\u0152"+
		"\7q\2\2\u0152\u0153\7c\2\2\u0153\u0154\7v\2\2\u0154\u0155\7k\2\2\u0155"+
		"\u0156\7p\2\2\u0156\u0157\7i\2\2\u0157\u0159\7+\2\2\u0158\u0144\3\2\2"+
		"\2\u0158\u014e\3\2\2\2\u0159H\3\2\2\2\u015a\u015b\7U\2\2\u015b\u015c\7"+
		"{\2\2\u015c\u015d\7o\2\2\u015d\u015e\7d\2\2\u015e\u015f\7q\2\2\u015f\u0167"+
		"\7n\2\2\u0160\u0161\7u\2\2\u0161\u0162\7{\2\2\u0162\u0163\7o\2\2\u0163"+
		"\u0164\7d\2\2\u0164\u0165\7q\2\2\u0165\u0167\7n\2\2\u0166\u015a\3\2\2"+
		"\2\u0166\u0160\3\2\2\2\u0167J\3\2\2\2\u0168\u0169\7U\2\2\u0169\u016a\7"+
		"{\2\2\u016a\u016b\7n\2\2\u016b\u016c\7n\2\2\u016c\u016d\7c\2\2\u016d\u016e"+
		"\7d\2\2\u016e\u016f\7n\2\2\u016f\u0170\7g\2\2\u0170\u0171\7u\2\2\u0171"+
		"L\3\2\2\2\u0172\u0173\7g\2\2\u0173\u0174\7z\2\2\u0174\u0175\7r\2\2\u0175"+
		"\u0176\7n\2\2\u0176\u0177\7k\2\2\u0177\u0178\7e\2\2\u0178\u0179\7k\2\2"+
		"\u0179\u017a\7v\2\2\u017aN\3\2\2\2\u017b\u017c\7e\2\2\u017c\u017d\7n\2"+
		"\2\u017d\u017e\7g\2\2\u017e\u017f\7c\2\2\u017f\u0180\7t\2\2\u0180P\3\2"+
		"\2\2\u0181\u0182\7>\2\2\u0182\u0183\7U\2\2\u0183\u0184\7{\2\2\u0184\u0185"+
		"\7n\2\2\u0185\u018c\7@\2\2\u0186\u0187\7>\2\2\u0187\u0188\7u\2\2\u0188"+
		"\u0189\7{\2\2\u0189\u018a\7n\2\2\u018a\u018c\7@\2\2\u018b\u0181\3\2\2"+
		"\2\u018b\u0186\3\2\2\2\u018cR\3\2\2\2\u018d\u018e\7F\2\2\u018e\u018f\7"+
		"g\2\2\u018f\u0190\7t\2\2\u0190\u0191\7q\2\2\u0191\u0192\7o\2\2\u0192\u0193"+
		"\7c\2\2\u0193\u0194\7p\2\2\u0194\u0195\7k\2\2\u0195\u0196\7|\2\2\u0196"+
		"\u0197\7g\2\2\u0197\u01a4\7t\2\2\u0198\u0199\7f\2\2\u0199\u019a\7g\2\2"+
		"\u019a\u019b\7t\2\2\u019b\u019c\7q\2\2\u019c\u019d\7o\2\2\u019d\u019e"+
		"\7c\2\2\u019e\u019f\7p\2\2\u019f\u01a0\7k\2\2\u01a0\u01a1\7|\2\2\u01a1"+
		"\u01a2\7g\2\2\u01a2\u01a4\7t\2\2\u01a3\u018d\3\2\2\2\u01a3\u0198\3\2\2"+
		"\2\u01a4T\3\2\2\2\u01a5\u01a6\7T\2\2\u01a6\u01a7\7q\2\2\u01a7\u01a8\7"+
		"o\2\2\u01a8\u01a9\7c\2\2\u01a9\u01aa\7p\2\2\u01aa\u01ab\7k\2\2\u01ab\u01ac"+
		"\7|\2\2\u01ac\u01ad\7g\2\2\u01ad\u01b8\7t\2\2\u01ae\u01af\7t\2\2\u01af"+
		"\u01b0\7q\2\2\u01b0\u01b1\7o\2\2\u01b1\u01b2\7c\2\2\u01b2\u01b3\7p\2\2"+
		"\u01b3\u01b4\7k\2\2\u01b4\u01b5\7|\2\2\u01b5\u01b6\7g\2\2\u01b6\u01b8"+
		"\7t\2\2\u01b7\u01a5\3\2\2\2\u01b7\u01ae\3\2\2\2\u01b8V\3\2\2\2\u01b9\u01ba"+
		"\7V\2\2\u01ba\u01bb\7j\2\2\u01bb\u01bc\7g\2\2\u01bc\u01c2\7p\2\2\u01bd"+
		"\u01be\7v\2\2\u01be\u01bf\7j\2\2\u01bf\u01c0\7g\2\2\u01c0\u01c2\7p\2\2"+
		"\u01c1\u01b9\3\2\2\2\u01c1\u01bd\3\2\2\2\u01c2X\3\2\2\2\u01c3\u01c4\7"+
		"G\2\2\u01c4\u01c5\7n\2\2\u01c5\u01c6\7u\2\2\u01c6\u01cc\7g\2\2\u01c7\u01c8"+
		"\7g\2\2\u01c8\u01c9\7n\2\2\u01c9\u01ca\7u\2\2\u01ca\u01cc\7g\2\2\u01cb"+
		"\u01c3\3\2\2\2\u01cb\u01c7\3\2\2\2\u01ccZ\3\2\2\2\u01cd\u01ce\7R\2\2\u01ce"+
		"\u01cf\7t\2\2\u01cf\u01d0\7q\2\2\u01d0\u01d1\7r\2\2\u01d1\u01d2\7c\2\2"+
		"\u01d2\u01d3\7i\2\2\u01d3\u01d4\7c\2\2\u01d4\u01d5\7v\2\2\u01d5\u01e0"+
		"\7g\2\2\u01d6\u01d7\7r\2\2\u01d7\u01d8\7t\2\2\u01d8\u01d9\7q\2\2\u01d9"+
		"\u01da\7r\2\2\u01da\u01db\7c\2\2\u01db\u01dc\7i\2\2\u01dc\u01dd\7c\2\2"+
		"\u01dd\u01de\7v\2\2\u01de\u01e0\7g\2\2\u01df\u01cd\3\2\2\2\u01df\u01d6"+
		"\3\2\2\2\u01e0\\\3\2\2\2\u01e1\u01e2\7N\2\2\u01e2\u01e3\7V\2\2\u01e3\u01eb"+
		"\7T\2\2\u01e4\u01e5\7N\2\2\u01e5\u01e6\7v\2\2\u01e6\u01eb\7t\2\2\u01e7"+
		"\u01e8\7n\2\2\u01e8\u01e9\7v\2\2\u01e9\u01eb\7t\2\2\u01ea\u01e1\3\2\2"+
		"\2\u01ea\u01e4\3\2\2\2\u01ea\u01e7\3\2\2\2\u01eb^\3\2\2\2\u01ec\u01ed"+
		"\7T\2\2\u01ed\u01ee\7V\2\2\u01ee\u01f6\7N\2\2\u01ef\u01f0\7T\2\2\u01f0"+
		"\u01f1\7v\2\2\u01f1\u01f6\7n\2\2\u01f2\u01f3\7t\2\2\u01f3\u01f4\7v\2\2"+
		"\u01f4\u01f6\7n\2\2\u01f5\u01ec\3\2\2\2\u01f5\u01ef\3\2\2\2\u01f5\u01f2"+
		"\3\2\2\2\u01f6`\3\2\2\2\u01f7\u01f8\7N\2\2\u01f8\u01f9\7k\2\2\u01f9\u01fa"+
		"\7v\2\2\u01fa\u01fb\7g\2\2\u01fb\u01fc\7t\2\2\u01fc\u01fd\7c\2\2\u01fd"+
		"\u0206\7n\2\2\u01fe\u01ff\7n\2\2\u01ff\u0200\7k\2\2\u0200\u0201\7v\2\2"+
		"\u0201\u0202\7g\2\2\u0202\u0203\7t\2\2\u0203\u0204\7c\2\2\u0204\u0206"+
		"\7n\2\2\u0205\u01f7\3\2\2\2\u0205\u01fe\3\2\2\2\u0206b\3\2\2\2\u0207\u0208"+
		"\7E\2\2\u0208\u0209\7n\2\2\u0209\u020a\7g\2\2\u020a\u020b\7c\2\2\u020b"+
		"\u020c\7p\2\2\u020c\u020d\7w\2\2\u020d\u0216\7r\2\2\u020e\u020f\7e\2\2"+
		"\u020f\u0210\7n\2\2\u0210\u0211\7g\2\2\u0211\u0212\7c\2\2\u0212\u0213"+
		"\7p\2\2\u0213\u0214\7w\2\2\u0214\u0216\7r\2\2\u0215\u0207\3\2\2\2\u0215"+
		"\u020e\3\2\2\2\u0216d\3\2\2\2\u0217\u0218\7W\2\2\u0218\u0219\7p\2\2\u0219"+
		"\u021a\7e\2\2\u021a\u021b\7j\2\2\u021b\u021c\7c\2\2\u021c\u021d\7p\2\2"+
		"\u021d\u021e\7i\2\2\u021e\u021f\7g\2\2\u021f\u022a\7f\2\2\u0220\u0221"+
		"\7w\2\2\u0221\u0222\7p\2\2\u0222\u0223\7e\2\2\u0223\u0224\7j\2\2\u0224"+
		"\u0225\7c\2\2\u0225\u0226\7p\2\2\u0226\u0227\7i\2\2\u0227\u0228\7g\2\2"+
		"\u0228\u022a\7f\2\2\u0229\u0217\3\2\2\2\u0229\u0220\3\2\2\2\u022af\3\2"+
		"\2\2\u022b\u022d\5q9\2\u022c\u022b\3\2\2\2\u022d\u022e\3\2\2\2\u022e\u022c"+
		"\3\2\2\2\u022e\u022f\3\2\2\2\u022fh\3\2\2\2\u0230\u0232\5o8\2\u0231\u0230"+
		"\3\2\2\2\u0232\u0233\3\2\2\2\u0233\u0231\3\2\2\2\u0233\u0234\3\2\2\2\u0234"+
		"j\3\2\2\2\u0235\u0236\5s:\2\u0236l\3\2\2\2\u0237\u0239\5s:\2\u0238\u0237"+
		"\3\2\2\2\u0239\u023a\3\2\2\2\u023a\u0238\3\2\2\2\u023a\u023b\3\2\2\2\u023b"+
		"n\3\2\2\2\u023c\u023d\t\4\2\2\u023dp\3\2\2\2\u023e\u023f\t\5\2\2\u023f"+
		"r\3\2\2\2\u0240\u0241\7^\2\2\u0241\u0244\13\2\2\2\u0242\u0244\n\6\2\2"+
		"\u0243\u0240\3\2\2\2\u0243\u0242\3\2\2\2\u0244t\3\2\2\2\u0245\u0246\7"+
		"%\2\2\u0246v\3\2\2\2\'\2x~\u0085\u0088\u008e\u0091\u0095\u0098\u009e\u00a3"+
		"\u00a8\u00ab\u00b0\u00e6\u00f6\u010c\u0120\u0132\u0142\u0158\u0166\u018b"+
		"\u01a3\u01b7\u01c1\u01cb\u01df\u01ea\u01f5\u0205\u0215\u0229\u022e\u0233"+
		"\u023a\u0243\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}