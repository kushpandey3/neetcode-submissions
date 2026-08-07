class Solution {
    public int climbStairs(int n) {
        if(n<=2) return n;
        int slast = 1;
        int last = 2;
        for(int i = 2; i < n; i++){
            int temp = last;
            last += slast;
            slast = temp;
        }
        return last;
    }
}
