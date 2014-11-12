package wacc23;

import antlr.WaccParser;
import org.antlr.v4.runtime.misc.NotNull;

/**
 * Demonstrates how to override methods in BaseVisitor
 */
public class ExampleVisitor extends antlr.WaccParserBaseVisitor<String> {
    @Override
    public String visitProgram(@NotNull WaccParser.ProgramContext ctx) {
        System.out.println("Begin the program!");
        return super.visitProgram(ctx);
    }

    @Override
    public String visitDeclaration(
            @NotNull WaccParser.DeclarationContext ctx) {
        System.out.println("Declaration: Set " + ctx.IDENT().getText() +
                           " to " + visitAssignRhs(ctx.assignRhs()));
        return super.visitDeclaration(ctx);
    }

    @Override
    public String visitExpr(@NotNull WaccParser.ExprContext ctx) {
        return ctx.getText();
    }
}
