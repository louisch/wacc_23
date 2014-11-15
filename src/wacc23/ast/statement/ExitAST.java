package wacc23.ast.statement;

import wacc23.ast.expr.ExprAST;

public class ExitAST extends StatementAST {

    private final ExprAST expr;

    public ExitAST(ExprAST expr) {
        this.expr = expr;
    }
}
