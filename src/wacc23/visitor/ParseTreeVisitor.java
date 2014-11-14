package wacc23.visitor;

import antlr.WaccParserBaseVisitor;
import wacc23.ast.AST;

/**
 * Used for visiting a ParseTree of a WACC program.
 *
 * Each Visitor in the visitor package should extend ParseTreeVisitor.
 *
 * Visitors return an AST corresponding to the branch of the ParseTree they are
 * visiting. For example, the ProgramVisitor returns a ProgramAST.
 * If the branch has other nested branches which require building a nested AST,
 * the Visitor will other Visitors to visit these nested ParseTrees. For
 * example, the ProgramVisitor uses FunctionVisitor to visit the function
 * definitions in a program.
 *
 * As Visitors extend ParseTreeVisitor, which in turn extends ANTLR's
 * BaseVisitor, they can use the visit method to initiate traversal.
 *
 * @param <T> The type of AST that the visitor returns.
 */
public abstract class ParseTreeVisitor<T extends AST>
        extends WaccParserBaseVisitor<T> {
}
