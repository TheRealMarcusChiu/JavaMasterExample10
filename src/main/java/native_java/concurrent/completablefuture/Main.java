package native_java.concurrent.completablefuture;

import org.junit.Test;

import java.util.concurrent.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Main {

    public Future<String> calculateAsyncWithCancellation() {
        CompletableFuture<String> completableFuture = new CompletableFuture<>();

        Executors.newCachedThreadPool().submit(() -> {
            Thread.sleep(500);
            completableFuture.cancel(false);
            return null;
        });

        return completableFuture;
    }

    @Test(expected = CancellationException.class)
    public void test1() throws ExecutionException, InterruptedException {
        Future<String> future = calculateAsyncWithCancellation();
        String str = future.get(); // CancellationException
        System.out.println(str);
    }

    @Test
    public void chainingAsyncComputations() throws ExecutionException, InterruptedException {
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> "Hello");
        completableFuture = completableFuture.thenApply(s -> s + " World");
        assertEquals("Hello World", completableFuture.get());
    }

    @Test
    public void chainingAsyncComputation_returnVoid() throws ExecutionException, InterruptedException {
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> "Hello");
        CompletableFuture<Void> future = completableFuture.thenAccept(s -> System.out.println("first computation returned: " + s));
        Void t = future.get();
    }

    @Test
    public void chainingCompletableFutures() throws ExecutionException, InterruptedException {
        CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(() -> "Hello");
        CompletableFuture<String> chainedCF = cf1.thenCompose(s -> CompletableFuture.supplyAsync(() -> s + " World"));
        assertEquals("Hello World", chainedCF.get());
    }

    @Test
    public void combiningIndependentCompletableFutures() throws ExecutionException, InterruptedException {
        CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(() -> "Hello");
        CompletableFuture<String> cf2 = CompletableFuture.supplyAsync(() -> " World");
        CompletableFuture<String> combinedCF = cf1.thenCombine(cf2, (s1, s2) -> s1 + s2);
        assertEquals("Hello World", combinedCF.get());
    }

    @Test
    public void runningCompletableFuturesInParallel() throws ExecutionException, InterruptedException {
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> "Hello");
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> "Beautiful");
        CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> "World");

        CompletableFuture<Void> combinedFuture = CompletableFuture.allOf(future1, future2, future3);

        combinedFuture.get();

        assertTrue(future1.isDone());
        assertTrue(future2.isDone());
        assertTrue(future3.isDone());
    }

    @Test
    public void handlingExceptions() throws ExecutionException, InterruptedException {
        String name = null;
        // ...
        CompletableFuture<String> completableFuture =  CompletableFuture.supplyAsync(() -> {
            if (name == null) {
                throw new RuntimeException("Computation error!");
            }
            return "Hello, " + name;
        }).handle((s, t) -> s != null ? s : "Hello, Stranger!");

        assertEquals("Hello, Stranger!", completableFuture.get());
    }
}
