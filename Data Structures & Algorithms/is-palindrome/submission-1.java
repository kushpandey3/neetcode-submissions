class Solution {
    public boolean isPalindrome(String s) {
        s = format(s);
        int left = 0;
        int right = s.length()-1;
        while(left<=right){
            if(s.charAt(left)!=s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
    public String format(String s){
        String ret = "";
        for(int i = 0; i < s.length(); i++){
            char curr = s.charAt(i);
            if((curr>=97 && curr<=122)||(curr>=48&&curr<=57)) ret+= curr;
            else if(curr>=65 && curr<=90) ret += (char)(curr+32);
        }
        return ret;
    }
}
