package context_analisys;

import context_analisys.IdentificationTable;
import generated.AlphaParser;
import generated.AlphaParserBaseVisitor;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.misc.Pair;
import java.util.ArrayList;

public class ContextAnalisys extends AlphaParserBaseVisitor {
    private IdentificationTable table;
    private ArrayList<String> errorsList;
    private String currentMethod = "";
    public boolean inMethod = false;

    public ContextAnalisys(){
        this.table = new IdentificationTable();
        this.errorsList = new ArrayList<>();
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
        Token identDeclared = (Token) visit(ctx.ident());
        int expression = (int) visit(ctx.expression());
        IdentificationTable.Ident ident = table.searchIdent(identDeclared.getText());
        if(ident != null){
            if(!ident.isConstant){
                if(ident.type == expression){
                    return true;

                }
                else{
                    String typeError = "Type Error in line: " + identDeclared.getLine() + ", column: " + identDeclared.getCharPositionInLine() + "" +
                            " - Data type assigned to variable '" + identDeclared.getText() + "'does not match the data type declared for it";
                    errorsList.add(typeError);
                }
            }
            else{
                String scopeError = "Scope Error in line: " + identDeclared.getLine() + ", column: " + identDeclared.getCharPositionInLine() + "" +
                        "- Identifier '" + identDeclared.getText() + "' is constant, value declared is not allowed to change.";
                errorsList.add(scopeError);
            }

        }
        else{
            String scopeError = "Scope Error in line: " + identDeclared.getLine() + ", column: " + identDeclared.getCharPositionInLine() + "" +
                    "- Identifier '" + identDeclared.getText() + "' has not been declared in current context.";
            errorsList.add(scopeError);
        }
        return false;
    }

    @Override
    public Object visitCallSCAST(AlphaParser.CallSCASTContext ctx) {
        Token md = (Token) visit(ctx.ident());
        IdentificationTable.MethodIdent methodIdent = table.searchMethodIdent(md.getText());
        if(methodIdent!= null){
            if(ctx.actualParam() != null){
                ArrayList<Integer> inputParameters =  (ArrayList<Integer>) visit(ctx.actualParam());
                if(inputParameters.size() == methodIdent.parameters.size()){
                    for(int i = 0; i < methodIdent.parameters.size(); i++){
                        if(methodIdent.parameters.get(i).a.equals(inputParameters.get(i))){
                            continue;
                        }
                        else{
                            String typeError = "Type Error in line: " + md.getLine() + ", column: " + md.getCharPositionInLine() + "" +
                                    " - data type provided in method call '"+ md.getText() + "' doesn't match with method data type declared for parameters";
                            errorsList.add(typeError);
                        }
                    }
                }
                else{
                    String scopeError = "Scope Error in line: " + md.getLine() + ", column: " + md.getCharPositionInLine() + "" +
                            " - number of input parameters in method call '"+ md.getText() + "'  does not match with number of parameters in method declaration";
                    errorsList.add(scopeError);
                }
            }
            else{
                if(methodIdent.parameters.size() != 0){
                    String scopeError = "Scope Error in line: " + md.getLine() + ", column: " + md.getCharPositionInLine() + "" +
                            " - number of input parameters in method call '"+ md.getText() + "' does not match with number of parameters in method declaration";
                    errorsList.add(scopeError);
                }
            }
        }
        else{
            String scopeError = "Scope Error in line: " + md.getLine() + ", column: " + md.getCharPositionInLine() + "" +
                    " - Method call for '" + md.getText() + "' is invalid. Method declaration not found.";
            errorsList.add(scopeError);
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
        table.openScope();
        visit(ctx.declaration());
        visit(ctx.command());
        table.closeScope();
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
        if(inMethod){
            int methodDataType = table.searchMethodIdent(currentMethod).type;
            int expressionType = (int) visit(ctx.expression());
            if(methodDataType == expressionType){
                return true;
            }
            String typeError = "Type Error in line: " + ctx.RETURN().getSymbol().getLine() + ", column: " + ctx.RETURN().getSymbol().getCharPositionInLine() + "" +
                    " - data type provided to return doesn't match with method data type declared";
            errorsList.add(typeError);
            return false;
        }
        else{
            visit(ctx.expression());
        }
        return null;
    }

    @Override
    public Object visitActualParamAST(AlphaParser.ActualParamASTContext ctx) {
        ArrayList<Integer> typeParameters = new ArrayList<>();
        for(int i = 0; i < ctx.expression().size(); i++){
            int typeExpression = (int) visit(ctx.expression().get(i));
            typeParameters.add(typeExpression);
        }
        return typeParameters;
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
        int typeConst = (int) visit(ctx.typedenoter());
        if(typeConst != -1){
            if(table.searchIdent(ctx.IDENT().getSymbol().getText()) == null){
                int typeExpression = (int) visit(ctx.expression());
                if(typeExpression == typeConst){
                    table.insertVarIdent(ctx.IDENT().getSymbol(), typeConst, true);
                }
                else{
                    String typeError = "Type Error in line: " + ctx.IDENT().getSymbol().getLine() + ", column: " + ctx.IDENT().getSymbol().getCharPositionInLine() + "" +
                            "- data type provided for constant '" + ctx.IDENT().getSymbol().getText() + "' does not match with data type declared for it.";
                    errorsList.add(typeError);
                }
            }
            else {
                String scopeError = "Scope Error in line: " + ctx.IDENT().getSymbol().getLine() + ", column: " + ctx.IDENT().getSymbol().getCharPositionInLine() + "" +
                        "- Identifier '" + ctx.IDENT().getSymbol().getText() + "' cant be declared in current context.";
                errorsList.add(scopeError);
            }
        }
        else{
            String typeError = "Type Error in line: " + ctx.IDENT().getSymbol().getLine() + ", column: " + ctx.IDENT().getSymbol().getCharPositionInLine() + "" +
                    "- data type for constant '" + ctx.IDENT().getSymbol().getText() + "' is not recognized.";
            errorsList.add(typeError);
        }
        return null;
    }

    @Override
    public Object visitVarSDeclAST(AlphaParser.VarSDeclASTContext ctx) {
        visit(ctx.varDeclaration());
        return null;
    }

    @Override
    public Object visitMethodSDeclAST(AlphaParser.MethodSDeclASTContext ctx) {
        String currentMethodSaved = currentMethod;
        inMethod = true;
        currentMethod = ctx.IDENT().getText();
        ArrayList<Pair<Integer,String>> parameters = new ArrayList<>();
        if(ctx.paramDecls() != null){
            parameters = (ArrayList<Pair<Integer,String>>) visit(ctx.paramDecls());
        }
        if(table.searchMethodIdent(ctx.IDENT().getText()) == null) {
            if(ctx.VOID() != null){
                table.insertMethodIdent(ctx.IDENT().getSymbol(),ctx.IDENT().getSymbol().getText(),3,parameters);
                visit(ctx.singleCommand());
            }
            else {
                var dataType = (int) visit(ctx.typedenoter());
                if(dataType != -1){
                    table.insertMethodIdent(ctx.IDENT().getSymbol(),ctx.IDENT().getSymbol().getText(),dataType,parameters);
                    visit(ctx.singleCommand());
                }
                else{
                    String typeError = "Type Error in line: " + ctx.IDENT().getSymbol().getLine() + ", column: " + ctx.IDENT().getSymbol().getCharPositionInLine() + "" +
                            "- data type for method '" + ctx.IDENT().getSymbol().getText() + "' is not recognized.";
                    errorsList.add(typeError);
                }
            }
        }
        else{
            String scopeError = "Scope Error in line: " + ctx.IDENT().getSymbol().getLine() + ", column: " + ctx.IDENT().getSymbol().getCharPositionInLine() + "" +
                    "- Identifier for method '" + ctx.IDENT().getSymbol().getText() + "' is already used in current context.";
            errorsList.add(scopeError);
        }
        currentMethod = currentMethodSaved;
        inMethod = false;
        return null;
    }

    @Override
    public Object visitVarDeclAST(AlphaParser.VarDeclASTContext ctx) {
        int typeVar = (int) visit(ctx.typedenoter());
        if(typeVar != -1){
            if(table.searchIdent(ctx.IDENT().getSymbol().getText()) == null){
                return table.insertVarIdent(ctx.IDENT().getSymbol(), typeVar, false);
            }
            else {
                String scopeError = "Scope Error in line: " + ctx.IDENT().getSymbol().getLine() + ", column: " + ctx.IDENT().getSymbol().getCharPositionInLine() + "" +
                        "- Identifier '" + ctx.IDENT().getSymbol().getText() + "' cant be declared in current context.";
                errorsList.add(scopeError);
            }
        }
        else{
            String typeError = "Type Error in line: " + ctx.IDENT().getSymbol().getLine() + ", column: " + ctx.IDENT().getSymbol().getCharPositionInLine() + "" +
                    "- data type for variable '" + ctx.IDENT().getSymbol().getText() + "' is not recognized.";
            errorsList.add(typeError);
        }
        return null;
    }

    @Override
    public Object visitParamDeclsAST(AlphaParser.ParamDeclsASTContext ctx) {
        var parametersFinal = new ArrayList<Pair<Integer, String>>();
        for (int i = 0; i < ctx.varDeclaration().size();i++)
        {
            var id = (IdentificationTable.Ident) visit(ctx.varDeclaration().get(i));
            if(id != null){
                var parameter = new Pair<Integer,String>(id.type,id.tok.getText());
                parametersFinal.add(parameter);
            }
        }
        return parametersFinal;
    }

    @Override
    public Object visitTypeDenoterAST(AlphaParser.TypeDenoterASTContext ctx) {
        if(ctx.IDENT().getSymbol().getText().equals(("int"))){
            return 0;
        }
        else if(ctx.IDENT().getText().equals("char")){
            return 1;
        }
        return -1;
    }

    @Override
    public Object visitExpressionAST(AlphaParser.ExpressionASTContext ctx) {
        int typeExpression = (int) visit(ctx.primaryExpression().get(0));
        if(typeExpression == 0){
            for(int i = 1; i < ctx.primaryExpression().size(); i++){
                int typeExpressionX = (int) visit(ctx.primaryExpression().get(i));
                if(typeExpressionX != 0){
                    String typeError = "Type Error: cant operate different data type than 'int'";
                    errorsList.add(typeError);
                    return -1;
                }
            }
        }
        else if(typeExpression == 1){
            if(ctx.primaryExpression().size() > 1){
                String typeError = "Type Error: Can't operate char data type";
                errorsList.add(typeError);
            }
        }
        return typeExpression;
    }

    @Override
    public Object visitIdentPEAST(AlphaParser.IdentPEASTContext ctx) {
        var inputIdentExpression = (Token) visit(ctx.ident());
        IdentificationTable.Ident ident = table.searchIdent(inputIdentExpression.getText());
        if( ident != null){
            return ident.type; // Retorna el tipo de dato con el que se declaró la variable/constante
        }
        String typeError = "Scope Error: in line "+ inputIdentExpression.getLine() + ", column: "+ inputIdentExpression.getCharPositionInLine() + " " +
                "- Cant't find expression '"+ inputIdentExpression.getText() + " to operate";
        errorsList.add(typeError);
        return -1;
    }

    @Override
    public Object visitNumPEAST(AlphaParser.NumPEASTContext ctx) {
        return 0;
    }

    @Override
    public Object visitCharPEAST(AlphaParser.CharPEASTContext ctx) {
        return 1;
    }

    @Override
    public Object visitGroupPEAST(AlphaParser.GroupPEASTContext ctx) {
        int typeExpression = (int) visit(ctx.expression());
        return typeExpression;
    }

    @Override
    public Object visitOperator(AlphaParser.OperatorContext ctx) {
        int operator;
        if(ctx.MUL() != null){
            operator = 1;
        }
        else if(ctx.DIV() != null){
            operator = 2;
        }
        else if(ctx.SUM() != null){
            operator = 3;
        }
        else { // sub
            operator = 4;
        }
        return operator;
    }

    @Override
    public Object visitIdentAST(AlphaParser.IdentASTContext ctx) {
        return ctx.IDENT().getSymbol();
    }

    public Boolean hasErrors(){
        if(errorsList.size() > 0){
            return true;
        }
        return false;
    }

    public void printErrors(){
        if(hasErrors()){
            for (String s : errorsList) System.out.println(s);
        }
        else{
            System.out.println("Context errors: 0");
        }
    }
}
