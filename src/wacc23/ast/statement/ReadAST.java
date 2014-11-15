package wacc23.ast.statement;

import wacc23.SemanticErrorException;
import wacc23.ast.AssignLhsAST;
import wacc23.ast.expr.ExprAST;

/**
 * Created by Anton A.
 */
public class ReadAST extends StatementAST {
    private final AssignLhsAST lhs;

    public ReadAST(AssignLhsAST lhs) {
        this.lhs = lhs;
    }

    @Override
    public void check() throws SemanticErrorException {
        lhs.check();
    }

    public AssignLhsAST getLhs() {
        return lhs;
    }
}
