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
-->if the last the bit is 1 increment the value of count else not
-->and keep on right shifting the number
*/

import java.util.*;

public class HammingDistance
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
			if((n&1) == 1)
				count++;
			n = (n>>1);
		}

		System.out.println("Hamming distance = "+count);
	}
}
