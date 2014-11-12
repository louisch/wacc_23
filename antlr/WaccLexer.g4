lexer grammar WaccLexer;

// Binary Operators
fragment PLUS : '+' ; // also unary plus
fragment MINUS : '-' ; // also the unary minus
fragment MULT : '*' ;
fragment DIV : '/' ;
fragment MOD : '%' ;
fragment GT : '>' ;
fragment GTE : '>=' ;
fragment LT : '<' ;
fragment LTE : '<=' ;
fragment EQ : '==' ;
fragment NEQ : '!=' ;
fragment AND : '&&' ;
fragment OR : '||' ;
// Grouped
BINARY_OPER_MULT :  MULT | DIV | MOD ;
BINARY_OPER_ADD : PLUS | MINUS ;
BINARY_OPER_GT : GT | GTE | LT | LTE ;
BINARY_OPER_EQ : EQ | NEQ ;
BINARY_OPER_AND : AND | OR ;
// Pure Unary OP
fragment NOT : '!' ;
fragment LEN : 'len' ;
fragment ORD : 'ord' ;
fragment CHR : 'chr' ;
// Grouped
UNARY_OPER : NOT | PLUS | MINUS | LEN | ORD | CHR ;

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


INT_LITER : DIGIT+ ;
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
