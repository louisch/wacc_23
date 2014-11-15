package wacc23.ast;

import wacc23.SemanticErrorException;

import java.util.List;

/**
 * Created by Anton A.
 */
public class ArrayElemAST extends ExprAST {
    private final String identifier;
    private final List<ExprAST> exprAST;

    public ArrayElemAST(String identifier, List<ExprAST> exprAST) {
        this.identifier = identifier;
        this.exprAST = exprAST;
    }

    @Override
    public void check() throws SemanticErrorException {
        super.check();
    }

    public String getIdentifier() {
        return identifier;
    }

    public List<ExprAST> getExprAST() {
        return exprAST;
    }

    @Override
    public TypeAST getType() {
//        maybe? return ArrayTypeAST.makeArrayElemType(TypeAST *insert type*, int *symtab lookup depth*);
//        TODO: Should this return ArrayTypeAST or TypeAST or something else?
//        e.g. int[] a     - the type of a[0] is "int", right? i.e. a BaseTypeAST
//        e.g. int[][] a   - the type of a[0] is now "int[]" i.e. an ArrayTypeAST
//        I think this should return a TypeAST, but I'm not sure.
//  Anton: It can, but you would have to look up the array declaration to find out the elem type
        return null;
    }
}