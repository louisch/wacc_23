package wacc23.ast.assignRhs;

import wacc23.SemanticErrorException;
import wacc23.ast.PairElemAST;

/**
 * Created by Anton A.
 */
public class AssignPairElemAST extends AssignRhsAST {
    private final PairElemAST pairElem;

    public AssignPairElemAST(PairElemAST pairElem) {
        this.pairElem = pairElem;
    }

    @Override
    public void check() throws SemanticErrorException {
        pairElem.check();
    }

    public PairElemAST getPairElem() {
        return pairElem;
    }
}
