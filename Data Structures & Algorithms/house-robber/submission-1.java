class Solution {
    public int rob(int[] nums) {
        int last = 0;
        int slast = 0;
        for(int i = nums.length -1; i>=0; i--){
            int temp = last;
            last = Math.max(slast + nums[i], last);
            slast = temp;
        }
        return last;
    }
}
