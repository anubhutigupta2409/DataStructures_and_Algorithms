/*
Graph is basically a data structure where multiple nodes are connected via edges.

representing a graph-->
Two ways-->
1. Adjacency Matrix (not used as such) O(n^2) (space complexity)
2. Adjacency List (baiscally array of linked lists) (used) O(n + 2*e) (space complexity)
*/

import java.util.*;

public class Graph
{
	private LinkedList<Integer> adj[];

	public Graph(int v)
	{
		adj = new LinkedList[v];
		for(int i=0;i<v;i++)
			adj[i] = new LinkedList<Integer>();
	}
	public void addEdge(int source, int destination)
	{
		adj[source].add(destination);
		adj[destination].add(source);
	}

	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Add no. of vertces and edges-->");
		int vertex = sc.nextInt();
		int edge = sc.nextInt();

		Graph graph = new Graph(vertex);

		System.out.println("Enter "+edge+" edges (in form of source followed by destination)");

		for(int i=0;i<edge;i++)
		{
			int source = sc.nextInt();
			int destination = sc.nextInt();

			graph.addEdge(source, destination);
		}

	}
}