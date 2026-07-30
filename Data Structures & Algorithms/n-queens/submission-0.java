class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ret = new ArrayList<>();
        List<String> currList = new ArrayList<>(n);
        String dots = ".".repeat(n);
        for(int i = 0; i < n; i++) currList.add(dots);
        backtrack(ret, n, currList, 0);
        return ret;
    }
    public void backtrack(List<List<String>> ret, int n, List<String> curr, int row){
        if(n==row){
            ret.add(new ArrayList<>(curr));
            return;
        }
        for(int x = 0; x < n; x++){
            if(isValid(curr, x, row, n)){
                String c = curr.get(row);
                c = c.substring(0, x) + 'Q' + c.substring(x+1);
                curr.set(row, c);
                backtrack(ret, n, curr, row + 1);
                c = c.substring(0, x) + '.' + c.substring(x+1);
                curr.set(row, c);
            }
        }
    }
    public boolean isValid(List<String> currList, int x, int y, int n){
        for(int i = 0; i < n; i++) if(currList.get(i).charAt(x)=='Q') return false;
        for(int i = -n; i <=n; i++){
            if(x-i>=0&&y-i>=0&&x-i<n&&y-i<n)if(currList.get(y-i).charAt(x-i)=='Q') return false;
            if(x+i>=0&&y+i>=0&&x+i<n&&y+i<n) if(currList.get(y+i).charAt(x+i)=='Q') return false;
            if(x+i>=0&&y-i>=0&&x+i<n&&y-i<n) if(currList.get(y-i).charAt(x+i)=='Q') return false;
            if(x-i>=0&&y+i>=0&&x-i<n&&y+i<n) if(currList.get(y+i).charAt(x-i)=='Q') return false;
        }
        return true;
    }
}
