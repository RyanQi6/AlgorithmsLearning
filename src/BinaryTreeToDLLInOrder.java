import java.util.*;
public class BinaryTreeToDLLInOrder {
  class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
  };
  boolean head = true;
  Node dummy;
  Node preNode;
  public Node treeToDoublyList(Node root) {
      if(root == null){
        return root;
      }
      treeToDoublyListHelper(root);
      Node head = dummy.right;
      head.left = preNode;
      preNode.right = head;
      return head;
  }

  private void treeToDoublyListHelper(Node root){
    if(root == null){
      return;
    }
    treeToDoublyListHelper(root.left);
    if(head){
      dummy = new Node(0, null, null);
      dummy.right = root;
      preNode = root;
      head = false;
    } else {
      root.left = preNode;
      preNode.right = root;
      preNode = root;
    }
    treeToDoublyListHelper(root.right);
  }
}
