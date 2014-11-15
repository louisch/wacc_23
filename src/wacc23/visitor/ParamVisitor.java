package wacc23.visitor;

import antlr.WaccParser;
import org.antlr.v4.runtime.misc.NotNull;
import wacc23.ast.IdentAST;
import wacc23.ast.ParamAST;
import wacc23.ast.type.TypeAST;

/**
 * Created by Anton A.
 */
public class ParamVisitor extends ParseTreeVisitor<ParamAST> {
    @Override
    public ParamAST visitParam(@NotNull WaccParser.ParamContext ctx) {
        IdentAST id = new IdentAST(ctx.IDENT().getText());
        TypeAST type = new TypeVisitor().visit(ctx.type());
        return new ParamAST(type, id);
    }
}
