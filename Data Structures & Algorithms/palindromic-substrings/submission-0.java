class Solution {
    public int countSubstrings(String s) {
        int num = 0, l, r;
        for(int i = 0; i < s.length(); i++){
            l = i; r = i;
            while (l >= 0 && r < s.length() && s.charAt(l)==s.charAt(r)){
                num++;
                l--;
                r++;
            }
            l = i; r = i+1;
            while (l >= 0 && r < s.length() && s.charAt(l)==s.charAt(r)){
                num++;
                l--;
                r++;
            }
        }
        return num;
    }
}
