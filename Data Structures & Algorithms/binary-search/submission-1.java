class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while(left<right){
            int num = nums[left + (right-left)/2];
            if(target==num) return left + (right-left)/2;
            if(left == right - 1) return -1;
            if(target>num) left = left + (right-left)/2;
            else if(target<num) right = left + (right-left)/2;
        }
        return -1;
    }
}
