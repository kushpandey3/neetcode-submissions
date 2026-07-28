class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> currList = new ArrayList<>();
        List<Integer> remaining = new ArrayList<>();
        for(int i : nums) remaining.add(i);
        backtrack(nums, ret, currList, remaining);
        return ret;
    }
    public void backtrack(int[] nums, List<List<Integer>> ret, List<Integer> curr, List<Integer> remaining){
        if(remaining.isEmpty()){
            ret.add(new ArrayList<>(curr));
            return;
        }
        for(int i = 0; i < remaining.size(); i++){
            Integer removed = remaining.remove(i);
            curr.add(removed);
            backtrack(nums, ret, curr, remaining);
            remaining.add(i, removed);
            curr.removeLast();
        }
    }
}
