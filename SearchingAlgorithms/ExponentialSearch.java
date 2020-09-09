//Exponential search
/*We first find the range in which value is present and then do binary search in that range-
how we find the range
-
we start of first with subarray of size array and slowly start doubling the size and keep on checking till the last element
of the subarray is greater than the value, and stop when it is greater
**therefore, name is exponential array-
this way we get to know that range is i and i/2(since we could not find the element in previous ranges)
Time complexity- O(logn)
*/

import java.util.*;
public class ExponentialSearch
{
public static int exponentialSearch(int a[], int val)
{
	Arrays.sort(a);
	int n= a.length;
	if(a[0]==val)
		return 0;//if present at the first element itself
	else
	{
	if(n==1)
		return -1;// if array's size was only 1 and the element wasn't found at the first position itself return -1
	//finding the range for binary search
	int i=1;
	while(i<n && a[i]<=val)
		i*=2;
	//call binary search
	return Arrays.binarySearch(a,i/2 /*lower value*/,Math.min(i,n)/*higher value*/,val);
	}
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
	int result=exponentialSearch(a,val);
	if(result==-1)
		System.out.println("Value not found");
	else
		System.out.println("Value "+val+" found at "+result+" index position");
}
}