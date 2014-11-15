package wacc23.ast;

import wacc23.SemanticErrorException;
import wacc23.SymbolTable;
import wacc23.ast.statement.StatementAST;
import wacc23.type.Type;

import java.util.List;

public class FunctionAST extends AST {

    private final String identifier;
    private final Type type;
    private final List<ParamAST> params;
    private final StatementAST body;

    public FunctionAST(String identifier, Type type, StatementAST body) {
        this.identifier = identifier;
        this.type = type;
        this.params = null;
        this.body = body;
    }

    public FunctionAST(String identifier, Type type, List<ParamAST> params, StatementAST body) {
        this.identifier = identifier;
        this.type = type;
        this.params = params;
        this.body = body;
    }

    @Override
    public void check(SymbolTable funcSymTable, SymbolTable varSymTable) throws SemanticErrorException {
        body.check(funcSymTable, varSymTable);
        if (params != null) {
            for (ParamAST p : params) {
                p.check(funcSymTable, varSymTable);
            }
        }
    }

    public String getIdentifier() {
        return identifier;
    }
}
