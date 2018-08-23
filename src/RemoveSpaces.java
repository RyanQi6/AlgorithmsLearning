import java.util.*;
public class RemoveSpaces {
  public String removeSpaces(String s){
    if(s == null || s.length() == 0){
      return s;
    }
    char[] array = s.toCharArray();
    //_ _ _ a b c _ _ e d _ _ e f _ _ _
    //1. alphebet, array[i++] = array[j++]
    //2. space, 2.1 head, skip, j++
    //          2.2 former char is space, j++
    //          2.3 former char is alphebet, array[i++] = array[j++]
    //remove the last spaces
    int i = 0, j = 0;
    while(j < array.length){
      if(array[j] != ' ' || (j != 0 && array[j] == ' ' && array[j - 1] != ' ')){
        array[i++] = array[j++];
      } else if(j == 0 || (j != 0 && array[j - 1] == ' ')) {
        j++;
      }
    }
    while(array[i] == ' '){
      i--;
    }
    return new String(array, 0, i);
  }
}
