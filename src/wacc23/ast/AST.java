package wacc23.ast;

/**
 * Represents a node of the abstract syntax tree of the program.
 *
 * May represent any individual part of a program, such as a statement, an
 * expression, or the program as a whole.
 * Used by the compiler to check for semantic errors, as well as a data
 * structure to store the program, so that code may be generated from it.
 */
public abstract class AST extends antlr.WaccParserBaseVisitor<AST> {
    public abstract void check();
}
