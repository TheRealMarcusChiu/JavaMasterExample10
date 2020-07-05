package native_java.exectorservice;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

/**
 * based on: https://www.baeldung.com/java-executor-service-tutorial
 */
public class Main {

    static Runnable runnableTask = () -> {
        try {
            TimeUnit.MILLISECONDS.sleep(300);
            System.out.println("Runnable Task");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    };

    static Callable<String> callableTask = () -> {
        TimeUnit.MILLISECONDS.sleep(300);
        System.out.println("Callable Task");
        return "Callable Task's Response";
    };

    static List<Callable<String>> callableTasks = new ArrayList<>(Arrays.asList(callableTask, callableTask, callableTask));

    @Test
    public void test1() throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.execute(runnableTask);
        Future<String> future = executor.submit(callableTask);
        List<Future<String>> futures = executor.invokeAll(callableTasks);
        executor.shutdown();

        System.out.println(future.get());
        for (Future<String> f : futures) {
            System.out.println(f.get());
        }
    }

    @Test
    public void test2() throws ExecutionException, InterruptedException {
        ScheduledExecutorService scheduledExecutor = Executors.newScheduledThreadPool(1);
        Future<String> future = (Future<String>) scheduledExecutor
                .scheduleAtFixedRate(runnableTask, 100, 450, TimeUnit.MILLISECONDS);
        scheduledExecutor.shutdown();

        System.out.println(future.get());
    }
}
