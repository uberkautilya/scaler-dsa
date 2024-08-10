package low_level_design.concurrency.executors_and_callables.callables;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MergeSortWithCallable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Integer> unsortedList = Arrays.asList(2, 11, 9, 7, 4, 8, 18, 10);

        ExecutorService executorService = Executors.newCachedThreadPool();

        CallableSort sortTask = new CallableSort(unsortedList, executorService);
        Future<List<Integer>> sortedList = executorService.submit(sortTask);

        System.out.println("sortedList.get() = " + sortedList.get());
    }
}
