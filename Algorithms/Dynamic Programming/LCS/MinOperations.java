/*
Minimum number of deletions and insertions.
Easy
Given two strings str1 and str2. The task is to remove or insert the minimum number of characters from/in str1 so as to transform it into str2. It could be possible that the same character needs to be removed/deleted from one point of str1 and inserted to some another point.

Example 1:

Input: str1 = "heap", str2 = "pea"
Output: 3
Explanation: 2 deletions and 1 insertion
p and h deleted from heap. Then, p is
inserted at the beginning One thing to
note, though p was required yet it was
removed/deleted first from its position
and then it is inserted to some other
position. Thus, p contributes one to the
deletion_count and one to the
insertion_count.
Example 2:

Input : str1 = "geeksforgeeks"
str2 = "geeks"
Output: 8
Explanation: 8 insertions


Your Task:
You don't need to read or print anything. Your task is to complete the function minOperations() which takes both strings as input parameter and returns the minimum number of operation required.

Expected Time Complexity: O(|str1|*|str2|)
Expected Space Complexity: O(|str1|*|str2|)

Constraints:
1 = |str1|, |str2| = 1000
All the characters are lower case English alphabets


*/
class MinOperations
{
	public int minOperations(String X, String Y)
	{
	    // Your code goes here
	    //calculate the length of longest coomon subsequence

	    int m= X.length();
	    int n= Y.length();

        int dp[][] = new int[m+1][n+1];

        for(int i=0;i<m+1;i++)
            for(int j=0;j<n+1;j++)
                if(i==0 || j==0)
                    dp[i][j]=0;

        for(int i=1;i<m+1;i++)
        {
            for(int j=1;j<n+1;j++)
            {
                if(X.charAt(i-1)==Y.charAt(j-1))
                    dp[i][j] = 1+dp[i-1][j-1];
                else
                    dp[i][j] = Math.max(dp[i-1][j] , dp[i][j-1]);
            }
        }

        /*
        We have to convert X--->Y
        also since we have to convert completely then order matters.
        So, delete from X which Y doesn't have
        and insert into X from Y which X doesn't have
        */
        int deletions = m/*length of X*/ - dp[m][n];
        int insertions = n/*length of Y*/ - dp[m][n];

        return deletions+insertions;

	}
}