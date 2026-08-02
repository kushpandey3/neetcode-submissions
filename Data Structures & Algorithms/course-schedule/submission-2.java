class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //directed graph, detect cycles
        List<List<Integer>> adjacencies = new ArrayList<>(numCourses);
        for(int i = 0; i < numCourses; i++) adjacencies.add(new ArrayList<Integer>());
        for(int[] prereq : prerequisites){
            adjacencies.get(prereq[0]).add(prereq[1]);
        }
        boolean[] visited = new boolean[numCourses];
        boolean[] visiting = new boolean[numCourses];
        for(int i = 0; i < numCourses; i++){
            if(!dfs(adjacencies, visiting, visited, i)) return false;
        }
        return true;
    }
    public boolean dfs(List<List<Integer>> adjacencies, boolean[] visiting, boolean[] visited, int index){
        if(visiting[index]) return false;
        if(visited[index]) return true;
        visiting[index] = true;
        for(Integer prereq : adjacencies.get(index)){
            if(!dfs(adjacencies, visiting, visited, prereq)) return false;
        }
        visiting[index] = false;
        visited[index] = true;
        return true;
    }
}
