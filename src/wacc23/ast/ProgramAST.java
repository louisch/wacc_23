package wacc23.ast;

import wacc23.SemanticErrorException;
import wacc23.ast.statement.StatementAST;

import java.util.Map;

/**
 * Represents the abstract syntax tree of a WACC program
 *
 * Designed to be used to visit the ParseTree corresponding to the program rule
 * of an ANTLR file.
 */
public class ProgramAST extends AST {

    private final Map<String, FunctionAST> funcTable;
    private final StatementAST statement;

    /**
     * Constructs a ProgramAST with the given function table data structure.
     * @param funcTable Table for containing function names and their ASTs
     */
    public ProgramAST(Map<String, FunctionAST> funcTable,
                      StatementAST statement) {
        this.funcTable = funcTable;
        this.statement = statement;
    }

    @Override
    public void check() throws SemanticErrorException {
        for (AST functionAST : funcTable.values()) {
            functionAST.check();
        }
        statement.check();
    }
}
