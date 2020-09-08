//Interpolation Search
/* this search is slightly optimised version of binary search for certain instances
this works on the given formula and it's block depends on position pos; the higher value of which is returned if given val is
close to a[high] and lower value is returned if given val is close to a[low];
formula=
int pos = low + (((high-low) /
		                  (a[high]-a[low]))*(val - a[low]));
-can be referred to as probe position formula
time complaxity= O(log logn)
worst case- can take upto O(n)
*/

import java.util.*;

public class InterpolationSearch
{
public static int interpolationSearch(int a[],int val)
{
	Arrays.sort(a);//sorted array
	int low=0, high= a.length-1;
	while(high>low && val>=a[low] && val<=a[high])
	{	//just a testcase
		if(low==high)
		{
			if(a[low]==val)
				return low;
			return -1;
		}
		//probe position formula
		int pos = low + (((high-low) /
		                  (a[high]-a[low]))*(val - a[low]));
		if(a[pos]==val)
			return pos;
		//value is larger means in the larger subarray
		if(a[pos]<val)
			low= pos+1;
		//value is less means in the smaller subarray
		else
			high=pos+1;

	}
	return -1;
}
public static void main(String[] args)
{
	Scanner sc= new Scanner(System.in);
	System.out.println("Enter the no. of elements you are going to enter-");
	int n= sc.nextInt();
	int a[]= new int[n];
	System.out.println("Enter the elements-");
	for(int i=0;i<n;i++)
		a[i]=sc.nextInt();
	System.out.println("Enter the value to be found-");
	int val= sc.nextInt();
	int result=interpolationSearch(a,val);
	if(result==-1)
		System.out.println("Value not found");
	else
		System.out.println("Value "+val+" found at "+result+" index position");
}
}