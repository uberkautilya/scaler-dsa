package advanced.module7.dynamicprogramming;

public class PermutationToAnAmount {
    public static void main(String[] args) {
        int amount;
        int[] denominations;
        amount = 5;
        denominations = new int[]{1, 4, 3};

        amount = 4;
        denominations = new int[]{1, 2, 3};
        int permutationCount = solve(amount, denominations);
        System.out.println("permutationCount = " + permutationCount);
    }

    /**
     * Gets the count of distinct combinations of denominations to arrive at the amountGiven.
     * The assignment question seems to require distinct combination count, where the order is irrelevant.
     * @param amountGiven
     * @param denominations
     * @return
     */
    private static int solve(int amountGiven, int[] denominations) {
        //Here the count[] is the dp array
        int[] count = new int[amountGiven + 1];
        count[0] = 1;

        for (int amount = 1; amount <= amountGiven; amount++) {
            for (int denomination : denominations) {
                if (denomination <= amount) {
                    count[amount] = count[amount] + count[amount - denomination];
                    count[amount] = count[amount] % 1000_000_007;
                }
            }
        }
        return count[amountGiven];
    }
}
