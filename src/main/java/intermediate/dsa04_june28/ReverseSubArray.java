package intermediate.dsa04_june28;

import java.util.Arrays;

public class ReverseSubArray {
    public static void main(String[] args) {
        reverseSubArray(new int[]{2, 4, 6, 9, 98, 12, 13, 3, 7, 9}, 3, 7);
    }

    private static void reverseSubArray(int[] array, int startIndex, int endIndex) {
        while (startIndex < endIndex) {
            swapElement(array, startIndex, endIndex);
            startIndex++;
            endIndex--;
        }
        System.out.println(Arrays.toString(array));
    }

    private static void swapElement(int[] array, int startIndex, int endIndex) {
        int temp = array[startIndex];
        array[startIndex] = array[endIndex];
        array[endIndex] = temp;
    }


}
