package intermediate.dsa04_june28;

import java.util.Arrays;

//TODO: INTERESTING
public class RotateArrayKTimes {
    public static void main(String[] args) {
        int[] array = {4, 1, 6, 9, 14, 7, 8, 3};
        int noOfRotations = 9;
        //array.length number of rotations will produce the original array itself
        noOfRotations = noOfRotations % (array.length);
        rotateArray(array, noOfRotations);
    }

    private static void rotateArray(int[] array, int k) {
        //Reverse the entire array
        reverseArray(array, 0, array.length - 1);
        //Then reverse the subArrays split at the kth index
        //Reverse the first k elements at the start of the array
        reverseArray(array, 0, k - 1);
        //Reverse the rest: N-K elements at the end
        reverseArray(array, k, array.length - 1);
        System.out.printf("Array after %d rotations: %s", k, Arrays.toString(array));
    }

    private static int[] reverseArray(int[] array, int beginIndex, int endIndex) {

        while (beginIndex < endIndex) {
            int temp = array[beginIndex];
            array[beginIndex] = array[endIndex];
            array[endIndex] = temp;
            beginIndex++;
            endIndex--;
        }
        return array;
    }
}
