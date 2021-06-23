/*
Its an unbounded knapsack problem as we can use 1 or more instances of any resource. A simple 1D array, say dp[W+1] can be used
such that dp[i] stores the maximum value which can achieved using all items and i capacity of knapsack. Note that we use 1D array
here which is different from classical knapsack where we used 2D array. Here number of items never changes. We always have all
items available.
*/
class UnboundedKnapSack1D{
    static int knapSack(int n, int w, int val[], int wt[])
    {
        // code here

        //using just one dimensional array

        int dp[]= new int[w+1];

        for(int i=0;i<w+1;i++)
            for(int j=0;j<n;j++)
                if(wt[j]<=i)
                    dp[i]= Math.max(dp[i], val[j] + dp[i-wt[j]]);

        return dp[w];
    }
}