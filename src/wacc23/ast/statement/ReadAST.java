package wacc23.ast.statement;

import wacc23.SemanticErrorException;
import wacc23.SymbolTable;
import wacc23.ast.AssignLhsAST;

/**
 * Created by Anton A.
 */
public class ReadAST extends StatementAST {
    private final AssignLhsAST lhs;

    public ReadAST(AssignLhsAST lhs) {
        this.lhs = lhs;
    }

    @Override
    public void check(SymbolTable funcSymTable, SymbolTable varSymTable)
            throws SemanticErrorException {
        lhs.check(funcSymTable, varSymTable);
    }

    public AssignLhsAST getLhs() {
        return lhs;
    }
}
