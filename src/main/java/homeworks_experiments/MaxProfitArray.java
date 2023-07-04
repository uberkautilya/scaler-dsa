package homeworks_experiments;

public class MaxProfitArray {
    public static void main(String[] args) {
        int maxProfit = calculateMaxProfit(new int[]{1, 234, 99, 92, 2, 94, 0});
        System.out.println("maxProfit: " + maxProfit);
    }

    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public static int calculateMaxProfit(final int[] A) {
        if (A.length == 0) return 0;

        int maxOnRight = A[A.length - 1];
        int maxProfit = 0;

        for (int i = A.length - 2; i >= 0; i--) {
            if (maxOnRight - A[i] > maxProfit) {
                maxProfit = maxOnRight - A[i];
            }
            if (A[i] > maxOnRight) {
                //Max value till the current index
                maxOnRight = A[i];
            }
        }
        return maxProfit;
    }

}
