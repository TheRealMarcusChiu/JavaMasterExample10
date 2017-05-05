package annotations.types.of.annotations.multi.value;

public class Main {

    public static void main(String[] args) {
        Example example = new Example();
    }
}

class Example {

    @MultiValue(string = "marcus")
    private Object object;
}
