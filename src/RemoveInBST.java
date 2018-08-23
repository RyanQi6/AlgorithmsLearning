public class RemoveInBST {
  public TreeNode delete(TreeNode root, int key) {
  // Write your solution here
    if(root == null){
      return root;
    }
    if(root.key > key){
      root.left = delete(root.left, key);
    } else if(root.key < key){
      root.right = delete(root.right, key);
    } else {
      if(root.left == null && root.right == null){
        root = null;
      } else if(root.left == null){
        root = root.right;
      } else if(root.right == null){
        root = root.left;
      } else {
        TreeNode leftest = findLeftest(root.right);
        root.right = delete(root.right, leftest.key);
        root.key = leftest.key;
      }
    }
    return root;
  }

  private TreeNode findLeftest(TreeNode root){
    if(root == null){
      return root;
    }
    while(root.left != null){
      root = root.left;
    }
    return root;
  }
}
