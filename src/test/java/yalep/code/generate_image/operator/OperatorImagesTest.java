package yalep.code.generate_image.operator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import yalep.code.generate_image.TreeNodeType;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class OperatorImagesTest {

    private TreeNodeType treeNodeType;

    public OperatorImagesTest(TreeNodeType treeNodeType) {
        this.treeNodeType = treeNodeType;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> getTestData() {
        String rawImagePath = "/operators/ieee/";
        List list = Arrays.asList(TreeNodeType.values());
        return list;
    }

    @Test
    public void testExpressionChecker() {
        OperatorImages.setup(OperatorStandards.IEEE);
        System.out.println("running test for " + treeNodeType.toString());
        if (treeNodeType == TreeNodeType.VAR) {
            assertNull("Unexpected behavior", OperatorImages.getOperatorImageByNodeType(treeNodeType));
        } else {
            assertNotNull("No such file", OperatorImages.getOperatorImageByNodeType(treeNodeType));
        }
        System.out.println("OK");
    }
}
