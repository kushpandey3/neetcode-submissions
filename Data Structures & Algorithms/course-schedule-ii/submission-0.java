class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjs = new ArrayList<>(numCourses);
        for(int i = 0; i < numCourses; i++) adjs.add(new ArrayList<>());
        for(int[] prereq : prerequisites) adjs.get(prereq[1]).add(prereq[0]);
        List<Integer> ret = new ArrayList<>();
        boolean[] seen = new boolean[numCourses];
        boolean[] currStack = new boolean[numCourses];
        for(int i = 0; i < numCourses; i++){
            if(!seen[i]){
                if(!dfs(adjs, ret, seen, currStack, i)) return new int[]{};
            }
        }
        int[] retArr = new int[numCourses];
        for(int i = 0; i < numCourses; i++) retArr[i] = ret.get(i);
        return retArr;
    }
    public boolean dfs(List<List<Integer>> adjs, List<Integer> list, boolean[] seen, boolean[] currStack, int startIndex){
        if(currStack[startIndex]) return false;
        if(seen[startIndex]) return true;
        currStack[startIndex] = true;
        for(Integer prereq : adjs.get(startIndex)){
            if(!dfs(adjs, list, seen, currStack, prereq)) return false;
        }
        list.add(0, startIndex);
        currStack[startIndex] = false;
        seen[startIndex] = true;
        return true;
    }
}
