// Generated from C:/Users/Baxi/Desktop/Compi/Examen-Compiladores/ExamenParte2\AlphaParser.g4 by ANTLR 4.8
package generated;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class AlphaParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		PyCOMA=1, DOSPUNTOS=2, ASIGN=3, PIZQ=4, PDER=5, VIR=6, LE=7, GE=8, EQUAL=9, 
		NOT_EQUAL=10, GT=11, LT=12, AND=13, OR=14, SUMA=15, RESTA=16, MULT=17, 
		DIV=18, FN=19, IF=20, THEN=21, ELSE=22, WHILE=23, DO=24, LET=25, IN=26, 
		BEGIN=27, END=28, CONST=29, VAR=30, RETURN=31, TRUE=32, FALSE=33, INTEGER=34, 
		STRING=35, IDENT=36, WS=37, SINGLE_COMMENT=38, BLOCK_COMMENT=39;
	public static final int
		RULE_program = 0, RULE_command = 1, RULE_singleCommand = 2, RULE_declaration = 3, 
		RULE_singleDeclaration = 4, RULE_methodDeclaration = 5, RULE_formalParamList = 6, 
		RULE_typeDenoter = 7, RULE_expression = 8, RULE_primaryExpression = 9, 
		RULE_actualParamList = 10, RULE_operator = 11, RULE_comparation = 12, 
		RULE_ident = 13;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "command", "singleCommand", "declaration", "singleDeclaration", 
			"methodDeclaration", "formalParamList", "typeDenoter", "expression", 
			"primaryExpression", "actualParamList", "operator", "comparation", "ident"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "';'", "':'", "':='", "'('", "')'", "'~'", "'<='", "'>='", "'='", 
			"'!='", "'>'", "'<'", "'&'", "'|'", "'+'", "'-'", "'*'", "'/'", "'fn'", 
			"'if'", "'then'", "'else'", "'while'", "'do'", "'let'", "'in'", "'begin'", 
			"'end'", "'const'", "'var'", "'return'", "'true'", "'false'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "PyCOMA", "DOSPUNTOS", "ASIGN", "PIZQ", "PDER", "VIR", "LE", "GE", 
			"EQUAL", "NOT_EQUAL", "GT", "LT", "AND", "OR", "SUMA", "RESTA", "MULT", 
			"DIV", "FN", "IF", "THEN", "ELSE", "WHILE", "DO", "LET", "IN", "BEGIN", 
			"END", "CONST", "VAR", "RETURN", "TRUE", "FALSE", "INTEGER", "STRING", 
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

	@Override
	public String getGrammarFileName() { return "AlphaParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public AlphaParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramContext extends ParserRuleContext {
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
	 
		public ProgramContext() { }
		public void copyFrom(ProgramContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ProgramASTContext extends ProgramContext {
		public SingleCommandContext singleCommand() {
			return getRuleContext(SingleCommandContext.class,0);
		}
		public ProgramASTContext(ProgramContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlphaParserVisitor ) return ((AlphaParserVisitor<? extends T>)visitor).visitProgramAST(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		try {
			_localctx = new ProgramASTContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(28);
			singleCommand();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CommandContext extends ParserRuleContext {
		public CommandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_command; }
	 
		public CommandContext() { }
		public void copyFrom(CommandContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class CommandASTContext extends CommandContext {
		public List<SingleCommandContext> singleCommand() {
			return getRuleContexts(SingleCommandContext.class);
		}
		public SingleCommandContext singleCommand(int i) {
			return getRuleContext(SingleCommandContext.class,i);
		}
		public List<TerminalNode> PyCOMA() { return getTokens(AlphaParser.PyCOMA); }
		public TerminalNode PyCOMA(int i) {
			return getToken(AlphaParser.PyCOMA, i);
		}
		public CommandASTContext(CommandContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlphaParserVisitor ) return ((AlphaParserVisitor<? extends T>)visitor).visitCommandAST(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CommandContext command() throws RecognitionException {
		CommandContext _localctx = new CommandContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_command);
		int _la;
		try {
			_localctx = new CommandASTContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(30);
			singleCommand();
			setState(35);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PyCOMA) {
				{
				{
				setState(31);
				match(PyCOMA);
				setState(32);
				singleCommand();
				}
				}
				setState(37);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SingleCommandContext extends ParserRuleContext {
		public SingleCommandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_singleCommand; }
	 
		public SingleCommandContext() { }
		public void copyFrom(SingleCommandContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class IfSingleCommandASTContext extends SingleCommandContext {
		public TerminalNode IF() { return getToken(AlphaParser.IF, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode THEN() { return getToken(AlphaParser.THEN, 0); }
		public List<SingleCommandContext> singleCommand() {
			return getRuleContexts(SingleCommandContext.class);
		}
		public SingleCommandContext singleCommand(int i) {
			return getRuleContext(SingleCommandContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(AlphaParser.ELSE, 0); }
		public IfSingleCommandASTContext(SingleCommandContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlphaParserVisitor ) return ((AlphaParserVisitor<? extends T>)visitor).visitIfSingleCommandAST(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AssignSingleCommandASTContext extends SingleCommandContext {
		public IdentContext ident() {
			return getRuleContext(IdentContext.class,0);
		}
		public TerminalNode ASIGN() { return getToken(AlphaParser.ASIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public AssignSingleCommandASTContext(SingleCommandContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlphaParserVisitor ) return ((AlphaParserVisitor<? extends T>)visitor).visitAssignSingleCommandAST(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class WhileSingleCommandASTContext extends SingleCommandContext {
		public TerminalNode WHILE() { return getToken(AlphaParser.WHILE, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode DO() { return getToken(AlphaParser.DO, 0); }
		public SingleCommandContext singleCommand() {
			return getRuleContext(SingleCommandContext.class,0);
		}
		public WhileSingleCommandASTContext(SingleCommandContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlphaParserVisitor ) return ((AlphaParserVisitor<? extends T>)visitor).visitWhileSingleCommandAST(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ReturnSingleCommandASTContext extends SingleCommandContext {
		public TerminalNode RETURN() { return getToken(AlphaParser.RETURN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ReturnSingleCommandASTContext(SingleCommandContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlphaParserVisitor ) return ((AlphaParserVisitor<? extends T>)visitor).visitReturnSingleCommandAST(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LetSingleCommandASTContext extends SingleCommandContext {
		public TerminalNode LET() { return getToken(AlphaParser.LET, 0); }
		public DeclarationContext declaration() {
			return getRuleContext(DeclarationContext.class,0);
		}
		public TerminalNode IN() { return getToken(AlphaParser.IN, 0); }
		public SingleCommandContext singleCommand() {
			return getRuleContext(SingleCommandContext.class,0);
		}
		public LetSingleCommandASTContext(SingleCommandContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlphaParserVisitor ) return ((AlphaParserVisitor<? extends T>)visitor).visitLetSingleCommandAST(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BlockSingleCommandASTContext extends SingleCommandContext {
		public TerminalNode BEGIN() { return getToken(AlphaParser.BEGIN, 0); }
		public CommandContext command() {
			return getRuleContext(CommandContext.class,0);
		}
		public TerminalNode END() { return getToken(AlphaParser.END, 0); }
		public BlockSingleCommandASTContext(SingleCommandContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlphaParserVisitor ) return ((AlphaParserVisitor<? extends T>)visitor).visitBlockSingleCommandAST(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CallSingleCommandASTContext extends SingleCommandContext {
		public IdentContext ident() {
			return getRuleContext(IdentContext.class,0);
		}
		public TerminalNode PIZQ() { return getToken(AlphaParser.PIZQ, 0); }
		public TerminalNode PDER() { return getToken(AlphaParser.PDER, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public CallSingleCommandASTContext(SingleCommandContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlphaParserVisitor ) return ((AlphaParserVisitor<? extends T>)visitor).visitCallSingleCommandAST(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SingleCommandContext singleCommand() throws RecognitionException {
		SingleCommandContext _localctx = new SingleCommandContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_singleCommand);
		int _la;
		try {
			setState(72);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				_localctx = new AssignSingleCommandASTContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(38);
				ident();
				setState(39);
				match(ASIGN);
				setState(40);
				expression();
				}
				break;
			case 2:
				_localctx = new CallSingleCommandASTContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(42);
				ident();
				setState(43);
				match(PIZQ);
				setState(45);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PIZQ) | (1L << INTEGER) | (1L << IDENT))) != 0)) {
					{
					setState(44);
					expression();
					}
				}

				setState(47);
				match(PDER);
				}
				break;
			case 3:
				_localctx = new IfSingleCommandASTContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(49);
				match(IF);
				setState(50);
				expression();
				setState(51);
				match(THEN);
				setState(52);
				singleCommand();
				setState(53);
				match(ELSE);
				setState(54);
				singleCommand();
				}
				break;
			case 4:
				_localctx = new WhileSingleCommandASTContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(56);
				match(WHILE);
				setState(57);
				expression();
				setState(58);
				match(DO);
				setState(59);
				singleCommand();
				}
				break;
			case 5:
				_localctx = new LetSingleCommandASTContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(61);
				match(LET);
				setState(62);
				declaration();
				setState(63);
				match(IN);
				setState(64);
				singleCommand();
				}
				break;
			case 6:
				_localctx = new BlockSingleCommandASTContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(66);
				match(BEGIN);
				setState(67);
				command();
				setState(68);
				match(END);
				}
				break;
			case 7:
				_localctx = new ReturnSingleCommandASTContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(70);
				match(RETURN);
				setState(71);
				expression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclarationContext extends ParserRuleContext {
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
	 
		public DeclarationContext() { }
		public void copyFrom(DeclarationContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class DeclarationASTContext extends DeclarationContext {
		public List<SingleDeclarationContext> singleDeclaration() {
			return getRuleContexts(SingleDeclarationContext.class);
		}
		public SingleDeclarationContext singleDeclaration(int i) {
			return getRuleContext(SingleDeclarationContext.class,i);
		}
		public List<TerminalNode> PyCOMA() { return getTokens(AlphaParser.PyCOMA); }
		public TerminalNode PyCOMA(int i) {
			return getToken(AlphaParser.PyCOMA, i);
		}
		public DeclarationASTContext(DeclarationContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlphaParserVisitor ) return ((AlphaParserVisitor<? extends T>)visitor).visitDeclarationAST(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_declaration);
		int _la;
		try {
			_localctx = new DeclarationASTContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(74);
			singleDeclaration();
			setState(79);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PyCOMA) {
				{
				{
				setState(75);
				match(PyCOMA);
				setState(76);
				singleDeclaration();
				}
				}
				setState(81);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SingleDeclarationContext extends ParserRuleContext {
		public SingleDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_singleDeclaration; }
	 
		public SingleDeclarationContext() { }
		public void copyFrom(SingleDeclarationContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class MethodSingleDeclarationASTContext extends SingleDeclarationContext {
		public MethodDeclarationContext methodDeclaration() {
			return getRuleContext(MethodDeclarationContext.class,0);
		}
		public MethodSingleDeclarationASTContext(SingleDeclarationContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlphaParserVisitor ) return ((AlphaParserVisitor<? extends T>)visitor).visitMethodSingleDeclarationAST(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ConstSingleDeclarationASTContext extends SingleDeclarationContext {
		public TerminalNode CONST() { return getToken(AlphaParser.CONST, 0); }
		public TerminalNode IDENT() { return getToken(AlphaParser.IDENT, 0); }
		public TerminalNode VIR() { return getToken(AlphaParser.VIR, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ConstSingleDeclarationASTContext(SingleDeclarationContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlphaParserVisitor ) return ((AlphaParserVisitor<? extends T>)visitor).visitConstSingleDeclarationAST(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class VarSingleDeclarationASTContext extends SingleDeclarationContext {
		public TerminalNode VAR() { return getToken(AlphaParser.VAR, 0); }
		public TerminalNode IDENT() { return getToken(AlphaParser.IDENT, 0); }
		public TerminalNode DOSPUNTOS() { return getToken(AlphaParser.DOSPUNTOS, 0); }
		public TypeDenoterContext typeDenoter() {
			return getRuleContext(TypeDenoterContext.class,0);
		}
		public VarSingleDeclarationASTContext(SingleDeclarationContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlphaParserVisitor ) return ((AlphaParserVisitor<? extends T>)visitor).visitVarSingleDeclarationAST(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SingleDeclarationContext singleDeclaration() throws RecognitionException {
		SingleDeclarationContext _localctx = new SingleDeclarationContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_singleDeclaration);
		try {
			setState(91);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CONST:
				_localctx = new ConstSingleDeclarationASTContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(82);
				match(CONST);
				setState(83);
				match(IDENT);
				setState(84);
				match(VIR);
				setState(85);
				expression();
				}
				break;
			case VAR:
				_localctx = new VarSingleDeclarationASTContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(86);
				match(VAR);
				setState(87);
				match(IDENT);
				setState(88);
				match(DOSPUNTOS);
				setState(89);
				typeDenoter();
				}
				break;
			case FN:
				_localctx = new MethodSingleDeclarationASTContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(90);
				methodDeclaration();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MethodDeclarationContext extends ParserRuleContext {
		public MethodDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodDeclaration; }
	 
		public MethodDeclarationContext() { }
		public void copyFrom(MethodDeclarationContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class MethodDeclararionASTContext extends MethodDeclarationContext {
		public TerminalNode FN() { return getToken(AlphaParser.FN, 0); }
		public IdentContext ident() {
			return getRuleContext(IdentContext.class,0);
		}
		public TerminalNode PIZQ() { return getToken(AlphaParser.PIZQ, 0); }
		public FormalParamListContext formalParamList() {
			return getRuleContext(FormalParamListContext.class,0);
		}
		public TerminalNode PDER() { return getToken(AlphaParser.PDER, 0); }
		public TerminalNode DOSPUNTOS() { return getToken(AlphaParser.DOSPUNTOS, 0); }
		public TypeDenoterContext typeDenoter() {
			return getRuleContext(TypeDenoterContext.class,0);
		}
		public SingleCommandContext singleCommand() {
			return getRuleContext(SingleCommandContext.class,0);
		}
		public MethodDeclararionASTContext(MethodDeclarationContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlphaParserVisitor ) return ((AlphaParserVisitor<? extends T>)visitor).visitMethodDeclararionAST(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodDeclarationContext methodDeclaration() throws RecognitionException {
		MethodDeclarationContext _localctx = new MethodDeclarationContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_methodDeclaration);
		try {
			_localctx = new MethodDeclararionASTContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(93);
			match(FN);
			setState(94);
			ident();
			setState(95);
			match(PIZQ);
			setState(96);
			formalParamList();
			setState(97);
			match(PDER);
			setState(98);
			match(DOSPUNTOS);
			setState(99);
			typeDenoter();
			setState(100);
			singleCommand();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FormalParamListContext extends ParserRuleContext {
		public FormalParamListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formalParamList; }
	 
		public FormalParamListContext() { }
		public void copyFrom(FormalParamListContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class FormalParamListASTContext extends FormalParamListContext {
		public List<TerminalNode> IDENT() { return getTokens(AlphaParser.IDENT); }
		public TerminalNode IDENT(int i) {
			return getToken(AlphaParser.IDENT, i);
		}
		public List<TerminalNode> DOSPUNTOS() { return getTokens(AlphaParser.DOSPUNTOS); }
		public TerminalNode DOSPUNTOS(int i) {
			return getToken(AlphaParser.DOSPUNTOS, i);
		}
		public List<TypeDenoterContext> typeDenoter() {
			return getRuleContexts(TypeDenoterContext.class);
		}
		public TypeDenoterContext typeDenoter(int i) {
			return getRuleContext(TypeDenoterContext.class,i);
		}
		public List<TerminalNode> PyCOMA() { return getTokens(AlphaParser.PyCOMA); }
		public TerminalNode PyCOMA(int i) {
			return getToken(AlphaParser.PyCOMA, i);
		}
		public FormalParamListASTContext(FormalParamListContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlphaParserVisitor ) return ((AlphaParserVisitor<? extends T>)visitor).visitFormalParamListAST(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FormalParamListContext formalParamList() throws RecognitionException {
		FormalParamListContext _localctx = new FormalParamListContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_formalParamList);
		int _la;
		try {
			_localctx = new FormalParamListASTContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(109);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IDENT) {
				{
				{
				setState(102);
				match(IDENT);
				setState(103);
				match(DOSPUNTOS);
				setState(104);
				typeDenoter();
				setState(105);
				match(PyCOMA);
				}
				}
				setState(111);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeDenoterContext extends ParserRuleContext {
		public TypeDenoterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeDenoter; }
	 
		public TypeDenoterContext() { }
		public void copyFrom(TypeDenoterContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class TypeDenoterASTContext extends TypeDenoterContext {
		public TerminalNode IDENT() { return getToken(AlphaParser.IDENT, 0); }
		public TypeDenoterASTContext(TypeDenoterContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlphaParserVisitor ) return ((AlphaParserVisitor<? extends T>)visitor).visitTypeDenoterAST(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeDenoterContext typeDenoter() throws RecognitionException {
		TypeDenoterContext _localctx = new TypeDenoterContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_typeDenoter);
		try {
			_localctx = new TypeDenoterASTContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(112);
			match(IDENT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	 
		public ExpressionContext() { }
		public void copyFrom(ExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ExpressionComparationASTContext extends ExpressionContext {
		public List<PrimaryExpressionContext> primaryExpression() {
			return getRuleContexts(PrimaryExpressionContext.class);
		}
		public PrimaryExpressionContext primaryExpression(int i) {
			return getRuleContext(PrimaryExpressionContext.class,i);
		}
		public List<ComparationContext> comparation() {
			return getRuleContexts(ComparationContext.class);
		}
		public ComparationContext comparation(int i) {
			return getRuleContext(ComparationContext.class,i);
		}
		public ExpressionComparationASTContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlphaParserVisitor ) return ((AlphaParserVisitor<? extends T>)visitor).visitExpressionComparationAST(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpressionOperatorASTContext extends ExpressionContext {
		public List<PrimaryExpressionContext> primaryExpression() {
			return getRuleContexts(PrimaryExpressionContext.class);
		}
		public PrimaryExpressionContext primaryExpression(int i) {
			return getRuleContext(PrimaryExpressionContext.class,i);
		}
		public List<OperatorContext> operator() {
			return getRuleContexts(OperatorContext.class);
		}
		public OperatorContext operator(int i) {
			return getRuleContext(OperatorContext.class,i);
		}
		public ExpressionOperatorASTContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlphaParserVisitor ) return ((AlphaParserVisitor<? extends T>)visitor).visitExpressionOperatorAST(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_expression);
		int _la;
		try {
			setState(132);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				_localctx = new ExpressionComparationASTContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(114);
				primaryExpression();
				setState(120);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LE) | (1L << GE) | (1L << EQUAL) | (1L << NOT_EQUAL) | (1L << GT) | (1L << LT) | (1L << AND) | (1L << OR))) != 0)) {
					{
					{
					setState(115);
					comparation();
					setState(116);
					primaryExpression();
					}
					}
					setState(122);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				_localctx = new ExpressionOperatorASTContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(123);
				primaryExpression();
				setState(129);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SUMA) | (1L << RESTA) | (1L << MULT) | (1L << DIV))) != 0)) {
					{
					{
					setState(124);
					operator();
					setState(125);
					primaryExpression();
					}
					}
					setState(131);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrimaryExpressionContext extends ParserRuleContext {
		public PrimaryExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primaryExpression; }
	 
		public PrimaryExpressionContext() { }
		public void copyFrom(PrimaryExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class CallPrimaryExpressionContext extends PrimaryExpressionContext {
		public IdentContext ident() {
			return getRuleContext(IdentContext.class,0);
		}
		public TerminalNode PIZQ() { return getToken(AlphaParser.PIZQ, 0); }
		public ActualParamListContext actualParamList() {
			return getRuleContext(ActualParamListContext.class,0);
		}
		public TerminalNode PDER() { return getToken(AlphaParser.PDER, 0); }
		public CallPrimaryExpressionContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlphaParserVisitor ) return ((AlphaParserVisitor<? extends T>)visitor).visitCallPrimaryExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class GroupPrimaryExpressionASTContext extends PrimaryExpressionContext {
		public TerminalNode PIZQ() { return getToken(AlphaParser.PIZQ, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode PDER() { return getToken(AlphaParser.PDER, 0); }
		public GroupPrimaryExpressionASTContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlphaParserVisitor ) return ((AlphaParserVisitor<? extends T>)visitor).visitGroupPrimaryExpressionAST(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NumPrimaryExpressionASTContext extends PrimaryExpressionContext {
		public TerminalNode INTEGER() { return getToken(AlphaParser.INTEGER, 0); }
		public NumPrimaryExpressionASTContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlphaParserVisitor ) return ((AlphaParserVisitor<? extends T>)visitor).visitNumPrimaryExpressionAST(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IdPrimaryExpressionASTContext extends PrimaryExpressionContext {
		public IdentContext ident() {
			return getRuleContext(IdentContext.class,0);
		}
		public IdPrimaryExpressionASTContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlphaParserVisitor ) return ((AlphaParserVisitor<? extends T>)visitor).visitIdPrimaryExpressionAST(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimaryExpressionContext primaryExpression() throws RecognitionException {
		PrimaryExpressionContext _localctx = new PrimaryExpressionContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_primaryExpression);
		try {
			setState(145);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				_localctx = new NumPrimaryExpressionASTContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(134);
				match(INTEGER);
				}
				break;
			case 2:
				_localctx = new IdPrimaryExpressionASTContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(135);
				ident();
				}
				break;
			case 3:
				_localctx = new CallPrimaryExpressionContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(136);
				ident();
				setState(137);
				match(PIZQ);
				setState(138);
				actualParamList();
				setState(139);
				match(PDER);
				}
				break;
			case 4:
				_localctx = new GroupPrimaryExpressionASTContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(141);
				match(PIZQ);
				setState(142);
				expression();
				setState(143);
				match(PDER);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ActualParamListContext extends ParserRuleContext {
		public ActualParamListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_actualParamList; }
	 
		public ActualParamListContext() { }
		public void copyFrom(ActualParamListContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ActualParamListASTContext extends ActualParamListContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> PyCOMA() { return getTokens(AlphaParser.PyCOMA); }
		public TerminalNode PyCOMA(int i) {
			return getToken(AlphaParser.PyCOMA, i);
		}
		public ActualParamListASTContext(ActualParamListContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlphaParserVisitor ) return ((AlphaParserVisitor<? extends T>)visitor).visitActualParamListAST(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ActualParamListContext actualParamList() throws RecognitionException {
		ActualParamListContext _localctx = new ActualParamListContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_actualParamList);
		int _la;
		try {
			_localctx = new ActualParamListASTContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(152);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PIZQ) | (1L << INTEGER) | (1L << IDENT))) != 0)) {
				{
				{
				setState(147);
				expression();
				setState(148);
				match(PyCOMA);
				}
				}
				setState(154);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OperatorContext extends ParserRuleContext {
		public OperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operator; }
	 
		public OperatorContext() { }
		public void copyFrom(OperatorContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class DivASTContext extends OperatorContext {
		public TerminalNode DIV() { return getToken(AlphaParser.DIV, 0); }
		public DivASTContext(OperatorContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlphaParserVisitor ) return ((AlphaParserVisitor<? extends T>)visitor).visitDivAST(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MultASTContext extends OperatorContext {
		public TerminalNode MULT() { return getToken(AlphaParser.MULT, 0); }
		public MultASTContext(OperatorContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlphaParserVisitor ) return ((AlphaParserVisitor<? extends T>)visitor).visitMultAST(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SumaASTContext extends OperatorContext {
		public TerminalNode SUMA() { return getToken(AlphaParser.SUMA, 0); }
		public SumaASTContext(OperatorContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlphaParserVisitor ) return ((AlphaParserVisitor<? extends T>)visitor).visitSumaAST(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RestaASTContext extends OperatorContext {
		public TerminalNode RESTA() { return getToken(AlphaParser.RESTA, 0); }
		public RestaASTContext(OperatorContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlphaParserVisitor ) return ((AlphaParserVisitor<? extends T>)visitor).visitRestaAST(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OperatorContext operator() throws RecognitionException {
		OperatorContext _localctx = new OperatorContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_operator);
		try {
			setState(159);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SUMA:
				_localctx = new SumaASTContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(155);
				match(SUMA);
				}
				break;
			case RESTA:
				_localctx = new RestaASTContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(156);
				match(RESTA);
				}
				break;
			case MULT:
				_localctx = new MultASTContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(157);
				match(MULT);
				}
				break;
			case DIV:
				_localctx = new DivASTContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(158);
				match(DIV);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ComparationContext extends ParserRuleContext {
		public ComparationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comparation; }
	 
		public ComparationContext() { }
		public void copyFrom(ComparationContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class MenorASTContext extends ComparationContext {
		public TerminalNode LT() { return getToken(AlphaParser.LT, 0); }
		public MenorASTContext(ComparationContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlphaParserVisitor ) return ((AlphaParserVisitor<? extends T>)visitor).visitMenorAST(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MayorIgualASTContext extends ComparationContext {
		public TerminalNode GE() { return getToken(AlphaParser.GE, 0); }
		public MayorIgualASTContext(ComparationContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlphaParserVisitor ) return ((AlphaParserVisitor<? extends T>)visitor).visitMayorIgualAST(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MenorIgualASTContext extends ComparationContext {
		public TerminalNode LE() { return getToken(AlphaParser.LE, 0); }
		public MenorIgualASTContext(ComparationContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlphaParserVisitor ) return ((AlphaParserVisitor<? extends T>)visitor).visitMenorIgualAST(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AndASTContext extends ComparationContext {
		public TerminalNode AND() { return getToken(AlphaParser.AND, 0); }
		public AndASTContext(ComparationContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlphaParserVisitor ) return ((AlphaParserVisitor<? extends T>)visitor).visitAndAST(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DiferenteASTContext extends ComparationContext {
		public TerminalNode NOT_EQUAL() { return getToken(AlphaParser.NOT_EQUAL, 0); }
		public DiferenteASTContext(ComparationContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlphaParserVisitor ) return ((AlphaParserVisitor<? extends T>)visitor).visitDiferenteAST(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MayorASTContext extends ComparationContext {
		public TerminalNode GT() { return getToken(AlphaParser.GT, 0); }
		public MayorASTContext(ComparationContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlphaParserVisitor ) return ((AlphaParserVisitor<? extends T>)visitor).visitMayorAST(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IgualASTContext extends ComparationContext {
		public TerminalNode EQUAL() { return getToken(AlphaParser.EQUAL, 0); }
		public IgualASTContext(ComparationContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlphaParserVisitor ) return ((AlphaParserVisitor<? extends T>)visitor).visitIgualAST(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class OrASTContext extends ComparationContext {
		public TerminalNode OR() { return getToken(AlphaParser.OR, 0); }
		public OrASTContext(ComparationContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlphaParserVisitor ) return ((AlphaParserVisitor<? extends T>)visitor).visitOrAST(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComparationContext comparation() throws RecognitionException {
		ComparationContext _localctx = new ComparationContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_comparation);
		try {
			setState(169);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LT:
				_localctx = new MenorASTContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(161);
				match(LT);
				}
				break;
			case GT:
				_localctx = new MayorASTContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(162);
				match(GT);
				}
				break;
			case LE:
				_localctx = new MenorIgualASTContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(163);
				match(LE);
				}
				break;
			case GE:
				_localctx = new MayorIgualASTContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(164);
				match(GE);
				}
				break;
			case EQUAL:
				_localctx = new IgualASTContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(165);
				match(EQUAL);
				}
				break;
			case NOT_EQUAL:
				_localctx = new DiferenteASTContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(166);
				match(NOT_EQUAL);
				}
				break;
			case AND:
				_localctx = new AndASTContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(167);
				match(AND);
				}
				break;
			case OR:
				_localctx = new OrASTContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(168);
				match(OR);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IdentContext extends ParserRuleContext {
		public SingleDeclarationContext decl = null;
		public IdentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ident; }
	 
		public IdentContext() { }
		public void copyFrom(IdentContext ctx) {
			super.copyFrom(ctx);
			this.decl = ctx.decl;
		}
	}
	public static class IdentASTContext extends IdentContext {
		public TerminalNode IDENT() { return getToken(AlphaParser.IDENT, 0); }
		public IdentASTContext(IdentContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlphaParserVisitor ) return ((AlphaParserVisitor<? extends T>)visitor).visitIdentAST(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentContext ident() throws RecognitionException {
		IdentContext _localctx = new IdentContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_ident);
		try {
			_localctx = new IdentASTContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(171);
			match(IDENT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3)\u00b0\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\3\2\3\2\3\3\3\3\3\3\7\3$\n\3\f"+
		"\3\16\3\'\13\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4\60\n\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\5\4K\n\4\3\5\3\5\3\5\7\5P\n\5\f\5\16\5S\13\5\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6^\n\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\b\3\b\3\b\3\b\3\b\7\bn\n\b\f\b\16\bq\13\b\3\t\3\t\3\n\3\n\3\n\3\n"+
		"\7\ny\n\n\f\n\16\n|\13\n\3\n\3\n\3\n\3\n\7\n\u0082\n\n\f\n\16\n\u0085"+
		"\13\n\5\n\u0087\n\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\5\13\u0094\n\13\3\f\3\f\3\f\7\f\u0099\n\f\f\f\16\f\u009c\13\f\3"+
		"\r\3\r\3\r\3\r\5\r\u00a2\n\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5"+
		"\16\u00ac\n\16\3\17\3\17\3\17\2\2\20\2\4\6\b\n\f\16\20\22\24\26\30\32"+
		"\34\2\2\2\u00be\2\36\3\2\2\2\4 \3\2\2\2\6J\3\2\2\2\bL\3\2\2\2\n]\3\2\2"+
		"\2\f_\3\2\2\2\16o\3\2\2\2\20r\3\2\2\2\22\u0086\3\2\2\2\24\u0093\3\2\2"+
		"\2\26\u009a\3\2\2\2\30\u00a1\3\2\2\2\32\u00ab\3\2\2\2\34\u00ad\3\2\2\2"+
		"\36\37\5\6\4\2\37\3\3\2\2\2 %\5\6\4\2!\"\7\3\2\2\"$\5\6\4\2#!\3\2\2\2"+
		"$\'\3\2\2\2%#\3\2\2\2%&\3\2\2\2&\5\3\2\2\2\'%\3\2\2\2()\5\34\17\2)*\7"+
		"\5\2\2*+\5\22\n\2+K\3\2\2\2,-\5\34\17\2-/\7\6\2\2.\60\5\22\n\2/.\3\2\2"+
		"\2/\60\3\2\2\2\60\61\3\2\2\2\61\62\7\7\2\2\62K\3\2\2\2\63\64\7\26\2\2"+
		"\64\65\5\22\n\2\65\66\7\27\2\2\66\67\5\6\4\2\678\7\30\2\289\5\6\4\29K"+
		"\3\2\2\2:;\7\31\2\2;<\5\22\n\2<=\7\32\2\2=>\5\6\4\2>K\3\2\2\2?@\7\33\2"+
		"\2@A\5\b\5\2AB\7\34\2\2BC\5\6\4\2CK\3\2\2\2DE\7\35\2\2EF\5\4\3\2FG\7\36"+
		"\2\2GK\3\2\2\2HI\7!\2\2IK\5\22\n\2J(\3\2\2\2J,\3\2\2\2J\63\3\2\2\2J:\3"+
		"\2\2\2J?\3\2\2\2JD\3\2\2\2JH\3\2\2\2K\7\3\2\2\2LQ\5\n\6\2MN\7\3\2\2NP"+
		"\5\n\6\2OM\3\2\2\2PS\3\2\2\2QO\3\2\2\2QR\3\2\2\2R\t\3\2\2\2SQ\3\2\2\2"+
		"TU\7\37\2\2UV\7&\2\2VW\7\b\2\2W^\5\22\n\2XY\7 \2\2YZ\7&\2\2Z[\7\4\2\2"+
		"[^\5\20\t\2\\^\5\f\7\2]T\3\2\2\2]X\3\2\2\2]\\\3\2\2\2^\13\3\2\2\2_`\7"+
		"\25\2\2`a\5\34\17\2ab\7\6\2\2bc\5\16\b\2cd\7\7\2\2de\7\4\2\2ef\5\20\t"+
		"\2fg\5\6\4\2g\r\3\2\2\2hi\7&\2\2ij\7\4\2\2jk\5\20\t\2kl\7\3\2\2ln\3\2"+
		"\2\2mh\3\2\2\2nq\3\2\2\2om\3\2\2\2op\3\2\2\2p\17\3\2\2\2qo\3\2\2\2rs\7"+
		"&\2\2s\21\3\2\2\2tz\5\24\13\2uv\5\32\16\2vw\5\24\13\2wy\3\2\2\2xu\3\2"+
		"\2\2y|\3\2\2\2zx\3\2\2\2z{\3\2\2\2{\u0087\3\2\2\2|z\3\2\2\2}\u0083\5\24"+
		"\13\2~\177\5\30\r\2\177\u0080\5\24\13\2\u0080\u0082\3\2\2\2\u0081~\3\2"+
		"\2\2\u0082\u0085\3\2\2\2\u0083\u0081\3\2\2\2\u0083\u0084\3\2\2\2\u0084"+
		"\u0087\3\2\2\2\u0085\u0083\3\2\2\2\u0086t\3\2\2\2\u0086}\3\2\2\2\u0087"+
		"\23\3\2\2\2\u0088\u0094\7$\2\2\u0089\u0094\5\34\17\2\u008a\u008b\5\34"+
		"\17\2\u008b\u008c\7\6\2\2\u008c\u008d\5\26\f\2\u008d\u008e\7\7\2\2\u008e"+
		"\u0094\3\2\2\2\u008f\u0090\7\6\2\2\u0090\u0091\5\22\n\2\u0091\u0092\7"+
		"\7\2\2\u0092\u0094\3\2\2\2\u0093\u0088\3\2\2\2\u0093\u0089\3\2\2\2\u0093"+
		"\u008a\3\2\2\2\u0093\u008f\3\2\2\2\u0094\25\3\2\2\2\u0095\u0096\5\22\n"+
		"\2\u0096\u0097\7\3\2\2\u0097\u0099\3\2\2\2\u0098\u0095\3\2\2\2\u0099\u009c"+
		"\3\2\2\2\u009a\u0098\3\2\2\2\u009a\u009b\3\2\2\2\u009b\27\3\2\2\2\u009c"+
		"\u009a\3\2\2\2\u009d\u00a2\7\21\2\2\u009e\u00a2\7\22\2\2\u009f\u00a2\7"+
		"\23\2\2\u00a0\u00a2\7\24\2\2\u00a1\u009d\3\2\2\2\u00a1\u009e\3\2\2\2\u00a1"+
		"\u009f\3\2\2\2\u00a1\u00a0\3\2\2\2\u00a2\31\3\2\2\2\u00a3\u00ac\7\16\2"+
		"\2\u00a4\u00ac\7\r\2\2\u00a5\u00ac\7\t\2\2\u00a6\u00ac\7\n\2\2\u00a7\u00ac"+
		"\7\13\2\2\u00a8\u00ac\7\f\2\2\u00a9\u00ac\7\17\2\2\u00aa\u00ac\7\20\2"+
		"\2\u00ab\u00a3\3\2\2\2\u00ab\u00a4\3\2\2\2\u00ab\u00a5\3\2\2\2\u00ab\u00a6"+
		"\3\2\2\2\u00ab\u00a7\3\2\2\2\u00ab\u00a8\3\2\2\2\u00ab\u00a9\3\2\2\2\u00ab"+
		"\u00aa\3\2\2\2\u00ac\33\3\2\2\2\u00ad\u00ae\7&\2\2\u00ae\35\3\2\2\2\17"+
		"%/JQ]oz\u0083\u0086\u0093\u009a\u00a1\u00ab";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}