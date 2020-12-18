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
		PyCOMA=1, DOSPUNTOS=2, ASIGN=3, PIZQ=4, PDER=5, VIR=6, LE=7, GE=8, EQUAL=9, 
		NOT_EQUAL=10, GT=11, LT=12, AND=13, OR=14, SUMA=15, RESTA=16, MULT=17, 
		DIV=18, FN=19, IF=20, THEN=21, ELSE=22, WHILE=23, DO=24, LET=25, IN=26, 
		BEGIN=27, END=28, CONST=29, VAR=30, RETURN=31, LEN=32, FIRST=33, LAST=34, 
		REST=35, PUSH=36, PUTS=37, BOOLEAN=38, INT=39, STR=40, TRUE=41, FALSE=42, 
		INTEGER=43, STRING=44, IDENT=45, WS=46, SINGLE_COMMENT=47, BLOCK_COMMENT=48;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"PyCOMA", "DOSPUNTOS", "ASIGN", "PIZQ", "PDER", "VIR", "LE", "GE", "EQUAL", 
			"NOT_EQUAL", "GT", "LT", "AND", "OR", "SUMA", "RESTA", "MULT", "DIV", 
			"FN", "IF", "THEN", "ELSE", "WHILE", "DO", "LET", "IN", "BEGIN", "END", 
			"CONST", "VAR", "RETURN", "LEN", "FIRST", "LAST", "REST", "PUSH", "PUTS", 
			"BOOLEAN", "INT", "STR", "TRUE", "FALSE", "INTEGER", "STRING", "IDENT", 
			"WS", "SINGLE_COMMENT", "BLOCK_COMMENT"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "';'", "':'", "':='", "'('", "')'", "'~'", "'<='", "'>='", "'='", 
			"'!='", "'>'", "'<'", "'&'", "'|'", "'+'", "'-'", "'*'", "'/'", "'fn'", 
			"'if'", "'then'", "'else'", "'while'", "'do'", "'let'", "'in'", "'begin'", 
			"'end'", "'const'", "'var'", "'return'", "'len'", "'first'", "'last'", 
			"'rest'", "'push'", "'puts'", "'boolean'", "'int'", "'string'", "'true'", 
			"'false'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "PyCOMA", "DOSPUNTOS", "ASIGN", "PIZQ", "PDER", "VIR", "LE", "GE", 
			"EQUAL", "NOT_EQUAL", "GT", "LT", "AND", "OR", "SUMA", "RESTA", "MULT", 
			"DIV", "FN", "IF", "THEN", "ELSE", "WHILE", "DO", "LET", "IN", "BEGIN", 
			"END", "CONST", "VAR", "RETURN", "LEN", "FIRST", "LAST", "REST", "PUSH", 
			"PUTS", "BOOLEAN", "INT", "STR", "TRUE", "FALSE", "INTEGER", "STRING", 
			"IDENT", "WS", "SINGLE_COMMENT", "BLOCK_COMMENT"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\62\u0140\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\3\2\3\2\3\3\3\3\3\4\3\4"+
		"\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3\13\3\13"+
		"\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22"+
		"\3\23\3\23\3\24\3\24\3\24\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\27"+
		"\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\32"+
		"\3\32\3\32\3\32\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\34\3\35\3\35"+
		"\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3 \3 \3 "+
		"\3 \3 \3 \3 \3!\3!\3!\3!\3\"\3\"\3\"\3\"\3\"\3\"\3#\3#\3#\3#\3#\3$\3$"+
		"\3$\3$\3$\3%\3%\3%\3%\3%\3&\3&\3&\3&\3&\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3"+
		"\'\3(\3(\3(\3(\3)\3)\3)\3)\3)\3)\3)\3*\3*\3*\3*\3*\3+\3+\3+\3+\3+\3+\3"+
		",\3,\7,\u0105\n,\f,\16,\u0108\13,\3-\3-\7-\u010c\n-\f-\16-\u010f\13-\3"+
		"-\3-\3.\3.\7.\u0115\n.\f.\16.\u0118\13.\3/\6/\u011b\n/\r/\16/\u011c\3"+
		"/\3/\3\60\3\60\3\60\3\60\7\60\u0125\n\60\f\60\16\60\u0128\13\60\3\60\5"+
		"\60\u012b\n\60\3\60\3\60\3\60\3\60\3\61\3\61\3\61\3\61\3\61\3\61\7\61"+
		"\u0137\n\61\f\61\16\61\u013a\13\61\3\61\3\61\3\61\3\61\3\61\2\2\62\3\3"+
		"\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21"+
		"!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!"+
		"A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62\3\2\b\3\2\62;\3\2$$\4\2C\\"+
		"c|\6\2\62;C\\aac|\5\2\13\f\17\17\"\"\4\2\f\f\17\17\2\u0148\2\3\3\2\2\2"+
		"\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2"+
		"\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2"+
		"\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2"+
		"\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2"+
		"\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2"+
		"\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2"+
		"\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W"+
		"\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\3c\3\2"+
		"\2\2\5e\3\2\2\2\7g\3\2\2\2\tj\3\2\2\2\13l\3\2\2\2\rn\3\2\2\2\17p\3\2\2"+
		"\2\21s\3\2\2\2\23v\3\2\2\2\25x\3\2\2\2\27{\3\2\2\2\31}\3\2\2\2\33\177"+
		"\3\2\2\2\35\u0081\3\2\2\2\37\u0083\3\2\2\2!\u0085\3\2\2\2#\u0087\3\2\2"+
		"\2%\u0089\3\2\2\2\'\u008b\3\2\2\2)\u008e\3\2\2\2+\u0091\3\2\2\2-\u0096"+
		"\3\2\2\2/\u009b\3\2\2\2\61\u00a1\3\2\2\2\63\u00a4\3\2\2\2\65\u00a8\3\2"+
		"\2\2\67\u00ab\3\2\2\29\u00b1\3\2\2\2;\u00b5\3\2\2\2=\u00bb\3\2\2\2?\u00bf"+
		"\3\2\2\2A\u00c6\3\2\2\2C\u00ca\3\2\2\2E\u00d0\3\2\2\2G\u00d5\3\2\2\2I"+
		"\u00da\3\2\2\2K\u00df\3\2\2\2M\u00e4\3\2\2\2O\u00ec\3\2\2\2Q\u00f0\3\2"+
		"\2\2S\u00f7\3\2\2\2U\u00fc\3\2\2\2W\u0102\3\2\2\2Y\u0109\3\2\2\2[\u0112"+
		"\3\2\2\2]\u011a\3\2\2\2_\u0120\3\2\2\2a\u0130\3\2\2\2cd\7=\2\2d\4\3\2"+
		"\2\2ef\7<\2\2f\6\3\2\2\2gh\7<\2\2hi\7?\2\2i\b\3\2\2\2jk\7*\2\2k\n\3\2"+
		"\2\2lm\7+\2\2m\f\3\2\2\2no\7\u0080\2\2o\16\3\2\2\2pq\7>\2\2qr\7?\2\2r"+
		"\20\3\2\2\2st\7@\2\2tu\7?\2\2u\22\3\2\2\2vw\7?\2\2w\24\3\2\2\2xy\7#\2"+
		"\2yz\7?\2\2z\26\3\2\2\2{|\7@\2\2|\30\3\2\2\2}~\7>\2\2~\32\3\2\2\2\177"+
		"\u0080\7(\2\2\u0080\34\3\2\2\2\u0081\u0082\7~\2\2\u0082\36\3\2\2\2\u0083"+
		"\u0084\7-\2\2\u0084 \3\2\2\2\u0085\u0086\7/\2\2\u0086\"\3\2\2\2\u0087"+
		"\u0088\7,\2\2\u0088$\3\2\2\2\u0089\u008a\7\61\2\2\u008a&\3\2\2\2\u008b"+
		"\u008c\7h\2\2\u008c\u008d\7p\2\2\u008d(\3\2\2\2\u008e\u008f\7k\2\2\u008f"+
		"\u0090\7h\2\2\u0090*\3\2\2\2\u0091\u0092\7v\2\2\u0092\u0093\7j\2\2\u0093"+
		"\u0094\7g\2\2\u0094\u0095\7p\2\2\u0095,\3\2\2\2\u0096\u0097\7g\2\2\u0097"+
		"\u0098\7n\2\2\u0098\u0099\7u\2\2\u0099\u009a\7g\2\2\u009a.\3\2\2\2\u009b"+
		"\u009c\7y\2\2\u009c\u009d\7j\2\2\u009d\u009e\7k\2\2\u009e\u009f\7n\2\2"+
		"\u009f\u00a0\7g\2\2\u00a0\60\3\2\2\2\u00a1\u00a2\7f\2\2\u00a2\u00a3\7"+
		"q\2\2\u00a3\62\3\2\2\2\u00a4\u00a5\7n\2\2\u00a5\u00a6\7g\2\2\u00a6\u00a7"+
		"\7v\2\2\u00a7\64\3\2\2\2\u00a8\u00a9\7k\2\2\u00a9\u00aa\7p\2\2\u00aa\66"+
		"\3\2\2\2\u00ab\u00ac\7d\2\2\u00ac\u00ad\7g\2\2\u00ad\u00ae\7i\2\2\u00ae"+
		"\u00af\7k\2\2\u00af\u00b0\7p\2\2\u00b08\3\2\2\2\u00b1\u00b2\7g\2\2\u00b2"+
		"\u00b3\7p\2\2\u00b3\u00b4\7f\2\2\u00b4:\3\2\2\2\u00b5\u00b6\7e\2\2\u00b6"+
		"\u00b7\7q\2\2\u00b7\u00b8\7p\2\2\u00b8\u00b9\7u\2\2\u00b9\u00ba\7v\2\2"+
		"\u00ba<\3\2\2\2\u00bb\u00bc\7x\2\2\u00bc\u00bd\7c\2\2\u00bd\u00be\7t\2"+
		"\2\u00be>\3\2\2\2\u00bf\u00c0\7t\2\2\u00c0\u00c1\7g\2\2\u00c1\u00c2\7"+
		"v\2\2\u00c2\u00c3\7w\2\2\u00c3\u00c4\7t\2\2\u00c4\u00c5\7p\2\2\u00c5@"+
		"\3\2\2\2\u00c6\u00c7\7n\2\2\u00c7\u00c8\7g\2\2\u00c8\u00c9\7p\2\2\u00c9"+
		"B\3\2\2\2\u00ca\u00cb\7h\2\2\u00cb\u00cc\7k\2\2\u00cc\u00cd\7t\2\2\u00cd"+
		"\u00ce\7u\2\2\u00ce\u00cf\7v\2\2\u00cfD\3\2\2\2\u00d0\u00d1\7n\2\2\u00d1"+
		"\u00d2\7c\2\2\u00d2\u00d3\7u\2\2\u00d3\u00d4\7v\2\2\u00d4F\3\2\2\2\u00d5"+
		"\u00d6\7t\2\2\u00d6\u00d7\7g\2\2\u00d7\u00d8\7u\2\2\u00d8\u00d9\7v\2\2"+
		"\u00d9H\3\2\2\2\u00da\u00db\7r\2\2\u00db\u00dc\7w\2\2\u00dc\u00dd\7u\2"+
		"\2\u00dd\u00de\7j\2\2\u00deJ\3\2\2\2\u00df\u00e0\7r\2\2\u00e0\u00e1\7"+
		"w\2\2\u00e1\u00e2\7v\2\2\u00e2\u00e3\7u\2\2\u00e3L\3\2\2\2\u00e4\u00e5"+
		"\7d\2\2\u00e5\u00e6\7q\2\2\u00e6\u00e7\7q\2\2\u00e7\u00e8\7n\2\2\u00e8"+
		"\u00e9\7g\2\2\u00e9\u00ea\7c\2\2\u00ea\u00eb\7p\2\2\u00ebN\3\2\2\2\u00ec"+
		"\u00ed\7k\2\2\u00ed\u00ee\7p\2\2\u00ee\u00ef\7v\2\2\u00efP\3\2\2\2\u00f0"+
		"\u00f1\7u\2\2\u00f1\u00f2\7v\2\2\u00f2\u00f3\7t\2\2\u00f3\u00f4\7k\2\2"+
		"\u00f4\u00f5\7p\2\2\u00f5\u00f6\7i\2\2\u00f6R\3\2\2\2\u00f7\u00f8\7v\2"+
		"\2\u00f8\u00f9\7t\2\2\u00f9\u00fa\7w\2\2\u00fa\u00fb\7g\2\2\u00fbT\3\2"+
		"\2\2\u00fc\u00fd\7h\2\2\u00fd\u00fe\7c\2\2\u00fe\u00ff\7n\2\2\u00ff\u0100"+
		"\7u\2\2\u0100\u0101\7g\2\2\u0101V\3\2\2\2\u0102\u0106\t\2\2\2\u0103\u0105"+
		"\t\2\2\2\u0104\u0103\3\2\2\2\u0105\u0108\3\2\2\2\u0106\u0104\3\2\2\2\u0106"+
		"\u0107\3\2\2\2\u0107X\3\2\2\2\u0108\u0106\3\2\2\2\u0109\u010d\7$\2\2\u010a"+
		"\u010c\n\3\2\2\u010b\u010a\3\2\2\2\u010c\u010f\3\2\2\2\u010d\u010b\3\2"+
		"\2\2\u010d\u010e\3\2\2\2\u010e\u0110\3\2\2\2\u010f\u010d\3\2\2\2\u0110"+
		"\u0111\7$\2\2\u0111Z\3\2\2\2\u0112\u0116\t\4\2\2\u0113\u0115\t\5\2\2\u0114"+
		"\u0113\3\2\2\2\u0115\u0118\3\2\2\2\u0116\u0114\3\2\2\2\u0116\u0117\3\2"+
		"\2\2\u0117\\\3\2\2\2\u0118\u0116\3\2\2\2\u0119\u011b\t\6\2\2\u011a\u0119"+
		"\3\2\2\2\u011b\u011c\3\2\2\2\u011c\u011a\3\2\2\2\u011c\u011d\3\2\2\2\u011d"+
		"\u011e\3\2\2\2\u011e\u011f\b/\2\2\u011f^\3\2\2\2\u0120\u0121\7\61\2\2"+
		"\u0121\u0122\7\61\2\2\u0122\u0126\3\2\2\2\u0123\u0125\n\7\2\2\u0124\u0123"+
		"\3\2\2\2\u0125\u0128\3\2\2\2\u0126\u0124\3\2\2\2\u0126\u0127\3\2\2\2\u0127"+
		"\u012a\3\2\2\2\u0128\u0126\3\2\2\2\u0129\u012b\7\17\2\2\u012a\u0129\3"+
		"\2\2\2\u012a\u012b\3\2\2\2\u012b\u012c\3\2\2\2\u012c\u012d\7\f\2\2\u012d"+
		"\u012e\3\2\2\2\u012e\u012f\b\60\2\2\u012f`\3\2\2\2\u0130\u0131\7\61\2"+
		"\2\u0131\u0132\7,\2\2\u0132\u0138\3\2\2\2\u0133\u0137\13\2\2\2\u0134\u0137"+
		"\5a\61\2\u0135\u0137\5_\60\2\u0136\u0133\3\2\2\2\u0136\u0134\3\2\2\2\u0136"+
		"\u0135\3\2\2\2\u0137\u013a\3\2\2\2\u0138\u0136\3\2\2\2\u0138\u0139\3\2"+
		"\2\2\u0139\u013b\3\2\2\2\u013a\u0138\3\2\2\2\u013b\u013c\7,\2\2\u013c"+
		"\u013d\7\61\2\2\u013d\u013e\3\2\2\2\u013e\u013f\b\61\2\2\u013fb\3\2\2"+
		"\2\f\2\u0106\u010d\u0114\u0116\u011c\u0126\u012a\u0136\u0138\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}