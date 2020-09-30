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
		SEP=1, WHITESPACE=2, LISTSTART=3, LISTEND=4, OPTIONAL=5, CLASSREF=6, CLASSDECL=7, 
		NAME=8, STR=9;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"SEP", "WHITESPACE", "LISTSTART", "LISTEND", "OPTIONAL", "CLASSREF", 
			"CLASSDECL", "NAME", "STR", "LOWER", "CHAR", "ANY"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, "'{'", "'}'", "'?'", "'@'", "'Class'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "SEP", "WHITESPACE", "LISTSTART", "LISTEND", "OPTIONAL", "CLASSREF", 
			"CLASSDECL", "NAME", "STR"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\13D\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\3\2\3\2\5\2\36\n\2\3\3\6\3!\n\3\r\3\16\3\"\3\4\3\4"+
		"\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\7\t\65\n\t\f"+
		"\t\16\t8\13\t\3\n\6\n;\n\n\r\n\16\n<\3\13\3\13\3\f\3\f\3\r\3\r\2\2\16"+
		"\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\2\27\2\31\2\3\2\5\3\2c|\5"+
		"\2\62;C\\c|\17\2\f\f\17\17\"#%&*/\61\61<<?B]]__aa}}\177\177\2D\2\3\3\2"+
		"\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17"+
		"\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\3\33\3\2\2\2\5 \3\2\2\2\7$\3\2\2\2"+
		"\t&\3\2\2\2\13(\3\2\2\2\r*\3\2\2\2\17,\3\2\2\2\21\62\3\2\2\2\23:\3\2\2"+
		"\2\25>\3\2\2\2\27@\3\2\2\2\31B\3\2\2\2\33\35\7.\2\2\34\36\5\5\3\2\35\34"+
		"\3\2\2\2\35\36\3\2\2\2\36\4\3\2\2\2\37!\7\"\2\2 \37\3\2\2\2!\"\3\2\2\2"+
		"\" \3\2\2\2\"#\3\2\2\2#\6\3\2\2\2$%\7}\2\2%\b\3\2\2\2&\'\7\177\2\2\'\n"+
		"\3\2\2\2()\7A\2\2)\f\3\2\2\2*+\7B\2\2+\16\3\2\2\2,-\7E\2\2-.\7n\2\2./"+
		"\7c\2\2/\60\7u\2\2\60\61\7u\2\2\61\20\3\2\2\2\62\66\5\25\13\2\63\65\5"+
		"\27\f\2\64\63\3\2\2\2\658\3\2\2\2\66\64\3\2\2\2\66\67\3\2\2\2\67\22\3"+
		"\2\2\28\66\3\2\2\29;\5\31\r\2:9\3\2\2\2;<\3\2\2\2<:\3\2\2\2<=\3\2\2\2"+
		"=\24\3\2\2\2>?\t\2\2\2?\26\3\2\2\2@A\t\3\2\2A\30\3\2\2\2BC\n\4\2\2C\32"+
		"\3\2\2\2\7\2\35\"\66<\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}