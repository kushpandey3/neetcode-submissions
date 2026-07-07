class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while(left<right){
            int mid = left + (right-left)/2;
            int num = nums[mid];
            if(target==num) return mid;
            if(target>num) left = mid + 1;
            else if(target<num) right = mid - 1;
        }
        if(nums[left]==target) return left;
        else return -1;
    }
}
