import java.util.*;
public class MergeKSortedList{
  class MyEntry{
    int y;
    ListNode node;
    MyEntry(int y, ListNode node){
      this.y = y;
      this.node = node;
    }
  }
  public ListNode merge(List<ListNode> listOfLists) {
  // Write your solution here/.
    if(listOfLists == null){
      return null;
    }
    ListNode dummy = new ListNode(0);
    ListNode tmp = dummy;
    boolean first = true;
    PriorityQueue<MyEntry> minHeap = new PriorityQueue<>(new Comparator<MyEntry>(){
      @Override
      public int compare(MyEntry e1, MyEntry e2){
        if(e1.node.value == e2.node.value) return 0;
        return e1.node.value < e2.node.value ? -1 : 1;
      }
    });
    int allLength = 0;
    int k = listOfLists.size();
    for(int i = 0; i < k; ++i){
      ListNode head = listOfLists.get(i);
      if(head != null){
        minHeap.offer(new MyEntry(i, head));
      }
    }
    while(!minHeap.isEmpty()){
      MyEntry cur = minHeap.poll();
      tmp.next = cur.node;
      tmp = cur.node;
      // listOfList.set(cur.k, cur.node.next);

      if(cur.node.next != null){
        minHeap.offer(new MyEntry(cur.y, cur.node.next));
      }
    }
    return dummy.next;
  }
}
