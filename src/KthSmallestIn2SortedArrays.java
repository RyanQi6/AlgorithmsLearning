public class KthSmallestIn2SortedArrays{
  public int kth(int[] a, int[] b, int k) {
    // Write your solution here
    return kthHelper(a, b, 0, 0, k);
  }

  private int kthHelper(int[] a, int[] b, int aLeft, int bLeft, int k){
    if(aLeft >= a.length){
      return b[bLeft + k - 1];
    }
    if(bLeft >= b.length){
      return a[aLeft + k - 1];
    }
    if(k == 1){
      return Math.min(a[aLeft], b[bLeft]);
    }
    int aNum = aLeft + k/2 <= a.length ? a[aLeft + k/2 - 1] : Integer.MAX_VALUE;
    int bNum = bLeft + k/2 <= b.length ? b[bLeft + k/2 - 1] : Integer.MAX_VALUE;
    if(aNum < bNum){
      return kthHelper(a, b, aLeft + k/2, bLeft, k - k/2);
    } else {
      return kthHelper(a, b, aLeft, bLeft + k/2, k - k/2);
    }
  }
}
