package powermock.mock.newly.created.objects.within.method;

public class Example {

    public Integer example(Integer i) {
        Integer integerTwoReturn;

        SubExample subExample = new SubExample(i);
        integerTwoReturn = subExample.getInteger();

        return integerTwoReturn;
    }
}
