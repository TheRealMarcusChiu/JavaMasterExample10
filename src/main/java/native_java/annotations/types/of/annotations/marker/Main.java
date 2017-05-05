package native_java.annotations.types.of.annotations.marker;

public class Main {
    public static void main(String[] args) {
        Example example = new Example();
    }
}

class Example {

    @Marker
    private Object object;
}
