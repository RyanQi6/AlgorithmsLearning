import java.util.*;
public class DeserializationBSTWithPost {
  public int index;
  public TreeNode reconstruct(int[] post) {
  // Write your solution here
    if(post == null || post.length == 0){
      return null;
    }
    index = post.length - 1;
    return constructHelper(post, Integer.MIN_VALUE);
  }

  private TreeNode constructHelper(int[] post, int min){
    if(index < 0 || post[index] < min){
      return null;
    }
    TreeNode root = new TreeNode(post[index--]);
    root.right = constructHelper(post, root.key);
    root.left = constructHelper(post, min);
    return root;
  }
}
