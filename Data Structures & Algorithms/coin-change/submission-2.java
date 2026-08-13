class Solution {
    public int coinChange(int[] coins, int amount) {
        Integer[] memo = new Integer[amount+1];
        int ret = backtrack(coins, amount, memo);
        return ret > 10000 ? -1 : ret;
    }
    public int backtrack(int[] coins, int amount, Integer[] memo){
        if(amount==0) return 0;
        if(memo[amount]!=null) return memo[amount];
        int ret = 10001;
        for(int coin : coins){
            if(amount-coin>=0){
                ret = Math.min(ret, 1 + backtrack(coins, amount - coin, memo));
            }    
        }
        memo[amount] = ret;
        return ret;
    }
}
