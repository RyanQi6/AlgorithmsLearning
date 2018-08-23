public class RotateMatrix {
  public void rotate(int[][] matrix) {
    // Write your solution here.
    if(matrix == null || matrix.length < 2){
      return;
    }
    rotateHelper(matrix, 0);
  }

  private void rotateHelper(int[][] matrix, int level){
    int maxLevel = matrix.length / 2;
    if(level > maxLevel){
      return;
    }
    int edgeLength = matrix.length - 2 * level - 1;
    for(int i = 0; i < edgeLength; i++){
      int tmp;
      tmp = matrix[level][level + i];
      matrix[level][level + i] = matrix[matrix.length - level - 1 - i][level];
      matrix[matrix.length - level - 1 - i][level] = matrix[matrix.length - level - 1][matrix.length - level - 1 - i];
      matrix[matrix.length - level - 1][matrix.length - level - 1 - i] = matrix[level + i][matrix.length - level - 1];
      matrix[level + i][matrix.length - level - 1] = tmp;
    }
    rotateHelper(matrix, level + 1);
  }
}
