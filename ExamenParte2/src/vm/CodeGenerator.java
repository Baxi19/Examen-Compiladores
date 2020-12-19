package vm;

import context_analisys.IdentificationTable;
import generated.AlphaParser;
import generated.AlphaParserBaseVisitor;

import java.util.LinkedList;

public class CodeGenerator  extends AlphaParserBaseVisitor {
    private int letmain;
    private int indice;
    private LinkedList<String> codigo;
    private IdentificationTable table;
    private String currentMethod = "";
    public boolean inMethod = false;

    public CodeGenerator() {
        this.table = new IdentificationTable();
        this.letmain=-1;
        this.indice=0;
        this.codigo= new LinkedList<String>();
    }

    @Override
    public Object visitProgramAST(AlphaParser.ProgramASTContext ctx) {
        visit(ctx.singleCommand());
        System.out.println(this.toString());
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
        visit(ctx.expression());
        String name= (String) visit(ctx.ident());

        if(letmain == 0)
            this.generar(this.indice,"STORE_GLOBAL",name);
        else
            this.generar(this.indice,"STORE_FAST",name);

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
    public Object visitWhileSCAST(AlphaParser.WhileSCASTContext ctx) {
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
    public Object visitLetSCAST(AlphaParser.LetSCASTContext ctx) {
        this.letmain++;
        this.table.openScope();
        visit(ctx.declaration());
        if (this.letmain==0) {
            this.generar(this.indice,"DEF","Main");
            visit(ctx.declaration());
            this.generar(this.indice,"END",null);
        }
        else
            visit(ctx.command());
        this.letmain--;
        this.table.closeScope();
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
        this.generar(this.indice,"RETURN_VALUE",null);
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
        this.generar(this.indice,"LOAD_CONST",ctx.BOOLEAN().getText());
        return 3;
    }

    @Override
    public Object visitStringPEAST(AlphaParser.StringPEASTContext ctx) {
        //String
        this.generar(this.indice,"LOAD_CONST",ctx.STRING().getText());
        return 2;
    }

    @Override
    public Object visitNumPEAST(AlphaParser.NumPEASTContext ctx) {
        //num
        this.generar(this.indice,"LOAD_CONST",ctx.NUM().getText());
        return 0;
    }

    @Override
    public Object visitIdentPEAST(AlphaParser.IdentPEASTContext ctx) {
        String name= (String) visit(ctx.ident());

        if(letmain == 0)
            this.generar(this.indice,"LOAD_GLOBAL",name);
        else
            this.generar(this.indice,"LOAD_FAST",name);

        return null;
    }

    @Override
    public Object visitCharPEAST(AlphaParser.CharPEASTContext ctx) {
        this.generar(this.indice,"LOAD_CONST",ctx.CHAR().getText());
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
            this.generar(this.indice,"BINARY_MULTIPLY", null);
            operator = "*";
        }else if(ctx.DIV() != null){
            this.generar(this.indice,"BINARY_DIVIDE", null);
            operator = "/";
        }else if(ctx.SUM() != null){
            this.generar(this.indice,"BINARY_ADD",null);
            operator = "+";
        }else if(ctx.SUB() != null){
            this.generar(this.indice,"BINARY_SUBSTRACT", null);
            operator = "-";
        }else if(ctx.LT() != null){
            this.generar(this.indice,"COMPARE_OP", "<");
            operator = "<";
        }else if(ctx.GT() != null){
            this.generar(this.indice,"COMPARE_OP", ">");
            operator = ">";
        }else if(ctx.EQUAL() != null){
            this.generar(this.indice,"COMPARE_OP", "=");
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
