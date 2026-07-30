class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for(int r = 0; r < grid.length; r++){
            for(int c = 0; c < grid[0].length; c++){
                maxArea = Math.max(dfs(grid, r, c), maxArea);
            }
        }
        return maxArea;
    }
    public int dfs(int[][] arr, int r, int c){
        if(r<0||c<0||r>=arr.length||c>=arr[0].length||arr[r][c]!=1) return 0;
        arr[r][c] = 0;
        return 1 + dfs(arr, r + 1, c) + dfs(arr, r, c + 1) + dfs(arr, r - 1, c) + dfs(arr, r, c - 1);
    }
}
