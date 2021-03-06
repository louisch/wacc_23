package wacc23.ast;

import wacc23.SemanticErrorException;

public class AssignLhsAST<T extends AST> extends AST {
    private final T lhsType;

    public AssignLhsAST(T lhsType) {
        this.lhsType = lhsType;
    }

    public T getLhsType() {
        return lhsType;
    }

    @Override
    public void check() throws SemanticErrorException {
        lhsType.check();
    }
}
