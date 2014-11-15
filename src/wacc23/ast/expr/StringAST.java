package wacc23.ast.expr;

import wacc23.type.BaseType;
import wacc23.type.BaseTypeValue;
import wacc23.type.Type;

public class StringAST extends ExprAST {
    private final String string;

    public StringAST(String string) {
        this.string = string;
    }

    @Override
    public Type getType() {
        return new BaseType(BaseTypeValue.STRING);
    }
}
