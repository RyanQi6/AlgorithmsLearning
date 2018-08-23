public class ReorderArray {
  public int[] reorder(int[] array) {
  // Write your solution here
    if(array == null || array.length <= 1){
      return array;
    }
    if(array.length % 2 == 0)
      convert(array, 0, array.length - 1);
    else
      convert(array, 0, array.length - 2);
    return array;
  }

  private void convert(int[] array, int left, int right){
    if(left + 1 >= right){
      return;
    }

    int size = right - left + 1;
    int mid = left + size / 2;
    int lmid = left + size / 4;
    int rmid = left + size * 3 / 4;

    reverse(array, lmid, mid - 1);
    reverse(array, mid, rmid - 1);
    reverse(array, lmid, rmid - 1);

    convert(array, left, left + 2 * (lmid - left) - 1);
    convert(array, left + 2 * (lmid - left), right);
  }

  private void reverse(int[] array, int index1, int index2){
    while(index1 < index2){
      int tmp = array[index1];
      array[index1++] = array[index2];
      array[index2--] = tmp;
    }
  }
}
