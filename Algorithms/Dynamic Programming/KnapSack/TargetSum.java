/*
Target Sum
Medium

You are given an integer array nums and an integer target.

You want to build an expression out of nums by adding one of the symbols '+' and '-' before each integer in nums and then concatenate all the integers.

For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1 and concatenate them to build the expression "+2-1".
Return the number of different expressions that you can build, which evaluates to target.



Example 1:

Input: nums = [1,1,1,1,1], target = 3
Output: 5
Explanation: There are 5 ways to assign symbols to make the sum of nums be target 3.
-1 + 1 + 1 + 1 + 1 = 3
+1 - 1 + 1 + 1 + 1 = 3
+1 + 1 - 1 + 1 + 1 = 3
+1 + 1 + 1 - 1 + 1 = 3
+1 + 1 + 1 + 1 - 1 = 3
Example 2:

Input: nums = [1], target = 1
Output: 1


Constraints:

1 <= nums.length <= 20
0 <= nums[i] <= 1000
0 <= sum(nums[i]) <= 1000
-1000 <= target <= 1000
*/

/*
Approach-->
1.here we are only applying + and - sign , which basically divides the array in two subsets , one with + and other with -
and we have to find s1 - s2 = given sum (count of such pairs)
*/
class TargetSum{
    public int findTargetSumWays(int[] arr, int target) {

        //given sum = target
        /*
        s1-s2=target
        s1+s2=sum
        _____________
        2*s1 = sum+ target (even quantity, if comes odd, return 0)
        ______________
        */

        int sumArr=0;
        for(int x: arr)
            sumArr+=x;

        if(((sumArr+target)&1)==1)
            return 0;//odd

        int sum = (sumArr+target)/2;

        int n= arr.length;


        //subset sum count problem from hereon

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
            for(int j=0/*if input array consists of 0*/;j<sum+1;j++)
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

        return dp[n][sum];
    }
}
