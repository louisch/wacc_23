package wacc23.type;

public class PairType extends Type {

    private Type fst;
    private Type snd;

    public PairType(Type fst, Type snd) {
        if (fst instanceof PairType) {
            this.fst = new InnerPairType();
        } else {
            this.fst = fst;
        }
        if (snd instanceof PairType) {
            this.snd = new InnerPairType();
        } else {
            this.snd = snd;
        }
    }
}
