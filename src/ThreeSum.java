import java.util.*;
public class ThreeSum {
  public List<List<Integer>> allTriples(int[] array, int target) {
    // Write your solution here
    List<List<Integer>> all = new ArrayList<>();
    if(array == null || array.length < 3){
      return all;
    }
    Arrays.sort(array);
    for(int i = 0; i < array.length - 2; ++i){
      if(i != 0 && array[i] == array[i-1]){
        continue;
      }
      int left = i + 1, right = array.length - 1;
      while(left < right){
        if((left != i + 1 && array[left] == array[left - 1])
            || array[left] + array[right] + array[i] < target){
          left++;
        } else if((right != array.length - 1 && array[right] == array[right + 1])
                  || array[left] + array[right] + array[i] > target){
          right--;
        } else if(array[left] + array[right] + array[i] == target){
          all.add(new ArrayList<Integer>(Arrays.asList(array[i], array[left++], array[right--])));
        }
      }
    }
    return all;
  }
}
