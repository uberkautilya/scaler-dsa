package dsa19_july24;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntegersSortTensPlace {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(
                19, 7, 11, 15
        ));

        A.sort((Integer a, Integer b) -> {
            Integer ten1 = (a / 10) % 10;
            Integer ten2 = (b / 10) % 10;

            if (ten1.equals(ten2)) {
                return b.compareTo(a);
            } else {
                return ten1.compareTo(ten2);
            }
        });
        System.out.println("A = " + A);
    }
}
