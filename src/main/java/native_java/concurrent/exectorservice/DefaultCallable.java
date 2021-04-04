package native_java.concurrent.exectorservice;

import java.util.concurrent.Callable;

public class DefaultCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        Thread.sleep(2000);
        return "DONE";
    }
}
