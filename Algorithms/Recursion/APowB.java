/*
find the a^b using recursion
*/

import java.util.*;

public class APowB
{
	static int pow(int a, int b)
	{
		//base case
		if(b==0)
			return 1;
		//generalise
		else
			return a*pow(a,b-1);//pow(2,5)=pow(2,4)*2 <-- Example
	}
	public static void main(String args[])
	{
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter the value of a and b for (a^b)");
		int a=sc.nextInt();
		int b=sc.nextInt();
		System.out.println("Value of "+a+"^"+b+" = "+pow(a,b));
	}
}