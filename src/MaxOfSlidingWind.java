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
    for(int i = 0; i < array.length; ++i){
      while(deq.size() > 0 && array[i] >= deq.peekLast().value){
        deq.pollLast();
      }
      if(deq.size() > 0 && deq.peekFirst().index <= i - k){
        deq.pollFirst();
      }
      deq.offerLast(new Pairs(array[i], i));
      if(i >= k - 1){
        res.add(deq.peekFirst().value);
      }
    }
    return res;
  }
}
