import java.util.*;
public class Traversal{
    public void preorderTraversalIter(TreeNode root){
      if(root == null){
        System.out.println("Root is null");
        return;
      }
      Deque<TreeNode> stack = new LinkedList<>();
      stack.offerFirst(root);

      while(!stack.isEmpty()){
        TreeNode cur = stack.pollFirst();
        System.out.println(cur.key);
        if(cur.right != null){
          stack.offerFirst(cur.right);
        }
        if(cur.left != null){
          stack.offerFirst(cur.left);
        }
      }
    }

/*Summary: 用一个指针cur，来遍历这棵树（1）当一个点非空，就入栈，再向左下走；
                                   （2）当它是空， 出栈，作操作，再朝右走

Tricks:(1) termination condition要包含当前点非空，否则while在一开始就终止
      （2）区分好到底是判断当前点还是遍历儿子节点，这里是当前节点
      （3）这里的指针不像BFS中的指向出栈节点，而是像linked list一样层层下联
*/
    public void inorderTraversalIter(TreeNode root){
      if(root == null){
          System.out.println("Root is NULL!");
          return;
      }
      Deque<TreeNode> stack = new LinkedList<>();
      TreeNode cur = root;
      while(cur != null || !stack.isEmpty()){
        if(cur != null){
          stack.offerFirst(cur);
          cur = cur.left;
        } else {
          cur = stack.pollFirst();
          System.out.println(cur.key);
          cur = cur.right;
        }
      }
    }


/*summary: 

*/
    public void postorderTraversalIter(TreeNode root){
    if(root == null){
        System.out.println("Root is NULL!");
        return;
    }
    Deque<TreeNode> stack  = new LinkedList<>();
    stack.offerFirst(root);
    TreeNode prev = null;
    while(!stack.isEmpty()){
      TreeNode cur = stack.peekFirst();
      if(prev == null || cur == prev.left || cur == prev.right){
        if(cur.left != null){
          stack.offerFirst(cur.left);
        } else if(cur.right != null){
          stack.offerFirst(cur.right);
        } else {
          stack.pollFirst();
          System.out.println(cur.key);
        }
      }
      else if(prev == cur.right || prev == cur.left && cur.right == null){
        stack.pollFirst();
        System.out.println(cur.key);
      }
      else{
        stack.offerFirst(cur.right);
      }
      prev = cur;
    }
  }
}
