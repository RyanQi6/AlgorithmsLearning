public class TreeNode{
    int key;
    TreeNode left;
    TreeNode right;

    public TreeNode(int key){
        this.key = key;
    }

    public boolean isIdentical(TreeNode one, TreeNode two){
      if(one == null && two == null){
        return true;
      } else if(one == null || two == null){
        return false;
      } else {
        return one.key == two.key &&
              isIdentical(one.left, two.left) &&
              isIdentical(one.right, two.right);
      }
    }
}
