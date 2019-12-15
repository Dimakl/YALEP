package yalep.code;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import yalep.exceptions.WrongExpressionFormatException;

import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.*;

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
                {"A|B=3", Result.FAIL},
                {"AandB=1", Result.FAIL},
        });
    }


    @Test
    public void testExpressionChecker() {
        System.out.println("running test for " + expression);
        try {
            LogicalExpressionValidityChecker.expressionIsValid(expression);
            assertEquals(result, Result.SUCCESS);
        } catch (WrongExpressionFormatException e) {
            assertEquals(result, Result.FAIL);
        }
    }

    private enum Result {
        SUCCESS,
        FAIL
    }
}
