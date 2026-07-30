class Solution {
    static char[][] matches = {{'a','b','c'}, {'d','e','f'}, {'g', 'h', 'i'}, {'j', 'k', 'l'},
        {'m','n','o'}, {'p','q','r','s'}, {'t','u','v'}, {'w','x','y','z'}};
    public List<String> letterCombinations(String digits) {
        List<String> ret = new ArrayList<>();
        StringBuilder s = new StringBuilder();
        if(digits.length()==0) return ret;
        backtrack(digits, ret, s, 0);
        return ret;
    }
    public void backtrack(String digits, List<String> ret, StringBuilder sb, int currIndex){
        if(sb.length()==digits.length()){
            ret.add(sb.toString());
            return;
        }
        int convertedChar = digits.charAt(currIndex) - '2';
        for(int i = 0; i < matches[convertedChar].length; i++){
            sb.append(matches[convertedChar][i]);
            backtrack(digits, ret, sb, currIndex + 1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
