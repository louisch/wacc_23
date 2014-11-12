package wacc23.ast;

import antlr.WaccParser;
import org.antlr.v4.runtime.misc.NotNull;

public class FunctionAST extends AST {

    String identifier;

    @Override
    public AST visitFunc(@NotNull WaccParser.FuncContext ctx) {
        identifier = ctx.IDENT().getText();
        return this;
    }

    @Override
    public void check() {

    }

    public String getIdentifier() {
        return identifier;
    }
}
