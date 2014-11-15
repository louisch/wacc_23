package wacc23.visitor;

import antlr.WaccParser;
import org.antlr.v4.runtime.misc.NotNull;
import wacc23.ast.FunctionAST;
import wacc23.ast.ParamAST;
import wacc23.ast.ReturnAST;
import wacc23.ast.statement.StatementAST;
import wacc23.type.Type;

import java.util.ArrayList;
import java.util.List;

public class FunctionVisitor extends ParseTreeVisitor<FunctionAST> {

    @Override
    public FunctionAST visitFunc(@NotNull WaccParser.FuncContext ctx) {
        String identifier = ctx.IDENT().getText();
        Type type = new TypeVisitor().visit(ctx.type());
        StatementAST body = null;
        if (ctx.stat() != null) {
            body = new StatementVisitor().visit(ctx);
        }
        ReturnAST ret = new RetVisitor().visit(ctx.ret());
        if (ctx.paramList() != null) {
            List<ParamAST> params = new ArrayList<>();
            for (WaccParser.ParamContext p : ctx.paramList().param()) {
                params.add(new ParamVisitor().visitParam(p));
            }
            return new FunctionAST(identifier, type, params, body, ret);
        } else {
            return new FunctionAST(identifier, type,
                    new ArrayList<ParamAST>(), body, ret);
        }
    }
}
