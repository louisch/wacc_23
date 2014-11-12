package wacc23;

import antlr.WaccParser;
import antlr.WaccLexer;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import wacc23.ast.ProgramAST;

import java.io.IOException;

/**
 * The entry point for the compiler.
 *
 * The main method of this class can be used to compile the program from
 * standard input.
 * TODO: Allow program to be specified as a filename.
 */
public class Compiler {
    /**
     * @param args - Arguments passed from the command line
     */
    public static void main(String[] args) throws IOException {
        ANTLRInputStream input = new ANTLRInputStream(System.in);
        WaccLexer lexer = new WaccLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        WaccParser parser = new WaccParser(tokens);
        ParseTree parseTree = parser.program();

        ProgramAST program = new ProgramAST();
        program.visit(parseTree);
    }
}
