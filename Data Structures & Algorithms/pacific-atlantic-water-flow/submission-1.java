class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        boolean[][] pacific = new boolean[heights.length][heights[0].length]; 
        boolean[][] atlantic = new boolean[heights.length][heights[0].length]; 
        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for(int i = 0; i < heights.length; i++){
            dfs(i, 0, pacific, dirs, heights);
            dfs(i, heights[0].length-1, atlantic, dirs, heights);
        }
        for(int i = 0; i < heights[0].length; i++){
            dfs(0, i, pacific, dirs, heights);
            dfs(heights.length-1, i, atlantic, dirs, heights);
        }
        List<List<Integer>> ret = new ArrayList<>();
        for(int r = 0; r < heights.length; r++)
            for(int c = 0; c < heights[0].length; c++)
                if(pacific[r][c]&&atlantic[r][c]) ret.add(new ArrayList(Arrays.asList(r, c)));
        return ret;
    }
    public void dfs(int r, int c, boolean[][] arr, int[][] dirs, int[][] heights){
        arr[r][c] = true;
        for(int[] dir : dirs){
            int y = r + dir[0];
            int x = c + dir[1];
            if(y>=0&&y<arr.length&&x>=0&&x<arr[0].length&&!arr[y][x]&&heights[y][x]>=heights[r][c]) dfs(y, x, arr, dirs, heights);
        }
    }
}
