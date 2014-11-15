package wacc23.ast.statement;

import wacc23.ast.expr.ExprAST;

/**
 * Created by Anton A.
 */
public class PrintAST extends AbstractExprStatementAST {
    public PrintAST(ExprAST expr) {
        super(expr);
    }
}
