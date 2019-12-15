package yalep.code.generate_image.operator;

import yalep.code.generate_image.TreeNodeType;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class OperatorImages {

    private final static String OPERATOR_IMAGES_PATH = "/operators/";
    private static Map<TreeNodeType, Image> nodeTypeToImage = new HashMap();

    public static void setup(OperatorStandards standard) {
        String fullPath = OPERATOR_IMAGES_PATH + standard.getFolder();
        setupNodeTypeToImage(fullPath);
    }

    public Image getOperatorImageByNodeType(TreeNodeType nodeType) {
        return nodeTypeToImage.get(nodeType);
    }

    private static void setupNodeTypeToImage(String fullPath) {
        try {
            nodeTypeToImage = new HashMap() {{
                for (TreeNodeType nodeType : TreeNodeType.values()) {
                    if (nodeType != TreeNodeType.VAR) {
                        Image image = ImageIO.read(getClass().getResource(fullPath + nodeType.getImageFileName()));
                        put(nodeType, image);
                    }
                nodeTypeToImage.put(TreeNodeType.VAR, null);
                }
            }};
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
