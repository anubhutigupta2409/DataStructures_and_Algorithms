/*
check whether given number is a palindrome or not
*/

import java.util.*;

public class PalindromeNumber
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number-->");
		int n=sc.nextInt();

		int temp=n;
		int reversed=0;

		int lastDig;

		while(temp!=0)
		{
			lastDig= temp%10;
			temp/=10;
			reversed = reversed*10 + lastDig;
		}

		if(reversed==n)
			System.out.println("\nPalindrome");
		else
			System.out.println("\nNot Palindrome");
	}
}