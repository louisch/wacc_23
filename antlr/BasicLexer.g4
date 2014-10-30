lexer grammar BasicLexer;

// Binary operators
PLUS: '+' ;
MINUS: '-' ;
MULT: '*' ;
DIV: '/' ;
MOD: '%' ;
GT: '>' ;
GTE: '>=' ;
LT: '<' ;
LTE: '<=' ;
EQ: '==' ;
NEQ: '!=' ;
AND: '&&' ;
OR: '||' ;

// Brackets
OPEN_PARENTHESES : '(' ;
CLOSE_PARENTHESES : ')' ;

// Numbers
fragment DIGIT : '0'..'9' ;

INTEGER: DIGIT+ ;
