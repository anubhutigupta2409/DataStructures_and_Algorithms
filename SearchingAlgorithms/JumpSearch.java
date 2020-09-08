//Jump Search
/*Jump Search , just like binary search works on the sorted arrays, the name is jump since it jumps through or skips some
elements in the array while finding the particular element.
For eg. we have an array of n elements and the optimal jump block size is m then we search at the indexes a[m],a[2m]..
Now, what can be the optimal jump block size??
Taking the worst case we do n/m jumps with m-1 comparisons therefore the value of function comes out to be (n/m)+(m-1);
and performing the right differential equation mathematics we calculate that this function is minimum at value sqrt(n)
;therefore, m=sqrt(n) and also time complexity for jump search= O(sqrt(n));
**Note- Since it is in the java. lang package, the Math class does not need to be imported.
*/

import java.util.*;

public class JumpSearch
{
public static int jumpSearch(int a[], int val)
{
	Arrays.sort(a);//since sorted array is required
	int n= a.length;
	int m= (int)(Math.floor(Math.sqrt(n)));// we want the floor value of the sqrt value
	//typecasted to int as Math class returns double
	int pre= 0;//to return to the previous block if value is not found
	while(a[Math.min(m,n)-1]<val)
	{	//this loop will work until we have found an interval for ourselves
		//that is till the element at the position minimum out of n or m
		//we have taken a variable pre to denote previous index no. to mark the inteval
		pre=m;
		//and we keep on increasing the m with regular intevals until value is in our range
		m+=(int)(Math.floor(Math.sqrt(n)));
		//if we cross the array size while increasing the intervals, means value is not present
		if(pre>=n)
			return -1;

	}
	//now we search each and every element to get the desired index
	//that is do a linear search
	while(a[pre]<val)
	{	//we keep on increasing the value of v
		pre++;
		//if we reached the next m or the end of the array-value id not present
		if(pre==Math.min(m,n))
			return -1;

	}
	if(a[pre]==val)
		return pre;

	//if value was found then the required index would already have been returned
	//once the value is returned , it doesnot go back to the function
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
	int result=jumpSearch(a,val);
	if(result==-1)
		System.out.println("Value not found");
	else
		System.out.println("Value "+val+" found at "+result+" index position");
}
}