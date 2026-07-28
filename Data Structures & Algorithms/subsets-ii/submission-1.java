class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>(1 << nums.length);
        List<Integer> currList = new ArrayList<>(nums.length);
        Arrays.sort(nums);
        backtrack(nums, ret, currList, 0);
        return ret;
    }
    public void backtrack(int[] nums, List<List<Integer>> ret, List<Integer> curr, int startIndex){

        ret.add(new ArrayList(curr));
        for(int i = startIndex; i < nums.length; i++){
           if(i>startIndex&& nums[i]==nums[i-1]) continue;
            curr.add(nums[i]);
            backtrack(nums, ret, curr, i + 1);
            curr.removeLast();
        }
    }
}
