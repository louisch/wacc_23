package wacc23.visitor;

import antlr.WaccParser;
import org.antlr.v4.runtime.misc.NotNull;
import wacc23.ast.*;
import wacc23.ast.assignRhs.AssignRhsAST;
import wacc23.ast.statement.AssignmentAST;
import wacc23.ast.statement.DeclarationAST;
import wacc23.ast.statement.StatementAST;
import wacc23.ast.statement.StatementsAST;
import wacc23.ast.type.TypeAST;

public class StatementVisitor extends ParseTreeVisitor<StatementAST> {

    @Override
    public StatementAST visitAssignment(@NotNull WaccParser.AssignmentContext ctx) {
        AssignLhsAST lhs = new AssignLhsVisitor().visitAssignLhs(ctx.assignLhs());
        AssignRhsAST rhs = new AssignRhsVisitor().visitAssignRhs(ctx.assignRhs());
        return new AssignmentAST(lhs, rhs);
    }

    @Override
    public StatementAST visitDeclaration(@NotNull WaccParser.DeclarationContext ctx) {
        TypeAST type = new TypeVisitor().visit(ctx.type());
        IdentAST identifier = new IdentAST(ctx.IDENT().getText());
        AssignRhsAST rhs = new AssignRhsVisitor().visitAssignRhs(ctx.assignRhs());
        return new DeclarationAST(type, identifier, rhs);
    }

    @Override
    public StatementAST visitStats(@NotNull WaccParser.StatsContext ctx) {
        StatementVisitor statementVisitor = new StatementVisitor();
        StatementAST statement0 = statementVisitor.visit(ctx.stat(0));
        StatementAST statement1 = statementVisitor.visit(ctx.stat(1));
        return new StatementsAST(statement0, statement1);
    }
}
