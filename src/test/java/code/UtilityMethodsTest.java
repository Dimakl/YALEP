package code;

import org.junit.Test;
import org.junit.Assert;

public class UtilityMethodsTest {
    @Test
    public void testManyBrackets() {
        String inp = "((((A&B))))", res = "A&B";
        Assert.assertEquals(UtilityMethods.deleteBrackets(inp), res);
    }

    @Test
    public void testNoBrackets() {
        String inp = "A&B", res = "A&B";
        Assert.assertEquals(UtilityMethods.deleteBrackets(inp), res);
    }

}
