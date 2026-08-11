class Solution {
    public int numDecodings(String s) {
        Integer[] interpretations = new Integer[s.length()];
        int num = backtrack(s, interpretations, 0);
        return num;
    }
    public int backtrack(String s, Integer[] interpretations, int startIndex){
        if(startIndex==s.length()) return 1;
        if(startIndex > s.length()) return 0;
        if(interpretations[startIndex]!=null) return interpretations[startIndex];
        if(s.charAt(startIndex)=='0') return 0;
        if(startIndex+1 < s.length()){
            int num = Integer.parseInt(s.substring(startIndex, startIndex + 2));
            if(num>0 && num <= 26){
                interpretations[startIndex] = backtrack(s, interpretations, startIndex+1) + backtrack(s, interpretations, startIndex+2);
            }
            else interpretations[startIndex] = backtrack(s, interpretations, startIndex+1);
        }
        else{
            interpretations[startIndex] = backtrack(s, interpretations, startIndex+1);
        }
        return interpretations[startIndex];
    }
}
