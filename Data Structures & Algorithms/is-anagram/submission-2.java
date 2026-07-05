class Solution {
    public boolean isAnagram(String s, String t) {
        int[] one = new int[26];
        int[] two = new int[26];
        if(s.length()!=t.length()) return false;
        for(int i = 0; i <s.length(); i++){
            one[s.charAt(i) - 'a']++;
            two[t.charAt(i)- 'a'] ++;
        }
        for(int i = 0; i < one.length; i++) if(one[i]!=two[i]) return false;
        return true;
    }
}
