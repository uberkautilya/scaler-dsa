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
        /*A.add(8);
        A.add(886);*/
        A = new ArrayList<>(
                List.of(
                        170, 480, 735, 896, 634, 844, 1, 610, 446, 591, 935, 802, 383, 8, 443, 247,
                        124, 461, 317, 457, 48, 886, 420, 473, 973, 464, 203, 288, 785, 703, 935, 7, 987, 48,
                        692, 633, 597, 857, 139, 733, 692, 68, 434, 587, 489, 517, 305, 432, 577, 335, 586,
                        34, 659, 491, 310, 857, 256, 856, 257, 877, 209, 979, 653, 646, 2, 65, 858, 779, 372,
                        116, 404, 268, 364, 351, 866, 824, 947, 960, 91, 691, 492, 312, 609, 915, 579, 476, 248, 192
                ));
        System.out.println("largestNumber(A) = " + largestNumber(A));

        /*System.out.println("\"12\".compareTo(\"121\") = " + "12".compareTo("121"));

        System.out.println("\"11\".compareTo(\"116\") = " + "11".compareTo("116"));
        //Move after shorter number. Continue to check with the elements of the shorter number
        //If higher, the longer number should come first. Else, shorter one should come first
        System.out.println("\"30\".compareTo(\"34\") = " + "30".compareTo("34"));
        System.out.println("\"1\".compareTo(\"2\") = " + "1".compareTo("2"));*/

    }

    public static String largestNumber(final List<Integer> A) {
        List<String> stringA = new ArrayList<>();
        for (Integer val : A) {
            stringA.add(val.toString());
        }

        stringA.sort((String a, String b) -> {
            int smallerLength = a.length() < b.length() ? a.length() : b.length();
            boolean isExt = true;
            for (int i = 0; i < smallerLength; i++) {
                if (a.charAt(i) != b.charAt(i)) {
                    isExt = false;
                    break;
                }
            }
            if (isExt) {
                if (a.length() < b.length()) {
                    int index = 0;
                    for (int i = a.length(); i < b.length(); i++) {
                        if (b.charAt(i) > a.charAt(index)) {
                            return 1;
                        } else if (b.charAt(i) < a.charAt(index)) {
                            return -1;
                        }
                        index++;
                        if (index >= a.length() - 1) {
                            index = 0;
                        }
                    }

                } else if (b.length() < a.length()) {
                    int index = 0;
                    for (int i = b.length(); i < a.length(); i++) {
                        if (a.charAt(i) > b.charAt(index)) {
                            return -1;
                        } else if (a.charAt(i) < b.charAt(index)) {
                            return 1;
                        }
                        index++;
                        if (index >= b.length() - 1) {
                            index = 0;
                        }
                    }

                }
                return 0;
            }
            //Largest numbers first
            return b.compareTo(a);
        });
        if (stringA.get(0).equals("0")) {
            return "0";
        }

        StringBuilder largestNumber = new StringBuilder();
        for (int i = 0; i < stringA.size(); i++) {
            largestNumber.append(stringA.get(i));
        }

        return largestNumber.toString();
    }
}

/**
 * 121, 12 -> 12 121
 * 1, 116 -> 116 1
 * 1, 11 -> 11 1
 */


//9999899759549494993192290390289987285582981780279771757477437437407167157086996636386155895875234624484023893737234232632332231229288286236209196176163124114103
//9999899759549499493192290390289987285582981780279771757477437437407167157086996636386155895875234624484023893737234232632332231229288286236209196176163124114103