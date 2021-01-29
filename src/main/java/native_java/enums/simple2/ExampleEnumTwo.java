package native_java.enums.simple2;

public enum ExampleEnumTwo {
    LASER("PNG", "PDF", "GIF"),
    THERMAL("EPL2", "EPL2", "EPL2");

    private String fileType;
    private String oneFileType;
    private String twoFileType;

    ExampleEnumTwo(String fileType, String oneFileType, String twoFileType) {
        this.fileType = fileType;
        this.oneFileType = oneFileType;
        this.twoFileType = twoFileType;
    }

    public String getFileType(Integer i) {
        if(i == 1) {
            return oneFileType;
        }
        else if(i == 2) {
            return twoFileType;
        }
        return fileType;
    }
}
