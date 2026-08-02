class Solution {
    int[][] dirs = new int[][]{{1,0}, {-1,0}, {0,1}, {0,-1}};
    public void solve(char[][] board) {
        for(int r = 0; r < board.length; r++){
            if(board[r][0]=='O') dfs(board, r, 0);
            if(board[r][board[r].length-1]=='O') dfs(board, r, board[r].length-1);
        }
        for(int c = 0; c < board[0].length; c++){
            if(board[0][c]=='O') dfs(board, 0, c);
            if(board[board.length-1][c]=='O') dfs(board, board.length-1, c);
        }
        for(int r = 0; r < board.length; r++) {
            for(int c = 0; c < board[r].length; c++) {
                if(board[r][c]=='#') board[r][c]='O';
                else if(board[r][c]=='O') board[r][c]='X';
            }
        }
    }
    public void dfs(char[][] board, int r, int c){
        board[r][c]='#';
        for(int[] dir: dirs){
            int nr = r + dir[0];
            int nc = c + dir[1];
            if(nr>=0 && nc>=0 && nr < board.length && nc < board[0].length && board[nr][nc]=='O') dfs(board, nr, nc);
        }
    }
}
