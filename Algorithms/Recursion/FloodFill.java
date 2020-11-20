/*
Matrix : Flood Fill

explaining the question-->
if we are given the following matrix-->

1 1 1 1 1 1 1 1
1 1 1 1 1 1 0 0
1 0 0 1 1 0 1 1
1 2 2 2 2 0 1 0
1 1 1 2 2 0 1 0
1 1 1 2 2 2 2 0
1 1 1 1 1 2 1 1
1 1 1 1 1 2 2 1

if we give input to change (3,1) that is a 2 currently to 3 we will get

1 1 1 1 1 1 1 1
1 1 1 1 1 1 0 0
1 0 0 1 1 0 1 1
1 3 3 3 3 0 1 0
1 1 1 3 3 0 1 0
1 1 1 3 3 3 3 0
1 1 1 1 1 3 1 1
1 1 1 1 1 3 3 1

this is like filling in flood--> for the imput value and the value present above, below, or to the left or to the right
of the current position

*/

import java.util.*;

public class FloodFill
{
	static void floodFill(int a[][], int r, int c, int toFill, int prevFill)
	{
		int row= a.length;
		int col= a[0].length;
		if(r<0 || r>=row || c<0 || c>=col)
			return ;
		else if(a[r][c]!= prevFill)
			return ;

		a[r][c] = toFill;

		floodFill(a,r-1,c,toFill,prevFill);//above
		floodFill(a,r+1,c,toFill,prevFill);//below
		floodFill(a,r,c-1,toFill,prevFill);//left
		floodFill(a,r,c+1,toFill,prevFill);//right


	}

	static void print(int a[][])
	{
		for(int[] array: a)
		{
			for(int element: array)
			{
				System.out.print(element +" ");
			}
			System.out.println();
		}
	}

	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Current Matrix=");
		int a[][]={{1,1,1,1,1,1,1,1},
				   {1,1,1,1,1,1,0,0},
				   {1,0,0,1,1,0,1,1},
				   {1,2,2,2,2,0,1,0},
				   {1,1,1,2,2,0,1,0},
				   {1,1,1,2,2,2,2,0},
				   {1,1,1,1,1,2,1,1},
				   {1,1,1,1,1,2,2,1},
				  };
		print(a);
		System.out.println("Enter the row no.,col no., previous fill and the number to fill");
		int r=sc.nextInt();
		int c=sc.nextInt();
		int prevFill=sc.nextInt();
		int toFill=sc.nextInt();

		System.out.println("\nMatrix now-->\n");
		floodFill(a,r,c,toFill,prevFill);
		print(a);
	}
}