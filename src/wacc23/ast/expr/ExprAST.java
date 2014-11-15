package wacc23.ast.expr;

import wacc23.ast.AST;
import wacc23.type.Type;

public abstract class ExprAST extends AST {
    public abstract Type getType();
}