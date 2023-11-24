package advanced.module5.dsa52_oct11;

import java.util.HashSet;

public class CountPoints {
    private int count(int[] x, int[] y) {
        HashSet<String> hs = new HashSet<>();
        for (int i = 0; i < x.length; i++) {
            String point = x[i] + "_" + y[i];
            hs.add(point);
        }
        return hs.size();
    }
}
