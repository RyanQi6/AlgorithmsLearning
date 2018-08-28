import java.util.*;
public class DeserializationTreeWithInLv {
  public TreeNode deserial(int[] in, int[] level){
    if(in.length == 0 || level.length == 0 || in.length != level.length){
      return null;
    }
    Map<Integer, Integer> map = new HashMap<>();
    List<Integer> li = new ArrayList<>();
    for(int i = 0; i < in.length; i++){
      li.add(level[i]);
      map.put(in[i], i);
    }
    return deserialHelper(li, map);
  }

  private TreeNode deserialHelper(List<Integer> level,
                                  Map<Integer, Integer> map){
    if(level.size() == 0) return null;
    TreeNode root = new TreeNode(level.remove(0));
    List<Integer> left = new ArrayList<>();
    List<Integer> right = new ArrayList<>();
    for(Integer num: level){
      if(map.get(num) < map.get(root.key)){
        left.add(num);
      } else {
        right.add(num);
      }
    }
    root.left = deserialHelper(left, map);
    root.right = deserialHelper(right, map);
    return root;
  }
}
