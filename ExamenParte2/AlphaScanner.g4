lexer grammar AlphaScanner;

//Simbolos
PyCOMA      : ';';
DOSPUNTOS   : ':';
ASIGN       : ':=';
PIZQ        : '(';
PDER        : ')';
VIR         : '~';

//-------------------------------------------------------------------------------------------------------------------
// comparision
LE      : '<=';
GE      : '>=';
EQUAL   : '=';
NOT_EQUAL : '!=';
GT      : '>';
LT      : '<';
AND     : '&';
OR     : '|';

//-------------------------------------------------------------------------------------------------------------------
//Operadores
SUMA        : '+';
RESTA       : '-';
MULT        : '*';
DIV         : '/';

//-------------------------------------------------------------------------------------------------------------------
//Palabras Reservadas
FN      : 'fn';
IF      : 'if';
THEN    : 'then';
ELSE    : 'else';
WHILE   : 'while';
DO      : 'do';
LET     : 'let';
IN      : 'in';
BEGIN   : 'begin';
END     : 'end';
CONST   : 'const';
VAR     : 'var';
RETURN  : 'return';


//-------------------------------------------------------------------------------------------------------------------
// Funtions
LEN     : 'len';
FIRST   : 'first';
LAST    : 'last';
REST    : 'rest';
PUSH    : 'push';
PUTS    : 'puts';


//-------------------------------------------------------------------------------------------------------------------
// Types
BOOLEAN : 'boolean';
INT     : 'int';
STR     : 'string';
TRUE    : 'true';
FALSE   : 'false';
INTEGER : [0-9]([0-9])*;
STRING  : '"' (~["])* '"';
IDENT   : [a-zA-Z]([a-zA-Z]|[0-9]|'_')*;

//-------------------------------------------------------------------------------------------------------------------
// Skiped
WS              : [ \r\t\n]+                                        -> skip ;
SINGLE_COMMENT  : '//' ~[\r\n]* '\r'? '\n'                          -> skip ;
BLOCK_COMMENT   : '/*' (.|BLOCK_COMMENT|SINGLE_COMMENT)* '*/'       -> skip ;