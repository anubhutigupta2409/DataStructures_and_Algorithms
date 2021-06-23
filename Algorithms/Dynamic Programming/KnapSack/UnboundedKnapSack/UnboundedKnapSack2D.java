/*
Knapsack with Duplicate Items

Given a set of N items, each with a weight and a value, and a weight limit W. Find the maximum value of a collection containing any of the N items any number of times so that the total weight is less than or equal to W.



Example 1:

Input: N = 2, W = 3
val[] = {1, 1}
wt[] = {2, 1}
Output: 3
Explaination: Pick the 2nd element thrice.


Example 2:

Input: N = 4, W = 8
val[] = {1, 4, 5, 7}
wt[] = {1, 3, 4, 5}
Output: 11
Explaination: The optimal choice is to
pick the 2nd and 4th element.


Your Task:
You do not need to read input or print anything. Your task is to complete the function knapSack() which takes the values N, W and the arrays val[] and wt[] as input parameters and returns the maximum possible value.



Expected Time Complexity: O(N*W)
Expected Auxiliary Space: O(W)



Constraints:
1 = N, W = 1000
1 = val[i], wt[i] = 100


*/

/*
Approach-->
1.In unbounded knapsack, if a particaluar item was eligible to be put, it was considered as processed, irrespective of the decision
whether, it was included or not.
2.But in unbounded knapsack, since multiple occurrences of a single item are allowed, we can notice that, if an item was included
at a moment of time, then it should be considered as unprocessed, since we can come back to it
*/
class UnboundedKnapSack2D{
    static int knapSack(int n, int w, int val[], int wt[])
    {
        // code here

        int dp[][]= new int[n+1][w+1];

        //initialisation
        for(int i=0;i<n+1;i++)
            for(int j=0;j<w+1;j++)
                if(i==0 || j==0)
                    dp[i][j]=0;


        for(int i=1;i<n+1;i++)
        {
            for(int j=1;j<w+1;j++)
            {
                if(wt[i-1]<=j)
                {
                    int val1= val[i-1] + dp[i][j-wt[i-1]];//included, nut can be taken again, so put in unprocssed state, that is dp[i][] and not dp[i-1][]
                    int val2= dp[i-1][j];//not included, so processed

                    dp[i][j]= Math.max(val1,val2);
                }
                else
                    dp[i][j] = dp[i-1][j];

            }

        }
        return dp[n][w];
    }
}