package wacc23.ast.statement;

import wacc23.SemanticErrorException;
import wacc23.SymbolTable;
import wacc23.ast.assignRhs.AssignRhsAST;
import wacc23.ast.expr.IdentAST;
import wacc23.type.Type;

public class DeclarationAST extends StatementAST {
    private final Type type;
    private final IdentAST identifier;
    private final AssignRhsAST rhs;

    public DeclarationAST(Type type, IdentAST identifier, AssignRhsAST rhs) {
        this.type = type;
        this.identifier = identifier;
        this.rhs = rhs;
    }

    @Override
    public void check(SymbolTable funcSymTable, SymbolTable varSymTable)
            throws SemanticErrorException {
        if (!type.equals(rhs.getType())) {
            throw new SemanticErrorException("Variable must have the same as " +
                    "its initial value.");
        }
        rhs.check(funcSymTable, varSymTable);
    }

    public Type getType() {
        return type;
    }

    public IdentAST getIdentifier() {
        return identifier;
    }

    public AssignRhsAST getRhs() {
        return rhs;
    }
}
