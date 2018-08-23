import java.util.*;
public class IsTweakedIdentical{
  public boolean isTweakedIdentical(TreeNode one, TreeNode two){
    if(one == null && two == null){
      return true;
    } else if(one == null || two == null){
      return false;
    } else{
      return one.key == two.key &&
            isTweakedIdentical(one.left, two.right) && isTweakedIdentical(one.right, two.left) ||
            isTweakedIdentical(one.left, two.left) && isTweakedIdentical(one.right, two.right);
    }
  }
}
