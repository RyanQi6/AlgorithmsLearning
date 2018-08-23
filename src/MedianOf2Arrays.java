import java.util.*;
public class MedianOf2Arrays {
  public double median(int[] a, int[] b) {
    // Write your solution here
    //Assumption: a and b are not nulls, and have at least 1 element
    Arrays.sort(a);
    Arrays.sort(b);
    if((a.length + b.length) % 2 == 1){
      return (double) kthElement(a, b, 0, 0, (a.length + b.length)/2 + 1);
    } else {
      return (double) kthElement(a, b, 0, 0, (a.length + b.length)/2)/2 +
            (double) kthElement(a, b, 0, 0, (a.length + b.length)/2 + 1)/2;
    }
  }

  private int kthElement(int[] a, int[] b, int aLeft, int bLeft, int k){
    if(aLeft >= a.length) return b[bLeft + k - 1];
    if(bLeft >= b.length) return a[aLeft + k - 1];
    if(k == 1) return Math.min(a[aLeft], b[bLeft]);
    int aNum = aLeft + k/2 <= a.length ? a[aLeft + k/2 - 1] : Integer.MAX_VALUE;
    int bNum = bLeft + k/2 <= b.length ? b[bLeft + k/2 - 1] : Integer.MAX_VALUE;
    if(aNum < bNum) return kthElement(a, b, aLeft + k/2, bLeft, k - k/2);
    else return kthElement(a, b, aLeft, bLeft + k/2, k - k/2);
  }
}
