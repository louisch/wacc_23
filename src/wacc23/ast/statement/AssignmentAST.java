package wacc23.ast.statement;

import wacc23.SemanticErrorException;
import wacc23.ast.AssignLhsAST;
import wacc23.ast.assignRhs.AssignRhsAST;

public class AssignmentAST extends StatementAST {
    private final AssignLhsAST lhs;
    private final AssignRhsAST rhs;

    public AssignmentAST(AssignLhsAST lhs, AssignRhsAST rhs) {
        this.lhs = lhs;
        this.rhs = rhs;
    }

    @Override
    public void check()
            throws SemanticErrorException {
        if (!lhs.getType().equals(rhs.getType())) {
            throw new SemanticErrorException("LHS of assignment does not " +
                    "match type of RHS.");
        }
        lhs.check();
        rhs.check();
    }
}
