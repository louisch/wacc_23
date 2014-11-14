package wacc23.ast;

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
     * If this statement represents two or more statements, get the very last.
     *
     * Statements can be two statements nested inside one. This resembles a tree
     * structure. For any given statement, this returns the statement
     * furthest to the 'right' of the statement tree.
     */
    public AST lastStatement() {
        if (!statements.isEmpty()) {
            return null;
        }
        return statements.get(statements.size() - 1);
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
