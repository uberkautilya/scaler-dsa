package fundamentals;

import java.util.ArrayList;
import java.util.List;

public class AddNullToArrayList {
    public static void main(String[] args) {
        List<Integer> intList = new ArrayList<>();
        intList.add(null);
        for (Integer i : intList) {
            System.out.println(i.intValue());
        }
    }
}
