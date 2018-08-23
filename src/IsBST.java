import java.util.*;

public class IsBST{
  public boolean isBSTRecursive(TreeNode root){
    return isBSTHelper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }
  private boolean isBSTHelper(TreeNode root, Integer min, Integer max){
    if(root == null){
      return true;
    }
    if(root.key <= min || root.key >= max){
      return false;
    } else {
      return isBSTHelper(root.left, min, root.key) &&
             isBSTHelper(root.right, root.key, max);
    }
  }

  public boolean isBSTIterative(TreeNode root){
    if(root == null) return true;
    int value = Integer.MIN_VALUE;
    boolean farLeft = false;
    Deque<TreeNode> stack = new LinkedList<>();
    /////////stack.offerFirst(root);
    TreeNode cur = root;
    while(cur != null || !stack.isEmpty()){
      if(cur != null){
        stack.offerFirst(cur);
        cur = cur.left;
      } else{
        cur = stack.pollFirst();
        System.out.println(cur.key);
        if(!farLeft){
          farLeft = true;
          value = cur.key;
        } else if(cur.key <= value){
          return false;
        }
        value = cur.key;
        cur = cur.right;
      }
    }
    return true;
  }
}
