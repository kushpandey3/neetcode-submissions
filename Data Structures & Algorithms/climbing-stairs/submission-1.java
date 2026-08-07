class Solution {
    public int climbStairs(int n) {
        return backtrack(0, n, new Integer[n]);
    }
    public int backtrack(int currNum, int goal, Integer[] data){
        if(currNum==goal) return 1;
        if(currNum>goal) return 0;
        if(data[currNum]!=null) return data[currNum];
        data[currNum] = backtrack(currNum+1, goal, data) + backtrack(currNum+2, goal, data);
        return data[currNum];
    }
}
