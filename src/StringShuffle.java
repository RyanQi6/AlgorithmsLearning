public class StringShuffle{
  public String stringShuffle(String s){
    if(s == null || s.length() == 0){
      return s;
    }
    char[] array = s.toCharArray();
    convert(array, 0, array.length - 1);
    return new String(array);
  }
  private void convert(char[] array, int left, int right){
    if(left + 1 <= right){
      return;
    }
    int size = right - left + 1;
    int mid = left + size / 2;
    int lmid = left + size / 4;
    int rmid = left + size * 3 /4;

    reverse(array, lmid, mid - 1);
    reverse(array, mid, rmid - 1);
    reverse(array, lmid, rmid - 1);

    convert(array, left, left + 2 * (lmid - left) - 1);
    convert(array, left + 2 * (lmid - left), right);
  }

  private void reverse(char[] array, int left, int right){
    while(left < right){
      array[left++] = array[right--];
    }
  }
}
