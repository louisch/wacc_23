package wacc23.ast.expr;

import wacc23.SemanticErrorException;

public class IdentAST extends ExprAST {
    private final String identifier;

    public IdentAST(String identifier) {
        this.identifier = identifier;
    }

    public String getIdentifier() {
        return identifier;
    }
}
