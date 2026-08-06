class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        DSU dsu = new DSU(edges.length+1);
        for(int[] edge : edges) if(!dsu.union(edge[0], edge[1])) return edge;
        return edges[0];
    }
}
class DSU{
    int[] parents, sizes;
    public DSU(int n){
        parents = new int[n]; sizes = new int[n];
        for(int i = 0; i < n; i++){
            parents[i] = i;
            sizes[i] = 1;
        }
    }
    public int find(int i){
        if(parents[i]!=i){
            parents[i] = find(parents[i]);
        }
        return parents[i];
    }
    public boolean union(int a, int b){
        int rootA = find(a);
        int rootB = find(b);
        if(rootA==rootB) return false;
        if(sizes[rootA]<sizes[rootB]){
            int temp = rootA;
            rootA = rootB;
            rootB = temp;
        }
        parents[rootB] = rootA;
        sizes[rootA] += sizes[rootB];
        return true;
    }
}
