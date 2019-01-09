grammar LogExp;

eval
 : expression '=' BOOL EOF
 ;

expression
 : LPAREN expression RPAREN                       #parenExpression
 | not expression                                 #notExpression
 | left=expression op=binary right=expression     #binaryExpression
 | id=IDENTIFIER                                  #identifierExpression
 ;

binary
 : AND | OR
 ;

not
: NOT ;

AND        : '&' ;
OR         : '|' ;
NOT        : '^' ;
LPAREN     : '(' ;
RPAREN     : ')' ;
IDENTIFIER : [A-Z] ;
BOOL       : [01] ;
WS         : [ \r\t\u000C\n]+ -> skip ;