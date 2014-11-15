package wacc23.ast.statement;

import wacc23.SemanticErrorException;

/**
 * Created by Anton A.
 */
public class SkipAST extends StatementAST {
    @Override
    public void check() throws SemanticErrorException {
        //do nothing
    }
}
