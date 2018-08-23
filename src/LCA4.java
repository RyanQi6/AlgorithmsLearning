import java.util.*;
public class LCA4 {
  public TreeNode lowestCommonAncestor(TreeNode root, List<TreeNode> nodes) {
    // Write your solution here.
    Set<TreeNode> set = new HashSet<>(nodes);
    return LCAHelper(root, set);
  }

  private TreeNode LCAHelper(TreeNode root, Set<TreeNode> set){
    if(root == null || set.contains(root)){
      return root;
    }

    TreeNode left = LCAHelper(root.left, set);
    TreeNode right = LCAHelper(root.right, set);

    if(left != null && right != null){
      return root;
    }
    return left == null ? right : left;
  }
}
