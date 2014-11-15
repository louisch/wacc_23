package wacc23.ast;

import wacc23.ast.expr.ExprAST;

public class ReturnAST extends AST {

    private final ExprAST expr;

    public ReturnAST(ExprAST expr) {
        this.expr = expr;
    }
}
