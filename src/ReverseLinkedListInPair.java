public class ReverseLinkedListInPair {
  public ListNode reverseInPairs(ListNode head){
    if(head == null || head.next == null){
      return head;
    }
    ListNode node = reverseInPairs(head.next.next);
    ListNode newHead = head.next;
    head.next.next = head;
    head.next = node;
    return newHead;
  }
}
