package wacc23.ast;

import wacc23.SemanticErrorException;

/**
 * Created by Anton A.
 */
public class IdentAST extends AST {
    private final String identifier;

    public IdentAST(String identifier) {
        this.identifier = identifier;
    }

    public String getIdentifier() {
        return identifier;
    }

    @Override
    public void check() throws SemanticErrorException {
        // do nothing
    }
}
