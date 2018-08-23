import java.util.*;
public class KthSmallestWith357 {
  class Node {
    int i;
    int j;
    int k;
    long product;
    Node(int i, int j, int k){
      this.i = i;
      this.j = j;
      this.k = k;
      product = (long) Math.pow(3, i) * (long) Math.pow(5, j) * (long) Math.pow(7, k);
    }
  }
  public long kth(int k) {
  // Write your solution here
    if(k == 0){
      return 1;
    }
    Set<Long> set = new HashSet<>();
    PriorityQueue<Node> minHeap = new PriorityQueue<>(new Comparator<Node>(){
      @Override
      public int compare(Node n1, Node n2){
        if(n1.product == n2.product){
          return 0;
        }
        return n1.product < n2.product ? -1 : 1;
      }
    });
    Node n = new Node(1, 1, 1);
    minHeap.offer(n);
    set.add(n.product);

    while(k > 1){
      Node cur = minHeap.poll();
      Node n3 = new Node(cur.i + 1, cur.j, cur.k);
      if(set.add(n3.product)){
        minHeap.offer(n3);
      }
      Node n5 = new Node(cur.i, cur.j + 1, cur.k);
      if(set.add(n5.product)){
        minHeap.offer(n5);
      }
      Node n7 = new Node(cur.i, cur.j, cur.k + 1);
      if(set.add(n7.product)){
        minHeap.offer(n7);
      }
      k--;
    }
    return minHeap.poll().product;
  }
}
