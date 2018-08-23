public class LongestAscendingSubarray {
  public int longest(int[] array) {
  // Write your solution here
    if(array == null || array.length == 0){
      return 0;
    }
    int max = 1;
    int[] M = new int[array.length];
    M[0] = 1;
    for(int i = 1; i < array.length; ++i){
      if(array[i] > array[i - 1]){
        M[i] = M[i - 1] + 1;
        max = Math.max(max, M[i]);
      } else {
        M[i] = 1;
      }
    }
    return max;
  }
}
