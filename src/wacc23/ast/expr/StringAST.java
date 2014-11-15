package wacc23.ast.expr;

import wacc23.ast.type.BaseTypeAST;
import wacc23.ast.type.TypeAST;

/**
 * Created by Anton A.
 */
public class StringAST extends ExprAST {
    private final String string;

    public StringAST(String string) {
        this.string = string;
    }

    @Override
    public TypeAST getType() {
        return BaseTypeAST.makeStringType();
    }
}
