import java.util.*;

public class KthClosestToOrigin {
  class Node{
    int i;
    int j;
    int k;
    long dis;
    Node(int i, int j, int k){
      this.i = i;
      this.j = j;
      this.k = k;
    }

    public boolean equals(Object obj){
      if(obj == this) return true;
      if(!(obj instanceof Node)) return false;
      Node n = (Node) obj;
      return n.i == this.i && n.j == this.j && n.k == this.k;
    }

    public int hashCode(){
      return i * i + j * j + k * k;
    }
  }
  public List<Integer> closest(int[] a, int[] b, int[] c, int k) {
  // Write your solution here
    List<Integer> result = new ArrayList<>();
    PriorityQueue<Node> minHeap = new PriorityQueue<>(new Comparator<Node>(){
      @Override
      public int compare(Node n1, Node n2){
        if(n1.dis == n2.dis) return 0;
        return n1.dis < n2.dis ? -1 : 1;
      }
    });
    Set<Node> set = new HashSet<>();
    Node n = new Node(0, 0, 0);
    n.dis = dis(a[0], b[0], c[0]);
    minHeap.offer(n);
    set.add(n);
    while(k > 1){
      Node cur = minHeap.poll();
      Node ni = new Node(cur.i + 1, cur.j, cur.k);
      if(ni.i < a.length && ni.j < b.length && ni.k < c.length){
        ni.dis = dis(a[ni.i], b[ni.j], c[ni.k]);
        if(set.add(ni)){
          minHeap.offer(ni);
        }
      }
      Node nj = new Node(cur.i, cur.j + 1, cur.k);
      if(nj.i < a.length && nj.j < b.length && nj.k < c.length){
        nj.dis = dis(a[nj.i], b[nj.j], c[nj.k]);
        if(set.add(nj)){
          minHeap.offer(nj);
        }
      }
      Node nk = new Node(cur.i, cur.j, cur.k + 1);
      if(nk.i < a.length && nk.j < b.length && nk.k < c.length){
        nk.dis = dis(a[nk.i], b[nk.j], c[nk.k]);
        if(set.add(nk)){
          minHeap.offer(nk);
        }
      }
      k--;
    }
    Node re = minHeap.poll();
    result.add(a[re.i]);
    result.add(b[re.j]);
    result.add(c[re.k]);
    return result;
  }

  private long dis(int x, int y, int z){
    return (long) x * x + (long) y * y + (long) z * z;
  }

  public void eq(){
    Node n1 = new Node(1, 0, 0);
    Node n2 = new Node(1, 0, 0);
    System.out.println(n1 == n2);
    System.out.println(n1.equals(n2));
    Set<Node> s = new HashSet<>();
    s.add(n1);
    s.add(n2);
    System.out.println(s.size());
  }
}
