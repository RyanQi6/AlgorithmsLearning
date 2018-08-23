public class LargestSubmatrixSum {
  public int largest(int[][] matrix) {
  // Write your solution here
    if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
      return 0;
    }
    int numRow = matrix.length, numCol = matrix[0].length;
    int[][] M = new int[numRow][numCol];
    M[0][0] = matrix[0][0];
    int max = M[0][0];
    for(int row = 0; row < numRow; row++){
      for(int col = 0; col < numCol; col++){
        if(row == 0 && col != 0){
          M[row][col] = M[row][col - 1] + matrix[row][col];
          max = Math.max(max, M[row][col]);
        } else if(col == 0 && row != 0){
          M[row][col] = M[row - 1][col] + matrix[row][col];
          max = Math.max(max, M[row][col]);
        } else if(row != 0 && col != 0){
          M[row][col] = M[row - 1][col] + M[row][col - 1] + matrix[row][col] - M[row - 1][col - 1];
        }
      }
    }

    for(int rowUL = 0; rowUL < numRow; rowUL++){
      for(int colUL = 0; colUL < numCol; colUL++){
        for(int rowDR = 1; rowDR < numRow; rowDR++){
          for(int colDR = 1; colDR < numCol; colDR++){
            if(rowUL == 0 && colUL == 0){
              max = Math.max(max, M[rowDR][colDR]);
            } else if(rowUL == 0){
              max = Math.max(max, M[rowDR][colDR] - M[rowDR][colUL - 1]);
            } else if(colUL == 0){
              max = Math.max(max, M[rowDR][colDR] - M[rowUL - 1][colDR]);
            } else {
              max = Math.max(max, M[rowDR][colDR] - M[rowUL - 1][colDR] - M[rowDR][colUL - 1] + M[rowUL - 1][colUL - 1]);
            }
          }
        }
      }
    }

    return max;
  }
}
