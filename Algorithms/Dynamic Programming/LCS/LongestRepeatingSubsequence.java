/*
Longest Repeating Subsequence 
Given a string, find the length of the longest repeating subsequence such that the two subsequences don't have same string character at the same position, i.e., any i'th character in the two subsequences shouldn't have the same index in the original string.

 

Example 1:

Input: str = "axxxy"
Output: 2
Explanation: The longest repeating subsequenece
is "xx".
Example 2:

Input: str = "aab"
output: 1
Explanation: The longest reapting subsequenece
is "a".
 

Your Task:
You don't need to read or print anything. Your task is to complete the function LongestRepeatingSubsequence() which takes str as input parameter and returns the length of the longest repeating subsequnece.
 

Expected Time Complexity: O(n2)
Expected Space Complexity: O(n2)
 

Constraints:
1 <= |str| <= 103

 


*/
class LongestRepeatingSubsequence
{
    public int LongestRepeatingSubsequence(String a)
    {
        // code here
        int n= a.length();
        String b= a;//our second string is the same string
        
        int dp [][] = new int[n+1][n+1];
        
        for(int i=0;i<n+1;i++)
            for(int j=0;j<n+1;j++)
                if(i==0 || j==0)
                    dp[i][j]=0;
                    
        for(int i=1;i<n+1;i++)
        {
            for(int j=1;j<n+1;j++)
            {
                
                if((a.charAt(i-1) == b.charAt(j-1) ) && i!=j/*if the character is occurring at the same place in the second string, means it's not reapeating*/)
                    dp[i][j] = 1 + dp[i-1][j-1];
                else
                    dp[i][j] = Math.max( dp[i-1][j] , dp[i][j-1] );
            }
        }
        return dp[n][n];
    }
}