package wacc23.ast.statement;

import wacc23.SemanticErrorException;
import wacc23.SymbolTable;

public class BlockAST extends StatementAST {
    private final StatementAST stat;

    public BlockAST(StatementAST s) {
        this.stat = s;
    }

    @Override
    public void check(SymbolTable funcSymTable, SymbolTable varSymTable) throws SemanticErrorException {
        stat.check(funcSymTable, varSymTable);
    }

    public StatementAST getStat() {
        return stat;
    }
}
