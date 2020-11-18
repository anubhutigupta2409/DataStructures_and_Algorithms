/*
find the a^b using recursion
_________

Here we show an optimised approach-->
-keeping in mind that a^b can be written as (a^2)^(b/2)
--we develop two examples
-if a=3 b=7 (b=odd)--> it can be wriiten as 3^7=3*(3*6)===>a*(a^(b-1))
-if a=3 b=6 (b=even)--> it can be written as 3^6=(3^2)^3=(3^2)^(6/2)===> (a^2)^(b/2)
_________

no. of times our method is being called reduces drastically with this approach
*/

import java.util.*;

public class APowB_Optimsed
{
	static int pow(int a, int b)
	{
		//base case
		if(b==0)
			return 1;
		else if(b%2==0)
			return pow(a*a,b/2);
		else
			return a*pow(a,b-1);
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