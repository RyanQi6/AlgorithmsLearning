import java.util.*;
public class Percentile {
  public int percentile95(List<Integer> lengths) {
    // Write your solution here.
    if(lengths == null || lengths.size() == 0){
        return 0;
    }
    int size = (int) Math.ceil(lengths.size() * 0.05);
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    for(int i = 0; i < lengths.size(); i++){
      if(minHeap.size() < size){
        minHeap.offer(lengths.get(i));
      } else if(lengths.get(i) >= minHeap.peek()) {
        minHeap.offer(lengths.get(i));
      }
    }

    if(minHeap.size() > size){
      while(minHeap.size() > size){
        minHeap.poll();
      }
    }
    return minHeap.peek();
  }
}
