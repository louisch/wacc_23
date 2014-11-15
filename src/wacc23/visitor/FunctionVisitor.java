package wacc23.visitor;

import antlr.WaccParser;
import org.antlr.v4.runtime.misc.NotNull;
import wacc23.ast.FunctionAST;
import wacc23.ast.statement.StatementAST;
import wacc23.ast.type.TypeAST;

public class FunctionVisitor extends ParseTreeVisitor<FunctionAST> {

    @Override
    public FunctionAST visitFunc(@NotNull WaccParser.FuncContext ctx) {
        String identifier = ctx.IDENT().getText();
        TypeAST type = new TypeVisitor().visit(ctx.type());
        StatementAST body = new StatementVisitor().visit(ctx.stat());
        return new FunctionAST(identifier, type, body);
    }
}
