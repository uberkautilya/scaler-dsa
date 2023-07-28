package dsa21_July28_contest_2;

import java.util.ArrayList;
import java.util.List;

public class PrettyNumbers {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>(List.of(17, 4, 12, 10, 5));
        System.out.println("solve(arrayList) = " + solve(arrayList));
    }

    public static ArrayList<Integer> solve(ArrayList<Integer> A) {
        int min = Integer.MAX_VALUE;
        int largerMin = Integer.MAX_VALUE;
        ArrayList<Integer> newArray = new ArrayList<>();
        for (int i = 0; i < A.size(); i++) {
            if (A.get(i) < min) {
                largerMin = min;
                min = A.get(i);
            } else if (A.get(i) < largerMin) {
                largerMin = A.get(i);
            }
        }
        for (int i = 0; i < A.size(); i++) {
            if (A.get(i) > largerMin) {
                newArray.add(A.get(i));
            }
        }
        return newArray;
    }
}
