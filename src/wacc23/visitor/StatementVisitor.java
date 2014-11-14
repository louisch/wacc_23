package wacc23.visitor;

import antlr.WaccParser;
import org.antlr.v4.runtime.misc.NotNull;
import wacc23.ast.StatementAST;
import wacc23.ast.StatementsAST;

public class StatementVisitor extends ParseTreeVisitor<StatementAST> {

    @Override
    public StatementAST visitStats(@NotNull WaccParser.StatsContext ctx) {
        StatementVisitor statementVisitor = new StatementVisitor();
        StatementAST statement0 = statementVisitor.visit(ctx.stat(0));
        StatementAST statement1 = statementVisitor.visit(ctx.stat(1));
        return new StatementsAST(statement0, statement1);
    }
}
