/*
Longest Common Substring
Medium
Given two strings. The task is to find the length of the longest common substring.


Example 1:

Input: S1 = "ABCDGH", S2 = "ACDGHR"
Output: 4
Explanation: The longest common substring
is "CDGH" which has length 4.
Example 2:

Input: S1 = "ABC", S2 "ACB"
Output: 1
Explanation: The longest common substrings
are "A", "B", "C" all having length 1.

Your Task:
You don't need to read input or print anything. Your task is to complete the function longestCommonSubstr() which takes the string S1, string S2 and their length n and m as inputs and returns the length of the longest common substring in S1 and S2.


Expected Time Complexity: O(n*m).
Expected Auxiliary Space: O(n*m).


Constraints:
1<=n, m<=1000


*/

class LongestCommonSubString{
    int longestCommonSubstr(String s1, String s2, int n, int m){
        // code here

        int dp[][]= new int[n+1][m+1];

        //initialisation
        for(int i=0;i<n+1;i++)
            for(int j=0;j<m+1;j++)
                dp[i][j]=0;

        int res = Integer.MIN_VALUE;//as the largest substring could be formed anywhere in the matrix
        //so the last cell might not give us the result

        //filling the matrix
        for(int i=1;i<n+1;i++)
        {
            for(int j=1;j<m+1;j++)
            {
                if(s1.charAt(i-1)== s2.charAt(j-1))
                    dp[i][j] = 1 + dp[i-1][j-1];
                else
                    dp[i][j] = 0;//if continutity breaks store zero

                res = Math.max(res,dp[i][j]);
            }
        }

        return res;
    }
}