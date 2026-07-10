class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<Character>();
        int left = 0, right = 0, max = 0;
        while(right<s.length()){
            char lC = s.charAt(left);
            char rC = s.charAt(right);
            if(!set.contains(rC)){
                set.add(rC);
                right++;
                if(right-left>max) max = right-left;
            }
            else{
                set.remove(lC);
                left++;
            }
        }
        return max;
    }
}
