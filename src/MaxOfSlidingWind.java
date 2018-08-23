import java.util.*;
public class MaxOfSlidingWind {
  class Pairs{
    int value;
    int index;
    Pairs(int value, int index){
      this.value = value;
      this.index = index;
    }
  }
  public List<Integer> maxWindows(int[] array, int k) {
    // Write your solution here
    List<Integer> res = new ArrayList<>();
    if(array == null || array.length < k){
      return res;
    }
    Deque<Pairs> deq = new ArrayDeque<>();
    deq.offerFirst(new Pairs(array[0], 0));
    for(int i = 1; i < array.length; ++i){
      if(array[i] > deq.getFirst().value){
        while(deq.getFirst().index < i){
          deq.pollLast();
        }
        deq.offerFirst(new Pairs(array[i], i));
      }
      if(i >= k && i - k == deq.getFirst().index){
        deq.pollFirst();
      }
      res.add(deq.getFirst().value);
    }
    return res;
  }
}
