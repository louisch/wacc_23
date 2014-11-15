package wacc23.ast.statement;

import wacc23.ast.expr.ExprAST;

/**
 * Created by Anton A.
 */
public class ReturnAST extends AbstractExprStatementAST {
    public ReturnAST(ExprAST expr) {
        super(expr);
    }
}
