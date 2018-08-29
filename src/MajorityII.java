import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class MajorityII {
  public int majority(int[] array, int k){
    if(array == null || array.length == 0){
      return 0;
    }
    Map<Integer, Integer> map = new ConcurrentHashMap<>();
    for(int i = 0; i < array.length; i++){
      if(map.size() < k - 1){
        if(map.containsKey(array[i])){
          map.put(array[i], map.get(array[i]) + 1);
        } else {
          map.put(array[i], 1);
        }
      } else if(map.containsKey(array[i])){
        int count = map.get(array[i]);
        map.put(array[i], count + 1);
      } else {
        for(Map.Entry<Integer, Integer> e : map.entrySet()){
          e.setValue(e.getValue() - 1);
          if(e.getValue() == 0){
            map.remove(e.getKey());
          }
        }
      }
    }
    int max = Integer.MIN_VALUE;
    int key = 0;
    for(Map.Entry<Integer, Integer> e : map.entrySet()){
      e.setValue(0);
    }
    for(int i = 0; i < array.length; i++){
      if(map.containsKey(array[i])){
        map.put(array[i], map.get(array[i]) + 1);
      }
    }
    for(Map.Entry<Integer, Integer> e : map.entrySet()){
      key = max > e.getValue() ? key : e.getKey();
      max = max > e.getValue() ? max : e.getValue();
    }
    return key;
  }
}
