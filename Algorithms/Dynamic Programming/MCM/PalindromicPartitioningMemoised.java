class PalindromicPartitioningMemoised{
    static boolean isPalindrome(String str, int i, int j)
    {
        while(i<j)
        {
            if(str.charAt(i) != str.charAt(j))
                return false;
            
            i++;
            j--;
        }
        
        return true;
    }
    static int util(String str, int i, int j, int dp[][])
    {
        //base condition
        if(i>=j || isPalindrome(str,i,j)/*we could discard the first condition as it can be checked in the second condition as well, coz string of size 0 and 1 are palindrome, but have mentioned for our convinience to relate to the MCM Pattern*/)
            return 0;
           
        if(dp[i][j]!=-1)
            return dp[i][j];
          
        int ans = Integer.MAX_VALUE;
        
        //loop
        for(int k=i; k<=j-1; k++)
        {
            //temp ans
            int tempAns = util(str,i,k,dp) + util(str,k+1,j,dp) + 1;
            
            //final ans
            ans = Math.min(ans,tempAns);
        }
        
        dp[i][j]=ans;
        
        return ans;
        
    }
    static int palindromicPartition(String str)
    {
        // code here
        int n = str.length();
        
        int dp[][] = new int[n][n];
        
        for(int x[] : dp)
            Arrays.fill(x,-1);
        
        return util(str, 0, n-1, dp);
    }
}