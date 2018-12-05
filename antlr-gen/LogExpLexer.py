# Generated from LogExp.g4 by ANTLR 4.5.3
from antlr4 import *
from io import StringIO


def serializedATN():
    with StringIO() as buf:
        buf.write("\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\13")
        buf.write("?\b\1\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7")
        buf.write("\4\b\t\b\4\t\t\t\4\n\t\n\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3")
        buf.write("\3\3\3\5\3\37\n\3\3\4\3\4\3\4\3\4\3\4\5\4&\n\4\3\5\3\5")
        buf.write("\3\5\3\5\3\5\3\5\3\5\5\5/\n\5\3\6\3\6\3\7\3\7\3\b\3\b")
        buf.write("\3\t\3\t\3\n\6\n:\n\n\r\n\16\n;\3\n\3\n\2\2\13\3\3\5\4")
        buf.write("\7\5\t\6\13\7\r\b\17\t\21\n\23\13\3\2\5\3\2C\\\3\2\62")
        buf.write("\63\5\2\13\f\16\17\"\"E\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3")
        buf.write("\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2")
        buf.write("\2\2\21\3\2\2\2\2\23\3\2\2\2\3\25\3\2\2\2\5\36\3\2\2\2")
        buf.write("\7%\3\2\2\2\t.\3\2\2\2\13\60\3\2\2\2\r\62\3\2\2\2\17\64")
        buf.write("\3\2\2\2\21\66\3\2\2\2\239\3\2\2\2\25\26\7?\2\2\26\4\3")
        buf.write("\2\2\2\27\30\7c\2\2\30\31\7p\2\2\31\37\7f\2\2\32\33\7")
        buf.write("C\2\2\33\34\7P\2\2\34\37\7F\2\2\35\37\7(\2\2\36\27\3\2")
        buf.write("\2\2\36\32\3\2\2\2\36\35\3\2\2\2\37\6\3\2\2\2 !\7q\2\2")
        buf.write("!&\7t\2\2\"#\7Q\2\2#&\7T\2\2$&\7~\2\2% \3\2\2\2%\"\3\2")
        buf.write("\2\2%$\3\2\2\2&\b\3\2\2\2\'(\7p\2\2()\7q\2\2)/\7v\2\2")
        buf.write("*+\7P\2\2+,\7Q\2\2,/\7V\2\2-/\7`\2\2.\'\3\2\2\2.*\3\2")
        buf.write("\2\2.-\3\2\2\2/\n\3\2\2\2\60\61\7*\2\2\61\f\3\2\2\2\62")
        buf.write("\63\7+\2\2\63\16\3\2\2\2\64\65\t\2\2\2\65\20\3\2\2\2\66")
        buf.write("\67\t\3\2\2\67\22\3\2\2\28:\t\4\2\298\3\2\2\2:;\3\2\2")
        buf.write("\2;9\3\2\2\2;<\3\2\2\2<=\3\2\2\2=>\b\n\2\2>\24\3\2\2\2")
        buf.write("\7\2\36%.;\3\b\2\2")
        return buf.getvalue()


class LogExpLexer(Lexer):
    atn = ATNDeserializer().deserialize(serializedATN())

    decisionsToDFA = [DFA(ds, i) for i, ds in enumerate(atn.decisionToState)]

    T__0 = 1
    AND = 2
    OR = 3
    NOT = 4
    LPAREN = 5
    RPAREN = 6
    IDENTIFIER = 7
    BOOL = 8
    WS = 9

    modeNames = ["DEFAULT_MODE"]

    literalNames = ["<INVALID>",
                    "'='", "'('", "')'"]

    symbolicNames = ["<INVALID>",
                     "AND", "OR", "NOT", "LPAREN", "RPAREN", "IDENTIFIER", "BOOL",
                     "WS"]

    ruleNames = ["T__0", "AND", "OR", "NOT", "LPAREN", "RPAREN", "IDENTIFIER",
                 "BOOL", "WS"]

    grammarFileName = "LogExp.g4"

    def __init__(self, input=None):
        super().__init__(input)
        self.checkVersion("4.5.3")
        self._interp = LexerATNSimulator(self, self.atn, self.decisionsToDFA, PredictionContextCache())
        self._actions = None
        self._predicates = None
