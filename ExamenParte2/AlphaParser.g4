parser grammar AlphaParser;

options {
  tokenVocab = AlphaScanner;
}

program         : singleCommand                                                                                         #programAST;

command         : singleCommand (PyCOMA singleCommand)*                                                                 #commandAST;

singleCommand   :ident ASIGN expression                                                                                 #assignSingleCommandAST
                | ident PIZQ expression? PDER                                                                           #callSingleCommandAST
                | IF expression THEN singleCommand ELSE singleCommand                                                   #ifSingleCommandAST
                | WHILE expression DO singleCommand                                                                     #whileSingleCommandAST
                | LET declaration IN singleCommand                                                                      #letSingleCommandAST
                | BEGIN command END                                                                                     #blockSingleCommandAST
                | RETURN expression                                                                                     #returnSingleCommandAST;

declaration     : singleDeclaration (PyCOMA singleDeclaration)*                                                         #declarationAST;

singleDeclaration: CONST IDENT VIR expression                                                                           #constSingleDeclarationAST
    	        | VAR IDENT DOSPUNTOS typeDenoter                                                                       #varSingleDeclarationAST
    	        | methodDeclaration                                                                                     #methodSingleDeclarationAST;

methodDeclaration: FN ident PIZQ formalParamList PDER DOSPUNTOS typeDenoter singleCommand                               #methodDeclararionAST;

formalParamList : (IDENT DOSPUNTOS typeDenoter PyCOMA)*                                                                 #formalParamListAST;

typeDenoter     : IDENT                                                                                                 #typeDenoterAST;

expression      : primaryExpression (comparation primaryExpression)*                                                    #expressionComparationAST
                | primaryExpression (operator primaryExpression)*                                                       #expressionOperatorAST;

primaryExpression: INTEGER                                                                                              #numPrimaryExpressionAST
                | ident                                                                                                 #idPrimaryExpressionAST
                | ident PIZQ actualParamList PDER                                                                       #callPrimaryExpression
                | PIZQ expression PDER                                                                                  #groupPrimaryExpressionAST;

actualParamList : (expression PyCOMA)*                                                                                  #actualParamListAST;

operator        : SUMA                                                                                                  #sumaAST
                | RESTA                                                                                                 #restaAST
                | MULT                                                                                                  #multAST
                | DIV                                                                                                   #divAST;

comparation     : LT                                                                                                    #menorAST
                | GT                                                                                                    #mayorAST
                | LE                                                                                                    #menorIgualAST
                | GE                                                                                                    #mayorIgualAST
                | EQUAL                                                                                                 #igualAST
                | NOT_EQUAL                                                                                             #diferenteAST
                | AND                                                                                                   #andAST
                | OR                                                                                                    #orAST;

ident
locals [SingleDeclarationContext decl = null]: IDENT                                                                    #identAST;
