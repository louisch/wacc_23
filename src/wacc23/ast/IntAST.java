package wacc23.ast;

import wacc23.SemanticErrorException;
import wacc23.ast.type.BaseTypeAST;
import wacc23.ast.type.TypeAST;

public class IntAST extends ExprAST {

    int value;

    public IntAST(int value) {
        this.value = value;
    }

    @Override
    public void check() throws SemanticErrorException {
        super.check(); // one does not simply semantic check an int
    }

    @Override
    public TypeAST getType() {
        return BaseTypeAST.makeIntType();
    }
}
