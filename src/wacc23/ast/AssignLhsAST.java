package wacc23.ast;

import wacc23.SemanticErrorException;
import wacc23.SymbolTable;

public class AssignLhsAST<T extends AST> extends AST {
    private final T lhsType;

    public AssignLhsAST(T lhsType) {
        this.lhsType = lhsType;
    }

    public T getLhsType() {
        return lhsType;
    }

    @Override
    public void check(SymbolTable funcSymTable, SymbolTable varSymTable) throws SemanticErrorException {
        lhsType.check(funcSymTable, varSymTable);
    }
}
