public class ReverseLinkedList{
  class ListNode{
    int value;
    ListNode next;
    public ListNode(int value){
      this.value = value;
    }
  }
  public ListNode reverseIterative(ListNode head){
    ListNode pre = null;
    ListNode cur = head;
    ListNode next = null;
    while(cur != null){
      next = cur.next;
      cur.next = pre;
      pre = cur;
      cur = next;
    }
    return cur;
  }
  public ListNode reverseRecursive(ListNode head){
    if(head == null || head.next == null){
      return head;
    }
    ListNode nextNode = head.next;
    ListNode nextHead = reverseRecursive(nextNode);
    head.next = null;
    nextNode.next = head;
    return nextHead;
  }
}
