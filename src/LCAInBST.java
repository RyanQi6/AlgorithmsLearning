public class LCAInBST {
  public TreeNode LCA(TreeNode root, TreeNode one, TreeNode two){
    if(one.key > two.key){
      TreeNode tmp = one;
      one = two;
      two = tmp;
    }
    if(root == null || root.key >= one.key && root.key <= two.key){
      return root;
    }
    if(root.key > two.key){
      return LCA(root.left, one, two);
    } else if(root.key < one.key){
      return LCA(root.right, one, two);
    }
    return null;
  }
}
