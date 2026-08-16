class Solution {
    public int lengthOfLIS(int[] nums) {
        Integer[][] memo = new Integer[nums.length][nums.length + 1];
        return backtrack(nums, 0, -1, memo);
    }
    public int backtrack(int[] nums, int index, int prevIndex, Integer[][] memo){
        if(index>=nums.length) return 0;
        if(memo[index][prevIndex+1]!=null) return memo[index][prevIndex+1];
        int excl = backtrack(nums, index + 1, prevIndex, memo);
        int incl = 0;
        if(prevIndex<0||nums[index]>nums[prevIndex]){
            incl = 1 + backtrack(nums, index + 1, index, memo);
        }
        return memo[index][prevIndex+1] = Math.max(incl, excl);
    }
}
