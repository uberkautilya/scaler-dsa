package low_level_design.concurrency.executors_and_callables.callables;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MergeSortWithCallable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        List<Integer> listToSort = Arrays.asList(2, 11, 9, 7, 4, 8, 18, 10);
        Sorter sorter = new Sorter(listToSort, executorService);

        Future<List<Integer>> sortedList = executorService.submit(sorter);
        System.out.println("sortedList.get() = " + sortedList.get());
    }
}
