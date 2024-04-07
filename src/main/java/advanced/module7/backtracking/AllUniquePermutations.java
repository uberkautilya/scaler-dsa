package advanced.module7.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class AllUniquePermutations {

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(0, 0, 0, 1, 9));
//        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(1, 2, 1));
        ArrayList<ArrayList<Integer>> result = new AllUniquePermutations().uniquePermute(arrayList);
        System.out.println(result);
    }

    public ArrayList<ArrayList<Integer>> uniquePermute(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (A.isEmpty()) {
            return result;
        }
        HashMap<Integer, Integer> elementCountMap = new HashMap<>();
        for (Integer a : A) {
            elementCountMap.put(a, elementCountMap.get(a) == null ? 1 : elementCountMap.get(a) + 1);
        }
        uniquePermutations(new ArrayList<>(), elementCountMap, result, A.size());
        return result;
    }

    private void uniquePermutations(ArrayList<Integer> arrayList, HashMap<Integer, Integer> elementCountMap,
                                    ArrayList<ArrayList<Integer>> result, Integer size) {
        ArrayList<Integer> currentArray = new ArrayList<>(arrayList);
        if (currentArray.size() >= size) {
            result.add(currentArray);
            return;
        }

        for (Map.Entry<Integer, Integer> entry : elementCountMap.entrySet()) {

            Integer element = entry.getKey();
            Integer elementCount = entry.getValue();

            if (elementCount <= 0) {
                continue;
            }

            //Select the current element from elementCountMap
            entry.setValue(--elementCount);
            currentArray.add(element);
            uniquePermutations(currentArray, elementCountMap, result, size);

            //Retrace the current element selection
            entry.setValue(++elementCount);
            currentArray.remove(currentArray.size() - 1);
        }
    }
}
