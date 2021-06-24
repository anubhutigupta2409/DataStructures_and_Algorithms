/*
Minimum Deletions 
Easy 
Given a string of S as input. Your task is to write a program to remove or delete the minimum number of characters from the string so that the resultant string is a palindrome.
Note: The order of characters in the string should be maintained.

Example 1:

Input: S = "aebcbda"
Output: 2
Explanation: Remove characters 'e' 
and 'd'.
​Example 2:

Input: S = "geeksforgeeks"
Output: 8
Explanation: One of the possible result
string can be "eefee", so answer is 
13 - 5 = 8.
Your Task:  
You don't need to read input or print anything. Your task is to complete the function minimumNumberOfDeletions() which takes the string S as inputs and returns the minimum number of deletions required to convert S into a pallindrome.

Expected Time Complexity: O(|S|2)
Expected Auxiliary Space: O(|S|2)

Constraints:
1 = |S| = 103


*/
class MinimumNumberOfDeletions{
    
    static int minimumNumberOfDeletions(String a)
    {
        //your code here
        int n = a.length();
        String b= "";
        
        int dp[][] = new int[n+1][n+1];
        
        for(int i = n-1 ; i>=0 ; i--)
            b+=a.charAt(i);
        
        //longest palindromic subsequence --> longest common subsequence of that string and it's reverse
        
        for(int i=0;i<n+1;i++)
            for(int j=0;j<n+1;j++)
                if(i==0 || j==0)
                    dp[i][j]=0;
                    
        for(int i=1;i<n+1;i++)
        {
            for(int j=1;j<n+1;j++)
            {
                if(a.charAt(i-1) == b.charAt(j-1))
                    dp[i][j] = 1 + dp[i-1][j-1];
                else
                    dp[i][j] = Math.max( dp[i-1][j] , dp[i][j-1] );
            }
        }
        
        /*now remove the characters that do not contribute to the string for becoming a palindrome*/
        return n - dp[n][n];
    }
}