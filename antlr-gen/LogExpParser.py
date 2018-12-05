# Generated from LogExp.g4 by ANTLR 4.5.3
# encoding: utf-8
from antlr4 import *
from io import StringIO


def serializedATN():
    with StringIO() as buf:
        buf.write("\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\13")
        buf.write("#\4\2\t\2\4\3\t\3\4\4\t\4\3\2\3\2\3\2\3\2\3\2\3\3\3\3")
        buf.write("\3\3\3\3\3\3\3\3\3\3\3\3\5\3\26\n\3\3\3\3\3\3\3\3\3\7")
        buf.write("\3\34\n\3\f\3\16\3\37\13\3\3\4\3\4\3\4\2\3\4\5\2\4\6\2")
        buf.write("\3\3\2\4\5\"\2\b\3\2\2\2\4\25\3\2\2\2\6 \3\2\2\2\b\t\5")
        buf.write("\4\3\2\t\n\7\3\2\2\n\13\7\n\2\2\13\f\7\2\2\3\f\3\3\2\2")
        buf.write("\2\r\16\b\3\1\2\16\17\7\7\2\2\17\20\5\4\3\2\20\21\7\b")
        buf.write("\2\2\21\26\3\2\2\2\22\23\7\6\2\2\23\26\5\4\3\5\24\26\7")
        buf.write("\t\2\2\25\r\3\2\2\2\25\22\3\2\2\2\25\24\3\2\2\2\26\35")
        buf.write("\3\2\2\2\27\30\f\4\2\2\30\31\5\6\4\2\31\32\5\4\3\5\32")
        buf.write("\34\3\2\2\2\33\27\3\2\2\2\34\37\3\2\2\2\35\33\3\2\2\2")
        buf.write("\35\36\3\2\2\2\36\5\3\2\2\2\37\35\3\2\2\2 !\t\2\2\2!\7")
        buf.write("\3\2\2\2\4\25\35")
        return buf.getvalue()


class LogExpParser(Parser):
    grammarFileName = "LogExp.g4"

    atn = ATNDeserializer().deserialize(serializedATN())

    decisionsToDFA = [DFA(ds, i) for i, ds in enumerate(atn.decisionToState)]

    sharedContextCache = PredictionContextCache()

    literalNames = ["<INVALID>", "'='", "<INVALID>", "<INVALID>", "<INVALID>",
                    "'('", "')'"]

    symbolicNames = ["<INVALID>", "<INVALID>", "AND", "OR", "NOT", "LPAREN",
                     "RPAREN", "IDENTIFIER", "BOOL", "WS"]

    RULE_parse = 0
    RULE_expression = 1
    RULE_binary = 2

    ruleNames = ["parse", "expression", "binary"]

    EOF = Token.EOF
    T__0 = 1
    AND = 2
    OR = 3
    NOT = 4
    LPAREN = 5
    RPAREN = 6
    IDENTIFIER = 7
    BOOL = 8
    WS = 9

    def __init__(self, input: TokenStream):
        super().__init__(input)
        self.checkVersion("4.5.3")
        self._interp = ParserATNSimulator(self, self.atn, self.decisionsToDFA, self.sharedContextCache)
        self._predicates = None

    class ParseContext(ParserRuleContext):

        def __init__(self, parser, parent: ParserRuleContext = None, invokingState: int = -1):
            super().__init__(parent, invokingState)
            self.parser = parser

        def expression(self):
            return self.getTypedRuleContext(LogExpParser.ExpressionContext, 0)

        def BOOL(self):
            return self.getToken(LogExpParser.BOOL, 0)

        def EOF(self):
            return self.getToken(LogExpParser.EOF, 0)

        def getRuleIndex(self):
            return LogExpParser.RULE_parse

        def enterRule(self, listener: ParseTreeListener):
            if hasattr(listener, "enterParse"):
                listener.enterParse(self)

        def exitRule(self, listener: ParseTreeListener):
            if hasattr(listener, "exitParse"):
                listener.exitParse(self)

    def parse(self):

        localctx = LogExpParser.ParseContext(self, self._ctx, self.state)
        self.enterRule(localctx, 0, self.RULE_parse)
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 6
            self.expression(0)
            self.state = 7
            self.match(LogExpParser.T__0)
            self.state = 8
            self.match(LogExpParser.BOOL)
            self.state = 9
            self.match(LogExpParser.EOF)
        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.exitRule()
        return localctx

    class ExpressionContext(ParserRuleContext):

        def __init__(self, parser, parent: ParserRuleContext = None, invokingState: int = -1):
            super().__init__(parent, invokingState)
            self.parser = parser

        def getRuleIndex(self):
            return LogExpParser.RULE_expression

        def copyFrom(self, ctx: ParserRuleContext):
            super().copyFrom(ctx)

    class BinaryExpressionContext(ExpressionContext):

        def __init__(self, parser, ctx: ParserRuleContext):  # actually a LogExpParser.ExpressionContext
            super().__init__(parser)
            self.left = None  # ExpressionContext
            self.op = None  # BinaryContext
            self.right = None  # ExpressionContext
            self.copyFrom(ctx)

        def expression(self, i: int = None):
            if i is None:
                return self.getTypedRuleContexts(LogExpParser.ExpressionContext)
            else:
                return self.getTypedRuleContext(LogExpParser.ExpressionContext, i)

        def binary(self):
            return self.getTypedRuleContext(LogExpParser.BinaryContext, 0)

        def enterRule(self, listener: ParseTreeListener):
            if hasattr(listener, "enterBinaryExpression"):
                listener.enterBinaryExpression(self)

        def exitRule(self, listener: ParseTreeListener):
            if hasattr(listener, "exitBinaryExpression"):
                listener.exitBinaryExpression(self)

    class IdentifierExpressionContext(ExpressionContext):

        def __init__(self, parser, ctx: ParserRuleContext):  # actually a LogExpParser.ExpressionContext
            super().__init__(parser)
            self.copyFrom(ctx)

        def IDENTIFIER(self):
            return self.getToken(LogExpParser.IDENTIFIER, 0)

        def enterRule(self, listener: ParseTreeListener):
            if hasattr(listener, "enterIdentifierExpression"):
                listener.enterIdentifierExpression(self)

        def exitRule(self, listener: ParseTreeListener):
            if hasattr(listener, "exitIdentifierExpression"):
                listener.exitIdentifierExpression(self)

    class NotExpressionContext(ExpressionContext):

        def __init__(self, parser, ctx: ParserRuleContext):  # actually a LogExpParser.ExpressionContext
            super().__init__(parser)
            self.copyFrom(ctx)

        def NOT(self):
            return self.getToken(LogExpParser.NOT, 0)

        def expression(self):
            return self.getTypedRuleContext(LogExpParser.ExpressionContext, 0)

        def enterRule(self, listener: ParseTreeListener):
            if hasattr(listener, "enterNotExpression"):
                listener.enterNotExpression(self)

        def exitRule(self, listener: ParseTreeListener):
            if hasattr(listener, "exitNotExpression"):
                listener.exitNotExpression(self)

    class ParenExpressionContext(ExpressionContext):

        def __init__(self, parser, ctx: ParserRuleContext):  # actually a LogExpParser.ExpressionContext
            super().__init__(parser)
            self.copyFrom(ctx)

        def LPAREN(self):
            return self.getToken(LogExpParser.LPAREN, 0)

        def expression(self):
            return self.getTypedRuleContext(LogExpParser.ExpressionContext, 0)

        def RPAREN(self):
            return self.getToken(LogExpParser.RPAREN, 0)

        def enterRule(self, listener: ParseTreeListener):
            if hasattr(listener, "enterParenExpression"):
                listener.enterParenExpression(self)

        def exitRule(self, listener: ParseTreeListener):
            if hasattr(listener, "exitParenExpression"):
                listener.exitParenExpression(self)

    def expression(self, _p: int = 0):
        _parentctx = self._ctx
        _parentState = self.state
        localctx = LogExpParser.ExpressionContext(self, self._ctx, _parentState)
        _prevctx = localctx
        _startState = 2
        self.enterRecursionRule(localctx, 2, self.RULE_expression, _p)
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 19
            token = self._input.LA(1)
            if token in [LogExpParser.LPAREN]:
                localctx = LogExpParser.ParenExpressionContext(self, localctx)
                self._ctx = localctx
                _prevctx = localctx

                self.state = 12
                self.match(LogExpParser.LPAREN)
                self.state = 13
                self.expression(0)
                self.state = 14
                self.match(LogExpParser.RPAREN)

            elif token in [LogExpParser.NOT]:
                localctx = LogExpParser.NotExpressionContext(self, localctx)
                self._ctx = localctx
                _prevctx = localctx
                self.state = 16
                self.match(LogExpParser.NOT)
                self.state = 17
                self.expression(3)

            elif token in [LogExpParser.IDENTIFIER]:
                localctx = LogExpParser.IdentifierExpressionContext(self, localctx)
                self._ctx = localctx
                _prevctx = localctx
                self.state = 18
                self.match(LogExpParser.IDENTIFIER)

            else:
                raise NoViableAltException(self)

            self._ctx.stop = self._input.LT(-1)
            self.state = 27
            self._errHandler.sync(self)
            _alt = self._interp.adaptivePredict(self._input, 1, self._ctx)
            while _alt != 2 and _alt != ATN.INVALID_ALT_NUMBER:
                if _alt == 1:
                    if self._parseListeners is not None:
                        self.triggerExitRuleEvent()
                    _prevctx = localctx
                    localctx = LogExpParser.BinaryExpressionContext(self,
                                                                    LogExpParser.ExpressionContext(self, _parentctx,
                                                                                                   _parentState))
                    localctx.left = _prevctx
                    self.pushNewRecursionContext(localctx, _startState, self.RULE_expression)
                    self.state = 21
                    if not self.precpred(self._ctx, 2):
                        from antlr4.error.Errors import FailedPredicateException
                        raise FailedPredicateException(self, "self.precpred(self._ctx, 2)")
                    self.state = 22
                    localctx.op = self.binary()
                    self.state = 23
                    localctx.right = self.expression(3)
                self.state = 29
                self._errHandler.sync(self)
                _alt = self._interp.adaptivePredict(self._input, 1, self._ctx)

        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.unrollRecursionContexts(_parentctx)
        return localctx

    class BinaryContext(ParserRuleContext):

        def __init__(self, parser, parent: ParserRuleContext = None, invokingState: int = -1):
            super().__init__(parent, invokingState)
            self.parser = parser

        def AND(self):
            return self.getToken(LogExpParser.AND, 0)

        def OR(self):
            return self.getToken(LogExpParser.OR, 0)

        def getRuleIndex(self):
            return LogExpParser.RULE_binary

        def enterRule(self, listener: ParseTreeListener):
            if hasattr(listener, "enterBinary"):
                listener.enterBinary(self)

        def exitRule(self, listener: ParseTreeListener):
            if hasattr(listener, "exitBinary"):
                listener.exitBinary(self)

    def binary(self):

        localctx = LogExpParser.BinaryContext(self, self._ctx, self.state)
        self.enterRule(localctx, 4, self.RULE_binary)
        self._la = 0  # Token type
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 30
            _la = self._input.LA(1)
            if not (_la == LogExpParser.AND or _la == LogExpParser.OR):
                self._errHandler.recoverInline(self)
            else:
                self.consume()
        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.exitRule()
        return localctx

    def sempred(self, localctx: RuleContext, ruleIndex: int, predIndex: int):
        if self._predicates == None:
            self._predicates = dict()
        self._predicates[1] = self.expression_sempred
        pred = self._predicates.get(ruleIndex, None)
        if pred is None:
            raise Exception("No predicate with index:" + str(ruleIndex))
        else:
            return pred(localctx, predIndex)

    def expression_sempred(self, localctx: ExpressionContext, predIndex: int):
        if predIndex == 0:
            return self.precpred(self._ctx, 2)
