lexer grammar AlphaScanner;
//symbols
PyCOMA  : ';' ;
ASSIGN  : ':=';
PIZQ    : '(';
PDER    : ')';
VIR     : '~';
DOSPUN  : ':';
SUM     : '+';
SUB     : '-';
MUL     : '*';
DIV     : '/';
LT      : '<';
GT      : '>';
EQUAL   : '=';
AND     : '&&';
OR      : '||';

//reserved words
IF      : 'if' ;
WHILE   : 'while' ;
LET     : 'let';
THEN    : 'then';
ELSE    : 'else';
IN      : 'in';
DO      : 'do';
BEGIN   : 'begin';
END     : 'end';
CONST   : 'const';
VAR     : 'var';
VOID    : 'void';
RETURN  : 'return';

TRUE    : 'true';
FALSE   : 'false';

// regular expresions
NUM     : [1-9][0-9]* | '0';
CHAR    : '\'' ([a-z]|[0-9]|' '|'!')? '\'';
IDENT   : [a-zA-Z]([a-zA-Z]|[0-9]|'_')*;
STRING  : '"' (~["])* '"';
BOOLEAN : (TRUE| FALSE);

// skiped
WS  :   [ \t\n\r]+ -> skip ;
LINECOMENT      :'//' ~[\r\n]* -> skip;         // Comentario de una línea
MULTILINECOMENT : '/*' .*? '*/' -> skip;        // Bloque de comentario