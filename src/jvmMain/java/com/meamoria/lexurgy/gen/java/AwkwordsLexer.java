// Generated from Awkwords.g4 by ANTLR 4.7.2
package com.meamoria.lexurgy.gen.java;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class AwkwordsLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		COMMENT=1, ATOM=2, SUBREF=3, ALTSEP=4, OPSTART=5, OPEND=6, GROUPSTART=7, 
		GROUPEND=8, WEIGHT=9, FILTERSEP=10, ESCAPE=11, SUBPATSTART=12, TEMPLATESTART=13, 
		NUMWORDSSTART=14, DIGIT=15, NEWLINE=16;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"COMMENT", "ATOM", "SUBREF", "ALTSEP", "OPSTART", "OPEND", "GROUPSTART", 
			"GROUPEND", "WEIGHT", "FILTERSEP", "ESCAPE", "SUBPATSTART", "TEMPLATESTART", 
			"NUMWORDSSTART", "DIGIT", "NEWLINE", "COMMENTSTART"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, "'/'", "'('", "')'", "'['", "']'", "'*'", "'^'", 
			"'\"'", "':'", "'r:'", "'n:'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "COMMENT", "ATOM", "SUBREF", "ALTSEP", "OPSTART", "OPEND", "GROUPSTART", 
			"GROUPEND", "WEIGHT", "FILTERSEP", "ESCAPE", "SUBPATSTART", "TEMPLATESTART", 
			"NUMWORDSSTART", "DIGIT", "NEWLINE"
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


	public AwkwordsLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Awkwords.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\22S\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\3\2\3\2\7\2(\n\2\f\2\16\2+\13\2\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3"+
		"\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16"+
		"\3\16\3\17\3\17\3\17\3\20\3\20\3\21\3\21\3\21\5\21P\n\21\3\22\3\22\2\2"+
		"\23\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35"+
		"\20\37\21!\22#\2\3\2\6\4\2\f\f\17\17\t\2\f\f\17\17$$*,\61<C]_`\3\2C\\"+
		"\3\2\62;\2S\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2"+
		"\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27"+
		"\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2"+
		"\2\3%\3\2\2\2\5.\3\2\2\2\7\60\3\2\2\2\t\62\3\2\2\2\13\64\3\2\2\2\r\66"+
		"\3\2\2\2\178\3\2\2\2\21:\3\2\2\2\23<\3\2\2\2\25>\3\2\2\2\27@\3\2\2\2\31"+
		"B\3\2\2\2\33D\3\2\2\2\35G\3\2\2\2\37J\3\2\2\2!O\3\2\2\2#Q\3\2\2\2%)\5"+
		"#\22\2&(\n\2\2\2\'&\3\2\2\2(+\3\2\2\2)\'\3\2\2\2)*\3\2\2\2*,\3\2\2\2+"+
		")\3\2\2\2,-\b\2\2\2-\4\3\2\2\2./\n\3\2\2/\6\3\2\2\2\60\61\t\4\2\2\61\b"+
		"\3\2\2\2\62\63\7\61\2\2\63\n\3\2\2\2\64\65\7*\2\2\65\f\3\2\2\2\66\67\7"+
		"+\2\2\67\16\3\2\2\289\7]\2\29\20\3\2\2\2:;\7_\2\2;\22\3\2\2\2<=\7,\2\2"+
		"=\24\3\2\2\2>?\7`\2\2?\26\3\2\2\2@A\7$\2\2A\30\3\2\2\2BC\7<\2\2C\32\3"+
		"\2\2\2DE\7t\2\2EF\7<\2\2F\34\3\2\2\2GH\7p\2\2HI\7<\2\2I\36\3\2\2\2JK\t"+
		"\5\2\2K \3\2\2\2LM\7\17\2\2MP\7\f\2\2NP\7\f\2\2OL\3\2\2\2ON\3\2\2\2P\""+
		"\3\2\2\2QR\7%\2\2R$\3\2\2\2\5\2)O\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}