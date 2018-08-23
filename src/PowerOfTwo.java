public class PowerOfTwo {
  public boolean isPowerOfTwo(int number) {
  // Write your solution here
    return (number & (number - 1)) == 0;
  }
}
