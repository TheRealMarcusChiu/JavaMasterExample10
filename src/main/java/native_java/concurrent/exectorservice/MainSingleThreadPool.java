package native_java.concurrent.exectorservice;

import java.util.concurrent.*;

public class MainSingleThreadPool {

    private static final ExecutorService es = new ThreadPoolExecutor(
            1,
            1,
            0L,
            TimeUnit.MILLISECONDS,
            new SynchronousQueue<>());

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("submitting job1");
        Future<String> future1 = submit(new DefaultCallable());
        System.out.println("submitting job2");
        Future<String> future2 = submit(new DefaultCallable());
        es.shutdown();
        System.out.println(future1.get());
        System.out.println(future2.get());
    }

    private static Future<String> submit(Callable<String> callable) {
        try {
            return es.submit(callable);
        } catch (RejectedExecutionException e) {
            return CompletableFuture.completedFuture("REJECTED");
        }
    }

    private static Future<String> submit(Runnable runnable) {
        try {
            return es.submit(runnable, "COMPLETED");
        } catch (RejectedExecutionException e) {
            return CompletableFuture.completedFuture("REJECTED");
        }
    }
}
