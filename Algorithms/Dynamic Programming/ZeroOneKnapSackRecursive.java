/*

0 - 1 Knapsack Problem
Medium
You are given weights and values of N items, put these items in a knapsack of capacity W to get the maximum total value in the knapsack. Note that we have only one quantity of each item.
In other words, given two integer arrays val[0..N-1] and wt[0..N-1] which represent values and weights associated with N items respectively. Also given an integer W which represents knapsack capacity, find out the maximum value subset of val[] such that sum of the weights of this subset is smaller than or equal to W. You cannot break an item, either pick the complete item or don’t pick it (0-1 property).

Example 1:

Input:
N = 3
W = 4
values[] = {1,2,3}
weight[] = {4,5,1}
Output: 3
Example 2:

Input:
N = 3
W = 3
values[] = {1,2,3}
weight[] = {4,5,6}
Output: 0
Your Task:
Complete the function knapSack() which takes maximum capacity W, weight array wt[], value array val[], and the number of items n as a parameter and returns the maximum possible value you can get.

Expected Time Complexity: O(N*W).
Expected Auxiliary Space: O(N*W)

Constraints:
1 = N = 1000
1 = W = 1000
1 = wt[i] = 1000
1 = v[i] = 1000


*/

/*
The following is brute force solution, since we were able to identify that we have to make choices whether to or not include a
weight in our knapsack, we can do this recursion.
The following solution will obviously give us TLE Error, but this is just to show that recursion is DP's parent, and dp questions
can def be done by recursion, but we use DP to reduce the unncessary same processing steps(which we will learn later on).
*/
class ZeroOneKnapSackRecursive
{
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int w, int wt[], int val[], int n)
    {
         // your code here
         //base condition
         if(w==0 || n==0)
            return 0;

        //if we can put it into the bag
        if(wt[n-1]<=w)
        {
            int val1= val[n-1] + knapSack(w-wt[n-1], wt, val, n-1);//included
            int val2= 0 + knapSack(w,wt,val,n-1);//not included

            return Math.max(val1,val2);//as we have to maximise
        }

        else /*if(wt[n-1]>w)*/
            return knapSack(w,wt,val,n-1);//simply don't include
    }
}


