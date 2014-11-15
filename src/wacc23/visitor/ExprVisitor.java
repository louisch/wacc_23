package wacc23.visitor;

import antlr.WaccParser;
import org.antlr.v4.runtime.misc.NotNull;
import wacc23.ast.expr.*;

import java.util.ArrayList;
import java.util.List;

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
        return new NullAST();
    }

    @Override
    public ExprAST visitIdent(@NotNull WaccParser.IdentContext ctx) {
        return new IdentAST(ctx.IDENT().getText());
    }

    @Override
    public ExprAST visitArrayElemExpr(@NotNull WaccParser.ArrayElemExprContext ctx) {
        List<ExprAST> indicies = new ArrayList<>();
        for (WaccParser.ExprContext exprCtx : ctx.arrayElem().expr()) {
            indicies.add(visit(exprCtx));
        }
        return new ArrayElemAST(ctx.arrayElem().IDENT().getText(), indicies);
    }

    @Override
    public ExprAST visitBinOpMult(@NotNull WaccParser.BinOpMultContext ctx) {
        String actualOp = ctx.BINARY_OPER_MULT().getText();
        switch(actualOp) {
            case "*":
                return new BinOpAST(visit(ctx.expr(0)), visit(ctx.expr(1)), BinOp.MULT);
            case "/":
                return new BinOpAST(visit(ctx.expr(0)), visit(ctx.expr(1)), BinOp.DIV);
            case "%":
                return new BinOpAST(visit(ctx.expr(0)), visit(ctx.expr(1)), BinOp.MOD);
            default:
                throw new UnsupportedOperationException("\""
                        + actualOp + "\" is not a valid BinOpMult");
        }
    }

    @Override
    public ExprAST visitBinOpAdd(@NotNull WaccParser.BinOpAddContext ctx) {
        String actualOp = ctx.BINARY_OPER_ADD().getText();
        switch(actualOp) {
            case "+":
                return new BinOpAST(visit(ctx.expr(0)), visit(ctx.expr(1)), BinOp.PLUS);
            case "-":
                return new BinOpAST(visit(ctx.expr(0)), visit(ctx.expr(1)), BinOp.MINUS);
            default:
                throw new UnsupportedOperationException("\""
                        + actualOp + "\" is not a valid BinOpAdd");
        }
    }

    @Override
    public ExprAST visitBinOpGT(@NotNull WaccParser.BinOpGTContext ctx) {
            String actualOp = ctx.BINARY_OPER_GT().getText();
            switch(actualOp) {
                case ">":
                    return new BinOpAST(visit(ctx.expr(0)), visit(ctx.expr(1)), BinOp.GT);
                case ">=":
                    return new BinOpAST(visit(ctx.expr(0)), visit(ctx.expr(1)), BinOp.GTE);
                case "<":
                    return new BinOpAST(visit(ctx.expr(0)), visit(ctx.expr(1)), BinOp.LT);
                case "<=":
                    return new BinOpAST(visit(ctx.expr(0)), visit(ctx.expr(1)), BinOp.LTE);
                default:
                    throw new UnsupportedOperationException("\""
                            + actualOp + "\" is not a valid BinOpGT");
            }
    }

    @Override
    public ExprAST visitBinOpEQ(@NotNull WaccParser.BinOpEQContext ctx) {
        String actualOp = ctx.BINARY_OPER_EQ().getText();
        switch(actualOp) {
            case "==":
                return new BinOpAST(visit(ctx.expr(0)), visit(ctx.expr(1)), BinOp.EQ);
            case "!=":
                return new BinOpAST(visit(ctx.expr(0)), visit(ctx.expr(1)), BinOp.NEQ);
            default:
                throw new UnsupportedOperationException("\""
                        + actualOp + "\" is not a valid BinOpEQ");
        }
    }

    @Override
    public ExprAST visitBinOpAnd(@NotNull WaccParser.BinOpAndContext ctx) {
        String actualOp = ctx.BINARY_OPER_AND().getText();
        switch(actualOp) {
            case "&&":
                return new BinOpAST(visit(ctx.expr(0)), visit(ctx.expr(1)), BinOp.AND);
            case "||":
                return new BinOpAST(visit(ctx.expr(0)), visit(ctx.expr(1)), BinOp.OR);
            default:
                throw new UnsupportedOperationException("\""
                        + actualOp + "\" is not a valid BinOpAnd");
        }    }

    @Override
    public ExprAST visitUnOp(@NotNull WaccParser.UnOpContext ctx) {
        return super.visitUnOp(ctx);
    }

    @Override
    public ExprAST visitParens(@NotNull WaccParser.ParensContext ctx) {
        return super.visitParens(ctx);
    }
}