package wacc23.ast.statement;

import wacc23.ast.expr.ExprAST;

/**
 * Created by Anton A.
 */
public class FreeAST extends StatementAST {

    private final ExprAST expr;

    public FreeAST(ExprAST expr) {
        this.expr = expr;
    }
}
