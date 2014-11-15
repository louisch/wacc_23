package wacc23.ast;

import wacc23.SemanticErrorException;

/**
 * Represents a node of the abstract syntax tree of the program.
 *
 * May represent any individual part of a program, such as a statement, an
 * expression, or the program as a whole.
 * Used by the compiler to check for semantic errors, as well as a data
 * structure to store the program, so that code may be generated from it.
 */
public abstract class AST {
    public void check() throws SemanticErrorException {
        throw new UnsupportedOperationException("This AST cannot be checked.");
    }
}
