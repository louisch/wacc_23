package wacc23.ast.expr;

import wacc23.SemanticErrorException;
import wacc23.type.Type;

public class IdentAST extends ExprAST {
    private final String identifier;

    public IdentAST(String identifier) {
        this.identifier = identifier;
    }

    public String getIdentifier() {
        return identifier;
    }

    @Override
    public void check()
            throws SemanticErrorException {
        if (!varSymTable.containsIdent(this)) {
            throw new SemanticErrorException("Identifier not declared.");
        }
    }

    @Override
    public Type getType() {
        return super.getType();
    }

    @Override
    public String toString() {
        return identifier;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof IdentAST) {
            return ((IdentAST) obj).identifier.equals(this.identifier);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return identifier.hashCode();
    }
}
