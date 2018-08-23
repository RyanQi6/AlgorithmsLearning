public class StringDecompressII {
  public String decompress(String s){
    if(s == null || s.length() < 2 || s.length() % 2 == 1){
      return s;
    }
    StringBuilder sb = new StringBuilder();
    char ch = 'a';
    int freq;
    for(int i = 0; i < s.length(); ++i){
      if(i % 2 == 0){
        ch = s.charAt(i);
      } else {
        freq = (int)(s.charAt(i) - '0');
        for(int j = 0; j < freq; ++j){
          sb.append(ch);
        }
      }
    }
    return sb.toString();
  }
}
