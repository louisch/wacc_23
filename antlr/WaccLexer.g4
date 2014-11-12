lexer grammar WaccLexer;

// Binary Operators
PLUS : '+' ;
MINUS : '-' ; // also the unary minus
MULT : '*' ;
DIV : '/' ;
MOD : '%' ;
GT : '>' ;
GTE : '>=' ;
LT : '<' ;
LTE : '<=' ;
EQ : '==' ;
NEQ : '!=' ;
AND : '&&' ;
OR : '||' ;
// Unary OP
NOT : '!' ;
LEN : 'len' ;
ORD : 'ord' ;
CHR : 'chr' ;

// scope statements
BEGIN : 'begin' ;
END : 'end' ;

// special
IS : 'is' ; // used in funcitons
ASSIGN : '=' ; // assignment operator
COMMA : ',' ;  // used in lists
CALL : 'call' ; // function call
NEWPAIR : 'newpair' ; // newpair declaration
FST : 'fst' ;
SND : 'snd' ;


// types
INT : 'int' ;
BOOL : 'bool' ;
CHAR : 'char' ;
PAIR : 'pair' ;
STRING : 'string' ;


// statement qualifiers
SKIP : 'skip' ;
READ : 'read' ;
FREE : 'free' ;
RET : 'return' ;
EXIT : 'exit' ;
PRINT : 'print' ;
PRINTLN : 'println' ;
// if
IF : 'if' ;
THEN : 'then' ;
ELSE : 'else' ;
FI : 'fi' ;
// while
WHILE : 'while' ;
DO : 'do' ;
DONE : 'done' ;
SEMICOLON : ';' ;


// Brackets
OPEN_PARENTHESES : '(' ;
CLOSE_PARENTHESES : ')' ;
OPEN_BRACKET : '[' ;
CLOSE_BRACKET : ']' ;


// integer stuffs
fragment DIGIT : [0-9] ;
fragment INT_SIGN : MINUS | PLUS ;

// char stuffs
fragment LOWER : [a-z] ;
fragment UPPER : [A-Z] ;
fragment UNDERSCORE : '_' ;
fragment ALPHA : UPPER | LOWER ;
fragment ALPHANUM : ALPHA | DIGIT ;
fragment ESC : [0btnfr"\'\\] ;
fragment CHARACTER : ( ~[\\\'"] | '\\' ESC ) ;

// boolean stuffs
fragment TRUE: 'true' ;
fragment FALSE: 'false' ;

// quotes marks
fragment SQUOTE : '\'' ;
fragment DQUOTE : '"' ;


INT_LITER : INT_SIGN? DIGIT+ ;
BOOL_LITER : TRUE | FALSE ;
CHAR_LITER : SQUOTE CHARACTER SQUOTE ;
STR_LITER : DQUOTE ( CHARACTER )* DQUOTE ;
PAIR_LITER : 'null';
IDENT : ( ALPHA | UNDERSCORE ) ( ALPHANUM | UNDERSCORE )* ;

// skipped tokens
COMMENT : '#' .*? '\n' -> skip ;
WS : [ \n\f]+ -> skip ;
/* note that neither \t or any other whitespace (e.g. \r)
 * are not taken into account here as they are not part of the spec
 */
