package com.company.leetcode;

import java.util.Stack;

public class leetcode1190 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
    }
}
/**
class Solution {
    public String reverseParentheses(String s) {
        
        Stack<String> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        
        int len = s.length();
        String tmp = "";
        for(int i=0; i< len; i++) {
                
            char ch = s.charAt(i);
            
            if(ch == '(') {
                if(sb.length() > 0) {
                    stack.add(sb.toString());
                    sb = new StringBuilder();
                }
                stack.add("(");
            }
            else if(ch == ')') {
                
                if(!stack.isEmpty()) {
                    if(stack.peek().equals("(")) {
                        sb.reverse();
                        stack.pop();
                        
                        if(!stack.isEmpty() && !stack.peek().equals("(")) {
                            tmp = stack.pop();
                            sb.insert(0,tmp);    
                        }
                    }
                    else {
                        tmp = stack.pop();
                        sb.insert(0,tmp);
                    }
                }
                
                
            }
            else sb.append(ch);
        }
        return sb.toString();
    }
} 
 */
