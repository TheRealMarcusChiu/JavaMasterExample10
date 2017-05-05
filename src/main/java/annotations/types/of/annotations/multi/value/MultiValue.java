package annotations.types.of.annotations.multi.value;

public @interface MultiValue {
    int value() default 10;
    String string();
    String[] params() default {};
}
