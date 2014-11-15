package wacc23.type;

public class ArrayType extends Type {

    /**
     * Arrays will either be arrays of arrays of... pairs, or BaseTypes.
     *
     * This variable represents that type. i.e. What the array actually contains
     * at the lowest level.
     *
     * This variable may be null, which represents an empty array type, or an
     * array which only has nested empty arrays.
     */
    private Type arrayBaseType;
    private int depth;

    public ArrayType() {
        arrayBaseType = null;
        depth = 0;
    }
    /**
     * Creates an array of the given innerType.
     *
     * If an array is given as the inner type, that array's baseType is used,
     * and the depth of this array is set to be that array's depth plus one.
     */
    public ArrayType(Type innerType) {
        if (innerType instanceof ArrayType) {
            ArrayType innerTypeAsArray = (ArrayType) innerType;
            this.depth = innerTypeAsArray.depth + 1;
            this.arrayBaseType = innerTypeAsArray.arrayBaseType;
        } else {
            this.arrayBaseType = innerType;
            this.depth = 0;
        }
    }
}
