/*
Rod Cutting

Given a rod of length N inches and an array of prices that contains prices of all pieces of size smaller than N. Determine the maximum value obtainable by cutting up the rod and selling the pieces.



Example 1:

Input:
N = 8
Price[] = {1, 5, 8, 9, 10, 17, 17, 20}
Output:
22
Explanation:
The maximum obtainable value is 22 by
cutting in two pieces of lengths 2 and
6, i.e., 5+17=22.
Example 2:

Input:
N=8
Price []={3,   5,   8,   9,  10,  17,  17,  20}
Output: 24
Explanation:
The maximum obtainable value is
24 by cutting the rod into 8 pieces
of length 1, i.e, 8*3=24.

Your Task:
You don't need to read input or print anything. Your task is to complete the function cutRod() which takes the array A[] and its size N as inputs and returns the maximum price obtainable.



Expected Time Complexity: O(N2)
Expected Auxiliary Space: O(N)



Constraints:
1 = N = 1000
1 = Ai = 105


*/

/*
Note-->
if we used 2D array space approach over here, then in initialisation step first row would be initialised w Integer.MIN_VALUE (except
the cell dp[0][0], which will be 0), as in knapsack, we had choice whether we can fill the knapsack completely or not, but here
we have to cut the enitre rod, as rod has fixed length. and the first column will be 0
*/
class RodCuttingProblem{
    public int cutRod(int price[], int n) {
        //code here

        int len[] = new int[n];

        for(int i=0;i<n;i++)
            len[i] = i+1;//making length array

        int l = len.length;//to avoid confusion

        //dp
        int dp[]= new int[l+1];

        //initialisation
        for(int i=0;i<l+1;i++)
            for(int j=0;j<n;j++)
                if(len[j]<=i)
                    dp[i] = Math.max(dp[i], price[j]+dp[i-len[j]]);

        return dp[l];



    }
}