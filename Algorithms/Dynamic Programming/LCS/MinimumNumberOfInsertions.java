/*
Form a palindrome
Medium
Given a string, find the minimum number of characters to be inserted to convert it to palindrome.
For Example:
ab: Number of insertions required is 1. bab or aba
aa: Number of insertions required is 0. aa
abcd: Number of insertions required is 3. dcbabcd


Example 1:

Input: str = "abcd"
Output: 3
Explanation: Inserted character marked
with bold characters in dcbabcd
Example 2:

Input: str = "aa"
Output: 0
Explanation:"aa" is already a palindrome.

Your Task:
You don't need to read input or print anything. Your task is to complete the function countMin() which takes the string str as inputs and returns the answer.

Expected Time Complexity: O(N2), N = |str|
Expected Auxiliary Space: O(N2)

Constraints:
1 = |str| = 103
str contains only lower case alphabets.


*/
class MinimumNumberOfInsertions{
    static int countMin(String a)
    {
        // code here

        //calculate longest palindromic subsequence
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

        //now if we found the coomon elements then all we need to do is
        //insert the left elements, so that we can pairs and the string becomes
        //a palindrome
        return n - dp[n][n];
    }
}