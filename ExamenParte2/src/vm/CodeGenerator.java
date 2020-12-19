package vm;

import generated.AlphaParser;
import generated.AlphaParserBaseVisitor;

public class CodeGenerator  extends AlphaParserBaseVisitor {

    public CodeGenerator() {
    }

    @Override
    public Object visitProgramAST(AlphaParser.ProgramASTContext ctx) {
        visit(ctx.singleCommand());
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
        return super.visitAssignSCAST(ctx);
    }

    @Override
    public Object visitCallSCAST(AlphaParser.CallSCASTContext ctx) {
        return super.visitCallSCAST(ctx);
    }

    @Override
    public Object visitIfSCAST(AlphaParser.IfSCASTContext ctx) {
        return super.visitIfSCAST(ctx);
    }

    @Override
    public Object visitWhileSCAST(AlphaParser.WhileSCASTContext ctx) {
        return super.visitWhileSCAST(ctx);
    }

    @Override
    public Object visitLetSCAST(AlphaParser.LetSCASTContext ctx) {
        return super.visitLetSCAST(ctx);
    }

    @Override
    public Object visitBeginSCAST(AlphaParser.BeginSCASTContext ctx) {
        return super.visitBeginSCAST(ctx);
    }

    @Override
    public Object visitReturnSCAST(AlphaParser.ReturnSCASTContext ctx) {
        return super.visitReturnSCAST(ctx);
    }

    @Override
    public Object visitActualParamAST(AlphaParser.ActualParamASTContext ctx) {
        return super.visitActualParamAST(ctx);
    }

    @Override
    public Object visitDeclarationAST(AlphaParser.DeclarationASTContext ctx) {
        return super.visitDeclarationAST(ctx);
    }

    @Override
    public Object visitConstSDeclAST(AlphaParser.ConstSDeclASTContext ctx) {
        return super.visitConstSDeclAST(ctx);
    }

    @Override
    public Object visitVarSDeclAST(AlphaParser.VarSDeclASTContext ctx) {
        return super.visitVarSDeclAST(ctx);
    }

    @Override
    public Object visitMethodSDeclAST(AlphaParser.MethodSDeclASTContext ctx) {
        return super.visitMethodSDeclAST(ctx);
    }

    @Override
    public Object visitVarDeclAST(AlphaParser.VarDeclASTContext ctx) {
        return super.visitVarDeclAST(ctx);
    }

    @Override
    public Object visitParamDeclsAST(AlphaParser.ParamDeclsASTContext ctx) {
        return super.visitParamDeclsAST(ctx);
    }

    @Override
    public Object visitTypeDenoterAST(AlphaParser.TypeDenoterASTContext ctx) {
        return super.visitTypeDenoterAST(ctx);
    }

    @Override
    public Object visitExpressionAST(AlphaParser.ExpressionASTContext ctx) {
        return super.visitExpressionAST(ctx);
    }

    @Override
    public Object visitBooleanPEAST(AlphaParser.BooleanPEASTContext ctx) {
        return super.visitBooleanPEAST(ctx);
    }

    @Override
    public Object visitStringPEAST(AlphaParser.StringPEASTContext ctx) {
        return super.visitStringPEAST(ctx);
    }

    @Override
    public Object visitNumPEAST(AlphaParser.NumPEASTContext ctx) {
        return super.visitNumPEAST(ctx);
    }

    @Override
    public Object visitIdentPEAST(AlphaParser.IdentPEASTContext ctx) {
        return super.visitIdentPEAST(ctx);
    }

    @Override
    public Object visitCharPEAST(AlphaParser.CharPEASTContext ctx) {
        return super.visitCharPEAST(ctx);
    }

    @Override
    public Object visitGroupPEAST(AlphaParser.GroupPEASTContext ctx) {
        return super.visitGroupPEAST(ctx);
    }

    @Override
    public Object visitOperator(AlphaParser.OperatorContext ctx) {
        return super.visitOperator(ctx);
    }

    @Override
    public Object visitIdentAST(AlphaParser.IdentASTContext ctx) {
        return super.visitIdentAST(ctx);
    }
}
