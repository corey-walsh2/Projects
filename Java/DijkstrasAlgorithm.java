public class DijkstrasAlgorithm{
   static class Graph{
      int vertices;
      int matrix[][];
   
      public Graph(int vertex){
         this.vertices = vertex;
         matrix = new int[vertex][vertex];
      }
   
      public void insert(int start, int destination, int weight){
         matrix[start][destination] = weight;
         matrix[destination][start] = weight;
      }
      
      int findMinV(boolean [] mst, int [] key){
         int minKey = Integer.MAX_VALUE;
         int vertex = -1;
         
         for (int i = 0; i < vertices; i++){
            if(mst[i] == false && minKey > key[i]){
               minKey = key[i];
               vertex = i;
            }
         }
         return vertex;
      }
   
      public void minDistance(int startNode){
         boolean[] shortestPath = new boolean[vertices];
         int[] distance = new int[vertices];
         int INFINITY = Integer.MAX_VALUE;
         
         for(int i = 0; i < vertices; i++){
            distance[i] = INFINITY;
         }
         distance[startNode] = 0;
         for (int i = 0; i < vertices; i++){
            int U = findMinV(shortestPath, distance);
            shortestPath[U] = true;
            for (int V = 0; V < vertices; V++){
               if(matrix[U][V] > 0){
                  if(shortestPath[V] == false && matrix[U][V] != INFINITY){
                     int relax = matrix[U][V] + distance[U];
                     if(relax < distance[V]){
                        distance[V] = relax;
                     }
                  }
               }
            }
         }
         dumpDijkstra(startNode, distance);
      }
   
      public void dumpDijkstra(int startNode, int[] key){
         System.out.println("Node: \t\t Shortest Path Distance:");
         for (int i = 0; i < vertices; i++){
            System.out.println(i + " \t\t\t\t " + key[i]);
         }
      }
      
   }

   public static void main(String[] args){
      Graph g = new Graph(6); // graph max node is 6 (0-5)
      g.insert(0, 1, 6);
      g.insert(0, 2, 10);
      g.insert(0, 4, 1);
      g.insert(1, 3, 3);
      g.insert(3, 2, 3);
      g.insert(4, 1, 4);
      g.insert(4, 5, 2);
      g.insert(5, 1, 1);
      g.minDistance(0); // start node = 0
   }
}