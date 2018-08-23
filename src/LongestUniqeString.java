import java.util.*;
public class LongestUniqeString {
  public int longestUniqueString(String s){
    if(s == null || s.length() == 0){
      return 0;
    }
    int slow = 0, fast = 0, globalMax = Integer.MIN_VALUE;
    HashMap<Character, Integer> map = new HashMap<>();

    while(fast < s.length()){
      char ch = s.charAt(fast);
      Integer freq = map.get(ch);
      if(freq == null){
        map.put(ch, 1);
      } else {
        map.put(ch, map.get(ch) + 1);
        if(map.get(ch) > 1){
          globalMax = Math.max(fast - slow, globalMax);
          while(slow < fast && map.get(s.charAt(slow)) > 1){
            map.put(s.charAt(slow), map.get(s.charAt(slow)) - 1);
            slow++;
          }
        }
      }
      fast++;
    }
    return globalMax;
  }
}
