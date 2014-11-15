package wacc23;

/**
 * Represents a semantic error in the program code read by the compiler.
 *
 * This is when the program follows the spec BNF correctly, but the program
 * still has some code which semantically does not make sense.
 */
public class SemanticErrorException extends Exception {
    public SemanticErrorException() {}
    public SemanticErrorException(String message) {
        super(message);
    }
}
