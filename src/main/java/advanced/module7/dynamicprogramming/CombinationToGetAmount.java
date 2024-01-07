package advanced.module7.dynamicprogramming;

public class CombinationToGetAmount {
    public static void main(String[] args) {
        int amount;
        int[] denominations;
        amount = 5;
        denominations = new int[]{1, 4, 3};

        amount = 4;
        denominations = new int[]{1, 2, 3};
        amount = 458;
        denominations = new int[]{18,24,23,10,16,19,2,9,5,12,17,3,28,29,4,13,15,8};
        int combinationCount = solve(denominations, amount);
        System.out.println("combinationCount = " + combinationCount);
    }

    /**
     * @param A -> Denomincations of coins available
     * @param B -> Amount to be formed
     * @return
     */
    private static int solve(int[] A, int B) {
        int denominationCount = A.length;
        //no_of_ways[i] -> No. of ways to make sum i.
        //Assuming we have no_of_ways[k] where k<i
        int[] no_of_ways = new int[B + 1];
        //If required sum = 0, no. of ways to get there is 1
        no_of_ways[0] = 1;

        for (int denomination : A) {
            for (int amount = denomination; amount <= B; amount++) {
                no_of_ways[amount] += no_of_ways[amount - denomination];
                no_of_ways[amount] = no_of_ways[amount] % 1000_007;
            }
        }
        return no_of_ways[B];
    }
}
