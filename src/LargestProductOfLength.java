import java.util.*;
public class LargestProductOfLength {
  class Pair {
    int i;
    int j;
    int product;
    public Pair(int i, int j, int product){
      this.i = i;
      this.j = j;
      this.product = product;
    }
  }
  public int largestProduct(String[] dict) {
  // Write your solution here
    Arrays.sort(dict, new Comparator<String>(){
      @Override
      public int compare(String s1, String s2){
        if(s1.length() == s2.length()) return 0;
        return s1.length() > s2.length() ? -1: 1;
      }
    });
    PriorityQueue<Pair> maxHeap = new PriorityQueue<>(new Comparator<Pair>(){
      @Override
      public int compare(Pair p1, Pair p2){
        if(p1.product == p2.product) return 0;
        return p1.product > p2.product ? -1 : 1;
      }
    });
    maxHeap.offer(new Pair(0, 0, dict[0].length() * dict[0].length()));
    while(!maxHeap.isEmpty()){
      Pair cur = maxHeap.poll();
      if(!hasCommonChar(dict[cur.i], dict[cur.j])){
        return cur.product;
      }
      if(cur.i + 1 < dict.length)
        maxHeap.offer(new Pair(cur.i + 1, cur.j, dict[cur.i + 1].length() * dict[cur.j].length()));
      if(cur.j + 1 < dict.length)
        maxHeap.offer(new Pair(cur.i, cur.j + 1, dict[cur.i].length() * dict[cur.j + 1].length()));
    }
    return 0;
  }

  private boolean hasCommonChar(String a, String b){
    if(a == null && b == null){
      return false;
    }
    if(a == null || b == null){
      return false;
    }
    String longer = a.length() > b.length() ? a : b;
    String shorter = a.length() > b.length() ? b : a;
    Set<Character> set = new HashSet<>();
    for(int i = 0; i < shorter.length(); i++){
      set.add(shorter.charAt(i));
    }
    for(int i = 0; i < longer.length(); i++){
      if(set.contains(longer.charAt(i))){
        return true;
      }
    }
    return false;
  }
}
