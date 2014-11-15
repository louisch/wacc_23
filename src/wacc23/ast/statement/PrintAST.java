package wacc23.ast.statement;

import wacc23.ast.expr.ExprAST;

/**
 * Created by Anton A.
 */
public class PrintAST extends StatementAST {

    private final ExprAST expr;

    public PrintAST(ExprAST expr) {
        this.expr = expr;
    }
}
