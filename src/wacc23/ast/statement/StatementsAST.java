package wacc23.ast.statement;

import java.util.ArrayList;
import java.util.List;

public class StatementsAST extends StatementAST {

    private final List<StatementAST> statements;

    public StatementsAST(StatementAST statement0, StatementAST statement1) {
        statements = new ArrayList<>();
        addToStatements(statement0);
        addToStatements(statement1);
    }

    /**
     * Adds a single statement to the statements internal list.
     *
     * Will check if statement is actually Statements (plural), and if so, add
     * the Statements' internal statements list's contents instead of the
     * StatementsAST itself.
     */
    private void addToStatements(StatementAST statement) {
        if (statement instanceof StatementsAST) {
            StatementsAST actuallyStatements = (StatementsAST) statement;
            statements.addAll(actuallyStatements.statements);
        } else {
            statements.add(statement);
        }
    }
}
