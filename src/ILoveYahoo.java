public class ILoveYahoo {
  public String reverseWords(String input) {
  // Write your solution here
    if(input == null || input.length() < 2){
      return input;
    }
    char[] array = input.toCharArray();
    reverseHelper(array, 0, array.length - 1);
    int i = 0, j = 0;
    while(array[j] == ' ') j++;
    i = j;
    while(j < array.length){
      while(j < array.length && array[j] != ' ') j++;
      j--;
      reverseHelper(array, i, j);
      j++;
      while(j < array.length && array[j] == ' ') j++;
      i = j;
    }
    return new String(array);
  }
  private void reverseHelper(char[] array, int start, int end){
    while(start < end){
      char tmp = array[start];
      array[start++] = array[end];
      array[end--] = tmp;
    }
  }
}
