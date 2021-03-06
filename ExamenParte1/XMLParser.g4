//-------------------------------------------------------------------------------------------------------------------
//                                    Parser
//-------------------------------------------------------------------------------------------------------------------
parser grammar XMLParser;

options {
    tokenVocab = XMLScanner;
}

//-------------------------------------------------------------------------------------------------------------------
//                               Grammar for XML Language
//-------------------------------------------------------------------------------------------------------------------

program         :   definition? omited* element omited*                                                                 #program_AST;

definition      :   DECLARATION attribute* SPECIAL_CLOSE                                                                #definition_AST;

content         :   chardata? ((element | reference | CDATA | PI | COMMENT) chardata?)*                                 #content_AST;

element         :   '<' NAME attribute* '>' content '<' '/' NAME '>'                                                    #element_content_AST
                |   '<' NAME attribute* '/>'                                                                            #element_without_content_AST;

reference       :   ENTITYREF | CHARREF                                                                                 #reference_AST;

attribute       :   NAME '=' STRING                                                                                     #attribute_AST;

chardata        :   TEXT | WS                                                                                           #chardata_AST;

omited          :   COMMENT | PI | WS                                                                                   #omited_AST;
