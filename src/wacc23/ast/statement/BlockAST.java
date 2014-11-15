package wacc23.ast.statement;

import wacc23.SemanticErrorException;

/**
 * Created by Anton A.
 */
public class BlockAST extends StatementAST {
    private final StatementAST stat;

    public BlockAST(StatementAST s) {
        this.stat = s;
    }

    @Override
    public void check() throws SemanticErrorException {
        stat.check();
    }

    public StatementAST getStat() {
        return stat;
    }
}
