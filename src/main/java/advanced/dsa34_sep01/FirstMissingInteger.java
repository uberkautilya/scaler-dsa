package advanced.dsa34_sep01;

import java.util.ArrayList;
import java.util.Arrays;

public class FirstMissingInteger {
    public static void main(String[] args) {
        FirstMissingInteger firstMissingInteger = new FirstMissingInteger();
//        int result = firstMissingInteger.firstMissingPositive(new ArrayList<>(Arrays.asList(2, 3, 1, 2)));
        int result = firstMissingInteger.firstMissingPositive(new ArrayList<>(Arrays.asList(3, 4, -1, 1)));
        System.out.println("result = " + result);

    }

    public int firstMissingPositive(ArrayList<Integer> A) {

        for (int i = 0; i < A.size(); i++) {
            int val = A.get(i);
            int correctIndex = val - 1;
            while (correctIndex != i &&
                    1 <= val && val <= A.size() &&
                    0 <= correctIndex && correctIndex < A.size()) {
                if (A.get(i).intValue() == A.get(correctIndex).intValue()) break;

                swap(A, i, correctIndex);
                val = A.get(i);
                correctIndex = val - 1;
            }
        }
        for (int i = 0; i < A.size(); i++) {
            if (A.get(i) != i + 1) {
                return i + 1;
            }
        }
        return A.size() + 1;
    }

    void swap(ArrayList<Integer> list, int index1, int index2) {
        int temp = list.get(index1);
        list.set(index1, list.get(index2));
        list.set(index2, temp);
    }
}
