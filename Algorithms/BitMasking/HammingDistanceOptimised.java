/*
hamming distance is basically the number of bits we would have to change to convert one number into another.
Example-->
if a = 1 0 1 1 0
   b = 1 1 0 1 1
         ^ ^   ^

   therefore, distance = 3

//concept-->
do a^b and count the number of 1's
**method to calculate the number of 1's
-->n=(n & (n-1))--> this trick makes the Least significant set bit 0, means it clears the 1 to rightmost
-->and the number of times this operation was performed , is the number of 1's we had
*/

import java.util.*;

public class HammingDistanceOptimised
{
	public static void binaryConversion(int n)
	{
		int binN[] = new int[32];
		int c=0;//counter variable
		while(n>0)
		{
			binN[c]=n%2;
			n/=2;
			c++;
		}

		//printing the binary representation(in reverse order)
		for(int j=c-1;j>=0;j--)
			System.out.print(binN[j]+" ");

		System.out.println();
	}
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a = ");
		int a = sc.nextInt();
		System.out.println("Enter b = ");
		int b = sc.nextInt();

		System.out.println("Binary representations-->");
		System.out.println("a=");
		binaryConversion(a);
		System.out.println("b=");
		binaryConversion(b);

		int n= (a^b);

		//calculating 1's

		int count = 0;
		while(n!=0)
		{
			n=(n & (n-1));
			count++;
		}

		System.out.println("Hamming distance = "+count);
	}
}
