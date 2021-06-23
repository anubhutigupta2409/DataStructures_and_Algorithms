/*
Approach-->
1. Here we noticed in our recursive function that there are only two variables n and w here, whose values are changing according
to the given condition, so we create a matrix with the size of these two variables
2. and we simply retrieve the value if it's stored in our matrix, instead of calling the function again and again
*/
class ZeroOneKnapSackMemoisation
{

    static int knapSackUtil(int w, int wt[], int val[], int n, int dp[][])
    {
         //base condition


         if(w==0 || n==0)
            return 0;


        //memoisation change-->

        //if the value exists
        if(dp[n][w] != -1)
            return dp[n][w];

        //if we can put it into the bag
        if(wt[n-1]<=w)
        {
            int val1= val[n-1] + knapSackUtil(w-wt[n-1], wt, val, n-1,dp);//included
            int val2= 0 + knapSackUtil(w,wt,val,n-1,dp);//not included

            dp[n][w] = Math.max(val1,val2);//as we have to maximise
            return dp[n][w];
        }

        else /*if(wt[n-1]>w)*/
        {
            dp[n][w] =knapSackUtil(w,wt,val,n-1,dp);//simply don't include
            return dp[n][w];
        }
    }

    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int w, int wt[], int val[], int n)
    {
        int dp[][]= new int[n+1][w+1];

        for(int row[] : dp)
            Arrays.fill(row,-1);

        return knapSackUtil(w,wt,val,n,dp);
    }

}


