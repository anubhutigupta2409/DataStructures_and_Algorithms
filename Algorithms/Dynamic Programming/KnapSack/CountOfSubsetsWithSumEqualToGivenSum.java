/*
Count of subsets with sum equal to X
Difficulty Level : Medium

Given an array arr[] of length N and an integer X, the task is to find the number of subsets with a sum equal to X.

Examples:

Input: arr[] = {1, 2, 3, 3}, X = 6
Output: 3
All the possible subsets are {1, 2, 3},
{1, 2, 3} and {3, 3}


Input: arr[] = {1, 1, 1, 1}, X = 1
Output: 4
*/

/*
Very similar to subset sum problem, here we just have to return the count of the valid subsets
*/
class CountOfSubsetsWithSumEqualToGivenSum{
    static int equalPartition(int n, int arr[], int sum)
    {
        // code here

        int dp[][] = new int[n+1][sum+1];

        for(int i=0;i<n+1;i++)
        {
            for(int j=0;j<sum+1;j++)
            {
                if(i==0)
                    dp[i][j]=0;//false means 0 subset
                if(j==0)
                    dp[i][j]=1;//as here the only valid subset is {}, therefore count 1
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
                    int val1= dp[i-1][j-arr[i-1]];//included
                    int val2= dp[i-1][j];//not included

                    dp[i][j]= val1 + val2;//as we want all the counts
                }
                else
                    dp[i][j]= dp[i-1][j];
            }

        }

        return dp[n][sum]
    }
}