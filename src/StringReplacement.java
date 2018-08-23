import java.util.*;
public class StringReplacement{
  public String replace(String input, String s, String t) {
  // Write your solution here
  // assumption: strings are not null, s is not empty string;
  // case 1. len(s) >= len(t), in place, use 2 pointers
  // case 2: len(s) < len(t), iterate to get the occurencies of t
  //                          create a new array whose length = occ * (len(t) - len(s)) + len(input)
    char[] array = input.toCharArray();
    if(s.length() >= t.length()){
      return largerReplace(array, s, t);
    }
    int occ = 0;
    Set<Integer> indices = new HashSet<>();
    for(int i = 0; i < input.length() - t.length(); i++){
      if(match(array, i, t)){
        indices.add(i);
        occ++;
        i += t.length();
      }
    }
    char[] newArray = new char[occ * (t.length() - s.length()) + input.length()];
    smallerReplace(newArray, input, s, t, indices);
    return new String(newArray);
  }
  //apple dog apple
  //cat
  private String largerReplace(char[] array, String s, String t){
    int fast = 0, slow = 0;
    while(fast < array.length - s.length()){
      if(match(array, fast, s)){
        set(array, fast, t);
        slow += t.length();
        fast += s.length();
      } else{
        array[slow++] = array[fast++];
      }
    }
    return new String(array, 0, slow);
  }
  private String smallerReplace(char[] array, String input, String s, String t, Set<Integer> indices){
    int ori = 0, other = 0;
    while(ori < input.length()){
      if(indices.contains(ori)){
        set(array, other, t);
        ori += s.length();
        other += t.length();
      } else {
        array[other++] = input.charAt(ori++);
      }
    }
    return new String(array);
  }
  private boolean set(char[] array, int index, String t){
    for(int i = index; i < index + t.length(); i++){
      array[i] = t.charAt(i - index);
    }
    return true;
  }
  private boolean match(char[] array, int index, String s){
    for(int i = index; i < index + s.length(); i++){
      if(array[i] != s.charAt(i - index)){
        return false;
      }
    }
    return true;
  }
}
