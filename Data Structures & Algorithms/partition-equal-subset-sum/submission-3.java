class Solution {
    public boolean canPartition(int[] nums) {
        int target = 0;
        for(int num : nums) target += num;
        if(target%2==1) return false;
        target = target/2;
        boolean[] data = new boolean[target + 1];
        data[0] = true;
        for(int i = 0; i < nums.length; i++){
            for(int j = target; j >= nums[i]; j--){
                data[j] = data[j] || data[j-nums[i]];
            }
        }
        return data[target];
    }
}
