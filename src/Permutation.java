import java.util.*;
public class Permutation{
  public List<String> permutation(String s){
    if(s == null || s.length() == 0){
      return null;
    }
    List<String> permu = new ArrayList<>();
    char[] array = s.toCharArray();
    permuHelper(permu, array, 0);
    return permu;
  }

  private void permuHelper(List<String> permu, char[] array, int level){
    if(level >= array.length){
      permu.add(new String(array));
      return;
    }

    for(int i = level; i < array.length; ++i){
      swap(array, level, i);
      permuHelper(permu, array, level + 1);
      swap(array, level, i);
    }
  }

  private void swap(char[] array, int index1, int index2){
    char tmp = array[index1];
    array[index1] = array[index2];
    array[index2] = tmp;
  }

  public static void main(String[] args){
    List<String> list = new Permutation().permutation("abc");
    for(String s : list){
      System.out.println(s);
    }
  }
}
