class Solution {
    public int findMin(int[] nums) {
        int low = 1;
        int high = nums.length;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(mid==nums.length) mid = 0;
            int last = mid==0? nums.length-1 : mid-1;
            if(nums[mid]<=nums[last]) return nums[mid];
            if(nums[mid]>nums[0]) low = mid+1;
            if(nums[mid]<nums[0]) high = mid-1;
        }
        return -1;
    }
}
