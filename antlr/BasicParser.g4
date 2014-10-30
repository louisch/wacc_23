parser grammar BasicParser;

options {
  tokenVocab=BasicLexer;
}

program : BEGIN (func)* stat END ;

func : type IDENT OPEN_PARENTHESES (paramList)? CLOSED_PARENTHESES ;

paramList : param ( COMMA param )* ;

param : type IDENT ;

stat : SKIP
    | type IDENT ASSIGN assignRhs
    | assignLhs ASSIGN  assignLhs
    | READ assignLhs
    | FREE expr
    | RET expr
    | EXIT expr
    | PRINT expr
    | PRITNLN expr
    | IF expr THEN stat ELSE stat FI
    | WHILE expr DO stat DONE
    | BEGIN stat END
    | stat SEMICOLON stat

binaryOper : PLUS | MINUS | MULT | DIV | MOD
  | GT | GTE | LT | LTE | EQ | NEQ
  | AND | OR
  ;

unaryOper : NOT | NEG | LEN | ORD | CHR ;

pairElem : FST expr | SND expr ;

type : baseType | arrayType | pairType ;

baseType : INT | BOOL | CHAR | STRING ;

arrayType : type OPEN_BRACKET CLOSED_BRACKET ;

pairType : PAIR OPEN_PARENTHESES pairElemType COMMA pairElemType CLOSED_PARENTHESES ;

pairElemType : baseType | arrayType | PAIR ;

expr : expr binaryOper expr
  | INTEGER
  | OPEN_PARENTHESES expr CLOSED_PARENTHESES
  | BOOL
  | CHAR
  | STR
  | PAIR
  | IDENT
  | ARRAY_ELEMENT
  | unaryOper expr
  ;



// EOF indicates that the program must consume to the end of the input.
prog: (expr)*  EOF ;
