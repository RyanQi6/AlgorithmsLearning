public class BinaryTreeUpsideDown {
  public TreeNode reverse(TreeNode root){
    if(root == null){
      return null;
    }
    TreeNode parent = null;
    TreeNode nextLeft = root.left;
    TreeNode nextRight = root.right;
    while(root != null){
      TreeNode curLeft = nextLeft;
      TreeNode curRight = nextRight;
      nextLeft = root.left;
      nextRight = root.right;
      root.left = parent;
      root.right = (parent == null) ? null : curRight;
      parent = root;
      root = nextLeft;
    }
    return parent;
  }
}
