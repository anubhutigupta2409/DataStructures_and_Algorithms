/*
Print one sub array whose sum will be equal to the sum of the elements left in the array
________________________________________________________________________________________
Explaining the question-->
suppose the sum of all elements in an array is 20 then we have to divide the array into two subarrays whose sum is equal to 10
each, and print one of those subarrays (if such a combination of elements exists)
_____________
our approach-->
first of all such an array can exist only if the sum of the input array is even, then we keep on adding the elements in an arraylist
and leave the rest on recursive leap of faith, if it is possible to add an element in a particular subarray we return true, else
we return false.
*/


import java.util.*;

public class EqualSumPartitionOfArray
{
	public static void main(String args[])
	{
		int a[] = {2, 1, 2, 3, 4, 8};
		int sum=0;
		for(int i=0;i<a.length;i++)
			sum+=a[i];

		//to store our elements
		ArrayList<Integer> ans= new ArrayList<>();
		/*
		partition is possible only if sum is even, if we convert the sum in binary, then if the last bit is 0 then it's even
		and if it's 1 then it's odd, therefore bitwise AND of sum with '1' returns a '0' if last bit was 0 that is, the sum
		was even
		*/
		boolean isPossible= (sum&1)==0 && partition(a,sum/2,0,ans);

		if(isPossible)
		{
			for(int ele : ans)
				System.out.print(ele+" ");
		}
		else
			System.out.println("SubArray NOT possible");

	}

	static boolean partition(int a[], int sum, int i, ArrayList<Integer> ans)
	{
		if(i>=a.length || sum <0)
			return false;

		if(sum==0)
			return true;

		ans.add(a[i]);

		boolean leftPossible=partition(a,sum-a[i],i+1,ans);

		if(leftPossible)
			return true;

		ans.remove(ans.size()-1);//the backtracking line

		return partition(a,sum,i+1,ans);
	}
}