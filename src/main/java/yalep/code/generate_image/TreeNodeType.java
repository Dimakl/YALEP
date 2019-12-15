package yalep.code.generate_image;

public enum TreeNodeType {
    VAR("no static image"),
    OR("or.png"),
    AND("and.png"),
    XOR("xor.png"),
    BUFFER("buffer.png"),
    NOT("not.png");

    private String imageFileName;

    TreeNodeType(String imageFileName) {
        this.imageFileName = imageFileName;
    }

    public String getImageFileName() {
        return imageFileName;
    }
}
