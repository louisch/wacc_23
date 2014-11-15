package wacc23.ast.statement;

import wacc23.ast.expr.ExprAST;

/**
 * Created by Anton A.
 */
public class PrintlnAST extends AbstractExprStatementAST {
    public PrintlnAST(ExprAST expr) {
        super(expr);
    }
}
