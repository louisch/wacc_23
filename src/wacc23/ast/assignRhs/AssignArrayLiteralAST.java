package wacc23.ast.assignRhs;

import wacc23.SemanticErrorException;
import wacc23.ast.expr.ExprAST;
import wacc23.ast.ExprsAST;

import java.util.List;

/**
 * Created by Anton A.
 */
public class AssignArrayLiteralAST extends AssignRhsAST {
    private final ExprsAST arrayL;

    public AssignArrayLiteralAST(List<ExprAST> arrayL) {
        this.arrayL = new ExprsAST(arrayL);
    }

    @Override
    public void check() throws SemanticErrorException {
        arrayL.check();
    }

    public List<ExprAST> getArrayL() {
        return arrayL.getExprs();
    }
}
