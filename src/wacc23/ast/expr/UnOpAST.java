package wacc23.ast.expr;

public class UnOpAST extends ExprAST {
    private ExprAST expr;
    private Op op;

    public UnOpAST(ExprAST expr, Op op) {
        this.expr = expr;
        this.op = op;
    }

    public ExprAST getExpr() {
        return expr;
    }

    public Op getOp() {
        return op;
    }
}
