package intermediate.dsa27_aug09;

import java.util.ArrayList;
import java.util.Arrays;

public class KthElement {

    public static void main(String[] args) {
        KthElement kthElement = new KthElement();
        int element = kthElement.solve(4, 4);
//        int element = kthElement.solve(3, 0);
        System.out.println("element = " + element);
    }

    public int solve(int A, int B) {

        if (A == 1 && B == 0) return 0;
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(0));
        ArrayList<Integer> resultRow = recurse(list, A - 1);
        return resultRow.get(B);

    }

    public ArrayList<Integer> recurse(ArrayList<Integer> list, Integer rowsLeft) {

        if (rowsLeft == 0) {
            return list;
        }
        ArrayList<Integer> newList = new ArrayList<>();
        for (Integer val : list) {
            if (val == 0) {
                newList.add(0);
                newList.add(1);
            } else {
                newList.add(1);
                newList.add(0);
            }
        }
        return recurse(newList, rowsLeft - 1);
    }
}
