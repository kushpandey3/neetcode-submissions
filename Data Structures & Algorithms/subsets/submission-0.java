class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        ret.add(new ArrayList<Integer>());
        for(int i = 0; i < nums.length; i++){
            int size = ret.size();
            for(int o = 0; o < size; o++) {
                ArrayList<Integer> nList = new ArrayList<>(ret.get(o));
                nList.add(nums[i]);
                ret.add(nList);
            }
        }
        return ret;
    }
}
