public class ArrayDeduplicationI {
  public int[] dedup(int[] array){
    if(array == null || array.length == 0){
      return array;
    }
    int fast = 0, slow = 0;
    while(fast < array.length){
      if(array[fast] != array[fast - 1]){
        array[slow++] = array[fast++];
      } else {
        fast++;
      }
    }
    int[] result = new int[slow];
    for(int i = 0; i < slow; i++){
      result[i] = array[i];
    }
    return result;
  }
}
