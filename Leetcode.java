
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Leetcode {
  public static void main(String[] args) {
    // unorderd list
    HashMap<Integer, int[]> graph = new HashMap<>();
    graph.put(1, new int[] { 2, 3 });
    graph.put(2, new int[] { 1, 4 });
    graph.put(3, new int[] { 1, 4 });
    graph.put(4, new int[] { 2, 3, 5 });
    graph.put(5, new int[] { 4 });

    // breadth First serach
    ArrayList<Integer> list = new ArrayList<>();
    int[] visited = new int[6];
    Queue<Integer> q = new LinkedList<>();
    q.offer(1);
    visited[1] = 1;
    list.add(1);
    while(!q.isEmpty()){
      int n = q.size();
      while(n-- > 0){
        int node = q.poll();
        for(int neighbour: graph.get(node)){
          if(visited[neighbour] == 0){ //not visited
            visited[neighbour] = 1;
            q.offer(neighbour);
            list.add(neighbour);
          }
        }
      }
    }

    // print the bfs traversal 
    System.out.println(list.toString());
    

  }
}




//class Solution {
//    public int[] dijkstra(int V, int[][] edges, int src) {
//        // 1. Build Adjacency List
//        // Stores: node -> list of [neighbor, weight]
//        HashMap<Integer, ArrayList<ArrayList<Integer>>> adj = new HashMap<>();
//        for (int[] edge : edges) {
//            int u = edge[0];
//            int v = edge[1];
//            int w = edge[2]; // weight
//
//            // For an undirected graph, add edges in both directions
//            adj.computeIfAbsent(u, k -> new ArrayList<>()).add(new ArrayList<>(Arrays.asList(v, w)));
//            adj.computeIfAbsent(v, k -> new ArrayList<>()).add(new ArrayList<>(Arrays.asList(u, w)));
//        }
//
//        // 2. Initialize Distances
//        int[] result = new int[V];
//        Arrays.fill(result, Integer.MAX_VALUE);
//        result[src] = 0; // Distance to source is 0
//
//        // 3. Priority Queue for Dijkstra's
//        // Stores: [node, current_min_distance_to_node]
//        // Sorts by distance (min-heap)
//        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
//        pq.offer(new int[]{src, 0}); // Add source node with distance 0 to PQ
//
//        // 4. Dijkstra's Main Loop
//        while (!pq.isEmpty()) {
//            int currentDistance = pq.peek()[1];
//            int currentNode = pq.peek()[0];
//            pq.poll();
//
//            // Optimization: If we've already found a shorter path to this node,
//            // skip processing it from the PQ. This handles stale entries in the PQ.
//            if (currentDistance > result[currentNode]) {
//                continue;
//            }
//
//            // Get neighbors of the current node
//            // Handle case where a node might not have any outgoing edges in the map
//            ArrayList<ArrayList<Integer>> neighbors = adj.get(currentNode);
//
//            if (neighbors != null) { // Ensure neighbors list is not null
//                for (ArrayList<Integer> neighborInfo : neighbors) {
//                    int neighborNode = neighborInfo.get(0); // The actual neighbor node
//                    int weight = neighborInfo.get(1);       // The weight to this neighbor
//
//                    // If a shorter path to neighborNode is found
//                    if (currentDistance + weight < result[neighborNode]) {
//                        result[neighborNode] = currentDistance + weight; // Update distance
//                        pq.offer(new int[]{neighborNode, result[neighborNode]}); // Add (or update) in PQ
//                    }
//                }
//            }
//        }
//        return result;
//    }
//}
