class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ret = new ArrayList<>();
        List<String> currList = new ArrayList<>(n);
        Set<Integer> cols = new HashSet<>();
        Set<Integer> diag1 = new HashSet<>();
        Set<Integer> diag2 = new HashSet<>();
        String dots = ".".repeat(n);
        for(int i = 0; i < n; i++) currList.add(dots);
        backtrack(ret, n, currList, 0, cols, diag1, diag2);
        return ret;
    }
    public void backtrack(List<List<String>> ret, int n, List<String> curr, int row, Set<Integer> cols, Set<Integer> diag1, Set<Integer> diag2){
        if(n==row){
            ret.add(new ArrayList<>(curr));
            return;
        }
        for(int x = 0; x < n; x++){
            if(!cols.contains(x)&&!diag1.contains(x+row)&&!diag2.contains(x-row)){
                String c = curr.get(row);
                c = c.substring(0, x) + 'Q' + c.substring(x+1);
                curr.set(row, c);
                cols.add(x);
                diag1.add(x+row);
                diag2.add(x-row);
                backtrack(ret, n, curr, row + 1, cols, diag1, diag2);
                c = c.substring(0, x) + '.' + c.substring(x+1);
                curr.set(row, c);
                cols.remove(x);
                diag1.remove(x+row);
                diag2.remove(x-row);
            }
        }
    }
}
