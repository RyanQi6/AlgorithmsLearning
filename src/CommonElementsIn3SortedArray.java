import java.util.*;

public class CommonElementsIn3SortedArray {
  public List<Integer> common(int[] a, int[] b, int[] c) {
    // Write your solution here
    List<Integer> result = new ArrayList<>();
    Map<Integer, Integer> map = new HashMap<>();
    if(a.length < b.length){
      if(a.length < c.length){ // a shortest
        makeMap(a, map);
        if(b.length < c.length){ // a < b < c
          binarySearch(b, map, false, result);
          binarySearch(c, map, true, result);
        } else { // a < c < b
          binarySearch(c, map, false, result);
          binarySearch(b, map, true, result);
        }
      } else {  // c shortest, c < a < b
        makeMap(c, map);
        binarySearch(a, map, false, result);
        binarySearch(b, map, true, result);
      }
    } else {  // a > b
      if(b.length < c.length){ // b shortest
        makeMap(b, map);
        if(a.length < c.length){  // b < a < c
          binarySearch(a, map, false, result);
          binarySearch(c, map, true, result);
        } else {  // b < c < a
          binarySearch(c, map, false, result);
          binarySearch(a, map, false, result);
        }
      } else {  // c shortest, c < b < a
        makeMap(c, map);
        binarySearch(b, map, false, result);
        binarySearch(a, map, true, result);
      }
    }
    return result;
  }

  private void makeMap(int[] array, Map<Integer, Integer> map){
    for(int i = 0; i < array.length; i++){
      if(map.containsKey(array[i])){
        map.put(array[i], map.get(array[i]) + 1);
      } else {
        map.put(array[i], 1);
      }
    }
  }

  private void binarySearch(int[] array, Map<Integer, Integer> map, boolean last, List<Integer> result){
    Map<Integer, Integer> newMap = new HashMap<>();
    newMap.putAll(map);
    Set<Map.Entry<Integer, Integer>> set = newMap.entrySet();
    for(Map.Entry<Integer, Integer> entry : set){
      int target = entry.getKey(), freq = entry.getValue();
      int start = 0, end = array.length - 1;
      while(start + 1 < end){
        int mid = start + (end - start) / 2;
        if(array[mid] >= target){
          end = mid;
        } else {
          start = mid;
        }
      }
      start = array[start] == target ? start : end;
      if(array[start] == target){
        for(int i = 0; i <freq; i++){
          if(!last){
            if(array[start + i] != target){
              map.put(target, i);
              break;
            }
          } else {
            if(array[start + i] == target){
              result.add(array[start + i]);
            }
          }
        }
      } else {
        map.remove(target);
      }
    }
  }
}
