package com.company.leetcode;

public class leetcode155 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
    }
}

/**
class MinStack {
    Stack<Integer> mainStack, minStack;
    
    public MinStack() {
        mainStack = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int x) {
        
        if(minStack.isEmpty()) minStack.add(x);
        else {
            if(minStack.peek() > x) minStack.add(x);
            else minStack.add(minStack.peek());
        }
        mainStack.add(x);
    }
    
    public void pop() {
        if(!mainStack.isEmpty()) mainStack.pop();
        if(!minStack.isEmpty()) minStack.pop();
    }
    
    public int top() {
        return mainStack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
**/

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
 

/**
class MinStack {

    Stack<Node> stack;
    public MinStack() {
        stack = new Stack<>();
    }
    
    public void push(int x) {
        if(stack.isEmpty()) stack.add(new Node(x,x));
        else stack.add(new Node(x, Math.min(stack.peek().min, x) ));
    }
    
    public void pop() {
        if(!stack.isEmpty()) stack.pop();
    }
    
    public int top() {
        return stack.peek().num;
    }
    
    public int getMin() {
        return stack.peek().min;
    }
    public class Node {
        int num, min;
        Node(int a, int b) {
            num = a; min = b;
        }
    }
}

**/




