import java.util.*;
public class GraphNode{
     public int key;
     public List<GraphNode> neighbors;
     public GraphNode(int key) {
       this.key = key;
       this.neighbors = new ArrayList<GraphNode>();
     }

   // public List<GraphNode> generateAjacecncyList(int[][] adjacencyArray){
   //   List<GraphNode> graph = new ArrayList<>();
   //   if(adjacencyArray == null){
   //     return null;
   //   }
   //
   // }
}
