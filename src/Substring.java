public class Substring {
  public int strstr(String large, String small) {
  // Write your solution here
    if(large == null || large.length() < small.length()){
      return -1;
    }
    if(small == null || small.length() == 0){
      return 0;
    }
    char[] largeArray = large.toCharArray();
    char[] smallArray = small.toCharArray();
    int smallHash = hashInitial(smallArray, small.length());
    int largeHash = hashInitial(largeArray, small.length());

    for(int i = 0; i < large.length() - small.length(); ++i){
      if(largeHash == smallHash){
        return i;
      }
      largeHash = hash(largeArray, largeHash, i + 1, small.length());
    }

    return -1;
  }
  private int hashInitial(char[] array, int windowSize){
    int hash = 0;
    for(int i = 0; i < windowSize; ++i){
      hash += (array[i] - 'a') * Math.pow(26, (windowSize - i - 1));
    }
    return hash;
  }
  private int hash(char[] array, int lastHash, int index, int windowSize){
    lastHash -= (array[index - 1] - 'a') * Math.pow(26, (windowSize - 1));
    lastHash *= 26;
    lastHash += (array[index + windowSize - 1] - 'a');
    return lastHash;
  }
}
