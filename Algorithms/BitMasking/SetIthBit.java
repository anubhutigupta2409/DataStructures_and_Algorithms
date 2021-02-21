/*
Setting Ith bit means making it 1 if it is not
concept -->
0 | anything = anything
1 | anything = 1//therefore to set to 1 we do OR that bit with 1
*/

import java.util.*;

public class SetIthBit
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

	public static boolean validateI(int i, int n)
	{
		if( i>=0 && i<(int)(Math.log(n)/Math.log(2)))
			return true;
		else
			return false;
	}

	public static void main(String args[])
	{
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter the decimal number-->");
		int n= sc.nextInt();

		//decimal to binary conversion
		System.out.println("it's binary representation-->");
		binaryConversion(n);

		System.out.println("Enter the index of the bit to set-->");
		int i= sc.nextInt();

		//validating i
		if(validateI(i,n))
		{
			int mask= (1<<i);
			n = n | mask;
			System.out.println("After setting the number is= "+n+"\nBinary representation is-->");
			binaryConversion(n);
		}
		else
		{
			System.out.println("Invalid i");
		}
	}
}