public class MoveZerosToEndII {
  public int[] moveZero(int[] array) {
  // Write your solution here
    if(array == null || array.length == 0){
      return array;
    }
    int slow = 0, fast = 0;
    while(fast < array.length){
      while(slow < array.length && array[slow] != 0){
        slow++;
      }
      fast = slow + 1;
      while(fast < array.length && array[fast] == 0){
        fast++;
      }
      if(fast < array.length){
        swap(array, slow++, fast++);
      }
    }
    return array;
  }

  private void swap(int[] array, int left, int right){
    int tmp = array[left];
    array[left] = array[right];
    array[right] = tmp;
  }
}
