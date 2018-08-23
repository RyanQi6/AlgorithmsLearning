public class MaxWaterTrappedI {
  public int maxTrapped(int[] array) {
    // Write your solution here
    if(array == null || array.length < 3){
      return 0;
    }
    int left = 0, right = array.length - 1;
    int water = 0;
    int leftMax = Integer.MIN_VALUE, rightMax = Integer.MIN_VALUE;
    while(left <= right){
      leftMax = Math.max(leftMax, array[left]);
      rightMax = Math.max(rightMax, array[right]);
      if(leftMax < rightMax){
        water += (leftMax - array[left++]);
      } else {
        water += (rightMax - array[right--]);
      }
    }
    return water;
  }
}
