package wacc23.ast;

import wacc23.SemanticErrorException;
import wacc23.SymbolTable;
import wacc23.ast.expr.ExprAST;
import wacc23.type.Type;

public class PairElemAST extends AST {
    private final boolean isFirst;
    private final ExprAST expr;

    public PairElemAST(boolean isFirst, ExprAST expr) {
        this.isFirst = isFirst;
        this.expr = expr;
    }

    @Override
    public void check(SymbolTable funcSymTable, SymbolTable varSymTable) throws SemanticErrorException {
        expr.check(funcSymTable, varSymTable);
    }

    public boolean isFirst() {
        return isFirst;
    }

    public ExprAST getExpr() {
        return expr;
    }

    @Override
    public Type getType() {
        // TODO: Use the symbol table to do this.
        return null;
    }
}
