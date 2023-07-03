package homeworks_experiments;

public class SmallestSubArrayWithMinMax {
    public static void main(String[] args) {
        int[] a = {8, 8, 8};
        int count = countSubArrayLength(a);
        System.out.println("Count of array length, smallest which contains both min and max: " + count);
    }

    private static int countSubArrayLength(int[] a) {
        int min = findMin(a);
        int max = findMax(a);
        if (min == max) {
            return 1;
        }

        int subArrayLength = a.length;
        int minIndex = -1;
        int maxIndex = -1;

        for (int i = a.length - 1; i >= 0; i--) {
            if (a[i] == min) {
                //Find nearest max on the right
                minIndex = i;
                if (maxIndex != -1) {
                    //maxIndex is on the right
                    int len = maxIndex - minIndex + 1;
                    if (len < subArrayLength) {
                        subArrayLength = len;
                    }
                }
            } else if (a[i] > max) {
                //Find nearest min on the right
                maxIndex = i;
                if (minIndex != -1) {
                    //minIndex is on the right
                    int len = minIndex - maxIndex + 1;
                    if (len < subArrayLength) {
                        subArrayLength = len;
                    }
                }
            }
        }
        return subArrayLength;
    }

    private static int findMax(int[] a) {
        int max = a[0];
        for (int i = 1; i < a.length; i++) {

            if (a[i] > max) {
                max = a[i];
            }
        }
        return max;
    }

    private static int findMin(int[] a) {
        int min = a[0];
        for (int i = 1; i < a.length; i++) {

            if (a[i] < min) {
                min = a[i];
            }
        }
        return min;
    }
}
