package wacc23.ast;

import antlr.WaccParser;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents the abstract syntax tree of a WACC program
 *
 * Designed to be used to visit the ParseTree corresponding to the program rule
 * of an ANTLR file.
 */
public class ProgramAST extends AST {

    private Map<String, AST> funcTable;
    private AST statement;

    /**
     * Constructs a ProgramAST with an empty function table.
     */
    public ProgramAST() {
        this(new HashMap<String, AST>());
    }

    /**
     * Constructs a ProgramAST with the given function table data structure.
     * @param funcTable Table for containing function names and their ASTs
     */
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
        for (AST functionAST : funcTable.values()) {
            functionAST.check();
        }
        statement.check();
    }
}
