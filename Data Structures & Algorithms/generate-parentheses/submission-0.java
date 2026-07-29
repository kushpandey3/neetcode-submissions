class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ret = new ArrayList<>();
        StringBuilder s = new StringBuilder();
        backtrack(ret, s, 0, 0, n);
        return ret;
    }
    public void backtrack(List<String> ret, StringBuilder s, int o, int c, int n){
        if(c>o) return;
        if(o>n) return;
        if(s.length()==2*n){
            ret.add(s.toString());
            return;
        }
        s.append('(');
        backtrack(ret, s, o + 1, c, n);
        s.deleteCharAt(s.length()-1);
        s.append(')');
        backtrack(ret, s, o, c + 1, n);
        s.deleteCharAt(s.length()-1);
    }
}
