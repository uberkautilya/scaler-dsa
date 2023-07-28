package dsa19_july24;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array A of non-negative integers, arrange them such that they form the largest number.
 * <p>
 * Note: The result may be very large, so you need to return a string instead of an integer.
 */
public class MakeLargestNumberFromArrayOfNaturalNumbers {
    public static void main(String[] args) {
        List<Integer> A = new ArrayList<>();
        /*A.add(3);
        A.add(30);
        A.add(34);
        A.add(5);
        A.add(9);*/
        A.add(8);
        A.add(89);
//        System.out.println("largestNumber(A) = " + largestNumber(A));
        System.out.println("\"12\".compareTo(\"121\") = " + "12".compareTo("121"));

        System.out.println("\"11\".compareTo(\"116\") = " + "11".compareTo("116"));
        //Move after shorter number. Continue to check with the elements of the shorter number
        //If higher, the longer number should come first. Else, shorter one should come first
        System.out.println("\"30\".compareTo(\"34\") = " + "30".compareTo("34"));
        System.out.println("\"1\".compareTo(\"2\") = " + "1".compareTo("2"));

    }

    public static String largestNumber(final List<Integer> A) {
        List<String> stringA = new ArrayList<>();
        for (Integer val : A) {
            stringA.add(String.valueOf(val));
        }
        System.out.println("\n1. Original A = " + stringA);

        stringA.sort((String a, String b) -> {
            if (a.length() < b.length() && b.charAt(a.length()) < a.charAt(0)) {
                return -1;
            }
            if (b.length() < a.length() && a.charAt(b.length()) < b.charAt(0)) {
                return 1;
            } else {
                //Largest numbers first
                return b.compareTo(a);
            }
        });
        System.out.println("2. Descending A = " + stringA);
        StringBuilder largestNumber = new StringBuilder();
        for (int i = 0; i < stringA.size(); i++) {
            largestNumber.append(stringA.get(i));
        }
        System.out.println("\nlargestNumber.toString() = " + largestNumber.toString());
        return largestNumber.toString();
    }
}

/**
 * 121, 12 -> 12 121
 * 1, 116 -> 116 1
 * 1, 11 -> 11 1
 */