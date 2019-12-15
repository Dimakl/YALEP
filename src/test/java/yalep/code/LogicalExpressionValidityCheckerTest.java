package yalep.code;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import yalep.exceptions.WrongExpressionFormatException;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class LogicalExpressionValidityCheckerTest {

    private String expression;
    private Result result;

    public LogicalExpressionValidityCheckerTest(String expression, Result result) {
        this.expression = expression;
        this.result = result;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> getTestData() {
        return Arrays.asList(new Object[][] {
                {"A&B=1", Result.SUCCESS},
                {"A&B&C&D=0", Result.SUCCESS},
                {"A=1", Result.SUCCESS},
                {"A & B = 0", Result.SUCCESS},
                {"1", Result.FAIL},
                {"A&&B=1", Result.FAIL},
                {"expression=1", Result.FAIL},
                {"ABC=1", Result.FAIL},
                {"A|B=3", Result.SUCCESS},
                {"AandB=1", Result.FAIL},
        });
    }


    @Test
    public void testExpressionChecker() {
        System.out.println("running test for " + expression);
        try {
            LogicalExpressionValidityChecker.expressionIsValid(expression);
            assert result == Result.SUCCESS : "No expected format exception";
        } catch (WrongExpressionFormatException e) {
            assert result == Result.FAIL : "Unexpected format exception";
        }
    }

    private enum Result {
        SUCCESS,
        FAIL;
    }
}
