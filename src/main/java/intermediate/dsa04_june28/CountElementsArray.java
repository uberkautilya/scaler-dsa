package intermediate.dsa04_june28;

public class CountElementsArray {
    public static void main(String[] args) {
        System.out.println(countGreater(new int[]{1, 3, 4, 8, 8, 9, 2, 9, 10}));
        System.out.println(checkSum(new int[]{1, 3, 4, 8, 8, 9, 2, 8, 12}, 22));
        System.out.println(checkSumLowerTriangle(new int[]{1, 3, 4, 8, 8, 9, 2, 8, 12}, 22));
    }

    /**
     * To find number of elements from an array, which has at least one greater than itself
     *
     * @param array
     * @return
     */
    static int countGreater(int[] array) {
        int count = 0;
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
                count = 0;
            }
            if (array[i] == max) {
                count++;
            }
        }
        return array.length - count;
    }

    static boolean checkSum(int[] array, int pairSum) {
        int l = array.length;
        for (int i = 0; i < l; i++) {
            for (int j = i+1; j < l; j++) {
                if (array[i] + array[j] == pairSum) {
                    return true;
                }
            }
        }
        return false;
    }

    static boolean checkSumLowerTriangle(int[] array, int k) {
        int length = array.length;
        for (int i = 1; i < length; i++) {
            for (int j = 0; j < i; j++) {
                if (array[i] + array[j] == k) {
                    return true;
                }
            }
        }
        return false;
    }
}
