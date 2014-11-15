package wacc23.visitor;

import antlr.WaccParser;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTree;
import wacc23.ast.type.ArrayTypeAST;
import wacc23.ast.type.BaseTypeAST;
import wacc23.ast.type.PairTypeAST;
import wacc23.ast.type.TypeAST;

public class TypeVisitor extends ParseTreeVisitor<TypeAST> {
    @Override
    public TypeAST visit(@NotNull ParseTree tree) {
        if (tree instanceof WaccParser.TypeContext) {
            WaccParser.TypeContext ctx = (WaccParser.TypeContext) tree;
            if (ctx.arrayType() != null) {
                return visitArrayType(ctx.arrayType());
            } else if (ctx.baseType() != null) {
                return visitBaseType(ctx.baseType());
            } else if (ctx.pairType() != null) {
                return visitPairType(ctx.pairType());
            } else {
                throw new IllegalArgumentException("No context found for TypeContext");
            }
        } else {
            throw new IllegalArgumentException("TypeVisitor: non-type found where type expected.");
        }
    }

    @Override
    public TypeAST visitBaseType(@NotNull WaccParser.BaseTypeContext ctx) {
        String type;
        if(ctx.BOOL() != null){
            type = ctx.BOOL().getText();
        }else if(ctx.CHAR() != null){
            type = ctx.CHAR().getText();
        }else if(ctx.INT() != null){
            type = ctx.INT().getText();
        }else if(ctx.STRING() != null) {
            type = ctx.STRING().getText();
        }else{
            throw new IllegalArgumentException("No context found for BaseType");
        }

        return new BaseTypeAST(type);
    }

    @Override
    public TypeAST visitArrayType(@NotNull WaccParser.ArrayTypeContext ctx) {
        TypeAST type;
        int depth = 1;
        while (ctx.arrayType() != null) {
            ctx = ctx.arrayType();
            ++depth;
        }
        if (ctx.baseType() != null) {
            type = visitBaseType(ctx.baseType());
        } else if (ctx.pairType() != null) {
            type = visitPairType(ctx.pairType());
        } else {
            throw new IllegalArgumentException("No context found for ArrayType");
        }
        return ArrayTypeAST.makeArrayElemType(type, depth);
    }

    @Override
    public TypeAST visitPairType(@NotNull WaccParser.PairTypeContext ctx) {
        String fst = getPairType(ctx.pairElemType(0));
        String snd = getPairType(ctx.pairElemType(1));
        return new PairTypeAST(fst, snd);
    }

    private String getPairType(WaccParser.PairElemTypeContext pairElemTypeContext) {
        if (pairElemTypeContext.PAIR() != null) {
            return pairElemTypeContext.PAIR().getText();
        } else if (pairElemTypeContext.baseType() != null) {
            return new TypeVisitor().visitBaseType(pairElemTypeContext.baseType()).getType();
        } else if (pairElemTypeContext.arrayType() != null) {
            return new TypeVisitor().visitArrayType(pairElemTypeContext.arrayType()).getType();
        } else {
            throw new IllegalArgumentException("No context found for PairType");
        }
    }
}
