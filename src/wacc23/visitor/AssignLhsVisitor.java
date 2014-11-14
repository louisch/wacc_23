package wacc23.visitor;

import antlr.WaccParser;
import org.antlr.v4.runtime.misc.NotNull;
import wacc23.ast.ArrayElemAST;
import wacc23.ast.AssignLhsAST;
import wacc23.ast.IdentAST;
import wacc23.ast.PairElemAST;

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
        } else {
            return new AssignLhsAST<PairElemAST>(new PairElemVisitor().visit(ctx.pairElem()));
        }
    }
}
