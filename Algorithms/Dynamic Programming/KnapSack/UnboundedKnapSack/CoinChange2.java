/*
Number of Coins
Medium
Given a value V and array coins[] of size M, the task is to make the change for V cents, given that you have an infinite supply of each of coins{coins1, coins2, ..., coinsm} valued coins. Find the minimum number of coins to make the change. If not possible to make change then return -1.


Example 1:

Input: V = 30, M = 3, coins[] = {25, 10, 5}
Output: 2
Explanation: Use one 25 cent coin
and one 5 cent coin
Example 2:
Input: V = 11, M = 4,coins[] = {9, 6, 5, 1}
Output: 2
Explanation: Use one 6 cent coin
and one 5 cent coin

Your Task:
You don't need to read input or print anything. Complete the function minCoins() which takes V, M and array coins as input parameters and returns the answer.

Expected Time Complexity: O(V*M)
Expected Auxiliary Space: O(V)

Constraints:
1 = V*M = 106
All array elements are distinct
*/
class CoinChange2{

	public int minCoins(int coins[], int M, int V)
	{
	    // Your code goes here
	    int dp[] = new int[V+1];

	    Arrays.fill(dp,Integer.MAX_VALUE-1);
	    dp[0] = 0;

	    for(int i=0;i<V+1;i++)
	        for(int j=0;j<M;j++)
	            if(coins[j]<=i)
	                dp[i] = Math.min(dp[i], 1+dp[i-coins[j]]);

	    return dp[V]== Integer.MAX_VALUE-1 ? -1 : dp[V];
	}
}