import java.util.*;
public class AllSubsets{
  public List<String>allSubset_1(String input){
    if(input == null || input.length() == 0){
      return null;
    }
    char[] array = input.toCharArray();
    StringBuilder sb = new StringBuilder();
    List<String> result = new ArrayList<>();
    allSubset_1_helper(array, 0, sb, result);
    return result;
  }

  private void allSubset_1_helper(char[] array, int index, StringBuilder sb, List<String> result){
    if(index >= array.length){
      result.add(sb.toString());
      return;
    }
    sb.append(array[index]);
    allSubset_1_helper(array, index + 1, sb, result);
    sb.deleteCharAt(sb.length() - 1);
    allSubset_1_helper(array, index + 1, sb, result);
  }

}
