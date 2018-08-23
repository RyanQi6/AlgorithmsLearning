public class LCA2 {
  class TreeNodeP {
    TreeNodeP left;
    TreeNodeP right;
    TreeNodeP parent;
    int key;

    TreeNodeP(int key){
      this.key = key;
    }
  }
  public TreeNodeP lowestCommonAncestor(TreeNodeP one, TreeNodeP two) {
    if(one == null || two == null){
      return one == null ? two : one;
    }
    int D1 = getDepth(one);
    int D2 = getDepth(two);
    if(D1 < D2){
      two = traceUp(two, D2 - D1);
    } else if(D2 < D1){
      one = traceUp(one, D1 - D2);
    }
    while(one != null && two != null && one!= two){
      one = one.parent;
      two = two.parent;
    }
    return one == null ? one : two;
  }

  private int getDepth(TreeNodeP root){
    if(root == null){
      return 0;
    }
    return 1 + getDepth(root.parent);
  }

  private TreeNodeP traceUp(TreeNodeP root, int depth){
    if(depth <1){
      return null;
    }
    if(depth == 1){
      return root;
    }
    return traceUp(root.parent, depth - 1);
  }
}
