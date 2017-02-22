package test.mockito.privatevariable;

public class Example1 {

    private Example2 example2;

    public void SandBox1() {
        if(example2 == null) {
            example2 = new Example2();
        }
    }

    public String getMessage() throws Exception {
        String message = example2.getMessage();
        return message;
    }
}
