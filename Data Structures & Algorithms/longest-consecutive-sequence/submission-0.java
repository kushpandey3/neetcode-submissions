class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        LinkedList<Integer> starters = new LinkedList<>();
        for(int i : nums) set.add(i);
        for(Integer i : set) if(!set.contains(i-1)) starters.add(i);
        int max = 0;
        for(Integer i : starters){
            int currNum = i;
            int currStreak = 1;
            while(set.contains(currNum+1)){
                currNum++;
                currStreak++;
            }
            if(currStreak>max) max = currStreak;
        }
        return max;
    }
}
