package wacc23;

import wacc23.ast.AST;
import wacc23.ast.expr.IdentAST;

import java.util.HashMap;
import java.util.Map;

public class SymbolTable {

    private Map<IdentAST, AST> table;

    public SymbolTable() {
        this.table = new HashMap<>();
    }
    public SymbolTable(Map<IdentAST, AST> existingTable) {
        this.table = existingTable;
    }

    public AST get(IdentAST identifier) {
        return table.get(identifier);
    }
}
