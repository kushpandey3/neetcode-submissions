class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] data = new int[amount+1];
        Arrays.fill(data, amount+1);
        data[0] = 0;
        for(int i = 1; i <= amount; i++){
            for(int coin : coins){
                if(i-coin>=0){
                    data[i] = Math.min(data[i], 1 + data[i-coin]);
                }
            }
        }
        return data[amount] == amount + 1 ? -1 : data[amount];
    }
}
