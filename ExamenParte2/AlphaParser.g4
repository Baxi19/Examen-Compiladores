parser grammar AlphaParser;

options {
    tokenVocab = AlphaScanner;
}


program             : singleCommand EOF                                              #programAST;

command             : singleCommand (PyCOMA singleCommand)*                          #commandAST;

singleCommand       : ident ASSIGN expression                                        #assignSCAST
                    | ident PIZQ actualParam? PDER                                   #callSCAST
                    | IF expression THEN singleCommand ELSE singleCommand            #ifSCAST
                    | WHILE expression DO singleCommand                              #whileSCAST
                    | LET declaration IN command                                     #letSCAST
                    | BEGIN command? END                                             #beginSCAST
                    | RETURN expression                                              #returnSCAST;

actualParam         : expression (PyCOMA expression)*                                #actualParamAST;

declaration         : singleDeclaration (PyCOMA singleDeclaration)*                  #declarationAST;

singleDeclaration   : CONST typedenoter IDENT VIR expression                         #constSDeclAST
    	            | varDeclaration                                                 #varSDeclAST
    	            | (typedenoter | VOID) IDENT PIZQ paramDecls? PDER singleCommand #methodSDeclAST;


varDeclaration      : VAR IDENT DOSPUN typedenoter                                  #varDeclAST;

paramDecls          : varDeclaration (PyCOMA varDeclaration)*                       #paramDeclsAST;

typedenoter         : IDENT                                                         #typeDenoterAST;

expression          : primaryExpression (operator primaryExpression)*               #expressionAST;

primaryExpression   : NUM                                                           #numPEAST
                    | ident                                                         #identPEAST
                    | CHAR                                                          #charPEAST
                    | PIZQ expression PDER                                          #groupPEAST;

operator            : SUM | SUB | MUL | DIV                                         #operatorAST;

ident
locals [VarDeclASTContext decl=null]
                    : IDENT                                                         #identAST;
