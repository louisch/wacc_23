package wacc23.ast;

import wacc23.ast.type.TypeAST;

public abstract class ExprAST extends AST {
    // should this extend TypeAST instead?
    // Anton: no, expressions are not types.
    public abstract TypeAST getType();
}