package wacc23;

import antlr.WaccParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.junit.Before;
import org.junit.Test;
import wacc23.ast.FunctionAST;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class FunctionASTTest {

    private FunctionAST functionAST;

    @Before
    public void setUp() {
        functionAST = new FunctionAST();
    }

    @Test
    public void TestFunctionASTHasCorrectIdentifier() {
        String funcIdent = "BillyBobby3";
        String inputFunction = "int " + funcIdent + " () is skip; skip end";
        WaccParser parser = Compiler.createParseTree(
                new ANTLRInputStream(inputFunction));
        functionAST.visit(parser.func());

        assertThat(functionAST.getIdentifier(), is(funcIdent));
    }
}
