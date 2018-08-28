import java.util.*;
public class DeserializationTreeWithPostIn {
  public TreeNode deserial(int[] in, int[] post){
    if(in.length == 0 || post.length == 0 || in.length != post.length){
      return null;
    }
    HashMap<Integer, Integer> map = new HashMap<>();
    for(int i = 0; i < in.length; i++){
      map.put(in[i], i);
    }
    return deserialHelper(in, 0, in.length - 1, post, 0, post.length - 1, map);
  }

  private TreeNode deserialHelper(int[] in, int inLeft, int inRight,
                                  int[] post, int poLeft, int poRight,
                                  HashMap<Integer, Integer> map){
    if(inLeft > inRight){
      return null;
    }
    TreeNode root = new TreeNode(post[poRight]);
    int inIndex = map.get(root.key);
    int size = inRight - inIndex;
    root.right = deserialHelper(in, inIndex + 1, inRight,
                                post, poRight - size, poRight - 1, map);
    root.left  = deserialHelper(in, inLeft, inIndex - 1,
                                post, poLeft, poRight - size - 1, map);
    return root;
  }
}
