package wacc23.ast;

import wacc23.SemanticErrorException;
import wacc23.ast.expr.ExprAST;

import java.util.List;

/**
 * Created by Anton A.
 *
 * Should not extends ExprAST, as this is just a wrapper for expression lists.
 */
public class ExprsAST extends AST{
    private final List<ExprAST> exprs;

    public ExprsAST(List<ExprAST> exprs) {
        this.exprs = exprs;
    }

    @Override
    public void check() throws SemanticErrorException {
        for (ExprAST e : exprs) {
            e.check();
        }
    }

    public List<ExprAST> getExprs() {
        return exprs;
    }

    public ExprAST getExpr(int i) {
        return exprs.get(i);
    }
}
