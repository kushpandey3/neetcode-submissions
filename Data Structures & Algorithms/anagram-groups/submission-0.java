class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
      int[] freqs = new int[26];
      HashMap<String, LinkedList<String>> map = new HashMap<>();
      LinkedList<String> list;
      String hashCode;
      for(int o = 0; o < strs.length; o++){
        for(int i = 0; i < strs[o].length(); i++) freqs[strs[o].charAt(i)-'a']++;
        hashCode = "";
        for(int j = 0; j < freqs.length; j++) hashCode+=freqs[j]+"#";
        list = map.get(hashCode);
        if(list==null){
            list = new LinkedList<String>();
            map.put(hashCode, list);
        }
        list.add(strs[o]);
        freqs = new int[26];
      }
      return new LinkedList<>(map.values());
    }
}
