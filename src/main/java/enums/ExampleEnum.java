package enums;

public enum ExampleEnum {

    ONE(false),
    TWO(false),
    THREE(false),
    FOUR(false),
    FIVE(false),
    SIX(true),
    SEVEN(true),
    EIGHT(true),
    NINE(false),
    TEN(false);

    private Boolean secret;

    ExampleEnum(Boolean secret) {
        this.secret = secret;
    }

    public Boolean isSecret() {
        return secret;
    }
}
