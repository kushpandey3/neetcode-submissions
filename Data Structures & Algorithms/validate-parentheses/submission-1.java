class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char currChar = s.charAt(i);
            if(currChar=='['||currChar=='('||currChar=='{') stack.push(currChar);
            else{
                if(stack.isEmpty()) return false;
                if(currChar==']') if (stack.pop()!='[') return false;
                if(currChar=='}') if (stack.pop()!='{') return false;
                if(currChar==')') if (stack.pop()!='(') return false;
            }
        }
        if(!stack.isEmpty()) return false;
        return true;
    }
}
