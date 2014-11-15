package wacc23.ast.expr;

import wacc23.ast.type.BaseTypeAST;
import wacc23.ast.type.TypeAST;

/**
 * Created by Anton A.
 */
public class CharAST extends ExprAST {
    private final char c;

    public CharAST(char c) {
        this.c = c;
    }

    @Override
    public TypeAST getType() {
        return BaseTypeAST.makeCharType();
    }
}
