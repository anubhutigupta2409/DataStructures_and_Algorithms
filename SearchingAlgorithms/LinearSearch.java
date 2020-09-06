//Linear Search
/*we traverse through the array and check whether the value given as argument matches any element inside the array,
if it does we return the index position at which it occurs for the first time, else we return -1*/
import java.util.*;
public class LinearSearch
{
public static int linearSearch(int a[], int x)
{	int i;
	for(i=0;i<a.length;i++)
			if(a[i]==x)
				return i;
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
	int x=sc.nextInt();
	int result=linearSearch(a,x);
	if(result==-1)
		System.out.println("Value Not Found");
	else
		System.out.println("Your value appeared the first, at the index: "+result);

}
}