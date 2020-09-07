//Binary Search
/*Array should be sorted
Time complexity(O(Logn)), in comparison of O(n) of linear search (considering worst cases for both algorithms)
This includes dividing the array into subarrays- starting by dividing it into two subarrays from the middle,
1.if the required value matches the middle index , we return mid index
2.if it is greater than the middle element, then we search in the right subarray
3.if it is lesser, then we search in the left subarray
4.we iterate this algorithm until the value is found
5.if not found we return -1
//Iterative Approach*/

import java.util.*;

public class BinarySearch
{
public static int binarySearch(int a[],int val )
{
	int lwr = 0, upr = a.length - 1;
	        while (lwr <= upr) {
	            int mid = lwr + (upr - lwr) / 2;

	            if (a[mid] == val)
	                return mid;

	            if (a[mid] < val)
	                lwr = mid + 1;

	            else
	                upr = mid - 1;
	        }

	 return -1;
}
public static void main(String args[])
{
	Scanner sc= new Scanner(System.in);
	System.out.println("Enter the no. of elements you going to enter");
	int n=sc.nextInt();
	int a[]= new int[n];
	System.out.println("Enter the contents");
	for(int i=0;i<n;i++)
		a[i]=sc.nextInt();
	System.out.println("Enter the value to be found");
	int val=sc.nextInt();

	int result=binarySearch(a,val);
	if(result==-1)
		System.out.println("Value Not Found");
	else
		System.out.println("Your value appeared the first, at the index: "+result);

}
}
