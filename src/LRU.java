import java.util.*;
public class LRU {
//  class DListNode{
//    K key;
//    V value;
//    DListNode next;
//    DListNode prev;
//    DListNode(K key, V value){
//      this.value = value;
//    }
//  }
//  HashMap<K, DListNode> map;
//  DListNode head = null;
//  DListNode tail = null;
//  int limit;
//  public LRU(int limit) {
//    this.limit = limit;
//    map = new HashMap<K, DListNode>();
//  }
//
//  public void set(K key, V value) {
//    DListNode newHead = null;
//    if(map.containsKey(key)){
//      newHead = map.get(key);
//      removeNode(newHead);
//    } else {
//      if(map.size() < limit){
//        newHead = new DListNode(key, value);
//      } else {
//        newHead = tail;
//        removeNode(newHead);
//      }
//    }
//    newHead.key = key;
//    newHead.value = value;
//    appendNode(newHead);
//  }
//
//  public V get(K key) {
//    if(!map.containsKey(key)){
//      return null;
//    }
//    DListNode newHead = map.get(key);
//    removeNode(newHead);
//    appendNode(newHead);
//    return newHead.value;
//  }
//
//  private void removeNode(DListNode cur){
//    map.remove(cur.key);
//    if(cur.next != null)
//      cur.next.prev = cur.prev;
//    if(cur.prev != null)
//      cur.prev.next = cur.next;
//    if(cur == head){
//      head = head.next;
//    }
//    if(cur == tail){
//      tail = tail.prev;
//    }
//    cur.prev = null;
//    cur.next = null;
//  }
//
//  private DListNode appendNode(DListNode cur){
//    map.put(cur.key, cur);
//    if(head == null){
//      head = tail = null;
//    } else {
//      cur.next = head;
//      head.prev = cur;
//      head = cur;
//    }
//    return cur;
//  }
}
