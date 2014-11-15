package wacc23.ast.type;

import wacc23.ast.type.TypeAST;

public class PairTypeAST extends TypeAST {

    private final String fst;
    private final String snd;

    public PairTypeAST(String fst, String snd){
        super("PAIR");
        this.fst = fst;
        this.snd = snd;
    }
}
