import java.util.*;
public class DeserializationTreeWithPostPre {
  public TreeNode constructFromPrePost(int[] pre, int[] post) {
    if(pre.length == 0 || post.length == 0 || pre.length != post.length){
      return null;
    }
    HashMap<Integer, Integer> map = new HashMap<>();
    for(int i = 0; i < post.length; i++){
      map.put(post[i], i);
    }
    return contructHelper(pre, 0, pre.length - 1, map);
  }

  private TreeNode contructHelper(int[] pre, int preLeft, int preRight,
                                  HashMap<Integer, Integer> map){
    if(preLeft >= pre.length) return null;
    TreeNode root = new TreeNode(pre[preLeft]);
    int postIndex = map.get(root.key);
    int midIndex = map.get(preLeft + 1);
    int rightSize = postIndex - midIndex - 1;
    root.left = contructHelper(pre, preLeft + 1, preRight - rightSize, map);
    root.right = contructHelper(pre, preRight - rightSize + 1, preRight, map);
    return root;
  }
}
