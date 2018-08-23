public class LargestSubarraySum {
  public int largestSum(int[] array) {
  // Write your solution here
    int max = Integer.MIN_VALUE;
    int[] M = new int[array.length];
    M[0] = array[0];
    max = array[0];
    for(int i = 1; i < array.length; ++i){
      M[i] = M[i - 1] > 0 ? M[i - 1] + array[i] : array[i];
      max = Math.max(max, M[i]);
    }
    return max;
  }
}
