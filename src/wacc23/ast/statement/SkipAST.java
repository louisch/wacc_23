package wacc23.ast.statement;

import wacc23.SemanticErrorException;
import wacc23.SymbolTable;

/**
 * Created by Anton A.
 */
public class SkipAST extends StatementAST {
    @Override
    public void check(SymbolTable funcSymTable, SymbolTable varSymTable) throws SemanticErrorException {
        //do nothing
    }
}
