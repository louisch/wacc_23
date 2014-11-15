package wacc23.ast.statement;

import wacc23.SemanticErrorException;
import wacc23.ast.expr.ExprAST;

/**
 * Created by Anton A.
 */
public class WhileAST extends AbstractExprStatementAST {
    private final StatementAST stat;

    public WhileAST(ExprAST e, StatementAST s) {
        super(e);
        this.stat = s;
    }

    @Override
    public void check() throws SemanticErrorException {
        super.check();
        stat.check();
    }

    public StatementAST getStat() {
        return stat;
    }
}
