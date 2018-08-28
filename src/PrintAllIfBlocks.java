import java.util.*;
public class PrintAllIfBlocks {
  public void printAll(int n){
    List<String> all = getAll(n);
    int index = 0;
    for(String s: all){
      System.out.println("Permu " + index++ + ":");
      System.out.println(s);
    }
  }
  private List<String> getAll(int n){
    List<String> all = new ArrayList<>();
    getAllHelper(n, 0, 0, new StringBuilder(), all);
    return all;
  }
  private void getAllHelper(int n, int left, int right, StringBuilder sb, List<String> all){
    if(left == right && left == n){
      all.add(sb.toString());
    }
    if(left < n){
      sb.append("if {");
      getAllHelper(n, left + 1, right, sb, all);
      sb.delete(sb.length() - 4, sb.length());
    }
    if(left > right){
      sb.append("} ");
      getAllHelper(n, left, right + 1, sb, all);
      sb.delete(sb.length() - 2, sb.length());
    }
  }
}
