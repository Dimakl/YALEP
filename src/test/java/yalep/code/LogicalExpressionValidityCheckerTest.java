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
    private Boolean mustFail;

    public LogicalExpressionValidityCheckerTest(String expression, Boolean mustFail) {
        this.expression = expression;
        this.mustFail = mustFail;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> getTestData() {
        return Arrays.asList(new Object[][] {
                {"A=1", false},
                {"A&B=0", false},
                {"1", true},
                {"A&&B=1", true},
                {"expression=1", true},
                {"A|B=3", true}
        });
    }


    @Test
    public void testExpressionChecker() {
        System.out.println("running test for " + expression);
        try {
            LogicalExpressionValidityChecker.expressionIsValid(expression);
            Assert.assertEquals(mustFail, false);
        } catch (WrongExpressionFormatException e) {
            Assert.assertEquals(mustFail, true);
        }
    }
}
