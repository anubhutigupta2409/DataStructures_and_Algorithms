/*
find the sum of n nos. using recursion
*/

import java.util.*;

public class SumN_Nos
{
	
	static int sum(int n)
	{
		//base case
		if(n==1)
			return 1;
		//generalise
		else
			return n+ sum(n-1);//sum(5)=sum(4)+5 <-- Example

		//you can ask that how we came to knw the value of sum(4)--> but we say ,assume we knw its value-->that's called
		//recursive leap of faith
	}
	public static void main(String args[])
	{
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter the value of n");
		int n=sc.nextInt();
		System.out.println("Sum= "+sum(n));
	}
}
