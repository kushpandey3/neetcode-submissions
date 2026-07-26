class Solution {
    public int maxSubArray(int[] nums) {
        int right = 0;
        int max = nums[0];
        int runningMax = 0;
        while(right<nums.length){
            runningMax += nums[right];
            if(runningMax > max) max = runningMax;
            if(runningMax < 0){
                runningMax = 0;
            }
            right++;
        }
        return max;
    }
}
