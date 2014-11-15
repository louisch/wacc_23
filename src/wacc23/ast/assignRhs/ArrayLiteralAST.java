package wacc23.ast.assignRhs;

import wacc23.SemanticErrorException;
import wacc23.ast.AST;
import wacc23.ast.expr.ExprAST;
import wacc23.ast.ExprsAST;
import wacc23.type.ArrayType;
import wacc23.type.Type;

import java.util.List;

public class ArrayLiteralAST extends AST {

    private final Type type;
    private final List<ExprAST> expressions;

    public ArrayLiteralAST(List<ExprAST> expressions) {
        this.type = expressions.get(0).getType();
        this.expressions = expressions;
    }

    public List<ExprAST> getExpressions() {
        return expressions;
    }

    @Override
    public Type getType() {
        if (expressions.isEmpty()) {
            return new ArrayType();
        } else {
            return new ArrayType(expressions.get(0).getType());
        }
    }

    @Override
    public void check() throws SemanticErrorException {
        if (expressions.isEmpty()) {
            return;
        }
        for (ExprAST expr : expressions) {
            if (type != expr.getType()) {
                throw new SemanticErrorException("Expressions in array " +
                        "literal are not all the same type.");
            }
        }
    }
}
