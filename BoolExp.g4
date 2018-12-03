grammar BoolExp;

parse
 : expression '=' BOOL EOF
 ;

expression
 : LPAREN expression RPAREN                       #parenExpression
 | NOT expression                                 #notExpression
 | left=expression op=binary right=expression     #binaryExpression
 | IDENTIFIER                                     #identifierExpression
 ;

binary
 : AND | OR
 ;


AND        : ('and' | 'AND' | '&') ;
OR         : ('or' | 'OR' | '|') ;
NOT        : ('not' | 'NOT' | '^');
LPAREN     : '(' ;
RPAREN     : ')' ;
IDENTIFIER : [A-Z] ;
BOOL       : [01] ;
WS         : [ \r\t\u000C\n]+ -> skip ;
