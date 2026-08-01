class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length!=n-1) return false;
        List<List<Integer>> adjacencyLists = new ArrayList<>();
        for(int i = 0; i < n; i++) adjacencyLists.add(new ArrayList<Integer>());
        for(int i = 0; i < edges.length; i++){
            adjacencyLists.get(edges[i][0]).add(edges[i][1]);
            adjacencyLists.get(edges[i][1]).add(edges[i][0]);
        }
        boolean[] visited = new boolean[n];
        if(dfs(adjacencyLists, visited, 0, -1)) return false;
        for(boolean v: visited) if(!v) return false;
        return true;
    }
    public boolean dfs(List<List<Integer>> graph, boolean[] visited, int node, int parent){
        visited[node] = true;
        for(int neighbor : graph.get(node)){
            if(neighbor==parent) continue;
            if(visited[neighbor]) return true;
            if(dfs(graph, visited, neighbor, node)) return true;
        }
        return false;
    }
}
