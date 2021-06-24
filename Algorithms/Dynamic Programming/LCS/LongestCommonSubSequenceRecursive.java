/*
Longest Common Subsequence
Medium
Given two sequences, find the length of longest subsequence present in both of them. Both the strings are of uppercase.

Example 1:

Input:
A = 6, B = 6
str1 = ABCDGH
str2 = AEDFHR
Output: 3
Explanation: LCS for input Sequences
“ABCDGH” and “AEDFHR” is “ADH” of
length 3.
Example 2:

Input:
A = 3, B = 2
str1 = ABC
str2 = AC
Output: 2
Explanation: LCS of "ABC" and "AC" is
"AC" of length 2.
Your Task:
Complete the function lcs() which takes the length of two strings respectively and two strings as input parameters and returns the length of the longest subsequence present in both of them.

Expected Time Complexity : O(|str1|*|str2|)
Expected Auxiliary Space: O(|str1|*|str2|)

Constraints:
1<=size(str1),size(str2)<=103


*/

class LongestCommonSubSequenceRecursive
{
    //Function to find the length of longest common subsequence in two strings.
    static int lcs(int x, int y, String s1, String s2)
    {
        // your code here

        //base case
        if(x==0 || y==0)
            return 0; //if either of the two strings is empty, then we don't have anything to find common out of

        if(s1.charAt(x-1) == s2.charAt(y-1))
            return 1/*as one common character found*/ + lcs(x-1,y-1,s1,s2);
        //our processing spectrum reduces by 1 length for both the strings

        else
            return Math.max(lcs(x-1,y,s1,s2), lcs(x,y-1,s1,s2));
    }

}