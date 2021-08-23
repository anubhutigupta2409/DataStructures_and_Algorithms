class CoinChange1_2
{
    public long count(int coin[], int sum) 
    { 
        //code here.
        long dp[] = new long[sum+1];
        dp[0]=1;
        
        for(int i=0; i<coin.length; i++) 
		    for(int j=coin[i]; j<=sum; j++) 
			    dp[j] += dp[j-coin[i]]; 
        return dp[sum];
    } 
}
