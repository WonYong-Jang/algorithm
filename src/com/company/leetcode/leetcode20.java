package com.company.leetcode;

import java.util.Stack;

public class leetcode20 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Stack<Character> stack = new Stack<>();
        
    }
    
}
/**
class Solution {
    public boolean isValid(String s) {
        
        int len = s.length();
        
        boolean answer = true;
        Stack<Character> stack = new Stack<>();
        
        
        for(int i=0; i< len; i++)
        {
            char ch = s.charAt(i);
            
            if(stack.isEmpty()) stack.add(ch);
            else
            {
                char tmp = stack.peek();
                if(ch == '{' || ch == '[' || ch == '(')
                {
                    stack.add(ch);
                }
                else if(ch == '}' && tmp =='{') stack.pop();
                else if(ch == ')' && tmp =='(') stack.pop();
                else if(ch == ']' && tmp =='[') stack.pop();
                else break;
            }
        }
        
        if(stack.size() > 0) answer = false;
        return answer;
    }
}
 */
