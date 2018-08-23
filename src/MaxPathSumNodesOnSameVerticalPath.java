public class MaxPathSumNodesOnSameVerticalPath {
  public int maxPathSum(TreeNode root) {
  // Write your solution here
  if(root == null){
    return Integer.MIN_VALUE;
  }
  int[] max = new int[1];
  max[0] = Integer.MIN_VALUE;
  maxPathSumHelper(root, max);
  return max[0];
  }

  private int maxPathSumHelper(TreeNode root, int[] max){
    if(root == null){
      return 0;
    }
    int left = maxPathSumHelper(root.left, max);
    int right = maxPathSumHelper(root.right, max);
    left = left < 0 ? 0 : left;
    right = right < 0 ? 0 : right;
    if(root.left == null && root.right == null){
      max[0] = Math.max(max[0], root.key);
      return root.key;
    }
    if(root.left != null && root.right != null){
      max[0] = Math.max(max[0], Math.max(left, right) + root.key);
      return Math.max(left, right) + root.key;
    }
    if(root.left == null){
      max[0] = Math.max(max[0], right + root.key);
      return right + root.key;
    }
    max[0] = Math.max(max[0], left + root.key);
    return left + root.key;
  }
}
