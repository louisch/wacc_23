package wacc23.visitor;

import antlr.WaccParser;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTree;
import wacc23.ast.ExprAST;
import wacc23.ast.IntAST;

public class ExprVisitor extends ParseTreeVisitor<ExprAST> {
    @Override
    public ExprAST visit(@NotNull ParseTree tree) {
        //should obviously figure out type of expression and call appropriate method
        return super.visit(tree);
    }

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
        return super.visitBool(ctx);
    }

    @Override
    public ExprAST visitChar(@NotNull WaccParser.CharContext ctx) {
        return super.visitChar(ctx);
    }

    @Override
    public ExprAST visitString(@NotNull WaccParser.StringContext ctx) {
        return super.visitString(ctx);
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