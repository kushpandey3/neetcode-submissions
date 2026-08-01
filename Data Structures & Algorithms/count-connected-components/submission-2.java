class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adjacencies = new ArrayList<>(n);
        for(int i = 0; i < n; i++) adjacencies.add(new ArrayList<Integer>());
        for(int i = 0; i < edges.length; i++){
            adjacencies.get(edges[i][0]).add(edges[i][1]);
            adjacencies.get(edges[i][1]).add(edges[i][0]);
        }
        boolean[] visited = new boolean[n];
        int ret = 0;
        for(int i = 0; i < adjacencies.size(); i++){
            if(!visited[i]) ret++;
            dfs(adjacencies, visited, i);
        }
        return ret;
    }
    public void dfs(List<List<Integer>> adjacencies, boolean[] visited, int node){
        if(visited[node]) return; 
        visited[node] = true; 
        for(int neighbor : adjacencies.get(node)) dfs(adjacencies, visited, neighbor);
    }
}
