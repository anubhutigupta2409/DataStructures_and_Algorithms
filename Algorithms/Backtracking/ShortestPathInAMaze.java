/*
Find the shortest path in a maze
________________________________
Explaining the question-->

we will be given a matrix and a source and a destination (both in the form of (row no., col no.)), the maze will be in the form of
a matrix filled with only 0s and 1s, a valid path is only when the path has only 1s and a path is closed if we encounter a 0, return
the minimum number of steps to reach the destination from the source.
________________________________
our approach-->

first of all we make sure whether the index position we are standing at is a valid position or not(this can be defined by, if the
index position is still inside the matrix and is a 1), if it is valid we move forward(left,right,top,bottom) and increment our no.
of steps by 1, by doing so we mark the index position as a true(as in-->visited), and then we backtrack to the source index by
making all of them false(so that some other path can visit those positions), and then we return the minimum of all the possible
paths.

here our base condition would be if source is equal to destination then return 0, as we didnot need to move any step
*/

public class ShortestPathInAMaze
{
	static int shortestPath(int a[][], int srcI, int srcJ, int desI, int desJ)
	{
		int row= a.length;
		int col= a[0].length;

		boolean visited[][]=new boolean[row][col];
		//here we have overriden the method since we needed a visited boolean matrix too ,to solve the problem from
		//our approach
		return shortestPath(a,srcI,srcJ,desI,desJ,visited);
	}

	//the valid method

	static boolean isValid(int a[][], int i, int j, boolean visited[][])
	{
		int rows= a.length;
		int cols= a[0].length;

		return i >= 0 && j >= 0 && i < rows && j < cols && a[i][j] == 1 &&
				!visited[i][j];
	}

	//the method to solve the problem
	static int shortestPath(int a[][], int srcI, int srcJ, int desI, int desJ, boolean visited[][])
	{
		//checking for valid
		if(!isValid(a,srcI,srcJ,visited))
			return 1000000;//just returning a big number

		//base case
		if(srcI==desI && srcJ==desJ)
			return 0;

		//making the current position true
		visited[srcI][srcJ]=true;

		int left= shortestPath(a, srcI, srcJ-1, desI, desJ, visited) +1;
		int right= shortestPath(a, srcI, srcJ+1, desI, desJ, visited) +1;
		int down= shortestPath(a, srcI+1, srcJ, desI, desJ, visited) +1;
		int up= shortestPath(a, srcI-1, srcJ, desI, desJ, visited) +1;

		//making backtracking work
		visited[srcI][srcJ]=false;

		//returning minimum
		return Math.min(Math.min(left,right) , Math.min(down,up));
	}

	public static void main(String[] args) {
			int a[][] =
				{
						{ 1, 1, 1, 1, 1, 0, 0, 1, 1, 1 },
						{ 0, 1, 1, 1, 1, 1, 0, 1, 0, 1 },
						{ 0, 0, 1, 0, 1, 1, 1, 0, 0, 1 },
						{ 1, 0, 1, 1, 1, 0, 1, 1, 0, 1 },
						{ 0, 0, 0, 1, 0, 0, 0, 1, 0, 1 },
						{ 1, 0, 1, 1, 1, 0, 0, 1, 1, 0 },
						{ 0, 0, 0, 0, 1, 0, 0, 1, 0, 1 },
						{ 0, 1, 1, 1, 1, 1, 1, 1, 0, 0 },
						{ 1, 1, 1, 1, 1, 0, 0, 1, 1, 1 },
						{ 0, 0, 1, 0, 0, 1, 1, 0, 0, 1 },
				};

			int result = shortestPath(a, 0, 0, 8, 0);
			if(result >= 1000000) {
				System.out.println("No path possible");
			} else {
				System.out.println(result);
			}

	}
}