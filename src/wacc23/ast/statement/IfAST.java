package wacc23.ast.statement;

import wacc23.SemanticErrorException;
import wacc23.SymbolTable;
import wacc23.ast.expr.ExprAST;

import java.util.List;

public class IfAST extends StatementAST {

    private final ExprAST boolExpr;

    private final List<StatementAST> stats;

    public IfAST(ExprAST expr, List<StatementAST> stats) {
        this.boolExpr = expr;
        this.stats = stats;
    }

    @Override
    public void check(SymbolTable funcSymTable, SymbolTable varSymTable)
            throws SemanticErrorException {
        for (StatementAST s : stats) {
            s.check(funcSymTable, varSymTable);
        }
    }

    public List<StatementAST> getStats() {
        return stats;
    }
}
