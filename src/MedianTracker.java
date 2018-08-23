import java.util.*;

public class MedianTracker {
  PriorityQueue<Integer> maxHeap;
  PriorityQueue<Integer> minHeap;
  Double median;
  public MedianTracker() {
    // add new fields and complete the constructor if necessary.
    maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    minHeap = new PriorityQueue<>();
    median = null;
  }

  public void read(int value) {
    // write your implementation here.
    if(median == null){
      median = 1.0 * value;
      maxHeap.offer(value);
      return;
    }
    if(value <= median){
      maxHeap.offer(value);
    } else {
      minHeap.offer(value);
    }
    int maxSize = maxHeap.size(), minSize = minHeap.size();
    if((maxSize + minSize) % 2 == 0){
      if(maxSize - minSize < 0){
        maxHeap.offer(minHeap.poll());
      } else if(maxSize - minSize > 0){
        minHeap.offer(maxHeap.poll());
      }
      median = (maxHeap.peek() + minHeap.peek()) / 2.0;
    } else {
      if(maxSize - minSize - 1 < 0){
        maxHeap.offer(minHeap.poll());
      } else if(maxSize - minSize - 1 > 0){
        minHeap.offer(maxHeap.poll());
      }
      median = 1.0 * maxHeap.peek();
    }
  }

  public Double median() {
    // write your implementation here.
    return median;
  }

    public static void main(String args[]) {
        MedianTracker m = new MedianTracker();
        m.read(1);
        m.read(3);
        m.read(2);
        m.read(6);
        m.read(7);
        m.read(8);
        m.read(9);

        System.out.println(m.median());
    }
}
