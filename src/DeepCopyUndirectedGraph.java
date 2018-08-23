import java.util.*;

public class DeepCopyUndirectedGraph {
  public List<GraphNode> copy(List<GraphNode> graph) {
    // Write your solution here.
    if(graph == null){
      return null;
    }
    List<GraphNode> result = new ArrayList<>();
    Map<GraphNode, GraphNode> map = new HashMap<>();
    Queue<GraphNode> queue = new LinkedList<>();
    for(GraphNode node: graph){
      if(!map.containsKey(node)){
        queue.offer(node);
        map.put(node, new GraphNode(node.key));
        BFS(queue, map, result);
      }
    }
    return result;
  }

  private void BFS(Queue<GraphNode> queue, Map<GraphNode, GraphNode> map, List<GraphNode> result){
    while(!queue.isEmpty()){
      GraphNode cur = queue.poll();
      GraphNode newCur = map.get(cur);
      result.add(newCur);
      for(GraphNode ne : cur.neighbors){
        if(map.containsKey(ne)){
          newCur.neighbors.add(map.get(ne));
        } else {
          GraphNode newNe = new GraphNode(ne.key);
          newCur.neighbors.add(newNe);
          map.put(ne, newNe);
          queue.offer(ne);
        }
      }
    }
  }
}
