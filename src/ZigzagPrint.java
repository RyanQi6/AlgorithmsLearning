import java.util.*;
public class ZigzagPrint {
  public List<Integer> zigZag(TreeNode root) {
  // Write your solution here
    List<Integer> order = new ArrayList<>();
    if(root == null){
      return order;
    }
    Deque<TreeNode> stack = new ArrayDeque<>();
    boolean oddOrNot = false;
    stack.offerLast(root);
    while(!stack.isEmpty()){
      int size = stack.size();
      for(int i = 0; i < size; i++){
        if(oddOrNot){
          TreeNode cur = stack.pollFirst();
          order.add(cur.key);
          if(cur.left != null)
            stack.offerLast(cur.left);
          if(cur.right != null)
            stack.offerLast(cur.right);
        } else {
          TreeNode cur = stack.pollLast();
          order.add(cur.key);
          if(cur.right != null)
            stack.offerFirst(cur.right);
          if(cur.left != null)
            stack.offerFirst(cur.left);
        }
      }
      oddOrNot = !oddOrNot;
    }
    return order;
  }
}
