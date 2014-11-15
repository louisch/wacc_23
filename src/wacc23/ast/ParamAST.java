package wacc23.ast;

import wacc23.SemanticErrorException;
import wacc23.type.Type;

/**
 * Created by Anton A.
 */
public class ParamAST extends AST {
    private final Type type;
    private final IdentAST id;

    public ParamAST(Type type, IdentAST id) {
        this.type = type;
        this.id = id;
    }

    @Override
    public void check() throws SemanticErrorException {
        type.check();
    }

    public Type getType() {
        return type;
    }

    public IdentAST getId() {
        return id;
    }
}
