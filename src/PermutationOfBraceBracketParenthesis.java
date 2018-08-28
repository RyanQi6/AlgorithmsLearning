import java.util.*;
public class PermutationOfBraceBracketParenthesis{
  public void printAll(int n){
    List<String> all = getAll(n);
    int index = 0;
    for(String s: all){
      System.out.println("The permutation " + index++ + " :");
      System.out.println(s);
    }
  }

  private List<String> getAll(int n){
    List<String> all = new ArrayList<>();
    getAllHelper(n, all, new StringBuilder(), 0, 0, 0, 0, 0, 0);
    return all;
  }

  private void getAllHelper(int n, List<String> all, StringBuilder sb, int braceL, int braceR,
                            int bracketL, int bracketR, int parenL, int parenR){
    if(braceL == braceR && bracketL == bracketR && parenL == parenR && braceL == bracketL && parenL == braceL && parenL == n){
      all.add(sb.toString());
      return;
    }
    if(braceL < n){
      sb.append("{");
      getAllHelper(n, all, sb, braceL + 1, braceR, bracketL, bracketR, parenL, parenR);
      sb.deleteCharAt(sb.length() - 1);
    }
    if(braceR < braceL && sb.charAt(sb.length() - 1) == '{'){
      sb.append("}");
      getAllHelper(n, all, sb, braceL, braceR + 1, bracketL, bracketR, parenL, parenR);
      sb.deleteCharAt(sb.length() - 1);
    }
    if(bracketL < n){
      sb.append("[");
      getAllHelper(n, all, sb, braceL, braceR, bracketL + 1, bracketR, parenL, parenR);
      sb.deleteCharAt(sb.length() - 1);
    }
    if(bracketR < bracketL && sb.charAt(sb.length() - 1) == '['){
      sb.append("]");
      getAllHelper(n, all, sb, braceL, braceR, bracketL, bracketR + 1, parenL, parenR);
      sb.deleteCharAt(sb.length() - 1);
    }
    if(parenL < n){
      sb.append("(");
      getAllHelper(n, all, sb, braceL, braceR, bracketL, bracketR, parenL + 1, parenR);
      sb.deleteCharAt(sb.length() - 1);
    }
    if(parenR < parenL && sb.charAt(sb.length() - 1) == '('){
      sb.append(")");
      getAllHelper(n, all, sb, braceL, braceR, bracketL, bracketR, parenL, parenR + 1);
      sb.deleteCharAt(sb.length() - 1);
    }
  }
}
