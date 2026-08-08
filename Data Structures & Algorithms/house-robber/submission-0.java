class Solution {
    public int rob(int[] nums) {
        Integer[] memo = new Integer[nums.length];
        return Math.max(backtrack(nums, memo, 0), backtrack(nums, memo, 1));
    }
    public int backtrack(int[] nums, Integer[] memo, int currIndex){
        if(currIndex>=nums.length) return 0;
        if(memo[currIndex]!=null){
            return memo[currIndex];
        }
        memo[currIndex] = Math.max(backtrack(nums, memo, currIndex + 1), nums[currIndex] + backtrack(nums, memo, currIndex + 2));
        return memo[currIndex];
    }
}
