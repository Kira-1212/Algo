import java.util.LinkedList;

class MaxFlow {
	static final int V = 6; // Number of vertices in graph

	/* Returns true if there is a path from source 's' to sink 't' in residual graph. */
	boolean bfs(int rGraph[][], int s, int t, int parent[])
	{
		// Creates a visited array and marks all vertices as not visited
		boolean visited[] = new boolean[V];
		for (int i = 0; i < V; ++i)
			visited[i] = false;

		// Creates a queue, enqueues source vertex and marks source vertex as visited
		LinkedList<Integer> queue = new LinkedList<Integer>();
		queue.add(s);
		visited[s] = true;
		parent[s] = -1;

		// Standard BFS Loop
		while (queue.size() != 0) {
			int u = queue.poll();

			for (int v = 0; v < V; v++) {
				if (visited[v] == false
					&& rGraph[u][v] > 0) {
					
					if (v == t) {
						parent[v] = u;
						return true;
					}
					queue.add(v);
					parent[v] = u;
					visited[v] = true;
				}
			}
		}

		//  sink not reached in BFS starting from source, so return false
		return false;
	}

	// Returns the maximum flow from s to t 
	int maxFlow_FordFulkerson(int graph[][], int s, int t)
	{
		int u, v;

		// Creates a residual graph and fills the residual graph with given capacities in the original graph

		int rGraph[][] = new int[V][V];

		for (u = 0; u < V; u++)
			for (v = 0; v < V; v++)
				rGraph[u][v] = graph[u][v];

		// This array is filled by BFS and to store path
		int parent[] = new int[V];

		int max_flow = 0; 

		// Augments the flow if there is path from source to sink
		while (bfs(rGraph, s, t, parent)) {
			
			String path=""+t;
			int path_flow = Integer.MAX_VALUE;
			
			for (v = t; v != s; v = parent[v]) {
				u = parent[v];
				path=path+" "+u;
				path_flow
					= Math.min(path_flow, rGraph[u][v]);
//				System.out.println("Residual edge: "+u+" "+v+" New Value:"+ (rGraph[u][v]-path_flow));
//				System.out.println(rGraph[u][v]+"   "+path_flow);
			}
			System.out.println("Augmenting path " +path+" min flow "+path_flow);
			// updates residual capacities of the edges and reverses edges along the path
			for (v = t; v != s; v = parent[v]) {
				u = parent[v];
				rGraph[u][v] -= path_flow;
				System.out.println("Residual edge: "+u+" "+v+" New Value:"+ (rGraph[u][v]));
				rGraph[v][u] += path_flow;
				System.out.println("Reverse Residual edge: "+v+" "+u+" New Value:"+ rGraph[v][u]);
			}
			

			// Add path flow to overall flow
			
			max_flow += path_flow;
		}

		// Return the overall flow
		return max_flow;
	}


	public static void main(String[] args) throws java.lang.Exception
	{

		
		int graph[][] = new int[][] {
			{ 0, 16, 13, 0, 0, 0},
			{ 0, 0, 10, 12, 0, 0 },
			{ 0, 4, 0, 0, 14, 0 }, 
			{ 0, 0, 9, 0, 0, 20 },
			{ 0, 0, 0, 7, 0, 4 },
			{ 0, 0, 0, 0, 0, 0 }
		};
		
		MaxFlow m = new MaxFlow();

		System.out.println("The maximum possible flow is " + m.maxFlow_FordFulkerson(graph, 0, 5));
	}
}