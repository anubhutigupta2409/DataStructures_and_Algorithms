class MatrixChainMultiplicationMemoisation{
    static int util(int arr[], int i, int j,int dp[][])
    {
        //base condition
        if(i>=j)
            return 0;
            
        if(dp[i][j]!=-1)
            return dp[i][j];
        
        int ans = Integer.MAX_VALUE;
        
        //break k
        for(int k=i;k<=j-1;k++)
        {
            //temp ans
            int tempAns = util(arr,i,k,dp) + util(arr,k+1,j,dp) + arr[i-1]*arr[k]*arr[j]/*final cost*/;
            
            //final ans
            ans = Math.min(tempAns , ans);
            
        }
        
        dp[i][j] = ans;//store
        
        return ans;
    }
    static int matrixMultiplication(int N, int arr[])
    {
        // code here
        int dp[][] = new int[N][N];
        
        for(int x[] : dp)
            Arrays.fill(x,-1);
            
        return util(arr, 1, N-1,dp);
    }
}