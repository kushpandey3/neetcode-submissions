class Solution {
    public int rob(int[] nums) {
        if(nums.length==1) return nums[0];
        int last = 0;
        int slast = 0;
        for(int i = nums.length - 1; i >= 1; i--){
            int temp = last;
            last = Math.max(nums[i] + slast, last);
            slast = temp;
        }
        int num1 = last;
        last = 0;
        slast = 0;
        for(int i = nums.length - 2; i >= 0; i--){
            int temp = last;
            last = Math.max(nums[i] + slast, last);
            slast = temp;
        }
        return Math.max(num1, last);
    }
}
