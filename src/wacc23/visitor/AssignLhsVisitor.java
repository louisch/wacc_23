package wacc23.visitor;

import antlr.WaccParser;
import org.antlr.v4.runtime.misc.NotNull;
import wacc23.ast.AssignLhsAST;
import wacc23.ast.expr.IdentAST;
import wacc23.ast.PairElemAST;
import wacc23.ast.expr.ArrayElemAST;

/**
 * Created by Anton A.
 */
public class AssignLhsVisitor extends ParseTreeVisitor<AssignLhsAST> {
    @Override
    public AssignLhsAST visitAssignLhs(@NotNull WaccParser.AssignLhsContext ctx) {
        if (ctx.IDENT() != null) {
            return new AssignLhsAST<IdentAST>(new IdentAST(ctx.IDENT().getText()));

        } else if (ctx.arrayElem() != null) {
            return new AssignLhsAST<ArrayElemAST>(new ArrayElemVisitor().visit(ctx.arrayElem()));

        } else if (ctx.pairElem() != null) {
            return new AssignLhsAST<PairElemAST>(new PairElemVisitor().visit(ctx.pairElem()));

        } else {
            throw new IllegalArgumentException("No context found for AssignLhs");
        }
    }
}
