public class LCA1 {
  public TreeNode LCA(TreeNode root, TreeNode one, TreeNode two){
    if(root == null){
      return null;
    }
    if(root == one || root == two){
      return root;
    }
    TreeNode left = LCA(root.left, one, two);
    TreeNode right = LCA(root.right, one, two);

    if(left != null && right != null){
      return root;
    }

    return left == null ? right : left;
  }
}
