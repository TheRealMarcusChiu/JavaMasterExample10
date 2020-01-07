package powermock.whitebox;

public class Example1 {

    private Example2 example2;
    public Integer i;

    public Example1() {
        if(example2 == null) {
            example2 = new Example2();
        }
    }

    // called from testInvokeConstructor
    private Example1(Integer i) {
        this.i = i;
    }

    public String getMessage() throws Exception {
        String message = example2.getMessage();
        return message;
    }

    // called from testInvokeMethod
    private int sum(int a, int b) {
        return a+b;
    }
}
