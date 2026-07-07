class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] ret = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        int dist;
        for(int i = 0; i < temperatures.length; i++){
            if(stack.isEmpty()||temperatures[stack.peek()]>=temperatures[i]){
                stack.push(i);
            }
            else{
                while(!stack.isEmpty()&&temperatures[stack.peek()]<temperatures[i]){
                    int ind = stack.pop();
                    ret[ind] = i-ind;
                }
                stack.push(i);
            }
        }
        while(!stack.isEmpty()) ret[stack.pop()] = 0;
        return ret;
    }
}
