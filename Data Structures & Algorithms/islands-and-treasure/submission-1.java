class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> q = new ArrayDeque<>();
        int[][] dirs = new int[][]{{0, -1}, {0, 1}, {1, 0}, {-1,0}};
        for(int i = 0; i < grid.length; i++){
            for(int o = 0; o < grid[0].length; o++){
                if(grid[i][o]!=0) continue;
                q.add(new int[]{i,o});
            }
        }
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                int[] popped = q.poll();
                for(int[] dir : dirs){
                    int[] n = new int[]{popped[0] + dir[0], popped[1] + dir[1]};
                    if(n[0] >= 0 && n[0] < grid.length && n[1] >= 0 
                    && n[1] < grid[0].length && grid[n[0]][n[1]]==Integer.MAX_VALUE){
                        q.add(n);
                        grid[n[0]][n[1]] = grid[popped[0]][popped[1]] + 1;
                    }
                }
            }
        }
    }
}
