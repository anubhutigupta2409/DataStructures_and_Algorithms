/*
Dfs-->

visit the source, print it then add any of it's non-visited neighbours, then add any of it's non-visited neighbours, if everything
is visited then we backtrack to get add the non-visited neighbour
*/

import java.util.*;

public class DFSRecursive
{
	private LinkedList<Integer> adj[];

	public DFSRecursive(int v)
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

	private boolean dfsHelper(int source, int destination, boolean visited[])
	{
		if(source == destination)
			return true;

		for(int neighbour : this.adj[source])
		{
			if(!visited[neighbour])
			{
				visited[neighbour] = true;
				//recursive leap of faith
				boolean isConnected = dfsHelper(neighbour,destination,visited);
				if(isConnected)
					return true;
			}
		}
		return false;
	}

	public boolean dfs(int source, int destination)
	{
		boolean visited[] = new boolean[this.adj.length];
		visited[source] = true;
		return dfsHelper(source, destination, visited);
	}

	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Add no. of vertces and edges-->");
		int vertex = sc.nextInt();
		int edge = sc.nextInt();

		DFSRecursive graph = new DFSRecursive(vertex);

		System.out.println("Enter "+edge+" edges (in form of source followed by destination)");

		for(int i=0;i<edge;i++)
		{
			int source = sc.nextInt();
			int destination = sc.nextInt();

			graph.addEdge(source, destination);
		}

		System.out.println("Enter source and destination (for DFS)-->");
		int source = sc.nextInt();
		int destination = sc.nextInt();

		if(graph.dfs(source,destination))
			System.out.println("Path Possible");

		else
			System.out.println("Path Not Possible");

	}
}