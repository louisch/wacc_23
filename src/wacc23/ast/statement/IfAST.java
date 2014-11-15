package wacc23.ast.statement;

import wacc23.SemanticErrorException;
import wacc23.ast.expr.ExprAST;

import java.util.List;

/**
 * Created by Anton A.
 */
public class IfAST extends AbstractExprStatementAST {
    private final List<StatementAST> stats;

    public IfAST(ExprAST expr, List<StatementAST> stats) {
        super(expr);
        this.stats = stats;
    }

    @Override
    public void check() throws SemanticErrorException {
        super.check();
        for (StatementAST s : stats) {
            s.check();
        }
    }

    public List<StatementAST> getStats() {
        return stats;
    }
}
