import java.util.*;

public class EditDistance {
  public int editDistanceRecursive(String one, String two) {
  // Write your solution here
    if(one == null || one.length() == 0){
      return two.length();
    }
    if(two == null || two.length() == 0){
      return one.length();
    }
    if(one.charAt(0) == two.charAt(0)){
      return editDistanceRecursive(one.substring(1), two.substring(1));
    }
    int replace = 1 + editDistanceRecursive(one.substring(1), two.substring(1));
    int delete = 1 + editDistanceRecursive(one.substring(1), two);
    int insert = 1 + editDistanceRecursive(one, two.substring(1));

    return Math.min(Math.min(replace, delete), insert);
  }

  public int editDistanceDP(String one, String two){
    if(one == null || one.length() == 0){
          return two.length();
        }
        if(two == null || two.length() == 0){
          return one.length();
        }
        int[][] M = new int[one.length() + 1][two.length() + 1];
        M[0][0] = 0;
        for(int i = 0; i <= one.length(); i++){
          M[i][0] = i;
        }
        for(int j = 0; j <= two.length(); j++){
          M[0][j] = j;
        }
        for(int i = 1; i <= one.length(); i++){
          for(int j = 1; j <= two.length(); j++){
            if(one.charAt(i - 1) == two.charAt(j - 1)){
                M[i][j] = M[i - 1][j - 1];
            } else {
              int replace = 1 + M[i - 1][j - 1];
              int delete = 1 + M[i - 1][j];
              int insert = 1 + M[i][j - 1];
              M[i][j] = Math.min(Math.min(replace, delete), insert);
            }
          }
        }
        return M[one.length()][two.length()];
  }
}
