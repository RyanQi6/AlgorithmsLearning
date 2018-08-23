import java.util.*;
public class TwoSumInAllPairsII {
  public List<List<Integer>> allPairs(int[] array, int target) {
    // Write your solution here
    List<List<Integer>> res = new ArrayList<>();
    if(array == null || array.length < 2){
      return res;
    }
    Arrays.sort(array);
    int left = 0, right = array.length - 1;
    while(left < right){
      if(left != 0 && array[left] == array[left - 1]){
        left++;
      } else if(right != array.length - 1 && array[right] == array[right + 1]){
        right--;
      } else if(array[left] + array[right] == target){
        List<Integer> li = new ArrayList<>();
        li.add(array[left++]);
        li.add(array[right--]);
        res.add(li);
      } else if(array[left] + array[right] < target){
        left++;
      } else if(array[left] + array[right] > target){
        right--;
      }
    }
    return res;
  }
}
