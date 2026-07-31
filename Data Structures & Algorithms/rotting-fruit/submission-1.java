class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new ArrayDeque<>();
        int totFruits = 0;
        int currRotten = 0;
        int mins = 0;
        int[][] dirs = new int[][]{{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
        for(int r = 0; r < grid.length; r++){
            for(int c = 0; c < grid[r].length; c++){
                if(grid[r][c]==2){
                    totFruits++; currRotten++;
                    q.add(new int[]{r, c});
                }
                else if(grid[r][c]==1) totFruits++;
            }
        }
        while(!q.isEmpty()){
            if(totFruits==currRotten) return mins;
            int size = q.size();
            for(int i = 0; i < size; i++){
                int[] currPos = q.poll();
                for(int[] dir : dirs){
                    int[] nextPos = new int[] {currPos[0] + dir[0], currPos[1] + dir[1]};
                    if(nextPos[0]>=0&&nextPos[1]>=0&&nextPos[0]<grid.length&&nextPos[1]<grid[0].length
                    &&grid[nextPos[0]][nextPos[1]]==1){
                        q.add(nextPos);
                        grid[nextPos[0]][nextPos[1]] = 2;
                        currRotten++;
                    }
                }
            }
            mins++;
        }
        if(totFruits>currRotten) return -1; else return mins;
    }
}
