class Solution {
    public boolean exist(char[][] board, String word) {
        for(int y = 0; y < board.length; y++)
            for(int x = 0; x < board[0].length; x++)
                if(board[y][x]==word.charAt(0) && backtrack(board, word, 0, y, x)) return true;
        return false;
    }
    public boolean backtrack(char[][] board, String word, int currIndex, int y, int x){
        if(currIndex>=word.length()) return true;
        if(x >= board[0].length || x < 0 || y >= board.length || y < 0) return false;
        if(board[y][x]!=word.charAt(currIndex)) return false;
        char temp = board[y][x];
        board[y][x] = '#';
        boolean found = backtrack(board, word, currIndex+1, y + 1, x) || backtrack(board, word, currIndex+1, y - 1, x)
        || backtrack(board, word, currIndex+1, y, x + 1) || backtrack(board, word,currIndex+1, y, x - 1);
        board[y][x] = temp;
        return found;
    }
}
