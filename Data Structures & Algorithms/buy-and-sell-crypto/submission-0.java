class Solution {
    public int maxProfit(int[] prices) {
        int max = 0, left = 0, right = 1;
        while(right<prices.length){
            int lP = prices[left];
            int rP = prices[right];
            if(rP - lP > max) max = rP - lP;
            else if(rP<lP){
                left = right;
                right++;
            }
            else right++;
        }
        return max;
        
    }
}
