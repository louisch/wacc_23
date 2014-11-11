package wacc23.ast;

import antlr.BasicParser;
import org.antlr.v4.runtime.misc.NotNull;

public class ProgramAST extends AST {

    // TODO: Add fields corresponding to branches of the program.

    @Override
    public AST visitProgram(@NotNull BasicParser.ProgramContext ctx) {
        // TODO: Visit the branches of the program
        return super.visitProgram(ctx);
    }

    @Override
    public void Check() {
        // TODO: Check the program for semantic correctness
    }
}
