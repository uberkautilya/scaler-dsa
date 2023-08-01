package dsa23_july31;

import java.util.Arrays;

public class ToLowerCase {
    public static void main(String[] args) {
        ToLowerCase toLowerCase = new ToLowerCase();
        char[] lower = toLowerCase.to_lower(new char[]{'S', 'c', 'A', 'L', 'E', 'r', 'A', 'c', 'a', 'D', 'e', 'm', 'y' });
        System.out.println("lower = " + Arrays.toString(lower));
    }

    public char[] to_lower(char[] A) {

        for (int i = 0; i < A.length; i++) {
            if ('A' <= A[i] && A[i] <= 'Z') {
                A[i] = (char) (A[i] + 32);
            }
        }
        return A;

        //Can also use XOR to set the 5th bit of each char to turn then lowercase
    }
}
