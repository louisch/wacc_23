package wacc23.visitor;

import antlr.WaccParser;
import org.antlr.v4.runtime.misc.NotNull;
import wacc23.ast.PairElemAST;

/**
 * Created by Anton A.
 *
 * TODO
 */
public class PairElemVisitor extends ParseTreeVisitor<PairElemAST> {
    @Override
    public PairElemAST visitPairElem(@NotNull WaccParser.PairElemContext ctx) {
        return super.visitPairElem(ctx);
    }
}
