public class LargestX {
  public int largest(int[][] matrix) {
  // Write your solution here
    if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
      return 0;
    }
    int[][][] M = new int[4][matrix.length][matrix[0].length];
    int max = 0;
    for(int k = 0; k < 5; k++){
      if(k < 2){
        for(int i = 0; i < matrix.length; i++){
          for(int j = 0; j < matrix[0].length; j++){
              if(matrix[i][j] == 1){
                if(k == 0)
                  M[k][i][j] = isLegal(M, i - 1, j - 1) ? M[k][i - 1][j - 1] + 1 : 1;
                else if(k == 1)
                  M[k][i][j] = isLegal(M, i - 1, j + 1) ? M[k][i - 1][j + 1] + 1 : 1;
              }
          }
        }
      } else {
          for(int i = matrix.length - 1; i >= 0; i--){
            for(int j = matrix[0].length - 1; j >= 0; j--){
              if(k == 4){
                int min = Integer.MAX_VALUE;
                for(int l = 0; l < 4; l++){
                  min = Math.min(M[l][i][j], min);
                }
                max = Math.max(max, min);
              } else {
                if(matrix[i][j] == 1){
                  if(k == 2)
                    M[k][i][j] = isLegal(M, i + 1, j - 1) ? M[k][i + 1][j - 1] + 1 : 1;
                  else if(k == 3)
                    M[k][i][j] = isLegal(M, i + 1, j + 1) ? M[k][i + 1][j + 1] + 1 : 1;
                }
            }
          }
        }
      }
    }
    return max;
  }

  private boolean isLegal(int[][][] m, int y, int x){
    return y >= 0 && y < m[0].length && x >= 0 && x < m[0][0].length;
  }
}
