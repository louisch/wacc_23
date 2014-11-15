package wacc23.type;

public enum BaseTypeValue {
    INT ("int"),
    BOOL ("bool"),
    CHAR ("char"),
    STRING ("string");

    private String representation;

    BaseTypeValue(String representation) {
        this.representation = representation;
    }

    String getRepr() {
        return representation;
    }
}
