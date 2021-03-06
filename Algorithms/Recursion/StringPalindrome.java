/*
--> Find if the input string is a palindrome or not

--> logic

(i) a b c b a --> a b c b a --> a b c b a
	^       ^		^	^			^
	|     	|		|	|			|
	L		R	   L+1 R-1		   (L==R)--> return yes
	(check if the characters at the two pointer positions are equal then move inside)

(ii)a --> (L==R) --> return yes
(iii)a b b a --> a b b a --> a b b a
	 ^	   ^	   ^ ^		   ^ ^
	 |	   |  	   | |         | |
	 L	   R       L R         R L  (L>R)--> return yes
*/

import java.util.*;

public class StringPalindrome
{
	public static boolean isPalindrome(String s, int L, int R)
	{
		if(L>=R)
			return true;

		if(s.charAt(L) != s.charAt(R))
			return false;

		return isPalindrome(s, L+1, R-1);
	}

	public static boolean isPalindrome(String s)
	{
		return isPalindrome(s, 0, s.length() - 1);
	}
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the string");
		String s = sc.nextLine();
		if(isPalindrome(s))
			System.out.println("Palindrome!");
		else
			System.out.println("Not a Palindrome!");
	}
}