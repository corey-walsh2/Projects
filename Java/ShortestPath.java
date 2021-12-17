import java.util.*; 

class ShortestPath {  
	static final int V = 6; 
   
   void dijkstra(int matrix[][], int src) 
	{ 
		int dist[] = new int[V];  
		Boolean workingSet[] = new Boolean[V]; 
		for (int i = 0; i < V; i++) { 
			dist[i] = Integer.MAX_VALUE; 
			workingSet[i] = false; 
		} 
		dist[src] = 0; 
		for (int count = 0; count < V - 1; count++) {  
			int u = minDistance(dist, workingSet); 
			workingSet[u] = true; 
			for (int v = 0; v < V; v++){ 
				if (!workingSet[v] && matrix[u][v] != 0 && 
				dist[u] != Integer.MAX_VALUE && dist[u] + matrix[u][v] < dist[v]) 
					dist[v] = dist[u] + matrix[u][v]; 
         }
		} 
		dumpDijkstra(dist, V); 
	}
   
	int minDistance(int dist[], Boolean workingSet[]) 
	{ 
		int min = Integer.MAX_VALUE, min_index = -1; 
		for (int v = 0; v < V; v++) 
			if (workingSet[v] == false && dist[v] <= min) { 
				min = dist[v]; 
				min_index = v; 
			} 
		return min_index; 
	} 

	void dumpDijkstra(int dist[], int n) 
	{ 
		System.out.println("Node: \t\t Shortest Path Distance:"); 
		for (int i = 0; i < V; i++) 
			System.out.println(i + " \t\t\t\t " + dist[i]); 
	} 

	// Main method
	public static void main(String[] args) 
	{ 
                                    // Interchangeable matrix
		int matrix[][] = new  int[][] { { 0, 6, 10, 0, 0, 0 }, 
                                      { 0, 0, 0, 3, 0, 0 }, 
                                      { 0, 0, 0, 0, 0, 0 }, 
                                      { 0, 0, 2, 0, 0, 0 }, 
                                      { 0, 4, 0, 0, 0, 2 }, 
                                      { 0, 1, 0, 0, 0, 0 } };
		ShortestPath t = new ShortestPath(); 
		t.dijkstra(matrix, 0); 
	} 
} 

