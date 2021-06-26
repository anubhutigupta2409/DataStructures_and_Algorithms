/*
Palindromic patitioning 
Hard
Given a string str, a partitioning of the string is a palindrome partitioning if every sub-string of the partition is a palindrome. Determine the fewest cuts needed for palindrome partitioning of given string.


Example 1:

Input: str = "ababbbabbababa"
Output: 3
Explaination: After 3 partitioning substrings 
are "a", "babbbab", "b", "ababa".
Example 2:

Input: str = "aaabba"
Output: 1
Explaination: The substrings after 1
partitioning are "aa" and "abba".

Your Task:
You do not need to read input or print anything, Your task is to complete the function palindromicPartition() which takes the string str as input parameter and returns minimum number of partitions required.


Expected Time Complexity: O(n*n) [n is the length of the string str]
Expected Auxiliary Space: O(n*n)


Constraints:
1 = length of str = 500


*/
class PalindromicPartitioningRecursive{
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
    static int util(String str, int i, int j)
    {
        //base condition
        if(i>=j || isPalindrome(str,i,j)/*we could discard the first condition as it can be checked in the second condition as well, coz string of size 0 and 1 are palindrome, but have mentioned for our convinience to relate to the MCM Pattern*/)
            return 0;
            
        int ans = Integer.MAX_VALUE;
        
        //loop
        for(int k=i; k<=j-1; k++)
        {
            //temp ans
            int tempAns = util(str,i,k) + util(str,k+1,j) + 1;
            
            //final ans
            ans = Math.min(ans,tempAns);
        }
        
        return ans;
        
    }
    static int palindromicPartition(String str)
    {
        // code here
        
        return util(str, 0, str.length()-1);
    }
}