package wacc23;

import antlr.WaccParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.junit.Before;
import org.junit.Test;
import wacc23.ast.AST;
import wacc23.ast.ProgramAST;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertTrue;

public class ProgramASTTest {

    private Map<String, AST> testMap;
    private ProgramAST programAST;

    @Before
    public void setUp() {
        testMap = new HashMap<String, AST>();
        programAST = new ProgramAST(testMap);
    }

    @Test
    public void testProgramASTReadsFunctionsCorrectly() {
        String funcName = "foo";
        String inputProgram = "begin\n" +
                              "int " + funcName + " (int x) is\n" +
                              "skip\n" +
                              "end\n" +
                              "skip\n" +
                              "end";
        WaccParser parser = Compiler.createParseTree(
                new ANTLRInputStream(inputProgram));
        programAST.visit(parser.program());
        assertTrue(testMap.containsKey(funcName));
    }
}
