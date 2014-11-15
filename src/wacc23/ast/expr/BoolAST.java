package wacc23.ast.expr;

import wacc23.type.BaseType;
import wacc23.type.BaseTypeValue;
import wacc23.type.Type;

public class BoolAST extends ExprAST {
    private final boolean isTrue;

    public BoolAST(boolean isTrue) {
        this.isTrue = isTrue;
    }

    @Override
    public Type getType() {
        return new BaseType(BaseTypeValue.BOOL);
    }

    public boolean isTrue() {
        return isTrue;
    }
}
