import java.util.*;
public class SerialAndDeserial {
  public String serialize(TreeNode root) {
    // write your code here
    if(root == null) return "";
    StringBuilder sb = new StringBuilder();
    List<TreeNode> queue = new ArrayList<>();
    int index = 0;
    queue.add(root);
    while(index < queue.size()){
        int size = queue.size() - index;
        for(int i = 0; i < size; i++){
            TreeNode cur = queue.get(index + i);
            if(cur != null){
                queue.add(cur.left);
                queue.add(cur.right);
            }
        }
        index += size;
    }
    while(queue.get(queue.size() - 1) == null){
        queue.remove(queue.size() - 1);
    }
    for(TreeNode node: queue){
        if(node != null)
            sb.append(node.key + ",");
        else
            sb.append("#,");
    }
    sb.deleteCharAt(sb.length() - 1);
    return sb.toString();
  }

  public TreeNode deserialize(String data) {
      // write your code here
      String[] nodes = data.split(",");
      List<TreeNode> queue = new ArrayList<>();
      TreeNode root = new TreeNode(Integer.valueOf(nodes[0]));
      queue.add(root);
      int curIndex = 0;
      int childIndex = 1;
      while(childIndex < nodes.length){
          TreeNode cur = queue.get(curIndex);
          String left = nodes[childIndex++];
          if(!left.equals("#")){
              cur.left = new TreeNode(Integer.valueOf(left));
              queue.add(cur.left);
          }
          if(childIndex == nodes.length) break;
          String right = nodes[childIndex++];
          if(!right.equals("#")){
              cur.right = new TreeNode(Integer.valueOf(right));
              queue.add(cur.right);
          }
          curIndex++;
      }
      return queue.get(0);
  }
}
