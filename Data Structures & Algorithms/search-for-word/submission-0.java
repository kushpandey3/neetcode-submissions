class Solution {
    public boolean exist(char[][] board, String word) {
        boolean[][] seen = new boolean[board.length][board[0].length];
        for(int y = 0; y < board.length; y++){
            for(int x = 0; x < board[0].length; x++){
                if(backtrack(board, word, seen, 0, y, x)) return true;
            }
        }
        return false;
    }
    public boolean backtrack(char[][] board, String word, boolean[][] seen, int currIndex, int y, int x){
        if(currIndex>=word.length()) return true;
        if(x >= board[0].length || x < 0 || y >= board.length || y < 0) return false;
        if(seen[y][x]) return false;
        if(board[y][x]!=word.charAt(currIndex)) return false;
        seen[y][x] = true;
        if(backtrack(board, word, seen, currIndex+1, y + 1, x) || backtrack(board, word, seen, currIndex+1, y - 1, x)
        || backtrack(board, word, seen, currIndex+1, y, x + 1) || backtrack(board, word, seen, currIndex+1, y, x - 1)) return true;
        seen[y][x] = false;
        return false;
    }
}
