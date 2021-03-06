package wacc23.ast.assignRhs;

import wacc23.SemanticErrorException;
import wacc23.ast.AST;
import wacc23.ast.expr.ExprAST;
import wacc23.ast.expr.IdentAST;
import wacc23.type.Type;

import java.util.List;

public class CallAST extends AST {
    private final IdentAST ident;
    private final List<ExprAST> argList;

    public CallAST(IdentAST ident, List<ExprAST> argList) {
        this.ident = ident;
        this.argList = argList;
    }

    @Override
    public void check()
            throws SemanticErrorException {
        if (!(funcSymTable.containsIdent(ident))) {
            throw new SemanticErrorException("Function not declared.");
        }
    }

    public IdentAST getIdent() {
        return ident;
    }

    public List<ExprAST> getArgList() {
        return argList;
    }

    @Override
    public Type getType() {
        // TODO: Use function symbol table to do this
        return null;
    }
}
