import java.util.*;
public class SpiralOrderTraverseI{
  public List<Integer> spiral(int[][] matrix) {
  // Write your solution here
    List<Integer> list = new ArrayList<>();
    if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
      return list;
    }
    spiralHelper(matrix, list, 0);
    return list;
  }

  private void spiralHelper(int[][] matrix, List<Integer> list, int start){
    if(2 * start == matrix.length){
      return;
    }
    if(2* start + 1 == matrix.length){
      list.add(matrix[start][start]);
      return;
    }
    for(int i = start; i < matrix.length - start - 1; ++i){
      list.add(matrix[start][i]);
    }
    for(int i = start; i < matrix.length - start - 1; ++i){
      list.add(matrix[i][matrix.length - start - 1]);
    }
    for(int i = matrix.length - start - 1; i > start; --i){
      list.add(matrix[matrix.length - start - 1][i]);
    }
    for(int i = matrix.length - start - 1; i > start; --i){
      list.add(matrix[i][start]);
    }
    spiralHelper(matrix, list, start + 1);
  }
}
