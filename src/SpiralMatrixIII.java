import java.util.*;
public class SpiralMatrixIII {
  class Pair{
    int y;
    int x;
    Pair(int y, int x){
      this.y = y;
      this.x = x;
    }
  }
  public int[][] spiralMatrixIII(int R, int C, int r0, int c0) {
    List<Pair> li = new ArrayList<>();
    if(R < 1 || C < 1){
      return new int[0][2];
    }
    int total = R * C;
    int count = 0;
    int curNum = 0;
    Pair prev = new Pair(r0, c0);
    Pair cur = null;
    boolean flag = true;
    while(total > count){
      for(int dir = 0; dir < 4; dir++){
        if(flag){
          curNum++;
          flag = false;
        } else {
          flag = true;
        }
        for(int i = 0; i < curNum; i++){
          if(dir == 0){
            cur = new Pair(prev.y, prev.x + 1);
          } else if(dir == 1){
            cur = new Pair(prev.y + 1, prev.x);
          } else if(dir == 2){
            cur = new Pair(prev.y, prev.x - 1);
          } else if(dir == 3){
            cur = new Pair(prev.y - 1, prev.x);
          }
          if(isLegal(R, C, prev)){
            li.add(prev);
            count++;
          }
          prev = cur;
        }
      }
    }
    int[][] re = new int[li.size()][2];
    int index = 0;
    for(Pair p : li){
      re[index][0] = p.y;
      re[index++][1] = p.x;
    }
    return re;
  }
  private boolean isLegal(int R, int C, Pair p){
    return p.y < R && p.y >= 0 && p.x < C && p.x >= 0;
  }
}
