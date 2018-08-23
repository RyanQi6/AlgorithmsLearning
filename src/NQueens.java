import java.util.*;
public class NQueens{
  public List<List<Integer>> nQueens(int n){
    if(n == 0){
      return new ArrayList<List<Integer>>();
    }
    List<List<Integer>> list = new ArrayList<>();
    nQueensHelper(n, 0, list, new ArrayList<Integer>());
    return list;
  }

  private void nQueensHelper(int n, int level, List<List<Integer>> list, List<Integer> oneSolu){
    if(level >= n){
      list.add(new ArrayList<Integer>(oneSolu));
    }
    for(int i = 0; i < n; ++i){
      int size = oneSolu.size();
      boolean feasible = true;
      for(int row = 0; row < size; ++row){
        if(oneSolu.get(row) == i || Math.abs(level - row) == Math.abs(i - oneSolu.get(row))){
          feasible = false;
          break;
        }
      }
      if(feasible){
        oneSolu.add(i);
        nQueensHelper(n, level + 1, list, oneSolu);
        oneSolu.remove(oneSolu.size() - 1);
      }
    }
  }
}
