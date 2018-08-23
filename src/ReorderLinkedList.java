import java.util.*;
public class ReorderLinkedList{
  public ListNode reorder(ListNode head){
    ListNode mid = findMiddle(head);
    ListNode secHalf = reverse(mid);
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode cur = head;
    boolean flag = true;
    while(head != null && mid != null){
      ListNode tmp = null;
      if(flag){
        cur.next = mid;
        tmp = mid;
        mid = mid.next;
      } else{
        cur.next = head;
        tmp = head;
        head = head.next;
      }
      tmp.next = null;
      flag = !flag;
      cur = cur.next;
    }
    cur.next = head == null ? mid : head;
    return dummy.next;
  }
  private ListNode findMiddle(ListNode head){
    if(head == null && head.next == null){
      return head;
    }
    ListNode slow = head;
    ListNode fast = head;
    while(fast.next != null && fast.next.next != null){
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow;
  }
  private ListNode reverse(ListNode head){
    ListNode cur = head;
    ListNode pre = null;
    ListNode next = null;
    while(cur != null){
      next = cur.next;
      cur.next = pre;
      pre = cur;
      cur = next;
    }
    return pre;
  }
}
