package vm;

import context_analisys.IdentificationTable;
import generated.AlphaParser;
import generated.AlphaParserBaseVisitor;

import java.util.ArrayList;
import java.util.LinkedList;

public class CodeGenerator  extends AlphaParserBaseVisitor {
    private int indice;
    private LinkedList<String> codigo;
    private IdentificationTable table;
    private String currentMethod = "";
    public boolean inMethod = false;

    public CodeGenerator() {
        this.table = new IdentificationTable();
        this.indice=0;
        this.codigo= new LinkedList<String>();
    }

    @Override
    public Object visitProgramAST(AlphaParser.ProgramASTContext ctx) {
        visit(ctx.singleCommand());
        //System.out.println(this.toString());
        return null;
    }

    @Override
    public Object visitCommandAST(AlphaParser.CommandASTContext ctx) {
        for(int i = 0;i < ctx.singleCommand().size();i++){
            visit(ctx.singleCommand().get(i));
        }
        return null;
    }

    @Override
    public Object visitAssignSCAST(AlphaParser.AssignSCASTContext ctx) {
        visit(ctx.ident());
        visit(ctx.expression());
        return null;
    }

    @Override
    public Object visitCallSCAST(AlphaParser.CallSCASTContext ctx) {
        visit(ctx.ident());
        if(ctx.actualParam() != null){
            visit(ctx.actualParam());
        }
        return null;
    }

    @Override
    public Object visitIfSCAST(AlphaParser.IfSCASTContext ctx) {
        visit(ctx.expression());
        for(int i = 0; i < ctx.singleCommand().size(); i++){
            visit(ctx.singleCommand().get(i));
        }
        return null;
    }

    @Override
    public Object visitWhileSCAST(AlphaParser.WhileSCASTContext ctx) {
        visit(ctx.expression());
        visit(ctx.singleCommand());
        return null;
    }

    @Override
    public Object visitLetSCAST(AlphaParser.LetSCASTContext ctx) {
        //table.openScope();
        visit(ctx.declaration());
        visit(ctx.command());
        //table.closeScope();
        return null;
    }

    @Override
    public Object visitBeginSCAST(AlphaParser.BeginSCASTContext ctx) {
        if(ctx.command() != null){
            visit(ctx.command());
        }
        return null;
    }

    @Override
    public Object visitReturnSCAST(AlphaParser.ReturnSCASTContext ctx) {
        visit(ctx.expression());
        //this.generar(this.indice,"RETURN_VALUE",null);
        return null;
    }

    @Override
    public Object visitActualParamAST(AlphaParser.ActualParamASTContext ctx) {
        //ArrayList<Integer> typeParameters = new ArrayList<>();
        for(int i = 0; i < ctx.expression().size(); i++){
            visit(ctx.expression().get(i));
            //int typeExpression = (int) visit(ctx.expression().get(i));
            //typeParameters.add(typeExpression);
        }

        return null;
    }

    @Override
    public Object visitDeclarationAST(AlphaParser.DeclarationASTContext ctx) {
        for(int i = 0; i < ctx.singleDeclaration().size(); i++){
            visit(ctx.singleDeclaration().get(i));
        }
        return null;
    }

    @Override
    public Object visitConstSDeclAST(AlphaParser.ConstSDeclASTContext ctx) {
        visit(ctx.typedenoter());
        visit(ctx.expression());
        return null;
    }

    @Override
    public Object visitVarSDeclAST(AlphaParser.VarSDeclASTContext ctx) {
        visit(ctx.varDeclaration());
        return null;
    }

    @Override
    public Object visitMethodSDeclAST(AlphaParser.MethodSDeclASTContext ctx) {
        if(ctx.typedenoter() != null){
            visit(ctx.typedenoter());
        }

        if(ctx.paramDecls() != null){
            visit(ctx.paramDecls());
        }

        visit(ctx.singleCommand());
        return null;
    }

    @Override
    public Object visitVarDeclAST(AlphaParser.VarDeclASTContext ctx) {
        visit(ctx.typedenoter());
        return null;
    }

    @Override
    public Object visitParamDeclsAST(AlphaParser.ParamDeclsASTContext ctx) {
        for (int i = 0; i < ctx.varDeclaration().size(); i++) {
            visit(ctx.varDeclaration(i));
        }
        return null;
    }

    @Override
    public Object visitTypeDenoterAST(AlphaParser.TypeDenoterASTContext ctx) {
        return null;
    }

    @Override
    public Object visitExpressionAST(AlphaParser.ExpressionASTContext ctx) {
        for (int i = 0; i < ctx.primaryExpression().size(); i++) {
            visit(ctx.primaryExpression(i));
            if(i != ctx.primaryExpression().size()-1){
                visit(ctx.operator(i));
            }
        }
        return null;
    }

    @Override
    public Object visitBooleanPEAST(AlphaParser.BooleanPEASTContext ctx) {
        //boolean
        return 3;
    }

    @Override
    public Object visitStringPEAST(AlphaParser.StringPEASTContext ctx) {
        //String
        return 2;
    }

    @Override
    public Object visitNumPEAST(AlphaParser.NumPEASTContext ctx) {
        //num
        return 0;
    }

    @Override
    public Object visitIdentPEAST(AlphaParser.IdentPEASTContext ctx) {

        return null;
    }

    @Override
    public Object visitCharPEAST(AlphaParser.CharPEASTContext ctx) {
        return 1;
    }

    @Override
    public Object visitGroupPEAST(AlphaParser.GroupPEASTContext ctx) {
        visit(ctx.expression());
        return null;
    }

    @Override
    public Object visitOperator(AlphaParser.OperatorContext ctx) {
        String operator = "";
        if(ctx.MUL() != null){
            operator = "*";
        }else if(ctx.DIV() != null){
            operator = "/";
        }else if(ctx.SUM() != null){
            operator = "+";
        }else if(ctx.SUB() != null){
            operator = "-";
        }else if(ctx.LT() != null){
            operator = "<";
        }else if(ctx.GT() != null){
            operator = ">";
        }else if(ctx.EQUAL() != null){
            operator = "=";
        }else if(ctx.AND() != null){
            operator = "&";
        }else if(ctx.OR() != null){
            operator = "|";
        }
        return operator;
    }

    @Override
    public Object visitIdentAST(AlphaParser.IdentASTContext ctx) {
        return null;
    }

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
}
