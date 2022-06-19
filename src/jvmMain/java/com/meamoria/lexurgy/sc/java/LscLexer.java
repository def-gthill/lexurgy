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
		FEATURE_DECL=30, SYLLABLE_FEATURE=31, DIACRITIC_DECL=32, DIA_BEFORE=33, 
		DIA_FIRST=34, DIA_FLOATING=35, SYMBOL_DECL=36, SYLLABLE_DECL=37, EXPLICIT_SYLLABLES=38, 
		CLEAR_SYLLABLES=39, ANY_SYLLABLE=40, DEROMANIZER=41, ROMANIZER=42, ALL_MATCHING=43, 
		FIRST_MATCHING=44, LITERAL=45, LTR=46, RTL=47, PROPAGATE=48, CLEANUP=49, 
		UNCHANGED=50, OFF=51, NUMBER=52, NAME=53, STR1=54, STR=55;
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
			"FEATURE_DECL", "SYLLABLE_FEATURE", "DIACRITIC_DECL", "DIA_BEFORE", "DIA_FIRST", 
			"DIA_FLOATING", "SYMBOL_DECL", "SYLLABLE_DECL", "EXPLICIT_SYLLABLES", 
			"CLEAR_SYLLABLES", "ANY_SYLLABLE", "DEROMANIZER", "ROMANIZER", "ALL_MATCHING", 
			"FIRST_MATCHING", "LITERAL", "LTR", "RTL", "PROPAGATE", "CLEANUP", "UNCHANGED", 
			"OFF", "NUMBER", "NAME", "STR1", "STR", "CHAR", "DIGIT", "ANY", "COMMENT_START"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, null, "'_'", null, null, "'('", "')'", 
			"'*'", "'['", "']'", "'{'", "'}'", "'+'", "'?'", "'-'", "':'", "'~'", 
			"'!'", "'.'", "'$'", "'$$'", "'@'", "'&'", "'&!'", "'>'"
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
			"CLASS_DECL", "FEATURE_DECL", "SYLLABLE_FEATURE", "DIACRITIC_DECL", "DIA_BEFORE", 
			"DIA_FIRST", "DIA_FLOATING", "SYMBOL_DECL", "SYLLABLE_DECL", "EXPLICIT_SYLLABLES", 
			"CLEAR_SYLLABLES", "ANY_SYLLABLE", "DEROMANIZER", "ROMANIZER", "ALL_MATCHING", 
			"FIRST_MATCHING", "LITERAL", "LTR", "RTL", "PROPAGATE", "CLEANUP", "UNCHANGED", 
			"OFF", "NUMBER", "NAME", "STR1", "STR"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\29\u026a\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\3\2\5"+
		"\2{\n\2\3\2\3\2\7\2\177\n\2\f\2\16\2\u0082\13\2\3\2\3\2\3\3\3\3\5\3\u0088"+
		"\n\3\3\4\5\4\u008b\n\4\3\4\3\4\3\4\3\4\5\4\u0091\n\4\3\5\5\5\u0094\n\5"+
		"\3\5\3\5\5\5\u0098\n\5\3\6\5\6\u009b\n\6\3\6\3\6\3\6\3\6\5\6\u00a1\n\6"+
		"\3\7\3\7\3\b\5\b\u00a6\n\b\3\b\3\b\3\b\5\b\u00ab\n\b\3\b\5\b\u00ae\n\b"+
		"\3\t\6\t\u00b1\n\t\r\t\16\t\u00b2\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3"+
		"\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3"+
		"\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\31\3\32\3\32\3\33\3"+
		"\33\3\34\3\34\3\34\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3"+
		"\36\3\36\5\36\u00e9\n\36\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37"+
		"\3\37\3\37\3\37\3\37\3\37\5\37\u00f9\n\37\3 \3 \3 \3 \3 \3 \3 \3 \3 \3"+
		" \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \5 \u010f\n \3!\3!\3!\3!\3!\3!\3!\3!\3"+
		"!\3!\3!\3!\3!\3!\3!\3!\3!\3!\5!\u0123\n!\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3"+
		"\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\5\"\u0135\n\"\3#\3#\3#\3#\3#\3#\3#"+
		"\3#\3#\3#\3#\3#\3#\3#\5#\u0145\n#\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$"+
		"\3$\3$\3$\3$\3$\3$\3$\3$\5$\u015b\n$\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%"+
		"\3%\5%\u0169\n%\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&"+
		"\5&\u017d\n&\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3"+
		"\'\3\'\5\'\u018f\n\'\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\5(\u019b\n(\3)\3)\3"+
		")\3)\3)\3)\3)\3)\3)\3)\5)\u01a7\n)\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3"+
		"*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\5*\u01bf\n*\3+\3+\3+\3+\3+\3+\3+\3+\3"+
		"+\3+\3+\3+\3+\3+\3+\3+\3+\3+\5+\u01d3\n+\3,\3,\3,\3,\3,\3,\3,\3,\5,\u01dd"+
		"\n,\3-\3-\3-\3-\3-\3-\3-\3-\5-\u01e7\n-\3.\3.\3.\3.\3.\3.\3.\3.\3.\3."+
		"\3.\3.\3.\3.\5.\u01f7\n.\3/\3/\3/\3/\3/\3/\3/\3/\3/\5/\u0202\n/\3\60\3"+
		"\60\3\60\3\60\3\60\3\60\3\60\3\60\3\60\5\60\u020d\n\60\3\61\3\61\3\61"+
		"\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61"+
		"\3\61\5\61\u0221\n\61\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62"+
		"\3\62\3\62\3\62\3\62\5\62\u0231\n\62\3\63\3\63\3\63\3\63\3\63\3\63\3\63"+
		"\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\5\63\u0245\n\63"+
		"\3\64\3\64\3\64\3\64\3\64\3\64\5\64\u024d\n\64\3\65\6\65\u0250\n\65\r"+
		"\65\16\65\u0251\3\66\6\66\u0255\n\66\r\66\16\66\u0256\3\67\3\67\38\68"+
		"\u025c\n8\r8\168\u025d\39\39\3:\3:\3;\3;\3;\5;\u0267\n;\3<\3<\2\2=\3\3"+
		"\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21"+
		"!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!"+
		"A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62c\63e\64g\65i\66k\67m8o9q\2"+
		"s\2u\2w\2\3\2\7\4\2\f\f\17\17\f\2\13\17\"\"\u0087\u0087\u00a2\u00a2\u1682"+
		"\u1682\u2002\u200c\u202a\u202b\u2031\u2031\u2061\u2061\u3002\u3002\5\2"+
		"\62;C\\c|\3\2\62;\16\2\f\f\17\17\"#%&((*\61<<?B]_aa}}\177\u0080\2\u028f"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2"+
		"\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2"+
		"\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2"+
		"\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3"+
		"\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2"+
		"\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2"+
		"U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3"+
		"\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2"+
		"\2\2o\3\2\2\2\3z\3\2\2\2\5\u0085\3\2\2\2\7\u008a\3\2\2\2\t\u0093\3\2\2"+
		"\2\13\u009a\3\2\2\2\r\u00a2\3\2\2\2\17\u00a5\3\2\2\2\21\u00b0\3\2\2\2"+
		"\23\u00b4\3\2\2\2\25\u00b6\3\2\2\2\27\u00b8\3\2\2\2\31\u00ba\3\2\2\2\33"+
		"\u00bc\3\2\2\2\35\u00be\3\2\2\2\37\u00c0\3\2\2\2!\u00c2\3\2\2\2#\u00c4"+
		"\3\2\2\2%\u00c6\3\2\2\2\'\u00c8\3\2\2\2)\u00ca\3\2\2\2+\u00cc\3\2\2\2"+
		"-\u00ce\3\2\2\2/\u00d0\3\2\2\2\61\u00d2\3\2\2\2\63\u00d5\3\2\2\2\65\u00d7"+
		"\3\2\2\2\67\u00d9\3\2\2\29\u00dc\3\2\2\2;\u00e8\3\2\2\2=\u00f8\3\2\2\2"+
		"?\u010e\3\2\2\2A\u0122\3\2\2\2C\u0134\3\2\2\2E\u0144\3\2\2\2G\u015a\3"+
		"\2\2\2I\u0168\3\2\2\2K\u017c\3\2\2\2M\u018e\3\2\2\2O\u019a\3\2\2\2Q\u01a6"+
		"\3\2\2\2S\u01be\3\2\2\2U\u01d2\3\2\2\2W\u01dc\3\2\2\2Y\u01e6\3\2\2\2["+
		"\u01f6\3\2\2\2]\u0201\3\2\2\2_\u020c\3\2\2\2a\u0220\3\2\2\2c\u0230\3\2"+
		"\2\2e\u0244\3\2\2\2g\u024c\3\2\2\2i\u024f\3\2\2\2k\u0254\3\2\2\2m\u0258"+
		"\3\2\2\2o\u025b\3\2\2\2q\u025f\3\2\2\2s\u0261\3\2\2\2u\u0266\3\2\2\2w"+
		"\u0268\3\2\2\2y{\5\21\t\2zy\3\2\2\2z{\3\2\2\2{|\3\2\2\2|\u0080\5w<\2}"+
		"\177\n\2\2\2~}\3\2\2\2\177\u0082\3\2\2\2\u0080~\3\2\2\2\u0080\u0081\3"+
		"\2\2\2\u0081\u0083\3\2\2\2\u0082\u0080\3\2\2\2\u0083\u0084\b\2\2\2\u0084"+
		"\4\3\2\2\2\u0085\u0087\7.\2\2\u0086\u0088\5\21\t\2\u0087\u0086\3\2\2\2"+
		"\u0087\u0088\3\2\2\2\u0088\6\3\2\2\2\u0089\u008b\5\21\t\2\u008a\u0089"+
		"\3\2\2\2\u008a\u008b\3\2\2\2\u008b\u008c\3\2\2\2\u008c\u008d\7?\2\2\u008d"+
		"\u008e\7@\2\2\u008e\u0090\3\2\2\2\u008f\u0091\5\21\t\2\u0090\u008f\3\2"+
		"\2\2\u0090\u0091\3\2\2\2\u0091\b\3\2\2\2\u0092\u0094\5\21\t\2\u0093\u0092"+
		"\3\2\2\2\u0093\u0094\3\2\2\2\u0094\u0095\3\2\2\2\u0095\u0097\7\61\2\2"+
		"\u0096\u0098\5\21\t\2\u0097\u0096\3\2\2\2\u0097\u0098\3\2\2\2\u0098\n"+
		"\3\2\2\2\u0099\u009b\5\21\t\2\u009a\u0099\3\2\2\2\u009a\u009b\3\2\2\2"+
		"\u009b\u009c\3\2\2\2\u009c\u009d\7\61\2\2\u009d\u009e\7\61\2\2\u009e\u00a0"+
		"\3\2\2\2\u009f\u00a1\5\21\t\2\u00a0\u009f\3\2\2\2\u00a0\u00a1\3\2\2\2"+
		"\u00a1\f\3\2\2\2\u00a2\u00a3\7a\2\2\u00a3\16\3\2\2\2\u00a4\u00a6\5\21"+
		"\t\2\u00a5\u00a4\3\2\2\2\u00a5\u00a6\3\2\2\2\u00a6\u00aa\3\2\2\2\u00a7"+
		"\u00a8\7\17\2\2\u00a8\u00ab\7\f\2\2\u00a9\u00ab\7\f\2\2\u00aa\u00a7\3"+
		"\2\2\2\u00aa\u00a9\3\2\2\2\u00ab\u00ad\3\2\2\2\u00ac\u00ae\5\21\t\2\u00ad"+
		"\u00ac\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ae\20\3\2\2\2\u00af\u00b1\t\3\2"+
		"\2\u00b0\u00af\3\2\2\2\u00b1\u00b2\3\2\2\2\u00b2\u00b0\3\2\2\2\u00b2\u00b3"+
		"\3\2\2\2\u00b3\22\3\2\2\2\u00b4\u00b5\7*\2\2\u00b5\24\3\2\2\2\u00b6\u00b7"+
		"\7+\2\2\u00b7\26\3\2\2\2\u00b8\u00b9\7,\2\2\u00b9\30\3\2\2\2\u00ba\u00bb"+
		"\7]\2\2\u00bb\32\3\2\2\2\u00bc\u00bd\7_\2\2\u00bd\34\3\2\2\2\u00be\u00bf"+
		"\7}\2\2\u00bf\36\3\2\2\2\u00c0\u00c1\7\177\2\2\u00c1 \3\2\2\2\u00c2\u00c3"+
		"\7-\2\2\u00c3\"\3\2\2\2\u00c4\u00c5\7A\2\2\u00c5$\3\2\2\2\u00c6\u00c7"+
		"\7/\2\2\u00c7&\3\2\2\2\u00c8\u00c9\7<\2\2\u00c9(\3\2\2\2\u00ca\u00cb\7"+
		"\u0080\2\2\u00cb*\3\2\2\2\u00cc\u00cd\7#\2\2\u00cd,\3\2\2\2\u00ce\u00cf"+
		"\7\60\2\2\u00cf.\3\2\2\2\u00d0\u00d1\7&\2\2\u00d1\60\3\2\2\2\u00d2\u00d3"+
		"\7&\2\2\u00d3\u00d4\7&\2\2\u00d4\62\3\2\2\2\u00d5\u00d6\7B\2\2\u00d6\64"+
		"\3\2\2\2\u00d7\u00d8\7(\2\2\u00d8\66\3\2\2\2\u00d9\u00da\7(\2\2\u00da"+
		"\u00db\7#\2\2\u00db8\3\2\2\2\u00dc\u00dd\7@\2\2\u00dd:\3\2\2\2\u00de\u00df"+
		"\7E\2\2\u00df\u00e0\7n\2\2\u00e0\u00e1\7c\2\2\u00e1\u00e2\7u\2\2\u00e2"+
		"\u00e9\7u\2\2\u00e3\u00e4\7e\2\2\u00e4\u00e5\7n\2\2\u00e5\u00e6\7c\2\2"+
		"\u00e6\u00e7\7u\2\2\u00e7\u00e9\7u\2\2\u00e8\u00de\3\2\2\2\u00e8\u00e3"+
		"\3\2\2\2\u00e9<\3\2\2\2\u00ea\u00eb\7H\2\2\u00eb\u00ec\7g\2\2\u00ec\u00ed"+
		"\7c\2\2\u00ed\u00ee\7v\2\2\u00ee\u00ef\7w\2\2\u00ef\u00f0\7t\2\2\u00f0"+
		"\u00f9\7g\2\2\u00f1\u00f2\7h\2\2\u00f2\u00f3\7g\2\2\u00f3\u00f4\7c\2\2"+
		"\u00f4\u00f5\7v\2\2\u00f5\u00f6\7w\2\2\u00f6\u00f7\7t\2\2\u00f7\u00f9"+
		"\7g\2\2\u00f8\u00ea\3\2\2\2\u00f8\u00f1\3\2\2\2\u00f9>\3\2\2\2\u00fa\u00fb"+
		"\7*\2\2\u00fb\u00fc\7U\2\2\u00fc\u00fd\7{\2\2\u00fd\u00fe\7n\2\2\u00fe"+
		"\u00ff\7n\2\2\u00ff\u0100\7c\2\2\u0100\u0101\7d\2\2\u0101\u0102\7n\2\2"+
		"\u0102\u0103\7g\2\2\u0103\u010f\7+\2\2\u0104\u0105\7*\2\2\u0105\u0106"+
		"\7u\2\2\u0106\u0107\7{\2\2\u0107\u0108\7n\2\2\u0108\u0109\7n\2\2\u0109"+
		"\u010a\7c\2\2\u010a\u010b\7d\2\2\u010b\u010c\7n\2\2\u010c\u010d\7g\2\2"+
		"\u010d\u010f\7+\2\2\u010e\u00fa\3\2\2\2\u010e\u0104\3\2\2\2\u010f@\3\2"+
		"\2\2\u0110\u0111\7F\2\2\u0111\u0112\7k\2\2\u0112\u0113\7c\2\2\u0113\u0114"+
		"\7e\2\2\u0114\u0115\7t\2\2\u0115\u0116\7k\2\2\u0116\u0117\7v\2\2\u0117"+
		"\u0118\7k\2\2\u0118\u0123\7e\2\2\u0119\u011a\7f\2\2\u011a\u011b\7k\2\2"+
		"\u011b\u011c\7c\2\2\u011c\u011d\7e\2\2\u011d\u011e\7t\2\2\u011e\u011f"+
		"\7k\2\2\u011f\u0120\7v\2\2\u0120\u0121\7k\2\2\u0121\u0123\7e\2\2\u0122"+
		"\u0110\3\2\2\2\u0122\u0119\3\2\2\2\u0123B\3\2\2\2\u0124\u0125\7*\2\2\u0125"+
		"\u0126\7D\2\2\u0126\u0127\7g\2\2\u0127\u0128\7h\2\2\u0128\u0129\7q\2\2"+
		"\u0129\u012a\7t\2\2\u012a\u012b\7g\2\2\u012b\u0135\7+\2\2\u012c\u012d"+
		"\7*\2\2\u012d\u012e\7d\2\2\u012e\u012f\7g\2\2\u012f\u0130\7h\2\2\u0130"+
		"\u0131\7q\2\2\u0131\u0132\7t\2\2\u0132\u0133\7g\2\2\u0133\u0135\7+\2\2"+
		"\u0134\u0124\3\2\2\2\u0134\u012c\3\2\2\2\u0135D\3\2\2\2\u0136\u0137\7"+
		"*\2\2\u0137\u0138\7H\2\2\u0138\u0139\7k\2\2\u0139\u013a\7t\2\2\u013a\u013b"+
		"\7u\2\2\u013b\u013c\7v\2\2\u013c\u0145\7+\2\2\u013d\u013e\7*\2\2\u013e"+
		"\u013f\7h\2\2\u013f\u0140\7k\2\2\u0140\u0141\7t\2\2\u0141\u0142\7u\2\2"+
		"\u0142\u0143\7v\2\2\u0143\u0145\7+\2\2\u0144\u0136\3\2\2\2\u0144\u013d"+
		"\3\2\2\2\u0145F\3\2\2\2\u0146\u0147\7*\2\2\u0147\u0148\7H\2\2\u0148\u0149"+
		"\7n\2\2\u0149\u014a\7q\2\2\u014a\u014b\7c\2\2\u014b\u014c\7v\2\2\u014c"+
		"\u014d\7k\2\2\u014d\u014e\7p\2\2\u014e\u014f\7i\2\2\u014f\u015b\7+\2\2"+
		"\u0150\u0151\7*\2\2\u0151\u0152\7h\2\2\u0152\u0153\7n\2\2\u0153\u0154"+
		"\7q\2\2\u0154\u0155\7c\2\2\u0155\u0156\7v\2\2\u0156\u0157\7k\2\2\u0157"+
		"\u0158\7p\2\2\u0158\u0159\7i\2\2\u0159\u015b\7+\2\2\u015a\u0146\3\2\2"+
		"\2\u015a\u0150\3\2\2\2\u015bH\3\2\2\2\u015c\u015d\7U\2\2\u015d\u015e\7"+
		"{\2\2\u015e\u015f\7o\2\2\u015f\u0160\7d\2\2\u0160\u0161\7q\2\2\u0161\u0169"+
		"\7n\2\2\u0162\u0163\7u\2\2\u0163\u0164\7{\2\2\u0164\u0165\7o\2\2\u0165"+
		"\u0166\7d\2\2\u0166\u0167\7q\2\2\u0167\u0169\7n\2\2\u0168\u015c\3\2\2"+
		"\2\u0168\u0162\3\2\2\2\u0169J\3\2\2\2\u016a\u016b\7U\2\2\u016b\u016c\7"+
		"{\2\2\u016c\u016d\7n\2\2\u016d\u016e\7n\2\2\u016e\u016f\7c\2\2\u016f\u0170"+
		"\7d\2\2\u0170\u0171\7n\2\2\u0171\u0172\7g\2\2\u0172\u017d\7u\2\2\u0173"+
		"\u0174\7u\2\2\u0174\u0175\7{\2\2\u0175\u0176\7n\2\2\u0176\u0177\7n\2\2"+
		"\u0177\u0178\7c\2\2\u0178\u0179\7d\2\2\u0179\u017a\7n\2\2\u017a\u017b"+
		"\7g\2\2\u017b\u017d\7u\2\2\u017c\u016a\3\2\2\2\u017c\u0173\3\2\2\2\u017d"+
		"L\3\2\2\2\u017e\u017f\7G\2\2\u017f\u0180\7z\2\2\u0180\u0181\7r\2\2\u0181"+
		"\u0182\7n\2\2\u0182\u0183\7k\2\2\u0183\u0184\7e\2\2\u0184\u0185\7k\2\2"+
		"\u0185\u018f\7v\2\2\u0186\u0187\7g\2\2\u0187\u0188\7z\2\2\u0188\u0189"+
		"\7r\2\2\u0189\u018a\7n\2\2\u018a\u018b\7k\2\2\u018b\u018c\7e\2\2\u018c"+
		"\u018d\7k\2\2\u018d\u018f\7v\2\2\u018e\u017e\3\2\2\2\u018e\u0186\3\2\2"+
		"\2\u018fN\3\2\2\2\u0190\u0191\7E\2\2\u0191\u0192\7n\2\2\u0192\u0193\7"+
		"g\2\2\u0193\u0194\7c\2\2\u0194\u019b\7t\2\2\u0195\u0196\7e\2\2\u0196\u0197"+
		"\7n\2\2\u0197\u0198\7g\2\2\u0198\u0199\7c\2\2\u0199\u019b\7t\2\2\u019a"+
		"\u0190\3\2\2\2\u019a\u0195\3\2\2\2\u019bP\3\2\2\2\u019c\u019d\7>\2\2\u019d"+
		"\u019e\7U\2\2\u019e\u019f\7{\2\2\u019f\u01a0\7n\2\2\u01a0\u01a7\7@\2\2"+
		"\u01a1\u01a2\7>\2\2\u01a2\u01a3\7u\2\2\u01a3\u01a4\7{\2\2\u01a4\u01a5"+
		"\7n\2\2\u01a5\u01a7\7@\2\2\u01a6\u019c\3\2\2\2\u01a6\u01a1\3\2\2\2\u01a7"+
		"R\3\2\2\2\u01a8\u01a9\7F\2\2\u01a9\u01aa\7g\2\2\u01aa\u01ab\7t\2\2\u01ab"+
		"\u01ac\7q\2\2\u01ac\u01ad\7o\2\2\u01ad\u01ae\7c\2\2\u01ae\u01af\7p\2\2"+
		"\u01af\u01b0\7k\2\2\u01b0\u01b1\7|\2\2\u01b1\u01b2\7g\2\2\u01b2\u01bf"+
		"\7t\2\2\u01b3\u01b4\7f\2\2\u01b4\u01b5\7g\2\2\u01b5\u01b6\7t\2\2\u01b6"+
		"\u01b7\7q\2\2\u01b7\u01b8\7o\2\2\u01b8\u01b9\7c\2\2\u01b9\u01ba\7p\2\2"+
		"\u01ba\u01bb\7k\2\2\u01bb\u01bc\7|\2\2\u01bc\u01bd\7g\2\2\u01bd\u01bf"+
		"\7t\2\2\u01be\u01a8\3\2\2\2\u01be\u01b3\3\2\2\2\u01bfT\3\2\2\2\u01c0\u01c1"+
		"\7T\2\2\u01c1\u01c2\7q\2\2\u01c2\u01c3\7o\2\2\u01c3\u01c4\7c\2\2\u01c4"+
		"\u01c5\7p\2\2\u01c5\u01c6\7k\2\2\u01c6\u01c7\7|\2\2\u01c7\u01c8\7g\2\2"+
		"\u01c8\u01d3\7t\2\2\u01c9\u01ca\7t\2\2\u01ca\u01cb\7q\2\2\u01cb\u01cc"+
		"\7o\2\2\u01cc\u01cd\7c\2\2\u01cd\u01ce\7p\2\2\u01ce\u01cf\7k\2\2\u01cf"+
		"\u01d0\7|\2\2\u01d0\u01d1\7g\2\2\u01d1\u01d3\7t\2\2\u01d2\u01c0\3\2\2"+
		"\2\u01d2\u01c9\3\2\2\2\u01d3V\3\2\2\2\u01d4\u01d5\7V\2\2\u01d5\u01d6\7"+
		"j\2\2\u01d6\u01d7\7g\2\2\u01d7\u01dd\7p\2\2\u01d8\u01d9\7v\2\2\u01d9\u01da"+
		"\7j\2\2\u01da\u01db\7g\2\2\u01db\u01dd\7p\2\2\u01dc\u01d4\3\2\2\2\u01dc"+
		"\u01d8\3\2\2\2\u01ddX\3\2\2\2\u01de\u01df\7G\2\2\u01df\u01e0\7n\2\2\u01e0"+
		"\u01e1\7u\2\2\u01e1\u01e7\7g\2\2\u01e2\u01e3\7g\2\2\u01e3\u01e4\7n\2\2"+
		"\u01e4\u01e5\7u\2\2\u01e5\u01e7\7g\2\2\u01e6\u01de\3\2\2\2\u01e6\u01e2"+
		"\3\2\2\2\u01e7Z\3\2\2\2\u01e8\u01e9\7N\2\2\u01e9\u01ea\7k\2\2\u01ea\u01eb"+
		"\7v\2\2\u01eb\u01ec\7g\2\2\u01ec\u01ed\7t\2\2\u01ed\u01ee\7c\2\2\u01ee"+
		"\u01f7\7n\2\2\u01ef\u01f0\7n\2\2\u01f0\u01f1\7k\2\2\u01f1\u01f2\7v\2\2"+
		"\u01f2\u01f3\7g\2\2\u01f3\u01f4\7t\2\2\u01f4\u01f5\7c\2\2\u01f5\u01f7"+
		"\7n\2\2\u01f6\u01e8\3\2\2\2\u01f6\u01ef\3\2\2\2\u01f7\\\3\2\2\2\u01f8"+
		"\u01f9\7N\2\2\u01f9\u01fa\7V\2\2\u01fa\u0202\7T\2\2\u01fb\u01fc\7N\2\2"+
		"\u01fc\u01fd\7v\2\2\u01fd\u0202\7t\2\2\u01fe\u01ff\7n\2\2\u01ff\u0200"+
		"\7v\2\2\u0200\u0202\7t\2\2\u0201\u01f8\3\2\2\2\u0201\u01fb\3\2\2\2\u0201"+
		"\u01fe\3\2\2\2\u0202^\3\2\2\2\u0203\u0204\7T\2\2\u0204\u0205\7V\2\2\u0205"+
		"\u020d\7N\2\2\u0206\u0207\7T\2\2\u0207\u0208\7v\2\2\u0208\u020d\7n\2\2"+
		"\u0209\u020a\7t\2\2\u020a\u020b\7v\2\2\u020b\u020d\7n\2\2\u020c\u0203"+
		"\3\2\2\2\u020c\u0206\3\2\2\2\u020c\u0209\3\2\2\2\u020d`\3\2\2\2\u020e"+
		"\u020f\7R\2\2\u020f\u0210\7t\2\2\u0210\u0211\7q\2\2\u0211\u0212\7r\2\2"+
		"\u0212\u0213\7c\2\2\u0213\u0214\7i\2\2\u0214\u0215\7c\2\2\u0215\u0216"+
		"\7v\2\2\u0216\u0221\7g\2\2\u0217\u0218\7r\2\2\u0218\u0219\7t\2\2\u0219"+
		"\u021a\7q\2\2\u021a\u021b\7r\2\2\u021b\u021c\7c\2\2\u021c\u021d\7i\2\2"+
		"\u021d\u021e\7c\2\2\u021e\u021f\7v\2\2\u021f\u0221\7g\2\2\u0220\u020e"+
		"\3\2\2\2\u0220\u0217\3\2\2\2\u0221b\3\2\2\2\u0222\u0223\7E\2\2\u0223\u0224"+
		"\7n\2\2\u0224\u0225\7g\2\2\u0225\u0226\7c\2\2\u0226\u0227\7p\2\2\u0227"+
		"\u0228\7w\2\2\u0228\u0231\7r\2\2\u0229\u022a\7e\2\2\u022a\u022b\7n\2\2"+
		"\u022b\u022c\7g\2\2\u022c\u022d\7c\2\2\u022d\u022e\7p\2\2\u022e\u022f"+
		"\7w\2\2\u022f\u0231\7r\2\2\u0230\u0222\3\2\2\2\u0230\u0229\3\2\2\2\u0231"+
		"d\3\2\2\2\u0232\u0233\7W\2\2\u0233\u0234\7p\2\2\u0234\u0235\7e\2\2\u0235"+
		"\u0236\7j\2\2\u0236\u0237\7c\2\2\u0237\u0238\7p\2\2\u0238\u0239\7i\2\2"+
		"\u0239\u023a\7g\2\2\u023a\u0245\7f\2\2\u023b\u023c\7w\2\2\u023c\u023d"+
		"\7p\2\2\u023d\u023e\7e\2\2\u023e\u023f\7j\2\2\u023f\u0240\7c\2\2\u0240"+
		"\u0241\7p\2\2\u0241\u0242\7i\2\2\u0242\u0243\7g\2\2\u0243\u0245\7f\2\2"+
		"\u0244\u0232\3\2\2\2\u0244\u023b\3\2\2\2\u0245f\3\2\2\2\u0246\u0247\7"+
		"Q\2\2\u0247\u0248\7h\2\2\u0248\u024d\7h\2\2\u0249\u024a\7q\2\2\u024a\u024b"+
		"\7h\2\2\u024b\u024d\7h\2\2\u024c\u0246\3\2\2\2\u024c\u0249\3\2\2\2\u024d"+
		"h\3\2\2\2\u024e\u0250\5s:\2\u024f\u024e\3\2\2\2\u0250\u0251\3\2\2\2\u0251"+
		"\u024f\3\2\2\2\u0251\u0252\3\2\2\2\u0252j\3\2\2\2\u0253\u0255\5q9\2\u0254"+
		"\u0253\3\2\2\2\u0255\u0256\3\2\2\2\u0256\u0254\3\2\2\2\u0256\u0257\3\2"+
		"\2\2\u0257l\3\2\2\2\u0258\u0259\5u;\2\u0259n\3\2\2\2\u025a\u025c\5u;\2"+
		"\u025b\u025a\3\2\2\2\u025c\u025d\3\2\2\2\u025d\u025b\3\2\2\2\u025d\u025e"+
		"\3\2\2\2\u025ep\3\2\2\2\u025f\u0260\t\4\2\2\u0260r\3\2\2\2\u0261\u0262"+
		"\t\5\2\2\u0262t\3\2\2\2\u0263\u0264\7^\2\2\u0264\u0267\13\2\2\2\u0265"+
		"\u0267\n\6\2\2\u0266\u0263\3\2\2\2\u0266\u0265\3\2\2\2\u0267v\3\2\2\2"+
		"\u0268\u0269\7%\2\2\u0269x\3\2\2\2+\2z\u0080\u0087\u008a\u0090\u0093\u0097"+
		"\u009a\u00a0\u00a5\u00aa\u00ad\u00b2\u00e8\u00f8\u010e\u0122\u0134\u0144"+
		"\u015a\u0168\u017c\u018e\u019a\u01a6\u01be\u01d2\u01dc\u01e6\u01f6\u0201"+
		"\u020c\u0220\u0230\u0244\u024c\u0251\u0256\u025d\u0266\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}