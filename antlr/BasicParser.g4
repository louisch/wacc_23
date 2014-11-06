parser grammar BasicParser;

options {
  tokenVocab=BasicLexer;
}

program : BEGIN (func)* stat END ;

func : type IDENT OPEN_PARENTHESES (paramList)? CLOSE_PARENTHESES ;

paramList : param ( COMMA param )* ;

param : type IDENT ;

stat : SKIP  # skip
  | type IDENT ASSIGN assignRhs  # declaration
  | assignLhs ASSIGN  assignRhs  # assignment
  | READ assignLhs  # read
  | FREE expr  # free
  | RET expr  # ret
  | EXIT expr  # exit
  | PRINT expr  # print
  | PRINTLN expr  # println
  | IF expr THEN stat ELSE stat FI  # if
  | WHILE expr DO stat DONE  # while
  | BEGIN stat END  # block
  | stat SEMICOLON stat  # stats
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

arrayType : baseType OPEN_BRACKET CLOSE_BRACKET
          | arrayType OPEN_BRACKET CLOSE_BRACKET
          | pairType OPEN_BRACKET CLOSE_BRACKET
          ;

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
