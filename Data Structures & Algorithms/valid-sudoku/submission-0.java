class Solution {
    public boolean isValidSudoku(char[][] board) {
       Set<Integer> running = new HashSet<>();
       Set<Integer>[][] boxSets = new Set[3][3];
       for(int i = 0; i < 3; i++){
        for(int o = 0; o < 3; o++){
            boxSets[i][o] = new HashSet<>();
        }
       }
       for(int r = 0; r < 9; r++){
        for(int c = 0; c < 9; c++){
            if(board[c][r]!='.'){
                if(!running.add(board[c][r]-'0')) return false;
                if(!boxSets[r/3][c/3].add(board[c][r]-'0')) return false;
            }
        }
        running.clear();
       }
       for(int c = 0; c < 9; c++){
        for(int r = 0; r < 9; r++){
            if(board[c][r]!='.') if(!running.add(board[c][r]-'0')) return false;
        }
        running.clear();
       }
       return true;
    }
}