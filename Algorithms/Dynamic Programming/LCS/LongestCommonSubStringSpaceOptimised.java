class  LongestCommonSubStringSpaceOptimised{
    int longestCommonSubstr(String s1, String s2, int n, int m){
        // code here

        //assuming s1 is the bigger string
        if(n<m)
        {
            //swap sizes and strings
            String temp=s1;
            s1=s2;
            s2=temp;

            int temp2= n;
            n=m;
            m=temp2;
        }

        //minimum of the two
        int dp[][]= new int[2][m+1];

        int res = Integer.MIN_VALUE;

        //filling the matrix
        for(int i=1;i<n+1;i++)
        {
            for(int j=1;j<m+1;j++)
            {
                if(s1.charAt(i-1)== s2.charAt(j-1))
                    dp[i%2][j] = 1 + dp[(i-1)%2][j-1];
                else
                    dp[i%2][j] = 0;//if continutity breaks store zero

                res = Math.max(res,dp[i%2][j]);
            }
        }

        return res;
    }
}

/*
Time Complexity--> O(n*m)
Space Complexity--> O(min(m,n))
*/