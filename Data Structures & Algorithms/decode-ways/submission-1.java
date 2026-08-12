class Solution {
    public int numDecodings(String s) {
        int next = 1, nextNext = 0;
        for(int i = s.length() - 1; i >= 0; i--){
            int curr = 0;
            if(s.charAt(i)!='0'){
                curr = next;
                if(i+1<s.length()){
                    int n = Integer.parseInt(s.substring(i, i+2));
                    if(n>=10&&n<=26){
                        curr+=nextNext;
                    }
                }
            }
            nextNext = next;
            next = curr;
        }
        return next;
    }
}
