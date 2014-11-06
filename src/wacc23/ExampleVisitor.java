package wacc23;

import antlr.BasicParser;
import org.antlr.v4.runtime.misc.NotNull;

/**
 * Demonstrates how to override methods in BaseVisitor
 */
public class ExampleVisitor extends antlr.BasicParserBaseVisitor<String> {
    @Override
    public String visitProgram(@NotNull BasicParser.ProgramContext ctx) {
        System.out.println("Begin the program!");
        return super.visitProgram(ctx);
    }

    @Override
    public String visitDeclaration(
            @NotNull BasicParser.DeclarationContext ctx) {
        System.out.println("Declaration: Set " + ctx.IDENT().getText() +
                           " to " + visitAssignRhs(ctx.assignRhs()));
        return super.visitDeclaration(ctx);
    }

    @Override
    public String visitExpr(@NotNull BasicParser.ExprContext ctx) {
        return ctx.getText();
    }
}
