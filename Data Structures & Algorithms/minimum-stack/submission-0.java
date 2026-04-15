class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();   
    }
    
    public void push(int val) {
        stack.push(val);
        int minVal = Math.min(minStack.isEmpty() ? Integer.MAX_VALUE : minStack.peek(), val);
        minStack.push(minVal);   
    }
    
    public void pop() {
        stack.pop();
        minStack.pop();   
    }
    
    public int top() {
        return stack.peek();
        
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
