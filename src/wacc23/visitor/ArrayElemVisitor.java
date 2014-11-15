package wacc23.visitor;

import antlr.WaccParser;
import org.antlr.v4.runtime.misc.NotNull;
import wacc23.ast.expr.ArrayElemAST;
import wacc23.ast.expr.ExprAST;
import wacc23.ast.expr.IdentAST;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Anton A.
 */
public class ArrayElemVisitor extends ParseTreeVisitor<ArrayElemAST> {
    @Override
    public ArrayElemAST visitArrayElem(
            @NotNull WaccParser.ArrayElemContext ctx) {
        IdentAST identifier = new IdentVisitor().visitIdent(ctx.IDENT());
        List<ExprAST> es = new ArrayList<>();
        for (WaccParser.ExprContext exp : ctx.expr()) {
            es.add(new ExprVisitor().visit(exp));
        }
        return new ArrayElemAST(identifier, es);
    }
}
