package wacc23.ast;

import wacc23.SemanticErrorException;

/**
 * Created by Anton A.
 */
public class PairElemAST extends AST {
    private final boolean isFirst;
    private final ExprAST expr;

    public PairElemAST(boolean isFirst, ExprAST expr) {
        this.isFirst = isFirst;
        this.expr = expr;
    }

    @Override
    public void check() throws SemanticErrorException {
        expr.check();
    }

    public boolean isFirst() {
        return isFirst;
    }

    public ExprAST getExpr() {
        return expr;
    }
}