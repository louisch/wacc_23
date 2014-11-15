package wacc23.ast;

import wacc23.SemanticErrorException;

public class TypeAST extends AST {

    private final String type;

    public TypeAST(String type){
        this.type = type;
    }

    public String getType(){
        return type;
    }

    @Override
    public void check() throws SemanticErrorException {

    }

    @Override
    public boolean equals(Object obj){
        boolean result = false;
        if(obj instanceof TypeAST){
            TypeAST newType = (TypeAST) obj;
            result = (newType.getType().equals(this.getType()));
        }
        return result;
    }

    @Override
    public int hashCode(){
        return type.hashCode();
    }


}
