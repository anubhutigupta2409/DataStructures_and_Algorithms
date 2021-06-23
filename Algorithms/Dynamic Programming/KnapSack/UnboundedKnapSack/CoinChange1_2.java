class CoinChange1_2
{
    public long count(int S[], int m, int n) 
    { 
        //code here.
        long dp[] = new long[n+1];
        Arrays.fill(dp,0);
        dp[0]=1;
        
        for(int i=0; i<m; i++) 
		    for(int j=S[i]; j<=n; j++) 
			    dp[j] += dp[j-S[i]]; 
        return dp[n];
    } 
}