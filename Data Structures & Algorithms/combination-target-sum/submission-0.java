class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> currList = new ArrayList<>();
        backtrack(nums, ret, currList, 0, target, 0);
        return ret;
    }
    public void backtrack(int[] nums, List<List<Integer>> ret, List<Integer> curr, int currSum, int target, int startIndex){
        if(currSum==target){
            ret.add(new ArrayList<>(curr));
        }
        if(currSum>target) return;
        for(int i = startIndex; i < nums.length; i++){
            curr.add(nums[i]);
            backtrack(nums, ret, curr, currSum + nums[i], target, i);
            curr.removeLast();
        }
    }
}
