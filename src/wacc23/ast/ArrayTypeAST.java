package wacc23.ast;

import wacc23.utils.RepeatString;

public class ArrayTypeAST extends TypeAST {

    public ArrayTypeAST(String type) {
        super(type);
    }

    /**
     * This generates an ArrayTypeAST given a TypeAST and the array depth.
     * (This is primarily useful in semantic checking.)
     *
     * @param type Type of the array
     * @param n Array depth e.g. n = 3 could generate "int[][][]"
     */
    public static ArrayTypeAST makeArrayElemType(TypeAST type, int n) {
        return new ArrayTypeAST(type.getType()
                + RepeatString.repeatString("[]", n));
    }
}
