package wacc23.visitor;

import antlr.WaccParser;
import org.antlr.v4.runtime.misc.NotNull;
import wacc23.ast.expr.ExprAST;
import wacc23.ast.PairElemAST;

/**
 * Created by Anton A.
 *
 * TODO
 */
public class PairElemVisitor extends ParseTreeVisitor<PairElemAST> {
    @Override
    public PairElemAST visitPairElem(@NotNull WaccParser.PairElemContext ctx) {
        boolean isFirst = ctx.FST() != null;
        ExprAST expr = new ExprVisitor().visit(ctx.expr());
        return new PairElemAST(isFirst, expr);
    }
}
