package wacc23.ast.assignRhs;

import wacc23.SemanticErrorException;
import wacc23.ast.ExprAST;
import wacc23.ast.ExprsAST;

import java.util.List;

/**
 * Created by Anton A.
 */
public class AssignNewpairAST extends AssignRhsAST {
    private final ExprsAST exprs;

    public AssignNewpairAST(List<ExprAST> exprs) {
        this.exprs = new ExprsAST(exprs);
    }

    @Override
    public void check() throws SemanticErrorException {
        exprs.check();
    }

    public ExprAST getFst() {
        return exprs.getExpr(0);
    }

    public ExprAST getSnd() {
        return exprs.getExpr(1);
    }
}
