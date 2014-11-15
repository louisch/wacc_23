package wacc23.ast.expr;

import wacc23.SemanticErrorException;
import wacc23.SymbolTable;
import wacc23.type.Type;

import java.util.List;

public class ArrayElemAST extends ExprAST {
    private final String identifier;
    private final List<ExprAST> indices;

    public ArrayElemAST(String identifier, List<ExprAST> indices) {
        this.identifier = identifier;
        this.indices = indices;
    }

    @Override
    public void check(SymbolTable funcSymTable, SymbolTable varSymTable)
            throws SemanticErrorException {
        // check that index is of type int
    }

    public String getIdentifier() {
        return identifier;
    }

    public List<ExprAST> getIndices() {
        return indices;
    }

    @Override
    public Type getType() {
//        maybe? return ArrayTypeAST.makeArrayElemType(TypeAST *insert type*, int *symtab lookup depth*);
//        TODO: Should this return ArrayTypeAST or TypeAST or something else?
//        e.g. int[] a     - the type of a[0] is "int", right? i.e. a BaseTypeAST
//        e.g. int[][] a   - the type of a[0] is now "int[]" i.e. an ArrayTypeAST
//        I think this should return a TypeAST, but I'm not sure.
//  Anton: It can, but you would have to look up the array declaration to find out the elem type
        return null;
    }
}
