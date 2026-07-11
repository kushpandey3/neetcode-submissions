class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0, right = 0, max = 0, common = 0, replacements = 0;
        int[] freqArr = new int[26];
        if(s.length()>0){
            freqArr[s.charAt(0)-'A']++;
            common = s.charAt(0)-'A';
        }
        while(right<s.length()){
            replacements = right - left - freqArr[common] + 1;
            if(replacements > k){
                freqArr[s.charAt(left)-'A']--;
                left++;
            }
            else{
                right++;
                if(right<s.length()) freqArr[s.charAt(right)-'A']++;
            }
            for(int i = 0; i <= 25; i++){
                if(freqArr[i]>freqArr[common]) common = i;
            }
            if(right-left>max) max = right-left;
        }
        return max;
    }
}
