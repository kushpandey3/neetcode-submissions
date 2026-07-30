class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ret = new ArrayList<>();
        List<String> currList = new ArrayList<>();
        backtrack(ret, s, currList, 0);
        return ret;
    }
    public void backtrack(List<List<String>> ret, String s, List<String> curr, int currIndex){
        if(currIndex==s.length()){
            ret.add(new ArrayList<>(curr));
            return;
        }
        for(int i = currIndex; i < s.length(); i++){
            if(isPalindrome(s, currIndex, i)){
                curr.add(s.substring(currIndex, i+1));
                backtrack(ret, s, curr, i+1);
                curr.removeLast();
            }
        }
    }
    public boolean isPalindrome(String s, int start, int end){
        while(start<=end){
            if(s.charAt(start)!=s.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }
}
