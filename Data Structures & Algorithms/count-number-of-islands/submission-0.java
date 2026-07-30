class Solution {
    public int numIslands(char[][] grid) {
        char[][] copy = new char[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++){
            for(int x = 0; x < grid[0].length; x++){
                copy[i][x] = grid[i][x];
            }
        }
        int numIslands = 0;
        for(int y = 0; y < grid.length; y++){
            for(int x = 0; x < grid[0].length; x++){
                if(copy[y][x]=='1'){
                    numIslands++;
                    dfs(copy, x, y);
                }
            }
        }
        return numIslands;
    }
    public void dfs(char[][] arr, int x, int y){
        if(x<0||y<0||x>=arr[0].length||y>=arr.length||arr[y][x]!='1') return;
        arr[y][x] = '0';
        dfs(arr, x + 1, y);
        dfs(arr, x - 1, y);
        dfs(arr, x, y + 1);
        dfs(arr, x, y - 1);
    }
}
