// Generated from C:/Users/Baxi/Desktop/Compi/Examen-Compiladores/ExamenParte2\AlphaParser.g4 by ANTLR 4.8
package generated;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link AlphaParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface AlphaParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code programAST}
	 * labeled alternative in {@link AlphaParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgramAST(AlphaParser.ProgramASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code commandAST}
	 * labeled alternative in {@link AlphaParser#command}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommandAST(AlphaParser.CommandASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code assignSCAST}
	 * labeled alternative in {@link AlphaParser#singleCommand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignSCAST(AlphaParser.AssignSCASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code callSCAST}
	 * labeled alternative in {@link AlphaParser#singleCommand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCallSCAST(AlphaParser.CallSCASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ifSCAST}
	 * labeled alternative in {@link AlphaParser#singleCommand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfSCAST(AlphaParser.IfSCASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code whileSCAST}
	 * labeled alternative in {@link AlphaParser#singleCommand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileSCAST(AlphaParser.WhileSCASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code letSCAST}
	 * labeled alternative in {@link AlphaParser#singleCommand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLetSCAST(AlphaParser.LetSCASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code beginSCAST}
	 * labeled alternative in {@link AlphaParser#singleCommand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBeginSCAST(AlphaParser.BeginSCASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code returnSCAST}
	 * labeled alternative in {@link AlphaParser#singleCommand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnSCAST(AlphaParser.ReturnSCASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code actualParamAST}
	 * labeled alternative in {@link AlphaParser#actualParam}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitActualParamAST(AlphaParser.ActualParamASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code declarationAST}
	 * labeled alternative in {@link AlphaParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclarationAST(AlphaParser.DeclarationASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code constSDeclAST}
	 * labeled alternative in {@link AlphaParser#singleDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstSDeclAST(AlphaParser.ConstSDeclASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code varSDeclAST}
	 * labeled alternative in {@link AlphaParser#singleDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarSDeclAST(AlphaParser.VarSDeclASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code methodSDeclAST}
	 * labeled alternative in {@link AlphaParser#singleDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodSDeclAST(AlphaParser.MethodSDeclASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code varDeclAST}
	 * labeled alternative in {@link AlphaParser#varDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDeclAST(AlphaParser.VarDeclASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code paramDeclsAST}
	 * labeled alternative in {@link AlphaParser#paramDecls}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParamDeclsAST(AlphaParser.ParamDeclsASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code typeDenoterAST}
	 * labeled alternative in {@link AlphaParser#typedenoter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeDenoterAST(AlphaParser.TypeDenoterASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expressionAST}
	 * labeled alternative in {@link AlphaParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionAST(AlphaParser.ExpressionASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code booleanPEAST}
	 * labeled alternative in {@link AlphaParser#primaryExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanPEAST(AlphaParser.BooleanPEASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stringPEAST}
	 * labeled alternative in {@link AlphaParser#primaryExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringPEAST(AlphaParser.StringPEASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code numPEAST}
	 * labeled alternative in {@link AlphaParser#primaryExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumPEAST(AlphaParser.NumPEASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code identPEAST}
	 * labeled alternative in {@link AlphaParser#primaryExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentPEAST(AlphaParser.IdentPEASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code charPEAST}
	 * labeled alternative in {@link AlphaParser#primaryExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCharPEAST(AlphaParser.CharPEASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code groupPEAST}
	 * labeled alternative in {@link AlphaParser#primaryExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGroupPEAST(AlphaParser.GroupPEASTContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlphaParser#operator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperator(AlphaParser.OperatorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code identAST}
	 * labeled alternative in {@link AlphaParser#ident}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentAST(AlphaParser.IdentASTContext ctx);
}