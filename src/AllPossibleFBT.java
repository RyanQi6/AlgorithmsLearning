import java.util.*;
public class AllPossibleFBT {
  public List<TreeNode> allPossibleFBT(int N) {
      List<TreeNode> re = new ArrayList<>();
      TreeNode root = new TreeNode(0);
      allHelper(re, N - 1, root, root);
      return re;
  }

  private void allHelper(List<TreeNode> re, int N, TreeNode root, TreeNode origin){
    if(N == 0){
      TreeNode newOrigin = copy(origin);
      re.add(newOrigin);
      return;
    }
    root.left = new TreeNode(0);
    allHelper(re, N - 1, root.left, origin);
    root.left = null;
    root.right = new TreeNode(0);
    allHelper(re, N - 1, root.right, origin);
    root.right = null;
  }

  private TreeNode copy(TreeNode root){
    if(root == null){
      return null;
    }
    TreeNode newRoot = new TreeNode(root.key);
    newRoot.left = copy(root.left);
    newRoot.right = copy(root.right);
    return root;
  }
}
