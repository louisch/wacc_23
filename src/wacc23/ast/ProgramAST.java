package wacc23.ast;

import antlr.WaccParser;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.Map;

public class ProgramAST extends AST {

    private Map<String, AST> funcTable;
    private AST statement;

    @Override
    public AST visitProgram(@NotNull WaccParser.ProgramContext ctx) {
        for (WaccParser.FuncContext funcCtx : ctx.func()) {
            funcTable.put(funcCtx.IDENT().getText(), visit(funcCtx));
        }
        statement = visit(ctx.stat());
        return this;
    }

    @Override
    public void Check() {
        // TODO: Check the program for semantic correctness
    }
}
