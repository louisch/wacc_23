package wacc23.ast.expr;

import wacc23.ast.PairElemAST;
import wacc23.type.Type;

public class PairAST extends ExprAST {

    PairElemAST fst;
    PairElemAST snd;

    public PairAST(PairElemAST fst, PairElemAST snd) {
        this.fst = fst;
        this.snd = snd;
    }

    @Override
    public Type getType() {
        return null;
    }
}
