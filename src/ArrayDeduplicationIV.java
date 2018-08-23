import java.util.*;
public class ArrayDeduplicationIV {
  public int[] dedup(int[] array) {
    // Write your solution here
    if(array == null || array.length < 2){
      return array;
    }
    int stackTop = 0;
    for(int i = 1; i < array.length; i++){
      if(stackTop < 0 || array[stackTop] != array[i]){
        array[++stackTop] = array[i];
      } else {
        while(i + 1 < array.length && array[i + 1] == array[i]) {
          i++;
        }
        stackTop--;
      }
    }
    return Arrays.copyOf(array, stackTop + 1);
  }
}
