class LongestCommonSubSequenceMemoisation
{
    //Function to find the length of longest common subsequence in two strings.
    static int lcsUtil(int x, int y, String s1, String s2,int dp[][])
    {
        // your code here
        
        
        
        //base case
        if(x==0 || y==0)
            return 0; 
            
        if(dp[x][y]!=-1)
            return dp[x][y];
            
        if(s1.charAt(x-1) == s2.charAt(y-1))
        {
            dp[x][y] = 1 + lcsUtil(x-1,y-1,s1,s2,dp);
            return dp[x][y];
        }
       
        
        else
        {
            dp[x][y]= Math.max(lcsUtil(x-1,y,s1,s2,dp), lcsUtil(x,y-1,s1,s2,dp));
            return dp[x][y];
        }
    }
    static int lcs(int x, int y, String s1, String s2)
    {
        int dp[][]= new int[x+1][y+1];//the two variables whose value wer changing
        
        for(int row[] : dp)
            Arrays.fill(row,-1);
        
        return lcsUtil(x,y,s1,s2,dp);
    }
    
}