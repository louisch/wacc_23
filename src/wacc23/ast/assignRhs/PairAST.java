package wacc23.ast.assignRhs;

import wacc23.ast.AST;
import wacc23.ast.expr.ExprAST;
import wacc23.type.PairType;
import wacc23.type.Type;

public class PairAST extends AST {

    ExprAST fst;
    ExprAST snd;

    public PairAST(ExprAST fst, ExprAST snd) {
        this.fst = fst;
        this.snd = snd;
    }

    @Override
    public Type getType() {
        return new PairType(fst.getType(), snd.getType());
    }
}
