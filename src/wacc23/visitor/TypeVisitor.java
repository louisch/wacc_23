package wacc23.visitor;

import antlr.WaccParser;
import org.antlr.v4.runtime.misc.NotNull;
import wacc23.ast.type.BaseTypeAST;
import wacc23.ast.type.TypeAST;

public class TypeVisitor extends ParseTreeVisitor<TypeAST> {

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
            type = ctx.INT().getText();
        }else{
            throw new IllegalArgumentException("No context found for BaseType");
        }

        return new BaseTypeAST(type);
    }
}
