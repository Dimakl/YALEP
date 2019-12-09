grammar LogicalExpression;

eval
    : expression EOF;

expression
    : expression XOR expression       #XOR
    | expression AND expression       #AND
    | expression OR expression        #OR
    | (NOT)* LPAREN expression RPAREN #PARENS
    | (NOT)* VARIABLE                 #VARIABLE
    ;

LPAREN
    : '('
    ;

RPAREN
    : ')'
    ;

NOT
    : '!'
    ;

AND
    : '&'
    ;

OR
    : '|'
    ;

XOR
    : '^'
    ;

VARIABLE
    : [A-Z]
    ;