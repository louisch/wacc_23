parser grammar BasicParser;

options {
  tokenVocab=BasicLexer;
}

program : BEGIN (func)* stat END ;

func : type IDENT OPEN_PARENTHESES (paramList)? CLOSE_PARENTHESES ;

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
    | PRINTLN expr
    | IF expr THEN stat ELSE stat FI
    | WHILE expr DO stat DONE
    | BEGIN stat END
    | stat SEMICOLON stat
    ;

assignLhs : IDENT
    | arrayElem
    | pairElem
    ;

assignRhs : expr
    | arrayLiter
    | NEWPAIR OPEN_PARENTHESES expr COMMA expr CLOSE_PARENTHESES
    | pairElem
    | CALL IDENT OPEN_PARENTHESES (argList)? CLOSE_PARENTHESES
    ;

argList : expr (COMMA expr)* ;

pairElem : FST expr | SND expr ;

type : baseType | arrayType | pairType ;

baseType : INT | BOOL | CHAR | STRING ;

arrayType : baseType OPEN_BRACKET CLOSE_BRACKET ; // baseType should be type

pairType : PAIR OPEN_PARENTHESES pairElemType COMMA pairElemType CLOSE_PARENTHESES ;

pairElemType : baseType | arrayType | PAIR ;

expr : expr binaryOper expr
  | INT_LITER
  | OPEN_PARENTHESES expr CLOSE_PARENTHESES
  | BOOL_LITER
  | CHAR_LITER
  | STR_LITER
  | PAIR_LITER
  | IDENT
  | arrayElem
  | unaryOper expr
  ;

unaryOper : NOT | MINUS | LEN | ORD | CHR ;

binaryOper : PLUS | MINUS | MULT | DIV | MOD
  | GT | GTE | LT | LTE | EQ | NEQ
  | AND | OR
  ;

arrayElem : IDENT OPEN_BRACKET expr CLOSE_BRACKET ;

arrayLiter : OPEN_BRACKET (expr (COMMA expr)*)? CLOSE_BRACKET ;
