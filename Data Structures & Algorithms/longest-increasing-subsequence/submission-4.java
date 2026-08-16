class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] data = new int[nums.length];
        Arrays.fill(data, 1);
        int max = 1;
        for(int i = nums.length - 1; i >= 0; i--){
            for(int o = i + 1; o < nums.length; o++){
                if(nums[o]>nums[i]) data[i] = Math.max(data[i], 1 + data[o]);
            }
            max = Math.max(data[i], max);
        }
        return max;
    }
}
