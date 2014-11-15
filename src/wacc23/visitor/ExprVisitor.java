package wacc23.visitor;

import antlr.WaccParser;
import org.antlr.v4.runtime.misc.NotNull;
import wacc23.ast.expr.*;

public class ExprVisitor extends ParseTreeVisitor<ExprAST> {
    @Override
    public ExprAST visitInt(@NotNull WaccParser.IntContext ctx) {
        try {
            int i = Integer.parseInt(ctx.getText());
            return new IntAST(i);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Incorrect number format supplied. Possible integer overflow.");
        }
    }

    @Override
    public ExprAST visitBool(@NotNull WaccParser.BoolContext ctx) {
        return new BoolAST(ctx.BOOL_LITER().getText().equals("true"));
    }

    @Override
    public ExprAST visitChar(@NotNull WaccParser.CharContext ctx) {
        if (ctx.CHAR_LITER().getText().length() > 1) {
            throw new IllegalArgumentException("Looking for char, but found string.");
        }
        return new CharAST(ctx.CHAR_LITER().getText().charAt(0));
    }

    @Override
    public ExprAST visitString(@NotNull WaccParser.StringContext ctx) {
        return new StringAST(ctx.STR_LITER().getText());
    }

    @Override
    public ExprAST visitPair(@NotNull WaccParser.PairContext ctx) {
        return super.visitPair(ctx);
    }

    @Override
    public ExprAST visitIdent(@NotNull WaccParser.IdentContext ctx) {
        return super.visitIdent(ctx);
    }

    @Override
    public ExprAST visitArrayElemExpr(@NotNull WaccParser.ArrayElemExprContext ctx) {
        return super.visitArrayElemExpr(ctx);
    }

    @Override
    public ExprAST visitBinOpMult(@NotNull WaccParser.BinOpMultContext ctx) {
        return super.visitBinOpMult(ctx);
    }

    @Override
    public ExprAST visitBinOpAdd(@NotNull WaccParser.BinOpAddContext ctx) {
        return super.visitBinOpAdd(ctx);
    }

    @Override
    public ExprAST visitBinOpGT(@NotNull WaccParser.BinOpGTContext ctx) {
        return super.visitBinOpGT(ctx);
    }

    @Override
    public ExprAST visitBinOpEQ(@NotNull WaccParser.BinOpEQContext ctx) {
        return super.visitBinOpEQ(ctx);
    }

    @Override
    public ExprAST visitBinOpAnd(@NotNull WaccParser.BinOpAndContext ctx) {
        return super.visitBinOpAnd(ctx);
    }


}