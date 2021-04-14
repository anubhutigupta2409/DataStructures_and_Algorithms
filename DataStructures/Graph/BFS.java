/*
Breadth First Search-->

visit a source, print it and then visit all it's neighbours, print any  of it's neighbours then add their neighbours.

Application--> we can find the shortest distance through this also
*/

/*
Example-->

Add no. of vertces and edges-->
5 6
Enter 6 edges (in form of source followed by destination)
0 1
1 2
2 3
3 4
0 4
2 4
Enter source and destination (for BFS)-->
0 3
Shortest path=
3 -> 4 ->
Shortest distance= 2

*/

import java.util.*;

public class BFS
{
	private LinkedList<Integer> adj[];

	public BFS(int v)
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

	public void bfs(int source, int destination)
	{
		Queue<Integer> q = new LinkedList<>();
		boolean vis[] = new boolean[this.adj.length];
		int parent[] = new int[this.adj.length];

		/*maintain a parent array to store where we got a particular vertex from, for example parent of the source would be
		= -1, representing "null" */
		q.add(source);
		parent[source] = -1;
		vis[source] = true;

		while(!q.isEmpty())
		{
			int curr = q.poll();
			if(curr == destination) break;

			for(int neighbour : adj[curr])
			{
				if(!vis[neighbour])
				{
					vis[neighbour] = true;
					q.add(neighbour);
					parent[neighbour] = curr;
				}
			}
		}

		//now to calculate the shortest distance ,traverse the parent array from the destination till the source

		int curr = destination;
		int distance = 0;

		System.out.println("Shortest path= ");

		while(parent[curr] != -1)
		{
			System.out.print(curr + " -> ");
			curr = parent[curr];
			distance++;
		}

		System.out.println("\nShortest distance= " +distance);

	}

	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Add no. of vertces and edges-->");
		int vertex = sc.nextInt();
		int edge = sc.nextInt();

		BFS graph = new BFS(vertex);

		System.out.println("Enter "+edge+" edges (in form of source followed by destination)");

		for(int i=0;i<edge;i++)
		{
			int source = sc.nextInt();
			int destination = sc.nextInt();

			graph.addEdge(source, destination);
		}

		System.out.println("Enter source and destination (for BFS)-->");
		int source = sc.nextInt();
		int destination = sc.nextInt();

		graph.bfs(source,destination);

	}
}