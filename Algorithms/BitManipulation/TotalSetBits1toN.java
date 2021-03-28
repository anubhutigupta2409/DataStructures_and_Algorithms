/*
You are given a number N. Find the total count of set bits for all numbers from 1 to N(both inclusive).

Example 1:

Input: N = 4
Output: 5
Explanation:
For numbers from 1 to 4.
For 1: 0 0 1 = 1 set bits
For 2: 0 1 0 = 1 set bits
For 3: 0 1 1 = 2 set bits
For 4: 1 0 0 = 1 set bits
Therefore, the total set bits is 5.
Example 2:

Input: N = 17
Output: 35
Explanation: From numbers 1 to 17(both inclusive), 
the total number of set bits is 35.

Your Task: The task is to complete the function countSetBits() that takes n as a parameter and returns the count of all bits.

Expected Time Complexity: O(log N).
Expected Auxiliary Space: O(1).

Constraints:
1 = N = 108
*/

/*
Normal solution-->

class Solution{
    
    //Function to return sum of count of set bits in the integers from 1 to n.
    public static int countSetBits(int n){
    
        // Your code here
        int temp,count=0;
        for(int i=1;i<=n;i++)
            {
                temp=i;
                while(temp!=0)
                {
                    temp=(temp & (temp-1));
                    count++;
                }
            }
            
        return count;
        
    }
}
*/

/*
Approach--> (by GFG)

Decimal	E	D	C	B	A
0	0	0	0	0	0
1	0	0	0	0	1
2	0	0	0	1	0
3	0	0	0	1	1
4	0	0	1	0	0
5	0	0	1	0	1
6	0	0	1	1	0
7	0	0	1	1	1
8	0	1	0	0	0
9	0	1	0	0	1
10	0	1	0	1	0
11	0	1	0	1	1
12	0	1	1	0	0
13	0	1	1	0	1
14	0	1	1	1	0
15	0	1	1	1	1
16	1	0	0	0	0
Notice that,

Every alternate bits in A are set.
Every 2 alternate bits in B are set.
Every 4 alternate bits in C are set.
Every 8 alternate bits in D are set.
…..
This will keep on repeating for every power of 2.
So, we will iterate till the number of bits in the number. And we don’t have to iterate every single number in the range from 1 to n.
We will perform the following operations to get the desired result.

, First of all, we will add 1 to the number in order to compensate 0. As the binary number system starts from 0. So now n = n + 1.
We will keep the track of the number of set bits encountered till now. And we will initialise it with n/2.
We will keep one variable which is a power of 2, in order to keep track of bit we are computing.
We will iterate till the power of 2 becomes greater than n.
We can get the number of pairs of 0s and 1s in the current bit for all the numbers by dividing n by current power of 2.
Now we have to add the bits in the set bits count. We can do this by dividing the number of pairs of 0s and 1s by 2 which will give us the number of pairs of 1s only and after that, we will multiply that with the current power of 2 to get the count of ones in the groups.
Now there may be a chance that we get a number as number of pairs, which is somewhere in the middle of the group i.e. the number of 1s are less than the current power of 2 in that particular group. So, we will find modulus and add that to the count of set bits which will be clear with the help of an example.
Example: Consider N = 14
From the table above, there will be 28 set bits in total from 1 to 14.
We will be considering 20 as A, 21 as B, 22 as C and 23 as D

First of all we will add 1 to number N, So now our N = 14 + 1 = 15.

Calculation for A (20 = 1)
15/2 = 7
Number of set bits in A = 7 ————> (i)
Calculation for B (2^1 = 2)
15/2 = 7 => there are 7 groups of 0s and 1s
Now, to compute number of groups of set bits only, we have to divide that by 2.
So, 7/2 = 3. There are 3 set bit groups.
And these groups will contain set bits equal to power of 2 this time, which is 2. So we will multiply number of set bit groups with power of 2
=> 3*2 = 6 —>(2i)
Plus
There may be some extra 1s in this because 4th group is not considered, as this division will give us only integer value. So we have to add that as well. Note: – This will happen only when number of groups of 0s and 1s is odd.
15%2 = 1 —>(2ii)
2i + 2ii => 6 + 1 = 7 ————>(ii)
Calculation for C (2^2 = 4)
15/4 = 3 => there are 3 groups of 0s and 1s
Number of set bit groups = 3/2 = 1
Number of set bits in those groups = 1*4 = 4 —> (3i)
As 3 is odd, we have to add bits in the group which is not considered
So, 15%4 = 3 —> (3ii)
3i + 3ii = 4 + 3 = 7 ————>(iii)
Calculation for D (2^3 = 8)
15/8 = 1 => there is 1 group of 0s and 1s. Now in this case there is only one group and that too of only 0.
Number of set bit groups = 1/2 = 0
Number of set bits in those groups = 0 * 8 = 0 —> (4i)
As number of groups are odd,
So, 15%8 = 7 —> (4ii)
4i + 4ii = 0 + 7 = 7 ————>(iv)
At this point, our power of 2 variable becomes greater than the number, which is 15 in our case. (power of 2 = 16 and 16 > 15). So the loop gets terminated here.
Final output = i + ii + iii + iv = 7 + 7 + 7 + 7 = 28
Number of set bits from 1 to 14 are 28.
*/

class TotalSetBits1toN{
    
    //Function to return sum of count of set bits in the integers from 1 to n.
    public static int countSetBits(int n){
    
        // Your code here
        n++;
        
        int count = n/2;
        int powerOf2 = 2;
        
        while(powerOf2<=n)
        {
            int totalPairs = n/powerOf2;
            
            count += (totalPairs/2)*powerOf2;
            
            count += ((totalPairs&1)==0) ? 0 : (n%powerOf2);
            
            powerOf2 <<= 1;
            
        }
        
        return count;
    }
}