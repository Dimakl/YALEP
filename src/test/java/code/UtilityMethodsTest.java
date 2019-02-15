package code;

import org.junit.Test;
import org.junit.Assert;

public class UtilityMethodsTest {
    @Test
    protected void testManyBrackets() {
        String inp = "((((A&B))))", res = "A&B";
        Assert.assertEquals(UtilityMethods.deleteBrackets(inp), res);
    }

    @Test
    protected void testNoBrackets() {
        String inp = "A&B", res = "A&B";
        Assert.assertEquals(UtilityMethods.deleteBrackets(inp), res);
    }

//    @Test
//    protected void test

}
