package wacc23.ast.expr;

public class BinOpAST extends ExprAST {

    private ExprAST lhs;
    private ExprAST rhs;
    private Op op;

    public BinOpAST(ExprAST lhs, ExprAST rhs, Op op) {
        this.lhs = lhs;
        this.rhs = rhs;
        this.op = op;
    }

    public ExprAST getLhs() {
        return lhs;
    }

    public ExprAST getRhs() {
        return rhs;
    }

    public Op getOp() {
        return op;
    }

}
