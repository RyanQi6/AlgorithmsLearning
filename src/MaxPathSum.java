public class MaxPathSum {
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
    if(root.left == null && root.right == null){
      return root.key;
    }
    if(root.right == null){
      int left = maxPathSumHelper(root.left, max);
      return left + root.key;
    }
    if(root.left == null){
      int right = maxPathSumHelper(root.right, max);
      return right + root.key;
    }
    int left = maxPathSumHelper(root.left, max);
    int right = maxPathSumHelper(root.right, max);
    max[0] = Math.max(max[0], left + right + root.key);
    return left < right ? right + root.key : left + root.key;
  }
}
