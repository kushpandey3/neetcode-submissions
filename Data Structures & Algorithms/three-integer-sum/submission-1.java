class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ret = new LinkedList<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++){
            int target = -nums[i];
            int left = i;
            int right = nums.length-1;
            if(i>0 && nums[i]==nums[i-1]) continue;
            while(left<right){
                if(left==i) left++;
                else if(right==i) right--;
                else{
                    if(nums[left]+nums[right]==target){
                        LinkedList<Integer> ans = new LinkedList<>();
                        ans.add(nums[left]);
                        ans.add(nums[right]);
                        ans.add(nums[i]);
                        ret.add(ans);
                        left++;
                        right--;
                        while(left<right && (nums[left]==nums[left-1])) left++;
                        while(left<right && (nums[right]==nums[right+1])) right--;
                    }
                    else if(nums[left]+nums[right]>target){
                        right--;
                    }
                    else{
                        left++;
                    }
                }
            }
        }
        return ret;

    }
}
