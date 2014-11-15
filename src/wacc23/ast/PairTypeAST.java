package wacc23.ast;

public class PairTypeAST extends TypeAST{

    private final String fst;
    private final String snd;

    public PairTypeAST(String fst, String snd){
        super("PAIR");
        this.fst = fst;
        this.snd = snd;
    }
}
