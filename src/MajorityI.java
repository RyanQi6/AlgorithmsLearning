public class MajorityI {
  public int majority(int[] array) {
  // Write your solution here
    if(array == null || array.length == 0){
      return 0;
    }
    int candidate = array[0];
    int count = 1;
    for(int i = 1; i < array.length; i++){
      if(count == 0){
        candidate = array[i];
        count = 1;
      } else if(candidate == array[i]){
        count++;
      } else {
        count--;
      }
    }
    return candidate;
  }
}
