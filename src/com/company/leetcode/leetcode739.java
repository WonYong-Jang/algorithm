package com.company.leetcode;

public class leetcode739 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
    }
    
}
/**
class Solution {
    public int[] dailyTemperatures(int[] T) {
        
        int len = T.length;
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[len];
        
        for(int i= len - 1; i >= 0; i--)
        {
            while(!stack.isEmpty() && T[i] >= T[stack.peek()] ) stack.pop();
            
            ans[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            stack.add(i);
        }
        
        return ans;
    }
} 
 */
