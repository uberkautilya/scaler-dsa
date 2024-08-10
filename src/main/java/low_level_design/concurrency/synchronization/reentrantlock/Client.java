package low_level_design.concurrency.synchronization.reentrantlock;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Client {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        try (ExecutorService executorService = Executors.newCachedThreadPool()) {
            Value v = new Value(0);
            Lock lock = new ReentrantLock();

            AddCallable addCallable = new AddCallable(v, lock);
            SubtractCallable subtractCallable = new SubtractCallable(v, lock);

            Future<Integer> subtractFuture = executorService.submit(subtractCallable);
            Future<Integer> addFuture = executorService.submit(addCallable);

            //Depending on how many additions and subtractions are done, the subtractResult and addResult value can vary
            Integer subtractResult = subtractFuture.get();
            System.out.println("subtractResult = " + subtractResult);

            Integer addResult = addFuture.get();
            System.out.println("addResult = " + addResult);

            System.out.println("v.value = " + v.value);
            executorService.shutdown();
        }
    }
}
