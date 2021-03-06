package wacc23.ast;

import wacc23.SemanticErrorException;
import wacc23.SymbolTable;
import wacc23.type.Type;

/**
 * Represents a node of the abstract syntax tree of the program.
 *
 * May represent any individual part of a program, such as a statement, an
 * expression, or the program as a whole.
 * Used by the compiler to check for semantic errors, as well as a data
 * structure to store the program, so that code may be generated from it.
 */
public class AST {

    protected SymbolTable funcSymTable;
    protected SymbolTable varSymTable;

    public AST() {
        this.funcSymTable = null;
        this.varSymTable = null;
    }
    public AST(SymbolTable funcSymTable, SymbolTable varSymTable) {
        this.funcSymTable = funcSymTable;
        this.varSymTable = varSymTable;
    }

    public void check() throws SemanticErrorException {
    }

    public Type getType() {
        throw new UnsupportedOperationException("This AST has no type.");
    }
}
