public class ArrayHopperI{
  public boolean canJump(int[] array) {
  // Write your solution here
    if(array.length <= 1){
      return true;
    }
    boolean[] M = new boolean[array.length];
    M[array.length - 1] = true;
    for(int i = array.length - 2; i >= 0; --i){
      for(int j = i; j < i + array[i] && j < array.length; ++j){
        M[i] = M[i] || M[j];
      }
    }
    return M[0];
  }
}
