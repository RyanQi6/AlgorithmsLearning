import java.util.*;
public class IsCompleteTree{
  public boolean isComplete(TreeNode root){
      if(root == null){
        return true;
      }
      Queue<TreeNode> q = new LinkedList<>();
      q.offer(root);
      boolean bubble = false;
      while(!q.isEmpty()){
        //if(bubble) return false;
        int size = q.size();
        for(int i = 0; i < size; ++i) {
          TreeNode cur = q.poll();
          if(cur.left == null){
            bubble = true;
          } else {
            if(bubble) return false;
            q.offer(cur.left);
          }
          if(cur.right == null){
            bubble = true;
          } else{
            if(bubble) return false;
            q.offer(cur.right);
          }
        }
      }
      return true;
  }
}
