//public class IsBapartite{
//  public boolean isBapartite(List<GraphNode> graph){
//      if(graph == null){
//        return true;
//      }
//      Map<GraphNode> visited = new HashMap<>();
//      if(!assignGroups(graph.get(0)) && visited.size != graph.size()){
//        return false;
//      }
//      return true;
//  }
//
//  private boolean assignGroups(GraphNode node, Map<GraphNode> map){
//    Queue<GraphNode> q = new LinkedList<>();
//    q.offer(node);
//    map.put(node, 0);
//
//    while(!q.isEmpty()){
//      GraphNode cur = q.poll();
//      int curGroup = map.get(cur);
//      int neighborGroup = 1 - curGroup;
//      for(GraphNode ne : cur.neighbors){
//        if(!map.containsKey(ne)){
//          q.offer(ne);
//          map.put(ne, neighborGroup);
//        } else if(map.get(ne) != neighborGroup){
//          return false;
//        }
//      }
//    }
//  }
//}
