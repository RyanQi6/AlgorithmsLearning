import java.util.*;
public class DeepCopyALinkedList {
  public RandomListNode copy(RandomListNode head) {
  // Write your solution here.
    if(head == null){
      return null;
    }
    RandomListNode dummy = new RandomListNode(0);
    dummy.next = head;
    Map<RandomListNode, RandomListNode> map = new HashMap<>();
    map.put(head, new RandomListNode(head.value));
    while(head != null){
        RandomListNode newHead = map.get(head);
        if(head.next != null && map.containsKey(head.next)){
          newHead.next = map.get(head.next);
        } else if(head.next != null){
          newHead.next = new RandomListNode(head.next.value);
          map.put(head.next, newHead.next);
        }
        if(head.random != null && map.containsKey(head.random)){
          newHead.random = map.get(head.random);
        } else if(head.random != null){
          newHead.random = new RandomListNode(head.random.value);
          map.put(head.random, newHead.random);
        }
        head = head.next;
    }
    return map.get(dummy.next);
  }
}
