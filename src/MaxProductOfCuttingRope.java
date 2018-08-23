public class MaxProductOfCuttingRope {
  public int maxProduct(int length) {
  // Write your solution here
    if(length <= 1){
      return length;
    }
    int max = 1;
    int[] M = new int[length];
    M[0] = 1;
    M[1] = 1;
    for(int i = 2; i < length; ++i){
      for(int j = 1; j < i; ++j){
        max = Math.max(max, Math.max(j, M[j]) * (i - j));
      }
    }
    return M[length - 1];
  }
}
