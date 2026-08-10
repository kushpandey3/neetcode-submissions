class Solution {
    public String longestPalindrome(String s) {
        int start = 0;
        int maxLen = 0;
        int dist = 0;
        for(int i = 0; i < s.length(); i++){
            while(i-dist>=0 && i + dist < s.length()){
                if(s.charAt(i+dist)==s.charAt(i-dist)){
                    dist++;
                    if(dist*2-1>maxLen){
                        start = i - dist + 1;
                        maxLen = dist*2-1;
                    }
                }
                else break;
            }
            dist = 0;
            while(i-dist-1>=0 && i + dist < s.length()){
                if(s.charAt(i+dist)==s.charAt(i-dist-1)){
                    dist++;
                    if(dist*2>maxLen){
                        start = i - dist;
                        maxLen = dist*2;
                    }
                }
                else break;
            }
        }
        return s.substring(start, start+maxLen);
    }
}
