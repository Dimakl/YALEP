# Generated from LogExp.g4 by ANTLR 4.5.3
from antlr4 import *

if __name__ is not None and "." in __name__:
    from .LogExpParser import LogExpParser
else:
    from LogExpParser import LogExpParser


# This class defines a complete listener for a parse tree produced by LogExpParser.
class LogExpListener(ParseTreeListener):

    # Enter a parse tree produced by LogExpParser#parse.
    def enterParse(self, ctx: LogExpParser.ParseContext):
        pass

    # Exit a parse tree produced by LogExpParser#parse.
    def exitParse(self, ctx: LogExpParser.ParseContext):
        pass

    # Enter a parse tree produced by LogExpParser#binaryExpression.
    def enterBinaryExpression(self, ctx: LogExpParser.BinaryExpressionContext):
        pass

    # Exit a parse tree produced by LogExpParser#binaryExpression.
    def exitBinaryExpression(self, ctx: LogExpParser.BinaryExpressionContext):
        pass

    # Enter a parse tree produced by LogExpParser#identifierExpression.
    def enterIdentifierExpression(self, ctx: LogExpParser.IdentifierExpressionContext):
        pass

    # Exit a parse tree produced by LogExpParser#identifierExpression.
    def exitIdentifierExpression(self, ctx: LogExpParser.IdentifierExpressionContext):
        pass

    # Enter a parse tree produced by LogExpParser#notExpression.
    def enterNotExpression(self, ctx: LogExpParser.NotExpressionContext):
        pass

    # Exit a parse tree produced by LogExpParser#notExpression.
    def exitNotExpression(self, ctx: LogExpParser.NotExpressionContext):
        pass

    # Enter a parse tree produced by LogExpParser#parenExpression.
    def enterParenExpression(self, ctx: LogExpParser.ParenExpressionContext):
        pass

    # Exit a parse tree produced by LogExpParser#parenExpression.
    def exitParenExpression(self, ctx: LogExpParser.ParenExpressionContext):
        pass

    # Enter a parse tree produced by LogExpParser#binary.
    def enterBinary(self, ctx: LogExpParser.BinaryContext):
        pass

    # Exit a parse tree produced by LogExpParser#binary.
    def exitBinary(self, ctx: LogExpParser.BinaryContext):
        pass
