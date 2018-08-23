import java.util.*;
public class AbbreviateMatching {
  public boolean match(String input, String pattern) {
  // Write your solution here
    if(input == null && pattern == null){
      return true;
    }
    if(input == null || pattern == null){
      return false;
    }
    return matchHelper(input, pattern, 0, 0);
  }

  private boolean matchHelper(String input, String pattern, int indexInput, int indexPattern){
    if(indexPattern >= pattern.length()){
      return indexInput == input.length();
    }

    char ch = pattern.charAt(indexPattern);
    if(ch >= '9' || ch <= '0'){
      return input.charAt(indexInput) == pattern.charAt(indexPattern) &&
            matchHelper(input, pattern, indexInput + 1, indexPattern + 1);
    } else {
      int num = 0;
      while(indexPattern < pattern.length() && pattern.charAt(indexPattern) <= '9' && pattern.charAt(indexPattern) >= '0'){
        num = num * 10 + (int)(pattern.charAt(indexPattern) - '0');
        indexPattern++;
      }
      return matchHelper(input, pattern, indexInput + num, indexPattern);
    }
  }
}
