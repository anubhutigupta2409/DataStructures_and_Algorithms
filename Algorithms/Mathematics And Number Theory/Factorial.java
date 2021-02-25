/*
calculate the factorial of the passed number
*/

import java.util.*;

public class Factorial
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the value of n-->");
		int n = sc.nextInt();
		int res=1;
		for(int i=1;i<=n;i++)
			res*=i;

		System.out.println("\n"+n+"! ="+res);
	}
}