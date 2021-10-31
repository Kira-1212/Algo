import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class MinCut{
	// Lists to store the vertices
	static List<Integer> verticeSet1 = new ArrayList<>();
	static List<Integer> verticeSet2 = new ArrayList<>();
	static List<List<Integer>> verticeList = new ArrayList<>();
	static int find(Subset subsets[], int i)
	{
	    // finds root and makes root as parent of i

	    if (subsets[i].parent != i)
	      subsets[i].parent = find(subsets, subsets[i].parent);
	 
	    return subsets[i].parent;
	}
	
	static void union(Subset subsets[], int x, int y)
	{
	    int xroot = find(subsets, x);
	    int yroot = find(subsets, y);
	 
	    // Attaches smaller rank tree under root of high rank tree (Union by Rank)
	    if (subsets[xroot].rank < subsets[yroot].rank)
	        subsets[xroot].parent = yroot;
	    else if (subsets[xroot].rank > subsets[yroot].rank)
	        subsets[yroot].parent = xroot;
	 
	    // If ranks are same, then make one as root and increment its rank by one
	    else
	    {
	        subsets[yroot].parent = xroot;
	        subsets[xroot].rank++;
	    }
	}
	
	static int minCut_Karger(Graph graph)
	{
	   
	    int V = graph.V, E = graph.E;
	    Edge edge[] = graph.edgeList;
	    Random rand = new Random();
	    // Allocate memory for creating V subsets.
	    Subset subsets[] = new Subset[V];
	 
	    // Create V subsets with single elements
	    for (int v = 0; v < V; ++v)
	    {
	        subsets[v] = new Subset(v,0);
	    }
	 
	    // Initially there are V vertices in contracted graph
	    int vertices = V;
	 
	    // logic to Keep contracting vertices until there are only 2 vertices.
	    while (vertices > 2)
	    {
	       // Pick a random edge
	       int i = (int)(Math.random() *100) % E;
	 
	       // Find vertices (or sets) of two corners of current edge
	       int subset1 = find(subsets, edge[i].src);
	       int subset2 = find(subsets, edge[i].dest);
	       //System.out.println("Subset 1 : " + subset1);
	       //System.out.println("Subset 2 : " + subset2);
	       
	       // If two corners belong to same subset, then no point considering this edge
	       if (subset1 == subset2)
	         continue;
	 
	       // Else contract the edge (or combine the corners of edge into one vertex)
	       else
	       {
	    	  verticeSet1.add(edge[i].src);
	    	  verticeSet2.add(edge[i].dest);
	    	  List<Integer> arr = new ArrayList<>();
	    	  arr.add(edge[i].dest);
	    	  arr.add(edge[i].dest);
	    	  verticeList.add(arr) ;
	          //System.out.println("Contracting vertices "+ edge[i].src + " "+  edge[i].dest);
	          vertices--;
	          union(subsets, subset1, subset2);
	       }
	    }
	 
	    // Now we have two vertices (or subsets) left in the contracted graph, so count the edges between two components and return the count.
	    int cutedges = 0;
	    for (int i=0; i<E; i++)
	    {
	        int subset1 = find(subsets, edge[i].src);
	        int subset2 = find(subsets, edge[i].dest);
	        if (subset1 != subset2)
	          cutedges++;
	    }
	 
	    return cutedges;
	}
	static boolean check(int [] arr, int k) {
		for (int element : arr) {
		    if (element == k) {
		        return true;
		    }
		}
		return false;
	}
	
	public static void main(String[] args) {
		int V = 9;  // Number of vertices in graph
	    int E = 18;  // Number of edges in graph
	    Graph graph = new Graph(V, E);
	 

	    graph.edgeList[0] = new Edge(0,1);
	 
	    graph.edgeList[1] = new Edge(0,2);

	    graph.edgeList[2] = new Edge(0,3);
	    
	    graph.edgeList[3] = new Edge(0,4);
	    
	    graph.edgeList[4] = new Edge(1,2);
	 
	    graph.edgeList[5] = new Edge(1,3);
	    
	    graph.edgeList[6] = new Edge(1,4);
	    
	    graph.edgeList[7] = new Edge(1,5);
	    
	    graph.edgeList[8] = new Edge(2,3);
	    
	    graph.edgeList[9] = new Edge(2,4);
	    
	    graph.edgeList[10] = new Edge(3,4);
	 
	    graph.edgeList[11] = new Edge(4,6);
	    
	    graph.edgeList[12] = new Edge(5,6);
	    
	    graph.edgeList[13] = new Edge(5,7);
	    
	    graph.edgeList[14] = new Edge(5,8);
	 
	    graph.edgeList[15] = new Edge(6,7);
	    
	    graph.edgeList[16] = new Edge(6,8);
	    
	    graph.edgeList[17] = new Edge(7,8);
	    int minCut = minCut_Karger(graph);

	    Graph2 g = new Graph2(V);
	    for(int  i = 0; i<verticeSet1.size();i++ ) {
	    	g.addEdge(verticeSet1.get(i), verticeSet2.get(i));
	    }
	    //System.out.println("Following are connected components");
	    g.connectedComponents();
	    System.out.println(g.result);
	    System.out.println("Mincut is: " + minCut);
	   }
}

class Graph2
{

	static List<List<Integer>> result = new ArrayList<>();
    int V;
    ArrayList<ArrayList<Integer> > adjListArray;
    Graph2(int V)
    {
        this.V = V;
        adjListArray = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjListArray.add(i, new ArrayList<>());
        }
    }

    void addEdge(int src, int dest)
    {
        adjListArray.get(src).add(dest);
        adjListArray.get(dest).add(src);

    }

    void DFSUtil(int v, boolean[] visited, List<Integer> l)
    {
        visited[v] = true;
        //System.out.print(v + " ");
        l.add(v);
        for (int x : adjListArray.get(v)) {
            if (!visited[x])
                DFSUtil(x, visited, l);
        }

    }

    void connectedComponents()
    {
        boolean[] visited = new boolean[V];
        for (int v = 0; v < V; ++v) {
            if (!visited[v]) {
            	List<Integer> l = new ArrayList<Integer>();
                DFSUtil(v, visited, l);
                Collections.sort(l);
                result.add(l);
                //System.out.println();
            }
        }
    }
}
class Edge
{
	int src;
	int dest;
	Edge(int s, int d){
		this.src = s;
		this.dest = d;
	}
}

class Graph{
	int V;
	int E;
	Edge edgeList[];
	Graph(int V, int E){
		this.V = V;
		this.E = E;
		this.edgeList = new Edge[E];
	}
}

class Subset{
	int parent;
    int rank;
    Subset(int p, int r) {
    	this.parent = p;
    	this.rank = r;
    }
}
