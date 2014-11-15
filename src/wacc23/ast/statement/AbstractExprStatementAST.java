package wacc23.ast.statement;

import wacc23.SemanticErrorException;
import wacc23.ast.expr.ExprAST;
import wacc23.ast.statement.StatementAST;

/**
 * Created by Anton A.
 */
public abstract class AbstractExprStatementAST extends StatementAST {
    private final ExprAST expr;

    public AbstractExprStatementAST(ExprAST expr) {
        this.expr = expr;
    }

    @Override
    public void check() throws SemanticErrorException {
        expr.check();
    }

    public ExprAST getExpr() {
        return expr;
    }
}
