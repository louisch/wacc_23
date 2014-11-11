package wacc23;

import antlr.BasicParser;
import antlr.BasicLexer;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;

public class Compiler {
    /**
     * @param args - Arguments passed from the command line
     */
    public static void main(String[] args) throws IOException {
        ANTLRInputStream input = new ANTLRInputStream(System.in);
        BasicLexer lexer = new BasicLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        BasicParser parser = new BasicParser(tokens);
        ParseTree tree = parser.program();
        ExampleVisitor visitor = new ExampleVisitor();
        visitor.visit(tree);
    }
}
