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

// regular expresions
NUM : [1-9][0-9]* | '0';
CHAR : '\'' ([a-z]|[0-9]|' '|'!')? '\'';
IDENT : [a-z]([a-z]|[0-9])*;

// skiped
WS  :   [ \t\n\r]+ -> skip ;
LINECOMENT      :'//' ~[\r\n]* -> skip;         // Comentario de una línea
MULTILINECOMENT : '/*' .*? '*/' -> skip;        // Bloque de comentario