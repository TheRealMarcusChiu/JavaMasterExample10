package annotations.types.of.annotations.single.value;

public class Main {

    public static void main(String[] args) {
        Example example = new Example();
    }
}

class Example {

    @SingleValue(value=10)
    private Object object;
}
