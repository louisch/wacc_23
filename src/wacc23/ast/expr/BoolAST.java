package wacc23.ast.expr;

import wacc23.ast.type.BaseTypeAST;
import wacc23.ast.type.TypeAST;

/**
 * Created by Anton A.
 */
public class BoolAST extends ExprAST {
    private final boolean isTrue;

    public BoolAST(boolean isTrue) {
        this.isTrue = isTrue;
    }

    @Override
    public TypeAST getType() {
        return BaseTypeAST.makeBoolType();
    }

    public boolean isTrue() {
        return isTrue;
    }
}
