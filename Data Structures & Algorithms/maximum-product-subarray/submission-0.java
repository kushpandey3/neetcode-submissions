class Solution {
    public int maxProduct(int[] nums) {
        int min = nums[0], max = nums[0], absolute = nums[0];
        for(int i = 1; i < nums.length; i++){
            int tempMax = Math.max(nums[i], Math.max(min*nums[i], max*nums[i]));
            min = Math.min(nums[i], Math.min(min*nums[i], max*nums[i]));
            max = tempMax;
            absolute = Math.max(absolute, max);
        }
        return absolute;
    }
}
