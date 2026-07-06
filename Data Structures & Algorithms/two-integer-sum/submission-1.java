class Solution {
    public int[] twoSum(int[] nums, int target) {
       for(int o = 0; o < nums.length; o++){
        for(int i = o+1; i < nums.length; i++){
            if(nums[i] + nums[o]==target) return new int[]{o,i};
        }
       }
       return new int[]{0,0};
    }
}
