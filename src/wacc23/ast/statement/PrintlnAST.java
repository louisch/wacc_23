package wacc23.ast.statement;

import wacc23.ast.expr.ExprAST;

/**
 * Created by Anton A.
 */
public class PrintlnAST extends StatementAST {

    private final ExprAST expr;

    public PrintlnAST(ExprAST expr) {
        this.expr = expr;
    }
}
