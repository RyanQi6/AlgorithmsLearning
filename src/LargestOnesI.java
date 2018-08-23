public class LargestOnesI {
  public int largest(int[][] matrix) {
  // Write your solution here
    if(matrix == null || matrix.length == 0){
      return 0;
    }
    int[][] M = new int[matrix.length][matrix[0].length];
    int maxSize = 0;
    for(int i = 0; i < matrix.length; i++){
      for(int j = 0; j < matrix[0].length; j++){
        if(matrix[i][j] == 1){
          if(i == 0 || j == 0){
            M[i][j] = 1;
          } else {
            M[i][j] = 1 + Math.min(M[i - 1][j - 1], Math.min(M[i - 1][j], M[i][j - 1]));
            maxSize = Math.max(maxSize, M[i][j]);
          }
        } else {
          M[i][j] = 0;
        }
      }
    }
    return maxSize;
  }
}
