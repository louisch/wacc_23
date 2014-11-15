package wacc23.ast.statement;

import wacc23.SemanticErrorException;
import wacc23.ast.expr.ExprAST;

import java.util.List;

public class IfAST extends StatementAST {

    private final ExprAST boolExpr;

    private final List<StatementAST> stats;

    public IfAST(ExprAST expr, List<StatementAST> stats) {
        this.boolExpr = expr;
        this.stats = stats;
    }

    @Override
    public void check()
            throws SemanticErrorException {
        for (StatementAST s : stats) {
            s.check();
        }
    }

    public List<StatementAST> getStats() {
        return stats;
    }
}
