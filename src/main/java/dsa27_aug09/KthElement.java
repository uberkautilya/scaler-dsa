package dsa27_aug09;

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
        /*
        0                   0: 0     A, B -> A-1, B/2
        01                  1:-0 = 1, since index odd
        01 10               2: = 1
        01 10 10 01         4: = 1
        01 10 10 01 10 01 01 10
        5,5(odd) -> 4,2(even) -> 3,1(odd) -> 2,0(even)
        1-1(comp)<- 1(same)   <- 1-0(comp)  <- 0(same)
        */
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
