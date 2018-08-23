public class TargetPathSumVerticalPath {
  public boolean exist(TreeNode root, int target) {
  // Write your solution here
    return existHelper(root, target, false);
  }

  private boolean existHelper(TreeNode root, int target, boolean addition){
    if(root == null){
      return false;
    }
    System.out.println(root.key + ",");
    if(root.key == target){
      return true;
    }
    if(addition){
      return existHelper(root.left, target - root.key, true) ||
             existHelper(root.right, target - root.key, true);
    } else {
      return existHelper(root.left, target, false) ||
             existHelper(root.right, target, false) ||
             existHelper(root.left, target - root.key, true) ||
             existHelper(root.right, target - root.key, true);
    }
  }
}
