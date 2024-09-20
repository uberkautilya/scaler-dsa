package advanced.module4.dsa34_sep01;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Implement the next permutation, which rearranges numbers into the numerically next greater permutation of numbers for a given array A of size N.
 * If such arrangement is not possible, it must be rearranged as the lowest possible order, i.e., sorted in ascending order.
 * NOTE:
 * The replacement must be in-place, do not allocate extra memory.
 * DO NOT USE LIBRARY FUNCTION FOR NEXT PERMUTATION. Use of Library functions will disqualify your submission retroactively and will give you penalty points.
 */
public class NextPermutation {

    public static void main(String[] args) {
        NextPermutation nextPermutation = new NextPermutation();
        ArrayList<Integer> result = nextPermutation.nextPermutation(new ArrayList<>(Arrays.asList(
                73, 4, 52, 13, 1, 3
//                73, 4, 52, 13, 3, 1
        )));
        System.out.println("result = " + result);

    }

    public ArrayList<Integer> nextPermutation(ArrayList<Integer> A) {
        //73,4,52,131,3 -> Iterate from right, find the first number which is less than the previous value.
        // Swap this number with a value on its right that is closest and larger.
        // Thereafter, arrange all the numbers on the right of the number found in ascending order
        int indexToSwap1 = A.size() - 2;
        while (indexToSwap1 >= 0) {
            Integer val1 = A.get(indexToSwap1);
            Integer val2 = A.get(indexToSwap1 + 1);
            if (val1 < val2) {
                break;
            }
            indexToSwap1--;
        }
        //If A is fully in descending order, make the whole list ascending
        if (indexToSwap1 == -1) {
            for (int i = 0; i < A.size() / 2; i++) {
                swap(A, i, A.size() - i - 1);
            }
            return A;
        }
        int lastIndex = A.size() - 1;
        int indexToSwap2 = lastIndex;
        while (indexToSwap2 >= indexToSwap1) {
            if (A.get(indexToSwap2) > A.get(indexToSwap1)) {
                break;
            }
            indexToSwap2--;
        }

        System.out.println(Arrays.toString(A.toArray()));
        System.out.println("IndexToSwap1 = " + indexToSwap1);
        System.out.println("IndexToSwap2 = " + indexToSwap2);
        swap(A, indexToSwap1, indexToSwap2);

        int startIndex = indexToSwap1 + 1;
        int midIndex = (startIndex + lastIndex) / 2;
        for (int i = startIndex, j = lastIndex; i <= midIndex; i++, j--) {
            swap(A, i, j);
        }

        return A;
    }

    void swap(ArrayList<Integer> list, int index1, int index2) {
        int temp = list.get(index1);
        list.set(index1, list.get(index2));
        list.set(index2, temp);
    }
}

/*
A : [
444, 994, 508, 72, 125, 299, 181, 238, 354, 223, 691, 249, 838, 890, 758, 675, 424, 199, 201, 788, 609, 582, 979, 259, 901, 371, 766,
759, 983, 728, 220, 16, 158, 822, 515, 488, 846, 321, 908, 469, 84, 460, 961, 285, 417, 142, 952, 626, 916, 247, 116, 975, 202, 734,
128, 312, 499, 274, 213, 208, 472, 265, 315, 335, 205, 784, 708, 681, 160, 448, 365, 165, 190, 693, 606, 226, 351, 241, 526, 311, 164,
98, 422, 363, 103, 747, 507, 669, 153, 856, 701, 319, 695, 52 ]

Expected:
444 994 508 72 125 299 181 238 354 223 691 249 838 890 758 675 424 199 201 788 609 582 979 259 901 371 766
759 983 728 220 16 158 822 515 488 846 321 908 469 84 460 961 285 417 142 952 626 916 247 116 975 202 734
128 312 499 274 213 208 472 265 315 335 205 784 708 681 160 448 365 165 190 693 606 226 351 241 526 311 164
98 422 363 103 747 507 669 153 856 701 695 52 319
Output:
444 994 508 72 125 299 181 238 354 223 691 249 838 890 758 675 424 199 201 788 609 582 979 259 901 371 766
759 983 728 220 16 158 822 515 488 846 321 908 469 84 460 961 285 417 142 952 626 916 247 116 975 202 734
128 312 499 274 213 208 472 265 315 335 205 784 708 681 160 448 365 165 190 693 606 226 351 241 526 311 164
98 422 363 103 747 507 669 153 856 701 695 319 52
 */