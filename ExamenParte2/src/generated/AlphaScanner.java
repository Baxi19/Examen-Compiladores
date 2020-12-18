// Generated from C:/Users/Baxi/Desktop/Compi/Examen-Compiladores/ExamenParte2\AlphaScanner.g4 by ANTLR 4.8
package generated;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class AlphaScanner extends Lexer {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		PyCOMA=1, DOSPUNTOS=2, ASIGN=3, PIZQ=4, PDER=5, VIR=6, SUMA=7, RESTA=8, 
		MULT=9, DIV=10, FN=11, IF=12, THEN=13, ELSE=14, WHILE=15, DO=16, LET=17, 
		IN=18, BEGIN=19, END=20, CONST=21, VAR=22, RETURN=23, IDENT=24, LITERAL=25, 
		WS=26;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"PyCOMA", "DOSPUNTOS", "ASIGN", "PIZQ", "PDER", "VIR", "SUMA", "RESTA", 
			"MULT", "DIV", "FN", "IF", "THEN", "ELSE", "WHILE", "DO", "LET", "IN", 
			"BEGIN", "END", "CONST", "VAR", "RETURN", "IDENT", "LITERAL", "LETRA", 
			"DIGITO", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "';'", "':'", "':='", "'('", "')'", "'~'", "'+'", "'-'", "'*'", 
			"'/'", "'fn'", "'if'", "'then'", "'else'", "'while'", "'do'", "'let'", 
			"'in'", "'begin'", "'end'", "'const'", "'var'", "'return'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "PyCOMA", "DOSPUNTOS", "ASIGN", "PIZQ", "PDER", "VIR", "SUMA", 
			"RESTA", "MULT", "DIV", "FN", "IF", "THEN", "ELSE", "WHILE", "DO", "LET", 
			"IN", "BEGIN", "END", "CONST", "VAR", "RETURN", "IDENT", "LITERAL", "WS"
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


	public AlphaScanner(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "AlphaScanner.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\34\u00a5\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\3\2\3\2\3\3\3\3\3\4\3\4"+
		"\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f"+
		"\3\f\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\23\3\23"+
		"\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\3\31\3\31\3\31\7\31\u008f\n\31\f\31\16\31\u0092\13\31\3\32\3\32\7\32"+
		"\u0096\n\32\f\32\16\32\u0099\13\32\3\33\3\33\3\34\3\34\3\35\6\35\u00a0"+
		"\n\35\r\35\16\35\u00a1\3\35\3\35\2\2\36\3\3\5\4\7\5\t\6\13\7\r\b\17\t"+
		"\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27"+
		"-\30/\31\61\32\63\33\65\2\67\29\34\3\2\4\4\2C\\c|\5\2\13\f\17\17\"\"\2"+
		"\u00a6\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2"+
		"\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3"+
		"\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2"+
		"\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2"+
		"/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\29\3\2\2\2\3;\3\2\2\2\5=\3\2\2\2\7"+
		"?\3\2\2\2\tB\3\2\2\2\13D\3\2\2\2\rF\3\2\2\2\17H\3\2\2\2\21J\3\2\2\2\23"+
		"L\3\2\2\2\25N\3\2\2\2\27P\3\2\2\2\31S\3\2\2\2\33V\3\2\2\2\35[\3\2\2\2"+
		"\37`\3\2\2\2!f\3\2\2\2#i\3\2\2\2%m\3\2\2\2\'p\3\2\2\2)v\3\2\2\2+z\3\2"+
		"\2\2-\u0080\3\2\2\2/\u0084\3\2\2\2\61\u008b\3\2\2\2\63\u0093\3\2\2\2\65"+
		"\u009a\3\2\2\2\67\u009c\3\2\2\29\u009f\3\2\2\2;<\7=\2\2<\4\3\2\2\2=>\7"+
		"<\2\2>\6\3\2\2\2?@\7<\2\2@A\7?\2\2A\b\3\2\2\2BC\7*\2\2C\n\3\2\2\2DE\7"+
		"+\2\2E\f\3\2\2\2FG\7\u0080\2\2G\16\3\2\2\2HI\7-\2\2I\20\3\2\2\2JK\7/\2"+
		"\2K\22\3\2\2\2LM\7,\2\2M\24\3\2\2\2NO\7\61\2\2O\26\3\2\2\2PQ\7h\2\2QR"+
		"\7p\2\2R\30\3\2\2\2ST\7k\2\2TU\7h\2\2U\32\3\2\2\2VW\7v\2\2WX\7j\2\2XY"+
		"\7g\2\2YZ\7p\2\2Z\34\3\2\2\2[\\\7g\2\2\\]\7n\2\2]^\7u\2\2^_\7g\2\2_\36"+
		"\3\2\2\2`a\7y\2\2ab\7j\2\2bc\7k\2\2cd\7n\2\2de\7g\2\2e \3\2\2\2fg\7f\2"+
		"\2gh\7q\2\2h\"\3\2\2\2ij\7n\2\2jk\7g\2\2kl\7v\2\2l$\3\2\2\2mn\7k\2\2n"+
		"o\7p\2\2o&\3\2\2\2pq\7d\2\2qr\7g\2\2rs\7i\2\2st\7k\2\2tu\7p\2\2u(\3\2"+
		"\2\2vw\7g\2\2wx\7p\2\2xy\7f\2\2y*\3\2\2\2z{\7e\2\2{|\7q\2\2|}\7p\2\2}"+
		"~\7u\2\2~\177\7v\2\2\177,\3\2\2\2\u0080\u0081\7x\2\2\u0081\u0082\7c\2"+
		"\2\u0082\u0083\7t\2\2\u0083.\3\2\2\2\u0084\u0085\7t\2\2\u0085\u0086\7"+
		"g\2\2\u0086\u0087\7v\2\2\u0087\u0088\7w\2\2\u0088\u0089\7t\2\2\u0089\u008a"+
		"\7p\2\2\u008a\60\3\2\2\2\u008b\u0090\5\65\33\2\u008c\u008f\5\65\33\2\u008d"+
		"\u008f\5\67\34\2\u008e\u008c\3\2\2\2\u008e\u008d\3\2\2\2\u008f\u0092\3"+
		"\2\2\2\u0090\u008e\3\2\2\2\u0090\u0091\3\2\2\2\u0091\62\3\2\2\2\u0092"+
		"\u0090\3\2\2\2\u0093\u0097\5\67\34\2\u0094\u0096\5\67\34\2\u0095\u0094"+
		"\3\2\2\2\u0096\u0099\3\2\2\2\u0097\u0095\3\2\2\2\u0097\u0098\3\2\2\2\u0098"+
		"\64\3\2\2\2\u0099\u0097\3\2\2\2\u009a\u009b\t\2\2\2\u009b\66\3\2\2\2\u009c"+
		"\u009d\4\62;\2\u009d8\3\2\2\2\u009e\u00a0\t\3\2\2\u009f\u009e\3\2\2\2"+
		"\u00a0\u00a1\3\2\2\2\u00a1\u009f\3\2\2\2\u00a1\u00a2\3\2\2\2\u00a2\u00a3"+
		"\3\2\2\2\u00a3\u00a4\b\35\2\2\u00a4:\3\2\2\2\7\2\u008e\u0090\u0097\u00a1"+
		"\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}