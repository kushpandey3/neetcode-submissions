class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>(1 << nums.length);
        List<Integer> subset = new ArrayList<>();
        backtrack(nums, ret, subset, 0);
        return ret;
    }
    public void backtrack(int[] nums, List<List<Integer>> ret, List<Integer> subset, int index){
        ret.add(new ArrayList<>(subset));
        for(int i = index; i < nums.length; i++){
            subset.add(nums[i]);
            backtrack(nums, ret, subset, i+1);
            subset.removeLast();
        }
    }
}
