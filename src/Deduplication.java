public class Deduplication{
  public String deDup(String input) {
  // Write your solution here
    if(input == null || input.length() <= 1){
      return input;
    }
    // array and a pointer pointed to the top of the stack, and another pointer as the iterator
    // a c b c
    //   t
    //         i
    //
    int top = 0, iter = 1;
    char[] array = input.toCharArray();
    while(iter < array.length){
      if(top < 0){
        array[++top] = array[iter++];
      } else if(array[iter] != array[top]){
        array[++top] = array[iter++];
      } else {
        char tmp = array[top];
        while(iter < array.length && array[iter] == tmp){
          iter++;
        }
        while(top >= 0 && array[top] == tmp){
          top--;
        }
      }
    }
    return top == -1 ? "" : new String(array, 0, top + 1);
  }
}
