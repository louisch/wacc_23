package wacc23;

import antlr.WaccParser;
import antlr.WaccLexer;
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
 * TODO: Allow program to be specified as a filename.
 */
public class Compiler {

    public static WaccParser createParseTree(ANTLRInputStream inputStream) {
        WaccLexer lexer = new WaccLexer(inputStream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        return new WaccParser(tokens);
    }

    /**
     * @param args - Arguments passed from the command line
     */
    public static void main(String[] args) throws IOException {
        WaccParser parser = createParseTree(new ANTLRInputStream(System.in));
        ParseTree parseTree = parser.program();

        ProgramVisitor programVisitor = new ProgramVisitor();
        ProgramAST program = programVisitor.visit(parseTree);
    }
}
