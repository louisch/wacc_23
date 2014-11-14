package wacc23.ast;

import wacc23.SemanticErrorException;

/**
 * Created by Anton A.
 */
public class ArrayElemAST extends AST {
    private final String identifier;
    private final ExpressionAST expressionAST;

    public ArrayElemAST(String identifier, ExpressionAST expressionAST) {
        this.identifier = identifier;
        this.expressionAST = expressionAST;
    }

    @Override
    public void check() throws SemanticErrorException {
        super.check();
    }

    public String getIdentifier() {
        return identifier;
    }

    public ExpressionAST getExpressionAST() {
        return expressionAST;
    }
}
