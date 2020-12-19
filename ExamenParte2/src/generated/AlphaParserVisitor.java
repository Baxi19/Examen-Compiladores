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
	 * Visit a parse tree produced by the {@code assignSingleCommandAST}
	 * labeled alternative in {@link AlphaParser#singleCommand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignSingleCommandAST(AlphaParser.AssignSingleCommandASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code callSingleCommandAST}
	 * labeled alternative in {@link AlphaParser#singleCommand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCallSingleCommandAST(AlphaParser.CallSingleCommandASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ifSingleCommandAST}
	 * labeled alternative in {@link AlphaParser#singleCommand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfSingleCommandAST(AlphaParser.IfSingleCommandASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code whileSingleCommandAST}
	 * labeled alternative in {@link AlphaParser#singleCommand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileSingleCommandAST(AlphaParser.WhileSingleCommandASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code letSingleCommandAST}
	 * labeled alternative in {@link AlphaParser#singleCommand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLetSingleCommandAST(AlphaParser.LetSingleCommandASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code blockSingleCommandAST}
	 * labeled alternative in {@link AlphaParser#singleCommand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockSingleCommandAST(AlphaParser.BlockSingleCommandASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code returnSingleCommandAST}
	 * labeled alternative in {@link AlphaParser#singleCommand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnSingleCommandAST(AlphaParser.ReturnSingleCommandASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code declarationAST}
	 * labeled alternative in {@link AlphaParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclarationAST(AlphaParser.DeclarationASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code constSingleDeclarationAST}
	 * labeled alternative in {@link AlphaParser#singleDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstSingleDeclarationAST(AlphaParser.ConstSingleDeclarationASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code varSingleDeclarationAST}
	 * labeled alternative in {@link AlphaParser#singleDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarSingleDeclarationAST(AlphaParser.VarSingleDeclarationASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code methodSingleDeclarationAST}
	 * labeled alternative in {@link AlphaParser#singleDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodSingleDeclarationAST(AlphaParser.MethodSingleDeclarationASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code methodDeclararionAST}
	 * labeled alternative in {@link AlphaParser#methodDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodDeclararionAST(AlphaParser.MethodDeclararionASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code formalParamListAST}
	 * labeled alternative in {@link AlphaParser#formalParamList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormalParamListAST(AlphaParser.FormalParamListASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code typeDenoterIdentAST}
	 * labeled alternative in {@link AlphaParser#typeDenoter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeDenoterIdentAST(AlphaParser.TypeDenoterIdentASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expressionIdentAST}
	 * labeled alternative in {@link AlphaParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionIdentAST(AlphaParser.ExpressionIdentASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expressionComparationAST}
	 * labeled alternative in {@link AlphaParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionComparationAST(AlphaParser.ExpressionComparationASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expressionOperatorAST}
	 * labeled alternative in {@link AlphaParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionOperatorAST(AlphaParser.ExpressionOperatorASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code typeDenoterStringAST}
	 * labeled alternative in {@link AlphaParser#typeLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeDenoterStringAST(AlphaParser.TypeDenoterStringASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code typeDenoterBooleanAST}
	 * labeled alternative in {@link AlphaParser#typeLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeDenoterBooleanAST(AlphaParser.TypeDenoterBooleanASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code typeDenoterIntAST}
	 * labeled alternative in {@link AlphaParser#typeLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeDenoterIntAST(AlphaParser.TypeDenoterIntASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code numPrimaryExpressionAST}
	 * labeled alternative in {@link AlphaParser#primaryExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumPrimaryExpressionAST(AlphaParser.NumPrimaryExpressionASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code idPrimaryExpressionAST}
	 * labeled alternative in {@link AlphaParser#primaryExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdPrimaryExpressionAST(AlphaParser.IdPrimaryExpressionASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code callPrimaryExpression}
	 * labeled alternative in {@link AlphaParser#primaryExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCallPrimaryExpression(AlphaParser.CallPrimaryExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code groupPrimaryExpressionAST}
	 * labeled alternative in {@link AlphaParser#primaryExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGroupPrimaryExpressionAST(AlphaParser.GroupPrimaryExpressionASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code actualParamListAST}
	 * labeled alternative in {@link AlphaParser#actualParamList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitActualParamListAST(AlphaParser.ActualParamListASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code sumaAST}
	 * labeled alternative in {@link AlphaParser#operator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSumaAST(AlphaParser.SumaASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code restaAST}
	 * labeled alternative in {@link AlphaParser#operator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRestaAST(AlphaParser.RestaASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code multAST}
	 * labeled alternative in {@link AlphaParser#operator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultAST(AlphaParser.MultASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code divAST}
	 * labeled alternative in {@link AlphaParser#operator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDivAST(AlphaParser.DivASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code menorAST}
	 * labeled alternative in {@link AlphaParser#comparation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMenorAST(AlphaParser.MenorASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code mayorAST}
	 * labeled alternative in {@link AlphaParser#comparation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMayorAST(AlphaParser.MayorASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code menorIgualAST}
	 * labeled alternative in {@link AlphaParser#comparation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMenorIgualAST(AlphaParser.MenorIgualASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code mayorIgualAST}
	 * labeled alternative in {@link AlphaParser#comparation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMayorIgualAST(AlphaParser.MayorIgualASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code igualAST}
	 * labeled alternative in {@link AlphaParser#comparation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIgualAST(AlphaParser.IgualASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code diferenteAST}
	 * labeled alternative in {@link AlphaParser#comparation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDiferenteAST(AlphaParser.DiferenteASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code andAST}
	 * labeled alternative in {@link AlphaParser#comparation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndAST(AlphaParser.AndASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code orAST}
	 * labeled alternative in {@link AlphaParser#comparation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrAST(AlphaParser.OrASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code identAST}
	 * labeled alternative in {@link AlphaParser#ident}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentAST(AlphaParser.IdentASTContext ctx);
}