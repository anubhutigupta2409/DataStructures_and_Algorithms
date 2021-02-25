/*
Find the number of trailing zeroes in the factorial of n(given as input).

Example-->
12!= 479001600

therefore, number of trailing zeroes over here --> 2

concept-->
12!= 12X11X10X9X8X7X6X5X4X3X2X1 (will exceed, int/long limit)

therefore, calculate the number of (2X5) pairs to calculate the trailing zeroes
--> can be calculated by counting number of 5's

--> logic

(floor value taken)
[n/5] + [n/25] + [n/125] + .....
(n>5)	(n>25)	 (n>125)
*/

import java.util.*;

public class TrailingZeroesInFactorial
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number-->");
		int n = sc.nextInt();

		int res=0;
		for(int i=5;i<=n;i*=5)
			res += n/i;

		System.out.println("\nTrailing zeroes in "+n+"! = "+res);
	}
}

