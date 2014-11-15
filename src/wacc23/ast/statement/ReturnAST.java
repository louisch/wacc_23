package wacc23.ast.statement;

import wacc23.ast.expr.ExprAST;

/**
 * Created by Anton A.
 */
public class ReturnAST extends StatementAST {

    private final ExprAST expr;

    public ReturnAST(ExprAST expr) {
        this.expr = expr;
    }
}
