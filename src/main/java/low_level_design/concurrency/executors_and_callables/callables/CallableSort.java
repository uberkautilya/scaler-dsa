package low_level_design.concurrency.executors_and_callables.callables;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/**
 * The return type of the Callable is List<Integer>
 */
public class CallableSort implements Callable<List<Integer>> {
    private final List<Integer> arrayToSort;
    private final ExecutorService executorService;

    public CallableSort(List<Integer> arrayToSort, ExecutorService executorService) {
        this.arrayToSort = arrayToSort;
        this.executorService = executorService;
    }

    @Override
    public List<Integer> call() throws Exception {
        if (arrayToSort.size() == 1) {
            return arrayToSort;
        }
        int mid = arrayToSort.size() / 2;
        List<Integer> leftArray = arrayToSort.subList(0, mid);
        List<Integer> rightArray = arrayToSort.subList(mid, arrayToSort.size());

        // Create sub-tasks
        CallableSort leftCallableSort = new CallableSort(leftArray, executorService);
        CallableSort rightCallableSort = new CallableSort(rightArray, executorService);

        // Submit tasks to executorService
        Future<List<Integer>> sortedLeftListFuture = executorService.submit(leftCallableSort);
        Future<List<Integer>> sortedRightListFuture = executorService.submit(rightCallableSort);

        // Merge the sorted parts - Need both tasks to complete - No more asynchronous
        List<Integer> sortedLeftList = sortedLeftListFuture.get();
        List<Integer> sortedRightList = sortedRightListFuture.get();

        return mergeSortedParts(sortedLeftList, sortedRightList);
    }

    private static List<Integer> mergeSortedParts(List<Integer> leftSortedList,
                                                  List<Integer> rightSortedList) {
        List<Integer> sortedList = new ArrayList<>();
        int lIndex = 0;
        int rIndex = 0;

        while (lIndex < leftSortedList.size() && rIndex < rightSortedList.size()) {
            if (leftSortedList.get(lIndex) <= rightSortedList.get(rIndex)) {
                sortedList.add(leftSortedList.get(lIndex));
                lIndex++;
            } else {
                sortedList.add(rightSortedList.get(rIndex));
                rIndex++;
            }
        }
        while (lIndex < leftSortedList.size()) {
            sortedList.add(leftSortedList.get(lIndex));
            lIndex++;
        }
        while (rIndex < rightSortedList.size()) {
            sortedList.add(rightSortedList.get(rIndex));
            rIndex++;
        }
        return sortedList;
    }
}
