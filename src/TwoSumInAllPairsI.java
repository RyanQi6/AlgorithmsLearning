import java.util.*;
public class TwoSumInAllPairsI {
  public List<List<Integer>> allPairs(int[] array, int target) {
    // Write your solution here
    List<List<Integer>> all = new ArrayList<>();
    if(array == null || array.length == 0){
      return all;
    }
    Map<Integer, List<Integer>> map = new HashMap<>();
    for(int i = 0; i < array.length; ++i){
      if(map.containsKey(array[i])){
        List<Integer> l = map.get(array[i]);
        l.add(i);
        map.put(array[i], l);
      } else {
        List<Integer> l = new ArrayList<>();
        l.add(i);
        map.put(array[i], l);
      }
    }
    for(int i = 0; i < array.length; ++i){
      if(map.containsKey(array[i]) && map.containsKey(target - array[i])){
        if(array[i] != target - array[i]){
          for(Integer index1 : map.get(array[i])){
            for(Integer index2: map.get(target - array[i])){
                all.add(Arrays.asList(index1, index2));
            }
          }
        } else{
          List<Integer> l = map.get(array[i]);
          for(int j = 0; j < l.size(); ++j){
            for(int k = j + 1; k < l.size(); ++k)
              all.add(Arrays.asList(l.get(j), l.get(k)));
          }
        }
        map.remove(array[i]);
        map.remove(target - array[i]);
      }
    }
    return all;
  }
}
