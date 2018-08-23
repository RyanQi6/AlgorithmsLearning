public class NumberOfDifferentBits {
  public int diffBits(int a, int b) {
  // Write your solution here
    a = a ^ b;
    int count = 0;
    for(int i = 0; i < 32; i++){
      if(((a >> i) & 1) != 0){
        count++;
      }
    }
    return count;
  }
}
