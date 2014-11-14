package wacc23;

import antlr.WaccParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.junit.Test;
import wacc23.ast.FunctionAST;
import wacc23.visitor.FunctionVisitor;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class FunctionVisitorTest {

    private FunctionVisitor functionVisitor = new FunctionVisitor();

    @Test
    public void TestFunctionASTHasCorrectIdentifier() {
        String funcIdent = "BillyBobby3";
        String inputFunction = "int " + funcIdent + " () is skip; skip end";
        WaccParser parser = Compiler.createParser(
                new ANTLRInputStream(inputFunction));
        FunctionAST functionAST = functionVisitor.visit(parser.func());

        assertThat(functionAST.getIdentifier(), is(funcIdent));
    }
}
