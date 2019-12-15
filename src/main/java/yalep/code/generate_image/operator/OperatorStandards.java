package yalep.code.generate_image.operator;

public enum OperatorStandards {
    IEEE("ieee");

    private String folderName;

    OperatorStandards(String folderName) {
        this.folderName = folderName;
    }

    public String getFolder() {
        return folderName;
    }
}
