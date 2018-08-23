import java.util.*;
public class FourSum {
  class Pair{
    int left;
    int right;
    int sum;
    Pair(int left, int right, int sum){
      this.left = left;
      this.right = right;
      this.sum = sum;
    }
  }
  public boolean exist(int[] array, int target) {
    // Write your solution here
    if(array == null || array.length  < 4){
      return false;
    }
    Arrays.sort(array);
    Pair[] pairs = getPairs(array);
    Arrays.sort(pairs, new Comparator<Pair>(){
      @Override
      public int compare(Pair p1, Pair p2){
        if(p1.sum == p2.sum) return 0;
        return p1.sum < p2.sum ? -1 : 1;
      }
    });
    int left = 0, right = pairs.length - 1;
    while(left < right){
      if(pairs[left].sum + pairs[right].sum == target && pairs[left].right < pairs[right].left){
        return true;
      } else if(pairs[left].sum + pairs[right].sum > target){
        right--;
      } else {
        left++;
      }
    }
    return false;
  }

  private Pair[] getPairs(int[] array){
    Pair[] pairs = new Pair[array.length * (array.length - 1) / 2];
    int index = 0;
    for(int i = 0; i < array.length; ++i){
      for(int j = i + 1; j < array.length; ++j){
        pairs[index++] = new Pair(i, j, array[i] + array[j]);
      }
    }
    return pairs;
  }
}
