package wacc23.ast;

public class FunctionAST extends AST {

    String identifier;
    TypeAST type;
    StatementAST body;

    public FunctionAST(String identifier, TypeAST type, StatementAST body) {
        this.identifier = identifier;
        this.type = type;
        this.body = body;
    }

    @Override
    public void check() {
        body.check();
    }

    public String getIdentifier() {
        return identifier;
    }
}
