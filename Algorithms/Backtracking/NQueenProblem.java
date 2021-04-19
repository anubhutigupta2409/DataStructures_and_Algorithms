/*
-->Problem Statement

We are given N no. of queens(relate from chess), and we need to place the N no. of queens in a NXN grid, such that no queen cancel
eachother.

-->Logic
we need to use backtracking and not recursion, so that we can come back and check whether placing a queen at the designated position
is possible or not.
*/

import java.util.*;

public class NQueenProblem
{
	//function to print the final board
	public static void printBoard(int board[][], int N)
	{
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<N;j++)
				System.out.print(board[i][j]+" ");

			System.out.println();
		}
	}

	//function to check whether it is safe to place a queen or not
	//also, since this function is called when we have already placed a queen/or are going to place, therefore, right side need not
	//be checked!
	public static boolean isSafe(int board[][], int row, int col,int N)
	{
		int i,j;

		//left side
		for(i=0;i<col;i++)
			if(board[row][i]==1)
				return false;

		//upper-diagonal left-side
		for(i=row, j=col; i>=0 && j>=0; i--, j--)
			if(board[i][j]==1)
				return false;

		//lower-diagonal left-side
		for(i=row, j=col; j>=0 && i<N; i++, j--)
			if(board[i][j]==1)
				return false;

		return true;

	}

	//function to solve NQueen problem
	public static boolean NQueen(int board[][], int col, int N)
	{
		//all queens are placed
		if(col>=N)
			return true;

		//considering this col, try placing the queen in all the
		//rows
		for(int i=0;i<N;i++)
		{
			if(isSafe(board,i,col,N))
			{
				board[i][col]=1;
				if(NQueen(board, col+1, N))
					return true;

				//else part
				board[i][col]=0;//backtracking possible because of this
			}
		}
		return false;
	}

	//utility--> final method
	public static void solveNQueen(int N)
	{
		int board[][]= new int[N][N];
		for(int i=0;i<N;i++)
			for(int j=0;j<N;j++)
				board[i][j]=0;

		if( !NQueen(board,0,N))
			System.out.println("Solution doesnot exists");

		else
		{
			System.out.println("\nPossible Placement-->");
			printBoard(board,N);
		}

	}
	//main function
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the value of N-->");
		int N= sc.nextInt();
		solveNQueen(N);
	}
}