package wacc23.ast.assignRhs;

import wacc23.SemanticErrorException;
import wacc23.ast.expr.ExprAST;
import wacc23.ast.ExprsAST;
import wacc23.ast.expr.IdentAST;

import java.util.List;

/**
 * Created by Anton A.
 */
public class AssignCallAST extends AssignRhsAST {
    private final IdentAST ident;
    private final ExprsAST argList;

    public AssignCallAST(IdentAST ident, List<ExprAST> argList) {
        this.ident = ident;
        this.argList = new ExprsAST(argList);
    }

    @Override
    public void check() throws SemanticErrorException {
        argList.check();
    }

    public IdentAST getIdent() {
        return ident;
    }

    public List<ExprAST> getArgList() {
        return argList.getExprs();
    }
}
