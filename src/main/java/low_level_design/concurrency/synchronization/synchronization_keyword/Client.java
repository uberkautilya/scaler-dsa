package low_level_design.concurrency.synchronization.synchronization_keyword;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Client {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        try (ExecutorService executorService = Executors.newCachedThreadPool()) {
            Value v = new Value(0);

            AddCallable addCallable = new AddCallable(v);
            SubtractCallable subtractCallable = new SubtractCallable(v);

            Future<Integer> subtractFuture = executorService.submit(subtractCallable);
            Future<Integer> addFuture = executorService.submit(addCallable);

            subtractFuture.get();
            System.out.println("subtractResult = " + subtractFuture.get());
            addFuture.get();
            System.out.println("addResult = " + addFuture.get());

            System.out.println("v.value = " + v.value);
            executorService.shutdown();
        }
    }
}
