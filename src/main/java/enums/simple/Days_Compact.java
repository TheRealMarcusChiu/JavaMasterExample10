package enums.simple;

public enum Days_Compact implements Day {

    MONDAY(false),
    TUESDAY(false),
    WEDNESDAY(false),
    THURSDAY(false),
    FRIDAY(false),
    SATURDAY(true),
    SUNDAY(true);

    private Boolean isWeekend;

    Days_Compact(Boolean isWeekend) {
        this.isWeekend = isWeekend;
    }

    public Boolean isWeekend() {
        return isWeekend;
    }
}
