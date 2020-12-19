package code_generation;

import generated.AlphaParser;
import generated.AlphaParserBaseVisitor;


import java.io.FileWriter;
import java.util.LinkedList;

public class CodeGenerator extends AlphaParserBaseVisitor {
    private int letmain;
    private int indice;
    private LinkedList<String> codigo;
    private TablaSimbolos tablaIDS;
    private int type;

    public CodeGenerator() {
        this.letmain=-1;
        this.indice=0;
        this.codigo= new LinkedList<String>();
        this.tablaIDS = new TablaSimbolos();
        this.type = -1;
    }

    private void generar(int indice, String instr, Object param){
        if (param!=null)
            this.codigo.add(indice + " " + instr + " " + param);
        else
            this.codigo.add(indice + " " + instr);
        this.indice++;
    }

    @Override
    public Object visitProgramAST(AlphaParser.ProgramASTContext ctx) {
        //this.generar(this.indice,"DEF Main", null);
        visit(ctx.singleCommand());
        //this.generar(this.indice,"END",null);
        System.out.println(this.toString());
        return null;

    }

    @Override
    public Object visitReturnSingleCommandAST(AlphaParser.ReturnSingleCommandASTContext ctx) {
        visit(ctx.expression());
        this.generar(this.indice,"RETURN_VALUE",null);
        return null;
    }

    @Override
    public Object visitFormalParamListAST(AlphaParser.FormalParamListASTContext ctx) {
        for(int i=0; i <= ctx.IDENT().size()-1; i++) {
            this.tablaIDS.insertar(ctx.IDENT(i).getSymbol(),0,null);
            this.generar(this.indice,"PUSH_LOCAL",ctx.IDENT(i).getText());
        }
        return null;
    }

    @Override
    public Object visitActualParamListAST(AlphaParser.ActualParamListASTContext ctx) {
        for(int i=0; i <= ctx.expression().size()-1; i++) {
            visit(ctx.expression(i));
        }
        return ctx.expression().size();
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
        visit(ctx.expression());
        String name= ( String ) visit(ctx.ident());
        this.generar(this.indice,"STORE_FAST",name);
/*        if(((TablaSimbolos.Ident) this.tablaIDS.buscar(name)).getNivel() == 0)
            this.generar(this.indice,"STORE_GLOBAL",name);
        else
            this.generar(this.indice,"STORE_FAST",name);
*/
        return null;
    }

    @Override
    public Object visitCallSingleCommandAST(AlphaParser.CallSingleCommandASTContext ctx) {
        if (ctx.expression()==null) {
            this.generar(this.indice, "LOAD_GLOBAL", visit(ctx.ident()));
            this.generar(this.indice, "CALL_FUNCTION", 0);
        }
        else {
            visit(ctx.expression());
            String methodName= ( String ) visit(ctx.ident());
            if (methodName.equals("print"))
                this.generar(this.indice, "LOAD_GLOBAL", "write");
            else
                this.generar(this.indice, "LOAD_GLOBAL", methodName);
            this.generar(this.indice, "CALL_FUNCTION", 1);
        }
        return null;
    }

    @Override
    public Object visitIfSingleCommandAST(AlphaParser.IfSingleCommandASTContext ctx) {
        //if
        visit(ctx.expression());
        int tag1Index = this.indice;
        this.generar(this.indice,"JUMP_IF_FALSE",-1);

        //then
        visit(ctx.singleCommand(0));
        int tag2Index = this.indice;
        this.generar(this.indice,"JUMP_ABSOLUTE",-1);
        this.codigo.set(tag1Index, tag1Index+" "+"JUMP_IF_FALSE"+ " "+this.indice);

        //else
        visit(ctx.singleCommand(1));
        this.codigo.set(tag2Index, tag2Index+" "+"JUMP_ABSOLUTE"+ " "+this.indice);

        return null;
    }

    @Override
    public Object visitWhileSingleCommandAST(AlphaParser.WhileSingleCommandASTContext ctx) {
        int tag1Index = this.indice;
        this.generar(this.indice,"JUMP_ABSOLUTE",-1);
        int tag2Index = this.indice;
        visit(ctx.singleCommand());
        this.codigo.set(tag1Index, tag2Index+" "+"JUMP_ABSOLUTE"+ " "+this.indice);
        visit(ctx.expression());
        this.generar(this.indice,"JUMP_IF_TRUE",tag2Index);

        return null;
    }

    @Override
    public Object visitLetSingleCommandAST(AlphaParser.LetSingleCommandASTContext ctx) {
        this.letmain++;
        this.tablaIDS.openScope();
        visit(ctx.declaration());
        if (this.letmain==0) {
            this.generar(this.indice,"DEF","Main");
            visit(ctx.singleCommand());
            this.generar(this.indice,"END",null);
        }
        else{
            visit(ctx.singleCommand());
        }

        this.letmain--;
        this.tablaIDS.closeScope();
        return null;
    }

    @Override
    public Object visitBlockSingleCommandAST(AlphaParser.BlockSingleCommandASTContext ctx) {
        return super.visitBlockSingleCommandAST(ctx);
    }

    @Override
    public Object visitDeclarationAST(AlphaParser.DeclarationASTContext ctx) {
        return super.visitDeclarationAST(ctx);
    }

    @Override
    public Object visitConstSingleDeclarationAST(AlphaParser.ConstSingleDeclarationASTContext ctx) {
        visit(ctx.expression());
        this.generar(this.indice,"LOAD_CONST", ctx.IDENT().getText());
        return null;
    }

    @Override
    public Object visitVarSingleDeclarationAST(AlphaParser.VarSingleDeclarationASTContext ctx) {
        visit(ctx.typeDenoter());
        this.tablaIDS.insertar(ctx.IDENT().getSymbol(),type,ctx);
        if (this.letmain==0)
            this.generar(this.indice,"PUSH_GLOBAL",ctx.IDENT().getText());
        else
            this.generar(this.indice,"PUSH_LOCAL",ctx.IDENT().getText());

        return null;
    }

    @Override
    public Object visitMethodSingleDeclarationAST(AlphaParser.MethodSingleDeclarationASTContext ctx) {
        visit(ctx.methodDeclaration());
        return null;
    }

    @Override
    public Object visitMethodDeclararionAST(AlphaParser.MethodDeclararionASTContext ctx) {
        this.generar(this.indice,"DEF",visit(ctx.ident()));
        this.tablaIDS.openScope();
        visit(ctx.formalParamList());
        visit(ctx.singleCommand());
        this.generar(this.indice,"RETURN",null);
        this.tablaIDS.closeScope();
        return null;
    }


    @Override
    public Object visitTypeDenoterIdentAST(AlphaParser.TypeDenoterIdentASTContext ctx) {
        visit(ctx.typeLiteral());
        return null;
    }

    @Override
    public Object visitExpressionComparationAST(AlphaParser.ExpressionComparationASTContext ctx) {
        for (int i = 0; i < ctx.primaryExpression().size(); i++) {
            visit(ctx.primaryExpression(i));
            if(i < ctx.primaryExpression().size()-1){
                visit(ctx.comparation(i));
            }
        }
        return null;
    }


    @Override
    public Object visitExpressionOperatorAST(AlphaParser.ExpressionOperatorASTContext ctx) {
        visit(ctx.primaryExpression(0));
        int i;
        for(i=1; i <= ctx.primaryExpression().size()-1; i++) {
            visit(ctx.primaryExpression(i));
            this.generar(this.indice,"BINARY_ADD",null);
        }
        return null;
    }

    @Override
    public Object visitNumPrimaryExpressionAST(AlphaParser.NumPrimaryExpressionASTContext ctx) {
        this.generar(this.indice,"LOAD_CONST",ctx.INTEGER().getText());
        return null;
    }

    @Override
    public Object visitIdPrimaryExpressionAST(AlphaParser.IdPrimaryExpressionASTContext ctx) {
        String name= ( String ) visit(ctx.ident());
        this.generar(this.indice,"LOAD_FAST",name);
/*
        if(((TablaSimbolos.Ident) this.tablaIDS.buscar(name)).getNivel() == 0){
            this.generar(this.indice,"LOAD_GLOBAL",name);
        }else{
            this.generar(this.indice,"LOAD_FAST",name);
        }
*/

        return null;
    }

    @Override
    public Object visitCallPrimaryExpression(AlphaParser.CallPrimaryExpressionContext ctx) {
        int cantParams = (int) visit(ctx.actualParamList());
        this.generar(this.indice, "LOAD_GLOBAL", visit(ctx.ident()));
        this.generar(this.indice, "CALL_FUNCTION", cantParams);
        return null;
    }

    @Override
    public Object visitGroupPrimaryExpressionAST(AlphaParser.GroupPrimaryExpressionASTContext ctx) {
        visit(ctx.expression());
        return null;
    }

    @Override
    public Object visitSumaAST(AlphaParser.SumaASTContext ctx) {
        this.generar(this.indice,"BINARY_ADD", null);
        return null;
    }

    @Override
    public Object visitRestaAST(AlphaParser.RestaASTContext ctx) {
        this.generar(this.indice,"BINARY_SUBSTRACT", null);
        return null;
    }

    @Override
    public Object visitMultAST(AlphaParser.MultASTContext ctx) {
        this.generar(this.indice,"BINARY_MULTIPLY", null);
        return null;
    }

    @Override
    public Object visitDivAST(AlphaParser.DivASTContext ctx) {
        this.generar(this.indice,"BINARY_DIVIDE", null);
        return null;
    }

    @Override
    public Object visitMenorAST(AlphaParser.MenorASTContext ctx) {
        this.generar(this.indice,"COMPARE_OP", "<");
        return null;
    }

    @Override
    public Object visitMayorAST(AlphaParser.MayorASTContext ctx) {
        this.generar(this.indice,"COMPARE_OP", ">");
        return null;
    }

    @Override
    public Object visitMenorIgualAST(AlphaParser.MenorIgualASTContext ctx) {
        this.generar(this.indice,"COMPARE_OP", "<=");
        return null;
    }

    @Override
    public Object visitMayorIgualAST(AlphaParser.MayorIgualASTContext ctx) {
        this.generar(this.indice,"COMPARE_OP", ">=");
        return null;
    }

    @Override
    public Object visitIgualAST(AlphaParser.IgualASTContext ctx) {
        this.generar(this.indice,"COMPARE_OP", "=");
        return null;
    }

    @Override
    public Object visitDiferenteAST(AlphaParser.DiferenteASTContext ctx) {
        this.generar(this.indice,"COMPARE_OP", "!=");
        return null;
    }

    @Override
    public Object visitAndAST(AlphaParser.AndASTContext ctx) {
        this.generar(this.indice,"BINARY_AND",null);
        return null;
    }

    @Override
    public Object visitOrAST(AlphaParser.OrASTContext ctx) {
        this.generar(this.indice,"BINARY_OR",null);
        return null;
    }

    @Override
    public Object visitIdentAST(AlphaParser.IdentASTContext ctx) {
        return null;
    }

    @Override
    public Object visitTypeDenoterStringAST(AlphaParser.TypeDenoterStringASTContext ctx) {
        this.generar(this.indice,"LOAD_CONST", ctx.STR().getText());
        type = 0;
        return null;
    }

    @Override
    public Object visitTypeDenoterBooleanAST(AlphaParser.TypeDenoterBooleanASTContext ctx) {
        this.generar(this.indice,"LOAD_CONST", ctx.BOOLEAN().getText());
        type = 1;
        return null;
    }

    @Override
    public Object visitTypeDenoterIntAST(AlphaParser.TypeDenoterIntASTContext ctx) {
        this.generar(this.indice,"LOAD_CONST", ctx.INT().getText());
        type = 2;
        return null;
    }

    @Override
    public String toString() {
        String result="";
        for (String s : codigo){
            result+= s + '\n';
        }
        return result;
    }
}
