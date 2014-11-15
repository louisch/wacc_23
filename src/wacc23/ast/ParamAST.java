package wacc23.ast;

import wacc23.SemanticErrorException;
import wacc23.ast.type.TypeAST;

/**
 * Created by Anton A.
 */
public class ParamAST extends AST {
    private final TypeAST type;
    private final IdentAST id;

    public ParamAST(TypeAST type, IdentAST id) {
        this.type = type;
        this.id = id;
    }

    @Override
    public void check() throws SemanticErrorException {
        type.check();
    }

    public TypeAST getType() {
        return type;
    }

    public IdentAST getId() {
        return id;
    }
}
