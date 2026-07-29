class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> currList = new ArrayList<>();
        boolean[] seen = new boolean[nums.length];
        backtrack(nums, ret, currList, seen);
        return ret;
    }
    public void backtrack(int[] nums, List<List<Integer>> ret, List<Integer> curr, boolean[] seen){
        if(curr.size()==nums.length){
            ret.add(new ArrayList<>(curr));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(seen[i]==true) continue;
            seen[i] = true;
            curr.add(nums[i]);
            backtrack(nums, ret, curr, seen);
            curr.removeLast();
            seen[i] = false;
        }
    }
}
