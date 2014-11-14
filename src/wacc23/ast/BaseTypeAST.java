package wacc23.ast;

public class BaseTypeAST extends TypeAST {

    public BaseTypeAST(String type) {
        super(type);
    }

    public static BaseTypeAST getIntType() {
        return new BaseTypeAST("int");
    }

    // TODO: Write other get_Type methods
}

