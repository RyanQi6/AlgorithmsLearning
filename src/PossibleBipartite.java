import java.util.*;
public class PossibleBipartite {
  public boolean possibleBipartition(int N, int[][] dislikes) {
    if(dislikes.length == 0){
      return true;
    }
    Map<Integer, Integer> colors = new HashMap<>();
    Map<Integer, List<Integer>> graph = getGraph(N, dislikes);
    for(int i = 0; i < N; i++){
      if(!graph.containsKey(i)){
        continue;
      } else {
        if(!BFS(i, graph, colors, N)){
          return false;
        }
      }
    }
    return true;
  }
  private boolean BFS(int i, Map<Integer, List<Integer>> graph, Map<Integer, Integer> map, int N){
    if(map.containsKey(i)) return true;
    Queue<Integer> queue = new LinkedList<>();
    queue.offer(i);
    map.put(i, 0);
    while(!queue.isEmpty()){
      Integer n = queue.poll();
      int curGroup = map.get(n);
      int adGroup = 1 - curGroup;
      List<Integer> advers = graph.get(n);
      for(Integer adv: advers){
        if(!map.containsKey(adv)){
          queue.offer(adv);
          map.put(adv, adGroup);
        }
        if(map.containsKey(adv) && curGroup == map.get(adv)){
          return false;
        }
      }
    }
    return true;
  }
  private Map<Integer, List<Integer>> getGraph(int N, int array[][]){
    Map<Integer, List<Integer>> map = new HashMap<>();
    for(int i = 0; i < array.length; i++){
      List<Integer> li0 = map.containsKey(array[i][0]) ? map.get(array[i][0]) : new ArrayList<>();
      List<Integer> li1 = map.containsKey(array[i][1]) ? map.get(array[i][1]) : new ArrayList<>();
      li0.add(array[i][1]);
      li1.add(array[i][0]);
      map.put(array[i][0], li0);
      map.put(array[i][1], li1);
    }
    return map;
  }
}
