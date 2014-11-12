package wacc23.ast;

import antlr.WaccParser;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.HashMap;
import java.util.Map;

public class ProgramAST extends AST {

    private Map<String, AST> funcTable;
    private AST statement;

    public ProgramAST() {
        this.funcTable = new HashMap<String, AST>();
    }

    public ProgramAST(Map<String, AST> funcTable) {
        this.funcTable = funcTable;
    }

    @Override
    public AST visitProgram(@NotNull WaccParser.ProgramContext ctx) {
        for (WaccParser.FuncContext funcCtx : ctx.func()) {
            FunctionAST functionAST = new FunctionAST();
            functionAST.visit(funcCtx);
            funcTable.put(functionAST.getIdentifier(), functionAST);
        }
        statement = visit(ctx.stat());
        return this;
    }

    @Override
    public void check() {
        // TODO: check the program for semantic correctness
    }
}
