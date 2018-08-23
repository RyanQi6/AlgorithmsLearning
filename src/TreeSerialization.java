/*
Summary:
BFS-1的变种，Tree level order traversal

Tricks:
（1）使用list的必要性：遍历完node之后要检查删除末尾的null nodes，而如果
用queue在第一遍遍历就编码进string的话（需要有分隔符），在后面删除时还要split。
时间至少2n，空间至少n;
（2）使用list来实现queue，加一个queue末的指针index即可；
（3）deserialize中，使用isLeft作分频器，指针index指向父节点，每遍历下面两个nodes，父节点才后移一次。
*/
import java.util.*;
public class TreeSerialization{
      public String serialize(TreeNode root) {
        if(root == null){
          return "";
        }
        StringBuilder sb = new StringBuilder();
        List<TreeNode> list = new ArrayList<>();
        list.add(root);
        int index = 0;
        while(index < list.size()){
          TreeNode cur = list.get(index);
          if(cur != null){
            list.add(cur.left);
            list.add(cur.right);
          }
          index++;
        }

        while(list.get(list.size() - 1) == null){
          list.remove(list.size() - 1);
        }

        boolean first = true;
        for(TreeNode node : list){
          if(node == null)
            sb.append(",#");
          else if(first){
            sb.append(node.key);
            first = false;
          } else
            sb.append("," + node.key);
        }

        return sb.toString();
      }

      public TreeNode deserialize(String data) {
        if(data == null || data.length() == 0){
          return null;
        }
        String[] array = data.split(",");
        List<TreeNode> list = new ArrayList<>();
        list.add(new TreeNode(Integer.parseInt(array[0])));
        boolean isLeftNode = true;
        int index = 0;
        for(int i = 1; i < array.length; ++i){
          if(!array[i].equals("#")){
            if(isLeftNode){
              list.get(index).left = new TreeNode(Integer.parseInt(array[i]));
              list.add(list.get(index).left);
            } else {
              list.get(index).right = new TreeNode(Integer.parseInt(array[i]));
              list.add(list.get(index).right);
            }
          }
          if(!isLeftNode){
            ++index;
          }
          isLeftNode = !isLeftNode;
        }

        return list.get(0);
      }
}
