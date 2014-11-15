package wacc23.ast.expr;

import wacc23.type.BaseType;
import wacc23.type.BaseTypeValue;
import wacc23.type.Type;

public class CharAST extends ExprAST {
    private final char c;

    public CharAST(char c) {
        this.c = c;
    }

    @Override
    public Type getType() {
        return new BaseType(BaseTypeValue.CHAR);
    }
}
