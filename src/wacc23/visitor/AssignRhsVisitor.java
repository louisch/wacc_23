package wacc23.visitor;

import antlr.WaccParser;
import org.antlr.v4.runtime.misc.NotNull;
import wacc23.ast.expr.ExprAST;
import wacc23.ast.expr.IdentAST;
import wacc23.ast.PairElemAST;
import wacc23.ast.assignRhs.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anton A.
 */
public class AssignRhsVisitor extends ParseTreeVisitor<AssignRhsAST> {
    @Override
    public AssignRhsAST visitAssignRhs(@NotNull WaccParser.AssignRhsContext ctx) {
        final ExprVisitor exprVisitor = new ExprVisitor();
        if (ctx.arrayLiter() != null) {
            // assign array literal
            List<ExprAST> exps = new ArrayList<>();
            for (WaccParser.ExprContext e : ctx.arrayLiter().expr()) {
                exps.add(exprVisitor.visit(e));
            }
            return new AssignRhsAST(new ArrayLiteralAST(exps));

        } else if (ctx.pairElem() != null) {
            // assign pair element
            PairElemAST pair = new PairElemVisitor().visitPairElem(ctx.pairElem());
            return new AssignRhsAST(pair);

        } else if (ctx.NEWPAIR() != null) {
            // assign pair
            return new AssignRhsAST(new PairAST(exprVisitor.visit(ctx.expr(0)),
                                                exprVisitor.visit(ctx.expr(1))));

        } else if (ctx.CALL() != null) {
            // assign function call
            IdentAST identifier = new IdentAST(ctx.IDENT().getText());
            List<ExprAST> argList = new ArrayList<>();
            for (WaccParser.ExprContext e : ctx.argList().expr()) {
                argList.add(exprVisitor.visit(e));
            }
            return new AssignRhsAST(new CallAST(identifier, argList));

        } else if (ctx.expr() != null) {
            // assign expression
            return new AssignRhsAST(exprVisitor.visit(ctx.expr(0)));

        } else {
            throw new IllegalArgumentException("No context found for AssignRhs");
        }
    }
}
