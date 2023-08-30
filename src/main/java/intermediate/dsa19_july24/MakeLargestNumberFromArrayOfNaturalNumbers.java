package intermediate.dsa19_july24;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array A of non-negative integers, arrange them such that they form the largest number.
 * <p>
 * Note: The result may be very large, so you need to return a string instead of an integer.
 */
public class MakeLargestNumberFromArrayOfNaturalNumbers {
    public static void main(String[] args) {
        List<Integer> arrayListOfIntegers = new ArrayList<>();
        /*arrayListOfIntegers.add(3);
        arrayListOfIntegers.add(30);
        arrayListOfIntegers.add(34);
        arrayListOfIntegers.add(5);
        arrayListOfIntegers.add(9);*/
        /*arrayListOfIntegers.add(8);
        arrayListOfIntegers.add(886);*/


        arrayListOfIntegers = new ArrayList<>(
                Arrays.asList(
                        170, 480, 735, 896, 634, 844, 1, 610, 446, 591, 935, 802, 383, 8, 443, 247,
                        124, 461, 317, 457, 48, 886, 420, 473, 973, 464, 203, 288, 785, 703, 935, 7, 987, 48,
                        692, 633, 597, 857, 139, 733, 692, 68, 434, 587, 489, 517, 305, 432, 577, 335, 586,
                        34, 659, 491, 310, 857, 256, 856, 257, 877, 209, 979, 653, 646, 2, 65, 858, 779, 372,
                        116, 404, 268, 364, 351, 866, 824, 947, 960, 91, 691, 492, 312, 609, 915, 579, 476, 248, 192
                ));

        ArrayList<Integer> integers = new ArrayList<>(Arrays.asList(
                170, 480, 735, 896, 634, 844, 1, 610, 446, 591, 935, 802, 383, 8, 443, 247, 124, 461, 317, 457, 48, 886, 420, 473,
                973, 464, 203, 288, 785, 703, 935, 7, 987, 48, 692, 633, 597, 857, 139, 733, 692, 68, 434, 587, 489, 517, 305, 432,
                577, 335, 586, 34, 659, 491, 310, 857, 256, 856, 257, 877, 209, 979, 653, 646, 2, 65, 858, 779, 372, 116, 404, 268,
                364, 351, 866, 824, 947, 960, 91, 691, 492, 312, 609, 915, 579, 476, 248, 192
        ));

        integers = new ArrayList<>(Arrays.asList(
                931, 94, 209, 448, 716, 903, 124, 372, 462, 196, 715, 802, 103, 740, 389, 872, 615, 638, 771, 829, 899, 999, 29, 163, 342, 902, 922, 312, 326, 817, 288, 75, 37, 286, 708, 589, 975, 747, 743, 699, 743, 954, 523, 989, 114, 402, 236, 855, 323, 79, 949, 176, 663, 587, 322
        ));
        integers = new ArrayList<>(Arrays.asList(
                94, 949
        ));


        System.out.println("largestNumber(arrayListOfIntegers) = " + largestNumber(integers));

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
            String alternate1 = a + b;
            String alternate2 = b + a;
            if (alternate1.compareTo(alternate2) > 0) {
                return -1;
            } else if (alternate1.compareTo(alternate2) < 0) {
                return 1;
            } else {
                return 0;
            }
        });
        System.out.println("stringA = " + stringA);
        if (stringA.get(0).equals("0")) {
            return "0";
        }

        StringBuilder largestNumber = new StringBuilder();
        for (String s : stringA) {
            largestNumber.append(s);
        }

        return largestNumber.toString();
    }
}

/**
 * 121, 12 -> 12 121
 * 1, 116 -> 116 1
 * 1, 11 -> 11 1
 */


/*
Input:
[170,480,735,896,634,844,1,610,446,591,935,802,383,8,443,247,124,461,317,457,48,886,420,473,973,464,203,288,785,703,935,7,987,48,692,633,597,857,139,733,692,68,434,587,489,517,305,432,577,335,586,34,659,491,310,857,256,856,257,877,209,979,653,646,2,65,858,779,372,116,404,268,364,351,866,824,947,960,91,691,492,312,609,915,579,476,248,192]
Expected:
9879799739609479359359191589688868778668588578578568448248027857797735733703692692691686596565364663463361060959759158758657957751749249148948484804764734644614574464434344324204043833723643513433531731231030528826825725624824722092031921701391241161
Actual:
9879799739609479359359191589688868778668588578578568448248027857779735733703692692691686596565364663463361060959759158758657957751749249148948484804764734644614574464434344324204043833723643513433531731231030528826825725624824722092031921701391241161
 */

/*
Input:
[931,94,209,448,716,903,124,372,462,196,715,802,103,740,389,872,615,638,771,829,899,999,29,163,342,902,922,312,326,817,288,75,37,286,708,589,975,747,743,699,743,954,523,989,114,402,236,855,323,79,949,176,663,587,322]
Expected:
9999899759549499493192290390289987285582981780279771757477437437407167157086996636386155895875234624484023893737234232632332231229288286236209196176163124114103
Actual:
9999899759549494993192290390289987285582981780279771757477437437407167157086996636386155895875234624484023893737234232632332231229288286236209196176163124114103
 */