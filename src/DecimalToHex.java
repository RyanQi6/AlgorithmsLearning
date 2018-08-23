public class DecimalToHex {
  public String decimalToHex(int num){
    if(num == 0){
      return "0X0";
    }
    char[] table = {'0','1','2','3','4','5','6','7','8',
    '9','A','B','C','D','E','F'};
    StringBuilder sb = new StringBuilder("0x");
    boolean isLeading = true;
    for(int i = 0; i < 8; ++i){
      char cur = table[(num >> (28 - 4 * i)) & 15];
      if(cur != '0' || !isLeading){
        sb.append(cur);
        isLeading = false;
      }
    }
    return sb.toString();
  }
}
