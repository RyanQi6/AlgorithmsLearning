import java.util.*;
import java.lang.*;

public class PerfectShuffle {
  public void shuffle(int[] array){
    if(array == null || array.length == 0){
      return;
    }
    int len = array.length;
    for(int i = 0; i < len; i++){
      int j = (int) (Math.random() * (len - i)) + i;
      swap(array, i, j);
    }
  }

  private void swap(int[] array, int i, int j){
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }
}
