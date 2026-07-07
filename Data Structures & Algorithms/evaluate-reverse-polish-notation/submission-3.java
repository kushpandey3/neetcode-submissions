class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < tokens.length; i++){
            if(tokens[i].charAt(0)>='0'&& tokens[i].charAt(0)<='9') stack.push(Integer.parseInt(tokens[i]));
            else if(tokens[i].charAt(0)=='-'&&tokens[i].length()>1) stack.push(-1*Integer.parseInt(tokens[i].substring(1)));
            else{
                char op = tokens[i].charAt(0);
                int second = stack.pop();
                int first = stack.isEmpty() ? 0 : stack.pop();
                if(op=='+') stack.push(first+second);
                if(op=='-') stack.push(first-second);
                if(op=='*') stack.push(first*second);
                if(op=='/') stack.push(first/second);
            }
        }
        return stack.pop();
    }
}
