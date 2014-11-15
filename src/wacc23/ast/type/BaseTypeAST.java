package wacc23.ast.type;

public class BaseTypeAST extends TypeAST {

    public BaseTypeAST(String type) {
        super(type);
    }

    public static BaseTypeAST makeIntType() {
        return new BaseTypeAST("int");
    }

    // TODO: Write other get_Type methods
}