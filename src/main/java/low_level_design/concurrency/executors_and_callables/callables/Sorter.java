package low_level_design.concurrency.executors_and_callables.callables;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * The return type of the Callable is List<Integer>
 */
public class Sorter implements Callable<List<Integer>> {
    private List<Integer> arrayToSort;
    private ExecutorService executorService;

    public Sorter(List<Integer> arrayToSort, ExecutorService executorService) {
        this.arrayToSort = arrayToSort;
        this.executorService = executorService;
    }

    @Override
    public List<Integer> call() throws Exception {
        if (arrayToSort.size() == 1) {
            return arrayToSort;
        }
        int mid = arrayToSort.size() /2;
        List<Integer> leftArray = arrayToSort.subList(0, mid);
        List<Integer> rightArray = arrayToSort.subList(mid, arrayToSort.size());

        // Create tasks
        Sorter leftListSortTask = new Sorter(leftArray, executorService);
        Sorter rightListSortTask = new Sorter(rightArray, executorService);

        // Submit tasks to executorService
        Future<List<Integer>> sortedLeftListFuture = executorService.submit(leftListSortTask);
        Future<List<Integer>> sortedRightListFuture = executorService.submit(rightListSortTask);

        // Merge the sorted parts - Need both tasks to complete - No more asynchronous
        List<Integer> sortedLeftList = sortedLeftListFuture.get();
        List<Integer> sortedRightList = sortedRightListFuture.get();

        return mergeSortedParts(sortedLeftList, sortedRightList);
    }

    private static List<Integer> mergeSortedParts(List<Integer> sortedLeftList,
                                                  List<Integer> sortedRightList) {
        int i = 0;
        int j = 0;
        List<Integer> sortedList = new ArrayList<>();
        while (i < sortedLeftList.size() && j < sortedRightList.size()) {
            if (sortedLeftList.get(i) <= sortedRightList.get(j)) {
                sortedList.add(sortedLeftList.get(i));
                i++;
            }else {
                sortedList.add(sortedRightList.get(j));
                j++;
            }
        }
        while (i < sortedLeftList.size()) {
            sortedList.add(sortedLeftList.get(i));
            i++;
        }
        while (j < sortedRightList.size()) {
            sortedList.add(sortedRightList.get(j));
            j++;
        }
        return sortedList;
    }
}
