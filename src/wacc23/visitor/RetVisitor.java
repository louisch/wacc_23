package wacc23.visitor;

import antlr.WaccParser;
import org.antlr.v4.runtime.misc.NotNull;
import wacc23.ast.ReturnAST;

public class RetVisitor extends ParseTreeVisitor<ReturnAST> {

    @Override
    public ReturnAST visitRet(@NotNull WaccParser.RetContext ctx) {
        return new ReturnAST(new ExprVisitor().visit(ctx.expr()));
    }
}
