// Generated from Lgn.g4 by ANTLR 4.7.2
package com.meamoria.lexurgy.gen;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class LgnLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		SEP=1, WHITESPACE=2, NEWLINE=3, LISTSTART=4, LISTEND=5, OPTIONAL=6, CLASSREF=7, 
		BLOCKSTART=8, CLASSDECL=9, PATTERNDECL=10, NAME=11, STR=12;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"SEP", "WHITESPACE", "NEWLINE", "LISTSTART", "LISTEND", "OPTIONAL", "CLASSREF", 
			"BLOCKSTART", "CLASSDECL", "PATTERNDECL", "NAME", "STR", "LOWER", "CHAR", 
			"ANY"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, "'{'", "'}'", "'?'", "'@'", "':'", "'Class'", 
			"'Pattern'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "SEP", "WHITESPACE", "NEWLINE", "LISTSTART", "LISTEND", "OPTIONAL", 
			"CLASSREF", "BLOCKSTART", "CLASSDECL", "PATTERNDECL", "NAME", "STR"
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


	public LgnLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Lgn.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\16_\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\3\2\3\2\5\2$\n\2\3\3"+
		"\6\3\'\n\3\r\3\16\3(\3\4\5\4,\n\4\3\4\3\4\3\4\5\4\61\n\4\3\4\5\4\64\n"+
		"\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\7\fP\n\f\f\f\16\fS\13\f\3"+
		"\r\6\rV\n\r\r\r\16\rW\3\16\3\16\3\17\3\17\3\20\3\20\2\2\21\3\3\5\4\7\5"+
		"\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\2\35\2\37\2\3\2\5\3\2"+
		"c|\5\2\62;C\\c|\17\2\f\f\17\17\"#%&*/\61\61<<?B]]__aa}}\177\177\2b\2\3"+
		"\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2"+
		"\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31"+
		"\3\2\2\2\3!\3\2\2\2\5&\3\2\2\2\7+\3\2\2\2\t\65\3\2\2\2\13\67\3\2\2\2\r"+
		"9\3\2\2\2\17;\3\2\2\2\21=\3\2\2\2\23?\3\2\2\2\25E\3\2\2\2\27M\3\2\2\2"+
		"\31U\3\2\2\2\33Y\3\2\2\2\35[\3\2\2\2\37]\3\2\2\2!#\7.\2\2\"$\5\5\3\2#"+
		"\"\3\2\2\2#$\3\2\2\2$\4\3\2\2\2%\'\7\"\2\2&%\3\2\2\2\'(\3\2\2\2(&\3\2"+
		"\2\2()\3\2\2\2)\6\3\2\2\2*,\5\5\3\2+*\3\2\2\2+,\3\2\2\2,\60\3\2\2\2-."+
		"\7\17\2\2.\61\7\f\2\2/\61\7\f\2\2\60-\3\2\2\2\60/\3\2\2\2\61\63\3\2\2"+
		"\2\62\64\5\5\3\2\63\62\3\2\2\2\63\64\3\2\2\2\64\b\3\2\2\2\65\66\7}\2\2"+
		"\66\n\3\2\2\2\678\7\177\2\28\f\3\2\2\29:\7A\2\2:\16\3\2\2\2;<\7B\2\2<"+
		"\20\3\2\2\2=>\7<\2\2>\22\3\2\2\2?@\7E\2\2@A\7n\2\2AB\7c\2\2BC\7u\2\2C"+
		"D\7u\2\2D\24\3\2\2\2EF\7R\2\2FG\7c\2\2GH\7v\2\2HI\7v\2\2IJ\7g\2\2JK\7"+
		"t\2\2KL\7p\2\2L\26\3\2\2\2MQ\5\33\16\2NP\5\35\17\2ON\3\2\2\2PS\3\2\2\2"+
		"QO\3\2\2\2QR\3\2\2\2R\30\3\2\2\2SQ\3\2\2\2TV\5\37\20\2UT\3\2\2\2VW\3\2"+
		"\2\2WU\3\2\2\2WX\3\2\2\2X\32\3\2\2\2YZ\t\2\2\2Z\34\3\2\2\2[\\\t\3\2\2"+
		"\\\36\3\2\2\2]^\n\4\2\2^ \3\2\2\2\n\2#(+\60\63QW\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}