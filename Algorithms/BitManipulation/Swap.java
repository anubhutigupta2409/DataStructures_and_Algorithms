/*
swapping two nos. using extra space-->
(assuming a and b have some values)
temp=a;
a=b;
b=temp;
*/

import java.util.*;

public class Swap
{
	public static void main(String args[])
	{
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter a=");
		int a = sc.nextInt();
		System.out.println("Enter b=");
		int b = sc.nextInt();
		a = a^b;//XOR operation
		b = a^b;
		a = a^b;
		System.out.println("After swapping-->\na="+a+" ,b="+b);
	}
}