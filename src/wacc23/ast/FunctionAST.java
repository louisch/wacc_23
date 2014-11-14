package wacc23.ast;

import wacc23.SemanticErrorException;

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
    public void check() throws SemanticErrorException {
        body.check();
    }

    public String getIdentifier() {
        return identifier;
    }
}
