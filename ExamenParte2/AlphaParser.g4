parser grammar AlphaParser;

options {
  tokenVocab = AlphaScanner;
}

program
        : singleCommand                                             #programAST;
command : singleCommand (PyCOMA singleCommand)*                     #commandAST;
singleCommand
        :
        ident ASIGN expression                                      #assignSingleCommandAST
        | ident PIZQ expression? PDER                               #callSingleCommandAST
        | IF expression THEN singleCommand
                        ELSE singleCommand                          #ifSingleCommandAST
        | WHILE expression DO singleCommand                         #whileSingleCommandAST
        | LET declaration IN singleCommand                          #letSingleCommandAST
        | BEGIN command END                                         #blockSingleCommandAST
        | RETURN expression                                         #returnSingleCommandAST;
declaration  : singleDeclaration (PyCOMA singleDeclaration)*        #declarationAST;
singleDeclaration : CONST IDENT VIR expression                      #constSingleDeclarationAST
    	   | VAR IDENT DOSPUNTOS typeDenoter                        #varSingleDeclarationAST
    	   | methodDeclaration                                      #methodSingleDeclarationAST;
methodDeclaration : FN ident PIZQ formalParamList PDER DOSPUNTOS typeDenoter singleCommand                #methodDeclararionAST;
formalParamList : (IDENT DOSPUNTOS typeDenoter PyCOMA)*              #formalParamListAST;
typeDenoter : IDENT                                                 #typeDenoterAST;
expression : primaryExpression (operator primaryExpression)*        #expressionAST;
primaryExpression : LITERAL                                         #numPrimaryExpressionAST
        | ident                                                     #idPrimaryExpressionAST
        | ident PIZQ actualParamList PDER                           #callPrimaryExpression
        | PIZQ expression PDER                                      #groupPrimaryExpressionAST;
actualParamList : (expression PyCOMA)*                              #actualParamListAST;
operator : SUMA | RESTA | MULT | DIV                                #operatorAST;

ident
locals [SingleDeclarationContext decl = null]: IDENT                #identAST;
