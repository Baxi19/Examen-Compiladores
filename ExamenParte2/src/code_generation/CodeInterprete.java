package code_generation;

import generated.AlphaParser;
import generated.AlphaParserBaseVisitor;

import java.util.ArrayList;


public class CodeInterprete extends AlphaParserBaseVisitor {
    private int letmain;
    private int indice;
    private ArrayList<String> codigo;
    private TablaSimbolos tablaIDS;

    // Constructor
    public CodeInterprete() {
        this.letmain=-1;
        this.indice=0;
        this.codigo= new ArrayList<>();
        this.tablaIDS = new TablaSimbolos();
    }

    //generate method
    private void generar(int indice, String instr, Object param){
        if (param!=null)
            this.codigo.add(indice + " " + instr + " " + param);
        else
            this.codigo.add(indice + " " + instr);
        this.indice++;
    }

    @Override
    public String toString() {
        String result="";
        for (String s : codigo){
            result+= s + '\n';
        }
        return result;
    }

    // Override Methods
    @Override
    public Object visitProgramAST(AlphaParser.ProgramASTContext ctx) {
        visit(ctx.singleCommand());
        System.out.println(this.toString());
        return null;
    }

    @Override
    public Object visitCommandAST(AlphaParser.CommandASTContext ctx) {
        for (int i = 0; i < ctx.singleCommand().size(); i++) {
            visit(ctx.singleCommand(i));
        }
        return null;
    }

    @Override
    public Object visitAssignSingleCommandAST(AlphaParser.AssignSingleCommandASTContext ctx) {
        visit(ctx.ident());
        visit(ctx.expression());
        return null;
    }

    @Override
    public Object visitCallSingleCommandAST(AlphaParser.CallSingleCommandASTContext ctx) {
        visit(ctx.ident());
        if(ctx.expression() != null){
            visit(ctx.expression());
        }
        return null;
    }

    @Override
    public Object visitIfSingleCommandAST(AlphaParser.IfSingleCommandASTContext ctx) {
        //if
        visit(ctx.expression());
        //then
        visit(ctx.singleCommand(0));
        //else
        visit(ctx.singleCommand(1));
        return null;
    }

    @Override
    public Object visitWhileSingleCommandAST(AlphaParser.WhileSingleCommandASTContext ctx) {
        // while
        visit(ctx.expression());
        // do
        visit(ctx.singleCommand());
        return null;
    }

    @Override
    public Object visitLetSingleCommandAST(AlphaParser.LetSingleCommandASTContext ctx) {
        //let
        visit(ctx.declaration());
        //in
        visit(ctx.singleCommand());
        return null;
    }

    @Override
    public Object visitBlockSingleCommandAST(AlphaParser.BlockSingleCommandASTContext ctx) {
        // begin
        visit(ctx.command());
        // end
        return null;
    }

    @Override
    public Object visitReturnSingleCommandAST(AlphaParser.ReturnSingleCommandASTContext ctx) {
        //return
        visit(ctx.expression());
        this.generar(this.indice,"RETURN_VALUE",null);
        return null;
    }

    @Override
    public Object visitDeclarationAST(AlphaParser.DeclarationASTContext ctx) {
        for (int i = 0; i < ctx.singleDeclaration().size(); i++) {
            visit(ctx.singleDeclaration(i));
        }
        return null;
    }

    @Override
    public Object visitConstSingleDeclarationAST(AlphaParser.ConstSingleDeclarationASTContext ctx) {
        // const ident ~
        visit(ctx.expression());
        return null;
    }

    @Override
    public Object visitVarSingleDeclarationAST(AlphaParser.VarSingleDeclarationASTContext ctx) {
        // var ident : type
        visit(ctx.typeDenoter());
        return null;
    }

    @Override
    public Object visitMethodSingleDeclarationAST(AlphaParser.MethodSingleDeclarationASTContext ctx) {
        visit(ctx.methodDeclaration());
        return null;
    }

    @Override
    public Object visitMethodDeclararionAST(AlphaParser.MethodDeclararionASTContext ctx) {
        // fn id (...) : type
        //fn
        visit(ctx.ident());
        //param
        visit(ctx.formalParamList());
        //type
        visit(ctx.typeDenoter());
        //single command
        visit(ctx.singleCommand());
        return null;
    }

    @Override
    public Object visitFormalParamListAST(AlphaParser.FormalParamListASTContext ctx) {
        //parameters
        for(int i=0; i < ctx.IDENT().size(); i++) {
            this.tablaIDS.insertar(ctx.IDENT(i).getSymbol(),0,null);
            this.generar(this.indice,"PUSH_LOCAL_I",ctx.IDENT(i).getText());
        }

        /*if(!ctx.typeDenoter().isEmpty()){
            for (int i = 0; i < ctx.typeDenoter().size(); i++) {
                visit(ctx.typeDenoter(i));
            }
        }

         */
        return null;
    }

    @Override
    public Object visitTypeDenoterIdentAST(AlphaParser.TypeDenoterIdentASTContext ctx) {
        //Ident
        return null;
    }

    @Override
    public Object visitExpressionComparationAST(AlphaParser.ExpressionComparationASTContext ctx) {
        //comparation
        for (int i = 0; i < ctx.primaryExpression().size(); i++) {
            visit(ctx.primaryExpression(i));
            if(i != ctx.primaryExpression().size()-1){
                visit(ctx.comparation(i));
            }
        }
        return null;
    }



    @Override
    public Object visitExpressionOperatorAST(AlphaParser.ExpressionOperatorASTContext ctx) {
        //operator
        for (int i = 0; i < ctx.primaryExpression().size(); i++) {
            visit(ctx.primaryExpression(i));
            if(i != ctx.primaryExpression().size()-1){
                visit(ctx.operator(i));
            }
        }
        return null;
    }

    @Override
    public Object visitNumPrimaryExpressionAST(AlphaParser.NumPrimaryExpressionASTContext ctx) {
        visit(ctx.INTEGER());
        return null;
    }

    @Override
    public Object visitIdPrimaryExpressionAST(AlphaParser.IdPrimaryExpressionASTContext ctx) {
        visit(ctx.ident());
        return null;
    }

    @Override
    public Object visitCallPrimaryExpression(AlphaParser.CallPrimaryExpressionContext ctx) {
        visit(ctx.ident());
        visit(ctx.actualParamList());
        return null;
    }

    @Override
    public Object visitGroupPrimaryExpressionAST(AlphaParser.GroupPrimaryExpressionASTContext ctx) {
        visit(ctx.expression());
        return null;
    }

    @Override
    public Object visitActualParamListAST(AlphaParser.ActualParamListASTContext ctx) {
        //parameters
        for (int i = 0; i < ctx.expression().size(); i++) {
            visit(ctx.expression(i));
        }
        return ctx.expression().size();
    }

    @Override
    public Object visitSumaAST(AlphaParser.SumaASTContext ctx) {
        //suma
        return "+";
    }

    @Override
    public Object visitRestaAST(AlphaParser.RestaASTContext ctx) {
        //resta
        return "-";
    }

    @Override
    public Object visitMultAST(AlphaParser.MultASTContext ctx) {
        //multiplicacion
        return "*";
    }

    @Override
    public Object visitDivAST(AlphaParser.DivASTContext ctx) {
        //division
        return "/";
    }

    @Override
    public Object visitMenorAST(AlphaParser.MenorASTContext ctx) {
        return "<";
    }

    @Override
    public Object visitMayorAST(AlphaParser.MayorASTContext ctx) {
        return ">";
    }

    @Override
    public Object visitMenorIgualAST(AlphaParser.MenorIgualASTContext ctx) {
        return "<=";
    }

    @Override
    public Object visitMayorIgualAST(AlphaParser.MayorIgualASTContext ctx) {
        return ">=";
    }

    @Override
    public Object visitIgualAST(AlphaParser.IgualASTContext ctx) {
        return "=";
    }

    @Override
    public Object visitDiferenteAST(AlphaParser.DiferenteASTContext ctx) {
        return "!=";
    }

    @Override
    public Object visitAndAST(AlphaParser.AndASTContext ctx) {
        return "&";
    }

    @Override
    public Object visitOrAST(AlphaParser.OrASTContext ctx) {
        return "|";
    }

    @Override
    public Object visitIdentAST(AlphaParser.IdentASTContext ctx) {
        visit(ctx.IDENT());
        return null;
    }
/*
    @Override
    public Object visitExpressionTypeAST(AlphaParser.ExpressionTypeASTContext ctx) {
        visit(ctx.typeLiteral());
        return null;
    }
*/
    @Override
    public Object visitTypeDenoterStringAST(AlphaParser.TypeDenoterStringASTContext ctx) {
        return null;
    }

    @Override
    public Object visitTypeDenoterBooleanAST(AlphaParser.TypeDenoterBooleanASTContext ctx) {
        return null;
    }

    @Override
    public Object visitTypeDenoterIntAST(AlphaParser.TypeDenoterIntASTContext ctx) {
        return null;
    }
}
