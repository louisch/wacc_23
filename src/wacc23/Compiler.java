package wacc23;

import antlr.BasicParser;
import antlr.BasicLexer;
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
        BasicLexer lexer = new BasicLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        BasicParser parser = new BasicParser(tokens);
        ParseTree parseTree = parser.program();

        ProgramAST program = new ProgramAST();
        program.visit(parseTree);
    }
}
