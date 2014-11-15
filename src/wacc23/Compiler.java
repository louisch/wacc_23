package wacc23;

import antlr.WaccLexer;
import antlr.WaccParser;
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import wacc23.ast.AST;
import wacc23.ast.ProgramAST;
import wacc23.visitor.ParseTreeVisitor;
import wacc23.visitor.ProgramVisitor;

import java.io.IOException;

/**
 * The entry point for the compiler.
 *
 * The main method of this class can be used to compile the program from
 * standard input.
 */
public class Compiler {

    /**
     * Creates the various ANTLR components required to create a parser
     * @param inputStream An input stream that will be lexed
     * @return The resulting parser after passing input stream through all the
     *         ANTLR components.
     */
    public static WaccParser createParser(ANTLRInputStream inputStream) {
        WaccLexer lexer = new WaccLexer(inputStream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        return new WaccParser(tokens);
    }

    private static String helpMessage() {
        return "The compiler takes 0 or 1 arguments. If an argument is " +
               "given, it must be a filename, which should be a WACC program " +
               "file.\n" +
               "If no arguments are given, then stdin is taken as input, and " +
               "parsed as a WACC program.\n";
    }

    /**
     * Exits the program, assuming a Semantic Error has been found.
     *
     * Produces an exit code of 200.
     */
    private static void exitFromSemanticError() {
        final int semanticErrorExitCode = 200;
        System.exit(semanticErrorExitCode);
    }

    /**
     * <p>Runs the compiler, either using stdin as input, or a given file.</p>
     *
     * <p>If an argument is given, then it is taken to be the filename of a wacc
     * file to be processed.</p>
     * @param args - Arguments passed from the command line
     */
    public static void main(String[] args) throws IOException {
        // Get input either from System.in, or the first argument to main.
        ANTLRInputStream input;
        if (args.length == 0) {
            input = new ANTLRInputStream(System.in);
        } else if (args.length == 1) {
            input = new ANTLRFileStream(args[0]);
        } else {
            System.out.print(helpMessage());
            throw new IllegalArgumentException("Wrong number of arguments " +
                                               "passed to main.");
        }

        WaccParser parser = createParser(input);
        // Insert a custom Error Listener here that will produce the correct
        // exit code on a syntax error.
        parser.removeErrorListeners();
        parser.addErrorListener(new Exit100ErrorListener());
        ParseTree parseTree = parser.program();

        ParseTreeVisitor<ProgramAST> programVisitor = new ProgramVisitor();
        // Builds an AST by traversing the parse tree with the Visitors.
        AST program = programVisitor.visit(parseTree);
    }
}
