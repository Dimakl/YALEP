// Generated from /home/dimakl/IdeaProjects/inflate-my-mind/src/main/java/com/inflatemymind/antlr/LogicalExpression.g4 by ANTLR 4.7.2
package yalep.antlr.generated;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class LogicalExpressionParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		LPAREN=1, RPAREN=2, NOT=3, AND=4, OR=5, XOR=6, VARIABLE=7;
	public static final int
		RULE_eval = 0, RULE_expression = 1;
	private static String[] makeRuleNames() {
		return new String[] {
			"eval", "expression"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", "'!'", "'&'", "'|'", "'^'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "LPAREN", "RPAREN", "NOT", "AND", "OR", "XOR", "VARIABLE"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "LogicalExpression.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public LogicalExpressionParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class EvalContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode EOF() { return getToken(LogicalExpressionParser.EOF, 0); }
		public EvalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eval; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LogicalExpressionListener ) ((LogicalExpressionListener)listener).enterEval(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LogicalExpressionListener ) ((LogicalExpressionListener)listener).exitEval(this);
		}
	}

	public final EvalContext eval() throws RecognitionException {
		EvalContext _localctx = new EvalContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_eval);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(4);
			expression(0);
			setState(5);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	 
		public ExpressionContext() { }
		public void copyFrom(ExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ORContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode OR() { return getToken(LogicalExpressionParser.OR, 0); }
		public ORContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LogicalExpressionListener ) ((LogicalExpressionListener)listener).enterOR(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LogicalExpressionListener ) ((LogicalExpressionListener)listener).exitOR(this);
		}
	}
	public static class PARENSContext extends ExpressionContext {
		public TerminalNode LPAREN() { return getToken(LogicalExpressionParser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(LogicalExpressionParser.RPAREN, 0); }
		public List<TerminalNode> NOT() { return getTokens(LogicalExpressionParser.NOT); }
		public TerminalNode NOT(int i) {
			return getToken(LogicalExpressionParser.NOT, i);
		}
		public PARENSContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LogicalExpressionListener ) ((LogicalExpressionListener)listener).enterPARENS(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LogicalExpressionListener ) ((LogicalExpressionListener)listener).exitPARENS(this);
		}
	}
	public static class VARIABLEContext extends ExpressionContext {
		public TerminalNode VARIABLE() { return getToken(LogicalExpressionParser.VARIABLE, 0); }
		public List<TerminalNode> NOT() { return getTokens(LogicalExpressionParser.NOT); }
		public TerminalNode NOT(int i) {
			return getToken(LogicalExpressionParser.NOT, i);
		}
		public VARIABLEContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LogicalExpressionListener ) ((LogicalExpressionListener)listener).enterVARIABLE(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LogicalExpressionListener ) ((LogicalExpressionListener)listener).exitVARIABLE(this);
		}
	}
	public static class ANDContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode AND() { return getToken(LogicalExpressionParser.AND, 0); }
		public ANDContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LogicalExpressionListener ) ((LogicalExpressionListener)listener).enterAND(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LogicalExpressionListener ) ((LogicalExpressionListener)listener).exitAND(this);
		}
	}
	public static class XORContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode XOR() { return getToken(LogicalExpressionParser.XOR, 0); }
		public XORContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LogicalExpressionListener ) ((LogicalExpressionListener)listener).enterXOR(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LogicalExpressionListener ) ((LogicalExpressionListener)listener).exitXOR(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 2;
		enterRecursionRule(_localctx, 2, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(25);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				{
				_localctx = new PARENSContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(11);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NOT) {
					{
					{
					setState(8);
					match(NOT);
					}
					}
					setState(13);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(14);
				match(LPAREN);
				setState(15);
				expression(0);
				setState(16);
				match(RPAREN);
				}
				break;
			case 2:
				{
				_localctx = new VARIABLEContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(21);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NOT) {
					{
					{
					setState(18);
					match(NOT);
					}
					}
					setState(23);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(24);
				match(VARIABLE);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(38);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(36);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
					case 1:
						{
						_localctx = new XORContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(27);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(28);
						match(XOR);
						setState(29);
						expression(6);
						}
						break;
					case 2:
						{
						_localctx = new ANDContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(30);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(31);
						match(AND);
						setState(32);
						expression(5);
						}
						break;
					case 3:
						{
						_localctx = new ORContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(33);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(34);
						match(OR);
						setState(35);
						expression(4);
						}
						break;
					}
					} 
				}
				setState(40);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 1:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 5);
		case 1:
			return precpred(_ctx, 4);
		case 2:
			return precpred(_ctx, 3);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\t,\4\2\t\2\4\3\t"+
		"\3\3\2\3\2\3\2\3\3\3\3\7\3\f\n\3\f\3\16\3\17\13\3\3\3\3\3\3\3\3\3\3\3"+
		"\7\3\26\n\3\f\3\16\3\31\13\3\3\3\5\3\34\n\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\7\3\'\n\3\f\3\16\3*\13\3\3\3\2\3\4\4\2\4\2\2\2/\2\6\3\2\2\2"+
		"\4\33\3\2\2\2\6\7\5\4\3\2\7\b\7\2\2\3\b\3\3\2\2\2\t\r\b\3\1\2\n\f\7\5"+
		"\2\2\13\n\3\2\2\2\f\17\3\2\2\2\r\13\3\2\2\2\r\16\3\2\2\2\16\20\3\2\2\2"+
		"\17\r\3\2\2\2\20\21\7\3\2\2\21\22\5\4\3\2\22\23\7\4\2\2\23\34\3\2\2\2"+
		"\24\26\7\5\2\2\25\24\3\2\2\2\26\31\3\2\2\2\27\25\3\2\2\2\27\30\3\2\2\2"+
		"\30\32\3\2\2\2\31\27\3\2\2\2\32\34\7\t\2\2\33\t\3\2\2\2\33\27\3\2\2\2"+
		"\34(\3\2\2\2\35\36\f\7\2\2\36\37\7\b\2\2\37\'\5\4\3\b !\f\6\2\2!\"\7\6"+
		"\2\2\"\'\5\4\3\7#$\f\5\2\2$%\7\7\2\2%\'\5\4\3\6&\35\3\2\2\2& \3\2\2\2"+
		"&#\3\2\2\2\'*\3\2\2\2(&\3\2\2\2()\3\2\2\2)\5\3\2\2\2*(\3\2\2\2\7\r\27"+
		"\33&(";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}