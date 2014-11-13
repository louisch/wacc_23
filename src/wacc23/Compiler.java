package wacc23;

import antlr.WaccParser;
import antlr.WaccLexer;
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import wacc23.ast.ProgramAST;
import wacc23.visitor.ProgramVisitor;

import java.io.IOException;

/**
 * The entry point for the compiler.
 *
 * The main method of this class can be used to compile the program from
 * standard input.
 */
public class Compiler {

    public static String helpMessage() {
        return "The compiler takes 0 or 1 arguments. If an argument is " +
               "given, it must be a filename, which should be a WACC program " +
               "file.\n" +
               "If no arguments are given, then stdin is taken as input, and " +
               "parsed as a WACC program.\n";
    }

    public static WaccParser createParseTree(ANTLRInputStream inputStream) {
        WaccLexer lexer = new WaccLexer(inputStream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        return new WaccParser(tokens);
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

        WaccParser parser = createParseTree(input);
        parser.removeErrorListeners();
        parser.addErrorListener(new Exit100ErrorListener());
        ParseTree parseTree = parser.program();

        ProgramVisitor programVisitor = new ProgramVisitor();
        ProgramAST program = programVisitor.visit(parseTree);
    }
}
