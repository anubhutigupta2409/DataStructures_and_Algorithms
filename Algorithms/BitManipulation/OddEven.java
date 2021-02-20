/*
checking odd even-->

(normal method, using expensive operator)

if(a%2==0)
	System.out.println("Number is even");
else
	System.out.println("Number is odd");

*/

//using the concept of bit masking over here, that the LSB of the even number is 0 and that of an odd number is 1
//therefore doing & of it with 1, if it gives 0 means==even else odd

import java.util.*;

public class OddEven
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number-->");
		int x = sc.nextInt();
		if((x&1) == 0)
			System.out.println("Even number");
		else
			System.out.println("Odd number");
	}
}