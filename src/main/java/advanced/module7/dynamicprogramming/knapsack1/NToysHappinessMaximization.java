/*
package advanced.module7.dynamicprogramming.knapsack1;

public class NToysHappinessMaximization {
for all i, j: ans[i][j] = 0 // fill the array
//ans holds max possible happiness

for i-> 1 to N //N toys
	for j -> 1 to capacityW //W: Max aggregate weight allowed
		if(j < w[i(-1 due to shift)]) //Check if available weight < current object weight
			ans[i][j] = ans[i-1][j];
		else //Available weight j>= current object weight w[i]
			ans[i][j] = max of (
										h[i-1] + ans[i-1][j - w[i-1]], //Selection
										ans[i-1][j] //Reject
									);
return ans[N][capacityW];
}
*/
