import java.util.*;
public class DictionaryI {
  public boolean canBreak(String input, String[] dict) {
// Write your solution here
//Given a word and a dictionary, determine if it can be composed by concatenating words from the given dictionary.
    if(input == null){
      return false;
    }
    Set<String> set = new HashSet(Arrays.asList(dict));
    boolean[] M = new boolean[input.length()];

    for(int i = 0; i < input.length(); ++i){
      if(set.contains(input.substring(0, i + 1))){
        M[i] = true;
        continue;
      }
      for(int j = 0; j < i; ++j){
        if(set.contains(input.substring(j + 1, i + 1)) && M[j]){
          M[i]  = true;
          break;
        }
      }
    }
    return M[input.length() - 1];
  }
}
