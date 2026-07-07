class MinStack {
    public int[] stack;
    public int[] mins;
    public int head;
    public MinStack() {
        stack = new int[10];
        mins = new int[10];
        head = -1;
    }
    
    public void push(int val) {
        if(head==-1){
            head = 0;
            stack[head] = val;
            mins[head] = val;
        }
        else if(head>=stack.length-1){
            int[] tempStack = new int[stack.length*2];
            for(int i = 0; i < stack.length; i++) tempStack[i] = stack[i];
            stack = tempStack;
            int[] tempMins = new int[mins.length*2];
            for(int i = 0; i < mins.length; i++) tempMins[i] = mins[i];
            mins = tempMins;
            head++;
            stack[head] = val;
            mins[head] = Math.min(mins[head-1], val);
        }
        else{
            head++;
            stack[head] = val;
            mins[head] = Math.min(mins[head-1], val);
        }
    }
    
    public void pop() {
        if(head==-1) throw new EmptyStackException();
        else{
            stack[head]=0;
            mins[head]=0;
            head--;
        }
    }
    
    public int top() {
        if(head==-1) throw new EmptyStackException();
        return stack[head];
    }
    
    public int getMin() {
       if(head==-1) throw new EmptyStackException();
       return mins[head]; 
    }
}
