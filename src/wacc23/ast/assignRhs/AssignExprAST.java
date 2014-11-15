package wacc23.ast.assignRhs;

import wacc23.SemanticErrorException;
import wacc23.ast.ExprAST;

/**
 * Created by Anton A.
 */
public class AssignExprAST extends AssignRhsAST {
    private final ExprAST expr;

    public AssignExprAST(ExprAST expr) {
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
