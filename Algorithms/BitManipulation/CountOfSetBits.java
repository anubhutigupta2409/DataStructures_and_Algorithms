/*
Given a positive integer N, print count of set bits in it. 

Example 1:

Input:
N = 6
Output:
2
Explanation:
Binary representation is '110' 
So the count of the set bit is 2.
Example 2:

Input:
8
Output:
1
Explanation:
Binary representation is '1000' 
So the count of the set bit is 1.
Your Task:  
You don't need to read input or print anything. Your task is to complete the function setBits() which takes an Integer N and returns the count of number of set bits.

Expected Time Complexity: O(LogN)
Expected Auxiliary Space: O(1)

Constraints:
1 = N = 109
*/

/*
110&1=0+count(0)-->count=0
110>>1=011
011&1=1+count-->count=1
011>>1=001
001&1=1+count-->count=2
001>>1=000
now n=0-->exit
*/
class Solution {
    static int setBits(int N) {
        // code here
        int count=0;
        while(N!=0)
        {
            count += (N&1);
            N=N>>1;
        }
        return count;
    }
}