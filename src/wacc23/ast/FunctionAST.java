package wacc23.ast;

import wacc23.SemanticErrorException;
import wacc23.ast.statement.StatementAST;
import wacc23.type.Type;

import java.util.List;

public class FunctionAST extends AST {

    private final String identifier;
    private final Type type;
    private final List<ParamAST> params;
    /**
     * Note that body may be null. This signifies a function with a bare return
     * statement.
     */
    private final StatementAST body;
    private final ReturnAST ret;

    public FunctionAST(String identifier, Type type, List<ParamAST> params,
                       StatementAST body, ReturnAST ret) {
        this.identifier = identifier;
        this.type = type;
        this.params = params;
        this.body = body;
        this.ret = ret;
    }

    @Override
    public void check()
            throws SemanticErrorException {
        if (body != null) {
            body.check();
        }
        for (ParamAST p : params) {
            p.check();
        }
    }

    public String getIdentifier() {
        return identifier;
    }
}
