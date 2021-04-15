/*
Dfs-->

visit the source, print it then add any of it's non-visited neighbours, then add any of it's non-visited neighbours, if everything
is visited then we backtrack to get add the non-visited neighbour

"More space efficient then bfs"

complexity--> O(V+E)
*/

/*
For Example-->

Add no. of vertces and edges-->
5 5
Enter 5 edges (in form of source followed by destination)
0 4
4 3
3 2
2 1
1 2
Enter source and destination (for DFS)-->
0 1
Path Possible
*/

import java.util.*;

public class DFS_Stack
{
	private LinkedList<Integer> adj[];

	public DFS_Stack(int v)
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
		Stack<Integer> s = new Stack<>();

		s.push(source);

		while(!s.empty())
		{
			int curr = s.pop();

			if(curr==destination) return true;

			for(int neighbour : this.adj[curr])
			{
				if(!visited[neighbour])
				{
					visited[neighbour] = true;
					s.push(neighbour);
				}
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

		DFS_Stack graph = new DFS_Stack(vertex);

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
