package wacc23.visitor;

import antlr.WaccParser;
import org.antlr.v4.runtime.misc.NotNull;
import wacc23.ast.AssignLhsAST;
import wacc23.ast.IdentAST;
import wacc23.ast.assignRhs.AssignRhsAST;
import wacc23.ast.expr.ExprAST;
import wacc23.ast.statement.*;
import wacc23.ast.type.TypeAST;

import java.util.LinkedList;
import java.util.List;

public class StatementVisitor extends ParseTreeVisitor<StatementAST> {
    @Override
    public StatementAST visitSkip(@NotNull WaccParser.SkipContext ctx) {
        return new SkipAST();
    }

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
    public StatementAST visitRead(@NotNull WaccParser.ReadContext ctx) {
        return new ReadAST(new AssignLhsVisitor().visitAssignLhs(ctx.assignLhs()));
    }

    @Override
    public StatementAST visitFree(@NotNull WaccParser.FreeContext ctx) {
        return new FreeAST(new ExprVisitor().visit(ctx.expr()));
    }

    @Override
    public StatementAST visitRet(@NotNull WaccParser.RetContext ctx) {
        return new ReturnAST(new ExprVisitor().visit(ctx.expr()));
    }

    @Override
    public StatementAST visitExit(@NotNull WaccParser.ExitContext ctx) {
        return new ExitAST(new ExprVisitor().visit(ctx.expr()));
    }

    @Override
    public StatementAST visitPrint(@NotNull WaccParser.PrintContext ctx) {
        return new PrintAST(new ExprVisitor().visit(ctx.expr()));
    }

    @Override
    public StatementAST visitPrintln(@NotNull WaccParser.PrintlnContext ctx) {
        return new PrintlnAST(new ExprVisitor().visit(ctx.expr()));
    }

    @Override
    public StatementAST visitIf(@NotNull WaccParser.IfContext ctx) {
        ExprAST e = new ExprVisitor().visit(ctx.expr());
        List<StatementAST> stats = new LinkedList<StatementAST>();
        for (WaccParser.StatContext s : ctx.stat()) {
            stats.add(new StatementVisitor().visit(s));
        }
        return new IfAST(e, stats);
    }

    @Override
    public StatementAST visitWhile(@NotNull WaccParser.WhileContext ctx) {
        ExprAST e = new ExprVisitor().visit(ctx.expr());
        StatementAST s = new StatementVisitor().visit(ctx.stat());
        return new WhileAST(e, s);
    }

    @Override
    public StatementAST visitBlock(@NotNull WaccParser.BlockContext ctx) {
        StatementAST s = new StatementVisitor().visit(ctx.stat());
        return new BlockAST(s);
    }

    @Override
    public StatementAST visitStats(@NotNull WaccParser.StatsContext ctx) {
        StatementVisitor statementVisitor = new StatementVisitor();
        StatementAST statement0 = statementVisitor.visit(ctx.stat(0));
        StatementAST statement1 = statementVisitor.visit(ctx.stat(1));
        return new StatementsAST(statement0, statement1);
    }
}
