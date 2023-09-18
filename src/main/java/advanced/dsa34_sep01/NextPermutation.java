package advanced.dsa34_sep01;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Implement the next permutation, which rearranges numbers into the numerically next greater permutation of numbers for a given array A of size N.
 * <p>
 * If such arrangement is not possible, it must be rearranged as the lowest possible order, i.e., sorted in ascending order.
 */
public class NextPermutation {

    public static void main(String[] args) {
        NextPermutation nextPermutation = new NextPermutation();
        ArrayList<Integer> result = nextPermutation.nextPermutation(new ArrayList<>(Arrays.asList(
                7, 3, 4, 5, 2, 1, 3, 3, 1
        )));
        System.out.println("result = " + result);

    }

    public ArrayList<Integer> nextPermutation(ArrayList<Integer> A) {
        //734521313 -> Start from the rightmost element. The first element less than it should be swapped
        for (int j = 1; j < A.size() - 1; j++) {

            for (int i = A.size() - 1; i > 0 && i - j >= 0; i--) {
                if (A.get(i - j).toString().compareTo(A.get(i).toString()) < 0) {
                    swap(A, i - j, i);
                    return A;
                }
            }
        }
        return A;
    }

    void swap(ArrayList<Integer> list, int index1, int index2) {
        int temp = list.get(index1);
        list.set(index1, list.get(index2));
        list.set(index2, temp);
    }

    void sort(ArrayList<Integer> list, int startIndex, int endIndex) {

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