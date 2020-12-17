// Generated from C:/Users/Baxi/Desktop/Compi/ExamenParte1\XMLParser.g4 by ANTLR 4.8
package generated;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link XMLParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface XMLParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code program_AST}
	 * labeled alternative in {@link XMLParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram_AST(XMLParser.Program_ASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code definition_AST}
	 * labeled alternative in {@link XMLParser#definition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefinition_AST(XMLParser.Definition_ASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code content_AST}
	 * labeled alternative in {@link XMLParser#content}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContent_AST(XMLParser.Content_ASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code element_content_AST}
	 * labeled alternative in {@link XMLParser#element}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElement_content_AST(XMLParser.Element_content_ASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code element_without_content_AST}
	 * labeled alternative in {@link XMLParser#element}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElement_without_content_AST(XMLParser.Element_without_content_ASTContext ctx);
	/**
	 * Visit a parse tree produced by {@link XMLParser#reference}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReference(XMLParser.ReferenceContext ctx);
	/**
	 * Visit a parse tree produced by the {@code attribute_AST}
	 * labeled alternative in {@link XMLParser#attribute}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttribute_AST(XMLParser.Attribute_ASTContext ctx);
	/**
	 * Visit a parse tree produced by {@link XMLParser#chardata}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChardata(XMLParser.ChardataContext ctx);
	/**
	 * Visit a parse tree produced by {@link XMLParser#omited}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOmited(XMLParser.OmitedContext ctx);
}