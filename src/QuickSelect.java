import java.util.*;
public class QuickSelect{
  public void quickSelect(int[] nums, int k, int left, int right){
    if(nums == null || nums.length == 0){
      return;
    }
    int mid = partition(nums, left, right);
    if(mid == k){
      return;
    } else if(mid < k){
      quickSelect(nums, k, mid + 1, right);
    } else {
      quickSelect(nums, k, left, mid - 1);
    }
  }

  private int partition(int[] nums, int left, int right){
    int pivot = nums[right];
    int start = left, end = right - 1;
    while(start <= end){
      if(nums[start] < pivot){
        start ++;
      }
      else if(nums[end] >= pivot){
        end --;
      } else{
        swap(nums, start++, end--);
      }
    }
    swap(nums, start, right);
    return start;
  }

  private void swap(int[] nums, int left, int right){
    int tmp = nums[left];
    nums[left] = nums[right];
    nums[right] = tmp;
  }
}
