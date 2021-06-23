/*
Approach-->
1.In Top Down Approach we follow two steps-->
	1.1 Initialisation (The base condition of the recursive code, is used for this)
	1.2 Completely eliminate recursion ,and write an iterative solution instead
*/
class ZeroOneKnapSackTopDown
{



    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int w, int wt[], int val[], int n)
    {
        int dp[][]= new int[n+1][w+1];

        //base condition of recursion is the initialisation
        for(int i=0;i<n+1;i++)
            for(int j=0;j<w+1;j++)
                if(i==0 || j==0)
                    dp[i][j]=0;

        //now converting the recursive conditions into iterative approach
        for(int i=1;i<n+1;i++)
        {
            for(int j=1;j<w+1;j++)
            {
                if(wt[i-1]<=j)
                {
                    int val1= val[i-1] + dp[i-1][j-wt[i-1]];
                    int val2= dp[i-1][j];

                    dp[i][j]= Math.max(val1,val2);
                }
                else
                    dp[i][j] = dp[i-1][j];

            }

        }
        return dp[n][w];
    }

}


