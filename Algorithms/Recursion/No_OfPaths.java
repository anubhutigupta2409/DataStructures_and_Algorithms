/*
find the no. of paths to travel the entire nXm grid using recursion

-->
Explaining the question
_______
|_|_|_|

the above has 3 columns 1 row therefore the no. of ways or paths with which we can reach the end of the grid is =1

similarly-->
___
|_|
|_|
|_|

the above has 3 rows 1 column therefore, no. of ways or paths =1

for a an actual grid
_______
|_|_|_|
|_|_|_|
|_|_|_|

for the above grid if we have reached (3,2), then only one row is left and if we reach (2,3) only one column is left therefore,
total no. of ways for this would be (n,m-1)+(m,n-1)
*/

import java.util.*;

public class No_OfPaths
{
	static int path(int n, int m)
	{
		//base case
		if(n==1 || m==1)
			return 1;
		else
			return path(n,m-1) + path(m,n-1) ;
	}
	public static void main(String args[])
	{
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter the value of n and m for (nXm)");
		int n=sc.nextInt();
		int m=sc.nextInt();
		System.out.println("No. of paths for grid "+n+"X"+m+" ="+path(n,m));
	}
}