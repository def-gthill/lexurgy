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
		NEGATION=20, SYLLABLE_BOUNDARY=21, WORD_BOUNDARY=22, BETWEEN_WORDS=23, 
		CLASSREF=24, INTERSECTION=25, CLASS_DECL=26, FEATURE_DECL=27, SYLLABLE_FEATURE=28, 
		DIACRITIC=29, DIA_BEFORE=30, DIA_FIRST=31, DIA_FLOATING=32, SYMBOL=33, 
		SYLLABLE_DECL=34, EXPLICIT_SYLLABLES=35, CLEAR_SYLLABLES=36, ANY_SYLLABLE=37, 
		DEROMANIZER=38, ROMANIZER=39, ALL_MATCHING=40, FIRST_MATCHING=41, PROPAGATE=42, 
		LITERAL=43, UNCHANGED=44, NUMBER=45, NAME=46, STR1=47, STR=48;
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
			"NEGATION", "SYLLABLE_BOUNDARY", "WORD_BOUNDARY", "BETWEEN_WORDS", "CLASSREF", 
			"INTERSECTION", "CLASS_DECL", "FEATURE_DECL", "SYLLABLE_FEATURE", "DIACRITIC", 
			"DIA_BEFORE", "DIA_FIRST", "DIA_FLOATING", "SYMBOL", "SYLLABLE_DECL", 
			"EXPLICIT_SYLLABLES", "CLEAR_SYLLABLES", "ANY_SYLLABLE", "DEROMANIZER", 
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
			"'.'", "'$'", "'$$'", "'@'", "'&'", null, null, null, null, null, null, 
			null, null, "'Syllables'", "'explicit'", "'clear'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "COMMENT", "SEP", "CHANGE", "CONDITION", "EXCLUSION", "ANCHOR", 
			"NEWLINE", "WHITESPACE", "O_PAREN", "C_PAREN", "NULL", "MATRIX_START", 
			"MATRIX_END", "LIST_START", "LIST_END", "AT_LEAST_ONE", "OPTIONAL", "HYPHEN", 
			"RULE_START", "NEGATION", "SYLLABLE_BOUNDARY", "WORD_BOUNDARY", "BETWEEN_WORDS", 
			"CLASSREF", "INTERSECTION", "CLASS_DECL", "FEATURE_DECL", "SYLLABLE_FEATURE", 
			"DIACRITIC", "DIA_BEFORE", "DIA_FIRST", "DIA_FLOATING", "SYMBOL", "SYLLABLE_DECL", 
			"EXPLICIT_SYLLABLES", "CLEAR_SYLLABLES", "ANY_SYLLABLE", "DEROMANIZER", 
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\62\u020e\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64"+
		"\t\64\4\65\t\65\3\2\5\2m\n\2\3\2\3\2\7\2q\n\2\f\2\16\2t\13\2\3\2\3\2\3"+
		"\3\3\3\5\3z\n\3\3\4\5\4}\n\4\3\4\3\4\3\4\3\4\5\4\u0083\n\4\3\5\5\5\u0086"+
		"\n\5\3\5\3\5\5\5\u008a\n\5\3\6\5\6\u008d\n\6\3\6\3\6\3\6\3\6\5\6\u0093"+
		"\n\6\3\7\3\7\3\b\5\b\u0098\n\b\3\b\3\b\3\b\5\b\u009d\n\b\3\b\5\b\u00a0"+
		"\n\b\3\t\6\t\u00a3\n\t\r\t\16\t\u00a4\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3"+
		"\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3"+
		"\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\30\3\31\3\31\3\32\3\32\3"+
		"\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\5\33\u00d4\n\33\3\34"+
		"\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\5\34"+
		"\u00e4\n\34\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35"+
		"\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\5\35\u00fa\n\35\3\36\3\36\3\36"+
		"\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36"+
		"\3\36\5\36\u010e\n\36\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37"+
		"\3\37\3\37\3\37\3\37\3\37\3\37\5\37\u0120\n\37\3 \3 \3 \3 \3 \3 \3 \3"+
		" \3 \3 \3 \3 \3 \3 \5 \u0130\n \3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3"+
		"!\3!\3!\3!\3!\3!\3!\3!\5!\u0146\n!\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\""+
		"\3\"\3\"\3\"\5\"\u0154\n\"\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3$\3$\3$\3$\3"+
		"$\3$\3$\3$\3$\3%\3%\3%\3%\3%\3%\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\5&\u0179"+
		"\n&\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3"+
		"\'\3\'\3\'\3\'\3\'\3\'\5\'\u0191\n\'\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3("+
		"\3(\3(\3(\3(\3(\3(\3(\5(\u01a5\n(\3)\3)\3)\3)\3)\3)\3)\3)\5)\u01af\n)"+
		"\3*\3*\3*\3*\3*\3*\3*\3*\5*\u01b9\n*\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+"+
		"\3+\3+\3+\3+\3+\3+\3+\5+\u01cd\n+\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,"+
		"\3,\3,\5,\u01dd\n,\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-"+
		"\3-\5-\u01f1\n-\3.\6.\u01f4\n.\r.\16.\u01f5\3/\6/\u01f9\n/\r/\16/\u01fa"+
		"\3\60\3\60\3\61\6\61\u0200\n\61\r\61\16\61\u0201\3\62\3\62\3\63\3\63\3"+
		"\64\3\64\3\64\5\64\u020b\n\64\3\65\3\65\2\2\66\3\3\5\4\7\5\t\6\13\7\r"+
		"\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25"+
		")\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O"+
		")Q*S+U,W-Y.[/]\60_\61a\62c\2e\2g\2i\2\3\2\7\4\2\f\f\17\17\f\2\13\17\""+
		"\"\u0087\u0087\u00a2\u00a2\u1682\u1682\u2002\u200c\u202a\u202b\u2031\u2031"+
		"\u2061\u2061\u3002\u3002\5\2\62;C\\c|\3\2\62;\16\2\f\f\17\17\"#%&((*\61"+
		"<<?B]_aa}}\177\177\2\u022a\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2"+
		"\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2"+
		"\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3"+
		"\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2"+
		"\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67"+
		"\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2"+
		"\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2"+
		"\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]"+
		"\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\3l\3\2\2\2\5w\3\2\2\2\7|\3\2\2\2\t\u0085"+
		"\3\2\2\2\13\u008c\3\2\2\2\r\u0094\3\2\2\2\17\u0097\3\2\2\2\21\u00a2\3"+
		"\2\2\2\23\u00a6\3\2\2\2\25\u00a8\3\2\2\2\27\u00aa\3\2\2\2\31\u00ac\3\2"+
		"\2\2\33\u00ae\3\2\2\2\35\u00b0\3\2\2\2\37\u00b2\3\2\2\2!\u00b4\3\2\2\2"+
		"#\u00b6\3\2\2\2%\u00b8\3\2\2\2\'\u00ba\3\2\2\2)\u00bc\3\2\2\2+\u00be\3"+
		"\2\2\2-\u00c0\3\2\2\2/\u00c2\3\2\2\2\61\u00c5\3\2\2\2\63\u00c7\3\2\2\2"+
		"\65\u00d3\3\2\2\2\67\u00e3\3\2\2\29\u00f9\3\2\2\2;\u010d\3\2\2\2=\u011f"+
		"\3\2\2\2?\u012f\3\2\2\2A\u0145\3\2\2\2C\u0153\3\2\2\2E\u0155\3\2\2\2G"+
		"\u015f\3\2\2\2I\u0168\3\2\2\2K\u0178\3\2\2\2M\u0190\3\2\2\2O\u01a4\3\2"+
		"\2\2Q\u01ae\3\2\2\2S\u01b8\3\2\2\2U\u01cc\3\2\2\2W\u01dc\3\2\2\2Y\u01f0"+
		"\3\2\2\2[\u01f3\3\2\2\2]\u01f8\3\2\2\2_\u01fc\3\2\2\2a\u01ff\3\2\2\2c"+
		"\u0203\3\2\2\2e\u0205\3\2\2\2g\u020a\3\2\2\2i\u020c\3\2\2\2km\5\21\t\2"+
		"lk\3\2\2\2lm\3\2\2\2mn\3\2\2\2nr\5i\65\2oq\n\2\2\2po\3\2\2\2qt\3\2\2\2"+
		"rp\3\2\2\2rs\3\2\2\2su\3\2\2\2tr\3\2\2\2uv\b\2\2\2v\4\3\2\2\2wy\7.\2\2"+
		"xz\5\21\t\2yx\3\2\2\2yz\3\2\2\2z\6\3\2\2\2{}\5\21\t\2|{\3\2\2\2|}\3\2"+
		"\2\2}~\3\2\2\2~\177\7?\2\2\177\u0080\7@\2\2\u0080\u0082\3\2\2\2\u0081"+
		"\u0083\5\21\t\2\u0082\u0081\3\2\2\2\u0082\u0083\3\2\2\2\u0083\b\3\2\2"+
		"\2\u0084\u0086\5\21\t\2\u0085\u0084\3\2\2\2\u0085\u0086\3\2\2\2\u0086"+
		"\u0087\3\2\2\2\u0087\u0089\7\61\2\2\u0088\u008a\5\21\t\2\u0089\u0088\3"+
		"\2\2\2\u0089\u008a\3\2\2\2\u008a\n\3\2\2\2\u008b\u008d\5\21\t\2\u008c"+
		"\u008b\3\2\2\2\u008c\u008d\3\2\2\2\u008d\u008e\3\2\2\2\u008e\u008f\7\61"+
		"\2\2\u008f\u0090\7\61\2\2\u0090\u0092\3\2\2\2\u0091\u0093\5\21\t\2\u0092"+
		"\u0091\3\2\2\2\u0092\u0093\3\2\2\2\u0093\f\3\2\2\2\u0094\u0095\7a\2\2"+
		"\u0095\16\3\2\2\2\u0096\u0098\5\21\t\2\u0097\u0096\3\2\2\2\u0097\u0098"+
		"\3\2\2\2\u0098\u009c\3\2\2\2\u0099\u009a\7\17\2\2\u009a\u009d\7\f\2\2"+
		"\u009b\u009d\7\f\2\2\u009c\u0099\3\2\2\2\u009c\u009b\3\2\2\2\u009d\u009f"+
		"\3\2\2\2\u009e\u00a0\5\21\t\2\u009f\u009e\3\2\2\2\u009f\u00a0\3\2\2\2"+
		"\u00a0\20\3\2\2\2\u00a1\u00a3\t\3\2\2\u00a2\u00a1\3\2\2\2\u00a3\u00a4"+
		"\3\2\2\2\u00a4\u00a2\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5\22\3\2\2\2\u00a6"+
		"\u00a7\7*\2\2\u00a7\24\3\2\2\2\u00a8\u00a9\7+\2\2\u00a9\26\3\2\2\2\u00aa"+
		"\u00ab\7,\2\2\u00ab\30\3\2\2\2\u00ac\u00ad\7]\2\2\u00ad\32\3\2\2\2\u00ae"+
		"\u00af\7_\2\2\u00af\34\3\2\2\2\u00b0\u00b1\7}\2\2\u00b1\36\3\2\2\2\u00b2"+
		"\u00b3\7\177\2\2\u00b3 \3\2\2\2\u00b4\u00b5\7-\2\2\u00b5\"\3\2\2\2\u00b6"+
		"\u00b7\7A\2\2\u00b7$\3\2\2\2\u00b8\u00b9\7/\2\2\u00b9&\3\2\2\2\u00ba\u00bb"+
		"\7<\2\2\u00bb(\3\2\2\2\u00bc\u00bd\7#\2\2\u00bd*\3\2\2\2\u00be\u00bf\7"+
		"\60\2\2\u00bf,\3\2\2\2\u00c0\u00c1\7&\2\2\u00c1.\3\2\2\2\u00c2\u00c3\7"+
		"&\2\2\u00c3\u00c4\7&\2\2\u00c4\60\3\2\2\2\u00c5\u00c6\7B\2\2\u00c6\62"+
		"\3\2\2\2\u00c7\u00c8\7(\2\2\u00c8\64\3\2\2\2\u00c9\u00ca\7E\2\2\u00ca"+
		"\u00cb\7n\2\2\u00cb\u00cc\7c\2\2\u00cc\u00cd\7u\2\2\u00cd\u00d4\7u\2\2"+
		"\u00ce\u00cf\7e\2\2\u00cf\u00d0\7n\2\2\u00d0\u00d1\7c\2\2\u00d1\u00d2"+
		"\7u\2\2\u00d2\u00d4\7u\2\2\u00d3\u00c9\3\2\2\2\u00d3\u00ce\3\2\2\2\u00d4"+
		"\66\3\2\2\2\u00d5\u00d6\7H\2\2\u00d6\u00d7\7g\2\2\u00d7\u00d8\7c\2\2\u00d8"+
		"\u00d9\7v\2\2\u00d9\u00da\7w\2\2\u00da\u00db\7t\2\2\u00db\u00e4\7g\2\2"+
		"\u00dc\u00dd\7h\2\2\u00dd\u00de\7g\2\2\u00de\u00df\7c\2\2\u00df\u00e0"+
		"\7v\2\2\u00e0\u00e1\7w\2\2\u00e1\u00e2\7t\2\2\u00e2\u00e4\7g\2\2\u00e3"+
		"\u00d5\3\2\2\2\u00e3\u00dc\3\2\2\2\u00e48\3\2\2\2\u00e5\u00e6\7*\2\2\u00e6"+
		"\u00e7\7U\2\2\u00e7\u00e8\7{\2\2\u00e8\u00e9\7n\2\2\u00e9\u00ea\7n\2\2"+
		"\u00ea\u00eb\7c\2\2\u00eb\u00ec\7d\2\2\u00ec\u00ed\7n\2\2\u00ed\u00ee"+
		"\7g\2\2\u00ee\u00fa\7+\2\2\u00ef\u00f0\7*\2\2\u00f0\u00f1\7u\2\2\u00f1"+
		"\u00f2\7{\2\2\u00f2\u00f3\7n\2\2\u00f3\u00f4\7n\2\2\u00f4\u00f5\7c\2\2"+
		"\u00f5\u00f6\7d\2\2\u00f6\u00f7\7n\2\2\u00f7\u00f8\7g\2\2\u00f8\u00fa"+
		"\7+\2\2\u00f9\u00e5\3\2\2\2\u00f9\u00ef\3\2\2\2\u00fa:\3\2\2\2\u00fb\u00fc"+
		"\7F\2\2\u00fc\u00fd\7k\2\2\u00fd\u00fe\7c\2\2\u00fe\u00ff\7e\2\2\u00ff"+
		"\u0100\7t\2\2\u0100\u0101\7k\2\2\u0101\u0102\7v\2\2\u0102\u0103\7k\2\2"+
		"\u0103\u010e\7e\2\2\u0104\u0105\7f\2\2\u0105\u0106\7k\2\2\u0106\u0107"+
		"\7c\2\2\u0107\u0108\7e\2\2\u0108\u0109\7t\2\2\u0109\u010a\7k\2\2\u010a"+
		"\u010b\7v\2\2\u010b\u010c\7k\2\2\u010c\u010e\7e\2\2\u010d\u00fb\3\2\2"+
		"\2\u010d\u0104\3\2\2\2\u010e<\3\2\2\2\u010f\u0110\7*\2\2\u0110\u0111\7"+
		"D\2\2\u0111\u0112\7g\2\2\u0112\u0113\7h\2\2\u0113\u0114\7q\2\2\u0114\u0115"+
		"\7t\2\2\u0115\u0116\7g\2\2\u0116\u0120\7+\2\2\u0117\u0118\7*\2\2\u0118"+
		"\u0119\7d\2\2\u0119\u011a\7g\2\2\u011a\u011b\7h\2\2\u011b\u011c\7q\2\2"+
		"\u011c\u011d\7t\2\2\u011d\u011e\7g\2\2\u011e\u0120\7+\2\2\u011f\u010f"+
		"\3\2\2\2\u011f\u0117\3\2\2\2\u0120>\3\2\2\2\u0121\u0122\7*\2\2\u0122\u0123"+
		"\7H\2\2\u0123\u0124\7k\2\2\u0124\u0125\7t\2\2\u0125\u0126\7u\2\2\u0126"+
		"\u0127\7v\2\2\u0127\u0130\7+\2\2\u0128\u0129\7*\2\2\u0129\u012a\7h\2\2"+
		"\u012a\u012b\7k\2\2\u012b\u012c\7t\2\2\u012c\u012d\7u\2\2\u012d\u012e"+
		"\7v\2\2\u012e\u0130\7+\2\2\u012f\u0121\3\2\2\2\u012f\u0128\3\2\2\2\u0130"+
		"@\3\2\2\2\u0131\u0132\7*\2\2\u0132\u0133\7H\2\2\u0133\u0134\7n\2\2\u0134"+
		"\u0135\7q\2\2\u0135\u0136\7c\2\2\u0136\u0137\7v\2\2\u0137\u0138\7k\2\2"+
		"\u0138\u0139\7p\2\2\u0139\u013a\7i\2\2\u013a\u0146\7+\2\2\u013b\u013c"+
		"\7*\2\2\u013c\u013d\7h\2\2\u013d\u013e\7n\2\2\u013e\u013f\7q\2\2\u013f"+
		"\u0140\7c\2\2\u0140\u0141\7v\2\2\u0141\u0142\7k\2\2\u0142\u0143\7p\2\2"+
		"\u0143\u0144\7i\2\2\u0144\u0146\7+\2\2\u0145\u0131\3\2\2\2\u0145\u013b"+
		"\3\2\2\2\u0146B\3\2\2\2\u0147\u0148\7U\2\2\u0148\u0149\7{\2\2\u0149\u014a"+
		"\7o\2\2\u014a\u014b\7d\2\2\u014b\u014c\7q\2\2\u014c\u0154\7n\2\2\u014d"+
		"\u014e\7u\2\2\u014e\u014f\7{\2\2\u014f\u0150\7o\2\2\u0150\u0151\7d\2\2"+
		"\u0151\u0152\7q\2\2\u0152\u0154\7n\2\2\u0153\u0147\3\2\2\2\u0153\u014d"+
		"\3\2\2\2\u0154D\3\2\2\2\u0155\u0156\7U\2\2\u0156\u0157\7{\2\2\u0157\u0158"+
		"\7n\2\2\u0158\u0159\7n\2\2\u0159\u015a\7c\2\2\u015a\u015b\7d\2\2\u015b"+
		"\u015c\7n\2\2\u015c\u015d\7g\2\2\u015d\u015e\7u\2\2\u015eF\3\2\2\2\u015f"+
		"\u0160\7g\2\2\u0160\u0161\7z\2\2\u0161\u0162\7r\2\2\u0162\u0163\7n\2\2"+
		"\u0163\u0164\7k\2\2\u0164\u0165\7e\2\2\u0165\u0166\7k\2\2\u0166\u0167"+
		"\7v\2\2\u0167H\3\2\2\2\u0168\u0169\7e\2\2\u0169\u016a\7n\2\2\u016a\u016b"+
		"\7g\2\2\u016b\u016c\7c\2\2\u016c\u016d\7t\2\2\u016dJ\3\2\2\2\u016e\u016f"+
		"\7>\2\2\u016f\u0170\7U\2\2\u0170\u0171\7{\2\2\u0171\u0172\7n\2\2\u0172"+
		"\u0179\7@\2\2\u0173\u0174\7>\2\2\u0174\u0175\7u\2\2\u0175\u0176\7{\2\2"+
		"\u0176\u0177\7n\2\2\u0177\u0179\7@\2\2\u0178\u016e\3\2\2\2\u0178\u0173"+
		"\3\2\2\2\u0179L\3\2\2\2\u017a\u017b\7F\2\2\u017b\u017c\7g\2\2\u017c\u017d"+
		"\7t\2\2\u017d\u017e\7q\2\2\u017e\u017f\7o\2\2\u017f\u0180\7c\2\2\u0180"+
		"\u0181\7p\2\2\u0181\u0182\7k\2\2\u0182\u0183\7|\2\2\u0183\u0184\7g\2\2"+
		"\u0184\u0191\7t\2\2\u0185\u0186\7f\2\2\u0186\u0187\7g\2\2\u0187\u0188"+
		"\7t\2\2\u0188\u0189\7q\2\2\u0189\u018a\7o\2\2\u018a\u018b\7c\2\2\u018b"+
		"\u018c\7p\2\2\u018c\u018d\7k\2\2\u018d\u018e\7|\2\2\u018e\u018f\7g\2\2"+
		"\u018f\u0191\7t\2\2\u0190\u017a\3\2\2\2\u0190\u0185\3\2\2\2\u0191N\3\2"+
		"\2\2\u0192\u0193\7T\2\2\u0193\u0194\7q\2\2\u0194\u0195\7o\2\2\u0195\u0196"+
		"\7c\2\2\u0196\u0197\7p\2\2\u0197\u0198\7k\2\2\u0198\u0199\7|\2\2\u0199"+
		"\u019a\7g\2\2\u019a\u01a5\7t\2\2\u019b\u019c\7t\2\2\u019c\u019d\7q\2\2"+
		"\u019d\u019e\7o\2\2\u019e\u019f\7c\2\2\u019f\u01a0\7p\2\2\u01a0\u01a1"+
		"\7k\2\2\u01a1\u01a2\7|\2\2\u01a2\u01a3\7g\2\2\u01a3\u01a5\7t\2\2\u01a4"+
		"\u0192\3\2\2\2\u01a4\u019b\3\2\2\2\u01a5P\3\2\2\2\u01a6\u01a7\7V\2\2\u01a7"+
		"\u01a8\7j\2\2\u01a8\u01a9\7g\2\2\u01a9\u01af\7p\2\2\u01aa\u01ab\7v\2\2"+
		"\u01ab\u01ac\7j\2\2\u01ac\u01ad\7g\2\2\u01ad\u01af\7p\2\2\u01ae\u01a6"+
		"\3\2\2\2\u01ae\u01aa\3\2\2\2\u01afR\3\2\2\2\u01b0\u01b1\7G\2\2\u01b1\u01b2"+
		"\7n\2\2\u01b2\u01b3\7u\2\2\u01b3\u01b9\7g\2\2\u01b4\u01b5\7g\2\2\u01b5"+
		"\u01b6\7n\2\2\u01b6\u01b7\7u\2\2\u01b7\u01b9\7g\2\2\u01b8\u01b0\3\2\2"+
		"\2\u01b8\u01b4\3\2\2\2\u01b9T\3\2\2\2\u01ba\u01bb\7R\2\2\u01bb\u01bc\7"+
		"t\2\2\u01bc\u01bd\7q\2\2\u01bd\u01be\7r\2\2\u01be\u01bf\7c\2\2\u01bf\u01c0"+
		"\7i\2\2\u01c0\u01c1\7c\2\2\u01c1\u01c2\7v\2\2\u01c2\u01cd\7g\2\2\u01c3"+
		"\u01c4\7r\2\2\u01c4\u01c5\7t\2\2\u01c5\u01c6\7q\2\2\u01c6\u01c7\7r\2\2"+
		"\u01c7\u01c8\7c\2\2\u01c8\u01c9\7i\2\2\u01c9\u01ca\7c\2\2\u01ca\u01cb"+
		"\7v\2\2\u01cb\u01cd\7g\2\2\u01cc\u01ba\3\2\2\2\u01cc\u01c3\3\2\2\2\u01cd"+
		"V\3\2\2\2\u01ce\u01cf\7N\2\2\u01cf\u01d0\7k\2\2\u01d0\u01d1\7v\2\2\u01d1"+
		"\u01d2\7g\2\2\u01d2\u01d3\7t\2\2\u01d3\u01d4\7c\2\2\u01d4\u01dd\7n\2\2"+
		"\u01d5\u01d6\7n\2\2\u01d6\u01d7\7k\2\2\u01d7\u01d8\7v\2\2\u01d8\u01d9"+
		"\7g\2\2\u01d9\u01da\7t\2\2\u01da\u01db\7c\2\2\u01db\u01dd\7n\2\2\u01dc"+
		"\u01ce\3\2\2\2\u01dc\u01d5\3\2\2\2\u01ddX\3\2\2\2\u01de\u01df\7W\2\2\u01df"+
		"\u01e0\7p\2\2\u01e0\u01e1\7e\2\2\u01e1\u01e2\7j\2\2\u01e2\u01e3\7c\2\2"+
		"\u01e3\u01e4\7p\2\2\u01e4\u01e5\7i\2\2\u01e5\u01e6\7g\2\2\u01e6\u01f1"+
		"\7f\2\2\u01e7\u01e8\7w\2\2\u01e8\u01e9\7p\2\2\u01e9\u01ea\7e\2\2\u01ea"+
		"\u01eb\7j\2\2\u01eb\u01ec\7c\2\2\u01ec\u01ed\7p\2\2\u01ed\u01ee\7i\2\2"+
		"\u01ee\u01ef\7g\2\2\u01ef\u01f1\7f\2\2\u01f0\u01de\3\2\2\2\u01f0\u01e7"+
		"\3\2\2\2\u01f1Z\3\2\2\2\u01f2\u01f4\5e\63\2\u01f3\u01f2\3\2\2\2\u01f4"+
		"\u01f5\3\2\2\2\u01f5\u01f3\3\2\2\2\u01f5\u01f6\3\2\2\2\u01f6\\\3\2\2\2"+
		"\u01f7\u01f9\5c\62\2\u01f8\u01f7\3\2\2\2\u01f9\u01fa\3\2\2\2\u01fa\u01f8"+
		"\3\2\2\2\u01fa\u01fb\3\2\2\2\u01fb^\3\2\2\2\u01fc\u01fd\5g\64\2\u01fd"+
		"`\3\2\2\2\u01fe\u0200\5g\64\2\u01ff\u01fe\3\2\2\2\u0200\u0201\3\2\2\2"+
		"\u0201\u01ff\3\2\2\2\u0201\u0202\3\2\2\2\u0202b\3\2\2\2\u0203\u0204\t"+
		"\4\2\2\u0204d\3\2\2\2\u0205\u0206\t\5\2\2\u0206f\3\2\2\2\u0207\u0208\7"+
		"^\2\2\u0208\u020b\13\2\2\2\u0209\u020b\n\6\2\2\u020a\u0207\3\2\2\2\u020a"+
		"\u0209\3\2\2\2\u020bh\3\2\2\2\u020c\u020d\7%\2\2\u020dj\3\2\2\2$\2lry"+
		"|\u0082\u0085\u0089\u008c\u0092\u0097\u009c\u009f\u00a4\u00d3\u00e3\u00f9"+
		"\u010d\u011f\u012f\u0145\u0153\u0178\u0190\u01a4\u01ae\u01b8\u01cc\u01dc"+
		"\u01f0\u01f5\u01fa\u0201\u020a\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}