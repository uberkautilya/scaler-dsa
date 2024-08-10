package low_level_design.concurrency.executors_and_callables.adder_subtractor;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Client {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        try (ExecutorService executorService = Executors.newCachedThreadPool()) {

            Value v = new Value(10);
            Adder adder = new Adder(v);
            Subtractor subtractor = new Subtractor(v);

            Future<Integer> adderResult = executorService.submit(adder);
            Future<Integer> subtractResult = executorService.submit(subtractor);

            System.out.println(adderResult.get() + subtractResult.get());
            executorService.shutdown();
        }
    }
}
