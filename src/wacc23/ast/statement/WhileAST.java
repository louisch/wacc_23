package wacc23.ast.statement;

import wacc23.SemanticErrorException;
import wacc23.ast.expr.ExprAST;

/**
 * Created by Anton A.
 */
public class WhileAST extends StatementAST {

    private final ExprAST expr;

    private final StatementAST stat;

    public WhileAST(ExprAST expr, StatementAST s) {
        this.expr = expr;
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
