public class ArrayDeduplicationII {
  public int[] dedup(int[] array) {
  // Write your solution here
    if(array == null || array.length == 0){
      return array;
    }
    int fast = 0, slow = 0;
    boolean frequencySplitter = false;

    while(fast < array.length){
      if(fast == 0 || array[fast] != array[fast - 1]){
        array[slow++] = array[fast++];
        frequencySplitter = true;
      } else if(frequencySplitter){
        array[slow++] = array[fast++];
        frequencySplitter = false;
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
