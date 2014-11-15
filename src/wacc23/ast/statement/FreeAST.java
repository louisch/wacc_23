package wacc23.ast.statement;

import wacc23.SemanticErrorException;
import wacc23.ast.expr.ExprAST;

public class FreeAST extends StatementAST {

    private final ExprAST expr;

    public FreeAST(ExprAST expr) {
        this.expr = expr;
    }

    @Override
    public void check()
            throws SemanticErrorException {
        super.check();
    }
}
