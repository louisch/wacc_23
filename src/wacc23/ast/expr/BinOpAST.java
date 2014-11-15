package wacc23.ast.expr;

public class BinOpAST extends ExprAST {

    private ExprAST lhs;
    private ExprAST rhs;
    private BinOp binOp;

    public BinOpAST(ExprAST lhs, ExprAST rhs, BinOp binOp) {
        this.lhs = lhs;
        this.rhs = rhs;
        this.binOp = binOp;
    }

    public ExprAST getLhs() {
        return lhs;
    }

    public ExprAST getRhs() {
        return rhs;
    }

    public BinOp getBinOp() {
        return binOp;
    }

}
