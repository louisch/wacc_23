package wacc23.ast.statement;

import wacc23.SemanticErrorException;
import wacc23.ast.assignRhs.AssignRhsAST;
import wacc23.ast.IdentAST;
import wacc23.ast.TypeAST;

/**
 * Created by Anton A.
 */
public class DeclarationAST extends StatementAST {
    private final TypeAST type;
    private final IdentAST identifier;
    private final AssignRhsAST rhs;

    public DeclarationAST(TypeAST type, IdentAST identifier, AssignRhsAST rhs) {
        this.type = type;
        this.identifier = identifier;
        this.rhs = rhs;
    }

    @Override
    public void check() throws SemanticErrorException {
        rhs.check();
    }

    public TypeAST getType() {
        return type;
    }

    public IdentAST getIdentifier() {
        return identifier;
    }

    public AssignRhsAST getRhs() {
        return rhs;
    }
}
