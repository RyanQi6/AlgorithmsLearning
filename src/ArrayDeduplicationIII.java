public class ArrayDeduplicationIII {
  public int[] dedup(int[] array) {
  // Write your solution here
    if(array == null || array.length < 2){
      return array;
    }

    int slow = 0, fast = 0;
    while(fast < array.length){
      int begin = fast;
      while(fast < array.length && array[fast] == array[begin]){
        fast++;
      }
      if(fast - begin == 1){
        array[slow++] = array[begin];
      }
    }
    int[] result = new int[slow];
    for(int i = 0; i < result.length; i++){
      result[i] = array[i];
    }
    return result;
  }
}
