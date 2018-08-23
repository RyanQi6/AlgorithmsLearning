import java.util.*;
public class AllSubsetsWithDuplicates {
  public List<String> subSets(String set) {
  // Write your solution here.
    List<String> subsets = new ArrayList<>();
    if(set == null){
      return subsets;
    }
    char[] array = set.toCharArray();
    Arrays.sort(array);
    dfsHelper(subsets, new StringBuilder(), array, 0);
    return subsets;
  }

  private void dfsHelper(List<String> subsets, StringBuilder sb, char[] array, int index){
    subsets.add(sb.toString());
    for(int i = index; i < array.length; ++i){
      if(i == index || array[i] != array[i - 1]){
        sb.append(array[i]);
        dfsHelper(subsets, sb, array, i + 1);
        sb.deleteCharAt(sb.length() - 1);
      }
    }
  }
}
