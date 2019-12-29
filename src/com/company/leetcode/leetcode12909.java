package com.company.leetcode;

import java.util.Stack;

public class leetcode12909 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Stack<String> stack = new Stack<>();
        
    }
    
}



/**
import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        int len = s.length();
        Stack<Character> stack = new Stack<>();
        for(int i=0; i< len; i++)
        {
            char str = s.charAt(i);
            if(stack.isEmpty() || str == '(') stack.push(str);
            else if(str ==  ')') {
                char target = stack.peek();
                if(target == '(') stack.pop();
                else return false;
            }
            
        }
        
        if(!stack.isEmpty()) answer = false;
        return answer;
    }
}
 */
