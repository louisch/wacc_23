package wacc23.visitor;

import antlr.WaccParser;
import org.antlr.v4.runtime.misc.NotNull;
import wacc23.ast.FunctionAST;
import wacc23.ast.ProgramAST;
import wacc23.ast.StatementAST;

import java.util.HashMap;
import java.util.Map;

public class ProgramVisitor extends ParseTreeVisitor<ProgramAST> {

    /**
     * Visits the functions and statement in the program
     * @param ctx The parse tree representing the program
     * @return A ProgramAST representing the program in a form suitable for
     *         the compiler to do intermediate work before code generation.
     *
     * Uses the FunctionVisitor and StatementVisitor to visit and create ASTs
     * to enter into the ProgramAST.
     */
    @Override
    public ProgramAST visitProgram(@NotNull WaccParser.ProgramContext ctx) {
        FunctionVisitor functionVisitor = new FunctionVisitor();
        Map<String, FunctionAST> funcTable = new HashMap<>();
        for (WaccParser.FuncContext funcCtx : ctx.func()) {
            FunctionAST functionAST = functionVisitor.visit(funcCtx);
            funcTable.put(functionAST.getIdentifier(), functionAST);
        }

        StatementVisitor statementVisitor = new StatementVisitor();
        StatementAST statement = statementVisitor.visit(ctx.stat());

        return new ProgramAST(funcTable, statement);
    }
}
