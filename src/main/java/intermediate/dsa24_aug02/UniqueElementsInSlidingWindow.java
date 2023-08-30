package intermediate.dsa24_aug02;

import java.util.Arrays;
import java.util.HashMap;

public class UniqueElementsInSlidingWindow {
    public static void main(String[] args) {
        UniqueElementsInSlidingWindow uniqueElementsInSlidingWindow = new UniqueElementsInSlidingWindow();
        int[] result = uniqueElementsInSlidingWindow.dNums(
                new int[]{
                        1, 2, 1, 3, 4, 3
                }, 3
        );
        System.out.println("result = " + Arrays.toString(result));

    }

    public int[] dNums(int[] A, int B) {
        if (A.length < B) return new int[]{};
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int[] result = new int[A.length - B + 1];

        for (int i = 0; i < B; i++) {
            if (hashMap.containsKey(A[i])) {
                Integer count = hashMap.get(A[i]);
                hashMap.put(A[i], count + 1);
            } else {
                hashMap.put(A[i], 1);
            }
            result[0] = hashMap.size();
        }

        for (int i = 1; i + B - 1 < A.length; i++) {
            if (hashMap.containsKey(A[i + B - 1])) {
                Integer count = hashMap.get(A[i + B - 1]);
                hashMap.put(A[i + B - 1], count + 1);
            } else {
                hashMap.put(A[i + B - 1], 1);
            }

            if (hashMap.containsKey(A[i - 1])) {
                Integer count = hashMap.get(A[i - 1]);
                if (count - 1 == 0) {
                    hashMap.remove(A[i - 1]);
                } else {
                    hashMap.put(A[i - 1], count - 1);
                }
            }
            result[i] = hashMap.size();
        }
        return result;
    }
}
