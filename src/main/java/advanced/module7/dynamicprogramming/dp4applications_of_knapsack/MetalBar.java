package advanced.module7.dynamicprogramming.dp4applications_of_knapsack;

/**
 * 0-N Knapsack problem: Rods of same lengths can be picked multiple times
 * Given total length, rod prices of lengths 1-N
 */
public class MetalBar {
    //Here we have 1 based indexing

 /*   int dp[N+1][N+1]

    //i tracks the item length, j is the length remaining

    //dp[i][j]: Max cost with length j using i items
    for(int j = 0; j <= N; j++){
        dp[0][j] = 0;
    }

    for(int i; i<=N; i++){
        dp[i][0] = 0;
    }

    for(int i=1; i<=N; i++){

        for(int j=1; j<=N; j++){

            dp[i][j] = dp[i-1][j];
            if(j >= i){
                dp[i][j] = Math.max(
                        dp[i-1][j], //rod of length i not picked choice
                        cost[i] + dp[i][j-i] //Choice where we pick the current length and stay at the same rod length
                );
            }

        }
    }
    return dp[N][N];*/



}
