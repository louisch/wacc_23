package wacc23.visitor;

import antlr.WaccParser;
import org.antlr.v4.runtime.misc.NotNull;
import wacc23.ast.ExprAST;
import wacc23.ast.IdentAST;
import wacc23.ast.PairElemAST;
import wacc23.ast.assignRhs.*;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Anton A.
 */
public class AssignRhsVisitor extends ParseTreeVisitor<AssignRhsAST> {
    @Override
    public AssignRhsAST visitAssignRhs(@NotNull WaccParser.AssignRhsContext ctx) {
        if (ctx.arrayLiter() != null) {
            // assign array literal
            List<ExprAST> exps = new LinkedList<ExprAST>();
            for (WaccParser.ExprContext e : ctx.arrayLiter().expr()) {
                exps.add(new ExprVisitor().visit(e));
            }
            return new AssignArrayLiteralAST(exps);

        } else if (ctx.pairElem() != null) {
            // assign pair element
            PairElemAST pair = new PairElemVisitor().visitPairElem(ctx.pairElem());
            return new AssignPairElemAST(pair);

        } else if (ctx.NEWPAIR() != null) {
            // assign pair
            List<ExprAST> argList = new LinkedList<ExprAST>();
            for (WaccParser.ExprContext e : ctx.expr()) {
                argList.add(new ExprVisitor().visit(e));
            }
            return new AssignNewpairAST(argList);

        } else if (ctx.CALL() != null) {
            // assign function call
            IdentAST identifier = new IdentAST(ctx.IDENT().getText());
            List<ExprAST> argList = new LinkedList<ExprAST>();
            for (WaccParser.ExprContext e : ctx.argList().expr()) {
                argList.add(new ExprVisitor().visit(e));
            }
            return new AssignCallAST(identifier, argList);

        } else if (ctx.expr() != null) {
            // assign expression
            return new AssignExprAST(new ExprVisitor().visit(ctx.expr(0)));

        } else {
            throw new IllegalArgumentException("No context found for AssignRhs");
        }
    }
}
