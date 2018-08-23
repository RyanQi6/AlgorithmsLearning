public class ArrayHopperII {
  public int minJump(int[] array) {
    // Write your solution here
    if(array == null || array.length == 0){
      return -1;
    }
    int len = array.length;
    int[] M = new int[len];
    M[len - 1] = 0;
    for(int i = len - 2; i >= 0; --i){
      int min = Integer.MAX_VALUE;
      for(int j = i + 1; j < len && j <= i + array[i]; ++j){
        min = Math.min(min, M[j]);
      }
      M[i] = min < Integer.MAX_VALUE ? min + 1 : min;
    }
    return M[0] < Integer.MAX_VALUE ? M[0] : -1;
  }
}
