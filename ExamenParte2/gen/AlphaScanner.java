// Generated from C:/Users/Baxi/Desktop/Compi/Examen-Compiladores/ExamenParte2\AlphaScanner.g4 by ANTLR 4.8
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
		PyCOMA=1, ASSIGN=2, PIZQ=3, PDER=4, VIR=5, DOSPUN=6, SUM=7, SUB=8, MUL=9, 
		DIV=10, IF=11, WHILE=12, LET=13, THEN=14, ELSE=15, IN=16, DO=17, BEGIN=18, 
		END=19, CONST=20, VAR=21, VOID=22, RETURN=23, NUM=24, CHAR=25, IDENT=26, 
		WS=27, LINECOMENT=28, MULTILINECOMENT=29;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"PyCOMA", "ASSIGN", "PIZQ", "PDER", "VIR", "DOSPUN", "SUM", "SUB", "MUL", 
			"DIV", "IF", "WHILE", "LET", "THEN", "ELSE", "IN", "DO", "BEGIN", "END", 
			"CONST", "VAR", "VOID", "RETURN", "NUM", "CHAR", "IDENT", "WS", "LINECOMENT", 
			"MULTILINECOMENT"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "';'", "':='", "'('", "')'", "'~'", "':'", "'+'", "'-'", "'*'", 
			"'/'", "'if'", "'while'", "'let'", "'then'", "'else'", "'in'", "'do'", 
			"'begin'", "'end'", "'const'", "'var'", "'void'", "'return'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "PyCOMA", "ASSIGN", "PIZQ", "PDER", "VIR", "DOSPUN", "SUM", "SUB", 
			"MUL", "DIV", "IF", "WHILE", "LET", "THEN", "ELSE", "IN", "DO", "BEGIN", 
			"END", "CONST", "VAR", "VOID", "RETURN", "NUM", "CHAR", "IDENT", "WS", 
			"LINECOMENT", "MULTILINECOMENT"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\37\u00c6\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\3\2\3\2\3\3\3"+
		"\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3"+
		"\13\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\17\3\17"+
		"\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3\22"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30"+
		"\3\30\3\30\3\30\3\30\3\31\3\31\7\31\u0092\n\31\f\31\16\31\u0095\13\31"+
		"\3\31\5\31\u0098\n\31\3\32\3\32\5\32\u009c\n\32\3\32\3\32\3\33\3\33\7"+
		"\33\u00a2\n\33\f\33\16\33\u00a5\13\33\3\34\6\34\u00a8\n\34\r\34\16\34"+
		"\u00a9\3\34\3\34\3\35\3\35\3\35\3\35\7\35\u00b2\n\35\f\35\16\35\u00b5"+
		"\13\35\3\35\3\35\3\36\3\36\3\36\3\36\7\36\u00bd\n\36\f\36\16\36\u00c0"+
		"\13\36\3\36\3\36\3\36\3\36\3\36\3\u00be\2\37\3\3\5\4\7\5\t\6\13\7\r\b"+
		"\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26"+
		"+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37\3\2\t\3\2\63;\3\2\62;\5\2"+
		"\"#\62;c|\3\2c|\4\2\62;c|\5\2\13\f\17\17\"\"\4\2\f\f\17\17\2\u00cc\2\3"+
		"\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2"+
		"\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31"+
		"\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2"+
		"\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2"+
		"\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2"+
		"\2\3=\3\2\2\2\5?\3\2\2\2\7B\3\2\2\2\tD\3\2\2\2\13F\3\2\2\2\rH\3\2\2\2"+
		"\17J\3\2\2\2\21L\3\2\2\2\23N\3\2\2\2\25P\3\2\2\2\27R\3\2\2\2\31U\3\2\2"+
		"\2\33[\3\2\2\2\35_\3\2\2\2\37d\3\2\2\2!i\3\2\2\2#l\3\2\2\2%o\3\2\2\2\'"+
		"u\3\2\2\2)y\3\2\2\2+\177\3\2\2\2-\u0083\3\2\2\2/\u0088\3\2\2\2\61\u0097"+
		"\3\2\2\2\63\u0099\3\2\2\2\65\u009f\3\2\2\2\67\u00a7\3\2\2\29\u00ad\3\2"+
		"\2\2;\u00b8\3\2\2\2=>\7=\2\2>\4\3\2\2\2?@\7<\2\2@A\7?\2\2A\6\3\2\2\2B"+
		"C\7*\2\2C\b\3\2\2\2DE\7+\2\2E\n\3\2\2\2FG\7\u0080\2\2G\f\3\2\2\2HI\7<"+
		"\2\2I\16\3\2\2\2JK\7-\2\2K\20\3\2\2\2LM\7/\2\2M\22\3\2\2\2NO\7,\2\2O\24"+
		"\3\2\2\2PQ\7\61\2\2Q\26\3\2\2\2RS\7k\2\2ST\7h\2\2T\30\3\2\2\2UV\7y\2\2"+
		"VW\7j\2\2WX\7k\2\2XY\7n\2\2YZ\7g\2\2Z\32\3\2\2\2[\\\7n\2\2\\]\7g\2\2]"+
		"^\7v\2\2^\34\3\2\2\2_`\7v\2\2`a\7j\2\2ab\7g\2\2bc\7p\2\2c\36\3\2\2\2d"+
		"e\7g\2\2ef\7n\2\2fg\7u\2\2gh\7g\2\2h \3\2\2\2ij\7k\2\2jk\7p\2\2k\"\3\2"+
		"\2\2lm\7f\2\2mn\7q\2\2n$\3\2\2\2op\7d\2\2pq\7g\2\2qr\7i\2\2rs\7k\2\2s"+
		"t\7p\2\2t&\3\2\2\2uv\7g\2\2vw\7p\2\2wx\7f\2\2x(\3\2\2\2yz\7e\2\2z{\7q"+
		"\2\2{|\7p\2\2|}\7u\2\2}~\7v\2\2~*\3\2\2\2\177\u0080\7x\2\2\u0080\u0081"+
		"\7c\2\2\u0081\u0082\7t\2\2\u0082,\3\2\2\2\u0083\u0084\7x\2\2\u0084\u0085"+
		"\7q\2\2\u0085\u0086\7k\2\2\u0086\u0087\7f\2\2\u0087.\3\2\2\2\u0088\u0089"+
		"\7t\2\2\u0089\u008a\7g\2\2\u008a\u008b\7v\2\2\u008b\u008c\7w\2\2\u008c"+
		"\u008d\7t\2\2\u008d\u008e\7p\2\2\u008e\60\3\2\2\2\u008f\u0093\t\2\2\2"+
		"\u0090\u0092\t\3\2\2\u0091\u0090\3\2\2\2\u0092\u0095\3\2\2\2\u0093\u0091"+
		"\3\2\2\2\u0093\u0094\3\2\2\2\u0094\u0098\3\2\2\2\u0095\u0093\3\2\2\2\u0096"+
		"\u0098\7\62\2\2\u0097\u008f\3\2\2\2\u0097\u0096\3\2\2\2\u0098\62\3\2\2"+
		"\2\u0099\u009b\7)\2\2\u009a\u009c\t\4\2\2\u009b\u009a\3\2\2\2\u009b\u009c"+
		"\3\2\2\2\u009c\u009d\3\2\2\2\u009d\u009e\7)\2\2\u009e\64\3\2\2\2\u009f"+
		"\u00a3\t\5\2\2\u00a0\u00a2\t\6\2\2\u00a1\u00a0\3\2\2\2\u00a2\u00a5\3\2"+
		"\2\2\u00a3\u00a1\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4\66\3\2\2\2\u00a5\u00a3"+
		"\3\2\2\2\u00a6\u00a8\t\7\2\2\u00a7\u00a6\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9"+
		"\u00a7\3\2\2\2\u00a9\u00aa\3\2\2\2\u00aa\u00ab\3\2\2\2\u00ab\u00ac\b\34"+
		"\2\2\u00ac8\3\2\2\2\u00ad\u00ae\7\61\2\2\u00ae\u00af\7\61\2\2\u00af\u00b3"+
		"\3\2\2\2\u00b0\u00b2\n\b\2\2\u00b1\u00b0\3\2\2\2\u00b2\u00b5\3\2\2\2\u00b3"+
		"\u00b1\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4\u00b6\3\2\2\2\u00b5\u00b3\3\2"+
		"\2\2\u00b6\u00b7\b\35\2\2\u00b7:\3\2\2\2\u00b8\u00b9\7\61\2\2\u00b9\u00ba"+
		"\7,\2\2\u00ba\u00be\3\2\2\2\u00bb\u00bd\13\2\2\2\u00bc\u00bb\3\2\2\2\u00bd"+
		"\u00c0\3\2\2\2\u00be\u00bf\3\2\2\2\u00be\u00bc\3\2\2\2\u00bf\u00c1\3\2"+
		"\2\2\u00c0\u00be\3\2\2\2\u00c1\u00c2\7,\2\2\u00c2\u00c3\7\61\2\2\u00c3"+
		"\u00c4\3\2\2\2\u00c4\u00c5\b\36\2\2\u00c5<\3\2\2\2\13\2\u0093\u0097\u009b"+
		"\u00a1\u00a3\u00a9\u00b3\u00be\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}