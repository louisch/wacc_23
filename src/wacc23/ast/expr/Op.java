package wacc23.ast.expr;

public enum Op {
//    General Ops:
    // Add:
    PLUS,
    MINUS,

//    Binary Ops:
    // Mult:
    MULT,
    DIV,
    MOD,

    // GT:
    GT,
    GTE,
    LT,
    LTE,

    // EQ:
    EQ,
    NEQ,

    // AND:
    AND,
    OR,

//    Unary Ops
    NOT,
    LEN,
    ORD,
    CHR;
}