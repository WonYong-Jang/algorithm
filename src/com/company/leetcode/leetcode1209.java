package com.company.leetcode;

public class leetcode1209 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
    }   
}
/**
class Solution {
    public String removeDuplicates(String s, int k) {
        
        return solve(s, k);
    }
    public String solve(String s, int k) {
        
        int len = s.length();
        StringBuilder sb = new StringBuilder(s);
        
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0; i< sb.length(); i++) {
            
            char ch = s.charAt(i);
            
            if(stack.isEmpty()) stack.add(1);
            else {
                if(i-1 < 0 || sb.charAt(i-1) != sb.charAt(i)) {
                    stack.add(1);
                }
                else {
                    int num = stack.pop() + 1;
                    if(num == k) {
                        sb.delete(i-k+1, i+1);
                        i = i-k;
                    }
                    else stack.add(num);
                }    
            }
        }
        
        return sb.toString();
    }
} 
 */
