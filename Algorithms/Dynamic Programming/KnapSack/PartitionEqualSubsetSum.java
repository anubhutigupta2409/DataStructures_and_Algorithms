/*
Partition Equal Subset Sum
Medium
Given an array arr[] of size N, check if it can be partitioned into two parts such that the sum of elements in both parts is the same.

Example 1:

Input: N = 4
arr = {1, 5, 11, 5}
Output: YES
Explaination:
The two parts are {1, 5, 5} and {11}.
Example 2:

Input: N = 3
arr = {1, 3, 5}
Output: NO
Explaination: This array can never be
partitioned into two such parts.

Your Task:
You do not need to read input or print anything. Your task is to complete the function equalPartition() which takes the value N and the array as input parameters and returns 1 if the partition is possible. Otherwise, returns 0.


Expected Time Complexity: O(N*sum of elements)
Expected Auxiliary Space: O(N*sum of elements)


Constraints:
1 = N = 100
1 = arr[i] = 1000


*/

/*
Approach-->
1.here we were given a maximum capacity
2.we had choice to include an element or not
3.therefore variation of 0-1 knapsack
*/
class PartitionEqualSubsetSum{
    static int equalPartition(int n, int arr[])
    {
        // code here

        //initialisation
        //if N==0 and sum==0 then true as {} empty set would be the reqd subset
        //if sum==0 then true as {}
        //if N==0 and sum!=0 then false, as there are no elements in the array
        //which can form a reqd subset

        int sum=0;

        for(int x: arr)
            sum+=x;

        if((sum&1)==1)
            return 0;//odd sum can't be divided

        sum = sum/2;


        boolean dp[][] = new boolean[n+1][sum+1];

        for(int i=0;i<n+1;i++)
        {
            for(int j=0;j<sum+1;j++)
            {
                if(i==0)
                    dp[i][j]=false;
                if(j==0)
                    dp[i][j]=true;
            }
        }

        //now again if current element's value is less than the current sum
        //decide to include it or not
        //else don't include it

        for(int i=1;i<n+1;i++)
        {
            for(int j=1;j<sum+1;j++)
            {
                if(arr[i-1]<=j)
                {
                    boolean val1= dp[i-1][j-arr[i-1]];//included
                    boolean val2= dp[i-1][j];//not included

                    dp[i][j]= val1 || val2;
                }
                else
                    dp[i][j]= dp[i-1][j];
            }

        }

        if(dp[n][sum])
            return 1;
        else
            return 0;
    }
}