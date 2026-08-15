class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] data = new boolean[s.length() + 1];
        data[data.length-1] = true;
        for(int i = s.length() - 1; i >= 0; i--){
            for(String word : wordDict){
                if(i+word.length() < data.length && data[i+word.length()] && s.startsWith(word, i)){
                    data[i] = true;
                }
            }
        }
        return data[0];
    }
}
