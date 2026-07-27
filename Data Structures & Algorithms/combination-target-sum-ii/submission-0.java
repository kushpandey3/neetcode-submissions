class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> currList = new ArrayList<>();
        backtrack(candidates, ret, currList, 0, 0, target);
        return ret;
    }
    public void backtrack(int[] nums, List<List<Integer>> ret, List<Integer> curr, int currSum, int index, int target){
        if(currSum == target){
            ret.add(new ArrayList<>(curr));
            return;
        }
        if(currSum > target) return;
        for(int i = index; i < nums.length; i++){
            if(i>index && nums[i]==nums[i-1]) continue;
            curr.add(nums[i]);
            backtrack(nums, ret, curr, currSum + nums[i], i + 1, target);
            curr.removeLast();
        }
    }
}
