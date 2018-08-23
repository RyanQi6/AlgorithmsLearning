public class LCAI {
  public TreeNode LCA(TreeNode root, TreeNode node1, TreeNode node2){
    if(root == null || root == node1 || root == node2){
      return root;
    }
    TreeNode left = LCA(root.left, node1, node2);
    TreeNode right = LCA(root.right, node1, node2);
    if(left == null && right == null){
      return null;
    }
    if(left == null){
      return right;
    }
    if(right == null){
      return left;
    }
    if(left == node1 && right == node2 || left == node1 && right == node2){
      return root;
    }
    return null;  
  }
}
