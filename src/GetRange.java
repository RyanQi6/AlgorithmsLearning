import java.util.*;
public class GetRange{
  public List<Integer> getRange(TreeNode root, int min, int max){
    List<Integer> range = new ArrayList<>();
    if(root == null){
      return range;
    }
    Deque<TreeNode> stack = new LinkedList<>();
    TreeNode cur = root;

    while(cur != null || !stack.isEmpty()){
      if(cur != null){
        stack.offerFirst(cur);
        cur = cur.left;
      } else{
        cur = stack.pollFirst();
        if(cur.key >= min && cur.key <= max){
          range.add(cur.key);
        }
        cur = cur.right;
      }
    }
    return range;
  }
}
