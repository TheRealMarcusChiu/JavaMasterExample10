package native_java.annotations.types.of.annotations.single.value;

/**
 * An annotation that has one method, is called single-value annotation
 */
public @interface SingleValue {
    int value();

    // or we can default to 0
    // int value() default 0;
}
