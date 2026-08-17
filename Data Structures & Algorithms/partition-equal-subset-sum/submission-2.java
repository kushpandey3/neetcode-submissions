class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num : nums) sum += num;
        if(sum%2==1) return false;
        return backtrack(nums, 0, sum/2, new Boolean[nums.length][sum/2+1]);
    }
    public boolean backtrack(int[] nums, int index, int left, Boolean[][] memo){
        if(index==nums.length&&left==0) return true;
        if(index>=nums.length||left<=0) return false;
        if(memo[index][left]!=null) return memo[index][left];
        boolean excl = backtrack(nums, index + 1, left, memo);
        boolean incl = backtrack(nums, index + 1, left - nums[index], memo);
        return memo[index][left] = excl||incl;
    }
}
