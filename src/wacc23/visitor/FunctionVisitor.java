package wacc23.visitor;

import antlr.WaccParser;
import org.antlr.v4.runtime.misc.NotNull;
import wacc23.ast.FunctionAST;
import wacc23.ast.ParamAST;
import wacc23.ast.statement.StatementAST;
import wacc23.type.Type;

import java.util.LinkedList;
import java.util.List;

public class FunctionVisitor extends ParseTreeVisitor<FunctionAST> {

    @Override
    public FunctionAST visitFunc(@NotNull WaccParser.FuncContext ctx) {
        String identifier = ctx.IDENT().getText();
        Type type = new TypeVisitor().visit(ctx.type());
        StatementAST body = new StatementVisitor().visit(ctx.stat());
        if (ctx.paramList() != null) {
            List<ParamAST> params = new LinkedList<ParamAST>();
            for (WaccParser.ParamContext p : ctx.paramList().param()) {
                params.add(new ParamVisitor().visitParam(p));
            }
            return new FunctionAST(identifier, type, params, body);
        } else {
            return new FunctionAST(identifier, type, body);
        }
    }
}
