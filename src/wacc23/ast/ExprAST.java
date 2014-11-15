package wacc23.ast;

public abstract class ExprAST extends AST {
    // should this extend TypeAST instead?
    public abstract TypeAST getType();
}