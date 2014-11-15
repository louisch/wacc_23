package wacc23.ast;

import wacc23.SemanticErrorException;
import wacc23.ast.statement.StatementAST;
import wacc23.ast.type.TypeAST;

import java.util.List;

public class FunctionAST extends AST {

    private final String identifier;
    private final TypeAST type;
    private final List<ParamAST> params;
    private final StatementAST body;

    public FunctionAST(String identifier, TypeAST type, StatementAST body) {
        this.identifier = identifier;
        this.type = type;
        this.params = null;
        this.body = body;
    }

    public FunctionAST(String identifier, TypeAST type, List<ParamAST> params, StatementAST body) {
        this.identifier = identifier;
        this.type = type;
        this.params = params;
        this.body = body;
    }

    @Override
    public void check() throws SemanticErrorException {
        body.check();
        if (params != null) {
            for (ParamAST p : params) {
                p.check();
            }
        }
    }

    public String getIdentifier() {
        return identifier;
    }
}
