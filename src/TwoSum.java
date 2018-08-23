import java.util.*;
public class TwoSum {
  public boolean existSum(int[] array, int target) {
  // Write your solution here
    if(array == null || array.length == 0){
      return false;
    }
    Arrays.sort(array);
    int left = 0, right = array.length - 1;
    while(left < right){
      if(array[left] + array[right] == target){
        return true;
      } else if(array[left] + array[right] < target){
        left++;
      } else {
        right--;
      }
    }
    return false;
  }
}
