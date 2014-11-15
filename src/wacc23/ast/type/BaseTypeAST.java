package wacc23.ast.type;

public class BaseTypeAST extends TypeAST {

    public BaseTypeAST(String type) {
        super(type);
    }

    public static BaseTypeAST makeIntType() {
        return new BaseTypeAST("int");
    }

    public static BaseTypeAST makeBoolType() {
        return new BaseTypeAST("bool");
    }

    public static BaseTypeAST makeCharType() {
        return new BaseTypeAST("char");
    }

    public static BaseTypeAST makeStringType() {
        return new BaseTypeAST("string");
    }

    // TODO: Write other get_Type methods
}
