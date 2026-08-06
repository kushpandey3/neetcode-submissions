class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjs = new ArrayList<>(numCourses);
        for(int i = 0; i < numCourses; i++) adjs.add(new ArrayList<>());
        for(int[] prereq : prerequisites) adjs.get(prereq[1]).add(prereq[0]);
        int[] ret = new int[numCourses];
        boolean[] seen = new boolean[numCourses];
        boolean[] currStack = new boolean[numCourses];
        int[] soFar = {0};
        for(int i = 0; i < numCourses; i++){
            if(!seen[i]){
                if(!dfs(adjs, ret, seen, currStack, i, soFar)) return new int[]{};
            }
        }
        return ret;
    }
    public boolean dfs(List<List<Integer>> adjs, int[] list, boolean[] seen, boolean[] currStack, int startIndex, int[] soFar){
        if(currStack[startIndex]) return false;
        if(seen[startIndex]) return true;
        currStack[startIndex] = true;
        for(Integer prereq : adjs.get(startIndex)){
            if(!dfs(adjs, list, seen, currStack, prereq, soFar)) return false;
        }
        list[list.length-soFar[0]-1] = startIndex;
        soFar[0]++;
        currStack[startIndex] = false;
        seen[startIndex] = true;
        return true;
    }
}
