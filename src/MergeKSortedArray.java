import java.util.*;
public class MergeKSortedArray {
  public int[] merge(int[][] arrayOfArrays) {
  // Write your solution here
  //Assumptions: input is not null, and k > 1
    if(arrayOfArrays == null){
      return null;
    }
    int size = 0;
    int k = arrayOfArrays.length;
    for(int i = 0; i < k; ++i){
      size += arrayOfArrays[i].length;
    }
    if(size == 0) return new int[0];
    List<Integer> all = new ArrayList<>();
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    int[] indices = new int[k];
    boolean[] finished = new boolean[k];
    boolean allFinished = false;
    for(int i = 0; i < k; ++i){
      if(indices[i] < arrayOfArrays[i].length){
        minHeap.offer(arrayOfArrays[i][indices[i]++]);
      } else {
        finished[i] = true;
      }
    }
    int min = Integer.MAX_VALUE;
    int minIndex = -1;
    while(!allFinished || !minHeap.isEmpty()){
      all.add(minHeap.poll());
      allFinished = true;
      for(int i = 0; i < k; ++i){
        if(indices[i] < arrayOfArrays[i].length){
          minIndex = arrayOfArrays[i][indices[i]] < min ? i : minIndex;
          min = Math.min(arrayOfArrays[i][indices[i]], min);
        } else {
          finished[i] = true;
        }
        allFinished = allFinished && finished[i];
      }
      if(!allFinished){
        minHeap.offer(arrayOfArrays[minIndex][indices[minIndex]++]);
        min = Integer.MAX_VALUE;
      }
    }
    int[] re = new int[all.size()];
    int index = 0;
    for(Integer i: all){
      re[index++] = i;
    }
    return re;
  }
}
