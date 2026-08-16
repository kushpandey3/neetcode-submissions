class Solution {
    public int lengthOfLIS(int[] nums) {
        HashMap<Integer, Integer>[] memo = new HashMap[nums.length];
        for(int i = 0; i < memo.length; i++) memo[i] = new HashMap<>();
        return backtrack(nums, 0, Integer.MIN_VALUE, memo);
    }
    public int backtrack(int[] nums, int index, int min, HashMap<Integer, Integer>[] memo){
        if(index>=nums.length) return 0;
        Integer val = memo[index].get(min);
        if(val!=null) return val;
        int excl = backtrack(nums, index + 1, min, memo);
        if(nums[index]<=min){
            memo[index].put(min, excl);
            return excl;
        }
        int incl = 1 + backtrack(nums, index + 1, nums[index], memo);
        memo[index].put(min, Math.max(incl, excl));
        return Math.max(incl, excl);
    }
}
