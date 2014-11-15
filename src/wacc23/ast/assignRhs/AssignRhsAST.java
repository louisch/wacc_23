package wacc23.ast.assignRhs;

import wacc23.SemanticErrorException;
import wacc23.ast.AST;
import wacc23.type.Type;

public class AssignRhsAST extends AST {

    AST innerValue;

    public AssignRhsAST(AST value) {
        this.innerValue = value;
    }

    @Override
    public Type getType() {
        return innerValue.getType();
    }

    @Override
    public void check() throws SemanticErrorException {
        innerValue.check();
    }
}
