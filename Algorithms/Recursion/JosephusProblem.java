/*
//Josephus Problem

-->Problem Statement
You are given n number of friends who are playing the game of death, all of them are standing in a circle, the 0th person(their
positions are indexed) has the gun, in the starting of the game, and he has to kill the kth person (he counts himself too, so that
the possibility exists of him being able to kill himself), and the gun passes to the person, who was next to the person being killed
we need to return the position of the person who wins in the end(that is , remains alive :) );

-->logic building
1. the problem is breaking into (n-1,k) in each round of killing
2. the person (x+k) gets the gun next, if x had the the gun previously
3. now if no one else is left (assuming, and leaving everything else on recursive leap of faith) we can take out the inference that
   the (x+k) person wins
4. since we are in a circle, the (x+k) value can give an overflow index as well, therefore, we return (x+k)%n value
*/


import java.util.* ;

public class JosephusProblem
{
	public static int jos(int n, int k)
	{
		if(n==1)
			return 0;
		return (jos(n-1, k) + k)%n ;
	}
	public static void main( String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of friends(n), and then the number of friends to skip(k)-->");
		int n= sc.nextInt();
		int k= sc.nextInt();
		System.out.println("\nThe person standing at --> "+jos(n,k)+" wins!!");
	}
}