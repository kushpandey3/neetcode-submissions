class Solution {

    public String encode(List<String> strs) {
      StringBuilder builder = new StringBuilder();
      for(String str : strs){
        builder.append("#" + String.format("%03d", str.length()) + str);
      }
      return builder.toString();
    }

    public List<String> decode(String str) {
      List<String> ret = new LinkedList<>();
      int index = 1;
      while(index < str.length()){
        int len = Integer.parseInt(str.substring(index, index + 3));
        ret.add(str.substring(index+3, index + 3 + len));
        index+=len+4;
      }
      return ret;
    }
}
