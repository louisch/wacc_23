package wacc23.visitor;

import antlr.WaccParser;
import org.antlr.v4.runtime.misc.NotNull;
import wacc23.ast.ArrayElemAST;

/**
 * Created by Anton A.
 */
public class ArrayElemVisitor extends ParseTreeVisitor<ArrayElemAST> {
    @Override
    public ArrayElemAST visitArrayElem(@NotNull WaccParser.ArrayElemContext ctx) {
        return super.visitArrayElem(ctx);
    }
}
