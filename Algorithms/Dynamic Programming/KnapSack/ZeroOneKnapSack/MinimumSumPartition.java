/*
Minimum sum partition
Hard
Given an integer array arr of size N, the task is to divide it into two sets S1 and S2 such that the absolute difference between their sums is minimum and find the minimum difference


Example 1:

Input: N = 4, arr[] = {1, 6, 11, 5}
Output: 1
Explanation:
Subset1 = {1, 5, 6}, sum of Subset1 = 12
Subset2 = {11}, sum of Subset2 = 11
Example 2:
Input: N = 2, arr[] = {1, 4}
Output: 3
Explanation:
Subset1 = {1}, sum of Subset1 = 1
Subset2 = {4}, sum of Subset2 = 4

Your Task:
You don't need to read input or print anything. Complete the function minDifference() which takes N and array arr as input parameters and returns the integer value


Expected Time Complexity: O(N*|sum of array elements|)
Expected Auxiliary Space: O(N*|sum of array elements|)


Constraints:
1 = N*|sum of array elements| = 106


*/
/*
Approach-->
1. we have to minimise |s2-s1|, where s1 and s2 are sums of two valid partitions, somewhere similar to subset sum problem
2. now we know that if we find s1 then s2 = total sum - s1
3. what is the range for s1 = ? --> [0-total sum]
4. but obviously s1 can't have all possible values in the range, therefore it can have only those values which are true in our
subset sum problem's matrix.
5. how do we access it, the last row of the matrix, siginifies n elements and variable sum from 0 to total sum
6. also since we have to minimise |s2-s1|,and s2= sum-s1, therefore now we have to minimise (sum-s1)-s1 = sum - 2*s1
7. also we takeup values uo to only half of the sum, so that s2 is always bigger than s1, and we don't have to takeup abs
*/
class MinimumSumPartition
{

	public int minDifference(int arr[], int n)
	{
	    // Your code goes here

	    //creating the matrix, same as subset sum problem
	    int sum=0;

	    for(int x : arr)
	        sum+=x;

	    boolean dp[][]= new boolean[n+1][sum+1];

	    //base condition
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

	    //fill the rest matrix
	    for(int i=1;i<n+1;i++)
	    {
	        for(int j=1;j<sum+1;j++)
	        {
	            if(arr[i-1]<=j)
	            {
	                boolean val1 = dp[i-1][j-arr[i-1]];//included
	                boolean val2 = dp[i-1][j];//not included
	                dp[i][j]= val1 || val2;
	            }
	            else
	                dp[i][j] = dp[i-1][j];//simply don't include
	        }
	    }

	    //s1 lies in the half matrix, last row
	    //store in a list

	    ArrayList<Integer> list = new ArrayList<>();

	    for(int j=0;j<=Math.ceil(sum)/2; j++)
	        if(dp[n][j]==true)
	            list.add(j);

	   //now minimising |s2-s1|,  but s2 lies in the other half of the
	   //last row, therefore minimise |Sum-s1 - s1| = sum - 2*s1

	   int min = Integer.MAX_VALUE;

	   for(int i=0;i<list.size();i++)
	        min = Math.min(min, sum-2*list.get(i));

	    return min;

	}
}
