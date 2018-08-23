import java.util.*;
public class TopkWords {
  public String[] topKFrequent(String[] combo, int k) {
    // Write your solution here
    if(combo.length == 0){
      return new String[0];
    }
    HashMap<String, Integer> map = new HashMap();
    PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>( new Comparator<Map.Entry<String, Integer>>(){
      @Override
      public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2){
        if(e1.getValue() == e2.getValue()){
          return 0;
        }
        return e1.getValue() < e2.getValue() ? -1 : 1;
      }
    });

    for(String s : combo){
      if(!map.containsKey(s)){
        map.put(s, 1);
      } else {
        map.put(s, map.get(s) + 1);
      }
    }
    k = k < map.size() ? k : map.size();
    for(Map.Entry<String, Integer> e: map.entrySet()){
      if(pq.size() < k){
        pq.offer(e);
      } else {
        if(pq.peek().getValue() < e.getValue()){
          pq.poll();
          pq.offer(e);
        }
      }
    }

    String[] topK = new String[k];
    for(int i = 0; i < k; i++){
      topK[k-1-i] = pq.poll().getKey();
    }
    return topK;
  }
}
