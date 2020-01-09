package com.company.leetcode;
/**
 * 32 Longest Valid Parentheses
 */
public class leetcode32 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
    }    
}
/**
class Solution {
    public int maxNum, answer;
    public int longestValidParentheses(String s) {
        
        int len = s.length();        
        Stack<Integer> stack = new Stack<>();
        stack.add(-1);
        maxNum = 0; answer = 0;
        for(int i=0; i< len; i++)
        {
            int curIdx = i;
            if(stack.isEmpty()) {
                stack.add(curIdx);
            }
            else if(s.charAt(curIdx) == '(') {
                stack.add(curIdx);
            }
            else if(s.charAt(curIdx) == ')') { 
                int tmp = stack.peek();
                if(tmp != -1 && s.charAt(tmp) == '(') {
                    stack.pop();
                    tmp = stack.peek();
                    answer = max(answer, curIdx - tmp);
                }
                else stack.add(curIdx);
                    
            }
        }
       
        return answer;
    }
    public static int max(int a, int b) { return a > b ? a : b ;}
    
}
 */
