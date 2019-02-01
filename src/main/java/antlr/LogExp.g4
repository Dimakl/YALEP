grammar LogExp;

eval
 : expression '=' BOOL EOF
 ;

expression
 : NOT expression                                 #notExpression
 | left=expression op=binary right=expression     #binaryExpression
 | id=IDENTIFIER                                  #identifierExpression
 | LPAREN expression RPAREN                       #parenExpression
 ;

binary
 : AND | OR
 ;

AND        : '&' ;
OR         : '|' ;
NOT        : '^' ;
LPAREN     : '(' ;
RPAREN     : ')' ;
IDENTIFIER : [A-Z] ;
BOOL       : [01] ;
WS         : [ \r\t\u000C\n]+ -> skip ;