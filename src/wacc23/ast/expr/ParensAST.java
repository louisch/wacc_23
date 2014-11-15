package wacc23.ast.expr;

public class ParensAST extends ExprAST {
    ExprAST expr;

    public ParensAST(ExprAST expr) {
        this.expr = expr;
    }

    public ExprAST getExpr() {
        return expr;
    }
}
