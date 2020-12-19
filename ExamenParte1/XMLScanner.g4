//-------------------------------------------------------------------------------------------------------------------
//                                      Lexer Rules
//-------------------------------------------------------------------------------------------------------------------
lexer grammar XMLScanner;


//-------------------------------------------------------------------------------------------------------------------
COMMENT     :   '<!--' .*? '-->' ;

CDATA       :   '<![CDATA[' .*? ']]>' ;

DTD         :   '<!' .*? '>'  -> skip ;

ENTITYREF   :   '&' NAME ';' ;

CHARREF     :   '&#' DIGIT+ ';'
            |   '&#x' HEXDIGIT+ ';' ;

WS      :   (' '|'\t'|'\r'? '\n')+ ;

OPEN        :   '<'                     -> pushMode(INSIDE) ;

DECLARATION :   '<?xml' SKIPED          -> pushMode(INSIDE) ;

SPECIAL_OPEN:   '<?' NAME               -> more, pushMode(PROC_INSTR) ;

TEXT        :   ~[<&]+ ;        // match any 16 bit char other than < and &

//-------------------------------------------------------------------------------------------------------------------
// Everything INSIDE of a tag
mode INSIDE;

CLOSE       :   '>'                     -> popMode ;

SPECIAL_CLOSE:  '?>'                    -> popMode ; // close <?xml...?>

SLASH_CLOSE :   '/>'                    -> popMode ;

SLASH       :   '/' ;

EQUALS      :   '=' ;

STRING      :   '"' ~[<"]* '"'
            |   '\'' ~[<']* '\''
            ;

NAME        :   NAMESTARTCHAR NAMECHAR* ;

SKIPED      :   [ \t\r\n] -> skip ;

//-------------------------------------------------------------------------------------------------------------------
// Fragments
fragment
HEXDIGIT    :   [a-fA-F0-9] ;

fragment
DIGIT       :   [0-9] ;

fragment
NAMECHAR    :   NAMESTARTCHAR
            |   '-' | '_' | '.' | DIGIT
            |   '\u00B7'
            |   '\u0300'..'\u036F'
            |   '\u203F'..'\u2040'
            ;

fragment
NAMESTARTCHAR
            :   [:a-zA-Z]
            |   '\u2070'..'\u218F'
            |   '\u2C00'..'\u2FEF'
            |   '\u3001'..'\uD7FF'
            |   '\uF900'..'\uFDCF'
            |   '\uFDF0'..'\uFFFD'
            ;

//-------------------------------------------------------------------------------------------------------------------
// Handle <? ... ?>
mode PROC_INSTR;

PI          :   '?>'                    -> popMode ; // close <?...?>

IGNORE      :   .                       -> more ;