package wacc23.ast.expr;

import wacc23.type.BaseType;
import wacc23.type.BaseTypeValue;
import wacc23.type.Type;

public class IntAST extends ExprAST {

    private final int value;

    public IntAST(int value) {
        this.value = value;
    }

    @Override
    public Type getType() {
        return new BaseType(BaseTypeValue.INT);
    }
}
