class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        return helper(s, wordDict, 0, new Boolean[s.length()]);
    }
    public boolean helper(String s, List<String> wordDict, int startIndex, Boolean[] memo){
        if(startIndex>=s.length()) return true;
        if(memo[startIndex]!=null) return memo[startIndex];
        for(String str : wordDict){
            if(s.startsWith(str, startIndex)){
                memo[startIndex] = helper(s, wordDict, str.length() + startIndex, memo);
                if(memo[startIndex]) return true;
            }
        }
        return false;
    }
}
