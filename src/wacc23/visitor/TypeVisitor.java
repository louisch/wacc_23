package wacc23.visitor;

import antlr.WaccParser;
import org.antlr.v4.runtime.misc.NotNull;
import wacc23.type.*;

public class TypeVisitor extends ParseTreeVisitor<Type> {

    @Override
    public Type visitBaseType(@NotNull WaccParser.BaseTypeContext ctx) {
        if (ctx.BOOL() != null) {
            return new BaseType(BaseTypeValue.BOOL);
        } else if(ctx.CHAR() != null) {
            return new BaseType(BaseTypeValue.CHAR);
        } else if(ctx.INT() != null) {
            return new BaseType(BaseTypeValue.INT);
        } else if(ctx.STRING() != null) {
            return new BaseType(BaseTypeValue.STRING);
        } else {
            throw new IllegalArgumentException("Was given BaseType did not " +
                "match any of the known BaseTypes.");
        }
    }

    @Override
    public Type visitArrayType(@NotNull WaccParser.ArrayTypeContext ctx) {
        if (ctx.baseType() != null) {
            return new ArrayType(visit(ctx.baseType()));
        } else if (ctx.pairType() != null) {
            return new ArrayType(visit(ctx.pairType()));
        } else if (ctx.arrayType() != null) {
            return new ArrayType(visit(ctx.arrayType()));
        } else {
            throw new IllegalArgumentException("Was given an array type that " +
                "did not match any of the known array types.");
        }
    }

    @Override
    public Type visitPairType(@NotNull WaccParser.PairTypeContext ctx) {
        Type fst = visit(ctx.pairElemType(0));
        Type snd = visit(ctx.pairElemType(1));
        return new PairType(fst, snd);
    }
}
