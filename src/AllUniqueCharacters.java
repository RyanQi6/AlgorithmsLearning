public class AllUniqueCharacters{
  public boolean allUnique(String word) {
  // Write your solution here
    if(word == null || word.length() < 2){
      return true;
    }
    int[] set = new int[8];
    for(int i = 0; i < word.length(); ++i){
      int blockId = (int) word.charAt(i) / 32;
      int pos = (int) word.charAt(i) % 32;
      if(((1 << pos) & set[blockId]) != 0){
        return false;
      } else {
        set[blockId] = (1 << pos) | set[blockId];
      }
    }
    return true;
  }
}
