package wacc23.visitor;

import org.antlr.v4.runtime.tree.TerminalNode;
import wacc23.ast.expr.IdentAST;

/**
 * This is simply a utility class that takes an Identifier and turns it into an
 * IdentAST
 */
public class IdentVisitor {

    public IdentAST visitIdent(TerminalNode ident) {
        return new IdentAST(ident.getText());
    }
}
