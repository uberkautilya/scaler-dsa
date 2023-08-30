package intermediate.dsa23_july31;

import java.util.Arrays;

public class ToUpperCase {
    public static void main(String[] args) {
        char[] upper = to_upper(new char[]{
                'S', 'c', 'A', 'L', 'E', 'r', 'A', 'c', 'a', 'D', 'e', 'm', 'y'
        });
        System.out.println("upper = " + Arrays.toString(upper));
    }

    public static char[] to_upper(char[] A) {
        for (int i=0; i<A.length; i++) {
            if (A[i] >= 'a' && A[i] <= 'z') {
                A[i] -= 32;
            }
        }
        return A;
    }
}
