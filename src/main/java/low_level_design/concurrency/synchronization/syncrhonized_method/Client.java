package low_level_design.concurrency.synchronization.syncrhonized_method;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Client {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();

        Value v = new Value(0);

        AddCallable addCallable = new AddCallable(v);
        SubtractCallable subtractCallable = new SubtractCallable(v);

        Future<Void> subtractFuture = executorService.submit(subtractCallable);
        Future<Void> addFuture = executorService.submit(addCallable);

        subtractFuture.get();
        addFuture.get();

        System.out.println("Value.x = " + Value.x);
        System.out.println("v.value = " + v.value);
        executorService.shutdown();
    }
}
