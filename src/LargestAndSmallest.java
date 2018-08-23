public class LargestAndSmallest {
  public int[] largestAndSmallest(int[] array) {
  // Write your solution here
    int[] result = new int[2];
    if(array == null || array.length == 0){
      return new int[]{0,0};
    }
    if(array.length == 1){
      result[0] = array[0];
      result[1] = array[0];
      return result;
    }
    int len = array.length;
    for(int i = 0; i < len/2; i++){
      if(array[i] > array[len - 1 - i]){
        swap(array, i, len - 1 - i);
      }
    }

    return new int[] {largest(array, 0, len/2), smallest(array, len/2, len - 1)};
  }

  private void swap(int[] array, int left, int right){
    int tmp = array[left];
    array[left] = array[right];
    array[right] = tmp;
  }

  private int largest(int[] array, int left, int right){
    int max = Integer.MIN_VALUE;
    for(int i = left; i <= right; i++){
      max = Math.max(max, array[i]);
    }
    return max;
  }

  private int smallest(int[] array, int left, int right){
    int min = Integer.MAX_VALUE;
    for(int i = left; i <= right; i++){
      min = Math.min(min, array[i]);
    }
    return min;
  }
}
