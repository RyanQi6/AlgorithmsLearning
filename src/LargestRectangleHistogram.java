import java.util.*;
public class LargestRectangleHistogram {
  public int largest(int[] array) {
    // Write your solution here
    if(array == null || array.length == 0){
      return 0;
    }
    Stack<Integer> s = new Stack<>();
    int max = 0;
    s.push(-1);
    for(int i = 0; i < array.length; ++i){
      if(s.size() <= 1 || array[s.peek()] <= array[i]){
        s.push(i);
      } else if(s.size() > 1 && array[s.peek()] > array[i]) {
        int rightBound = i - 1;
        int height = array[s.pop()];
        int leftBound = s.peek();
        while(height > array[i]){
          max = Math.max(max, height * (rightBound - leftBound));
          if(s.size() > 1 && array[s.peek()] > array[i]){
            height = array[s.pop()];
            leftBound = s.peek();
          } else break;
        }
        s.push(i);
      }
    }
    if(s.size() > 1){
      int rightBound = s.peek();
      int height = array[s.pop()];
      int leftBound = s.peek();
      while(s.size() >= 1){
        max = Math.max(max, height * (rightBound - leftBound));
        if(s.size() == 1){
          break;
        }
        height = array[s.pop()];
        leftBound = s.peek();
      }
    }
    return max;
  }
}
